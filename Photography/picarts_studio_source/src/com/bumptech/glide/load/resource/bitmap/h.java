// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.f;
import java.nio.ByteBuffer;
import myobfuscated.aj.a;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            p

public final class h
    implements f
{

    private final p a;

    public h(p p1)
    {
        a = p1;
    }

    public final ad a(Object obj, int i, int j, e e)
    {
        obj = myobfuscated.aj.a.b((ByteBuffer)obj);
        return a.a(((java.io.InputStream) (obj)), i, j, e, p.c);
    }

    public final boolean a(Object obj, e e)
    {
        return p.b();
    }
}
