// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AsArraySerializerBase extends ContainerSerializer
    implements ContextualSerializer
{

    protected PropertySerializerMap _dynamicSerializers;
    protected final JsonSerializer _elementSerializer;
    protected final JavaType _elementType;
    protected final BeanProperty _property;
    protected final boolean _staticTyping;
    protected final TypeSerializer _valueTypeSerializer;

    protected AsArraySerializerBase(AsArraySerializerBase asarrayserializerbase, BeanProperty beanproperty, TypeSerializer typeserializer, JsonSerializer jsonserializer)
    {
        super(asarrayserializerbase);
        _elementType = asarrayserializerbase._elementType;
        _staticTyping = asarrayserializerbase._staticTyping;
        _valueTypeSerializer = typeserializer;
        _property = beanproperty;
        _elementSerializer = jsonserializer;
        _dynamicSerializers = asarrayserializerbase._dynamicSerializers;
    }

    protected AsArraySerializerBase(Class class1, JavaType javatype, boolean flag, TypeSerializer typeserializer, BeanProperty beanproperty, JsonSerializer jsonserializer)
    {
label0:
        {
            boolean flag1 = false;
            super(class1, false);
            _elementType = javatype;
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
        _valueTypeSerializer = typeserializer;
        _property = beanproperty;
        _elementSerializer = jsonserializer;
        _dynamicSerializers = PropertySerializerMap.emptyMap();
    }

    protected final JsonSerializer _findAndAddDynamic(PropertySerializerMap propertyserializermap, JavaType javatype, SerializerProvider serializerprovider)
        throws JsonMappingException
    {
        javatype = propertyserializermap.findAndAddSecondarySerializer(javatype, serializerprovider, _property);
        if (propertyserializermap != ((com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult) (javatype)).map)
        {
            _dynamicSerializers = ((com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult) (javatype)).map;
        }
        return ((com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult) (javatype)).serializer;
    }

    protected final JsonSerializer _findAndAddDynamic(PropertySerializerMap propertyserializermap, Class class1, SerializerProvider serializerprovider)
        throws JsonMappingException
    {
        class1 = propertyserializermap.findAndAddSecondarySerializer(class1, serializerprovider, _property);
        if (propertyserializermap != ((com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult) (class1)).map)
        {
            _dynamicSerializers = ((com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult) (class1)).map;
        }
        return ((com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult) (class1)).serializer;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
        throws JsonMappingException
    {
        JsonArrayFormatVisitor jsonarrayformatvisitor;
        if (jsonformatvisitorwrapper == null)
        {
            jsonarrayformatvisitor = null;
        } else
        {
            jsonarrayformatvisitor = jsonformatvisitorwrapper.expectArrayFormat(javatype);
        }
        if (jsonarrayformatvisitor != null)
        {
            JavaType javatype1 = jsonformatvisitorwrapper.getProvider().getTypeFactory().moreSpecificType(_elementType, javatype.getContentType());
            if (javatype1 == null)
            {
                throw new JsonMappingException("Could not resolve type");
            }
            JsonSerializer jsonserializer = _elementSerializer;
            javatype = jsonserializer;
            if (jsonserializer == null)
            {
                javatype = jsonformatvisitorwrapper.getProvider().findValueSerializer(javatype1, _property);
            }
            jsonarrayformatvisitor.itemsFormat(javatype, javatype1);
        }
    }

    public JsonSerializer createContextual(SerializerProvider serializerprovider, BeanProperty beanproperty)
        throws JsonMappingException
    {
        TypeSerializer typeserializer;
        JsonSerializer jsonserializer2;
        typeserializer = _valueTypeSerializer;
        if (typeserializer != null)
        {
            typeserializer = typeserializer.forProperty(beanproperty);
        }
        jsonserializer2 = null;
        JsonSerializer jsonserializer = jsonserializer2;
        if (beanproperty != null)
        {
            com.fasterxml.jackson.databind.introspect.AnnotatedMember annotatedmember = beanproperty.getMember();
            jsonserializer = jsonserializer2;
            if (annotatedmember != null)
            {
                Object obj = serializerprovider.getAnnotationIntrospector().findContentSerializer(annotatedmember);
                jsonserializer = jsonserializer2;
                if (obj != null)
                {
                    jsonserializer = serializerprovider.serializerInstance(annotatedmember, obj);
                }
            }
        }
        jsonserializer2 = jsonserializer;
        if (jsonserializer == null)
        {
            jsonserializer2 = _elementSerializer;
        }
        jsonserializer2 = findConvertingContentSerializer(serializerprovider, beanproperty, jsonserializer2);
        if (jsonserializer2 != null) goto _L2; else goto _L1
_L1:
        JsonSerializer jsonserializer1;
label0:
        {
            jsonserializer1 = jsonserializer2;
            if (_elementType == null)
            {
                break label0;
            }
            if (!_staticTyping || _elementType.getRawClass() == java/lang/Object)
            {
                jsonserializer1 = jsonserializer2;
                if (!hasContentTypeAnnotation(serializerprovider, beanproperty))
                {
                    break label0;
                }
            }
            jsonserializer1 = serializerprovider.findValueSerializer(_elementType, beanproperty);
        }
_L4:
label1:
        {
            if (jsonserializer1 == _elementSerializer && beanproperty == _property)
            {
                serializerprovider = this;
                if (_valueTypeSerializer == typeserializer)
                {
                    break label1;
                }
            }
            serializerprovider = withResolved(beanproperty, typeserializer, jsonserializer1);
        }
        return serializerprovider;
_L2:
        jsonserializer1 = serializerprovider.handleSecondaryContextualization(jsonserializer2, beanproperty);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public JsonSerializer getContentSerializer()
    {
        return _elementSerializer;
    }

    public JavaType getContentType()
    {
        return _elementType;
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        throws JsonMappingException
    {
        ObjectNode objectnode = createSchemaNode("array", true);
        JavaType javatype;
        if (type != null)
        {
            JavaType javatype1 = serializerprovider.constructType(type).getContentType();
            javatype = javatype1;
            if (javatype1 == null)
            {
                javatype = javatype1;
                if (type instanceof ParameterizedType)
                {
                    type = ((ParameterizedType)type).getActualTypeArguments();
                    javatype = javatype1;
                    if (type.length == 1)
                    {
                        javatype = serializerprovider.constructType(type[0]);
                    }
                }
            }
        } else
        {
            javatype = null;
        }
        type = javatype;
        if (javatype == null)
        {
            type = javatype;
            if (_elementType != null)
            {
                type = _elementType;
            }
        }
        if (type == null) goto _L2; else goto _L1
_L1:
        if (type.getRawClass() == java/lang/Object) goto _L4; else goto _L3
_L3:
        type = serializerprovider.findValueSerializer(type, _property);
        if (!(type instanceof SchemaAware)) goto _L4; else goto _L5
_L5:
        serializerprovider = ((SchemaAware)type).getSchema(serializerprovider, null);
_L7:
        type = serializerprovider;
        if (serializerprovider == null)
        {
            type = JsonSchema.getDefaultSchemaNode();
        }
        objectnode.put("items", type);
_L2:
        return objectnode;
_L4:
        serializerprovider = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        if (serializerprovider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && hasSingleElement(obj))
        {
            serializeContents(obj, jsongenerator, serializerprovider);
            return;
        } else
        {
            jsongenerator.writeStartArray();
            serializeContents(obj, jsongenerator, serializerprovider);
            jsongenerator.writeEndArray();
            return;
        }
    }

    protected abstract void serializeContents(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException;

    public void serializeWithType(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonGenerationException
    {
        typeserializer.writeTypePrefixForArray(obj, jsongenerator);
        serializeContents(obj, jsongenerator, serializerprovider);
        typeserializer.writeTypeSuffixForArray(obj, jsongenerator);
    }

    public abstract AsArraySerializerBase withResolved(BeanProperty beanproperty, TypeSerializer typeserializer, JsonSerializer jsonserializer);
}
