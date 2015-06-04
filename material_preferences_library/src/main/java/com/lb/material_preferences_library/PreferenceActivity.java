package com.lb.material_preferences_library;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.support.annotation.XmlRes;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public abstract class PreferenceActivity extends AppCompatPreferenceActivity
  {
  private Toolbar _toolbar;

  /** this should return the R.xml.menu file of the preferenceActivity */
  protected abstract
  @XmlRes
  int getPreferencesXmlId();

  public Toolbar getToolbar()
    {
    return _toolbar;
    }

  @SuppressWarnings("deprecation")
  @Override
  protected void onCreate(final Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mpl__preference_activity);
    _toolbar=(Toolbar)findViewById(R.id.abp__toolbar);
    if(VERSION.SDK_INT>=VERSION_CODES.LOLLIPOP)
      {
      View shadowView=findViewById(R.id.abp__shadowView);
      final ViewGroup parent=(ViewGroup)shadowView.getParent();
      parent.removeView(shadowView);
      }
    addPreferencesFromResource(getPreferencesXmlId());
    final Map<Preference,PreferenceGroup> preferenceToParentMap=buildPreferenceParentTree(this);
    for(PreferenceGroup preferenceGroup : preferenceToParentMap.values())
      if(preferenceGroup!=null&&preferenceGroup instanceof PreferenceScreen)
        preferenceGroup.setLayoutResource(R.layout.mpl__preference);
    _toolbar.setClickable(true);
    _toolbar.setNavigationIcon(getResIdFromAttribute(this,R.attr.homeAsUpIndicator));
    _toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
    @Override
    public void onClick(final View v)
      {
      finish();
      }
    });
    _toolbar.setTitle(getTitle());
    }

  private static int getResIdFromAttribute(final Activity activity,final int attr)
    {
    if(attr==0)
      return 0;
    final TypedValue typedValue=new TypedValue();
    activity.getTheme().resolveAttribute(attr,typedValue,true);
    return typedValue.resourceId;
    }

  @SuppressWarnings("deprecation")
  public static Map<Preference,PreferenceGroup> buildPreferenceParentTree(final android.preference.PreferenceActivity activity)
    {
    final Map<Preference,PreferenceGroup> result=new HashMap<>();
    final Stack<PreferenceGroup> curParents=new Stack<>();
    curParents.add(activity.getPreferenceScreen());
    while(!curParents.isEmpty())
      {
      final PreferenceGroup parent=curParents.pop();
      final int childCount=parent.getPreferenceCount();
      for(int i=0;i<childCount;++i)
        {
        final Preference child=parent.getPreference(i);
        result.put(child,parent);
        if(child instanceof PreferenceGroup)
          curParents.push((PreferenceGroup)child);
        }
      }
    return result;
    }

  }
