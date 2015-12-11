// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.HyperText;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, TextAttributesDefaultEncoder

public class HyperTextDefaultEncoder
    implements Encoder
{

    public HyperTextDefaultEncoder()
    {
    }

    public void encode(HyperText hypertext, DataOutputStream dataoutputstream)
        throws IOException
    {
        Encoder encoder;
        boolean flag;
        if (hypertext.getText() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(hypertext.getText(), dataoutputstream);
        }
        if (hypertext.getAttributes() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new TextAttributesDefaultEncoder()).encode(hypertext.getAttributes(), dataoutputstream);
        }
        encoder = DefaultEncoder.getBooleanInstance();
        if (hypertext.getLineBreak())
        {
            hypertext = Boolean.TRUE;
        } else
        {
            hypertext = Boolean.FALSE;
        }
        encoder.encode(hypertext, dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((HyperText)obj, dataoutputstream);
    }
}
