// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.f;
import myobfuscated.f.m;
import myobfuscated.s.g;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            w

public final class a
    implements f
{

    private final f a;
    private final Resources b;
    private final g c;

    public a(Resources resources, g g1, f f1)
    {
        b = (Resources)m.a(resources, "Argument must not be null");
        c = (g)m.a(g1, "Argument must not be null");
        a = (f)m.a(f1, "Argument must not be null");
    }

    public final ad a(Object obj, int i, int j, e e)
    {
        obj = a.a(obj, i, j, e);
        if (obj == null)
        {
            return null;
        } else
        {
            return w.a(b, c, (Bitmap)((ad) (obj)).b());
        }
    }

    public final boolean a(Object obj, e e)
    {
        return a.a(obj, e);
    }
}
