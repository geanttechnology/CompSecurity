// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, SearchResultDefaultDecoder, DefaultDecoder, StreamedResponseListener

public class BasicProductsResponseDefaultDecoder
    implements Decoder
{

    public BasicProductsResponseDefaultDecoder()
    {
    }

    public BasicProductsResponse decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new BasicProductsResponse();
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setProducts((List)DefaultDecoder.getArrayInstance(new SearchResultDefaultDecoder()).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
