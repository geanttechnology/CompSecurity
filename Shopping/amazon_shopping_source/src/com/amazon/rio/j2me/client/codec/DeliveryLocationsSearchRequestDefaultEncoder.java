// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.DeliveryLocationsSearchRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, CoordinatesDefaultEncoder

public class DeliveryLocationsSearchRequestDefaultEncoder
    implements Encoder
{

    public DeliveryLocationsSearchRequestDefaultEncoder()
    {
    }

    public void encode(DeliveryLocationsSearchRequest deliverylocationssearchrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getEnumInstance(4).encode(new Integer(deliverylocationssearchrequest.getType()), dataoutputstream);
        boolean flag;
        if (deliverylocationssearchrequest.getState() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(deliverylocationssearchrequest.getState(), dataoutputstream);
        }
        if (deliverylocationssearchrequest.getQuery() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(deliverylocationssearchrequest.getQuery(), dataoutputstream);
        }
        if (deliverylocationssearchrequest.getCoordinates() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new CoordinatesDefaultEncoder()).encode(deliverylocationssearchrequest.getCoordinates(), dataoutputstream);
        }
        if (deliverylocationssearchrequest.getRadiusKm() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(deliverylocationssearchrequest.getRadiusKm(), dataoutputstream);
        }
        if (deliverylocationssearchrequest.getPage() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(deliverylocationssearchrequest.getPage(), dataoutputstream);
        }
        if (deliverylocationssearchrequest.getSize() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(deliverylocationssearchrequest.getSize(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((DeliveryLocationsSearchRequest)obj, dataoutputstream);
    }
}
