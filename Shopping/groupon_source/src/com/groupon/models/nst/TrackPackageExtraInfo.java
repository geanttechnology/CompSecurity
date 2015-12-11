// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class TrackPackageExtraInfo extends JsonEncodedNSTField
{

    public String buttonPosition;
    public String orderId;

    public TrackPackageExtraInfo(String s)
    {
        orderId = s;
    }

    public TrackPackageExtraInfo(String s, String s1)
    {
        orderId = s;
        buttonPosition = s1;
    }
}
