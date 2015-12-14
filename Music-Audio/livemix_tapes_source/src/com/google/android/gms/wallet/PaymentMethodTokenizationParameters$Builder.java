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

    final PaymentMethodTokenizationParameters zzaXx;

    public <init> addParameter(String s, String s1)
    {
        zzx.zzh(s, "Tokenization parameter name must not be empty");
        zzx.zzh(s1, "Tokenization parameter value must not be empty");
        zzaXx.zzaXw.putString(s, s1);
        return this;
    }

    public PaymentMethodTokenizationParameters build()
    {
        return zzaXx;
    }

    public zzaXx setPaymentMethodTokenizationType(int i)
    {
        zzaXx.zzaXv = i;
        return this;
    }

    private (PaymentMethodTokenizationParameters paymentmethodtokenizationparameters)
    {
        zzaXx = paymentmethodtokenizationparameters;
        super();
    }

    zzaXx(PaymentMethodTokenizationParameters paymentmethodtokenizationparameters, zzaXx zzaxx)
    {
        this(paymentmethodtokenizationparameters);
    }
}
