// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import android.content.Intent;

// Referenced classes of package com.socialin.android.photo.notifications:
//            NotificationsService

final class a
    implements Runnable
{

    private NotificationsService a;

    public final void run()
    {
        if (a.a)
        {
            return;
        } else
        {
            Intent intent = new Intent();
            intent.setAction("action.refresh");
            NotificationsService.a(a, intent);
            return;
        }
    }

    (NotificationsService notificationsservice)
    {
        a = notificationsservice;
        super();
    }
}
