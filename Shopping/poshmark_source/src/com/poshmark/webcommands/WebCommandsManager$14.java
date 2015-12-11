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

class val.command
    implements com.poshmark.utils.er._cls14
{

    final WebCommandsManager this$0;
    final WebCommand val$command;

    public void runOnUIThread(final Object id)
    {
        id = (String)val$command.parameters.get("id");
        if (id != null)
        {
            fragment.showProgressDialogWithMessage("Loading...");
            PMApi.getListingDetails(((String) (id)), new PMApiResponseHandler() {

                final WebCommandsManager._cls14 this$1;
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
                            com.poshmark.data_model.models.inner_models.Inventory.ListingStatus listingstatus = pmapiresponse.getListingStatus();
                            if (!((String) (obj)).equals(PMApplicationSession.GetPMSession().getUserId()) || listingstatus == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD)
                            {
                                break label0;
                            }
                            obj = new Bundle();
                            ((Bundle) (obj)).putBoolean("NEW_LISTING", false);
                            ((Bundle) (obj)).putString("ID", id);
                            parentActivity.launchFragmentInNewActivity(((Bundle) (obj)), com/poshmark/ui/fragments/ListingEditorFragment, pmapiresponse);
                        }
                        return;
                    }
                    fragment.showAlertMessage("", "Cannot edit Listing");
                }

            
            {
                this$1 = WebCommandsManager._cls14.this;
                id = s;
                super();
            }
            });
        }
    }

    _cls1.val.id()
    {
        this$0 = final_webcommandsmanager;
        val$command = WebCommand.this;
        super();
    }
}
