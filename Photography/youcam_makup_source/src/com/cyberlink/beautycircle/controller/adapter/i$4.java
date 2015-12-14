// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.UserInfo;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            i

class a
    implements android.view..OnClickListener
{

    final UserInfo a;
    final i b;

    public void onClick(View view)
    {
        c.a(i.a(b), a.id, com.cyberlink.beautycircle.model.bItem.MeListMode.a);
    }

    ode(i j, UserInfo userinfo)
    {
        b = j;
        a = userinfo;
        super();
    }
}
