// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class LiveChatExtraInfo extends JsonEncodedNSTField
{

    protected String dealId;
    protected String pageId;

    public LiveChatExtraInfo(String s, String s1)
    {
        pageId = s;
        dealId = s1;
    }
}
