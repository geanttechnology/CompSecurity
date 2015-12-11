// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import android.content.res.Resources;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.home.BrowseDepartmentFragment;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.content.dm.UssDealsHistogramDataManager;
import com.ebay.nautilus.domain.data.UnifiedStream.Category;
import com.ebay.nautilus.domain.data.UnifiedStream.CategoryHistogram;
import com.ebay.nautilus.domain.data.UnifiedStream.SearchRefinement;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BrowseDealsFragment extends BrowseDepartmentFragment
    implements com.ebay.nautilus.domain.content.dm.UssDealsHistogramDataManager.Observer
{

    protected List dealCategories;

    public BrowseDealsFragment()
    {
    }

    public void onDealsHistogramChanged(UssDealsHistogramDataManager ussdealshistogramdatamanager, Content content)
    {
        dealCategories = null;
        ussdealshistogramdatamanager = (SearchRefinement)content.getData();
        if (!EbayErrorHandler.handleResultStatus(this, getId(), content.getStatus()))
        {
            return;
        }
        spinnerSelections = new ArrayList();
        content = new com.ebay.mobile.home.BrowseDepartmentFragment.SpinnerSelection(false, null, getResources().getString(0x7f0701d8));
        spinnerSelections.add(content);
        int j = 0;
        int k = 0;
        int i = 0;
        if (((SearchRefinement) (ussdealshistogramdatamanager)).verticalCategoryHistogram != null)
        {
            content = ((SearchRefinement) (ussdealshistogramdatamanager)).verticalCategoryHistogram.iterator();
            do
            {
                k = i;
                if (!content.hasNext())
                {
                    break;
                }
                CategoryHistogram categoryhistogram = (CategoryHistogram)content.next();
                spinnerSelections.add(new com.ebay.mobile.home.BrowseDepartmentFragment.SpinnerSelection(false, categoryhistogram.category.id, categoryhistogram.category.name.content));
                k = j + 1;
                j = k;
                if (categoryhistogram.category.id.equals(currentDepartmentId))
                {
                    dealCategories = categoryhistogram.childCategoryHistogram;
                    i = k;
                    j = k;
                }
            } while (true);
        }
        if (dealCategories == null)
        {
            dealCategories = ((SearchRefinement) (ussdealshistogramdatamanager)).weeklyCategoryHistogram;
        }
        populateSelectionsSpinner(spinnerSelections, k);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        datamanagercontainer.initialize(UssDealsHistogramDataManager.KEY, this);
    }

    protected void refreshContents()
    {
        if (selectedSpinnerItem == null)
        {
            return;
        } else
        {
            getDataManagerContainer().initialize(UssContentsDataManager.getDealChannelKeyParams(selectedSpinnerItem.department), this);
            return;
        }
    }
}
