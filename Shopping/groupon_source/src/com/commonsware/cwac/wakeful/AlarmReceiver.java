// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.commonsware.cwac.wakeful;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.commonsware.cwac.wakeful:
//            WakefulIntentService

public class AlarmReceiver extends BroadcastReceiver
{

    public AlarmReceiver()
    {
    }

    private WakefulIntentService.AlarmListener getListener(Context context)
    {
        PackageManager packagemanager;
        packagemanager = context.getPackageManager();
        context = new ComponentName(context, getClass());
        context = packagemanager.getReceiverInfo(context, 128).loadXmlMetaData(packagemanager, "com.commonsware.cwac.wakeful");
        do
        {
            if (context.getEventType() == 1)
            {
                return null;
            }
            try
            {
                if (context.getEventType() == 2 && context.getName().equals("WakefulIntentService"))
                {
                    return (WakefulIntentService.AlarmListener)Class.forName(context.getAttributeValue(null, "listener")).newInstance();
                }
                context.next();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException("Cannot find own info???", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException("Malformed metadata resource XML", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException("Could not read resource XML", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException("Listener class not found", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException("Listener is not public or lacks public constructor", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException("Could not create instance of listener", context);
            }
        } while (true);
    }

    public void onReceive(Context context, Intent intent)
    {
        WakefulIntentService.AlarmListener alarmlistener;
label0:
        {
            alarmlistener = getListener(context);
            if (alarmlistener != null)
            {
                if (intent.getAction() != null)
                {
                    break label0;
                }
                context.getSharedPreferences("com.commonsware.cwac.wakeful.WakefulIntentService", 0).edit().putLong("lastAlarm", System.currentTimeMillis()).commit();
                alarmlistener.sendWakefulWork(context);
            }
            return;
        }
        WakefulIntentService.scheduleAlarms(alarmlistener, context, true);
    }
}
