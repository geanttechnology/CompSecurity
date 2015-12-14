// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SettingActivity, NoticeActivity

class a
    implements android.view.r
{

    final SettingActivity a;

    public void onClick(View view)
    {
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/NoticeActivity);
        view.putExtra("previousActivity", "launcher");
        view.putExtra(a.getResources().getString(0x7f070729), com/cyberlink/youcammakeup/activity/SettingActivity);
        a.startActivity(view);
    }

    (SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }
}
