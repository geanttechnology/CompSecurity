// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.e.a.a;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.view.list.ListCollectionItemView;
import java.util.List;

public class com.target.ui.adapter.list.b extends com.e.a.a
    implements com.target.ui.view.list.ListCollectionItemView.a
{
    public static interface a
    {

        public abstract void a(ListCollectionItem listcollectionitem);

        public abstract void a(ListCollectionItem listcollectionitem, int j);

        public abstract void a(boolean flag);

        public abstract boolean a();

        public abstract void b(ListCollectionItem listcollectionitem);

        public abstract void b(ListCollectionItem listcollectionitem, int j);
    }

    public class b extends com.e.a.a.b
    {

        final com.target.ui.adapter.list.b this$0;

        public b(com.e.a.a a1, View view)
        {
            this$0 = com.target.ui.adapter.list.b.this;
            super(a1, view);
        }
    }


    private List mListItems;
    private a mListener;
    private RecyclerView mRecyclerView;

    public com.target.ui.adapter.list.b(List list, a a1, RecyclerView recyclerview)
    {
        super(recyclerview);
        mListItems = list;
        mListener = a1;
        mRecyclerView = recyclerview;
    }

    public int a()
    {
        return mListItems.size();
    }

    public int a(long l)
    {
        for (int j = 0; j < mListItems.size(); j++)
        {
            if (b(j) == l)
            {
                return j;
            }
        }

        return -1;
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int j)
    {
        return c(viewgroup, j);
    }

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int j)
    {
        a((b)t, j);
    }

    public void a(b b1, int j)
    {
        boolean flag = false;
        ListCollectionItemView listcollectionitemview = (ListCollectionItemView)b1.itemView;
        ListCollectionItem listcollectionitem = (ListCollectionItem)mListItems.get(j);
        View view = listcollectionitemview.findViewById(0x7f1002a9);
        byte byte0;
        if (mListItems.size() == 1)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        listcollectionitemview.a(listcollectionitem, this, b1);
        if (f() == b(j))
        {
            flag = true;
        }
        listcollectionitemview.a(flag);
    }

    public void a(ListCollectionItem listcollectionitem)
    {
        mRecyclerView.requestFocus();
        mListItems.add(listcollectionitem);
        if (mListItems.size() == 2)
        {
            d();
            return;
        } else
        {
            d(mListItems.size() - 1);
            return;
        }
    }

    public void a(ListCollectionItem listcollectionitem, int j)
    {
        mListItems.add(j, listcollectionitem);
        if (mListItems.size() == 2)
        {
            d();
            return;
        } else
        {
            d(j);
            return;
        }
    }

    public long b(int j)
    {
        return (long)((ListCollectionItem)mListItems.get(j)).hashCode();
    }

    public void b(ListCollectionItem listcollectionitem)
    {
        mListener.b(listcollectionitem);
        d(listcollectionitem);
        c(mListItems.indexOf(listcollectionitem));
    }

    public void b(boolean flag)
    {
        if (mListener != null)
        {
            mListener.a(flag);
        }
    }

    public boolean b(int j, int k)
    {
        ListCollectionItem listcollectionitem = (ListCollectionItem)mListItems.get(j);
        mListItems.add(k, mListItems.remove(j));
        if (mListener != null)
        {
            mListener.b(listcollectionitem, k);
            return true;
        } else
        {
            return false;
        }
    }

    public b c(ViewGroup viewgroup, int j)
    {
        return new b(this, LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300d3, null));
    }

    public void c(ListCollectionItem listcollectionitem)
    {
        int j = mListItems.indexOf(listcollectionitem);
        mListItems.remove(j);
        if (mListItems.size() == 1)
        {
            d();
        } else
        {
            e(j);
        }
        if (mListener != null)
        {
            mListener.a(listcollectionitem, j);
        }
    }

    public void d(ListCollectionItem listcollectionitem)
    {
        c(mListItems.indexOf(listcollectionitem));
        listcollectionitem.a(false);
    }

    public void e(ListCollectionItem listcollectionitem)
    {
        if (mListener != null)
        {
            mListener.a(listcollectionitem);
        }
    }

    public void f(ListCollectionItem listcollectionitem)
    {
        c(listcollectionitem);
    }

    public void g(ListCollectionItem listcollectionitem)
    {
        b(listcollectionitem);
    }

    public void h()
    {
        mListItems.clear();
        d();
    }

    public boolean i()
    {
        if (mListener != null)
        {
            return mListener.a();
        } else
        {
            return false;
        }
    }
}
