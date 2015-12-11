// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Extractor, ExtractorFactory, ElementLabel, Contact, 
//            Label

private static class union
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

    public (Contact contact1, ElementUnion elementunion, Format format1)
        throws Exception
    {
        contact = contact1;
        format = format1;
        union = elementunion;
    }
}
