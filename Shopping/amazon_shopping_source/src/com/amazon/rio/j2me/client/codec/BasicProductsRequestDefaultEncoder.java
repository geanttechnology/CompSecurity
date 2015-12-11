// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.BasicProductsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class BasicProductsRequestDefaultEncoder
    implements Encoder
{

    public BasicProductsRequestDefaultEncoder()
    {
    }

    public void encode(BasicProductsRequest basicproductsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getArrayInstance(DefaultEncoder.getStringInstance()).encode(basicproductsrequest.getAsins(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((BasicProductsRequest)obj, dataoutputstream);
    }
}
