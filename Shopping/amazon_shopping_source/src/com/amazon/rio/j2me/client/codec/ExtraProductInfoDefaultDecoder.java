// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.ExtraProductInfo;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, CustomerReviewsInfoDefaultDecoder, KeyValuePairDefaultDecoder, DefaultDecoder, 
//            ConditionalOffersSummaryDefaultDecoder, OfferListingDefaultDecoder, HyperTextDefaultDecoder, ProductWarningDefaultDecoder, 
//            SimilarItemsResponseDefaultDecoder, VideoClipDefaultDecoder, DiscListingDefaultDecoder, StreamedResponseListener

public class ExtraProductInfoDefaultDecoder
    implements Decoder
{

    public ExtraProductInfoDefaultDecoder()
    {
    }

    public ExtraProductInfo decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new ExtraProductInfo();
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setCustomerReviewsInfo((new CustomerReviewsInfoDefaultDecoder()).decode(datainputstream, null));
        }
        streamedresponselistener.setDetails((List)DefaultDecoder.getArrayInstance(new KeyValuePairDefaultDecoder()).decode(datainputstream, null));
        streamedresponselistener.setDescs((List)DefaultDecoder.getArrayInstance(new KeyValuePairDefaultDecoder()).decode(datainputstream, null));
        streamedresponselistener.setOfferListSummaries((List)DefaultDecoder.getArrayInstance(new ConditionalOffersSummaryDefaultDecoder()).decode(datainputstream, null));
        streamedresponselistener.setOffers((List)DefaultDecoder.getArrayInstance(new OfferListingDefaultDecoder()).decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setProductMessages((List)DefaultDecoder.getArrayInstance(new HyperTextDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setProductWarnings((List)DefaultDecoder.getArrayInstance(new ProductWarningDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setSimilarItems((new SimilarItemsResponseDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setVideoClips((List)DefaultDecoder.getArrayInstance(new VideoClipDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setTrackListings((List)DefaultDecoder.getArrayInstance(new DiscListingDefaultDecoder()).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
