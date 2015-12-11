// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.f2prateek.dart.Dart;
import com.groupon.Channel;
import com.groupon.activity.Carousel;
import com.groupon.activity.IntentFactory;
import com.groupon.manager.UniversalInfo;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.util.BaseRecyclerViewDelegate;
import com.groupon.util.DialogManager;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.fragment.GrouponNormalFragmentV3;
import com.groupon.v3.loader.IUniversalCallback;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.util.ScrollToolBarHelperV3;
import com.groupon.v3.util.ViewsPerSecondHelperV3;
import com.groupon.v3.view.GrouponSwipeRefreshLayoutV3;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewFragment extends GrouponNormalFragmentV3
    implements com.groupon.util.BaseRecyclerViewDelegate.SyncManagerHelper, IViewCallback, IUniversalCallback, commonlib.manager.SyncManager.SyncUiCallbacks
{

    protected static final String DB_CHANNEL = "db_channel";
    protected static final String PAGER_CHANNEL = "pager_channel";
    protected Activity activity;
    protected BaseRecyclerViewDelegate baseRecyclerViewDelegate;
    protected String dbChannel;
    protected DialogManager dialogManager;
    protected View emptyView;
    protected IntentFactory intentFactory;
    protected LoggingUtils loggingUtils;
    protected Channel pagerChannel;
    protected SharedPreferences prefs;
    protected RecyclerView recyclerView;
    protected ScrollToolBarHelperV3 scrollToolBarHelper;
    protected UniversalSyncManager universalSyncManager;
    protected ViewsPerSecondHelperV3 vpsHelper;

    public BaseRecyclerViewFragment()
    {
    }

    public BaseRecyclerViewFragment(Channel channel, String s)
    {
        pagerChannel = channel;
        dbChannel = s;
    }

    protected void configureEmptyView(View view)
    {
    }

    protected abstract void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks);

    protected abstract void configureSyncManager(UniversalSyncManager universalsyncmanager);

    protected void configureSyncManagerAndLoader(UniversalListAdapter universallistadapter)
    {
        configureSyncManager(universalSyncManager);
        UniversalLoaderCallbacks universalloadercallbacks = new UniversalLoaderCallbacks(universallistadapter, getActivity(), dbChannel, this);
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
        return 0x7f0300d9;
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
        baseRecyclerViewDelegate.handleSyncError(runnable, exception, getActivity());
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        baseRecyclerViewDelegate.onActivityCreated(bundle);
        configureSyncManagerAndLoader(baseRecyclerViewDelegate.getDataAdapter());
        if (activity instanceof Carousel)
        {
            scrollToolBarHelper.initToolBar((Carousel)activity, this);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Dart.inject(this);
        if (bundle != null)
        {
            pagerChannel = (Channel)bundle.getSerializable("pager_channel");
            dbChannel = bundle.getString("db_channel");
        }
        baseRecyclerViewDelegate.initDelegate(getActivity(), this, getRecyclerOnScrollListener(), this, getEmptyViewLayoutId(), enablePullToRefresh(), syncAutomaticallyOnResume(), getListItemDecorations());
        universalSyncManager = baseRecyclerViewDelegate.getUniversalSyncManager();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (prefs.getBoolean("adminMenuEnabled", false))
        {
            vpsHelper.onCreateOptionsMenu(menu);
        }
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(getLayoutId(), viewgroup, false);
        ButterKnife.bind(this, viewgroup);
        baseRecyclerViewDelegate.onCreateView(viewgroup, layoutinflater);
        emptyView = baseRecyclerViewDelegate.getEmptyView();
        configureEmptyView(emptyView);
        recyclerView = baseRecyclerViewDelegate.getRecyclerView();
        return viewgroup;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        baseRecyclerViewDelegate.onLoaderDataChanged(universallistloadresultdata, flag);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return vpsHelper.onOptionsItemSelected(dialogManager, baseRecyclerViewDelegate.getRecyclerView(), menuitem) || super.onOptionsItemSelected(menuitem);
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

    public void onPrepareOptionsMenu(Menu menu)
    {
        GrouponSwipeRefreshLayoutV3 grouponswiperefreshlayoutv3 = baseRecyclerViewDelegate.getSwipeLayout();
        if (grouponswiperefreshlayoutv3 != null)
        {
            setRefreshMenuItemEnabled(grouponswiperefreshlayoutv3.isEnabled());
        }
        super.onPrepareOptionsMenu(menu);
    }

    public void onResume()
    {
        super.onResume();
        baseRecyclerViewDelegate.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        baseRecyclerViewDelegate.onSaveInstanceState(bundle);
        bundle.putSerializable("pager_channel", pagerChannel);
        bundle.putString("db_channel", dbChannel);
        super.onSaveInstanceState(bundle);
    }

    public void onViewClick(View view)
    {
    }

    protected void setList(List list)
    {
        baseRecyclerViewDelegate.getDataAdapter().setList(list);
        View view = emptyView;
        int i;
        if (list.isEmpty())
        {
            i = 0;
        } else
        {
            i = 4;
        }
        view.setVisibility(i);
    }

    protected boolean syncAutomaticallyOnResume()
    {
        return true;
    }
}
