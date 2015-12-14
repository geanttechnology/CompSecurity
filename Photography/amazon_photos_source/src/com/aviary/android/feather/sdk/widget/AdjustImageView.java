// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.aviary.android.feather.common.utils.ReflectionException;
import com.aviary.android.feather.common.utils.ReflectionUtils;
import com.aviary.android.feather.library.graphics.Point2D;
import com.aviary.android.feather.library.graphics.animation.ExpoInterpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import java.io.PrintStream;

public class AdjustImageView extends View
{
    public static final class FlipType extends Enum
    {

        private static final FlipType $VALUES[];
        public static final FlipType FLIP_HORIZONTAL;
        public static final FlipType FLIP_NONE;
        public static final FlipType FLIP_VERTICAL;
        public final int nativeInt;

        public static FlipType valueOf(String s)
        {
            return (FlipType)Enum.valueOf(com/aviary/android/feather/sdk/widget/AdjustImageView$FlipType, s);
        }

        public static FlipType[] values()
        {
            return (FlipType[])$VALUES.clone();
        }

        static 
        {
            FLIP_NONE = new FlipType("FLIP_NONE", 0, 1);
            FLIP_HORIZONTAL = new FlipType("FLIP_HORIZONTAL", 1, 2);
            FLIP_VERTICAL = new FlipType("FLIP_VERTICAL", 2, 4);
            $VALUES = (new FlipType[] {
                FLIP_NONE, FLIP_HORIZONTAL, FLIP_VERTICAL
            });
        }

        private FlipType(String s, int i, int j)
        {
            super(s, i);
            nativeInt = j;
        }
    }

    public static interface OnResetListener
    {

        public abstract void onResetComplete();
    }

    public static final class ScaleType extends Enum
    {

        private static final ScaleType $VALUES[];
        public static final ScaleType CENTER;
        public static final ScaleType CENTER_CROP;
        public static final ScaleType CENTER_INSIDE;
        public static final ScaleType FIT_CENTER;
        public static final ScaleType FIT_END;
        public static final ScaleType FIT_START;
        public static final ScaleType FIT_XY;
        public static final ScaleType MATRIX;
        final int nativeInt;

        public static ScaleType valueOf(String s)
        {
            return (ScaleType)Enum.valueOf(com/aviary/android/feather/sdk/widget/AdjustImageView$ScaleType, s);
        }

        public static ScaleType[] values()
        {
            return (ScaleType[])$VALUES.clone();
        }

        static 
        {
            MATRIX = new ScaleType("MATRIX", 0, 0);
            FIT_XY = new ScaleType("FIT_XY", 1, 1);
            FIT_START = new ScaleType("FIT_START", 2, 2);
            FIT_CENTER = new ScaleType("FIT_CENTER", 3, 3);
            FIT_END = new ScaleType("FIT_END", 4, 4);
            CENTER = new ScaleType("CENTER", 5, 5);
            CENTER_CROP = new ScaleType("CENTER_CROP", 6, 6);
            CENTER_INSIDE = new ScaleType("CENTER_INSIDE", 7, 7);
            $VALUES = (new ScaleType[] {
                MATRIX, FIT_XY, FIT_START, FIT_CENTER, FIT_END, CENTER, CENTER_CROP, CENTER_INSIDE
            });
        }

        private ScaleType(String s, int i, int j)
        {
            super(s, i);
            nativeInt = j;
        }
    }


    private static final int HIT_TOLERANCE = 60;
    static final String LOG_TAG = "rotate";
    private static final android.graphics.Matrix.ScaleToFit SS2F_ARRAY[];
    float currentGrowth;
    final int gridCols;
    final int gridRows;
    int handleHeight;
    int handleWidth;
    RectF imageCaptureRegion;
    boolean initStraighten;
    boolean isReset;
    int mActivePointerId;
    int mActivePointerIndex;
    private boolean mAdjustViewBounds;
    private int mAlpha;
    long mAnimationDuration;
    private int mBaseline;
    private boolean mBaselineAlignBottom;
    private boolean mCameraEnabled;
    private PointF mCenter;
    Path mClipPath;
    private ColorFilter mColorFilter;
    private boolean mColorMod;
    protected float mCurrentScale;
    private Matrix mDrawMatrix;
    RectF mDrawRect;
    private Drawable mDrawable;
    private int mDrawableHeight;
    private int mDrawableWidth;
    private boolean mEnableFreeRotate;
    Animator mFadeAnimator;
    boolean mFadeHandlerStarted;
    AnimatorSet mFadeOutlinesAnimator;
    private Matrix mFlipMatrix;
    protected int mFlipType;
    protected Handler mHandler;
    private boolean mHaveFrame;
    Path mInversePath;
    private boolean mIsInStraighten;
    private float mLastTouchX;
    private int mLevel;
    int mLinesAlpha;
    Paint mLinesPaint;
    Path mLinesPath;
    private Matrix mMatrix;
    protected final float mMatrixValues[];
    private int mMaxHeight;
    private int mMaxWidth;
    private boolean mMergeState;
    Paint mOutlineFill;
    int mOutlineFillAlpha;
    Paint mOutlinePaint;
    int mOutlinePaintAlpha;
    private float mPosX;
    long mResetAnimationDuration;
    private OnResetListener mResetListener;
    private int mResource;
    private Matrix mRotateMatrix;
    protected double mRotation;
    protected boolean mRunning;
    private ScaleType mScaleType;
    private int mState[];
    Drawable mStraightenDrawable;
    Matrix mStraightenMatrix;
    private RectF mTempDst;
    private Matrix mTempMatrix;
    private RectF mTempSrc;
    private Uri mUri;
    private int mViewAlphaScale;
    Rect mViewDrawRect;
    RectF mViewInvertRect;
    int orientation;
    boolean portrait;
    double prevGrowth;
    double previousAngle;
    double previousStraightenAngle;
    boolean straightenStarted;
    boolean testStraighten;

    public AdjustImageView(Context context)
    {
        this(context, null);
    }

    public AdjustImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, com.aviary.android.feather.sdk.R.attr.aviaryAdjustImageViewStyle);
    }

    public AdjustImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMatrixValues = new float[9];
        gridRows = 8;
        gridCols = 8;
        mHandler = new Handler();
        mRotation = 0.0D;
        mCurrentScale = 0.0F;
        mRunning = false;
        mFlipType = FlipType.FLIP_NONE.nativeInt;
        isReset = false;
        mClipPath = new Path();
        mInversePath = new Path();
        mViewDrawRect = new Rect();
        mViewInvertRect = new RectF();
        mOutlinePaint = new Paint();
        mOutlineFill = new Paint();
        mLinesPath = new Path();
        mLinesPaint = new Paint();
        straightenStarted = false;
        previousStraightenAngle = 0.0D;
        prevGrowth = 1.0D;
        testStraighten = true;
        currentGrowth = 0.0F;
        mStraightenMatrix = new Matrix();
        previousAngle = 0.0D;
        portrait = false;
        orientation = 0;
        mActivePointerId = -1;
        mActivePointerIndex = -1;
        imageCaptureRegion = null;
        initStraighten = true;
        mResource = 0;
        mAdjustViewBounds = false;
        mMaxWidth = 0x7fffffff;
        mMaxHeight = 0x7fffffff;
        mAlpha = 255;
        mViewAlphaScale = 256;
        mColorMod = false;
        mDrawable = null;
        mState = null;
        mMergeState = false;
        mLevel = 0;
        mDrawMatrix = null;
        mTempMatrix = new Matrix();
        mRotateMatrix = new Matrix();
        mFlipMatrix = new Matrix();
        mTempSrc = new RectF();
        mTempDst = new RectF();
        mBaseline = -1;
        mBaselineAlignBottom = false;
        initImageView(context, attributeset, i);
    }

    private void applyColorMod()
    {
        if (mDrawable != null && mColorMod)
        {
            mDrawable = mDrawable.mutate();
            mDrawable.setColorFilter(mColorFilter);
            mDrawable.setAlpha(mAlpha * mViewAlphaScale >> 8);
        }
    }

    private void configureBounds()
    {
        if (mDrawable == null || !mHaveFrame)
        {
            return;
        }
        int i = mDrawableWidth;
        int j = mDrawableHeight;
        int k = getWidth() - getPaddingLeft() - getPaddingRight();
        int l = getHeight() - getPaddingTop() - getPaddingBottom();
        boolean flag;
        if ((i < 0 || k == i) && (j < 0 || l == j))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i <= 0 || j <= 0 || ScaleType.FIT_XY == mScaleType)
        {
            mDrawable.setBounds(0, 0, k, l);
            mDrawMatrix = null;
            return;
        }
        mDrawable.setBounds(0, 0, i, j);
        if (ScaleType.MATRIX == mScaleType)
        {
            if (mMatrix.isIdentity())
            {
                mDrawMatrix = null;
                return;
            } else
            {
                mDrawMatrix = mMatrix;
                return;
            }
        }
        if (flag)
        {
            mDrawMatrix = null;
            return;
        }
        if (ScaleType.CENTER == mScaleType)
        {
            mDrawMatrix = mMatrix;
            mDrawMatrix.setTranslate((int)((float)(k - i) * 0.5F + 0.5F), (int)((float)(l - j) * 0.5F + 0.5F));
            return;
        }
        if (ScaleType.CENTER_CROP == mScaleType)
        {
            mDrawMatrix = mMatrix;
            float f = 0.0F;
            float f3 = 0.0F;
            float f5;
            if (i * l > k * j)
            {
                f5 = (float)l / (float)j;
                f = ((float)k - (float)i * f5) * 0.5F;
            } else
            {
                f5 = (float)k / (float)i;
                f3 = ((float)l - (float)j * f5) * 0.5F;
            }
            mDrawMatrix.setScale(f5, f5);
            mDrawMatrix.postTranslate((int)(0.5F + f), (int)(0.5F + f3));
            return;
        }
        if (ScaleType.CENTER_INSIDE == mScaleType)
        {
            mDrawMatrix = mMatrix;
            float f1;
            float f4;
            float f6;
            if (i <= k && j <= l)
            {
                f1 = 1.0F;
            } else
            {
                f1 = Math.min((float)k / (float)i, (float)l / (float)j);
            }
            f4 = (int)(((float)k - (float)i * f1) * 0.5F + 0.5F);
            f6 = (int)(((float)l - (float)j * f1) * 0.5F + 0.5F);
            mDrawMatrix.setScale(f1, f1);
            mDrawMatrix.postTranslate(f4, f6);
            return;
        } else
        {
            mTempSrc.set(0.0F, 0.0F, i, j);
            mTempDst.set(0.0F, 0.0F, k, l);
            mDrawMatrix = mMatrix;
            mDrawMatrix.setRectToRect(mTempSrc, mTempDst, scaleTypeToScaleToFit(mScaleType));
            mCurrentScale = getMatrixScale(mDrawMatrix)[0];
            Matrix matrix = new Matrix(mMatrix);
            RectF rectf = new RectF();
            RectF rectf1 = new RectF();
            rectf.set(0.0F, 0.0F, j, i);
            rectf1.set(0.0F, 0.0F, k, l);
            matrix.setRectToRect(rectf, rectf1, scaleTypeToScaleToFit(mScaleType));
            matrix = new Matrix(mDrawMatrix);
            matrix.invert(matrix);
            float f2 = getMatrixScale(matrix)[0];
            mDrawMatrix.postScale(f2, f2, k / 2, l / 2);
            mRotateMatrix.reset();
            mStraightenMatrix.reset();
            mFlipMatrix.reset();
            mFlipType = FlipType.FLIP_NONE.nativeInt;
            mRotation = 0.0D;
            mRotateMatrix.postScale(mCurrentScale, mCurrentScale, k / 2, l / 2);
            mDrawRect = getImageRect();
            getCenter();
            return;
        }
    }

    private void fireOnResetComplete()
    {
        if (mResetListener != null)
        {
            mResetListener.onResetComplete();
        }
    }

    private void flip(boolean flag, boolean flag1)
    {
        invalidate();
        PointF pointf = getCenter();
        if (flag)
        {
            mFlipType = mFlipType ^ FlipType.FLIP_HORIZONTAL.nativeInt;
            mDrawMatrix.postScale(-1F, 1.0F, pointf.x, pointf.y);
        }
        if (flag1)
        {
            mFlipType = mFlipType ^ FlipType.FLIP_VERTICAL.nativeInt;
            mDrawMatrix.postScale(1.0F, -1F, pointf.x, pointf.y);
        }
        mRotateMatrix.postRotate((float)(-mRotation * 2D), pointf.x, pointf.y);
        mRotation = Point2D.angle360(getRotationFromMatrix(mRotateMatrix));
        mFlipMatrix.reset();
    }

    static double getAngle90(double d)
    {
        double d1 = Point2D.angle360(d);
        d = d1;
        if (d1 >= 270D)
        {
            d = 360D - d1;
        } else
        {
            if (d1 >= 180D)
            {
                return d1 - 180D;
            }
            if (d1 > 90D)
            {
                return 180D - d1;
            }
        }
        return d;
    }

    private PointF getCenter()
    {
        if (mCenter == null)
        {
            int i = getWidth();
            int j = getPaddingLeft();
            int k = getPaddingRight();
            int l = getHeight();
            int i1 = getPaddingTop();
            int j1 = getPaddingBottom();
            mCenter = new PointF((float)(i - j - k) / 2.0F, (float)(l - i1 - j1) / 2.0F);
        }
        return mCenter;
    }

    private RectF getImageRect()
    {
        return new RectF(0.0F, 0.0F, mDrawableWidth, mDrawableHeight);
    }

    private double getRotationFromMatrix(Matrix matrix)
    {
        float af[] = new float[4];
        float[] _tmp = af;
        af[0] = 0.0F;
        af[1] = 0.0F;
        af[2] = 0.0F;
        af[3] = -100F;
        matrix.mapPoints(af);
        return -Point2D.angleBetweenPoints(af[0], af[1], af[2], af[3], 0.0F);
    }

    private RectF getViewRect()
    {
        int i = getWidth();
        int j = getPaddingLeft();
        int k = getPaddingRight();
        int l = getHeight();
        int i1 = getPaddingTop();
        int j1 = getPaddingBottom();
        return new RectF(0.0F, 0.0F, i - j - k, l - i1 - j1);
    }

    private void initImageView(Context context, AttributeSet attributeset, int i)
    {
        mMatrix = new Matrix();
        mScaleType = ScaleType.FIT_CENTER;
        context = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView, i, 0);
        mStraightenDrawable = context.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView_aviary_handle);
        i = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView_aviary_strokeColor, 0);
        int j = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView_aviary_strokeColor2, 0);
        int k = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView_aviary_strokeWidth, 2);
        int l = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView_aviary_strokeWidth2, 1);
        int i1 = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView_aviary_color1, 0);
        mAnimationDuration = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView_aviary_animationDuration, 400);
        mResetAnimationDuration = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView_aviary_animationDuration2, 200);
        boolean flag = context.getBoolean(com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView_aviary_enable3d, false);
        boolean flag1 = context.getBoolean(com.aviary.android.feather.sdk.R.styleable.AviaryAdjustImageView_aviary_freeRotate, true);
        context.recycle();
        setCameraEnabled(flag);
        setEnableFreeRotate(flag1);
        double d = mStraightenDrawable.getIntrinsicWidth();
        double d1 = mStraightenDrawable.getIntrinsicHeight();
        handleWidth = (int)Math.ceil(d / 2D);
        handleHeight = (int)Math.ceil(d1 / 2D);
        mOutlinePaint.setStrokeWidth(k);
        mOutlinePaint.setStyle(android.graphics.Paint.Style.STROKE);
        mOutlinePaint.setAntiAlias(true);
        mOutlinePaint.setColor(i);
        mOutlineFill.setStyle(android.graphics.Paint.Style.FILL);
        mOutlineFill.setAntiAlias(false);
        mOutlineFill.setColor(i1);
        mOutlineFill.setDither(false);
        try
        {
            ReflectionUtils.invokeMethod(mOutlineFill, "setHinting", new Class[] {
                Integer.TYPE
            }, new Object[] {
                Integer.valueOf(0)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        mLinesPaint.setStrokeWidth(l);
        mLinesPaint.setAntiAlias(false);
        mLinesPaint.setDither(false);
        mLinesPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mLinesPaint.setColor(j);
        try
        {
            ReflectionUtils.invokeMethod(mLinesPaint, "setHinting", new Class[] {
                Integer.TYPE
            }, new Object[] {
                Integer.valueOf(0)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        mOutlineFillAlpha = mOutlineFill.getAlpha();
        mOutlinePaintAlpha = mOutlinePaint.getAlpha();
        mLinesAlpha = mLinesPaint.getAlpha();
        mOutlinePaint.setAlpha(0);
        mOutlineFill.setAlpha(0);
        mLinesPaint.setAlpha(0);
    }

    private void onReset()
    {
        if (isReset)
        {
            double d = getRotation();
            double d2 = getStraightenAngle();
            boolean flag1 = getStraightenStarted();
            straightenStarted = false;
            double d1 = d % 360D;
            d = d1;
            if (d1 > 180D)
            {
                d = d1 - 360D;
            }
            boolean flag2 = getHorizontalFlip();
            boolean flag3 = getVerticalFlip();
            boolean flag = false;
            initStraighten = false;
            invalidate();
            if (d != 0.0D || flag1)
            {
                if (flag1)
                {
                    straightenBy(-d2, (int)getCenter().x, mResetAnimationDuration);
                } else
                {
                    rotateBy(-d, mResetAnimationDuration);
                }
                flag = true;
            }
            if (flag2)
            {
                flip(true, mResetAnimationDuration);
                flag = true;
            }
            if (flag3)
            {
                flip(false, mResetAnimationDuration);
                flag = true;
            }
            if (!flag)
            {
                fireOnResetComplete();
            }
        }
    }

    private void onTouchStart()
    {
        if (mFadeHandlerStarted)
        {
            fadeinGrid(100);
            return;
        } else
        {
            fadeinOutlines(200);
            return;
        }
    }

    private void onTouchUp()
    {
        invalidate();
        fadeoutGrid(200);
    }

    private void resetStraighten()
    {
        mStraightenMatrix.reset();
        straightenStarted = false;
        previousStraightenAngle = 0.0D;
        prevGrowth = 1.0D;
        testStraighten = true;
        currentGrowth = 0.0F;
        previousAngle = 0.0D;
    }

    private void resizeFromDrawable()
    {
        Drawable drawable = mDrawable;
        if (drawable != null)
        {
            int j = drawable.getIntrinsicWidth();
            int i = j;
            if (j < 0)
            {
                i = mDrawableWidth;
            }
            int k = drawable.getIntrinsicHeight();
            j = k;
            if (k < 0)
            {
                j = mDrawableHeight;
            }
            if (i != mDrawableWidth || j != mDrawableHeight)
            {
                mDrawableWidth = i;
                mDrawableHeight = j;
                requestLayout();
            }
        }
    }

    private int resolveAdjustedSize(int i, int j, int k)
    {
        int l = android.view.View.MeasureSpec.getMode(k);
        k = android.view.View.MeasureSpec.getSize(k);
        switch (l)
        {
        default:
            return i;

        case 0: // '\0'
            return Math.min(i, j);

        case -2147483648: 
            return Math.min(Math.min(i, k), j);

        case 1073741824: 
            return k;
        }
    }

    private void resolveUri()
    {
        if (mDrawable == null) goto _L2; else goto _L1
_L1:
        Resources resources;
        return;
_L2:
        if ((resources = getResources()) == null) goto _L1; else goto _L3
_L3:
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        if (mResource == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = resources.getDrawable(mResource);
        obj1 = obj;
_L4:
        updateDrawable(((Drawable) (obj1)));
        return;
        obj;
        Log.w("rotate", (new StringBuilder()).append("Unable to find resource: ").append(mResource).toString(), ((Throwable) (obj)));
        mUri = null;
          goto _L4
        if (mUri == null) goto _L1; else goto _L5
_L5:
        obj1 = mUri.getScheme();
        if (!"android.resource".equals(obj1)) goto _L7; else goto _L6
_L6:
        obj1 = obj;
        if (obj == null)
        {
            System.out.println((new StringBuilder()).append("resolveUri failed on bad bitmap uri: ").append(mUri).toString());
            mUri = null;
            obj1 = obj;
        }
          goto _L4
_L7:
        if (!"content".equals(obj1) && !"file".equals(obj1))
        {
            break MISSING_BLOCK_LABEL_232;
        }
        obj1 = Drawable.createFromStream(getContext().getContentResolver().openInputStream(mUri), null);
        obj = obj1;
          goto _L6
        Exception exception;
        exception;
        Log.w("rotate", (new StringBuilder()).append("Unable to open content: ").append(mUri).toString(), exception);
          goto _L6
        obj = Drawable.createFromPath(mUri.toString());
          goto _L6
    }

    private static android.graphics.Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType scaletype)
    {
        return SS2F_ARRAY[scaletype.nativeInt - 1];
    }

    private void setImageRotation(double d, boolean flag)
    {
        PointF pointf = getCenter();
        Matrix matrix = new Matrix(mDrawMatrix);
        RectF rectf = getImageRect();
        RectF rectf1 = getViewRect();
        matrix.setRotate((float)d, pointf.x, pointf.y);
        matrix.mapRect(rectf);
        matrix.setRectToRect(rectf, rectf1, scaleTypeToScaleToFit(mScaleType));
        float af[] = getMatrixScale(matrix);
        float f = Math.min(af[0], af[1]);
        if (flag)
        {
            mRotateMatrix.setRotate((float)d, pointf.x, pointf.y);
            mRotateMatrix.postScale(f, f, pointf.x, pointf.y);
            return;
        } else
        {
            mRotateMatrix.setScale(f, f, pointf.x, pointf.y);
            mRotateMatrix.postRotate((float)d, pointf.x, pointf.y);
            return;
        }
    }

    private void setStraightenRotation(double d)
    {
        PointF pointf = getCenter();
        mStraightenMatrix.postRotate((float)(-previousStraightenAngle), pointf.x, pointf.y);
        mStraightenMatrix.postRotate((float)d, pointf.x, pointf.y);
        previousStraightenAngle = d;
        double d1 = isNumber(1.0D / prevGrowth, 1.0D);
        mStraightenMatrix.postScale((float)d1, (float)d1, pointf.x, pointf.y);
        int i = getPaddingLeft();
        int j = getPaddingRight();
        int k = getPaddingTop();
        int l = getPaddingBottom();
        if (portrait)
        {
            double d6 = Math.sin(Math.toRadians(d));
            double d2 = Math.cos(Math.toRadians(d));
            float af[] = new float[8];
            af[0] = (float)((double)imageCaptureRegion.left + (double)i * d6 + (double)i * d2);
            af[1] = (float)(((double)imageCaptureRegion.top - (double)k * d6) + (double)i * d2);
            af[2] = (float)((double)imageCaptureRegion.right + (double)j * d6 + (double)j * d2);
            af[3] = (float)(((double)imageCaptureRegion.top - (double)k * d6) + (double)i * d2);
            af[4] = (float)((double)imageCaptureRegion.left + (double)i * d6 + (double)i * d2);
            af[5] = (float)(((double)imageCaptureRegion.bottom - (double)l * d6) + (double)l * d2);
            af[6] = (float)((double)imageCaptureRegion.right + (double)j * d6 + (double)j * d2);
            af[7] = (float)(((double)imageCaptureRegion.bottom - (double)l * d6) + (double)l * d2);
            mStraightenMatrix.mapPoints(af);
            float f = (float)((double)imageCaptureRegion.right + (double)j * d6 + (double)j * d2);
            float f2 = (float)(((double)imageCaptureRegion.top - (double)k * d6) + (double)k * d2);
            float f4 = (float)((double)imageCaptureRegion.right + (double)j * d6 + (double)j * d2);
            float f6 = (float)(((double)imageCaptureRegion.bottom - (double)l * d6) + (double)l * d2);
            float f8 = af[2];
            float f10 = af[3];
            float f12 = af[6];
            float f14 = af[7];
            double d10 = (f * f6 - f2 * f4) * (f10 - f14) - (f2 - f6) * (f8 * f14 - f10 * f12);
            double d11 = (f - f4) * (f10 - f14) - (f2 - f6) * (f8 - f12);
            double d8 = imageCaptureRegion.right + (float)j;
            double d4 = d10 / d11 + (double)l;
            orientation = getResources().getConfiguration().orientation;
            d2 = d4;
            if (orientation == 2)
            {
                d2 = d4;
                if (d > 0.0D)
                {
                    d2 = d10 / d11 + (double)l * d6;
                }
            }
            d4 = d8 - (double)f4;
            d6 = d2 - (double)f6;
            if (d < 0.0D)
            {
                d4 = d8 - (double)f;
                d6 = d2 - (double)f2;
            }
            d2 = Math.sqrt(d4 * d4 + d6 * d6);
            d4 = Math.sin(Math.toRadians(Math.abs(d)));
            d6 = Math.sqrt((af[0] - af[2]) * (af[0] - af[2]));
            if (d != 0.0D)
            {
                d = isNumber((d6 + 2D * d2 * d4) / d6, 1.0D);
                mStraightenMatrix.postScale((float)d, (float)d, pointf.x, pointf.y);
            } else
            {
                d = 1.0D;
            }
        } else
        {
            double d3 = Math.sin(Math.toRadians(d));
            double d5 = Math.cos(Math.toRadians(d));
            float af1[] = new float[8];
            af1[0] = (float)((double)imageCaptureRegion.left + (double)i * d3 + (double)i * d5);
            af1[1] = (float)(((double)imageCaptureRegion.top - (double)k * d3) + (double)i * d5);
            af1[2] = (float)((double)imageCaptureRegion.right + (double)j * d3 + (double)j * d5);
            af1[3] = (float)(((double)imageCaptureRegion.top - (double)k * d3) + (double)i * d5);
            af1[4] = (float)((double)imageCaptureRegion.left + (double)i * d3 + (double)i * d5);
            af1[5] = (float)(((double)imageCaptureRegion.bottom - (double)l * d3) + (double)l * d5);
            af1[6] = (float)((double)imageCaptureRegion.right + (double)j * d3 + (double)j * d5);
            af1[7] = (float)(((double)imageCaptureRegion.bottom - (double)l * d3) + (double)l * d5);
            mStraightenMatrix.mapPoints(af1);
            float f1 = (float)((double)imageCaptureRegion.left + (double)i * d3 + (double)i * d5);
            float f3 = (float)(((double)imageCaptureRegion.bottom - (double)l * d3) + (double)l * d5);
            float f5 = (float)((double)imageCaptureRegion.right + (double)j * d3 + (double)j * d5);
            float f7 = (float)(((double)imageCaptureRegion.bottom - (double)l * d3) + (double)l * d5);
            float f9 = af1[4];
            float f11 = af1[5];
            float f13 = af1[6];
            float f15 = af1[7];
            double d9 = (double)((f1 * f7 - f3 * f5) * (f9 - f13) - (f1 - f5) * (f9 * f15 - f11 * f13)) / (double)((f1 - f5) * (f11 - f15) - (f3 - f7) * (f9 - f13)) + (double)i;
            double d7 = imageCaptureRegion.bottom + (float)l;
            d3 = d9 - (double)f1;
            d5 = d7 - (double)f3;
            if (d < 0.0D)
            {
                d3 = d9 - (double)f5;
                d5 = d7 - (double)f7;
            }
            d3 = Math.sqrt(d3 * d3 + d5 * d5);
            d5 = Math.sin(Math.toRadians(Math.abs(d)));
            d7 = Math.sqrt((af1[5] - af1[1]) * (af1[5] - af1[1]));
            if (d != 0.0D)
            {
                d = isNumber((d7 + 2D * d3 * d5) / d7, 1.0D);
                mStraightenMatrix.postScale((float)d, (float)d, pointf.x, pointf.y);
            } else
            {
                d = 1.0D;
            }
        }
        prevGrowth = d;
    }

    private void updateDrawable(Drawable drawable)
    {
        if (mDrawable != null)
        {
            mDrawable.setCallback(null);
            unscheduleDrawable(mDrawable);
        }
        mDrawable = drawable;
        if (drawable != null)
        {
            drawable.setCallback(this);
            if (drawable.isStateful())
            {
                drawable.setState(getDrawableState());
            }
            drawable.setLevel(mLevel);
            mDrawableWidth = drawable.getIntrinsicWidth();
            mDrawableHeight = drawable.getIntrinsicHeight();
            applyColorMod();
            configureBounds();
            return;
        } else
        {
            mDrawableWidth = -1;
            mDrawableHeight = -1;
            return;
        }
    }

    public final void clearColorFilter()
    {
        setColorFilter(((ColorFilter) (null)));
    }

    RectF crop(float f, float f1, double d, float f2, float f3, PointF pointf, 
            Canvas canvas)
    {
        double d1 = Point2D.radians(d);
        PointF apointf1[] = new PointF[4];
        apointf1[0] = new PointF(0.0F, 0.0F);
        apointf1[1] = new PointF(f, 0.0F);
        apointf1[2] = new PointF(f, f1);
        apointf1[3] = new PointF(0.0F, f1);
        Point2D.translate(apointf1, -f / 2.0F, -f1 / 2.0F);
        PointF apointf[] = new PointF[apointf1.length];
        System.arraycopy(apointf1, 0, apointf, 0, apointf1.length);
        Point2D.rotate(apointf, d1);
        if (d >= 0.0D)
        {
            PointF apointf2[] = new PointF[2];
            apointf2[0] = new PointF(0.0F, 0.0F);
            apointf2[1] = new PointF(-f2 / 2.0F, -f3 / 2.0F);
            PointF apointf3[] = new PointF[2];
            apointf3[0] = apointf[0];
            apointf3[1] = apointf[3];
            Object obj = Point2D.intersection(apointf2, apointf3);
            PointF apointf4[] = new PointF[2];
            apointf4[0] = new PointF(0.0F, 0.0F);
            apointf4[1] = new PointF(f2 / 2.0F, -f3 / 2.0F);
            PointF apointf5[] = new PointF[2];
            apointf5[0] = apointf[0];
            apointf5[1] = apointf[1];
            PointF pointf1 = Point2D.intersection(apointf4, apointf5);
            obj = new PointF(Math.max(((PointF) (obj)).x, -pointf1.x), Math.max(((PointF) (obj)).y, pointf1.y));
            obj = new RectF(((PointF) (obj)).x, ((PointF) (obj)).y, -((PointF) (obj)).x, -((PointF) (obj)).y);
            ((RectF) (obj)).offset(pointf.x, pointf.y);
            if (canvas != null)
            {
                Point2D.translate(apointf, pointf.x, pointf.y);
                Point2D.translate(apointf2, pointf.x, pointf.y);
                Point2D.translate(apointf4, pointf.x, pointf.y);
                pointf = new Paint(1);
                pointf.setColor(0x66ffff00);
                pointf.setStyle(android.graphics.Paint.Style.STROKE);
                pointf.setStrokeWidth(2.0F);
                drawRect(apointf, canvas, pointf);
                pointf.setColor(0xff00ff00);
                drawLine(apointf2, canvas, pointf);
                pointf.setColor(0xff0000ff);
                drawLine(apointf4, canvas, pointf);
                pointf.setColor(0xff00ffff);
                drawLine(apointf3, canvas, pointf);
                pointf.setColor(-1);
                drawLine(apointf5, canvas, pointf);
                pointf.setColor(0xff888888);
                canvas.drawRect(((RectF) (obj)), pointf);
            }
            return ((RectF) (obj));
        } else
        {
            throw new IllegalArgumentException("angle cannot be < 0");
        }
    }

    void drawLine(PointF apointf[], Canvas canvas, Paint paint)
    {
        canvas.drawLine(apointf[0].x, apointf[0].y, apointf[1].x, apointf[1].y, paint);
    }

    void drawRect(PointF apointf[], Canvas canvas, Paint paint)
    {
        Path path = new Path();
        path.moveTo(apointf[0].x, apointf[0].y);
        path.lineTo(apointf[1].x, apointf[1].y);
        path.lineTo(apointf[2].x, apointf[2].y);
        path.lineTo(apointf[3].x, apointf[3].y);
        path.lineTo(apointf[0].x, apointf[0].y);
        canvas.drawPath(path, paint);
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = mDrawable;
        if (drawable != null && drawable.isStateful())
        {
            drawable.setState(getDrawableState());
        }
    }

    protected void fadeinGrid(int i)
    {
        if (mFadeAnimator != null)
        {
            mFadeAnimator.cancel();
        }
        mFadeAnimator = ObjectAnimator.ofInt(this, "gridAlpha", new int[] {
            mLinesPaint.getAlpha(), mLinesAlpha
        });
        mFadeAnimator.setDuration(i);
        mFadeAnimator.start();
    }

    protected void fadeinOutlines(int i)
    {
        if (mFadeHandlerStarted)
        {
            return;
        }
        mFadeHandlerStarted = true;
        if (mFadeOutlinesAnimator != null)
        {
            mFadeOutlinesAnimator.cancel();
        }
        mFadeOutlinesAnimator = new AnimatorSet();
        mFadeOutlinesAnimator.playTogether(new Animator[] {
            ObjectAnimator.ofInt(this, "outlineFillAlpha", new int[] {
                0, mOutlineFillAlpha
            }), ObjectAnimator.ofInt(this, "outlinePaintAlpha", new int[] {
                0, mOutlinePaintAlpha
            }), ObjectAnimator.ofInt(this, "linesAlpha", new int[] {
                0, mLinesAlpha
            })
        });
        mFadeOutlinesAnimator.setDuration(i);
        mFadeOutlinesAnimator.start();
    }

    protected void fadeoutGrid(int i)
    {
        if (mFadeAnimator != null)
        {
            mFadeAnimator.cancel();
        }
        mFadeAnimator = ObjectAnimator.ofInt(this, "gridAlpha", new int[] {
            mLinesPaint.getAlpha(), 0
        });
        mFadeAnimator.setDuration(i);
        mFadeAnimator.start();
    }

    protected void fadeoutOutlines(int i)
    {
        if (mFadeOutlinesAnimator != null)
        {
            mFadeOutlinesAnimator.cancel();
        }
        mFadeOutlinesAnimator = new AnimatorSet();
        mFadeOutlinesAnimator.playTogether(new Animator[] {
            ObjectAnimator.ofInt(this, "outlineFillAlpha", new int[] {
                mOutlineFill.getAlpha(), 0
            }), ObjectAnimator.ofInt(this, "outlinePaintAlpha", new int[] {
                0, mOutlinePaint.getAlpha(), 0
            }), ObjectAnimator.ofInt(this, "linesAlpha", new int[] {
                0, mLinesPaint.getAlpha()
            })
        });
        mFadeOutlinesAnimator.setDuration(i);
        mFadeOutlinesAnimator.start();
    }

    public void flip(boolean flag)
    {
        flip(flag, mAnimationDuration);
    }

    protected void flip(boolean flag, long l)
    {
        flipTo(flag, l);
        hideOutlines();
    }

    protected void flipTo(final boolean horizontal, long l)
    {
        if (mRunning)
        {
            Log.w("rotate", "still running!..");
        } else
        {
            mRunning = true;
            int i = getWidth();
            int j = getPaddingLeft();
            int k = getPaddingRight();
            int i1 = getHeight();
            int j1 = getPaddingTop();
            int k1 = getPaddingBottom();
            final float centerx = (i - j - k) / 2;
            final float centery = (i1 - j1 - k1) / 2;
            final Camera camera = new Camera();
            float f;
            float f1;
            ValueAnimator valueanimator;
            if (mCameraEnabled)
            {
                f = 0.0F;
            } else
            {
                f = 1.0F;
            }
            if (mCameraEnabled)
            {
                f1 = 180F;
            } else
            {
                f1 = -1F;
            }
            valueanimator = ValueAnimator.ofFloat(new float[] {
                f, f1
            });
            valueanimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

                final AdjustImageView this$0;
                final Camera val$camera;
                final float val$centerx;
                final float val$centery;
                final boolean val$horizontal;

                public void onAnimationUpdate(ValueAnimator valueanimator1)
                {
                    float f2 = ((Float)valueanimator1.getAnimatedValue()).floatValue();
                    if (mCameraEnabled)
                    {
                        camera.save();
                        if (horizontal)
                        {
                            camera.rotateY(f2);
                        } else
                        {
                            camera.rotateX(f2);
                        }
                        camera.getMatrix(mFlipMatrix);
                        camera.restore();
                        mFlipMatrix.preTranslate(-centerx, -centery);
                        mFlipMatrix.postTranslate(centerx, centery);
                    } else
                    if (horizontal)
                    {
                        mFlipMatrix.setScale(f2, 1.0F, centerx, centery);
                    } else
                    {
                        mFlipMatrix.setScale(1.0F, f2, centerx, centery);
                    }
                    invalidate();
                }

            
            {
                this$0 = AdjustImageView.this;
                camera = camera1;
                horizontal = flag;
                centerx = f;
                centery = f1;
                super();
            }
            });
            valueanimator.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

                final AdjustImageView this$0;
                final float val$centerx;
                final float val$centery;
                final boolean val$horizontal;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    if (horizontal)
                    {
                        animator = AdjustImageView.this;
                        animator.mFlipType = ((AdjustImageView) (animator)).mFlipType ^ FlipType.FLIP_HORIZONTAL.nativeInt;
                        mDrawMatrix.postScale(-1F, 1.0F, centerx, centery);
                    } else
                    {
                        animator = AdjustImageView.this;
                        animator.mFlipType = ((AdjustImageView) (animator)).mFlipType ^ FlipType.FLIP_VERTICAL.nativeInt;
                        mDrawMatrix.postScale(1.0F, -1F, centerx, centery);
                    }
                    mRotateMatrix.postRotate((float)(-mRotation * 2D), centerx, centery);
                    mRotation = Point2D.angle360(getRotationFromMatrix(mRotateMatrix));
                    mFlipMatrix.reset();
                    invalidate();
                    printDetails();
                    mRunning = false;
                    if (isReset)
                    {
                        onReset();
                    }
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = AdjustImageView.this;
                horizontal = flag;
                centerx = f;
                centery = f1;
                super();
            }
            });
            valueanimator.setInterpolator(new ExpoInterpolator(com.aviary.android.feather.library.graphics.animation.EasingType.Type.INOUT));
            valueanimator.setDuration(l);
            valueanimator.start();
            if (straightenStarted && !isReset)
            {
                initStraighten = true;
                resetStraighten();
                invalidate();
                return;
            }
        }
    }

    public int getBaseline()
    {
        if (mBaselineAlignBottom)
        {
            return getMeasuredHeight();
        } else
        {
            return mBaseline;
        }
    }

    public boolean getBaselineAlignBottom()
    {
        return mBaselineAlignBottom;
    }

    public double getCurrentRotation()
    {
        return mRotation;
    }

    public Drawable getDrawable()
    {
        return mDrawable;
    }

    public int getFlipType()
    {
        return mFlipType;
    }

    public int getGridAlpha()
    {
        return mLinesPaint.getAlpha();
    }

    public double getGrowthFactor()
    {
        return prevGrowth;
    }

    public boolean getHorizontalFlip()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mFlipType != FlipType.FLIP_NONE.nativeInt)
        {
            flag = flag1;
            if ((mFlipType & FlipType.FLIP_HORIZONTAL.nativeInt) == FlipType.FLIP_HORIZONTAL.nativeInt)
            {
                flag = true;
            }
        }
        return flag;
    }

    public Matrix getImageMatrix()
    {
        return mMatrix;
    }

    public int getLinesAlpha()
    {
        return mLinesPaint.getAlpha();
    }

    protected float[] getMatrixScale(Matrix matrix)
    {
        return (new float[] {
            getValue(matrix, 0), getValue(matrix, 4)
        });
    }

    public int getOutlineFillAlpha()
    {
        return mOutlineFill.getAlpha();
    }

    public int getOutlinePaintAlpha()
    {
        return mOutlinePaint.getAlpha();
    }

    public float getRotation()
    {
        return (float)mRotation;
    }

    public ScaleType getScaleType()
    {
        return mScaleType;
    }

    public double getStraightenAngle()
    {
        return previousStraightenAngle;
    }

    public boolean getStraightenStarted()
    {
        return straightenStarted;
    }

    protected float getValue(Matrix matrix, int i)
    {
        matrix.getValues(mMatrixValues);
        return mMatrixValues[i];
    }

    public boolean getVerticalFlip()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mFlipType != FlipType.FLIP_NONE.nativeInt)
        {
            flag = flag1;
            if ((mFlipType & FlipType.FLIP_VERTICAL.nativeInt) == FlipType.FLIP_VERTICAL.nativeInt)
            {
                flag = true;
            }
        }
        return flag;
    }

    protected void hideOutlines()
    {
        mFadeHandlerStarted = false;
        mOutlineFill.setAlpha(0);
        mOutlinePaint.setAlpha(0);
        mLinesPaint.setAlpha(0);
        invalidate();
    }

    public void invalidateDrawable(Drawable drawable)
    {
        if (drawable == mDrawable)
        {
            invalidate();
            return;
        } else
        {
            super.invalidateDrawable(drawable);
            return;
        }
    }

    public boolean isFreeRotateEnabled()
    {
        return mEnableFreeRotate;
    }

    protected double isNumber(double d, double d1)
    {
        double d2;
label0:
        {
            if (!Double.isInfinite(d))
            {
                d2 = d;
                if (!Double.isNaN(d))
                {
                    break label0;
                }
            }
            Log.e("rotate", "number is NaN or Infinite");
            d2 = d1;
        }
        return d2;
    }

    public boolean isRunning()
    {
        return mRunning;
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        orientation = getResources().getConfiguration().orientation;
        initStraighten = true;
        mCenter = null;
        invalidate();
        if (straightenStarted)
        {
            initStraighten = true;
            resetStraighten();
            invalidate();
        }
    }

    public int[] onCreateDrawableState(int i)
    {
        if (mState == null)
        {
            return super.onCreateDrawableState(i);
        }
        if (!mMergeState)
        {
            return mState;
        } else
        {
            return mergeDrawableStates(super.onCreateDrawableState(mState.length + i), mState);
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mDrawable != null) goto _L2; else goto _L1
_L1:
        Log.e("rotate", "Drawable is null");
_L4:
        return;
_L2:
        int k1;
        int l1;
        if (mDrawableWidth == 0 || mDrawableHeight == 0)
        {
            Log.e("rotate", "drawable width or height is 0");
            return;
        }
        k1 = getPaddingTop();
        l1 = getPaddingLeft();
        if (mDrawMatrix == null)
        {
            Log.e("rotate", "mDrawMatrix is null");
            mDrawable.draw(canvas);
            return;
        }
        int i = canvas.save();
        canvas.translate(l1, k1);
        if (mFlipMatrix != null)
        {
            canvas.concat(mFlipMatrix);
        }
        if (mRotateMatrix != null)
        {
            canvas.concat(mRotateMatrix);
        }
        if (mStraightenMatrix != null)
        {
            canvas.concat(mStraightenMatrix);
        }
        if (mDrawMatrix != null)
        {
            canvas.concat(mDrawMatrix);
        }
        mDrawable.draw(canvas);
        canvas.restoreToCount(i);
        if (!mEnableFreeRotate) goto _L4; else goto _L3
_L3:
        double d;
        double d1;
        double d2;
        mDrawRect = getImageRect();
        getDrawingRect(mViewDrawRect);
        mClipPath.reset();
        mInversePath.reset();
        mLinesPath.reset();
        float af[] = new float[8];
        af[0] = mDrawRect.left;
        af[1] = mDrawRect.top;
        af[2] = mDrawRect.right;
        af[3] = mDrawRect.top;
        af[4] = mDrawRect.right;
        af[5] = mDrawRect.bottom;
        af[6] = mDrawRect.left;
        af[7] = mDrawRect.bottom;
        mTempMatrix.set(mDrawMatrix);
        mTempMatrix.postConcat(mRotateMatrix);
        mTempMatrix.postConcat(mStraightenMatrix);
        mTempMatrix.mapPoints(af);
        mViewInvertRect.set(mViewDrawRect);
        RectF rectf1 = mViewInvertRect;
        rectf1.top = rectf1.top - (float)l1;
        rectf1 = mViewInvertRect;
        rectf1.left = rectf1.left - (float)k1;
        mInversePath.addRect(mViewInvertRect, android.graphics.Path.Direction.CW);
        d = Point2D.distance(af[2], af[3], af[0], af[1]);
        d1 = Point2D.distance(af[6], af[7], af[0], af[1]);
        d2 = getAngle90(mRotation);
        if (!initStraighten) goto _L6; else goto _L5
_L5:
        RectF rectf;
        float f;
        float f2;
        if (d2 < 45D)
        {
            rectf = crop((float)d, (float)d1, d2, mDrawableWidth, mDrawableHeight, getCenter(), null);
        } else
        {
            rectf = crop((float)d, (float)d1, d2, mDrawableHeight, mDrawableWidth, getCenter(), null);
        }
        f = rectf.height() / 8F;
        f2 = rectf.width() / 8F;
        for (int j = 1; j < 8; j++)
        {
            mLinesPath.moveTo((int)rectf.left, (int)(rectf.top + (float)j * f));
            mLinesPath.lineTo((int)rectf.right, (int)(rectf.top + (float)j * f));
        }

        for (int k = 1; k < 8; k++)
        {
            mLinesPath.moveTo((int)(rectf.left + (float)k * f2), (int)rectf.top);
            mLinesPath.lineTo((int)(rectf.left + (float)k * f2), (int)rectf.bottom);
        }

        imageCaptureRegion = rectf;
        PointF pointf = getCenter();
        mStraightenDrawable.setBounds((int)(pointf.x - (float)handleWidth), (int)(imageCaptureRegion.bottom - (float)handleHeight), (int)(pointf.x + (float)handleWidth), (int)(imageCaptureRegion.bottom + (float)handleHeight));
        mPosX = pointf.x;
        initStraighten = false;
_L8:
        mClipPath.addRect(rectf, android.graphics.Path.Direction.CW);
        mInversePath.addRect(rectf, android.graphics.Path.Direction.CCW);
        int l = canvas.save();
        canvas.translate(l1, k1);
        canvas.drawPath(mInversePath, mOutlineFill);
        canvas.drawPath(mLinesPath, mLinesPaint);
        canvas.drawPath(mClipPath, mOutlinePaint);
        if (!mRunning)
        {
            mStraightenDrawable.draw(canvas);
        }
        canvas.restoreToCount(l);
        return;
_L6:
        RectF rectf2 = imageCaptureRegion;
        float f1 = rectf2.height() / 8F;
        float f3 = rectf2.width() / 8F;
        for (int i1 = 1; i1 < 8; i1++)
        {
            mLinesPath.moveTo((int)rectf2.left, (int)(rectf2.top + (float)i1 * f1));
            mLinesPath.lineTo((int)rectf2.right, (int)(rectf2.top + (float)i1 * f1));
        }

        int j1 = 1;
        do
        {
            rectf = rectf2;
            if (j1 >= 8)
            {
                continue;
            }
            mLinesPath.moveTo((int)(rectf2.left + (float)j1 * f3), (int)rectf2.top);
            mLinesPath.lineTo((int)(rectf2.left + (float)j1 * f3), (int)rectf2.bottom);
            j1++;
        } while (true);
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (flag)
        {
            mHaveFrame = true;
            double d = mRotation;
            flag = getHorizontalFlip();
            boolean flag1 = getVerticalFlip();
            configureBounds();
            if (flag || flag1)
            {
                flip(flag, flag1);
            }
            if (d != 0.0D)
            {
                setImageRotation(d, false);
                mRotation = d;
            }
            invalidate();
        }
    }

    protected void onMeasure(int i, int j)
    {
        resolveUri();
        float f = 0.0F;
        boolean flag = false;
        boolean flag1 = false;
        int k2 = android.view.View.MeasureSpec.getMode(i);
        int j2 = android.view.View.MeasureSpec.getMode(j);
        int k;
        int l1;
        int i2;
        int l2;
        int i3;
        if (mDrawable == null)
        {
            mDrawableWidth = -1;
            mDrawableHeight = -1;
            i2 = 0;
            l1 = 0;
        } else
        {
            int j1 = mDrawableWidth;
            l1 = mDrawableHeight;
            k = j1;
            if (j1 <= 0)
            {
                k = 1;
            }
            j1 = l1;
            if (l1 <= 0)
            {
                j1 = 1;
            }
            if (mDrawableHeight > mDrawableWidth)
            {
                portrait = true;
            }
            orientation = getResources().getConfiguration().orientation;
            l1 = j1;
            i2 = k;
            if (mAdjustViewBounds)
            {
                if (k2 != 0x40000000)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (j2 != 0x40000000)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                f = (float)k / (float)j1;
                l1 = j1;
                i2 = k;
            }
        }
        l2 = getPaddingLeft();
        i3 = getPaddingRight();
        j2 = getPaddingTop();
        k2 = getPaddingBottom();
        if (flag || flag1)
        {
            int l = resolveAdjustedSize(i2 + l2 + i3, mMaxWidth, i);
            i2 = resolveAdjustedSize(l1 + j2 + k2, mMaxHeight, j);
            j = i2;
            k = l;
            if (f != 0.0F)
            {
                j = i2;
                k = l;
                if ((double)Math.abs((float)(l - l2 - i3) / (float)(i2 - j2 - k2) - f) > 9.9999999999999995E-08D)
                {
                    j = 0;
                    l1 = j;
                    i = l;
                    if (flag)
                    {
                        k = (int)((float)(i2 - j2 - k2) * f) + l2 + i3;
                        l1 = j;
                        i = l;
                        if (k <= l)
                        {
                            i = k;
                            l1 = 1;
                        }
                    }
                    j = i2;
                    k = i;
                    if (l1 == 0)
                    {
                        j = i2;
                        k = i;
                        if (flag1)
                        {
                            int i1 = (int)((float)(i - l2 - i3) / f) + j2 + k2;
                            j = i2;
                            k = i;
                            if (i1 <= i2)
                            {
                                j = i1;
                                k = i;
                            }
                        }
                    }
                }
            }
        } else
        {
            k = Math.max(i2 + (l2 + i3), getSuggestedMinimumWidth());
            int k1 = Math.max(l1 + (j2 + k2), getSuggestedMinimumHeight());
            k = resolveSize(k, i);
            j = resolveSize(k1, j);
        }
        setMeasuredDimension(k, j);
    }

    protected boolean onSetAlpha(int i)
    {
        if (getBackground() == null)
        {
            i += i >> 7;
            if (mViewAlphaScale != i)
            {
                mViewAlphaScale = i;
                mColorMod = true;
                applyColorMod();
            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        if (!mEnableFreeRotate)
        {
            return true;
        }
        i = motionevent.getAction();
        if (initStraighten)
        {
            resetStraighten();
        }
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 76
    //                   0 157
    //                   1 550
    //                   2 353
    //                   3 585
    //                   4 76
    //                   5 157
    //                   6 78;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L2 _L6
_L1:
        return true;
_L6:
        if (motionevent.findPointerIndex(mActivePointerId) < 0)
        {
            Log.d("rotate", "released original pointer");
            onTouchUp();
            mActivePointerId = -1;
            mActivePointerIndex = -1;
        }
        Log.d("rotate", (new StringBuilder()).append("pointerId: ").append(mActivePointerId).append(", activePointerId: ").append(mActivePointerId).toString());
        continue; /* Loop/switch isn't completed */
_L2:
        if (mActivePointerId != -1)
        {
            Log.w("rotate", "We already have a valid pointer");
            return true;
        }
        int j = 0;
        while (j < motionevent.getPointerCount()) 
        {
            float f = motionevent.getX(j);
            float f2 = motionevent.getY(j);
            if (imageCaptureRegion != null)
            {
                RectF rectf = new RectF(imageCaptureRegion.left - 60F, imageCaptureRegion.bottom - 60F, imageCaptureRegion.right + 60F, imageCaptureRegion.bottom + 60F);
                rectf.offset(getPaddingLeft(), getPaddingTop());
                mIsInStraighten = rectf.contains(f, f2);
            }
            if (mIsInStraighten)
            {
                mLastTouchX = f;
                mPosX = mStraightenDrawable.getBounds().centerX();
                mActivePointerIndex = j;
                mActivePointerId = motionevent.getPointerId(mActivePointerIndex);
                onTouchStart();
                return true;
            }
            j++;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int k = motionevent.findPointerIndex(mActivePointerId);
        if (k < 0)
        {
            Log.w("rotate", "could not find the original pointerId");
            return false;
        }
        float f1 = motionevent.getX(k);
        motionevent.getY(k);
        float f3 = mLastTouchX;
        mPosX = mPosX + (f1 - f3);
        mLastTouchX = f1;
        if (mIsInStraighten)
        {
            if (mPosX > imageCaptureRegion.right)
            {
                mPosX = imageCaptureRegion.right;
            }
            if (mPosX < imageCaptureRegion.left)
            {
                mPosX = imageCaptureRegion.left;
            }
            double d = getCenter().x;
            double d1 = (double)(45F * imageCaptureRegion.right) / d;
            straighten(-((45D * ((double)(45F * mPosX) / d - 45D)) / (d1 - 45D)) / 2D, mPosX);
        }
        invalidate();
        continue; /* Loop/switch isn't completed */
_L3:
        if (mActivePointerId != -1)
        {
            onTouchUp();
        }
        mActivePointerId = -1;
        mActivePointerIndex = -1;
        mIsInStraighten = false;
        mLastTouchX = 0.0F;
        continue; /* Loop/switch isn't completed */
_L5:
        mActivePointerId = -1;
        mActivePointerIndex = -1;
        mIsInStraighten = false;
        mLastTouchX = 0.0F;
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void printDetails()
    {
        boolean flag1 = true;
        Log.i("rotate", "details:");
        StringBuilder stringbuilder = (new StringBuilder()).append(" flip horizontal: ");
        boolean flag;
        if ((mFlipType & FlipType.FLIP_HORIZONTAL.nativeInt) == FlipType.FLIP_HORIZONTAL.nativeInt)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Log.d("rotate", stringbuilder.append(flag).toString());
        stringbuilder = (new StringBuilder()).append(" flip vertical: ");
        if ((mFlipType & FlipType.FLIP_VERTICAL.nativeInt) == FlipType.FLIP_VERTICAL.nativeInt)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Log.d("rotate", stringbuilder.append(flag).toString());
        Log.d("rotate", (new StringBuilder()).append(" rotation: ").append(mRotation).toString());
        Log.d("rotate", "--------");
    }

    public void reset()
    {
        isReset = true;
        onReset();
    }

    public void resetToOriginal()
    {
        hideOutlines();
        resetStraighten();
        mPosX = getWidth() / 2;
        mLastTouchX = mPosX;
        mStraightenDrawable.setBounds((int)(mPosX - (float)handleWidth), (int)(imageCaptureRegion.bottom - (float)handleHeight), (int)(mPosX + (float)handleWidth), (int)(imageCaptureRegion.bottom + (float)handleHeight));
        rotateBy(-getCurrentRotation(), mAnimationDuration);
        invalidate();
    }

    public void rotate90(boolean flag)
    {
        rotate90(flag, mAnimationDuration);
    }

    public void rotate90(boolean flag, long l)
    {
        int i;
        if (flag)
        {
            i = 90;
        } else
        {
            i = -90;
        }
        rotateBy(i, l);
        hideOutlines();
        if (!portrait)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        portrait = flag;
    }

    protected void rotateBy(final double destRotation, long l)
    {
        if (mRunning)
        {
            Log.w("rotate", "still running!..");
        } else
        {
            mRunning = true;
            destRotation = mRotation + destRotation;
            double d = mRotation;
            setImageRotation(mRotation, false);
            invalidate();
            ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
                (float)d, (float)destRotation
            });
            valueanimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

                final AdjustImageView this$0;

                public void onAnimationUpdate(ValueAnimator valueanimator1)
                {
                    float f = ((Float)valueanimator1.getAnimatedValue()).floatValue();
                    mRotation = Point2D.angle360(f);
                    setImageRotation(mRotation, false);
                    initStraighten = true;
                    invalidate();
                }

            
            {
                this$0 = AdjustImageView.this;
                super();
            }
            });
            valueanimator.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

                final AdjustImageView this$0;
                final double val$destRotation;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    mRotation = Point2D.angle360(destRotation);
                    setImageRotation(mRotation, true);
                    initStraighten = true;
                    mRunning = false;
                    invalidate();
                    printDetails();
                    if (isReset)
                    {
                        onReset();
                    }
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = AdjustImageView.this;
                destRotation = d;
                super();
            }
            });
            valueanimator.setInterpolator(new ExpoInterpolator(com.aviary.android.feather.library.graphics.animation.EasingType.Type.INOUT));
            valueanimator.setDuration(l);
            valueanimator.start();
            if (straightenStarted && !isReset)
            {
                initStraighten = true;
                resetStraighten();
                invalidate();
                return;
            }
        }
    }

    public void setAdjustViewBounds(boolean flag)
    {
        mAdjustViewBounds = flag;
        if (flag)
        {
            setScaleType(ScaleType.FIT_CENTER);
        }
    }

    public void setAlpha(int i)
    {
        i &= 0xff;
        if (mAlpha != i)
        {
            mAlpha = i;
            mColorMod = true;
            applyColorMod();
            invalidate();
        }
    }

    public void setBaseline(int i)
    {
        if (mBaseline != i)
        {
            mBaseline = i;
            requestLayout();
        }
    }

    public void setBaselineAlignBottom(boolean flag)
    {
        if (mBaselineAlignBottom != flag)
        {
            mBaselineAlignBottom = flag;
            requestLayout();
        }
    }

    public void setCameraEnabled(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14 && flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mCameraEnabled = flag;
    }

    public final void setColorFilter(int i)
    {
        setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
    }

    public final void setColorFilter(int i, android.graphics.PorterDuff.Mode mode)
    {
        setColorFilter(((ColorFilter) (new PorterDuffColorFilter(i, mode))));
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        if (mColorFilter != colorfilter)
        {
            mColorFilter = colorfilter;
            mColorMod = true;
            applyColorMod();
            invalidate();
        }
    }

    public void setEnableFreeRotate(boolean flag)
    {
        mEnableFreeRotate = flag;
    }

    public void setGridAlpha(int i)
    {
        mLinesPaint.setAlpha(i);
        postInvalidate();
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        setImageDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
    }

    public void setImageDrawable(Drawable drawable)
    {
        if (mDrawable != drawable)
        {
            mResource = 0;
            mUri = null;
            int i = mDrawableWidth;
            int j = mDrawableHeight;
            updateDrawable(drawable);
            if (i != mDrawableWidth || j != mDrawableHeight)
            {
                requestLayout();
            }
            invalidate();
        }
    }

    public void setImageLevel(int i)
    {
        mLevel = i;
        if (mDrawable != null)
        {
            mDrawable.setLevel(i);
            resizeFromDrawable();
        }
    }

    public void setImageMatrix(Matrix matrix)
    {
        Matrix matrix1 = matrix;
        if (matrix != null)
        {
            matrix1 = matrix;
            if (matrix.isIdentity())
            {
                matrix1 = null;
            }
        }
        if (matrix1 == null && !mMatrix.isIdentity() || matrix1 != null && !mMatrix.equals(matrix1))
        {
            mMatrix.set(matrix1);
            configureBounds();
            invalidate();
        }
    }

    public void setImageResource(int i)
    {
        if (mUri != null || mResource != i)
        {
            updateDrawable(null);
            mResource = i;
            mUri = null;
            resolveUri();
            requestLayout();
            invalidate();
        }
    }

    public void setImageState(int ai[], boolean flag)
    {
        mState = ai;
        mMergeState = flag;
        if (mDrawable != null)
        {
            refreshDrawableState();
            resizeFromDrawable();
        }
    }

    public void setImageURI(Uri uri)
    {
        if (mResource != 0 || mUri != uri && (uri == null || mUri == null || !uri.equals(mUri)))
        {
            updateDrawable(null);
            mResource = 0;
            mUri = uri;
            resolveUri();
            requestLayout();
            invalidate();
        }
    }

    public void setLinesAlpha(int i)
    {
        mLinesPaint.setAlpha(i);
        postInvalidate();
    }

    public void setMaxHeight(int i)
    {
        mMaxHeight = i;
    }

    public void setMaxWidth(int i)
    {
        mMaxWidth = i;
    }

    public void setOnResetListener(OnResetListener onresetlistener)
    {
        mResetListener = onresetlistener;
    }

    public void setOutlineFillAlpha(int i)
    {
        mOutlineFill.setAlpha(i);
        postInvalidate();
    }

    public void setOutlinePaintAlpha(int i)
    {
        mOutlinePaint.setAlpha(i);
        postInvalidate();
    }

    public void setScaleType(ScaleType scaletype)
    {
        if (scaletype == null)
        {
            throw new NullPointerException();
        }
        if (mScaleType != scaletype)
        {
            mScaleType = scaletype;
            boolean flag;
            if (mScaleType == ScaleType.CENTER)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            setWillNotCacheDrawing(flag);
            requestLayout();
            invalidate();
        }
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        resizeFromDrawable();
    }

    public void straighten(double d, float f)
    {
        if (mRunning)
        {
            return;
        } else
        {
            straightenStarted = true;
            mStraightenDrawable.setBounds((int)(f - (float)handleWidth), (int)(imageCaptureRegion.bottom - (float)handleHeight), (int)((float)handleWidth + f), (int)(imageCaptureRegion.bottom + (float)handleHeight));
            setStraightenRotation(d);
            mPosX = f;
            invalidate();
            return;
        }
    }

    public void straightenBy(final double newPosition, final int newx, long l)
    {
        if (mRunning)
        {
            Log.w("rotate", "still running!..");
            return;
        } else
        {
            mRunning = true;
            straightenStarted = true;
            System.currentTimeMillis();
            final int srcx = mStraightenDrawable.getBounds().centerX();
            final float deltax = newx - srcx;
            double d = getStraightenAngle();
            final double srcRotation = getStraightenAngle();
            invalidate();
            ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
                0.0F, 1.0F
            });
            valueanimator.setDuration(l);
            valueanimator.setInterpolator(new ExpoInterpolator(com.aviary.android.feather.library.graphics.animation.EasingType.Type.INOUT));
            valueanimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

                final AdjustImageView this$0;
                final float val$deltax;
                final double val$newPosition;
                final double val$srcRotation;
                final int val$srcx;

                public void onAnimationUpdate(ValueAnimator valueanimator1)
                {
                    float f = ((Float)valueanimator1.getAnimatedValue()).floatValue();
                    mStraightenDrawable.setBounds((int)(((float)srcx + deltax * f) - (float)handleWidth), (int)(imageCaptureRegion.bottom - (float)handleHeight), (int)((float)srcx + deltax * f + (float)handleWidth), (int)(imageCaptureRegion.bottom + (float)handleHeight));
                    setStraightenRotation(srcRotation + newPosition * (double)f);
                    invalidate();
                }

            
            {
                this$0 = AdjustImageView.this;
                srcx = i;
                deltax = f;
                srcRotation = d;
                newPosition = d1;
                super();
            }
            });
            valueanimator.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

                final AdjustImageView this$0;
                final double val$destRotation;
                final int val$newx;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    mStraightenDrawable.setBounds(newx - handleWidth, (int)(imageCaptureRegion.bottom - (float)handleHeight), newx + handleWidth, (int)(imageCaptureRegion.bottom + (float)handleHeight));
                    setStraightenRotation(destRotation);
                    mRunning = false;
                    invalidate();
                    if (isReset)
                    {
                        straightenStarted = false;
                        onReset();
                    }
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = AdjustImageView.this;
                newx = i;
                destRotation = d;
                super();
            }
            });
            valueanimator.start();
            return;
        }
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return mDrawable == drawable || super.verifyDrawable(drawable);
    }

    static 
    {
        SS2F_ARRAY = (new android.graphics.Matrix.ScaleToFit[] {
            android.graphics.Matrix.ScaleToFit.FILL, android.graphics.Matrix.ScaleToFit.START, android.graphics.Matrix.ScaleToFit.CENTER, android.graphics.Matrix.ScaleToFit.END
        });
    }








}
