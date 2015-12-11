// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.listadapter:
//            ViewGenerator

public class ViewGeneratorTree
    implements ViewGenerator
{

    private final List children;

    public ViewGeneratorTree()
    {
        children = new ArrayList();
    }

    public ViewGeneratorTree(int i)
    {
        children = new ArrayList(i);
    }

    public ViewGeneratorTree(List list)
    {
        children = list;
    }

    public List getChildren()
    {
        return children;
    }

    public int getCount()
    {
        int i = 0;
        for (Iterator iterator = children.iterator(); iterator.hasNext();)
        {
            i += ((ViewGenerator)iterator.next()).getCount();
        }

        return i;
    }

    public int getType(int i)
    {
        for (Iterator iterator = children.iterator(); iterator.hasNext();)
        {
            ViewGenerator viewgenerator = (ViewGenerator)iterator.next();
            int j = viewgenerator.getCount();
            if (i < j)
            {
                return viewgenerator.getType(i);
            }
            i -= j;
        }

        return -1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        for (Iterator iterator = children.iterator(); iterator.hasNext();)
        {
            ViewGenerator viewgenerator = (ViewGenerator)iterator.next();
            int j = viewgenerator.getCount();
            if (i < j)
            {
                return viewgenerator.getView(i, view, viewgroup);
            }
            i -= j;
        }

        return null;
    }

    public boolean isEnabled(int i)
    {
        for (Iterator iterator = children.iterator(); iterator.hasNext();)
        {
            ViewGenerator viewgenerator = (ViewGenerator)iterator.next();
            int j = viewgenerator.getCount();
            if (i < j)
            {
                return viewgenerator.isEnabled(i);
            }
            i -= j;
        }

        return true;
    }
}
