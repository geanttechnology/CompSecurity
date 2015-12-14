// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.ap;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AboutInfoActivity

class a
    implements android.view.
{

    final AboutInfoActivity a;

    public void onClick(View view)
    {
        view = AccountManager.c();
        if (AboutInfoActivity.a(a) != -1L && (view == null || AboutInfoActivity.a(a) != view.longValue()))
        {
            b.a(new ap("click_about_url", null, Long.toString(AboutInfoActivity.a(a))));
        }
        c.a(a, com.cyberlink.beautycircle.controller.activity.AboutInfoActivity.b(a), 2);
    }

    (AboutInfoActivity aboutinfoactivity)
    {
        a = aboutinfoactivity;
        super();
    }
}
