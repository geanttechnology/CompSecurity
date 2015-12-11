// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.target.ui.util.k;

public class c extends k
{

    public c(Context context, int i, int j, int l)
    {
        super(context, i, j, l);
    }

    protected boolean a(View view, RecyclerView recyclerview)
    {
        return ((ListDetailAdapter.c)recyclerview.a(view)).x();
    }
}
