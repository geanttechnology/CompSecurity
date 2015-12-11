// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.content.PaymentReminderStorageUtil;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.SellingListRefinement;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayCountsResponse;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayResponse;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbaySellingCountsRequest;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbaySellingRequest;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayDataManager, UssContentsDataManager, PagedListManager, UserContextObservingDataManager

public final class MyEbaySellingDataManager extends MyEbayDataManager
{
    private final class BestOfferListLoader extends FilteredListLoader
    {

        private static final int BEST_OFFER_ITEMS_PER_PAGE = 200;
        private ListCountContent listCountOffers;
        private ListContent listDataOffers;
        final MyEbaySellingDataManager this$0;

        protected GetMyEbaySellingRequest createGetMyEbaySellingRequest(int i, EbayTradingApi ebaytradingapi)
        {
            return new GetMyEbaySellingRequest(ebaytradingapi, listName, itemsPerPage, i, "BestOfferCountDescending", null);
        }

        public final ListContent getOfferListData()
        {
            this;
            JVM INSTR monitorenter ;
            ListContent listcontent = listDataOffers;
            this;
            JVM INSTR monitorexit ;
            return listcontent;
            Exception exception;
            exception;
            throw exception;
        }

        public void markDirty()
        {
            this;
            JVM INSTR monitorenter ;
            markDirty();
            listDataOffers = null;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void onCountChanged(ListCountContent listcountcontent)
        {
        }

        public void onListChanged(ListContent listcontent)
        {
            ResultStatus resultstatus = listcontent.getStatus();
            if (resultstatus.hasError())
            {
                ((Observer)bestOfferEnabled).onFilteredListChanged(MyEbaySellingDataManager.this, listcontent, refinement);
                return;
            }
            List list = listcontent.getList();
            boolean flag = false;
            int i = 0;
            Object obj1 = null;
            Object obj = obj1;
            int j = ((flag) ? 1 : 0);
            if (list != null)
            {
                obj = obj1;
                j = ((flag) ? 1 : 0);
                if (!list.isEmpty())
                {
                    obj = list.iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        MyEbayListItem myebaylistitem = (MyEbayListItem)((Iterator) (obj)).next();
                        if (!myebaylistitem.bestOfferEnabled || myebaylistitem.bestOfferPendingCount <= 0)
                        {
                            break;
                        }
                        i++;
                    } while (true);
                    obj = obj1;
                    j = i;
                    if (i > 0)
                    {
                        obj = list.subList(0, i);
                        j = i;
                    }
                }
            }
            long l;
            if (obj == null)
            {
                obj = Collections.emptyList();
            } else
            {
                obj = Collections.unmodifiableList(((List) (obj)));
            }
            l = listcontent.getLastUpdatedMillis();
            if (listCountOffers == null || listCountOffers.getTotalItemCount() != j)
            {
                listCountOffers = new ListCountContent(j, resultstatus, l);
            }
            listDataOffers = new ListContent(((List) (obj)), j, listcontent.getPagesLoaded(), listcontent.getHighestPageIndex(), j, j, resultstatus, l);
            ((Observer)bestOfferEnabled).onFilteredListChanged(MyEbaySellingDataManager.this, listDataOffers, refinement);
        }


        public BestOfferListLoader(SellingListRefinement sellinglistrefinement)
        {
            this$0 = MyEbaySellingDataManager.this;
            super("ActiveList", sellinglistrefinement, 200, 1);
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

        public MyEbaySellingDataManager create(EbayContext ebaycontext)
        {
            return new MyEbaySellingDataManager(ebaycontext, this);
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
            int j = hashCode();
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

        public final boolean includeActiveList;
        public final boolean includeScheduledList;
        public final boolean includeSoldList;
        public final boolean includeUnsoldList;
        final MyEbaySellingDataManager this$0;

        protected transient DatedContent doInBackground(Void avoid[])
        {
            try
            {
                avoid = loadCounts(includeActiveList, includeSoldList, includeUnsoldList, includeScheduledList);
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
            this$0 = MyEbaySellingDataManager.this;
            super();
            includeActiveList = flag;
            includeSoldList = flag1;
            includeUnsoldList = flag2;
            includeScheduledList = flag3;
        }
    }

    public static interface Observer
    {

        public abstract void onActiveCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent);

        public abstract void onActiveListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent);

        public abstract void onFilteredListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent, SellingListRefinement sellinglistrefinement);

        public abstract void onRemoveFromSoldListComplete(MyEbaySellingDataManager myebaysellingdatamanager, Content content);

        public abstract void onRemoveFromUnsoldListComplete(MyEbaySellingDataManager myebaysellingdatamanager, Content content);

        public abstract void onScheduledCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent);

        public abstract void onScheduledListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent);

        public abstract void onSoldCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent);

        public abstract void onSoldListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent);

        public abstract void onUnsoldCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent);

        public abstract void onUnsoldListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent);
    }

    private final class RemoveFromSoldListTask extends AsyncTask
    {

        public final Observer observer;
        public final SellingListRefinement refinement;
        final MyEbaySellingDataManager this$0;

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
                MyEbayDataManager.RemoveFromMyEbayListRequest removefrommyebaylistrequest = MyEbayDataManager.RemoveFromMyEbayListRequest.getRemoveFromSoldListRequest(ebaytradingapi.site, ebaytradingapi.iafToken, amyebaylistitem);
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
            handleRemoveFromSoldListResult(this, null, refinement);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleRemoveFromSoldListResult(this, content, refinement);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public RemoveFromSoldListTask(Observer observer1)
        {
            this(observer1, null);
        }

        public RemoveFromSoldListTask(Observer observer1, SellingListRefinement sellinglistrefinement)
        {
            this$0 = MyEbaySellingDataManager.this;
            super();
            observer = observer1;
            refinement = sellinglistrefinement;
        }
    }

    private final class RemoveFromUnsoldListTask extends AsyncTask
    {

        public final Observer observer;
        final MyEbaySellingDataManager this$0;

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
                MyEbayDataManager.RemoveFromMyEbayListRequest removefrommyebaylistrequest = MyEbayDataManager.RemoveFromMyEbayListRequest.getRemoveFromUnsoldListRequest(ebaytradingapi.site, ebaytradingapi.iafToken, amyebaylistitem);
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
            handleRemoveFromUnsoldListResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleRemoveFromUnsoldListResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public RemoveFromUnsoldListTask(Observer observer1)
        {
            this$0 = MyEbaySellingDataManager.this;
            super();
            observer = observer1;
        }
    }

    private abstract class SellingListLoader extends PagedListManager
    {

        public final int highestPageAllowed;
        public ListCountContent listCount;
        public final String listName;
        final MyEbaySellingDataManager this$0;

        protected GetMyEbaySellingRequest createGetMyEbaySellingRequest(int i, EbayTradingApi ebaytradingapi)
        {
            return new GetMyEbaySellingRequest(ebaytradingapi, listName, itemsPerPage, i, null, null);
        }

        public ResultStatus getPage(int i, ArrayList arraylist)
            throws InterruptedException
        {
            if (i < 1 || i > highestPageAllowed)
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
                obj = createGetMyEbaySellingRequest(i, ((EbayTradingApi) (obj1)));
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
                    if (getmyebayresponse.totalPages > highestPageAllowed)
                    {
                        i = highestPageAllowed;
                    } else
                    {
                        i = getmyebayresponse.totalPages;
                    }
                    highestPageIndex = i;
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

        public SellingListLoader(String s)
        {
            this(s, 25, 100);
        }

        public SellingListLoader(String s, int i, int j)
        {
            this$0 = MyEbaySellingDataManager.this;
            super(i);
            listCount = null;
            listName = s;
            highestPageAllowed = j;
        }
    }


    private final ActiveListLoader activeListLoader = new ActiveListLoader();
    private final HashMap filteredListLoaderHashMap = new HashMap();
    private LoadCountsTask loadCountsTask;
    private final SellingListLoader scheduledListLoader = new ScheduledListLoader();
    private final SellingListLoader soldListLoader = new SoldListLoader();
    private final SellingListLoader unsoldListLoader = new UnsoldListLoader();

    MyEbaySellingDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        MyEbayDataManager(ebaycontext, com/ebay/nautilus/domain/content/dm/MyEbaySellingDataManager$Observer, keyparams);
        PaymentReminderStorageUtil.create((Context)ebaycontext.getExtension(android/content/Context));
    }

    private void cancelPendingTasks()
    {
        if (loadCountsTask != null)
        {
            loadCountsTask.cancel(true);
        }
        loadCountsTask = null;
        activeListLoader.markDirty();
        activeListLoader.listCount = null;
        soldListLoader.markDirty();
        soldListLoader.listCount = null;
        unsoldListLoader.markDirty();
        unsoldListLoader.listCount = null;
        scheduledListLoader.markDirty();
        scheduledListLoader.listCount = null;
        clearFilteredListLoaders(null);
    }

    private void clearFilteredListLoaders(String s)
    {
        Iterator iterator = filteredListLoaderHashMap.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            FilteredListLoader filteredlistloader = (FilteredListLoader)entry.getValue();
            if (TextUtils.isEmpty(s) || ((SellingListRefinement)entry.getKey()).listName.equals(s))
            {
                filteredlistloader.markDirty();
            }
        } while (true);
    }

    private SellingListLoader getListLoader(SellingListRefinement sellinglistrefinement, SellingListLoader sellinglistloader)
    {
        if (sellinglistrefinement == null)
        {
            return sellinglistloader;
        }
        if (sellinglistrefinement.isDefault()) goto _L2; else goto _L1
_L1:
        if (filteredListLoaderHashMap.containsKey(sellinglistrefinement))
        {
            sellinglistrefinement = (SellingListLoader)filteredListLoaderHashMap.get(sellinglistrefinement);
        } else
        {
            sellinglistloader = new SellingListRefinement(sellinglistrefinement);
            if ("ActiveList".equals(sellinglistrefinement.listName) && "NewOffers".equals(sellinglistrefinement.filter))
            {
                sellinglistrefinement = new BestOfferListLoader(sellinglistloader);
            } else
            {
                sellinglistrefinement = new FilteredListLoader(sellinglistrefinement.listName, sellinglistloader);
            }
            filteredListLoaderHashMap.put(sellinglistloader, (FilteredListLoader)sellinglistrefinement);
        }
_L10:
        return sellinglistrefinement;
_L2:
        byte byte0;
        sellinglistrefinement = sellinglistrefinement.listName;
        byte0 = -1;
        sellinglistrefinement.hashCode();
        JVM INSTR lookupswitch 4: default 168
    //                   -1814759733: 255
    //                   -257782556: 213
    //                   699781451: 241
    //                   1539699634: 227;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_255;
_L8:
        switch (byte0)
        {
        default:
            sellinglistrefinement = sellinglistloader;
            break;

        case 0: // '\0'
            sellinglistrefinement = activeListLoader;
            break;

        case 1: // '\001'
            sellinglistrefinement = soldListLoader;
            break;

        case 2: // '\002'
            sellinglistrefinement = unsoldListLoader;
            break;

        case 3: // '\003'
            sellinglistrefinement = scheduledListLoader;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (sellinglistrefinement.equals("ActiveList"))
        {
            byte0 = 0;
        }
          goto _L8
_L7:
        if (sellinglistrefinement.equals("SoldList"))
        {
            byte0 = 1;
        }
          goto _L8
_L6:
        if (sellinglistrefinement.equals("UnsoldList"))
        {
            byte0 = 2;
        }
          goto _L8
        if (sellinglistrefinement.equals("ScheduledList"))
        {
            byte0 = 3;
        }
          goto _L8
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void doRefine(Observer observer, SellingListRefinement sellinglistrefinement)
    {
        Object obj = getListLoader(sellinglistrefinement, null);
        if (obj == null)
        {
            throw new IllegalArgumentException("Invalid refinement");
        }
        ((SellingListLoader) (obj)).load(1);
        if (obj instanceof BestOfferListLoader)
        {
            obj = ((BestOfferListLoader)obj).listDataOffers;
        } else
        {
            obj = ((SellingListLoader) (obj)).getData();
        }
        if (obj != null)
        {
            observer.onFilteredListChanged(this, ((ListContent) (obj)), sellinglistrefinement);
        }
    }

    public boolean forceReloadActiveList()
    {
        NautilusKernel.verifyMain();
        clearFilteredListLoaders("ActiveList");
        UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.SELLING_UTILITY
        });
        return activeListLoader.forceReload();
    }

    public boolean forceReloadActiveList(SellingListRefinement sellinglistrefinement)
    {
        NautilusKernel.verifyMain();
        clearFilteredListLoaders("ActiveList");
        activeListLoader.markDirty();
        UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.SELLING_UTILITY
        });
        return getListLoader(sellinglistrefinement, activeListLoader).forceReload();
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

    public boolean forceReloadScheduledList()
    {
        NautilusKernel.verifyMain();
        UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.SCHEDULED_LISTING
        });
        return scheduledListLoader.forceReload();
    }

    public boolean forceReloadSoldList()
    {
        NautilusKernel.verifyMain();
        clearFilteredListLoaders("SoldList");
        UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.SELLING_UTILITY
        });
        UssContentsDataManager.invalidateActivityChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.BUYING_SELLING_OVERVIEW
        });
        return soldListLoader.forceReload();
    }

    public boolean forceReloadSoldList(SellingListRefinement sellinglistrefinement)
    {
        NautilusKernel.verifyMain();
        clearFilteredListLoaders("SoldList");
        soldListLoader.markDirty();
        UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.SELLING_UTILITY
        });
        UssContentsDataManager.invalidateActivityChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.BUYING_SELLING_OVERVIEW
        });
        return getListLoader(sellinglistrefinement, soldListLoader).forceReload();
    }

    public boolean forceReloadUnsoldList()
    {
        NautilusKernel.verifyMain();
        UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.SELLING_UTILITY
        });
        UssContentsDataManager.invalidateActivityChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.BUYING_SELLING_OVERVIEW
        });
        return unsoldListLoader.forceReload();
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
            if (loadcountstask.includeActiveList)
            {
                if (map == null)
                {
                    i = 0;
                } else
                {
                    i = ((com.ebay.nautilus.domain.net.api.trading.GetMyEbayCountsResponse.ListCount)map.get(activeListLoader.listName)).count;
                }
                datedcontent = new ListCountContent(i, resultstatus, l);
                if (!flag)
                {
                    activeListLoader.listCount = datedcontent;
                    ((Observer)dispatcher).onActiveCountChanged(this, datedcontent);
                }
            }
            if (loadcountstask.includeSoldList)
            {
                if (map == null)
                {
                    i = 0;
                } else
                {
                    i = ((com.ebay.nautilus.domain.net.api.trading.GetMyEbayCountsResponse.ListCount)map.get(soldListLoader.listName)).count;
                }
                datedcontent = new ListCountContent(i, resultstatus, l);
                if (!flag)
                {
                    soldListLoader.listCount = datedcontent;
                }
                ((Observer)dispatcher).onSoldCountChanged(this, datedcontent);
            }
            if (loadcountstask.includeUnsoldList)
            {
                if (map == null)
                {
                    i = 0;
                } else
                {
                    i = ((com.ebay.nautilus.domain.net.api.trading.GetMyEbayCountsResponse.ListCount)map.get(unsoldListLoader.listName)).count;
                }
                datedcontent = new ListCountContent(i, resultstatus, l);
                if (!flag)
                {
                    unsoldListLoader.listCount = datedcontent;
                }
                ((Observer)dispatcher).onUnsoldCountChanged(this, datedcontent);
            }
            if (loadcountstask.includeScheduledList)
            {
                if (map == null)
                {
                    i = 0;
                } else
                {
                    i = ((com.ebay.nautilus.domain.net.api.trading.GetMyEbayCountsResponse.ListCount)map.get(scheduledListLoader.listName)).count;
                }
                loadcountstask = new ListCountContent(i, resultstatus, l);
                if (!flag)
                {
                    scheduledListLoader.listCount = loadcountstask;
                }
                ((Observer)dispatcher).onScheduledCountChanged(this, loadcountstask);
                return;
            }
        }
    }

    void handleRemoveFromSoldListResult(RemoveFromSoldListTask removefromsoldlisttask, Content content, SellingListRefinement sellinglistrefinement)
    {
        if (content != null)
        {
            if (!content.getStatus().hasError())
            {
                clearFilteredListLoaders("SoldList");
                forceReloadSoldList(sellinglistrefinement);
            }
            if (removefromsoldlisttask.observer != null)
            {
                removefromsoldlisttask.observer.onRemoveFromSoldListComplete(this, content);
                return;
            }
        }
    }

    void handleRemoveFromUnsoldListResult(RemoveFromUnsoldListTask removefromunsoldlisttask, Content content)
    {
        if (content != null)
        {
            if (!content.getStatus().hasError())
            {
                forceReloadUnsoldList();
            }
            if (removefromunsoldlisttask.observer != null)
            {
                removefromunsoldlisttask.observer.onRemoveFromUnsoldListComplete(this, content);
                return;
            }
        }
    }

    public void invalidateSellLists()
    {
        UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.SELLING_UTILITY, ContentSourceEnum.SCHEDULED_LISTING
        });
        UssContentsDataManager.invalidateActivityChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.BUYING_SELLING_OVERVIEW
        });
        cancelPendingTasks();
    }

    public void loadActiveList(int i)
    {
        NautilusKernel.verifyMain();
        activeListLoader.load(i);
    }

    public void loadActiveList(int i, SellingListRefinement sellinglistrefinement)
    {
        NautilusKernel.verifyMain();
        getListLoader(sellinglistrefinement, activeListLoader).load(i);
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
            obj = (GetMyEbayCountsResponse)sendRequest(new GetMyEbaySellingCountsRequest(((EbayTradingApi) (obj2)), flag, flag1, flag2, flag3));
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

    public void loadScheduledList(int i)
    {
        NautilusKernel.verifyMain();
        scheduledListLoader.load(i);
    }

    public void loadSoldList(int i)
    {
        NautilusKernel.verifyMain();
        soldListLoader.load(i);
    }

    public void loadSoldList(int i, SellingListRefinement sellinglistrefinement)
    {
        NautilusKernel.verifyMain();
        getListLoader(sellinglistrefinement, soldListLoader).load(i);
    }

    public void loadUnsoldList(int i)
    {
        NautilusKernel.verifyMain();
        unsoldListLoader.load(i);
    }

    protected void onLastObserverUnregistered()
    {
        clearFilteredListLoaders(null);
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
        ListCountContent listcountcontent = new ListCountContent(0, ResultStatus.SUCCESS, System.currentTimeMillis());
        ((Observer)dispatcher).onActiveCountChanged(this, listcountcontent);
        ((Observer)dispatcher).onSoldCountChanged(this, listcountcontent);
        ((Observer)dispatcher).onUnsoldCountChanged(this, listcountcontent);
        ((Observer)dispatcher).onScheduledCountChanged(this, listcountcontent);
    }

    public transient void removeFromSoldList(Observer observer, SellingListRefinement sellinglistrefinement, MyEbayListItem amyebaylistitem[])
    {
        if (amyebaylistitem == null || amyebaylistitem.length == 0)
        {
            throw new IllegalArgumentException("items is empty");
        } else
        {
            NautilusKernel.verifyMain();
            executeOnThreadPool(new RemoveFromSoldListTask((Observer)getSafeCallback(observer), sellinglistrefinement), amyebaylistitem);
            return;
        }
    }

    public transient void removeFromSoldList(Observer observer, MyEbayListItem amyebaylistitem[])
    {
        if (amyebaylistitem == null || amyebaylistitem.length == 0)
        {
            throw new IllegalArgumentException("items is empty");
        } else
        {
            NautilusKernel.verifyMain();
            executeOnThreadPool(new RemoveFromSoldListTask((Observer)getSafeCallback(observer)), amyebaylistitem);
            return;
        }
    }

    public transient void removeFromUnsoldList(Observer observer, MyEbayListItem amyebaylistitem[])
    {
        if (amyebaylistitem == null || amyebaylistitem.length == 0)
        {
            throw new IllegalArgumentException("items is empty");
        } else
        {
            NautilusKernel.verifyMain();
            executeOnThreadPool(new RemoveFromUnsoldListTask((Observer)getSafeCallback(observer)), amyebaylistitem);
            return;
        }
    }

    public void setObserving(Observer observer, boolean flag, SellingListRefinement sellinglistrefinement)
    {
        NautilusKernel.verifyMain();
        if (sellinglistrefinement != null)
        {
            if (sellinglistrefinement.isDefault())
            {
                setObserving(observer, flag, "ActiveList".equals(sellinglistrefinement.listName), "SoldList".equals(sellinglistrefinement.listName), "UnsoldList".equals(sellinglistrefinement.listName), "ScheduledList".equals(sellinglistrefinement.listName));
                return;
            }
            setObserving(observer, flag, false, false, false, false);
            observer = getListLoader(sellinglistrefinement, null);
            if (observer != null)
            {
                observer.load(1);
                if (observer instanceof BestOfferListLoader)
                {
                    observer = ((BestOfferListLoader)observer).listDataOffers;
                } else
                {
                    observer = observer.getData();
                }
                if (observer != null)
                {
                    ((Observer)dispatcher).onFilteredListChanged(this, observer, sellinglistrefinement);
                    return;
                }
            }
        }
    }

    public void setObserving(Observer observer, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        NautilusKernel.verifyMain();
        if (!flag || loadCountsTask != null) goto _L2; else goto _L1
_L1:
        boolean flag5;
        boolean flag6;
        boolean flag7;
        if (!flag1 && activeListLoader.listCount == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag2 && soldListLoader.listCount == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (!flag3 && unsoldListLoader.listCount == null)
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        if (!flag4 && scheduledListLoader.listCount == null)
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
            activeListLoader.load(1);
            observer = activeListLoader.getData();
            if (observer != null)
            {
                ((Observer)dispatcher).onActiveListChanged(this, observer);
            }
        }
        if (flag2)
        {
            soldListLoader.load(1);
            observer = soldListLoader.getData();
            if (observer != null)
            {
                ((Observer)dispatcher).onSoldListChanged(this, observer);
            }
        }
        if (flag3)
        {
            unsoldListLoader.load(1);
            observer = unsoldListLoader.getData();
            if (observer != null)
            {
                ((Observer)dispatcher).onUnsoldListChanged(this, observer);
            }
        }
        if (flag4)
        {
            scheduledListLoader.load(1);
            observer = scheduledListLoader.getData();
            if (observer != null)
            {
                ((Observer)dispatcher).onScheduledListChanged(this, observer);
            }
        }
        return;
_L4:
        if (activeListLoader.listCount != null && soldListLoader.listCount != null && unsoldListLoader.listCount != null && scheduledListLoader.listCount != null)
        {
            ((Observer)dispatcher).onSoldCountChanged(this, soldListLoader.listCount);
            ((Observer)dispatcher).onUnsoldCountChanged(this, unsoldListLoader.listCount);
            ((Observer)dispatcher).onScheduledCountChanged(this, scheduledListLoader.listCount);
            ((Observer)dispatcher).onActiveCountChanged(this, activeListLoader.listCount);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }















}
