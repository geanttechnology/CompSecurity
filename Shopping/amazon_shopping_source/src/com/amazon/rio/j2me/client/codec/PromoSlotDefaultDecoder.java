// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, HomeItemDefaultDecoder, DefaultDecoder, ActionDefaultDecoder, 
//            StreamedResponseListener

public class PromoSlotDefaultDecoder
    implements Decoder
{

    public PromoSlotDefaultDecoder()
    {
    }

    public PromoSlot decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new PromoSlot();
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setProduct((new HomeItemDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setProductHeader((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        streamedresponselistener.setAction((new ActionDefaultDecoder()).decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setClickStreamOrigin((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setImageUrl((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setSlotToken((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
