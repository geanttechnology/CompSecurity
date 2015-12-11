// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, MerchantInfoDefaultDecoder, HyperTextDefaultDecoder, 
//            ShippingOfferDefaultDecoder, SpecialOfferDefaultDecoder, PricePerUnitDefaultDecoder, BadgeInfoDefaultDecoder, 
//            StreamedResponseListener

public class BasicOfferListingDefaultDecoder
    implements Decoder
{

    public BasicOfferListingDefaultDecoder()
    {
    }

    public BasicOfferListing decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new BasicOfferListing();
        streamedresponselistener.setOfferId((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setMerchantInfo((new MerchantInfoDefaultDecoder()).decode(datainputstream, null));
        streamedresponselistener.setCondition((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setConditionType((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setPrice((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPriceMessage((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        streamedresponselistener.setPriceViolatesMap(((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null)).booleanValue());
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPriceSavings((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPercentSavings((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        streamedresponselistener.setGiftWrapAvailable(((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null)).booleanValue());
        streamedresponselistener.setEligibleForSuperSaverShipping(((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null)).booleanValue());
        streamedresponselistener.setDeprecatedEligibleForPrimeShipping(((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null)).booleanValue());
        streamedresponselistener.setAvailabilityCondition(((Integer)DefaultDecoder.getEnumInstance(3).decode(datainputstream, null)).intValue());
        streamedresponselistener.setAvailabilityMessages((List)DefaultDecoder.getArrayInstance(new HyperTextDefaultDecoder()).decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setShippingOffer((new ShippingOfferDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setSpecialOffer((new SpecialOfferDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setFulfilledBy((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPoints((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPricePerUnit((new PricePerUnitDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBadgeInfo((new BadgeInfoDefaultDecoder()).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
