// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;
import bdq;
import bdr;
import com.instamag.activity.library.model.TFilterMenuItemType;
import java.util.List;

public class LibraryFilterMenuView extends LinearLayout
{

    public bdq lisener;
    bdr resCountAdapter;
    ListView resCountListView;
    bdr resStyleAdapter;
    ListView resStyleListView;
    bdr resTypeAdapter;
    ListView resTypeListView;

    public LibraryFilterMenuView(Context context)
    {
        super(context);
        resTypeAdapter = new bdr(this);
        resStyleAdapter = new bdr(this);
        resCountAdapter = new bdr(this);
        initView();
    }

    public LibraryFilterMenuView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        resTypeAdapter = new bdr(this);
        resStyleAdapter = new bdr(this);
        resCountAdapter = new bdr(this);
        initView();
    }

    public LibraryFilterMenuView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        resTypeAdapter = new bdr(this);
        resStyleAdapter = new bdr(this);
        resCountAdapter = new bdr(this);
        initView();
    }

    public void initView()
    {
        LayoutInflater layoutinflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
        resTypeListView.setAdapter(resTypeAdapter);
        resStyleListView.setAdapter(resStyleAdapter);
        resCountListView.setAdapter(resCountAdapter);
    }

    public void setFilterItemLisener(bdq bdq)
    {
        lisener = bdq;
    }

    public void setResCountSeletsd(int i)
    {
        resCountAdapter.a(i);
    }

    public void setResCounts(List list, TFilterMenuItemType tfiltermenuitemtype)
    {
        resCountAdapter.a(list, tfiltermenuitemtype);
    }

    public void setResStyleSeletsd(int i)
    {
        resStyleAdapter.a(i);
    }

    public void setResStyles(List list, TFilterMenuItemType tfiltermenuitemtype)
    {
        resStyleAdapter.a(list, tfiltermenuitemtype);
    }

    public void setResTypeSeletsd(int i)
    {
        resTypeAdapter.a(i);
    }

    public void setResTypes(List list, TFilterMenuItemType tfiltermenuitemtype)
    {
        resTypeAdapter.a(list, tfiltermenuitemtype);
    }
}
