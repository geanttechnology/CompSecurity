// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.os.Bundle;
import com.ebay.mobile.givingworks.GivingWorksFavoritesFragment;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.sell:
//            ListingFragmentActivity

public class GivingWorksFragment extends GivingWorksFavoritesFragment
    implements com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{

    public static String DRAFT_KEY_PARAMS = "keyParams";
    private ListingDraftDataManager dm;

    public GivingWorksFragment()
    {
    }

    protected void handleSelectionChanged(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
    {
        ((ListingFragmentActivity)getActivity()).setCharityChanged(true);
        dm.updateDonationEnabled(true, nonprofit.nonprofitId, nonprofit.name);
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initDataManagers();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        dm = (ListingDraftDataManager)datamanagercontainer.initialize((com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable(DRAFT_KEY_PARAMS), this);
    }

}
