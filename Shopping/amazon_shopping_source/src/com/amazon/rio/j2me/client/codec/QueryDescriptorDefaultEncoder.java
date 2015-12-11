// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.QueryDescriptor;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class QueryDescriptorDefaultEncoder
    implements Encoder
{

    public QueryDescriptorDefaultEncoder()
    {
    }

    public void encode(QueryDescriptor querydescriptor, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(querydescriptor.getQueryType(), dataoutputstream);
        DefaultEncoder.getArrayInstance(DefaultEncoder.getStringInstance()).encode(querydescriptor.getQueryData(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((QueryDescriptor)obj, dataoutputstream);
    }
}
