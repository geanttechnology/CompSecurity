// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.ap;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            q, p

class a
    implements android.view..OnClickListener
{

    final q a;

    public void onClick(View view)
    {
        view = AccountManager.c();
        if (p.a(a.b) != -1L && (view == null || p.a(a.b) != view.longValue()))
        {
            b.a(new ap("click_me_url", null, Long.toString(p.a(a.b))));
        }
        c.a(a.b.getActivity(), p.e(a.b).websiteUrl, 2);
    }

    (q q1)
    {
        a = q1;
        super();
    }
}
