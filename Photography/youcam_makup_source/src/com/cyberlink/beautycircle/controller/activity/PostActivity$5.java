// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity, g

class b extends m
{

    final Long a;
    final g b;
    final PostActivity c;

    protected void a(int i)
    {
        e.d(new Object[] {
            "Vote Fail: ", a, ", code=", Integer.valueOf(i)
        });
        if (i != 0x80000001)
        {
            Globals.b((new StringBuilder()).append("Vote Fail: code=").append(i).toString());
        }
        PostActivity.a(c, g.g(b), -1);
        if (i != 0x80000001)
        {
            PostActivity.a(c, false);
        }
        super.a(i);
    }

    protected void a(com.cyberlink.beautycircle.model.network.ContestResult contestresult)
    {
        e.c(new Object[] {
            "Vote: ", a, ", response=", contestresult.result
        });
        if (contestresult.result == null)
        {
            a(0x80000001);
            return;
        }
        if ("OK".equals(contestresult.result.status))
        {
            Globals.b("Vote Succeed.");
            return;
        }
        if ("Repeat".equals(contestresult.result.status))
        {
            Globals.b("Vote Repeated.");
            a(0x80000001);
            return;
        } else
        {
            a(0x80000001);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.ContestResult)obj);
    }

    tResult(PostActivity postactivity, Long long1, g g1)
    {
        c = postactivity;
        a = long1;
        b = g1;
        super();
    }
}
