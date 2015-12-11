// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.Collection;

// Referenced classes of package com.flurry.org.codehaus.jackson.map:
//            ObjectMapper, DeserializationConfig, BeanProperty, TypeDeserializer, 
//            SerializationConfig, TypeSerializer

public static class _appliesFor extends StdTypeResolverBuilder
{

    protected final _appliesFor _appliesFor;

    public TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, Collection collection, BeanProperty beanproperty)
    {
        if (useForType(javatype))
        {
            return super.buildTypeDeserializer(deserializationconfig, javatype, collection, beanproperty);
        } else
        {
            return null;
        }
    }

    public TypeSerializer buildTypeSerializer(SerializationConfig serializationconfig, JavaType javatype, Collection collection, BeanProperty beanproperty)
    {
        if (useForType(javatype))
        {
            return super.buildTypeSerializer(serializationconfig, javatype, collection, beanproperty);
        } else
        {
            return null;
        }
    }

    public boolean useForType(JavaType javatype)
    {
        JavaType javatype1;
        boolean flag;
        flag = false;
        javatype1 = javatype;
        ackson.map.ObjectMapper.DefaultTyping[_appliesFor._appliesFor()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 51
    //                   2 65
    //                   3 85;
           goto _L1 _L2 _L3 _L4
_L1:
        if (javatype.getRawClass() != java/lang/Object) goto _L6; else goto _L5
_L5:
        return true;
_L2:
        javatype1 = javatype;
        if (javatype.isArrayType())
        {
            javatype1 = javatype.getContentType();
        }
_L3:
        if (javatype1.getRawClass() == java/lang/Object || !javatype1.isConcrete())
        {
            flag = true;
        }
        return flag;
_L4:
        JavaType javatype2 = javatype;
        if (javatype.isArrayType())
        {
            javatype2 = javatype.getContentType();
        }
        if (javatype2.isFinal())
        {
            return false;
        }
        if (true) goto _L5; else goto _L6
_L6:
        return false;
    }

    public Q(Q q)
    {
        _appliesFor = q;
    }
}
