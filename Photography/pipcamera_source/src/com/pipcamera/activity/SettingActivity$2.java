// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

// Referenced classes of package com.pipcamera.activity:
//            SettingActivity

class a
    implements android.widget.ClickListener
{

    final SettingActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (TextView)view.findViewById(0x7f0c034e);
        view = adapterview.getText().toString();
        if (i == 0)
        {
            SettingActivity.a(a, adapterview, view);
        } else
        if (i != 1 && i != 2 && i == 3)
        {
            SettingActivity.b(a, adapterview, view);
            return;
        }
    }

    tener(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }
}
