// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            cx, ck, bw, AppLovinSdkImpl, 
//            o, p

class cl extends cx
{

    final ck a;

    cl(ck ck1, String s, int i, AppLovinSdkImpl applovinsdkimpl)
    {
        a = ck1;
        super(s, i, applovinsdkimpl);
    }

    public void a(int i)
    {
        ck.d(a).onPostbackFailure(ck.c(a), i);
    }

    protected void a(o o1, p p)
    {
        int i;
        if (ck.a(a) < 0)
        {
            i = ((Integer)f.a(bw.aF)).intValue();
        } else
        {
            i = ck.a(a);
        }
        if (ck.b(a) == null)
        {
            o1.a(ck.c(a), i, false, p);
            return;
        } else
        {
            o1.a(ck.c(a), i, new JSONObject(ck.b(a)), false, p);
            return;
        }
    }

    public void a(JSONObject jsonobject, int i)
    {
        ck.d(a).onPostbackSuccess(ck.c(a));
    }
}
