// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.b;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.h;
import java.security.MessageDigest;
import myobfuscated.f.m;
import myobfuscated.s.g;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            e, w

public final class c
    implements h
{

    private final Context b;
    private final g c;
    private final h d;

    public c(Context context, h h1)
    {
        this(context, com.bumptech.glide.b.a(context).a, h1);
    }

    private c(Context context, g g1, h h1)
    {
        b = context.getApplicationContext();
        c = (g)m.a(g1, "Argument must not be null");
        d = (h)m.a(h1, "Argument must not be null");
    }

    public final ad a(ad ad1, int i, int j)
    {
        e e1 = e.a(((BitmapDrawable)ad1.b()).getBitmap(), c);
        Object obj = d.a(e1, i, j);
        if (obj.equals(e1))
        {
            return ad1;
        } else
        {
            ad1 = b;
            obj = (Bitmap)((ad) (obj)).b();
            return w.a(ad1.getResources(), com.bumptech.glide.b.a(ad1).a, ((Bitmap) (obj)));
        }
    }

    public final void a(MessageDigest messagedigest)
    {
        d.a(messagedigest);
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof c)
        {
            obj = (c)obj;
            return d.equals(((c) (obj)).d);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return d.hashCode();
    }
}
