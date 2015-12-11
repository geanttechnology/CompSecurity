// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            CreditCard

static class pe
{

    static final int $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type = new int[pe.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[pe.AMERICANEXPRESS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[pe.JCB.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[pe.MASTERCARD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[pe.VISA.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[pe.DISCOVER.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[pe.INSUFFICIENT_DIGITS.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[pe.UNKNOWN.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
