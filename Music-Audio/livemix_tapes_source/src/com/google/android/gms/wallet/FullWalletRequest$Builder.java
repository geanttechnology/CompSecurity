// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;


// Referenced classes of package com.google.android.gms.wallet:
//            FullWalletRequest, Cart

public final class <init>
{

    final FullWalletRequest zzaWu;

    public FullWalletRequest build()
    {
        return zzaWu;
    }

    public zzaWu setCart(Cart cart)
    {
        zzaWu.zzaWt = cart;
        return this;
    }

    public zzaWu setGoogleTransactionId(String s)
    {
        zzaWu.zzaWi = s;
        return this;
    }

    public zzaWu setMerchantTransactionId(String s)
    {
        zzaWu.zzaWj = s;
        return this;
    }

    private (FullWalletRequest fullwalletrequest)
    {
        zzaWu = fullwalletrequest;
        super();
    }

    zzaWu(FullWalletRequest fullwalletrequest, zzaWu zzawu)
    {
        this(fullwalletrequest);
    }
}
