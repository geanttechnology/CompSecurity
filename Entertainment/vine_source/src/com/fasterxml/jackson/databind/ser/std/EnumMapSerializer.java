// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.util.EnumValues;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            EnumSerializer, StdSerializer

public class EnumMapSerializer extends ContainerSerializer
    implements ContextualSerializer
{

    protected final EnumValues _keyEnums;
    protected final BeanProperty _property;
    protected final boolean _staticTyping;
    protected final JsonSerializer _valueSerializer;
    protected final JavaType _valueType;
    protected final TypeSerializer _valueTypeSerializer;

    public EnumMapSerializer(JavaType javatype, boolean flag, EnumValues enumvalues, TypeSerializer typeserializer, JsonSerializer jsonserializer)
    {
label0:
        {
            boolean flag1 = false;
            super(java/util/EnumMap, false);
            _property = null;
            if (!flag)
            {
                flag = flag1;
                if (javatype == null)
                {
                    break label0;
                }
                flag = flag1;
                if (!javatype.isFinal())
                {
                    break label0;
                }
            }
            flag = true;
        }
        _staticTyping = flag;
        _valueType = javatype;
        _keyEnums = enumvalues;
        _valueTypeSerializer = typeserializer;
        _valueSerializer = jsonserializer;
    }

    public EnumMapSerializer(EnumMapSerializer enummapserializer, BeanProperty beanproperty, JsonSerializer jsonserializer)
    {
        super(enummapserializer);
        _property = beanproperty;
        _staticTyping = enummapserializer._staticTyping;
        _valueType = enummapserializer._valueType;
        _keyEnums = enummapserializer._keyEnums;
        _valueTypeSerializer = enummapserializer._valueTypeSerializer;
        _valueSerializer = jsonserializer;
    }

    public volatile ContainerSerializer _withValueTypeSerializer(TypeSerializer typeserializer)
    {
        return _withValueTypeSerializer(typeserializer);
    }

    public EnumMapSerializer _withValueTypeSerializer(TypeSerializer typeserializer)
    {
        return new EnumMapSerializer(_valueType, _staticTyping, _keyEnums, typeserializer, _valueSerializer);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
        throws JsonMappingException
    {
        if (jsonformatvisitorwrapper != null) goto _L2; else goto _L1
_L1:
        JsonObjectFormatVisitor jsonobjectformatvisitor;
        return;
_L2:
        if ((jsonobjectformatvisitor = jsonformatvisitorwrapper.expectObjectFormat(javatype)) != null)
        {
            JavaType javatype1 = javatype.containedType(1);
            Object obj = _valueSerializer;
            JsonSerializer jsonserializer = ((JsonSerializer) (obj));
            if (obj == null)
            {
                jsonserializer = ((JsonSerializer) (obj));
                if (javatype1 != null)
                {
                    jsonserializer = jsonformatvisitorwrapper.getProvider().findValueSerializer(javatype1, _property);
                }
            }
            if (javatype1 == null)
            {
                javatype1 = jsonformatvisitorwrapper.getProvider().constructType(java/lang/Object);
            }
            EnumValues enumvalues = _keyEnums;
            obj = enumvalues;
            if (enumvalues == null)
            {
                obj = javatype.containedType(0);
                if (obj == null)
                {
                    throw new IllegalStateException((new StringBuilder()).append("Can not resolve Enum type of EnumMap: ").append(javatype).toString());
                }
                obj = jsonformatvisitorwrapper.getProvider().findValueSerializer(((JavaType) (obj)), _property);
                if (!(obj instanceof EnumSerializer))
                {
                    throw new IllegalStateException((new StringBuilder()).append("Can not resolve Enum type of EnumMap: ").append(javatype).toString());
                }
                obj = ((EnumSerializer)obj).getEnumValues();
            }
            obj = ((EnumValues) (obj)).internalMap().entrySet().iterator();
            javatype = jsonserializer;
            while (((Iterator) (obj)).hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                String s = ((SerializedString)entry.getValue()).getValue();
                if (javatype == null)
                {
                    javatype = jsonformatvisitorwrapper.getProvider().findValueSerializer(entry.getKey().getClass(), _property);
                }
                jsonobjectformatvisitor.property(s, javatype, javatype1);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public JsonSerializer createContextual(SerializerProvider serializerprovider, BeanProperty beanproperty)
        throws JsonMappingException
    {
        JsonSerializer jsonserializer;
        JsonSerializer jsonserializer1 = null;
        jsonserializer = jsonserializer1;
        if (beanproperty != null)
        {
            com.fasterxml.jackson.databind.introspect.AnnotatedMember annotatedmember = beanproperty.getMember();
            jsonserializer = jsonserializer1;
            if (annotatedmember != null)
            {
                Object obj = serializerprovider.getAnnotationIntrospector().findContentSerializer(annotatedmember);
                jsonserializer = jsonserializer1;
                if (obj != null)
                {
                    jsonserializer = serializerprovider.serializerInstance(annotatedmember, obj);
                }
            }
        }
        jsonserializer1 = jsonserializer;
        if (jsonserializer == null)
        {
            jsonserializer1 = _valueSerializer;
        }
        jsonserializer = findConvertingContentSerializer(serializerprovider, beanproperty, jsonserializer1);
        if (jsonserializer != null) goto _L2; else goto _L1
_L1:
        if (!_staticTyping) goto _L4; else goto _L3
_L3:
        serializerprovider = withValueSerializer(beanproperty, serializerprovider.findValueSerializer(_valueType, beanproperty));
_L6:
        return serializerprovider;
_L2:
        jsonserializer = serializerprovider.handleSecondaryContextualization(jsonserializer, beanproperty);
_L4:
        serializerprovider = this;
        if (jsonserializer != _valueSerializer)
        {
            return withValueSerializer(beanproperty, jsonserializer);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public JsonSerializer getContentSerializer()
    {
        return _valueSerializer;
    }

    public JavaType getContentType()
    {
        return _valueType;
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        throws JsonMappingException
    {
        ObjectNode objectnode = createSchemaNode("object", true);
        if (type instanceof ParameterizedType)
        {
            Type atype[] = ((ParameterizedType)type).getActualTypeArguments();
            if (atype.length == 2)
            {
                type = serializerprovider.constructType(atype[0]);
                JavaType javatype = serializerprovider.constructType(atype[1]);
                ObjectNode objectnode1 = JsonNodeFactory.instance.objectNode();
                Enum aenum[] = (Enum[])type.getRawClass().getEnumConstants();
                int j = aenum.length;
                int i = 0;
                while (i < j) 
                {
                    Enum enum = aenum[i];
                    type = serializerprovider.findValueSerializer(javatype.getRawClass(), _property);
                    if (type instanceof SchemaAware)
                    {
                        type = ((SchemaAware)type).getSchema(serializerprovider, null);
                    } else
                    {
                        type = JsonSchema.getDefaultSchemaNode();
                    }
                    objectnode1.put(serializerprovider.getConfig().getAnnotationIntrospector().findEnumValue(enum), type);
                    i++;
                }
                objectnode.put("properties", objectnode1);
            }
        }
        return objectnode;
    }

    public volatile boolean hasSingleElement(Object obj)
    {
        return hasSingleElement((EnumMap)obj);
    }

    public boolean hasSingleElement(EnumMap enummap)
    {
        return enummap.size() == 1;
    }

    public volatile boolean isEmpty(Object obj)
    {
        return isEmpty((EnumMap)obj);
    }

    public boolean isEmpty(EnumMap enummap)
    {
        return enummap == null || enummap.isEmpty();
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((EnumMap)obj, jsongenerator, serializerprovider);
    }

    public void serialize(EnumMap enummap, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeStartObject();
        if (!enummap.isEmpty())
        {
            serializeContents(enummap, jsongenerator, serializerprovider);
        }
        jsongenerator.writeEndObject();
    }

    protected void serializeContents(EnumMap enummap, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        if (_valueSerializer == null) goto _L2; else goto _L1
_L1:
        serializeContentsUsing(enummap, jsongenerator, serializerprovider, _valueSerializer);
_L4:
        return;
_L2:
        Object obj2 = _keyEnums;
        Object obj;
        Object obj1;
        TypeSerializer typeserializer;
        Iterator iterator;
        boolean flag;
        if (!serializerprovider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        typeserializer = _valueTypeSerializer;
        iterator = enummap.entrySet().iterator();
        obj1 = null;
        obj = null;
label0:
        do
        {
label1:
            {
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    Object obj4 = entry.getValue();
                    if (flag && obj4 == null)
                    {
                        continue;
                    }
                    Object obj3 = (Enum)entry.getKey();
                    EnumValues enumvalues = ((EnumValues) (obj2));
                    if (obj2 == null)
                    {
                        enumvalues = ((EnumSerializer)(StdSerializer)serializerprovider.findValueSerializer(((Enum) (obj3)).getDeclaringClass(), _property)).getEnumValues();
                    }
                    jsongenerator.writeFieldName(enumvalues.serializedValueFor(((Enum) (obj3))));
                    if (obj4 == null)
                    {
                        serializerprovider.defaultSerializeNull(jsongenerator);
                        obj2 = enumvalues;
                        continue;
                    }
                    obj2 = obj4.getClass();
                    if (obj2 == obj1)
                    {
                        obj2 = obj1;
                        obj1 = obj;
                        obj3 = obj;
                        obj = obj2;
                    } else
                    {
                        obj3 = serializerprovider.findValueSerializer(((Class) (obj2)), _property);
                        obj1 = obj3;
                        obj = obj2;
                    }
                    if (typeserializer != null)
                    {
                        break label1;
                    }
                    try
                    {
                        ((JsonSerializer) (obj3)).serialize(obj4, jsongenerator, serializerprovider);
                    }
                    catch (Exception exception)
                    {
                        wrapAndThrow(serializerprovider, exception, enummap, ((Enum)entry.getKey()).name());
                    }
                }
                obj3 = obj1;
                obj2 = enumvalues;
                obj1 = obj;
                obj = obj3;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        ((JsonSerializer) (obj3)).serializeWithType(obj4, jsongenerator, serializerprovider, typeserializer);
        break MISSING_BLOCK_LABEL_225;
    }

    protected void serializeContentsUsing(EnumMap enummap, JsonGenerator jsongenerator, SerializerProvider serializerprovider, JsonSerializer jsonserializer)
        throws IOException, JsonGenerationException
    {
        Object obj;
        Object obj1;
        TypeSerializer typeserializer;
        java.util.Map.Entry entry;
        Object obj2;
        obj1 = _keyEnums;
        Iterator iterator;
        Enum enum;
        boolean flag;
        if (!serializerprovider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        typeserializer = _valueTypeSerializer;
        iterator = enummap.entrySet().iterator();
_L2:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        entry = (java.util.Map.Entry)iterator.next();
        obj2 = entry.getValue();
        if (flag && obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        enum = (Enum)entry.getKey();
        obj = obj1;
        if (obj1 == null)
        {
            obj = ((EnumSerializer)(StdSerializer)serializerprovider.findValueSerializer(enum.getDeclaringClass(), _property)).getEnumValues();
        }
        jsongenerator.writeFieldName(((EnumValues) (obj)).serializedValueFor(enum));
        if (obj2 == null)
        {
            serializerprovider.defaultSerializeNull(jsongenerator);
            obj1 = obj;
            continue; /* Loop/switch isn't completed */
        }
        if (typeserializer == null)
        {
            try
            {
                jsonserializer.serialize(obj2, jsongenerator, serializerprovider);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                wrapAndThrow(serializerprovider, ((Throwable) (obj1)), enummap, ((Enum)entry.getKey()).name());
                obj1 = obj;
                continue; /* Loop/switch isn't completed */
            }
            obj1 = obj;
            continue; /* Loop/switch isn't completed */
        }
        jsonserializer.serializeWithType(obj2, jsongenerator, serializerprovider, typeserializer);
        obj1 = obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile void serializeWithType(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonProcessingException
    {
        serializeWithType((EnumMap)obj, jsongenerator, serializerprovider, typeserializer);
    }

    public void serializeWithType(EnumMap enummap, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonGenerationException
    {
        typeserializer.writeTypePrefixForObject(enummap, jsongenerator);
        if (!enummap.isEmpty())
        {
            serializeContents(enummap, jsongenerator, serializerprovider);
        }
        typeserializer.writeTypeSuffixForObject(enummap, jsongenerator);
    }

    public EnumMapSerializer withValueSerializer(BeanProperty beanproperty, JsonSerializer jsonserializer)
    {
        if (_property == beanproperty && jsonserializer == _valueSerializer)
        {
            return this;
        } else
        {
            return new EnumMapSerializer(this, beanproperty, jsonserializer);
        }
    }
}
