// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import com.poshmark.data_model.models.ListingSummaryCollection;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.SearchFilterModel;

// Referenced classes of package com.poshmark.ui.fragments:
//            ClosetFragment, PMFilterableFragment

class val.intent
    implements PMApiResponseHandler
{

    final ClosetFragment this$0;
    final Intent val$intent;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        hideProgressDialog();
        getFilterManager().getSearchModel().clearCount();
        if (isAdded() && !pmapiresponse.hasError())
        {
            saveFacetLists(((ListingSummaryCollection)pmapiresponse.data).getFacets());
            handleNotification(val$intent);
        }
    }

    nt()
    {
        this$0 = final_closetfragment;
        val$intent = Intent.this;
        super();
    }
}
