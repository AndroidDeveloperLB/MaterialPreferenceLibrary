/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lb.material_preferences_library.custom_preferences;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;

import com.lb.material_preferences_library.R;

/**
 * A {@link android.preference.Preference} that provides checkbox widget
 * functionality.
 * <p/>
 * This preference will store a boolean into the SharedPreferences.
 *
 * @attr ref android.R.styleable#CheckBoxPreference_summaryOff
 * @attr ref android.R.styleable#CheckBoxPreference_summaryOn
 * @attr ref android.R.styleable#CheckBoxPreference_disableDependentsState
 */
public class CheckBoxPreference extends TwoStatePreference
  {

  public CheckBoxPreference(Context context,AttributeSet attrs,int defStyleAttr)
    {
    super(context,attrs,defStyleAttr);
    }

  public CheckBoxPreference(Context context,AttributeSet attrs,int defStyleAttr,int defStyleRes)
    {
    super(context,attrs,defStyleAttr,defStyleRes);
    }

  @Override
  protected void init(final Context context,final AttributeSet attrs,final int defStyleAttr,final int defStyleRes)
    {
    super.init(context,attrs,defStyleAttr,defStyleRes);
    setWidgetLayoutResource(R.layout.mpl__preference_widget_checkbox);
    final TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.CheckBoxPreference,defStyleAttr,defStyleRes);
    setSummaryOn(a.getString(R.styleable.CheckBoxPreference_summaryOn));
    setSummaryOff(a.getString(R.styleable.CheckBoxPreference_summaryOff));
    setDisableDependentsState(a.getBoolean(R.styleable.CheckBoxPreference_disableDependentsState,false));
    a.recycle();
    }

  public CheckBoxPreference(Context context,AttributeSet attrs)
    {
    this(context,attrs,R.attr.checkBoxPreferenceStyle);
    }

  public CheckBoxPreference(Context context)
    {
    this(context,null);
    }

  @Override
  protected void onBindView(View view)
    {
    super.onBindView(view);
    View checkboxView=view.findViewById(android.R.id.checkbox);
    if(checkboxView!=null&&checkboxView instanceof Checkable)
      ((Checkable)checkboxView).setChecked(mChecked);
    syncSummaryView(view);
    }
  }
