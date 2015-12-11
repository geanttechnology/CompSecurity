// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import com.offerup.android.c.b;

// Referenced classes of package com.offerup.android.dto:
//            Status, Data

public class OfferUpResponse
{

    String asyncTaskName;
    boolean authenticationError;
    private Data data;
    private Status status;

    public OfferUpResponse()
    {
        asyncTaskName = "";
        status = new Status();
        data = new Data();
    }

    public String getAsyncTaskName()
    {
        return asyncTaskName;
    }

    public Data getData()
    {
        return data;
    }

    public Status getStatus()
    {
        return status;
    }

    public boolean isAuthenticationError()
    {
        return authenticationError;
    }

    public boolean isSuccess()
    {
        if (getStatus() == null || isAuthenticationError())
        {
            return false;
        } else
        {
            return b.a.equalsIgnoreCase(getStatus().getStatus());
        }
    }

    public void setAsyncTaskName(String s)
    {
        asyncTaskName = s;
    }

    public void setAuthenticationError(boolean flag)
    {
        authenticationError = flag;
    }

    public void setData(Data data1)
    {
        data = data1;
    }

    public void setStatus(Status status1)
    {
        status = status1;
    }

    public String toString()
    {
        return (new StringBuilder("OfferUpResponse [status=")).append(status).append(", data=").append(data).append("]").toString();
    }
}
