package com.alertdialogpro.material;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/**
 * This class allows us to intercept calls so that we can tint resources (if applicable).
 */
class TintResources extends Resources
  {
  private final TintManager mTintManager;

  public TintResources(final Resources resources,final TintManager tintManager)
    {
    super(resources.getAssets(),resources.getDisplayMetrics(),resources.getConfiguration());
    mTintManager=tintManager;
    }

  @Override
  public Drawable getDrawable(final int id) throws NotFoundException
    {
    final Drawable d=super.getDrawable(id);
    if(d!=null)
      mTintManager.tintDrawable(id,d);
    return d;
    }
  }
