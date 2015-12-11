// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class DealViewExtraInfo extends JsonEncodedNSTField
{

    public String DTFValue;
    protected String category;
    protected String connectedMarketPlace;
    protected String crm;
    protected String dealtype;
    protected String defaultDealOptionId;
    protected String gdtFlag;
    protected String offerType;
    public String type;

    public DealViewExtraInfo(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        type = null;
        DTFValue = null;
        dealtype = s;
        crm = s1;
        offerType = s3;
        category = s2;
        gdtFlag = s4;
        connectedMarketPlace = s5;
        defaultDealOptionId = s6;
    }
}
