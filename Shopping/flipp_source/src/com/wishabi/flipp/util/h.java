// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
{

    public static Double a(JSONObject jsonobject, String s, Double double1)
    {
        while (jsonobject == null || TextUtils.isEmpty(s) || jsonobject.isNull(s)) 
        {
            return double1;
        }
        return Double.valueOf(jsonobject.getDouble(s));
    }

    public static Integer a(JSONObject jsonobject, String s, Integer integer)
    {
        while (jsonobject == null || TextUtils.isEmpty(s) || jsonobject.isNull(s)) 
        {
            return integer;
        }
        return Integer.valueOf(jsonobject.getInt(s));
    }

    public static String a(JSONObject jsonobject, String s)
    {
        while (jsonobject == null || TextUtils.isEmpty(s) || jsonobject.isNull(s)) 
        {
            return null;
        }
        return jsonobject.getString(s);
    }

    public static JSONArray b(JSONObject jsonobject, String s)
    {
        while (jsonobject == null || TextUtils.isEmpty(s) || jsonobject.isNull(s)) 
        {
            return null;
        }
        return jsonobject.getJSONArray(s);
    }
}
