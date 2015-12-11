// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class ThankYouScreenExtraInfo extends JsonEncodedNSTField
{

    public String dealId;
    public String pageId;
    public String widgetName;

    public ThankYouScreenExtraInfo(String s, String s1, String s2)
    {
        dealId = s;
        pageId = s1;
        widgetName = s2;
    }
}
