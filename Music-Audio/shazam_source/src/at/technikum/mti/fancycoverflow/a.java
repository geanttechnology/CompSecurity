// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package at.technikum.mti.fancycoverflow;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class a extends BaseAdapter
{

    public a()
    {
    }

    public abstract View a(int i, View view, ViewGroup viewgroup);

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = a(i, view, viewgroup);
        if (view == null)
        {
            throw new NullPointerException("getCoverFlowItem() was expected to return a view, but null was returned.");
        } else
        {
            return view;
        }
    }
}
