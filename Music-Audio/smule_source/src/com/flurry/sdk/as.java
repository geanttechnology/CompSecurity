// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            gd

public final class as
{

    static final List a = Arrays.asList(new String[] {
        "requested", "filled", "unfilled", "rendered", "clicked", "prepared", "adunitMerged", "sendUrlStatusResult", "videoStart", "videoFirstQuartile", 
        "videoMidpoint", "videoThirdQuartile", "videoCompleted", "videoProgressed", "sentToUrl", "adClosed", "adWillClose", "renderFailed", "requestAdComponents", "urlVerified", 
        "capExhausted", "capNotExhausted"
    });
    private static final String b = com/flurry/sdk/as.getSimpleName();
    private String c;
    private boolean d;
    private long e;
    private Map f;

    private as()
    {
    }


    public as(String s, boolean flag, long l, Map map)
    {
        if (!a.contains(s))
        {
            gd.a(b, (new StringBuilder()).append("AdEvent initialized with unrecognized type: ").append(s).toString());
        }
        c = s;
        d = flag;
        e = l;
        if (map == null)
        {
            f = new HashMap();
            return;
        } else
        {
            f = map;
            return;
        }
    }

    static long a(as as1, long l)
    {
        as1.e = l;
        return l;
    }

    static String a(as as1)
    {
        return as1.c;
    }

    static String a(as as1, String s)
    {
        as1.c = s;
        return s;
    }

    static Map a(as as1, Map map)
    {
        as1.f = map;
        return map;
    }

    static boolean a(as as1, boolean flag)
    {
        as1.d = flag;
        return flag;
    }

    static boolean b(as as1)
    {
        return as1.d;
    }

    static long c(as as1)
    {
        return as1.e;
    }

    static Map d(as as1)
    {
        return as1.f;
    }

    public String a()
    {
        return c;
    }

    public boolean b()
    {
        return d;
    }

    public long c()
    {
        return e;
    }

    public Map d()
    {
        return f;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof as))
            {
                return false;
            }
            obj = (as)obj;
            if (!TextUtils.equals(c, ((as) (obj)).c) || d != ((as) (obj)).d || e != ((as) (obj)).e || f != ((as) (obj)).f && (f == null || !f.equals(((as) (obj)).f)))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int i = 17;
        if (c != null)
        {
            i = 0x11 ^ c.hashCode();
        }
        int j = i;
        if (d)
        {
            j = i ^ 1;
        }
        j = (int)((long)j ^ e);
        i = j;
        if (f != null)
        {
            i = j ^ f.hashCode();
        }
        return i;
    }

}
