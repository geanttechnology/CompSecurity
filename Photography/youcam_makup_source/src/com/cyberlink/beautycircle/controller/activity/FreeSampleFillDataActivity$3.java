// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.c;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleFillDataActivity

class b
    implements c
{

    final boolean a;
    final UserInfo b;
    final FreeSampleFillDataActivity c;

    public void a()
    {
        FreeSampleFillDataActivity.a(c, a, b);
    }

    public void b()
    {
        e.e(new Object[] {
            "Query FB email fail. Continue initViewData()"
        });
        FreeSampleFillDataActivity.a(c, a, b);
    }

    Q(FreeSampleFillDataActivity freesamplefilldataactivity, boolean flag, UserInfo userinfo)
    {
        c = freesamplefilldataactivity;
        a = flag;
        b = userinfo;
        super();
    }
}
