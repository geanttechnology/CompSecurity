// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import com.google.ads.util.b;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.ads.internal:
//            j

public static class a
{

    private final String a;

    public JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("debugHeader", a);
        }
        catch (JSONException jsonexception)
        {
            b.b("Could not build ReportAdJson from inputs.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public (String s)
    {
        a = s;
    }
}
