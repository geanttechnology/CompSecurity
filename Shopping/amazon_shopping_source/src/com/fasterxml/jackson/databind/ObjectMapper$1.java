// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;

// Referenced classes of package com.fasterxml.jackson.databind:
//            ObjectMapper, AbstractTypeResolver

class val.mapper
    implements text
{

    final ObjectMapper this$0;
    final ObjectMapper val$mapper;

    public void addAbstractTypeResolver(AbstractTypeResolver abstracttyperesolver)
    {
        abstracttyperesolver = val$mapper._deserializationContext._factory.withAbstractTypeResolver(abstracttyperesolver);
        val$mapper._deserializationContext = val$mapper._deserializationContext.with(abstracttyperesolver);
    }

    public void addDeserializers(Deserializers deserializers)
    {
        deserializers = val$mapper._deserializationContext._factory.withAdditionalDeserializers(deserializers);
        val$mapper._deserializationContext = val$mapper._deserializationContext.with(deserializers);
    }

    public void addKeyDeserializers(KeyDeserializers keydeserializers)
    {
        keydeserializers = val$mapper._deserializationContext._factory.withAdditionalKeyDeserializers(keydeserializers);
        val$mapper._deserializationContext = val$mapper._deserializationContext.with(keydeserializers);
    }

    public void addKeySerializers(Serializers serializers)
    {
        val$mapper._serializerFactory = val$mapper._serializerFactory.withAdditionalKeySerializers(serializers);
    }

    public void addSerializers(Serializers serializers)
    {
        val$mapper._serializerFactory = val$mapper._serializerFactory.withAdditionalSerializers(serializers);
    }

    public void addValueInstantiators(ValueInstantiators valueinstantiators)
    {
        valueinstantiators = val$mapper._deserializationContext._factory.withValueInstantiators(valueinstantiators);
        val$mapper._deserializationContext = val$mapper._deserializationContext.with(valueinstantiators);
    }

    public transient void registerSubtypes(NamedType anamedtype[])
    {
        val$mapper.registerSubtypes(anamedtype);
    }

    public void setMixInAnnotations(Class class1, Class class2)
    {
        val$mapper.addMixInAnnotations(class1, class2);
    }

    ype()
    {
        this$0 = final_objectmapper;
        val$mapper = ObjectMapper.this;
        super();
    }
}
