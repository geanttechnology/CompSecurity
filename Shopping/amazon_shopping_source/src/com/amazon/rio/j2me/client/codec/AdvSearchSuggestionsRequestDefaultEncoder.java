// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.AdvSearchSuggestionsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class AdvSearchSuggestionsRequestDefaultEncoder
    implements Encoder
{

    public AdvSearchSuggestionsRequestDefaultEncoder()
    {
    }

    public void encode(AdvSearchSuggestionsRequest advsearchsuggestionsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(advsearchsuggestionsrequest.getQuery(), dataoutputstream);
        boolean flag;
        if (advsearchsuggestionsrequest.getFilters() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(advsearchsuggestionsrequest.getFilters(), dataoutputstream);
        }
        if (advsearchsuggestionsrequest.getToggleRefinements() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getArrayInstance(DefaultEncoder.getStringInstance()).encode(advsearchsuggestionsrequest.getToggleRefinements(), dataoutputstream);
        }
        if (advsearchsuggestionsrequest.getMaxSuggestions() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(advsearchsuggestionsrequest.getMaxSuggestions(), dataoutputstream);
        }
        if (advsearchsuggestionsrequest.getMaxDepartments() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(advsearchsuggestionsrequest.getMaxDepartments(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((AdvSearchSuggestionsRequest)obj, dataoutputstream);
    }
}
