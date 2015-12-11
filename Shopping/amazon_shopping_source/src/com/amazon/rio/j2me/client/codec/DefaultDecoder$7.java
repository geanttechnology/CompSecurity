// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener

static final class val.elementDecoder
    implements Decoder
{

    final Decoder val$elementDecoder;

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }

    public List decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        int j = datainputstream.readInt();
        ArrayList arraylist;
        int ai[];
        int i;
        if (streamedresponselistener == null)
        {
            arraylist = new ArrayList(j);
        } else
        {
            arraylist = null;
        }
        if (streamedresponselistener != null)
        {
            ai = new int[1];
        } else
        {
            ai = null;
        }
        if (streamedresponselistener != null)
        {
            streamedresponselistener.aboutToReceiveArrayOfSize(j, DefaultDecoder.access$100());
        }
        i = 0;
        while (i < j) 
        {
            Object obj = val$elementDecoder.decode(datainputstream, null);
            if (streamedresponselistener == null)
            {
                arraylist.add(obj);
            } else
            {
                ai[0] = i;
                streamedresponselistener.receivedObject(obj, ai);
            }
            i++;
        }
        if (streamedresponselistener != null)
        {
            streamedresponselistener.receivedObject(arraylist, DefaultDecoder.access$100());
        }
        return arraylist;
    }

    istener(Decoder decoder)
    {
        val$elementDecoder = decoder;
        super();
    }
}
