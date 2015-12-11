// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.search;

import com.amazon.mShop.control.ObjectSubscriber;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.AdvSearchRequest;
import com.amazon.rio.j2me.client.services.mShop.AdvSearchResponseListener;
import com.amazon.rio.j2me.client.services.mShop.AdvSearchResults;
import com.amazon.rio.j2me.client.services.mShop.HyperText;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.SortOption;
import java.util.List;
import java.util.Vector;

public class AdvSearchResultsBrowser extends PagedListingBrowser
    implements AdvSearchResponseListener
{

    private AdvSearchRequest mAdvSearchRequest;
    private AdvSearchResults mAdvSearchResults;
    private List mBreadCrumbs;
    private ClickStreamTag mClickStreamTag;
    private List mCorrectedResultsTitle;
    private String mCorrection;
    private SortOption mCurrentSortOption;
    private String mFilters;
    private boolean mHasCorrectedResults;
    private List mMainResultsTitle;
    private int mMainTotalCount;
    private final int mPageSize;
    protected ObjectSubscriber mPrefetchSubscriber;
    private String mQuery;
    private List mRefinementBins;
    private String mRequestId;
    private boolean mReturnProducts;
    private ServiceCall mServiceCallForStubs;
    private boolean mShouldReturnCorrection;
    private List mSortOptions;
    private AdvSearchResponseListener mStubsResponseListener;
    private List mToggleRefinements;
    protected int mTotalCount;

    private boolean checkPrefetchable()
    {
        return primarySubscriber == null && secondarySubscriber == null && getPretchSubscriber() != null;
    }

    private ServiceCall doAdvSearch(int i, int j, String s, String s1, List list, Boolean boolean1, Boolean boolean2, 
            Boolean boolean3, Boolean boolean4, String s2, AdvSearchResponseListener advsearchresponselistener)
    {
        mAdvSearchRequest = new AdvSearchRequest();
        mAdvSearchRequest.setClickStreamOrigin(getClickStreamTag().getTag());
        mAdvSearchRequest.setSortId(s2);
        mAdvSearchRequest.setOffset(Integer.valueOf(i));
        mAdvSearchRequest.setCount(Integer.valueOf(j));
        mAdvSearchRequest.setQuery(s);
        mAdvSearchRequest.setFilters(s1);
        mAdvSearchRequest.setReturnStubs(boolean1);
        s1 = mAdvSearchRequest;
        boolean flag;
        if (list != null)
        {
            s = new Vector(list);
        } else
        {
            s = null;
        }
        s1.setToggleRefinements(s);
        mAdvSearchRequest.setReturnProducts(boolean2);
        mAdvSearchRequest.setReturnRefinements(boolean3);
        mAdvSearchRequest.setReturnCorrections(boolean4);
        mAdvSearchRequest.setIncludeAddOnItems(Boolean.TRUE);
        if (boolean1.booleanValue() && !boolean2.booleanValue() || checkPrefetchable())
        {
            mAdvSearchRequest.setIsPrefetch(Boolean.TRUE);
        }
        if (i == 0)
        {
            mRequestId = CustomClientFields.getAmazonRequestId();
        }
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        CustomClientFields.setCustomHeaderFields("adv_search_v34", flag, mRequestId);
        return ServiceController.getMShopService().advSearch(mAdvSearchRequest, advsearchresponselistener);
    }

    public static String validateQuery(String s)
    {
        if (s != null)
        {
            s = s.trim();
            if (!Util.isEmpty(s))
            {
                return s;
            }
        }
        return null;
    }

    public void cancelServiceCallForStubs()
    {
        if (mServiceCallForStubs != null)
        {
            mServiceCallForStubs.cancel();
            mServiceCallForStubs = null;
        }
    }

    public ClickStreamTag getClickStreamTag()
    {
        return mClickStreamTag;
    }

    public ObjectSubscriber getPretchSubscriber()
    {
        return mPrefetchSubscriber;
    }

    protected void onPrefetchCancelled()
    {
        if (getPretchSubscriber() != null)
        {
            getPretchSubscriber().onCancelled();
        }
    }

    protected void onPrefetchCountReceived(int i)
    {
        if (checkPrefetchable())
        {
            getPretchSubscriber().onAvailableCountReceived(i);
        }
    }

    protected void onPrefetchError(Exception exception, ServiceCall servicecall)
    {
        if (checkPrefetchable())
        {
            getPretchSubscriber().onError(exception, servicecall);
        }
    }

    protected void onPrefetchObjReceived(Object obj, int i)
    {
        if (checkPrefetchable())
        {
            getPretchSubscriber().onObjectReceived(obj, i);
        }
    }

    protected void onPrefetchObjsReceived()
    {
        if (checkPrefetchable())
        {
            getPretchSubscriber().onObjectsReceived();
        }
    }

    protected void onPrefetchSuccess()
    {
        if (checkPrefetchable())
        {
            getPretchSubscriber().onPageComplete();
        }
    }

    public void receivedAdvSearchResults(final AdvSearchResults value, int i, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final AdvSearchResultsBrowser this$0;
            final AdvSearchResults val$value;

            public void run()
            {
                mHasCorrectedResults = true;
                mCorrectedResultsTitle = value.getResultsDesc();
                mTotalCount = value.getTotalCount().intValue();
                if (!Util.isEmpty(value.getQuery()))
                {
                    mQuery = value.getQuery();
                }
                mFilters = value.getFilters();
            }

            
            {
                this$0 = AdvSearchResultsBrowser.this;
                value = advsearchresults;
                super();
            }
        });
        availableCountReceived(value.getAvailableCount().intValue(), servicecall);
        if (!Util.isEmpty(value.getResults()))
        {
            objectsReceived(value.getResults(), servicecall, false);
        }
    }

    public void receivedHyperText(final HyperText value, int i, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final AdvSearchResultsBrowser this$0;
            final HyperText val$value;

            public void run()
            {
                mCorrection = value.getText();
            }

            
            {
                this$0 = AdvSearchResultsBrowser.this;
                value = hypertext;
                super();
            }
        });
    }

    public void receivedMainResults(final AdvSearchResults value, final ServiceCall serviceCall)
    {
        availableCountReceived(value.getAvailableCount().intValue(), serviceCall);
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final AdvSearchResultsBrowser this$0;
            final ServiceCall val$serviceCall;
            final AdvSearchResults val$value;

            public void run()
            {
                if (serviceCall == getCurrentServiceCall())
                {
                    cancelServiceCallForStubs();
                    if (!mHasCorrectedResults)
                    {
                        mMainTotalCount = value.getTotalCount().intValue();
                    }
                    if (value.getResultsDesc() != null)
                    {
                        mMainResultsTitle = value.getResultsDesc();
                    }
                    mTotalCount = value.getTotalCount().intValue();
                    mAdvSearchResults = value;
                    if (!Util.isEmpty(value.getRefinements()))
                    {
                        mRefinementBins = value.getRefinements();
                        mFilters = value.getFilters();
                        mToggleRefinements = null;
                        mBreadCrumbs = value.getBreadcrumbs();
                    }
                    if (!Util.isEmpty(value.getSortOptions()))
                    {
                        mSortOptions = value.getSortOptions();
                        if (mCurrentSortOption == null && mSortOptions.size() > 1)
                        {
                            mCurrentSortOption = (SortOption)mSortOptions.get(0);
                        }
                    }
                }
            }

            
            {
                this$0 = AdvSearchResultsBrowser.this;
                serviceCall = servicecall;
                value = advsearchresults;
                super();
            }
        });
        if (!Util.isEmpty(value.getResults()))
        {
            objectsReceived(value.getResults(), serviceCall, false);
        }
    }

    public boolean startFirstPageRequest(int i, List list)
    {
        mTotalCount = 0x7fffffff;
        mHasCorrectedResults = false;
        return super.startFirstPageRequest(i, list);
    }

    protected ServiceCall startPageRequest(int i)
    {
        int j = getAvailableCount() - mPageSize * i;
        int l = mPageSize;
        List list;
        Object obj;
        String s;
        String s1;
        Object obj1;
        Boolean boolean1;
        Boolean boolean2;
        Boolean boolean3;
        int k;
        boolean flag;
        boolean flag1;
        if (j < mPageSize)
        {
            k = j;
        } else
        {
            k = mPageSize;
        }
        s = mQuery;
        s1 = mFilters;
        if (i == 0)
        {
            list = mToggleRefinements;
        } else
        {
            list = null;
        }
        obj1 = Boolean.TRUE;
        boolean1 = Boolean.FALSE;
        boolean2 = Boolean.FALSE;
        boolean3 = Boolean.FALSE;
        if (mCurrentSortOption != null)
        {
            obj = mCurrentSortOption.getSortId();
        } else
        {
            obj = null;
        }
        mServiceCallForStubs = doAdvSearch(i * l, k, s, s1, list, ((Boolean) (obj1)), boolean1, boolean2, boolean3, ((String) (obj)), mStubsResponseListener);
        k = mPageSize;
        if (j >= mPageSize)
        {
            j = mPageSize;
        }
        s1 = mQuery;
        obj1 = mFilters;
        if (i == 0)
        {
            list = mToggleRefinements;
        } else
        {
            list = null;
        }
        boolean1 = Boolean.FALSE;
        flag = mReturnProducts;
        if (i == 0)
        {
            obj = Boolean.TRUE;
        } else
        {
            obj = Boolean.FALSE;
        }
        flag1 = mShouldReturnCorrection;
        if (mCurrentSortOption != null)
        {
            s = mCurrentSortOption.getSortId();
        } else
        {
            s = null;
        }
        return doAdvSearch(i * k, j, s1, ((String) (obj1)), list, boolean1, Boolean.valueOf(flag), ((Boolean) (obj)), Boolean.valueOf(flag1), s, this);
    }



/*
    static boolean access$002(AdvSearchResultsBrowser advsearchresultsbrowser, boolean flag)
    {
        advsearchresultsbrowser.mHasCorrectedResults = flag;
        return flag;
    }

*/


/*
    static int access$102(AdvSearchResultsBrowser advsearchresultsbrowser, int i)
    {
        advsearchresultsbrowser.mMainTotalCount = i;
        return i;
    }

*/


/*
    static List access$1302(AdvSearchResultsBrowser advsearchresultsbrowser, List list)
    {
        advsearchresultsbrowser.mCorrectedResultsTitle = list;
        return list;
    }

*/


/*
    static String access$1402(AdvSearchResultsBrowser advsearchresultsbrowser, String s)
    {
        advsearchresultsbrowser.mQuery = s;
        return s;
    }

*/


/*
    static String access$1502(AdvSearchResultsBrowser advsearchresultsbrowser, String s)
    {
        advsearchresultsbrowser.mCorrection = s;
        return s;
    }

*/


/*
    static List access$202(AdvSearchResultsBrowser advsearchresultsbrowser, List list)
    {
        advsearchresultsbrowser.mMainResultsTitle = list;
        return list;
    }

*/


/*
    static AdvSearchResults access$302(AdvSearchResultsBrowser advsearchresultsbrowser, AdvSearchResults advsearchresults)
    {
        advsearchresultsbrowser.mAdvSearchResults = advsearchresults;
        return advsearchresults;
    }

*/


/*
    static List access$402(AdvSearchResultsBrowser advsearchresultsbrowser, List list)
    {
        advsearchresultsbrowser.mRefinementBins = list;
        return list;
    }

*/


/*
    static String access$502(AdvSearchResultsBrowser advsearchresultsbrowser, String s)
    {
        advsearchresultsbrowser.mFilters = s;
        return s;
    }

*/


/*
    static List access$602(AdvSearchResultsBrowser advsearchresultsbrowser, List list)
    {
        advsearchresultsbrowser.mToggleRefinements = list;
        return list;
    }

*/


/*
    static List access$702(AdvSearchResultsBrowser advsearchresultsbrowser, List list)
    {
        advsearchresultsbrowser.mBreadCrumbs = list;
        return list;
    }

*/



/*
    static List access$802(AdvSearchResultsBrowser advsearchresultsbrowser, List list)
    {
        advsearchresultsbrowser.mSortOptions = list;
        return list;
    }

*/



/*
    static SortOption access$902(AdvSearchResultsBrowser advsearchresultsbrowser, SortOption sortoption)
    {
        advsearchresultsbrowser.mCurrentSortOption = sortoption;
        return sortoption;
    }

*/
}
