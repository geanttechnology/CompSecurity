// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;


// Referenced classes of package com.google.android.gms.wallet:
//            FullWalletRequest, Cart

public final class <init>
{

    final FullWalletRequest zzbcB;

    public final FullWalletRequest build()
    {
        return zzbcB;
    }

    public final zzbcB setCart(Cart cart)
    {
        zzbcB.zzbcA = cart;
        return this;
    }

    public final zzbcB setGoogleTransactionId(String s)
    {
        zzbcB.zzbcp = s;
        return this;
    }

    public final zzbcB setMerchantTransactionId(String s)
    {
        zzbcB.zzbcq = s;
        return this;
    }

    private (FullWalletRequest fullwalletrequest)
    {
        zzbcB = fullwalletrequest;
        super();
    }

    zzbcB(FullWalletRequest fullwalletrequest, zzbcB zzbcb)
    {
        this(fullwalletrequest);
    }
}
