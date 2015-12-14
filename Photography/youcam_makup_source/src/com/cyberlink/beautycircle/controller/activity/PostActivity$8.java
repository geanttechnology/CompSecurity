// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity

class a
    implements Runnable
{

    final com.cyberlink.beautycircle.model.tus a;
    final PostActivity b;

    public void run()
    {
        TopBarFragment topbarfragment = b.b();
        if (topbarfragment == null)
        {
            e.e(new Object[] {
                "Topbar null"
            });
        } else
        if (a.voteNum != null)
        {
            topbarfragment.b(a.voteNum.toString());
            return;
        }
    }

    (PostActivity postactivity, com.cyberlink.beautycircle.model.tus tus)
    {
        b = postactivity;
        a = tus;
        super();
    }
}
