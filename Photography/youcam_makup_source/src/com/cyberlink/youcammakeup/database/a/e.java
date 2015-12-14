// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.a;

import com.cyberlink.youcammakeup.utility.ad;
import org.json.JSONObject;

public class e
{

    private String a;
    private String b;
    private String c;
    private int d;

    public e(JSONObject jsonobject)
    {
        a = jsonobject.optString("adUnitID");
        b = jsonobject.optString("type");
        c = jsonobject.optString("group");
        d = ad.b(jsonobject, "order");
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return c;
    }

    public int c()
    {
        return d;
    }
}
