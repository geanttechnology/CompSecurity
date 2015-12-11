// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.SetOneClickConfigRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class SetOneClickConfigRequestDefaultEncoder
    implements Encoder
{

    public SetOneClickConfigRequestDefaultEncoder()
    {
    }

    public void encode(SetOneClickConfigRequest setoneclickconfigrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (setoneclickconfigrequest.getDeviceName() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(setoneclickconfigrequest.getDeviceName(), dataoutputstream);
        }
        if (setoneclickconfigrequest.getAddressId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(setoneclickconfigrequest.getAddressId(), dataoutputstream);
        }
        if (setoneclickconfigrequest.getPaymentId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(setoneclickconfigrequest.getPaymentId(), dataoutputstream);
        }
        if (setoneclickconfigrequest.getOneClickStatus() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(setoneclickconfigrequest.getOneClickStatus(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((SetOneClickConfigRequest)obj, dataoutputstream);
    }
}
