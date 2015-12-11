// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.KiangSecurity;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class KiangSecurityDefaultEncoder
    implements Encoder
{

    public KiangSecurityDefaultEncoder()
    {
    }

    public void encode(KiangSecurity kiangsecurity, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(kiangsecurity.getNonce(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(kiangsecurity.getSigningAlgorithm(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(kiangsecurity.getCorpusAlgorithm(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(kiangsecurity.getSignature(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((KiangSecurity)obj, dataoutputstream);
    }
}
