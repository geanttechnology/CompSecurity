// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.registries.interfaces.RegistrySearchSummary;
import com.target.ui.adapter.e.a.a;
import com.target.ui.view.product.PlpListFooterView;
import com.target.ui.view.registry.RegistrySearchListItemView;
import com.target.ui.view.registry.RegistryStickyHeaderView;
import java.util.List;

public class b extends com.target.ui.adapter.e.a.a
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(RegistrySearchSummary registrysearchsummary);
    }


    public static final int REGISTRY_ITEM = 500;
    private a mListener;
    private final List mRegistrySearchSummaryList;
    private String mStickHeaderTitle;

    public b(List list)
    {
        mRegistrySearchSummaryList = list;
    }

    static a a(b b1)
    {
        return b1.mListener;
    }

    protected View a(ViewGroup viewgroup)
    {
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301dc, viewgroup, false);
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public void a(String s)
    {
        mStickHeaderTitle = s;
    }

    protected View c(ViewGroup viewgroup)
    {
        viewgroup = (PlpListFooterView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301aa, viewgroup, false);
        a(viewgroup);
        return viewgroup;
    }

    protected View c(ViewGroup viewgroup, int i)
    {
        return (RegistrySearchListItemView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301db, viewgroup, false);
    }

    protected void c(android.support.v7.widget.RecyclerView.t t, int i)
    {
        ((RegistryStickyHeaderView)t.itemView).setTitle(mStickHeaderTitle);
    }

    protected void e(android.support.v7.widget.RecyclerView.t t, int i)
    {
        ((PlpListFooterView)t.itemView).setClickListener(new com.target.ui.view.product.PlpFooterView.a() {

            final b this$0;

            public void a()
            {
                if (com.target.ui.adapter.e.b.a(b.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.e.b.a(b.this).a();
                    return;
                }
            }

            
            {
                this$0 = b.this;
                super();
            }
        });
    }

    protected long f(int i)
    {
        return 0L;
    }

    protected void f(android.support.v7.widget.RecyclerView.t t, int i)
    {
        if (mRegistrySearchSummaryList == null)
        {
            return;
        } else
        {
            final RegistrySearchSummary searchItem = (RegistrySearchSummary)mRegistrySearchSummaryList.get(i);
            t = (RegistrySearchListItemView)t.itemView;
            t.setItemData(searchItem);
            t.setOnClickListener(new android.view.View.OnClickListener() {

                final b this$0;
                final RegistrySearchSummary val$searchItem;

                public void onClick(View view)
                {
                    if (com.target.ui.adapter.e.b.a(b.this) != null)
                    {
                        com.target.ui.adapter.e.b.a(b.this).a(searchItem);
                    }
                }

            
            {
                this$0 = b.this;
                searchItem = registrysearchsummary;
                super();
            }
            });
            return;
        }
    }

    protected int g()
    {
        if (mRegistrySearchSummaryList != null)
        {
            return mRegistrySearchSummaryList.size();
        } else
        {
            return 0;
        }
    }

    protected int g(int i)
    {
        return 500;
    }
}
