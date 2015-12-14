// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.ad;
import myobfuscated.aj.j;
import myobfuscated.f.m;
import myobfuscated.s.g;

public final class w
    implements ad
{

    private final Bitmap a;
    private final Resources b;
    private final g c;

    private w(Resources resources, g g1, Bitmap bitmap)
    {
        b = (Resources)m.a(resources, "Argument must not be null");
        c = (g)m.a(g1, "Argument must not be null");
        a = (Bitmap)m.a(bitmap, "Argument must not be null");
    }

    public static w a(Resources resources, g g1, Bitmap bitmap)
    {
        return new w(resources, g1, bitmap);
    }

    public final Class a()
    {
        return android/graphics/drawable/BitmapDrawable;
    }

    public final Object b()
    {
        return new BitmapDrawable(b, a);
    }

    public final int c()
    {
        return j.a(a);
    }

    public final void d()
    {
        c.a(a);
    }
}
