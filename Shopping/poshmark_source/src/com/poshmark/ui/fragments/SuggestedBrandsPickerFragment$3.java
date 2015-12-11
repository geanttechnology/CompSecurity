// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.TextView;
import com.poshmark.db.AllBrandsModel;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            SuggestedBrandsPickerFragment

class this._cls0
    implements PMApiResponseHandler
{

    final SuggestedBrandsPickerFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            retryButton.setVisibility(4);
            allBrandsModel = (AllBrandsModel)pmapiresponse.data;
            serverSuggestedBrandsCount = allBrandsModel.data.size();
            SuggestedBrandsPickerFragment.access$100(SuggestedBrandsPickerFragment.this);
            SuggestedBrandsPickerFragment.access$200(SuggestedBrandsPickerFragment.this);
            return;
        } else
        {
            pmapiresponse = new ActionErrorContext(pmapiresponse.apiError, null, null, com.poshmark.ui.model.);
            showError(pmapiresponse);
            retryButton.setVisibility(0);
            return;
        }
    }

    ()
    {
        this$0 = SuggestedBrandsPickerFragment.this;
        super();
    }
}
