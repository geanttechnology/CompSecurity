// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.transport;

import android.util.Log;
import com.amazon.client.metrics.MetricEvent;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.amazon.client.metrics.transport:
//            MetricsTransport, TransportStateNotifier

public class OutputStreamMetricsTransport
    implements MetricsTransport, TransportStateNotifier
{

    private static final String TAG = "Metrics:OutputStreamMetricsTransport";
    private final OutputStream mOutputStream;

    public OutputStreamMetricsTransport(OutputStream outputstream)
    {
        mOutputStream = outputstream;
    }

    public void close()
    {
    }

    public void listenForTransportWarmed(TransportStateNotifier.TransportWarmedListener transportwarmedlistener)
    {
    }

    public void shutdown()
    {
        try
        {
            mOutputStream.close();
            return;
        }
        catch (IOException ioexception)
        {
            Log.e("Metrics:OutputStreamMetricsTransport", "Unable to shutdown transport.", ioexception);
        }
    }

    public int transmit(byte abyte0[], MetricEvent metricevent)
    {
        try
        {
            mOutputStream.write(abyte0);
            mOutputStream.flush();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.e("Metrics:OutputStreamMetricsTransport", "Unable to transmit.", abyte0);
            return 3;
        }
        return 1;
    }
}
