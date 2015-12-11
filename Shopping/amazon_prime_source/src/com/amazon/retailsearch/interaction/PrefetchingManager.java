// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            SearchDataSource

public class PrefetchingManager
{
    class PrefetchingHandler extends Handler
    {

        final PrefetchingManager this$0;

        public void handleMessage(Message message)
        {
            if ((message.what == 1 || message.what == 2) && (message.obj instanceof RetailSearchQuery))
            {
                searchDataSource.prefetchQuery((RetailSearchQuery)message.obj);
            }
        }

        public PrefetchingHandler(Looper looper)
        {
            this$0 = PrefetchingManager.this;
            super(looper);
        }
    }


    private static final int MESSAGE_ISS_PREFETCHING = 1;
    private static final int MESSAGE_SEARCH_BOX_PREFETCHING = 2;
    private int currentBudget;
    FeatureConfiguration featureConfig;
    private PrefetchingHandler handler;
    private Resources resources;
    SearchDataSource searchDataSource;

    public PrefetchingManager(Context context)
    {
        currentBudget = 0;
        RetailSearchDaggerGraphController.inject(this);
        resources = context.getResources();
        handler = new PrefetchingHandler(context.getMainLooper());
    }

    private int getIssPrefetchingCount()
    {
        String s;
        if (isPrefetchingEnabled())
        {
            if (!"C".equals(s = FeatureStateUtil.getISSPrefetchingWeblab(featureConfig)))
            {
                switch (getTreatmentNumber(s))
                {
                default:
                    return 0;

                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                    return 1;

                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                    return 2;

                case 7: // '\007'
                case 8: // '\b'
                case 9: // '\t'
                    return 3;
                }
            }
        }
        return 0;
    }

    private int getIssPrefetchingDelay()
    {
        String s;
        if (isPrefetchingEnabled())
        {
            if (!"C".equals(s = FeatureStateUtil.getISSPrefetchingWeblab(featureConfig)))
            {
                switch (getTreatmentNumber(s))
                {
                default:
                    return 0;

                case 1: // '\001'
                case 4: // '\004'
                case 7: // '\007'
                    return 500;

                case 2: // '\002'
                case 5: // '\005'
                case 8: // '\b'
                    return 750;

                case 3: // '\003'
                case 6: // '\006'
                case 9: // '\t'
                    return 1000;
                }
            }
        }
        return 0;
    }

    private int getPrefetchingBudget()
    {
        return getTreatmentNumber(FeatureStateUtil.getPrefetchingBudgetWeblab(featureConfig));
    }

    private int getSearchBoxPrefetchingDelay()
    {
        String s = FeatureStateUtil.getSearchBoxPrefetchingWeblab(featureConfig);
        if ("C".equals(s))
        {
            return 0;
        } else
        {
            return (getTreatmentNumber(s) - 1) * 250 + 500;
        }
    }

    private int getTreatmentNumber(String s)
    {
        if (TextUtils.isEmpty(s) || "C".equals(s) || s.length() < 2)
        {
            return 0;
        }
        int i;
        try
        {
            i = Integer.parseInt(s.substring(1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }

    private boolean isQueryBuilderPrefetchingEnabled()
    {
        return isPrefetchingEnabled() && !"C".equals(FeatureStateUtil.getQueryBuilderPrefetchingWeblab(featureConfig));
    }

    public void cancelPreviousISSPrefetchingRequests()
    {
        handler.removeMessages(1);
    }

    public void cancelPreviousSearchBoxPrefetchingRequests()
    {
        handler.removeMessages(2);
    }

    public boolean isOutOfBudget()
    {
        int i = searchDataSource.getPrefetchingCounter();
        int j = getPrefetchingBudget();
        if (j != currentBudget)
        {
            searchDataSource.resetCache(j);
            currentBudget = j;
        }
        return j > 0 && j <= i;
    }

    public boolean isPrefetchingEnabled()
    {
        while (resources == null || !resources.getBoolean(com.amazon.retailsearch.R.bool.config_rs_prefetching_enabled) || "C".equals(FeatureStateUtil.getPrefetchingMasterWeblab(featureConfig))) 
        {
            return false;
        }
        return true;
    }

    public void prefetchForISS(RetailSearchQuery retailsearchquery, int i)
    {
        if (isPrefetchingEnabled() && retailsearchquery != null && !TextUtils.isEmpty(retailsearchquery.getKeywords()) && !isOutOfBudget())
        {
            int j = getIssPrefetchingCount();
            int k = getIssPrefetchingDelay();
            if (j > 0 && k > 0 && i < j)
            {
                handler.sendMessageDelayed(handler.obtainMessage(1, retailsearchquery), k);
                return;
            }
        }
    }

    public void prefetchForQueryBuilder(RetailSearchQuery retailsearchquery)
    {
        if (!isQueryBuilderPrefetchingEnabled() || retailsearchquery == null || TextUtils.isEmpty(retailsearchquery.getKeywords()) || isOutOfBudget())
        {
            return;
        } else
        {
            searchDataSource.prefetchQuery(retailsearchquery);
            return;
        }
    }

    public void prefetchForSearchBox(RetailSearchQuery retailsearchquery)
    {
        if (!isPrefetchingEnabled() || retailsearchquery == null || TextUtils.isEmpty(retailsearchquery.getKeywords()) || isOutOfBudget())
        {
            return;
        } else
        {
            int i = getSearchBoxPrefetchingDelay();
            handler.sendMessageDelayed(handler.obtainMessage(2, retailsearchquery), i);
            return;
        }
    }
}
