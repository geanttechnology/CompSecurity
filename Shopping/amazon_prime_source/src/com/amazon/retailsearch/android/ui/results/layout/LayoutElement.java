// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.view.View;
import android.view.ViewGroup;
import com.amazon.ansel.fetch.tools.collection.Factory;
import com.amazon.retailsearch.android.ui.listadapter.ViewEntry;
import com.amazon.retailsearch.android.ui.listadapter.ViewEntryWrapper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            BorderType, LayoutElementModel

public class LayoutElement extends ViewEntryWrapper
    implements Comparable
{

    private final boolean isShownInSplitView;
    private final LayoutElementModel layoutElementModel;
    private List loaders;
    private int position;
    private int priority;
    private int requestedPosition;
    private int section;
    private final int span;

    LayoutElement(ViewEntry viewentry, int i, int j, int k, int l, List list, int i1, 
            LayoutElementModel layoutelementmodel, boolean flag)
    {
        super(viewentry);
        section = i;
        requestedPosition = j;
        priority = k;
        span = l;
        loaders = list;
        position = i1;
        layoutElementModel = layoutelementmodel;
        isShownInSplitView = flag;
    }

    LayoutElement(ViewEntry viewentry, int i, int j, LayoutElementModel layoutelementmodel, boolean flag)
    {
        this(viewentry, i, j, 0, 1, null, 0, layoutelementmodel, flag);
    }

    private View addBorder(View view)
    {
        BorderType bordertype = BorderType.BOTTOM;
        if (getType() == 13)
        {
            bordertype = BorderType.NONE;
        }
        view.setBackgroundResource(bordertype.getResourceId());
        return view;
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

    public View getView(View view, ViewGroup viewgroup)
    {
        view = super.getView(view, viewgroup);
        if (isShownInSplitView)
        {
            return view;
        } else
        {
            return addBorder(view);
        }
    }

    boolean isShownInSplitView()
    {
        return isShownInSplitView;
    }

    void setPosition(int i)
    {
        position = i;
    }

    void setPriority(int i)
    {
        priority = i;
    }

    void setRequestedPosition(int i)
    {
        requestedPosition = i;
    }

    void setSection(int i)
    {
        section = i;
    }
}
