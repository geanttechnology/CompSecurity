// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.RecsRating;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class RecsRatingDefaultEncoder
    implements Encoder
{

    public RecsRatingDefaultEncoder()
    {
    }

    public void encode(RecsRating recsrating, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(recsrating.getAsin(), dataoutputstream);
        DefaultEncoder.getEnumInstance(5).encode(new Integer(recsrating.getType()), dataoutputstream);
        boolean flag;
        if (recsrating.getNumber() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(recsrating.getNumber(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((RecsRating)obj, dataoutputstream);
    }
}
