// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.youcammakeup.Globals;
import java.util.Collections;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SettingActivity

class a
    implements android.view.r
{

    final SettingActivity a;

    public void onClick(View view)
    {
        view = Globals.O();
        view.attachmentPath = Collections.emptyList();
        c.a(a, view, 2);
    }

    k.FeedbackConfig(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }
}
