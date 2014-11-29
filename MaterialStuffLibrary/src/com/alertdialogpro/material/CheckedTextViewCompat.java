package com.alertdialogpro.material;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.TextView;

/**
 * Compatible CheckedTextView for Pre-Lollipop devices. Draw checkMark on its left side.
 */
public class CheckedTextViewCompat extends TextView implements Checkable
  {
  private static final int[] CHECKED_TEXT_VIEW_ATTRS =new int[] {android.R.attr.checked,android.R.attr.checkMark};
  private boolean            mChecked;
  private int                mCheckMarkResource;
  private Drawable           mCheckMarkDrawable;
  private int                mBasePadding;
  private int                mCheckMarkWidth;
  private static final int[] CHECKED_STATE_SET       = {android.R.attr.state_checked};
  private final TintManager  mTintManager;

  public CheckedTextViewCompat(final Context context)
    {
    this(context,null);
    }

  public CheckedTextViewCompat(final Context context,final AttributeSet attrs)
    {
    this(context,attrs,0);
    }

  public CheckedTextViewCompat(final Context context,final AttributeSet attrs,final int defStyle)
    {
    super(context,attrs,defStyle);
    final TintTypedArray a=TintTypedArray.obtainStyledAttributes(context,attrs,CHECKED_TEXT_VIEW_ATTRS,defStyle,0);
    final boolean checked=a.getBoolean(0,false);
    setChecked(checked);
    final Drawable d=a.getDrawable(1);
    if(d!=null)
      setCheckMarkDrawable(d);
    a.recycle();
    mTintManager=a.getTintManager();
    }

  @Override
  public void toggle()
    {
    setChecked(!mChecked);
    }

  @Override
  public boolean isChecked()
    {
    return mChecked;
    }

  /**
   * <p>
   * Changes the checked state of this text view.
   * </p>
   *
   * @param checked true to check the text, false to uncheck it
   */
  @Override
  public void setChecked(final boolean checked)
    {
    if(mChecked!=checked)
      {
      mChecked=checked;
      refreshDrawableState();
      }
    }

  /**
   * Set the checkmark to a given Drawable, identified by its resourece id. This will be drawn
   * when {@link #isChecked()} is true.
   *
   * @param resid The Drawable to use for the checkmark.
   */
  public void setCheckMarkDrawable(final int resid)
    {
    if(resid!=0&&resid==mCheckMarkResource)
      return;
    mCheckMarkResource=resid;
    setCheckMarkDrawable(mTintManager.getDrawable(resid));
    }

  /**
   * Set the checkmark to a given Drawable. This will be drawn when {@link #isChecked()} is true.
   *
   * @param d The Drawable to use for the checkmark.
   */
  public void setCheckMarkDrawable(final Drawable d)
    {
    if(mCheckMarkDrawable!=null)
      {
      mCheckMarkDrawable.setCallback(null);
      unscheduleDrawable(mCheckMarkDrawable);
      }
    if(d!=null)
      {
      d.setCallback(this);
      d.setVisible(getVisibility()==VISIBLE,false);
      d.setState(CHECKED_STATE_SET);
      setMinHeight(d.getIntrinsicHeight());
      mCheckMarkWidth=d.getIntrinsicWidth();
      mBasePadding=getPaddingLeft();
      super.setPadding(mCheckMarkWidth+mBasePadding,getPaddingTop(),getPaddingRight(),getPaddingBottom());
      d.setState(getDrawableState());
      }
    mCheckMarkDrawable=d;
    requestLayout();
    }

  @Override
  public void setVisibility(final int visibility)
    {
    super.setVisibility(visibility);
    if(mCheckMarkDrawable!=null)
      mCheckMarkDrawable.setVisible(visibility==VISIBLE,false);
    }

  @TargetApi(Build.VERSION_CODES.HONEYCOMB)
  @Override
  public void jumpDrawablesToCurrentState()
    {
    super.jumpDrawablesToCurrentState();
    if(mCheckMarkDrawable!=null)
      mCheckMarkDrawable.jumpToCurrentState();
    }

  @Override
  protected boolean verifyDrawable(final Drawable who)
    {
    return who==mCheckMarkDrawable||super.verifyDrawable(who);
    }

  /**
   * Gets the checkmark drawable
   *
   * @return The drawable use to represent the checkmark, if any.
   * @see #setCheckMarkDrawable(Drawable)
   * @see #setCheckMarkDrawable(int)
   * @attr ref android.R.styleable#CheckedTextView_checkMark
   */
  public Drawable getCheckMarkDrawable()
    {
    return mCheckMarkDrawable;
    }

  @Override
  public void setPadding(final int left,final int top,final int right,final int bottom)
    {
    super.setPadding(left,top,right,bottom);
    mBasePadding=getPaddingLeft();
    }

  @Override
  protected void onDraw(final Canvas canvas)
    {
    super.onDraw(canvas);
    final Drawable checkMarkDrawable=mCheckMarkDrawable;
    if(checkMarkDrawable!=null)
      {
      final int verticalGravity=getGravity()&Gravity.VERTICAL_GRAVITY_MASK;
      final int height=checkMarkDrawable.getIntrinsicHeight();
      int y=0;
      switch(verticalGravity)
        {
        case Gravity.BOTTOM:
          y=getHeight()-height;
          break;
        case Gravity.CENTER_VERTICAL:
          y=(getHeight()-height)/2;
          break;
        }
      checkMarkDrawable.setBounds(mBasePadding,y,mBasePadding+mCheckMarkWidth,y+height);
      checkMarkDrawable.draw(canvas);
      }
    }

  @Override
  protected int[] onCreateDrawableState(final int extraSpace)
    {
    final int[] drawableState=super.onCreateDrawableState(extraSpace+1);
    if(isChecked())
      mergeDrawableStates(drawableState,CHECKED_STATE_SET);
    return drawableState;
    }

  @Override
  protected void drawableStateChanged()
    {
    super.drawableStateChanged();
    if(mCheckMarkDrawable!=null)
      {
      final int[] myDrawableState=getDrawableState();
      // Set the state of the Drawable
      mCheckMarkDrawable.setState(myDrawableState);
      invalidate();
      }
    }

  @Override
  public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent event)
    {
    final boolean populated=super.dispatchPopulateAccessibilityEvent(event);
    if(!populated)
      event.setChecked(mChecked);
    return populated;
    }
  }
