// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.paypal.android.sdk:
//            ii, kt

final class ik
{

    private static final ii a[];
    private static final Map b;

    static kt a(kt kt1)
    {
        int i = 0;
        for (int j = kt1.b.length; i < j; i++)
        {
            byte byte0 = kt1.b[i];
            if (byte0 >= 65 && byte0 <= 90)
            {
                throw new IOException((new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ")).append(kt1.a()).toString());
            }
        }

        return kt1;
    }

    static ii[] a()
    {
        return a;
    }

    static Map b()
    {
        return b;
    }

    static 
    {
        int i = 0;
        a = (new ii[] {
            new ii(ii.e, ""), new ii(ii.b, "GET"), new ii(ii.b, "POST"), new ii(ii.c, "/"), new ii(ii.c, "/index.html"), new ii(ii.d, "http"), new ii(ii.d, "https"), new ii(ii.a, "200"), new ii(ii.a, "204"), new ii(ii.a, "206"), 
            new ii(ii.a, "304"), new ii(ii.a, "400"), new ii(ii.a, "404"), new ii(ii.a, "500"), new ii("accept-charset", ""), new ii("accept-encoding", "gzip, deflate"), new ii("accept-language", ""), new ii("accept-ranges", ""), new ii("accept", ""), new ii("access-control-allow-origin", ""), 
            new ii("age", ""), new ii("allow", ""), new ii("authorization", ""), new ii("cache-control", ""), new ii("content-disposition", ""), new ii("content-encoding", ""), new ii("content-language", ""), new ii("content-length", ""), new ii("content-location", ""), new ii("content-range", ""), 
            new ii("content-type", ""), new ii("cookie", ""), new ii("date", ""), new ii("etag", ""), new ii("expect", ""), new ii("expires", ""), new ii("from", ""), new ii("host", ""), new ii("if-match", ""), new ii("if-modified-since", ""), 
            new ii("if-none-match", ""), new ii("if-range", ""), new ii("if-unmodified-since", ""), new ii("last-modified", ""), new ii("link", ""), new ii("location", ""), new ii("max-forwards", ""), new ii("proxy-authenticate", ""), new ii("proxy-authorization", ""), new ii("range", ""), 
            new ii("referer", ""), new ii("refresh", ""), new ii("retry-after", ""), new ii("server", ""), new ii("set-cookie", ""), new ii("strict-transport-security", ""), new ii("transfer-encoding", ""), new ii("user-agent", ""), new ii("vary", ""), new ii("via", ""), 
            new ii("www-authenticate", "")
        });
        LinkedHashMap linkedhashmap = new LinkedHashMap(61);
        for (; i < 61; i++)
        {
            if (!linkedhashmap.containsKey(a[i].h))
            {
                linkedhashmap.put(a[i].h, Integer.valueOf(i));
            }
        }

        b = Collections.unmodifiableMap(linkedhashmap);
    }
}
