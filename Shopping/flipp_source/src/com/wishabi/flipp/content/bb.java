// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import org.json.JSONException;
import org.json.JSONObject;

public final class bb
{

    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    private int f;
    private String g;
    private int h;
    private double i;
    private double j;
    private String k;

    public bb()
    {
    }

    public static bb a(JSONObject jsonobject)
    {
        bb bb1;
        try
        {
            bb1 = new bb();
            bb1.f = jsonobject.getInt("id");
            bb1.g = a(jsonobject, "merchant_store_code");
            bb1.h = jsonobject.getInt("merchant_id");
            bb1.a = a(jsonobject, "address");
            bb1.b = a(jsonobject, "city");
            bb1.c = a(jsonobject, "province");
            bb1.d = a(jsonobject, "postal_code");
            bb1.e = a(jsonobject, "name");
            bb1.i = jsonobject.getDouble("lat");
            bb1.j = jsonobject.getDouble("lon");
            bb1.k = a(jsonobject, "source");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.toString();
            return null;
        }
        return bb1;
    }

    private static String a(JSONObject jsonobject, String s)
    {
        if (jsonobject.isNull(s))
        {
            return null;
        } else
        {
            return jsonobject.getString(s);
        }
    }
}
