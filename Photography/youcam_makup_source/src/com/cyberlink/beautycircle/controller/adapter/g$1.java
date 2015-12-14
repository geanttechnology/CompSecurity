// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            g

class a extends j
{

    final g a;

    public d a(d d1)
    {
        if (a.h() && d1 != null && d1.b != null && d1.b.size() > 0)
        {
            BCTileImage.a(d1.b);
        }
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

    nActivity(g g1)
    {
        a = g1;
        super();
    }
}
