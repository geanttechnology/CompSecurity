// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            cx, q, o, cd, 
//            by, AppLovinSdkImpl, p

class ce extends cx
{

    final JSONObject a;
    final cd b;

    ce(cd cd1, String s, by by, AppLovinSdkImpl applovinsdkimpl, JSONObject jsonobject)
    {
        b = cd1;
        a = jsonobject;
        super(s, by, applovinsdkimpl);
    }

    public void a(int i)
    {
        q.a(i, f);
    }

    protected void a(o o1, p p)
    {
        o1.a(q.a("device", f), a, p);
    }

    public void a(JSONObject jsonobject, int i)
    {
        b.a(jsonobject);
    }
}
