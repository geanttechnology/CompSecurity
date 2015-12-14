// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import myobfuscated.aj.e;
import myobfuscated.s.g;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            q, RecyclableBufferedInputStream

final class y
    implements q
{

    private final RecyclableBufferedInputStream a;
    private final e b;

    public y(RecyclableBufferedInputStream recyclablebufferedinputstream, e e1)
    {
        a = recyclablebufferedinputstream;
        b = e1;
    }

    public final void a()
    {
        a.a();
    }

    public final void a(g g1, Bitmap bitmap)
    {
        java.io.IOException ioexception = b.a;
        if (ioexception != null)
        {
            if (bitmap != null)
            {
                g1.a(bitmap);
            }
            throw ioexception;
        } else
        {
            return;
        }
    }
}
