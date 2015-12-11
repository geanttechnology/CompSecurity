// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.text.TextUtils;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionItemViewModel extends ViewModel
{
    public class CollectionItemDetail
    {

        public final String image;
        public final String itemId;
        public final String price;
        final CollectionItemViewModel this$0;
        public final String title;

        public CollectionItemDetail(String s, String s1, String s2, String s3)
        {
            this$0 = CollectionItemViewModel.this;
            super();
            title = s;
            image = s1;
            itemId = s3;
            price = s2;
        }
    }


    public List collectionItems;

    public CollectionItemViewModel(int i, List list, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        collectionItems = new ArrayList();
        if (list != null)
        {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                list = (com.ebay.nautilus.domain.data.CollectionDetail.CollectionEntry)iterator.next();
                com.ebay.nautilus.domain.data.CollectionDetail.ListingSummaryBase listingsummarybase = ((com.ebay.nautilus.domain.data.CollectionDetail.CollectionEntry) (list)).listingSummaryBase;
                if (list != null && listingsummarybase != null)
                {
                    Object obj = null;
                    onclicklistener = null;
                    String s = listingsummarybase.imageURL;
                    String s1 = listingsummarybase.listingId;
                    if (((com.ebay.nautilus.domain.data.CollectionDetail.CollectionEntry) (list)).note != null && !TextUtils.isEmpty(((com.ebay.nautilus.domain.data.CollectionDetail.CollectionEntry) (list)).note))
                    {
                        list = ((com.ebay.nautilus.domain.data.CollectionDetail.CollectionEntry) (list)).note;
                    } else
                    {
                        list = obj;
                        if (listingsummarybase.title != null)
                        {
                            list = obj;
                            if (listingsummarybase.title.content != null)
                            {
                                list = listingsummarybase.title.content;
                            }
                        }
                    }
                    if (listingsummarybase.format != null && listingsummarybase.format == com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.AUCTION && listingsummarybase.currentBidPrice != null)
                    {
                        onclicklistener = EbayCurrencyUtil.formatDisplay(listingsummarybase.currentBidPrice.currency, listingsummarybase.currentBidPrice.value, 2);
                    } else
                    if (listingsummarybase.lowestFixedPrice != null)
                    {
                        onclicklistener = EbayCurrencyUtil.formatDisplay(listingsummarybase.lowestFixedPrice.currency, listingsummarybase.lowestFixedPrice.value, 2);
                    }
                    collectionItems.add(new CollectionItemDetail(list, s, onclicklistener, s1));
                }
            }
        }
    }
}
