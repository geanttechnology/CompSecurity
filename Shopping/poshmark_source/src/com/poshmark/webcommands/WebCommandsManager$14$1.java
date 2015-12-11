// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.os.Bundle;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.ListingEditorFragment;
import com.poshmark.ui.fragments.MappPageFragment;
import java.util.Map;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager, WebCommand

class val.id
    implements PMApiResponseHandler
{

    final ertMessage this$1;
    final String val$id;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            fragment.hideProgressDialog();
            if (!pmapiresponse.hasError())
            {
                pmapiresponse = (ListingDetails)pmapiresponse.data;
                Object obj = pmapiresponse.getUserId();
                com.poshmark.data_model.models.inner_models._19_ _l19_ = pmapiresponse.getListingStatus();
                if (!((String) (obj)).equals(PMApplicationSession.GetPMSession().getUserId()) || _l19_ == com.poshmark.data_model.models.inner_models.SOLD)
                {
                    break label0;
                }
                obj = new Bundle();
                ((Bundle) (obj)).putBoolean("NEW_LISTING", false);
                ((Bundle) (obj)).putString("ID", val$id);
                parentActivity.launchFragmentInNewActivity(((Bundle) (obj)), com/poshmark/ui/fragments/ListingEditorFragment, pmapiresponse);
            }
            return;
        }
        fragment.showAlertMessage("", "Cannot edit Listing");
    }

    l.command()
    {
        this$1 = final_command;
        val$id = String.this;
        super();
    }

    // Unreferenced inner class com/poshmark/webcommands/WebCommandsManager$14

/* anonymous class */
    class WebCommandsManager._cls14
        implements com.poshmark.utils.UIThreadTask.Callback
    {

        final WebCommandsManager this$0;
        final WebCommand val$command;

        public void runOnUIThread(Object obj)
        {
            obj = (String)command.parameters.get("id");
            if (obj != null)
            {
                fragment.showProgressDialogWithMessage("Loading...");
                PMApi.getListingDetails(((String) (obj)), ((WebCommandsManager._cls14._cls1) (obj)). new WebCommandsManager._cls14._cls1());
            }
        }

            
            {
                this$0 = final_webcommandsmanager;
                command = WebCommand.this;
                super();
            }
    }

}
