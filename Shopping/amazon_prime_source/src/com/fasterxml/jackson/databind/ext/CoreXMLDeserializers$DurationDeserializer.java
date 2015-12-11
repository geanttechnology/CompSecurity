// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.IOException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

// Referenced classes of package com.fasterxml.jackson.databind.ext:
//            CoreXMLDeserializers

public static class  extends FromStringDeserializer
{

    protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return _deserialize(s, deserializationcontext);
    }

    protected Duration _deserialize(String s, DeserializationContext deserializationcontext)
        throws IllegalArgumentException
    {
        return CoreXMLDeserializers._dataTypeFactory.newDuration(s);
    }

    public ()
    {
        super(javax/xml/datatype/Duration);
    }
}
