// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class RaOContactHotelImpressionExtraInfo extends JsonEncodedNSTField
{

    protected int leftAttempts;
    protected int waitingTimeInMillionSeconds;

    public RaOContactHotelImpressionExtraInfo(int i, int j)
    {
        waitingTimeInMillionSeconds = i;
        leftAttempts = j;
    }
}
