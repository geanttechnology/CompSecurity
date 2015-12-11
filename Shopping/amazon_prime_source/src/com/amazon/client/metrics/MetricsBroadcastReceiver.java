// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.dp.logger.DPLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            UploadIntentListener

public class MetricsBroadcastReceiver extends BroadcastReceiver
{

    private static final DPLogger log = new DPLogger("MetricsBroadcastReceiver");
    private static List sUploadIntentListenerList = new ArrayList();

    public MetricsBroadcastReceiver()
    {
    }

    protected static void addUploadIntentListener(UploadIntentListener uploadintentlistener)
    {
        sUploadIntentListenerList.add(uploadintentlistener);
    }

    public static void shutdown()
    {
        sUploadIntentListenerList.clear();
    }

    public void onReceive(Context context, Intent intent)
    {
        String s;
        if (intent == null)
        {
            s = null;
        } else
        {
            s = intent.getAction();
        }
        if ("com.amazon.intent.action.UPLOAD_METRICS".equals(s))
        {
            if (context.checkCallingOrSelfPermission("amazon.permission.UPLOAD_METRICS") == -1)
            {
                log.error("onReceive", "Metrics upload permission denied.", new Object[0]);
            } else
            {
                log.info("onReceive", "Upload metrics intent received. Notifying listeners.", new Object[0]);
                context = sUploadIntentListenerList.iterator();
                while (context.hasNext()) 
                {
                    ((UploadIntentListener)context.next()).onUploadIntentReceived();
                }
            }
            return;
        } else
        {
            log.verbose("onReceive", "Received unexpected intent.", new Object[] {
                " intent: ", intent, " action: ", s
            });
            return;
        }
    }

}
