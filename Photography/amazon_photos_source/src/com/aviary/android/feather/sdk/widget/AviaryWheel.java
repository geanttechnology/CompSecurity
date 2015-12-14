// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            VibrationWidget, AviaryEdgeEffect, ScrollerRunnable, VibrationHelper

public class AviaryWheel extends View
    implements android.view.GestureDetector.OnGestureListener, ScrollerRunnable.ScrollableView, VibrationWidget
{
    public static interface OnWheelChangeListener
    {

        public abstract void onStartTrackingTouch(AviaryWheel aviarywheel);

        public abstract void onStopTrackingTouch(AviaryWheel aviarywheel);

        public abstract void onValueChanged(AviaryWheel aviarywheel, int i);
    }


    private static final double EDGE_HEIGHT = 0.55172413793103448D;
    private static final int HARD_LIMIT = 2048;
    private static final int INVALID_VALUE = -1;
    static final String LOG_TAG = "wheel";
    private static final int MAX_DELTA = 50;
    private static final float SHADER_MULTIPLIER = 2.1F;
    private Paint debugPaint;
    private double mCurrentValue;
    private AviaryEdgeEffect mEdgeLeft;
    private Matrix mEdgeMatrixLeft;
    private Matrix mEdgeMatrixRight;
    private float mEdgeOffset;
    private AviaryEdgeEffect mEdgeRight;
    private int mEdgeStyle;
    private GestureDetector mGestureDetector;
    int mHeightDiff;
    private boolean mInLayout;
    private int mLastMotionValue;
    private boolean mLayoutCompleted;
    private int mLineWidth;
    private Drawable mLinesIndicator;
    private Paint mLinesPaint;
    private Drawable mLinesSingle;
    private int mMaxX;
    private int mMinX;
    private int mNextValue;
    private float mOverscrollX;
    private float mScaledDensity;
    private OnWheelChangeListener mScrollListener;
    private ScrollerRunnable mScroller;
    private BitmapShader mShader;
    private Matrix mShaderMatrix;
    private int mShaderWidth;
    private Drawable mShadowBottom;
    private boolean mToLeft;
    private VibrationHelper mVibrationHelper;

    public AviaryWheel(Context context)
    {
        this(context, null);
    }

    public AviaryWheel(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, com.aviary.android.feather.sdk.R.attr.aviaryWheelStyle);
    }

    public AviaryWheel(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mHeightDiff = 0;
        mEdgeMatrixLeft = new Matrix();
        mEdgeMatrixRight = new Matrix();
        mOverscrollX = 0.0F;
        init(context, attributeset, i);
    }

    private void createShader(int i, int j)
    {
        Bitmap bitmap = Bitmap.createBitmap((int)((float)i * 2.1F), mLinesSingle.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        BitmapShader bitmapshader = new BitmapShader(((BitmapDrawable)mLinesSingle).getBitmap(), android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.CLAMP);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(7);
        paint.setShader(bitmapshader);
        int k = bitmap.getWidth() / 2;
        int l = mLinesIndicator.getIntrinsicWidth();
        j = k - l / 2;
        k += l / 2;
        double d = j % mLineWidth;
        Matrix matrix = new Matrix();
        matrix.setTranslate((float)d, 0.0F);
        bitmapshader.setLocalMatrix(matrix);
        canvas.drawRect(0.0F, 0.0F, j, bitmap.getHeight(), paint);
        mLinesIndicator.setBounds(j, 0, k, bitmap.getHeight());
        mLinesIndicator.draw(canvas);
        bitmapshader.setLocalMatrix(null);
        canvas.drawRect(k, 0.0F, bitmap.getWidth(), bitmap.getHeight(), paint);
        mShader = new BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        mLinesPaint.setShader(mShader);
        mShaderMatrix = new Matrix();
        mShaderWidth = bitmap.getWidth();
        j = (int)(0.55172413793103448D * (double)bitmap.getHeight());
        k = (int)(9F * mScaledDensity);
        mEdgeMatrixLeft.reset();
        mEdgeMatrixLeft.postRotate(-90F);
        mEdgeMatrixLeft.postTranslate(k, j);
        mEdgeMatrixLeft.postTranslate(0.0F, mHeightDiff - 3);
        mEdgeLeft.setSize(j, k * 2);
        mEdgeMatrixRight.reset();
        mEdgeMatrixRight.postRotate(90F);
        mEdgeMatrixRight.postTranslate(i - k, 0.0F);
        mEdgeMatrixRight.postTranslate(0.0F, mHeightDiff - 3);
        mEdgeRight.setSize(j, k * 2);
    }

    private void init(Context context, AttributeSet attributeset, int i)
    {
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        mScaledDensity = context.getResources().getDisplayMetrics().density / 2.0F;
        attributeset = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviaryWheel, i, 0);
        mShadowBottom = attributeset.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryWheel_aviaryWheelShadowTop);
        mLinesSingle = attributeset.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryWheel_aviaryWheelLine);
        mLinesIndicator = attributeset.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryWheel_aviaryWheelIndicator);
        mEdgeStyle = attributeset.getResourceId(com.aviary.android.feather.sdk.R.styleable.AviaryWheel_aviary_edgeStyle, 0);
        attributeset.recycle();
        mEdgeOffset = (float)(20D * (double)mScaledDensity);
        mLineWidth = mLinesSingle.getIntrinsicWidth();
        mLinesPaint = new Paint(7);
        if (!isInEditMode())
        {
            mGestureDetector = new GestureDetector(context, this);
            mGestureDetector.setIsLongpressEnabled(false);
        }
        mScroller = new ScrollerRunnable(this, 200, viewconfiguration.getScaledOverflingDistance(), null);
        mVibrationHelper = new VibrationHelper(context, true);
        mEdgeLeft = new AviaryEdgeEffect(getContext(), mEdgeStyle);
        mEdgeRight = new AviaryEdgeEffect(getContext(), mEdgeStyle);
        mEdgeLeft.setEdgeMaxAlpha(100);
        mEdgeRight.setEdgeMaxAlpha(100);
        mNextValue = -1;
        mCurrentValue = 0.0D;
    }

    private void onFinishedMovement()
    {
        scrollCompleted();
    }

    private void trackMotionValue(int i)
    {
        mCurrentValue = i;
        scrollRunning();
        postInvalidate();
    }

    public void computeScroll()
    {
        super.computeScroll();
        if (mScroller.hasMore())
        {
            int i = mScroller.getPreviousX();
            int j = mScroller.getCurrX();
            if (i != j)
            {
                if (j < mMinX && i >= mMinX && i > j)
                {
                    mEdgeLeft.onAbsorb((int)mScroller.getCurrVelocity());
                } else
                if (j > mMaxX && i <= mMaxX && j > i)
                {
                    mEdgeRight.onAbsorb((int)mScroller.getCurrVelocity());
                    return;
                }
            }
        }
    }

    public int getMaxX()
    {
        return mMaxX;
    }

    public int getMinX()
    {
        return mMinX;
    }

    protected int getPositionFromValue(double d)
    {
        return (int)((d / 100D) * (double)getRange()) + mMinX;
    }

    public int getRange()
    {
        return mMaxX - mMinX;
    }

    protected int getSuggestedMinimumHeight()
    {
        if (getBackground() != null)
        {
            return getBackground().getIntrinsicHeight();
        } else
        {
            return super.getSuggestedMinimumHeight();
        }
    }

    protected int getSuggestedMinimumWidth()
    {
        if (getBackground() != null)
        {
            return getBackground().getIntrinsicWidth();
        } else
        {
            return super.getSuggestedMinimumWidth();
        }
    }

    public int getValue()
    {
        return (int)mCurrentValue;
    }

    protected double getValueFromPosition(int i)
    {
        return ((double)(i - mMinX) / (double)getRange()) * 100D;
    }

    public boolean getVibrationEnabled()
    {
        return mVibrationHelper.enabled();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        getParent().requestDisallowInterceptTouchEvent(true);
        mScroller.stop(false);
        scrollStarted();
        return true;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (getBackground() != null)
        {
            if (mShader != null && mShaderMatrix != null)
            {
                int i = mShaderWidth / 2;
                int l = getPositionFromValue(mCurrentValue);
                mShaderMatrix.setTranslate(l - i, 0.0F);
                mShader.setLocalMatrix(mShaderMatrix);
                canvas.drawRect(mEdgeOffset, 0.0F, (float)getWidth() - mEdgeOffset, getHeight(), mLinesPaint);
            }
            canvas.translate(0.0F, mHeightDiff);
            mShadowBottom.draw(canvas);
            canvas.translate(0.0F, -mHeightDiff);
            if (debugPaint != null)
            {
                debugPaint.setColor(-1);
                debugPaint.setAlpha(127);
                canvas.drawLine(mMinX, 0.0F, mMinX, getHeight(), debugPaint);
                canvas.drawLine(mMaxX, 0.0F, mMaxX, getHeight(), debugPaint);
                canvas.drawLine(getWidth() / 2, 0.0F, getWidth() / 2, getHeight(), debugPaint);
            }
            if (mEdgeLeft != null)
            {
                if (!mEdgeLeft.isFinished())
                {
                    int j = canvas.save();
                    canvas.concat(mEdgeMatrixLeft);
                    if (mEdgeLeft.draw(canvas))
                    {
                        postInvalidate();
                    }
                    canvas.restoreToCount(j);
                }
                if (!mEdgeRight.isFinished())
                {
                    int k = canvas.save();
                    canvas.concat(mEdgeMatrixRight);
                    if (mEdgeRight.draw(canvas))
                    {
                        postInvalidate();
                    }
                    canvas.restoreToCount(k);
                    return;
                }
            }
        }
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        int i;
        int j;
        int k;
        i = getMaxX();
        j = getMinX();
        k = getPositionFromValue(mCurrentValue);
        boolean flag;
        if (f < 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        if (k < i) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        if (k > i)
        {
            mScroller.startUsingDistance(k, i - k);
            return true;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (k <= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k < j)
        {
            mScroller.startUsingDistance(k, j - k);
            return true;
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L3; else goto _L5
_L5:
        mScroller.startUsingVelocity(k, (int)f / 2);
        return true;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        mInLayout = true;
        if (flag)
        {
            mLayoutCompleted = true;
            if (mNextValue != -1)
            {
                setValue(mNextValue);
                mNextValue = -1;
            }
        }
        mInLayout = false;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    protected void onMeasure(int i, int j)
    {
        Drawable drawable = getBackground();
        if (drawable != null)
        {
            int l = android.view.View.MeasureSpec.getMode(i);
            i = android.view.View.MeasureSpec.getSize(i);
            int k = android.view.View.MeasureSpec.getMode(j);
            j = android.view.View.MeasureSpec.getSize(j);
            if (l == 0x80000000 || l == 0)
            {
                i = drawable.getIntrinsicWidth();
            }
            l = Math.min(i, 975);
            if (k == 0x80000000 || k == 0)
            {
                i = drawable.getIntrinsicHeight();
            } else
            {
                i = j;
            }
            setMeasuredDimension(l, i);
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        f = -1F * f;
        int i;
        int j;
        int k;
        int l;
        boolean flag;
        if (f < 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mToLeft = flag;
        l = getPositionFromValue(mCurrentValue);
        i = (int)((float)l + f);
        j = getMaxX();
        k = getMinX();
        if (!mToLeft)
        {
            if ((float)l + f > (float)j)
            {
                f = Math.min(f, 50F);
                f = (float)((double)f * (1.0D - (double)(((mOverscrollX + f) - (float)j) / 50F)));
                mOverscrollX = (float)l + f;
                i = j;
                mEdgeRight.onPull(f / 50F);
            } else
            {
                mOverscrollX = (float)l + f;
            }
        } else
        if ((float)l + f < (float)k)
        {
            f = Math.max(f, -50F);
            f1 = ((float)l - f - (float)k) / 50F;
            i = k;
            mEdgeLeft.onPull((f * (1.0F - f1)) / 50F);
        } else
        {
            mOverscrollX = (float)l + f;
        }
        trackMotionScroll(i);
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        Rect rect = new Rect(0, 0, i, j);
        mMinX = (i - (int)((float)i - mEdgeOffset * 4F)) / 2;
        mMaxX = i - mMinX;
        if (getBackground() != null)
        {
            mHeightDiff = getBackground().getIntrinsicHeight() - mShadowBottom.getIntrinsicHeight();
        }
        mShadowBottom.setBounds(rect.left, rect.top, rect.right, rect.top + mShadowBottom.getIntrinsicHeight());
        createShader(i, j);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = mGestureDetector.onTouchEvent(motionevent);
        if (motionevent.getAction() == 1)
        {
            onUp(motionevent);
        }
        return flag;
    }

    public boolean onUp(MotionEvent motionevent)
    {
        mEdgeLeft.onRelease();
        mEdgeRight.onRelease();
        if (mScroller.isFinished())
        {
            scrollIntoSlots();
        }
        return true;
    }

    void scrollCompleted()
    {
        if (mScrollListener != null)
        {
            mScrollListener.onStopTrackingTouch(this);
        }
    }

    public void scrollIntoSlots()
    {
        if (!mScroller.isFinished())
        {
            return;
        }
        int i = getMaxX();
        int j = getMinX();
        int k = getPositionFromValue(mCurrentValue);
        if (k > i)
        {
            mScroller.startUsingDistance(k, i - k);
            return;
        }
        if (k < j)
        {
            mScroller.startUsingDistance(k, j - k);
            return;
        } else
        {
            onFinishedMovement();
            return;
        }
    }

    void scrollRunning()
    {
        int i = getValue();
        if (!mInLayout && Math.abs(i - mLastMotionValue) > 3)
        {
            mVibrationHelper.vibrate(8);
            mLastMotionValue = i;
        }
        if (mScrollListener != null)
        {
            mScrollListener.onValueChanged(this, getValue());
        }
    }

    void scrollStarted()
    {
        if (mScrollListener != null)
        {
            mScrollListener.onStartTrackingTouch(this);
        }
    }

    public void setOnWheelChangeListener(OnWheelChangeListener onwheelchangelistener)
    {
        mScrollListener = onwheelchangelistener;
    }

    public void setValue(int i)
    {
label0:
        {
            i = Math.min(100, Math.max(i, 0));
            if (mCurrentValue != (double)i)
            {
                if (mLayoutCompleted)
                {
                    break label0;
                }
                mNextValue = i;
            }
            return;
        }
        if (!mScroller.isFinished())
        {
            mScroller.stop(false);
        }
        scrollStarted();
        trackMotionValue(i);
        scrollCompleted();
    }

    public void setVibrationEnabled(boolean flag)
    {
        Log.i("wheel", (new StringBuilder()).append("setVibrationEnabled: ").append(flag).toString());
        mVibrationHelper.setEnabled(flag);
    }

    public void trackMotionScroll(int i)
    {
        double d = getValueFromPosition(i);
        if (d != mCurrentValue)
        {
            mCurrentValue = d;
            scrollRunning();
        }
        postInvalidate();
    }
}
