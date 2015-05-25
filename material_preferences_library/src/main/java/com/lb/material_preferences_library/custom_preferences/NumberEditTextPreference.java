package com.lb.material_preferences_library.custom_preferences;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class NumberEditTextPreference extends EditTextPreference
  {
  public NumberEditTextPreference(final Context context)
    {
    super(context);
    }

  public NumberEditTextPreference(final Context context,final AttributeSet attrs)
    {
    super(context,attrs);
    }

  public NumberEditTextPreference(final Context context,final AttributeSet attrs,final int defStyle)
    {
    super(context,attrs,defStyle);
    }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
  @Override
  protected View onCreateView(final ViewGroup parent)
    {
    final View view=super.onCreateView(parent);
    return view;
    }

  @Override
  protected void onAddEditTextToDialogView(final View dialogView,final EditText editText)
    {
    super.onAddEditTextToDialogView(dialogView,editText);
    editText.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL);
    editText.setSelectAllOnFocus(true);
    }
  }
