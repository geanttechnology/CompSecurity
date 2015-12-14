// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.adapter;

import android.content.Context;
import com.picsart.studio.utils.b;
import com.picsart.studio.view.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.socialin.android.adapter:
//            a

public abstract class RecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter
{

    public a clickListener;
    public Context context;
    public List itemsList;
    protected android.widget.AdapterView.OnItemLongClickListener longClickListener;
    public e onScrolledToEndListener;
    private b pagingFragment;
    public ViewStyle viewStyle;

    public RecyclerViewAdapter(Context context1)
    {
        this(context1, null);
    }

    public RecyclerViewAdapter(Context context1, a a)
    {
        context = context1;
        setOnItemClickListener(a);
        itemsList = new ArrayList();
    }

    public void add(Object obj)
    {
        itemsList.add(obj);
        notifyItemInserted(itemsList.size() - 1);
    }

    public void addAll(List list)
    {
        int i = getItemCount();
        itemsList.addAll(list);
        notifyItemRangeInserted(i, list.size());
    }

    public void clear()
    {
        itemsList.clear();
        if (pagingFragment != null)
        {
            pagingFragment.i_();
        }
    }

    public Object getItem(int i)
    {
        return itemsList.get(i);
    }

    public int getItemCount()
    {
        return itemsList.size();
    }

    public List getItems()
    {
        return Collections.unmodifiableList(itemsList);
    }

    public boolean isEmpty()
    {
        return itemsList.isEmpty();
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        if (i == itemsList.size() - 1 && onScrolledToEndListener != null)
        {
            onScrolledToEndListener.a();
        }
    }

    public void remove(Object obj)
    {
        itemsList.remove(obj);
        notifyDataSetChanged();
    }

    public void setItems(List list)
    {
        itemsList.clear();
        itemsList.addAll(list);
        notifyDataSetChanged();
        if (pagingFragment != null)
        {
            pagingFragment.i_();
        }
    }

    public void setOnItemClickListener(a a)
    {
        clickListener = a;
    }

    public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener)
    {
        longClickListener = onitemlongclicklistener;
    }

    public void setOnScrollToEndListener(e e1)
    {
        onScrolledToEndListener = e1;
    }

    public void setPagingFragment(b b1)
    {
        pagingFragment = b1;
    }

    public final void setViewStyle(ViewStyle viewstyle)
    {
        viewStyle = viewstyle;
        notifyDataSetChanged();
    }
}
