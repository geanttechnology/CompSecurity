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
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.poshmark.utils.GestureViewUtils;
import com.poshmark.utils.ImageUtils;
import com.poshmark.utils.PMGestureDetector;
import com.poshmark.utils.PMGestureDetectorListener;

public class GestureView extends SurfaceView
    implements PMGestureDetectorListener
{

    private static final int CREATE_COVERSHOT = 1;
    private static final int CREATE_THUMBNAIL = 0;
    private static final String DEFAULT_GRIDLINE_COLOUR_ID = "#FFFFFF";
    private static final int GRID_COLUMN_COUNT = 3;
    private static final int GRID_ROW_COUNT = 3;
    private static final float MAX_SCALEFACTOR = 3F;
    private static final float MIN_SCALEFACTOR = 0.5F;
    private static final String TAG = "GESTURE VIEW";
    Paint backgroundPaint;
    Bitmap bitmap;
    Point bitmapTopLeft;
    String bmpFileName;
    int cenX;
    int cenY;
    int cropImageWidth;
    Rect cropSpace;
    Matrix currentMatrix;
    int dragXOffset;
    int dragYOffset;
    PMGestureDetector gestureDetector;
    SurfaceHolder holder;
    boolean isDragging;
    boolean isPinchZooming;
    Paint mGridLinePaint;
    private float mPts[];
    Point pivot;
    GestureViewUtils utils;
    float xCurrentScaleFactor;
    float xPinchDistance;
    float yPinchDistance;

    public GestureView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isDragging = false;
        isPinchZooming = false;
        bitmapTopLeft = null;
        pivot = new Point();
        xCurrentScaleFactor = 1.0F;
        currentMatrix = new Matrix();
        backgroundPaint = new Paint();
        backgroundPaint.setDither(true);
        mGridLinePaint = new Paint();
        mGridLinePaint.setColor(Color.parseColor("#FFFFFF"));
        mPts = new float[16];
        holder = getHolder();
        utils = new GestureViewUtils();
    }

    private void drawGrid(Canvas canvas)
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
            af[l] = ((float)cropSpace.height() * ((float)k + 1.0F)) / 3F + (float)cropSpace.top;
            af = mPts;
            l = i + 1;
            af[i] = cropSpace.right;
            af = mPts;
            i = l + 1;
            af[l] = ((float)cropSpace.height() * ((float)k + 1.0F)) / 3F + (float)cropSpace.top;
        }

        boolean flag = false;
        k = i;
        for (int j = ((flag) ? 1 : 0); j < 2; j++)
        {
            float af1[] = mPts;
            int i1 = k + 1;
            af1[k] = ((float)cropSpace.width() * ((float)j + 1.0F)) / 3F + (float)cropSpace.left;
            af1 = mPts;
            k = i1 + 1;
            af1[i1] = cropSpace.top;
            af1 = mPts;
            i1 = k + 1;
            af1[k] = ((float)cropSpace.width() * ((float)j + 1.0F)) / 3F + (float)cropSpace.left;
            af1 = mPts;
            k = i1 + 1;
            af1[i1] = cropSpace.bottom;
        }

        canvas.drawLines(mPts, mGridLinePaint);
    }

    private Rect getBoundingRect(Point point, Point point1)
    {
        Rect rect = new Rect();
        if (point.x > point1.x)
        {
            rect.left = point1.x;
            rect.right = point.x;
        } else
        {
            rect.left = point.x;
            rect.right = point1.x;
        }
        if (point.y > point1.y)
        {
            rect.top = point1.y;
            rect.bottom = point.y;
            return rect;
        } else
        {
            rect.top = point.y;
            rect.bottom = point1.y;
            return rect;
        }
    }

    private boolean isSwipableArea(Point point)
    {
        return cropSpace.contains(point.x, point.y);
    }

    private boolean isSwipableArea(Point point, Point point1)
    {
        return cropSpace.contains(point.x, point.y) && cropSpace.contains(point1.x, point1.y);
    }

    private void resetImage()
    {
        Point point = new Point();
        Point point1 = new Point();
        RectF rectf = new RectF(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        currentMatrix.mapRect(rectf);
        byte byte0;
        int i;
        if ((float)cropSpace.width() > rectf.width() || (float)cropSpace.height() > rectf.height())
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        Log.d("GESTURE VIEW", String.format("Reset Image State : %s", new Object[] {
            Integer.valueOf(byte0)
        }));
        i = bitmapTopLeft.x;
        point1.x = i;
        point.x = i;
        i = bitmapTopLeft.y;
        point1.y = i;
        point.y = i;
        if (byte0 == 1)
        {
            if ((float)cropSpace.left < rectf.left)
            {
                point1.x = bitmapTopLeft.x - (int)(rectf.left - (float)cropSpace.left);
            } else
            if ((float)cropSpace.right > rectf.right)
            {
                point1.x = bitmapTopLeft.x + (cropSpace.right - (int)rectf.right);
            }
            if ((float)cropSpace.top < rectf.top)
            {
                point1.y = bitmapTopLeft.y - (int)(rectf.top - (float)cropSpace.top);
            } else
            if ((float)cropSpace.bottom > rectf.bottom)
            {
                point1.y = bitmapTopLeft.y + (cropSpace.bottom - (int)rectf.bottom);
            }
        } else
        if (byte0 == 2)
        {
            point1.x = cenX;
            point1.y = cenY;
            utils.startScaleAnimation(xCurrentScaleFactor, 1.0F, this);
            Log.d("GESTURE VIEW", String.format("Reset Image Scaling", new Object[0]));
        }
        utils.startTranslationAnimation(point, point1, this);
        Log.d("GESTURE VIEW", String.format("Reset Image Translating", new Object[0]));
    }

    private void setPivotPoints(Point point, Point point1)
    {
        point = new RectF();
        currentMatrix.mapRect(point);
        pivot.x = bitmap.getWidth() / 2;
        pivot.y = bitmap.getHeight() / 2;
    }

    public Uri getCroppedImage()
    {
        float af[] = new float[9];
        currentMatrix.getValues(af);
        float f = af[0];
        Log.d("GESTURE VIEW", String.format("Getting Cropped Image", new Object[0]));
        Object obj = new RectF(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        currentMatrix.mapRect(((RectF) (obj)));
        int i = (int)((RectF) (obj)).left;
        int l1 = cropSpace.left;
        int j1 = (int)((RectF) (obj)).top;
        int k1 = cropSpace.top;
        int l = (int)((RectF) (obj)).right;
        int i1 = cropSpace.right;
        int j = (int)((RectF) (obj)).bottom;
        int k = cropSpace.bottom;
        i = Math.abs(l1 - i);
        j1 = Math.abs(k1 - j1);
        l = (int)((RectF) (obj)).width() - Math.abs(i1 - l);
        j = (int)((RectF) (obj)).height() - Math.abs(k - j);
        Log.d("GESTURE VIEW", String.format("Final Crop Values top: %s, right : %s, bottom: %s, left: %s", new Object[] {
            Integer.valueOf(j1), Integer.valueOf(l), Integer.valueOf(j), Integer.valueOf(i)
        }));
        j = (int)((float)j / f);
        k = (int)((float)j1 / f);
        i = (int)((float)i / f);
        l = (int)((float)l / f);
        f = (float)bitmap.getWidth() / (float)cropImageWidth;
        obj = new Matrix();
        ((Matrix) (obj)).postScale(f, f);
        Log.d("GESTURE VIEW", String.format("Bitmap values Width: %s, height: %s", new Object[] {
            Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())
        }));
        obj = Bitmap.createBitmap(bitmap, i, k, l - i, j - k, ((Matrix) (obj)), true);
        Uri uri = ImageUtils.saveBitmapToDisk(((Bitmap) (obj)));
        bitmap.recycle();
        ((Bitmap) (obj)).recycle();
        System.gc();
        Log.d("GESTURE VIEW", String.format("Returning Saved URI : %s", new Object[] {
            uri.toString()
        }));
        return uri;
    }

    public void onActionEnd()
    {
        resetImage();
        Log.d("GESTURE VIEW", String.format("Action End!", new Object[0]));
    }

    public void onDrag(Point point, Point point1)
    {
        if (isDragging)
        {
            dragXOffset = point1.x - point.x;
            dragYOffset = point1.y - point.y;
            point = bitmapTopLeft;
            point.x = point.x + dragXOffset;
            point = bitmapTopLeft;
            point.y = point.y + dragYOffset;
            Log.d("GESTURE VIEW", String.format("offset: %s, %s", new Object[] {
                Integer.valueOf(dragXOffset), Integer.valueOf(dragYOffset)
            }));
            updateImage();
        }
    }

    public void onDragEnd()
    {
        isDragging = false;
        Log.d("GESTURE VIEW", String.format("DRAG End!", new Object[0]));
    }

    public void onDragStart(Point point)
    {
        if (!isDragging && isSwipableArea(point))
        {
            isDragging = true;
            Log.d("GESTURE VIEW", String.format("Dragging TRUE!", new Object[0]));
            return;
        } else
        {
            Log.d("GESTURE VIEW", String.format("Dragging FALSE!", new Object[0]));
            return;
        }
    }

    public void onPinchZoom(Point point, Point point1, Point point2, Point point3)
    {
        if (isPinchZooming && isSwipableArea(point1, point3))
        {
            Log.d("GESTURE VIEW", String.format("Pinch Zooming", new Object[0]));
            point = getBoundingRect(point, point2);
            xPinchDistance = getBoundingRect(point1, point3).width() - point.width();
            Log.d("GESTURE VIEW", String.format("zoom: %s, %s", new Object[] {
                Float.valueOf(xPinchDistance), Float.valueOf(yPinchDistance)
            }));
            Log.d("GESTURE VIEW", String.format("offset: %s, %s", new Object[] {
                Integer.valueOf(dragXOffset), Integer.valueOf(dragYOffset)
            }));
            float f = Math.abs(xPinchDistance / 100F);
            Log.d("GESTURE VIEW", String.format("pinchDistance: %s", new Object[] {
                Float.valueOf(xPinchDistance)
            }));
            if (xPinchDistance >= 0.0F)
            {
                xCurrentScaleFactor = xCurrentScaleFactor + f;
                if (xCurrentScaleFactor > 3F)
                {
                    f = 3F;
                } else
                {
                    f = xCurrentScaleFactor;
                }
                xCurrentScaleFactor = f;
            } else
            {
                xCurrentScaleFactor = xCurrentScaleFactor - f;
                if (xCurrentScaleFactor < 0.5F)
                {
                    f = 0.5F;
                } else
                {
                    f = xCurrentScaleFactor;
                }
                xCurrentScaleFactor = f;
            }
            Log.d("GESTURE VIEW", String.format("Current Scale Factor: %s", new Object[] {
                Float.valueOf(xCurrentScaleFactor)
            }));
            xPinchDistance = 0.0F;
            updateImage();
        }
    }

    public void onPinchZoomEnd()
    {
        isPinchZooming = false;
        Log.d("GESTURE VIEW", String.format("Pinch Zoom End!", new Object[0]));
    }

    public void onPinchZoomStart(Point point, Point point1)
    {
        if (!isPinchZooming && isSwipableArea(point, point1))
        {
            Log.d("GESTURE VIEW", String.format("pinch_zoom start", new Object[0]));
            isPinchZooming = true;
            isDragging = false;
        }
        setPivotPoints(point, point1);
        updateImage();
    }

    public void onSingleTap(Point point)
    {
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
            cropImageWidth = 100;
            return;

        case 1: // '\001'
            cropImageWidth = 1024;
            break;
        }
    }

    public void setupBitmap(Rect rect)
    {
        Log.d("GESTURE VIEW", "Setting Bitmap");
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        int i = ImageUtils.calculateInSampleSize(options, rect.right - rect.left, rect.bottom - rect.top);
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        bitmap = BitmapFactoryInstrumentation.decodeFile(bmpFileName, options);
        bitmap = utils.getInitialScaledBitmap(rect, bitmap);
        cenX = (rect.left + rect.width() / 2) - bitmap.getWidth() / 2;
        cenY = (rect.top + rect.height() / 2) - bitmap.getHeight() / 2;
        bitmapTopLeft = new Point();
        bitmapTopLeft.x = cenX;
        bitmapTopLeft.y = cenY;
        cropSpace = rect;
        holder.addCallback(new android.view.SurfaceHolder.Callback() {

            final GestureView this$0;

            public void surfaceChanged(SurfaceHolder surfaceholder, int j, int k, int l)
            {
            }

            public void surfaceCreated(SurfaceHolder surfaceholder)
            {
                updateImage();
                gestureDetector = new PMGestureDetector(GestureView.this, GestureView.this);
            }

            public void surfaceDestroyed(SurfaceHolder surfaceholder)
            {
            }

            
            {
                this$0 = GestureView.this;
                super();
            }
        });
    }

    public void updateImage()
    {
        Canvas canvas = holder.lockCanvas(null);
        canvas.drawColor(-1);
        currentMatrix.reset();
        currentMatrix.setScale(xCurrentScaleFactor, xCurrentScaleFactor, pivot.x, pivot.y);
        currentMatrix.postTranslate(bitmapTopLeft.x, bitmapTopLeft.y);
        canvas.drawBitmap(bitmap, currentMatrix, backgroundPaint);
        drawGrid(canvas);
        holder.unlockCanvasAndPost(canvas);
    }

    public void updateScaleFactor(float f)
    {
        xCurrentScaleFactor = f;
        updateImage();
    }

    public void updateTranslation(Point point)
    {
        bitmapTopLeft.x = point.x;
        bitmapTopLeft.y = point.y;
        updateImage();
    }
}
