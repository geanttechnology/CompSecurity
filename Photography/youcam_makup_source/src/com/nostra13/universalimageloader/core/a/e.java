// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.a;

import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.assist.c;
import com.nostra13.universalimageloader.core.d;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

public class e
{

    private final String a;
    private final String b;
    private final String c;
    private final c d;
    private final ImageScaleType e;
    private final ViewScaleType f;
    private final ImageDownloader g;
    private final Object h;
    private final boolean i;
    private final android.graphics.BitmapFactory.Options j = new android.graphics.BitmapFactory.Options();

    public e(String s, String s1, String s2, c c1, ViewScaleType viewscaletype, ImageDownloader imagedownloader, d d1)
    {
        a = s;
        b = s1;
        c = s2;
        d = c1;
        e = d1.j();
        f = viewscaletype;
        g = imagedownloader;
        h = d1.n();
        i = d1.m();
        a(d1.k(), j);
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

    public c c()
    {
        return d;
    }

    public ImageScaleType d()
    {
        return e;
    }

    public ViewScaleType e()
    {
        return f;
    }

    public ImageDownloader f()
    {
        return g;
    }

    public Object g()
    {
        return h;
    }

    public boolean h()
    {
        return i;
    }

    public android.graphics.BitmapFactory.Options i()
    {
        return j;
    }
}
