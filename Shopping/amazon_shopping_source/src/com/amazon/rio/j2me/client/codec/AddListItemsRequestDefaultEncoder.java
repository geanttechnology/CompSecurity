// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.AddListItemsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, RequestListItemDefaultEncoder, DefaultEncoder

public class AddListItemsRequestDefaultEncoder
    implements Encoder
{

    public AddListItemsRequestDefaultEncoder()
    {
    }

    public void encode(AddListItemsRequest addlistitemsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getArrayInstance(new RequestListItemDefaultEncoder()).encode(addlistitemsrequest.getItems(), dataoutputstream);
        boolean flag;
        if (addlistitemsrequest.getReturnAddedItems() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(addlistitemsrequest.getReturnAddedItems(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((AddListItemsRequest)obj, dataoutputstream);
    }
}
