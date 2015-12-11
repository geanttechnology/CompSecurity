// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import com.poshmark.data_model.models.SearchResults;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            PartyFragment, PMFilterableFragment

class val.intent
    implements PMApiResponseHandler
{

    final PartyFragment this$0;
    final Intent val$intent;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded() && !pmapiresponse.hasError())
        {
            saveFacetLists(((SearchResults)pmapiresponse.data).getFacets());
            handleNotification(val$intent);
        }
    }

    ment()
    {
        this$0 = final_partyfragment;
        val$intent = Intent.this;
        super();
    }
}
