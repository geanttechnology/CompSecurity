// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.select:
//            Evaluator

public static final class  extends 
{

    public boolean matches(Element element, Element element1)
    {
        return element1.hasAttr(key) && element1.attr(key).toLowerCase().contains(value);
    }

    public String toString()
    {
        return String.format("[%s*=%s]", new Object[] {
            key, value
        });
    }

    public (String s, String s1)
    {
        super(s, s1);
    }
}
