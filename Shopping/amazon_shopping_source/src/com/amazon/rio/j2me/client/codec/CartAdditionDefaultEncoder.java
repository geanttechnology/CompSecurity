// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.CartAddition;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class CartAdditionDefaultEncoder
    implements Encoder
{

    public CartAdditionDefaultEncoder()
    {
    }

    public void encode(CartAddition cartaddition, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(cartaddition.getOfferId(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(cartaddition.getAsin(), dataoutputstream);
        Encoder encoder;
        boolean flag;
        if (cartaddition.getListId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(cartaddition.getListId(), dataoutputstream);
        }
        if (cartaddition.getListItemId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(cartaddition.getListItemId(), dataoutputstream);
        }
        if (cartaddition.getDealId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(cartaddition.getDealId(), dataoutputstream);
        }
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(cartaddition.getQuantity()), dataoutputstream);
        encoder = DefaultEncoder.getBooleanInstance();
        if (cartaddition.getIsSavedItem())
        {
            cartaddition = Boolean.TRUE;
        } else
        {
            cartaddition = Boolean.FALSE;
        }
        encoder.encode(cartaddition, dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((CartAddition)obj, dataoutputstream);
    }
}
