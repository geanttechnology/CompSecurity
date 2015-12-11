// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mixerbox.mixerbox3b.adapters.SortAdapter;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.c;
import com.mobeta.android.dslv.i;
import java.util.ArrayList;

public class SortFragment extends ListFragment
{

    SortAdapter adapter;
    public ArrayList array;
    public Context ctx;
    public boolean dragEnabled;
    public int dragStartMode;
    private c mController;
    private DragSortListView mDslv;
    private i onDrop;
    public String pid;
    public boolean sortEnabled;

    public SortFragment()
    {
        dragStartMode = 0;
        sortEnabled = true;
        dragEnabled = true;
        onDrop = new _cls1();
    }

    public c buildController(DragSortListView dragsortlistview)
    {
        dragsortlistview = new c(dragsortlistview);
        dragsortlistview.b(0x7f070125);
        dragsortlistview.b(false);
        dragsortlistview.a(sortEnabled);
        dragsortlistview.a(dragStartMode);
        return dragsortlistview;
    }

    public c getController()
    {
        return mController;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mDslv = (DragSortListView)getListView();
        mDslv.setDropListener(onDrop);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        mDslv = (DragSortListView)layoutinflater.inflate(0x7f030037, viewgroup, false);
        mController = buildController(mDslv);
        mDslv.setFloatViewManager(mController);
        mDslv.setOnTouchListener(mController);
        mDslv.setDragEnabled(dragEnabled);
        return mDslv;
    }

    public void setListAdapter()
    {
        adapter = new SortAdapter(ctx, array);
        setListAdapter(((android.widget.ListAdapter) (adapter)));
    }

    private class _cls1
        implements i
    {

        final SortFragment this$0;

        public void drop(int j, int k)
        {
            if (j != k)
            {
                SongItem songitem = (SongItem)array.get(j);
                array.remove(j);
                array.add(k, songitem);
                adapter.notifyDataSetChanged();
            }
        }

        _cls1()
        {
            this$0 = SortFragment.this;
            super();
        }
    }

}
