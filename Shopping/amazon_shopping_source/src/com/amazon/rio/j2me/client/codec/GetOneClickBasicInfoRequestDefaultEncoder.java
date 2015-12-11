// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.GetOneClickBasicInfoRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder

public class GetOneClickBasicInfoRequestDefaultEncoder
    implements Encoder
{

    public GetOneClickBasicInfoRequestDefaultEncoder()
    {
    }

    public void encode(GetOneClickBasicInfoRequest getoneclickbasicinforequest, DataOutputStream dataoutputstream)
        throws IOException
    {
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((GetOneClickBasicInfoRequest)obj, dataoutputstream);
    }
}
