// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

// Referenced classes of package com.pipcamera.activity:
//            SettingActivity

class a
    implements android.widget.ClickListener
{

    final SettingActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        a.OnRequsetBtnClicked(view);
        SettingActivity.a(a).notifyDataSetChanged();
    }

    tener(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }
}
