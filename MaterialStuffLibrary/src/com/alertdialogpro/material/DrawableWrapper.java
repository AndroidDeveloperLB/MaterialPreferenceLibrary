package com.alertdialogpro.material;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;

/**
 * Base wrapper that delegates all calls to another {@link Drawable}. The wrapped {@link Drawable} <em>must</em> be fully released from any {@link View} before wrapping, otherwise internal {@link Drawable.Callback} may be dropped.
 */
class DrawableWrapper extends Drawable implements Drawable.Callback
  {
  private final Drawable mDrawable;

  public DrawableWrapper(final Drawable drawable)
    {
    mDrawable=drawable;
    mDrawable.setCallback(this);
    }

  @Override
  public void draw(final Canvas canvas)
    {
    mDrawable.draw(canvas);
    }

  @Override
  public void setBounds(final int left,final int top,final int right,final int bottom)
    {
    super.setBounds(left,top,right,bottom);
    mDrawable.setBounds(left,top,right,bottom);
    }

  @Override
  public void setChangingConfigurations(final int configs)
    {
    mDrawable.setChangingConfigurations(configs);
    }

  @Override
  public int getChangingConfigurations()
    {
    return mDrawable.getChangingConfigurations();
    }

  @Override
  public void setDither(final boolean dither)
    {
    mDrawable.setDither(dither);
    }

  @Override
  public void setFilterBitmap(final boolean filter)
    {
    mDrawable.setFilterBitmap(filter);
    }

  @Override
  public void setAlpha(final int alpha)
    {
    mDrawable.setAlpha(alpha);
    }

  @Override
  public void setColorFilter(final ColorFilter cf)
    {
    mDrawable.setColorFilter(cf);
    }

  @Override
  public boolean isStateful()
    {
    return mDrawable.isStateful();
    }

  @Override
  public boolean setState(final int[] stateSet)
    {
    return mDrawable.setState(stateSet);
    }

  @Override
  public int[] getState()
    {
    return mDrawable.getState();
    }

  @Override
  public void jumpToCurrentState()
    {
    DrawableCompat.jumpToCurrentState(mDrawable);
    }

  @Override
  public Drawable getCurrent()
    {
    return mDrawable.getCurrent();
    }

  @Override
  public boolean setVisible(final boolean visible,final boolean restart)
    {
    return super.setVisible(visible,restart)||mDrawable.setVisible(visible,restart);
    }

  @Override
  public int getOpacity()
    {
    return mDrawable.getOpacity();
    }

  @Override
  public Region getTransparentRegion()
    {
    return mDrawable.getTransparentRegion();
    }

  @Override
  public int getIntrinsicWidth()
    {
    return mDrawable.getIntrinsicWidth();
    }

  @Override
  public int getIntrinsicHeight()
    {
    return mDrawable.getIntrinsicHeight();
    }

  @Override
  public int getMinimumWidth()
    {
    return mDrawable.getMinimumWidth();
    }

  @Override
  public int getMinimumHeight()
    {
    return mDrawable.getMinimumHeight();
    }

  @Override
  public boolean getPadding(final Rect padding)
    {
    return mDrawable.getPadding(padding);
    }

  /**
   * {@inheritDoc}
   */
  @Override
  public void invalidateDrawable(final Drawable who)
    {
    invalidateSelf();
    }

  /**
   * {@inheritDoc}
   */
  @Override
  public void scheduleDrawable(final Drawable who,final Runnable what,final long when)
    {
    scheduleSelf(what,when);
    }

  /**
   * {@inheritDoc}
   */
  @Override
  public void unscheduleDrawable(final Drawable who,final Runnable what)
    {
    unscheduleSelf(what);
    }

  @Override
  protected boolean onLevelChange(final int level)
    {
    return mDrawable.setLevel(level);
    }

  @Override
  public void setAutoMirrored(final boolean mirrored)
    {
    DrawableCompat.setAutoMirrored(mDrawable,mirrored);
    }

  @Override
  public boolean isAutoMirrored()
    {
    return DrawableCompat.isAutoMirrored(mDrawable);
    }

  @Override
  public void setTint(final int tint)
    {
    DrawableCompat.setTint(mDrawable,tint);
    }

  @Override
  public void setTintList(final ColorStateList tint)
    {
    DrawableCompat.setTintList(mDrawable,tint);
    }

  @Override
  public void setTintMode(final PorterDuff.Mode tintMode)
    {
    DrawableCompat.setTintMode(mDrawable,tintMode);
    }

  @Override
  public void setHotspot(final float x,final float y)
    {
    DrawableCompat.setHotspot(mDrawable,x,y);
    }

  @Override
  public void setHotspotBounds(final int left,final int top,final int right,final int bottom)
    {
    DrawableCompat.setHotspotBounds(mDrawable,left,top,right,bottom);
    }
  }
