// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.core.configs:
//            a

public class c
{

    private com.inmobi.commons.core.b.c a;

    public c()
    {
        a = com.inmobi.commons.core.b.c.b("config_store");
    }

    public static String a()
    {
        return com.inmobi.commons.core.b.c.a("config_store");
    }

    public void a(a a1)
    {
        try
        {
            a.a((new StringBuilder()).append(a1.a()).append("_config").toString(), a1.b().toString());
            a(a1.a(), System.currentTimeMillis());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            a1.printStackTrace();
        }
    }

    public void a(String s, long l)
    {
        a.a((new StringBuilder()).append(s).append("_config_update_ts").toString(), l);
    }

    public boolean a(String s)
    {
        return a.b((new StringBuilder()).append(s).append("_config").toString(), null) != null;
    }

    public long b(String s)
    {
        return a.b((new StringBuilder()).append(s).append("_config_update_ts").toString(), 0L);
    }

    public void b(a a1)
    {
        String s = a.b((new StringBuilder()).append(a1.a()).append("_config").toString(), null);
        if (s == null)
        {
            return;
        }
        try
        {
            a1.a(new JSONObject(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            a1.printStackTrace();
        }
    }
}
