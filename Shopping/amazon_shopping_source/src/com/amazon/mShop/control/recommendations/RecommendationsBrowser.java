// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.recommendations;

import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.search.QueryProvider;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CategoryResult;
import com.amazon.rio.j2me.client.services.mShop.GetRecommendedItemsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.RecommendedItemsRequest;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.control.recommendations:
//            RecommendationsSubscriber

public class RecommendationsBrowser extends PagedListingBrowser
    implements GetRecommendedItemsResponseListener
{

    private Set mRatingPendingIndexSet;
    private RecommendationsSubscriber mRecSubscriber;
    private final List mRefinements = new ArrayList();
    private final RecommendedItemsRequest mRequest = new RecommendedItemsRequest();
    private String mRequestId;
    protected int mTotalCount;

    public RecommendationsBrowser(int i, int j, int k, QueryProvider queryprovider, String s)
    {
        super(i, j);
        mTotalCount = 0x7fffffff;
        mRequest.setCount(pageSize);
        mRequest.setMaxImageDimension(k);
        mRequest.setCategory(s);
        mRatingPendingIndexSet = new HashSet();
    }

    public void addRatingPendingIndex(int i)
    {
        mRatingPendingIndexSet.add(Integer.valueOf(i));
    }

    protected int adjustRequestTriggerIndex(int i)
    {
        int j = i;
        if (getRatingPendingIndexSet().size() > 0)
        {
            j = i + getRatingPendingIndexSet().size();
        }
        return j;
    }

    public int amountHasDelted(int i)
    {
        int j = 0;
        Iterator iterator = mRatingPendingIndexSet.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (i > ((Integer)iterator.next()).intValue())
            {
                j++;
            }
        } while (true);
        return j;
    }

    public void clearAllList()
    {
        listingObjects.clear();
        listingImages.clear();
        listingIndices.clear();
    }

    public void clearRatingPendingIndexSet()
    {
        mRatingPendingIndexSet.clear();
    }

    public Set getRatingPendingIndexSet()
    {
        return mRatingPendingIndexSet;
    }

    public RecommendationsSubscriber getRecSubscriber()
    {
        return mRecSubscriber;
    }

    public List getRefinements()
    {
        List list = mRefinements;
        list;
        JVM INSTR monitorenter ;
        int i = mRefinements.size();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        list;
        JVM INSTR monitorexit ;
        return null;
        ArrayList arraylist;
        arraylist = new ArrayList(i);
        arraylist.addAll(mRefinements);
        list;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean hasCategoryResult()
    {
        return mRequest.getCategory() != null;
    }

    public boolean hasDeletedAt(int i)
    {
        return mRatingPendingIndexSet.contains(Integer.valueOf(i));
    }

    protected void imageReceived(final byte image[], final int intraPageIndex, final ServiceCall serviceCall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() );
    }

    protected void objectReceived(final SearchResult o, final int intraPageIndex, final ServiceCall serviceCall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() );
    }

    protected volatile void objectReceived(Object obj, int i, ServiceCall servicecall)
    {
        objectReceived((SearchResult)obj, i, servicecall);
    }

    public void receivedAvailableCount(Integer integer, ServiceCall servicecall)
    {
        availableCountReceived(Math.min(100, integer.intValue()), servicecall);
    }

    public void receivedCategoryResult(CategoryResult categoryresult, int i, ServiceCall servicecall)
    {
        mRefinements.add(categoryresult);
    }

    public void receivedImage(byte abyte0[], int i, ServiceCall servicecall)
    {
        imageReceived(abyte0, i, servicecall);
    }

    public void receivedNoRecommendationsExplanation(final String value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final RecommendationsBrowser this$0;
            final String val$value;

            public void run()
            {
                getRecSubscriber().onReceivedNoRecommendationsExplanation(value);
            }

            
            {
                this$0 = RecommendationsBrowser.this;
                value = s;
                super();
            }
        });
    }

    public void receivedSearchResult(SearchResult searchresult, int i, ServiceCall servicecall)
    {
        objectReceived(searchresult, i, servicecall);
    }

    public boolean refine(CategoryResult categoryresult)
    {
        RecommendedItemsRequest recommendeditemsrequest = mRequest;
        if (categoryresult != null)
        {
            categoryresult = categoryresult.getCategory();
        } else
        {
            categoryresult = null;
        }
        recommendeditemsrequest.setCategory(categoryresult);
        mRefinements.clear();
        return startFirstPageRequest(0x7fffffff, null);
    }

    public Object removeItemAt(int i)
    {
        Object obj = null;
        if (i < listingObjects.size())
        {
            obj = listingObjects.remove(i);
        }
        if (i < listingImages.size())
        {
            listingImages.remove(i);
        }
        return obj;
    }

    public int removeItemIndexAt(int i)
    {
        return ((Integer)listingIndices.remove(i)).intValue();
    }

    public void setRecSubscriber(RecommendationsSubscriber recommendationssubscriber)
    {
        mRecSubscriber = recommendationssubscriber;
    }

    public boolean startFirstPageRequest(int i, List list)
    {
        mTotalCount = 0x7fffffff;
        mRefinements.clear();
        mRequestId = CustomClientFields.getAmazonRequestId();
        return startFirstPageRequest(i, null);
    }

    protected ServiceCall startPageRequest(int i)
    {
        mRequest.setStartOffset(pageSize * i);
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        CustomClientFields.setCustomHeaderFields("get_recommended_items_v32", flag, mRequestId);
        return ServiceController.getMShopService().getRecommendedItems(mRequest, this);
    }









}
