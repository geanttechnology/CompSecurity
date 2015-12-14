// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import yp;

public class FontLabelCursorView extends View
{

    private PointF cursorPos1;
    private PointF cursorPos2;
    private Paint paint;

    public FontLabelCursorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(0xff0000ff);
        paint.setAlpha(255);
        paint.setStrokeWidth(5F);
        cursorPos1 = new PointF(0.0F, 0.0F);
        cursorPos2 = new PointF(0.0F, yp.a(getContext(), 50F));
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        paint.setColor(0xff0000ff);
        canvas.drawLine(cursorPos1.x, cursorPos1.y, cursorPos2.x, cursorPos2.y, paint);
    }

    public void setLocation(PointF pointf, PointF pointf1)
    {
        float f1 = pointf.x;
        float f3 = pointf.y;
        float f = pointf1.x;
        float f2 = pointf1.y;
        if (pointf.x > pointf1.x)
        {
            f1 = pointf1.x;
            f = pointf.x;
        }
        if (pointf.y > pointf1.y)
        {
            f3 = pointf1.y;
            f2 = pointf.y;
        }
        f1 -= yp.a(getContext(), 2.0F);
        f3 -= yp.a(getContext(), 2.0F);
        float f4 = yp.a(getContext(), 2.0F);
        float f5 = yp.a(getContext(), 2.0F);
        pointf.x = pointf.x - f1;
        pointf.y = pointf.y - f3;
        pointf1.x = pointf1.x - f1;
        pointf1.y = pointf1.y - f3;
        cursorPos1.set(pointf.x, pointf.y);
        cursorPos2.set(pointf1.x, pointf1.y);
        pointf = (android.widget.FrameLayout.LayoutParams)getLayoutParams();
        pointf.gravity = 51;
        pointf.leftMargin = (int)f1;
        pointf.topMargin = (int)f3;
        pointf.width = (int)((f4 + f) - f1);
        pointf.height = (int)((f2 + f5) - f3);
        requestLayout();
        invalidate();
    }
}
