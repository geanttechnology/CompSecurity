// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.module;

import java.util.HashMap;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.type.JavaType;

public class SimpleAbstractTypeResolver extends AbstractTypeResolver
{

    protected final HashMap _mappings;

    public JavaType findTypeMapping(DeserializationConfig deserializationconfig, JavaType javatype)
    {
        deserializationconfig = javatype.getRawClass();
        deserializationconfig = (Class)_mappings.get(new ClassKey(deserializationconfig));
        if (deserializationconfig == null)
        {
            return null;
        } else
        {
            return javatype.narrowBy(deserializationconfig);
        }
    }

    public JavaType resolveAbstractType(DeserializationConfig deserializationconfig, JavaType javatype)
    {
        return null;
    }
}
