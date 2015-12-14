// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class ai extends View
{

    private Paint a;
    private Paint b;
    private Paint c;

    public ai(Context context)
    {
        super(context);
        a = new Paint();
        a.setColor(0xffcccccc);
        a.setStyle(android.graphics.Paint.Style.STROKE);
        a.setStrokeWidth(3F);
        a.setAntiAlias(true);
        b = new Paint();
        b.setColor(0xb3444444);
        b.setStyle(android.graphics.Paint.Style.FILL);
        b.setAntiAlias(true);
        c = new Paint();
        c.setColor(-1);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setStrokeWidth(6F);
        c.setAntiAlias(true);
    }

    protected void onDraw(Canvas canvas)
    {
        int i = Math.min(canvas.getWidth(), canvas.getHeight());
        int j = i / 2;
        int k = (j * 2) / 3;
        canvas.drawCircle(j, j, k, a);
        canvas.drawCircle(j, j, k - 2, b);
        i /= 3;
        canvas.drawLine(i, i, i * 2, i * 2, c);
        canvas.drawLine(i * 2, i, i, i * 2, c);
        super.onDraw(canvas);
    }
}
