// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.content.Intent;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistReminderService, BlueAssistReminderActivity

class a
    implements Runnable
{

    final Intent a;
    final BlueAssistReminderService b;

    public void run()
    {
        Intent intent = new Intent(b.getApplicationContext(), com/bestbuy/android/activities/blueassist/BlueAssistReminderActivity);
        intent.putExtras(a.getExtras());
        intent.addFlags(0x10000000);
        b.startActivity(intent);
    }

    (BlueAssistReminderService blueassistreminderservice, Intent intent)
    {
        b = blueassistreminderservice;
        a = intent;
        super();
    }
}
