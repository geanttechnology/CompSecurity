// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.TextAttributes;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class TextAttributesDefaultEncoder
    implements Encoder
{

    public TextAttributesDefaultEncoder()
    {
    }

    public void encode(TextAttributes textattributes, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (textattributes.getSize() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getEnumInstance(3).encode(textattributes.getSize(), dataoutputstream);
        }
        if (textattributes.getStyle() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getEnumInstance(2).encode(textattributes.getStyle(), dataoutputstream);
        }
        if (textattributes.getColor() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).encode(textattributes.getColor(), dataoutputstream);
        }
        if (textattributes.getLinkUrl() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(textattributes.getLinkUrl(), dataoutputstream);
        }
        if (textattributes.getAllowTruncation() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(textattributes.getAllowTruncation(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((TextAttributes)obj, dataoutputstream);
    }
}
