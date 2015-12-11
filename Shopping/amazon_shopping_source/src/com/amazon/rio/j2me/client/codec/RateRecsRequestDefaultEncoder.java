// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.RateRecsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, RecsRatingDefaultEncoder, DefaultEncoder

public class RateRecsRequestDefaultEncoder
    implements Encoder
{

    public RateRecsRequestDefaultEncoder()
    {
    }

    public void encode(RateRecsRequest raterecsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (raterecsrequest.getDeletions() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getArrayInstance(new RecsRatingDefaultEncoder()).encode(raterecsrequest.getDeletions(), dataoutputstream);
        }
        if (raterecsrequest.getAdditions() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getArrayInstance(new RecsRatingDefaultEncoder()).encode(raterecsrequest.getAdditions(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((RateRecsRequest)obj, dataoutputstream);
    }
}
