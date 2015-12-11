// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class CameraViewportRectView extends View
{
    public static interface CustomListener
    {

        public abstract void afterDraw();
    }


    int VIEWPORT_HEIGHT;
    int VIEWPORT_LEFT;
    int VIEWPORT_TOP;
    int VIEWPORT_WIDTH;
    Paint backgroundPaint;
    CustomListener listener;
    private int parentHeight;
    private int parentWidth;
    Paint viewPortRectPaint;

    public CameraViewportRectView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        backgroundPaint = new Paint();
        viewPortRectPaint = new Paint();
        VIEWPORT_LEFT = 10;
        VIEWPORT_TOP = 100;
        VIEWPORT_WIDTH = 100;
        VIEWPORT_HEIGHT = 100;
        listener = null;
    }

    public int getViewPortTop()
    {
        return VIEWPORT_TOP;
    }

    public int getViewportBottom()
    {
        return VIEWPORT_TOP + VIEWPORT_HEIGHT;
    }

    public int getViewportHeight()
    {
        return VIEWPORT_HEIGHT;
    }

    public int getViewportLeft()
    {
        return VIEWPORT_LEFT;
    }

    public int getViewportOffsetFromBottomEdgeOfScreen()
    {
        return parentHeight - (VIEWPORT_TOP + VIEWPORT_HEIGHT);
    }

    public int getViewportOffsetFromLeftEdgeOfScreen()
    {
        return VIEWPORT_LEFT;
    }

    public int getViewportOffsetFromRightEdgeOfScreen()
    {
        return parentWidth - (VIEWPORT_LEFT + VIEWPORT_WIDTH);
    }

    public int getViewportOffsetFromTopEdgeOfScreen()
    {
        return VIEWPORT_TOP;
    }

    public Rect getViewportRect()
    {
        return new Rect(VIEWPORT_LEFT, VIEWPORT_TOP, VIEWPORT_LEFT + VIEWPORT_WIDTH, VIEWPORT_TOP + VIEWPORT_HEIGHT);
    }

    public int getViewportRight()
    {
        return VIEWPORT_LEFT + VIEWPORT_WIDTH;
    }

    public int getViewportWidth()
    {
        return VIEWPORT_WIDTH;
    }

    public void onDraw(Canvas canvas)
    {
        VIEWPORT_WIDTH = parentWidth - VIEWPORT_LEFT * 2;
        VIEWPORT_HEIGHT = VIEWPORT_WIDTH;
        VIEWPORT_TOP = (parentHeight - VIEWPORT_HEIGHT) / 2;
        Rect rect = new Rect(0, 0, canvas.getWidth(), VIEWPORT_TOP);
        Rect rect1 = new Rect(0, VIEWPORT_TOP, VIEWPORT_LEFT, VIEWPORT_TOP + VIEWPORT_HEIGHT);
        Rect rect2 = new Rect(VIEWPORT_LEFT + VIEWPORT_WIDTH, VIEWPORT_TOP, canvas.getWidth(), VIEWPORT_TOP + VIEWPORT_HEIGHT);
        Rect rect3 = new Rect(0, VIEWPORT_TOP + VIEWPORT_HEIGHT, canvas.getWidth(), canvas.getHeight());
        backgroundPaint.setColor(Color.argb(204, 0, 0, 0));
        backgroundPaint.setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawRect(rect, backgroundPaint);
        canvas.drawRect(rect1, backgroundPaint);
        canvas.drawRect(rect2, backgroundPaint);
        canvas.drawRect(rect3, backgroundPaint);
        viewPortRectPaint.setColor(-1);
        viewPortRectPaint.setStyle(android.graphics.Paint.Style.STROKE);
        canvas.drawRect(new Rect(VIEWPORT_LEFT, VIEWPORT_TOP, VIEWPORT_LEFT + VIEWPORT_WIDTH, VIEWPORT_TOP + VIEWPORT_HEIGHT), viewPortRectPaint);
        if (listener != null)
        {
            listener.afterDraw();
        }
    }

    protected void onMeasure(int i, int j)
    {
        parentWidth = android.view.View.MeasureSpec.getSize(i);
        parentHeight = android.view.View.MeasureSpec.getSize(j);
        setMeasuredDimension(parentWidth, parentHeight);
    }

    public void setCustomListerner(CustomListener customlistener)
    {
        listener = customlistener;
    }
}
