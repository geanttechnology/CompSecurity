// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.activityrecognition;

import com.inmobi.commons.core.utilities.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{

    private static final String a = com/inmobi/signals/activityrecognition/a.getSimpleName();
    private int b;
    private long c;

    public a(int i, long l)
    {
        b = i;
        c = l;
    }

    public JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("a", b);
            jsonobject.put("ts", c);
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while converting WifiInfo to string.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

}
