// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener

static final class val.upperBound
    implements Decoder
{

    final long val$lowerBound;
    final long val$upperBound;

    public Integer decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return Integer.valueOf((int)DefaultDecoder.access$000(val$lowerBound, val$upperBound, datainputstream));
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }

    istener(long l, long l1)
    {
        val$lowerBound = l;
        val$upperBound = l1;
        super();
    }
}
