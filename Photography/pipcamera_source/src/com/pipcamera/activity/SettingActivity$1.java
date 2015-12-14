// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.pipcamera.activity:
//            SettingActivity

public class a
    implements android.widget.ClickListener
{

    final SettingActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i == 0)
        {
            adapterview = new Intent("android.intent.action.VIEW");
            adapterview.setData(Uri.parse("market://details?id=com.pipcamera.activity"));
            adapterview = Intent.createChooser(adapterview, null);
            a.startActivity(adapterview);
            SettingActivity.a(a, 0);
        } else
        if (i == 1)
        {
            adapterview = new Intent("android.intent.action.VIEW");
            adapterview.setData(Uri.parse("https://m.facebook.com/ads/ad_choices"));
            adapterview = Intent.createChooser(adapterview, null);
            a.startActivity(adapterview);
            return;
        }
    }

    tener(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }
}
