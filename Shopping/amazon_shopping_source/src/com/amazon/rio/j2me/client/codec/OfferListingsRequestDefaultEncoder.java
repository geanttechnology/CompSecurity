// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.OfferListingsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class OfferListingsRequestDefaultEncoder
    implements Encoder
{

    public OfferListingsRequestDefaultEncoder()
    {
    }

    public void encode(OfferListingsRequest offerlistingsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(offerlistingsrequest.getAsin(), dataoutputstream);
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(offerlistingsrequest.getPage()), dataoutputstream);
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(offerlistingsrequest.getSize()), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(offerlistingsrequest.getConditionType(), dataoutputstream);
        boolean flag;
        if (offerlistingsrequest.getSort() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(offerlistingsrequest.getSort(), dataoutputstream);
        }
        if (offerlistingsrequest.getProductGroupId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(offerlistingsrequest.getProductGroupId(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((OfferListingsRequest)obj, dataoutputstream);
    }
}
