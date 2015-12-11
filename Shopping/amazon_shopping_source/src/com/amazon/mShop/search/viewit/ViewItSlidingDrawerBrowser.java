// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.mShop.control.ObjectSubscriber;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsRequest;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItDBHelper, ViewItSearchResultWrapper, ViewItDBResultWrapper, ViewItActivity, 
//            ViewItPhotoCaptureView, ViewItSlidingDrawerView

public class ViewItSlidingDrawerBrowser extends PagedListingBrowser
    implements BasicProductsResponseListener
{

    private ViewItActivity mActivity;
    private List mAllHistoryDBObjects;
    private ViewItAllMatchedResultsView.ViewItAllMatchesAdapter mAllMatchesAdapter;
    private List mCurrentRequestDBObjects;
    private ViewItDBHelper mDBHelper;
    protected int mHistoryObjectsDeletedCount;
    private int mNextPageStartIndex;
    private ViewItSearchResultWrapper mObjectToDelete;
    private List mRecentlyScannedObjects;
    private String mRequestId;
    private ViewItSlidingDrawerView.ViewItSlidingDrawerItemAdapter mSlidingDrawerAdapter;

    public ViewItSlidingDrawerBrowser(ViewItActivity viewitactivity, int i, int j)
    {
        super(i, j);
        mNextPageStartIndex = 0;
        mHistoryObjectsDeletedCount = 0;
        mActivity = viewitactivity;
        mCurrentRequestDBObjects = new ArrayList();
        mRecentlyScannedObjects = new Vector();
        mDBHelper = new ViewItDBHelper(mActivity);
    }

    private boolean deleteEntireGroup(ViewItSearchResultWrapper viewitsearchresultwrapper)
    {
        if (viewitsearchresultwrapper.isRecentlyScanned())
        {
            if (!Util.isEmpty(mRecentlyScannedObjects))
            {
                int k = mRecentlyScannedObjects.size();
                for (int i = 0; i < k; i++)
                {
                    if (((ViewItSearchResultWrapper)mRecentlyScannedObjects.get(i)).getOriginalScannedOutput().equals(viewitsearchresultwrapper.getOriginalScannedOutput()))
                    {
                        mRecentlyScannedObjects.remove(i);
                        mDBHelper.delete(viewitsearchresultwrapper);
                        return true;
                    }
                }

            }
        } else
        if (!Util.isEmpty(listingObjects))
        {
            int l = listingObjects.size();
            for (int j = 0; j < l; j++)
            {
                if (((ViewItSearchResultWrapper)listingObjects.get(j)).getOriginalScannedOutput().equals(viewitsearchresultwrapper.getOriginalScannedOutput()))
                {
                    listingObjects.remove(j);
                    mDBHelper.delete(viewitsearchresultwrapper);
                    mHistoryObjectsDeletedCount = mHistoryObjectsDeletedCount + 1;
                    return true;
                }
            }

        }
        return false;
    }

    private boolean deleteItemOfGroup(ViewItSearchResultWrapper viewitsearchresultwrapper)
    {
        List list = viewitsearchresultwrapper.getSearchResults();
        if (!Util.isEmpty(viewitsearchresultwrapper.getDeletedAsin()) && !Util.isEmpty(list))
        {
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                SearchResult searchresult = (SearchResult)list.get(i);
                if (viewitsearchresultwrapper.getDeletedAsin().equals(searchresult.getBasicProduct().getAsin()))
                {
                    list.remove(i);
                    viewitsearchresultwrapper.setDeletedAsin(null);
                    mDBHelper.update(viewitsearchresultwrapper);
                    return true;
                }
            }

        }
        return false;
    }

    private boolean deleteObject(ViewItSearchResultWrapper viewitsearchresultwrapper)
    {
        String s = viewitsearchresultwrapper.getDeletedAsin();
        if (!Util.isEmpty(s))
        {
            if (s.equals("delete_all_asin"))
            {
                return deleteEntireGroup(viewitsearchresultwrapper);
            }
            if (viewitsearchresultwrapper.getSearchResults().size() == 1)
            {
                if (s.equals(((SearchResult)viewitsearchresultwrapper.getSearchResults().get(0)).getBasicProduct().getAsin()))
                {
                    return deleteEntireGroup(viewitsearchresultwrapper);
                }
            } else
            {
                return deleteItemOfGroup(viewitsearchresultwrapper);
            }
        }
        return false;
    }

    private void notifyDataSetChanged()
    {
        if (mSlidingDrawerAdapter != null)
        {
            mSlidingDrawerAdapter.notifyDataSetChanged();
        }
        if (mAllMatchesAdapter != null)
        {
            mAllMatchesAdapter.notifyDataSetChanged();
        }
    }

    public void addNewSannedObejct(ViewItSearchResultWrapper viewitsearchresultwrapper)
    {
        mRecentlyScannedObjects.add(0, viewitsearchresultwrapper);
        mDBHelper.insert(viewitsearchresultwrapper);
    }

    protected int adjustRequestTriggerIndex(int i)
    {
        return mHistoryObjectsDeletedCount + i;
    }

    public void cancelled(ServiceCall servicecall)
    {
        super.cancelled(servicecall);
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItSlidingDrawerBrowser this$0;

            public void run()
            {
                mCurrentRequestDBObjects.clear();
            }

            
            {
                this$0 = ViewItSlidingDrawerBrowser.this;
                super();
            }
        });
    }

    public void clear()
    {
        mObjectToDelete = null;
        mCurrentRequestDBObjects.clear();
        listingObjects.clear();
        mRecentlyScannedObjects.clear();
        mHistoryObjectsDeletedCount = 0;
        if (mAllHistoryDBObjects != null)
        {
            mAllHistoryDBObjects.clear();
        }
    }

    public void completed(final BasicProductsResponse response, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItSlidingDrawerBrowser this$0;
            final BasicProductsResponse val$response;
            final ServiceCall val$sc;

            public void run()
            {
                ArrayList arraylist;
                List list;
                Iterator iterator;
                int l;
                arraylist = new ArrayList();
                list = response.getProducts();
                l = list.size();
                iterator = mCurrentRequestDBObjects.iterator();
_L2:
                ViewItDBResultWrapper viewitdbresultwrapper;
                Vector vector;
                if (!iterator.hasNext())
                {
                    break; /* Loop/switch isn't completed */
                }
                viewitdbresultwrapper = (ViewItDBResultWrapper)iterator.next();
                vector = new Vector();
                List list1 = viewitdbresultwrapper.getAsinList();
                int i;
                int j;
                if (Util.isEmpty(list1))
                {
                    i = 0;
                } else
                {
                    i = list1.size();
                }
                j = 0;
                do
                {
label0:
                    {
                        if (j >= i)
                        {
                            break label0;
                        }
                        String s = (String)list1.get(j);
                        int k = 0;
                        do
                        {
label1:
                            {
                                if (k < l)
                                {
                                    SearchResult searchresult = (SearchResult)list.get(k);
                                    if (!s.equals(searchresult.getBasicProduct().getAsin()))
                                    {
                                        break label1;
                                    }
                                    vector.add(searchresult);
                                }
                                j++;
                            }
                            if (true)
                            {
                                break;
                            }
                            k++;
                        } while (true);
                    }
                } while (true);
                if (!Util.isEmpty(vector))
                {
                    arraylist.add(new ViewItSearchResultWrapper(viewitdbresultwrapper.getOriginalScannedOutput(), vector, null, viewitdbresultwrapper.getScannedDate(), false));
                }
                if (true) goto _L2; else goto _L1
_L1:
                objectsReceived(arraylist, sc);
                mCurrentRequestDBObjects.clear();
                return;
            }

            
            {
                this$0 = ViewItSlidingDrawerBrowser.this;
                response = basicproductsresponse;
                sc = servicecall;
                super();
            }
        });
    }

    public void deleteAllObjects()
    {
        cancel();
        clear();
        mDBHelper.deleteAllObjectsFromDB();
    }

    public void deleteUndoObject()
    {
        if (mObjectToDelete != null)
        {
            deleteObject(mObjectToDelete);
            mObjectToDelete = null;
            notifyDataSetChanged();
        }
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        super.error(exception, servicecall);
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() );
    }

    public List getAllHistoryDBObjects()
    {
        return mAllHistoryDBObjects;
    }

    public List getCurrentRequestDBObjects()
    {
        return mCurrentRequestDBObjects;
    }

    public List getHistoryListingObjects()
    {
        return listingObjects;
    }

    public int getNextPageStartIndex()
    {
        return mNextPageStartIndex;
    }

    public ViewItSearchResultWrapper getObjectAtIndex(int i)
    {
        if (i >= 0 && i < listingObjects.size() + mRecentlyScannedObjects.size())
        {
            if (i < mRecentlyScannedObjects.size())
            {
                return (ViewItSearchResultWrapper)mRecentlyScannedObjects.get(i);
            } else
            {
                return (ViewItSearchResultWrapper)listingObjects.get(i - mRecentlyScannedObjects.size());
            }
        } else
        {
            return null;
        }
    }

    public volatile Object getObjectAtIndex(int i)
    {
        return getObjectAtIndex(i);
    }

    public ViewItSearchResultWrapper getObjectToDelete()
    {
        return mObjectToDelete;
    }

    public int getObjectsCount()
    {
        return mRecentlyScannedObjects.size() + listingObjects.size();
    }

    public List getRecentlyScannedObjects()
    {
        return mRecentlyScannedObjects;
    }

    public ViewItDBHelper getViewItDBHelper()
    {
        return mDBHelper;
    }

    public boolean isObjectToDelete(ViewItSearchResultWrapper viewitsearchresultwrapper, SearchResult searchresult, ViewItItemView.ItemShowType itemshowtype)
    {
        while (viewitsearchresultwrapper != null && mObjectToDelete != null && viewitsearchresultwrapper.getOriginalScannedOutput().equals(mObjectToDelete.getOriginalScannedOutput()) && (ViewItItemView.ItemShowType.ITME_SHOW_AS_GROUP.equals(itemshowtype) && "delete_all_asin".equals(mObjectToDelete.getDeletedAsin()) || mObjectToDelete.getDeletedAsin().equals(searchresult.getBasicProduct().getAsin()))) 
        {
            return true;
        }
        return false;
    }

    protected void objectsReceived(List list, ServiceCall servicecall)
    {
        objectsReceived(list, servicecall);
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItSlidingDrawerBrowser this$0;

            public void run()
            {
                mActivity.getPhotoCaptureView().getViewItSlidingDrawerView().updateBottomToolBar();
            }

            
            {
                this$0 = ViewItSlidingDrawerBrowser.this;
                super();
            }
        });
    }

    public void recoverUndo(ViewItSearchResultWrapper viewitsearchresultwrapper)
    {
        if (viewitsearchresultwrapper.getOriginalScannedOutput().equals(mObjectToDelete.getOriginalScannedOutput()))
        {
            viewitsearchresultwrapper.setDeletedAsin(null);
            mObjectToDelete = null;
        }
    }

    public void setAllMatchesPageListingAdapter(ViewItAllMatchedResultsView.ViewItAllMatchesAdapter viewitallmatchesadapter)
    {
        mAllMatchesAdapter = viewitallmatchesadapter;
    }

    public void setSlidingDrawerPageListingAdapter(ViewItSlidingDrawerView.ViewItSlidingDrawerItemAdapter viewitslidingdraweritemadapter)
    {
        mSlidingDrawerAdapter = viewitslidingdraweritemadapter;
    }

    public boolean startFirstPageRequest(List list)
    {
        mAllHistoryDBObjects = list;
        return startFirstPageRequest(list.size(), null);
    }

    protected ServiceCall startPageRequest(int i)
    {
        BasicProductsRequest basicproductsrequest = new BasicProductsRequest();
        Vector vector = new Vector();
        mCurrentRequestDBObjects.clear();
        int i1 = i * pageSize;
        int k = i1 + pageSize;
        int l = mAllHistoryDBObjects.size();
        int j = k;
        if (k > l)
        {
            j = l;
        }
        mNextPageStartIndex = j;
        ViewItDBResultWrapper viewitdbresultwrapper;
        for (Iterator iterator = mAllHistoryDBObjects.subList(i1, j).iterator(); iterator.hasNext(); mCurrentRequestDBObjects.add(viewitdbresultwrapper))
        {
            viewitdbresultwrapper = (ViewItDBResultWrapper)iterator.next();
            Object obj = viewitdbresultwrapper.getAsinList();
            if (Util.isEmpty(((java.util.Collection) (obj))))
            {
                continue;
            }
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); vector.add((String)((Iterator) (obj)).next())) { }
        }

        if (vector.size() == 0)
        {
            lastRequestPageIndex = i;
            currentRequestPageIndex = -1;
            mActivity.getPhotoCaptureView().getViewItSlidingDrawerView().updateBottomToolBar();
            primarySubscriber.onPageComplete();
            return null;
        }
        basicproductsrequest.setAsins(vector);
        if (i == 0)
        {
            mRequestId = CustomClientFields.getAmazonRequestId();
            CustomClientFields.setCustomHeaderFields("basic_products_v32", false, mRequestId);
        } else
        {
            CustomClientFields.setCustomHeaderFields("basic_products_v32", true, mRequestId);
        }
        return ServiceController.getMShopService().basicProducts(basicproductsrequest, this);
    }

    public boolean updateUndoObject(ViewItSearchResultWrapper viewitsearchresultwrapper, SearchResult searchresult, ViewItItemView.ItemShowType itemshowtype)
    {
        if (viewitsearchresultwrapper != null && searchresult != null)
        {
            if (mObjectToDelete != null)
            {
                deleteObject(mObjectToDelete);
                notifyDataSetChanged();
            }
            if (ViewItItemView.ItemShowType.ITME_SHOW_AS_GROUP.equals(itemshowtype))
            {
                viewitsearchresultwrapper.setDeletedAsin("delete_all_asin");
            } else
            {
                viewitsearchresultwrapper.setDeletedAsin(searchresult.getBasicProduct().getAsin());
            }
            mObjectToDelete = viewitsearchresultwrapper;
            return true;
        } else
        {
            return false;
        }
    }






/*
    static int access$402(ViewItSlidingDrawerBrowser viewitslidingdrawerbrowser, int i)
    {
        viewitslidingdrawerbrowser.nextTriggerObjectIndex = i;
        return i;
    }

*/


}
