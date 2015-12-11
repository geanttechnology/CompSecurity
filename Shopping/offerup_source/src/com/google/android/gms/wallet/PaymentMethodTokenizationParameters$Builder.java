// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.wallet:
//            PaymentMethodTokenizationParameters

public final class <init>
{

    final PaymentMethodTokenizationParameters zzbdE;

    public final <init> addParameter(String s, String s1)
    {
        zzx.zzh(s, "Tokenization parameter name must not be empty");
        zzx.zzh(s1, "Tokenization parameter value must not be empty");
        zzbdE.zzbdD.putString(s, s1);
        return this;
    }

    public final PaymentMethodTokenizationParameters build()
    {
        return zzbdE;
    }

    public final zzbdE setPaymentMethodTokenizationType(int i)
    {
        zzbdE.zzbdC = i;
        return this;
    }

    private (PaymentMethodTokenizationParameters paymentmethodtokenizationparameters)
    {
        zzbdE = paymentmethodtokenizationparameters;
        super();
    }

    zzbdE(PaymentMethodTokenizationParameters paymentmethodtokenizationparameters, zzbdE zzbde)
    {
        this(paymentmethodtokenizationparameters);
    }
}
