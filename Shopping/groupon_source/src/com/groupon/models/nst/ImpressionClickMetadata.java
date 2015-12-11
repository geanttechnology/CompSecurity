// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class ImpressionClickMetadata extends JsonEncodedNSTField
{

    public String badgeDisplayText;
    public String badgeType;
    protected String dealId;
    protected String dealUuid;
    protected String impressionType;
    protected int placement;

    public ImpressionClickMetadata(String s, String s1, int i, String s2)
    {
        dealId = s;
        dealUuid = s1;
        placement = i;
        impressionType = s2;
    }
}
