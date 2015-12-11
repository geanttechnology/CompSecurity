// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class HttpHeaderParser
{

    public HttpHeaderParser()
    {
    }

    public static com.android.volley.Cache.Entry parseCacheHeaders(NetworkResponse networkresponse)
    {
        Map map;
        String s;
        boolean flag;
        boolean flag1;
        boolean flag2;
        long l;
        long l1;
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        long l8;
        long l9;
        l9 = System.currentTimeMillis();
        map = networkresponse.headers;
        l2 = 0L;
        l5 = 0L;
        l6 = 0L;
        l7 = 0L;
        l8 = 0L;
        l1 = 0L;
        l = 0L;
        flag1 = false;
        flag2 = false;
        flag = false;
        s = (String)map.get("Date");
        if (s != null)
        {
            l2 = parseDateAsEpoch(s);
        }
        s = (String)map.get("Cache-Control");
        l4 = l1;
        l3 = l;
        if (s == null) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        boolean flag3;
        flag3 = true;
        as = s.split(",");
        i = 0;
_L6:
        flag1 = flag3;
        flag2 = flag;
        l4 = l1;
        l3 = l;
        if (i >= as.length) goto _L2; else goto _L3
_L3:
        String s1;
        s1 = as[i].trim();
        if (s1.equals("no-cache") || s1.equals("no-store"))
        {
            return null;
        }
        if (!s1.startsWith("max-age=")) goto _L5; else goto _L4
_L4:
        l3 = Long.parseLong(s1.substring(8));
        l4 = l;
_L7:
        i++;
        l1 = l3;
        l = l4;
          goto _L6
_L5:
        if (!s1.startsWith("stale-while-revalidate="))
        {
            break MISSING_BLOCK_LABEL_218;
        }
        l4 = Long.parseLong(s1.substring(23));
        l3 = l1;
          goto _L7
        if (s1.equals("must-revalidate")) goto _L9; else goto _L8
_L8:
        l3 = l1;
        l4 = l;
        if (!s1.equals("proxy-revalidate")) goto _L7; else goto _L9
_L9:
        flag = true;
        l3 = l1;
        l4 = l;
          goto _L7
_L2:
        as = (String)map.get("Expires");
        if (as != null)
        {
            l6 = parseDateAsEpoch(as);
        }
        as = (String)map.get("Last-Modified");
        if (as != null)
        {
            l5 = parseDateAsEpoch(as);
        }
        as = (String)map.get("ETag");
        if (!flag1) goto _L11; else goto _L10
_L10:
        l1 = l9 + 1000L * l4;
        com.android.volley.Cache.Entry entry;
        if (flag2)
        {
            l = l1;
        } else
        {
            l = l1 + 1000L * l3;
        }
_L13:
        entry = new com.android.volley.Cache.Entry();
        entry.data = networkresponse.data;
        entry.etag = as;
        entry.softTtl = l1;
        entry.ttl = l;
        entry.serverDate = l2;
        entry.lastModified = l5;
        entry.responseHeaders = map;
        return entry;
_L11:
        l = l8;
        l1 = l7;
        if (l2 > 0L)
        {
            l = l8;
            l1 = l7;
            if (l6 >= l2)
            {
                l1 = l9 + (l6 - l2);
                l = l1;
            }
        }
        if (true) goto _L13; else goto _L12
_L12:
        Exception exception;
        exception;
        l3 = l1;
        l4 = l;
          goto _L7
        exception;
        l3 = l1;
        l4 = l;
          goto _L7
    }

    public static String parseCharset(Map map)
    {
        return parseCharset(map, "ISO-8859-1");
    }

    public static String parseCharset(Map map, String s)
    {
        String s1;
        s1 = (String)map.get("Content-Type");
        map = s;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        as = s1.split(";");
        i = 1;
_L7:
        map = s;
        if (i >= as.length) goto _L2; else goto _L3
_L3:
        map = as[i].trim().split("=");
        if (map.length != 2 || !map[0].equals("charset")) goto _L5; else goto _L4
_L4:
        map = map[1];
_L2:
        return map;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static long parseDateAsEpoch(String s)
    {
        long l;
        try
        {
            l = DateUtils.parseDate(s).getTime();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0L;
        }
        return l;
    }
}
