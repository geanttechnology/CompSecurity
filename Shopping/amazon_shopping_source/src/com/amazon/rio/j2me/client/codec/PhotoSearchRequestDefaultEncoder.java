// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.PhotoSearchRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class PhotoSearchRequestDefaultEncoder
    implements Encoder
{

    public PhotoSearchRequestDefaultEncoder()
    {
    }

    public void encode(PhotoSearchRequest photosearchrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getOctetArrayInstance().encode(photosearchrequest.getImage(), dataoutputstream);
        boolean flag;
        if (photosearchrequest.getIncludeAddOnItems() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(photosearchrequest.getIncludeAddOnItems(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((PhotoSearchRequest)obj, dataoutputstream);
    }
}
