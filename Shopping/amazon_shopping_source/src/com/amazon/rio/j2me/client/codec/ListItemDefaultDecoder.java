// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.ListItem;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, BasicProductInfoDefaultDecoder, BasicOfferListingDefaultDecoder, 
//            StreamedResponseListener

public class ListItemDefaultDecoder
    implements Decoder
{

    public ListItemDefaultDecoder()
    {
    }

    public ListItem decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new ListItem();
        streamedresponselistener.setListItemId((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setTitle((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPrice((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setSiteDomain((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setProductUrl((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPriority((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setDesired((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setReceived((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setComment((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setDataAdded((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setImageUrl((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBasicProduct((new BasicProductInfoDefaultDecoder()).decode(datainputstream, null));
        }
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
