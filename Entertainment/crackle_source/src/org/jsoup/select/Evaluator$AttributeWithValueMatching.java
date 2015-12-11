// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.select:
//            Evaluator

public static final class pattern extends Evaluator
{

    String key;
    Pattern pattern;

    public boolean matches(Element element, Element element1)
    {
        return element1.hasAttr(key) && pattern.matcher(element1.attr(key)).find();
    }

    public String toString()
    {
        return String.format("[%s~=%s]", new Object[] {
            key, pattern.toString()
        });
    }

    public (String s, Pattern pattern1)
    {
        key = s.trim().toLowerCase();
        pattern = pattern1;
    }
}
