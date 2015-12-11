// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.select:
//            Selector, NodeTraversor, NodeVisitor

public class Elements
    implements List, Cloneable
{

    private List contents;

    public Elements()
    {
        contents = new ArrayList();
    }

    public Elements(int i)
    {
        contents = new ArrayList(i);
    }

    public Elements(Collection collection)
    {
        contents = new ArrayList(collection);
    }

    public Elements(List list)
    {
        contents = list;
    }

    public transient Elements(Element aelement[])
    {
        this(Arrays.asList(aelement));
    }

    public volatile void add(int i, Object obj)
    {
        add(i, (Element)obj);
    }

    public void add(int i, Element element)
    {
        contents.add(i, element);
    }

    public volatile boolean add(Object obj)
    {
        return add((Element)obj);
    }

    public boolean add(Element element)
    {
        return contents.add(element);
    }

    public boolean addAll(int i, Collection collection)
    {
        return contents.addAll(i, collection);
    }

    public boolean addAll(Collection collection)
    {
        return contents.addAll(collection);
    }

    public Elements addClass(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).addClass(s)) { }
        return this;
    }

    public Elements after(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).after(s)) { }
        return this;
    }

    public Elements append(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).append(s)) { }
        return this;
    }

    public String attr(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext();)
        {
            Element element = (Element)iterator1.next();
            if (element.hasAttr(s))
            {
                return element.attr(s);
            }
        }

        return "";
    }

    public Elements attr(String s, String s1)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).attr(s, s1)) { }
        return this;
    }

    public Elements before(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).before(s)) { }
        return this;
    }

    public void clear()
    {
        contents.clear();
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public Elements clone()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); arraylist.add(((Element)iterator1.next()).clone())) { }
        return new Elements(arraylist);
    }

    public boolean contains(Object obj)
    {
        return contents.contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        return contents.containsAll(collection);
    }

    public Elements empty()
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).empty()) { }
        return this;
    }

    public Elements eq(int i)
    {
        if (contents.size() > i)
        {
            return new Elements(new Element[] {
                get(i)
            });
        } else
        {
            return new Elements();
        }
    }

    public boolean equals(Object obj)
    {
        return contents.equals(obj);
    }

    public Element first()
    {
        if (contents.isEmpty())
        {
            return null;
        } else
        {
            return (Element)contents.get(0);
        }
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public Element get(int i)
    {
        return (Element)contents.get(i);
    }

    public boolean hasAttr(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext();)
        {
            if (((Element)iterator1.next()).hasAttr(s))
            {
                return true;
            }
        }

        return false;
    }

    public boolean hasClass(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext();)
        {
            if (((Element)iterator1.next()).hasClass(s))
            {
                return true;
            }
        }

        return false;
    }

    public boolean hasText()
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext();)
        {
            if (((Element)iterator1.next()).hasText())
            {
                return true;
            }
        }

        return false;
    }

    public int hashCode()
    {
        return contents.hashCode();
    }

    public String html()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Element element;
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); stringbuilder.append(element.html()))
        {
            element = (Element)iterator1.next();
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append("\n");
            }
        }

        return stringbuilder.toString();
    }

    public Elements html(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).html(s)) { }
        return this;
    }

    public int indexOf(Object obj)
    {
        return contents.indexOf(obj);
    }

    public boolean is(String s)
    {
        return !select(s).isEmpty();
    }

    public boolean isEmpty()
    {
        return contents.isEmpty();
    }

    public Iterator iterator()
    {
        return contents.iterator();
    }

    public Element last()
    {
        if (contents.isEmpty())
        {
            return null;
        } else
        {
            return (Element)contents.get(contents.size() - 1);
        }
    }

    public int lastIndexOf(Object obj)
    {
        return contents.lastIndexOf(obj);
    }

    public ListIterator listIterator()
    {
        return contents.listIterator();
    }

    public ListIterator listIterator(int i)
    {
        return contents.listIterator(i);
    }

    public Elements not(String s)
    {
        return Selector.filterOut(this, Selector.select(s, this));
    }

    public String outerHtml()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Element element;
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); stringbuilder.append(element.outerHtml()))
        {
            element = (Element)iterator1.next();
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append("\n");
            }
        }

        return stringbuilder.toString();
    }

    public Elements parents()
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); linkedhashset.addAll(((Element)iterator1.next()).parents())) { }
        return new Elements(linkedhashset);
    }

    public Elements prepend(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).prepend(s)) { }
        return this;
    }

    public volatile Object remove(int i)
    {
        return remove(i);
    }

    public Element remove(int i)
    {
        return (Element)contents.remove(i);
    }

    public Elements remove()
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).remove()) { }
        return this;
    }

    public boolean remove(Object obj)
    {
        return contents.remove(obj);
    }

    public boolean removeAll(Collection collection)
    {
        return contents.removeAll(collection);
    }

    public Elements removeAttr(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).removeAttr(s)) { }
        return this;
    }

    public Elements removeClass(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).removeClass(s)) { }
        return this;
    }

    public boolean retainAll(Collection collection)
    {
        return contents.retainAll(collection);
    }

    public Elements select(String s)
    {
        return Selector.select(s, this);
    }

    public volatile Object set(int i, Object obj)
    {
        return set(i, (Element)obj);
    }

    public Element set(int i, Element element)
    {
        return (Element)contents.set(i, element);
    }

    public int size()
    {
        return contents.size();
    }

    public List subList(int i, int j)
    {
        return contents.subList(i, j);
    }

    public Elements tagName(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).tagName(s)) { }
        return this;
    }

    public String text()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Element element;
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); stringbuilder.append(element.text()))
        {
            element = (Element)iterator1.next();
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append(" ");
            }
        }

        return stringbuilder.toString();
    }

    public Object[] toArray()
    {
        return contents.toArray();
    }

    public Object[] toArray(Object aobj[])
    {
        return contents.toArray(aobj);
    }

    public String toString()
    {
        return outerHtml();
    }

    public Elements toggleClass(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).toggleClass(s)) { }
        return this;
    }

    public Elements traverse(NodeVisitor nodevisitor)
    {
        Validate.notNull(nodevisitor);
        nodevisitor = new NodeTraversor(nodevisitor);
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); nodevisitor.traverse((Element)iterator1.next())) { }
        return this;
    }

    public Elements unwrap()
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).unwrap()) { }
        return this;
    }

    public String val()
    {
        if (size() > 0)
        {
            return first().val();
        } else
        {
            return "";
        }
    }

    public Elements val(String s)
    {
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).val(s)) { }
        return this;
    }

    public Elements wrap(String s)
    {
        Validate.notEmpty(s);
        for (Iterator iterator1 = contents.iterator(); iterator1.hasNext(); ((Element)iterator1.next()).wrap(s)) { }
        return this;
    }
}
