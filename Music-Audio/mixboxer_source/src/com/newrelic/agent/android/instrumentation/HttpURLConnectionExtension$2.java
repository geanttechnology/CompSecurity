// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import java.net.HttpURLConnection;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            HttpURLConnectionExtension, TransactionState

class val.transactionState
    implements StreamCompleteListener
{

    final HttpURLConnectionExtension this$0;
    final TransactionState val$transactionState;

    public void streamComplete(StreamCompleteEvent streamcompleteevent)
    {
        if (!val$transactionState.isComplete())
        {
            String s = HttpURLConnectionExtension.access$100(HttpURLConnectionExtension.this).getRequestProperty("content-length");
            long l1 = streamcompleteevent.getBytes();
            long l = l1;
            if (s != null)
            {
                try
                {
                    l = Long.parseLong(s);
                }
                // Misplaced declaration of an exception variable
                catch (StreamCompleteEvent streamcompleteevent)
                {
                    l = l1;
                }
            }
            val$transactionState.setBytesSent(l);
            HttpURLConnectionExtension.access$200(HttpURLConnectionExtension.this, val$transactionState);
        }
    }

    public void streamError(StreamCompleteEvent streamcompleteevent)
    {
        if (!val$transactionState.isComplete())
        {
            val$transactionState.setBytesSent(streamcompleteevent.getBytes());
        }
        HttpURLConnectionExtension.access$000(HttpURLConnectionExtension.this, streamcompleteevent.getException());
    }

    ()
    {
        this$0 = final_httpurlconnectionextension;
        val$transactionState = TransactionState.this;
        super();
    }
}
