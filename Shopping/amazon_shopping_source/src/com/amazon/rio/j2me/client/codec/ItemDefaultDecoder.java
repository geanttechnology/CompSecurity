// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.Item;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, MerchantInfoDefaultDecoder, StreamedResponseListener

public class ItemDefaultDecoder
    implements Decoder
{

    public ItemDefaultDecoder()
    {
    }

    public Item decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new Item();
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAsin((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setTitle((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setStatus((List)DefaultDecoder.getArrayInstance(DefaultDecoder.getStringInstance()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setItemId((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setLineItemId((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPrice((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        streamedresponselistener.setQuantity(((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null)).intValue());
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setMerchantInfo((new MerchantInfoDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setImageUrl((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBinding((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setByLine((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
