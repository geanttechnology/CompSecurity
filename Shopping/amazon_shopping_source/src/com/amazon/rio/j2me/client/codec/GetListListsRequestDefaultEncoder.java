// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.GetListListsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class GetListListsRequestDefaultEncoder
    implements Encoder
{

    public GetListListsRequestDefaultEncoder()
    {
    }

    public void encode(GetListListsRequest getlistlistsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(getlistlistsrequest.getRegType(), dataoutputstream);
        boolean flag;
        if (getlistlistsrequest.getSubtype() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getEnumInstance(2).encode(getlistlistsrequest.getSubtype(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((GetListListsRequest)obj, dataoutputstream);
    }
}
