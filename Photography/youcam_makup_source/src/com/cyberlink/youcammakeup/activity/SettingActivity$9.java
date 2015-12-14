// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SettingActivity

class a
    implements w
{

    final String a;
    final SettingActivity b;

    public void a(boolean flag)
    {
        Globals.d().i().i(b);
        SettingActivity.b(b, a);
    }

    public void b(boolean flag)
    {
        Globals.d().i().i(b);
    }

    (SettingActivity settingactivity, String s)
    {
        b = settingactivity;
        a = s;
        super();
    }
}
