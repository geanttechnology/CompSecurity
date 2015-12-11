// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.metrics;

import com.amazon.retailsearch.android.api.log.LogEventHandler;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;
import com.amazon.searchapp.retailsearch.model.Metrics;

// Referenced classes of package com.amazon.retailsearch.data.metrics:
//            SRDSMetricsLoader

private class <init> extends AbstractServiceCallListener
{

    private boolean cancelled;
    private LogEventHandler logEventHandler;
    final SRDSMetricsLoader this$0;

    public void endRequest()
    {
        while (cancelled || SRDSMetricsLoader.access$300(SRDSMetricsLoader.this)) 
        {
            return;
        }
        SRDSMetricsLoader.access$402(SRDSMetricsLoader.this, true);
    }

    public void error(Exception exception)
    {
        if (!cancelled)
        {
            SRDSMetricsLoader.access$402(SRDSMetricsLoader.this, true);
        }
    }

    public void result(Metrics metrics)
    {
        if (!cancelled && SRDSMetricsLoader.access$200(SRDSMetricsLoader.this, metrics) != null)
        {
            SRDSMetricsLoader.access$302(SRDSMetricsLoader.this, true);
        }
    }

    public volatile void result(Object obj)
    {
        result((Metrics)obj);
    }

    public void startRequest()
    {
        if (cancelled);
    }


/*
    static boolean access$102(r r, boolean flag)
    {
        r.cancelled = flag;
        return flag;
    }

*/

    private cancelled()
    {
        this$0 = SRDSMetricsLoader.this;
        super();
    }

    r(r r)
    {
        this();
    }
}
