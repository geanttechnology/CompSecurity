// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.graphics.IBitmapDrawable;

public class ImageViewTouchAndDraw extends ImageViewTouch
{
    public static interface OnDrawPathListener
    {

        public abstract void onEnd();

        public abstract void onLineTo(float f, float f1);

        public abstract void onMoveTo(float f, float f1);

        public abstract void onQuadTo(float f, float f1, float f2, float f3);

        public abstract void onStart();
    }

    public static interface OnDrawStartListener
    {

        public abstract void onDrawStart();
    }

    public static final class TouchMode extends Enum
    {

        private static final TouchMode $VALUES[];
        public static final TouchMode DRAW;
        public static final TouchMode IMAGE;

        public static TouchMode valueOf(String s)
        {
            return (TouchMode)Enum.valueOf(com/aviary/android/feather/sdk/widget/ImageViewTouchAndDraw$TouchMode, s);
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


    public static final float DEFAULT_STROKE_WIDTH = 10F;
    protected static final float TOUCH_TOLERANCE = 4F;
    protected Canvas mCanvas;
    protected Bitmap mCopy;
    private OnDrawStartListener mDrawListener;
    private OnDrawPathListener mDrawPathListener;
    protected Matrix mIdentityMatrix;
    protected Matrix mInvertedMatrix;
    protected Paint mPaint;
    protected TouchMode mTouchMode;
    private boolean mTouchStarted;
    protected float mX;
    protected float mY;
    protected Path tmpPath;

    public ImageViewTouchAndDraw(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ImageViewTouchAndDraw(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        tmpPath = new Path();
        mTouchMode = TouchMode.DRAW;
        mIdentityMatrix = new Matrix();
        mInvertedMatrix = new Matrix();
    }

    public static float[] getMatrixValues(Matrix matrix)
    {
        float af[] = new float[9];
        matrix.getValues(af);
        return af;
    }

    private void onTouchMove(float f, float f1)
    {
        if (!mTouchStarted)
        {
            Log.w("ImageViewTouchBase", "touch not started!");
        } else
        {
            float f2 = Math.abs(f - mX);
            float f4 = Math.abs(f1 - mY);
            if (f2 >= 4F || f4 >= 4F)
            {
                float f3 = (mX + f) / 2.0F;
                float f5 = (mY + f1) / 2.0F;
                tmpPath.quadTo(mX, mY, f3, f5);
                mCanvas.drawPath(tmpPath, mPaint);
                tmpPath.reset();
                tmpPath.moveTo(f3, f5);
                if (mDrawPathListener != null)
                {
                    float af[] = new float[4];
                    af[0] = mX;
                    af[1] = mY;
                    af[2] = f3;
                    af[3] = f5;
                    mInvertedMatrix.mapPoints(af);
                    mDrawPathListener.onQuadTo(af[0], af[1], af[2], af[3]);
                }
                mX = f;
                mY = f1;
                return;
            }
        }
    }

    private void onTouchStart(float f, float f1)
    {
        Log.i("ImageViewTouchBase", "onTouchStart");
        if (mTouchStarted)
        {
            Log.w("ImageViewTouchBase", "touch already started!");
        } else
        {
            mTouchStarted = true;
            tmpPath.reset();
            tmpPath.moveTo(f, f1);
            mX = f;
            mY = f1;
            if (mDrawListener != null)
            {
                mDrawListener.onDrawStart();
            }
            if (mDrawPathListener != null)
            {
                mDrawPathListener.onStart();
                mCanvas.drawPoint(f, f1, mPaint);
                float af[] = new float[2];
                af[0] = f;
                af[1] = f1;
                mInvertedMatrix.mapPoints(af);
                mDrawPathListener.onMoveTo(af[0], af[1]);
                return;
            }
        }
    }

    private void onTouchUp()
    {
        if (mTouchStarted)
        {
            tmpPath.reset();
            if (mDrawPathListener != null)
            {
                mDrawPathListener.onEnd();
            }
        }
        mTouchStarted = false;
    }

    public void commit(Canvas canvas)
    {
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof IBitmapDrawable))
        {
            canvas.drawBitmap(((IBitmapDrawable)drawable).getBitmap(), new Matrix(), null);
            canvas.drawBitmap(mCopy, new Matrix(), null);
        }
    }

    public TouchMode getDrawMode()
    {
        return mTouchMode;
    }

    public float getDrawingScale()
    {
        return getScale(mInvertedMatrix);
    }

    public Bitmap getOverlayBitmap()
    {
        return mCopy;
    }

    public Paint getPaint()
    {
        return mPaint;
    }

    protected void init(Context context, AttributeSet attributeset, int i)
    {
        super.init(context, attributeset, i);
        Log.i("ImageViewTouchBase", (new StringBuilder()).append("init, paint: ").append(mPaint).toString());
        mPaint = new Paint(5);
        mPaint.setFilterBitmap(false);
        mPaint.setColor(0xffff0000);
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        mPaint.setStrokeWidth(10F);
        tmpPath = new Path();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mCopy != null)
        {
            int i = canvas.getSaveCount();
            canvas.save();
            canvas.drawBitmap(mCopy, getImageMatrix(), null);
            canvas.restoreToCount(i);
        }
    }

    protected void onDrawModeChanged()
    {
        if (mTouchMode == TouchMode.DRAW)
        {
            Matrix matrix = new Matrix(getImageMatrix());
            mInvertedMatrix.reset();
            float af[] = getMatrixValues(matrix);
            matrix.invert(matrix);
            float af1[] = getMatrixValues(matrix);
            mInvertedMatrix.postTranslate(-af[2], -af[5]);
            mInvertedMatrix.postScale(af1[0], af1[4]);
            mCanvas.setMatrix(mInvertedMatrix);
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("scale: ").append(getScale(mInvertedMatrix)).toString());
        }
    }

    protected void onDrawableChanged(Drawable drawable)
    {
        super.onDrawableChanged(drawable);
        if (mCopy != null)
        {
            mCopy.recycle();
            mCopy = null;
        }
        if (drawable != null && (drawable instanceof IBitmapDrawable))
        {
            drawable = ((IBitmapDrawable)drawable).getBitmap();
            mCopy = Bitmap.createBitmap(drawable.getWidth(), drawable.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mCopy);
            mCanvas.drawColor(0);
            onDrawModeChanged();
        }
    }

    protected void onLayoutChanged(int i, int j, int k, int l)
    {
        super.onLayoutChanged(i, j, k, l);
        onDrawModeChanged();
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
            case 3: // '\003'
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

    public void setDrawMode(TouchMode touchmode)
    {
        if (touchmode != mTouchMode)
        {
            mTouchMode = touchmode;
            onDrawModeChanged();
        }
    }

    public void setOnDrawPathListener(OnDrawPathListener ondrawpathlistener)
    {
        mDrawPathListener = ondrawpathlistener;
    }

    public void setOnDrawStartListener(OnDrawStartListener ondrawstartlistener)
    {
        mDrawListener = ondrawstartlistener;
    }

    public void setPaint(Paint paint)
    {
        mPaint.set(paint);
    }
}
