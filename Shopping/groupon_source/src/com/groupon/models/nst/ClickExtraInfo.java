// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField, GiftingNSTField

public class ClickExtraInfo extends JsonEncodedNSTField
{

    public String action;
    public Boolean bookableDeal;
    public Boolean buyAsGift;
    public String dealId;
    public GiftingNSTField gifting;
    public String intent;
    public String pageId;
    public String type;

    public ClickExtraInfo()
    {
    }
}
