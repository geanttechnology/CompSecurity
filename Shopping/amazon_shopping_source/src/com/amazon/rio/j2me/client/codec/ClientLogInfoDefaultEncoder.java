// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.ClientLogInfo;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, FeatureExperienceDefaultEncoder

public class ClientLogInfoDefaultEncoder
    implements Encoder
{

    public ClientLogInfoDefaultEncoder()
    {
    }

    public void encode(ClientLogInfo clientloginfo, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (clientloginfo.getSessionId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(clientloginfo.getSessionId(), dataoutputstream);
        }
        if (clientloginfo.getRelatedRequestId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(clientloginfo.getRelatedRequestId(), dataoutputstream);
        }
        if (clientloginfo.getPageType() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(clientloginfo.getPageType(), dataoutputstream);
        }
        if (clientloginfo.getPageAssemblyType() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(clientloginfo.getPageAssemblyType(), dataoutputstream);
        }
        if (clientloginfo.getFeatures() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getArrayInstance(new FeatureExperienceDefaultEncoder()).encode(clientloginfo.getFeatures(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((ClientLogInfo)obj, dataoutputstream);
    }
}
