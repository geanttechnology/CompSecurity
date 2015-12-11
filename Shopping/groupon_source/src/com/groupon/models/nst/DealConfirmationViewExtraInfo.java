// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class DealConfirmationViewExtraInfo extends JsonEncodedNSTField
{

    protected String dealType;
    protected String defaultDealOptionId;
    protected String selectedDealOptionId;

    public DealConfirmationViewExtraInfo(String s, String s1, String s2)
    {
        dealType = s;
        selectedDealOptionId = s1;
        defaultDealOptionId = s2;
    }
}
