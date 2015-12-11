// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UrlRequestContextConfig
{

    JSONObject a;

    public UrlRequestContextConfig()
    {
        boolean flag = false;
        super();
        a = new JSONObject();
        a("ENABLE_LEGACY_MODE", false);
        a("ENABLE_QUIC", false);
        a("ENABLE_SPDY", true);
        HttpCache httpcache = HttpCache.a;
        if (httpcache == HttpCache.d || httpcache == HttpCache.c)
        {
            if (a().isEmpty())
            {
                throw new IllegalArgumentException("Storage path must be set");
            }
        } else
        if (!a().isEmpty())
        {
            throw new IllegalArgumentException("Storage path must be empty");
        }
        if (httpcache == HttpCache.a || httpcache == HttpCache.c)
        {
            flag = true;
        }
        a("LOAD_DISABLE_CACHE", flag);
        a("HTTP_CACHE_MAX_SIZE", 0L);
        switch (_cls1.a[httpcache.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a("HTTP_CACHE", "HTTP_CACHE_DISABLED");
            return;

        case 2: // '\002'
        case 3: // '\003'
            a("HTTP_CACHE", "HTTP_CACHE_DISK");
            return;

        case 4: // '\004'
            a("HTTP_CACHE", "HTTP_CACHE_MEMORY");
            break;
        }
    }

    private String a()
    {
        return a.optString("STORAGE_PATH");
    }

    private UrlRequestContextConfig a(String s, long l)
    {
        try
        {
            a.put(s, l);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return this;
        }
        return this;
    }

    private UrlRequestContextConfig a(String s, String s1)
    {
        try
        {
            a.put(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return this;
        }
        return this;
    }

    public final UrlRequestContextConfig a(String s, int i, int j)
    {
        if (s.contains("/"))
        {
            throw new IllegalArgumentException((new StringBuilder("Illegal QUIC Hint Host: ")).append(s).toString());
        }
        JSONArray jsonarray;
        Object obj;
        try
        {
            obj = a.optJSONArray("QUIC_HINTS");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return this;
        }
        jsonarray = ((JSONArray) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        jsonarray = new JSONArray();
        a.put("QUIC_HINTS", jsonarray);
        obj = new JSONObject();
        ((JSONObject) (obj)).put("QUIC_HINT_HOST", s);
        ((JSONObject) (obj)).put("QUIC_HINT_PORT", i);
        ((JSONObject) (obj)).put("QUIC_HINT_ALT_PORT", j);
        jsonarray.put(obj);
        return this;
    }

    public UrlRequestContextConfig a(String s, boolean flag)
    {
        try
        {
            a.put(s, flag);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return this;
        }
        return this;
    }

    public String toString()
    {
        return a.toString();
    }

    private class HttpCache extends Enum
    {

        public static final HttpCache a;
        public static final HttpCache b;
        public static final HttpCache c;
        public static final HttpCache d;
        private static final HttpCache e[];

        public static HttpCache valueOf(String s)
        {
            return (HttpCache)Enum.valueOf(org/chromium/net/UrlRequestContextConfig$HttpCache, s);
        }

        public static HttpCache[] values()
        {
            return (HttpCache[])e.clone();
        }

        static 
        {
            a = new HttpCache("DISABLED", 0);
            b = new HttpCache("IN_MEMORY", 1);
            c = new HttpCache("DISK_NO_HTTP", 2);
            d = new HttpCache("DISK", 3);
            e = (new HttpCache[] {
                a, b, c, d
            });
        }

        private HttpCache(String s, int i)
        {
            super(s, i);
        }
    }


    private class _cls1
    {

        static final int a[];

        static 
        {
            a = new int[HttpCache.values().length];
            try
            {
                a[HttpCache.a.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[HttpCache.c.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[HttpCache.d.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[HttpCache.b.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
