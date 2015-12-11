// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;


// Referenced classes of package com.offerup.android.dto.response:
//            BaseResponse, NotificationResponseData

public class NotificationResponse extends BaseResponse
{

    private NotificationResponseData data;

    public NotificationResponse()
    {
        data = new NotificationResponseData();
    }

    public NotificationResponseData getData()
    {
        return data;
    }
}
