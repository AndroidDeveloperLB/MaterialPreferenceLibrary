package com.lb.material_stuff_library.demo;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.alertdialogpro.demo.R;
import com.lb.material_stuff_library.AlertDialogPro;

public class MainActivity extends ActionBarActivity implements View.OnClickListener
  {
  @Override
  protected void onCreate(final Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.showMaterialDialog).setOnClickListener(this);
    findViewById(R.id.showMaterialLightDialog).setOnClickListener(this);
    findViewById(R.id.showNativeDialog).setOnClickListener(this);
    findViewById(R.id.showLibraryDefaultDialog).setOnClickListener(this);
    }

  @Override
  public boolean onCreateOptionsMenu(final Menu menu)
    {
    getMenuInflater().inflate(R.menu.activity_main,menu);
    return super.onCreateOptionsMenu(menu);
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
      case R.id.action_settings:
        startActivity(new Intent(this,SettingsActivity.class));
        return true;
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
  public void onClick(final View v)
    {
    switch(v.getId())
      {
      case R.id.showMaterialDialog:
        showAlertDialog(new AlertDialogPro.Builder(this,R.style.AlertDialogProTheme_Material));
        break;
      case R.id.showMaterialLightDialog:
        showAlertDialog(new AlertDialogPro.Builder(this,R.style.AlertDialogProTheme_Material_Light));
        break;
      case R.id.showNativeDialog:
        showAlertDialog(new AlertDialog.Builder(this));
        break;
      case R.id.showLibraryDefaultDialog:
        showAlertDialog(new AlertDialogPro.Builder(this));
        break;
      }
    }

  private void showAlertDialog(final AlertDialog.Builder builder)
    {
    builder.setTitle(R.string.app_name).//
        setItems(new String[] {"item 1","item 2","item 3"},new DialogInterface.OnClickListener()//
              {
                @Override
                public void onClick(final DialogInterface dialog,final int which)
                  {
                  dialog.dismiss();
                  }
              }).//
        // setMessage("Message").
        // setMultiChoiceItems(new String[]{"A", "B", "C"},
        // new boolean[]{true, false, true},
        // new DialogInterface.OnMultiChoiceClickListener() {
        // @Override
        // public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        // }
        // }).
        setPositiveButton("OK",null).//
        setNegativeButton("Cancel",null).//
        show();
    }
  }
