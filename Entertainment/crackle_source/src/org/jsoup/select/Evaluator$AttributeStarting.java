// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.select:
//            Evaluator

public static final class keyPrefix extends Evaluator
{

    private String keyPrefix;

    public boolean matches(Element element, Element element1)
    {
        for (element = element1.attributes().asList().iterator(); element.hasNext();)
        {
            if (((Attribute)element.next()).getKey().startsWith(keyPrefix))
            {
                return true;
            }
        }

        return false;
    }

    public String toString()
    {
        return String.format("[^%s]", new Object[] {
            keyPrefix
        });
    }

    public (String s)
    {
        keyPrefix = s;
    }
}
