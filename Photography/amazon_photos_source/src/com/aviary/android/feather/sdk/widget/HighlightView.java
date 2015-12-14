// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.aviary.android.feather.common.utils.ReflectionException;
import com.aviary.android.feather.common.utils.ReflectionUtils;
import com.aviary.android.feather.library.graphics.RectD;
import com.aviary.android.feather.library.graphics.animation.ExpoInterpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            CropImageView, DrawableHighlightView

public class HighlightView
{
    static final class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode Grow;
        public static final Mode Move;
        public static final Mode None;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/aviary/android/feather/sdk/widget/HighlightView$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            None = new Mode("None", 0);
            Move = new Mode("Move", 1);
            Grow = new Mode("Grow", 2);
            $VALUES = (new Mode[] {
                None, Move, Grow
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }


    static final int GROW_BOTTOM_EDGE = 16;
    static final int GROW_LEFT_EDGE = 2;
    static final int GROW_NONE = 1;
    static final int GROW_RIGHT_EDGE = 4;
    static final int GROW_TOP_EDGE = 8;
    private static final String LOG_TAG = "HighlightView";
    static final int MOVE = 32;
    private static Handler mHandler = new Handler();
    protected int animationDurationMs;
    private int dHeight;
    private int dWidth;
    final int gridCols = 3;
    final int gridRows = 3;
    final float hysteresis = 30F;
    private RectD mCropRect;
    private Rect mDrawRect;
    private boolean mHidden;
    private RectD mImageRect;
    private double mInitialAspectRatio;
    private int mInternalStrokeColor;
    private int mInternalStrokeColorPressed;
    private Path mInversePath;
    private Drawable mKnobDrawableBottomLeft;
    private Drawable mKnobDrawableBottomRight;
    private Drawable mKnobDrawableTopLeft;
    private Drawable mKnobDrawableTopRight;
    private Paint mLinesPaintShadow;
    private Path mLinesPath;
    private boolean mMaintainAspectRatio;
    private Matrix mMatrix;
    private int mMinSize;
    private Mode mMode;
    private final Paint mOutlineFill = new Paint();
    private final Paint mOutlinePaint = new Paint();
    private final Paint mOutlinePaint2 = new Paint();
    private int mOutsideFillColor;
    private int mOutsideFillColorPressed;
    private int mParentHeight;
    private int mParentWidth;
    private Path mPath;
    protected volatile boolean mRunning;
    private int mStrokeColor;
    private int mStrokeColorPressed;
    private int mStrokeWidth;
    private int mStrokeWidth2;
    private Rect mViewDrawingRect;
    private RectF tempLayoutRectF;
    private RectF tmpDisplayRectF;
    private RectF tmpDrawRect2F;
    private RectF tmpDrawRectF;
    private RectD tmpRect2;
    private Rect tmpRect4;
    private Rect tmpRectMotion;
    private RectD tmpRectMotionD;

    public HighlightView(View view, int i)
    {
        mRunning = false;
        animationDurationMs = 300;
        mMinSize = 20;
        mDrawRect = new Rect();
        mMaintainAspectRatio = false;
        mLinesPaintShadow = new Paint();
        mViewDrawingRect = new Rect();
        mPath = new Path();
        mLinesPath = new Path();
        mInversePath = new Path();
        tmpRect2 = new RectD();
        tmpRect4 = new Rect();
        tmpDrawRect2F = new RectF();
        tmpDrawRectF = new RectF();
        tmpDisplayRectF = new RectF();
        tmpRectMotion = new Rect();
        tmpRectMotionD = new RectD();
        tempLayoutRectF = new RectF();
        if (i > 0)
        {
            TypedArray typedarray = view.getContext().obtainStyledAttributes(i, com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView);
            mStrokeWidth = typedarray.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_aviary_strokeWidth, 2);
            mStrokeColor = typedarray.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_aviary_strokeColor, -1);
            mStrokeColorPressed = typedarray.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_aviary_strokeColor2, -1);
            mOutsideFillColor = typedarray.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_aviary_color1, 0x99000000);
            mOutsideFillColorPressed = typedarray.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_aviary_color2, 0x99000000);
            mStrokeWidth2 = typedarray.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_aviary_strokeWidth2, 1);
            mInternalStrokeColor = typedarray.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_aviary_strokeColor3, -1);
            mInternalStrokeColorPressed = typedarray.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_aviary_strokeColor4, -1);
            mKnobDrawableTopLeft = typedarray.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_android_src);
            mKnobDrawableTopRight = typedarray.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_android_src);
            mKnobDrawableBottomLeft = typedarray.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_android_src);
            mKnobDrawableBottomRight = typedarray.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryCropHighlightView_android_src);
            typedarray.recycle();
        } else
        {
            mStrokeWidth = 2;
            mStrokeWidth2 = 1;
            mStrokeColor = -1;
            mStrokeColorPressed = -1;
            mOutsideFillColor = 0;
            mOutsideFillColorPressed = 0;
            mInternalStrokeColor = 0;
            mInternalStrokeColorPressed = 0;
        }
        if (mKnobDrawableTopLeft != null)
        {
            double d = mKnobDrawableTopLeft.getIntrinsicWidth();
            double d1 = mKnobDrawableTopLeft.getIntrinsicHeight();
            dWidth = (int)Math.ceil(d / 2D);
            dHeight = (int)Math.ceil(d1 / 2D);
        }
        view.getDrawingRect(mViewDrawingRect);
        mParentWidth = view.getWidth();
        mParentHeight = view.getHeight();
    }

    private void adjustCropRect(RectD rectd)
    {
        double d;
        double d1;
        double d2;
        double d3;
        if (rectd.left < mImageRect.left)
        {
            rectd.offset(mImageRect.left - rectd.left, 0.0D);
        } else
        if (rectd.right > mImageRect.right)
        {
            rectd.offset(-(rectd.right - mImageRect.right), 0.0D);
        }
        if (rectd.top < mImageRect.top)
        {
            rectd.offset(0.0D, mImageRect.top - rectd.top);
        } else
        if (rectd.bottom > mImageRect.bottom)
        {
            rectd.offset(0.0D, -(rectd.bottom - mImageRect.bottom));
        }
        d2 = -1D;
        d3 = -1D;
        if (rectd.width() > mImageRect.width())
        {
            if (rectd.left < mImageRect.left)
            {
                d = mImageRect.left - rectd.left;
                rectd.left = rectd.left + d;
                d1 = d3;
            } else
            {
                d = d2;
                d1 = d3;
                if (rectd.right > mImageRect.right)
                {
                    d = rectd.right - mImageRect.right;
                    rectd.right = rectd.right + -d;
                    d1 = d3;
                }
            }
        } else
        {
            d = d2;
            d1 = d3;
            if (rectd.height() > mImageRect.height())
            {
                if (rectd.top < mImageRect.top)
                {
                    d1 = mImageRect.top - rectd.top;
                    rectd.top = rectd.top + d1;
                    d = d2;
                } else
                {
                    d = d2;
                    d1 = d3;
                    if (rectd.bottom > mImageRect.bottom)
                    {
                        d1 = rectd.bottom - mImageRect.bottom;
                        rectd.bottom = rectd.bottom + -d1;
                        d = d2;
                    }
                }
            }
        }
        if (mMaintainAspectRatio)
        {
            if (d1 != -1D)
            {
                rectd.inset((d1 * mInitialAspectRatio) / 2D, 0.0D);
            } else
            if (d != -1D)
            {
                rectd.inset(0.0D, d / mInitialAspectRatio / 2D);
            }
        }
        rectd.sort();
    }

    private RectD adjustRealCropRect(Matrix matrix, RectD rectd, RectD rectd1)
    {
        boolean flag = false;
        tempLayoutRectF.set((float)rectd.left, (float)rectd.top, (float)rectd.right, (float)rectd.bottom);
        matrix.mapRect(tempLayoutRectF);
        float af[] = new float[9];
        matrix.getValues(af);
        float f = af[0];
        if ((double)tempLayoutRectF.left < rectd1.left)
        {
            flag = true;
            rectd.offset((rectd1.left - (double)tempLayoutRectF.left) / (double)f, 0.0D);
        } else
        if ((double)tempLayoutRectF.right > rectd1.right)
        {
            flag = true;
            rectd.offset(-((double)tempLayoutRectF.right - rectd1.right) / (double)f, 0.0D);
        }
        if ((double)tempLayoutRectF.top < rectd1.top)
        {
            flag = true;
            rectd.offset(0.0D, (rectd1.top - (double)tempLayoutRectF.top) / (double)f);
        } else
        if ((double)tempLayoutRectF.bottom > rectd1.bottom)
        {
            flag = true;
            rectd.offset(0.0D, -((double)tempLayoutRectF.bottom - rectd1.bottom) / (double)f);
        }
        tempLayoutRectF.set((float)rectd.left, (float)rectd.top, (float)rectd.right, (float)rectd.bottom);
        matrix.mapRect(tempLayoutRectF);
        if ((double)tempLayoutRectF.width() > rectd1.width())
        {
            boolean flag1 = true;
            if ((double)tempLayoutRectF.left < rectd1.left)
            {
                rectd.left = rectd.left + (rectd1.left - (double)tempLayoutRectF.left) / (double)f;
            }
            flag = flag1;
            if ((double)tempLayoutRectF.right > rectd1.right)
            {
                rectd.right = rectd.right + -((double)tempLayoutRectF.right - rectd1.right) / (double)f;
                flag = flag1;
            }
        }
        if ((double)tempLayoutRectF.height() > rectd1.height())
        {
            boolean flag2 = true;
            if ((double)tempLayoutRectF.top < rectd1.top)
            {
                rectd.top = rectd.top + (rectd1.top - (double)tempLayoutRectF.top) / (double)f;
            }
            flag = flag2;
            if ((double)tempLayoutRectF.bottom > rectd1.bottom)
            {
                rectd.bottom = rectd.bottom + -((double)tempLayoutRectF.bottom - rectd1.bottom) / (double)f;
                flag = flag2;
            }
        }
        if (mMaintainAspectRatio && flag)
        {
            if (mInitialAspectRatio >= 1.0D)
            {
                double d = rectd.width() / mInitialAspectRatio;
                rectd.bottom = rectd.top + d;
            } else
            {
                double d1 = rectd.height();
                double d2 = mInitialAspectRatio;
                rectd.right = rectd.left + d1 * d2;
            }
        }
        rectd.sort();
        return rectd;
    }

    private void computeLayout(boolean flag, Rect rect)
    {
        if (flag)
        {
            adjustCropRect(mCropRect);
            tmpRect2.set(0.0D, 0.0D, mParentWidth, mParentHeight);
            mCropRect = adjustRealCropRect(mMatrix, mCropRect, tmpRect2);
        }
        getDisplayRect(mMatrix, mCropRect, rect);
    }

    public void animateTo(final View parent, final Matrix anim1, final RectD anim2, final RectD anim3, final boolean maintainAspectRatio)
    {
        if (!mRunning)
        {
            mRunning = true;
            setMode(Mode.None, 1);
            parent.postInvalidate();
            mMatrix = new Matrix(anim1);
            mCropRect = anim3;
            mImageRect = new RectD(anim2);
            mMaintainAspectRatio = false;
            mInitialAspectRatio = mCropRect.width() / mCropRect.height();
            final ValueAnimator anim4 = mDrawRect;
            Object obj = new Rect();
            computeLayout(false, ((Rect) (obj)));
            anim1 = ValueAnimator.ofInt(new int[] {
                ((Rect) (anim4)).left, ((Rect) (obj)).left
            });
            anim2 = ValueAnimator.ofInt(new int[] {
                ((Rect) (anim4)).right, ((Rect) (obj)).right
            });
            anim3 = ValueAnimator.ofInt(new int[] {
                ((Rect) (anim4)).top, ((Rect) (obj)).top
            });
            anim4 = ValueAnimator.ofInt(new int[] {
                ((Rect) (anim4)).bottom, ((Rect) (obj)).bottom
            });
            anim4.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

                final HighlightView this$0;
                final ValueAnimator val$anim1;
                final ValueAnimator val$anim2;
                final ValueAnimator val$anim3;
                final ValueAnimator val$anim4;
                final View val$parent;

                public void onAnimationUpdate(ValueAnimator valueanimator)
                {
                    int i = ((Integer)anim1.getAnimatedValue()).intValue();
                    int j = ((Integer)anim2.getAnimatedValue()).intValue();
                    int k = ((Integer)anim3.getAnimatedValue()).intValue();
                    int l = ((Integer)anim4.getAnimatedValue()).intValue();
                    mDrawRect.left = i;
                    mDrawRect.right = j;
                    mDrawRect.top = k;
                    mDrawRect.bottom = l;
                    parent.invalidate();
                }

            
            {
                this$0 = HighlightView.this;
                anim1 = valueanimator;
                anim2 = valueanimator1;
                anim3 = valueanimator2;
                anim4 = valueanimator3;
                parent = view;
                super();
            }
            });
            obj = new AnimatorSet();
            ((AnimatorSet) (obj)).playTogether(new Animator[] {
                anim1, anim2, anim3, anim4
            });
            ((AnimatorSet) (obj)).setDuration(animationDurationMs);
            ((AnimatorSet) (obj)).setInterpolator(new ExpoInterpolator(com.aviary.android.feather.library.graphics.animation.EasingType.Type.INOUT));
            ((AnimatorSet) (obj)).addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

                final HighlightView this$0;
                final boolean val$maintainAspectRatio;
                final View val$parent;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    mMaintainAspectRatio = maintainAspectRatio;
                    mRunning = false;
                    invalidate();
                    if (parent != null)
                    {
                        parent.postInvalidate();
                    }
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = HighlightView.this;
                maintainAspectRatio = flag;
                parent = view;
                super();
            }
            });
            ((AnimatorSet) (obj)).start();
        }
    }

    double calculateDx(double d, double d1)
    {
        double d2 = d1;
        if (d != 0.0D)
        {
            d2 = d * mInitialAspectRatio;
            d = d2;
            if (d1 != 0.0D)
            {
                if (d1 > 0.0D)
                {
                    d = Math.abs(d2);
                } else
                {
                    d = Math.abs(d2) * -1D;
                }
            }
            d2 = d;
        }
        return d2;
    }

    double calculateDy(double d, double d1)
    {
        double d2 = d1;
        if (d != 0.0D)
        {
            d2 = d / mInitialAspectRatio;
            d = d2;
            if (d1 != 0.0D)
            {
                if (d1 > 0.0D)
                {
                    d = Math.abs(d2);
                } else
                {
                    d = Math.abs(d2) * -1D;
                }
            }
            d2 = d;
        }
        return d2;
    }

    public void dispose()
    {
    }

    protected void draw(Canvas canvas)
    {
        if (!mHidden)
        {
            mPath.reset();
            mInversePath.reset();
            mLinesPath.reset();
            tmpDrawRectF.set(mDrawRect);
            tmpDrawRect2F.set(mViewDrawingRect);
            mInversePath.addRect(tmpDrawRect2F, android.graphics.Path.Direction.CW);
            mInversePath.addRect(tmpDrawRectF, android.graphics.Path.Direction.CCW);
            tmpDrawRectF.set(mDrawRect);
            mPath.addRect(tmpDrawRectF, android.graphics.Path.Direction.CW);
            tmpDrawRect2F.set(mDrawRect);
            mLinesPath.addRect(tmpDrawRect2F, android.graphics.Path.Direction.CW);
            float f = (float)mDrawRect.height() / 3F;
            float f1 = (float)mDrawRect.width() / 3F;
            for (int i = 1; i < 3; i++)
            {
                mLinesPath.moveTo(mDrawRect.left, (int)((float)mDrawRect.top + (float)i * f));
                mLinesPath.lineTo(mDrawRect.right, (int)((float)mDrawRect.top + (float)i * f));
            }

            for (int j = 1; j < 3; j++)
            {
                mLinesPath.moveTo((int)((float)mDrawRect.left + (float)j * f1), mDrawRect.top);
                mLinesPath.lineTo((int)((float)mDrawRect.left + (float)j * f1), mDrawRect.bottom);
            }

            canvas.drawPath(mInversePath, mOutlineFill);
            canvas.drawPath(mLinesPath, mOutlinePaint2);
            canvas.drawPath(mPath, mOutlinePaint);
            int k = mDrawRect.left + 1;
            int l = mDrawRect.right + 1;
            int i1 = mDrawRect.top + 4;
            int j1 = mDrawRect.bottom + 3;
            if (mKnobDrawableTopLeft != null)
            {
                mKnobDrawableTopLeft.setBounds(k - dWidth, i1 - dHeight, dWidth + k, dHeight + i1);
                mKnobDrawableTopLeft.draw(canvas);
                mKnobDrawableTopRight.setBounds(l - dWidth, i1 - dHeight, dWidth + l, dHeight + i1);
                mKnobDrawableTopRight.draw(canvas);
                mKnobDrawableBottomLeft.setBounds(k - dWidth, j1 - dHeight, dWidth + k, dHeight + j1);
                mKnobDrawableBottomLeft.draw(canvas);
                mKnobDrawableBottomRight.setBounds(l - dWidth, j1 - dHeight, dWidth + l, dHeight + j1);
                mKnobDrawableBottomRight.draw(canvas);
                return;
            }
        }
    }

    public Rect getCropRect()
    {
        return new Rect((int)mCropRect.left, (int)mCropRect.top, (int)mCropRect.right, (int)mCropRect.bottom);
    }

    public RectD getCropRectD()
    {
        return mCropRect;
    }

    public void getDisplayRect(Matrix matrix, RectD rectd, Rect rect)
    {
        tmpDisplayRectF.set((float)rectd.left, (float)rectd.top, (float)rectd.right, (float)rectd.bottom);
        matrix.mapRect(tmpDisplayRectF);
        rect.set(Math.round(tmpDisplayRectF.left), Math.round(tmpDisplayRectF.top), Math.round(tmpDisplayRectF.right), Math.round(tmpDisplayRectF.bottom));
    }

    public Rect getDrawRect()
    {
        return mDrawRect;
    }

    public int getHit(float f, float f1)
    {
        Rect rect = new Rect();
        computeLayout(false, rect);
        int j = 1;
        int i;
        boolean flag;
        boolean flag1;
        if (f1 >= (float)rect.top - 30F && f1 < (float)rect.bottom + 30F)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (f >= (float)rect.left - 30F && f < (float)rect.right + 30F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = j;
        if (Math.abs((float)rect.left - f) < 30F)
        {
            i = j;
            if (flag1)
            {
                i = 1 | 2;
            }
        }
        j = i;
        if (Math.abs((float)rect.right - f) < 30F)
        {
            j = i;
            if (flag1)
            {
                j = i | 4;
            }
        }
        i = j;
        if (Math.abs((float)rect.top - f1) < 30F)
        {
            i = j;
            if (flag)
            {
                i = j | 8;
            }
        }
        j = i;
        if (Math.abs((float)rect.bottom - f1) < 30F)
        {
            j = i;
            if (flag)
            {
                j = i | 0x10;
            }
        }
        i = j;
        if (j == 1)
        {
            i = j;
            if (rect.contains((int)f, (int)f1))
            {
                i = 32;
            }
        }
        return i;
    }

    public Rect getInvalidateRect()
    {
        return tmpRectMotion;
    }

    public Matrix getMatrix()
    {
        return mMatrix;
    }

    protected float getScale()
    {
        float af[] = new float[9];
        mMatrix.getValues(af);
        return af[0];
    }

    void growWithConstantAspectSize(int i, double d, double d1)
    {
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag1 = isLeftEdge(i);
        flag2 = isRightEdge(i);
        flag3 = isTopEdge(i);
        flag4 = isBottomEdge(i);
        double d2;
        RectD rectd;
        boolean flag;
        if (flag1 || flag2)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (flag3 || flag4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i == 0 || !flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d2 = (double)mMinSize / (double)getScale();
        tmpRectMotionD.set(mCropRect);
        if (!flag) goto _L2; else goto _L1
_L1:
        if (i == 0) goto _L4; else goto _L3
_L3:
        d1 = calculateDy(d, 0.0D);
        if (flag1)
        {
            rectd = tmpRectMotionD;
            rectd.left = rectd.left + d;
            tmpRectMotionD.inset(0.0D, d1 / 2D);
        } else
        {
            RectD rectd1 = tmpRectMotionD;
            rectd1.right = rectd1.right + d;
            tmpRectMotionD.inset(0.0D, -d1 / 2D);
        }
_L6:
        if (tmpRectMotionD.width() >= d2 && tmpRectMotionD.height() >= d2 && mImageRect.contains(tmpRectMotionD))
        {
            mCropRect.set(tmpRectMotionD);
        }
        computeLayout(true, mDrawRect);
        return;
_L4:
        d = calculateDx(d1, 0.0D);
        if (flag3)
        {
            RectD rectd2 = tmpRectMotionD;
            rectd2.top = rectd2.top + d1;
            tmpRectMotionD.inset(d / 2D, 0.0D);
        } else
        if (flag4)
        {
            RectD rectd3 = tmpRectMotionD;
            rectd3.bottom = rectd3.bottom + d1;
            tmpRectMotionD.inset(-d / 2D, 0.0D);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        d1 = calculateDy(d, 0.0D);
        if (flag1 && flag3)
        {
            RectD rectd4 = tmpRectMotionD;
            rectd4.left = rectd4.left + d;
            rectd4 = tmpRectMotionD;
            rectd4.top = rectd4.top + d1;
        } else
        if (flag1 && flag4)
        {
            RectD rectd5 = tmpRectMotionD;
            rectd5.left = rectd5.left + d;
            rectd5 = tmpRectMotionD;
            rectd5.bottom = rectd5.bottom - d1;
        } else
        if (flag2 && flag3)
        {
            RectD rectd6 = tmpRectMotionD;
            rectd6.right = rectd6.right + d;
            rectd6 = tmpRectMotionD;
            rectd6.top = rectd6.top - d1;
        } else
        if (flag2 && flag4)
        {
            RectD rectd7 = tmpRectMotionD;
            rectd7.right = rectd7.right + d;
            rectd7 = tmpRectMotionD;
            rectd7.bottom = rectd7.bottom + d1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    void growWithoutConstantAspectSize(int i, double d, double d1)
    {
        boolean flag1 = isLeftEdge(i);
        boolean flag2 = isRightEdge(i);
        boolean flag3 = isTopEdge(i);
        boolean flag4 = isBottomEdge(i);
        double d2;
        boolean flag;
        if (flag1 || flag2)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (flag3 || flag4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d2 = (double)mMinSize / (double)getScale();
        tmpRectMotionD.set(mCropRect);
        if (i != 0)
        {
            if (flag1)
            {
                RectD rectd = tmpRectMotionD;
                rectd.left = rectd.left + d;
                if (!flag)
                {
                    tmpRectMotionD.inset(0.0D, d1 / 2D);
                }
            } else
            if (flag2)
            {
                RectD rectd2 = tmpRectMotionD;
                rectd2.right = rectd2.right + d;
                if (!flag)
                {
                    tmpRectMotionD.inset(0.0D, -d1 / 2D);
                }
            }
        }
        if (flag)
        {
            if (flag3)
            {
                RectD rectd1 = tmpRectMotionD;
                rectd1.top = rectd1.top + d1;
                if (i == 0)
                {
                    tmpRectMotionD.inset(d / 2D, 0.0D);
                }
            } else
            if (flag4)
            {
                RectD rectd3 = tmpRectMotionD;
                rectd3.bottom = rectd3.bottom + d1;
                if (i == 0)
                {
                    tmpRectMotionD.inset(-d / 2D, 0.0D);
                }
            }
        }
        if (tmpRectMotionD.width() >= d2 && tmpRectMotionD.height() >= d2 && mImageRect.contains(tmpRectMotionD))
        {
            mCropRect.set(tmpRectMotionD);
        }
        computeLayout(true, mDrawRect);
    }

    void handleMotion(int i, float f, float f1)
    {
        if (!mRunning)
        {
            computeLayout(false, tmpRect4);
            if (i != 1)
            {
                if (i == 32)
                {
                    moveBy((double)f * (mCropRect.width() / (double)tmpRect4.width()), (double)f1 * (mCropRect.height() / (double)tmpRect4.height()));
                    return;
                }
                if ((i & 6) == 0)
                {
                    f = 0.0F;
                }
                if ((i & 0x18) == 0)
                {
                    f1 = 0.0F;
                }
                double d = Math.round((double)f * (mCropRect.width() / (double)tmpRect4.width()));
                double d1 = Math.round((double)f1 * (mCropRect.height() / (double)tmpRect4.height()));
                if (mMaintainAspectRatio)
                {
                    growWithConstantAspectSize(i, d, d1);
                    return;
                } else
                {
                    growWithoutConstantAspectSize(i, d, d1);
                    return;
                }
            }
        }
    }

    public void invalidate()
    {
        if (!mRunning)
        {
            computeLayout(true, mDrawRect);
        }
    }

    boolean isBottomEdge(int i)
    {
        return (i & 0x10) == 16;
    }

    boolean isLeftEdge(int i)
    {
        return (i & 2) == 2;
    }

    boolean isRightEdge(int i)
    {
        return (i & 4) == 4;
    }

    public boolean isRunning()
    {
        return mRunning;
    }

    boolean isTopEdge(int i)
    {
        return (i & 8) == 8;
    }

    void moveBy(double d, double d1)
    {
        moveBy((float)d, (float)d1);
    }

    void moveBy(float f, float f1)
    {
        tmpRectMotion.set(mDrawRect);
        mCropRect.offset(f, f1);
        mCropRect.offset(Math.max(0.0D, mImageRect.left - mCropRect.left), Math.max(0.0D, mImageRect.top - mCropRect.top));
        mCropRect.offset(Math.min(0.0D, mImageRect.right - mCropRect.right), Math.min(0.0D, mImageRect.bottom - mCropRect.bottom));
        computeLayout(false, mDrawRect);
        tmpRectMotion.union(mDrawRect);
        tmpRectMotion.inset(-dWidth * 2, -dHeight * 2);
    }

    public void onSizeChanged(CropImageView cropimageview, int i, int j, int k, int l)
    {
        cropimageview.getDrawingRect(mViewDrawingRect);
        mParentWidth = i;
        mParentHeight = j;
    }

    public void setAspectRatio(double d)
    {
        mInitialAspectRatio = d;
    }

    public void setHidden(boolean flag)
    {
        mHidden = flag;
    }

    public void setMaintainAspectRatio(boolean flag)
    {
        mMaintainAspectRatio = flag;
    }

    public void setMinSize(int i)
    {
        mMinSize = i;
    }

    public void setMode(Mode mode, int i)
    {
label0:
        {
            if (mode != mMode)
            {
                mMode = mode;
                mode = mOutlinePaint;
                int j;
                if (mMode == Mode.None)
                {
                    j = mStrokeColor;
                } else
                {
                    j = mStrokeColorPressed;
                }
                mode.setColor(j);
                mode = mOutlinePaint2;
                if (mMode == Mode.None)
                {
                    j = mInternalStrokeColor;
                } else
                {
                    j = mInternalStrokeColorPressed;
                }
                mode.setColor(j);
                mode = mLinesPaintShadow;
                if (mMode == Mode.None)
                {
                    j = 102;
                } else
                {
                    j = 0;
                }
                mode.setAlpha(j);
                mode = mOutlineFill;
                if (mMode == Mode.None)
                {
                    j = mOutsideFillColor;
                } else
                {
                    j = mOutsideFillColorPressed;
                }
                mode.setColor(j);
                mKnobDrawableBottomRight.setState(DrawableHighlightView.STATE_SET_NONE);
                mKnobDrawableBottomLeft.setState(DrawableHighlightView.STATE_SET_NONE);
                mKnobDrawableTopLeft.setState(DrawableHighlightView.STATE_SET_NONE);
                mKnobDrawableTopRight.setState(DrawableHighlightView.STATE_SET_NONE);
                if (i != 1 && i != 32)
                {
                    break label0;
                }
            }
            return;
        }
        if ((i & 2) == 2)
        {
            if ((i & 8) == 8)
            {
                mKnobDrawableTopLeft.setState(DrawableHighlightView.STATE_SET_SELECTED_PRESSED);
                return;
            } else
            {
                mKnobDrawableBottomLeft.setState(DrawableHighlightView.STATE_SET_SELECTED_PRESSED);
                return;
            }
        }
        if ((i & 8) == 8)
        {
            mKnobDrawableTopRight.setState(DrawableHighlightView.STATE_SET_SELECTED_PRESSED);
            return;
        } else
        {
            mKnobDrawableBottomRight.setState(DrawableHighlightView.STATE_SET_SELECTED_PRESSED);
            return;
        }
    }

    public void setup(Matrix matrix, RectD rectd, RectD rectd1, boolean flag)
    {
        mMatrix = new Matrix(matrix);
        mCropRect = rectd1;
        mImageRect = new RectD(rectd);
        mMaintainAspectRatio = flag;
        mInitialAspectRatio = mCropRect.width() / mCropRect.height();
        computeLayout(true, mDrawRect);
        mOutlinePaint.setStrokeWidth(mStrokeWidth);
        mOutlinePaint.setStyle(android.graphics.Paint.Style.STROKE);
        mOutlinePaint.setAntiAlias(false);
        try
        {
            ReflectionUtils.invokeMethod(mOutlinePaint, "setHinting", new Class[] {
                Integer.TYPE
            }, new Object[] {
                Integer.valueOf(0)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Matrix matrix) { }
        mOutlinePaint2.setStrokeWidth(mStrokeWidth2);
        mOutlinePaint2.setStyle(android.graphics.Paint.Style.STROKE);
        mOutlinePaint2.setAntiAlias(false);
        mOutlinePaint2.setColor(mInternalStrokeColor);
        try
        {
            ReflectionUtils.invokeMethod(mOutlinePaint2, "setHinting", new Class[] {
                Integer.TYPE
            }, new Object[] {
                Integer.valueOf(0)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Matrix matrix) { }
        mOutlineFill.setColor(mOutsideFillColor);
        mOutlineFill.setStyle(android.graphics.Paint.Style.FILL);
        mOutlineFill.setAntiAlias(false);
        mOutlineFill.setDither(true);
        try
        {
            ReflectionUtils.invokeMethod(mOutlineFill, "setHinting", new Class[] {
                Integer.TYPE
            }, new Object[] {
                Integer.valueOf(0)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Matrix matrix) { }
        mLinesPaintShadow.setStrokeWidth(mStrokeWidth2);
        mLinesPaintShadow.setAntiAlias(true);
        mLinesPaintShadow.setColor(0xff000000);
        mLinesPaintShadow.setStyle(android.graphics.Paint.Style.STROKE);
        mLinesPaintShadow.setMaskFilter(new BlurMaskFilter(2.0F, android.graphics.BlurMaskFilter.Blur.NORMAL));
        setMode(Mode.None, 1);
    }

    public void update(Matrix matrix, Rect rect)
    {
        mMatrix = new Matrix(matrix);
        mImageRect = new RectD(rect);
        computeLayout(true, mDrawRect);
    }




/*
    static boolean access$102(HighlightView highlightview, boolean flag)
    {
        highlightview.mMaintainAspectRatio = flag;
        return flag;
    }

*/
}
