// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.nio.charset.Charset;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            FromStringDeserializer

public class CharsetDeserializer extends FromStringDeserializer
{

    private static final long serialVersionUID = 1L;

    public CharsetDeserializer()
    {
        super(java/nio/charset/Charset);
    }

    protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
        throws IOException
    {
        return _deserialize(s, deserializationcontext);
    }

    protected Charset _deserialize(String s, DeserializationContext deserializationcontext)
        throws IOException
    {
        return Charset.forName(s);
    }
}
