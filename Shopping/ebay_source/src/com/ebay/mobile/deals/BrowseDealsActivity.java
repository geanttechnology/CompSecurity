// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import android.text.TextUtils;
import android.view.View;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.BrowseDepartmentActivity;
import com.ebay.mobile.home.BrowseDepartmentFragment;
import com.ebay.mobile.home.cards.ListingViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.data.UnifiedStream.KeyValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.deals:
//            BrowseDealsFragment, DealsContentAdapter

public class BrowseDealsActivity extends BrowseDepartmentActivity
    implements com.ebay.mobile.common.view.ViewModel.OnClickListener
{

    public BrowseDealsActivity()
    {
    }

    public BrowseDepartmentFragment createBrowseDepartmentFragment()
    {
        return new BrowseDealsFragment();
    }

    public RecyclerContentAdapter getChannelContentAdapter(Boolean boolean1)
    {
        return new DealsContentAdapter(this);
    }

    public ContentSourceEnum getContentSourceEnum(String s)
    {
        return ContentSourceEnum.DEALS;
    }

    public List getContextValues()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new KeyValue(ContentSourceEnum.DEALS.name(), "DealCategoryID", departmentId));
        return arraylist;
    }

    public String getTrackingEventName()
    {
        return "DealsBrowse";
    }

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof ListingViewModel)
        {
            ItemViewActivity.StartActivity(this, Long.parseLong(((ListingViewModel)viewmodel).listingId), com.ebay.common.ConstantsCommon.ItemKind.Deals);
        }
    }

    public void sendTracking(String s, Contents contents)
    {
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        trackingdata.addKeyValuePair("chnl", ChannelEnum.SHOP.name());
        trackingdata.addKeyValuePair("subchnl", s, true);
        if (TextUtils.equals(s, departmentId))
        {
            s = "0";
        } else
        {
            s = "1";
        }
        trackingdata.addKeyValuePair("filter", s);
        trackingdata.addSourceIdentification(getIntent());
        s = new LinkedList();
        if (contents != null && contents.contentGroups != null)
        {
            for (contents = contents.contentGroups.iterator(); contents.hasNext();)
            {
                Object obj = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup)contents.next();
                if (obj != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents != null)
                {
                    obj = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents.iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        Object obj1 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((Iterator) (obj)).next();
                        if (obj1 != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj1)).listings != null)
                        {
                            obj1 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj1)).listings.iterator();
                            while (((Iterator) (obj1)).hasNext()) 
                            {
                                com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing)((Iterator) (obj1)).next();
                                if (listing != null && !TextUtils.isEmpty(listing.listingId))
                                {
                                    s.add(listing.listingId);
                                }
                            }
                        }
                    }
                }
            }

        }
        trackingdata.addKeyValuePair("itm", TextUtils.join(",", s));
        trackingdata.send(this);
    }
}
