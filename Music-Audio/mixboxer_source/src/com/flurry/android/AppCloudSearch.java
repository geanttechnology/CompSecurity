// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.flurry.android.responses.AppCloudEnumSearchResultCompletionHandler;
import com.flurry.android.responses.AppCloudSearchResultCompletionHandler;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.flurry.android:
//            gn, FlurryAppCloud, CacheSearchData, CacheSearchItemsData, 
//            AppCloudSearchPaginatingOrLimitPredicateCreator, ey, AppCloudSearchPredicateMatch, AppCloudSearchPredicateReturnOrder, 
//            AppCloudSearchPredicatePaginationOrLimit, eq

public class AppCloudSearch
{

    private CacheSearchItemsData bA;
    private CacheSearchData bz;
    private ExecutorService eD;
    private LinkedList gx;
    private AppCloudSearchPredicateReturnOrder gy;
    private AppCloudSearchPredicatePaginationOrLimit gz;
    private String mCollectionName;

    AppCloudSearch()
    {
        bz = null;
        bA = null;
        mCollectionName = null;
        gx = null;
        gy = null;
        gz = null;
        eD = null;
        bz = (CacheSearchData)FlurryAppCloud.a(gn.iL);
        bA = (CacheSearchItemsData)FlurryAppCloud.a(gn.iM);
        eD = Executors.newSingleThreadExecutor();
    }

    AppCloudSearch(String s)
    {
        bz = null;
        bA = null;
        mCollectionName = null;
        gx = null;
        gy = null;
        gz = null;
        eD = null;
        bz = (CacheSearchData)FlurryAppCloud.a(gn.iL);
        bA = (CacheSearchItemsData)FlurryAppCloud.a(gn.iM);
        eD = Executors.newSingleThreadExecutor();
        mCollectionName = s;
    }

    static String a(AppCloudSearch appcloudsearch)
    {
        return appcloudsearch.mCollectionName;
    }

    private void a(int i, int j, AppCloudEnumSearchResultCompletionHandler appcloudenumsearchresultcompletionhandler, boolean flag)
    {
        setPaginatingOrLimit(AppCloudSearchPaginatingOrLimitPredicateCreator.preginateResult(i, j));
        searchWithCompletionHandler(new ey(this, appcloudenumsearchresultcompletionhandler, j, i, flag));
    }

    static void a(AppCloudSearch appcloudsearch, int i, int j, AppCloudEnumSearchResultCompletionHandler appcloudenumsearchresultcompletionhandler)
    {
        appcloudsearch.a(i, j, appcloudenumsearchresultcompletionhandler, true);
    }

    static String b(AppCloudSearch appcloudsearch)
    {
        String s2 = "";
        if (appcloudsearch.gx != null)
        {
            String s = "";
            int i = 0;
            do
            {
                s2 = s;
                if (i >= appcloudsearch.gx.size())
                {
                    break;
                }
                s2 = ((AppCloudSearchPredicateMatch)appcloudsearch.gx.get(i)).e();
                String s3 = (new StringBuilder()).append("match").append(i + 1).append("=").toString();
                s = (new StringBuilder()).append(s).append("/").append(s3).append(s2).toString();
                i++;
            } while (true);
        }
        String s1 = "";
        if (appcloudsearch.gy != null)
        {
            s1 = appcloudsearch.gy.e();
        }
        String s4 = "";
        if (appcloudsearch.gz != null)
        {
            s4 = appcloudsearch.gz.e();
        }
        return (new StringBuilder()).append(s2).append(s1).append(s4).toString();
    }

    static CacheSearchData c(AppCloudSearch appcloudsearch)
    {
        return appcloudsearch.bz;
    }

    static CacheSearchItemsData d(AppCloudSearch appcloudsearch)
    {
        return appcloudsearch.bA;
    }

    public static void onMakeSearchNotValidForCollection(String s)
    {
        CacheSearchData cachesearchdata = (CacheSearchData)FlurryAppCloud.a(gn.iL);
        CacheSearchItemsData cachesearchitemsdata = (CacheSearchItemsData)FlurryAppCloud.a(gn.iM);
        if (cachesearchdata != null && cachesearchdata != null)
        {
            Object aobj[] = cachesearchdata.getIdsAssociatedWithCollectionName(s);
            cachesearchdata.removeByCollectionName(s);
            for (int i = 0; i < aobj.length; i++)
            {
                cachesearchitemsdata.removeItemsById((String)aobj[i]);
            }

        }
    }

    public static void toStringAndPrint()
    {
        Log.i("SearchCache", "============SEARCH REQUESTS==================");
        ((CacheSearchData)FlurryAppCloud.a(gn.iL)).readAll();
        Log.i("SearchCache", "============SEARCH ITEMS==================");
        ((CacheSearchItemsData)FlurryAppCloud.a(gn.iM)).readAll();
    }

    public void addPredicate(AppCloudSearchPredicateMatch appcloudsearchpredicatematch)
    {
        if (gx == null)
        {
            gx = new LinkedList();
        }
        gx.add(appcloudsearchpredicatematch);
    }

    public void searchWithCompletionHandler(AppCloudSearchResultCompletionHandler appcloudsearchresultcompletionhandler)
    {
        eD.execute(new eq(this, appcloudsearchresultcompletionhandler));
    }

    public void searchWithFetchBatchSize(int i, int j, AppCloudEnumSearchResultCompletionHandler appcloudenumsearchresultcompletionhandler)
    {
        a(i, j, appcloudenumsearchresultcompletionhandler, false);
    }

    public void setOrder(AppCloudSearchPredicateReturnOrder appcloudsearchpredicatereturnorder)
    {
        gy = appcloudsearchpredicatereturnorder;
    }

    public void setPaginatingOrLimit(AppCloudSearchPredicatePaginationOrLimit appcloudsearchpredicatepaginationorlimit)
    {
        gz = appcloudsearchpredicatepaginationorlimit;
    }
}
