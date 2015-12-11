// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.e;

import com.shazam.android.ae.m;
import com.shazam.android.aq.e;
import com.shazam.android.j.e.b;
import com.shazam.b.e.a;
import com.shazam.h.k;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.shazam.android.e:
//            a

public final class g
    implements com.shazam.android.e.a
{

    private final com.shazam.android.y.b a;
    private final e b;
    private final b c;

    public g(com.shazam.android.y.b b1, e e1, b b2)
    {
        a = b1;
        b = e1;
        c = b2;
    }

    private static URL a(URL url, String s)
    {
        URL url1 = url;
        if (s != null)
        {
            url1 = url;
            if (!s.isEmpty())
            {
                try
                {
                    url1 = new URL(url, s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return url;
                }
            }
        }
        return url1;
    }

    public final void a(String s, Map map)
    {
        Object obj = null;
        b.a(map);
        String s1 = c.a();
        if (com.shazam.b.e.a.c(s1))
        {
            obj = com.shazam.b.c.a.a(s1);
        }
        Object obj2 = (String)map.get("uuid");
        Object obj1 = obj2;
        try
        {
            if (com.shazam.b.e.a.a(((String) (obj2))))
            {
                obj1 = UUID.randomUUID().toString();
            }
            map.put("clientbeaconuuid", obj1);
            obj1 = a;
            obj2 = new com.shazam.h.l.a();
            obj2.a = a(((URL) (obj)), s);
            com.shazam.h.y.a a1 = new com.shazam.h.y.a();
            a1.a = map;
            obj2.c = a1.a();
            obj2.e = k.a;
            ((com.shazam.android.y.b) (obj1)).a(((com.shazam.h.l.a) (obj2)).a());
            return;
        }
        catch (Exception exception)
        {
            obj1 = obj;
            obj = exception;
        }
        break MISSING_BLOCK_LABEL_156;
        obj;
        obj1 = null;
        if (map == null)
        {
            map = "null";
        } else
        {
            map = map.toString();
        }
        if (obj1 == null)
        {
            obj1 = "null";
        } else
        {
            obj1 = ((URL) (obj1)).toString();
        }
        m.a(this, ((Throwable) (obj)), "Failed to send beacon %s with param map %s to url %s", new Object[] {
            s, map, obj1
        });
        return;
    }
}
