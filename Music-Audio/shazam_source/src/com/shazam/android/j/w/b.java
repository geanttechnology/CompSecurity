// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.w;

import com.shazam.android.aq.c;
import com.shazam.android.j.o;
import com.shazam.b.c.a;
import com.shazam.o.k;
import com.shazam.server.response.config.AmpApis;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpHref;
import com.shazam.server.response.config.AmpSocial;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.shazam.android.j.w:
//            c

public final class b
    implements com.shazam.android.j.w.c
{

    private final c b;
    private final o c;

    public b(c c1, o o1)
    {
        b = c1;
        c = o1;
    }

    private static String a(String s, Map map)
    {
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            s = s.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue());
        }

        return s;
    }

    private URL a(a a1)
    {
        return a(a1, Collections.emptyMap());
    }

    private URL a(a a1, Map map)
    {
        Object obj = b.a();
    /* block-local class not found */
    class a {}

        a1 = a1.j;
        obj = (AmpHref)((AmpConfig) (obj)).getAmpApis().getSocial().getHrefMap().get(a1);
        if (obj == null)
        {
            throw new com.shazam.f.b((new StringBuilder()).append(a1).append(" is null").toString());
        }
        a1 = ((AmpHref) (obj)).getHref();
        a1 = a(c.a(a1), map);
        if (a1 == null)
        {
            throw new com.shazam.f.b("Endpoint does not exist");
        } else
        {
            return com.shazam.b.c.a.a(a1);
        }
    }

    public final URL a()
    {
        return a(a.b);
    }

    public final URL a(String s)
    {
        return a(com.shazam.android.j.w.a.a, k.a("{likekey}", s));
    }

    public final URL b()
    {
        return a(a.d);
    }

    public final URL b(String s)
    {
        return a(com.shazam.android.j.w.a.c, k.a("{followkey}", s));
    }

    public final URL c()
    {
        return a(a.e);
    }

    public final URL c(String s)
    {
        return a(a.f, k.a("{followkey}", s));
    }

    public final URL d(String s)
    {
        return a(a.g, k.a("{postid}", s));
    }

    public final URL e(String s)
    {
        return a(a.h, k.a("{postid}", s));
    }

    public final URL f(String s)
    {
        return a(a.i, k.a("{artistid}", s));
    }
}
