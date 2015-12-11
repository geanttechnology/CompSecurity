// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.BarcodeBadMatch;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class BarcodeBadMatchDefaultEncoder
    implements Encoder
{

    public BarcodeBadMatchDefaultEncoder()
    {
    }

    public void encode(BarcodeBadMatch barcodebadmatch, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(barcodebadmatch.getBarcode(), dataoutputstream);
        boolean flag;
        if (barcodebadmatch.getBarcodeType() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(barcodebadmatch.getBarcodeType(), dataoutputstream);
        }
        DefaultEncoder.getArrayInstance(DefaultEncoder.getStringInstance()).encode(barcodebadmatch.getAsins(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((BarcodeBadMatch)obj, dataoutputstream);
    }
}
