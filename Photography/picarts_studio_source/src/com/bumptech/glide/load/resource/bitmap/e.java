// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.ad;
import myobfuscated.aj.j;
import myobfuscated.f.m;
import myobfuscated.s.g;

public final class e
    implements ad
{

    private final Bitmap a;
    private final g b;

    public e(Bitmap bitmap, g g1)
    {
        a = (Bitmap)m.a(bitmap, "Bitmap must not be null");
        b = (g)m.a(g1, "BitmapPool must not be null");
    }

    public static e a(Bitmap bitmap, g g1)
    {
        if (bitmap == null)
        {
            return null;
        } else
        {
            return new e(bitmap, g1);
        }
    }

    public final Class a()
    {
        return android/graphics/Bitmap;
    }

    public final volatile Object b()
    {
        return a;
    }

    public final int c()
    {
        return j.a(a);
    }

    public final void d()
    {
        b.a(a);
    }
}
