package com.lb.material_preferences_library.custom_preferences;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION_CODES;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lb.material_preferences_library.R;

public class Preference extends android.preference.Preference
  {
  private boolean _isInitialized=false;
  private int _iconResId;
  private Drawable _icon;

  protected void init(final Context context,final AttributeSet attrs,final int defStyleAttr,final int defStyleRes)
    {
    setLayoutResource(R.layout.mpl__preference);
    final TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.Preference,defStyleAttr,defStyleRes);
    _iconResId=a.getResourceId(R.styleable.Preference_icon,0);
    a.recycle();
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

  /**
   * Sets the icon for this Preference with a Drawable.
   * This icon will be placed into the ID
   * {@link android.R.id#icon} within the View created by
   * {@link #onCreateView(ViewGroup)}.
   *
   * @param icon The optional icon for this Preference.
   */
  public void setIcon(Drawable icon)
    {
    if((icon==null&&_icon!=null)||(icon!=null&&_icon!=icon))
      {
      _icon=icon;
      notifyChanged();
      }
    }

  /**
   * Sets the icon for this Preference with a resource ID.
   *
   * @param iconResId The icon as a resource ID.
   * @see #setIcon(Drawable)
   */
  public void setIconCompat(@DrawableRes int iconResId)
    {
    if(_iconResId!=iconResId)
      {
      _iconResId=iconResId;
      setIcon(ContextCompat.getDrawable(getContext(),iconResId));
      }
    }

  /**
   * Returns the icon of this Preference.
   *
   * @return The icon.
   * @see #setIcon(Drawable)
   */
  public Drawable getIconCompat()
    {
    return _icon;
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
    if(!_isInitialized)
      {
      _isInitialized=true;
      init(context,attrs,0,0);
      }
    }

  public Preference(Context context)
    {
    super(context);
    if(!_isInitialized)
      {
      _isInitialized=true;
      init(context,null,0,0);
      }
    }

  @Override
  protected void onBindView(final View view)
    {
    super.onBindView(view);
    final ImageView imageView=(ImageView)view.findViewById(R.id.icon);
    if(imageView!=null)
      {
      if(_iconResId!=0||_icon!=null)
        {
        if(_icon==null)
          _icon=ContextCompat.getDrawable(getContext(),_iconResId);
        if(_icon!=null)
          imageView.setImageDrawable(_icon);
        }
      imageView.setVisibility(_icon!=null?View.VISIBLE:View.GONE);
      }

    final View imageFrame=view.findViewById(R.id.icon_frame);
    if(imageFrame!=null)
      {
      imageFrame.setVisibility(_icon!=null?View.VISIBLE:View.GONE);
      }
    }
  }
