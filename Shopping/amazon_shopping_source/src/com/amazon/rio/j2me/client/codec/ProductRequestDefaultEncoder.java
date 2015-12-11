// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.ProductRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class ProductRequestDefaultEncoder
    implements Encoder
{

    public ProductRequestDefaultEncoder()
    {
    }

    public void encode(ProductRequest productrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(productrequest.getAsin(), dataoutputstream);
        Boolean boolean1;
        Encoder encoder;
        boolean flag;
        if (productrequest.getOfferId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(productrequest.getOfferId(), dataoutputstream);
        }
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(productrequest.getMaxImageDimension()), dataoutputstream);
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(productrequest.getReviewsCount()), dataoutputstream);
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(productrequest.getOfferListingsCount()), dataoutputstream);
        if (productrequest.getVariationsModelOverride() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getEnumInstance(2).encode(productrequest.getVariationsModelOverride(), dataoutputstream);
        }
        encoder = DefaultEncoder.getBooleanInstance();
        if (productrequest.getVariationChild())
        {
            boolean1 = Boolean.TRUE;
        } else
        {
            boolean1 = Boolean.FALSE;
        }
        encoder.encode(boolean1, dataoutputstream);
        if (productrequest.getNoPrefetchChildren() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(productrequest.getNoPrefetchChildren(), dataoutputstream);
        }
        if (productrequest.getExcludeImage() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(productrequest.getExcludeImage(), dataoutputstream);
        }
        if (productrequest.getMaxSwatchDimension() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(productrequest.getMaxSwatchDimension(), dataoutputstream);
        }
        DefaultEncoder.getStringInstance().encode(productrequest.getClickStreamOrigin(), dataoutputstream);
        if (productrequest.getSimsCount() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(productrequest.getSimsCount(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((ProductRequest)obj, dataoutputstream);
    }
}
