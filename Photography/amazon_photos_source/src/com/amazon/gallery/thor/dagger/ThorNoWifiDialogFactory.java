// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.dagger;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import com.amazon.gallery.framework.kindle.amazon.NoWifiDialogFactory;

public class ThorNoWifiDialogFactory
    implements NoWifiDialogFactory
{

    public ThorNoWifiDialogFactory()
    {
    }

    private boolean isAirplaneModeOn(Context context)
    {
        boolean flag = false;
        if (android.provider.Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0)
        {
            flag = true;
        }
        return flag;
    }

    public AlertDialog createDialog(final Context context)
    {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        if (isAirplaneModeOn(context))
        {
            builder.setTitle(0x7f0e00f4).setMessage(0x7f0e00f3);
        } else
        {
            builder.setTitle(0x7f0e00f6).setMessage(0x7f0e00f5);
        }
        builder.setNegativeButton(0x7f0e0305, new android.content.DialogInterface.OnClickListener() {

            final ThorNoWifiDialogFactory this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = ThorNoWifiDialogFactory.this;
                super();
            }
        }).setPositiveButton(0x7f0e01a3, new android.content.DialogInterface.OnClickListener() {

            final ThorNoWifiDialogFactory this$0;
            final Context val$context;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialoginterface.dismiss();
            }

            
            {
                this$0 = ThorNoWifiDialogFactory.this;
                context = context1;
                super();
            }
        });
        return builder.create();
    }
}
