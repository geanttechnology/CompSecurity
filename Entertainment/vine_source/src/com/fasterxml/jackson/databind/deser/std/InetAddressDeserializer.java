// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.net.InetAddress;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            FromStringDeserializer

class InetAddressDeserializer extends FromStringDeserializer
{

    public static final InetAddressDeserializer instance = new InetAddressDeserializer();
    private static final long serialVersionUID = 1L;

    public InetAddressDeserializer()
    {
        super(java/net/InetAddress);
    }

    protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
        throws IOException
    {
        return _deserialize(s, deserializationcontext);
    }

    protected InetAddress _deserialize(String s, DeserializationContext deserializationcontext)
        throws IOException
    {
        return InetAddress.getByName(s);
    }

}
