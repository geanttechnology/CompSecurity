// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.OneClickConfigResponse;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, AddressDefaultDecoder, PaymentMethodDefaultDecoder, 
//            StreamedResponseListener

public class OneClickConfigResponseDefaultDecoder
    implements Decoder
{

    public OneClickConfigResponseDefaultDecoder()
    {
    }

    public OneClickConfigResponse decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new OneClickConfigResponse();
        streamedresponselistener.setOneClickStatus(((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null)).booleanValue());
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setDeviceName((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAddress((new AddressDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPaymentMethod((new PaymentMethodDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setShippingSpeed((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
