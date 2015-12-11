// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.convert;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;

// Referenced classes of package org.simpleframework.xml.convert:
//            ConverterFactory, ScannerBuilder, Scanner, Convert, 
//            ConvertException, Converter

class ConverterScanner
{

    private final ScannerBuilder builder = new ScannerBuilder();
    private final ConverterFactory factory = new ConverterFactory();

    public ConverterScanner()
    {
    }

    private Annotation getAnnotation(Class class1, Class class2)
    {
        return builder.build(class1).scan(class2);
    }

    private Convert getConvert(Class class1)
        throws Exception
    {
        Convert convert = (Convert)getAnnotation(class1, org/simpleframework/xml/convert/Convert);
        if (convert != null && (Root)getAnnotation(class1, org/simpleframework/xml/Root) == null)
        {
            throw new ConvertException("Root annotation required for %s", new Object[] {
                class1
            });
        } else
        {
            return convert;
        }
    }

    private Convert getConvert(Type type)
        throws Exception
    {
        Convert convert = (Convert)type.getAnnotation(org/simpleframework/xml/convert/Convert);
        if (convert != null && (Element)type.getAnnotation(org/simpleframework/xml/Element) == null)
        {
            throw new ConvertException("Element annotation required for %s", new Object[] {
                type
            });
        } else
        {
            return convert;
        }
    }

    private Convert getConvert(Type type, Class class1)
        throws Exception
    {
        Convert convert = getConvert(type);
        type = convert;
        if (convert == null)
        {
            type = getConvert(class1);
        }
        return type;
    }

    private Class getType(Type type, Object obj)
    {
        type = type.getType();
        if (obj != null)
        {
            type = obj.getClass();
        }
        return type;
    }

    private Class getType(Type type, Value value)
    {
        type = type.getType();
        if (value != null)
        {
            type = value.getType();
        }
        return type;
    }

    public Converter getConverter(Type type, Object obj)
        throws Exception
    {
        type = getConvert(type, getType(type, obj));
        if (type != null)
        {
            return factory.getInstance(type);
        } else
        {
            return null;
        }
    }

    public Converter getConverter(Type type, Value value)
        throws Exception
    {
        type = getConvert(type, getType(type, value));
        if (type != null)
        {
            return factory.getInstance(type);
        } else
        {
            return null;
        }
    }
}
