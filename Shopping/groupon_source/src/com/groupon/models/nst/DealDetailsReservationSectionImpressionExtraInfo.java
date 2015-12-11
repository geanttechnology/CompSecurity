// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class DealDetailsReservationSectionImpressionExtraInfo extends JsonEncodedNSTField
{

    private String dealId;
    private String dealUuid;
    private String intent;
    private String type;

    public DealDetailsReservationSectionImpressionExtraInfo(String s, String s1, String s2, String s3)
    {
        type = s;
        intent = s1;
        dealId = s2;
        dealUuid = s3;
    }
}
