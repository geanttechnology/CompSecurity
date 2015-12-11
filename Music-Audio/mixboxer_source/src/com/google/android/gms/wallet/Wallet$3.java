// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.iu;

// Referenced classes of package com.google.android.gms.wallet:
//            Wallet, MaskedWalletRequest

static final class <init> extends <init>
{

    final int Hc;
    final MaskedWalletRequest Hd;

    protected volatile void a(com.google.android.gms.common.api.t> t>)
    {
        a((iu)t>);
    }

    protected void a(iu iu1)
    {
        iu1.loadMaskedWallet(Hd, Hc);
        a(((com.google.android.gms.common.api.Result) (Status.nA)));
    }

    letRequest(MaskedWalletRequest maskedwalletrequest, int i)
    {
        Hd = maskedwalletrequest;
        Hc = i;
        super();
    }
}
