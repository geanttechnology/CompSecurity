// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.signals.b.a;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m
{

    private static final String a = com/inmobi/signals/m.getSimpleName();
    private long b;
    private a c;
    private List d;
    private Map e;

    public m()
    {
        a(Calendar.getInstance().getTimeInMillis());
    }

    public void a(long l)
    {
        b = l;
    }

    public void a(a a1)
    {
        c = a1;
    }

    public void a(List list)
    {
        d = list;
    }

    public void a(Map map)
    {
        e = map;
    }

    public boolean a()
    {
        return c != null || d != null;
    }

    public JSONObject b()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("ts", b);
        if (e != null && !e.isEmpty())
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = e.entrySet().iterator(); iterator.hasNext(); jsonobject.put((String)entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
          goto _L1
        JSONException jsonexception;
        jsonexception;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while converting IceWifiCellSample to string.", jsonexception);
_L3:
        return jsonobject;
_L1:
        JSONArray jsonarray;
        if (c != null)
        {
            jsonobject.put("c-ap", c.b());
        }
        jsonarray = new JSONArray();
        if (d == null) goto _L3; else goto _L2
_L2:
        int i = 0;
_L5:
        if (i >= d.size())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray.put(((a)d.get(i)).b());
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        if (jsonarray.length() <= 0) goto _L3; else goto _L6
_L6:
        jsonobject.put("v-ap", jsonarray);
        return jsonobject;
    }

}
