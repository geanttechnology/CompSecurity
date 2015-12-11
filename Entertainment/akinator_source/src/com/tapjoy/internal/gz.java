// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.net.URL;

// Referenced classes of package com.tapjoy.internal:
//            ax, ay, aw, bu, 
//            at, v, bp

public final class gz
{

    public static final bp b = new bp() {

        public final Object a(bu bu1)
        {
            return new gz(bu1);
        }

    };
    private static final at c;
    public URL a;
    private Bitmap d;

    gz(bu bu1)
    {
        if (bu1.b())
        {
            a = bu1.f();
            return;
        }
        bu1.i();
        String s = bu1.m();
        while (bu1.k()) 
        {
            if ("url".equals(s))
            {
                a = bu1.f();
            } else
            {
                bu1.t();
            }
        }
        bu1.j();
    }

    public gz(URL url)
    {
        a = url;
    }

    public final Bitmap a()
    {
        return d;
    }

    public final void b()
    {
        d = (Bitmap)c.a(a);
        if (d == null)
        {
            v v1 = v.a;
            d = v.a(a.openConnection());
            c.a(a, d);
        }
    }

    static 
    {
        Object obj = new ax();
        if (!(obj instanceof ay))
        {
            obj = new av.a((aw)obj);
        }
        c = ((at) (obj));
    }
}
