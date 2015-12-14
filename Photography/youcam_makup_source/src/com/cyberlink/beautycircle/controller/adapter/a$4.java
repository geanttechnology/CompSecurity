// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.UserInfo;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a

class a
    implements android.view..OnClickListener
{

    final UserInfo a;
    final a b;

    public void onClick(View view)
    {
        if (a.id != -1L)
        {
            c.a(b.c, a.id, com.cyberlink.beautycircle.model.bItem.MeListMode.a);
        }
    }

    ode(a a1, UserInfo userinfo)
    {
        b = a1;
        a = userinfo;
        super();
    }
}
