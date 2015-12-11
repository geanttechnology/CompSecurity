// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.Channel;
import com.groupon.manager.UniversalInfo;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.util.BaseRecyclerViewDelegate;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.loader.IUniversalCallback;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public abstract class BaseRecyclerViewActivity extends GrouponActivity
    implements com.groupon.util.BaseRecyclerViewDelegate.SyncManagerHelper, GrouponDialogListener, IViewCallback, IUniversalCallback, commonlib.manager.SyncManager.SyncUiCallbacks
{

    protected BaseRecyclerViewDelegate baseRecyclerViewDelegate;
    protected String dbChannel;
    protected View emptyView;
    protected IntentFactory intentFactory;
    protected LoggingUtils loggingUtils;
    protected Channel pagerChannel;
    protected RecyclerView recyclerView;
    ViewGroup scrollableContent;
    protected UniversalSyncManager universalSyncManager;

    public BaseRecyclerViewActivity()
    {
    }

    protected void configureEmptyView(View view)
    {
    }

    protected abstract void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks);

    protected abstract void configureSyncManager(UniversalSyncManager universalsyncmanager);

    protected void configureSyncManagerAndLoader(UniversalListAdapter universallistadapter)
    {
        configureSyncManager(universalSyncManager);
        UniversalLoaderCallbacks universalloadercallbacks = new UniversalLoaderCallbacks(universallistadapter, this, dbChannel, this);
        configureLoaderAndAdapter(universallistadapter, universalloadercallbacks);
        getLoaderManager().initLoader(0, null, universalloadercallbacks);
    }

    protected boolean enablePullToRefresh()
    {
        return true;
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
        baseRecyclerViewDelegate.enableSyncProgressIndicator(flag);
    }

    public void forceReload()
    {
        baseRecyclerViewDelegate.forceReload();
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f03002b;
    }

    public UniversalInfo getInfoForSync()
    {
        return null;
    }

    public int getLayoutId()
    {
        return 0x7f0301d7;
    }

    protected List getListItemDecorations()
    {
        return new ArrayList();
    }

    public android.support.v7.widget.RecyclerView.OnScrollListener getRecyclerOnScrollListener()
    {
        return null;
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        baseRecyclerViewDelegate.handleSyncError(runnable, exception, this);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        baseRecyclerViewDelegate.initDelegate(this, this, getRecyclerOnScrollListener(), this, getEmptyViewLayoutId(), enablePullToRefresh(), syncAutomaticallyOnResume(), getListItemDecorations());
        baseRecyclerViewDelegate.onCreateView(scrollableContent, getLayoutInflater());
        baseRecyclerViewDelegate.onActivityCreated(bundle);
        emptyView = baseRecyclerViewDelegate.getEmptyView();
        recyclerView = baseRecyclerViewDelegate.getRecyclerView();
        universalSyncManager = baseRecyclerViewDelegate.getUniversalSyncManager();
        configureEmptyView(emptyView);
        configureSyncManagerAndLoader(baseRecyclerViewDelegate.getDataAdapter());
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        baseRecyclerViewDelegate.onLoaderDataChanged(universallistloadresultdata, flag);
    }

    public void onPause()
    {
        baseRecyclerViewDelegate.onPause();
        super.onPause();
    }

    public void onPendingViewBound()
    {
        baseRecyclerViewDelegate.onPendingViewBound();
    }

    public void onResume()
    {
        super.onResume();
        baseRecyclerViewDelegate.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        baseRecyclerViewDelegate.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void onViewClick(View view)
    {
    }

    protected boolean syncAutomaticallyOnResume()
    {
        return true;
    }
}
