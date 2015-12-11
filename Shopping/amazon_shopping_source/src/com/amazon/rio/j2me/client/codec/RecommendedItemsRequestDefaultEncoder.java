// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.RecommendedItemsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class RecommendedItemsRequestDefaultEncoder
    implements Encoder
{

    public RecommendedItemsRequestDefaultEncoder()
    {
    }

    public void encode(RecommendedItemsRequest recommendeditemsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(recommendeditemsrequest.getMaxImageDimension()), dataoutputstream);
        boolean flag;
        if (recommendeditemsrequest.getCategory() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(recommendeditemsrequest.getCategory(), dataoutputstream);
        }
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(recommendeditemsrequest.getStartOffset()), dataoutputstream);
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(recommendeditemsrequest.getCount()), dataoutputstream);
        if (recommendeditemsrequest.getContext() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(recommendeditemsrequest.getContext(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((RecommendedItemsRequest)obj, dataoutputstream);
    }
}
