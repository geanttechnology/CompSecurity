// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.util.SparseArray;
import android.view.View;

public class ViewHolder
{

    private static final int INITIAL_SIZE = 4;

    public ViewHolder()
    {
    }

    public static View get(View view, int i)
    {
        Object obj = (SparseArray)view.getTag(com.amazon.retailsearch.R.id.view_holder_sub_view);
        SparseArray sparsearray = ((SparseArray) (obj));
        if (obj == null)
        {
            sparsearray = new SparseArray(4);
            view.setTag(com.amazon.retailsearch.R.id.view_holder_sub_view, sparsearray);
        }
        View view1 = (View)sparsearray.get(i);
        obj = view1;
        if (view1 == null)
        {
            obj = view.findViewById(i);
            sparsearray.put(i, obj);
        }
        return ((View) (obj));
    }
}
