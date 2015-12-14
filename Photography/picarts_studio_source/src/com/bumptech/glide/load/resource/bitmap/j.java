// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;
import myobfuscated.s.g;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            f, z

public final class j extends f
{

    private static final byte b[];

    public j(Context context)
    {
        super(context);
    }

    protected final Bitmap a(g g, Bitmap bitmap, int i, int k)
    {
        return z.c(g, bitmap, i, k);
    }

    public final void a(MessageDigest messagedigest)
    {
        messagedigest.update(b);
    }

    public final boolean equals(Object obj)
    {
        return obj instanceof j;
    }

    public final int hashCode()
    {
        return "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".hashCode();
    }

    static 
    {
        b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(a);
    }
}
