// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.text.TextUtils;
import com.google.android.gms.internal.eg;

// Referenced classes of package com.google.android.gms.wallet:
//            NotifyTransactionStatusRequest

public final class <init>
{

    final NotifyTransactionStatusRequest GW;

    public NotifyTransactionStatusRequest build()
    {
        boolean flag1 = true;
        boolean flag;
        if (!TextUtils.isEmpty(GW.Gn))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "googleTransactionId is required");
        if (GW.status >= 1 && GW.status <= 8)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        eg.b(flag, "status is an unrecognized value");
        return GW;
    }

    public GW setDetailedReason(String s)
    {
        GW.GV = s;
        return this;
    }

    public GW setGoogleTransactionId(String s)
    {
        GW.Gn = s;
        return this;
    }

    public GW setStatus(int i)
    {
        GW.status = i;
        return this;
    }

    private (NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        GW = notifytransactionstatusrequest;
        super();
    }

    GW(NotifyTransactionStatusRequest notifytransactionstatusrequest, GW gw)
    {
        this(notifytransactionstatusrequest);
    }
}
