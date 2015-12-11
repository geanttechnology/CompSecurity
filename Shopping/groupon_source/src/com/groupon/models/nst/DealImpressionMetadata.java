// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class DealImpressionMetadata extends JsonEncodedNSTField
{

    public String DTFInfo;
    public String badgeDisplayText;
    public String badgeType;
    public String crm;
    public String deal_status;
    public String offerType;
    public String type;

    public DealImpressionMetadata(String s)
    {
        deal_status = s;
    }

    public DealImpressionMetadata(String s, String s1, String s2)
    {
        offerType = s;
        crm = s1;
        deal_status = s2;
    }
}
