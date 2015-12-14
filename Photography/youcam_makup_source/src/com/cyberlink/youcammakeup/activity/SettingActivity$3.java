// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SettingActivity, WebViewerExActivity

class a
    implements android.view.er
{

    final SettingActivity a;

    public void onClick(View view)
    {
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
        view.putExtra("RedirectUrl", "http://www.perfectcorp.com/stat/faq/youcam-makeup/redirect.jsp");
        view.putExtra("Title", a.getString(0x7f070637));
        view.putExtra("TopBarStyle", 2);
        a.startActivity(view);
    }

    y(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }
}
