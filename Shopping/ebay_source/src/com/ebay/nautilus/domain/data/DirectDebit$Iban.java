// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            DirectDebit

public static class ibanAccountNumber
{

    public String bic;
    public String cardNumberLastFour;
    public String ibanAccountNumber;
    public String ibanTokenId;

    public ()
    {
    }

    public (String s)
    {
        ibanAccountNumber = s;
    }
}
