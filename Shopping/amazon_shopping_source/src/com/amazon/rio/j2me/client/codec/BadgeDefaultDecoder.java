// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.Badge;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, RichMessageDefaultDecoder, StreamedResponseListener

public class BadgeDefaultDecoder
    implements Decoder
{

    public BadgeDefaultDecoder()
    {
    }

    public Badge decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new Badge();
        streamedresponselistener.setType((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setMeta((new RichMessageDefaultDecoder()).decode(datainputstream, null));
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
