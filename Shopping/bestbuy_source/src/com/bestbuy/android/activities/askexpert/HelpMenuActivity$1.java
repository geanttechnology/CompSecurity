// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.askexpert;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import com.inc247.ChatSDK;

// Referenced classes of package com.bestbuy.android.activities.askexpert:
//            HelpMenuActivity

class a
    implements android.view.r
{

    final HelpMenuActivity a;

    public void onClick(View view)
    {
        HelpMenuActivity.a(a, true);
        if (ChatRunningStatus.getChatRunning())
        {
            HelpMenuActivity.c().maximizeChat();
            a.stopService(new Intent(a.getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService));
            return;
        }
        if (HelpMenuActivity.a(a))
        {
            HelpMenuActivity.b(a).setVisibility(0);
            HelpMenuActivity.a(a, "bestbuy-App-Sales");
            return;
        } else
        {
            HelpMenuActivity.a(a, false);
            view = new android.app.(a);
            view.setCancelable(true);
            view.setMessage(a.getString(0x7f080210));
            view.setNeutralButton(0x7f080283, new android.content.DialogInterface.OnClickListener() {

                final HelpMenuActivity._cls1 a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                a = HelpMenuActivity._cls1.this;
                super();
            }
            });
            view.create().show();
            return;
        }
    }

    _cls1.a(HelpMenuActivity helpmenuactivity)
    {
        a = helpmenuactivity;
        super();
    }
}
