// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.refine.adapters.RefineOptionAdapter;
import com.ebay.mobile.search.refine.adapters.RefineSingleOptionAdapter;
import com.ebay.mobile.search.refine.types.AuctionFormat;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            CheckedDetailController

public class AuctionFormatRefinementController extends CheckedDetailController
{

    private int selectedIndex;

    public AuctionFormatRefinementController(SearchRefineFragment searchrefinefragment, ListView listview)
    {
        super(searchrefinefragment, listview, true);
        adapter = new RefineSingleOptionAdapter(searchrefinefragment.getActivity(), searchrefinefragment.auctionFormats);
    }

    public RefineOptionAdapter getAdapter()
    {
        return adapter;
    }

    public DetailMode getDetailMode()
    {
        return DetailMode.AUCTION_FORMAT;
    }

    public String getTitle()
    {
        return getString(0x7f070974);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        super.onItemClick(adapterview, view, i, l);
        unlockRefinements(new com.ebay.mobile.search.RefinementLocks.RefinementLockType[] {
            com.ebay.mobile.search.RefinementLocks.RefinementLockType.BUYINGFORMAT, com.ebay.mobile.search.RefinementLocks.RefinementLockType.BESTOFFER
        });
    }

    public void onResume()
    {
        super.onResume();
        refineFragment.trackingEventListener.onRefineAuctionType();
        selectedIndex = 0;
        AuctionFormat auctionformat = new AuctionFormat(getSearchParameters().buyingFormat, getSearchParameters().bestOfferOnly);
        for (int i = 0; i < refineFragment.auctionFormats.length; i++)
        {
            if (auctionformat.equals(refineFragment.auctionFormats[i]))
            {
                selectedIndex = i;
            }
        }

        setupListView(selectedIndex);
    }

    public void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
    }

    protected boolean update(AuctionFormat auctionformat)
    {
        return refineFragment.setBuyingFormat(auctionformat.auctionFormat, auctionformat.isBestOffer);
    }

    protected volatile boolean update(Object obj)
    {
        return update((AuctionFormat)obj);
    }
}
