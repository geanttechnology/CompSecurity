// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.OneClickAddress;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, AddressDefaultDecoder, PaymentMethodDefaultDecoder, DefaultDecoder, 
//            StreamedResponseListener

public class OneClickAddressDefaultDecoder
    implements Decoder
{

    public OneClickAddressDefaultDecoder()
    {
    }

    public OneClickAddress decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new OneClickAddress();
        streamedresponselistener.setAddress((new AddressDefaultDecoder()).decode(datainputstream, null));
        streamedresponselistener.setPaymentMethod((List)DefaultDecoder.getArrayInstance(new PaymentMethodDefaultDecoder()).decode(datainputstream, null));
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
