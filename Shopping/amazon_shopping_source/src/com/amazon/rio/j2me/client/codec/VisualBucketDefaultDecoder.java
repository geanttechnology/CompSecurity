// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.VisualBucket;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener

public class VisualBucketDefaultDecoder
    implements Decoder
{

    public VisualBucketDefaultDecoder()
    {
    }

    public VisualBucket decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new VisualBucket();
        streamedresponselistener.setAttributes((List)DefaultDecoder.getArrayInstance(DefaultDecoder.getIntegerInstance(-1L, 254L)).decode(datainputstream, null));
        streamedresponselistener.setSameAsBucket((List)DefaultDecoder.getArrayInstance(DefaultDecoder.getIntegerInstance(-1L, 254L)).decode(datainputstream, null));
        streamedresponselistener.setBestImage((byte[])DefaultDecoder.getOctetArrayInstance().decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBestImageUrl((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
