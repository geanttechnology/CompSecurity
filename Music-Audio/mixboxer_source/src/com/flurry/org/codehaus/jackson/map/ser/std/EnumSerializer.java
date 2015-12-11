// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser.std;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.io.SerializedString;
import com.flurry.org.codehaus.jackson.map.SerializationConfig;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.introspect.BasicBeanDescription;
import com.flurry.org.codehaus.jackson.map.util.EnumValues;
import com.flurry.org.codehaus.jackson.node.ArrayNode;
import com.flurry.org.codehaus.jackson.node.ObjectNode;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ser.std:
//            ScalarSerializerBase

public class EnumSerializer extends ScalarSerializerBase
{

    protected final EnumValues _values;

    public EnumSerializer(EnumValues enumvalues)
    {
        super(java/lang/Enum, false);
        _values = enumvalues;
    }

    public static EnumSerializer construct(Class class1, SerializationConfig serializationconfig, BasicBeanDescription basicbeandescription)
    {
        basicbeandescription = serializationconfig.getAnnotationIntrospector();
        if (serializationconfig.isEnabled(com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING))
        {
            class1 = EnumValues.constructFromToString(class1, basicbeandescription);
        } else
        {
            class1 = EnumValues.constructFromName(class1, basicbeandescription);
        }
        return new EnumSerializer(class1);
    }

    public EnumValues getEnumValues()
    {
        return _values;
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        if (!serializerprovider.isEnabled(com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature.WRITE_ENUMS_USING_INDEX)) goto _L2; else goto _L1
_L1:
        ObjectNode objectnode = createSchemaNode("integer", true);
_L4:
        return objectnode;
_L2:
        ObjectNode objectnode1 = createSchemaNode("string", true);
        objectnode = objectnode1;
        if (type == null)
        {
            continue;
        }
        objectnode = objectnode1;
        if (!serializerprovider.constructType(type).isEnumType())
        {
            continue;
        }
        serializerprovider = objectnode1.putArray("enum");
        type = _values.values().iterator();
        do
        {
            objectnode = objectnode1;
            if (!type.hasNext())
            {
                continue;
            }
            serializerprovider.add(((SerializedString)type.next()).getValue());
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void serialize(Enum enum, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        if (serializerprovider.isEnabled(com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature.WRITE_ENUMS_USING_INDEX))
        {
            jsongenerator.writeNumber(enum.ordinal());
            return;
        } else
        {
            jsongenerator.writeString(_values.serializedValueFor(enum));
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((Enum)obj, jsongenerator, serializerprovider);
    }
}
