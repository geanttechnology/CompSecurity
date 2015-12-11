// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.text.TextUtils;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService

public static final class zzVQ
{

    private zzVQ zzVQ;

    public zzVQ build()
    {
        if (zzVQ(zzVQ) != null)
        {
            if (!TextUtils.isEmpty(zzVQ(zzVQ)))
            {
                throw new IllegalArgumentException("notificationTitle requires using the default notification");
            }
            if (!TextUtils.isEmpty(zzVQ(zzVQ)))
            {
                throw new IllegalArgumentException("notificationText requires using the default notification");
            }
            if (zzVQ(zzVQ) != null)
            {
                throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
            }
        } else
        if (TextUtils.isEmpty(zzVQ(zzVQ)) && TextUtils.isEmpty(zzVQ(zzVQ)) && zzVQ(zzVQ) == null)
        {
            throw new IllegalArgumentException("At least an argument must be provided");
        }
        return zzVQ;
    }

    public zzVQ setNotification(Notification notification)
    {
        zzVQ(zzVQ, notification);
        return this;
    }

    public zzVQ setNotificationPendingIntent(PendingIntent pendingintent)
    {
        zzVQ(zzVQ, pendingintent);
        return this;
    }

    public zzVQ setNotificationText(String s)
    {
        zzVQ(zzVQ, s);
        return this;
    }

    public zzVQ setNotificationTitle(String s)
    {
        zzVQ(zzVQ, s);
        return this;
    }

    public ()
    {
        zzVQ = new zzVQ(null);
    }
}
