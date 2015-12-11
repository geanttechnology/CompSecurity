// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.ui.adapter.b.e;
import com.target.ui.util.al;
import java.util.List;

public class SearchHistoryItemsAdapter extends e
{
    static class ViewHolder extends com.target.ui.view.a
    {

        ImageView editView;
        TextView title;

        public ViewHolder(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(String s);
    }


    private a mSearchEditClickListener;
    private boolean mShowEditIcon;
    private boolean mShowIcon;

    public SearchHistoryItemsAdapter(Context context, List list)
    {
        super(context, list);
        mShowIcon = true;
        mShowEditIcon = false;
        setNotifyOnChange(false);
    }

    private ViewHolder a(View view)
    {
        return new ViewHolder(view);
    }

    static a a(SearchHistoryItemsAdapter searchhistoryitemsadapter)
    {
        return searchhistoryitemsadapter.mSearchEditClickListener;
    }

    protected int a()
    {
        return 0x7f0301ec;
    }

    public void a(a a1)
    {
        mSearchEditClickListener = a1;
    }

    public void a(List list)
    {
        clear();
        addAll(list);
        notifyDataSetChanged();
    }

    public void a(boolean flag)
    {
        mShowIcon = flag;
    }

    public void b(boolean flag)
    {
        mShowEditIcon = flag;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j = 0;
        if (view == null)
        {
            view = mInflater.inflate(a(), viewgroup, false);
            viewgroup = view.findViewById(0x7f100442);
            final String title;
            if (!mShowIcon)
            {
                j = 8;
            }
            viewgroup.setVisibility(j);
            viewgroup = a(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        title = (String)getItem(i);
        ((ViewHolder) (viewgroup)).title.setText(title);
        al.a(((ViewHolder) (viewgroup)).editView, mShowEditIcon);
        ((ViewHolder) (viewgroup)).editView.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchHistoryItemsAdapter this$0;
            final String val$title;

            public void onClick(View view1)
            {
                if (SearchHistoryItemsAdapter.a(SearchHistoryItemsAdapter.this) != null)
                {
                    SearchHistoryItemsAdapter.a(SearchHistoryItemsAdapter.this).a(title);
                }
            }

            
            {
                this$0 = SearchHistoryItemsAdapter.this;
                title = s;
                super();
            }
        });
        return view;
    }
}
