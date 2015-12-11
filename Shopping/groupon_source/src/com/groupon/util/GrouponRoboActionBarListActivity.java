// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.groupon.foundations.activity.BaseActionBarActivity;

public class GrouponRoboActionBarListActivity extends BaseActionBarActivity
{

    private ListAdapter mAdapter;
    private boolean mFinishedStart;
    private Handler mHandler;
    private ListView mList;
    private android.widget.AdapterView.OnItemClickListener mOnClickListener;
    private Runnable mRequestFocus;

    public GrouponRoboActionBarListActivity()
    {
        mRequestFocus = new Runnable() {

            final GrouponRoboActionBarListActivity this$0;

            public void run()
            {
                mList.focusableViewAvailable(mList);
            }

            
            {
                this$0 = GrouponRoboActionBarListActivity.this;
                super();
            }
        };
        mHandler = new Handler();
        mFinishedStart = false;
        mOnClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final GrouponRoboActionBarListActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                onListItemClick((ListView)adapterview, view, i, l);
            }

            
            {
                this$0 = GrouponRoboActionBarListActivity.this;
                super();
            }
        };
    }

    private void ensureList()
    {
        if (mList != null)
        {
            return;
        } else
        {
            setContentView(0x7f03014e);
            return;
        }
    }

    public ListAdapter getListAdapter()
    {
        return mAdapter;
    }

    public ListView getListView()
    {
        ensureList();
        return mList;
    }

    public long getSelectedItemId()
    {
        return mList.getSelectedItemId();
    }

    public int getSelectedItemPosition()
    {
        return mList.getSelectedItemPosition();
    }

    protected void onDestroy()
    {
        mHandler.removeCallbacks(mRequestFocus);
        super.onDestroy();
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        ensureList();
        super.onRestoreInstanceState(bundle);
    }

    public void onSupportContentChanged()
    {
        super.onSupportContentChanged();
        View view = findViewById(0x1020004);
        mList = (ListView)findViewById(0x102000a);
        if (mList == null)
        {
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        }
        if (view != null)
        {
            mList.setEmptyView(view);
        }
        mList.setOnItemClickListener(mOnClickListener);
        if (mFinishedStart)
        {
            setListAdapter(mAdapter);
        }
        mHandler.post(mRequestFocus);
        mFinishedStart = true;
    }

    public void setListAdapter(ListAdapter listadapter)
    {
        this;
        JVM INSTR monitorenter ;
        ensureList();
        mAdapter = listadapter;
        mList.setAdapter(listadapter);
        this;
        JVM INSTR monitorexit ;
        return;
        listadapter;
        this;
        JVM INSTR monitorexit ;
        throw listadapter;
    }

    public void setSelection(int i)
    {
        mList.setSelection(i);
    }

}
