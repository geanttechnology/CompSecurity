// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.KiangUpdateRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, KiangSecurityDefaultEncoder, KiangApplicationStateDefaultEncoder

public class KiangUpdateRequestDefaultEncoder
    implements Encoder
{

    public KiangUpdateRequestDefaultEncoder()
    {
    }

    public void encode(KiangUpdateRequest kiangupdaterequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (kiangupdaterequest.getSecurity() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new KiangSecurityDefaultEncoder()).encode(kiangupdaterequest.getSecurity(), dataoutputstream);
        }
        (new KiangApplicationStateDefaultEncoder()).encode(kiangupdaterequest.getApplicationState(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((KiangUpdateRequest)obj, dataoutputstream);
    }
}
