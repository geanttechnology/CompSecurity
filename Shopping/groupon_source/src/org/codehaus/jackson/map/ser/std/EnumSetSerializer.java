// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.ser.std;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.type.JavaType;

// Referenced classes of package org.codehaus.jackson.map.ser.std:
//            AsArraySerializerBase, ContainerSerializerBase

public class EnumSetSerializer extends AsArraySerializerBase
{

    public EnumSetSerializer(JavaType javatype, BeanProperty beanproperty)
    {
        super(java/util/EnumSet, javatype, true, null, beanproperty, null);
    }

    public ContainerSerializerBase _withValueTypeSerializer(TypeSerializer typeserializer)
    {
        return this;
    }

    public volatile void serializeContents(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serializeContents((EnumSet)obj, jsongenerator, serializerprovider);
    }

    public void serializeContents(EnumSet enumset, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        Object obj = _elementSerializer;
        Iterator iterator = enumset.iterator();
        for (enumset = ((EnumSet) (obj)); iterator.hasNext(); enumset = ((EnumSet) (obj)))
        {
            Enum enum = (Enum)iterator.next();
            obj = enumset;
            if (enumset == null)
            {
                obj = serializerprovider.findValueSerializer(enum.getDeclaringClass(), _property);
            }
            ((JsonSerializer) (obj)).serialize(enum, jsongenerator, serializerprovider);
        }

    }
}
