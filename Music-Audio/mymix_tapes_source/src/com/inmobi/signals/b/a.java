// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.b;

import com.inmobi.commons.core.utilities.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{

    private static final String a = com/inmobi/signals/b/a.getSimpleName();
    private long b;
    private String c;
    private int d;
    private int e;

    public a()
    {
    }

    public long a()
    {
        return b;
    }

    public void a(int i)
    {
        d = i;
    }

    public void a(long l)
    {
        b = l;
    }

    public void a(String s)
    {
        c = s;
    }

    public JSONObject b()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("bssid", b);
            jsonobject.put("essid", c);
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while converting WifiInfo to string.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public void b(int i)
    {
        e = i;
    }

}
