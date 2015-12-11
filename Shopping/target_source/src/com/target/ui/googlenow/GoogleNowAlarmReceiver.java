// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.googlenow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.target.ui.service.GoogleNowService;

// Referenced classes of package com.target.ui.googlenow:
//            b

public class GoogleNowAlarmReceiver extends BroadcastReceiver
{

    private static final String ALARM = "ALARM";
    private static final String ALARM_KEY = "ALARM_KEY";

    public GoogleNowAlarmReceiver()
    {
    }

    private void a(Context context)
    {
        context.startService((new Intent(context, com/target/ui/service/GoogleNowService)).putExtra("ALARM_KEY", "ALARM"));
    }

    public void onReceive(Context context, Intent intent)
    {
        b.b(context, Boolean.valueOf(false));
        a(context);
    }
}
