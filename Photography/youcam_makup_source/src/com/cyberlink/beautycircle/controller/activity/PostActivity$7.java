// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.m;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity

class a
    implements Runnable
{

    final boolean a;
    final PostActivity b;

    public void run()
    {
        TopBarFragment topbarfragment = b.b();
        if (topbarfragment == null)
        {
            e.e(new Object[] {
                "Topbar null"
            });
            return;
        }
        if (a)
        {
            topbarfragment.e(true);
            topbarfragment.g(false);
            topbarfragment.c(m.bc_top_bar_voted_btn);
            return;
        } else
        {
            topbarfragment.e(false);
            topbarfragment.g(true);
            topbarfragment.c(m.bc_top_bar_vote_btn);
            return;
        }
    }

    (PostActivity postactivity, boolean flag)
    {
        b = postactivity;
        a = flag;
        super();
    }
}
