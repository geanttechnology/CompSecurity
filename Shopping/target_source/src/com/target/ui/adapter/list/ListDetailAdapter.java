// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.list;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.e.a.a;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.ui.model.list.ListDetailCompletedItem;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.model.list.b;
import com.target.ui.view.list.ListItemCompletedView;
import com.target.ui.view.list.ListItemView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.adapter.list:
//            a

public class ListDetailAdapter extends com.e.a.a
    implements com.target.ui.view.list.ListItemCompletedView.a, com.target.ui.view.list.ListItemView.a
{
    static class NormalItemViewHolder extends c
    {

        View gripper;

        public boolean x()
        {
            return true;
        }

        public NormalItemViewHolder(com.e.a.a a1, View view)
        {
            super(a1, view);
            ButterKnife.bind(this, view);
        }
    }

    static class SectionHeaderViewHolder extends c
    {

        TextView title;

        public boolean x()
        {
            return false;
        }

        public SectionHeaderViewHolder(com.e.a.a a1, View view)
        {
            super(a1, view);
            ButterKnife.bind(this, view);
        }
    }

    static class a extends c
    {

        public boolean x()
        {
            return true;
        }

        public a(com.e.a.a a1, View view)
        {
            super(a1, view);
        }
    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(ListDetailCompletedItem listdetailcompleteditem);

        public abstract void a(ListDetailItem listdetailitem);

        public abstract void a(ListDetailItem listdetailitem, int i1);

        public abstract void a(ListDetailItem listdetailitem, View view);

        public abstract void a(boolean flag);

        public abstract void b();

        public abstract void b(ListDetailItem listdetailitem);

        public abstract void b(ListDetailItem listdetailitem, int i1);

        public abstract void c(ListDetailItem listdetailitem);

        public abstract void c(ListDetailItem listdetailitem, int i1);

        public abstract void d(ListDetailItem listdetailitem);

        public abstract void d(ListDetailItem listdetailitem, int i1);

        public abstract void setAnimationsFinishedListener(com.target.ui.adapter.list.a a1);
    }

    static abstract class c extends com.e.a.a.b
    {

        public abstract boolean x();

        public c(com.e.a.a a1, View view)
        {
            super(a1, view);
        }
    }


    private static final String TAG = com/target/ui/adapter/list/ListDetailAdapter.getSimpleName();
    private List mCompletedItems;
    private com.target.ui.model.list.a mCompletedSectionHeader;
    private boolean mIsDragging;
    private boolean mIsEditMode;
    private List mListItems;
    private b mListener;
    private final RecyclerView mRecyclerView;

    public ListDetailAdapter(b b1, RecyclerView recyclerview, String s)
    {
        super(recyclerview);
        if (b1 == null)
        {
            throw new IllegalArgumentException("The listener passed to the ListDetailAdapter is null");
        } else
        {
            mListItems = new ArrayList();
            mCompletedItems = new ArrayList();
            mCompletedSectionHeader = new com.target.ui.model.list.a(s);
            mListener = b1;
            mRecyclerView = recyclerview;
            return;
        }
    }

    private com.target.ui.model.list.b f(int i1)
    {
        if (i1 < mListItems.size())
        {
            return (com.target.ui.model.list.b)mListItems.get(i1);
        }
        if (i1 == mListItems.size())
        {
            return mCompletedSectionHeader;
        } else
        {
            return (com.target.ui.model.list.b)mCompletedItems.get(g(i1));
        }
    }

    private int g(int i1)
    {
        return i1 - (mListItems.size() + 1);
    }

    private int h(int i1)
    {
        int k1 = mListItems.size();
        int j1 = i1;
        if (i1 > k1)
        {
            j1 = k1;
        }
        return j1;
    }

    private void j(ListDetailItem listdetailitem)
    {
        b(false);
        int i1 = mListItems.indexOf(listdetailitem);
        if (i1 == -1)
        {
            d();
            return;
        }
        mListItems.remove(i1);
        if (mListItems.size() == 1)
        {
            d();
            return;
        } else
        {
            e(i1);
            return;
        }
    }

    public int a()
    {
        int j1 = mListItems.size();
        int i1 = j1;
        if (!mCompletedItems.isEmpty())
        {
            i1 = j1 + (mCompletedItems.size() + 1);
        }
        return i1;
    }

    public int a(int i1)
    {
        return f(i1).a();
    }

    public int a(long l1)
    {
        for (int i1 = 0; i1 < mListItems.size(); i1++)
        {
            if ((long)((ListDetailItem)mListItems.get(i1)).e().getKey() == l1)
            {
                return i1;
            }
        }

        return -1;
    }

    public int a(ListDetailItem listdetailitem)
    {
        int i1 = mListItems.size();
        a(listdetailitem, i1);
        return i1;
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i1)
    {
        return c(viewgroup, i1);
    }

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int i1)
    {
        a((c)t, i1);
    }

    public void a(c c1, int i1)
    {
        boolean flag = false;
        switch (f(i1).a())
        {
        default:
            return;

        case 2: // '\002'
            Object obj = (NormalItemViewHolder)c1;
            ListItemView listitemview = (ListItemView)c1.itemView;
            ListDetailItem listdetailitem = (ListDetailItem)mListItems.get(i1);
            obj = ((NormalItemViewHolder) (obj)).gripper;
            if (mListItems.size() == 1)
            {
                i1 = 8;
            } else
            {
                i1 = 0;
            }
            ((View) (obj)).setVisibility(i1);
            listitemview.a(listdetailitem, this, c1);
            if (f() == (long)listdetailitem.e().getKey())
            {
                flag = true;
            }
            listitemview.c(flag);
            return;

        case 1: // '\001'
            ((SectionHeaderViewHolder)c1).title.setText(mCompletedSectionHeader.b());
            return;

        case 3: // '\003'
            ((ListItemCompletedView)c1.itemView).a((ListDetailCompletedItem)mCompletedItems.get(g(i1)), this);
            return;
        }
    }

    public void a(com.target.ui.adapter.list.a a1)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.setAnimationsFinishedListener(a1);
            return;
        }
    }

    public void a(ListDetailCompletedItem listdetailcompleteditem)
    {
        int i1 = mCompletedItems.indexOf(listdetailcompleteditem);
        mCompletedItems.remove(listdetailcompleteditem);
        i1 += mListItems.size() + 1;
        e(i1);
        if (mCompletedItems.isEmpty())
        {
            e(i1 - 1);
        }
        if (mListener != null)
        {
            mListener.a(listdetailcompleteditem);
        }
    }

    public void a(ListDetailItem listdetailitem, int i1)
    {
        i1 = h(i1);
        mListItems.add(i1, listdetailitem);
        d(i1);
        mRecyclerView.a_(i1);
        if (mListener != null)
        {
            mListener.b(listdetailitem);
        }
    }

    public void a(ListDetailItem listdetailitem, View view)
    {
        if (mListener != null)
        {
            mListener.a(listdetailitem, view);
        }
    }

    public void a(List list)
    {
        mCompletedItems.clear();
        mCompletedItems.addAll(list);
    }

    public void a(boolean flag, ListItemView listitemview)
    {
        LinearLayoutManager linearlayoutmanager = (LinearLayoutManager)mRecyclerView.getLayoutManager();
        int j1 = mListItems.size();
        int i1 = 0;
        while (i1 < j1) 
        {
            ListItemView listitemview1 = (ListItemView)linearlayoutmanager.c(i1);
            if (listitemview1 != null)
            {
                listitemview1.setDisabled(flag);
                if (listitemview1 != listitemview)
                {
                    listitemview1.setDisabled(flag);
                    if (flag)
                    {
                        listitemview1.b(false);
                    } else
                    {
                        listitemview1.a(false);
                    }
                }
            }
            i1++;
        }
    }

    public long b(int i1)
    {
        com.target.ui.model.list.b b1 = f(i1);
        switch (b1.a())
        {
        default:
            return -1L;

        case 2: // '\002'
            return (long)((ListDetailItem)b1).e().getKey();

        case 3: // '\003'
            return (long)((ListDetailCompletedItem)b1).e().getKey();
        }
    }

    public void b(ListDetailCompletedItem listdetailcompleteditem)
    {
        mCompletedItems.add(0, listdetailcompleteditem);
        int i1 = mCompletedItems.size();
        if (mCompletedItems.size() == 1)
        {
            d(i1);
        }
        d(i1 + 1);
    }

    public void b(ListDetailItem listdetailitem)
    {
        int i1 = mListItems.indexOf(listdetailitem);
        j(listdetailitem);
        if (mListener != null)
        {
            mListener.d(listdetailitem, i1);
        }
    }

    public void b(boolean flag)
    {
        if (mListener != null)
        {
            mListener.a(flag);
        }
        mIsEditMode = flag;
    }

    public boolean b(int i1, int j1)
    {
        if (j1 >= mListItems.size())
        {
            return false;
        }
        ListDetailItem listdetailitem = (ListDetailItem)mListItems.get(i1);
        mListItems.add(j1, mListItems.remove(i1));
        if (mListener != null)
        {
            mListener.c(listdetailitem, j1);
            return true;
        } else
        {
            return false;
        }
    }

    public c c(ViewGroup viewgroup, int i1)
    {
        switch (i1)
        {
        default:
            return null;

        case 2: // '\002'
            return new NormalItemViewHolder(this, LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300d6, null));

        case 1: // '\001'
            return new SectionHeaderViewHolder(this, LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300d8, null));

        case 3: // '\003'
            return new a(this, LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300d5, null));
        }
    }

    public void c(ListDetailItem listdetailitem)
    {
        c(mListItems.indexOf(listdetailitem));
        listdetailitem.a(false);
    }

    public void d(ListDetailItem listdetailitem)
    {
        j(listdetailitem);
        if (mListener != null)
        {
            mListener.d(listdetailitem);
        }
    }

    public void e()
    {
        super.e();
        if (mListener != null)
        {
            mListener.b();
        }
        mIsDragging = false;
    }

    public void e(ListDetailItem listdetailitem)
    {
        if (mListener != null)
        {
            mListener.a(listdetailitem);
        }
    }

    public void f(ListDetailItem listdetailitem)
    {
label0:
        {
            if (mListener != null)
            {
                if (listdetailitem.h() >= 1)
                {
                    break label0;
                }
                b(listdetailitem);
            }
            return;
        }
        mListener.c(listdetailitem);
    }

    public void g(ListDetailItem listdetailitem)
    {
        if (mListener != null)
        {
            c(listdetailitem);
            int i1 = mListItems.indexOf(listdetailitem);
            mListener.a(listdetailitem, i1);
        }
    }

    public void h()
    {
        d();
    }

    public void h(ListDetailItem listdetailitem)
    {
        b(listdetailitem);
    }

    public void i()
    {
        mListItems.clear();
        mCompletedItems.clear();
        d();
    }

    public void i(ListDetailItem listdetailitem)
    {
        int i1 = mListItems.indexOf(listdetailitem);
        if (mListener != null)
        {
            mListener.b(listdetailitem, i1);
        }
    }

    public void j()
    {
        mCompletedItems.clear();
        d();
    }

    public List k()
    {
        return mListItems;
    }

    public boolean l()
    {
        return mIsEditMode;
    }

    public boolean onDrag(View view, DragEvent dragevent)
    {
        if (!mIsDragging && dragevent.getAction() == 1)
        {
            if (mListener != null)
            {
                mListener.a();
            }
            mIsDragging = true;
        }
        return super.onDrag(view, dragevent);
    }

}
