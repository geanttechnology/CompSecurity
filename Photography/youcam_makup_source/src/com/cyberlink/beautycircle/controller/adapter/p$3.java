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
//            p

class a extends j
{

    final p a;

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
        if (p.a(a) != null && (p.a(a) instanceof MainActivity) && i != 0)
        {
            ((BaseActivity)p.a(a)).a(p.a(a).getString(m.bc_server_connect_fail), 3000);
        }
    }

    nActivity(p p1)
    {
        a = p1;
        super();
    }
}
