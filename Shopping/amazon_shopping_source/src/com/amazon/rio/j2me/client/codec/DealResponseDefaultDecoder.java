// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DealDefaultDecoder, StreamedResponseListener

public class DealResponseDefaultDecoder
    implements Decoder
{

    public DealResponseDefaultDecoder()
    {
    }

    public Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        int ai[] = new int[1];
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.receivedObject((new DealDefaultDecoder()).decode(datainputstream, null), ai);
        }
        ai[0] = ai[0] + 1;
        streamedresponselistener.receivedObject(null, new int[0]);
        return null;
    }
}
