// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Group, ExtractorFactory, LabelMap, Extractor, 
//            Label, Contact, CacheLabel

class GroupExtractor
    implements Group
{
    private static class Registry extends LinkedHashMap
        implements Iterable
    {

        private final LabelMap elements;

        public Iterator iterator()
        {
            return values().iterator();
        }

        public void register(Class class1, String s, Label label1)
            throws Exception
        {
            label1 = new CacheLabel(label1);
            if (!elements.containsKey(s))
            {
                elements.put(s, label1);
            }
            if (!containsKey(class1))
            {
                put(class1, label1);
            }
        }

        public Label resolve(Class class1)
        {
            for (; class1 != null; class1 = class1.getSuperclass())
            {
                Label label1 = (Label)get(class1);
                if (label1 != null)
                {
                    return label1;
                }
            }

            return null;
        }

        public Registry(LabelMap labelmap)
        {
            elements = labelmap;
        }
    }


    private final LabelMap elements = new LabelMap();
    private final ExtractorFactory factory;
    private final Annotation label;
    private final Registry registry;

    public GroupExtractor(Contact contact, Annotation annotation, Format format)
        throws Exception
    {
        factory = new ExtractorFactory(contact, annotation, format);
        registry = new Registry(elements);
        label = annotation;
        extract();
    }

    private void extract()
        throws Exception
    {
        Extractor extractor = factory.getInstance();
        if (extractor != null)
        {
            extract(extractor);
        }
    }

    private void extract(Extractor extractor)
        throws Exception
    {
        Annotation aannotation[] = extractor.getAnnotations();
        int j = aannotation.length;
        for (int i = 0; i < j; i++)
        {
            extract(extractor, aannotation[i]);
        }

    }

    private void extract(Extractor extractor, Annotation annotation)
        throws Exception
    {
        Label label1 = extractor.getLabel(annotation);
        extractor = extractor.getType(annotation);
        annotation = label1.getName();
        if (registry != null)
        {
            registry.register(extractor, annotation, label1);
        }
    }

    public LabelMap getElements()
        throws Exception
    {
        return elements.getLabels();
    }

    public Label getLabel(Class class1)
    {
        return registry.resolve(class1);
    }

    public String[] getNames()
        throws Exception
    {
        return elements.getKeys();
    }

    public String[] getPaths()
        throws Exception
    {
        return elements.getPaths();
    }

    public boolean isDeclared(Class class1)
    {
        return registry.containsKey(class1);
    }

    public boolean isInline()
    {
        Iterator iterator = registry.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (((Label)iterator.next()).isInline()) goto _L4; else goto _L3
_L3:
        return false;
_L2:
        if (!registry.isEmpty())
        {
            return true;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public boolean isValid(Class class1)
    {
        return registry.resolve(class1) != null;
    }

    public String toString()
    {
        return label.toString();
    }
}
