// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.AddListItemsResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, ListListDefaultDecoder, ListItemDefaultDecoder, DefaultDecoder, 
//            StreamedResponseListener

public class AddListItemsResponseDefaultDecoder
    implements Decoder
{

    public AddListItemsResponseDefaultDecoder()
    {
    }

    public AddListItemsResponse decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new AddListItemsResponse();
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAffectedRegistry((new ListListDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAddedItems((List)DefaultDecoder.getArrayInstance(new ListItemDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setErrorCode((Integer)DefaultDecoder.getEnumInstance(2).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
