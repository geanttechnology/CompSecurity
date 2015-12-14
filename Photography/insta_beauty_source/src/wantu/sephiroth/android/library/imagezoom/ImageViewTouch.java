// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wantu.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import bpn;
import cgb;
import cgc;
import cgd;
import cgn;

// Referenced classes of package wantu.sephiroth.android.library.imagezoom:
//            ImageViewTouchBase

public class ImageViewTouch extends ImageViewTouchBase
{

    private static final String TAG = "ImageViewTouch";
    public float MIN_ZOOM;
    private cgc doubleTapListener;
    public float mCurrentScaleFactor;
    public int mDoubleTapDirection;
    public boolean mDoubleTapToZoomEnabled;
    protected GestureDetector mGestureDetector;
    protected android.view.GestureDetector.OnGestureListener mGestureListener;
    public ScaleGestureDetector mScaleDetector;
    public boolean mScaleEnabled;
    protected float mScaleFactor;
    protected android.view.ScaleGestureDetector.OnScaleGestureListener mScaleListener;
    public boolean mScrollEnabled;
    protected int mTouchSlop;
    private bpn movingLisener;

    public ImageViewTouch(Context context)
    {
        super(context);
        MIN_ZOOM = 0.9F;
        mDoubleTapToZoomEnabled = true;
        mScaleEnabled = true;
        mScrollEnabled = true;
    }

    public ImageViewTouch(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        MIN_ZOOM = 0.9F;
        mDoubleTapToZoomEnabled = true;
        mScaleEnabled = true;
        mScrollEnabled = true;
    }

    protected void _setImageDrawable(Drawable drawable, boolean flag, Matrix matrix, float f)
    {
        super._setImageDrawable(drawable, flag, matrix, f);
        mScaleFactor = getMaxZoom() / 3F;
    }

    public Bitmap getDispalyImage(int i, int j)
    {
        int k = getWidth();
        float f = (float)i / (float)k;
        Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Matrix matrix = getImageMatrix();
        matrix.postScale(f, f);
        Bitmap bitmap1 = ((cgn)getDrawable()).a();
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap1, matrix, paint);
        return bitmap;
    }

    public boolean getDoubleTapEnabled()
    {
        return mDoubleTapToZoomEnabled;
    }

    protected android.view.GestureDetector.OnGestureListener getGestureListener()
    {
        return new cgb(this);
    }

    protected android.view.ScaleGestureDetector.OnScaleGestureListener getScaleListener()
    {
        return new cgd(this);
    }

    protected void init()
    {
        super.init();
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        mGestureListener = getGestureListener();
        mScaleListener = getScaleListener();
        mScaleDetector = new ScaleGestureDetector(getContext(), mScaleListener);
        mGestureDetector = new GestureDetector(getContext(), mGestureListener, null, true);
        mCurrentScaleFactor = 1.0F;
        mDoubleTapDirection = 1;
    }

    protected void onBitmapChanged(Drawable drawable)
    {
        super.onBitmapChanged(drawable);
        drawable = new float[9];
        mSuppMatrix.getValues(drawable);
        mCurrentScaleFactor = drawable[0];
    }

    public float onDoubleTapPost(float f, float f1)
    {
        if (mDoubleTapDirection == 1)
        {
            if (mScaleFactor * 2.0F + f <= f1)
            {
                return f + mScaleFactor;
            } else
            {
                mDoubleTapDirection = -1;
                return f1;
            }
        } else
        {
            mDoubleTapDirection = 1;
            return 1.0F;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        mScaleDetector.onTouchEvent(motionevent);
        if (!mScaleDetector.isInProgress())
        {
            mGestureDetector.onTouchEvent(motionevent);
        }
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 1 1: default 56
    //                   1 75;
           goto _L1 _L2
_L1:
        if (movingLisener != null)
        {
            movingLisener.ImageMovingTouchEvent(motionevent);
        }
        return true;
_L2:
        if (getScale() < 1.0F)
        {
            zoomTo(1.0F, 50F);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onZoom(float f)
    {
        super.onZoom(f);
        if (!mScaleDetector.isInProgress())
        {
            mCurrentScaleFactor = f;
        }
    }

    public void setDoubleTapListener(cgc cgc)
    {
        doubleTapListener = cgc;
    }

    public void setDoubleTapToZoomEnabled(boolean flag)
    {
        mDoubleTapToZoomEnabled = flag;
    }

    public void setMinScale(float f)
    {
        MIN_ZOOM = f;
    }

    public void setMovingListener(bpn bpn1)
    {
        movingLisener = bpn1;
    }

    public void setScaleEnabled(boolean flag)
    {
        mScaleEnabled = flag;
    }

    public void setScrollEnabled(boolean flag)
    {
        mScrollEnabled = flag;
    }

    public void zoomScaleToFitView(float f, float f1, float f2)
    {
        float f3 = Math.min(getMaxZoom(), Math.max(f, MIN_ZOOM));
        mCurrentScaleFactor = f3;
        Log.v("ImageViewTouch", (new StringBuilder()).append("ImageViewTouch zoomScaleToFitView targetScale :").append(f3).toString());
        Log.v("ImageViewTouch", (new StringBuilder()).append("ImageViewTouch zoomScaleToFitView centerX :").append(f1).toString());
        Log.v("ImageViewTouch", (new StringBuilder()).append("ImageViewTouch zoomScaleToFitView centerY :").append(f2).toString());
        zoomTo(f, f1, f2, 5F);
        invalidate();
    }

}
