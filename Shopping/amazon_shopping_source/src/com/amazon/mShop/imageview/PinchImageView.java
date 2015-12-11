// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.imageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.amazon.mShop.util.ConfigUtils;

// Referenced classes of package com.amazon.mShop.imageview:
//            BasePinchImageView, MShopScaleGestoreDetector

public class PinchImageView extends BasePinchImageView
{
    class GestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final PinchImageView this$0;

        public boolean onDoubleTap(MotionEvent motionevent)
        {
            float f = getScale();
            f = onDoubleTapPost(f, 4F);
            zoomTo(f, motionevent.getX(), motionevent.getY());
            invalidate();
            return super.onDoubleTap(motionevent);
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            while (motionevent == null || motionevent1 == null || motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || mScaleDetector.isInProgress() || getScale() <= 1.0F) 
            {
                return false;
            }
            scrollBy(-f, -f1);
            invalidate();
            return super.onScroll(motionevent, motionevent1, f, f1);
        }

        GestureListener()
        {
            this$0 = PinchImageView.this;
            super();
        }
    }

    class ScaleListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
    {

        final PinchImageView this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            updateScale(scalegesturedetector);
            return true;
        }

        ScaleListener()
        {
            this$0 = PinchImageView.this;
            super();
        }
    }


    private GestureDetector mGestureDetector;
    private MShopScaleGestoreDetector.VersionedGestureDetector mScaleDetector;

    public PinchImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void init()
    {
        super.init();
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 8)
        {
            mScaleDetector = MShopScaleGestoreDetector.newInstance(getContext(), new ScaleListener());
        } else
        {
            mScaleDetector = MShopScaleGestoreDetector.newInstance(getContext(), null);
        }
        mGestureDetector = new GestureDetector(getContext(), new GestureListener());
    }

    public float onDoubleTapPost(float f, float f1)
    {
        if (f < f1 / 2.0F)
        {
            mCurrentScaleFactor = f1 / 2.0F;
        } else
        if (f >= f1 / 2.0F && f < f1)
        {
            mCurrentScaleFactor = f1;
        } else
        {
            mCurrentScaleFactor = 1.0F;
        }
        return mCurrentScaleFactor;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (ConfigUtils.isEnabledForApp(getContext(), com.amazon.mShop.android.lib.R.bool.config_isSupportPinchZoom))
        {
            mScaleDetector.onTouchEvent(motionevent);
            if (!mScaleDetector.isInProgress())
            {
                mGestureDetector.onTouchEvent(motionevent);
            }
        } else
        {
            mGestureDetector.onTouchEvent(motionevent);
        }
        return true;
    }

    public void updateScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = Math.min(4F, mCurrentScaleFactor * scalegesturedetector.getScaleFactor());
        zoomTo(f, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
        mCurrentScaleFactor = f;
        invalidate();
    }

}
