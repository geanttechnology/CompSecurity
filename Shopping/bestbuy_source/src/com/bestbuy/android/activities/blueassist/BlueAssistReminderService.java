// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistReminderActivity

public class BlueAssistReminderService extends IntentService
{

    public BlueAssistReminderService()
    {
        super("BlueAssistReminerService");
    }

    protected void onHandleIntent(Intent intent)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable(intent) {

            final Intent a;
            final BlueAssistReminderService b;

            public void run()
            {
                Intent intent1 = new Intent(b.getApplicationContext(), com/bestbuy/android/activities/blueassist/BlueAssistReminderActivity);
                intent1.putExtras(a.getExtras());
                intent1.addFlags(0x10000000);
                b.startActivity(intent1);
            }

            
            {
                b = BlueAssistReminderService.this;
                a = intent;
                super();
            }
        });
    }
}
