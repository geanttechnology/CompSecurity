// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickStatus;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener

public class PrimeOneClickStatusDefaultDecoder
    implements Decoder
{

    public PrimeOneClickStatusDefaultDecoder()
    {
    }

    public PrimeOneClickStatus decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new PrimeOneClickStatus();
        streamedresponselistener.setIsPrime(((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null)).booleanValue());
        streamedresponselistener.setIsOneClickEnabled(((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null)).booleanValue());
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
