// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import org.json.JSONObject;

public class u
{

    String a;
    String b;
    String c;
    String d;
    Integer e;
    String f;
    String g;
    String h;
    String i;

    public u(String s, String s1)
    {
        a = s;
        i = s1;
        s = new JSONObject(i);
        b = s.optString("productId");
        c = s.optString("type");
        d = s.optString("price");
        e = Integer.valueOf(s.optInt("price_amount_micros"));
        f = s.optString("price_currency_code");
        g = s.optString("title");
        h = s.optString("description");
    }

    public String a()
    {
        return b;
    }

    public String b()
    {
        return d;
    }

    public String toString()
    {
        return (new StringBuilder()).append("SkuDetails:").append(i).toString();
    }
}
