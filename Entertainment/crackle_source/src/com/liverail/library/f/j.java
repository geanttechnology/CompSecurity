// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

public class j extends TextView
{

    private Paint a;
    private Paint b;
    private RectF c;

    public j(Context context)
    {
        super(context);
        a();
    }

    public j(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public j(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        setBackgroundColor(0);
        setTextColor(-1);
        setPadding(15, 5, 15, 5);
        setTextSize(20F);
        a = new Paint();
        a.setStyle(android.graphics.Paint.Style.STROKE);
        a.setColor(0xff999999);
        a.setStrokeWidth(1.0F);
        a.setAntiAlias(true);
        b = new Paint();
        b.setStyle(android.graphics.Paint.Style.FILL);
        b.setColor(0xcc000000);
        c = new RectF();
    }

    protected void onDraw(Canvas canvas)
    {
        if (getText().length() > 0)
        {
            int i = getWidth();
            int k = getHeight();
            c.set(0, 0, i, k);
            canvas.drawRoundRect(c, 6F, 6F, b);
            c.set(2, 2, i - 2, k - 2);
            canvas.drawRoundRect(c, 6F, 6F, a);
        }
        super.onDraw(canvas);
    }
}
