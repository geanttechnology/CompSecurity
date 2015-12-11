// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.amazon.retailsearch.android.ui.listadapter:
//            ViewEntry

public class ViewEntryWrapper extends ViewEntry
{

    private final ViewEntry entry;

    public ViewEntryWrapper(ViewEntry viewentry)
    {
        entry = viewentry;
    }

    public ViewEntry getEntry()
    {
        return entry;
    }

    public int getType()
    {
        return entry.getType();
    }

    public View getView(View view, ViewGroup viewgroup)
    {
        return entry.getView(view, viewgroup);
    }

    public boolean isEnabled()
    {
        return entry.isEnabled();
    }
}
