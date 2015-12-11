// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;
import org.simpleframework.xml.transform.Transformer;

// Referenced classes of package org.simpleframework.xml.core:
//            EmptyMatcher, ScannerFactory, InstanceFactory, Reflector, 
//            Scanner, Instance

class Support
    implements Filter
{

    private final InstanceFactory creator;
    private final ScannerFactory factory;
    private final Filter filter;
    private final Format format;
    private final Matcher matcher;
    private final Transformer transform;

    public Support()
    {
        this(((Filter) (new PlatformFilter())));
    }

    public Support(Filter filter1)
    {
        this(filter1, ((Matcher) (new EmptyMatcher())));
    }

    public Support(Filter filter1, Matcher matcher1)
    {
        this(filter1, matcher1, new Format());
    }

    public Support(Filter filter1, Matcher matcher1, Format format1)
    {
        factory = new ScannerFactory(this, format1);
        transform = new Transformer(matcher1);
        creator = new InstanceFactory();
        matcher = matcher1;
        filter = filter1;
        format = format1;
    }

    private String getClassName(Class class1)
        throws Exception
    {
        Class class2 = class1;
        if (class1.isArray())
        {
            class2 = class1.getComponentType();
        }
        class1 = class2.getSimpleName();
        if (class2.isPrimitive())
        {
            return class1;
        } else
        {
            return Reflector.getName(class1);
        }
    }

    public static Class getPrimitive(Class class1)
    {
        Class class2;
        if (class1 == Double.TYPE)
        {
            class2 = java/lang/Double;
        } else
        {
            if (class1 == Float.TYPE)
            {
                return java/lang/Float;
            }
            if (class1 == Integer.TYPE)
            {
                return java/lang/Integer;
            }
            if (class1 == Long.TYPE)
            {
                return java/lang/Long;
            }
            if (class1 == Boolean.TYPE)
            {
                return java/lang/Boolean;
            }
            if (class1 == Character.TYPE)
            {
                return java/lang/Character;
            }
            if (class1 == Short.TYPE)
            {
                return java/lang/Short;
            }
            class2 = class1;
            if (class1 == Byte.TYPE)
            {
                return java/lang/Byte;
            }
        }
        return class2;
    }

    public static boolean isAssignable(Class class1, Class class2)
    {
        Class class3 = class1;
        if (class1.isPrimitive())
        {
            class3 = getPrimitive(class1);
        }
        class1 = class2;
        if (class2.isPrimitive())
        {
            class1 = getPrimitive(class2);
        }
        return class1.isAssignableFrom(class3);
    }

    public static boolean isFloat(Class class1)
        throws Exception
    {
        while (class1 == java/lang/Double || class1 == java/lang/Float || class1 == Float.TYPE || class1 == Double.TYPE) 
        {
            return true;
        }
        return false;
    }

    public Instance getInstance(Class class1)
    {
        return creator.getInstance(class1);
    }

    public Instance getInstance(Value value)
    {
        return creator.getInstance(value);
    }

    public String getName(Class class1)
        throws Exception
    {
        String s = getScanner(class1).getName();
        if (s != null)
        {
            return s;
        } else
        {
            return getClassName(class1);
        }
    }

    public Scanner getScanner(Class class1)
        throws Exception
    {
        return factory.getInstance(class1);
    }

    public Style getStyle()
    {
        return format.getStyle();
    }

    public Transform getTransform(Class class1)
        throws Exception
    {
        return matcher.match(class1);
    }

    public boolean isPrimitive(Class class1)
        throws Exception
    {
        while (class1 == java/lang/String || class1 == java/lang/Float || class1 == java/lang/Double || class1 == java/lang/Long || class1 == java/lang/Integer || class1 == java/lang/Boolean || class1.isEnum() || class1.isPrimitive()) 
        {
            return true;
        }
        return transform.valid(class1);
    }

    public Object read(String s, Class class1)
        throws Exception
    {
        return transform.read(s, class1);
    }

    public String replace(String s)
    {
        return filter.replace(s);
    }

    public boolean valid(Class class1)
        throws Exception
    {
        return transform.valid(class1);
    }

    public String write(Object obj, Class class1)
        throws Exception
    {
        return transform.write(obj, class1);
    }
}
