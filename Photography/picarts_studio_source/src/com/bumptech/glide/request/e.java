// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;

import android.content.Context;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.j;
import myobfuscated.f.m;

// Referenced classes of package com.bumptech.glide.request:
//            a

public final class e extends a
{

    private static e A;
    private static e w;
    private static e x;
    private static e y;
    private static e z;

    public e()
    {
    }

    public static e a(b b1)
    {
        Object obj;
        for (obj = new e(); ((a) (obj)).v; obj = ((a) (obj)).a()) { }
        obj.l = (b)m.a(b1, "Argument must not be null");
        obj.a = ((a) (obj)).a | 0x400;
        return (e)((a) (obj)).a.d();
    }

    public static e a(Class class1)
    {
        Object obj;
        for (obj = new e(); ((a) (obj)).v; obj = ((a) (obj)).a()) { }
        obj.s = (Class)m.a(class1, "Argument must not be null");
        obj.a = ((a) (obj)).a | 0x1000;
        return (e)((a) (obj)).a.d();
    }

    public static e b(l l)
    {
        return (e)(new e()).a(l);
    }

    public static e c(Context context)
    {
        if (x == null)
        {
            x = (e)((e)(new e()).b(context.getApplicationContext())).c();
        }
        return x;
    }

    public static e d(Context context)
    {
        if (y == null)
        {
            y = (e)((e)(new e()).a(context.getApplicationContext())).c();
        }
        return y;
    }

    public static e e()
    {
        if (w == null)
        {
            w = (e)((e)(new e()).a(true)).c();
        }
        return w;
    }

    public static e e(Context context)
    {
        if (z == null)
        {
            e e1 = new e();
            context = context.getApplicationContext();
            z = (e)((e)e1.b(context, DownsampleStrategy.b, new j(context))).c();
        }
        return z;
    }

    public static e f()
    {
        if (A == null)
        {
            A = (e)((e)(new e()).b()).c();
        }
        return A;
    }
}
