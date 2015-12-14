// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            NotificationsImpl

private static abstract class _cls1.zzQs extends com.google.android.gms.games.tingLoadImpl
{

    public com.google.android.gms.games.tingLoadImpl zzan(Status status)
    {
        return new com.google.android.gms.games.Notifications.ContactSettingLoadResult(status) {

            final Status zzQs;
            final NotificationsImpl.ContactSettingLoadImpl zzavn;

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzavn = NotificationsImpl.ContactSettingLoadImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzan(status);
    }
}
