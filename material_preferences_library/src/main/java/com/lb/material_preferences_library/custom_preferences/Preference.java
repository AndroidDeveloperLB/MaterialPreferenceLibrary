package com.lb.material_preferences_library.custom_preferences;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION_CODES;
import android.util.AttributeSet;

import com.lb.material_preferences_library.R;

public class Preference extends android.preference.Preference
  {
  private boolean _isInitialized=false;

  protected void init(final Context context,final AttributeSet attrs,final int defStyleAttr,final int defStyleRes)
    {
    setLayoutResource(R.layout.mpl__preference);
    }

  @TargetApi(VERSION_CODES.LOLLIPOP)
  public Preference(final Context context,final AttributeSet attrs,final int defStyleAttr,final int defStyleRes)
    {
    super(context,attrs,defStyleAttr,defStyleRes);
    if(!_isInitialized)
      {
      _isInitialized=true;
      init(context,attrs,defStyleAttr,defStyleRes);
      }
    }

  public Preference(Context context,AttributeSet attrs,int defStyleAttr)
    {
    super(context,attrs,defStyleAttr);
    if(!_isInitialized)
      {
      _isInitialized=true;
      init(context,attrs,defStyleAttr,0);
      }
    }

  public Preference(Context context,AttributeSet attrs)
    {
    super(context,attrs);
    }

  public Preference(Context context)
    {
    super(context);
    }

  }
