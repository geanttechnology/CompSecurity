// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.cyberlink.youcammakeup.utility.al;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SettingActivity

class a
    implements android.view.er
{

    final SettingActivity a;

    public void onClick(View view)
    {
        String s = a.getString(0x7f07063a);
        if (al.a("com.facebook.katana"))
        {
            if (al.b("com.facebook.katana") >= 0x2dd1e2)
            {
                view = (new StringBuilder()).append("fb://facewebmodal/f?href=").append(s).toString();
            } else
            {
                view = (new StringBuilder()).append("fb://profile/").append(a.getString(0x7f070639)).toString();
            }
            view = new Intent("android.intent.action.VIEW", Uri.parse(view));
        } else
        {
            view = new Intent("android.intent.action.VIEW", Uri.parse(s));
        }
        try
        {
            a.startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            m.b("SettingActivity", "start activity with exception: ", view);
        }
        view = new Intent("android.intent.action.VIEW", Uri.parse(s));
        a.startActivity(view);
    }

    (SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }
}
