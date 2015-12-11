// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayBuyingCountsRequest;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayBuyingRequest;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayCountsResponse;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayDataManager, UssContentsDataManager, PagedListManager, UserContextObservingDataManager

public final class MyEbayBuyingDataManager extends MyEbayDataManager
{
    private abstract class BuyingListLoader extends PagedListManager
    {

        public ListCountContent listCount;
        public final String listName;
        public String sort;
        final MyEbayBuyingDataManager this$0;

        public ResultStatus getPage(int i, ArrayList arraylist)
            throws InterruptedException
        {
            if (i < 1 || i > 100)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("pageIndex(").append(i).append(") out of range").toString());
            }
            Object obj = new ResultStatusOwner();
            Object obj1 = getApi(((ResultStatusOwner) (obj)));
            if (obj1 == null)
            {
                obj = ((ResultStatusOwner) (obj)).getResultStatus();
            } else
            {
                obj = new GetMyEbayBuyingRequest(((EbayTradingApi) (obj1)), listName, itemsPerPage, i, sort);
                GetMyEbayResponse getmyebayresponse = (GetMyEbayResponse)sendRequest(((Request) (obj)));
                obj1 = getmyebayresponse.getResultStatus();
                obj = obj1;
                if (!((ResultStatus) (obj1)).hasError())
                {
                    if (getmyebayresponse.resultItemList != null)
                    {
                        arraylist.addAll(getmyebayresponse.resultItemList);
                    }
                    totalNumberOfItems = getmyebayresponse.totalEntries;
                    highestPageIndex = getmyebayresponse.totalPages;
                    return ((ResultStatus) (obj1));
                }
            }
            return ((ResultStatus) (obj));
        }

        public void handleLoadListResult(ListContent listcontent)
        {
            if (listcontent.getStatus().hasError()) goto _L2; else goto _L1
_L1:
            if (listCount != null && listCount.getTotalItemCount() == listcontent.getTotalItemCount()) goto _L4; else goto _L3
_L3:
            ListCountContent listcountcontent = new ListCountContent(listcontent);
            listCount = listcountcontent;
            onCountChanged(listcountcontent);
_L2:
            onListChanged(listcontent);
            return;
_L4:
            if (listCount.getLastUpdatedMillis() < listcontent.getLastUpdatedMillis())
            {
                listCount = new ListCountContent(listcontent);
            }
            if (true) goto _L2; else goto _L5
_L5:
        }

        public abstract void onCountChanged(ListCountContent listcountcontent);

        public abstract void onListChanged(ListContent listcontent);

        protected void onLoadStarted()
        {
        }

        public BuyingListLoader(String s)
        {
            this(s, null);
        }

        public BuyingListLoader(String s, String s1)
        {
            this$0 = MyEbayBuyingDataManager.this;
            super(25);
            listCount = null;
            listName = s;
            sort = s1;
        }
    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams(parcel.readString());
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final String user;

        public MyEbayBuyingDataManager create(EbayContext ebaycontext)
        {
            return new MyEbayBuyingDataManager(ebaycontext, this);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj == null || obj.getClass() != getClass())
            {
                return false;
            } else
            {
                obj = (KeyParams)obj;
                return TextUtils.equals(user, ((KeyParams) (obj)).user);
            }
        }

        public int hashCode()
        {
            int j = super.hashCode();
            int i;
            if (user == null)
            {
                i = 0;
            } else
            {
                i = user.hashCode();
            }
            return j * 31 + i;
        }

        public String toString()
        {
            return (new StringBuilder()).append("user:").append(user).toString();
        }


        public KeyParams(String s)
        {
            user = s;
        }
    }

    private final class LoadCountsTask extends AsyncTask
    {

        public final boolean includeBestOfferList;
        public final boolean includeBidList;
        public final boolean includeLostList;
        public final boolean includeWonList;
        final MyEbayBuyingDataManager this$0;

        protected transient DatedContent doInBackground(Void avoid[])
        {
            try
            {
                avoid = loadCounts(includeBidList, includeWonList, includeLostList, includeBestOfferList);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(DatedContent datedcontent)
        {
            handleLoadCountsResult(this, datedcontent);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((DatedContent)obj);
        }

        public LoadCountsTask(boolean flag, boolean flag1, boolean flag2, boolean flag3)
        {
            this$0 = MyEbayBuyingDataManager.this;
            super();
            includeBidList = flag;
            includeWonList = flag1;
            includeLostList = flag2;
            includeBestOfferList = flag3;
        }
    }

    public static interface Observer
    {

        public abstract void onBiddingCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent);

        public abstract void onBiddingListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent);

        public abstract void onBuyingOffersCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent);

        public abstract void onBuyingOffersListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent);

        public abstract void onNotWonCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent);

        public abstract void onNotWonListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent);

        public abstract void onRemoveFromNotWonListComplete(MyEbayBuyingDataManager myebaybuyingdatamanager, Content content);

        public abstract void onRemoveFromWonListComplete(MyEbayBuyingDataManager myebaybuyingdatamanager, Content content);

        public abstract void onWonCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent);

        public abstract void onWonListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent);
    }

    private final class RemoveFromNotWonListTask extends AsyncTask
    {

        public final Observer observer;
        final MyEbayBuyingDataManager this$0;

        protected transient Content doInBackground(MyEbayListItem amyebaylistitem[])
        {
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            EbayTradingApi ebaytradingapi = getApi(resultstatusowner);
            if (ebaytradingapi == null)
            {
                return new Content(resultstatusowner.getResultStatus());
            }
            try
            {
                MyEbayDataManager.RemoveFromMyEbayListRequest removefrommyebaylistrequest = MyEbayDataManager.RemoveFromMyEbayListRequest.getRemoveFromDidntWinListRequest(ebaytradingapi.site, ebaytradingapi.iafToken, amyebaylistitem);
                amyebaylistitem = new Content(amyebaylistitem, sendRequest(removefrommyebaylistrequest).getResultStatus());
            }
            // Misplaced declaration of an exception variable
            catch (MyEbayListItem amyebaylistitem[])
            {
                return null;
            }
            return amyebaylistitem;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((MyEbayListItem[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleRemoveFromNotWonListResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleRemoveFromNotWonListResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public RemoveFromNotWonListTask(Observer observer1)
        {
            this$0 = MyEbayBuyingDataManager.this;
            super();
            observer = observer1;
        }
    }

    private final class RemoveFromWonListTask extends AsyncTask
    {

        public final Observer observer;
        final MyEbayBuyingDataManager this$0;

        protected transient Content doInBackground(MyEbayListItem amyebaylistitem[])
        {
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            EbayTradingApi ebaytradingapi = getApi(resultstatusowner);
            if (ebaytradingapi == null)
            {
                return new Content(resultstatusowner.getResultStatus());
            }
            try
            {
                MyEbayDataManager.RemoveFromMyEbayListRequest removefrommyebaylistrequest = MyEbayDataManager.RemoveFromMyEbayListRequest.getRemoveFromWonListRequest(ebaytradingapi.site, ebaytradingapi.iafToken, amyebaylistitem);
                amyebaylistitem = new Content(amyebaylistitem, sendRequest(removefrommyebaylistrequest).getResultStatus());
            }
            // Misplaced declaration of an exception variable
            catch (MyEbayListItem amyebaylistitem[])
            {
                return null;
            }
            return amyebaylistitem;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((MyEbayListItem[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleRemoveFromWonListResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleRemoveFromWonListResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public RemoveFromWonListTask(Observer observer1)
        {
            this$0 = MyEbayBuyingDataManager.this;
            super();
            observer = observer1;
        }
    }


    public static final String DEFAULT_BIDS_OFFERS_SORT = "TimeLeft";
    public static final String DEFAULT_DIDNT_WIN_SORT = "EndTimeDescending";
    private BuyingListLoader biddingListLoader;
    private String currentBidSort;
    private String currentNotWonSort;
    private String currentOfferSort;
    private LoadCountsTask loadCountsTask;
    private BuyingListLoader notWonListLoader;
    private BuyingListLoader offersListLoader;
    private final BuyingListLoader wonListLoader = new WonListLoader();

    MyEbayBuyingDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        MyEbayDataManager(ebaycontext, com/ebay/nautilus/domain/content/dm/MyEbayBuyingDataManager$Observer, keyparams);
        biddingListLoader = new BidListLoader("TimeLeft");
        notWonListLoader = new NotWonListLoader("EndTimeDescending");
        offersListLoader = new OffersListLoader("TimeLeft");
        currentBidSort = "TimeLeft";
        currentOfferSort = "TimeLeft";
        currentNotWonSort = "EndTimeDescending";
    }

    private void cancelPendingTasks()
    {
        if (loadCountsTask != null)
        {
            loadCountsTask.cancel(true);
        }
        loadCountsTask = null;
        biddingListLoader.markDirty();
        biddingListLoader.listCount = null;
        offersListLoader.markDirty();
        offersListLoader.listCount = null;
        wonListLoader.markDirty();
        wonListLoader.listCount = null;
        notWonListLoader.markDirty();
        notWonListLoader.listCount = null;
    }

    private void verifyBidListLoader()
    {
        if (!TextUtils.isEmpty(currentBidSort) && !currentBidSort.equals(biddingListLoader.sort))
        {
            biddingListLoader = new BidListLoader(currentBidSort);
        }
    }

    private void verifyNotWonListLoader()
    {
        if (!TextUtils.isEmpty(currentNotWonSort) && !currentNotWonSort.equals(notWonListLoader.sort))
        {
            notWonListLoader = new NotWonListLoader(currentNotWonSort);
        }
    }

    private void verifyOfferListLoader()
    {
        if (!TextUtils.isEmpty(currentOfferSort) && !currentOfferSort.equals(offersListLoader.sort))
        {
            offersListLoader = new OffersListLoader(currentOfferSort);
        }
    }

    public boolean forceReloadBidList()
    {
        NautilusKernel.verifyMain();
        verifyBidListLoader();
        return biddingListLoader.forceReload();
    }

    public boolean forceReloadCounts()
    {
        NautilusKernel.verifyMain();
        if (loadCountsTask != null)
        {
            return false;
        } else
        {
            loadCountsTask = new LoadCountsTask(true, true, true, true);
            executeOnThreadPool(loadCountsTask, new Void[0]);
            return true;
        }
    }

    public boolean forceReloadNotWonList()
    {
        NautilusKernel.verifyMain();
        verifyNotWonListLoader();
        return notWonListLoader.forceReload();
    }

    public boolean forceReloadOffersList()
    {
        NautilusKernel.verifyMain();
        verifyOfferListLoader();
        return offersListLoader.forceReload();
    }

    public boolean forceReloadWonList()
    {
        NautilusKernel.verifyMain();
        return wonListLoader.forceReload();
    }

    void handleLoadCountsResult(LoadCountsTask loadcountstask, DatedContent datedcontent)
    {
        if (loadCountsTask == loadcountstask)
        {
            loadCountsTask = null;
        }
        if (datedcontent != null)
        {
            ResultStatus resultstatus = datedcontent.getStatus();
            boolean flag = resultstatus.hasError();
            Map map = (Map)datedcontent.getData();
            long l = datedcontent.getLastUpdatedMillis();
            int i;
            if (loadcountstask.includeBidList)
            {
                if (map == null)
                {
                    i = 0;
                } else
                {
                    i = ((com.ebay.nautilus.domain.net.api.trading.GetMyEbayCountsResponse.ListCount)map.get(biddingListLoader.listName)).count;
                }
                datedcontent = new ListCountContent(i, resultstatus, l);
                if (!flag)
                {
                    biddingListLoader.listCount = datedcontent;
                }
                ((Observer)dispatcher).onBiddingCountChanged(this, datedcontent);
            }
            if (loadcountstask.includeWonList)
            {
                if (map == null)
                {
                    i = 0;
                } else
                {
                    i = ((com.ebay.nautilus.domain.net.api.trading.GetMyEbayCountsResponse.ListCount)map.get(wonListLoader.listName)).count;
                }
                datedcontent = new ListCountContent(i, resultstatus, l);
                if (!flag)
                {
                    wonListLoader.listCount = datedcontent;
                }
                ((Observer)dispatcher).onWonCountChanged(this, datedcontent);
            }
            if (loadcountstask.includeLostList)
            {
                if (map == null)
                {
                    i = 0;
                } else
                {
                    i = ((com.ebay.nautilus.domain.net.api.trading.GetMyEbayCountsResponse.ListCount)map.get(notWonListLoader.listName)).count;
                }
                datedcontent = new ListCountContent(i, resultstatus, l);
                if (!flag)
                {
                    notWonListLoader.listCount = datedcontent;
                }
                ((Observer)dispatcher).onNotWonCountChanged(this, datedcontent);
            }
            if (loadcountstask.includeBestOfferList)
            {
                if (map == null)
                {
                    i = 0;
                } else
                {
                    i = ((com.ebay.nautilus.domain.net.api.trading.GetMyEbayCountsResponse.ListCount)map.get(offersListLoader.listName)).count;
                }
                loadcountstask = new ListCountContent(i, resultstatus, l);
                if (!flag)
                {
                    offersListLoader.listCount = loadcountstask;
                }
                ((Observer)dispatcher).onBuyingOffersCountChanged(this, loadcountstask);
                return;
            }
        }
    }

    void handleRemoveFromNotWonListResult(RemoveFromNotWonListTask removefromnotwonlisttask, Content content)
    {
        if (content != null)
        {
            if (!content.getStatus().hasError())
            {
                forceReloadNotWonList();
            }
            if (removefromnotwonlisttask.observer != null)
            {
                removefromnotwonlisttask.observer.onRemoveFromNotWonListComplete(this, content);
                return;
            }
        }
    }

    void handleRemoveFromWonListResult(RemoveFromWonListTask removefromwonlisttask, Content content)
    {
        if (content != null)
        {
            if (!content.getStatus().hasError())
            {
                forceReloadWonList();
            }
            if (removefromwonlisttask.observer != null)
            {
                removefromwonlisttask.observer.onRemoveFromWonListComplete(this, content);
                return;
            }
        }
    }

    public void invalidateRelatedDataManagers()
    {
        invalidateRelatedDataManagers();
        UssContentsDataManager.invalidateActivityChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.BUYING_SELLING_OVERVIEW
        });
    }

    public void loadBidList(int i)
    {
        NautilusKernel.verifyMain();
        biddingListLoader.load(i);
    }

    DatedContent loadCounts(boolean flag, boolean flag1, boolean flag2, boolean flag3)
        throws InterruptedException
    {
        Object obj1 = new ResultStatusOwner();
        Object obj = null;
        Object obj2 = getApi(((ResultStatusOwner) (obj1)));
        if (obj2 == null)
        {
            obj1 = ((ResultStatusOwner) (obj1)).getResultStatus();
        } else
        {
            obj = (GetMyEbayCountsResponse)sendRequest(new GetMyEbayBuyingCountsRequest(((EbayTradingApi) (obj2)), flag, flag1, flag2, flag3));
            obj1 = ((GetMyEbayCountsResponse) (obj)).getResultStatus();
            obj = ((GetMyEbayCountsResponse) (obj)).counts;
        }
        obj2 = ((ResultStatus) (obj1)).getFirstError();
        if (obj2 != null && "network".equals(((com.ebay.nautilus.kernel.content.ResultStatus.Message) (obj2)).getCategory()))
        {
            ((ResultStatus) (obj1)).setCanRetry(true);
        }
        return new DatedContent(obj, ((ResultStatus) (obj1)));
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void loadNotWonList(int i)
    {
        NautilusKernel.verifyMain();
        notWonListLoader.load(i);
    }

    public void loadOffersList(int i)
    {
        NautilusKernel.verifyMain();
        offersListLoader.load(i);
    }

    public void loadWonList(int i)
    {
        NautilusKernel.verifyMain();
        wonListLoader.load(i);
    }

    protected final void onNewUser(String s)
    {
    }

    protected final void onUserAuthChanged()
    {
    }

    protected final void onUserSignedOut()
    {
        cancelPendingTasks();
    }

    public transient void removeFromNotWonList(Observer observer, MyEbayListItem amyebaylistitem[])
    {
        if (amyebaylistitem == null || amyebaylistitem.length == 0)
        {
            throw new IllegalArgumentException("items is empty");
        } else
        {
            NautilusKernel.verifyMain();
            executeOnThreadPool(new RemoveFromNotWonListTask((Observer)getSafeCallback(observer)), amyebaylistitem);
            return;
        }
    }

    public transient void removeFromWonList(Observer observer, MyEbayListItem amyebaylistitem[])
    {
        if (amyebaylistitem == null || amyebaylistitem.length == 0)
        {
            throw new IllegalArgumentException("items is empty");
        } else
        {
            NautilusKernel.verifyMain();
            executeOnThreadPool(new RemoveFromWonListTask((Observer)getSafeCallback(observer)), amyebaylistitem);
            return;
        }
    }

    public void setBidSort(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            s = "TimeLeft";
        }
        currentBidSort = s;
    }

    public void setDefaultSorts(String s, String s1, String s2)
    {
        setBidSort(s);
        setOfferSort(s1);
        setNotWonSort(s2);
    }

    public void setNotWonSort(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            s = "EndTimeDescending";
        }
        currentNotWonSort = s;
    }

    public void setObserving(Observer observer, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        NautilusKernel.verifyMain();
        if (!flag || loadCountsTask != null) goto _L2; else goto _L1
_L1:
        boolean flag5;
        boolean flag6;
        boolean flag7;
        if (!flag1 && biddingListLoader.listCount == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag2 && wonListLoader.listCount == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (!flag3 && notWonListLoader.listCount == null)
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        if (!flag4 && offersListLoader.listCount == null)
        {
            flag7 = true;
        } else
        {
            flag7 = false;
        }
        if (!flag && !flag5 && !flag6 && !flag7) goto _L4; else goto _L3
_L3:
        loadCountsTask = new LoadCountsTask(flag, flag5, flag6, flag7);
        executeOnThreadPool(loadCountsTask, new Void[0]);
_L2:
        if (flag1)
        {
            verifyBidListLoader();
            biddingListLoader.load(1);
            observer = biddingListLoader.getData();
            if (observer != null)
            {
                ((Observer)dispatcher).onBiddingListChanged(this, observer);
            }
        }
        if (flag2)
        {
            wonListLoader.load(1);
            observer = wonListLoader.getData();
            if (observer != null)
            {
                ((Observer)dispatcher).onWonListChanged(this, observer);
            }
        }
        if (flag3)
        {
            verifyNotWonListLoader();
            notWonListLoader.load(1);
            observer = notWonListLoader.getData();
            if (observer != null)
            {
                ((Observer)dispatcher).onNotWonListChanged(this, observer);
            }
        }
        if (flag4)
        {
            verifyOfferListLoader();
            offersListLoader.load(1);
            observer = offersListLoader.getData();
            if (observer != null)
            {
                ((Observer)dispatcher).onBuyingOffersListChanged(this, observer);
            }
        }
        return;
_L4:
        if (biddingListLoader.listCount != null && wonListLoader.listCount != null && notWonListLoader.listCount != null && offersListLoader.listCount != null)
        {
            ((Observer)dispatcher).onBiddingCountChanged(this, biddingListLoader.listCount);
            ((Observer)dispatcher).onWonCountChanged(this, wonListLoader.listCount);
            ((Observer)dispatcher).onNotWonCountChanged(this, notWonListLoader.listCount);
            ((Observer)dispatcher).onBuyingOffersCountChanged(this, offersListLoader.listCount);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void setOfferSort(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            s = "TimeLeft";
        }
        currentOfferSort = s;
    }











}
