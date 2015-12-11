// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.select:
//            StructuralEvaluator, Elements, Evaluator

static class evaluator extends StructuralEvaluator
{

    public boolean matches(Element element, Element element1)
    {
        for (Iterator iterator = element1.getAllElements().iterator(); iterator.hasNext();)
        {
            Element element2 = (Element)iterator.next();
            if (element2 != element1 && evaluator.matches(element, element2))
            {
                return true;
            }
        }

        return false;
    }

    public String toString()
    {
        return String.format(":has(%s)", new Object[] {
            evaluator
        });
    }

    public (Evaluator evaluator)
    {
        this.evaluator = evaluator;
    }
}
