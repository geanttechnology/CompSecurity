// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.aviary.android.feather.library.graphics.RectD;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.graphics.IBitmapDrawable;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            HighlightView

public class CropImageView extends ImageViewTouch
{
    class CropGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final CropImageView this$0;

        public boolean onDoubleTap(MotionEvent motionevent)
        {
            if (access$502)
            {
                mMotionHighlightView = null;
                float f = getScale();
                f = onDoubleTapPost(f, getMaxScale(), getMinScale());
                f = Math.min(getMaxScale(), Math.max(f, 1.0F));
                zoomTo(f, motionevent.getX(), motionevent.getY(), 200L);
                invalidate();
            }
            return super.onDoubleTap(motionevent);
        }

        public boolean onDown(MotionEvent motionevent)
        {
            mMotionHighlightView = null;
            Object obj = mHighlightView;
            if (obj != null)
            {
                int i = ((HighlightView) (obj)).getHit(motionevent.getX(), motionevent.getY());
                if (i != 1)
                {
                    mMotionEdge = i;
                    mMotionHighlightView = ((HighlightView) (obj));
                    HighlightView highlightview = mMotionHighlightView;
                    if (i == 32)
                    {
                        obj = HighlightView.Mode.Move;
                    } else
                    {
                        obj = HighlightView.Mode.Grow;
                    }
                    highlightview.setMode(((HighlightView.Mode) (obj)), i);
                    postInvalidate();
                }
            }
            return super.onDown(motionevent);
        }

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            while (motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || 
// JavaClassFileOutputException: get_constant: invalid tag

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            while (motionevent == null || motionevent1 == null || motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || 
// JavaClassFileOutputException: get_constant: invalid tag

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            mMotionHighlightView = null;
            return onSingleTapConfirmed(motionevent);
        }

        public boolean onSingleTapUp(MotionEvent motionevent)
        {
            mMotionHighlightView = null;
            if (mHighlightView != null && mMotionEdge == 32 && mHighlightSingleTapUpListener != null)
            {
                mHighlightSingleTapUpListener.onSingleTapUpConfirmed();
            }
            return onSingleTapUp(motionevent);
        }

        CropGestureListener()
        {
            this$0 = CropImageView.this;
            super();
        }
    }

    public static interface OnHighlightSingleTapUpConfirmedListener
    {

        public abstract void onSingleTapUpConfirmed();
    }


    public static final int GROW = 0;
    public static final int SHRINK = 1;
    private boolean cropRectChanged;
    protected double mAspectRatio;
    private boolean mAspectRatioFixed;
    private int mCropMinSize;
    protected Handler mHandler;
    private int mHighlighStyle;
    private OnHighlightSingleTapUpConfirmedListener mHighlightSingleTapUpListener;
    private HighlightView mHighlightView;
    private int mMotionEdge;
    private HighlightView mMotionHighlightView;
    private Rect mRect1;
    private Rect mRect2;
    Runnable onLayoutRunnable = new Runnable() {

        final CropImageView this$0;

        public void run()
        {
label0:
            {
                Drawable drawable = getDrawable();
                if (drawable != null && ((IBitmapDrawable)drawable).getBitmap() != null && mHighlightView != null)
                {
                    if (!mHighlightView.isRunning())
                    {
                        break label0;
                    }
                    mHandler.post(this);
                }
                return;
            }
            Log.d("ImageViewTouchBase", "onLayoutRunnable.. running");
            mHighlightView.getMatrix().set(getImageMatrix());
            mHighlightView.invalidate();
        }

            
            {
                this$0 = CropImageView.this;
                super();
            }
    };

    public CropImageView(Context context, AttributeSet attributeset)
    {
        CropImageView(context, attributeset, 0);
    }

    public CropImageView(Context context, AttributeSet attributeset, int i)
    {
        ImageViewTouch(context, attributeset, i);
        mHandler = new Handler();
        mAspectRatio = 0.0D;
        mMotionEdge = 1;
        cropRectChanged = false;
        mCropMinSize = 10;
        mRect1 = new Rect();
        mRect2 = new Rect();
    }

    private RectD computeFinalCropRect(double d)
    {
        float f = getScale();
        float f1 = getDrawable().getIntrinsicWidth();
        float f2 = getDrawable().getIntrinsicHeight();
        RectF rectf = new RectF(0.0F, 0.0F, getWidth(), getHeight());
        Object obj = getBitmapRect();
        obj = new RectF(Math.max(rectf.left, ((RectF) (obj)).left), Math.max(rectf.top, ((RectF) (obj)).top), Math.min(rectf.right, ((RectF) (obj)).right), Math.min(rectf.bottom, ((RectF) (obj)).bottom));
        double d3 = Math.min(Math.min(f1 / f, ((RectF) (obj)).width()), Math.min(f2 / f, ((RectF) (obj)).height())) * 0.8F;
        double d4 = d3;
        double d1 = d4;
        double d2 = d3;
        Matrix matrix;
        if (d != 0.0D)
        {
            if (d > 1.0D)
            {
                d1 = d4 / d;
                d2 = d3;
            } else
            {
                d2 = d3 * d;
                d1 = d4;
            }
        }
        obj = getImageMatrix();
        matrix = new Matrix();
        if (!((Matrix) (obj)).invert(matrix))
        {
            Log.e("ImageViewTouchBase", "cannot invert matrix");
        }
        matrix.mapRect(rectf);
        d = (double)rectf.centerX() - d2 / 2D;
        d3 = (double)rectf.centerY() - d1 / 2D;
        return new RectD(d, d3, d + d2, d3 + d1);
    }

    private boolean ensureVisible(HighlightView highlightview)
    {
        boolean flag = false;
        highlightview = highlightview.getDrawRect();
        int i = Math.max(0, getLeft() - ((Rect) (highlightview)).left);
        int l = Math.min(0, getRight() - ((Rect) (highlightview)).right);
        int j = Math.max(0, getTop() - ((Rect) (highlightview)).top);
        int k = Math.min(0, getBottom() - ((Rect) (highlightview)).bottom);
        if (i == 0)
        {
            i = l;
        }
        if (j == 0)
        {
            j = k;
        }
        if (i != 0 || j != 0)
        {
            panBy(i, j);
            flag = true;
        }
        return flag;
    }

    private void updateAspectRatio(double d, HighlightView highlightview, boolean flag)
    {
        Log.d("ImageViewTouchBase", (new StringBuilder()).append("updateAspectRatio: ").append(d).toString());
        float f = getDrawable().getIntrinsicWidth();
        float f1 = getDrawable().getIntrinsicHeight();
        RectD rectd = new RectD(0.0D, 0.0D, (int)f, (int)f1);
        Matrix matrix = getImageMatrix();
        RectD rectd1 = computeFinalCropRect(d);
        if (flag)
        {
            highlightview.animateTo(this, matrix, rectd, rectd1, mAspectRatioFixed);
            return;
        } else
        {
            highlightview.setup(matrix, rectd, rectd1, mAspectRatioFixed);
            postInvalidate();
            return;
        }
    }

    public double getAspectRatio()
    {
        return mAspectRatio;
    }

    public boolean getAspectRatioIsFixed()
    {
        return mAspectRatioFixed;
    }

    public HighlightView getHighlightView()
    {
        return mHighlightView;
    }

    public boolean hasCropRectChanged()
    {
        return cropRectChanged;
    }

    protected void init(Context context, AttributeSet attributeset, int i)
    {
        init(context, attributeset, i);
        mGestureDetector = null;
        mGestureListener = null;
        mScaleListener = null;
        mGestureDetector = new GestureDetector(getContext(), new CropGestureListener(), null, true);
        mGestureDetector.setIsLongpressEnabled(false);
        context = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviaryCropImageView, i, 0);
        mCropMinSize = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryCropImageView_aviary_minCropSize, 50);
        mHighlighStyle = context.getResourceId(com.aviary.android.feather.sdk.R.styleable.AviaryCropImageView_aviary_highlightStyle, -1);
        context.recycle();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (getHandler() != null)
        {
            getHandler().postDelayed(new Runnable() {

                final CropImageView this$0;

                public void run()
                {
                    setAspectRatio(mAspectRatio, getAspectRatioIsFixed());
                }

            
            {
                this$0 = CropImageView.this;
                super();
            }
            }, 500L);
        }
        postInvalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        onDraw(canvas);
        if (mHighlightView != null)
        {
            mHighlightView.draw(canvas);
        }
    }

    protected void onDrawableChanged(Drawable drawable)
    {
        onDrawableChanged(drawable);
        if (getHandler() != null)
        {
            getHandler().post(new Runnable() {

                final CropImageView this$0;

                public void run()
                {
                    updateCropView(true);
                }

            
            {
                this$0 = CropImageView.this;
                super();
            }
            });
        }
    }

    protected void onLayoutChanged(int i, int j, int k, int l)
    {
        onLayoutChanged(i, j, k, l);
        mHandler.post(onLayoutRunnable);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        onSizeChanged(i, j, k, l);
        if (mHighlightView != null)
        {
            mHighlightView.onSizeChanged(this, i, j, k, l);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        onTouchEvent(motionevent);
        switch (motionevent.getAction() & 0xff)
        {
        default:
            return true;

        case 1: // '\001'
            break;
        }
        if (mHighlightView != null)
        {
            mHighlightView.setMode(HighlightView.Mode.None, 1);
            postInvalidate();
        }
        mMotionHighlightView = null;
        mMotionEdge = 1;
        return true;
    }

    protected void postScale(float f, float f1, float f2)
    {
        if (mHighlightView != null)
        {
            if (mHighlightView.isRunning())
            {
                return;
            } else
            {
                RectD rectd = mHighlightView.getCropRectD();
                mHighlightView.getDisplayRect(getImageViewMatrix(), mHighlightView.getCropRectD(), mRect1);
                postScale(f, f1, f2);
                mHighlightView.getDisplayRect(getImageViewMatrix(), mHighlightView.getCropRectD(), mRect2);
                float af[] = new float[9];
                getImageViewMatrix().getValues(af);
                f = af[0];
                rectd.offset((float)(mRect1.left - mRect2.left) / f, (float)(mRect1.top - mRect2.top) / f);
                rectd.right = rectd.right + (double)((float)(-(mRect2.width() - mRect1.width())) / f);
                rectd.bottom = rectd.bottom + (double)((float)(-(mRect2.height() - mRect1.height())) / f);
                mHighlightView.getMatrix().set(getImageMatrix());
                mHighlightView.getCropRectD().set(rectd);
                mHighlightView.invalidate();
                return;
            }
        } else
        {
            postScale(f, f1, f2);
            return;
        }
    }

    protected void postTranslate(float f, float f1)
    {
        postTranslate(f, f1);
        if (mHighlightView == null || mHighlightView.isRunning())
        {
            return;
        }
        if (getScale() != 1.0F)
        {
            float af[] = new float[9];
            getImageMatrix().getValues(af);
            float f2 = af[0];
            mHighlightView.getCropRectD().offset(-f / f2, -f1 / f2);
        }
        mHighlightView.getMatrix().set(getImageMatrix());
        mHighlightView.invalidate();
    }

    public void setAspectRatio(double d, boolean flag)
    {
        if (getDrawable() != null)
        {
            mAspectRatio = d;
            mAspectRatioFixed = flag;
            updateCropView(false);
        }
    }

    public void setCropRectChanged(boolean flag)
    {
        cropRectChanged = flag;
    }

    public void setHighlightView(HighlightView highlightview)
    {
        if (mHighlightView != null)
        {
            mHighlightView.dispose();
        }
        mMotionHighlightView = null;
        mHighlightView = highlightview;
        invalidate();
    }

    public void setImageBitmap(Bitmap bitmap, double d, boolean flag)
    {
        mAspectRatio = d;
        mAspectRatioFixed = flag;
        setImageBitmap(bitmap, null, -1F, 8F);
    }

    public void setImageDrawable(Drawable drawable, Matrix matrix, float f, float f1)
    {
        mMotionHighlightView = null;
        setImageDrawable(drawable, matrix, f, f1);
    }

    public void setMinCropSize(int i)
    {
        mCropMinSize = i;
        if (mHighlightView != null)
        {
            mHighlightView.setMinSize(i);
        }
    }

    public void setOnHighlightSingleTapUpConfirmedListener(OnHighlightSingleTapUpConfirmedListener onhighlightsingletapupconfirmedlistener)
    {
        mHighlightSingleTapUpListener = onhighlightsingletapupconfirmedlistener;
    }

    public void updateCropView(boolean flag)
    {
        if (flag)
        {
            setHighlightView(null);
        }
        if (getDrawable() == null)
        {
            setHighlightView(null);
            invalidate();
            return;
        }
        if (getHighlightView() != null)
        {
            updateAspectRatio(mAspectRatio, getHighlightView(), true);
        } else
        {
            HighlightView highlightview = new HighlightView(this, mHighlighStyle);
            highlightview.setMinSize(mCropMinSize);
            updateAspectRatio(mAspectRatio, highlightview, false);
            setHighlightView(highlightview);
        }
        invalidate();
    }





/*
    static HighlightView access$102(CropImageView cropimageview, HighlightView highlightview)
    {
        cropimageview.mMotionHighlightView = highlightview;
        return highlightview;
    }

*/



/*
    static int access$1202(CropImageView cropimageview, int i)
    {
        cropimageview.mDoubleTapDirection = i;
        return i;
    }

*/



/*
    static int access$202(CropImageView cropimageview, int i)
    {
        cropimageview.mMotionEdge = i;
        return i;
    }

*/




/*
    static boolean access$502(CropImageView cropimageview, boolean flag)
    {
        cropimageview.cropRectChanged = flag;
        return flag;
    }

*/




}
