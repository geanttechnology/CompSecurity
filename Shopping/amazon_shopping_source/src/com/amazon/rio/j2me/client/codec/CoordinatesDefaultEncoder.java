// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.Coordinates;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class CoordinatesDefaultEncoder
    implements Encoder
{

    public CoordinatesDefaultEncoder()
    {
    }

    public void encode(Coordinates coordinates, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(coordinates.getLatitude(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(coordinates.getLongitude(), dataoutputstream);
        boolean flag;
        if (coordinates.getElevation() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(coordinates.getElevation(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((Coordinates)obj, dataoutputstream);
    }
}
