// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortedList extends ArrayList
{

    private static final String LOG_TAG = "SortedList";
    private static final long serialVersionUID = 1L;
    final Comparator comparator;

    public SortedList(Comparator comparator1)
    {
        comparator = comparator1;
    }

    public void add(int i, Object obj)
    {
        Log.i("SortedList", (new StringBuilder()).append("add(").append(i).append(", ").append(obj).append(")").toString());
        add(obj);
    }

    public boolean add(Object obj)
    {
        boolean flag = super.add(obj);
        Collections.sort(this, comparator);
        return flag;
    }
}
