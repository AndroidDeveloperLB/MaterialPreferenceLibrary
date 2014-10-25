package com.lb.material_stuff_library.demo;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.alertdialogpro.demo.R;
import com.lb.material_stuff_library.MaterialPreferenceActivity;

public class SettingsActivity extends MaterialPreferenceActivity
  {
  @SuppressWarnings("deprecation")
  @Override
  protected void onCreate(final Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.pref_general);
    // NOTE: do not use ActionBar in any way. Instead, use only the toolbar , as such:
    final Toolbar toolbar=getToolbar();
    toolbar.setTitle("Settings");
    // I've added this for those who like to have the shadow below the actionbar
    setEnabledActionBarShadow(true);
    }

  @Override
  protected int getPreferencesXmlId()
    {
    return R.xml.pref_general;
    }
  }
