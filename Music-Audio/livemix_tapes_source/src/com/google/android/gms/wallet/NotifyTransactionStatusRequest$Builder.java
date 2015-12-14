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

    final NotifyTransactionStatusRequest zzaXt;

    public NotifyTransactionStatusRequest build()
    {
        boolean flag1 = true;
        boolean flag;
        if (!TextUtils.isEmpty(zzaXt.zzaWi))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "googleTransactionId is required");
        if (zzaXt.status >= 1 && zzaXt.status <= 8)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "status is an unrecognized value");
        return zzaXt;
    }

    public zzaXt setDetailedReason(String s)
    {
        zzaXt.zzaXs = s;
        return this;
    }

    public zzaXt setGoogleTransactionId(String s)
    {
        zzaXt.zzaWi = s;
        return this;
    }

    public zzaXt setStatus(int i)
    {
        zzaXt.status = i;
        return this;
    }

    private (NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        zzaXt = notifytransactionstatusrequest;
        super();
    }

    zzaXt(NotifyTransactionStatusRequest notifytransactionstatusrequest, zzaXt zzaxt)
    {
        this(notifytransactionstatusrequest);
    }
}
