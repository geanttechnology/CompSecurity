// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Extractor, ExtractorFactory, ElementMapLabel, Contact, 
//            Label

private static class union
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

    public (Contact contact1, ElementMapUnion elementmapunion, Format format1)
        throws Exception
    {
        contact = contact1;
        format = format1;
        union = elementmapunion;
    }
}
