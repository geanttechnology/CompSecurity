// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.b;

import com.c.a.b.a.f;
import com.c.a.b.a.l;
import com.c.a.b.d;
import com.c.a.b.d.b;

public class e
{

    private final String a;
    private final String b;
    private final f c;
    private final com.c.a.b.a.e d;
    private final l e;
    private final b f;
    private final Object g;
    private final boolean h;
    private final android.graphics.BitmapFactory.Options i = new android.graphics.BitmapFactory.Options();

    public e(String s, String s1, f f1, l l, b b1, d d1)
    {
        a = s;
        b = s1;
        c = f1;
        d = d1.j();
        e = l;
        f = b1;
        g = d1.n();
        h = d1.m();
        a(d1.k(), i);
    }

    private void a(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options1)
    {
        options1.inDensity = options.inDensity;
        options1.inDither = options.inDither;
        options1.inInputShareable = options.inInputShareable;
        options1.inJustDecodeBounds = options.inJustDecodeBounds;
        options1.inPreferredConfig = options.inPreferredConfig;
        options1.inPurgeable = options.inPurgeable;
        options1.inSampleSize = options.inSampleSize;
        options1.inScaled = options.inScaled;
        options1.inScreenDensity = options.inScreenDensity;
        options1.inTargetDensity = options.inTargetDensity;
        options1.inTempStorage = options.inTempStorage;
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            b(options, options1);
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            c(options, options1);
        }
    }

    private void b(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options1)
    {
        options1.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    private void c(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options1)
    {
        options1.inBitmap = options.inBitmap;
        options1.inMutable = options.inMutable;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public f c()
    {
        return c;
    }

    public com.c.a.b.a.e d()
    {
        return d;
    }

    public l e()
    {
        return e;
    }

    public b f()
    {
        return f;
    }

    public Object g()
    {
        return g;
    }

    public boolean h()
    {
        return h;
    }

    public android.graphics.BitmapFactory.Options i()
    {
        return i;
    }
}
