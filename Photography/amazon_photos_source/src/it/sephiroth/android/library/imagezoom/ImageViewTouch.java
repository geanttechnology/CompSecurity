// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

// Referenced classes of package it.sephiroth.android.library.imagezoom:
//            ImageViewTouchBase

public class ImageViewTouch extends ImageViewTouchBase
{
    public class GestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final ImageViewTouch this$0;

        public boolean onDoubleTap(MotionEvent motionevent)
        {
            if (ImageViewTouchBase.DEBUG)
            {
                Log.i("ImageViewTouchBase", (new StringBuilder()).append("onDoubleTap. double tap enabled? ").append(mDoubleTapEnabled).toString());
            }
            if (mDoubleTapEnabled)
            {
                if (android.os.Build.VERSION.SDK_INT >= 19 && mScaleDetector.isQuickScaleEnabled())
                {
                    return true;
                }
                mUserScaled = true;
                float f = getScale();
                f = onDoubleTapPost(f, getMaxScale(), getMinScale());
                f = Math.min(getMaxScale(), Math.max(f, getMinScale()));
                zoomTo(f, motionevent.getX(), motionevent.getY(), mDefaultAnimationDuration);
            }
            if (mDoubleTapListener != null)
            {
                mDoubleTapListener.onDoubleTap();
            }
            return super.onDoubleTap(motionevent);
        }

        public boolean onDown(MotionEvent motionevent)
        {
            if (ImageViewTouchBase.DEBUG)
            {
                Log.i("ImageViewTouchBase", "onDown");
            }
            stopAllAnimations();
            return ImageViewTouch.this.onDown(motionevent);
        }

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            while (!mScrollEnabled || motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || mScaleDetector.isInProgress() || SystemClock.uptimeMillis() - mPointerUpTime <= ImageViewTouch.MIN_FLING_DELTA_TIME) 
            {
                return false;
            }
            return ImageViewTouch.this.onFling(motionevent, motionevent1, f, f1);
        }

        public void onLongPress(MotionEvent motionevent)
        {
            if (isLongClickable() && !mScaleDetector.isInProgress())
            {
                setPressed(true);
                performLongClick();
            }
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            while (!mScrollEnabled || motionevent == null || motionevent1 == null || motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || mScaleDetector.isInProgress()) 
            {
                return false;
            }
            return ImageViewTouch.this.onScroll(motionevent, motionevent1, f, f1);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            if (mSingleTapListener != null)
            {
                mSingleTapListener.onSingleTapConfirmed();
            }
            return ImageViewTouch.this.onSingleTapConfirmed(motionevent);
        }

        public boolean onSingleTapUp(MotionEvent motionevent)
        {
            return ImageViewTouch.this.onSingleTapUp(motionevent);
        }

        public GestureListener()
        {
            this$0 = ImageViewTouch.this;
            super();
        }
    }

    public static interface OnImageViewTouchDoubleTapListener
    {

        public abstract void onDoubleTap();
    }

    public static interface OnImageViewTouchSingleTapListener
    {

        public abstract void onSingleTapConfirmed();
    }

    public class ScaleListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
    {

        protected boolean mScaled;
        final ImageViewTouch this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            float f = scalegesturedetector.getCurrentSpan();
            float f2 = scalegesturedetector.getPreviousSpan();
            float f3 = getScale();
            float f4 = scalegesturedetector.getScaleFactor();
            if (mScaleEnabled)
            {
                if (mScaled && f - f2 != 0.0F)
                {
                    mUserScaled = true;
                    float f1 = Math.min(getMaxScale(), Math.max(f3 * f4, getMinScale() - 0.1F));
                    zoomTo(f1, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
                    mDoubleTapDirection = 1;
                    invalidate();
                } else
                if (!mScaled)
                {
                    mScaled = true;
                    return true;
                }
            }
            return true;
        }

        public ScaleListener()
        {
            this$0 = ImageViewTouch.this;
            super();
            mScaled = false;
        }
    }


    public static long MIN_FLING_DELTA_TIME = 0L;
    static final float SCROLL_DELTA_THRESHOLD = 1F;
    protected int mDoubleTapDirection;
    protected boolean mDoubleTapEnabled;
    private OnImageViewTouchDoubleTapListener mDoubleTapListener;
    protected GestureDetector mGestureDetector;
    protected android.view.GestureDetector.OnGestureListener mGestureListener;
    long mPointerUpTime;
    protected ScaleGestureDetector mScaleDetector;
    protected boolean mScaleEnabled;
    private float mScaleFactor;
    protected android.view.ScaleGestureDetector.OnScaleGestureListener mScaleListener;
    protected boolean mScrollEnabled;
    private OnImageViewTouchSingleTapListener mSingleTapListener;
    protected int mTouchSlop;

    public ImageViewTouch(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mDoubleTapEnabled = true;
        mScaleEnabled = true;
        mScrollEnabled = true;
    }

    public ImageViewTouch(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mDoubleTapEnabled = true;
        mScaleEnabled = true;
        mScrollEnabled = true;
    }

    protected void _setImageDrawable(Drawable drawable, Matrix matrix, float f, float f1)
    {
        super._setImageDrawable(drawable, matrix, f, f1);
    }

    public boolean canScroll()
    {
        RectF rectf;
        if (getScale() <= 1.0F)
        {
            if (mViewPort.contains(rectf = getBitmapRect()))
            {
                return false;
            }
        }
        return true;
    }

    public boolean canScroll(int i)
    {
        RectF rectf;
        Rect rect;
        boolean flag;
        flag = true;
        rectf = getBitmapRect();
        updateRect(rectf, mScrollPoint);
        rect = new Rect();
        getGlobalVisibleRect(rect);
        if (rectf != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if (rectf.right < (float)rect.right || i >= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (Math.abs(rectf.right - (float)rect.right) > 1.0F) goto _L4; else goto _L3
_L3:
        return false;
        if ((double)Math.abs(rectf.left - mScrollPoint.x) > 1.0D) goto _L4; else goto _L5
_L5:
        return false;
    }

    public boolean getDoubleTapEnabled()
    {
        return mDoubleTapEnabled;
    }

    protected android.view.GestureDetector.OnGestureListener getGestureListener()
    {
        return new GestureListener();
    }

    public boolean getQuickScaleEnabled()
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            return mScaleDetector.isQuickScaleEnabled();
        } else
        {
            return false;
        }
    }

    public float getScaleFactor()
    {
        return mScaleFactor;
    }

    protected android.view.ScaleGestureDetector.OnScaleGestureListener getScaleListener()
    {
        return new ScaleListener();
    }

    protected void init(Context context, AttributeSet attributeset, int i)
    {
        super.init(context, attributeset, i);
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        mGestureListener = getGestureListener();
        mScaleListener = getScaleListener();
        mScaleDetector = new ScaleGestureDetector(getContext(), mScaleListener);
        mGestureDetector = new GestureDetector(getContext(), mGestureListener, null, true);
        mDoubleTapDirection = 1;
        setQuickScaleEnabled(false);
    }

    protected float onDoubleTapPost(float f, float f1, float f2)
    {
        if (mScaleFactor + f <= f1)
        {
            f2 = f + mScaleFactor;
        }
        return f2;
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return !getBitmapChanged();
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (!canScroll())
        {
            return false;
        }
        if (DEBUG)
        {
            Log.i("ImageViewTouchBase", "onFling");
        }
        if (Math.abs(f) > (float)(mMinFlingVelocity * 4) || Math.abs(f1) > (float)(mMinFlingVelocity * 4))
        {
            if (DEBUG)
            {
                Log.v("ImageViewTouchBase", (new StringBuilder()).append("velocity: ").append(f1).toString());
                Log.v("ImageViewTouchBase", (new StringBuilder()).append("diff: ").append(motionevent1.getY() - motionevent.getY()).toString());
            }
            float f2 = Math.min(Math.max(2.0F, getScale() / 2.0F), 3F);
            f = (f / (float)mMaxFlingVelocity) * ((float)getWidth() * f2);
            f1 = (f1 / (float)mMaxFlingVelocity) * ((float)getHeight() * f2);
            if (DEBUG)
            {
                Log.v("ImageViewTouchBase", (new StringBuilder()).append("scale: ").append(getScale()).append(", scale_final: ").append(f2).toString());
                Log.v("ImageViewTouchBase", (new StringBuilder()).append("scaledDistanceX: ").append(f).toString());
                Log.v("ImageViewTouchBase", (new StringBuilder()).append("scaledDistanceY: ").append(f1).toString());
            }
            mUserScaled = true;
            scrollBy(f, f1, (long)Math.min(Math.max(300D, Math.sqrt(Math.pow(f, 2D) + Math.pow(f1, 2D)) / 5D), 800D));
            postInvalidate();
            return true;
        } else
        {
            return false;
        }
    }

    protected void onLayoutChanged(int i, int j, int k, int l)
    {
        super.onLayoutChanged(i, j, k, l);
        Log.v("ImageViewTouchBase", (new StringBuilder()).append("min: ").append(getMinScale()).append(", max: ").append(getMaxScale()).append(", result: ").append((getMaxScale() - getMinScale()) / 2.0F).toString());
        mScaleFactor = (getMaxScale() - getMinScale()) / 2.0F + 0.5F;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (!canScroll())
        {
            return false;
        } else
        {
            mUserScaled = true;
            scrollBy(-f, -f1);
            invalidate();
            return true;
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return !getBitmapChanged();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (getBitmapChanged())
        {
            return false;
        }
        int i = motionevent.getActionMasked();
        if (i == 6)
        {
            mPointerUpTime = motionevent.getEventTime();
        }
        mScaleDetector.onTouchEvent(motionevent);
        if (!mScaleDetector.isInProgress())
        {
            mGestureDetector.onTouchEvent(motionevent);
        }
        switch (i)
        {
        default:
            return true;

        case 1: // '\001'
            return onUp(motionevent);
        }
    }

    public boolean onUp(MotionEvent motionevent)
    {
        if (getBitmapChanged())
        {
            return false;
        }
        if (getScale() < getMinScale())
        {
            zoomTo(getMinScale(), 50L);
        }
        return true;
    }

    protected void onZoomAnimationCompleted(float f)
    {
        if (DEBUG)
        {
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("onZoomAnimationCompleted. scale: ").append(f).append(", minZoom: ").append(getMinScale()).toString());
        }
        if (f < getMinScale())
        {
            zoomTo(getMinScale(), 50L);
        }
    }

    public void setDoubleTapEnabled(boolean flag)
    {
        mDoubleTapEnabled = flag;
    }

    public void setDoubleTapListener(OnImageViewTouchDoubleTapListener onimageviewtouchdoubletaplistener)
    {
        mDoubleTapListener = onimageviewtouchdoubletaplistener;
    }

    public void setQuickScaleEnabled(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            mScaleDetector.setQuickScaleEnabled(flag);
        }
    }

    public void setScaleEnabled(boolean flag)
    {
        mScaleEnabled = flag;
    }

    public void setScrollEnabled(boolean flag)
    {
        mScrollEnabled = flag;
    }

    public void setSingleTapListener(OnImageViewTouchSingleTapListener onimageviewtouchsingletaplistener)
    {
        mSingleTapListener = onimageviewtouchsingletaplistener;
    }

    static 
    {
        MIN_FLING_DELTA_TIME = 150L;
    }


}
