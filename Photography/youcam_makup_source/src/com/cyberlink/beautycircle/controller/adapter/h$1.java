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
//            h

class a extends j
{

    final h a;

    public d a(d d1)
    {
        return d1;
    }

    public volatile Object a(Object obj)
    {
        return a((d)obj);
    }

    public void a(int i)
    {
        super.a(i);
        if (a.c != null && (a.c instanceof MainActivity))
        {
            ((BaseActivity)a.c).a(a.c.getString(m.bc_server_connect_fail), 3000);
        }
    }

    nActivity(h h1)
    {
        a = h1;
        super();
    }
}
