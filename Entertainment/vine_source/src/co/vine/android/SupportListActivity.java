// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class SupportListActivity extends FragmentActivity
{

    protected ListAdapter mAdapter;
    private boolean mFinishedStart;
    private Handler mHandler;
    protected ListView mList;
    private android.widget.AdapterView.OnItemClickListener mOnClickListener;
    private Runnable mRequestFocus;

    public SupportListActivity()
    {
        mHandler = new Handler();
        mFinishedStart = false;
        mRequestFocus = new Runnable() {

            final SupportListActivity this$0;

            public void run()
            {
                mList.focusableViewAvailable(mList);
            }

            
            {
                this$0 = SupportListActivity.this;
                super();
            }
        };
        mOnClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final SupportListActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                onListItemClick((ListView)adapterview, view, i, l);
            }

            
            {
                this$0 = SupportListActivity.this;
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
            setContentView(0x1090014);
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

    public void onContentChanged()
    {
        super.onContentChanged();
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
