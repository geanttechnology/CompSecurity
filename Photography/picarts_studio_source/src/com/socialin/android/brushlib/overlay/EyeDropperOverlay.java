// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.overlay;

import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.TypedValue;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.brushlib.overlay:
//            Overlay

public class EyeDropperOverlay extends Overlay
{

    private static final int BORDER1_COLOR = -1;
    private static final float BORDER1_SIZE_DIP = 13.5F;
    private static int BORDER1_SIZE_PIX = 0;
    private static final int BORDER2_COLOR = Color.argb(128, 0, 0, 0);
    private static final float BORDER2_SIZE_DIP = 13.5F;
    private static int BORDER2_SIZE_PIX = 0;
    private static final float COLOR_SIZE_DIP = 12.5F;
    private static int COLOR_SIZE_PIX = 0;
    private static final float CURSOR_BORDER_THICKNESS_DIP = 1F;
    private static float CURSOR_BORDER_THICKNESS_PIX = 0F;
    private static final float RADIUS_DIP = 75F;
    private static float RADIUS_PIX;
    private RectF bounds;
    private Matrix cameraMatrix;
    private float circleScale;
    float colorHSV[];
    private int lastPickedColor;
    private final RectF originalRect;
    private Paint paint;
    private int pickedColor;
    private PointF pickerCenter;
    float points[];
    private RectF rectForArcs;

    public EyeDropperOverlay(DrawingView drawingview)
    {
        pickerCenter = new PointF();
        paint = new Paint();
        cameraMatrix = new Matrix();
        points = new float[2];
        colorHSV = new float[3];
        circleScale = 1.0F;
        bounds = new RectF();
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setAntiAlias(true);
        RADIUS_PIX = (int)TypedValue.applyDimension(1, 75F, drawingview.getResources().getDisplayMetrics());
        COLOR_SIZE_PIX = (int)TypedValue.applyDimension(1, 12.5F, drawingview.getResources().getDisplayMetrics());
        BORDER1_SIZE_PIX = (int)TypedValue.applyDimension(1, 13.5F, drawingview.getResources().getDisplayMetrics());
        BORDER2_SIZE_PIX = (int)TypedValue.applyDimension(1, 13.5F, drawingview.getResources().getDisplayMetrics());
        CURSOR_BORDER_THICKNESS_PIX = (int)TypedValue.applyDimension(1, 1.0F, drawingview.getResources().getDisplayMetrics());
        float f = RADIUS_PIX + (float)BORDER2_SIZE_PIX;
        originalRect = new RectF(-f, -f, f, f);
        rectForArcs = new RectF();
    }

    public static float getRadiusDip()
    {
        return 75F;
    }

    protected void drawWithoutTransform(Canvas canvas)
    {
        canvas.scale(circleScale, circleScale, pickerCenter.x, pickerCenter.y);
        rectForArcs.set(pickerCenter.x - RADIUS_PIX, pickerCenter.y - RADIUS_PIX, pickerCenter.x + RADIUS_PIX, pickerCenter.y + RADIUS_PIX);
        points[0] = pickerCenter.x;
        points[1] = pickerCenter.y;
        cameraMatrix.mapPoints(points);
        paint.setStrokeWidth(BORDER2_SIZE_PIX);
        paint.setColor(BORDER2_COLOR);
        paint.setMaskFilter(new BlurMaskFilter(3F, android.graphics.BlurMaskFilter.Blur.SOLID));
        canvas.drawCircle(pickerCenter.x, pickerCenter.y, RADIUS_PIX, paint);
        paint.setStrokeWidth(BORDER1_SIZE_PIX);
        paint.setColor(-1);
        paint.setMaskFilter(null);
        canvas.drawCircle(pickerCenter.x, pickerCenter.y, RADIUS_PIX, paint);
        paint.setStrokeWidth(COLOR_SIZE_PIX);
        paint.setColor(pickedColor);
        paint.setMaskFilter(null);
        canvas.drawCircle(pickerCenter.x, pickerCenter.y, RADIUS_PIX, paint);
        paint.setStrokeWidth(COLOR_SIZE_PIX);
        paint.setColor(lastPickedColor);
        paint.setMaskFilter(null);
        canvas.drawArc(rectForArcs, 0.0F, 180F, false, paint);
        Color.colorToHSV(pickedColor, colorHSV);
        float f;
        float f1;
        float f2;
        float f3;
        float f4;
        if ((double)colorHSV[2] < 0.5D)
        {
            paint.setColor(-1);
        } else
        {
            paint.setColor(BORDER2_COLOR);
        }
        paint.setStrokeWidth(CURSOR_BORDER_THICKNESS_PIX);
        canvas.drawLine(pickerCenter.x - RADIUS_PIX / 2.7F, pickerCenter.y, pickerCenter.x - RADIUS_PIX / 18F, pickerCenter.y, paint);
        f = pickerCenter.x;
        f1 = RADIUS_PIX / 18F;
        f2 = pickerCenter.y;
        f3 = pickerCenter.x;
        canvas.drawLine(f1 + f, f2, RADIUS_PIX / 2.7F + f3, pickerCenter.y, paint);
        canvas.drawLine(pickerCenter.x, pickerCenter.y - RADIUS_PIX / 2.7F, pickerCenter.x, pickerCenter.y - RADIUS_PIX / 18F, paint);
        f = pickerCenter.x;
        f1 = pickerCenter.y;
        f2 = RADIUS_PIX / 18F;
        f3 = pickerCenter.x;
        f4 = pickerCenter.y;
        canvas.drawLine(f, f2 + f1, f3, RADIUS_PIX / 2.7F + f4, paint);
    }

    public int getColor()
    {
        return pickedColor;
    }

    public a getController$442001be()
    {
        return null;
    }

    public float getOrigHeight()
    {
        return 0.0F;
    }

    public float getOrigWidth()
    {
        return 0.0F;
    }

    public RectF getTransformedBounds(boolean flag)
    {
        bounds.set(originalRect);
        bounds.offsetTo(getTransform().getCx() - bounds.width() / 2.0F, getTransform().getCy() - bounds.height() / 2.0F);
        return bounds;
    }

    public void setColor(int i)
    {
        pickedColor = i;
    }

    public void setLastPickedColor(int i)
    {
        lastPickedColor = i;
    }

}
