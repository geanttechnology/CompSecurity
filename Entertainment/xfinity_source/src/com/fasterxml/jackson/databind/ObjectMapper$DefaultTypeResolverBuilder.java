// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import java.io.Serializable;
import java.util.Collection;

// Referenced classes of package com.fasterxml.jackson.databind:
//            ObjectMapper, JavaType, DeserializationConfig, SerializationConfig

public static class _appliesFor extends StdTypeResolverBuilder
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    protected final _appliesFor _appliesFor;

    public TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, Collection collection)
    {
        if (useForType(javatype))
        {
            return super.buildTypeDeserializer(deserializationconfig, javatype, collection);
        } else
        {
            return null;
        }
    }

    public TypeSerializer buildTypeSerializer(SerializationConfig serializationconfig, JavaType javatype, Collection collection)
    {
        if (useForType(javatype))
        {
            return super.buildTypeSerializer(serializationconfig, javatype, collection);
        } else
        {
            return null;
        }
    }

    public boolean useForType(JavaType javatype)
    {
        JavaType javatype1;
        JavaType javatype2;
        JavaType javatype3;
        boolean flag;
        flag = false;
        javatype1 = javatype;
        javatype2 = javatype;
        javatype3 = javatype;
        jackson.databind.ObjectMapper.DefaultTyping[_appliesFor._appliesFor()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 59
    //                   2 76
    //                   3 98;
           goto _L1 _L2 _L3 _L4
_L1:
        if (javatype.getRawClass() != java/lang/Object) goto _L6; else goto _L5
_L5:
        return true;
_L2:
        javatype2 = javatype1;
        if (!javatype1.isArrayType()) goto _L3; else goto _L7
_L7:
        javatype1 = javatype1.getContentType();
          goto _L2
_L3:
        if (javatype2.getRawClass() == java/lang/Object || !javatype2.isConcrete())
        {
            flag = true;
        }
        return flag;
_L4:
        for (; javatype3.isArrayType(); javatype3 = javatype3.getContentType()) { }
        if (javatype3.isFinal())
        {
            return false;
        }
        if (true) goto _L5; else goto _L6
_L6:
        return false;
    }

    public ( )
    {
        _appliesFor = ;
    }
}
