// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.LocaleRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class LocaleRequestDefaultEncoder
    implements Encoder
{

    public LocaleRequestDefaultEncoder()
    {
    }

    public void encode(LocaleRequest localerequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (localerequest.getCode() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(localerequest.getCode(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((LocaleRequest)obj, dataoutputstream);
    }
}
