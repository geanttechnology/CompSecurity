// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.IdentifyUserWithSisRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, KeyValuePairDefaultEncoder, DefaultEncoder

public class IdentifyUserWithSisRequestDefaultEncoder
    implements Encoder
{

    public IdentifyUserWithSisRequestDefaultEncoder()
    {
    }

    public void encode(IdentifyUserWithSisRequest identifyuserwithsisrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getArrayInstance(new KeyValuePairDefaultEncoder()).encode(identifyuserwithsisrequest.getDeviceInfo(), dataoutputstream);
        boolean flag;
        if (identifyuserwithsisrequest.getDeviceNativeData() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getArrayInstance(new KeyValuePairDefaultEncoder()).encode(identifyuserwithsisrequest.getDeviceNativeData(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((IdentifyUserWithSisRequest)obj, dataoutputstream);
    }
}
