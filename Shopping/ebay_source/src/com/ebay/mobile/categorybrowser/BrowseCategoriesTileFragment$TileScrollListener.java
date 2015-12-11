// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.ebay.mobile.home.channels.ChannelDispatcher;
import com.ebay.nautilus.domain.data.EbayCategory;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            BrowseCategoriesTileFragment

public static class fragmentReference extends android.support.v7.widget.tener
{

    private final WeakReference fragmentReference;

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        BrowseCategoriesTileFragment browsecategoriestilefragment = (BrowseCategoriesTileFragment)fragmentReference.get();
        if (browsecategoriestilefragment != null && !browsecategoriestilefragment.isRemoving())
        {
            switch (i)
            {
            default:
                return;

            case 0: // '\0'
                break;
            }
            if (browsecategoriestilefragment.isTablet && browsecategoriestilefragment.isCategorySelected() && (recyclerview.getLayoutManager() instanceof LinearLayoutManager))
            {
                recyclerview = (LinearLayoutManager)recyclerview.getLayoutManager();
                i = recyclerview.findFirstCompletelyVisibleItemPosition();
                if (i != -1)
                {
                    recyclerview = ((RecyclerView) (recyclerview.findViewByPosition(i).getTag(0x7f100010)));
                    if (recyclerview instanceof EbayCategory)
                    {
                        recyclerview = (EbayCategory)recyclerview;
                        if (((EbayCategory) (recyclerview)).id != browsecategoriestilefragment.selectedCategoryId)
                        {
                            browsecategoriestilefragment.setSelectedCategory(recyclerview);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        for (recyclerview = (BrowseCategoriesTileFragment)fragmentReference.get(); recyclerview == null || recyclerview.isRemoving() || ((BrowseCategoriesTileFragment) (recyclerview)).channelFragmentDispatcher == null;)
        {
            return;
        }

        ChannelDispatcher channeldispatcher = ((BrowseCategoriesTileFragment) (recyclerview)).channelFragmentDispatcher;
        if (recyclerview.hasScrollOffset() || ((BrowseCategoriesTileFragment) (recyclerview)).isTablet && recyclerview.isCategorySelected())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        channeldispatcher.onScrollChanged(recyclerview, 0, i);
    }

    public (BrowseCategoriesTileFragment browsecategoriestilefragment)
    {
        fragmentReference = new WeakReference(browsecategoriestilefragment);
    }
}
