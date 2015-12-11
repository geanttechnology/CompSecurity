// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.retailsearch.android.ui.listadapter.ViewEntry;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout, LayoutElementModel

static class layoutElementModel
    implements Comparable
{

    private final LayoutElementModel layoutElementModel;
    private final int position;
    private final int priority;
    private final ViewEntry viewEntry;

    public int compareTo(layoutElementModel layoutelementmodel)
    {
        int i = position - layoutelementmodel.position;
        if (i != 0)
        {
            return i;
        } else
        {
            return layoutelementmodel.priority - priority;
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    LayoutElementModel getLayoutElementModel()
    {
        return layoutElementModel;
    }

    int getPosition()
    {
        return position;
    }

    int getPriority()
    {
        return priority;
    }

    ViewEntry getViewEntry()
    {
        return viewEntry;
    }

    (ViewEntry viewentry, int i, int j, LayoutElementModel layoutelementmodel)
    {
        viewEntry = viewentry;
        position = i;
        priority = j;
        layoutElementModel = layoutelementmodel;
    }
}
