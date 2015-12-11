// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftOperation;
import com.ebay.nautilus.domain.net.api.lds.DeleteSavedListingDraftsRequest;
import com.ebay.nautilus.domain.net.api.lds.LdsRequestParams;
import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SavedListingDraftDataManager

private final class motorsDraftIds extends AsyncTask
{

    private final EbayCountry country;
    private final ArrayList draftIds;
    private final String iafToken;
    private final ArrayList motorsDraftIds;
    final SavedListingDraftDataManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (country != null && iafToken != null && (draftIds != null || motorsDraftIds != null)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        avoid = new LdsRequestParams(ListingDraftOperation.DELETE_SAVED_DRAFTS);
        avoid.iafToken = iafToken;
        avoid.site = country.site;
        if (draftIds != null && !draftIds.isEmpty())
        {
            DeleteSavedListingDraftsRequest deletesavedlistingdraftsrequest = new DeleteSavedListingDraftsRequest(avoid, draftIds);
            SavedListingDraftDataManager.access$700(SavedListingDraftDataManager.this, deletesavedlistingdraftsrequest);
        }
        if (motorsDraftIds == null || motorsDraftIds.isEmpty()) goto _L1; else goto _L3
_L3:
        avoid.site = EbaySite.MOTOR;
        avoid = new DeleteSavedListingDraftsRequest(avoid, motorsDraftIds);
        SavedListingDraftDataManager.access$800(SavedListingDraftDataManager.this, avoid);
        return null;
        avoid;
        return null;
    }

    public Q(EbayCountry ebaycountry, Authentication authentication, ArrayList arraylist, ArrayList arraylist1)
    {
        this$0 = SavedListingDraftDataManager.this;
        super();
        country = ebaycountry;
        if (authentication != null)
        {
            savedlistingdraftdatamanager = authentication.iafToken;
        } else
        {
            savedlistingdraftdatamanager = null;
        }
        iafToken = SavedListingDraftDataManager.this;
        draftIds = arraylist;
        motorsDraftIds = arraylist1;
    }
}
