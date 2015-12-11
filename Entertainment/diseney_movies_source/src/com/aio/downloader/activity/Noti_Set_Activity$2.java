// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.CompoundButton;

// Referenced classes of package com.aio.downloader.activity:
//            Noti_Set_Activity

class this._cls0
    implements android.widget.ckedChangeListener
{

    final Noti_Set_Activity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            Noti_Set_Activity.access$1(Noti_Set_Activity.this).edit().putInt("b_low", 0).commit();
            compoundbutton = new Intent("toggle_on");
            sendBroadcast(compoundbutton);
            return;
        } else
        {
            Noti_Set_Activity.access$1(Noti_Set_Activity.this).edit().putInt("b_low", 1).commit();
            compoundbutton = new Intent("toggle_off");
            sendBroadcast(compoundbutton);
            return;
        }
    }

    tener()
    {
        this$0 = Noti_Set_Activity.this;
        super();
    }
}
