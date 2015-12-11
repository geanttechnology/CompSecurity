// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;


// Referenced classes of package com.amazon.rio.j2me.client.rsc:
//            ServiceCallImpl, ServiceCallState

private static class errorString
{

    private long endTime;
    private String errorString;
    private String method;
    private long startTime;
    private ServiceCallState state;

    protected long getEndTime()
    {
        return endTime;
    }

    protected String getErrorString()
    {
        return errorString;
    }

    protected String getMethod()
    {
        return method;
    }

    protected long getStartTime()
    {
        return startTime;
    }

    protected ServiceCallState getState()
    {
        return state;
    }

    public (ServiceCallImpl servicecallimpl)
    {
        startTime = -1L;
        endTime = -1L;
        method = "";
        state = ServiceCallState.NOT_STARTED;
        errorString = "";
        if (servicecallimpl != null)
        {
            startTime = servicecallimpl.getStartTime();
            endTime = servicecallimpl.getEndTime();
            method = servicecallimpl.getMethod();
            state = servicecallimpl.getState();
            if (servicecallimpl.getError() != null)
            {
                errorString = servicecallimpl.getError().toString();
            }
        }
    }
}
