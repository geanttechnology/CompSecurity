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
//            k

class a extends j
{

    final k a;

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
        if (com.cyberlink.beautycircle.controller.adapter.k.d(a) != null && (com.cyberlink.beautycircle.controller.adapter.k.d(a) instanceof MainActivity))
        {
            ((BaseActivity)com.cyberlink.beautycircle.controller.adapter.k.d(a)).a(com.cyberlink.beautycircle.controller.adapter.k.d(a).getString(m.bc_server_connect_fail), 3000);
        }
    }

    Activity(k k1)
    {
        a = k1;
        super();
    }
}
