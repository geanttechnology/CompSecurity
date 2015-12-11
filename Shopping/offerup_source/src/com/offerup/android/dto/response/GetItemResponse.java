// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import com.offerup.android.dto.Status;

// Referenced classes of package com.offerup.android.dto.response:
//            GetItemResponseData

public class GetItemResponse
{

    GetItemResponseData data;
    Status status;

    public GetItemResponse()
    {
        status = new Status();
        data = new GetItemResponseData();
    }

    public GetItemResponseData getData()
    {
        return data;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setData(GetItemResponseData getitemresponsedata)
    {
        data = getitemresponsedata;
    }

    public void setStatus(Status status1)
    {
        status = status1;
    }
}
