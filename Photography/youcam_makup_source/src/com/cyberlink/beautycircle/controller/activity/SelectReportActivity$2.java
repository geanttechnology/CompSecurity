// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SelectReportActivity

class a extends m
{

    final SelectReportActivity a;

    public void a(int i)
    {
        Globals.b((new StringBuilder()).append("Fetching UserInfo error: ").append(i).toString());
    }

    public void a(Void void1)
    {
        Globals.b("Success");
    }

    public void b(Object obj)
    {
        a((Void)obj);
    }

    (SelectReportActivity selectreportactivity)
    {
        a = selectreportactivity;
        super();
    }
}
