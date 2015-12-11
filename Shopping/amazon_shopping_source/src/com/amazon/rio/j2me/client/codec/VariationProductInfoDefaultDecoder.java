// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.VariationProductInfo;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, OffersSummaryDefaultDecoder, BasicOfferListingDefaultDecoder, 
//            StreamedResponseListener

public class VariationProductInfoDefaultDecoder
    implements Decoder
{

    public VariationProductInfoDefaultDecoder()
    {
    }

    public VariationProductInfo decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new VariationProductInfo();
        streamedresponselistener.setAsin((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setVariationAttributes((List)DefaultDecoder.getArrayInstance(DefaultDecoder.getIntegerInstance(-1L, 254L)).decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setOffersSummary((new OffersSummaryDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setListPrice((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        streamedresponselistener.setImagesCount(((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null)).intValue());
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBasicOffer((new BasicOfferListingDefaultDecoder()).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
