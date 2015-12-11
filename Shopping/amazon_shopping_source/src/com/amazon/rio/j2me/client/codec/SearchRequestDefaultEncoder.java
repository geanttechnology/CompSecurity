// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.SearchRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, QueryDescriptorDefaultEncoder

public class SearchRequestDefaultEncoder
    implements Encoder
{

    public SearchRequestDefaultEncoder()
    {
    }

    public void encode(SearchRequest searchrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (searchrequest.getQuery() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(searchrequest.getQuery(), dataoutputstream);
        }
        if (searchrequest.getCategoryRefinements() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getArrayInstance(DefaultEncoder.getStringInstance()).encode(searchrequest.getCategoryRefinements(), dataoutputstream);
        }
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(searchrequest.getPage()), dataoutputstream);
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(searchrequest.getSize()), dataoutputstream);
        DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(new Integer(searchrequest.getMaxImageDimension()), dataoutputstream);
        if (searchrequest.getReturnRefinements() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(searchrequest.getReturnRefinements(), dataoutputstream);
        }
        if (searchrequest.getQueryDescriptor() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new QueryDescriptorDefaultEncoder()).encode(searchrequest.getQueryDescriptor(), dataoutputstream);
        }
        if (searchrequest.getClickStreamOrigin() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(searchrequest.getClickStreamOrigin(), dataoutputstream);
        }
        if (searchrequest.getIncludeAddOnItems() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(searchrequest.getIncludeAddOnItems(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((SearchRequest)obj, dataoutputstream);
    }
}
