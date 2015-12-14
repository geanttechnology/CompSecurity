// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bd;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SettingActivity

class a
    implements android.view.r
{

    final SettingActivity a;

    public void onClick(View view)
    {
        boolean flag = bd.a(a);
        if (flag)
        {
            z.a("HAS_RATE_THIS_APP", Boolean.valueOf(flag), a);
        }
    }

    (SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }
}
