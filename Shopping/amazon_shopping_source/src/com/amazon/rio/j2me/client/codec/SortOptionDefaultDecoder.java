// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.SortOption;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener

public class SortOptionDefaultDecoder
    implements Decoder
{

    public SortOptionDefaultDecoder()
    {
    }

    public SortOption decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new SortOption();
        streamedresponselistener.setSortId((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setName((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
