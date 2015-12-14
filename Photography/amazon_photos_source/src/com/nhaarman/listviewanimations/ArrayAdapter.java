// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class ArrayAdapter extends BaseAdapter
{

    private final List mItems;

    protected ArrayAdapter()
    {
        this(null);
    }

    protected ArrayAdapter(List list)
    {
        if (list != null)
        {
            mItems = list;
            return;
        } else
        {
            mItems = new ArrayList();
            return;
        }
    }
}
