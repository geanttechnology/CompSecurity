// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class GoogleWalletCardClickExtraInfo extends JsonEncodedNSTField
{

    protected String orderField;
    protected String pageId;

    public GoogleWalletCardClickExtraInfo(String s, String s1)
    {
        pageId = s;
        orderField = s1;
    }
}
