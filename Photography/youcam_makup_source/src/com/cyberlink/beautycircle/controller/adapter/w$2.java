// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.UserInfo;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            w

class a
    implements android.view..OnClickListener
{

    final w a;

    public void onClick(View view)
    {
        view = (UserInfo)view.getTag();
        if (view == null)
        {
            return;
        } else
        {
            c.a(a.a, ((UserInfo) (view)).id, com.cyberlink.beautycircle.model.bItem.MeListMode.a);
            return;
        }
    }

    ode(w w1)
    {
        a = w1;
        super();
    }
}
