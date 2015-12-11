// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.RichMessage;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, HyperTextDefaultDecoder, UniversalLinkDefaultDecoder, 
//            StreamedResponseListener

public class RichMessageDefaultDecoder
    implements Decoder
{

    public RichMessageDefaultDecoder()
    {
    }

    public RichMessage decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new RichMessage();
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setImageUrl((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        streamedresponselistener.setMessages((List)DefaultDecoder.getArrayInstance(new HyperTextDefaultDecoder()).decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setImageLink((new UniversalLinkDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBackgroundColor((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBorderColor((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
