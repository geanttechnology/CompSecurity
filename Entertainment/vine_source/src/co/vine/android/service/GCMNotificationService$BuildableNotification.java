// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import co.vine.android.api.VineSingleNotification;

// Referenced classes of package co.vine.android.service:
//            GCMNotificationService

public class event
{

    final event event;
    final VineSingleNotification notification;
    final GCMNotificationService this$0;

    public void build()
    {
        GCMNotificationService.access$900(GCMNotificationService.this, notification, event);
    }

    public (VineSingleNotification vinesinglenotification,  )
    {
        this$0 = GCMNotificationService.this;
        super();
        notification = vinesinglenotification;
        event = ;
    }
}
