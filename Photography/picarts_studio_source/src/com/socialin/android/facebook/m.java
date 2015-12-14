// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import org.json.JSONException;
import org.json.JSONObject;

public final class m
{

    public String a;
    private String b;
    private int c;

    public m(JSONObject jsonobject)
    {
        c = 0;
        if (jsonobject == null)
        {
            return;
        }
        JSONObject jsonobject1 = jsonobject.optJSONObject("cover");
        if (jsonobject1 != null)
        {
            b = jsonobject1.optString("id");
            a = jsonobject1.optString("source");
            c = jsonobject1.optInt("offset_y");
        }
        jsonobject.optInt("id");
    }

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", b);
            jsonobject.put("source", a);
            jsonobject.put("offset_y", c);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }
}
