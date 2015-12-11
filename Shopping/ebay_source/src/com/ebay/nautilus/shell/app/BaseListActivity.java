// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            BaseActivity, ActivityShimManager

public abstract class BaseListActivity extends BaseActivity
{
    private class Helper
        implements android.widget.AdapterView.OnItemClickListener, Runnable
    {

        private final Handler handler;
        final BaseListActivity this$0;

        public final void cancelRequestFocus()
        {
            handler.removeCallbacks(this);
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            onListItemClick((ListView)adapterview, view, i, l);
        }

        public final void requestFocus()
        {
            handler.post(this);
        }

        public void run()
        {
            _list.focusableViewAvailable(_list);
        }

        private Helper()
        {
            this$0 = BaseListActivity.this;
            super();
            handler = new Handler();
        }

    }


    private ListAdapter _adapter;
    private boolean _finishedLoading;
    private final Helper _helper = new Helper();
    private ListView _list;

    public BaseListActivity()
    {
        _finishedLoading = false;
    }

    private void ensureList()
    {
        if (_list != null)
        {
            return;
        } else
        {
            ListView listview = new ListView(this);
            listview.setId(0x102000a);
            setContentView(listview);
            return;
        }
    }

    public ListAdapter getListAdapter()
    {
        return _adapter;
    }

    public ListView getListView()
    {
        ensureList();
        return _list;
    }

    public long getSelectedItemId()
    {
        return _list.getSelectedItemId();
    }

    public int getSelectedItemPosition()
    {
        return _list.getSelectedItemPosition();
    }

    public void onContentChanged()
    {
        super.onContentChanged();
        View view = findViewById(0x1020004);
        _list = (ListView)findViewById(0x102000a);
        if (_list == null)
        {
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        }
        if (view != null)
        {
            _list.setEmptyView(view);
        }
        _list.setOnItemClickListener(_helper);
        if (_finishedLoading)
        {
            setListAdapter(_adapter);
        }
        _helper.requestFocus();
        _finishedLoading = true;
    }

    protected void onDestroy()
    {
        _helper.cancelRequestFocus();
        super.onDestroy();
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        if (ActivityShimManager.logCommonCallbacks.isLoggable)
        {
            logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
                listview, view, Integer.valueOf(i), Long.valueOf(l)
            });
        }
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
        _adapter = listadapter;
        _list.setAdapter(listadapter);
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
        _list.setSelection(i);
    }

}
