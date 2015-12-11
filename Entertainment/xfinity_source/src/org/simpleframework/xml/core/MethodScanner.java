// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Transient;
import org.simpleframework.xml.Version;

// Referenced classes of package org.simpleframework.xml.core:
//            ContactList, MethodPartFactory, Hierarchy, MethodPart, 
//            MethodContact, MethodException, MethodType

class MethodScanner extends ContactList
{
    private static class PartMap extends LinkedHashMap
        implements Iterable
    {

        public Iterator iterator()
        {
            return keySet().iterator();
        }

        public MethodPart take(String s)
        {
            return (MethodPart)remove(s);
        }

        private PartMap()
        {
        }

    }


    private final DefaultType access;
    private final MethodPartFactory factory;
    private final Hierarchy hierarchy;
    private final PartMap read;
    private final Class type;
    private final PartMap write;

    public MethodScanner(Class class1)
        throws Exception
    {
        this(class1, null);
    }

    public MethodScanner(Class class1, DefaultType defaulttype)
        throws Exception
    {
        this(class1, defaulttype, true);
    }

    public MethodScanner(Class class1, DefaultType defaulttype, boolean flag)
        throws Exception
    {
        factory = new MethodPartFactory(flag);
        hierarchy = new Hierarchy(class1);
        write = new PartMap();
        read = new PartMap();
        access = defaulttype;
        type = class1;
        scan(class1);
    }

    private void build()
        throws Exception
    {
        Iterator iterator = read.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            MethodPart methodpart = (MethodPart)read.get(s);
            if (methodpart != null)
            {
                build(methodpart, s);
            }
        } while (true);
    }

    private void build(MethodPart methodpart)
        throws Exception
    {
        add(new MethodContact(methodpart));
    }

    private void build(MethodPart methodpart, String s)
        throws Exception
    {
        s = write.take(s);
        if (s != null)
        {
            build(methodpart, ((MethodPart) (s)));
            return;
        } else
        {
            build(methodpart);
            return;
        }
    }

    private void build(MethodPart methodpart, MethodPart methodpart1)
        throws Exception
    {
        Object obj = methodpart.getAnnotation();
        String s = methodpart.getName();
        if (!methodpart1.getAnnotation().equals(obj))
        {
            throw new MethodException("Annotations do not match for '%s' in %s", new Object[] {
                s, type
            });
        }
        obj = methodpart.getType();
        if (obj != methodpart1.getType())
        {
            throw new MethodException("Method types do not match for %s in %s", new Object[] {
                s, obj
            });
        } else
        {
            add(new MethodContact(methodpart, methodpart1));
            return;
        }
    }

    private void process(Method method, Annotation annotation, Annotation aannotation[])
        throws Exception
    {
        method = factory.getInstance(method, annotation, aannotation);
        annotation = method.getMethodType();
        if (annotation == MethodType.GET)
        {
            process(((MethodPart) (method)), read);
        }
        if (annotation == MethodType.IS)
        {
            process(((MethodPart) (method)), read);
        }
        if (annotation == MethodType.SET)
        {
            process(((MethodPart) (method)), write);
        }
    }

    private void process(Method method, Annotation aannotation[])
        throws Exception
    {
        method = factory.getInstance(method, aannotation);
        aannotation = method.getMethodType();
        if (aannotation == MethodType.GET)
        {
            process(((MethodPart) (method)), read);
        }
        if (aannotation == MethodType.IS)
        {
            process(((MethodPart) (method)), read);
        }
        if (aannotation == MethodType.SET)
        {
            process(((MethodPart) (method)), write);
        }
    }

    private void process(MethodPart methodpart, PartMap partmap)
    {
        String s = methodpart.getName();
        if (s != null)
        {
            partmap.put(s, methodpart);
        }
    }

    private void remove(Method method, Annotation annotation, Annotation aannotation[])
        throws Exception
    {
        method = factory.getInstance(method, annotation, aannotation);
        annotation = method.getMethodType();
        if (annotation == MethodType.GET)
        {
            remove(((MethodPart) (method)), read);
        }
        if (annotation == MethodType.IS)
        {
            remove(((MethodPart) (method)), read);
        }
        if (annotation == MethodType.SET)
        {
            remove(((MethodPart) (method)), write);
        }
    }

    private void remove(MethodPart methodpart, PartMap partmap)
        throws Exception
    {
        methodpart = methodpart.getName();
        if (methodpart != null)
        {
            partmap.remove(methodpart);
        }
    }

    private void scan(Class class1)
        throws Exception
    {
        for (Iterator iterator = hierarchy.iterator(); iterator.hasNext(); scan((Class)iterator.next(), access)) { }
        for (Iterator iterator1 = hierarchy.iterator(); iterator1.hasNext(); scan((Class)iterator1.next(), class1)) { }
        build();
        validate();
    }

    private void scan(Class class1, Class class2)
        throws Exception
    {
        class1 = class1.getDeclaredMethods();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            scan(class1[i]);
        }

    }

    private void scan(Class class1, DefaultType defaulttype)
        throws Exception
    {
        class1 = class1.getDeclaredMethods();
        if (defaulttype == DefaultType.PROPERTY)
        {
            int j = class1.length;
            for (int i = 0; i < j; i++)
            {
                defaulttype = class1[i];
                Annotation aannotation[] = defaulttype.getDeclaredAnnotations();
                if (factory.getType(defaulttype) != null)
                {
                    process(defaulttype, aannotation);
                }
            }

        }
    }

    private void scan(Method method)
        throws Exception
    {
        Annotation aannotation[] = method.getDeclaredAnnotations();
        int j = aannotation.length;
        for (int i = 0; i < j; i++)
        {
            scan(method, aannotation[i], aannotation);
        }

    }

    private void scan(Method method, Annotation annotation, Annotation aannotation[])
        throws Exception
    {
        if (annotation instanceof Attribute)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementUnion)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementListUnion)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementMapUnion)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementList)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementArray)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof ElementMap)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof Element)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof Version)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof Text)
        {
            process(method, annotation, aannotation);
        }
        if (annotation instanceof Transient)
        {
            remove(method, annotation, aannotation);
        }
    }

    private void validate()
        throws Exception
    {
        Iterator iterator = write.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            MethodPart methodpart = (MethodPart)write.get(s);
            if (methodpart != null)
            {
                validate(methodpart, s);
            }
        } while (true);
    }

    private void validate(MethodPart methodpart, String s)
        throws Exception
    {
        s = read.take(s);
        methodpart = methodpart.getMethod();
        if (s == null)
        {
            throw new MethodException("No matching get method for %s in %s", new Object[] {
                methodpart, type
            });
        } else
        {
            return;
        }
    }
}
