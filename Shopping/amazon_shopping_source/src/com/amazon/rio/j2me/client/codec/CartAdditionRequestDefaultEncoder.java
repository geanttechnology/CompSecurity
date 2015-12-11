// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.CartAdditionRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, CartAdditionDefaultEncoder, DefaultEncoder

public class CartAdditionRequestDefaultEncoder
    implements Encoder
{

    public CartAdditionRequestDefaultEncoder()
    {
    }

    public void encode(CartAdditionRequest cartadditionrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getArrayInstance(new CartAdditionDefaultEncoder()).encode(cartadditionrequest.getAdditions(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(cartadditionrequest.getClickStreamOrigin(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((CartAdditionRequest)obj, dataoutputstream);
    }
}
