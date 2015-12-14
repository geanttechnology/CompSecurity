// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.l;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.utility.o;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            i

class a
    implements o
{

    final i a;

    public void a(CircleDetail circledetail, boolean flag)
    {
        Long long1;
        if (a.i != null)
        {
            if ((circledetail = (TextView)a.i.findViewById(j.circle_panel_follower)) != null && (long1 = i.b(a).followerCount) != null)
            {
                circledetail.setText((new StringBuilder()).append(long1).append(" ").append(circledetail.getResources().getQuantityString(l.bc_me_status_followers, long1.intValue())).toString());
                if (long1.longValue() > 0L)
                {
                    circledetail.setEnabled(true);
                    return;
                } else
                {
                    circledetail.setEnabled(false);
                    return;
                }
            }
        }
    }

    (i k)
    {
        a = k;
        super();
    }
}
