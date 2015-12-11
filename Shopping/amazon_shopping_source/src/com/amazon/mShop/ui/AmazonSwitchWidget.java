// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CompoundButton;

public class AmazonSwitchWidget extends CompoundButton
{

    private static final int CHECKED_STATE_SET[] = {
        0x10100a0
    };
    private final int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private final int mSwitchMaxWidth;
    private final int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private final TextPaint mTextPaint;
    private final Drawable mThumbDrawable;
    private final int mThumbMargin;
    private float mThumbPosition;
    private final int mThumbTextPadding;
    private int mThumbWidth;
    private int mTouchMode;
    private final int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private final Drawable mTrackDrawable;
    private final VelocityTracker mVelocityTracker;
    private final int mVelocityUnit;

    public AmazonSwitchWidget(Context context)
    {
        this(context, null);
    }

    public AmazonSwitchWidget(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, com.amazon.mShop.android.lib.R.attr.AmazonSwitchStyle);
    }

    public AmazonSwitchWidget(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mVelocityTracker = VelocityTracker.obtain();
        mVelocityUnit = 1000;
        mTempRect = new Rect();
        mTextPaint = new TextPaint(1);
        Resources resources = getResources();
        mTextPaint.density = resources.getDisplayMetrics().density;
        attributeset = context.obtainStyledAttributes(attributeset, com.amazon.mShop.android.lib.R.styleable.AmazonSwitch, i, 0);
        mThumbDrawable = attributeset.getDrawable(0);
        mTrackDrawable = attributeset.getDrawable(1);
        mTextOn = attributeset.getText(2);
        mTextOff = attributeset.getText(3);
        mThumbTextPadding = attributeset.getDimensionPixelSize(4, 0);
        mSwitchMaxWidth = attributeset.getDimensionPixelSize(6, 0);
        mSwitchPadding = attributeset.getDimensionPixelSize(7, 0);
        mThumbMargin = context.getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.switch_thumb_margin);
        i = attributeset.getResourceId(5, 0);
        if (i != 0)
        {
            setSwitchTextAppearance(context, i);
        }
        attributeset.recycle();
        context = ViewConfiguration.get(context);
        mTouchSlop = context.getScaledTouchSlop();
        mMinFlingVelocity = context.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void animateThumbToCheckedState(boolean flag)
    {
        setChecked(flag);
    }

    private void cancelSuperTouch(MotionEvent motionevent)
    {
        motionevent = MotionEvent.obtain(motionevent);
        motionevent.setAction(3);
        super.onTouchEvent(motionevent);
        motionevent.recycle();
    }

    private boolean getTargetCheckedState()
    {
        return mThumbPosition >= (float)(getThumbScrollRange() / 2);
    }

    private int getThumbScrollRange()
    {
        if (mTrackDrawable == null)
        {
            return 0;
        } else
        {
            mTrackDrawable.getPadding(mTempRect);
            return mSwitchWidth - mThumbWidth - mTempRect.left - mTempRect.right;
        }
    }

    private boolean hitThumb(float f, float f1)
    {
        mThumbDrawable.getPadding(mTempRect);
        int i = mSwitchTop;
        int j = mTouchSlop;
        int k = (mSwitchLeft + (int)(mThumbPosition + 0.5F)) - mTouchSlop;
        int l = mThumbWidth;
        int i1 = mTempRect.left;
        int j1 = mTempRect.right;
        int k1 = mTouchSlop;
        int l1 = mSwitchBottom;
        int i2 = mTouchSlop;
        return f > (float)k && f < (float)(l + k + i1 + j1 + k1) && f1 > (float)(i - j) && f1 < (float)(l1 + i2);
    }

    private Layout makeLayout(CharSequence charsequence)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(charsequence);
        if (charsequence == null || mTextOn == null || !charsequence.equals(mTextOn)) goto _L2; else goto _L1
_L1:
        spannablestringbuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(com.amazon.mShop.android.lib.R.color.white)), 0, mTextOn.length(), 33);
_L4:
        return new StaticLayout(spannablestringbuilder, mTextPaint, (int)Math.ceil(Layout.getDesiredWidth(spannablestringbuilder, mTextPaint)), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
_L2:
        if (charsequence != null && mTextOff != null && charsequence.equals(mTextOff))
        {
            spannablestringbuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(com.amazon.mShop.android.lib.R.color.dark_gray)), 0, mTextOff.length(), 33);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setSwitchTypefaceByIndex(int i, int j)
    {
        Typeface typeface = null;
        i;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 35
    //                   2 42
    //                   3 49;
           goto _L1 _L2 _L3 _L4
_L1:
        setSwitchTypeface(typeface, j);
        return;
_L2:
        typeface = Typeface.SANS_SERIF;
        continue; /* Loop/switch isn't completed */
_L3:
        typeface = Typeface.SERIF;
        continue; /* Loop/switch isn't completed */
_L4:
        typeface = Typeface.MONOSPACE;
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void stopDrag(MotionEvent motionevent)
    {
        mTouchMode = 0;
        boolean flag;
        if (motionevent.getAction() == 1 && isEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cancelSuperTouch(motionevent);
        if (flag)
        {
            mVelocityTracker.computeCurrentVelocity(1000);
            float f = mVelocityTracker.getXVelocity();
            boolean flag1;
            if (Math.abs(f) > (float)mMinFlingVelocity)
            {
                if (f > 0.0F)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } else
            {
                flag1 = getTargetCheckedState();
            }
            animateThumbToCheckedState(flag1);
            return;
        } else
        {
            animateThumbToCheckedState(isChecked());
            return;
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        int ai[] = getDrawableState();
        if (mThumbDrawable != null)
        {
            mThumbDrawable.setState(ai);
        }
        if (mTrackDrawable != null)
        {
            mTrackDrawable.setState(ai);
        }
        invalidate();
    }

    public int getCompoundPaddingRight()
    {
        int j = super.getCompoundPaddingRight() + mSwitchWidth;
        int i = j;
        if (!TextUtils.isEmpty(getText()))
        {
            i = j + mSwitchPadding;
        }
        return i;
    }

    public CharSequence getTextOff()
    {
        return mTextOff;
    }

    public CharSequence getTextOn()
    {
        return mTextOn;
    }

    protected int[] onCreateDrawableState(int i)
    {
        int ai[] = super.onCreateDrawableState(i + 1);
        if (isChecked())
        {
            mergeDrawableStates(ai, CHECKED_STATE_SET);
        }
        return ai;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int k = mSwitchLeft;
        int i = mSwitchTop;
        int j1 = mSwitchRight;
        int j = mSwitchBottom;
        mTrackDrawable.setBounds(k, i, j1, j);
        mTrackDrawable.draw(canvas);
        canvas.save();
        mTrackDrawable.getPadding(mTempRect);
        int i1 = k + mTempRect.left;
        k = mTempRect.top;
        int k1 = mTempRect.right;
        int l = mTempRect.bottom;
        canvas.clipRect(i1, i, j1 - k1, j);
        mThumbDrawable.getPadding(mTempRect);
        k1 = (int)(mThumbPosition + 0.5F);
        j1 = (i1 - mTempRect.left) + k1;
        i1 = i1 + k1 + mThumbWidth + mTempRect.right;
        mThumbDrawable.setBounds(mThumbMargin + j1, i, i1 - mThumbMargin, j);
        mThumbDrawable.draw(canvas);
        if (mTextColors != null)
        {
            mTextPaint.setColor(mTextColors.getColorForState(getDrawableState(), mTextColors.getDefaultColor()));
        }
        mTextPaint.drawableState = getDrawableState();
        Layout layout;
        if (getTargetCheckedState())
        {
            layout = mOnLayout;
        } else
        {
            layout = mOffLayout;
        }
        canvas.translate((j1 + i1) / 2 - layout.getWidth() / 2, (i + k + (j - l)) / 2 - layout.getHeight() / 2);
        layout.draw(canvas);
        canvas.restore();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        float f;
        if (isChecked())
        {
            f = getThumbScrollRange();
        } else
        {
            f = 0.0F;
        }
        mThumbPosition = f;
        k = getWidth() - getPaddingRight();
        l = mSwitchWidth;
        getGravity() & 0x70;
        JVM INSTR lookupswitch 2: default 80
    //                   16: 124
    //                   80: 158;
           goto _L1 _L2 _L3
_L1:
        j = getPaddingTop();
        i = j + mSwitchHeight;
_L5:
        mSwitchLeft = k - l;
        mSwitchTop = j;
        mSwitchBottom = i;
        mSwitchRight = k;
        return;
_L2:
        j = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2 - mSwitchHeight / 2;
        i = j + mSwitchHeight;
        continue; /* Loop/switch isn't completed */
_L3:
        i = getHeight() - getPaddingBottom();
        j = i - mSwitchHeight;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onMeasure(int i, int j)
    {
        int k;
        int l;
        int i1;
        int j1;
        int l1;
        int i2;
        k = android.view.View.MeasureSpec.getMode(i);
        l = android.view.View.MeasureSpec.getMode(j);
        i1 = android.view.View.MeasureSpec.getSize(i);
        j1 = android.view.View.MeasureSpec.getSize(j);
        if (mOnLayout == null)
        {
            mOnLayout = makeLayout(mTextOn);
        }
        if (mOffLayout == null)
        {
            mOffLayout = makeLayout(mTextOff);
        }
        mTrackDrawable.getPadding(mTempRect);
        int k1 = Math.max(mOnLayout.getWidth(), mOffLayout.getWidth());
        l1 = Math.min(mSwitchMaxWidth, k1 * 2 + mThumbTextPadding * 4 + mTempRect.left + mTempRect.right);
        i2 = mTrackDrawable.getIntrinsicHeight();
        mThumbWidth = mThumbTextPadding * 2 + k1;
        k;
        JVM INSTR lookupswitch 2: default 176
    //                   -2147483648: 250
    //                   0: 261;
           goto _L1 _L2 _L1
_L1:
        l;
        JVM INSTR lookupswitch 2: default 204
    //                   -2147483648: 264
    //                   0: 275;
           goto _L3 _L4 _L3
_L3:
        mSwitchWidth = l1;
        mSwitchHeight = i2;
        super.onMeasure(i, j);
        if (getMeasuredHeight() < i2)
        {
            if (android.os.Build.VERSION.SDK_INT < 11)
            {
                break; /* Loop/switch isn't completed */
            }
            setMeasuredDimension(getMeasuredWidthAndState(), i2);
        }
        return;
_L2:
        Math.min(i1, l1);
        continue; /* Loop/switch isn't completed */
_L4:
        Math.min(j1, i2);
        if (true) goto _L3; else goto _L5
_L5:
        setMeasuredDimension(getMeasuredWidth(), i2);
        return;
        if (true) goto _L1; else goto _L6
_L6:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        mVelocityTracker.addMovement(motionevent);
        int i;
        if (android.os.Build.VERSION.SDK_INT > 7)
        {
            i = motionevent.getActionMasked();
        } else
        {
            i = motionevent.getAction();
        }
        i;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 75
    //                   1 280
    //                   2 119
    //                   3 280;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        flag = super.onTouchEvent(motionevent);
_L6:
        return flag;
_L2:
        float f = motionevent.getX();
        float f3 = motionevent.getY();
        if (isEnabled() && hitThumb(f, f3))
        {
            mTouchMode = 1;
            mTouchX = f;
            mTouchY = f3;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        float f2;
        float f5;
        switch (mTouchMode)
        {
        case 0: // '\0'
        default:
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            float f1 = motionevent.getX();
            float f4 = motionevent.getY();
            if (Math.abs(f1 - mTouchX) > (float)mTouchSlop || Math.abs(f4 - mTouchY) > (float)mTouchSlop)
            {
                mTouchMode = 2;
                getParent().requestDisallowInterceptTouchEvent(true);
                mTouchX = f1;
                mTouchY = f4;
                return true;
            }
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
            f2 = motionevent.getX();
            f5 = mTouchX;
            f5 = Math.max(0.0F, Math.min(mThumbPosition + (f2 - f5), getThumbScrollRange()));
            break;
        }
        if (f5 == mThumbPosition) goto _L6; else goto _L5
_L5:
        mThumbPosition = f5;
        mTouchX = f2;
        invalidate();
        return true;
_L3:
        if (mTouchMode == 2)
        {
            stopDrag(motionevent);
            return true;
        }
        mTouchMode = 0;
        mVelocityTracker.clear();
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void setChecked(boolean flag)
    {
        super.setChecked(flag);
        float f;
        if (flag)
        {
            f = getThumbScrollRange();
        } else
        {
            f = 0.0F;
        }
        mThumbPosition = f;
        invalidate();
    }

    public void setSwitchTextAppearance(Context context, int i)
    {
        context = context.obtainStyledAttributes(i, com.amazon.mShop.android.lib.R.styleable.AmazonTextAppearance);
        ColorStateList colorstatelist = context.getColorStateList(3);
        if (colorstatelist != null)
        {
            mTextColors = colorstatelist;
        } else
        {
            mTextColors = getTextColors();
        }
        i = context.getDimensionPixelSize(0, 0);
        if (i != 0 && (float)i != mTextPaint.getTextSize())
        {
            mTextPaint.setTextSize(i);
            requestLayout();
        }
        setSwitchTypefaceByIndex(context.getInt(1, -1), context.getInt(2, -1));
        context.recycle();
    }

    public void setSwitchTypeface(Typeface typeface)
    {
        if (mTextPaint.getTypeface() != typeface)
        {
            mTextPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchTypeface(Typeface typeface, int i)
    {
        boolean flag = false;
        if (i > 0)
        {
            float f;
            int j;
            if (typeface == null)
            {
                typeface = Typeface.defaultFromStyle(i);
            } else
            {
                typeface = Typeface.create(typeface, i);
            }
            setSwitchTypeface(typeface);
            if (typeface != null)
            {
                j = typeface.getStyle();
            } else
            {
                j = 0;
            }
            i &= ~j;
            typeface = mTextPaint;
            if ((i & 1) != 0)
            {
                flag = true;
            }
            typeface.setFakeBoldText(flag);
            typeface = mTextPaint;
            if ((i & 2) != 0)
            {
                f = -0.25F;
            } else
            {
                f = 0.0F;
            }
            typeface.setTextSkewX(f);
            return;
        } else
        {
            mTextPaint.setFakeBoldText(false);
            mTextPaint.setTextSkewX(0.0F);
            setSwitchTypeface(typeface);
            return;
        }
    }

    public void setTextOff(CharSequence charsequence)
    {
        mTextOff = charsequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charsequence)
    {
        mTextOn = charsequence;
        requestLayout();
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == mThumbDrawable || drawable == mTrackDrawable;
    }

}
