// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.select:
//            Evaluator, Elements

abstract class StructuralEvaluator extends Evaluator
{
    static class Has extends StructuralEvaluator
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

        public Has(Evaluator evaluator1)
        {
            evaluator = evaluator1;
        }
    }

    static class ImmediateParent extends StructuralEvaluator
    {

        public boolean matches(Element element, Element element1)
        {
            if (element != element1)
            {
                if ((element1 = element1.parent()) != null && evaluator.matches(element, element1))
                {
                    return true;
                }
            }
            return false;
        }

        public String toString()
        {
            return String.format(":ImmediateParent%s", new Object[] {
                evaluator
            });
        }

        public ImmediateParent(Evaluator evaluator1)
        {
            evaluator = evaluator1;
        }
    }

    static class ImmediatePreviousSibling extends StructuralEvaluator
    {

        public boolean matches(Element element, Element element1)
        {
            if (element != element1)
            {
                if ((element1 = element1.previousElementSibling()) != null && evaluator.matches(element, element1))
                {
                    return true;
                }
            }
            return false;
        }

        public String toString()
        {
            return String.format(":prev%s", new Object[] {
                evaluator
            });
        }

        public ImmediatePreviousSibling(Evaluator evaluator1)
        {
            evaluator = evaluator1;
        }
    }

    static class Not extends StructuralEvaluator
    {

        public boolean matches(Element element, Element element1)
        {
            return !evaluator.matches(element, element1);
        }

        public String toString()
        {
            return String.format(":not%s", new Object[] {
                evaluator
            });
        }

        public Not(Evaluator evaluator1)
        {
            evaluator = evaluator1;
        }
    }

    static class Parent extends StructuralEvaluator
    {

        public boolean matches(Element element, Element element1)
        {
            if (element != element1)
            {
                element1 = element1.parent();
                while (element1 != element) 
                {
                    if (evaluator.matches(element, element1))
                    {
                        return true;
                    }
                    element1 = element1.parent();
                }
            }
            return false;
        }

        public String toString()
        {
            return String.format(":parent%s", new Object[] {
                evaluator
            });
        }

        public Parent(Evaluator evaluator1)
        {
            evaluator = evaluator1;
        }
    }

    static class PreviousSibling extends StructuralEvaluator
    {

        public boolean matches(Element element, Element element1)
        {
            if (element != element1)
            {
                element1 = element1.previousElementSibling();
                while (element1 != null) 
                {
                    if (evaluator.matches(element, element1))
                    {
                        return true;
                    }
                    element1 = element1.previousElementSibling();
                }
            }
            return false;
        }

        public String toString()
        {
            return String.format(":prev*%s", new Object[] {
                evaluator
            });
        }

        public PreviousSibling(Evaluator evaluator1)
        {
            evaluator = evaluator1;
        }
    }

    static class Root extends Evaluator
    {

        public boolean matches(Element element, Element element1)
        {
            return element == element1;
        }

        Root()
        {
        }
    }


    Evaluator evaluator;

    StructuralEvaluator()
    {
    }
}
