// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.text.TextUtils;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager;
import com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;
import com.ebay.nautilus.domain.data.ImmutableNameValue;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.UserDefinedList;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ItemDataManager extends UserContextObservingDataManager
    implements com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager.Observer, com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Observer
{
    public static final class KeyParams extends com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager.KeyBase
    {

        protected ItemDataManager create(EbayContext ebaycontext)
        {
            return new ItemDataManager(ebaycontext, this);
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            return obj != null && obj.getClass() == getClass();
        }

        public KeyParams()
        {
        }
    }

    public static interface Observer
    {

        public abstract void onMyEbayBidListChanged(ItemDataManager itemdatamanager);

        public abstract void onMyEbayWatchListChanged(ItemDataManager itemdatamanager);
    }


    private HashMap bidItems;
    private MyEbayBuyingDataManager myEbayBuyingDataManager;
    private MyEbayWatchingDataManager myEbayWatchingDataManager;
    private HashMap watchItems;

    ItemDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/mobile/viewitem/ItemDataManager$Observer, keyparams);
        watchItems = null;
        bidItems = null;
    }

    public void forceRefresh()
    {
        if (myEbayWatchingDataManager != null)
        {
            myEbayWatchingDataManager.forceReloadWatchList();
        }
        if (myEbayBuyingDataManager != null)
        {
            myEbayBuyingDataManager.forceReloadBidList();
        }
    }

    public final MyEbayListItem getMyEbayBidItem(long l)
    {
        if (bidItems != null)
        {
            return (MyEbayListItem)bidItems.get(Long.valueOf(l));
        } else
        {
            return null;
        }
    }

    public boolean isInMyEbayBidList(long l)
    {
        return bidItems != null && bidItems.containsKey(Long.valueOf(l));
    }

    public boolean isInMyEbayWatchList(EbayItemIdAndVariationSpecifics ebayitemidandvariationspecifics)
    {
        return watchItems != null && watchItems.containsKey(ebayitemidandvariationspecifics);
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onAddToWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content)
    {
        if (content.getStatus().hasError() || watchItems == null)
        {
            return;
        }
        myebaywatchingdatamanager = (EbayItemIdAndVariationSpecifics[])content.getData();
        int j = myebaywatchingdatamanager.length;
        for (int i = 0; i < j; i++)
        {
            content = myebaywatchingdatamanager[i];
            if (watchItems.containsKey(content))
            {
                continue;
            }
            MyEbayListItem myebaylistitem = new MyEbayListItem();
            myebaylistitem.id = ((EbayItemIdAndVariationSpecifics) (content)).id;
            if (!((EbayItemIdAndVariationSpecifics) (content)).variationSpecifics.isEmpty())
            {
                ArrayList arraylist = new ArrayList(((EbayItemIdAndVariationSpecifics) (content)).variationSpecifics.size());
                ImmutableNameValue immutablenamevalue;
                for (Iterator iterator = ((EbayItemIdAndVariationSpecifics) (content)).variationSpecifics.iterator(); iterator.hasNext(); arraylist.add(new NameValue(immutablenamevalue.name, immutablenamevalue.values)))
                {
                    immutablenamevalue = (ImmutableNameValue)iterator.next();
                }

                myebaylistitem.nameValueList = arraylist;
            }
            watchItems.put(content, myebaylistitem);
        }

        ((Observer)dispatcher).onMyEbayWatchListChanged(this);
    }

    public void onBiddingCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onBiddingListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
        if (listcontent.getStatus().hasError())
        {
            return;
        }
        if (bidItems == null)
        {
            bidItems = new HashMap();
        } else
        {
            bidItems.clear();
        }
        myebaybuyingdatamanager = listcontent.getList();
        if (myebaybuyingdatamanager != null && !myebaybuyingdatamanager.isEmpty())
        {
            for (myebaybuyingdatamanager = myebaybuyingdatamanager.iterator(); myebaybuyingdatamanager.hasNext(); bidItems.put(Long.valueOf(((MyEbayListItem) (listcontent)).id), listcontent))
            {
                listcontent = (MyEbayListItem)myebaybuyingdatamanager.next();
            }

        }
        ((Observer)dispatcher).onMyEbayBidListChanged(this);
    }

    public void onBuyingOffersCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onBuyingOffersListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        super.onCurrentUserChanged(usercontextdatamanager, s, s1, flag);
        if (flag)
        {
            return;
        }
        watchItems = null;
        bidItems = null;
        if (myEbayWatchingDataManager != null)
        {
            unObserveDm(myEbayWatchingDataManager);
            myEbayWatchingDataManager = null;
        }
        if (myEbayBuyingDataManager != null)
        {
            unObserveDm(myEbayBuyingDataManager);
            myEbayBuyingDataManager = null;
        }
        if (s != null)
        {
            myEbayWatchingDataManager = (MyEbayWatchingDataManager)observeDm(new com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.KeyParams(s));
            myEbayWatchingDataManager.loadWatchList();
            myEbayBuyingDataManager = (MyEbayBuyingDataManager)observeDm(new com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager.KeyParams(s));
            myEbayBuyingDataManager.setObserving(this, false, true, false, false, false);
            return;
        } else
        {
            ((Observer)dispatcher).onMyEbayWatchListChanged(this);
            ((Observer)dispatcher).onMyEbayBidListChanged(this);
            return;
        }
    }

    public void onNotWonCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onNotWonListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
    }

    public void onRemoveAllFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, ResultStatus resultstatus)
    {
        if (resultstatus.hasError() || watchItems == null)
        {
            return;
        } else
        {
            watchItems.clear();
            ((Observer)dispatcher).onMyEbayWatchListChanged(this);
            return;
        }
    }

    public void onRemoveFromNotWonListComplete(MyEbayBuyingDataManager myebaybuyingdatamanager, Content content)
    {
    }

    public void onRemoveFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content)
    {
        if (content.getStatus().hasError() || watchItems == null)
        {
            return;
        }
        myebaywatchingdatamanager = (EbayItemIdAndVariationSpecifics[])content.getData();
        int j = myebaywatchingdatamanager.length;
        for (int i = 0; i < j; i++)
        {
            content = myebaywatchingdatamanager[i];
            watchItems.remove(content);
        }

        ((Observer)dispatcher).onMyEbayWatchListChanged(this);
    }

    public void onRemoveFromWonListComplete(MyEbayBuyingDataManager myebaybuyingdatamanager, Content content)
    {
    }

    public void onWatchingListChanged(MyEbayWatchingDataManager myebaywatchingdatamanager, String s, DatedContent datedcontent)
    {
        if (TextUtils.isEmpty(s) && !datedcontent.getStatus().hasError())
        {
            if (watchItems == null)
            {
                watchItems = new HashMap();
            } else
            {
                watchItems.clear();
            }
            myebaywatchingdatamanager = (UserDefinedList)datedcontent.getData();
            if (myebaywatchingdatamanager != null && ((UserDefinedList) (myebaywatchingdatamanager)).list != null && !((UserDefinedList) (myebaywatchingdatamanager)).list.isEmpty())
            {
                for (myebaywatchingdatamanager = ((UserDefinedList) (myebaywatchingdatamanager)).list.iterator(); myebaywatchingdatamanager.hasNext(); watchItems.put(new EbayItemIdAndVariationSpecifics(s), s))
                {
                    s = (MyEbayListItem)myebaywatchingdatamanager.next();
                }

                ((Observer)dispatcher).onMyEbayWatchListChanged(this);
                return;
            }
        }
    }

    public void onWonCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
    }

    public void onWonListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
    }

    public final void setBidItemMaxPrice(long l, ItemCurrency itemcurrency)
    {
        if (bidItems == null)
        {
            bidItems = new HashMap();
        }
        MyEbayListItem myebaylistitem = (MyEbayListItem)bidItems.get(Long.valueOf(l));
        if (myebaylistitem != null)
        {
            myebaylistitem.maxBidPrice = itemcurrency;
        } else
        {
            MyEbayListItem myebaylistitem1 = new MyEbayListItem();
            myebaylistitem1.id = l;
            myebaylistitem1.maxBidPrice = itemcurrency;
            bidItems.put(Long.valueOf(l), myebaylistitem1);
        }
        ((Observer)dispatcher).onMyEbayBidListChanged(this);
    }
}
