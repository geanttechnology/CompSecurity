// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.select:
//            CombiningEvaluator, Evaluator

static final class evaluators extends CombiningEvaluator
{

    public void add(Evaluator evaluator)
    {
        evaluators.add(evaluator);
    }

    public boolean matches(Element element, Element element1)
    {
        for (Iterator iterator = evaluators.iterator(); iterator.hasNext();)
        {
            if (((Evaluator)iterator.next()).matches(element, element1))
            {
                return true;
            }
        }

        return false;
    }

    public String toString()
    {
        return String.format(":or%s", new Object[] {
            evaluators
        });
    }

    ()
    {
    }

    (Collection collection)
    {
        if (collection.size() > 1)
        {
            evaluators.add(new (collection));
            return;
        } else
        {
            evaluators.addAll(collection);
            return;
        }
    }
}
