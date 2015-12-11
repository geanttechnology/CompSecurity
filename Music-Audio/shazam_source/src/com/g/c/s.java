// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

// Referenced classes of package com.g.c:
//            z, x, j, ah, 
//            ab

final class s extends z
{
    static final class a extends IOException
    {

        public a(String s1)
        {
            super(s1);
        }
    }


    private final j a;
    private final ab b;

    public s(j j1, ab ab1)
    {
        a = j1;
        b = ab1;
    }

    final int a()
    {
        return 2;
    }

    final boolean a(NetworkInfo networkinfo)
    {
        return networkinfo == null || networkinfo.isConnected();
    }

    public final boolean a(x x1)
    {
        x1 = x1.d.getScheme();
        return "http".equals(x1) || "https".equals(x1);
    }

    public final z.a b(x x1)
    {
        j.a a1 = a.a(x1.d, x1.c);
        Object obj;
        if (a1.c)
        {
            x1 = u.d.b;
        } else
        {
            x1 = u.d.c;
        }
        obj = a1.b;
        if (obj != null)
        {
            return new z.a(((android.graphics.Bitmap) (obj)), x1);
        }
        obj = a1.a;
        if (obj == null)
        {
            return null;
        }
        if (x1 == u.d.b && a1.d == 0L)
        {
            ah.a(((java.io.InputStream) (obj)));
            throw new a("Received response with 0 content-length header.");
        }
        if (x1 == u.d.c && a1.d > 0L)
        {
            ab ab1 = b;
            long l = a1.d;
            ab1.c.sendMessage(ab1.c.obtainMessage(4, Long.valueOf(l)));
        }
        return new z.a(((java.io.InputStream) (obj)), x1);
    }

    final boolean b()
    {
        return true;
    }
}
