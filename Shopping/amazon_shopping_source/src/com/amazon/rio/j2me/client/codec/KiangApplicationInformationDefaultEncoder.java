// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.KiangApplicationInformation;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, KiangDeviceUniqueIdDefaultEncoder

public class KiangApplicationInformationDefaultEncoder
    implements Encoder
{

    public KiangApplicationInformationDefaultEncoder()
    {
    }

    public void encode(KiangApplicationInformation kiangapplicationinformation, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(kiangapplicationinformation.getUbid(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(kiangapplicationinformation.getHardwareIdentifier(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(kiangapplicationinformation.getOsIdentifier(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(kiangapplicationinformation.getOsVersion(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(kiangapplicationinformation.getApplicationIdentifier(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(kiangapplicationinformation.getApplicationVersion(), dataoutputstream);
        boolean flag;
        if (kiangapplicationinformation.getAssociateTag() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(kiangapplicationinformation.getAssociateTag(), dataoutputstream);
        }
        (new KiangDeviceUniqueIdDefaultEncoder()).encode(kiangapplicationinformation.getDeviceUniqueId(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((KiangApplicationInformation)obj, dataoutputstream);
    }
}
