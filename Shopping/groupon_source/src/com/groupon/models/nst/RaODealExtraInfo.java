// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class RaODealExtraInfo extends JsonEncodedNSTField
{

    protected boolean alreadyExpire;
    protected String currencyCode;
    protected String expireTime;
    protected boolean getRaOOffer;
    protected int raoPrice;

    public RaODealExtraInfo(boolean flag, int i, String s, String s1, boolean flag1)
    {
        getRaOOffer = flag;
        raoPrice = i;
        currencyCode = s;
        expireTime = s1;
        alreadyExpire = flag1;
    }
}
