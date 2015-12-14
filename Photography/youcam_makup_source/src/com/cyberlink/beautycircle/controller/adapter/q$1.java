// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            q

class a extends j
{

    final q a;

    protected d a(d d1)
    {
        return d1;
    }

    protected volatile Object a(Object obj)
    {
        return a((d)obj);
    }

    protected void a(int i)
    {
        super.a(i);
        if (q.a(a) != null && (q.a(a) instanceof MainActivity) && i != 0)
        {
            ((BaseActivity)q.a(a)).a(q.a(a).getString(m.bc_server_connect_fail), 3000);
        }
    }

    nActivity(q q1)
    {
        a = q1;
        super();
    }
}
