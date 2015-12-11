// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            DirectDebit

public static class routingNumber
{

    public String accountNumber;
    public String cardNumberLastFour;
    public String routingNumber;
    public String tokenId;

    public ()
    {
    }

    public (String s, String s1)
    {
        accountNumber = s;
        routingNumber = s1;
    }
}
