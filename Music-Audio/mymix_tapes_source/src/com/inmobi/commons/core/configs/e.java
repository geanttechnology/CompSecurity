// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;

import com.inmobi.commons.a.a;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.uid.d;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.core.configs:
//            c

final class e extends NetworkRequest
{

    private static final String d = com/inmobi/commons/core/configs/e.getSimpleName();
    private static String h = "http://config.inmobi.com/config-server/v1/config/secure.cfg";
    private int e;
    private int f;
    private Map g;

    public e(Map map, d d1, String s, int i, int j)
    {
        String s1;
        com.inmobi.commons.core.network.NetworkRequest.RequestType requesttype;
label0:
        {
            requesttype = com.inmobi.commons.core.network.NetworkRequest.RequestType.POST;
            if (s != null)
            {
                s1 = s;
                if (s.trim().length() != 0)
                {
                    break label0;
                }
            }
            s1 = h;
        }
        super(requesttype, s1, true, d1);
        g = map;
        e = i;
        f = j;
    }

    private String e()
    {
        JSONArray jsonarray;
        c c1 = new c();
        try
        {
            jsonarray = new JSONArray();
            JSONObject jsonobject;
            for (Iterator iterator = g.entrySet().iterator(); iterator.hasNext(); jsonarray.put(jsonobject))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                jsonobject = new JSONObject();
                jsonobject.put("n", entry.getKey());
                jsonobject.put("t", c1.b((String)entry.getKey()));
            }

        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, d, "Problem while creating config network request's payload.", jsonexception);
            return "";
        }
        String s = jsonarray.toString();
        return s;
    }

    public void a()
    {
        super.a();
        c.put("p", e());
        c.put("im-accid", com.inmobi.commons.a.a.c());
    }

    public void a(String s)
    {
        g.remove(s);
    }

    public Map b()
    {
        return g;
    }

    public int c()
    {
        return e;
    }

    public int d()
    {
        return f;
    }

}
