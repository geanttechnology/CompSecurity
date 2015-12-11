// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

// Referenced classes of package com.amazon.retailsearch.android.ui.listadapter:
//            ViewGenerator

public class GeneratorAdapter extends BaseAdapter
{

    private final ViewGenerator generator;
    private final int typeCount;

    public GeneratorAdapter(ViewGenerator viewgenerator)
    {
        this(viewgenerator, 1);
    }

    public GeneratorAdapter(ViewGenerator viewgenerator, int i)
    {
        generator = viewgenerator;
        typeCount = i;
    }

    public int getCount()
    {
        return generator.getCount();
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return generator.getType(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return generator.getView(i, view, viewgroup);
    }

    public int getViewTypeCount()
    {
        return typeCount;
    }
}
