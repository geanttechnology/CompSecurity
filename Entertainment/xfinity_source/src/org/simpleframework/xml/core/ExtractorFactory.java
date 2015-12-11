// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            PersistenceException, Extractor, Contact, ElementLabel, 
//            Label, ElementListLabel, ElementMapLabel

class ExtractorFactory
{
    private static class ElementExtractor
        implements Extractor
    {

        private final Contact contact;
        private final Format format;
        private final ElementUnion union;

        public volatile Annotation[] getAnnotations()
            throws Exception
        {
            return getAnnotations();
        }

        public Element[] getAnnotations()
        {
            return union.value();
        }

        public volatile Label getLabel(Annotation annotation)
            throws Exception
        {
            return getLabel((Element)annotation);
        }

        public Label getLabel(Element element)
        {
            return new ElementLabel(contact, element, format);
        }

        public volatile Class getType(Annotation annotation)
            throws Exception
        {
            return getType((Element)annotation);
        }

        public Class getType(Element element)
        {
            Class class1 = element.type();
            element = class1;
            if (class1 == Void.TYPE)
            {
                element = contact.getType();
            }
            return element;
        }

        public ElementExtractor(Contact contact1, ElementUnion elementunion, Format format1)
            throws Exception
        {
            contact = contact1;
            format = format1;
            union = elementunion;
        }
    }

    private static class ElementListExtractor
        implements Extractor
    {

        private final Contact contact;
        private final Format format;
        private final ElementListUnion union;

        public volatile Annotation[] getAnnotations()
            throws Exception
        {
            return getAnnotations();
        }

        public ElementList[] getAnnotations()
        {
            return union.value();
        }

        public volatile Label getLabel(Annotation annotation)
            throws Exception
        {
            return getLabel((ElementList)annotation);
        }

        public Label getLabel(ElementList elementlist)
        {
            return new ElementListLabel(contact, elementlist, format);
        }

        public volatile Class getType(Annotation annotation)
            throws Exception
        {
            return getType((ElementList)annotation);
        }

        public Class getType(ElementList elementlist)
        {
            return elementlist.type();
        }

        public ElementListExtractor(Contact contact1, ElementListUnion elementlistunion, Format format1)
            throws Exception
        {
            contact = contact1;
            format = format1;
            union = elementlistunion;
        }
    }

    private static class ElementMapExtractor
        implements Extractor
    {

        private final Contact contact;
        private final Format format;
        private final ElementMapUnion union;

        public volatile Annotation[] getAnnotations()
            throws Exception
        {
            return getAnnotations();
        }

        public ElementMap[] getAnnotations()
        {
            return union.value();
        }

        public volatile Label getLabel(Annotation annotation)
            throws Exception
        {
            return getLabel((ElementMap)annotation);
        }

        public Label getLabel(ElementMap elementmap)
        {
            return new ElementMapLabel(contact, elementmap, format);
        }

        public volatile Class getType(Annotation annotation)
            throws Exception
        {
            return getType((ElementMap)annotation);
        }

        public Class getType(ElementMap elementmap)
        {
            return elementmap.valueType();
        }

        public ElementMapExtractor(Contact contact1, ElementMapUnion elementmapunion, Format format1)
            throws Exception
        {
            contact = contact1;
            format = format1;
            union = elementmapunion;
        }
    }

    private static class ExtractorBuilder
    {

        private final Class label;
        private final Class type;

        private Constructor getConstructor()
            throws Exception
        {
            return type.getConstructor(new Class[] {
                org/simpleframework/xml/core/Contact, label, org/simpleframework/xml/stream/Format
            });
        }


        public ExtractorBuilder(Class class1, Class class2)
        {
            label = class1;
            type = class2;
        }
    }


    private final Contact contact;
    private final Format format;
    private final Annotation label;

    public ExtractorFactory(Contact contact1, Annotation annotation, Format format1)
    {
        contact = contact1;
        format = format1;
        label = annotation;
    }

    private ExtractorBuilder getBuilder(Annotation annotation)
        throws Exception
    {
        if (annotation instanceof ElementUnion)
        {
            return new ExtractorBuilder(org/simpleframework/xml/ElementUnion, org/simpleframework/xml/core/ExtractorFactory$ElementExtractor);
        }
        if (annotation instanceof ElementListUnion)
        {
            return new ExtractorBuilder(org/simpleframework/xml/ElementListUnion, org/simpleframework/xml/core/ExtractorFactory$ElementListExtractor);
        }
        if (annotation instanceof ElementMapUnion)
        {
            return new ExtractorBuilder(org/simpleframework/xml/ElementMapUnion, org/simpleframework/xml/core/ExtractorFactory$ElementMapExtractor);
        } else
        {
            throw new PersistenceException("Annotation %s is not a union", new Object[] {
                annotation
            });
        }
    }

    private Object getInstance(Annotation annotation)
        throws Exception
    {
        Constructor constructor = getBuilder(annotation).getConstructor();
        if (!constructor.isAccessible())
        {
            constructor.setAccessible(true);
        }
        return constructor.newInstance(new Object[] {
            contact, annotation, format
        });
    }

    public Extractor getInstance()
        throws Exception
    {
        return (Extractor)getInstance(label);
    }
}
