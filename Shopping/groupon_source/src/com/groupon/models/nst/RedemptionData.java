// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class RedemptionData extends JsonEncodedNSTField
{

    String grouponNumber;
    String voucherCode;
    String voucherUUID;

    public RedemptionData(String s, String s1, String s2)
    {
        grouponNumber = s;
        voucherCode = s1;
        voucherUUID = s2;
    }
}
