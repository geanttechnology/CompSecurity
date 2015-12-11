// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.type.JavaType;

// Referenced classes of package com.flurry.org.codehaus.jackson.map:
//            JsonMappingException, DeserializationConfig, BeanDescription, BeanProperty, 
//            KeyDeserializer

public interface KeyDeserializers
{

    public abstract KeyDeserializer findKeyDeserializer(JavaType javatype, DeserializationConfig deserializationconfig, BeanDescription beandescription, BeanProperty beanproperty)
        throws JsonMappingException;
}
