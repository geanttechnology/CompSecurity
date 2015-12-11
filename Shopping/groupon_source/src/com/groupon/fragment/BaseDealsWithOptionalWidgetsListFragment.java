// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.DealSummary;
import com.groupon.models.EndlessList;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import commonlib.adapter.JavaListAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            DealCardListFragment, DataTransformer, DealCardListLoader, DealSummaryListLoaderCallbacks

public abstract class BaseDealsWithOptionalWidgetsListFragment extends DealCardListFragment
{
    protected static class WidgetAndDealList extends EndlessList
    {

        private List smuggledDeals;
        private List widgetsList;



        public WidgetAndDealList(EndlessList endlesslist, List list, List list1)
        {
            super(endlesslist, endlesslist.getTotalSize(), endlesslist.getCurrentOffset(), endlesslist.getAttr());
            widgetsList = list;
            smuggledDeals = list1;
        }
    }

    protected static class WidgetAndDealSummaryListLoader extends DealCardListLoader
    {

        private DataTransformer dataTransformer;
        private String pagerChannel;
        private DaoWidgetSummary widgetDao;
        private boolean widgetsSupported;

        public volatile Object loadInBackground()
        {
            return loadInBackground();
        }

        public List loadInBackground()
        {
            Object obj;
            EndlessList endlesslist;
            Object obj1;
            try
            {
                endlesslist = (EndlessList)super.loadInBackground();
            }
            catch (SQLException sqlexception)
            {
                throw new RuntimeException(sqlexception);
            }
            if (endlesslist == null)
            {
                break MISSING_BLOCK_LABEL_130;
            }
            if (widgetsSupported && endlesslist.size() > 0)
            {
                obj = widgetDao.queryBuilder();
                obj1 = pagerChannel;
                ((QueryBuilder) (obj)).where().between("channel", obj1, (new StringBuilder()).append(((String) (obj1))).append("~").toString());
                obj = ((QueryBuilder) (obj)).prepare();
                obj = widgetDao.query(((com.j256.ormlite.stmt.PreparedQuery) (obj)));
            } else
            {
                obj = new ArrayList();
            }
            obj1 = new ArrayList();
            if (dataTransformer != null)
            {
                dataTransformer.transform(endlesslist, ((List) (obj)), ((List) (obj1)));
            }
            return new WidgetAndDealList(endlesslist, ((List) (obj)), ((List) (obj1)));
            return null;
        }

        public WidgetAndDealSummaryListLoader(Class class1, Class class2, Context context, String s, String s1, boolean flag, DataTransformer datatransformer)
        {
            super(class1, class2, context, s);
            widgetsSupported = flag;
            pagerChannel = s1;
            dataTransformer = datatransformer;
        }
    }

    protected class WidgetAndDealSummaryListLoaderCallbacks extends DealSummaryListLoaderCallbacks
    {

        private DataTransformer dataTransformer;
        final BaseDealsWithOptionalWidgetsListFragment this$0;

        public Loader onCreateLoader(int i, Bundle bundle)
        {
            bundle = new WidgetAndDealSummaryListLoader(com/groupon/db/models/DealSummary, com/groupon/db/events/ChannelUpdateEvent, getActivity(), pagerChannelAndSubchannel, pagerChannel.name(), widgetsSupported, dataTransformer);
            bundle.setForceDownload(isForceDownload);
            return bundle;
        }

        public volatile void onLoadFinished(Loader loader, Object obj)
        {
            onLoadFinished(loader, (List)obj);
        }

        public void onLoadFinished(Loader loader, List list)
        {
            WidgetAndDealList widgetanddeallist = (WidgetAndDealList)list;
            if (widgetListAdapter == null || list == null) goto _L2; else goto _L1
_L1:
            Object obj;
            widgetListAdapter.setSmuggledDeals(widgetanddeallist.smuggledDeals);
            widgetListAdapter.setList(widgetanddeallist.widgetsList, false);
            obj = list;
_L4:
            super.onLoadFinished(loader, ((List) (obj)));
            return;
_L2:
            obj = list;
            if (list != null)
            {
                obj = list;
                if (widgetanddeallist.smuggledDeals.size() > 0)
                {
                    list = (EndlessList)widgetanddeallist.getDelegate();
                    obj = new EndlessList(new ArrayList(), list.getTotalSize(), list.getCurrentOffset(), list.getAttr());
                    ((EndlessList) (obj)).addAll(widgetanddeallist.smuggledDeals);
                    ((EndlessList) (obj)).addAll(list);
                    obj = new WidgetAndDealList(((EndlessList) (obj)), new ArrayList(), new ArrayList());
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public WidgetAndDealSummaryListLoaderCallbacks(JavaListAdapter javalistadapter, BaseDealsWithOptionalWidgetsListFragment basedealswithoptionalwidgetslistfragment1, DataTransformer datatransformer)
        {
            this$0 = BaseDealsWithOptionalWidgetsListFragment.this;
            super(javalistadapter, basedealswithoptionalwidgetslistfragment1);
            dataTransformer = datatransformer;
        }
    }


    protected FilterableWidgetListAdapter widgetListAdapter;
    protected boolean widgetsSupported;
    protected boolean widgetsSupportedINTL;
    protected boolean widgetsSupportedUSA;

    public BaseDealsWithOptionalWidgetsListFragment(Channel channel)
    {
        super(channel);
    }

    public DataTransformer getDataTransformer()
    {
        return null;
    }

    public void initLoader(JavaListAdapter javalistadapter)
    {
        DataTransformer datatransformer = getDataTransformer();
        getLoaderManager().initLoader(0, null, new WidgetAndDealSummaryListLoaderCallbacks(javalistadapter, this, datatransformer));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }
}
