package com.alertdialogpro.material;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 * A class that wraps a {@link android.content.res.TypedArray} and provides the same public API
 * surface. The purpose of this class is so that we can intercept the {@link #getDrawable(int)} call and tint the result.
 */
public class TintTypedArray
  {
  private final Context    mContext;
  private final TypedArray mWrapped;
  private TintManager      mTintManager;

  public static TintTypedArray obtainStyledAttributes(final Context context,final AttributeSet set,final int[] attrs)
    {
    final TypedArray array=context.obtainStyledAttributes(set,attrs);
    return new TintTypedArray(context,array);
    }

  public static TintTypedArray obtainStyledAttributes(final Context context,final AttributeSet set,final int[] attrs,final int defStyleAttr,final int defStyleRes)
    {
    final TypedArray array=context.obtainStyledAttributes(set,attrs,defStyleAttr,defStyleRes);
    return new TintTypedArray(context,array);
    }

  private TintTypedArray(final Context context,final TypedArray array)
    {
    mContext=context;
    mWrapped=array;
    }

  public Drawable getDrawable(final int index)
    {
    if(mWrapped.hasValue(index))
      {
      final int resourceId=mWrapped.getResourceId(index,0);
      if(resourceId!=0)
        return getTintManager().getDrawable(resourceId);
      }
    return mWrapped.getDrawable(index);
    }

  public int length()
    {
    return mWrapped.length();
    }

  public int getIndexCount()
    {
    return mWrapped.getIndexCount();
    }

  public int getIndex(final int at)
    {
    return mWrapped.getIndex(at);
    }

  public Resources getResources()
    {
    return mWrapped.getResources();
    }

  public CharSequence getText(final int index)
    {
    return mWrapped.getText(index);
    }

  public String getString(final int index)
    {
    return mWrapped.getString(index);
    }

  public String getNonResourceString(final int index)
    {
    return mWrapped.getNonResourceString(index);
    }

  public boolean getBoolean(final int index,final boolean defValue)
    {
    return mWrapped.getBoolean(index,defValue);
    }

  public int getInt(final int index,final int defValue)
    {
    return mWrapped.getInt(index,defValue);
    }

  public float getFloat(final int index,final float defValue)
    {
    return mWrapped.getFloat(index,defValue);
    }

  public int getColor(final int index,final int defValue)
    {
    return mWrapped.getColor(index,defValue);
    }

  public ColorStateList getColorStateList(final int index)
    {
    return mWrapped.getColorStateList(index);
    }

  public int getInteger(final int index,final int defValue)
    {
    return mWrapped.getInteger(index,defValue);
    }

  public float getDimension(final int index,final float defValue)
    {
    return mWrapped.getDimension(index,defValue);
    }

  public int getDimensionPixelOffset(final int index,final int defValue)
    {
    return mWrapped.getDimensionPixelOffset(index,defValue);
    }

  public int getDimensionPixelSize(final int index,final int defValue)
    {
    return mWrapped.getDimensionPixelSize(index,defValue);
    }

  public int getLayoutDimension(final int index,final String name)
    {
    return mWrapped.getLayoutDimension(index,name);
    }

  public int getLayoutDimension(final int index,final int defValue)
    {
    return mWrapped.getLayoutDimension(index,defValue);
    }

  public float getFraction(final int index,final int base,final int pbase,final float defValue)
    {
    return mWrapped.getFraction(index,base,pbase,defValue);
    }

  public int getResourceId(final int index,final int defValue)
    {
    return mWrapped.getResourceId(index,defValue);
    }

  public CharSequence[] getTextArray(final int index)
    {
    return mWrapped.getTextArray(index);
    }

  public boolean getValue(final int index,final TypedValue outValue)
    {
    return mWrapped.getValue(index,outValue);
    }

  public boolean hasValue(final int index)
    {
    return mWrapped.hasValue(index);
    }

  public TypedValue peekValue(final int index)
    {
    return mWrapped.peekValue(index);
    }

  public String getPositionDescription()
    {
    return mWrapped.getPositionDescription();
    }

  public void recycle()
    {
    mWrapped.recycle();
    }

  public TintManager getTintManager()
    {
    if(mTintManager==null)
      mTintManager=new TintManager(mContext);
    return mTintManager;
    }
  }
