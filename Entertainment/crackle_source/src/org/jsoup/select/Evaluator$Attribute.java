// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.select:
//            Evaluator

public static final class key extends Evaluator
{

    private String key;

    public boolean matches(Element element, Element element1)
    {
        return element1.hasAttr(key);
    }

    public String toString()
    {
        return String.format("[%s]", new Object[] {
            key
        });
    }

    public (String s)
    {
        key = s;
    }
}
