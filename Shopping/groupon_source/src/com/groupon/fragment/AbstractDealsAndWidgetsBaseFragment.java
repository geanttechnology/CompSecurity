// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.LoginService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CountryUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.LoaderCallbacksUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ViewsPerSecondHelper;
import com.groupon.view.GrouponSwipeRefreshLayout;
import commonlib.adapter.PendingAdapterInterface;
import commonlib.manager.SyncManager;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            GrouponListFragment

public abstract class AbstractDealsAndWidgetsBaseFragment extends GrouponListFragment
    implements commonlib.manager.SyncManager.SyncUiCallbacks
{

    protected AbTestService abTestService;
    protected Activity activity;
    protected Channel channel;
    protected Lazy countryUtil;
    protected CurrentCountryManager currentCountryManager;
    protected DeepLinkManager deepLinkManager;
    protected Lazy dialogManager;
    protected Lazy intentFactory;
    protected LoggingUtils loggingUtils;
    protected Lazy loginService;
    protected String nstChannel;
    protected Channel pagerChannel;
    protected SharedPreferences prefs;
    GrouponSwipeRefreshLayout swipeLayout;
    protected String trackingTag;

    public AbstractDealsAndWidgetsBaseFragment(Channel channel1)
    {
        pagerChannel = channel1;
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
        if (flag)
        {
            setPullToRefreshEnabled(false);
            return;
        }
        if (swipeLayout != null)
        {
            swipeLayout.setRefreshing(false);
        }
        setPullToRefreshEnabled(true);
    }

    public void forceReload()
    {
        if (swipeLayout != null && swipeLayout.isEnabled())
        {
            swipeLayout.setRefreshing(true);
        }
        reload();
    }

    public abstract PendingAdapterInterface getAppendingAdapter();

    public abstract SyncManager getBaseSyncManager();

    protected Channel getChannel()
    {
        return channel;
    }

    public Channel getChannelNameForDealDetails()
    {
        return pagerChannel;
    }

    protected String getNstChannel()
    {
        return nstChannel;
    }

    protected void getOnSubsetClickedExtras(Bundle bundle)
    {
    }

    protected abstract String getWidgetNstChannelName();

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        LoaderCallbacksUtil.handleSyncError(runnable, exception, activity, (LoginService)loginService.get(), (CountryUtil)countryUtil.get(), currentCountryManager.getCurrentCountry(), getBaseSyncManager(), (IntentFactory)intentFactory.get(), new Function2() {

            final AbstractDealsAndWidgetsBaseFragment this$0;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable1, Exception exception1)
            {
                LoaderCallbacksUtil.showGenericErrorMessage(runnable1, exception1, activity, (DialogManager)dialogManager.get(), getBaseSyncManager(), new Function2() {

                    final _cls5 this$1;

                    public volatile void execute(Object obj, Object obj1)
                        throws Exception
                    {
                        execute((Runnable)obj, (Exception)obj1);
                    }

                    public void execute(Runnable runnable, Exception exception)
                    {
                        if (swipeLayout != null && swipeLayout.isEnabled())
                        {
                            swipeLayout.setRefreshing(true);
                        }
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                }, new Function2() {

                    final _cls5 this$1;

                    public volatile void execute(Object obj, Object obj1)
                        throws Exception
                    {
                        execute((Runnable)obj, (Exception)obj1);
                    }

                    public void execute(Runnable runnable, Exception exception)
                    {
                        handleSyncErrorCancellation(runnable, exception);
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
            }

            
            {
                this$0 = AbstractDealsAndWidgetsBaseFragment.this;
                super();
            }
        });
    }

    public void handleSyncErrorCancellation(Runnable runnable, Exception exception)
    {
        getAppendingAdapter().enableAppending(false);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        loginService = new Lazy(getActivity()) {

            final AbstractDealsAndWidgetsBaseFragment this$0;

            
            {
                this$0 = AbstractDealsAndWidgetsBaseFragment.this;
                super(context);
            }
        };
        countryUtil = new Lazy(getActivity()) {

            final AbstractDealsAndWidgetsBaseFragment this$0;

            
            {
                this$0 = AbstractDealsAndWidgetsBaseFragment.this;
                super(context);
            }
        };
        dialogManager = new Lazy(getActivity()) {

            final AbstractDealsAndWidgetsBaseFragment this$0;

            
            {
                this$0 = AbstractDealsAndWidgetsBaseFragment.this;
                super(context);
            }
        };
        intentFactory = new Lazy(getActivity()) {

            final AbstractDealsAndWidgetsBaseFragment this$0;

            
            {
                this$0 = AbstractDealsAndWidgetsBaseFragment.this;
                super(context);
            }
        };
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null)
        {
            channel = (Channel)bundle.getParcelable("channel");
            trackingTag = bundle.getString("tracking");
            nstChannel = bundle.getString("nstChannel");
            if (nstChannel == null)
            {
                if (channel == null)
                {
                    bundle = "";
                } else
                {
                    bundle = channel.toString();
                }
                nstChannel = bundle;
            }
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (prefs.getBoolean("adminMenuEnabled", false))
        {
            ViewsPerSecondHelper.onCreateOptionsMenu(menu, menuinflater);
        }
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03002a, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDealCardClicked(int i, View view, Object obj)
    {
    }

    public void onDestroyView()
    {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return ViewsPerSecondHelper.onOptionsItemSelected((DialogManager)dialogManager.get(), this, menuitem) || super.onOptionsItemSelected(menuitem);
    }

    public void onPause()
    {
        if (swipeLayout != null)
        {
            swipeLayout.clearAnimation();
        }
        getBaseSyncManager().stopAutomaticSyncs();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (!getActivity().isFinishing() && syncAutomaticallyOnResume())
        {
            getBaseSyncManager().startAutomaticSyncs(this, null);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (swipeLayout != null)
        {
            swipeLayout.setRefreshing(false);
            setPullToRefreshEnabled(true);
        }
        super.onSaveInstanceState(bundle);
    }

    protected void reload()
    {
        if (getView() != null)
        {
            getListView().setSelectionAfterHeaderView();
        }
        getAppendingAdapter().enableAppending(true);
        getBaseSyncManager().requestSync(this, null);
    }

    protected void setPullToRefreshEnabled(boolean flag)
    {
        if (swipeLayout != null)
        {
            swipeLayout.setEnabled(flag);
        }
    }

    protected void setUpRefreshListener()
    {
        if (swipeLayout != null)
        {
            swipeLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

                final AbstractDealsAndWidgetsBaseFragment this$0;

                public void onRefresh()
                {
                    forceReload();
                }

            
            {
                this$0 = AbstractDealsAndWidgetsBaseFragment.this;
                super();
            }
            });
        }
    }

    protected boolean syncAutomaticallyOnResume()
    {
        return true;
    }
}
