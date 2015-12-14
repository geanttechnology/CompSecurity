// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CameraFocusRectView extends View
{

    private Paint a;

    public CameraFocusRectView(Context context)
    {
        super(context);
        a = new Paint();
        a.setColor(0xffff0000);
        a.setAntiAlias(true);
        a.setStyle(android.graphics.Paint.Style.STROKE);
        a.setStrokeWidth(2.0F);
    }

    public CameraFocusRectView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new Paint();
        a.setColor(0xffff0000);
        a.setAntiAlias(true);
        a.setStyle(android.graphics.Paint.Style.STROKE);
        a.setStrokeWidth(2.0F);
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawLine(0.0F, 0.0F, 0.0F, getHeight(), a);
        canvas.drawLine(getWidth() - 1, 0.0F, getWidth() - 1, getHeight(), a);
        canvas.drawLine(0.0F, 0.0F, (getWidth() * 15) / 100, 0.0F, a);
        canvas.drawLine((getWidth() * 85) / 100, 0.0F, getWidth(), 0.0F, a);
        canvas.drawLine(0.0F, getHeight() - 1, (getWidth() * 15) / 100, getHeight() - 1, a);
        canvas.drawLine((getWidth() * 85) / 100, getHeight() - 1, getWidth(), getHeight() - 1, a);
        super.onDraw(canvas);
    }

    public void setLineColor(int i)
    {
        a.setColor(i);
    }
}
