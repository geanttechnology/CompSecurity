// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.KeyValuePair;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class KeyValuePairDefaultEncoder
    implements Encoder
{

    public KeyValuePairDefaultEncoder()
    {
    }

    public void encode(KeyValuePair keyvaluepair, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(keyvaluepair.getKey(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(keyvaluepair.getValue(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((KeyValuePair)obj, dataoutputstream);
    }
}
