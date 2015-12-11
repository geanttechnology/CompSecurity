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

        private CastRemoteDisplayLocalService.NotificationSettings zzVQ;

        public CastRemoteDisplayLocalService.NotificationSettings build()
        {
            if (CastRemoteDisplayLocalService.NotificationSettings.zza(zzVQ) != null)
            {
                if (!TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzb(zzVQ)))
                {
                    throw new IllegalArgumentException("notificationTitle requires using the default notification");
                }
                if (!TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzc(zzVQ)))
                {
                    throw new IllegalArgumentException("notificationText requires using the default notification");
                }
                if (CastRemoteDisplayLocalService.NotificationSettings.zzd(zzVQ) != null)
                {
                    throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                }
            } else
            if (TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzb(zzVQ)) && TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzc(zzVQ)) && CastRemoteDisplayLocalService.NotificationSettings.zzd(zzVQ) == null)
            {
                throw new IllegalArgumentException("At least an argument must be provided");
            }
            return zzVQ;
        }

        public Builder setNotification(Notification notification)
        {
            CastRemoteDisplayLocalService.NotificationSettings.zza(zzVQ, notification);
            return this;
        }

        public Builder setNotificationPendingIntent(PendingIntent pendingintent)
        {
            CastRemoteDisplayLocalService.NotificationSettings.zza(zzVQ, pendingintent);
            return this;
        }

        public Builder setNotificationText(String s)
        {
            CastRemoteDisplayLocalService.NotificationSettings.zzb(zzVQ, s);
            return this;
        }

        public Builder setNotificationTitle(String s)
        {
            CastRemoteDisplayLocalService.NotificationSettings.zza(zzVQ, s);
            return this;
        }

        public Builder()
        {
            zzVQ = new CastRemoteDisplayLocalService.NotificationSettings(null);
        }
    }


    private Notification mNotification;
    private PendingIntent zzVN;
    private String zzVO;
    private String zzVP;

    static Notification zza(Builder.zzVQ zzvq)
    {
        return zzvq.mNotification;
    }

    static Notification zza(mNotification mnotification, Notification notification)
    {
        mnotification.mNotification = notification;
        return notification;
    }

    static PendingIntent zza(mNotification mnotification, PendingIntent pendingintent)
    {
        mnotification.zzVN = pendingintent;
        return pendingintent;
    }

    static String zza(zzVN zzvn, String s)
    {
        zzvn.zzVO = s;
        return s;
    }

    static String zzb(zzVO zzvo)
    {
        return zzvo.zzVO;
    }

    static String zzb(zzVO zzvo, String s)
    {
        zzvo.zzVP = s;
        return s;
    }

    static String zzc(zzVP zzvp)
    {
        return zzvp.zzVP;
    }

    static PendingIntent zzd(zzVP zzvp)
    {
        return zzvp.zzVN;
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
        zzVN = <init>1.zzVN;
        zzVO = <init>1.zzVO;
        zzVP = <init>1.zzVP;
    }

    zzVP(zzVP zzvp, zzVP zzvp1)
    {
        this(zzvp);
    }
}
