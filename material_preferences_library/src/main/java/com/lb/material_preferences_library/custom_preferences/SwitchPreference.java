package com.lb.material_preferences_library.custom_preferences;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;

import com.lb.material_preferences_library.R;

/**
 * A {@link Preference} that provides a two-state toggleable option.
 * <p/>
 * This preference will store a boolean into the SharedPreferences.
 *
 * @attr ref android.R.styleable#SwitchPreference_summaryOff
 * @attr ref android.R.styleable#SwitchPreference_summaryOn
 * @attr ref android.R.styleable#SwitchPreference_switchTextOff
 * @attr ref android.R.styleable#SwitchPreference_switchTextOn
 * @attr ref android.R.styleable#SwitchPreference_disableDependentsState
 */
public class SwitchPreference extends TwoStatePreference
  {
  private final Listener mListener=new Listener();

  // Switch text for on and off states
  private CharSequence mSwitchOn;
  private CharSequence mSwitchOff;

  private class Listener implements CompoundButton.OnCheckedChangeListener
    {
    @Override
    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
      {
      if(!callChangeListener(isChecked))
        {
// Listener didn't like it, change it back.
// CompoundButton will make sure we don't recurse.
        buttonView.setChecked(!isChecked);
        return;
        }

      SwitchPreference.this.setChecked(isChecked);
      }
    }

  /**
   * Construct a new SwitchPreference with the given style options.
   *
   * @param context      The Context that will style this preference
   * @param attrs        Style attributes that differ from the default
   * @param defStyleAttr An attribute in the current theme that contains a
   *                     reference to a style resource that supplies default values for
   *                     the view. Can be 0 to not look for defaults.
   * @param defStyleRes  A resource identifier of a style resource that
   *                     supplies default values for the view, used only if
   *                     defStyleAttr is 0 or can not be found in the theme. Can be 0
   *                     to not look for defaults.
   */
  public SwitchPreference(Context context,AttributeSet attrs,int defStyleAttr,int defStyleRes)
    {
    super(context,attrs,defStyleAttr,defStyleRes);
    }

  /**
   * Construct a new SwitchPreference with the given style options.
   *
   * @param context      The Context that will style this preference
   * @param attrs        Style attributes that differ from the default
   * @param defStyleAttr An attribute in the current theme that contains a
   *                     reference to a style resource that supplies default values for
   *                     the view. Can be 0 to not look for defaults.
   */
  public SwitchPreference(Context context,AttributeSet attrs,int defStyleAttr)
    {
    super(context,attrs,defStyleAttr);
    }

  /**
   * Construct a new SwitchPreference with the given style options.
   *
   * @param context The Context that will style this preference
   * @param attrs   Style attributes that differ from the default
   */
  public SwitchPreference(Context context,AttributeSet attrs)
    {
    this(context,attrs,R.attr.switchPreferenceStyle);
    }



  /**
   * Construct a new SwitchPreference with default style options.
   *
   * @param context The Context that will style this preference
   */
  public SwitchPreference(Context context)
    {
    this(context,null);
    }

  @Override
  protected void init(final Context context,final AttributeSet attrs,final int defStyleAttr,final int defStyleRes)
    {
    super.init(context,attrs,defStyleAttr,defStyleRes);
    this.setWidgetLayoutResource(R.layout.mpl__switch_preference);

    TypedArray a=context.obtainStyledAttributes(attrs,
            R.styleable.SwitchPreference,defStyleAttr,defStyleRes);
    setSummaryOn(a.getString(R.styleable.SwitchPreference_summaryOn));
    setSummaryOff(a.getString(R.styleable.SwitchPreference_summaryOff));
    setSwitchTextOn(a.getString(
            R.styleable.SwitchPreference_switchTextOn));
    setSwitchTextOff(a.getString(
            R.styleable.SwitchPreference_switchTextOff));
    setDisableDependentsState(a.getBoolean(
            R.styleable.SwitchPreference_disableDependentsState,false));
    a.recycle();
    }

  @Override
  protected void onBindView(View view)
    {
    super.onBindView(view);
    View checkableView=view.findViewById(android.R.id.checkbox);
    if(checkableView!=null&&checkableView instanceof Checkable)
      {
      if(checkableView instanceof SwitchCompat)
        {
        final SwitchCompat switchView=(SwitchCompat)checkableView;
        switchView.setOnCheckedChangeListener(null);
        }

      ((Checkable)checkableView).setChecked(mChecked);

      if(checkableView instanceof SwitchCompat)
        {
        final SwitchCompat switchView=(SwitchCompat)checkableView;
        switchView.setTextOn(mSwitchOn);
        switchView.setTextOff(mSwitchOff);
        switchView.setOnCheckedChangeListener(mListener);
        }
      }

    syncSummaryView(view);
    }

  /**
   * Set the text displayed on the switch widget in the on state.
   * This should be a very short string; one word if possible.
   *
   * @param onText Text to display in the on state
   */
  public void setSwitchTextOn(CharSequence onText)
    {
    mSwitchOn=onText;
    notifyChanged();
    }

  /**
   * Set the text displayed on the switch widget in the off state.
   * This should be a very short string; one word if possible.
   *
   * @param offText Text to display in the off state
   */
  public void setSwitchTextOff(CharSequence offText)
    {
    mSwitchOff=offText;
    notifyChanged();
    }

  /**
   * Set the text displayed on the switch widget in the on state.
   * This should be a very short string; one word if possible.
   *
   * @param resId The text as a string resource ID
   */
  public void setSwitchTextOn(int resId)
    {
    setSwitchTextOn(getContext().getString(resId));
    }

  /**
   * Set the text displayed on the switch widget in the off state.
   * This should be a very short string; one word if possible.
   *
   * @param resId The text as a string resource ID
   */
  public void setSwitchTextOff(int resId)
    {
    setSwitchTextOff(getContext().getString(resId));
    }

  /**
   * @return The text that will be displayed on the switch widget in the on state
   */
  public CharSequence getSwitchTextOn()
    {
    return mSwitchOn;
    }

  /**
   * @return The text that will be displayed on the switch widget in the off state
   */
  public CharSequence getSwitchTextOff()
    {
    return mSwitchOff;
    }
  }