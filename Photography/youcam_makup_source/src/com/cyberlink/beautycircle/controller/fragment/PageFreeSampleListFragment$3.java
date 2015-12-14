// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.k;
import com.cyberlink.beautycircle.controller.adapter.b;
import com.cyberlink.beautycircle.controller.adapter.f;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.perfectcorp.model.Model;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            h, PageFreeSampleListFragment

class b extends h
{

    final PageFreeSampleListFragment b;

    public void a()
    {
        super.a();
        if (b.h != null && b.h.getCount() == 1)
        {
            Long long1 = ((Model)b.h.getItem(0)).b_();
            android.support.v4.app.FragmentActivity fragmentactivity = b.getActivity();
            if (long1 != null && fragmentactivity != null)
            {
                if (b.h instanceof b)
                {
                    c.a(fragmentactivity, long1, null, null);
                    fragmentactivity.finish();
                } else
                if (b.h instanceof f)
                {
                    com.perfectcorp.a.b.a(new k("click", Long.toString(long1.longValue())));
                    c.a(fragmentactivity, long1, "contest", false);
                    fragmentactivity.finish();
                    return;
                }
            }
        }
    }

    Q(PageFreeSampleListFragment pagefreesamplelistfragment)
    {
        b = pagefreesamplelistfragment;
        super(pagefreesamplelistfragment);
    }
}
