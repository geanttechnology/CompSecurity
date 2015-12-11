// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class PurchaseInitiationExtraInfo extends JsonEncodedNSTField
{

    protected String bookingStatus;
    protected String dealType;
    protected String gdtFlag;

    public PurchaseInitiationExtraInfo(String s, String s1, String s2)
    {
        dealType = s;
        gdtFlag = s1;
        bookingStatus = s2;
    }
}
