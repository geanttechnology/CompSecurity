// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.DialogUtils;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements android.view.r
{

    final ShareInActivity a;

    public void onClick(View view)
    {
        if (ShareInActivity.j(a))
        {
            if (ShareInActivity.q(a) == null || ShareInActivity.q(a).size() < 1)
            {
                DialogUtils.a(a, m.bc_share_in_pick_a_circle);
                return;
            } else
            {
                ShareInActivity.a(a, false);
                ShareInActivity.i(a);
                return;
            }
        } else
        {
            ShareInActivity.r(a);
            return;
        }
    }

    (ShareInActivity shareinactivity)
    {
        a = shareinactivity;
        super();
    }
}
