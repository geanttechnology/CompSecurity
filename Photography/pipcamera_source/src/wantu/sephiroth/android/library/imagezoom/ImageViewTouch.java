// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wantu.sephiroth.android.library.imagezoom;

import aip;
import aiq;
import air;
import ais;
import ait;
import ajb;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import re;

// Referenced classes of package wantu.sephiroth.android.library.imagezoom:
//            ImageViewTouchBase

public class ImageViewTouch extends ImageViewTouchBase
{

    public float MIN_ZOOM;
    private aiq doubleTapListener;
    private air longPressListener;
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
    private boolean mTouchStart;
    private re movingLisener;
    private ais singleTapListener;

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
        Bitmap bitmap;
        try
        {
            int k = getWidth();
            float f = (float)i / (float)k;
            bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Matrix matrix = getImageMatrix();
            matrix.postScale(f, f);
            Bitmap bitmap1 = ((ajb)getDrawable()).a();
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            canvas.drawBitmap(bitmap1, matrix, paint);
        }
        catch (Exception exception)
        {
            return null;
        }
        return bitmap;
    }

    public boolean getDoubleTapEnabled()
    {
        return mDoubleTapToZoomEnabled;
    }

    protected android.view.GestureDetector.OnGestureListener getGestureListener()
    {
        return new aip(this);
    }

    protected android.view.ScaleGestureDetector.OnScaleGestureListener getScaleListener()
    {
        return new ait(this);
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
        int i;
        i = motionevent.getAction();
        if (i == 0)
        {
            mTouchStart = true;
        }
        mScaleDetector.onTouchEvent(motionevent);
        if (!mScaleDetector.isInProgress())
        {
            mGestureDetector.onTouchEvent(motionevent);
        }
        i & 0xff;
        JVM INSTR tableswitch 1 1: default 64
    //                   1 83;
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

    public void setDoubleTapListener(aiq aiq)
    {
        doubleTapListener = aiq;
    }

    public void setDoubleTapToZoomEnabled(boolean flag)
    {
        mDoubleTapToZoomEnabled = flag;
    }

    public void setLongPressListener(air air)
    {
        longPressListener = air;
    }

    public void setMinScale(float f)
    {
        MIN_ZOOM = f;
    }

    public void setMovingListener(re re1)
    {
        movingLisener = re1;
    }

    public void setScaleEnabled(boolean flag)
    {
        mScaleEnabled = flag;
    }

    public void setScrollEnabled(boolean flag)
    {
        mScrollEnabled = flag;
    }

    public void setSingleTapListener(ais ais)
    {
        singleTapListener = ais;
    }

    public void zoomScaleToFitView(float f, float f1, float f2)
    {
        mCurrentScaleFactor = Math.min(getMaxZoom(), Math.max(f, MIN_ZOOM));
        zoomTo(f, f1, f2, 5F);
        invalidate();
    }






/*
    public static boolean access$302(ImageViewTouch imageviewtouch, boolean flag)
    {
        imageviewtouch.mTouchStart = flag;
        return flag;
    }

*/
}
