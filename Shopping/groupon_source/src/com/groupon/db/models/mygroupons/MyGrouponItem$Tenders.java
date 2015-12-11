// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models.mygroupons;


// Referenced classes of package com.groupon.db.models.mygroupons:
//            MyGrouponItem

protected static class DefaultBillingInfo
{

    public static final nfo DefaultBillingInfo = new nfo();
    public static final e DefaultPriceType = new e();
    public e amount;
    private nfo billingInfo;
    public String type;



    protected nfo()
    {
        type = "";
        amount = DefaultPriceType;
        billingInfo = DefaultBillingInfo;
    }
}
