// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            PinterestBoardPickerFragment, PMFragment

class val.json
    implements PMApiResponseHandler
{

    final PinterestBoardPickerFragment this$0;
    final String val$json;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        Log.d("PinterestBoardPicker", pmapiresponse.responseString);
        pmapiresponse = (PMFragment)getTargetFragment();
        if (pmapiresponse != null)
        {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("DATA_SELECTED", val$json);
            intent.putExtra("RETURNED_RESULTS", bundle);
            pmapiresponse.onActivityResult(mode, -1, intent);
            pmapiresponse = getActivity();
            hideProgressDialog();
            if (pmapiresponse != null)
            {
                pmapiresponse.onBackPressed();
            }
        }
    }

    ()
    {
        this$0 = final_pinterestboardpickerfragment;
        val$json = String.this;
        super();
    }
}
