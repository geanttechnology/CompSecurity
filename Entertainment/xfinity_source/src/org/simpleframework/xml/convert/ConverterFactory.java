// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.convert;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.convert:
//            ConvertException, Converter, Convert

class ConverterFactory
{

    private final Cache cache = new ConcurrentCache();

    public ConverterFactory()
    {
    }

    private Constructor getConstructor(Class class1)
        throws Exception
    {
        class1 = class1.getDeclaredConstructor(new Class[0]);
        if (!class1.isAccessible())
        {
            class1.setAccessible(true);
        }
        return class1;
    }

    private Converter getConverter(Class class1)
        throws Exception
    {
        Constructor constructor = getConstructor(class1);
        if (constructor == null)
        {
            throw new ConvertException("No default constructor for %s", new Object[] {
                class1
            });
        } else
        {
            return getConverter(class1, constructor);
        }
    }

    private Converter getConverter(Class class1, Constructor constructor)
        throws Exception
    {
        constructor = (Converter)constructor.newInstance(new Object[0]);
        if (constructor != null)
        {
            cache.cache(class1, constructor);
        }
        return constructor;
    }

    public Converter getInstance(Class class1)
        throws Exception
    {
        Converter converter1 = (Converter)cache.fetch(class1);
        Converter converter = converter1;
        if (converter1 == null)
        {
            converter = getConverter(class1);
        }
        return converter;
    }

    public Converter getInstance(Convert convert)
        throws Exception
    {
        convert = convert.value();
        if (convert.isInterface())
        {
            throw new ConvertException("Can not instantiate %s", new Object[] {
                convert
            });
        } else
        {
            return getInstance(((Class) (convert)));
        }
    }
}
