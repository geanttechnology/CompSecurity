// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.ui.view.shop.WeeklyAdCardView;
import java.util.List;

public class d extends android.support.v7.widget.RecyclerView.a
{
    public static interface a
    {

        public abstract void a(WeeklyAdCardView weeklyadcardview);
    }

    public static class b extends android.support.v7.widget.RecyclerView.t
    {

        public b(View view)
        {
            super(view);
        }
    }


    private int mFooterHeight;
    private a mListener;
    private List mViewModels;

    public d(List list)
    {
        mViewModels = list;
    }

    static a a(d d1)
    {
        return d1.mListener;
    }

    public int a()
    {
        return mViewModels.size();
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i)
    {
        return c(viewgroup, i);
    }

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int i)
    {
        a((b)t, i);
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public void a(final b weeklyAdCardView, int i)
    {
        com.target.ui.view.shop.WeeklyAdCardView.a a1 = (com.target.ui.view.shop.WeeklyAdCardView.a)mViewModels.get(i);
        weeklyAdCardView = (WeeklyAdCardView)weeklyAdCardView.itemView;
        weeklyAdCardView.setViewModel(a1);
        weeklyAdCardView.setOnClickListener(new android.view.View.OnClickListener() {

            final d this$0;
            final WeeklyAdCardView val$weeklyAdCardView;

            public void onClick(View view)
            {
                if (d.a(d.this) == null)
                {
                    return;
                } else
                {
                    d.a(d.this).a(weeklyAdCardView);
                    return;
                }
            }

            
            {
                this$0 = d.this;
                weeklyAdCardView = weeklyadcardview;
                super();
            }
        });
    }

    public b c(ViewGroup viewgroup, int i)
    {
        viewgroup = (WeeklyAdCardView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030208, viewgroup, false);
        viewgroup.setFooterHeight(mFooterHeight);
        return new b(viewgroup);
    }

    public void f(int i)
    {
        mFooterHeight = i;
    }
}
