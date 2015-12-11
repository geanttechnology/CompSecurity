// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.amazon.now.media:
//            Gallery

public class PinchImageView extends ImageView
{
    private class GestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final PinchImageView this$0;

        public boolean onDoubleTap(MotionEvent motionevent)
        {
            if (mScaleFactor < 5F)
            {
                doubleTapScale(motionevent.getX(), motionevent.getY());
            } else
            {
                mGallery.setVisibility(0);
                setVisibility(4);
            }
            return true;
        }

        private GestureListener()
        {
            this$0 = PinchImageView.this;
            super();
        }

    }

    private class ScaleListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
    {

        final PinchImageView this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            updateScale(scalegesturedetector);
            return true;
        }

        private ScaleListener()
        {
            this$0 = PinchImageView.this;
            super();
        }

    }


    private int mActivePointerId;
    private Gallery mGallery;
    private GestureDetector mGestureListener;
    private float mLastTouchX;
    private float mLastTouchY;
    private float mMinScaleFactor;
    private float mPosX;
    private float mPosY;
    private ScaleGestureDetector mScaleDetector;
    private float mScaleFactor;

    public PinchImageView(Context context)
    {
        this(context, null, 0);
    }

    public PinchImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PinchImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMinScaleFactor = -1F;
        mScaleFactor = -1F;
        mActivePointerId = -1;
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener()) {

            final PinchImageView this$0;

            public boolean onTouchEvent(MotionEvent motionevent)
            {
                if (motionevent.getPointerCount() >= 2)
                {
                    return super.onTouchEvent(motionevent);
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = PinchImageView.this;
                super(context, onscalegesturelistener);
            }
        };
        mGestureListener = new GestureDetector(context, new GestureListener());
    }

    public void doubleTapScale(float f, float f1)
    {
        float f2 = mScaleFactor;
        mScaleFactor = Math.min(mScaleFactor * 3F, 5F);
        mPosX = mPosX - (f - mPosX) * (mScaleFactor / f2 - 1.0F);
        mPosY = mPosY - (f1 - mPosY) * (mScaleFactor / f2 - 1.0F);
        invalidate();
    }

    public void onDraw(Canvas canvas)
    {
        if (getDrawable() == null)
        {
            return;
        }
        float f = (float)getWidth() / 2.0F + (float)getDrawable().getIntrinsicWidth() * (mMinScaleFactor / 2.0F - mScaleFactor);
        float f1 = (float)getWidth() / 2.0F - ((float)getDrawable().getIntrinsicWidth() * mMinScaleFactor) / 2.0F;
        float f2 = (float)getHeight() / 2.0F + (float)getDrawable().getIntrinsicHeight() * (mMinScaleFactor / 2.0F - mScaleFactor);
        float f3 = (float)getHeight() / 2.0F - ((float)getDrawable().getIntrinsicHeight() * mMinScaleFactor) / 2.0F;
        if (mPosX < f)
        {
            mPosX = f;
        }
        if (mPosX > f1)
        {
            mPosX = f1;
        }
        if (mPosY < f2)
        {
            mPosY = f2;
        }
        if (mPosY > f3)
        {
            mPosY = f3;
        }
        canvas.save();
        canvas.translate(mPosX, mPosY);
        canvas.scale(mScaleFactor, mScaleFactor);
        getDrawable().draw(canvas);
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        i = 0;
        mGestureListener.onTouchEvent(motionevent);
        mScaleDetector.onTouchEvent(motionevent);
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 6: default 72
    //                   0 74
    //                   1 193
    //                   2 105
    //                   3 200
    //                   4 72
    //                   5 72
    //                   6 207;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L1 _L6
_L1:
        return true;
_L2:
        float f = motionevent.getX();
        float f2 = motionevent.getY();
        mLastTouchX = f;
        mLastTouchY = f2;
        mActivePointerId = motionevent.getPointerId(0);
        return true;
_L4:
        i = motionevent.findPointerIndex(mActivePointerId);
        float f1 = motionevent.getX(i);
        float f3 = motionevent.getY(i);
        if (!mScaleDetector.isInProgress())
        {
            float f4 = mLastTouchX;
            float f5 = mLastTouchY;
            mPosX = mPosX + (f1 - f4);
            mPosY = mPosY + (f3 - f5);
            invalidate();
        }
        mLastTouchX = f1;
        mLastTouchY = f3;
        return true;
_L3:
        mActivePointerId = -1;
        return true;
_L5:
        mActivePointerId = -1;
        return true;
_L6:
        int j = (motionevent.getAction() & 0xff00) >> 8;
        if (motionevent.getPointerId(j) == mActivePointerId)
        {
            if (j == 0)
            {
                i = 1;
            }
            mLastTouchX = motionevent.getX(i);
            mLastTouchY = motionevent.getY(i);
            mActivePointerId = motionevent.getPointerId(i);
            return true;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    protected void onVisibilityChanged(View view, int i)
    {
        if (i == 0)
        {
            view = (ImageView)mGallery.getChildAt(mGallery.getCurrentPage());
            if (view != null)
            {
                view = view.getDrawable();
                setImageDrawable(view);
                mMinScaleFactor = Math.min((float)getHeight() / (float)view.getIntrinsicHeight(), (float)getWidth() / (float)view.getIntrinsicWidth());
                mScaleFactor = mMinScaleFactor;
                mPosX = (float)getWidth() / 2.0F - ((float)getDrawable().getIntrinsicWidth() * mMinScaleFactor) / 2.0F;
                mPosY = (float)getHeight() / 2.0F - ((float)getDrawable().getIntrinsicHeight() * mMinScaleFactor) / 2.0F;
            }
        } else
        if (mGallery != null)
        {
            mGallery.setCurrentPage(mGallery.getCurrentPage());
            return;
        }
    }

    public void setGallery(Gallery gallery)
    {
        mGallery = gallery;
    }

    public void updateScale(ScaleGestureDetector scalegesturedetector)
    {
        mScaleFactor = mScaleFactor * scalegesturedetector.getScaleFactor();
        mScaleFactor = Math.min(mScaleFactor, 5F);
        if (mScaleFactor < mMinScaleFactor)
        {
            mGallery.setVisibility(0);
            setVisibility(4);
            return;
        }
        if (mScaleFactor < 5F)
        {
            float f = scalegesturedetector.getFocusX();
            float f1 = scalegesturedetector.getFocusY();
            mPosX = mPosX - (f - mPosX) * (scalegesturedetector.getScaleFactor() - 1.0F);
            mPosY = mPosY - (f1 - mPosY) * (scalegesturedetector.getScaleFactor() - 1.0F);
        }
        invalidate();
    }


}
