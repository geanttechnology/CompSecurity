// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.b;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.h;
import myobfuscated.aj.j;
import myobfuscated.s.g;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            e

public abstract class f
    implements h
{

    private final g b;

    public f(Context context)
    {
        this(com.bumptech.glide.b.a(context).a);
    }

    private f(g g)
    {
        b = g;
    }

    protected abstract Bitmap a(g g, Bitmap bitmap, int i, int k);

    public final ad a(ad ad1, int i, int k)
    {
        if (!j.a(i, k))
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot apply transformation on width: ")).append(i).append(" or height: ").append(k).append(" less than or equal to zero and not Target.SIZE_ORIGINAL").toString());
        }
        Bitmap bitmap = (Bitmap)ad1.b();
        int l = i;
        if (i == 0x80000000)
        {
            l = bitmap.getWidth();
        }
        i = k;
        if (k == 0x80000000)
        {
            i = bitmap.getHeight();
        }
        Bitmap bitmap1 = a(b, bitmap, l, i);
        if (bitmap.equals(bitmap1))
        {
            return ad1;
        } else
        {
            return e.a(bitmap1, b);
        }
    }
}
