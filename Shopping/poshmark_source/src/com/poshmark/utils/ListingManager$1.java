// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.ID;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;

// Referenced classes of package com.poshmark.utils:
//            ListingManager

class this._cls0
    implements PMApiResponseHandler
{

    final ListingManager this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            if (callingFragment.isAdded())
            {
                callingFragment.hideProgressDialog();
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                newListingId = (ID)pmapiresponse.data;
                listingId = newListingId.id;
                pmapiresponse = ListingManager.this;
                pmapiresponse.currentSentImageIndex = ((ListingManager) (pmapiresponse)).currentSentImageIndex + 1;
                ListingManager.access$000(ListingManager.this);
            }
            return;
        }
        ListingManager.access$200(ListingManager.this, ListingManager.access$100(ListingManager.this, pmapiresponse.apiError));
    }

    ()
    {
        this$0 = ListingManager.this;
        super();
    }
}
