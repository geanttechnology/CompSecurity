// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

// Referenced classes of package org.jsoup.select:
//            Elements, NodeTraversor, Evaluator, NodeVisitor

public class Collector
{
    private static class Accumulator
        implements NodeVisitor
    {

        private final Elements elements;
        private final Evaluator eval;
        private final Element root;

        public void head(Node node, int i)
        {
            if (node instanceof Element)
            {
                node = (Element)node;
                if (eval.matches(root, node))
                {
                    elements.add(node);
                }
            }
        }

        public void tail(Node node, int i)
        {
        }

        Accumulator(Element element, Elements elements1, Evaluator evaluator)
        {
            root = element;
            elements = elements1;
            eval = evaluator;
        }
    }


    private Collector()
    {
    }

    public static Elements collect(Evaluator evaluator, Element element)
    {
        Elements elements = new Elements();
        (new NodeTraversor(new Accumulator(element, elements, evaluator))).traverse(element);
        return elements;
    }
}
