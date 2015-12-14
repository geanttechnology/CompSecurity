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
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class RibbonMarkerView extends View
{

    private int fillColor;
    private Paint fillPaint;
    private Path fillPath;
    private int textColor;
    private Paint textPaint;
    private int textSizeInPixels;
    private String textToDisplay;
    private final Rect textViewRect;
    private float textXPos;
    private float textYPos;
    private final Rect viewDrawingRect;

    public RibbonMarkerView(Context context)
    {
        this(context, null);
    }

    public RibbonMarkerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RibbonMarkerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        textToDisplay = "";
        attributeset = context.obtainStyledAttributes(attributeset, com.amazon.photos.R.styleable.RibbonMarkerView);
        fillColor = attributeset.getColor(3, context.getResources().getColor(0x7f090004));
        textColor = attributeset.getColor(1, context.getResources().getColor(0x7f0900b0));
        textSizeInPixels = attributeset.getDimensionPixelSize(2, 0);
        textToDisplay = attributeset.getString(0);
        attributeset.recycle();
        viewDrawingRect = new Rect();
        textViewRect = new Rect();
        initPaint();
    }

    private void initFillPath(Rect rect)
    {
        int i = rect.width();
        int j = rect.height();
        rect = new Point(0, 0);
        Point point = new Point(i, 0);
        Point point1 = new Point(Math.round((float)i * 0.9F), j / 2);
        Point point2 = new Point(i, j);
        Point point3 = new Point(0, j);
        fillPath = new Path();
        fillPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        fillPath.moveTo(((Point) (rect)).x, ((Point) (rect)).y);
        fillPath.lineTo(point.x, point.y);
        fillPath.lineTo(point1.x, point1.y);
        fillPath.lineTo(point2.x, point2.y);
        fillPath.lineTo(point3.x, point3.y);
        fillPath.lineTo(((Point) (rect)).x, ((Point) (rect)).y);
        fillPath.close();
    }

    private void initPaint()
    {
        fillPaint = new Paint(1);
        fillPaint.setColor(fillColor);
        fillPaint.setStyle(android.graphics.Paint.Style.FILL);
        textPaint = new Paint(1);
        textPaint.setTextSize(textSizeInPixels);
        textPaint.setColor(textColor);
        textPaint.setTypeface(Typeface.defaultFromStyle(0));
    }

    private void initTextCoordinates(Rect rect)
    {
        textPaint.getTextBounds(textToDisplay, 0, textToDisplay.length(), textViewRect);
        textXPos = (float)rect.centerX() - textViewRect.exactCenterX() - (0.1F * (float)rect.width()) / 2.0F;
        textYPos = (float)rect.centerY() - textViewRect.exactCenterY();
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawPath(fillPath, fillPaint);
        canvas.drawText(textToDisplay, textXPos, textYPos, textPaint);
    }

    public void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        getDrawingRect(viewDrawingRect);
        initTextCoordinates(viewDrawingRect);
        initFillPath(viewDrawingRect);
    }
}
