// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.f;
import java.io.InputStream;
import myobfuscated.aj.e;
import myobfuscated.aj.h;
import myobfuscated.s.j;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            RecyclableBufferedInputStream, y, p

public final class x
    implements f
{

    private final p a;
    private final j b;

    public x(p p1, j j)
    {
        a = p1;
        b = j;
    }

    private ad a(InputStream inputstream, int i, int j, com.bumptech.glide.load.e e1)
    {
        e e2;
        boolean flag;
        h h1;
        y y1;
        if (inputstream instanceof RecyclableBufferedInputStream)
        {
            inputstream = (RecyclableBufferedInputStream)inputstream;
            flag = false;
        } else
        {
            inputstream = new RecyclableBufferedInputStream(inputstream, b);
            flag = true;
        }
        e2 = e.a(inputstream);
        h1 = new h(e2);
        y1 = new y(inputstream, e2);
        e1 = a.a(h1, i, j, e1, y1);
        e2.a();
        if (flag)
        {
            inputstream.b();
        }
        return e1;
        e1;
        e2.a();
        if (flag)
        {
            inputstream.b();
        }
        throw e1;
    }

    public final volatile ad a(Object obj, int i, int j, com.bumptech.glide.load.e e1)
    {
        return a((InputStream)obj, i, j, e1);
    }

    public final volatile boolean a(Object obj, com.bumptech.glide.load.e e1)
    {
        return p.a();
    }
}
