// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.poshmark.utils.ImageUtils;

public class ScalableView extends ImageView
    implements android.view.View.OnTouchListener, android.view.ScaleGestureDetector.OnScaleGestureListener
{

    private static final int CREATE_COVERSHOT = 1;
    private static final int CREATE_THUMBNAIL = 0;
    private static final String DEFAULT_BACKGROUND_COLOR_ID = "#99000000";
    private static final String DEFAULT_GRIDLINE_COLOUR_ID = "#FFFFFF";
    private static final int GRID_COLUMN_COUNT = 3;
    private static final int GRID_ROW_COUNT = 3;
    private static final float MAX_SCALEFACTOR = 3F;
    private static final float MIN_SCALEFACTOR = 0.5F;
    private int INVALID_POINTER_ID;
    private int active_pointer_id;
    private Paint backgroundPaint;
    private Bitmap bitmap;
    private String bmpFileName;
    private Canvas canvas;
    private float cropImageWidth;
    private RectF cropSpace;
    private float mCenterX;
    private float mCenterY;
    private Paint mGridLinePaint;
    private float mLastTouchX;
    private float mLastTouchY;
    private float mPosX;
    private float mPosY;
    private float mPts[];
    private float mScaleFactor;
    private Paint mTransparentLayerPaint;
    private Matrix matrix;
    DisplayMetrics metrics;
    private int parentHeight;
    private int parentWidth;
    private float pivotX;
    private float pivotY;
    private Bitmap resizedBitmap;
    private ScaleGestureDetector scaleGestureDetector;

    public ScalableView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        INVALID_POINTER_ID = -1;
        active_pointer_id = INVALID_POINTER_ID;
        mScaleFactor = 1.0F;
        mPosX = 0.0F;
        mPosY = 0.0F;
        mCenterX = 0.0F;
        mCenterY = 0.0F;
        scaleGestureDetector = new ScaleGestureDetector(context, this);
        setOnTouchListener(this);
        cropSpace = new RectF();
        matrix = new Matrix();
        metrics = new DisplayMetrics();
        backgroundPaint = new Paint();
        mTransparentLayerPaint = new Paint();
        mTransparentLayerPaint.setColor(Color.parseColor("#99000000"));
        mGridLinePaint = new Paint();
        mGridLinePaint.setColor(Color.parseColor("#FFFFFF"));
        mPts = new float[16];
    }

    private void drawGrid(Canvas canvas1)
    {
        int k = 0;
        int i = 0;
        for (; k < 2; k++)
        {
            float af[] = mPts;
            int l = i + 1;
            af[i] = cropSpace.left;
            af = mPts;
            i = l + 1;
            af[l] = (cropSpace.height() * ((float)k + 1.0F)) / 3F + cropSpace.top;
            af = mPts;
            l = i + 1;
            af[i] = cropSpace.right;
            af = mPts;
            i = l + 1;
            af[l] = (cropSpace.height() * ((float)k + 1.0F)) / 3F + cropSpace.top;
        }

        boolean flag = false;
        k = i;
        for (int j = ((flag) ? 1 : 0); j < 2; j++)
        {
            float af1[] = mPts;
            int i1 = k + 1;
            af1[k] = (cropSpace.width() * ((float)j + 1.0F)) / 3F + cropSpace.left;
            af1 = mPts;
            k = i1 + 1;
            af1[i1] = cropSpace.top;
            af1 = mPts;
            i1 = k + 1;
            af1[k] = (cropSpace.width() * ((float)j + 1.0F)) / 3F + cropSpace.left;
            af1 = mPts;
            k = i1 + 1;
            af1[i1] = cropSpace.bottom;
        }

        canvas1.drawLines(mPts, mGridLinePaint);
    }

    private void drawTransparentLayer(Canvas canvas1)
    {
        Rect rect = new Rect();
        getLocalVisibleRect(rect);
        canvas1.drawRect(rect.left, rect.top, rect.right, cropSpace.top, mTransparentLayerPaint);
        canvas1.drawRect(rect.left, cropSpace.bottom, cropSpace.right, rect.bottom, mTransparentLayerPaint);
        canvas1.drawRect(rect.left, cropSpace.top, cropSpace.left, cropSpace.bottom, mTransparentLayerPaint);
        canvas1.drawRect(cropSpace.right, cropSpace.top, rect.right, cropSpace.bottom, mTransparentLayerPaint);
    }

    private Bitmap resize(Bitmap bitmap1, int i)
    {
        Bitmap bitmap2 = Bitmap.createBitmap(i, i, android.graphics.Bitmap.Config.ARGB_8888);
        float f2 = cropImageWidth / cropSpace.width();
        float f = cropImageWidth / (float)bitmap1.getWidth();
        Object obj = new RectF();
        matrix.mapRect(((RectF) (obj)));
        f = ((RectF) (obj)).left;
        float f3 = cropSpace.left;
        float f1 = ((RectF) (obj)).top - cropSpace.top;
        Canvas canvas1;
        Paint paint;
        if (((RectF) (obj)).left > 10F)
        {
            f = (f - f3) * f2;
        } else
        {
            f = 0.0F;
        }
        if (f1 > 0.0F)
        {
            f1 *= f2;
        } else
        {
            f1 = 0.0F;
        }
        obj = new Matrix();
        ((Matrix) (obj)).setScale(f2, f2);
        ((Matrix) (obj)).postTranslate(f, f1);
        canvas1 = new Canvas(bitmap2);
        paint = new Paint();
        paint.setFilterBitmap(false);
        canvas1.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        canvas1.drawBitmap(bitmap1, ((Matrix) (obj)), paint);
        return bitmap2;
    }

    public Uri getCroppedImage()
    {
        RectF rectf = new RectF();
        matrix.mapRect(rectf);
        resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        int i = (int)rectf.left;
        i = (int)cropSpace.left - i;
        int j = (int)rectf.top;
        j = (int)cropSpace.top - j;
        int k = (int)rectf.left;
        int l = resizedBitmap.getWidth();
        k = (int)cropSpace.right - (k + l);
        l = (int)rectf.top;
        int i1 = resizedBitmap.getHeight();
        l = (int)cropSpace.bottom - (l + i1);
        int j1;
        if (i < 0)
        {
            i = 0;
        } else
        {
            i = Math.abs(i);
        }
        if (j < 0)
        {
            j = 0;
        } else
        {
            j = Math.abs(j);
        }
        if (k > 0)
        {
            k = i;
        } else
        {
            k = Math.abs(k) + i;
        }
        if (l > 0)
        {
            l = j;
        } else
        {
            l = Math.abs(l) + j;
        }
        i1 = resizedBitmap.getWidth();
        j1 = resizedBitmap.getHeight();
        return ImageUtils.saveBitmapToDisk(resize(Bitmap.createBitmap(resizedBitmap, i, j, i1 - k, j1 - l, matrix, true), (int)cropImageWidth));
    }

    protected void onDraw(Canvas canvas1)
    {
        canvas = canvas1;
        canvas1.save();
        matrix.reset();
        matrix.setScale(mScaleFactor, mScaleFactor, pivotX, pivotY);
        matrix.postTranslate(mPosX, mPosY);
        canvas1.drawBitmap(bitmap, matrix, backgroundPaint);
        drawGrid(canvas1);
        canvas1.restore();
    }

    protected void onMeasure(int i, int j)
    {
        parentWidth = android.view.View.MeasureSpec.getSize(i);
        parentHeight = android.view.View.MeasureSpec.getSize(j);
        setMeasuredDimension(parentWidth, parentHeight);
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        Log.d("MytextView", (new StringBuilder()).append("onScale").append(scalegesturedetector.getScaleFactor()).toString());
        mScaleFactor = mScaleFactor * scalegesturedetector.getScaleFactor();
        mScaleFactor = Math.max(0.5F, Math.min(mScaleFactor, 3F));
        invalidate();
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        Log.d("MytextView", "onScaleBegin");
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        Log.d("MytextView", "onScaleEnd");
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i;
        i = 0;
        scaleGestureDetector.onTouchEvent(motionevent);
        MotionEventCompat.getActionMasked(motionevent);
        JVM INSTR tableswitch 0 6: default 60
    //                   0 62
    //                   1 196
    //                   2 105
    //                   3 206
    //                   4 60
    //                   5 60
    //                   6 216;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L1 _L6
_L1:
        return true;
_L2:
        i = MotionEventCompat.getActionIndex(motionevent);
        float f = MotionEventCompat.getX(motionevent, i);
        float f2 = MotionEventCompat.getY(motionevent, i);
        mLastTouchX = f;
        mLastTouchY = f2;
        active_pointer_id = MotionEventCompat.getPointerId(motionevent, 0);
        return true;
_L4:
        i = MotionEventCompat.findPointerIndex(motionevent, active_pointer_id);
        float f1 = MotionEventCompat.getX(motionevent, i);
        float f3 = MotionEventCompat.getY(motionevent, i);
        if (!scaleGestureDetector.isInProgress())
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
        active_pointer_id = INVALID_POINTER_ID;
        return true;
_L5:
        active_pointer_id = INVALID_POINTER_ID;
        return true;
_L6:
        int j = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, j) == active_pointer_id)
        {
            if (j == 0)
            {
                i = 1;
            }
            mLastTouchX = MotionEventCompat.getX(motionevent, i);
            mLastTouchY = MotionEventCompat.getY(motionevent, i);
            active_pointer_id = MotionEventCompat.getPointerId(motionevent, i);
            return true;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void setFileName(String s)
    {
        bmpFileName = s;
    }

    public void setMode(int i)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            cropImageWidth = 100F;
            return;

        case 1: // '\001'
            cropImageWidth = 1024F;
            break;
        }
    }

    public void setupBitmap(Rect rect)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        int i = ImageUtils.calculateInSampleSize(options, parentWidth, parentHeight);
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        bitmap = BitmapFactoryInstrumentation.decodeFile(bmpFileName, options);
        float f = (rect.left + rect.width() / 2) - bitmap.getWidth() / 2;
        mCenterX = f;
        mPosX = f;
        f = (rect.top + rect.height() / 2) - bitmap.getHeight() / 2;
        mCenterY = f;
        mPosY = f;
        pivotX = bitmap.getWidth() / 2;
        pivotY = bitmap.getHeight() / 2;
        cropSpace.left = rect.left;
        cropSpace.top = rect.top;
        cropSpace.right = rect.left + rect.width();
        cropSpace.bottom = rect.top + rect.height();
        setScaleType(android.widget.ImageView.ScaleType.CENTER);
        invalidate();
    }
}
