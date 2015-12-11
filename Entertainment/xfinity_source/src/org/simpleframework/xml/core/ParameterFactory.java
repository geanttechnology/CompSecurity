// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            ElementParameter, ElementListParameter, ElementArrayParameter, ElementMapUnionParameter, 
//            ElementListUnionParameter, ElementUnionParameter, ElementMapParameter, AttributeParameter, 
//            TextParameter, PersistenceException, Parameter

final class ParameterFactory
{
    private static class ParameterBuilder
    {

        private final Class entry;
        private final Class label;
        private final Class type;

        private transient Constructor getConstructor(Class aclass[])
            throws Exception
        {
            return type.getConstructor(aclass);
        }

        public Constructor getConstructor()
            throws Exception
        {
            if (entry != null)
            {
                return getConstructor(label, entry);
            } else
            {
                return getConstructor(label);
            }
        }

        public Constructor getConstructor(Class class1)
            throws Exception
        {
            return getConstructor(new Class[] {
                java/lang/reflect/Constructor, class1, org/simpleframework/xml/stream/Format, Integer.TYPE
            });
        }

        public Constructor getConstructor(Class class1, Class class2)
            throws Exception
        {
            return getConstructor(new Class[] {
                java/lang/reflect/Constructor, class1, class2, org/simpleframework/xml/stream/Format, Integer.TYPE
            });
        }

        public ParameterBuilder(Class class1, Class class2)
        {
            this(class1, class2, null);
        }

        public ParameterBuilder(Class class1, Class class2, Class class3)
        {
            label = class2;
            entry = class3;
            type = class1;
        }
    }


    ParameterFactory()
    {
    }

    private static ParameterBuilder getBuilder(Annotation annotation)
        throws Exception
    {
        if (annotation instanceof Element)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementParameter, org/simpleframework/xml/Element);
        }
        if (annotation instanceof ElementList)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementListParameter, org/simpleframework/xml/ElementList);
        }
        if (annotation instanceof ElementArray)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementArrayParameter, org/simpleframework/xml/ElementArray);
        }
        if (annotation instanceof ElementMapUnion)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementMapUnionParameter, org/simpleframework/xml/ElementMapUnion, org/simpleframework/xml/ElementMap);
        }
        if (annotation instanceof ElementListUnion)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementListUnionParameter, org/simpleframework/xml/ElementListUnion, org/simpleframework/xml/ElementList);
        }
        if (annotation instanceof ElementUnion)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementUnionParameter, org/simpleframework/xml/ElementUnion, org/simpleframework/xml/Element);
        }
        if (annotation instanceof ElementMap)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementMapParameter, org/simpleframework/xml/ElementMap);
        }
        if (annotation instanceof Attribute)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/AttributeParameter, org/simpleframework/xml/Attribute);
        }
        if (annotation instanceof Text)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/TextParameter, org/simpleframework/xml/Text);
        } else
        {
            throw new PersistenceException("Annotation %s not supported", new Object[] {
                annotation
            });
        }
    }

    private static Constructor getConstructor(Annotation annotation)
        throws Exception
    {
        annotation = getBuilder(annotation).getConstructor();
        if (!annotation.isAccessible())
        {
            annotation.setAccessible(true);
        }
        return annotation;
    }

    public static Parameter getInstance(Constructor constructor, Annotation annotation, Annotation annotation1, Format format, int i)
        throws Exception
    {
        Constructor constructor1 = getConstructor(annotation);
        if (annotation1 != null)
        {
            return (Parameter)constructor1.newInstance(new Object[] {
                constructor, annotation, annotation1, format, Integer.valueOf(i)
            });
        } else
        {
            return (Parameter)constructor1.newInstance(new Object[] {
                constructor, annotation, format, Integer.valueOf(i)
            });
        }
    }

    public static Parameter getInstance(Constructor constructor, Annotation annotation, Format format, int i)
        throws Exception
    {
        return getInstance(constructor, annotation, null, format, i);
    }
}
