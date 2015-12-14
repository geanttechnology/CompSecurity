// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.core.configs:
//            a

public class f extends a
{

    private String a;
    private String b;
    private String c;
    private String d;

    public f()
    {
        a = "010001";
        b = "E72409364B865B757E1D6B8DB73011BBB1D20C1A9F931ADD3C4C09E2794CE102F8AA7F2D50EB88F9880A576E6C7B0E95712CAE9416F7BACB798564627846E93B";
        c = "rsa";
        d = "1";
    }

    public String a()
    {
        return "pk";
    }

    public void a(JSONObject jsonobject)
        throws JSONException
    {
        super.a(jsonobject);
        a = jsonobject.getString("e");
        b = jsonobject.getString("m");
        c = jsonobject.getString("alg");
        d = jsonobject.getString("ver");
    }

    public JSONObject b()
        throws JSONException
    {
        JSONObject jsonobject = super.b();
        jsonobject.put("e", a);
        jsonobject.put("m", b);
        jsonobject.put("alg", c);
        jsonobject.put("ver", d);
        return jsonobject;
    }

    public boolean c()
    {
        return a.trim().length() != 0 && b.trim().length() != 0 && c.trim().length() != 0 && d.trim().length() != 0;
    }

    public a d()
    {
        return new f();
    }

    public String e()
    {
        return a;
    }

    public String f()
    {
        return b;
    }

    public String g()
    {
        return d;
    }
}
