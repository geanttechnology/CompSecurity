// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.text.TextUtils;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService

public static final class zzUa
{

    private zzUa zzUa;

    public zzUa build()
    {
        if (zzUa(zzUa) != null)
        {
            if (!TextUtils.isEmpty(zzUa(zzUa)))
            {
                throw new IllegalArgumentException("notificationTitle requires using the default notification");
            }
            if (!TextUtils.isEmpty(zzUa(zzUa)))
            {
                throw new IllegalArgumentException("notificationText requires using the default notification");
            }
            if (zzUa(zzUa) != null)
            {
                throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
            }
        } else
        if (TextUtils.isEmpty(zzUa(zzUa)) && TextUtils.isEmpty(zzUa(zzUa)) && zzUa(zzUa) == null)
        {
            throw new IllegalArgumentException("At least an argument must be provided");
        }
        return zzUa;
    }

    public zzUa setNotification(Notification notification)
    {
        zzUa(zzUa, notification);
        return this;
    }

    public zzUa setNotificationPendingIntent(PendingIntent pendingintent)
    {
        zzUa(zzUa, pendingintent);
        return this;
    }

    public zzUa setNotificationText(String s)
    {
        zzUa(zzUa, s);
        return this;
    }

    public zzUa setNotificationTitle(String s)
    {
        zzUa(zzUa, s);
        return this;
    }

    public ()
    {
        zzUa = new zzUa(null);
    }
}
