// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

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
            Noti_Set_Activity.access$7(Noti_Set_Activity.this).edit().putInt("c_cpu", 0).commit();
            return;
        } else
        {
            Noti_Set_Activity.access$7(Noti_Set_Activity.this).edit().putInt("c_cpu", 1).commit();
            return;
        }
    }

    tener()
    {
        this$0 = Noti_Set_Activity.this;
        super();
    }
}
