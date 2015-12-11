// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public abstract class Evaluator
{
    public static final class AllElements extends Evaluator
    {

        public boolean matches(Element element, Element element1)
        {
            return true;
        }

        public String toString()
        {
            return "*";
        }

        public AllElements()
        {
        }
    }

    public static final class Attribute extends Evaluator
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

        public Attribute(String s)
        {
            key = s;
        }
    }

    public static abstract class AttributeKeyPair extends Evaluator
    {

        String key;
        String value;

        public AttributeKeyPair(String s, String s1)
        {
            Validate.notEmpty(s);
            Validate.notEmpty(s1);
            key = s.trim().toLowerCase();
            value = s1.trim().toLowerCase();
        }
    }

    public static final class AttributeStarting extends Evaluator
    {

        private String keyPrefix;

        public boolean matches(Element element, Element element1)
        {
            for (element = element1.attributes().asList().iterator(); element.hasNext();)
            {
                if (((org.jsoup.nodes.Attribute)element.next()).getKey().startsWith(keyPrefix))
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

        public AttributeStarting(String s)
        {
            keyPrefix = s;
        }
    }

    public static final class AttributeWithValue extends AttributeKeyPair
    {

        public boolean matches(Element element, Element element1)
        {
            return element1.hasAttr(key) && value.equalsIgnoreCase(element1.attr(key));
        }

        public String toString()
        {
            return String.format("[%s=%s]", new Object[] {
                key, value
            });
        }

        public AttributeWithValue(String s, String s1)
        {
            super(s, s1);
        }
    }

    public static final class AttributeWithValueContaining extends AttributeKeyPair
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

        public AttributeWithValueContaining(String s, String s1)
        {
            super(s, s1);
        }
    }

    public static final class AttributeWithValueEnding extends AttributeKeyPair
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

        public AttributeWithValueEnding(String s, String s1)
        {
            super(s, s1);
        }
    }

    public static final class AttributeWithValueMatching extends Evaluator
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

        public AttributeWithValueMatching(String s, Pattern pattern1)
        {
            key = s.trim().toLowerCase();
            pattern = pattern1;
        }
    }

    public static final class AttributeWithValueNot extends AttributeKeyPair
    {

        public boolean matches(Element element, Element element1)
        {
            return !value.equalsIgnoreCase(element1.attr(key));
        }

        public String toString()
        {
            return String.format("[%s!=%s]", new Object[] {
                key, value
            });
        }

        public AttributeWithValueNot(String s, String s1)
        {
            super(s, s1);
        }
    }

    public static final class AttributeWithValueStarting extends AttributeKeyPair
    {

        public boolean matches(Element element, Element element1)
        {
            return element1.hasAttr(key) && element1.attr(key).toLowerCase().startsWith(value);
        }

        public String toString()
        {
            return String.format("[%s^=%s]", new Object[] {
                key, value
            });
        }

        public AttributeWithValueStarting(String s, String s1)
        {
            super(s, s1);
        }
    }

    public static final class Class extends Evaluator
    {

        private String className;

        public boolean matches(Element element, Element element1)
        {
            return element1.hasClass(className);
        }

        public String toString()
        {
            return String.format(".%s", new Object[] {
                className
            });
        }

        public Class(String s)
        {
            className = s;
        }
    }

    public static final class ContainsOwnText extends Evaluator
    {

        private String searchText;

        public boolean matches(Element element, Element element1)
        {
            return element1.ownText().toLowerCase().contains(searchText);
        }

        public String toString()
        {
            return String.format(":containsOwn(%s", new Object[] {
                searchText
            });
        }

        public ContainsOwnText(String s)
        {
            searchText = s.toLowerCase();
        }
    }

    public static final class ContainsText extends Evaluator
    {

        private String searchText;

        public boolean matches(Element element, Element element1)
        {
            return element1.text().toLowerCase().contains(searchText);
        }

        public String toString()
        {
            return String.format(":contains(%s", new Object[] {
                searchText
            });
        }

        public ContainsText(String s)
        {
            searchText = s.toLowerCase();
        }
    }

    public static final class Id extends Evaluator
    {

        private String id;

        public boolean matches(Element element, Element element1)
        {
            return id.equals(element1.id());
        }

        public String toString()
        {
            return String.format("#%s", new Object[] {
                id
            });
        }

        public Id(String s)
        {
            id = s;
        }
    }

    public static final class IndexEquals extends IndexEvaluator
    {

        public boolean matches(Element element, Element element1)
        {
            return element1.elementSiblingIndex().intValue() == index;
        }

        public String toString()
        {
            return String.format(":eq(%d)", new Object[] {
                Integer.valueOf(index)
            });
        }

        public IndexEquals(int i)
        {
            super(i);
        }
    }

    public static abstract class IndexEvaluator extends Evaluator
    {

        int index;

        public IndexEvaluator(int i)
        {
            index = i;
        }
    }

    public static final class IndexGreaterThan extends IndexEvaluator
    {

        public boolean matches(Element element, Element element1)
        {
            return element1.elementSiblingIndex().intValue() > index;
        }

        public String toString()
        {
            return String.format(":gt(%d)", new Object[] {
                Integer.valueOf(index)
            });
        }

        public IndexGreaterThan(int i)
        {
            super(i);
        }
    }

    public static final class IndexLessThan extends IndexEvaluator
    {

        public boolean matches(Element element, Element element1)
        {
            return element1.elementSiblingIndex().intValue() < index;
        }

        public String toString()
        {
            return String.format(":lt(%d)", new Object[] {
                Integer.valueOf(index)
            });
        }

        public IndexLessThan(int i)
        {
            super(i);
        }
    }

    public static final class Matches extends Evaluator
    {

        private Pattern pattern;

        public boolean matches(Element element, Element element1)
        {
            return pattern.matcher(element1.text()).find();
        }

        public String toString()
        {
            return String.format(":matches(%s", new Object[] {
                pattern
            });
        }

        public Matches(Pattern pattern1)
        {
            pattern = pattern1;
        }
    }

    public static final class MatchesOwn extends Evaluator
    {

        private Pattern pattern;

        public boolean matches(Element element, Element element1)
        {
            return pattern.matcher(element1.ownText()).find();
        }

        public String toString()
        {
            return String.format(":matchesOwn(%s", new Object[] {
                pattern
            });
        }

        public MatchesOwn(Pattern pattern1)
        {
            pattern = pattern1;
        }
    }

    public static final class Tag extends Evaluator
    {

        private String tagName;

        public boolean matches(Element element, Element element1)
        {
            return element1.tagName().equals(tagName);
        }

        public String toString()
        {
            return String.format("%s", new Object[] {
                tagName
            });
        }

        public Tag(String s)
        {
            tagName = s;
        }
    }


    protected Evaluator()
    {
    }

    public abstract boolean matches(Element element, Element element1);
}
