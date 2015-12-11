// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.select:
//            QueryParser, Elements, Collector, Evaluator

public class Selector
{
    public static class SelectorParseException extends IllegalStateException
    {

        public transient SelectorParseException(String s, Object aobj[])
        {
            super(String.format(s, aobj));
        }
    }


    private final Evaluator evaluator;
    private final Element root;

    private Selector(String s, Element element)
    {
        Validate.notNull(s);
        s = s.trim();
        Validate.notEmpty(s);
        Validate.notNull(element);
        evaluator = QueryParser.parse(s);
        root = element;
    }

    static Elements filterOut(Collection collection, Collection collection1)
    {
        Elements elements = new Elements();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Element element = (Element)collection.next();
            boolean flag1 = false;
            Iterator iterator = collection1.iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break;
                }
                if (!element.equals((Element)iterator.next()))
                {
                    continue;
                }
                flag = true;
                break;
            } while (true);
            if (!flag)
            {
                elements.add(element);
            }
        } while (true);
        return elements;
    }

    private Elements select()
    {
        return Collector.collect(evaluator, root);
    }

    public static Elements select(String s, Iterable iterable)
    {
        Validate.notEmpty(s);
        Validate.notNull(iterable);
        LinkedHashSet linkedhashset = new LinkedHashSet();
        for (iterable = iterable.iterator(); iterable.hasNext(); linkedhashset.addAll(select(s, (Element)iterable.next()))) { }
        return new Elements(linkedhashset);
    }

    public static Elements select(String s, Element element)
    {
        return (new Selector(s, element)).select();
    }
}
