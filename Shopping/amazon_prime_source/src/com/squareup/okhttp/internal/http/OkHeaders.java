// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Platform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Headers, Request, Response

public final class OkHeaders
{

    private static final Comparator FIELD_NAME_COMPARATOR = new Comparator() {

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((String)obj, (String)obj1);
        }

        public int compare(String s, String s1)
        {
            if (s == s1)
            {
                return 0;
            }
            if (s == null)
            {
                return -1;
            }
            if (s1 == null)
            {
                return 1;
            } else
            {
                return String.CASE_INSENSITIVE_ORDER.compare(s, s1);
            }
        }

    };
    static final String PREFIX = Platform.get().getPrefix();
    public static final String RECEIVED_MILLIS = (new StringBuilder()).append(PREFIX).append("-Received-Millis").toString();
    public static final String RESPONSE_SOURCE = (new StringBuilder()).append(PREFIX).append("-Response-Source").toString();
    public static final String SELECTED_PROTOCOL = (new StringBuilder()).append(PREFIX).append("-Selected-Protocol").toString();
    public static final String SENT_MILLIS = (new StringBuilder()).append(PREFIX).append("-Sent-Millis").toString();

    private OkHeaders()
    {
    }

    public static void addCookies(Request.Builder builder, Map map)
    {
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            String s = (String)entry.getKey();
            if (("Cookie".equalsIgnoreCase(s) || "Cookie2".equalsIgnoreCase(s)) && !((List)entry.getValue()).isEmpty())
            {
                builder.addHeader(s, buildCookieHeader((List)entry.getValue()));
            }
        } while (true);
    }

    private static String buildCookieHeader(List list)
    {
        if (list.size() == 1)
        {
            return (String)list.get(0);
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            if (i > 0)
            {
                stringbuilder.append("; ");
            }
            stringbuilder.append((String)list.get(i));
        }

        return stringbuilder.toString();
    }

    public static long contentLength(Headers headers)
    {
        return stringToLong(headers.get("Content-Length"));
    }

    public static long contentLength(Request request)
    {
        return contentLength(request.headers());
    }

    public static long contentLength(Response response)
    {
        return contentLength(response.headers());
    }

    private static long stringToLong(String s)
    {
        if (s == null)
        {
            return -1L;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1L;
        }
        return l;
    }

    public static Map toMultimap(Headers headers, String s)
    {
        TreeMap treemap = new TreeMap(FIELD_NAME_COMPARATOR);
        for (int i = 0; i < headers.size(); i++)
        {
            String s1 = headers.name(i);
            String s2 = headers.value(i);
            ArrayList arraylist = new ArrayList();
            List list = (List)treemap.get(s1);
            if (list != null)
            {
                arraylist.addAll(list);
            }
            arraylist.add(s2);
            treemap.put(s1, Collections.unmodifiableList(arraylist));
        }

        if (s != null)
        {
            treemap.put(null, Collections.unmodifiableList(Collections.singletonList(s)));
        }
        return Collections.unmodifiableMap(treemap);
    }

}
