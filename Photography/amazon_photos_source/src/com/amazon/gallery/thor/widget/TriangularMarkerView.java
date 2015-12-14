// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class TriangularMarkerView extends View
{

    private int fillColor;
    private Path fillPath;
    private Paint paint;
    private int strokeColor;
    private Path strokePath;
    private int strokeWidthInPixels;

    public TriangularMarkerView(Context context)
    {
        this(context, null);
    }

    public TriangularMarkerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public TriangularMarkerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        attributeset = context.obtainStyledAttributes(attributeset, com.amazon.photos.R.styleable.TriangularMarkerView);
        fillColor = attributeset.getColor(0, context.getResources().getColor(0x106000c));
        strokeColor = attributeset.getColor(1, context.getResources().getColor(0x106000d));
        strokeWidthInPixels = attributeset.getDimensionPixelSize(2, 0);
        attributeset.recycle();
    }

    private void createPaths()
    {
        int i = getWidth();
        int j = getHeight();
        Point point = new Point(0, 0);
        Point point1 = new Point(i, 0);
        Point point2 = new Point(i / 2, j);
        fillPath = new Path();
        fillPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        fillPath.lineTo(point1.x, point1.y);
        fillPath.lineTo(point2.x, point2.y);
        fillPath.lineTo(point.x, point.y);
        fillPath.close();
        strokePath = new Path();
        strokePath.moveTo(point.x, point.y);
        strokePath.lineTo(point2.x, point2.y);
        strokePath.moveTo(point2.x, point2.y);
        strokePath.lineTo(point1.x, point1.y);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setColor(fillColor);
        canvas.drawPath(fillPath, paint);
        if (strokeWidthInPixels > 0)
        {
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setColor(strokeColor);
            paint.setStrokeWidth(strokeWidthInPixels);
            canvas.drawPath(strokePath, paint);
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        createPaths();
    }
}
