// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.util.EnumValues;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            StdScalarSerializer

public class EnumSerializer extends StdScalarSerializer
    implements ContextualSerializer
{

    protected final Boolean _serializeAsIndex;
    protected final EnumValues _values;

    public EnumSerializer(EnumValues enumvalues)
    {
        this(enumvalues, null);
    }

    public EnumSerializer(EnumValues enumvalues, Boolean boolean1)
    {
        super(java/lang/Enum, false);
        _values = enumvalues;
        _serializeAsIndex = boolean1;
    }

    protected static Boolean _isShapeWrittenUsingIndex(Class class1, com.fasterxml.jackson.annotation.JsonFormat.Value value, boolean flag)
    {
        if (value == null)
        {
            value = null;
        } else
        {
            value = value.getShape();
        }
        while (value == null || value == com.fasterxml.jackson.annotation.JsonFormat.Shape.ANY || value == com.fasterxml.jackson.annotation.JsonFormat.Shape.SCALAR) 
        {
            return null;
        }
        if (value == com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING)
        {
            return Boolean.FALSE;
        }
        if (value.isNumeric())
        {
            return Boolean.TRUE;
        }
        value = (new StringBuilder()).append("Unsupported serialization shape (").append(value).append(") for Enum ").append(class1.getName()).append(", not supported as ");
        if (flag)
        {
            class1 = "class";
        } else
        {
            class1 = "property";
        }
        throw new IllegalArgumentException(value.append(class1).append(" annotation").toString());
    }

    public static EnumSerializer construct(Class class1, SerializationConfig serializationconfig, BeanDescription beandescription)
    {
        return construct(class1, serializationconfig, beandescription, beandescription.findExpectedFormat(null));
    }

    public static EnumSerializer construct(Class class1, SerializationConfig serializationconfig, BeanDescription beandescription, com.fasterxml.jackson.annotation.JsonFormat.Value value)
    {
        beandescription = serializationconfig.getAnnotationIntrospector();
        if (serializationconfig.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING))
        {
            serializationconfig = EnumValues.constructFromToString(class1, beandescription);
        } else
        {
            serializationconfig = EnumValues.constructFromName(class1, beandescription);
        }
        return new EnumSerializer(serializationconfig, _isShapeWrittenUsingIndex(class1, value, true));
    }

    protected final boolean _serializeAsIndex(SerializerProvider serializerprovider)
    {
        if (_serializeAsIndex != null)
        {
            return _serializeAsIndex.booleanValue();
        } else
        {
            return serializerprovider.isEnabled(SerializationFeature.WRITE_ENUMS_USING_INDEX);
        }
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
    {
        if (jsonformatvisitorwrapper.getProvider().isEnabled(SerializationFeature.WRITE_ENUMS_USING_INDEX))
        {
            jsonformatvisitorwrapper.expectIntegerFormat(javatype);
        } else
        {
            jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectStringFormat(javatype);
            if (javatype != null && javatype.isEnumType())
            {
                javatype = new HashSet();
                for (Iterator iterator = _values.values().iterator(); iterator.hasNext(); javatype.add(((SerializedString)iterator.next()).getValue())) { }
                jsonformatvisitorwrapper.enumTypes(javatype);
                return;
            }
        }
    }

    public JsonSerializer createContextual(SerializerProvider serializerprovider, BeanProperty beanproperty)
        throws JsonMappingException
    {
        EnumSerializer enumserializer = this;
        if (beanproperty != null)
        {
            serializerprovider = serializerprovider.getAnnotationIntrospector().findFormat(beanproperty.getMember());
            enumserializer = this;
            if (serializerprovider != null)
            {
                serializerprovider = _isShapeWrittenUsingIndex(beanproperty.getType().getRawClass(), serializerprovider, false);
                enumserializer = this;
                if (serializerprovider != _serializeAsIndex)
                {
                    enumserializer = new EnumSerializer(_values, serializerprovider);
                }
            }
        }
        return enumserializer;
    }

    public EnumValues getEnumValues()
    {
        return _values;
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        if (!_serializeAsIndex(serializerprovider)) goto _L2; else goto _L1
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
        if (_serializeAsIndex(serializerprovider))
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
