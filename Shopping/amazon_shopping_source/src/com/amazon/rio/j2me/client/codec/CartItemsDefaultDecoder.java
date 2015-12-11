// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.CartItems;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, CartItemDefaultDecoder, DefaultDecoder, RichMessageDefaultDecoder, 
//            UniversalLinkDefaultDecoder, ButtonInfoDefaultDecoder, InterstitialCartItemsInfoDefaultDecoder, StreamedResponseListener

public class CartItemsDefaultDecoder
    implements Decoder
{

    public CartItemsDefaultDecoder()
    {
    }

    public CartItems decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new CartItems();
        streamedresponselistener.setCartItem((List)DefaultDecoder.getArrayInstance(new CartItemDefaultDecoder()).decode(datainputstream, null));
        streamedresponselistener.setSubtotal((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setMessages((List)DefaultDecoder.getArrayInstance(DefaultDecoder.getStringInstance()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAlertMessages((List)DefaultDecoder.getArrayInstance(new RichMessageDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAlertMessagesDetailed((List)DefaultDecoder.getArrayInstance(new RichMessageDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPointsTotal((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setCartButtonUri((new UniversalLinkDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAlternateCartButton((new ButtonInfoDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setInterstitialCartInfo((new InterstitialCartItemsInfoDefaultDecoder()).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
