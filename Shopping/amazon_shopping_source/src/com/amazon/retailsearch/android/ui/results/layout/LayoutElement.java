// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.ansel.fetch.tools.collection.Factory;
import com.amazon.retailsearch.android.ui.listadapter.ViewEntry;
import com.amazon.retailsearch.android.ui.listadapter.ViewEntryWrapper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            LayoutElementModel

class LayoutElement extends ViewEntryWrapper
    implements Comparable
{

    private final LayoutElementModel layoutElementModel;
    private List loaders;
    private int position;
    private final int priority;
    private final int requestedPosition;
    private final int section;
    private final int span;

    LayoutElement(ViewEntry viewentry, int i, int j, int k, int l, List list, int i1, 
            LayoutElementModel layoutelementmodel)
    {
        super(viewentry);
        section = i;
        requestedPosition = j;
        priority = k;
        span = l;
        loaders = list;
        position = i1;
        layoutElementModel = layoutelementmodel;
    }

    LayoutElement(ViewEntry viewentry, int i, int j, LayoutElementModel layoutelementmodel)
    {
        this(viewentry, i, j, 0, 1, null, 0, layoutelementmodel);
    }

    void addLoader(Factory factory)
    {
        if (loaders == null)
        {
            loaders = new ArrayList(1);
        }
        loaders.add(factory);
    }

    public int compareTo(LayoutElement layoutelement)
    {
        int i = section - layoutelement.section;
        if (i != 0)
        {
            return i;
        }
        i = requestedPosition - layoutelement.requestedPosition;
        if (i != 0)
        {
            return i;
        } else
        {
            return layoutelement.priority - priority;
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((LayoutElement)obj);
    }

    LayoutElementModel getLayoutElementModel()
    {
        return layoutElementModel;
    }

    List getLoaders()
    {
        return loaders;
    }

    int getPosition()
    {
        return position;
    }

    int getPriority()
    {
        return priority;
    }

    int getRequestedPosition()
    {
        return requestedPosition;
    }

    int getSection()
    {
        return section;
    }

    int getSpan()
    {
        return span;
    }

    void setPosition(int i)
    {
        position = i;
    }
}
