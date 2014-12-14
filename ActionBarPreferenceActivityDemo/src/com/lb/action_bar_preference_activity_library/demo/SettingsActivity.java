package com.lb.action_bar_preference_activity_library.demo;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.lb.action_bar_preference_activity_library.ActionBarPreferenceActivity;

public class SettingsActivity extends ActionBarPreferenceActivity
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
    getMenuInflater().inflate(R.menu.activity_main,toolbar.getMenu());
    // I've added this for those who like to have the shadow below the actionbar
    setEnabledActionBarShadow(true);
    }

  @SuppressWarnings("deprecation")
  @Override
  public boolean onOptionsItemSelected(final MenuItem item)
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
        url="https://github.com/AndroidDeveloperLB/AndroidJniBitmapOperations";
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

  @Override
  protected int getPreferencesXmlId()
    {
    return R.xml.pref_general;
    }
  }
