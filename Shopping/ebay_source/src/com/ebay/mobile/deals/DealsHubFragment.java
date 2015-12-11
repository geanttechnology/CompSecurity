// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.home.departments.DepartmentContentAdapter;
import com.ebay.mobile.home.departments.DepartmentFragment;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.content.dm.UssDealsHistogramDataManager;
import com.ebay.nautilus.domain.data.UnifiedStream.SearchRefinement;
import com.ebay.nautilus.shell.app.DataManagerContainer;

public class DealsHubFragment extends DepartmentFragment
    implements com.ebay.nautilus.domain.content.dm.UssDealsHistogramDataManager.Observer
{

    public DealsHubFragment()
    {
    }

    public void onDealsHistogramChanged(UssDealsHistogramDataManager ussdealshistogramdatamanager, Content content)
    {
        if (!EbayErrorHandler.handleResultStatus(this, getId(), content.getStatus()))
        {
            return;
        }
        ussdealshistogramdatamanager = (SearchRefinement)content.getData();
        if (ussdealshistogramdatamanager != null && ((SearchRefinement) (ussdealshistogramdatamanager)).verticalCategoryHistogram != null)
        {
            contentAdapter.setDealsTaxonomy(((SearchRefinement) (ussdealshistogramdatamanager)).verticalCategoryHistogram);
        }
        ussdealshistogramdatamanager = UssContentsDataManager.getDealChannelKeyParams(null);
        contentDataManager = (UssContentsDataManager)getDataManagerContainer().initialize(ussdealshistogramdatamanager, this);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        datamanagercontainer.initialize(UssDealsHistogramDataManager.KEY, this);
    }
}
