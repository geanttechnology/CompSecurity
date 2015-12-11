// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;

// Referenced classes of package org.jsoup.nodes:
//            Node, Attributes, TextNode, DataNode

public class Element extends Node
{

    private Set classNames;
    private Tag tag;

    public Element(Tag tag1, String s)
    {
        this(tag1, s, new Attributes());
    }

    public Element(Tag tag1, String s, Attributes attributes)
    {
        super(s, attributes);
        Validate.notNull(tag1);
        tag = tag1;
    }

    private static void accumulateParents(Element element, Elements elements)
    {
        element = element.parent();
        if (element != null && !element.tagName().equals("#root"))
        {
            elements.add(element);
            accumulateParents(element, elements);
        }
    }

    private void appendNormalisedText(StringBuilder stringbuilder, TextNode textnode)
    {
        String s = textnode.getWholeText();
        textnode = s;
        if (!preserveWhitespace())
        {
            s = TextNode.normaliseWhitespace(s);
            textnode = s;
            if (TextNode.lastCharIsWhitespace(stringbuilder))
            {
                textnode = TextNode.stripLeadingWhitespace(s);
            }
        }
        stringbuilder.append(textnode);
    }

    private static void appendWhitespaceIfBr(Element element, StringBuilder stringbuilder)
    {
        if (element.tag.getName().equals("br") && !TextNode.lastCharIsWhitespace(stringbuilder))
        {
            stringbuilder.append(" ");
        }
    }

    private void html(StringBuilder stringbuilder)
    {
        for (Iterator iterator = childNodes.iterator(); iterator.hasNext(); ((Node)iterator.next()).outerHtml(stringbuilder)) { }
    }

    private static Integer indexInList(Element element, List list)
    {
        Validate.notNull(element);
        Validate.notNull(list);
        for (int i = 0; i < list.size(); i++)
        {
            if (((Element)list.get(i)).equals(element))
            {
                return Integer.valueOf(i);
            }
        }

        return null;
    }

    private void ownText(StringBuilder stringbuilder)
    {
        Iterator iterator = childNodes.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Node node = (Node)iterator.next();
            if (node instanceof TextNode)
            {
                appendNormalisedText(stringbuilder, (TextNode)node);
            } else
            if (node instanceof Element)
            {
                appendWhitespaceIfBr((Element)node, stringbuilder);
            }
        } while (true);
    }

    private void text(StringBuilder stringbuilder)
    {
        appendWhitespaceIfBr(this, stringbuilder);
        Iterator iterator = childNodes.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (Node)iterator.next();
            if (obj instanceof TextNode)
            {
                appendNormalisedText(stringbuilder, (TextNode)obj);
            } else
            if (obj instanceof Element)
            {
                obj = (Element)obj;
                if (stringbuilder.length() > 0 && ((Element) (obj)).isBlock() && !TextNode.lastCharIsWhitespace(stringbuilder))
                {
                    stringbuilder.append(" ");
                }
                ((Element) (obj)).text(stringbuilder);
            }
        } while (true);
    }

    public Element addClass(String s)
    {
        Validate.notNull(s);
        Set set = classNames();
        set.add(s);
        classNames(set);
        return this;
    }

    public Element after(String s)
    {
        return (Element)super.after(s);
    }

    public Element after(Node node)
    {
        return (Element)super.after(node);
    }

    public volatile Node after(String s)
    {
        return after(s);
    }

    public volatile Node after(Node node)
    {
        return after(node);
    }

    public Element append(String s)
    {
        Validate.notNull(s);
        s = Parser.parseFragment(s, this, baseUri());
        addChildren((Node[])s.toArray(new Node[s.size()]));
        return this;
    }

    public Element appendChild(Node node)
    {
        Validate.notNull(node);
        addChildren(new Node[] {
            node
        });
        return this;
    }

    public Element appendElement(String s)
    {
        s = new Element(Tag.valueOf(s), baseUri());
        appendChild(s);
        return s;
    }

    public Element appendText(String s)
    {
        appendChild(new TextNode(s, baseUri()));
        return this;
    }

    public Element attr(String s, String s1)
    {
        super.attr(s, s1);
        return this;
    }

    public volatile Node attr(String s, String s1)
    {
        return attr(s, s1);
    }

    public Element before(String s)
    {
        return (Element)super.before(s);
    }

    public Element before(Node node)
    {
        return (Element)super.before(node);
    }

    public volatile Node before(String s)
    {
        return before(s);
    }

    public volatile Node before(Node node)
    {
        return before(node);
    }

    public Element child(int i)
    {
        return children().get(i);
    }

    public Elements children()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = childNodes.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Node node = (Node)iterator.next();
            if (node instanceof Element)
            {
                arraylist.add((Element)node);
            }
        } while (true);
        return new Elements(arraylist);
    }

    public String className()
    {
        return attr("class");
    }

    public Set classNames()
    {
        if (classNames == null)
        {
            classNames = new LinkedHashSet(Arrays.asList(className().split("\\s+")));
        }
        return classNames;
    }

    public Element classNames(Set set)
    {
        Validate.notNull(set);
        attributes.put("class", StringUtil.join(set, " "));
        return this;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public Element clone()
    {
        Element element = (Element)super.clone();
        element.classNames();
        return element;
    }

    public volatile Node clone()
    {
        return clone();
    }

    public String data()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = childNodes.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Node node = (Node)iterator.next();
            if (node instanceof DataNode)
            {
                stringbuilder.append(((DataNode)node).getWholeData());
            } else
            if (node instanceof Element)
            {
                stringbuilder.append(((Element)node).data());
            }
        } while (true);
        return stringbuilder.toString();
    }

    public List dataNodes()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = childNodes.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Node node = (Node)iterator.next();
            if (node instanceof DataNode)
            {
                arraylist.add((DataNode)node);
            }
        } while (true);
        return Collections.unmodifiableList(arraylist);
    }

    public Map dataset()
    {
        return attributes.dataset();
    }

    public Integer elementSiblingIndex()
    {
        if (parent() == null)
        {
            return Integer.valueOf(0);
        } else
        {
            return indexInList(this, parent().children());
        }
    }

    public Element empty()
    {
        childNodes.clear();
        return this;
    }

    public boolean equals(Object obj)
    {
        return this == obj;
    }

    public Element firstElementSibling()
    {
        Elements elements = parent().children();
        if (elements.size() > 1)
        {
            return (Element)elements.get(0);
        } else
        {
            return null;
        }
    }

    public Elements getAllElements()
    {
        return Collector.collect(new org.jsoup.select.Evaluator.AllElements(), this);
    }

    public Element getElementById(String s)
    {
        Validate.notEmpty(s);
        s = Collector.collect(new org.jsoup.select.Evaluator.Id(s), this);
        if (s.size() > 0)
        {
            return s.get(0);
        } else
        {
            return null;
        }
    }

    public Elements getElementsByAttribute(String s)
    {
        Validate.notEmpty(s);
        return Collector.collect(new org.jsoup.select.Evaluator.Attribute(s.trim().toLowerCase()), this);
    }

    public Elements getElementsByAttributeStarting(String s)
    {
        Validate.notEmpty(s);
        return Collector.collect(new org.jsoup.select.Evaluator.AttributeStarting(s.trim().toLowerCase()), this);
    }

    public Elements getElementsByAttributeValue(String s, String s1)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.AttributeWithValue(s, s1), this);
    }

    public Elements getElementsByAttributeValueContaining(String s, String s1)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.AttributeWithValueContaining(s, s1), this);
    }

    public Elements getElementsByAttributeValueEnding(String s, String s1)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.AttributeWithValueEnding(s, s1), this);
    }

    public Elements getElementsByAttributeValueMatching(String s, String s1)
    {
        Pattern pattern;
        try
        {
            pattern = Pattern.compile(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Pattern syntax error: ").append(s1).toString(), s);
        }
        return getElementsByAttributeValueMatching(s, pattern);
    }

    public Elements getElementsByAttributeValueMatching(String s, Pattern pattern)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.AttributeWithValueMatching(s, pattern), this);
    }

    public Elements getElementsByAttributeValueNot(String s, String s1)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.AttributeWithValueNot(s, s1), this);
    }

    public Elements getElementsByAttributeValueStarting(String s, String s1)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.AttributeWithValueStarting(s, s1), this);
    }

    public Elements getElementsByClass(String s)
    {
        Validate.notEmpty(s);
        return Collector.collect(new org.jsoup.select.Evaluator.Class(s), this);
    }

    public Elements getElementsByIndexEquals(int i)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.IndexEquals(i), this);
    }

    public Elements getElementsByIndexGreaterThan(int i)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.IndexGreaterThan(i), this);
    }

    public Elements getElementsByIndexLessThan(int i)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.IndexLessThan(i), this);
    }

    public Elements getElementsByTag(String s)
    {
        Validate.notEmpty(s);
        return Collector.collect(new org.jsoup.select.Evaluator.Tag(s.toLowerCase().trim()), this);
    }

    public Elements getElementsContainingOwnText(String s)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.ContainsOwnText(s), this);
    }

    public Elements getElementsContainingText(String s)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.ContainsText(s), this);
    }

    public Elements getElementsMatchingOwnText(String s)
    {
        Pattern pattern;
        try
        {
            pattern = Pattern.compile(s);
        }
        catch (PatternSyntaxException patternsyntaxexception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Pattern syntax error: ").append(s).toString(), patternsyntaxexception);
        }
        return getElementsMatchingOwnText(pattern);
    }

    public Elements getElementsMatchingOwnText(Pattern pattern)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.MatchesOwn(pattern), this);
    }

    public Elements getElementsMatchingText(String s)
    {
        Pattern pattern;
        try
        {
            pattern = Pattern.compile(s);
        }
        catch (PatternSyntaxException patternsyntaxexception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Pattern syntax error: ").append(s).toString(), patternsyntaxexception);
        }
        return getElementsMatchingText(pattern);
    }

    public Elements getElementsMatchingText(Pattern pattern)
    {
        return Collector.collect(new org.jsoup.select.Evaluator.Matches(pattern), this);
    }

    public boolean hasClass(String s)
    {
        for (Iterator iterator = classNames().iterator(); iterator.hasNext();)
        {
            if (s.equalsIgnoreCase((String)iterator.next()))
            {
                return true;
            }
        }

        return false;
    }

    public boolean hasText()
    {
label0:
        {
            Iterator iterator = childNodes.iterator();
            Node node;
label1:
            do
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    node = (Node)iterator.next();
                    if (!(node instanceof TextNode))
                    {
                        continue label1;
                    }
                } while (((TextNode)node).isBlank());
                return true;
            } while (!(node instanceof Element) || !((Element)node).hasText());
            return true;
        }
        return false;
    }

    public int hashCode()
    {
        int j = super.hashCode();
        int i;
        if (tag != null)
        {
            i = tag.hashCode();
        } else
        {
            i = 0;
        }
        return j * 31 + i;
    }

    public String html()
    {
        StringBuilder stringbuilder = new StringBuilder();
        html(stringbuilder);
        return stringbuilder.toString().trim();
    }

    public Element html(String s)
    {
        empty();
        append(s);
        return this;
    }

    public String id()
    {
        String s1 = attr("id");
        String s = s1;
        if (s1 == null)
        {
            s = "";
        }
        return s;
    }

    public boolean isBlock()
    {
        return tag.isBlock();
    }

    public Element lastElementSibling()
    {
        Elements elements = parent().children();
        if (elements.size() > 1)
        {
            return (Element)elements.get(elements.size() - 1);
        } else
        {
            return null;
        }
    }

    public Element nextElementSibling()
    {
        if (parentNode != null)
        {
            Elements elements = parent().children();
            Integer integer = indexInList(this, elements);
            Validate.notNull(integer);
            if (elements.size() > integer.intValue() + 1)
            {
                return (Element)elements.get(integer.intValue() + 1);
            }
        }
        return null;
    }

    public String nodeName()
    {
        return tag.getName();
    }

    void outerHtmlHead(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
        if (stringbuilder.length() > 0 && outputsettings.prettyPrint() && (tag.formatAsBlock() || parent() != null && parent().tag().formatAsBlock()))
        {
            indent(stringbuilder, i, outputsettings);
        }
        stringbuilder.append("<").append(tagName());
        attributes.html(stringbuilder, outputsettings);
        if (childNodes.isEmpty() && tag.isSelfClosing())
        {
            stringbuilder.append(" />");
            return;
        } else
        {
            stringbuilder.append(">");
            return;
        }
    }

    void outerHtmlTail(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
        if (!childNodes.isEmpty() || !tag.isSelfClosing())
        {
            if (outputsettings.prettyPrint() && !childNodes.isEmpty() && tag.formatAsBlock())
            {
                indent(stringbuilder, i, outputsettings);
            }
            stringbuilder.append("</").append(tagName()).append(">");
        }
    }

    public String ownText()
    {
        StringBuilder stringbuilder = new StringBuilder();
        ownText(stringbuilder);
        return stringbuilder.toString().trim();
    }

    public final Element parent()
    {
        return (Element)parentNode;
    }

    public volatile Node parent()
    {
        return parent();
    }

    public Elements parents()
    {
        Elements elements = new Elements();
        accumulateParents(this, elements);
        return elements;
    }

    public Element prepend(String s)
    {
        Validate.notNull(s);
        s = Parser.parseFragment(s, this, baseUri());
        addChildren(0, (Node[])s.toArray(new Node[s.size()]));
        return this;
    }

    public Element prependChild(Node node)
    {
        Validate.notNull(node);
        addChildren(0, new Node[] {
            node
        });
        return this;
    }

    public Element prependElement(String s)
    {
        s = new Element(Tag.valueOf(s), baseUri());
        prependChild(s);
        return s;
    }

    public Element prependText(String s)
    {
        prependChild(new TextNode(s, baseUri()));
        return this;
    }

    boolean preserveWhitespace()
    {
        return tag.preserveWhitespace() || parent() != null && parent().preserveWhitespace();
    }

    public Element previousElementSibling()
    {
        if (parentNode != null)
        {
            Elements elements = parent().children();
            Integer integer = indexInList(this, elements);
            Validate.notNull(integer);
            if (integer.intValue() > 0)
            {
                return (Element)elements.get(integer.intValue() - 1);
            }
        }
        return null;
    }

    public Element removeClass(String s)
    {
        Validate.notNull(s);
        Set set = classNames();
        set.remove(s);
        classNames(set);
        return this;
    }

    public Elements select(String s)
    {
        return Selector.select(s, this);
    }

    public Elements siblingElements()
    {
        if (parentNode != null) goto _L2; else goto _L1
_L1:
        Object obj = new Elements(0);
_L4:
        return ((Elements) (obj));
_L2:
        obj = parent().children();
        Elements elements = new Elements(((List) (obj)).size() - 1);
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            obj = elements;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (Element)iterator.next();
            if (obj != this)
            {
                elements.add(((Element) (obj)));
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Tag tag()
    {
        return tag;
    }

    public String tagName()
    {
        return tag.getName();
    }

    public Element tagName(String s)
    {
        Validate.notEmpty(s, "Tag name must not be empty.");
        tag = Tag.valueOf(s);
        return this;
    }

    public String text()
    {
        StringBuilder stringbuilder = new StringBuilder();
        text(stringbuilder);
        return stringbuilder.toString().trim();
    }

    public Element text(String s)
    {
        Validate.notNull(s);
        empty();
        appendChild(new TextNode(s, baseUri));
        return this;
    }

    public List textNodes()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = childNodes.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Node node = (Node)iterator.next();
            if (node instanceof TextNode)
            {
                arraylist.add((TextNode)node);
            }
        } while (true);
        return Collections.unmodifiableList(arraylist);
    }

    public String toString()
    {
        return outerHtml();
    }

    public Element toggleClass(String s)
    {
        Validate.notNull(s);
        Set set = classNames();
        if (set.contains(s))
        {
            set.remove(s);
        } else
        {
            set.add(s);
        }
        classNames(set);
        return this;
    }

    public String val()
    {
        if (tagName().equals("textarea"))
        {
            return text();
        } else
        {
            return attr("value");
        }
    }

    public Element val(String s)
    {
        if (tagName().equals("textarea"))
        {
            text(s);
            return this;
        } else
        {
            attr("value", s);
            return this;
        }
    }

    public Element wrap(String s)
    {
        return (Element)super.wrap(s);
    }

    public volatile Node wrap(String s)
    {
        return wrap(s);
    }
}
