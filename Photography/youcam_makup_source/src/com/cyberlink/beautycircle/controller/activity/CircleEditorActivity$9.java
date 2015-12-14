// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            CircleEditorActivity

class a extends m
{

    final CircleEditorActivity a;

    protected void a()
    {
        e.b(new Object[] {
            "createCircle cancelled."
        });
        a.l();
    }

    protected void a(int i)
    {
        e.e(new Object[] {
            "createCircle error:", Integer.valueOf(i)
        });
        a.l();
    }

    protected void a(com.cyberlink.beautycircle.model.network.cleResult cleresult)
    {
        if (cleresult != null)
        {
            e.b(new Object[] {
                "createCircle done: ", cleresult.circleId
            });
            Globals.b((new StringBuilder()).append("createCircle done: ").append(cleresult.circleId).toString());
            t.a.a();
            CircleEditorActivity.h(a);
        } else
        {
            e.b(new Object[] {
                "createCircle done: null"
            });
            Globals.b("createCircle done: null");
        }
        a.l();
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.cleResult)obj);
    }

    ult(CircleEditorActivity circleeditoractivity)
    {
        a = circleeditoractivity;
        super();
    }
}
