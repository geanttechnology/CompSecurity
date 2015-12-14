// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

class MaterialProgressDrawable extends Drawable
    implements Animatable
{

    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5F;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75F;
    private static final float CENTER_RADIUS_LARGE = 12.5F;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float COLOR_START_DELAY_OFFSET = 0.75F;
    static final int DEFAULT = 1;
    private static final float END_TRIM_START_DELAY_OFFSET = 0.5F;
    private static final float FULL_ROTATION = 1080F;
    static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final float MAX_PROGRESS_ARC = 0.8F;
    private static final float NUM_POINTS = 5F;
    private static final float START_TRIM_DURATION_OFFSET = 0.5F;
    private static final float STROKE_WIDTH = 2.5F;
    private static final float STROKE_WIDTH_LARGE = 3F;
    private final int COLORS[] = {
        0xff000000
    };
    private Animation mAnimation;
    private final ArrayList mAnimators = new ArrayList();
    private final android.graphics.drawable.Drawable.Callback mCallback = new _cls3();
    boolean mFinishing;
    private double mHeight;
    private View mParent;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    private float mRotationCount;
    private double mWidth;

    public MaterialProgressDrawable(Context context, View view)
    {
        mParent = view;
        mResources = context.getResources();
        mRing = new Ring(mCallback);
        mRing.setColors(COLORS);
        updateSizes(1);
        setupAnimators();
    }

    private void applyFinishTranslation(float f, Ring ring)
    {
        updateRingColor(f, ring);
        float f1 = (float)(Math.floor(ring.getStartingRotation() / 0.8F) + 1.0D);
        float f2 = getMinProgressArc(ring);
        float f3 = ring.getStartingStartTrim();
        ring.setStartTrim((ring.getStartingEndTrim() - f2 - ring.getStartingStartTrim()) * f + f3);
        ring.setEndTrim(ring.getStartingEndTrim());
        f2 = ring.getStartingRotation();
        ring.setRotation((f1 - ring.getStartingRotation()) * f + f2);
    }

    private int evaluateColorChange(float f, int i, int j)
    {
        int i1 = Integer.valueOf(i).intValue();
        i = i1 >> 24 & 0xff;
        int k = i1 >> 16 & 0xff;
        int l = i1 >> 8 & 0xff;
        i1 &= 0xff;
        j = Integer.valueOf(j).intValue();
        int j1 = (int)((float)((j >> 24 & 0xff) - i) * f);
        int k1 = (int)((float)((j >> 16 & 0xff) - k) * f);
        int l1 = (int)((float)((j >> 8 & 0xff) - l) * f);
        return i1 + (int)((float)((j & 0xff) - i1) * f) | (i + j1 << 24 | k + k1 << 16 | l1 + l << 8);
    }

    private float getMinProgressArc(Ring ring)
    {
        return (float)Math.toRadians((double)ring.getStrokeWidth() / (6.2831853071795862D * ring.getCenterRadius()));
    }

    private float getRotation()
    {
        return mRotation;
    }

    private void setSizeParameters(double d, double d1, double d2, double d3, float f, float f1)
    {
        Ring ring = mRing;
        float f2 = mResources.getDisplayMetrics().density;
        mWidth = (double)f2 * d;
        mHeight = (double)f2 * d1;
        ring.setStrokeWidth((float)d3 * f2);
        ring.setCenterRadius((double)f2 * d2);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f * f2, f2 * f1);
        ring.setInsets((int)mWidth, (int)mHeight);
    }

    private void setupAnimators()
    {
        Ring ring = mRing;
        _cls1 _lcls1 = new _cls1(ring);
        _lcls1.setRepeatCount(-1);
        _lcls1.setRepeatMode(1);
        _lcls1.setInterpolator(LINEAR_INTERPOLATOR);
        _lcls1.setAnimationListener(new _cls2(ring));
        mAnimation = _lcls1;
    }

    private void updateRingColor(float f, Ring ring)
    {
        if (f > 0.75F)
        {
            ring.setColor(evaluateColorChange((f - 0.75F) / 0.25F, ring.getStartingColor(), ring.getNextColor()));
        }
    }

    public void draw(Canvas canvas)
    {
        Rect rect = getBounds();
        int i = canvas.save();
        canvas.rotate(mRotation, rect.exactCenterX(), rect.exactCenterY());
        mRing.draw(canvas, rect);
        canvas.restoreToCount(i);
    }

    public int getAlpha()
    {
        return mRing.getAlpha();
    }

    public int getIntrinsicHeight()
    {
        return (int)mHeight;
    }

    public int getIntrinsicWidth()
    {
        return (int)mWidth;
    }

    public int getOpacity()
    {
        return -3;
    }

    public boolean isRunning()
    {
        ArrayList arraylist = mAnimators;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            Animation animation = (Animation)arraylist.get(i);
            if (animation.hasStarted() && !animation.hasEnded())
            {
                return true;
            }
        }

        return false;
    }

    public void setAlpha(int i)
    {
        mRing.setAlpha(i);
    }

    public void setArrowScale(float f)
    {
        mRing.setArrowScale(f);
    }

    public void setBackgroundColor(int i)
    {
        mRing.setBackgroundColor(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mRing.setColorFilter(colorfilter);
    }

    public transient void setColorSchemeColors(int ai[])
    {
        mRing.setColors(ai);
        mRing.setColorIndex(0);
    }

    public void setProgressRotation(float f)
    {
        mRing.setRotation(f);
    }

    void setRotation(float f)
    {
        mRotation = f;
        invalidateSelf();
    }

    public void setStartEndTrim(float f, float f1)
    {
        mRing.setStartTrim(f);
        mRing.setEndTrim(f1);
    }

    public void showArrow(boolean flag)
    {
        mRing.setShowArrow(flag);
    }

    public void start()
    {
        mAnimation.reset();
        mRing.storeOriginals();
        if (mRing.getEndTrim() != mRing.getStartTrim())
        {
            mFinishing = true;
            mAnimation.setDuration(666L);
            mParent.startAnimation(mAnimation);
            return;
        } else
        {
            mRing.setColorIndex(0);
            mRing.resetOriginals();
            mAnimation.setDuration(1332L);
            mParent.startAnimation(mAnimation);
            return;
        }
    }

    public void stop()
    {
        mParent.clearAnimation();
        setRotation(0.0F);
        mRing.setShowArrow(false);
        mRing.setColorIndex(0);
        mRing.resetOriginals();
    }

    public void updateSizes(int i)
    {
        if (i == 0)
        {
            setSizeParameters(56D, 56D, 12.5D, 3D, 12F, 6F);
            return;
        } else
        {
            setSizeParameters(40D, 40D, 8.75D, 2.5D, 10F, 5F);
            return;
        }
    }








/*
    static float access$402(MaterialProgressDrawable materialprogressdrawable, float f)
    {
        materialprogressdrawable.mRotationCount = f;
        return f;
    }

*/

    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class Ring {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
