// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.text.TextUtils;
import com.google.android.gms.internal.er;

// Referenced classes of package com.google.android.gms.wallet:
//            NotifyTransactionStatusRequest

public final class <init>
{

    final NotifyTransactionStatusRequest Zl;

    public NotifyTransactionStatusRequest build()
    {
        boolean flag1 = true;
        boolean flag;
        if (!TextUtils.isEmpty(Zl.Yk))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.b(flag, "googleTransactionId is required");
        if (Zl.status >= 1 && Zl.status <= 8)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        er.b(flag, "status is an unrecognized value");
        return Zl;
    }

    public Zl setDetailedReason(String s)
    {
        Zl.Zk = s;
        return this;
    }

    public Zl setGoogleTransactionId(String s)
    {
        Zl.Yk = s;
        return this;
    }

    public Zl setStatus(int i)
    {
        Zl.status = i;
        return this;
    }

    private (NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        Zl = notifytransactionstatusrequest;
        super();
    }

    Zl(NotifyTransactionStatusRequest notifytransactionstatusrequest, Zl zl)
    {
        this(notifytransactionstatusrequest);
    }
}
