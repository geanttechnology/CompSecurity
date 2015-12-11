// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package org.jsoup.nodes:
//            Attributes, Attribute

private class <init> extends AbstractMap
{
    private class DatasetIterator
        implements Iterator
    {

        private Attribute attr;
        private Iterator attrIter;
        final Attributes.Dataset this$1;

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
            Attributes.access$100(this$0).remove(attr.getKey());
        }

        private DatasetIterator()
        {
            this$1 = Attributes.Dataset.this;
            super();
            attrIter = Attributes.access$100(this$0).values().iterator();
        }

        DatasetIterator(Attributes._cls1 _pcls1)
        {
            this();
        }
    }

    private class EntrySet extends AbstractSet
    {

        final Attributes.Dataset this$1;

        public Iterator iterator()
        {
            return new DatasetIterator(null);
        }

        public int size()
        {
            int i = 0;
            for (DatasetIterator datasetiterator = new DatasetIterator(null); datasetiterator.hasNext();)
            {
                i++;
            }

            return i;
        }

        private EntrySet()
        {
            this$1 = Attributes.Dataset.this;
            super();
        }

        EntrySet(Attributes._cls1 _pcls1)
        {
            this();
        }
    }


    final Attributes this$0;

    public Set entrySet()
    {
        return new EntrySet(null);
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((String)obj, (String)obj1);
    }

    public String put(String s, String s1)
    {
        String s2 = Attributes.access$300(s);
        if (hasKey(s2))
        {
            s = ((Attribute)Attributes.access$100(Attributes.this).get(s2)).getValue();
        } else
        {
            s = null;
        }
        s1 = new Attribute(s2, s1);
        Attributes.access$100(Attributes.this).put(s2, s1);
        return s;
    }

    private EntrySet()
    {
        this$0 = Attributes.this;
        super();
        if (Attributes.access$100(Attributes.this) == null)
        {
            Attributes.access$102(Attributes.this, new LinkedHashMap(2));
        }
    }

    _cls02(_cls02 _pcls02)
    {
        this();
    }
}
