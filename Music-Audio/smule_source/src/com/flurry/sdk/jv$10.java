// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.net.URL;

// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            jz

final class  extends ir
{

    public URL a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
        } else
        {
            jx1 = jx1.h();
            if (!"null".equals(jx1))
            {
                return new URL(jx1);
            }
        }
        return null;
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (URL)obj);
    }

    public void a(jz jz1, URL url)
    {
        if (url == null)
        {
            url = null;
        } else
        {
            url = url.toExternalForm();
        }
        jz1.b(url);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    ()
    {
    }
}
