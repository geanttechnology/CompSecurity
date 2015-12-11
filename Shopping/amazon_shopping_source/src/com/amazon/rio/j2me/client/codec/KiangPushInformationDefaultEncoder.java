// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.KiangPushInformation;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class KiangPushInformationDefaultEncoder
    implements Encoder
{

    public KiangPushInformationDefaultEncoder()
    {
    }

    public void encode(KiangPushInformation kiangpushinformation, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(kiangpushinformation.getProvider(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(kiangpushinformation.getSecret(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((KiangPushInformation)obj, dataoutputstream);
    }
}
