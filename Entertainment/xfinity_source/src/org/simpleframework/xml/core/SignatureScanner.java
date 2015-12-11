// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
//            SignatureBuilder, ParameterFactory, UnionException, Parameter, 
//            ParameterMap, Signature, ConstructorException

class SignatureScanner
{

    private final SignatureBuilder builder;
    private final Constructor factory;
    private final Format format;
    private final ParameterMap registry;
    private final Class type;

    public SignatureScanner(Constructor constructor, ParameterMap parametermap, Format format1)
        throws Exception
    {
        builder = new SignatureBuilder(constructor);
        type = constructor.getDeclaringClass();
        registry = parametermap;
        factory = constructor;
        format = format1;
        scan(type);
    }

    private List create(Annotation annotation, int i)
        throws Exception
    {
        annotation = ParameterFactory.getInstance(factory, annotation, format, i);
        if (annotation != null)
        {
            register(annotation);
        }
        return Collections.singletonList(annotation);
    }

    private Annotation[] extract(Annotation annotation)
        throws Exception
    {
        Method amethod[] = annotation.annotationType().getDeclaredMethods();
        if (amethod.length != 1)
        {
            throw new UnionException("Annotation '%s' is not a valid union for %s", new Object[] {
                annotation, type
            });
        } else
        {
            return (Annotation[])(Annotation[])amethod[0].invoke(annotation, new Object[0]);
        }
    }

    private List process(Annotation annotation, int i)
        throws Exception
    {
        if (annotation instanceof Attribute)
        {
            return create(annotation, i);
        }
        if (annotation instanceof Element)
        {
            return create(annotation, i);
        }
        if (annotation instanceof ElementList)
        {
            return create(annotation, i);
        }
        if (annotation instanceof ElementArray)
        {
            return create(annotation, i);
        }
        if (annotation instanceof ElementMap)
        {
            return create(annotation, i);
        }
        if (annotation instanceof ElementListUnion)
        {
            return union(annotation, i);
        }
        if (annotation instanceof ElementMapUnion)
        {
            return union(annotation, i);
        }
        if (annotation instanceof ElementUnion)
        {
            return union(annotation, i);
        }
        if (annotation instanceof Text)
        {
            return create(annotation, i);
        } else
        {
            return Collections.emptyList();
        }
    }

    private void register(Parameter parameter)
        throws Exception
    {
        String s = parameter.getPath();
        Object obj = parameter.getKey();
        if (registry.containsKey(obj))
        {
            validate(parameter, obj);
        }
        if (registry.containsKey(s))
        {
            validate(parameter, s);
        }
        registry.put(s, parameter);
        registry.put(obj, parameter);
    }

    private void scan(Class class1)
        throws Exception
    {
        class1 = factory.getParameterTypes();
        for (int i = 0; i < class1.length; i++)
        {
            scan(class1[i], i);
        }

    }

    private void scan(Class class1, int i)
        throws Exception
    {
        class1 = factory.getParameterAnnotations();
        for (int j = 0; j < class1[i].length; j++)
        {
            Parameter parameter;
            for (Iterator iterator = process(class1[i][j], i).iterator(); iterator.hasNext(); builder.insert(parameter, i))
            {
                parameter = (Parameter)iterator.next();
            }

        }

    }

    private List union(Annotation annotation, int i)
        throws Exception
    {
        Signature signature = new Signature(factory);
        Annotation aannotation[] = extract(annotation);
        int k = aannotation.length;
        for (int j = 0; j < k; j++)
        {
            Object obj = aannotation[j];
            obj = ParameterFactory.getInstance(factory, annotation, ((Annotation) (obj)), format, i);
            String s = ((Parameter) (obj)).getPath();
            if (signature.contains(s))
            {
                throw new UnionException("Annotation name '%s' used more than once in %s for %s", new Object[] {
                    s, annotation, type
                });
            }
            signature.set(s, ((Parameter) (obj)));
            register(((Parameter) (obj)));
        }

        return signature.getAll();
    }

    private void validate(Parameter parameter, Object obj)
        throws Exception
    {
        obj = (Parameter)registry.get(obj);
        if (parameter.isText() != ((Parameter) (obj)).isText())
        {
            Annotation annotation = parameter.getAnnotation();
            Annotation annotation1 = ((Parameter) (obj)).getAnnotation();
            String s = parameter.getPath();
            if (!annotation.equals(annotation1))
            {
                throw new ConstructorException("Annotations do not match for '%s' in %s", new Object[] {
                    s, type
                });
            }
            if (((Parameter) (obj)).getType() != parameter.getType())
            {
                throw new ConstructorException("Parameter types do not match for '%s' in %s", new Object[] {
                    s, type
                });
            }
        }
    }

    public List getSignatures()
        throws Exception
    {
        return builder.build();
    }

    public boolean isValid()
    {
        return builder.isValid();
    }
}
