// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.LoginData;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, PrimeOneClickStatusDefaultDecoder, DefaultDecoder, DateDefaultDecoder, 
//            StreamedResponseListener

public class LoginDataDefaultDecoder
    implements Decoder
{

    public LoginDataDefaultDecoder()
    {
    }

    public LoginData decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new LoginData();
        streamedresponselistener.setPrimeOneClickStatus((new PrimeOneClickStatusDefaultDecoder()).decode(datainputstream, null));
        streamedresponselistener.setFullName((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setGivenName((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setDob((new DateDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setIsPrimeFunnelEligible((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPrimeFunnelUrl((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
