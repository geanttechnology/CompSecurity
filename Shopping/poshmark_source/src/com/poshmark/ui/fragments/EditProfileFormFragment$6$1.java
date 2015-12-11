// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.ui.customviews.PMEditText;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.view_holders.EditProfileFormViewHolder;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            EditProfileFormFragment

class this._cls1
    implements PMApiResponseHandler
{

    final  this$1;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            if (isAdded())
            {
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                PMApi.getUserProfile(PMApplicationSession.GetPMSession().getUserId(), new PMApiResponseHandler() {

                    final EditProfileFormFragment._cls6._cls1 this$2;

                    public void handleResponse(PMApiResponse pmapiresponse1)
                    {
label0:
                        {
                            if (isAdded())
                            {
                                hideProgressDialog();
                                if (pmapiresponse1.hasError())
                                {
                                    break label0;
                                }
                                pmapiresponse1 = (UserInfoDetails)pmapiresponse1.data;
                                PMApplicationSession.GetPMSession().updateUserInfo(pmapiresponse1);
                                pmapiresponse1 = (PMActivity)getActivity();
                                profileUpdated = true;
                                pmapiresponse1.onBackPressed();
                            }
                            return;
                        }
                        showError(new ActionErrorContext(pmapiresponse1.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_USER_PROFILE, PMApplication.getContext().getString(0x7f0600eb)));
                    }

            
            {
                this$2 = EditProfileFormFragment._cls6._cls1.this;
                super();
            }
                });
            }
            return;
        }
        hideProgressDialog();
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.text.UPDATE_USER_PROFILE, PMApplication.getContext().getString(0x7f060100)));
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/EditProfileFormFragment$6

/* anonymous class */
    class EditProfileFormFragment._cls6
        implements android.view.View.OnClickListener
    {

        final EditProfileFormFragment this$0;

        public void onClick(View view)
        {
            if (EditProfileFormFragment.access$300(EditProfileFormFragment.this))
            {
                showProgressDialogWithMessage("Updating...");
                HashMap hashmap = new HashMap();
                view = EditProfileFormFragment.access$200(EditProfileFormFragment.this).cityEditText.getText().toString();
                if (view != null && !view.isEmpty())
                {
                    String as[] = view.split(",");
                    if (as != null && as.length > 1)
                    {
                        hashmap.put("state", as[as.length - 1]);
                        hashmap.put("city", as[0]);
                    } else
                    {
                        hashmap.put("city", view);
                        hashmap.put("state", "");
                    }
                } else
                {
                    hashmap.put("city", "");
                    hashmap.put("state", "");
                }
                if (EditProfileFormFragment.access$200(EditProfileFormFragment.this).websiteEditText.length() > 0)
                {
                    hashmap.put("website", EditProfileFormFragment.access$200(EditProfileFormFragment.this).websiteEditText.getText().toString());
                } else
                {
                    hashmap.put("website", "");
                }
                hashmap.put("first_name", EditProfileFormFragment.access$200(EditProfileFormFragment.this).firstNameEditText.getText().toString());
                hashmap.put("last_name", EditProfileFormFragment.access$200(EditProfileFormFragment.this).lastNameEditText.getText().toString());
                hashmap.put("email", EditProfileFormFragment.access$200(EditProfileFormFragment.this).emailEditText.getText().toString());
                view = null;
                if (EditProfileFormFragment.access$400(EditProfileFormFragment.this))
                {
                    view = ((BitmapDrawable)EditProfileFormFragment.access$200(EditProfileFormFragment.this).avataarImageView.getDrawable()).getBitmap();
                }
                PMApi.setUserProfile(hashmap, view, new EditProfileFormFragment._cls6._cls1());
            }
        }

            
            {
                this$0 = EditProfileFormFragment.this;
                super();
            }
    }

}
