// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.DealRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class DealRequestDefaultEncoder
    implements Encoder
{

    public DealRequestDefaultEncoder()
    {
    }

    public void encode(DealRequest dealrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (dealrequest.getDealId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(dealrequest.getDealId(), dataoutputstream);
        }
        if (dealrequest.getAsin() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(dealrequest.getAsin(), dataoutputstream);
        }
        if (dealrequest.getShowVariations() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(dealrequest.getShowVariations(), dataoutputstream);
        }
        if (dealrequest.getMaxSwatchDimension() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(dealrequest.getMaxSwatchDimension(), dataoutputstream);
        }
        if (dealrequest.getMaxImageDimension() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(dealrequest.getMaxImageDimension(), dataoutputstream);
        }
        if (dealrequest.getNoPrefetchChildren() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(dealrequest.getNoPrefetchChildren(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((DealRequest)obj, dataoutputstream);
    }
}
