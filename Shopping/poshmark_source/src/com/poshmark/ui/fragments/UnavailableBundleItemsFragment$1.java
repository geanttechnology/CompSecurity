// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.adapters.BundleListAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            UnavailableBundleItemsFragment

class val.position
    implements PMApiResponseHandler
{

    final UnavailableBundleItemsFragment this$0;
    final int val$position;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            unavailableBundleData.remove(val$position);
            pmapiresponse = new CustomMatrixCursor(new String[] {
                PMData.ID_COL, PMData.DATA_COL
            });
            UnavailableBundleItemsFragment.access$000(UnavailableBundleItemsFragment.this, pmapiresponse);
            adapter.changeCursor(pmapiresponse);
            adapter.notifyDataSetChanged();
            countChanged = true;
        }
    }

    ()
    {
        this$0 = final_unavailablebundleitemsfragment;
        val$position = I.this;
        super();
    }
}
