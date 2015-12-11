// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.RequestListItem;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class RequestListItemDefaultEncoder
    implements Encoder
{

    public RequestListItemDefaultEncoder()
    {
    }

    public void encode(RequestListItem requestlistitem, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(requestlistitem.getListType(), dataoutputstream);
        boolean flag;
        if (requestlistitem.getSubtype() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getEnumInstance(2).encode(requestlistitem.getSubtype(), dataoutputstream);
        }
        DefaultEncoder.getStringInstance().encode(requestlistitem.getAsin(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(requestlistitem.getListItemId(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(requestlistitem.getListId(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((RequestListItem)obj, dataoutputstream);
    }
}
