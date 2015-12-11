// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.EditText;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.fragments.SettingsFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            SleepDialog

class val.etName
    implements android.content.e.OnClickListener
{

    final SleepDialog this$0;
    final EditText val$etName;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (val$etName.getText() == null || val$etName.getText().toString().length() == 0)
        {
            MixerBoxUtils.toastMsg(SleepDialog.access$000(SleepDialog.this), SleepDialog.access$000(SleepDialog.this).getResources().getString(0x7f0800f4), 1);
            (new SleepDialog(SleepDialog.access$000(SleepDialog.this))).show();
            return;
        }
        if (val$etName.getText().toString().length() > 4)
        {
            val$etName.setText("1440");
        }
        int j = Integer.valueOf(val$etName.getText().toString()).intValue();
        if (j <= 0)
        {
            MixerBoxUtils.toastMsg(SleepDialog.access$000(SleepDialog.this), SleepDialog.access$000(SleepDialog.this).getResources().getString(0x7f0800f4), 1);
            (new SleepDialog(SleepDialog.access$000(SleepDialog.this))).show();
            return;
        }
        i = j;
        if (j > 1440)
        {
            i = 1440;
        }
        dialoginterface = (AlarmManager)SleepDialog.access$000(SleepDialog.this).getSystemService("alarm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(12, calendar.get(12) + i);
        Object obj = new Intent("SleepService");
        ((Intent) (obj)).putExtra("t", 0);
        obj = PendingIntent.getBroadcast(SleepDialog.access$000(SleepDialog.this), 0, ((Intent) (obj)), 0);
        dialoginterface.set(0, calendar.getTimeInMillis(), ((PendingIntent) (obj)));
        ((MainPage)SleepDialog.access$000(SleepDialog.this)).fragmentSettings.btnSleep.setText((new StringBuilder()).append(SleepDialog.access$000(SleepDialog.this).getResources().getString(0x7f0800f0)).append(":  ").append(SleepDialog.access$000(SleepDialog.this).getResources().getString(0x7f08007d)).toString());
        MixerBoxUtils.toastMsg(SleepDialog.access$000(SleepDialog.this), (new StringBuilder()).append(SleepDialog.access$000(SleepDialog.this).getResources().getString(0x7f0800f1)).append(i).append(SleepDialog.access$000(SleepDialog.this).getResources().getString(0x7f0800f2)).toString(), 0);
        dialoginterface = new HashMap();
        dialoginterface.put("val", "on");
        FlurryAgent.logEvent("action:set_sleep_timer", dialoginterface);
    }

    ment()
    {
        this$0 = final_sleepdialog;
        val$etName = EditText.this;
        super();
    }
}
