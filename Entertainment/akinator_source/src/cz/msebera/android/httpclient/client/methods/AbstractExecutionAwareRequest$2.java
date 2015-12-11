// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.concurrent.Cancellable;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            AbstractExecutionAwareRequest

class val.releaseTrigger
    implements Cancellable
{

    final AbstractExecutionAwareRequest this$0;
    final ConnectionReleaseTrigger val$releaseTrigger;

    public boolean cancel()
    {
        try
        {
            val$releaseTrigger.abortConnection();
        }
        catch (IOException ioexception)
        {
            return false;
        }
        return true;
    }

    ()
    {
        this$0 = final_abstractexecutionawarerequest;
        val$releaseTrigger = ConnectionReleaseTrigger.this;
        super();
    }
}
