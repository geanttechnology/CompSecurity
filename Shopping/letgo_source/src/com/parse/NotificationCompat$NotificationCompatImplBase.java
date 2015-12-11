// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Notification;

// Referenced classes of package com.parse:
//            NotificationCompat

static class 
    implements 
{

    public Notification build( )
    {
        Notification notification = .;
        notification.setLatestEventInfo(., ., ., .);
        if (. > 0)
        {
            notification.flags = notification.flags | 0x80;
        }
        return notification;
    }

    ()
    {
    }
}
