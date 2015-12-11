// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.IdentifyUserWithSisResponse;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener

public class IdentifyUserWithSisResponseDefaultDecoder
    implements Decoder
{

    public IdentifyUserWithSisResponseDefaultDecoder()
    {
    }

    public IdentifyUserWithSisResponse decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new IdentifyUserWithSisResponse();
        streamedresponselistener.setCalledSisSuccessfully(((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null)).booleanValue());
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
