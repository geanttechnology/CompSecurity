// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import com.amazon.avod.sdk.CallResponse;
import com.amazon.avod.sdk.ResponseHandler;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            BindingConnection

private static class <init>
    implements Runnable
{

    private final ResponseHandler mHandler;
    private final CallResponse mResponse;

    public void run()
    {
        mHandler.handleResponse(mResponse);
    }

    private (ResponseHandler responsehandler, CallResponse callresponse)
    {
        mHandler = responsehandler;
        mResponse = callresponse;
    }

    mResponse(ResponseHandler responsehandler, CallResponse callresponse, mResponse mresponse)
    {
        this(responsehandler, callresponse);
    }
}
