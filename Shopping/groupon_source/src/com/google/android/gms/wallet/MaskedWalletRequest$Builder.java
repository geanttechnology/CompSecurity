// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;


// Referenced classes of package com.google.android.gms.wallet:
//            MaskedWalletRequest, Cart

public final class <init>
{

    final MaskedWalletRequest zzaRv;

    public MaskedWalletRequest build()
    {
        return zzaRv;
    }

    public zzaRv setCart(Cart cart)
    {
        zzaRv.zzaQx = cart;
        return this;
    }

    public zzaRv setCurrencyCode(String s)
    {
        zzaRv.zzaQg = s;
        return this;
    }

    public zzaRv setEstimatedTotalPrice(String s)
    {
        zzaRv.zzaRl = s;
        return this;
    }

    public zzaRv setMerchantName(String s)
    {
        zzaRv.zzaRm = s;
        return this;
    }

    public zzaRv setPhoneNumberRequired(boolean flag)
    {
        zzaRv.zzaRi = flag;
        return this;
    }

    public zzaRv setShippingAddressRequired(boolean flag)
    {
        zzaRv.zzaRj = flag;
        return this;
    }

    public zzaRv setShouldRetrieveWalletObjects(boolean flag)
    {
        zzaRv.zzaRn = flag;
        return this;
    }

    private (MaskedWalletRequest maskedwalletrequest)
    {
        zzaRv = maskedwalletrequest;
        super();
    }

    zzaRv(MaskedWalletRequest maskedwalletrequest, zzaRv zzarv)
    {
        this(maskedwalletrequest);
    }
}
