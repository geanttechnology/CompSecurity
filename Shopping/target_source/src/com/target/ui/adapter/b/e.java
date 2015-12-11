// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import java.util.Collection;
import java.util.List;

public class e extends ArrayAdapter
{

    protected final LayoutInflater mInflater;

    public e(Context context, int i, List list)
    {
        super(context, i, list);
        mInflater = LayoutInflater.from(context);
    }

    public e(Context context, List list)
    {
        this(context, 0, list);
    }

    public void a(Collection collection)
    {
        addAll(collection);
    }
}
