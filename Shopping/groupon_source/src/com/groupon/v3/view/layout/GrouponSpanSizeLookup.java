// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.layout;

import com.groupon.v3.adapter.UniversalListAdapter;

public class GrouponSpanSizeLookup extends android.support.v7.widget.GridLayoutManager.SpanSizeLookup
{

    protected UniversalListAdapter adapter;
    protected int numColumns;

    public GrouponSpanSizeLookup(UniversalListAdapter universallistadapter, int i)
    {
        adapter = universallistadapter;
        numColumns = i;
    }

    public int getSpanSize(int i)
    {
        if (adapter.getColumnSpanAllColumns(i))
        {
            return numColumns;
        } else
        {
            return 1;
        }
    }
}
