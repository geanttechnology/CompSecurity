// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.CategoryResult;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener

public class CategoryResultDefaultDecoder
    implements Decoder
{

    public CategoryResultDefaultDecoder()
    {
    }

    public CategoryResult decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new CategoryResult();
        streamedresponselistener.setCategory((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setDisplayName((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setResultCount(((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null)).intValue());
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setParent((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
