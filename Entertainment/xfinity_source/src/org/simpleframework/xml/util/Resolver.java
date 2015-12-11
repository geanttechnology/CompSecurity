// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.util:
//            Match, LimitedCache

public class Resolver extends AbstractSet
{
    private class Cache extends LimitedCache
    {

        final Resolver this$0;

        public Cache()
        {
            this$0 = Resolver.this;
            super(1024);
        }
    }

    private class Stack extends LinkedList
    {

        final Resolver this$0;

        public void purge(int i)
        {
            cache.clear();
            remove(i);
        }

        public void push(Match match1)
        {
            cache.clear();
            addFirst(match1);
        }

        public Iterator sequence()
        {
            return new Sequence();
        }

        private Stack()
        {
            this$0 = Resolver.this;
            super();
        }

    }

    private class Stack.Sequence
        implements Iterator
    {

        private int cursor;
        final Stack this$1;

        public boolean hasNext()
        {
            return cursor > 0;
        }

        public volatile Object next()
        {
            return next();
        }

        public Match next()
        {
            if (hasNext())
            {
                Stack stack1 = Stack.this;
                int i = cursor - 1;
                cursor = i;
                return (Match)stack1.get(i);
            } else
            {
                return null;
            }
        }

        public void remove()
        {
            purge(cursor);
        }

        public Stack.Sequence()
        {
            this$1 = Stack.this;
            super();
            cursor = size();
        }
    }


    protected final Cache cache = new Cache();
    protected final Stack stack = new Stack();

    public Resolver()
    {
    }

    private boolean match(char ac[], int i, char ac1[], int j)
    {
_L11:
        if (j >= ac1.length || i >= ac.length) goto _L2; else goto _L1
_L1:
        int k;
        int i1;
        i1 = i;
        k = j;
        if (ac1[j] != '*') goto _L4; else goto _L3
_L3:
        i1 = j;
_L8:
        if (ac1[i1] != '*') goto _L6; else goto _L5
_L5:
        j = i1 + 1;
        i1 = j;
        if (j < ac1.length) goto _L8; else goto _L7
_L7:
        return true;
_L6:
        j = i;
        k = i1;
        if (ac1[i1] == '?')
        {
            k = i1 + 1;
            if (k >= ac1.length)
            {
                continue; /* Loop/switch isn't completed */
            }
            j = i;
        }
        for (; j < ac.length; j++)
        {
            if (ac[j] != ac1[k] && ac1[k] != '?')
            {
                continue;
            }
            if (ac1[k - 1] == '?')
            {
                break;
            }
            if (match(ac, j, ac1, k))
            {
                continue; /* Loop/switch isn't completed */
            }
        }

        i1 = j;
        if (ac.length == j)
        {
            return false;
        }
_L4:
        i = ac[i1];
        j = k + 1;
        if (i != ac1[k] && ac1[j - 1] != '?')
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L2:
        int l = j;
        if (ac1.length == j)
        {
            if (ac.length != i)
            {
                return false;
            }
        } else
        {
            while (ac1[l] == '*') 
            {
                i = l + 1;
                l = i;
                if (i >= ac1.length)
                {
                    return true;
                }
            }
            return false;
        }
        if (true) goto _L7; else goto _L9
_L9:
        i = i1 + 1;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private boolean match(char ac[], char ac1[])
    {
        return match(ac, 0, ac1, 0);
    }

    private List resolveAll(String s, char ac[])
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator1 = stack.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Match match1 = (Match)iterator1.next();
            if (match(ac, match1.getPattern().toCharArray()))
            {
                cache.put(s, arraylist);
                arraylist.add(match1);
            }
        } while (true);
        return arraylist;
    }

    public volatile boolean add(Object obj)
    {
        return add((Match)obj);
    }

    public boolean add(Match match1)
    {
        stack.push(match1);
        return true;
    }

    public void clear()
    {
        cache.clear();
        stack.clear();
    }

    public Iterator iterator()
    {
        return stack.sequence();
    }

    public boolean remove(Match match1)
    {
        cache.clear();
        return stack.remove(match1);
    }

    public Match resolve(String s)
    {
        List list1 = (List)cache.get(s);
        List list = list1;
        if (list1 == null)
        {
            list = resolveAll(s);
        }
        if (list.isEmpty())
        {
            return null;
        } else
        {
            return (Match)list.get(0);
        }
    }

    public List resolveAll(String s)
    {
        List list = (List)cache.get(s);
        if (list != null)
        {
            return list;
        }
        char ac[] = s.toCharArray();
        if (ac == null)
        {
            return null;
        } else
        {
            return resolveAll(s, ac);
        }
    }

    public int size()
    {
        return stack.size();
    }
}
