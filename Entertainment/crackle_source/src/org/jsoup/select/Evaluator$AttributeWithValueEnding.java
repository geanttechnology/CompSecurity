// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.select:
//            Evaluator

public static final class _cls9 extends _cls9
{

    public boolean matches(Element element, Element element1)
    {
        return element1.hasAttr(key) && element1.attr(key).toLowerCase().endsWith(value);
    }

    public String toString()
    {
        return String.format("[%s$=%s]", new Object[] {
            key, value
        });
    }

    public _cls9(String s, String s1)
    {
        super(s, s1);
    }
}
