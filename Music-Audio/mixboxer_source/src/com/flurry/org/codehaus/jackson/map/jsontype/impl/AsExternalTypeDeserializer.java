// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.jsontype.impl;

import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.jsontype.TypeIdResolver;
import com.flurry.org.codehaus.jackson.type.JavaType;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.jsontype.impl:
//            AsArrayTypeDeserializer

public class AsExternalTypeDeserializer extends AsArrayTypeDeserializer
{

    protected final String _typePropertyName;

    public AsExternalTypeDeserializer(JavaType javatype, TypeIdResolver typeidresolver, BeanProperty beanproperty, Class class1, String s)
    {
        super(javatype, typeidresolver, beanproperty, class1);
        _typePropertyName = s;
    }

    public String getPropertyName()
    {
        return _typePropertyName;
    }

    public com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As getTypeInclusion()
    {
        return com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As.EXTERNAL_PROPERTY;
    }
}
