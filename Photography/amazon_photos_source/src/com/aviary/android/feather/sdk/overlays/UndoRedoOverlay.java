// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.overlays;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.overlays:
//            AviaryOverlay

public class UndoRedoOverlay extends AviaryOverlay
{

    private Drawable mRedoDrawable;
    private CharSequence mRedoText;
    private Drawable mRedoTextDrawable;
    private final android.text.Layout.Alignment mTextAlign;
    private Drawable mTitleDrawable1;
    private CharSequence mTitleText;
    private final float mTitleWidthFraction;
    private Drawable mUndoDrawable;
    private CharSequence mUndoRext;
    private Drawable mUndoTextDrawable;

    public UndoRedoOverlay(Context context, int i)
    {
        super(context, "undo_redo", i, 5);
        context = context.getResources();
        mRedoDrawable = context.getDrawable(com.aviary.android.feather.sdk.R.drawable.aviary_overlay_undo_redo);
        mUndoDrawable = context.getDrawable(com.aviary.android.feather.sdk.R.drawable.aviary_overlay_undo_undo);
        mTitleText = getTitleText(context);
        mRedoText = context.getString(com.aviary.android.feather.sdk.R.string.feather_redo);
        mUndoRext = context.getString(com.aviary.android.feather.sdk.R.string.feather_undo);
        mTitleWidthFraction = getTitleWidthFraction(context);
        mTextAlign = android.text.Layout.Alignment.ALIGN_CENTER;
    }

    private void calculateTextLayouts()
    {
        if (!isAttachedToParent())
        {
            return;
        }
        char c = '\0';
        if (mOrientationChanged)
        {
            c = '\377';
        }
        Object obj = getDisplayMetrics();
        int i = mRedoDrawable.getIntrinsicWidth();
        int j = mRedoDrawable.getIntrinsicHeight();
        int k = getWidth() / 2;
        int l = getHeight() / 2;
        Rect rect = new Rect(k - i / 2, l - j / 2, i / 2 + k, j / 2 + l);
        mUndoDrawable.setBounds(rect);
        mUndoDrawable.setAlpha(c);
        mUndoTextDrawable = generateTextDrawable(getContext(), mUndoRext, rect.width(), mTextAlign);
        Rect rect1 = relativeBounds(mUndoTextDrawable, rect, 0, 80);
        mUndoTextDrawable.setBounds(rect1);
        mUndoTextDrawable.setAlpha(c);
        l = (int)((float)rect1.bottom + dp2px(((DisplayMetrics) (obj)), 60F));
        rect1 = new Rect(k - i / 2, l - j / 2, i / 2 + k, j / 2 + l);
        mRedoDrawable.setBounds(rect1);
        mRedoDrawable.setAlpha(c);
        mRedoTextDrawable = generateTextDrawable(getContext(), mRedoText, rect1.width(), mTextAlign);
        rect1 = relativeBounds(mRedoTextDrawable, rect1, 0, 80);
        mRedoTextDrawable.setBounds(rect1);
        mRedoTextDrawable.setAlpha(c);
        i = getWidth() / 2;
        rect = new Rect(i, rect.top, i, rect.bottom);
        i = (int)((float)((DisplayMetrics) (obj)).widthPixels * (mTitleWidthFraction / 100F));
        mTitleDrawable1 = generateTitleDrawable(getContext(), mTitleText, i, mTextAlign);
        obj = generateBounds(mTitleDrawable1, rect, getTextMargins(), "top");
        mTitleDrawable1.setBounds(((Rect) (obj)));
        mTitleDrawable1.setAlpha(c);
    }

    static float dp2px(DisplayMetrics displaymetrics, float f)
    {
        return displaymetrics.density * f;
    }

    private Rect generateBounds(Drawable drawable, Rect rect, int i, CharSequence charsequence)
    {
        DisplayMetrics displaymetrics = getDisplayMetrics();
        int j = drawable.getIntrinsicWidth();
        int k = drawable.getIntrinsicHeight();
        drawable = new Rect(0, 0, j, k);
        if ("top".equals(charsequence))
        {
            drawable.offsetTo((displaymetrics.widthPixels - j) / 2, rect.top - k - i);
            return drawable;
        } else
        {
            drawable.offsetTo((displaymetrics.widthPixels - j) / 2, rect.bottom + i);
            return drawable;
        }
    }

    private Rect relativeBounds(Drawable drawable, Rect rect, int i, int j)
    {
        int k = drawable.getIntrinsicWidth();
        int l = drawable.getIntrinsicHeight();
        drawable = new Rect(0, 0, k, l);
        drawable.offsetTo(rect.centerX() - k / 2, 0);
        if (j == 48)
        {
            drawable.offset(0, rect.top - l - i);
            return drawable;
        } else
        {
            drawable.offset(0, rect.bottom + i);
            return drawable;
        }
    }

    protected void calculatePositions()
    {
        logger.info("calculatePositions");
        calculateTextLayouts();
    }

    protected void dispatchDraw(Canvas canvas)
    {
        if (getVisibility() != 0 || !isAttachedToParent())
        {
            return;
        } else
        {
            canvas.drawColor(getBackgroundColor());
            mRedoDrawable.draw(canvas);
            mUndoDrawable.draw(canvas);
            mTitleDrawable1.draw(canvas);
            mRedoTextDrawable.draw(canvas);
            mUndoTextDrawable.draw(canvas);
            super.dispatchDraw(canvas);
            return;
        }
    }

    protected void doShow()
    {
        logger.info("doShow");
        if (!isAttachedToParent())
        {
            return;
        } else
        {
            fadeIn();
            return;
        }
    }

    protected Animator generateInAnimation()
    {
        AnimatorSet animatorset = new AnimatorSet();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "alpha", new float[] {
            0.0F, 1.0F
        });
        objectanimator.setDuration(getAnimationDuration());
        ObjectAnimator objectanimator1 = ObjectAnimator.ofInt(this, "alpha1", new int[] {
            0, 255
        });
        objectanimator1.setDuration(getAnimationDuration());
        objectanimator1.setStartDelay(100L);
        ObjectAnimator objectanimator2 = ObjectAnimator.ofInt(this, "alpha2", new int[] {
            0, 255
        });
        objectanimator2.setDuration(getAnimationDuration());
        objectanimator2.setStartDelay(200L);
        ObjectAnimator objectanimator3 = ObjectAnimator.ofInt(this, "alpha3", new int[] {
            0, 255
        });
        objectanimator3.setDuration(getAnimationDuration());
        objectanimator3.setStartDelay(600L);
        animatorset.playSequentially(new Animator[] {
            objectanimator, objectanimator1, objectanimator2, objectanimator3
        });
        return animatorset;
    }

    public int getAlpha1()
    {
        return mTitleDrawable1.getAlpha();
    }

    public int getAlpha2()
    {
        return mUndoDrawable.getAlpha();
    }

    public int getAlpha3()
    {
        return mRedoDrawable.getAlpha();
    }

    protected CharSequence getTitleText(Resources resources)
    {
        return resources.getString(com.aviary.android.feather.sdk.R.string.feather_overlay_undo_title);
    }

    protected float getTitleWidthFraction(Resources resources)
    {
        return 90F;
    }

    protected void inAnimationCompleted()
    {
        if (getCloseButton() != null)
        {
            getCloseButton().setVisibility(0);
        }
    }

    public void onClick(View view)
    {
        logger.info((new StringBuilder()).append("onClick: ").append(view).toString());
        if (view == getCloseButton() && mCloseListener != null)
        {
            trackTutorialClosed("button");
            mCloseListener.onClose(this);
            return;
        } else
        {
            super.onClick(view);
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (isVisible() && isActive())
        {
            if (mCloseListener != null)
            {
                trackTutorialClosed("background");
                mCloseListener.onClose(this);
                return true;
            }
            if (motionevent.getAction() == 0)
            {
                hide("background");
                return true;
            }
        }
        return true;
    }

    public void setAlpha(float f)
    {
        logger.info((new StringBuilder()).append("setAlpha: ").append(f).toString());
        super.setAlpha(f);
    }

    public void setAlpha1(int i)
    {
        mTitleDrawable1.setAlpha(i);
        postInvalidate();
    }

    public void setAlpha2(int i)
    {
        mUndoDrawable.setAlpha(i);
        mUndoTextDrawable.setAlpha(i);
        postInvalidate();
    }

    public void setAlpha3(int i)
    {
        mRedoDrawable.setAlpha(i);
        mRedoTextDrawable.setAlpha(i);
        postInvalidate();
    }
}
