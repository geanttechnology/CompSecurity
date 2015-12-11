// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jsoup.helper.Validate;

// Referenced classes of package org.jsoup.nodes:
//            Attribute, Document

public class Attributes
    implements Iterable, Cloneable
{
    private class Dataset extends AbstractMap
    {

        final Attributes this$0;

        public Set entrySet()
        {
            return new EntrySet();
        }

        public volatile Object put(Object obj, Object obj1)
        {
            return put((String)obj, (String)obj1);
        }

        public String put(String s, String s1)
        {
            String s2 = Attributes.dataKey(s);
            if (hasKey(s2))
            {
                s = ((Attribute)attributes.get(s2)).getValue();
            } else
            {
                s = null;
            }
            s1 = new Attribute(s2, s1);
            attributes.put(s2, s1);
            return s;
        }

        private Dataset()
        {
            this$0 = Attributes.this;
            super();
            if (attributes == null)
            {
                attributes = new LinkedHashMap(2);
            }
        }

    }

    private class Dataset.DatasetIterator
        implements Iterator
    {

        private Attribute attr;
        private Iterator attrIter;
        final Dataset this$1;

        public boolean hasNext()
        {
            while (attrIter.hasNext()) 
            {
                attr = (Attribute)attrIter.next();
                if (attr.isDataAttribute())
                {
                    return true;
                }
            }
            return false;
        }

        public volatile Object next()
        {
            return next();
        }

        public java.util.Map.Entry next()
        {
            return new Attribute(attr.getKey().substring("data-".length()), attr.getValue());
        }

        public void remove()
        {
            attributes.remove(attr.getKey());
        }

        private Dataset.DatasetIterator()
        {
            this$1 = Dataset.this;
            super();
            attrIter = attributes.values().iterator();
        }

    }

    private class Dataset.EntrySet extends AbstractSet
    {

        final Dataset this$1;

        public Iterator iterator()
        {
            return new Dataset.DatasetIterator();
        }

        public int size()
        {
            int i = 0;
            for (Dataset.DatasetIterator datasetiterator = new Dataset.DatasetIterator(); datasetiterator.hasNext();)
            {
                i++;
            }

            return i;
        }

        private Dataset.EntrySet()
        {
            this$1 = Dataset.this;
            super();
        }

    }


    protected static final String dataPrefix = "data-";
    private LinkedHashMap attributes;

    public Attributes()
    {
        attributes = null;
    }

    private static String dataKey(String s)
    {
        return (new StringBuilder()).append("data-").append(s).toString();
    }

    public void addAll(Attributes attributes1)
    {
        if (attributes1.size() == 0)
        {
            return;
        }
        if (attributes == null)
        {
            attributes = new LinkedHashMap(attributes1.size());
        }
        attributes.putAll(attributes1.attributes);
    }

    public List asList()
    {
        if (attributes == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList(attributes.size());
        for (Iterator iterator1 = attributes.entrySet().iterator(); iterator1.hasNext(); arraylist.add(((java.util.Map.Entry)iterator1.next()).getValue())) { }
        return Collections.unmodifiableList(arraylist);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public Attributes clone()
    {
        if (attributes != null) goto _L2; else goto _L1
_L1:
        Object obj = new Attributes();
_L4:
        return ((Attributes) (obj));
_L2:
        Attributes attributes1;
        Iterator iterator1;
        try
        {
            attributes1 = (Attributes)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new RuntimeException(clonenotsupportedexception);
        }
        attributes1.attributes = new LinkedHashMap(attributes.size());
        iterator1 = iterator();
        obj = attributes1;
        if (iterator1.hasNext())
        {
            obj = (Attribute)iterator1.next();
            attributes1.attributes.put(((Attribute) (obj)).getKey(), ((Attribute) (obj)).clone());
            break MISSING_BLOCK_LABEL_48;
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Map dataset()
    {
        return new Dataset();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Attributes))
            {
                return false;
            }
            obj = (Attributes)obj;
            if (attributes == null ? ((Attributes) (obj)).attributes != null : !attributes.equals(((Attributes) (obj)).attributes))
            {
                return false;
            }
        }
        return true;
    }

    public String get(String s)
    {
        Validate.notEmpty(s);
        if (attributes == null)
        {
            return "";
        }
        s = (Attribute)attributes.get(s.toLowerCase());
        if (s != null)
        {
            return s.getValue();
        } else
        {
            return "";
        }
    }

    public boolean hasKey(String s)
    {
        return attributes != null && attributes.containsKey(s.toLowerCase());
    }

    public int hashCode()
    {
        if (attributes != null)
        {
            return attributes.hashCode();
        } else
        {
            return 0;
        }
    }

    public String html()
    {
        StringBuilder stringbuilder = new StringBuilder();
        html(stringbuilder, (new Document("")).outputSettings());
        return stringbuilder.toString();
    }

    void html(StringBuilder stringbuilder, Document.OutputSettings outputsettings)
    {
        if (attributes != null)
        {
            Iterator iterator1 = attributes.entrySet().iterator();
            while (iterator1.hasNext()) 
            {
                Attribute attribute = (Attribute)((java.util.Map.Entry)iterator1.next()).getValue();
                stringbuilder.append(" ");
                attribute.html(stringbuilder, outputsettings);
            }
        }
    }

    public Iterator iterator()
    {
        return asList().iterator();
    }

    public void put(String s, String s1)
    {
        put(new Attribute(s, s1));
    }

    public void put(Attribute attribute)
    {
        Validate.notNull(attribute);
        if (attributes == null)
        {
            attributes = new LinkedHashMap(2);
        }
        attributes.put(attribute.getKey(), attribute);
    }

    public void remove(String s)
    {
        Validate.notEmpty(s);
        if (attributes == null)
        {
            return;
        } else
        {
            attributes.remove(s.toLowerCase());
            return;
        }
    }

    public int size()
    {
        if (attributes == null)
        {
            return 0;
        } else
        {
            return attributes.size();
        }
    }

    public String toString()
    {
        return html();
    }



/*
    static LinkedHashMap access$102(Attributes attributes1, LinkedHashMap linkedhashmap)
    {
        attributes1.attributes = linkedhashmap;
        return linkedhashmap;
    }

*/

}
