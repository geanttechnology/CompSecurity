// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.KiangApplicationState;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, KiangApplicationInformationDefaultEncoder, KiangApplicationInstanceInformationDefaultEncoder, 
//            KiangPushInformationDefaultEncoder

public class KiangApplicationStateDefaultEncoder
    implements Encoder
{

    public KiangApplicationStateDefaultEncoder()
    {
    }

    public void encode(KiangApplicationState kiangapplicationstate, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(kiangapplicationstate.getApplicationInstallId(), dataoutputstream);
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(kiangapplicationstate.getSequenceNumber()), dataoutputstream);
        (new KiangApplicationInformationDefaultEncoder()).encode(kiangapplicationstate.getApplicationInformation(), dataoutputstream);
        (new KiangApplicationInstanceInformationDefaultEncoder()).encode(kiangapplicationstate.getApplicationInstanceInformation(), dataoutputstream);
        boolean flag;
        if (kiangapplicationstate.getPushInformation() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new KiangPushInformationDefaultEncoder()).encode(kiangapplicationstate.getPushInformation(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((KiangApplicationState)obj, dataoutputstream);
    }
}
