// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.CartItem;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, MerchantInfoDefaultDecoder, BadgeDefaultDecoder, 
//            StreamedResponseListener

public class CartItemDefaultDecoder
    implements Decoder
{

    public CartItemDefaultDecoder()
    {
    }

    public CartItem decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new CartItem();
        streamedresponselistener.setItemId((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setOfferId((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setAsin((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setTitle((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setShortDescription((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        streamedresponselistener.setPrice((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setQuantity(((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null)).intValue());
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setMessages((List)DefaultDecoder.getArrayInstance(DefaultDecoder.getStringInstance()).decode(datainputstream, null));
        }
        streamedresponselistener.setIsSavedItem(((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null)).booleanValue());
        streamedresponselistener.setIsQuantityEditable(((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null)).booleanValue());
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPoints((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setMsToExpiry((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setImageUrl((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setByLine((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setShippingCharge((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setDeprecatedEligibleForPrimeShipping((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setEligibleForSuperSaverShipping((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBinding((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setMerchantInfo((new MerchantInfoDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBadge((new BadgeDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setIsMinimumThresholdRequired((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
