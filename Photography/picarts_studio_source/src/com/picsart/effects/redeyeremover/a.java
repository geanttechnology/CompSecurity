// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.redeyeremover;

import android.graphics.Bitmap;
import android.graphics.Paint;
import java.util.ArrayList;

// Referenced classes of package com.picsart.effects.redeyeremover:
//            b

public final class a
{

    static float a = 100F;
    private static float m = 25F;
    b b;
    Paint c;
    Paint d;
    Paint e;
    boolean f;
    boolean g;
    float h;
    float i;
    Bitmap j;
    ArrayList k;
    ArrayList l;

    public a(Bitmap bitmap)
    {
        f = false;
        g = false;
        h = 0.0F;
        i = 0.0F;
        m = 25F;
        c = new Paint();
        c.setAntiAlias(true);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setStrokeWidth(2.0F);
        c.setColor(-1);
        d = new Paint();
        d.setAntiAlias(true);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setStrokeWidth(1.0F);
        d.setColor(0x99000000);
        e = new Paint(2);
        k = new ArrayList();
        l = new ArrayList();
        j = bitmap;
        m = Math.max((float)j.getWidth() / 2.0F, (float)j.getHeight() / 2.0F);
    }

    static float a()
    {
        return m;
    }

}
