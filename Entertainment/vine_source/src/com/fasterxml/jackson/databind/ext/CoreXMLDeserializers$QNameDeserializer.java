// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.IOException;
import javax.xml.namespace.QName;

// Referenced classes of package com.fasterxml.jackson.databind.ext:
//            CoreXMLDeserializers

public static class  extends FromStringDeserializer
{

    public static final _deserialize instance = new <init>();
    private static final long serialVersionUID = 1L;

    protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
        throws IOException
    {
        return _deserialize(s, deserializationcontext);
    }

    protected QName _deserialize(String s, DeserializationContext deserializationcontext)
        throws IllegalArgumentException
    {
        return QName.valueOf(s);
    }


    public ()
    {
        super(javax/xml/namespace/QName);
    }
}
