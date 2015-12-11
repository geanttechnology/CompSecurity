// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.IOException;
import java.net.InetSocketAddress;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            FromStringDeserializer

public class InetSocketAddressDeserializer extends FromStringDeserializer
{

    public static final InetSocketAddressDeserializer instance = new InetSocketAddressDeserializer();
    private static final long serialVersionUID = 1L;

    public InetSocketAddressDeserializer()
    {
        super(java/net/InetSocketAddress);
    }

    protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
        throws IOException
    {
        return _deserialize(s, deserializationcontext);
    }

    protected InetSocketAddress _deserialize(String s, DeserializationContext deserializationcontext)
        throws IOException
    {
        if (s.startsWith("["))
        {
            int k = s.lastIndexOf(']');
            if (k == -1)
            {
                throw new InvalidFormatException("Bracketed IPv6 address must contain closing bracket", s, java/net/InetSocketAddress);
            }
            int i = s.indexOf(':', k);
            if (i > -1)
            {
                i = Integer.parseInt(s.substring(i + 1));
            } else
            {
                i = 0;
            }
            return new InetSocketAddress(s.substring(0, k + 1), i);
        }
        int j = s.indexOf(':');
        if (j != -1 && s.indexOf(':', j + 1) == -1)
        {
            int l = Integer.parseInt(s.substring(j + 1));
            return new InetSocketAddress(s.substring(0, j), l);
        } else
        {
            return new InetSocketAddress(s, 0);
        }
    }

}
