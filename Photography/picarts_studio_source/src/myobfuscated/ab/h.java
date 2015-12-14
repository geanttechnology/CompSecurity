// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.b;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.resource.bitmap.e;
import java.security.MessageDigest;
import myobfuscated.f.m;
import myobfuscated.s.g;

// Referenced classes of package myobfuscated.ab:
//            d, e, i

public final class h
    implements com.bumptech.glide.load.h
{

    private final com.bumptech.glide.load.h b;
    private final g c;

    public h(Context context, com.bumptech.glide.load.h h1)
    {
        this(h1, com.bumptech.glide.b.a(context).a);
    }

    private h(com.bumptech.glide.load.h h1, g g1)
    {
        b = (com.bumptech.glide.load.h)m.a(h1, "Argument must not be null");
        c = (g)m.a(g1, "Argument must not be null");
    }

    public final ad a(ad ad1, int j, int k)
    {
        d d1 = (d)ad1.b();
        Object obj = new e(d1.a.a.j, c);
        Object obj1 = b.a(((ad) (obj)), j, k);
        if (!obj.equals(obj1))
        {
            ((ad) (obj)).d();
        }
        obj = (Bitmap)((ad) (obj1)).b();
        obj1 = b;
        d1.a.a.a(((com.bumptech.glide.load.h) (obj1)), ((Bitmap) (obj)));
        return ad1;
    }

    public final void a(MessageDigest messagedigest)
    {
        b.a(messagedigest);
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof h)
        {
            obj = (h)obj;
            return b.equals(((h) (obj)).b);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return b.hashCode();
    }
}
