// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.Date;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener

public class DateDefaultDecoder
    implements Decoder
{

    public DateDefaultDecoder()
    {
    }

    public Date decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new Date();
        streamedresponselistener.setYear(((Integer)DefaultDecoder.getIntegerInstance(1800L, 2055L).decode(datainputstream, null)).intValue());
        streamedresponselistener.setMonth(((Integer)DefaultDecoder.getIntegerInstance(1L, 12L).decode(datainputstream, null)).intValue());
        streamedresponselistener.setDay(((Integer)DefaultDecoder.getIntegerInstance(1L, 31L).decode(datainputstream, null)).intValue());
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
