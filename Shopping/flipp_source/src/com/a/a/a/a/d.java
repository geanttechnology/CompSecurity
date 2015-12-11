// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.o;
import com.a.a.p;
import com.a.a.q;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.a.a.a.a:
//            e, v, b

public final class d
{

    public static final o a = new e();

    private static List a(v v1, String s)
    {
        ArrayList arraylist = new ArrayList();
label0:
        for (int i = 0; i < v1.a(); i++)
        {
            if (!s.equalsIgnoreCase(v1.a(i)))
            {
                continue;
            }
            String s1 = v1.b(i);
            int j = 0;
            do
            {
                if (j >= s1.length())
                {
                    continue label0;
                }
                int k = b.a(s1, j, " ");
                String s2 = s1.substring(j, k).trim();
                j = b.a(s1, k);
                if (!s1.regionMatches(j, "realm=\"", 0, 7))
                {
                    continue label0;
                }
                j += 7;
                k = b.a(s1, j, "\"");
                String s3 = s1.substring(j, k);
                j = b.a(s1, b.a(s1, k + 1, ",") + 1);
                arraylist.add(new p(s2, s3));
            } while (true);
        }

        return arraylist;
    }

    public static boolean a(o o1, int i, v v1, v v2, Proxy proxy, URL url)
    {
        String s;
        Object obj;
        if (i == 401)
        {
            obj = "WWW-Authenticate";
            s = "Authorization";
        } else
        if (i == 407)
        {
            obj = "Proxy-Authenticate";
            s = "Proxy-Authorization";
        } else
        {
            throw new IllegalArgumentException();
        }
        obj = a(v1, ((String) (obj)));
        if (((List) (obj)).isEmpty())
        {
            return false;
        }
        if (v1.d == 407)
        {
            o1 = o1.b(proxy, url, ((List) (obj)));
        } else
        {
            o1 = o1.a(proxy, url, ((List) (obj)));
        }
        if (o1 == null)
        {
            return false;
        } else
        {
            v2.b(s, ((q) (o1)).a);
            return true;
        }
    }

}
