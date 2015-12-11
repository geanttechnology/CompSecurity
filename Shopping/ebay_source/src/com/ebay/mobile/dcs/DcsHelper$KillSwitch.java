// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import com.ebay.mobile.ServiceStarter;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.shell.app.ActivityShim;

// Referenced classes of package com.ebay.mobile.dcs:
//            DcsHelper, DcsBoolean

public static final class _cls3.val.activity extends ActivityShim
{

    protected void onStart()
    {
        final Activity activity = getActivity();
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (deviceconfiguration.get(DcsBoolean.KillSwitch) || !deviceconfiguration.get(DcsBoolean.Polling))
        {
            ServiceStarter.startPollService(activity, "com.ebay.mobile.service.DISABLE_POLLING");
        }
        if (deviceconfiguration.get(DcsBoolean.KillSwitch))
        {
            android.support.v7.app.tion tion = new android.support.v7.app.init>(activity);
            tion.etMessage(activity.getString(0x7f07014a)).etCancelable(false).etPositiveButton(activity.getString(0x7f070b94), new android.content.DialogInterface.OnClickListener() {

                final DcsHelper.KillSwitch this$0;
                final Activity val$activity;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent("android.intent.action.VIEW");
                    dialoginterface.setData(Uri.parse("market://details?id=com.ebay.mobile"));
                    dialoginterface.addFlags(0x10800000);
                    activity.startActivity(dialoginterface);
                    activity.finish();
                }

            
            {
                this$0 = DcsHelper.KillSwitch.this;
                activity = activity1;
                super();
            }
            }).etNegativeButton(activity.getString(0x7f0701cc), new android.content.DialogInterface.OnClickListener() {

                final DcsHelper.KillSwitch this$0;
                final Activity val$activity;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    activity.finish();
                }

            
            {
                this$0 = DcsHelper.KillSwitch.this;
                activity = activity1;
                super();
            }
            }).etOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

                final DcsHelper.KillSwitch this$0;

                public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
                {
                    return i == 84 && keyevent.getRepeatCount() == 0;
                }

            
            {
                this$0 = DcsHelper.KillSwitch.this;
                super();
            }
            });
            tion.reate().show();
        }
    }

    public _cls3.val.activity()
    {
    }
}
