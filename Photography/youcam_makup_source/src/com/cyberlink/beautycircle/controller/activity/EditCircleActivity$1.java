// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditCircleActivity

class a extends m
{

    final EditCircleActivity a;

    protected void a()
    {
        e.b(new Object[] {
            "updateCircle cancelled."
        });
        a.l();
    }

    protected void a(int i)
    {
        e.e(new Object[] {
            "updateCircle error:", Integer.valueOf(i)
        });
        Globals.a(a.getResources().getString(com.cyberlink.beautycircle.m.bc_server_connect_fail));
        a.l();
    }

    protected void a(com.cyberlink.beautycircle.model.network.ircleResult ircleresult)
    {
        if (ircleresult != null)
        {
            e.b(new Object[] {
                "updateCircle done: ", ircleresult.circleId
            });
            Globals.b((new StringBuilder()).append("updateCircle done: ").append(ircleresult.circleId).toString());
            t.a.a();
            ircleresult = new Intent();
            ircleresult.putExtra("CircleDetail", EditCircleActivity.a(a).toString());
            a.setResult(-1, ircleresult);
            a.o();
        } else
        {
            e.b(new Object[] {
                "updateCircle done: null"
            });
            Globals.b("updateCircle done: null");
        }
        a.l();
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.ircleResult)obj);
    }

    esult(EditCircleActivity editcircleactivity)
    {
        a = editcircleactivity;
        super();
    }
}
