// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class PurchaseConfirmationExtraInfo extends JsonEncodedNSTField
{

    private String bookingStatus;
    private String buyButton;
    private String currencyCode;
    private String dealtype;
    private String priceInCents;
    private String quantity;

    public PurchaseConfirmationExtraInfo(String s, String s1, String s2, String s3, String s4, String s5)
    {
        dealtype = s;
        quantity = s1;
        priceInCents = s2;
        currencyCode = s3;
        bookingStatus = s4;
        buyButton = s5;
    }
}
