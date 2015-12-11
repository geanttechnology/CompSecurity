// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.util.Log;
import com.poshmark.data_model.adapters.PinterestBoardListAdapter;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.meta_data.PinterestBoardList;
import com.poshmark.utils.meta_data.PinterestBoardPickerInfo;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PinterestBoardPickerFragment

class this._cls1
    implements com.poshmark.ui.customviews.toDismissListener
{

    final ctivity this$1;

    public void dialogDismissed()
    {
        ((PMContainerActivity)getActivity()).popTopNFragments(2, true);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/PinterestBoardPickerFragment$1

/* anonymous class */
    class PinterestBoardPickerFragment._cls1
        implements PMApiResponseHandler
    {

        final PinterestBoardPickerFragment this$0;

        public void handleResponse(PMApiResponse pmapiresponse)
        {
            if (!pmapiresponse.hasError())
            {
                Log.d("PinterestBoardPicker", pmapiresponse.responseString);
                pmapiresponse = (PinterestBoardList)pmapiresponse.data;
                if (pmapiresponse != null)
                {
                    pmapiresponse = pmapiresponse.getBoards();
                    data.allboards.clear();
                    data.setAllboards(pmapiresponse);
                    adapter.notifyDataSetChanged();
                    PinterestBoardPickerFragment.access$000(PinterestBoardPickerFragment.this);
                }
                hideProgressDialog();
                return;
            } else
            {
                showAutoHideProgressDialogWithMessage(getString(0x7f06022e), new PinterestBoardPickerFragment._cls1._cls1());
                return;
            }
        }

            
            {
                this$0 = PinterestBoardPickerFragment.this;
                super();
            }
    }

}
