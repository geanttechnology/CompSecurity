// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class PageViewExtraInfo extends JsonEncodedNSTField
{

    protected String dealId;
    protected String intent;
    protected String offerId;
    protected String type;

    public PageViewExtraInfo(String s)
    {
        dealId = s;
    }

    public PageViewExtraInfo(String s, String s1)
    {
        dealId = s;
        offerId = s1;
    }

    public PageViewExtraInfo(String s, String s1, String s2)
    {
        dealId = s;
        type = s1;
        intent = s2;
    }
}
