// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
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
//            ContactList, AnnotationFactory, Hierarchy, ContactMap, 
//            Contact, FieldContact

class FieldScanner extends ContactList
{

    private final DefaultType access;
    private final ContactMap done;
    private final AnnotationFactory factory;
    private final Hierarchy hierarchy;

    public FieldScanner(Class class1)
        throws Exception
    {
        this(class1, null);
    }

    public FieldScanner(Class class1, DefaultType defaulttype)
        throws Exception
    {
        this(class1, defaulttype, true);
    }

    public FieldScanner(Class class1, DefaultType defaulttype, boolean flag)
        throws Exception
    {
        factory = new AnnotationFactory(flag);
        hierarchy = new Hierarchy(class1);
        done = new ContactMap();
        access = defaulttype;
        scan(class1);
    }

    private void build()
    {
        for (Iterator iterator = done.iterator(); iterator.hasNext(); add((Contact)iterator.next())) { }
    }

    private boolean isStatic(Field field)
    {
        return Modifier.isStatic(field.getModifiers());
    }

    private void process(Field field, Class class1, Annotation aannotation[])
        throws Exception
    {
        class1 = factory.getInstance(class1);
        if (class1 != null)
        {
            process(field, ((Annotation) (class1)), aannotation);
        }
    }

    private void process(Field field, Annotation annotation, Annotation aannotation[])
    {
        annotation = new FieldContact(field, annotation, aannotation);
        if (!field.isAccessible())
        {
            field.setAccessible(true);
        }
        done.put(field, annotation);
    }

    private void remove(Field field, Annotation annotation)
    {
        done.remove(field);
    }

    private void scan(Class class1)
        throws Exception
    {
        for (Iterator iterator = hierarchy.iterator(); iterator.hasNext(); scan((Class)iterator.next(), access)) { }
        for (Iterator iterator1 = hierarchy.iterator(); iterator1.hasNext(); scan((Class)iterator1.next(), class1)) { }
        build();
    }

    private void scan(Class class1, Class class2)
    {
        class1 = class1.getDeclaredFields();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            scan(class1[i]);
        }

    }

    private void scan(Class class1, DefaultType defaulttype)
        throws Exception
    {
        class1 = class1.getDeclaredFields();
        if (defaulttype == DefaultType.FIELD)
        {
            int j = class1.length;
            for (int i = 0; i < j; i++)
            {
                defaulttype = class1[i];
                Annotation aannotation[] = defaulttype.getDeclaredAnnotations();
                Class class2 = defaulttype.getType();
                if (!isStatic(defaulttype))
                {
                    process(defaulttype, class2, aannotation);
                }
            }

        }
    }

    private void scan(Field field)
    {
        Annotation aannotation[] = field.getDeclaredAnnotations();
        int j = aannotation.length;
        for (int i = 0; i < j; i++)
        {
            scan(field, aannotation[i], aannotation);
        }

    }

    private void scan(Field field, Annotation annotation, Annotation aannotation[])
    {
        if (annotation instanceof Attribute)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementUnion)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementListUnion)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementMapUnion)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementList)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementArray)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof ElementMap)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof Element)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof Version)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof Text)
        {
            process(field, annotation, aannotation);
        }
        if (annotation instanceof Transient)
        {
            remove(field, annotation);
        }
    }
}
