// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.TextAttributes;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener

public class TextAttributesDefaultDecoder
    implements Decoder
{

    public TextAttributesDefaultDecoder()
    {
    }

    public TextAttributes decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new TextAttributes();
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setSize((Integer)DefaultDecoder.getEnumInstance(3).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setStyle((Integer)DefaultDecoder.getEnumInstance(2).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setColor((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setLinkUrl((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAllowTruncation((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
