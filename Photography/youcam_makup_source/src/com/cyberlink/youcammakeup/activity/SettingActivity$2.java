// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SettingActivity, AboutActivity

class a
    implements android.view.er
{

    final SettingActivity a;

    public void onClick(View view)
    {
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/AboutActivity);
        a.startActivity(view);
    }

    (SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }
}
