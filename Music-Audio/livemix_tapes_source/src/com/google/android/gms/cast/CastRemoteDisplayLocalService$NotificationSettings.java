// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.text.TextUtils;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService

public static final class <init>
{
    public static final class Builder
    {

        private CastRemoteDisplayLocalService.NotificationSettings zzUa;

        public CastRemoteDisplayLocalService.NotificationSettings build()
        {
            if (CastRemoteDisplayLocalService.NotificationSettings.zza(zzUa) != null)
            {
                if (!TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzb(zzUa)))
                {
                    throw new IllegalArgumentException("notificationTitle requires using the default notification");
                }
                if (!TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzc(zzUa)))
                {
                    throw new IllegalArgumentException("notificationText requires using the default notification");
                }
                if (CastRemoteDisplayLocalService.NotificationSettings.zzd(zzUa) != null)
                {
                    throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                }
            } else
            if (TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzb(zzUa)) && TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzc(zzUa)) && CastRemoteDisplayLocalService.NotificationSettings.zzd(zzUa) == null)
            {
                throw new IllegalArgumentException("At least an argument must be provided");
            }
            return zzUa;
        }

        public Builder setNotification(Notification notification)
        {
            CastRemoteDisplayLocalService.NotificationSettings.zza(zzUa, notification);
            return this;
        }

        public Builder setNotificationPendingIntent(PendingIntent pendingintent)
        {
            CastRemoteDisplayLocalService.NotificationSettings.zza(zzUa, pendingintent);
            return this;
        }

        public Builder setNotificationText(String s)
        {
            CastRemoteDisplayLocalService.NotificationSettings.zzb(zzUa, s);
            return this;
        }

        public Builder setNotificationTitle(String s)
        {
            CastRemoteDisplayLocalService.NotificationSettings.zza(zzUa, s);
            return this;
        }

        public Builder()
        {
            zzUa = new CastRemoteDisplayLocalService.NotificationSettings(null);
        }
    }


    private Notification mNotification;
    private PendingIntent zzTX;
    private String zzTY;
    private String zzTZ;

    static Notification zza(Builder.zzUa zzua)
    {
        return zzua.mNotification;
    }

    static Notification zza(mNotification mnotification, Notification notification)
    {
        mnotification.mNotification = notification;
        return notification;
    }

    static PendingIntent zza(mNotification mnotification, PendingIntent pendingintent)
    {
        mnotification.zzTX = pendingintent;
        return pendingintent;
    }

    static String zza(zzTX zztx, String s)
    {
        zztx.zzTY = s;
        return s;
    }

    static String zzb(zzTY zzty)
    {
        return zzty.zzTY;
    }

    static String zzb(zzTY zzty, String s)
    {
        zzty.zzTZ = s;
        return s;
    }

    static String zzc(zzTZ zztz)
    {
        return zztz.zzTZ;
    }

    static PendingIntent zzd(zzTZ zztz)
    {
        return zztz.zzTX;
    }

    private <init>()
    {
    }

    <init>(<init> <init>1)
    {
        this();
    }

    private <init>(<init> <init>1)
    {
        mNotification = <init>1.mNotification;
        zzTX = <init>1.zzTX;
        zzTY = <init>1.zzTY;
        zzTZ = <init>1.zzTZ;
    }

    zzTZ(zzTZ zztz, zzTZ zztz1)
    {
        this(zztz);
    }
}
