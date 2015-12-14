// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.utilities.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class m
{

    private static final String g = com/inmobi/rendering/mraid/m.getSimpleName();
    String a;
    int b;
    int c;
    int d;
    int e;
    boolean f;

    public m()
    {
        d = 0;
        e = 0;
        a = "top-right";
        f = true;
    }

    public static m a(String s, m m1)
    {
        m m2 = new m();
        try
        {
            s = new JSONObject(s);
            m2.b = s.getInt("width");
            m2.c = s.getInt("height");
            m2.d = s.getInt("offsetX");
            m2.e = s.getInt("offsetY");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, g, "Invalid resize properties string passed.", s);
            return null;
        }
        if (m1 == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        m2.a = s.optString("customClosePosition", m1.a);
        m2.f = s.optBoolean("allowOffscreen", m1.f);
        return m2;
    }

    public String a()
    {
        Object obj;
        try
        {
            obj = new JSONObject();
            ((JSONObject) (obj)).put("width", b);
            ((JSONObject) (obj)).put("height", c);
            ((JSONObject) (obj)).put("customClosePosition", a);
            ((JSONObject) (obj)).put("offsetX", d);
            ((JSONObject) (obj)).put("offsetY", e);
            ((JSONObject) (obj)).put("allowOffscreen", f);
            obj = ((JSONObject) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, g, "Invalid resize properties string passed.", jsonexception);
            return "";
        }
        return ((String) (obj));
    }

}
