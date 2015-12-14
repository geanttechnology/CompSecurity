// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.util;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.ads.internal.thirdparty.http.a;
import com.facebook.ads.internal.thirdparty.http.n;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.facebook.ads.internal.util:
//            r, g, a

public class o extends AsyncTask
{

    private static final String a = com/facebook/ads/internal/util/o.getSimpleName();
    private static final Set b;
    private Map c;
    private Map d;

    public o()
    {
        this(null, null);
    }

    public o(Map map)
    {
        this(map, null);
    }

    public o(Map map, Map map1)
    {
        c = map;
        d = map1;
    }

    private String a(String s, String s1, String s2)
    {
        if (com.facebook.ads.internal.util.r.a(s) || com.facebook.ads.internal.util.r.a(s1) || com.facebook.ads.internal.util.r.a(s2))
        {
            return s;
        }
        String s3;
        if (s.contains("?"))
        {
            s3 = "&";
        } else
        {
            s3 = "?";
        }
        return (new StringBuilder()).append(s).append(s3).append(s1).append("=").append(URLEncoder.encode(s2)).toString();
    }

    private boolean a(String s)
    {
        a a1;
        boolean flag;
        flag = true;
        a1 = g.c();
        Exception exception;
        com.facebook.ads.internal.thirdparty.http.o o1;
        int i;
        if (d == null || d.size() == 0)
        {
            return a1.a(s, null).a() == 200;
        }
        o1 = new com.facebook.ads.internal.thirdparty.http.o();
        o1.a(d);
        i = a1.b(s, o1).a();
        if (i != 200)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_112;
        exception;
        Log.e(a, (new StringBuilder()).append("Error opening url: ").append(s).toString(), exception);
        flag = false;
        return flag;
    }

    private String b(String s)
    {
        String s1;
        try
        {
            s1 = a(s, "analog", com.facebook.ads.internal.util.g.a(com.facebook.ads.internal.util.a.a()));
        }
        catch (Exception exception)
        {
            return s;
        }
        return s1;
    }

    protected transient Void a(String as[])
    {
        as = as[0];
        if (!com.facebook.ads.internal.util.r.a(as) && !b.contains(as))
        {
            as = b(as);
            Object obj = as;
            if (c != null)
            {
                obj = as;
                if (!c.isEmpty())
                {
                    for (obj = c.entrySet().iterator(); ((Iterator) (obj)).hasNext();)
                    {
                        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                        as = a(((String) (as)), (String)entry.getKey(), (String)entry.getValue());
                    }

                    obj = as;
                }
            }
            int i = 1;
            while (i <= 2 && !a(((String) (obj)))) 
            {
                i++;
            }
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    static 
    {
        b = new HashSet();
        b.add("#");
        b.add("null");
    }
}
