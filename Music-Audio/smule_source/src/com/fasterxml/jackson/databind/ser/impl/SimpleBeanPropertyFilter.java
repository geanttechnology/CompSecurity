// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;

public abstract class SimpleBeanPropertyFilter
    implements BeanPropertyFilter, PropertyFilter
{

    public static PropertyFilter from(final BeanPropertyFilter src)
    {
        return new PropertyFilter() {

            final BeanPropertyFilter val$src;

            public void serializeAsField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, PropertyWriter propertywriter)
            {
                src.serializeAsField(obj, jsongenerator, serializerprovider, (BeanPropertyWriter)propertywriter);
            }

            
            {
                src = beanpropertyfilter;
                super();
            }
        };
    }

    protected abstract boolean include(BeanPropertyWriter beanpropertywriter);

    protected abstract boolean include(PropertyWriter propertywriter);

    public void serializeAsField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, BeanPropertyWriter beanpropertywriter)
    {
        if (include(beanpropertywriter))
        {
            beanpropertywriter.serializeAsField(obj, jsongenerator, serializerprovider);
        } else
        if (!jsongenerator.canOmitFields())
        {
            beanpropertywriter.serializeAsOmittedField(obj, jsongenerator, serializerprovider);
            return;
        }
    }

    public void serializeAsField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, PropertyWriter propertywriter)
    {
        if (include(propertywriter))
        {
            propertywriter.serializeAsField(obj, jsongenerator, serializerprovider);
        } else
        if (!jsongenerator.canOmitFields())
        {
            propertywriter.serializeAsOmittedField(obj, jsongenerator, serializerprovider);
            return;
        }
    }
}
