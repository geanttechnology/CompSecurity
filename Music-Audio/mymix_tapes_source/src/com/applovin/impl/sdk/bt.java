// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            bv, bu, bw, cx, 
//            AppLovinSdkImpl, p

abstract class bt extends bv
{

    protected bt(String s, AppLovinSdkImpl applovinsdkimpl)
    {
        super(s, applovinsdkimpl);
    }

    protected void a(String s, JSONObject jsonobject, p p)
    {
        s = new bu(this, (new StringBuilder()).append("Repeat").append(e).toString(), bw.h, f, s, jsonobject, p);
        s.a(bw.k);
        s.run();
    }
}
