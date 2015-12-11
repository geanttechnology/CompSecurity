// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.OfferListing;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, BasicOfferListingDefaultDecoder, PrimeOneClickShippingOffersDefaultDecoder, ExtraOfferListingDefaultDecoder, 
//            StreamedResponseListener

public class OfferListingDefaultDecoder
    implements Decoder
{

    public OfferListingDefaultDecoder()
    {
    }

    public OfferListing decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new OfferListing();
        streamedresponselistener.setBasicOffer((new BasicOfferListingDefaultDecoder()).decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPrimeOneClickShippingOffers((new PrimeOneClickShippingOffersDefaultDecoder()).decode(datainputstream, null));
        }
        streamedresponselistener.setExtraOffer((new ExtraOfferListingDefaultDecoder()).decode(datainputstream, null));
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
