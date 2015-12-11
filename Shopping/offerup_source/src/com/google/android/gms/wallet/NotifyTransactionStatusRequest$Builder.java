// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.wallet:
//            NotifyTransactionStatusRequest

public final class <init>
{

    final NotifyTransactionStatusRequest zzbdA;

    public final NotifyTransactionStatusRequest build()
    {
        boolean flag1 = true;
        boolean flag;
        if (!TextUtils.isEmpty(zzbdA.zzbcp))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "googleTransactionId is required");
        if (zzbdA.status > 0 && zzbdA.status <= 8)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "status is an unrecognized value");
        return zzbdA;
    }

    public final zzbdA setDetailedReason(String s)
    {
        zzbdA.zzbdz = s;
        return this;
    }

    public final zzbdA setGoogleTransactionId(String s)
    {
        zzbdA.zzbcp = s;
        return this;
    }

    public final zzbdA setStatus(int i)
    {
        zzbdA.status = i;
        return this;
    }

    private (NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        zzbdA = notifytransactionstatusrequest;
        super();
    }

    zzbdA(NotifyTransactionStatusRequest notifytransactionstatusrequest, zzbdA zzbda)
    {
        this(notifytransactionstatusrequest);
    }
}
