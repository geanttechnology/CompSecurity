// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.z;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SettingActivity

class q
    implements android.view.View.OnClickListener
{

    final SettingActivity a;
    private String b;

    public q(SettingActivity settingactivity, String s)
    {
        a = settingactivity;
        super();
        b = null;
        b = s;
    }

    public final void onClick(View view)
    {
        boolean flag;
        if (!view.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setSelected(flag);
        if (b != null)
        {
            z.a(b, Boolean.valueOf(flag), Globals.d());
        }
    }
}
