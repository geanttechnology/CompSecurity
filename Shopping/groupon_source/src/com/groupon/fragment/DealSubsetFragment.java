// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.DealSubsetActivity;
import com.groupon.activity.IntentFactory;
import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.AbstractDeal;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Pagination;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.Endpoint;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.manager.UrlPathSyncManager;
import com.groupon.models.EndlessList;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.WidgetExtraInfo;
import com.groupon.service.core.AbTestService;
import com.groupon.view.dealcards.DealCardBase;
import com.groupon.view.dealcards.DefaultLargeDealCard;
import com.groupon.view.dealcards.DefaultSmallDealCard;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import commonlib.adapter.JavaListAdapter;
import commonlib.manager.PaginatedSyncManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            DealCardListFragment, DealCardListLoader, DealSummaryListLoaderCallbacks

public class DealSubsetFragment extends DealCardListFragment
{
    protected static class AllDealsFragmentDealSummaryListLoader extends DealCardListLoader
    {

        private List getCachedDealSummaries()
            throws SQLException
        {
            long l = System.currentTimeMillis();
            QueryBuilder querybuilder = dealSummaryDao.queryBuilder();
            Where where = querybuilder.where();
            where.eq("channel", pagerChannelAndSubchannel).and().gt("modificationDate", new Date(l - 0xdbba0L));
            querybuilder.setWhere(where);
            return dealSummaryDao.query(querybuilder.prepare());
        }

        public volatile Object loadInBackground()
        {
            return loadInBackground();
        }

        public List loadInBackground()
        {
            Object obj;
            Pagination pagination;
            DealSubsetAttribute dealsubsetattribute;
            int i;
            int j;
            boolean flag;
            boolean flag1;
            try
            {
                obj = getCachedDealSummaries();
                pagination = (Pagination)paginationDao.queryForFirstEq("channel", pagerChannelAndSubchannel);
                dealsubsetattribute = (DealSubsetAttribute)dealSubsetAttributeDao.queryForFirstEq("channel", pagerChannelAndSubchannel);
            }
            catch (SQLException sqlexception)
            {
                throw new RuntimeException(sqlexception);
            }
            flag = false;
            flag1 = false;
            j = ((flag1) ? 1 : 0);
            i = ((flag) ? 1 : 0);
            if (pagination == null)
            {
                break MISSING_BLOCK_LABEL_84;
            }
            j = ((flag1) ? 1 : 0);
            i = ((flag) ? 1 : 0);
            if (pagination.hasMorePages())
            {
                i = pagination.getCount();
                j = pagination.getCurrentOffset();
            }
            obj = new EndlessList(((List) (obj)), i, j, dealsubsetattribute);
            return ((List) (obj));
        }

        public AllDealsFragmentDealSummaryListLoader(Class class1, Class class2, Context context, String s)
        {
            super(class1, class2, context, s);
        }
    }

    public class AllDealsFragmentDealSummaryListLoaderCallback extends DealSummaryListLoaderCallbacks
    {

        final DealSubsetFragment this$0;

        public Loader onCreateLoader(int i, Bundle bundle)
        {
            return new AllDealsFragmentDealSummaryListLoader(com/groupon/db/models/DealSummary, com/groupon/db/events/ChannelUpdateEvent, getActivity(), pagerChannelAndSubchannel);
        }

        public volatile void onLoadFinished(Loader loader, Object obj)
        {
            onLoadFinished(loader, (List)obj);
        }

        public void onLoadFinished(Loader loader, List list)
        {
            if (dataState == DealSubsetFragment.DATA_STATE_UNLOADED && list.size() == 0)
            {
                dataState = DealSubsetFragment.DATA_STATE_CACHE_CHECKED_ON_INITIALIZATION;
                reload();
            } else
            {
                dataState = DealSubsetFragment.DATA_STATE_FIRST_LOAD_COMPLETED;
            }
            super.onLoadFinished(loader, list);
        }

        public AllDealsFragmentDealSummaryListLoaderCallback(JavaListAdapter javalistadapter)
        {
            this$0 = DealSubsetFragment.this;
            super(javalistadapter, DealSubsetFragment.this);
        }
    }


    private static int DATA_STATE_CACHE_CHECKED_ON_INITIALIZATION = 0;
    private static int DATA_STATE_FIRST_LOAD_COMPLETED = 0;
    private static int DATA_STATE_TERMINATING_BECAUSE_USER_CANCELLED_BEFORE_FIRST_LOAD_COMPLETED = 0;
    private static int DATA_STATE_UNLOADED = 0;
    private static final int DEALS_EXPIRED_IN_MS = 0xdbba0;
    private int dataState;
    private DeepLinkUtil deepLinkUtil;
    private boolean isSmallDealCardsOnSearch1508;
    private String partialDealSubsetUrl;
    private String subsetId;
    private UrlPathSyncManager syncManager;

    public DealSubsetFragment()
    {
        super(Channel.ALLDEALS);
        dataState = DATA_STATE_UNLOADED;
    }

    public void configureSyncManager()
    {
        DealSubsetActivity dealsubsetactivity;
        boolean flag;
        boolean flag1;
        Bundle bundle = getArguments();
        partialDealSubsetUrl = bundle.getString("partial_deal_subset_url");
        subsetId = bundle.getString("subset_id");
        dealsubsetactivity = (DealSubsetActivity)getActivity();
        flag1 = false;
        flag = flag1;
        if (!deepLinkUtil.isDeepLink(partialDealSubsetUrl))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        boolean flag2 = deepLinkUtil.getDeepLink(partialDealSubsetUrl).getEndpoint().equals(Endpoint.SEARCH_RESULTS);
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
_L2:
        String s;
        if (flag)
        {
            s = Strings.md5(partialDealSubsetUrl);
        } else
        {
            s = subsetId;
        }
        pagerChannelAndSubchannel = Channel.encodePath(new String[] {
            Channel.ALLDEALS.name(), s
        });
        syncManager.configure(partialDealSubsetUrl, pagerChannelAndSubchannel, getOriginatingNstChannel(), dealsubsetactivity.getWidgetRequestId(), dealsubsetactivity.getWidgetScenarioId(), dealsubsetactivity.getWidgetTreatment());
        pagerChannel = Channel.ALLDEALS;
        return;
        InvalidDeepLinkException invaliddeeplinkexception;
        invaliddeeplinkexception;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Intent getDealCardClickedIntent(DealSummary dealsummary, com.groupon.util.ViewUtils.Size size)
    {
        return ((IntentFactory)intentFactory.get()).newDealIntent(dealsummary, Channel.safeValueOf(getOriginatingNstChannel()), size);
    }

    protected View getDealCardView(View view, DealSummary dealsummary, List list)
    {
        if ((view instanceof DefaultLargeDealCard) || (view instanceof DefaultSmallDealCard))
        {
            if (isSmallDealCardsOnSearch1508)
            {
                view = (DefaultSmallDealCard)view;
            } else
            {
                view = (DefaultLargeDealCard)view;
            }
        } else
        if (isSmallDealCardsOnSearch1508)
        {
            view = new DefaultSmallDealCard(activity);
        } else
        {
            view = new DefaultLargeDealCard(activity);
        }
        view.setInfoWithPlaces(dealsummary, list);
        return view;
    }

    protected JsonEncodedNSTField getDealImpressionExtraInfo(AbstractDeal abstractdeal)
    {
        abstractdeal = (DealSubsetActivity)getActivity();
        if (abstractdeal != null)
        {
            return new WidgetExtraInfo(abstractdeal.getWidgetRequestId(), abstractdeal.getWidgetTreatment(), abstractdeal.getWidgetCampaign());
        } else
        {
            return JsonEncodedNSTField.NULL_JSON_NST_FIELD;
        }
    }

    public String getOriginatingNstChannel()
    {
        Object obj = (DealSubsetActivity)getActivity();
        Channel channel;
        if (obj != null)
        {
            obj = ((DealSubsetActivity) (obj)).getOriginatingChannel();
        } else
        {
            obj = Channel.UNKNOWN;
        }
        channel = ((Channel) (obj));
        if (obj == Channel.UNKNOWN)
        {
            channel = Channel.DEAL_SUBSET_SEARCH;
        }
        return channel.toString();
    }

    public volatile AnyChannelSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public UrlPathSyncManager getSyncManager()
    {
        return syncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public void handleSyncErrorCancellation(Runnable runnable, Exception exception)
    {
        super.handleSyncErrorCancellation(runnable, exception);
        if (dataState != DATA_STATE_FIRST_LOAD_COMPLETED)
        {
            dataState = DATA_STATE_TERMINATING_BECAUSE_USER_CANCELLED_BEFORE_FIRST_LOAD_COMPLETED;
            runnable = getActivity();
            if (runnable != null)
            {
                runnable.finish();
            }
        }
    }

    public void initLoader(JavaListAdapter javalistadapter)
    {
        getLoaderManager().initLoader(0, null, new AllDealsFragmentDealSummaryListLoaderCallback(javalistadapter));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        isSmallDealCardsOnSearch1508 = abTestService.isVariantEnabled("smallDealCardsOnSearch1508", "on");
    }

    protected boolean requiresRedirectLogging()
    {
        return false;
    }

    protected boolean syncAutomaticallyOnResume()
    {
        return false;
    }

    static 
    {
        DATA_STATE_UNLOADED = 0;
        DATA_STATE_CACHE_CHECKED_ON_INITIALIZATION = 1;
        DATA_STATE_FIRST_LOAD_COMPLETED = 2;
        DATA_STATE_TERMINATING_BECAUSE_USER_CANCELLED_BEFORE_FIRST_LOAD_COMPLETED = 3;
    }



/*
    static int access$002(DealSubsetFragment dealsubsetfragment, int i)
    {
        dealsubsetfragment.dataState = i;
        return i;
    }

*/



}
