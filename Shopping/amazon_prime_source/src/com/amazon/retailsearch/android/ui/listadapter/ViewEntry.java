// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.amazon.retailsearch.android.ui.listadapter:
//            ViewGenerator

public abstract class ViewEntry
    implements ViewGenerator
{

    public ViewEntry()
    {
    }

    public int getCount()
    {
        return 1;
    }

    public abstract int getType();

    public int getType(int i)
    {
        return getType();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return getView(view, viewgroup);
    }

    public abstract View getView(View view, ViewGroup viewgroup);

    public abstract boolean isEnabled();

    public boolean isEnabled(int i)
    {
        return isEnabled();
    }
}
