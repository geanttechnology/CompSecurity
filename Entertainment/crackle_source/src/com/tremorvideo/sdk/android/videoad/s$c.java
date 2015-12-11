// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            s, n

public class i
{

    final s a;
    private String b;
    private String c;
    private int d;
    private String e;
    private long f;
    private String g;
    private int h;
    private int i;
    private boolean j;
    private String k;
    private long l;

    static String a(i i1)
    {
        return i1.k;
    }

    static boolean b(k k1)
    {
        return k1.j;
    }

    static long c(j j1)
    {
        return j1.l;
    }

    public String a()
    {
        if (j)
        {
            return b;
        } else
        {
            return n.b(b);
        }
    }

    public int b()
    {
        return h;
    }

    public int c()
    {
        return i;
    }

    public String d()
    {
        return b;
    }

    public String e()
    {
        return g;
    }

    public String f()
    {
        return c;
    }

    public int g()
    {
        return d;
    }

    public long h()
    {
        return f;
    }

    public (s s1, JSONObject jsonobject)
        throws Exception
    {
        a = s1;
        super();
        e = "";
        f = 0L;
        g = "";
        h = 0;
        i = 0;
        j = false;
        b = jsonobject.getString("video-url");
        c = jsonobject.getString("format");
        g = jsonobject.getString("tag");
        if (jsonobject.has("streaming"))
        {
            j = jsonobject.getBoolean("streaming");
        }
        if (j)
        {
            if (jsonobject.has("ad-size"))
            {
                d = jsonobject.getInt("ad-size");
            }
        } else
        {
            d = jsonobject.getInt("ad-size");
        }
        if (jsonobject.has("video-crc-32"))
        {
            f = jsonobject.getLong("video-crc-32");
        } else
        if (jsonobject.has("video-crc32"))
        {
            f = jsonobject.getLong("video-crc32");
        }
        if (jsonobject.has("streaming"))
        {
            j = jsonobject.getBoolean("streaming");
        }
        if (jsonobject.has("embed-video-player"))
        {
            k = jsonobject.getString("embed-video-player");
            if (jsonobject.has("embed-video-player-crc32"))
            {
                l = jsonobject.getLong("embed-video-player-crc32");
            }
        } else
        {
            k = null;
        }
        s1 = c.split("-")[1].split("x");
        h = Integer.parseInt(s1[0]);
        i = Integer.parseInt(s1[1]);
    }
}
