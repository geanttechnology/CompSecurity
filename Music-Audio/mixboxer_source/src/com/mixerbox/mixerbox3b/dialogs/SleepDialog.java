// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class SleepDialog extends android.app.AlertDialog.Builder
{

    private Context ctx;

    public SleepDialog(Context context)
    {
        super(context);
        ctx = context;
        getContent();
    }

    private void getContent()
    {
        final EditText etName = LayoutInflater.from(ctx).inflate(0x7f03002a, null);
        setView(etName);
        etName = (EditText)etName.findViewById(0x7f070062);
        etName.setSelection(2);
        setTitle(ctx.getResources().getString(0x7f0800f0));
        setPositiveButton(ctx.getResources().getString(0x7f08007e), new _cls1());
        setNegativeButton(ctx.getResources().getString(0x7f080063), new _cls2());
    }


    private class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final SleepDialog this$0;
        final EditText val$etName;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (etName.getText() == null || etName.getText().toString().length() == 0)
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800f4), 1);
                (new SleepDialog(ctx)).show();
                return;
            }
            if (etName.getText().toString().length() > 4)
            {
                etName.setText("1440");
            }
            int j = Integer.valueOf(etName.getText().toString()).intValue();
            if (j <= 0)
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800f4), 1);
                (new SleepDialog(ctx)).show();
                return;
            }
            i = j;
            if (j > 1440)
            {
                i = 1440;
            }
            dialoginterface = (AlarmManager)ctx.getSystemService("alarm");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(12, calendar.get(12) + i);
            Object obj = new Intent("SleepService");
            ((Intent) (obj)).putExtra("t", 0);
            obj = PendingIntent.getBroadcast(ctx, 0, ((Intent) (obj)), 0);
            dialoginterface.set(0, calendar.getTimeInMillis(), ((PendingIntent) (obj)));
            ((MainPage)ctx).fragmentSettings.btnSleep.setText((new StringBuilder()).append(ctx.getResources().getString(0x7f0800f0)).append(":  ").append(ctx.getResources().getString(0x7f08007d)).toString());
            MixerBoxUtils.toastMsg(ctx, (new StringBuilder()).append(ctx.getResources().getString(0x7f0800f1)).append(i).append(ctx.getResources().getString(0x7f0800f2)).toString(), 0);
            dialoginterface = new HashMap();
            dialoginterface.put("val", "on");
            FlurryAgent.logEvent("action:set_sleep_timer", dialoginterface);
        }

        _cls1()
        {
            this$0 = SleepDialog.this;
            etName = edittext;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final SleepDialog this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
        }

        _cls2()
        {
            this$0 = SleepDialog.this;
            super();
        }
    }

}
