// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

// Referenced classes of package org.simpleframework.xml.core:
//            GroupExtractor, CacheLabel, LabelMap, Label

private static class elements extends LinkedHashMap
    implements Iterable
{

    private final LabelMap elements;

    public Iterator iterator()
    {
        return values().iterator();
    }

    public void register(Class class1, String s, Label label)
        throws Exception
    {
        label = new CacheLabel(label);
        if (!elements.containsKey(s))
        {
            elements.put(s, label);
        }
        if (!containsKey(class1))
        {
            put(class1, label);
        }
    }

    public Label resolve(Class class1)
    {
        for (; class1 != null; class1 = class1.getSuperclass())
        {
            Label label = (Label)get(class1);
            if (label != null)
            {
                return label;
            }
        }

        return null;
    }

    public (LabelMap labelmap)
    {
        elements = labelmap;
    }
}
