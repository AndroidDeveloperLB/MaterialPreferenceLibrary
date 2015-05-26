package com.lb.material_preferences;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;

import com.lb.material_preferences_library.PreferenceActivity;
import com.lb.material_preferences_library.custom_preferences.ListPreference;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends PreferenceActivity
  {

  @Override
  protected void onCreate(final Bundle savedInstanceState)
    {
    final String themePrefKey=getString(R.string.pref_theme), defaultTheme=getResources().getString(R.string.pref_theme_default);
    final String theme=PreferenceManager.getDefaultSharedPreferences(this).getString(themePrefKey,defaultTheme);
    switch(theme)
      {
      case "dark":
        setTheme(R.style.AppTheme_Dark);
        break;
      case "light":
        setTheme(R.style.AppTheme_Light);
        break;
      }
    super.onCreate(savedInstanceState);
    ListPreference themeListPreference=(ListPreference)findPreference(getString(R.string.pref_theme));
    themeListPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener()
    {
    @Override
    public boolean onPreferenceChange(final Preference preference,final Object newValue)
      {
      restartActivity(SettingsActivity.this);
      return true;
      }
    });
    handleActionBarMenu();

    }

  private void handleActionBarMenu()
    {
    getToolbar().inflateMenu(R.menu.activity_main);
    final OnMenuItemClickListener onMenuItemClickListener=new OnMenuItemClickListener()
    {
    @Override
    public boolean onMenuItemClick(final MenuItem item)
      {
      String url=null;
      switch(item.getItemId())
        {
        case R.id.menuItem_all_my_apps:
          url="https://play.google.com/store/apps/developer?id=AndroidDeveloperLB";
          break;
        case R.id.menuItem_all_my_repositories:
          url="https://github.com/AndroidDeveloperLB";
          break;
        case R.id.menuItem_current_repository_website:
          url="https://github.com/AndroidDeveloperLB/MaterialPreferenceLibrary";
          break;
        }
      if(url==null)
        return true;
      final Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(url));
      intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
      startActivity(intent);
      return true;
      }
    };
    setOnMenuItemClickListenerRecursive(getToolbar().getMenu(),onMenuItemClickListener);
    }

  private static void setOnMenuItemClickListenerRecursive(Menu menu,OnMenuItemClickListener listener)
    {
    List<Menu> menus=new ArrayList<>(1);
    menus.add(menu);
    while(!menus.isEmpty())
      {
      final Menu currentMenu=menus.remove(0);
      for(int i=0;i<currentMenu.size();++i)
        {
        final MenuItem item=currentMenu.getItem(i);
        item.setOnMenuItemClickListener(listener);
        final SubMenu subMenu=item.getSubMenu();
        if(subMenu!=null)
          menus.add(subMenu);
        }
      }
    }

  @Override
  protected int getPreferencesXmlId()
    {
    return R.xml.settings_example;
    }

  @TargetApi(Build.VERSION_CODES.HONEYCOMB)
  public static void restartActivity(final Activity activity)
    {
    if(android.os.Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB)
      activity.recreate();
    else
      {
      new Handler().post(new Runnable()
      {
      @Override
      public void run()
        {
        activity.overridePendingTransition(0,0);
        activity.startActivity(activity.getIntent());
        }
      });
      activity.finish();
      }
    }
  }
