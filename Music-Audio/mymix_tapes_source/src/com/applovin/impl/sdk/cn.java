// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            cx, cm, bw, AppLovinSdkImpl, 
//            o, by, p

class cn extends cx
{

    final cm a;

    cn(cm cm1, String s, by by, AppLovinSdkImpl applovinsdkimpl)
    {
        a = cm1;
        super(s, by, applovinsdkimpl);
    }

    public void a(int i)
    {
        cm.a(a, i);
    }

    protected void a(o o1, p p)
    {
        o1.a(a.c(), ((Integer)f.a(bw.u)).intValue(), p);
    }

    public void a(JSONObject jsonobject, int i)
    {
        if (i == 200)
        {
            cm.a(a, jsonobject);
            return;
        } else
        {
            cm.a(a, i);
            return;
        }
    }
}
