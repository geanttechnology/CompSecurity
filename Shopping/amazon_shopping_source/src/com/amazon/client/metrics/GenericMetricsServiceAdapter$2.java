// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.amazon.dp.logger.DPLogger;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            GenericMetricsServiceAdapter, MetricEntry, DataPointEnvelope

class this._cls0 extends this._cls0
{

    final GenericMetricsServiceAdapter this$0;

    public boolean getRecordMetricsSetting()
    {
        return true;
    }

    public void record(int i, String s, String s1, long l, List list)
        throws RemoteException
    {
        GenericMetricsServiceAdapter.access$000().verbose("record", (new StringBuilder()).append("[ ").append(s).append(" , ").append(s1).append(" ]").toString(), new Object[0]);
        Handler handler = getHandler();
        Message message = handler.obtainMessage();
        message.arg1 = i;
        message.obj = new MetricEntry(l, s, s1, DataPointEnvelope.convertFromEnvelopes(list));
        handler.sendMessage(message);
    }

    ()
    {
        this$0 = GenericMetricsServiceAdapter.this;
        super();
    }
}
