// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class ClientMetricDefaultEncoder
    implements Encoder
{

    public ClientMetricDefaultEncoder()
    {
    }

    public void encode(ClientMetric clientmetric, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(clientmetric.getName(), dataoutputstream);
        boolean flag;
        if (clientmetric.getTime() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(clientmetric.getTime(), dataoutputstream);
        }
        if (clientmetric.getCount() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(clientmetric.getCount(), dataoutputstream);
        }
        if (clientmetric.getSize() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(clientmetric.getSize(), dataoutputstream);
        }
        if (clientmetric.getInfo() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(clientmetric.getInfo(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((ClientMetric)obj, dataoutputstream);
    }
}
