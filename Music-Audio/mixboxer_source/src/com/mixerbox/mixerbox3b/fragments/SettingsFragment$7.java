// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.dialogs.SleepDialog;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment

class this._cls0
    implements android.view.r
{

    final SettingsFragment this$0;

    public void onClick(View view)
    {
        if (btnSleep.getText().toString().equals((new StringBuilder()).append(getActivity().getResources().getString(0x7f0800f0)).append(":  ").append(getActivity().getResources().getString(0x7f08007c)).toString()))
        {
            (new SleepDialog(getActivity())).show().getWindow().setSoftInputMode(16);
            return;
        } else
        {
            view = (AlarmManager)getActivity().getSystemService("alarm");
            Intent intent = new Intent("SleepService");
            view.cancel(PendingIntent.getBroadcast(getActivity(), 0, intent, 0));
            btnSleep.setText((new StringBuilder()).append(getActivity().getResources().getString(0x7f0800f0)).append(":  ").append(getActivity().getResources().getString(0x7f08007c)).toString());
            MixerBoxUtils.toastMsg(getActivity(), (new StringBuilder()).append(getActivity().getResources().getString(0x7f0800f0)).append(":  ").append(getActivity().getResources().getString(0x7f08007c)).toString(), 1);
            view = new HashMap();
            view.put("val", "off");
            FlurryAgent.logEvent("action:set_sleep_timer", view);
            return;
        }
    }

    ()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
