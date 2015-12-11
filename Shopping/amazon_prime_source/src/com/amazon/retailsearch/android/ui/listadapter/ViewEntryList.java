// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.listadapter:
//            ViewGenerator, ViewEntry

public class ViewEntryList
    implements ViewGenerator
{

    private final List content;

    public ViewEntryList()
    {
        content = new ArrayList();
    }

    public ViewEntryList(int i)
    {
        content = new ArrayList(i);
    }

    public ViewEntryList(List list)
    {
        content = list;
    }

    public List getContent()
    {
        return content;
    }

    public int getCount()
    {
        return content.size();
    }

    public int getType(int i)
    {
        return ((ViewEntry)content.get(i)).getType();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return ((ViewEntry)content.get(i)).getView(view, viewgroup);
    }

    public boolean isEnabled(int i)
    {
        return ((ViewEntry)content.get(i)).isEnabled();
    }
}
