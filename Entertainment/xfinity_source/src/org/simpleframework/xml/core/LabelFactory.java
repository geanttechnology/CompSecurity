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
import org.simpleframework.xml.Version;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            ElementLabel, ElementListLabel, ElementArrayLabel, ElementMapLabel, 
//            ElementUnionLabel, ElementListUnionLabel, ElementMapUnionLabel, AttributeLabel, 
//            VersionLabel, TextLabel, PersistenceException, CacheLabel, 
//            Label, Contact

final class LabelFactory
{
    private static class LabelBuilder
    {

        private final Class entry;
        private final Class label;
        private final Class type;

        private Constructor getConstructor(Class class1)
            throws Exception
        {
            return type.getConstructor(new Class[] {
                org/simpleframework/xml/core/Contact, class1, org/simpleframework/xml/stream/Format
            });
        }

        private Constructor getConstructor(Class class1, Class class2)
            throws Exception
        {
            return type.getConstructor(new Class[] {
                org/simpleframework/xml/core/Contact, class1, class2, org/simpleframework/xml/stream/Format
            });
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

        public LabelBuilder(Class class1, Class class2)
        {
            this(class1, class2, null);
        }

        public LabelBuilder(Class class1, Class class2, Class class3)
        {
            entry = class3;
            label = class2;
            type = class1;
        }
    }


    LabelFactory()
    {
    }

    private static LabelBuilder getBuilder(Annotation annotation)
        throws Exception
    {
        if (annotation instanceof Element)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementLabel, org/simpleframework/xml/Element);
        }
        if (annotation instanceof ElementList)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementListLabel, org/simpleframework/xml/ElementList);
        }
        if (annotation instanceof ElementArray)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementArrayLabel, org/simpleframework/xml/ElementArray);
        }
        if (annotation instanceof ElementMap)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementMapLabel, org/simpleframework/xml/ElementMap);
        }
        if (annotation instanceof ElementUnion)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementUnionLabel, org/simpleframework/xml/ElementUnion, org/simpleframework/xml/Element);
        }
        if (annotation instanceof ElementListUnion)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementListUnionLabel, org/simpleframework/xml/ElementListUnion, org/simpleframework/xml/ElementList);
        }
        if (annotation instanceof ElementMapUnion)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementMapUnionLabel, org/simpleframework/xml/ElementMapUnion, org/simpleframework/xml/ElementMap);
        }
        if (annotation instanceof Attribute)
        {
            return new LabelBuilder(org/simpleframework/xml/core/AttributeLabel, org/simpleframework/xml/Attribute);
        }
        if (annotation instanceof Version)
        {
            return new LabelBuilder(org/simpleframework/xml/core/VersionLabel, org/simpleframework/xml/Version);
        }
        if (annotation instanceof Text)
        {
            return new LabelBuilder(org/simpleframework/xml/core/TextLabel, org/simpleframework/xml/Text);
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

    public static Label getInstance(Contact contact, Annotation annotation, Annotation annotation1, Format format)
        throws Exception
    {
        contact = getLabel(contact, annotation, annotation1, format);
        if (contact == null)
        {
            return contact;
        } else
        {
            return new CacheLabel(contact);
        }
    }

    public static Label getInstance(Contact contact, Annotation annotation, Format format)
        throws Exception
    {
        return getInstance(contact, annotation, null, format);
    }

    private static Label getLabel(Contact contact, Annotation annotation, Annotation annotation1, Format format)
        throws Exception
    {
        Constructor constructor = getConstructor(annotation);
        if (annotation1 != null)
        {
            return (Label)constructor.newInstance(new Object[] {
                contact, annotation, annotation1, format
            });
        } else
        {
            return (Label)constructor.newInstance(new Object[] {
                contact, annotation, format
            });
        }
    }
}
