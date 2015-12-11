// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import com.google.common.collect.Lists;
import com.xfinity.playerlib.model.tags.Tag;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class EmbeddedTagFinder
{

    private static final Comparator DESCENDING_LENGTH_COMPARATOR = new Comparator() {

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((String)obj, (String)obj1);
        }

        public int compare(String s, String s1)
        {
            if (s.length() > s1.length())
            {
                return -1;
            }
            if (s1.length() > s.length())
            {
                return 1;
            } else
            {
                return s.compareTo(s1);
            }
        }

    };
    private final SortedMap nameToTagMap;

    public EmbeddedTagFinder(Collection collection)
    {
        Validate.notNull(collection);
        TreeMap treemap = new TreeMap(DESCENDING_LENGTH_COMPARATOR);
        Tag tag;
        for (collection = collection.iterator(); collection.hasNext(); treemap.put(tag.getName().toLowerCase(Locale.US), tag))
        {
            tag = (Tag)collection.next();
        }

        nameToTagMap = Collections.unmodifiableSortedMap(treemap);
    }

    private List buildSubstringList(String as[])
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        int k = as.length;
label0:
        for (int i = 1; i <= k; i++)
        {
            int j = 0;
            do
            {
                int l = j + i;
                if (l > as.length)
                {
                    continue label0;
                }
                arraylist.add(StringUtils.join(ArrayUtils.subarray(as, j, l), ' '));
                j++;
            } while (true);
        }

        Collections.sort(arraylist, DESCENDING_LENGTH_COMPARATOR);
        return arraylist;
    }

    public List getResults(String s)
    {
        s = s.toLowerCase(Locale.US);
        List list = buildSubstringList(StringUtils.split(s));
        java.util.ArrayList arraylist = Lists.newArrayList();
        Iterator iterator = nameToTagMap.entrySet().iterator();
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s1 = (String)entry.getKey();
            int i = s1.length();
            if (i > s.length())
            {
                continue;
            }
            Iterator iterator1 = list.iterator();
            String s2;
label1:
            do
            {
                while (iterator1.hasNext()) 
                {
                    s2 = (String)iterator1.next();
                    if (s2.length() <= i)
                    {
                        continue label1;
                    }
                    iterator1.remove();
                }
                continue label0;
            } while (!s2.equals(s1));
            arraylist.add(entry.getValue());
            iterator1.remove();
        } while (true);
        return arraylist;
    }

}
