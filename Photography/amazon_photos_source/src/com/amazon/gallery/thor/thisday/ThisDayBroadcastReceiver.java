// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.service.ThisDayNotificationService;
import com.amazon.gallery.thor.app.service.ThisDayPrefetchService;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayAlarmManager

public class ThisDayBroadcastReceiver extends BroadcastReceiver
{

    private static final String TAG = com/amazon/gallery/thor/thisday/ThisDayBroadcastReceiver.getName();

    public ThisDayBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        byte byte0;
        while (intent.getAction() == null || !((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount()) 
        {
            return;
        }
        intent = intent.getAction();
        byte0 = -1;
        intent.hashCode();
        JVM INSTR lookupswitch 6: default 96
    //                   -1743310041: 167
    //                   -1567096722: 153
    //                   502473491: 195
    //                   505380757: 181
    //                   798292259: 209
    //                   1041332296: 223;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_223;
_L8:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            context.startService(new Intent(context, com/amazon/gallery/thor/app/service/ThisDayNotificationService));
            return;

        case 1: // '\001'
            context.startService(new Intent(context, com/amazon/gallery/thor/app/service/ThisDayPrefetchService));
            return;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            ((ThisDayAlarmManager)ThorGalleryApplication.getBean(Keys.THIS_DAY_ALARM_MANAGER)).setAlarm(ThisDayAlarmManager.AlarmType.NOTIFICATION_ALARM, true);
            break;
        }
        break MISSING_BLOCK_LABEL_269;
_L3:
        if (intent.equals("com.amazon.photos.action.ACTION_SHOW_THIS_DAY_NOTIFICATION"))
        {
            byte0 = 0;
        }
          goto _L8
_L2:
        if (intent.equals("com.amazon.photos.action.ACTION_PREFETCH_THIS_DAY_DATA"))
        {
            byte0 = 1;
        }
          goto _L8
_L5:
        if (intent.equals("android.intent.action.TIME_SET"))
        {
            byte0 = 2;
        }
          goto _L8
_L4:
        if (intent.equals("android.intent.action.TIMEZONE_CHANGED"))
        {
            byte0 = 3;
        }
          goto _L8
_L6:
        if (intent.equals("android.intent.action.BOOT_COMPLETED"))
        {
            byte0 = 4;
        }
          goto _L8
        if (intent.equals("android.intent.action.DATE_CHANGED"))
        {
            byte0 = 5;
        }
          goto _L8
        ((ThisDayAlarmManager)ThorGalleryApplication.getBean(Keys.THIS_DAY_ALARM_MANAGER)).setAlarm(ThisDayAlarmManager.AlarmType.PREFETCH_ALARM, true);
        return;
    }

}
