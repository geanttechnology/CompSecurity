// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CompositeArrayRecyclerAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    public static abstract class BaseViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        abstract void bindView(int i, Object obj);

        public BaseViewHolder(View view)
        {
            super(view);
        }
    }

    public static class HeaderViewHolder extends BaseViewHolder
    {

        public final TextView textView;

        final void bindView(int i, Object obj)
        {
            onBindView(i, (CharSequence)obj);
        }

        protected void onBindView(int i, CharSequence charsequence)
        {
            textView.setText(charsequence);
        }

        public HeaderViewHolder(View view)
        {
            super(view);
            if (view instanceof TextView)
            {
                textView = (TextView)view;
                return;
            }
            try
            {
                textView = (TextView)view.findViewById(0x1020014);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                Log.e("CompositeArrayRVAdapter", "You must supply a resource with ID android.R.id.text1 for a TextView");
            }
            throw new IllegalStateException("CompositeArrayRecyclerAdapter requires the resource ID android.R.id.text1 to be a TextView", view);
        }
    }

    private final class Helper extends com.ebay.nautilus.shell.widget.CompositeArrayAdapter.SectionManager
    {

        final CompositeArrayRecyclerAdapter this$0;

        protected void onRequestMore(com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j)
        {
            _requestMoreListener.onRequestMore(CompositeArrayRecyclerAdapter.this, section, i, j);
        }

        private Helper()
        {
            this$0 = CompositeArrayRecyclerAdapter.this;
            super();
        }

    }

    public static class ItemViewHolder extends BaseViewHolder
    {

        public final TextView textView;

        final void bindView(int i, Object obj)
        {
            onBindView(i, obj);
        }

        protected void onBindView(int i, Object obj)
        {
            if (obj instanceof CharSequence)
            {
                textView.setText((CharSequence)obj);
                return;
            } else
            {
                textView.setText(obj.toString());
                return;
            }
        }

        public ItemViewHolder(View view, TextView textview)
        {
            super(view);
            textView = textview;
        }
    }

    public static class ListIndexViewHolder extends BaseViewHolder
    {

        final void bindView(int i, Object obj)
        {
            onBindView(i, ((Integer)obj).intValue());
        }

        protected void onBindView(int i, int j)
        {
        }

        public ListIndexViewHolder(View view)
        {
            super(view);
        }
    }

    public static interface OnRequestMoreListener
    {

        public abstract void onRequestMore(CompositeArrayRecyclerAdapter compositearrayrecycleradapter, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j);
    }


    public static final int VIEW_TYPE_EMPTY = 2;
    public static final int VIEW_TYPE_HEADER = 1;
    public static final int VIEW_TYPE_ITEM = 0;
    public static final int VIEW_TYPE_LOADING = 4;
    public static final int VIEW_TYPE_MORE = 3;
    private final Context _context;
    private final int _fieldId;
    private final Helper _helper;
    private final LayoutInflater _inflater;
    private boolean _notifyOnChange;
    private OnRequestMoreListener _requestMoreListener;
    private int _resource;

    public CompositeArrayRecyclerAdapter(Context context, int i)
    {
        this(context, i, 0, ((List) (new ArrayList())));
    }

    public CompositeArrayRecyclerAdapter(Context context, int i, int j)
    {
        this(context, i, j, ((List) (new ArrayList())));
    }

    public CompositeArrayRecyclerAdapter(Context context, int i, int j, List list)
    {
        _helper = new Helper();
        _notifyOnChange = true;
        _context = context;
        _inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        _resource = i;
        _fieldId = j;
        _helper.init(list);
    }

    public CompositeArrayRecyclerAdapter(Context context, int i, int j, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section asection[])
    {
        this(context, i, j, Arrays.asList(asection));
    }

    public CompositeArrayRecyclerAdapter(Context context, int i, List list)
    {
        this(context, i, 0, list);
    }

    public CompositeArrayRecyclerAdapter(Context context, int i, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section asection[])
    {
        this(context, i, 0, Arrays.asList(asection));
    }

    public void add(com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section)
    {
        _helper.add(section);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public void addAll(Collection collection)
    {
        _helper.addAll(collection);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public void clear()
    {
        _helper.clear();
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public Context getContext()
    {
        return _context;
    }

    public Object getItem(int i)
    {
        return _helper.getItem(i);
    }

    public int getItemCount()
    {
        return _helper.getCount();
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return _helper.getItemViewType(i);
    }

    public com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section getList(int i)
    {
        return _helper.getList(i);
    }

    public int getListCount()
    {
        return _helper.getListCount();
    }

    public int getListIndexFromItemPosition(int i)
    {
        return _helper.getListIndexFromItemPosition(i);
    }

    public com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section getSectionByType(int i)
    {
        return _helper.getSectionByType(i);
    }

    public com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section getSectionFromItemPosition(int i)
    {
        return _helper.getSectionFromItemPosition(i);
    }

    public void insert(com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i)
    {
        _helper.insert(section, i);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public boolean isEmpty()
    {
        return _helper.isEmpty();
    }

    public final com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section newSection(int i, String s, List list, int j, int k, int l, int i1)
    {
        int j1;
        if (list == null)
        {
            j1 = 0;
        } else
        {
            j1 = list.size();
        }
        return new com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section(i, s, list, j, j1, k, l, i1);
    }

    public final com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section newSection(int i, String s, List list, int j, int k, int l, int i1, 
            int j1)
    {
        return new com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section(i, s, list, j, k, l, i1, j1);
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((BaseViewHolder)viewholder, i);
    }

    public void onBindViewHolder(BaseViewHolder baseviewholder, int i)
    {
        if (_requestMoreListener != null)
        {
            _helper.checkIfLoadIsNeeded(i);
        }
        baseviewholder.bindView(i, getItem(i));
    }

    public ListIndexViewHolder onCreateEmptyViewHolder(ViewGroup viewgroup)
    {
        return new ListIndexViewHolder(_inflater.inflate(_helper.getEmptyViewResource(), viewgroup, false));
    }

    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup viewgroup)
    {
        return new HeaderViewHolder(_inflater.inflate(_helper.getHeaderViewResource(), viewgroup, false));
    }

    public ItemViewHolder onCreateItemViewHolder(ViewGroup viewgroup)
    {
        View view = _inflater.inflate(_resource, viewgroup, false);
        if (_fieldId != 0) goto _L2; else goto _L1
_L1:
        viewgroup = (TextView)view;
_L4:
        return new ItemViewHolder(view, viewgroup);
_L2:
        try
        {
            viewgroup = (TextView)view.findViewById(_fieldId);
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            Log.e("CompositeArrayRVAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("CompositeArrayRecyclerAdapter requires the resource ID to be a TextView", viewgroup);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ListIndexViewHolder onCreateLoadingViewHolder(ViewGroup viewgroup)
    {
        viewgroup = _inflater.inflate(_helper.getLoadingViewResource(), viewgroup, false);
        viewgroup.setVisibility(0);
        return new ListIndexViewHolder(viewgroup);
    }

    public ListIndexViewHolder onCreateMoreViewHolder(ViewGroup viewgroup)
    {
        return new ListIndexViewHolder(_inflater.inflate(_helper.getMoreViewResource(), viewgroup, false));
    }

    public volatile android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return onCreateViewHolder(viewgroup, i);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return onCreateItemViewHolder(viewgroup);

        case 1: // '\001'
            return onCreateHeaderViewHolder(viewgroup);

        case 2: // '\002'
            return onCreateEmptyViewHolder(viewgroup);

        case 3: // '\003'
            return onCreateMoreViewHolder(viewgroup);

        case 4: // '\004'
            return onCreateLoadingViewHolder(viewgroup);
        }
    }

    public void remove(com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section)
    {
        _helper.remove(section);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public void setEmptyViewResource(int i)
    {
        _helper.setEmptyViewResource(i);
    }

    public void setHeaderViewResource(int i)
    {
        _helper.setHeaderViewResource(i);
    }

    public void setList(int i, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section)
    {
        _helper.setList(i, section);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public void setLoadingViewResource(int i)
    {
        _helper.setLoadingViewResource(i);
    }

    public void setMoreViewResource(int i)
    {
        _helper.setMoreViewResource(i);
    }

    public void setNotifyOnChange(boolean flag)
    {
        _notifyOnChange = flag;
    }

    public void setOnRequestMoreListener(OnRequestMoreListener onrequestmorelistener)
    {
        _requestMoreListener = onrequestmorelistener;
    }

    public void sort(Comparator comparator)
    {
        _helper.sort(comparator);
        if (_notifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

}
