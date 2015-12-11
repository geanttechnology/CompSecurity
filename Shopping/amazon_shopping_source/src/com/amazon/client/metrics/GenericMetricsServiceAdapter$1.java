// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.os.Message;

// Referenced classes of package com.amazon.client.metrics:
//            GenericMetricsServiceAdapter

class this._cls0
    implements android.os.rviceAdapter._cls1
{

    final GenericMetricsServiceAdapter this$0;

    public boolean handleMessage(Message message)
    {
        return handleMessageForService(message);
    }

    ()
    {
        this$0 = GenericMetricsServiceAdapter.this;
        super();
    }
}
