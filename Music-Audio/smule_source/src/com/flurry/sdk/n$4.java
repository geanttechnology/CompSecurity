// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.net.HttpCookie;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            n, gk, gd, fp

class nit>
    implements 
{

    final n a;

    public volatile void a(gk gk1, Object obj)
    {
        a(gk1, (Void)obj);
    }

    public void a(gk gk1, Void void1)
    {
        gd.a(3, n.f(), (new StringBuilder()).append("BCookie request: HTTP status code is:").append(gk1.e()).toString());
        if (gk1.c())
        {
            gk1 = gk1.b("Set-Cookie");
            if (gk1 != null)
            {
                for (gk1 = gk1.iterator(); gk1.hasNext();)
                {
                    void1 = HttpCookie.parse((String)gk1.next());
                    if (void1 != null)
                    {
                        void1 = void1.iterator();
                        while (void1.hasNext()) 
                        {
                            HttpCookie httpcookie = (HttpCookie)void1.next();
                            if (HttpCookie.domainMatches(".yahoo.com", httpcookie.getDomain()) && "B".equalsIgnoreCase(httpcookie.getName()))
                            {
                                gd.a(3, n.f(), "Found BCookie");
                                n.a(a, httpcookie.getValue());
                            }
                        }
                    }
                }

            }
        }
        if (TextUtils.isEmpty(n.b(a)))
        {
            n.a(a, 1);
            gd.a(3, n.f(), (new StringBuilder()).append("BCookie request failed, backing off: ").append(n.c(a)).append("ms").toString());
            fp.a().b(n.d(a), n.c(a));
            return;
        } else
        {
            n.e(a);
            return;
        }
    }

    ils(n n1)
    {
        a = n1;
        super();
    }
}
