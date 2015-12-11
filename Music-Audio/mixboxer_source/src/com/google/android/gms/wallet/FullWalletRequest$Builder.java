// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;


// Referenced classes of package com.google.android.gms.wallet:
//            FullWalletRequest, Cart

public final class <init>
{

    final FullWalletRequest Gv;

    public FullWalletRequest build()
    {
        return Gv;
    }

    public Gv setCart(Cart cart)
    {
        Gv.Gu = cart;
        return this;
    }

    public Gv setGoogleTransactionId(String s)
    {
        Gv.Gn = s;
        return this;
    }

    public Gv setMerchantTransactionId(String s)
    {
        Gv.Go = s;
        return this;
    }

    private (FullWalletRequest fullwalletrequest)
    {
        Gv = fullwalletrequest;
        super();
    }

    Gv(FullWalletRequest fullwalletrequest, Gv gv)
    {
        this(fullwalletrequest);
    }
}
