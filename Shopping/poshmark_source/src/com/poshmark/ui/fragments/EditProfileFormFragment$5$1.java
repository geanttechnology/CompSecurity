// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.view.View;
import android.widget.Spinner;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMEditText;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.view_holders.EditProfileFormViewHolder;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            EditProfileFormFragment, SuggestedBrandsPickerFragment, FindFriendsFragment

class this._cls1
    implements PMApiResponseHandler
{

    final  this$1;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (!isAdded()) goto _L2; else goto _L1
_L1:
        hideProgressDialog();
        if (pmapiresponse.hasError())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if (!FeatureManager.getGlobalFeatureManager().isBrandsFollowOnSignupEnabled()) goto _L4; else goto _L3
_L3:
        pmapiresponse = (PMActivity)getActivity();
        if (pmapiresponse != null && pmapiresponse.isActivityInForeground())
        {
            pmapiresponse.launchFragment(null, com/poshmark/ui/fragments/SuggestedBrandsPickerFragment, null);
        }
_L2:
        return;
_L4:
        pmapiresponse = (PMActivity)getActivity();
        if (pmapiresponse == null || !pmapiresponse.isActivityInForeground()) goto _L2; else goto _L5
_L5:
        pmapiresponse.launchFragment(null, com/poshmark/ui/fragments/FindFriendsFragment, null);
        return;
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.text.UPDATE_USER_PROFILE, PMApplication.getContext().getString(0x7f060100)));
        return;
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/EditProfileFormFragment$5

/* anonymous class */
    class EditProfileFormFragment._cls5
        implements android.view.View.OnClickListener
    {

        final EditProfileFormFragment this$0;

        public void onClick(View view)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "create_profile_button_tapped", null);
            view = new HashMap();
            Object obj = (MetaItem)EditProfileFormFragment.access$200(EditProfileFormFragment.this).shoeSizeSpinner.getSelectedItem();
            if (obj != null)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_shoe_size_entered", null);
                obj = ((MetaItem) (obj)).getId();
                if (obj != null && !((String) (obj)).isEmpty())
                {
                    view.put("shoe_size", obj);
                }
            }
            obj = (MetaItem)EditProfileFormFragment.access$200(EditProfileFormFragment.this).dressSizeSpinner.getSelectedItem();
            if (obj != null)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_dress_size_entered", null);
                obj = ((MetaItem) (obj)).getId();
                if (obj != null && !((String) (obj)).isEmpty())
                {
                    view.put("dress_size", obj);
                }
            }
            obj = EditProfileFormFragment.access$200(EditProfileFormFragment.this).cityEditText.getText().toString();
            String s = EditProfileFormFragment.access$200(EditProfileFormFragment.this).websiteEditText.getText().toString();
            if (obj != null && !((String) (obj)).isEmpty())
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_mycity_entered", null);
                String as[] = ((String) (obj)).split(",");
                if (as != null && as.length > 1)
                {
                    view.put("state", as[as.length - 1]);
                    view.put("city", as[0]);
                } else
                {
                    view.put("city", obj);
                }
            }
            if (s != null && !s.isEmpty())
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_website_entered", null);
                view.put("website", s);
            }
            PMApi.setUserProfile(view, null, new EditProfileFormFragment._cls5._cls1());
        }

            
            {
                this$0 = EditProfileFormFragment.this;
                super();
            }
    }

}
