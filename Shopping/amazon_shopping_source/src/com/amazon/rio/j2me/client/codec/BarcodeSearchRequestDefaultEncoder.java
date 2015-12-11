// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.BarcodeSearchRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class BarcodeSearchRequestDefaultEncoder
    implements Encoder
{

    public BarcodeSearchRequestDefaultEncoder()
    {
    }

    public void encode(BarcodeSearchRequest barcodesearchrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(barcodesearchrequest.getBarcode(), dataoutputstream);
        boolean flag;
        if (barcodesearchrequest.getBarcodeType() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(barcodesearchrequest.getBarcodeType(), dataoutputstream);
        }
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(barcodesearchrequest.getSize()), dataoutputstream);
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(barcodesearchrequest.getMaxImageDimension()), dataoutputstream);
        if (barcodesearchrequest.getClickStreamOrigin() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(barcodesearchrequest.getClickStreamOrigin(), dataoutputstream);
        }
        if (barcodesearchrequest.getIncludeAddOnItems() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(barcodesearchrequest.getIncludeAddOnItems(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((BarcodeSearchRequest)obj, dataoutputstream);
    }
}
