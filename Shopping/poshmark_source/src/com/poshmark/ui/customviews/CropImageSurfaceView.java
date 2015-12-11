// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.poshmark.utils.ImageUtils;

public class CropImageSurfaceView extends SurfaceView
    implements android.view.SurfaceHolder.Callback
{

    public static final int CREATE_COVERSHOT = 1;
    public static final int CREATE_THUMBNAIL = 0;
    int angle;
    private boolean bIsDragging;
    private String bmpFileName;
    int cropImageWidth;
    private float diffX;
    private float diffY;
    private SurfaceHolder mHolder;
    float originalHeight;
    float originalWidth;
    Paint paint;
    private int parentHeight;
    private int parentWidth;
    private float prevX;
    private float prevY;
    float rotatedHeight;
    float rotatedWidth;
    float scale;
    Bitmap selectedImage;
    Rect viewportRect;
    float xTranslation;
    float yTranslation;

    public CropImageSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        xTranslation = 0.0F;
        yTranslation = 0.0F;
        scale = 0.0F;
        bIsDragging = false;
        diffX = 0.0F;
        diffY = 0.0F;
        paint = new Paint();
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(3);
    }

    private void drawImage(Canvas canvas)
    {
        if (bmpFileName != null)
        {
            yTranslation = yTranslation + diffY;
            Matrix matrix = new Matrix();
            matrix.preScale(scale, scale);
            matrix.postTranslate(xTranslation, yTranslation);
            Paint paint1 = new Paint();
            paint1.setFilterBitmap(true);
            canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            canvas.drawBitmap(selectedImage, matrix, paint1);
        }
    }

    private void moveImage()
    {
        Canvas canvas;
        Canvas canvas1;
        invalidate();
        canvas1 = null;
        canvas = null;
        Canvas canvas2 = mHolder.lockCanvas(null);
        canvas = canvas2;
        canvas1 = canvas2;
        SurfaceHolder surfaceholder = mHolder;
        canvas = canvas2;
        canvas1 = canvas2;
        surfaceholder;
        JVM INSTR monitorenter ;
        drawImage(canvas2);
        surfaceholder;
        JVM INSTR monitorexit ;
        if (canvas2 != null)
        {
            mHolder.unlockCanvasAndPost(canvas2);
        }
_L2:
        return;
        Exception exception2;
        exception2;
        surfaceholder;
        JVM INSTR monitorexit ;
        canvas = canvas2;
        canvas1 = canvas2;
        throw exception2;
        Exception exception1;
        exception1;
        canvas1 = canvas;
        exception1.printStackTrace();
        if (canvas == null) goto _L2; else goto _L1
_L1:
        mHolder.unlockCanvasAndPost(canvas);
        return;
        Exception exception;
        exception;
        if (canvas1 != null)
        {
            mHolder.unlockCanvasAndPost(canvas1);
        }
        throw exception;
    }

    public Uri getBitmap(Rect rect)
    {
        Matrix matrix = new Matrix();
        float f = (float)cropImageWidth / rotatedWidth;
        float f1 = (float)cropImageWidth / rotatedHeight;
        matrix.preScale(f, f);
        int i = (int)(((float)rect.top - yTranslation) * ((float)cropImageWidth / (float)rect.height()));
        matrix.postTranslate(0, i * -1);
        rect = Bitmap.createBitmap(cropImageWidth, cropImageWidth, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(rect);
        Paint paint1 = new Paint();
        paint1.setFilterBitmap(true);
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        canvas.drawBitmap(selectedImage, matrix, paint1);
        selectedImage.recycle();
        selectedImage = null;
        return ImageUtils.saveBitmapToDisk(rect);
    }

    public void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (flag)
        {
            layout(0, 0, parentWidth, parentHeight);
        }
    }

    protected void onMeasure(int i, int j)
    {
        parentWidth = android.view.View.MeasureSpec.getSize(i);
        parentHeight = android.view.View.MeasureSpec.getSize(j);
        setMeasuredDimension(parentWidth, parentHeight);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 4: default 40
    //                   0 42
    //                   1 108
    //                   2 61
    //                   3 111
    //                   4 114;
           goto _L1 _L2 _L1 _L3 _L1 _L1
_L1:
        return true;
_L2:
        prevX = motionevent.getX();
        prevY = motionevent.getY();
        continue; /* Loop/switch isn't completed */
_L3:
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        diffX = f - prevX;
        diffY = f1 - prevY;
        prevX = f;
        prevY = f1;
        moveImage();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setFile(String s)
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
            cropImageWidth = 100;
            return;

        case 1: // '\001'
            cropImageWidth = 1024;
            break;
        }
    }

    public void setViewPortRect(Rect rect)
    {
        viewportRect = rect;
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        if (mHolder.getSurface() != null);
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Object obj;
        Object obj1;
        Canvas canvas;
        setWillNotDraw(false);
        if (bmpFileName == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        angle = ImageUtils.exifOrientation(bmpFileName);
        obj = new android.graphics.BitmapFactory.Options();
        obj.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeFile(bmpFileName, ((android.graphics.BitmapFactory.Options) (obj)));
        int i = ImageUtils.calculateInSampleSize(((android.graphics.BitmapFactory.Options) (obj)), parentWidth, parentHeight);
        obj.inJustDecodeBounds = false;
        obj.inSampleSize = i;
        obj = BitmapFactoryInstrumentation.decodeFile(bmpFileName, ((android.graphics.BitmapFactory.Options) (obj)));
        originalWidth = ((Bitmap) (obj)).getWidth();
        originalHeight = ((Bitmap) (obj)).getHeight();
        if (angle == 90 || angle == 270)
        {
            rotatedHeight = originalWidth;
            rotatedWidth = originalHeight;
        } else
        {
            rotatedHeight = originalHeight;
            rotatedWidth = originalWidth;
        }
        scale = (float)(parentWidth - viewportRect.left * 2) / rotatedWidth;
        xTranslation = 10F;
        yTranslation = ((float)parentHeight - rotatedHeight * scale) / 2.0F;
        obj1 = new Matrix();
        if (angle != 0)
        {
            ((Matrix) (obj1)).postRotate(90F);
            selectedImage = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, (int)originalWidth, (int)originalHeight, ((Matrix) (obj1)), true);
            ((Bitmap) (obj)).recycle();
        } else
        {
            selectedImage = ((Bitmap) (obj));
        }
        obj1 = null;
        obj = null;
        canvas = surfaceholder.lockCanvas(null);
        obj = canvas;
        obj1 = canvas;
        surfaceholder;
        JVM INSTR monitorenter ;
        drawImage(canvas);
        surfaceholder;
        JVM INSTR monitorexit ;
        if (canvas != null)
        {
            surfaceholder.unlockCanvasAndPost(canvas);
        }
_L2:
        return;
        Exception exception2;
        exception2;
        surfaceholder;
        JVM INSTR monitorexit ;
        obj = canvas;
        obj1 = canvas;
        throw exception2;
        Exception exception1;
        exception1;
        obj1 = obj;
        exception1.printStackTrace();
        if (obj == null) goto _L2; else goto _L1
_L1:
        surfaceholder.unlockCanvasAndPost(((Canvas) (obj)));
        return;
        Exception exception;
        exception;
        if (obj1 != null)
        {
            surfaceholder.unlockCanvasAndPost(((Canvas) (obj1)));
        }
        throw exception;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        if (selectedImage != null)
        {
            selectedImage.recycle();
        }
    }
}
