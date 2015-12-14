// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.graphics.IBitmapDrawable;

public class ImageViewSpotDraw extends ImageViewTouch
{
    public static interface OnDrawListener
    {

        public abstract void onDrawEnd();

        public abstract void onDrawStart(float af[], float f);

        public abstract void onDrawing(float af[], float f);
    }

    public static final class TouchMode extends Enum
    {

        private static final TouchMode $VALUES[];
        public static final TouchMode DRAW;
        public static final TouchMode IMAGE;

        public static TouchMode valueOf(String s)
        {
            return (TouchMode)Enum.valueOf(com/aviary/android/feather/sdk/widget/ImageViewSpotDraw$TouchMode, s);
        }

        public static TouchMode[] values()
        {
            return (TouchMode[])$VALUES.clone();
        }

        static 
        {
            IMAGE = new TouchMode("IMAGE", 0);
            DRAW = new TouchMode("DRAW", 1);
            $VALUES = (new TouchMode[] {
                IMAGE, DRAW
            });
        }

        private TouchMode(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final float TOUCH_TOLERANCE = 2F;
    protected float mBrushSize;
    protected Canvas mCanvas;
    protected float mCurrentScale;
    private OnDrawListener mDrawListener;
    protected Matrix mIdentityMatrix;
    protected Matrix mInvertedMatrix;
    private boolean mMoved;
    protected Paint mPaint;
    private double mRestiction;
    protected float mStartX;
    protected float mStartY;
    protected TouchMode mTouchMode;
    protected float mX;
    protected float mY;
    protected Path tmpPath;

    public ImageViewSpotDraw(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ImageViewSpotDraw(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mBrushSize = 30F;
        mCurrentScale = 1.0F;
        tmpPath = new Path();
        mTouchMode = TouchMode.DRAW;
        mIdentityMatrix = new Matrix();
        mInvertedMatrix = new Matrix();
        mRestiction = 0.0D;
        mMoved = false;
    }

    public static float[] getMatrixValues(Matrix matrix)
    {
        float af[] = new float[9];
        matrix.getValues(af);
        return af;
    }

    private void onTouchMove(float f, float f1)
    {
        float f4;
        float f5;
label0:
        {
            float f3 = Math.abs(f - mX);
            float f2 = Math.abs(f1 - mY);
            if (f3 < 2.0F)
            {
                f4 = f;
                f5 = f1;
                if (f2 < 2.0F)
                {
                    break label0;
                }
            }
            if (!mMoved && mPaint != null)
            {
                tmpPath.setLastPoint(mX, mY);
            }
            mMoved = true;
            f3 = f;
            f2 = f1;
            if (mRestiction > 0.0D)
            {
                double d1 = Math.sqrt(Math.pow(f - mStartX, 2D) + Math.pow(f1 - mStartY, 2D));
                double d = Math.atan2(f1 - mStartY, f - mStartX);
                f = getWidth();
                f1 = getHeight();
                double d2 = mRestiction / (double)mCurrentScale / (double)(f + f1) / (double)(mBrushSize / mCurrentScale);
                d1 = Math.log(d1 * d2 + 1.0D) / d2;
                f3 = (float)((double)mStartX + Math.cos(d) * d1);
                f2 = (float)((double)mStartY + Math.sin(d) * d1);
            }
            mX = f3;
            mY = f2;
            f4 = f3;
            f5 = f2;
            if (mPaint != null)
            {
                tmpPath.quadTo(mX, mY, (mX + f3) / 2.0F, (mY + f2) / 2.0F);
                f5 = f2;
                f4 = f3;
            }
        }
        if (mDrawListener != null)
        {
            float af[] = new float[2];
            af[0] = f4;
            af[1] = f5;
            mInvertedMatrix.mapPoints(af);
            mDrawListener.onDrawing(af, mBrushSize / mCurrentScale);
        }
    }

    private void onTouchStart(float f, float f1)
    {
        mMoved = false;
        tmpPath.reset();
        if (mPaint != null)
        {
            tmpPath.moveTo(f, f1);
        }
        mX = f;
        mY = f1;
        mStartX = f;
        mStartY = f1;
        if (mDrawListener != null)
        {
            float af[] = new float[2];
            af[0] = f;
            af[1] = f1;
            mInvertedMatrix.mapPoints(af);
            mDrawListener.onDrawStart(af, mBrushSize / mCurrentScale);
        }
    }

    private void onTouchUp()
    {
        if (mDrawListener != null)
        {
            mDrawListener.onDrawEnd();
        }
    }

    public TouchMode getDrawMode()
    {
        return mTouchMode;
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

    public Paint getPaint()
    {
        return mPaint;
    }

    protected void init(Context context, AttributeSet attributeset, int i)
    {
        super.init(context, attributeset, i);
        tmpPath = new Path();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mPaint != null)
        {
            canvas.drawPath(tmpPath, mPaint);
        }
    }

    protected void onDrawModeChanged()
    {
        if (mTouchMode == TouchMode.DRAW)
        {
            Log.i("ImageViewTouchBase", "onDrawModeChanged");
            Matrix matrix = new Matrix(getImageMatrix());
            mInvertedMatrix.reset();
            float af[] = getMatrixValues(matrix);
            matrix.invert(matrix);
            float af1[] = getMatrixValues(matrix);
            mInvertedMatrix.postTranslate(-af[2], -af[5]);
            mInvertedMatrix.postScale(af1[0], af1[4]);
            mCanvas.setMatrix(mInvertedMatrix);
            mCurrentScale = getScale() * getBaseScale();
            if (mPaint != null)
            {
                mPaint.setStrokeWidth(mBrushSize);
            }
        }
    }

    protected void onDrawableChanged(Drawable drawable)
    {
        super.onDrawableChanged(drawable);
        if (drawable != null && (drawable instanceof IBitmapDrawable))
        {
            mCanvas = new Canvas();
            mCanvas.drawColor(0);
            onDrawModeChanged();
        }
    }

    protected void onLayoutChanged(int i, int j, int k, int l)
    {
        super.onLayoutChanged(i, j, k, l);
        if (getDrawable() != null)
        {
            onDrawModeChanged();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mTouchMode == TouchMode.DRAW && motionevent.getPointerCount() == 1)
        {
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            switch (motionevent.getAction())
            {
            default:
                return true;

            case 0: // '\0'
                onTouchStart(f, f1);
                invalidate();
                return true;

            case 2: // '\002'
                onTouchMove(f, f1);
                invalidate();
                return true;

            case 1: // '\001'
                onTouchUp();
                invalidate();
                return true;
            }
        }
        if (mTouchMode == TouchMode.IMAGE)
        {
            return super.onTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public void setBrushSize(float f)
    {
        mBrushSize = f;
        if (mPaint != null)
        {
            mPaint.setStrokeWidth(mBrushSize);
        }
    }

    public void setDrawLimit(double d)
    {
        mRestiction = d;
    }

    public void setDrawMode(TouchMode touchmode)
    {
        if (touchmode != mTouchMode)
        {
            mTouchMode = touchmode;
            onDrawModeChanged();
        }
    }

    public void setOnDrawStartListener(OnDrawListener ondrawlistener)
    {
        mDrawListener = ondrawlistener;
    }

    public void setPaint(Paint paint)
    {
        mPaint.set(paint);
    }

    public void setPaintEnabled(boolean flag)
    {
        if (flag)
        {
            mPaint = new Paint(1);
            mPaint.setFilterBitmap(false);
            mPaint.setDither(true);
            mPaint.setColor(0x66ffffcc);
            mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        }
    }
}
