// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.library.graphics.animation.ExpoInterpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PointCloud

public class ImageViewVignette extends ImageViewTouch
{
    public class MyScaleListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
    {

        private float mRatio;
        final ImageViewVignette this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            while (mTouchState != TouchState.Scale || !ApiHelper.AT_LEAST_11) 
            {
                return true;
            }
            float f1 = scalegesturedetector.getPreviousSpanX();
            float f2 = scalegesturedetector.getCurrentSpanX();
            float f3 = scalegesturedetector.getPreviousSpanY();
            float f4 = scalegesturedetector.getCurrentSpanY();
            float f = scalegesturedetector.getPreviousSpan() - scalegesturedetector.getCurrentSpan();
            if (mRatio > 0.5F && mRatio < 1.5F)
            {
                f2 = mVignetteRect.width() / mVignetteRect.height();
                if ((double)f2 >= 1.0D)
                {
                    f1 = f;
                    f /= f2;
                } else
                {
                    f1 = f * f2;
                }
                onScroll(null, null, f1, f);
                return true;
            }
            if ((double)mRatio <= 0.75D)
            {
                onScroll(null, null, 0.0F, f3 - f4);
                return true;
            } else
            {
                onScroll(null, null, f1 - f2, 0.0F);
                return true;
            }
        }

        public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
        {
            if (ApiHelper.AT_LEAST_11)
            {
                mRatio = scalegesturedetector.getCurrentSpanX() / scalegesturedetector.getCurrentSpanY();
                setTouchState(TouchState.Scale);
            }
            return super.onScaleBegin(scalegesturedetector);
        }

        public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
        {
            super.onScaleEnd(scalegesturedetector);
        }

        public MyScaleListener()
        {
            this$0 = ImageViewVignette.this;
            super();
        }
    }

    public static interface OnVignetteChangeListener
    {

        public abstract void onVignetteChange(ImageViewVignette imageviewvignette, Bitmap bitmap, RectF rectf, int i, float f);
    }

    static final class TouchState extends Enum
    {

        private static final TouchState $VALUES[];
        public static final TouchState Center;
        public static final TouchState None;
        public static final TouchState Scale;

        public static TouchState valueOf(String s)
        {
            return (TouchState)Enum.valueOf(com/aviary/android/feather/sdk/widget/ImageViewVignette$TouchState, s);
        }

        public static TouchState[] values()
        {
            return (TouchState[])$VALUES.clone();
        }

        static 
        {
            None = new TouchState("None", 0);
            Center = new TouchState("Center", 1);
            Scale = new TouchState("Scale", 2);
            $VALUES = (new TouchState[] {
                None, Center, Scale
            });
        }

        private TouchState(String s, int i)
        {
            super(s, i);
        }
    }


    public static final float CLOUD_INSET_RATIO = 0.1F;
    public static final float DIAGONAL_ANGLE_RATIO_MAX = 1.5F;
    public static final float DIAGONAL_ANGLE_RATIO_MIN = 0.5F;
    public static final float STROKE_WIDTH_INCREASE_RATIO = 1.5F;
    public static final double VERTICAL_ANGLE_RATIO_MIN = 0.75D;
    private static com.aviary.android.feather.common.log.LoggerFactory.Logger logger = LoggerFactory.getLogger("ImageViewVignette");
    private static int mFadeoutTime;
    private static int mTempBitmapScale = 6;
    private float mControlPointSize;
    Animator mFadeInAnimator;
    Animator mFadeOutAnimator;
    private float mFeather;
    private GestureDetector mGestureDetector;
    private int mIntensity;
    private Matrix mInvertedMatrix;
    float mOuterRadiusAddition;
    float mOuterRectOutset;
    private final Paint mPaint;
    private int mPaintAlpha;
    private PointCloud mPointCloud;
    int mRippleAnimationDelay;
    int mRippleAnimationDuration;
    boolean mShouldRipple;
    private int mStrokeColor1;
    private int mStrokeColor2;
    private float mStrokeWidth1;
    private float mStrokeWidth2;
    private Bitmap mTempBitmap;
    private RectF mTempBitmapFinalRect;
    private Rect mTempBitmapRect;
    private float mTempScaleX;
    private float mTempScaleY;
    private TouchState mTouchState;
    private OnVignetteChangeListener mVignetteListener;
    private Paint mVignettePaint;
    private RectF mVignetteRect;
    private final RectF pBitmapRect;
    private float sControlPointTolerance;
    final RectF tempRect;

    public ImageViewVignette(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ImageViewVignette(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        tempRect = new RectF();
        pBitmapRect = new RectF();
        mPaint = new Paint();
        mShouldRipple = true;
        mFeather = 1.0F;
        mIntensity = 100;
        mPaintAlpha = 255;
        mTempScaleX = 1.0F;
        mTempScaleY = 1.0F;
        mInvertedMatrix = new Matrix();
        mTempBitmapRect = new Rect();
        mTempBitmapFinalRect = new RectF();
        initialize(context, attributeset, i);
    }

    private void dispatchVignetteChangeListener(RectF rectf)
    {
        if (mVignetteListener != null && mTempBitmap != null && !mTempBitmap.isRecycled() && !rectf.isEmpty())
        {
            mInvertedMatrix.mapRect(mTempBitmapFinalRect, rectf);
            mVignetteListener.onVignetteChange(this, mTempBitmap, mTempBitmapFinalRect, mIntensity, mFeather);
        }
    }

    private void initialize(Context context, AttributeSet attributeset, int i)
    {
        logger.info("initialize");
        attributeset = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.ImageViewVignette, i, 0);
        mStrokeWidth1 = attributeset.getDimension(com.aviary.android.feather.sdk.R.styleable.ImageViewVignette_aviary_vignette_strokeSize, 1.0F);
        mControlPointSize = attributeset.getDimension(com.aviary.android.feather.sdk.R.styleable.ImageViewVignette_aviary_vignette_controlPointSize, 1.0F);
        mStrokeWidth2 = mStrokeWidth1 * 1.5F;
        mStrokeColor1 = attributeset.getColor(com.aviary.android.feather.sdk.R.styleable.ImageViewVignette_aviary_vignette_strokeColor1, -1);
        mStrokeColor2 = attributeset.getColor(com.aviary.android.feather.sdk.R.styleable.ImageViewVignette_aviary_vignette_strokeColor2, 0xff000000);
        mIntensity = attributeset.getInteger(com.aviary.android.feather.sdk.R.styleable.ImageViewVignette_aviary_vignette_intensity, 100);
        mFeather = attributeset.getFloat(com.aviary.android.feather.sdk.R.styleable.ImageViewVignette_aviary_vignette_feather, 1.0F);
        android.graphics.drawable.Drawable drawable = attributeset.getDrawable(com.aviary.android.feather.sdk.R.styleable.ImageViewVignette_aviary_vignette_aviaryWave_pointDrawable);
        mOuterRectOutset = context.getResources().getDimension(com.aviary.android.feather.sdk.R.dimen.aviary_vignette_outer_rect_outset);
        mOuterRadiusAddition = context.getResources().getDimension(com.aviary.android.feather.sdk.R.dimen.aviary_vignette_outer_radius_addition);
        mRippleAnimationDuration = attributeset.getInt(com.aviary.android.feather.sdk.R.styleable.ImageViewVignette_aviary_vignette_rippleAnimationDuration, 1800);
        mRippleAnimationDelay = attributeset.getInt(com.aviary.android.feather.sdk.R.styleable.ImageViewVignette_aviary_vignette_animationDelay, 400);
        mFadeoutTime = attributeset.getInteger(com.aviary.android.feather.sdk.R.styleable.ImageViewVignette_aviary_vignette_fadeout_time, 1000);
        mInvertedMatrix.reset();
        mPaintAlpha = 255;
        attributeset.recycle();
        mGestureDetector = new GestureDetector(context, getGestureListener());
        if (ApiHelper.AT_LEAST_19)
        {
            mScaleDetector.setQuickScaleEnabled(true);
        }
        mVignettePaint = new Paint(1);
        mVignettePaint.setStyle(android.graphics.Paint.Style.STROKE);
        mVignetteRect = new RectF();
        mTouchState = TouchState.None;
        sControlPointTolerance = mControlPointSize * 2.0F;
        logger.log("control point size: %f", new Object[] {
            Float.valueOf(mControlPointSize)
        });
        setHardwareAccelerated(true);
        mFadeInAnimator = ObjectAnimator.ofFloat(this, "paintAlpha", new float[] {
            0.0F, 255F
        });
        mFadeOutAnimator = ObjectAnimator.ofFloat(this, "paintAlpha", new float[] {
            255F, 0.0F
        });
        mFadeOutAnimator.setStartDelay(mFadeoutTime);
        mPointCloud = new PointCloud(drawable);
    }

    private void setTouchState(TouchState touchstate)
    {
        if (touchstate != mTouchState)
        {
            logger.info("setTouchState: %s", new Object[] {
                touchstate
            });
            mTouchState = touchstate;
            invalidate();
        }
    }

    private void updateBitmapRect()
    {
        logger.log("updateBitmapRect");
        mTouchState = TouchState.None;
        if (getDrawable() == null)
        {
            mVignetteRect.setEmpty();
            pBitmapRect.setEmpty();
        } else
        {
            Object obj = getBitmapRect();
            boolean flag;
            if (!pBitmapRect.equals(obj))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            logger.log("rect_changed: %b", new Object[] {
                Boolean.valueOf(flag)
            });
            if (obj != null)
            {
                if (flag)
                {
                    if (!pBitmapRect.isEmpty())
                    {
                        float f = pBitmapRect.left;
                        float f1 = pBitmapRect.top;
                        float f2 = pBitmapRect.width();
                        float f3 = pBitmapRect.height();
                        mVignetteRect.inset(-(((RectF) (obj)).width() - f2) / 2.0F, -(((RectF) (obj)).height() - f3) / 2.0F);
                        mVignetteRect.offset(((RectF) (obj)).left - f, ((RectF) (obj)).top - f1);
                        mVignetteRect.offset((((RectF) (obj)).width() - f2) / 2.0F, (((RectF) (obj)).height() - f3) / 2.0F);
                    } else
                    {
                        mVignetteRect.set(((RectF) (obj)));
                        mVignetteRect.inset(sControlPointTolerance, sControlPointTolerance);
                    }
                }
                pBitmapRect.set(((RectF) (obj)));
            } else
            {
                pBitmapRect.setEmpty();
                mVignetteRect.setEmpty();
            }
            if (mShouldRipple)
            {
                mVignetteRect.inset(mVignetteRect.width() * 0.1F, mVignetteRect.height() * 0.1F);
            }
            mTempScaleX = (float)mTempBitmapRect.width() / pBitmapRect.width();
            mTempScaleY = (float)mTempBitmapRect.height() / pBitmapRect.height();
            obj = new Matrix(getImageMatrix());
            ((Matrix) (obj)).postScale(mTempBitmapScale, mTempBitmapScale);
            ((Matrix) (obj)).postTranslate(-pBitmapRect.left * (float)(mTempBitmapScale - 1), -pBitmapRect.top * (float)(mTempBitmapScale - 1));
            ((Matrix) (obj)).invert(mInvertedMatrix);
            dispatchVignetteChangeListener(mVignetteRect);
            mFadeOutAnimator.start();
            if (mShouldRipple)
            {
                setupRipple();
                mShouldRipple = false;
                return;
            }
        }
    }

    public void generateBitmap(Bitmap bitmap)
    {
        while (mVignetteRect.isEmpty() || pBitmapRect.isEmpty() || mTempBitmap == null || mTempBitmap.isRecycled()) 
        {
            return;
        }
        (new Canvas(bitmap)).drawBitmap(mTempBitmap, mTempBitmapRect, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), mPaint);
    }

    protected android.view.GestureDetector.OnGestureListener getGestureListener()
    {
        return new MyGestureListener();
    }

    public float getPaintAlpha()
    {
        return (float)mPaintAlpha;
    }

    protected android.view.ScaleGestureDetector.OnScaleGestureListener getScaleListener()
    {
        return new MyScaleListener();
    }

    public float getVignetteFeather()
    {
        return mFeather;
    }

    public int getVignetteIntensity()
    {
        return mIntensity;
    }

    public boolean onDown(MotionEvent motionevent)
    {
        mFadeOutAnimator.cancel();
        if (getPaintAlpha() != 255F)
        {
            mFadeInAnimator.start();
        }
        if (mVignetteRect.isEmpty())
        {
            return false;
        } else
        {
            setTouchState(TouchState.Center);
            return true;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        break MISSING_BLOCK_LABEL_5;
        if (!mVignetteRect.isEmpty() && !pBitmapRect.isEmpty() && mTempBitmap != null && !mTempBitmap.isRecycled())
        {
            canvas.drawBitmap(mTempBitmap, mTempBitmapRect, pBitmapRect, mPaint);
            if (mPaintAlpha > 0)
            {
                mVignettePaint.setStrokeWidth(mStrokeWidth2);
                mVignettePaint.setColor(mStrokeColor2);
                mVignettePaint.setAlpha(mPaintAlpha);
                canvas.drawOval(mVignetteRect, mVignettePaint);
                mVignettePaint.setStrokeWidth(mStrokeWidth1);
                mVignettePaint.setColor(mStrokeColor1);
                mVignettePaint.setAlpha(mPaintAlpha);
                canvas.drawOval(mVignetteRect, mVignettePaint);
            }
            if (mPointCloud != null)
            {
                mPointCloud.draw(canvas);
                return;
            }
        }
        return;
    }

    protected void onLayoutChanged(int i, int j, int k, int l)
    {
        super.onLayoutChanged(i, j, k, l);
        updateBitmapRect();
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (mVignetteRect.isEmpty())
        {
            return false;
        }
        tempRect.set(mVignetteRect);
        static class _cls3
        {

            static final int $SwitchMap$com$aviary$android$feather$sdk$widget$ImageViewVignette$TouchState[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$sdk$widget$ImageViewVignette$TouchState = new int[TouchState.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$widget$ImageViewVignette$TouchState[TouchState.None.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$widget$ImageViewVignette$TouchState[TouchState.Center.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$widget$ImageViewVignette$TouchState[TouchState.Scale.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.com.aviary.android.feather.sdk.widget.ImageViewVignette.TouchState[mTouchState.ordinal()];
        JVM INSTR tableswitch 1 3: default 60
    //                   1 60
    //                   2 115
    //                   3 159;
           goto _L1 _L1 _L2 _L3
_L1:
        if (tempRect.width() > sControlPointTolerance && tempRect.height() > sControlPointTolerance)
        {
            mVignetteRect.set(tempRect);
        }
        dispatchVignetteChangeListener(mVignetteRect);
        invalidate();
        return true;
_L2:
        if (pBitmapRect.contains(tempRect.centerX() - f, tempRect.centerY() - f1))
        {
            tempRect.offset(-f, -f1);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        tempRect.inset(f, f1);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (pBitmapRect.isEmpty())
        {
            return false;
        }
        mScaleDetector.onTouchEvent(motionevent);
        if (!mScaleDetector.isInProgress())
        {
            mGestureDetector.onTouchEvent(motionevent);
        }
        switch (motionevent.getAction() & 0xff)
        {
        default:
            return true;

        case 1: // '\001'
            return onUp(motionevent);
        }
    }

    public boolean onUp(MotionEvent motionevent)
    {
        setTouchState(TouchState.None);
        mFadeOutAnimator.start();
        return true;
    }

    public void setHardwareAccelerated(boolean flag)
    {
        if (flag)
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                if (isHardwareAccelerated())
                {
                    Paint paint = new Paint();
                    paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.OVERLAY));
                    setLayerType(2, paint);
                    return;
                } else
                {
                    setLayerType(1, null);
                    return;
                }
            } else
            {
                setDrawingCacheEnabled(true);
                return;
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setLayerType(1, null);
            return;
        } else
        {
            setDrawingCacheEnabled(true);
            return;
        }
    }

    public void setImageBitmap(Bitmap bitmap, Bitmap bitmap1, Matrix matrix, float f, float f1)
    {
        mTempBitmap = bitmap1;
        if (bitmap1 != null)
        {
            mTempBitmapRect.set(0, 0, mTempBitmap.getWidth(), mTempBitmap.getHeight());
            mTempBitmapScale = bitmap.getWidth() / bitmap1.getWidth();
        } else
        {
            mTempBitmapRect.setEmpty();
        }
        setImageBitmap(bitmap, matrix, f, f1);
    }

    public void setOnVignetteChangeListener(OnVignetteChangeListener onvignettechangelistener)
    {
        mVignetteListener = onvignettechangelistener;
    }

    public void setPaintAlpha(float f)
    {
        mPaintAlpha = (int)f;
        mVignettePaint.setAlpha(mPaintAlpha);
        invalidate();
    }

    public void setVignetteFeather(float f)
    {
        mFeather = f;
        dispatchVignetteChangeListener(mVignetteRect);
    }

    public void setVignetteIntensity(int i)
    {
        mIntensity = i;
        dispatchVignetteChangeListener(mVignetteRect);
    }

    void setupRipple()
    {
        final ObjectAnimator mAnimator = new RectF(mVignetteRect);
        mAnimator.inset(mOuterRectOutset * -1F, mOuterRectOutset * -1F);
        mPointCloud.waveManager.setRadius(Math.max(mVignetteRect.width(), mVignetteRect.height()));
        mPointCloud.waveManager.setAlpha(0.0F);
        mPointCloud.setEllipseOffset(mVignetteRect.left, mVignetteRect.top);
        mPointCloud.makeEllipseCloud(mVignetteRect, mAnimator);
        mAnimator = ObjectAnimator.ofFloat(mPointCloud.waveManager, "radius", new float[] {
            Math.max(mVignetteRect.width() / 2.0F, mVignetteRect.height() / 2.0F), Math.max(mAnimator.width() / 2.0F, mAnimator.height() / 2.0F) + mOuterRadiusAddition
        });
        mAnimator.setDuration(mRippleAnimationDuration);
        mAnimator.setStartDelay(mRippleAnimationDelay);
        mAnimator.setInterpolator(new ExpoInterpolator(com.aviary.android.feather.library.graphics.animation.EasingType.Type.OUT));
        mAnimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

            final ImageViewVignette this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                invalidate();
            }

            
            {
                this$0 = ImageViewVignette.this;
                super();
            }
        });
        mAnimator.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final ImageViewVignette this$0;
            final ValueAnimator val$mAnimator;

            public void onAnimationCancel(Animator animator)
            {
                mPointCloud.waveManager.setAlpha(0.0F);
                invalidate();
            }

            public void onAnimationEnd(Animator animator)
            {
                mPointCloud.waveManager.setRadius(0.0F);
                mPointCloud.waveManager.setAlpha(0.0F);
                invalidate();
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
                mPointCloud.waveManager.setRadius(((Float)mAnimator.getAnimatedValue()).floatValue());
                mPointCloud.waveManager.setAlpha(1.0F);
                invalidate();
            }

            
            {
                this$0 = ImageViewVignette.this;
                mAnimator = valueanimator;
                super();
            }
        });
        if (mPointCloud != null)
        {
            mPointCloud.waveManager.setType(PointCloud.WaveType.Ellipse);
            mPointCloud.waveManager.setAlpha(0.0F);
            if (mAnimator != null)
            {
                mAnimator.cancel();
            }
            mAnimator.start();
        }
    }






}
