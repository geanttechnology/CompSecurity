// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField, RedemptionData

public class RedemptionExtraInfo extends JsonEncodedNSTField
{

    public RedemptionData redemption;

    public RedemptionExtraInfo(String s, String s1, String s2)
    {
        redemption = new RedemptionData(s, s1, s2);
    }
}
