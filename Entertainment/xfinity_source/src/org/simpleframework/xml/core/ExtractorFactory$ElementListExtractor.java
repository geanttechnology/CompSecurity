// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Extractor, ExtractorFactory, ElementListLabel, Contact, 
//            Label

private static class union
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

    public (Contact contact1, ElementListUnion elementlistunion, Format format1)
        throws Exception
    {
        contact = contact1;
        format = format1;
        union = elementlistunion;
    }
}
