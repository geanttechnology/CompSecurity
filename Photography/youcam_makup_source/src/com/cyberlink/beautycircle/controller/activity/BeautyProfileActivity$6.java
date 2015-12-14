// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.EditText;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.c;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            BeautyProfileActivity

class a
    implements c
{

    final UserInfo a;
    final BeautyProfileActivity b;

    public void a()
    {
        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.e(b).setText(a.receiveEmail);
    }

    public void b()
    {
        e.e(new Object[] {
            "Query FB email fail."
        });
    }

    (BeautyProfileActivity beautyprofileactivity, UserInfo userinfo)
    {
        b = beautyprofileactivity;
        a = userinfo;
        super();
    }
}
