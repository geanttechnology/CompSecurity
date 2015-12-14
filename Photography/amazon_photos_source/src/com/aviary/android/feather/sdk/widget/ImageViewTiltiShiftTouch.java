// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.aviary.android.feather.library.graphics.CircleF;
import com.aviary.android.feather.library.graphics.LineF;
import com.aviary.android.feather.library.graphics.Point2D;
import com.aviary.android.feather.library.graphics.animation.ExpoInterpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PointCloud

public class ImageViewTiltiShiftTouch extends ImageViewTouch
{
    public static interface OnTiltShiftDrawListener
    {

        public abstract void onDrawEnd();

        public abstract void onDrawStart(float af[], TiltShiftDrawMode tiltshiftdrawmode, float f, float f1, float f2, float f3, float f4, 
                float f5);

        public abstract void onDrawing(float af[], float f, float f1, float f2, float f3, float f4, float f5);
    }

    public static final class TiltShiftDrawMode extends Enum
    {

        private static final TiltShiftDrawMode $VALUES[];
        public static final TiltShiftDrawMode Linear;
        public static final TiltShiftDrawMode None;
        public static final TiltShiftDrawMode Radial;

        public static TiltShiftDrawMode valueOf(String s)
        {
            return (TiltShiftDrawMode)Enum.valueOf(com/aviary/android/feather/sdk/widget/ImageViewTiltiShiftTouch$TiltShiftDrawMode, s);
        }

        public static TiltShiftDrawMode[] values()
        {
            return (TiltShiftDrawMode[])$VALUES.clone();
        }

        static 
        {
            Radial = new TiltShiftDrawMode("Radial", 0);
            Linear = new TiltShiftDrawMode("Linear", 1);
            None = new TiltShiftDrawMode("None", 2);
            $VALUES = (new TiltShiftDrawMode[] {
                Radial, Linear, None
            });
        }

        private TiltShiftDrawMode(String s, int i)
        {
            super(s, i);
        }
    }


    private static final float BRUSH_MULTIPLIER = 2.5F;
    public static final double CLOUD_INNER_RADIUS_RATIO = 2.5D;
    private static final int DEFAULT_FADEOUT_TIMEOUT = 1000;
    public static final float DEFAULT_SIZE_RATIO = 0.35F;
    public static final int INVALID_POINTER_ID = -1;
    LineF firstLine;
    int mActivePointerId;
    int mActivePointerIndex;
    private ObjectAnimator mAnimator;
    int mBackColor;
    protected int mBackPaintAlpha;
    protected int mBackPaintAlphaDefault;
    private RectF mBitmapRect;
    private float mBitmapRectSideLength;
    private Matrix mCenterMatrix;
    private PointF mCenterPoint;
    protected boolean mCrossEnabled;
    protected Paint mCrossPaint;
    private Path mCrossPath;
    private float mCurrentAngle;
    private float mCurrentDistance;
    protected float mCurrentScale;
    private int mDefaultShapeSize;
    private OnTiltShiftDrawListener mDrawListener;
    private CircleF mDrawingCircle;
    private Matrix mDrawingMatrix;
    private RectF mDrawingRect;
    private float mDrawingRectLength;
    private AnimatorSet mFadeAnimator;
    protected long mFadeOutDuration;
    protected int mFadeOutTimeout;
    private PointF mFirstPointOriginal;
    int mForeColor;
    protected Matrix mIdentityMatrix;
    private boolean mInitializedTouch;
    protected Matrix mInvertedMatrix;
    private int mMaxShapeSize;
    private int mMinShapeSize;
    private float mMinShapeSizePixels;
    float mOldAngle;
    PointF mOldCenter;
    float mOldDistance;
    protected Paint mPaint;
    protected int mPaintAlpha;
    protected int mPaintAlphaDefault;
    private Path mPath;
    private PointCloud mPointCloud;
    private boolean mPointCloudEnabled;
    private float mPointCloudOuterRadius;
    private float mPointCluodInnerRadius;
    private int mPointWaveDuration;
    private float mPoints[];
    private PointF mSecondPointOriginal;
    private RectF mShapeRect;
    private RectF mShapeRectInverted;
    private RectF mThisRectF;
    private TiltShiftDrawMode mTiltShiftDrawMode;
    LineF secondLine;

    public ImageViewTiltiShiftTouch(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, com.aviary.android.feather.sdk.R.attr.aviaryTiltShiftViewStyle);
    }

    public ImageViewTiltiShiftTouch(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mFadeOutTimeout = 1000;
        mPaintAlpha = 200;
        mPaintAlphaDefault = mPaintAlpha;
        mBackPaintAlpha = 80;
        mBackPaintAlphaDefault = mBackPaintAlpha;
        mFadeOutDuration = 200L;
        mCurrentScale = 1.0F;
        mIdentityMatrix = new Matrix();
        mInvertedMatrix = new Matrix();
        mForeColor = -1;
        mBackColor = 0xff000000;
        mOldCenter = new PointF();
        mOldDistance = 0.0F;
        mOldAngle = 0.0F;
        firstLine = new LineF(0.0F, 0.0F, 0.0F, 0.0F);
        secondLine = new LineF(0.0F, 0.0F, 0.0F, 0.0F);
        mTiltShiftDrawMode = TiltShiftDrawMode.None;
        mMinShapeSizePixels = 40F;
        mPoints = new float[8];
    }

    private void checkLimits()
    {
        if (mBitmapRect != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (mCurrentDistance > (mBitmapRectSideLength / 100F) * (float)mMaxShapeSize)
        {
            mCurrentDistance = (mBitmapRectSideLength / 100F) * (float)mMaxShapeSize;
        }
        if (mBitmapRect.contains(mCenterPoint.x, mCenterPoint.y)) goto _L1; else goto _L3
_L3:
        if (mCenterPoint.x <= mBitmapRect.right) goto _L5; else goto _L4
_L4:
        mCenterPoint.x = mBitmapRect.right;
_L7:
        if (mCenterPoint.y > mBitmapRect.bottom)
        {
            mCenterPoint.y = mBitmapRect.bottom;
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        if (mCenterPoint.x < mBitmapRect.left)
        {
            mCenterPoint.x = mBitmapRect.left;
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (mCenterPoint.y >= mBitmapRect.top) goto _L1; else goto _L8
_L8:
        mCenterPoint.y = mBitmapRect.top;
        return;
    }

    public static float[] getMatrixValues(Matrix matrix)
    {
        float af[] = new float[9];
        matrix.getValues(af);
        return af;
    }

    private void initializeTouch(float f, float f1, float f2, float f3)
    {
        mInitializedTouch = true;
        mFirstPointOriginal = new PointF(f, f1);
        mSecondPointOriginal = new PointF(f2, f3);
        Point2D.getLerp(mFirstPointOriginal, mSecondPointOriginal, 0.5F, mCenterPoint);
        mCurrentDistance = (float)Math.max(mMinShapeSizePixels, Point2D.distance(mFirstPointOriginal, mSecondPointOriginal));
        mCurrentAngle = (float)(-Point2D.angleBetweenPoints(mFirstPointOriginal, mSecondPointOriginal)) + 90F;
        if (mPointCloud != null && mPointCloudEnabled)
        {
            PointCloud.WaveManager wavemanager = mPointCloud.waveManager;
            PointCloud.WaveType wavetype;
            if (mTiltShiftDrawMode == TiltShiftDrawMode.Radial)
            {
                wavetype = PointCloud.WaveType.Circle;
            } else
            {
                wavetype = PointCloud.WaveType.Line;
            }
            wavemanager.setType(wavetype);
            mPointCloud.waveManager.setAlpha(0.0F);
            mPointCloud.setCenter(mCenterPoint.x, mCenterPoint.y);
            mPointCloud.setRotation(mCurrentAngle);
            f = (float)((double)mCurrentDistance / 2.5D);
            if (mPointCloudEnabled)
            {
                if (mAnimator != null)
                {
                    mAnimator.cancel();
                }
                mAnimator.setFloatValues(new float[] {
                    f, mPointCloudOuterRadius + 100F
                });
                mAnimator.start();
            }
        }
    }

    private void onTouchDown()
    {
        fadeInShape();
    }

    private void onTouchMove(PointF pointf, float f, float f1, boolean flag)
    {
        if (mBitmapRect != null)
        {
            mPath.reset();
            mCenterMatrix.setTranslate(pointf.x, pointf.y);
            f /= 2.0F;
            if (mTiltShiftDrawMode == TiltShiftDrawMode.Radial)
            {
                mDrawingCircle.set(pointf.x, pointf.y, f);
                mPath.addCircle(mDrawingCircle.centerX(), mDrawingCircle.centerY(), mDrawingCircle.getRadius(), android.graphics.Path.Direction.CW);
                mShapeRect.set(pointf.x - 2.5F * f, pointf.y - 2.5F * f, pointf.x + 2.5F * f, pointf.y + 2.5F * f);
            } else
            if (mTiltShiftDrawMode == TiltShiftDrawMode.Linear)
            {
                mDrawingMatrix.setRotate(f1, pointf.x, pointf.y);
                mDrawingRect.set(pointf.x - f, pointf.y - mDrawingRectLength / 2.0F, pointf.x + f, pointf.y + mDrawingRectLength / 2.0F);
                mDrawingRect.sort();
                mPoints[0] = mDrawingRect.left;
                mPoints[1] = mDrawingRect.top;
                mPoints[2] = mDrawingRect.left;
                mPoints[3] = mDrawingRect.bottom;
                mPoints[4] = mDrawingRect.right;
                mPoints[5] = mDrawingRect.bottom;
                mPoints[6] = mDrawingRect.right;
                mPoints[7] = mDrawingRect.top;
                mDrawingMatrix.mapPoints(mPoints);
                firstLine.reset();
                secondLine.reset();
                firstLine.set(mPoints[0], mPoints[1], mPoints[2], mPoints[3]);
                secondLine.set(mPoints[4], mPoints[5], mPoints[6], mPoints[7]);
                Object obj = null;
                PointF apointf[] = firstLine.intersect(mThisRectF);
                af = ((float []) (obj));
                if (apointf != null)
                {
                    af = ((float []) (obj));
                    if (apointf.length == 2)
                    {
                        mPath.moveTo(apointf[0].x, apointf[0].y);
                        mPath.lineTo(apointf[1].x, apointf[1].y);
                        af = new RectF(apointf[0].x, apointf[0].y, apointf[1].x, apointf[1].y);
                        af.sort();
                    }
                }
                apointf = secondLine.intersect(mThisRectF);
                obj = af;
                if (apointf != null)
                {
                    obj = af;
                    if (apointf.length == 2)
                    {
                        mPath.moveTo(apointf[0].x, apointf[0].y);
                        mPath.lineTo(apointf[1].x, apointf[1].y);
                        obj = new RectF(apointf[0].x, apointf[0].y, apointf[1].x, apointf[1].y);
                        ((RectF) (obj)).sort();
                        if (af != null)
                        {
                            if (af.isEmpty())
                            {
                                af.set(((RectF) (af)).left, ((RectF) (af)).top, ((RectF) (obj)).right, ((RectF) (obj)).bottom);
                                af.sort();
                                obj = af;
                            } else
                            {
                                af.union(((RectF) (obj)));
                                obj = af;
                            }
                        }
                    }
                }
                if (obj != null)
                {
                    Point2D.grow(((RectF) (obj)), 2.5F * f, 2.5F * f);
                    mShapeRect.set(((RectF) (obj)));
                } else
                {
                    mShapeRect.set(mBitmapRect);
                }
            }
            if (mDrawListener != null)
            {
                float af[] = new float[2];
                af[0] = pointf.x;
                af[1] = pointf.y;
                mInvertedMatrix.mapPoints(af);
                mInvertedMatrix.mapRect(mShapeRectInverted, mShapeRect);
                if (flag)
                {
                    mDrawListener.onDrawStart(af, mTiltShiftDrawMode, f / mCurrentScale, -f1 - 90F, mShapeRectInverted.left, mShapeRectInverted.top, mShapeRectInverted.right, mShapeRectInverted.bottom);
                    return;
                } else
                {
                    mDrawListener.onDrawing(af, f / mCurrentScale, -f1 - 90F, mShapeRectInverted.left, mShapeRectInverted.top, mShapeRectInverted.right, mShapeRectInverted.bottom);
                    return;
                }
            }
        }
    }

    private void onTouchUp()
    {
        fadeOutShape(mFadeOutTimeout);
        if (mDrawListener != null)
        {
            mDrawListener.onDrawEnd();
        }
    }

    private void resetWave(RectF rectf)
    {
        if (mPointCloud != null && mPointCloudEnabled)
        {
            mPointCloud.makePointCloud(mPointCluodInnerRadius, mPointCloudOuterRadius, rectf);
        }
    }

    private void updateBitmapRect()
    {
        Matrix matrix = new Matrix(getImageMatrix());
        mInvertedMatrix.reset();
        float af[] = getMatrixValues(matrix);
        matrix.invert(matrix);
        float af1[] = getMatrixValues(matrix);
        mInvertedMatrix.postTranslate(-af[2], -af[5]);
        mInvertedMatrix.postScale(af1[0], af1[4]);
        mCurrentScale = getScale();
        RectF rectf = getBitmapRect();
        boolean flag1;
        if (mBitmapRect == null && rectf != null || mBitmapRect != null && !mBitmapRect.equals(rectf))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (rectf != null)
        {
            boolean flag2 = false;
            if (mBitmapRect != null)
            {
                double d = Point2D.hypotenuse(mBitmapRect);
                double d1 = Point2D.hypotenuse(rectf);
                float f = mBitmapRect.left;
                float f1 = mBitmapRect.top;
                float f3 = mBitmapRect.width();
                float f2 = mBitmapRect.height();
                f3 = rectf.width() / f3;
                f2 = rectf.height() / f2;
                boolean flag;
                if (!mBitmapRect.equals(rectf))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag2 = flag;
                if (flag)
                {
                    mCurrentDistance = (float)((double)mCurrentDistance * (d1 / d));
                    mCenterPoint.offset(-f, -f1);
                    PointF pointf = mCenterPoint;
                    pointf.x = pointf.x * f3;
                    pointf = mCenterPoint;
                    pointf.y = pointf.y * f2;
                    pointf = mCenterPoint;
                    pointf.x = pointf.x + rectf.left;
                    pointf = mCenterPoint;
                    pointf.y = pointf.y + rectf.top;
                    flag2 = flag;
                }
            }
            mBitmapRect = new RectF(rectf);
            mBitmapRectSideLength = Math.max(mBitmapRect.width(), mBitmapRect.height());
            mDrawingRectLength = (float)Math.sqrt(Math.pow(mBitmapRect.width(), 2D) + Math.pow(mBitmapRect.height(), 2D));
            mDrawingRectLength = mBitmapRectSideLength * 1000F;
            mMinShapeSizePixels = (mBitmapRectSideLength / 100F) * (float)mMinShapeSize;
            if (flag2)
            {
                onTouchDown();
                onTouchMove(mCenterPoint, mCurrentDistance, mCurrentAngle, true);
                onTouchUp();
            }
        } else
        {
            mBitmapRect = null;
        }
        if (flag1 && mPointCloudEnabled)
        {
            resetWave(mBitmapRect);
        }
    }

    protected void fadeInShape()
    {
        if (mFadeAnimator != null)
        {
            mFadeAnimator.cancel();
            mPaintAlpha = mPaintAlphaDefault;
            mBackPaintAlpha = mBackPaintAlphaDefault;
            postInvalidate();
        }
    }

    protected void fadeOutShape(long l)
    {
        ObjectAnimator objectanimator;
        ObjectAnimator objectanimator1;
        if (mFadeAnimator != null)
        {
            mFadeAnimator.cancel();
        } else
        {
            mFadeAnimator = new AnimatorSet();
        }
        objectanimator = ObjectAnimator.ofInt(this, "paintAlpha", new int[] {
            mPaintAlpha, 0
        });
        objectanimator1 = ObjectAnimator.ofInt(this, "backPaintAlpha", new int[] {
            mBackPaintAlpha, 0
        });
        mFadeAnimator.playTogether(new Animator[] {
            objectanimator, objectanimator1
        });
        mFadeAnimator.setDuration(mFadeOutDuration);
        mFadeAnimator.setStartDelay(l);
        mFadeAnimator.setInterpolator(new ExpoInterpolator(com.aviary.android.feather.library.graphics.animation.EasingType.Type.OUT));
        mFadeAnimator.start();
    }

    public int getBackPaintAlpha()
    {
        return mBackPaintAlpha;
    }

    public RectF getImageRect()
    {
        if (getDrawable() != null)
        {
            return new RectF(0.0F, 0.0F, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        } else
        {
            return null;
        }
    }

    public int getPaintAlpha()
    {
        return mPaintAlpha;
    }

    public TiltShiftDrawMode getTiltShiftDrawMode()
    {
        return mTiltShiftDrawMode;
    }

    protected void init(Context context, AttributeSet attributeset, int i)
    {
        super.init(context, attributeset, i);
        context = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView, i, 0);
        i = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_timeout, 1000);
        int j = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_animationDuration, 200);
        int k = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_strokeColor, 0);
        int l = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_strokeColor2, 0);
        int i1 = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_strokeWidth, 2);
        attributeset = context.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviaryWave_pointDrawable);
        int j1 = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_shape_maxsize, 100);
        int k1 = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_shape_minsize, 10);
        int l1 = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_shape_defaultsize, 100);
        int i2 = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_crosshair_edge, 6);
        int j2 = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_crosshair_radius, 12);
        int k2 = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviary_crosshair_strokeWidth, 2);
        mPointWaveDuration = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviaryWave_animationDuration, 2000);
        mPointCluodInnerRadius = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviaryWave_innerRadius, 10);
        mPointCloudOuterRadius = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviaryWave_outerRadius, 200);
        mCrossEnabled = context.getBoolean(com.aviary.android.feather.sdk.R.styleable.AviaryTiltShiftImageView_aviaryCrosshair_enabled, true);
        mPointCloudEnabled = true;
        context.recycle();
        mMinShapeSize = k1;
        mMaxShapeSize = j1;
        mDefaultShapeSize = l1;
        mForeColor = k;
        mBackColor = l;
        mPaint = new Paint(1);
        mPaint.setFilterBitmap(false);
        mPaint.setDither(true);
        mPaint.setColor(mForeColor);
        mPaint.setAlpha(mPaintAlphaDefault);
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPaint.setStrokeWidth(i1);
        mCrossPaint = new Paint(mPaint);
        mCrossPaint.setStrokeWidth(k2);
        mCrossPaint.setColor(mForeColor);
        mCrossPaint.setStrokeCap(android.graphics.Paint.Cap.SQUARE);
        setFadeoutTimeout(i);
        setFadeoutDuration(j);
        mPath = new Path();
        mCrossPath = new Path();
        mDrawingRect = new RectF();
        mDrawingMatrix = new Matrix();
        mCenterMatrix = new Matrix();
        mDrawingCircle = new CircleF();
        mCenterPoint = new PointF();
        mShapeRect = new RectF();
        mThisRectF = new RectF();
        mShapeRectInverted = new RectF();
        mInitializedTouch = false;
        setCrossHairSize(j2, i2);
        if (attributeset != null)
        {
            mPointCloud = new PointCloud(attributeset);
            mPointCloud.waveManager.setRadius(mPointCluodInnerRadius);
            mPointCloud.waveManager.setAlpha(0.0F);
        }
        mAnimator = ObjectAnimator.ofFloat(mPointCloud.waveManager, "radius", new float[] {
            0.0F, 100F
        });
        mAnimator.setDuration(mPointWaveDuration);
        mAnimator.setStartDelay(100L);
        mAnimator.setInterpolator(new ExpoInterpolator(com.aviary.android.feather.library.graphics.animation.EasingType.Type.OUT));
        mAnimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

            final ImageViewTiltiShiftTouch this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                if (mPointCloudEnabled)
                {
                    invalidate();
                }
            }

            
            {
                this$0 = ImageViewTiltiShiftTouch.this;
                super();
            }
        });
        mAnimator.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final ImageViewTiltiShiftTouch this$0;

            public void onAnimationCancel(Animator animator)
            {
                if (mPointCloudEnabled)
                {
                    mPointCloud.waveManager.setAlpha(0.0F);
                    invalidate();
                }
            }

            public void onAnimationEnd(Animator animator)
            {
                if (mPointCloudEnabled)
                {
                    mPointCloud.waveManager.setRadius(0.0F);
                    mPointCloud.waveManager.setAlpha(0.0F);
                    invalidate();
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
                if (mPointCloudEnabled)
                {
                    mPointCloud.waveManager.setRadius(((Float)mAnimator.getAnimatedValue()).floatValue());
                    mPointCloud.waveManager.setAlpha(1.0F);
                    invalidate();
                }
            }

            
            {
                this$0 = ImageViewTiltiShiftTouch.this;
                super();
            }
        });
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        break MISSING_BLOCK_LABEL_5;
        if (mBitmapRect != null && mTiltShiftDrawMode != TiltShiftDrawMode.None)
        {
            float f = mCrossPaint.getStrokeWidth();
            int i = canvas.save(1);
            canvas.concat(mCenterMatrix);
            if (mCrossEnabled)
            {
                mCrossPaint.setStrokeWidth(f * 2.0F);
                mCrossPaint.setColor(mBackColor);
                mCrossPaint.setAlpha(mBackPaintAlpha);
                canvas.drawPath(mCrossPath, mCrossPaint);
                mCrossPaint.setStrokeWidth(f);
                mCrossPaint.setColor(mForeColor);
                mCrossPaint.setAlpha(mPaintAlpha);
                canvas.drawPath(mCrossPath, mCrossPaint);
            }
            canvas.restoreToCount(i);
            f = mPaint.getStrokeWidth();
            mPaint.setStrokeWidth(f * 2.0F);
            mPaint.setColor(mBackColor);
            mPaint.setAlpha(mBackPaintAlpha);
            canvas.drawPath(mPath, mPaint);
            mPaint.setStrokeWidth(f);
            mPaint.setColor(mForeColor);
            mPaint.setAlpha(mPaintAlpha);
            canvas.drawPath(mPath, mPaint);
            if (mPointCloud != null && mPointCloudEnabled)
            {
                mPointCloud.draw(canvas);
                return;
            }
        }
        return;
    }

    protected void onDrawModeChanged()
    {
        mInitializedTouch = false;
        mFirstPointOriginal = null;
        mSecondPointOriginal = null;
        onTouchUp();
        updateBitmapRect();
        if (mBitmapRect != null)
        {
            float f = mBitmapRect.centerX();
            float f1 = mBitmapRect.centerY();
            float f2 = Math.min(mBitmapRect.width(), mBitmapRect.height());
            f2 = Math.min(mDefaultShapeSize, f2 * 0.35F);
            initializeTouch(f, f1 - f2 / 2.0F, f, f2 / 2.0F + f1);
            onTouchDown();
            onTouchMove(mCenterPoint, mCurrentDistance, mCurrentAngle, true);
            onTouchUp();
        }
        invalidate();
    }

    protected void onImageMatrixChanged()
    {
        super.onImageMatrixChanged();
        updateBitmapRect();
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        mThisRectF.set(0.0F, 0.0F, i, j);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        int k;
        k = motionevent.getAction();
        i = motionevent.getPointerCount();
        k & 0xff;
        JVM INSTR tableswitch 0 6: default 60
    //                   0 66
    //                   1 751
    //                   2 451
    //                   3 751
    //                   4 60
    //                   5 193
    //                   6 364;
           goto _L1 _L2 _L3 _L4 _L3 _L1 _L5 _L6
_L1:
        invalidate();
        return true;
_L2:
        onTouchDown();
        float f = motionevent.getX();
        float f4 = motionevent.getY();
        mActivePointerIndex = 0;
        mActivePointerId = motionevent.getPointerId(mActivePointerIndex);
        if (mFirstPointOriginal == null)
        {
            initializeTouch(f - mMinShapeSizePixels / 2.0F, f4 - mMinShapeSizePixels / 2.0F, mMinShapeSizePixels / 2.0F + f, mMinShapeSizePixels / 2.0F + f4);
            onTouchMove(mCenterPoint, mCurrentDistance, mCurrentAngle, true);
        } else
        {
            mFirstPointOriginal = new PointF(f, f4);
            onTouchMove(mCenterPoint, mCurrentDistance, mCurrentAngle, true);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (i > 1 && mInitializedTouch)
        {
            float f1 = motionevent.getX(mActivePointerIndex);
            float f5 = motionevent.getY(mActivePointerIndex);
            float f8;
            float f10;
            if (mActivePointerIndex == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            f8 = motionevent.getX(i);
            if (mActivePointerIndex == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            f10 = motionevent.getY(i);
            mFirstPointOriginal.set(f1, f5);
            mSecondPointOriginal.set(f8, f10);
            mOldDistance = (float)Point2D.distance(mFirstPointOriginal, mSecondPointOriginal);
            mOldAngle = (float)(-Point2D.angleBetweenPoints(mFirstPointOriginal, mSecondPointOriginal)) + 180F;
            mOldCenter = new PointF();
            Point2D.getLerp(mFirstPointOriginal, mSecondPointOriginal, 0.5F, mOldCenter);
            invalidate();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        i = (0xff00 & k) >> 8;
        if (motionevent.getPointerId(i) == mActivePointerId && mInitializedTouch)
        {
            float f2;
            float f6;
            if (i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            f2 = motionevent.getX(i);
            f6 = motionevent.getY(i);
            mActivePointerId = motionevent.getPointerId(i);
            mActivePointerIndex = i;
            mFirstPointOriginal.set(f2, f6);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int l = motionevent.findPointerIndex(mActivePointerId);
        float f3 = motionevent.getX(l);
        float f7 = motionevent.getY(l);
        float f9 = mFirstPointOriginal.x;
        float f11 = mFirstPointOriginal.y;
        mFirstPointOriginal.set(f3, f7);
        if (i > 1 && mInitializedTouch)
        {
            int j;
            if (l == 0)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            f3 = motionevent.getX(j);
            f7 = motionevent.getY(j);
            mSecondPointOriginal.set(f3, f7);
            motionevent = new PointF();
            Point2D.getLerp(mFirstPointOriginal, mSecondPointOriginal, 0.5F, motionevent);
            f3 = (float)Point2D.distance(mFirstPointOriginal, mSecondPointOriginal);
            f7 = (float)(-Point2D.angleBetweenPoints(mFirstPointOriginal, mSecondPointOriginal)) + 180F;
            f9 = mOldDistance;
            f11 = mOldAngle;
            mCurrentDistance = Math.max(mMinShapeSizePixels, Math.abs(mCurrentDistance + (f3 - f9)));
            mCurrentAngle = mCurrentAngle + (f7 - f11);
            mCenterPoint.offset(((PointF) (motionevent)).x - mOldCenter.x, ((PointF) (motionevent)).y - mOldCenter.y);
            mOldDistance = f3;
            mOldAngle = f7;
            mOldCenter.set(((PointF) (motionevent)).x, ((PointF) (motionevent)).y);
        } else
        {
            mCenterPoint.offset(f3 - f9, f7 - f11);
        }
        checkLimits();
        onTouchMove(mCenterPoint, mCurrentDistance, mCurrentAngle, false);
        continue; /* Loop/switch isn't completed */
_L3:
        mActivePointerId = -1;
        onTouchUp();
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void setBackPaintAlpha(int i)
    {
        mBackPaintAlpha = i;
        postInvalidate();
    }

    public void setCrossHairSize(int i, int j)
    {
        mCrossPath.reset();
        if (mCrossEnabled)
        {
            mCrossPath.addCircle(0.0F, 0.0F, i, android.graphics.Path.Direction.CW);
            mCrossPath.moveTo(-i, 0.0F);
            mCrossPath.lineTo(-i - j, 0.0F);
            mCrossPath.moveTo(i, 0.0F);
            mCrossPath.lineTo(i + j, 0.0F);
            mCrossPath.moveTo(0.0F, -i);
            mCrossPath.lineTo(0.0F, -i - j);
            mCrossPath.moveTo(0.0F, i);
            mCrossPath.lineTo(0.0F, i + j);
        }
    }

    public void setFadeoutDuration(int i)
    {
        mFadeOutDuration = i;
    }

    public void setFadeoutTimeout(int i)
    {
        mFadeOutTimeout = i;
    }

    public void setOnDrawStartListener(OnTiltShiftDrawListener ontiltshiftdrawlistener)
    {
        mDrawListener = ontiltshiftdrawlistener;
    }

    public void setPaintAlpha(int i)
    {
        mPaintAlpha = i;
        postInvalidate();
    }

    public void setPaintStrokeColor(int i, int j)
    {
        mPaintAlpha = Color.alpha(i);
        mPaintAlphaDefault = mPaintAlpha;
        mBackPaintAlpha = Color.alpha(j);
        mBackPaintAlphaDefault = mBackPaintAlpha;
        mForeColor = i;
        mBackColor = j;
        mPaint.setColor(i);
        mCrossPaint.setColor(i);
        postInvalidate();
    }

    public void setPaintStrokeWidth(int i, int j)
    {
        mPaint.setStrokeWidth(i);
        mCrossPaint.setStrokeWidth(j);
        postInvalidate();
    }

    public void setPointWaveEnabled(boolean flag)
    {
        if (flag != mPointCloudEnabled && mPointCloud != null)
        {
            mPointCloudEnabled = flag;
            if (flag && mBitmapRect != null)
            {
                resetWave(mBitmapRect);
            }
        }
    }

    public void setShapeLimits(int i, int j)
    {
        if (i >= j)
        {
            return;
        } else
        {
            mMinShapeSize = Math.max(i, 1);
            mMaxShapeSize = Math.max(Math.min(j, 100), mMinShapeSize + 1);
            updateBitmapRect();
            return;
        }
    }

    public void setTiltShiftDrawMode(TiltShiftDrawMode tiltshiftdrawmode)
    {
        mTiltShiftDrawMode = tiltshiftdrawmode;
        if (getDrawable() != null)
        {
            onDrawModeChanged();
        }
    }



}
