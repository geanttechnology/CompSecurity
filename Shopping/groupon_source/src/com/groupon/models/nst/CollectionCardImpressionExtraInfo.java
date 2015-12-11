// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class CollectionCardImpressionExtraInfo extends JsonEncodedNSTField
{

    public final String cardUUID;
    public final String templateId;

    public CollectionCardImpressionExtraInfo(String s, String s1)
    {
        cardUUID = s;
        templateId = s1;
    }
}
