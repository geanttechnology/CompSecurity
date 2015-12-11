// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.KiangRegisterRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, KiangApplicationInformationDefaultEncoder, KiangApplicationInstanceInformationDefaultEncoder, KiangPushInformationDefaultEncoder

public class KiangRegisterRequestDefaultEncoder
    implements Encoder
{

    public KiangRegisterRequestDefaultEncoder()
    {
    }

    public void encode(KiangRegisterRequest kiangregisterrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        (new KiangApplicationInformationDefaultEncoder()).encode(kiangregisterrequest.getApplicationInformation(), dataoutputstream);
        (new KiangApplicationInstanceInformationDefaultEncoder()).encode(kiangregisterrequest.getApplicationInstanceInformation(), dataoutputstream);
        boolean flag;
        if (kiangregisterrequest.getPushInformation() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new KiangPushInformationDefaultEncoder()).encode(kiangregisterrequest.getPushInformation(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((KiangRegisterRequest)obj, dataoutputstream);
    }
}
