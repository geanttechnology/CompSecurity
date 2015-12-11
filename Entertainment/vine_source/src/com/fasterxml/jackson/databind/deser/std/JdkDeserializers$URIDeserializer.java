// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.net.URI;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            FromStringDeserializer, JdkDeserializers

public static class  extends FromStringDeserializer
{

    public static final _deserializeFromEmptyString instance = new <init>();

    protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
        throws IOException
    {
        return _deserialize(s, deserializationcontext);
    }

    protected URI _deserialize(String s, DeserializationContext deserializationcontext)
        throws IllegalArgumentException
    {
        return URI.create(s);
    }

    protected volatile Object _deserializeFromEmptyString()
    {
        return _deserializeFromEmptyString();
    }

    protected URI _deserializeFromEmptyString()
    {
        return URI.create("");
    }


    public ()
    {
        super(java/net/URI);
    }
}
