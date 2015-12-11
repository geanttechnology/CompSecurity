// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.concurrent.Cancellable;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;

// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            AbstractExecutionAwareRequest

class val.connRequest
    implements Cancellable
{

    final AbstractExecutionAwareRequest this$0;
    final ClientConnectionRequest val$connRequest;

    public boolean cancel()
    {
        val$connRequest.abortRequest();
        return true;
    }

    ()
    {
        this$0 = final_abstractexecutionawarerequest;
        val$connRequest = ClientConnectionRequest.this;
        super();
    }
}
