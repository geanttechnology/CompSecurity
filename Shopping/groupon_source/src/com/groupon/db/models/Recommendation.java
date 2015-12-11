// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            DealSummary, Merchant

public class Recommendation
{

    public DealSummary parentDealSummary;
    public Merchant parentMerchant;
    public String percentMessage;
    public Long primaryKey;
    public boolean prominentDisplay;
    public String source;
    public String totalMessage;

    public Recommendation()
    {
        totalMessage = "";
        source = "";
        prominentDisplay = false;
        percentMessage = "";
    }
}
