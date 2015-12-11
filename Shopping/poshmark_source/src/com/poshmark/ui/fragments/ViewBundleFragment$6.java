// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.adapters.BundleListAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMBundle;
import com.poshmark.data_model.models.PMData;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            ViewBundleFragment

class this._cls0
    implements PMApiResponseHandler
{

    final ViewBundleFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            bundleData = (PMBundle)pmapiresponse.data;
            unavailableBundleData = bundleData.removeUnavailableItems();
            pmapiresponse = new CustomMatrixCursor(new String[] {
                PMData.ID_COL, PMData.DATA_COL
            });
            bundleData.fillCursor(pmapiresponse);
            adapter.changeCursor(pmapiresponse);
            adapter.notifyDataSetChanged();
            ViewBundleFragment.access$000(ViewBundleFragment.this);
        }
    }

    ter()
    {
        this$0 = ViewBundleFragment.this;
        super();
    }
}
