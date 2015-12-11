// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;
import com.target.ui.util.q;

public class ScalableImageView extends ImageView
{

    private static final float DEFAULT_SCALE_MAX = 3F;
    private static final int NO_POINTER = -1;
    private static final float NO_SCALE = 1F;
    private static final float NO_TRANSLATION = 0F;
    private static final int RESET_ANIMATION_DURATION = 300;
    public static final String TAG = com/target/ui/view/ScalableImageView.getSimpleName();
    private float mAttemptedPanMax;
    private float mAttemptedScaleMax;
    private float mAttemptedScaleMin;
    private float mCurrentScale;
    private float mCurrentScaleMax;
    private float mCurrentScaleMin;
    private PointF mCurrentTranslation;
    private PointF mInitialCoordinates;
    private boolean mIsAnimating;
    private boolean mIsMultiPointerEventSeries;
    private boolean mIsScalable;
    private int mLastPointerId;
    private Matrix mMatrix;
    private float mMaxScale;
    private PointF mPreviousCoordinates;
    private ScaleGestureDetector mScaleGestureDetector;
    private android.view.ScaleGestureDetector.SimpleOnScaleGestureListener mScaleListener = new android.view.ScaleGestureDetector.SimpleOnScaleGestureListener() {

        PointF focus;
        PointF lastFocus;
        final ScalableImageView this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            if (ScalableImageView.e(ScalableImageView.this))
            {
                return true;
            }
            focus.x = scalegesturedetector.getFocusX();
            focus.y = scalegesturedetector.getFocusY();
            float f1 = scalegesturedetector.getScaleFactor();
            ScalableImageView.c(ScalableImageView.this, Math.max(f1, ScalableImageView.f(ScalableImageView.this)));
            ScalableImageView.d(ScalableImageView.this, Math.min(f1, ScalableImageView.g(ScalableImageView.this)));
            ScalableImageView.e(ScalableImageView.this, ScalableImageView.a(ScalableImageView.this, ScalableImageView.d(ScalableImageView.this), f1));
            ScalableImageView.a(ScalableImageView.this, Math.max(ScalableImageView.d(ScalableImageView.this), ScalableImageView.h(ScalableImageView.this)));
            ScalableImageView.b(ScalableImageView.this, Math.min(ScalableImageView.d(ScalableImageView.this), ScalableImageView.i(ScalableImageView.this)));
            if (Float.compare(ScalableImageView.d(ScalableImageView.this), 1.0F) > 0)
            {
                if (!android.widget.ImageView.ScaleType.MATRIX.equals(getScaleType()))
                {
                    setScaleType(android.widget.ImageView.ScaleType.MATRIX);
                }
                ScalableImageView.b(ScalableImageView.this).set(ScalableImageView.a(ScalableImageView.this));
                ScalableImageView.b(ScalableImageView.this).postScale(ScalableImageView.d(ScalableImageView.this), ScalableImageView.d(ScalableImageView.this), getX() + (float)getWidth() * 0.5F, getY() + (float)getHeight() * 0.5F);
                scalegesturedetector = ScalableImageView.a(ScalableImageView.this);
                scalegesturedetector.x = ((PointF) (scalegesturedetector)).x + (focus.x - lastFocus.x);
                scalegesturedetector = ScalableImageView.a(ScalableImageView.this);
                scalegesturedetector.y = ((PointF) (scalegesturedetector)).y + (focus.y - lastFocus.y);
                ScalableImageView.a(ScalableImageView.this, ScalableImageView.a(ScalableImageView.this, ScalableImageView.b(ScalableImageView.this), ScalableImageView.a(ScalableImageView.this)));
                ScalableImageView.b(ScalableImageView.this).postTranslate(ScalableImageView.a(ScalableImageView.this).x, ScalableImageView.a(ScalableImageView.this).y);
                lastFocus.x = focus.x;
                lastFocus.y = focus.y;
                setImageMatrix(ScalableImageView.b(ScalableImageView.this));
                return true;
            } else
            {
                a(ScalableImageView.j(ScalableImageView.this));
                return false;
            }
        }

        public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
        {
            lastFocus.x = scalegesturedetector.getFocusX();
            lastFocus.y = scalegesturedetector.getFocusY();
            ScalableImageView.a(ScalableImageView.this, ScalableImageView.d(ScalableImageView.this));
            ScalableImageView.b(ScalableImageView.this, ScalableImageView.d(ScalableImageView.this));
            return true;
        }

            
            {
                this$0 = ScalableImageView.this;
                super();
                focus = new PointF();
                lastFocus = new PointF();
            }
    };
    private int mTouchSlop;

    public ScalableImageView(Context context)
    {
        super(context);
        mIsAnimating = false;
        mIsMultiPointerEventSeries = false;
        mIsScalable = true;
        mAttemptedPanMax = 0.0F;
        mAttemptedScaleMax = 1.0F;
        mAttemptedScaleMin = 1.0F;
        mCurrentScale = 1.0F;
        mCurrentScaleMax = 1.0F;
        mCurrentScaleMin = 1.0F;
        mMaxScale = 3F;
        mLastPointerId = -1;
        mMatrix = new Matrix();
        mCurrentTranslation = new PointF();
        mInitialCoordinates = new PointF();
        mPreviousCoordinates = new PointF();
        a();
    }

    public ScalableImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsAnimating = false;
        mIsMultiPointerEventSeries = false;
        mIsScalable = true;
        mAttemptedPanMax = 0.0F;
        mAttemptedScaleMax = 1.0F;
        mAttemptedScaleMin = 1.0F;
        mCurrentScale = 1.0F;
        mCurrentScaleMax = 1.0F;
        mCurrentScaleMin = 1.0F;
        mMaxScale = 3F;
        mLastPointerId = -1;
        mMatrix = new Matrix();
        mCurrentTranslation = new PointF();
        mInitialCoordinates = new PointF();
        mPreviousCoordinates = new PointF();
        a();
    }

    public ScalableImageView(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        mIsAnimating = false;
        mIsMultiPointerEventSeries = false;
        mIsScalable = true;
        mAttemptedPanMax = 0.0F;
        mAttemptedScaleMax = 1.0F;
        mAttemptedScaleMin = 1.0F;
        mCurrentScale = 1.0F;
        mCurrentScaleMax = 1.0F;
        mCurrentScaleMin = 1.0F;
        mMaxScale = 3F;
        mLastPointerId = -1;
        mMatrix = new Matrix();
        mCurrentTranslation = new PointF();
        mInitialCoordinates = new PointF();
        mPreviousCoordinates = new PointF();
        a();
    }

    private float a(float f1, float f2)
    {
        return a(f1, f2, 1.0F, mMaxScale);
    }

    private float a(float f1, float f2, float f3, float f4)
    {
        return Math.max(f3, Math.min(f1 * f2, f4));
    }

    static float a(ScalableImageView scalableimageview, float f1)
    {
        scalableimageview.mCurrentScaleMax = f1;
        return f1;
    }

    static float a(ScalableImageView scalableimageview, float f1, float f2)
    {
        return scalableimageview.a(f1, f2);
    }

    private static int a(View view)
    {
        if (view == null)
        {
            return 0;
        } else
        {
            return view.getWidth() - view.getPaddingLeft() - view.getPaddingRight();
        }
    }

    static Matrix a(ImageView imageview)
    {
        return b(imageview);
    }

    private static PointF a(ImageView imageview, float f1)
    {
        PointF pointf = new PointF();
        if (imageview != null && imageview.getDrawable() != null)
        {
            Drawable drawable = imageview.getDrawable();
            int l = drawable.getIntrinsicWidth();
            int i1 = drawable.getIntrinsicHeight();
            int j1 = a(((View) (imageview)));
            int k1 = b(imageview);
            if (l > 0 && i1 > 0 && j1 > 0 && k1 > 0)
            {
                float f2 = l;
                float f3 = i1;
                pointf.set(((float)j1 - f2 * f1) / 2.0F + 0.5F, ((float)k1 - f3 * f1) / 2.0F + 0.5F);
                return pointf;
            }
        }
        return pointf;
    }

    static PointF a(ImageView imageview, Matrix matrix, PointF pointf)
    {
        return b(imageview, matrix, pointf);
    }

    static PointF a(ScalableImageView scalableimageview)
    {
        return scalableimageview.mCurrentTranslation;
    }

    static PointF a(ScalableImageView scalableimageview, PointF pointf)
    {
        scalableimageview.mCurrentTranslation = pointf;
        return pointf;
    }

    static boolean a(ScalableImageView scalableimageview, boolean flag)
    {
        scalableimageview.mIsAnimating = flag;
        return flag;
    }

    static float b(ScalableImageView scalableimageview, float f1)
    {
        scalableimageview.mCurrentScaleMin = f1;
        return f1;
    }

    private static int b(View view)
    {
        if (view == null)
        {
            return 0;
        } else
        {
            return view.getHeight() - view.getPaddingTop() - view.getPaddingBottom();
        }
    }

    private static Matrix b(ImageView imageview)
    {
        Matrix matrix = new Matrix();
        float f1 = c(imageview);
        matrix.setScale(f1, f1);
        imageview = a(imageview, f1);
        matrix.postTranslate(((PointF) (imageview)).x, ((PointF) (imageview)).y);
        return matrix;
    }

    static Matrix b(ScalableImageView scalableimageview)
    {
        return scalableimageview.mMatrix;
    }

    private static PointF b(ImageView imageview, Matrix matrix, PointF pointf)
    {
        if (imageview == null || imageview.getDrawable() == null || matrix == null)
        {
            return pointf;
        }
        RectF rectf = new RectF(imageview.getDrawable().copyBounds());
        imageview = new RectF(imageview.getLeft(), imageview.getTop(), imageview.getRight(), imageview.getBottom());
        matrix.mapRect(rectf);
        matrix = new PointF();
        if (rectf.width() < imageview.width())
        {
            matrix.x = 0.0F;
        } else
        if (pointf.x > 0.0F)
        {
            float f5 = ((RectF) (imageview)).left - rectf.left;
            float f1 = f5;
            if (pointf.x < f5)
            {
                f1 = pointf.x;
            }
            matrix.x = f1;
        } else
        {
            float f6 = ((RectF) (imageview)).right - rectf.right;
            float f2 = f6;
            if (pointf.x > f6)
            {
                f2 = pointf.x;
            }
            matrix.x = f2;
        }
        if (rectf.height() < imageview.height())
        {
            matrix.y = 0.0F;
        } else
        if (pointf.y > 0.0F)
        {
            float f7 = ((RectF) (imageview)).top - rectf.top;
            float f3 = f7;
            if (pointf.y < f7)
            {
                f3 = pointf.y;
            }
            matrix.y = f3;
        } else
        {
            float f8 = ((RectF) (imageview)).bottom - rectf.bottom;
            float f4 = f8;
            if (pointf.y > f8)
            {
                f4 = pointf.y;
            }
            matrix.y = f4;
        }
        return matrix;
    }

    private static float c(ImageView imageview)
    {
        if (imageview != null && imageview.getDrawable() != null)
        {
            Drawable drawable = imageview.getDrawable();
            int l = drawable.getIntrinsicWidth();
            int i1 = drawable.getIntrinsicHeight();
            int j1 = a(imageview);
            int k1 = b(imageview);
            if (l > 0 && i1 > 0 && j1 > 0 && k1 > 0)
            {
                return Math.min((float)j1 / (float)l, (float)k1 / (float)i1);
            }
        }
        return 1.0F;
    }

    static float c(ScalableImageView scalableimageview, float f1)
    {
        scalableimageview.mAttemptedScaleMax = f1;
        return f1;
    }

    static void c(ScalableImageView scalableimageview)
    {
        scalableimageview.d();
    }

    static float d(ScalableImageView scalableimageview)
    {
        return scalableimageview.mCurrentScale;
    }

    static float d(ScalableImageView scalableimageview, float f1)
    {
        scalableimageview.mAttemptedScaleMin = f1;
        return f1;
    }

    private void d()
    {
        mMatrix.reset();
        mCurrentTranslation.x = 0.0F;
        mCurrentTranslation.y = 0.0F;
        mCurrentScale = 1.0F;
        if (!android.widget.ImageView.ScaleType.FIT_CENTER.equals(getScaleType()))
        {
            setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        }
    }

    static float e(ScalableImageView scalableimageview, float f1)
    {
        scalableimageview.mCurrentScale = f1;
        return f1;
    }

    private boolean e()
    {
        return (float)Float.compare(mAttemptedPanMax, mTouchSlop) > 0.0F;
    }

    static boolean e(ScalableImageView scalableimageview)
    {
        return scalableimageview.mIsAnimating;
    }

    static float f(ScalableImageView scalableimageview)
    {
        return scalableimageview.mAttemptedScaleMax;
    }

    private boolean f()
    {
        return (float)Float.compare(mAttemptedScaleMax, 1.0F) != 0.0F || (float)Float.compare(mAttemptedScaleMin, 1.0F) != 0.0F;
    }

    static float g(ScalableImageView scalableimageview)
    {
        return scalableimageview.mAttemptedScaleMin;
    }

    private boolean g()
    {
        return Float.compare(mCurrentScaleMin, mCurrentScaleMax) != 0;
    }

    static float h(ScalableImageView scalableimageview)
    {
        return scalableimageview.mCurrentScaleMax;
    }

    private void h()
    {
        k();
        i();
        j();
    }

    static float i(ScalableImageView scalableimageview)
    {
        return scalableimageview.mCurrentScaleMin;
    }

    private void i()
    {
        mAttemptedPanMax = 0.0F;
    }

    private void j()
    {
        mAttemptedScaleMin = 1.0F;
        mAttemptedScaleMax = 1.0F;
    }

    static boolean j(ScalableImageView scalableimageview)
    {
        return scalableimageview.g();
    }

    private void k()
    {
        float f1 = mCurrentScale;
        mCurrentScaleMax = f1;
        mCurrentScaleMin = f1;
    }

    public void a()
    {
        mScaleGestureDetector = new ScaleGestureDetector(getContext(), mScaleListener);
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void a(boolean flag)
    {
        if (mIsAnimating)
        {
            return;
        }
        if (!flag || mMatrix.isIdentity())
        {
            d();
            return;
        } else
        {
            ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
                mCurrentScale, 1.0F
            });
            valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

                PointF lastTranslation;
                final ScalableImageView this$0;

                public void onAnimationUpdate(ValueAnimator valueanimator1)
                {
                    if (ScalableImageView.b(ScalableImageView.this).isIdentity())
                    {
                        q.a(ScalableImageView.TAG, "Identity matrix while animating");
                        return;
                    } else
                    {
                        ScalableImageView.b(ScalableImageView.this).set(ScalableImageView.a(ScalableImageView.this));
                        float f1 = ((Float)valueanimator1.getAnimatedValue()).floatValue();
                        float f2 = getX();
                        float f3 = getWidth();
                        float f4 = getY();
                        float f5 = getHeight();
                        ScalableImageView.b(ScalableImageView.this).postScale(f1, f1, f2 + f3 * 0.5F, f4 + f5 * 0.5F);
                        f1 = valueanimator1.getAnimatedFraction();
                        valueanimator1 = lastTranslation;
                        valueanimator1.x = ((PointF) (valueanimator1)).x * (1.0F - f1);
                        valueanimator1 = lastTranslation;
                        valueanimator1.y = (1.0F - f1) * ((PointF) (valueanimator1)).y;
                        ScalableImageView.b(ScalableImageView.this).postTranslate(lastTranslation.x, lastTranslation.y);
                        setImageMatrix(ScalableImageView.b(ScalableImageView.this));
                        return;
                    }
                }

            
            {
                this$0 = ScalableImageView.this;
                super();
                lastTranslation = new PointF(ScalableImageView.a(ScalableImageView.this).x, ScalableImageView.a(ScalableImageView.this).y);
            }
            });
            valueanimator.addListener(new AnimatorListenerAdapter() {

                final ScalableImageView this$0;

                public void onAnimationEnd(Animator animator)
                {
                    ScalableImageView.a(ScalableImageView.this, false);
                    ScalableImageView.c(ScalableImageView.this);
                }

                public void onAnimationStart(Animator animator)
                {
                    ScalableImageView.a(ScalableImageView.this, true);
                }

            
            {
                this$0 = ScalableImageView.this;
                super();
            }
            });
            valueanimator.setDuration(300L);
            valueanimator.start();
            return;
        }
    }

    public boolean b()
    {
        return Float.compare(mCurrentScale, 1.0F) != 0;
    }

    public void c()
    {
        a(false);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag2 = false;
        if (mIsScalable) goto _L2; else goto _L1
_L1:
        flag2 = super.onTouchEvent(motionevent);
_L8:
        return flag2;
_L2:
        mScaleGestureDetector.onTouchEvent(motionevent);
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 3: default 64
    //                   0 112
    //                   1 586
    //                   2 180
    //                   3 586;
           goto _L3 _L4 _L5 _L6 _L5
_L5:
        break MISSING_BLOCK_LABEL_586;
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
_L9:
        if (!flag && flag1)
        {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (flag || mIsMultiPointerEventSeries || super.onTouchEvent(motionevent))
        {
            return true;
        }
        if (true) goto _L8; else goto _L7
_L7:
        mIsMultiPointerEventSeries = false;
        mInitialCoordinates.x = motionevent.getX();
        mInitialCoordinates.y = motionevent.getY();
        mPreviousCoordinates.x = motionevent.getX();
        mPreviousCoordinates.y = motionevent.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        flag = false;
        flag1 = false;
          goto _L9
_L6:
        if (motionevent.getPointerCount() > 1)
        {
            mIsMultiPointerEventSeries = true;
        }
        if (mIsAnimating)
        {
            mPreviousCoordinates.x = motionevent.getX();
            mPreviousCoordinates.y = motionevent.getY();
            flag = false;
            flag1 = false;
        } else
        {
            if (mScaleGestureDetector.isInProgress())
            {
                mLastPointerId = -1;
                flag = true;
                flag1 = false;
            } else
            if (b())
            {
                if (mLastPointerId == -1 || mLastPointerId != motionevent.getPointerId(0))
                {
                    mLastPointerId = motionevent.getPointerId(0);
                    mPreviousCoordinates.x = motionevent.getX();
                    mPreviousCoordinates.y = motionevent.getY();
                }
                mAttemptedPanMax = Math.max((new PointF(motionevent.getX() - mInitialCoordinates.x, motionevent.getY() - mInitialCoordinates.y)).length(), mAttemptedPanMax);
                PointF pointf = new PointF(motionevent.getX() - mPreviousCoordinates.x, motionevent.getY() - mPreviousCoordinates.y);
                PointF pointf2;
                if (Float.compare(pointf.length(), mTouchSlop) > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                pointf = b(this, mMatrix, pointf);
                pointf2 = mCurrentTranslation;
                pointf2.x = pointf2.x + pointf.x;
                pointf2 = mCurrentTranslation;
                pointf2.y = pointf2.y + pointf.y;
                if (Float.compare(pointf.length(), 0.0F) != 0)
                {
                    mMatrix.postTranslate(pointf.x, pointf.y);
                    setImageMatrix(mMatrix);
                }
                flag1 = false;
            } else
            {
                PointF pointf1 = new PointF(motionevent.getX() - mInitialCoordinates.x, motionevent.getY() - mInitialCoordinates.y);
                if (!mIsMultiPointerEventSeries && Float.compare(pointf1.length(), mTouchSlop) > 0)
                {
                    flag = false;
                    flag1 = true;
                } else
                {
                    flag = false;
                    flag1 = false;
                }
            }
            mPreviousCoordinates.x = motionevent.getX();
            mPreviousCoordinates.y = motionevent.getY();
        }
          goto _L9
        mLastPointerId = -1;
        if (g() || e() || f())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        h();
        flag1 = false;
          goto _L9
    }

    public void setMaximumScale(float f1)
    {
        mMaxScale = f1;
    }

    public void setScalable(boolean flag)
    {
        mIsScalable = flag;
    }

}
