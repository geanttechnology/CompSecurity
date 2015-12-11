// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import commonlib.adapter.EndlessAdapter;
import commonlib.manager.PaginatedSyncManager;

public class DealsAndMyGrouponsBaseEndlessAdapter extends EndlessAdapter
{
    public static interface PaginatedSyncManagerProvider
    {

        public abstract PaginatedSyncManager getSyncManager();
    }


    private PaginatedSyncManagerProvider paginatedSyncManagerProvider;
    private commonlib.manager.SyncManager.SyncUiCallbacks syncUiCallbacksListener;

    public DealsAndMyGrouponsBaseEndlessAdapter(PaginatedSyncManagerProvider paginatedsyncmanagerprovider, commonlib.manager.SyncManager.SyncUiCallbacks syncuicallbacks, BaseAdapter baseadapter)
    {
        super(baseadapter);
        paginatedSyncManagerProvider = paginatedsyncmanagerprovider;
        syncUiCallbacksListener = syncuicallbacks;
    }

    public View createPendingView(ViewGroup viewgroup)
    {
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030201, null);
    }

    public int getCount()
    {
        if (!forceStopAppending && getWrappedAdapter().getCount() == 0)
        {
            return 1;
        } else
        {
            return super.getCount();
        }
    }

    public int getItemViewType(int i)
    {
        if (!forceStopAppending && getWrappedAdapter().getCount() == 0 && i == 0)
        {
            return getWrappedAdapter().getViewTypeCount();
        } else
        {
            return super.getItemViewType(i);
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (!forceStopAppending && getWrappedAdapter().getCount() == 0 && i == 0)
        {
            return getPendingView(viewgroup);
        } else
        {
            return super.getView(i, view, viewgroup);
        }
    }

    public int getWrappedAdapterCount()
    {
        return getWrappedAdapter().getCount();
    }

    protected void requestNextPage()
    {
        paginatedSyncManagerProvider.getSyncManager().requestSyncNextPage(syncUiCallbacksListener, null);
    }
}
