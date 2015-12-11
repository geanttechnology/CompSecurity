// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.BuyAsinRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class BuyAsinRequestDefaultEncoder
    implements Encoder
{

    public BuyAsinRequestDefaultEncoder()
    {
    }

    public void encode(BuyAsinRequest buyasinrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(buyasinrequest.getAsin(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(buyasinrequest.getOfferId(), dataoutputstream);
        boolean flag;
        if (buyasinrequest.getListId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(buyasinrequest.getListId(), dataoutputstream);
        }
        if (buyasinrequest.getListItemId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(buyasinrequest.getListItemId(), dataoutputstream);
        }
        if (buyasinrequest.getDealId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(buyasinrequest.getDealId(), dataoutputstream);
        }
        if (buyasinrequest.getOneClickShippingSpeed() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(buyasinrequest.getOneClickShippingSpeed(), dataoutputstream);
        }
        DefaultEncoder.getStringInstance().encode(buyasinrequest.getClickStreamOrigin(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((BuyAsinRequest)obj, dataoutputstream);
    }
}
