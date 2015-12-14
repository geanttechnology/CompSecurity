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

public final class r extends f
{

    private static final byte b[];

    public r(Context context)
    {
        super(context);
    }

    protected final Bitmap a(g g, Bitmap bitmap, int i, int j)
    {
        return z.b(g, bitmap, i, j);
    }

    public final void a(MessageDigest messagedigest)
    {
        messagedigest.update(b);
    }

    public final boolean equals(Object obj)
    {
        return obj instanceof r;
    }

    public final int hashCode()
    {
        return "com.bumptech.glide.load.resource.bitmap.FitCenter".hashCode();
    }

    static 
    {
        b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(a);
    }
}
