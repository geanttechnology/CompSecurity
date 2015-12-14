// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;

import android.graphics.Canvas;
import android.graphics.PointF;

// Referenced classes of package com.picsart.studio.editor:
//            d, SimpleTransform, h, Camera

public abstract class g
{

    public h c;

    public g()
    {
    }

    public static g a(g g1, Camera camera)
    {
        return new d(g1, camera);
    }

    public static SimpleTransform f()
    {
        return new SimpleTransform();
    }

    public abstract float a();

    public abstract g a(float f1);

    public final g a(float f1, float f2)
    {
        return a(f1).b(f2);
    }

    public final void a(Canvas canvas)
    {
        canvas.translate(a(), b());
        canvas.rotate(e());
        canvas.scale(c(), d());
    }

    public final void a(PointF pointf)
    {
        pointf.x = pointf.x * c();
        pointf.y = pointf.y * d();
        float f1 = (float)(Math.atan2(pointf.y, pointf.x) + ((double)e() * 3.1415926535897931D) / 180D);
        float f2 = (float)Math.sqrt(pointf.x * pointf.x + pointf.y * pointf.y);
        pointf.x = (float)((double)f2 * Math.cos(f1) + (double)a());
        double d1 = f2;
        pointf.y = (float)(Math.sin(f1) * d1 + (double)b());
    }

    public final void a(PointF pointf, PointF pointf1)
    {
        pointf1.x = pointf.x - a();
        pointf1.y = pointf.y - b();
        float f1 = (float)(Math.atan2(pointf1.y, pointf1.x) - ((double)e() * 3.1415926535897931D) / 180D);
        float f2 = (float)Math.sqrt(pointf1.x * pointf1.x + pointf1.y * pointf1.y);
        pointf1.x = (float)(((double)f2 * Math.cos(f1)) / (double)c());
        double d1 = f2;
        pointf1.y = (float)((Math.sin(f1) * d1) / (double)d());
    }

    public abstract float b();

    public abstract g b(float f1);

    public final g b(float f1, float f2)
    {
        return c(f1).d(f2);
    }

    public abstract float c();

    public abstract g c(float f1);

    public abstract float d();

    public abstract g d(float f1);

    public abstract float e();

    public abstract g e(float f1);

    protected final void g()
    {
        if (c != null)
        {
            c.a();
        }
    }
}
