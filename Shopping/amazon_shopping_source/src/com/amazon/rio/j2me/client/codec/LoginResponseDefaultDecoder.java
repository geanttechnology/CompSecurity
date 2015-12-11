// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.LoginResponse;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, LoginDataDefaultDecoder, NotificationDefaultDecoder, StreamedResponseListener

public class LoginResponseDefaultDecoder
    implements Decoder
{

    public LoginResponseDefaultDecoder()
    {
    }

    public LoginResponse decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new LoginResponse();
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setLoginData((new LoginDataDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setNotification((new NotificationDefaultDecoder()).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
