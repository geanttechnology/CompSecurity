// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.ClientMetrics;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, ClientMetricDefaultEncoder, DefaultEncoder, ClientLogInfoDefaultEncoder

public class ClientMetricsDefaultEncoder
    implements Encoder
{

    public ClientMetricsDefaultEncoder()
    {
    }

    public void encode(ClientMetrics clientmetrics, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (clientmetrics.getMetrics() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getArrayInstance(new ClientMetricDefaultEncoder()).encode(clientmetrics.getMetrics(), dataoutputstream);
        }
        if (clientmetrics.getExposedSlots() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getArrayInstance(DefaultEncoder.getStringInstance()).encode(clientmetrics.getExposedSlots(), dataoutputstream);
        }
        if (clientmetrics.getClickedSlots() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getArrayInstance(DefaultEncoder.getStringInstance()).encode(clientmetrics.getClickedSlots(), dataoutputstream);
        }
        if (clientmetrics.getLogInfo() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new ClientLogInfoDefaultEncoder()).encode(clientmetrics.getLogInfo(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((ClientMetrics)obj, dataoutputstream);
    }
}
