// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PointF;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            d

public final class c
{

    static float a = 100F;
    private static float k = 25F;
    d b;
    Paint c;
    Paint d;
    Paint e;
    boolean f;
    boolean g;
    float h;
    float i;
    Bitmap j;

    public c(Bitmap bitmap)
    {
        f = false;
        g = false;
        h = 0.0F;
        i = 0.0F;
        k = 25F;
        c = new Paint(1);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setStrokeWidth(2.0F);
        c.setColor(-1);
        d = new Paint(1);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setStrokeWidth(1.0F);
        d.setColor(0x99000000);
        e = new Paint(2);
        j = bitmap;
        k = Math.max((float)j.getWidth() / 2.0F, (float)j.getHeight() / 2.0F);
    }

    public static void a(float f1)
    {
        a = f1;
    }

    static float b()
    {
        return k;
    }

    public final PointF a()
    {
        if (b != null)
        {
            return b.a;
        } else
        {
            return null;
        }
    }

    public final void a(PointF pointf)
    {
        b = new d(pointf);
    }

}
