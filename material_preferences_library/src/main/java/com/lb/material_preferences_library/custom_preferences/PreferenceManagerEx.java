package com.lb.material_preferences_library.custom_preferences;
import android.preference.PreferenceManager;

import java.lang.reflect.Method;

/**used to access some methods of original PreferenceManager*/
public class PreferenceManagerEx
  {
  private Method METHOD_UNREGISTER_ON_ACTIVITY_DESTROY_LISTENER;
  private Method METHOD_REGISTER_ON_ACTIVITY_DESTROY_LISTENER;
  private static final PreferenceManagerEx INSTANCE=new PreferenceManagerEx();

  private PreferenceManagerEx()
    {
    }

  public void unregisterOnActivityDestroyListener(PreferenceManager pm,PreferenceManager.OnActivityDestroyListener listener)
    {
    Method unregisterMethod=METHOD_UNREGISTER_ON_ACTIVITY_DESTROY_LISTENER;
    try
      {
      if(unregisterMethod==null)
        {
        //this is used to hook to the onActivityDestroy method, to avoid a window leak when config-changes while the dialog is shown
        unregisterMethod=pm.getClass().getDeclaredMethod("unregisterOnActivityDestroyListener",
                PreferenceManager.OnActivityDestroyListener.class);
        unregisterMethod.setAccessible(true);
        }
      unregisterMethod.invoke(pm,listener);
      }
    catch(Exception e)
      {
      e.printStackTrace();
//      unregisterMethod=null;
      }
    METHOD_UNREGISTER_ON_ACTIVITY_DESTROY_LISTENER=unregisterMethod;
    }

  public void registerOnActivityDestroyListener(PreferenceManager pm,PreferenceManager.OnActivityDestroyListener listener)
    {
    //
    Method registerMethod=METHOD_REGISTER_ON_ACTIVITY_DESTROY_LISTENER;
    try
      {
      if(registerMethod==null)
        {
        //this is used to hook to the onActivityDestroy method, to avoid a window leak when config-changes while the dialog is shown
        registerMethod=pm.getClass().getDeclaredMethod("registerOnActivityDestroyListener",
                PreferenceManager.OnActivityDestroyListener.class);
        registerMethod.setAccessible(true);
        }
      registerMethod.invoke(pm,listener);
      }
    catch(Exception e)
      {
      e.printStackTrace();
//      registerMethod=null;
      }
    METHOD_REGISTER_ON_ACTIVITY_DESTROY_LISTENER=registerMethod;
    }

  public static PreferenceManagerEx getInstance()
    {
    return INSTANCE;
    }

  }
