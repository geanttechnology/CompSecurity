// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            HttpsURLConnectionExtension, TransactionState

class val.transactionState
    implements StreamCompleteListener
{

    final HttpsURLConnectionExtension this$0;
    final TransactionState val$transactionState;

    public void streamComplete(StreamCompleteEvent streamcompleteevent)
    {
        if (!val$transactionState.isComplete())
        {
            long l1 = HttpsURLConnectionExtension.access$100(HttpsURLConnectionExtension.this).getContentLength();
            long l = streamcompleteevent.getBytes();
            if (l1 >= 0L)
            {
                l = l1;
            }
            val$transactionState.setBytesReceived(l);
            HttpsURLConnectionExtension.access$200(HttpsURLConnectionExtension.this, val$transactionState);
        }
    }

    public void streamError(StreamCompleteEvent streamcompleteevent)
    {
        if (!val$transactionState.isComplete())
        {
            val$transactionState.setBytesReceived(streamcompleteevent.getBytes());
        }
        HttpsURLConnectionExtension.access$000(HttpsURLConnectionExtension.this, streamcompleteevent.getException());
    }

    ()
    {
        this$0 = final_httpsurlconnectionextension;
        val$transactionState = TransactionState.this;
        super();
    }
}
