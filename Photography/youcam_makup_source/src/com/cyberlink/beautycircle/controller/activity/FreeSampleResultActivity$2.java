// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.controller.a.aa;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleResultActivity

class a extends m
{

    final FreeSampleResultActivity a;

    protected void a(int i)
    {
        a.l();
    }

    protected void a(com.cyberlink.beautycircle.model.network.oResult oresult)
    {
        a.l();
        FreeSampleResultActivity.a(a, oresult.result);
        FreeSampleResultActivity.c(a);
        if (FreeSampleResultActivity.a(a) != null && FreeSampleResultActivity.d(a) != null)
        {
            com.perfectcorp.a.b.a(new aa(FreeSampleResultActivity.a(a).toString(), FreeSampleResultActivity.d(a).ceType));
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.oResult)obj);
    }

    t(FreeSampleResultActivity freesampleresultactivity)
    {
        a = freesampleresultactivity;
        super();
    }
}
