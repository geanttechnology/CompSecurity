// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.introspect.BasicBeanDescription;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser:
//            BeanDeserializerBuilder

public abstract class BeanDeserializerModifier
{

    public BeanDeserializerModifier()
    {
    }

    public JsonDeserializer modifyDeserializer(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, JsonDeserializer jsondeserializer)
    {
        return jsondeserializer;
    }

    public BeanDeserializerBuilder updateBuilder(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, BeanDeserializerBuilder beandeserializerbuilder)
    {
        return beandeserializerbuilder;
    }
}
