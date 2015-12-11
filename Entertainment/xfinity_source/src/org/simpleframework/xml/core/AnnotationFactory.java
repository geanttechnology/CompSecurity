// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;

// Referenced classes of package org.simpleframework.xml.core:
//            AnnotationHandler

class AnnotationFactory
{

    private final boolean required;

    public AnnotationFactory()
    {
        this(true);
    }

    public AnnotationFactory(boolean flag)
    {
        required = flag;
    }

    private ClassLoader getClassLoader()
        throws Exception
    {
        return org/simpleframework/xml/core/AnnotationFactory.getClassLoader();
    }

    private Annotation getInstance(ClassLoader classloader, Class class1)
        throws Exception
    {
        AnnotationHandler annotationhandler = new AnnotationHandler(class1, required);
        return (Annotation)Proxy.newProxyInstance(classloader, new Class[] {
            class1
        }, annotationhandler);
    }

    public Annotation getInstance(Class class1)
        throws Exception
    {
        ClassLoader classloader = getClassLoader();
        if (java/util/Map.isAssignableFrom(class1))
        {
            return getInstance(classloader, org/simpleframework/xml/ElementMap);
        }
        if (java/util/Collection.isAssignableFrom(class1))
        {
            return getInstance(classloader, org/simpleframework/xml/ElementList);
        }
        if (class1.isArray())
        {
            return getInstance(classloader, org/simpleframework/xml/ElementArray);
        } else
        {
            return getInstance(classloader, org/simpleframework/xml/Element);
        }
    }
}
