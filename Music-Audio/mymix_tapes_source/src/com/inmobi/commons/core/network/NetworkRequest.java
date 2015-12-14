// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.network;

import android.util.Base64;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.configs.f;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.a.b;
import com.inmobi.commons.core.utilities.d;
import java.util.HashMap;
import java.util.Map;

public class NetworkRequest
{
    public static final class RequestType extends Enum
    {

        private static final RequestType $VALUES[];
        public static final RequestType GET;
        public static final RequestType POST;

        public static RequestType valueOf(String s)
        {
            return (RequestType)Enum.valueOf(com/inmobi/commons/core/network/NetworkRequest$RequestType, s);
        }

        public static RequestType[] values()
        {
            return (RequestType[])$VALUES.clone();
        }

        static 
        {
            GET = new RequestType("GET", 0);
            POST = new RequestType("POST", 1);
            $VALUES = (new RequestType[] {
                GET, POST
            });
        }

        private RequestType(String s, int i1)
        {
            super(s, i1);
        }
    }


    private static final String d = com/inmobi/commons/core/network/NetworkRequest.getSimpleName();
    protected Map a;
    protected Map b;
    protected Map c;
    private RequestType e;
    private String f;
    private com.inmobi.commons.core.utilities.uid.d g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private byte l[];
    private byte m[];
    private boolean n;
    private long o;

    public NetworkRequest(RequestType requesttype, String s, boolean flag, com.inmobi.commons.core.utilities.uid.d d1)
    {
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
        h = 60000;
        i = 60000;
        j = true;
        n = true;
        o = -1L;
        e = requesttype;
        f = s;
        k = flag;
        g = d1;
        a.put("User-Agent", com.inmobi.commons.a.a.d());
    }

    private String a(String s)
    {
        byte abyte0[] = com.inmobi.commons.core.utilities.a.b.a(8);
        l = com.inmobi.commons.core.utilities.a.b.a(16);
        m = com.inmobi.commons.core.utilities.a.b.a();
        HashMap hashmap = new HashMap();
        f f1 = new f();
        com.inmobi.commons.core.configs.b.a().a(f1, null);
        hashmap.put("sm", com.inmobi.commons.core.utilities.a.b.a(s, m, l, abyte0, f1.f(), f1.e()));
        hashmap.put("sn", f1.g());
        return com.inmobi.commons.core.utilities.d.a(hashmap, "&");
    }

    private void a(Map map)
    {
label0:
        {
            map.putAll(com.inmobi.commons.core.utilities.info.a.a().c());
            map.putAll(com.inmobi.commons.core.utilities.info.b.a());
            map.putAll(com.inmobi.commons.core.utilities.info.d.a());
            if (g != null)
            {
                if (!p())
                {
                    break label0;
                }
                map.putAll(g.a());
            }
            return;
        }
        map.putAll(g.b());
    }

    public void a()
    {
        if (n)
        {
            if (e == RequestType.GET)
            {
                a(b);
            } else
            if (e == RequestType.POST)
            {
                a(c);
                return;
            }
        }
    }

    public void a(long l1)
    {
        o = l1;
    }

    public void a(boolean flag)
    {
        n = flag;
    }

    public void b(int i1)
    {
        h = i1;
    }

    public void b(boolean flag)
    {
        j = flag;
    }

    public void c(int i1)
    {
        i = i1;
    }

    public void c(Map map)
    {
        c.putAll(map);
    }

    protected String e(String s)
    {
        Object obj = null;
        if (s == null || s.trim().length() == 0)
        {
            s = "";
        } else
        {
            byte abyte0[] = com.inmobi.commons.core.utilities.a.b.a(Base64.decode(s.getBytes(), 0), m, l);
            s = obj;
            if (abyte0 != null)
            {
                return new String(abyte0);
            }
        }
        return s;
    }

    public long f()
    {
        return o;
    }

    public boolean g()
    {
        return o != -1L;
    }

    public String h()
    {
        return f;
    }

    public Map i()
    {
        com.inmobi.commons.core.utilities.d.a(a);
        return a;
    }

    public String j()
    {
        com.inmobi.commons.core.utilities.d.a(b);
        String s = com.inmobi.commons.core.utilities.d.a(b, "&");
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, d, (new StringBuilder()).append("Get params: ").append(s).toString());
        return s;
    }

    public String k()
    {
        com.inmobi.commons.core.utilities.d.a(c);
        String s1 = com.inmobi.commons.core.utilities.d.a(c, "&");
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, d, (new StringBuilder()).append("Post body url: ").append(h()).toString());
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, d, (new StringBuilder()).append("Post body: ").append(s1).toString());
        String s = s1;
        if (p())
        {
            s = a(s1);
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, d, (new StringBuilder()).append("Encrypted post body: ").append(s).toString());
        }
        return s;
    }

    public boolean l()
    {
        return j;
    }

    public RequestType m()
    {
        return e;
    }

    public int n()
    {
        return h;
    }

    public int o()
    {
        return i;
    }

    public boolean p()
    {
        return k;
    }

}
