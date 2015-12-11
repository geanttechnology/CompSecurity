// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickShippingOffers;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, ShippingOfferDefaultDecoder, DefaultDecoder, StreamedResponseListener

public class PrimeOneClickShippingOffersDefaultDecoder
    implements Decoder
{

    public PrimeOneClickShippingOffersDefaultDecoder()
    {
    }

    public PrimeOneClickShippingOffers decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new PrimeOneClickShippingOffers();
        streamedresponselistener.setShippingOffers((List)DefaultDecoder.getArrayInstance(new ShippingOfferDefaultDecoder()).decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setNote((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
