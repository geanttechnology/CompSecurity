// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleActivity

class a extends m
{

    final FreeSampleActivity a;

    protected void a(com.cyberlink.beautycircle.model.network.ntInfoResult ntinforesult)
    {
        a.l();
        if (ntinforesult == null || ntinforesult.result == null)
        {
            FreeSampleActivity.a(a, false);
            return;
        } else
        {
            FreeSampleActivity.a(a, ntinforesult.result);
            FreeSampleActivity.a(a, FreeSampleActivity.a(a).applyType);
            a.finish();
            return;
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.ntInfoResult)obj);
    }

    Result(FreeSampleActivity freesampleactivity)
    {
        a = freesampleactivity;
        super();
    }
}
