// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import org.json.JSONException;
import org.json.JSONObject;

class ap
{

    String a;
    float b;

    ap()
    {
        b = 14F;
    }

    static JSONObject a(String s, float f, String s1, String s2)
    {
        return a(s, String.valueOf(f));
    }

    static JSONObject a(String s, String s1)
    {
        JSONObject jsonobject = new JSONObject();
        if (s == null)
        {
            s = "";
        }
        try
        {
            jsonobject.put("palette_guid", s);
            jsonobject.put("version", s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return jsonobject;
        }
        return jsonobject;
    }
}
