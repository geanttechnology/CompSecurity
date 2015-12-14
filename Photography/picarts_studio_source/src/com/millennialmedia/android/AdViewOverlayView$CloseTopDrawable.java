// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

class a extends a
{

    private float b;
    private float c;

    public void draw(Canvas canvas)
    {
        Rect rect = copyBounds();
        float f = (float)(rect.right - rect.left) / 10F;
        float f1 = (float)rect.right - b * 20F;
        float f2 = (float)rect.top + b * 20F;
        a.setStrokeWidth(f);
        a.setColor(0xff000000);
        a.setStyle(android.graphics.opDrawable.a);
        canvas.drawCircle(f1, f2, 12F * b, a);
        a.setColor(-1);
        a.setStyle(android.graphics.opDrawable.a);
        canvas.drawCircle(f1, f2, b * 10F, a);
        a.setColor(0xff000000);
        canvas.drawCircle(f1, f2, 7F * b, a);
        a.setColor(-1);
        a.setStrokeWidth(f / 2.0F);
        a.setStyle(android.graphics.opDrawable.a);
        canvas.drawLine(f1 - c, f2 - c, f1 + c, f2 + c, a);
        canvas.drawLine(f1 + c, f2 - c, f1 - c, f2 + c, a);
    }

    (float f)
    {
        super(true);
        b = f;
        c = 4F * f;
        a.setColor(0xff000000);
    }
}
