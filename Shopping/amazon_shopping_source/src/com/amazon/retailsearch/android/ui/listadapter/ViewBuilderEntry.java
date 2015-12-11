// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.amazon.retailsearch.android.ui.listadapter:
//            ViewEntry, ViewBuilder

public abstract class ViewBuilderEntry extends ViewEntry
    implements ViewBuilder
{

    private final int type;

    public ViewBuilderEntry(int i)
    {
        type = i;
    }

    public int getType()
    {
        return type;
    }

    public View getView(View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = createView(viewgroup);
        }
        buildView(view);
        return view;
    }

    public boolean isEnabled()
    {
        return true;
    }
}
