// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Expression, PathParser

private class end
    implements Expression
{

    private int begin;
    private List cache;
    private int end;
    private String path;
    private String section;
    final PathParser this$0;

    private String getCanonicalPath()
    {
        int i = 0;
        int j;
        for (j = 0; j < begin; j++)
        {
            i = location.indexOf('/', i + 1);
        }

        int l = i;
        int k = j;
        j = l;
        for (; k <= end; k++)
        {
            int i1 = location.indexOf('/', j + 1);
            j = i1;
            if (i1 == -1)
            {
                j = location.length();
            }
        }

        return location.substring(i + 1, j);
    }

    private String getFragment()
    {
        int i = start;
        int i1 = 0;
        int j = 0;
        do
        {
label0:
            {
                int k = i;
                if (j <= end)
                {
                    if (i < count)
                    {
                        break label0;
                    }
                    k = i + 1;
                }
                return new String(data, i1, k - 1 - i1);
            }
            char ac[] = data;
            int l = i + 1;
            int j1 = j;
            if (ac[i] == '/')
            {
                j++;
                j1 = j;
                if (j == begin)
                {
                    i1 = l;
                    i = l;
                    continue;
                }
            }
            i = l;
            j = j1;
        } while (true);
    }

    public String getAttribute(String s)
    {
        String s2 = getPath();
        String s1 = s;
        if (s2 != null)
        {
            s1 = getAttributePath(s2, s);
        }
        return s1;
    }

    public String getElement(String s)
    {
        String s2 = getPath();
        String s1 = s;
        if (s2 != null)
        {
            s1 = getElementPath(s2, s);
        }
        return s1;
    }

    public String getFirst()
    {
        return (String)names.get(begin);
    }

    public int getIndex()
    {
        return ((Integer)indexes.get(begin)).intValue();
    }

    public String getLast()
    {
        return (String)names.get(end);
    }

    public String getPath()
    {
        if (section == null)
        {
            section = getCanonicalPath();
        }
        return section;
    }

    public Expression getPath(int i)
    {
        return getPath(i, 0);
    }

    public Expression getPath(int i, int j)
    {
        return new <init>(begin + i, end - j);
    }

    public String getPrefix()
    {
        return (String)prefixes.get(begin);
    }

    public boolean isAttribute()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (attribute)
        {
            flag = flag1;
            if (end >= names.size() - 1)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isEmpty()
    {
        return begin == end;
    }

    public boolean isPath()
    {
        return end - begin >= 1;
    }

    public Iterator iterator()
    {
        if (cache.isEmpty())
        {
            for (int i = begin; i <= end; i++)
            {
                String s = (String)names.get(i);
                if (s != null)
                {
                    cache.add(s);
                }
            }

        }
        return cache.iterator();
    }

    public String toString()
    {
        if (path == null)
        {
            path = getFragment();
        }
        return path;
    }

    public _cls9(int i, int j)
    {
        this$0 = PathParser.this;
        super();
        cache = new ArrayList();
        begin = i;
        end = j;
    }
}
