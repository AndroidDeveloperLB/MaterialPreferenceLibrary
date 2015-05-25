package com.lb.material_preferences;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;

import com.lb.material_preferences_library.custom_preferences.ListPreference;
import com.lb.material_preferences_library.PreferenceActivity;

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
