// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.RequestListIdea;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class RequestListIdeaDefaultEncoder
    implements Encoder
{

    public RequestListIdeaDefaultEncoder()
    {
    }

    public void encode(RequestListIdea requestlistidea, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(requestlistidea.getListType(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(requestlistidea.getListId(), dataoutputstream);
        boolean flag;
        if (requestlistidea.getListSubtype() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getEnumInstance(2).encode(requestlistidea.getListSubtype(), dataoutputstream);
        }
        DefaultEncoder.getStringInstance().encode(requestlistidea.getIdea(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(requestlistidea.getVendorId(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((RequestListIdea)obj, dataoutputstream);
    }
}
