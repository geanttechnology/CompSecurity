// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import org.json.JSONException;
import org.json.JSONObject;

class JSONUtils
{

    public static JSONObject getJSONObjectFromString(String s)
    {
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static String getStringFromJSON$3d0ad843(JSONObject jsonobject, String s)
    {
        if (jsonobject.isNull(s))
        {
            return null;
        } else
        {
            return jsonobject.optString(s, null);
        }
    }

    public static void put(JSONObject jsonobject, String s, String s1)
    {
        if (s1 == null || s1.equals(""))
        {
            break MISSING_BLOCK_LABEL_20;
        }
        jsonobject.put(s, s1);
        return;
        jsonobject;
    }
}
