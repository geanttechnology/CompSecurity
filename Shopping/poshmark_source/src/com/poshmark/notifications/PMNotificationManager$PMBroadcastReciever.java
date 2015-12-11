// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.poshmark.notifications:
//            PMNotificationManager, PMNotificationListener

public class listener extends BroadcastReceiver
{

    PMNotificationListener listener;
    final PMNotificationManager this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (listener != null)
        {
            listener.handleNotification(intent);
        }
    }

    public ()
    {
        this$0 = PMNotificationManager.this;
        super();
        listener = null;
    }

    public listener(PMNotificationListener pmnotificationlistener)
    {
        this$0 = PMNotificationManager.this;
        super();
        listener = null;
        listener = pmnotificationlistener;
    }
}
