// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class MultiOptionClickExtraInfo extends JsonEncodedNSTField
{

    protected String defaultDealOptionId;
    protected String pageId;
    protected String selectedDealOptionId;

    public MultiOptionClickExtraInfo(String s, String s1, String s2)
    {
        pageId = s;
        defaultDealOptionId = s1;
        selectedDealOptionId = s2;
    }
}
