// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMEditText;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfo;
import com.poshmark.utils.DeepLinkUtils;
import com.poshmark.utils.DeferredDeepLinkManager;
import com.poshmark.utils.FbDeferredDeepLinkManager;
import com.poshmark.utils.MetricsTrackingUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            SignupFormFragment, EditProfileFormFragment

class this._cls1 extends TypeToken
{

    final this._cls1 this$1;

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/SignupFormFragment$4

/* anonymous class */
    class SignupFormFragment._cls4
        implements android.view.View.OnClickListener
    {

        final SignupFormFragment this$0;

        public void onClick(View view)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "join_in_signup_clicked", null);
            if (!SignupFormFragment.access$500(SignupFormFragment.this)) goto _L2; else goto _L1
_L1:
            HashMap hashmap;
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            hashmap = new HashMap();
            hashmap.put("username", SignupFormFragment.access$600(SignupFormFragment.this).getText().toString());
            hashmap.put("password", SignupFormFragment.access$700(SignupFormFragment.this).getText().toString());
            hashmap.put("first_name", SignupFormFragment.access$800(SignupFormFragment.this).getText().toString());
            hashmap.put("last_name", SignupFormFragment.access$900(SignupFormFragment.this).getText().toString());
            hashmap.put("email", SignupFormFragment.access$1000(SignupFormFragment.this).getText().toString());
            hashmap.put("referral_code", SignupFormFragment.access$1100(SignupFormFragment.this).getText().toString());
            view = DeepLinkUtils.getDeepLinkHash();
            if (view.size() > 0)
            {
                hashmap.put("stack", MetricsTrackingUtils.getTrackingStackAsJson((Activity)getView().getContext()));
                Gson gson = (new GsonBuilder()).create();
                java.lang.reflect.Type type = (new SignupFormFragment._cls4._cls1()).getType();
                if (!(gson instanceof Gson))
                {
                    view = gson.toJson(view, type);
                } else
                {
                    view = GsonInstrumentation.toJson((Gson)gson, view, type);
                }
                hashmap.put("deeplinks", view);
            }
            if (!SignupFormFragment.access$1200(SignupFormFragment.this)) goto _L4; else goto _L3
_L3:
            hashmap.put("ext_access_token", SignupFormFragment.access$1300(SignupFormFragment.this));
            hashmap.put("ext_service_id", "fb");
            hashmap.put("ext_token_expr", SignupFormFragment.access$1400(SignupFormFragment.this));
_L6:
            view = null;
            if (SignupFormFragment.access$1600(SignupFormFragment.this))
            {
                view = ((BitmapDrawable)SignupFormFragment.access$200(SignupFormFragment.this).getDrawable()).getBitmap();
            }
            SignupFormFragment.access$1702(SignupFormFragment.this, true);
            PMApi.createNewUser(hashmap, view, new SignupFormFragment._cls4._cls2());
_L2:
            return;
_L4:
            if (SignupFormFragment.access$1500(SignupFormFragment.this))
            {
                hashmap.put("ext_access_token", SignupFormFragment.access$1300(SignupFormFragment.this));
                hashmap.put("ext_service_id", "gp");
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

            
            {
                this$0 = SignupFormFragment.this;
                super();
            }

        // Unreferenced inner class com/poshmark/ui/fragments/SignupFormFragment$4$2

/* anonymous class */
        class SignupFormFragment._cls4._cls2
            implements PMApiResponseHandler
        {

            final SignupFormFragment._cls4 this$1;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    SignupFormFragment.access$1702(this$0, false);
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        FbDeferredDeepLinkManager.INSTANCE.markAsExpired();
                        DeferredDeepLinkManager.INSTANCE.markAsExpired();
                        pmapiresponse = (UserInfo)pmapiresponse.data;
                        PMApplicationSession.GetPMSession().saveSession(pmapiresponse);
                        SignupFormFragment.access$1800(this$0);
                        PMNotificationManager.fireNotification("com.poshmark.intents.LOGIN_COMPLETE");
                        SignupFormFragment.access$1902(this$0, true);
                        pmapiresponse = (PMActivity)getActivity();
                        if (pmapiresponse.isActivityInForeground())
                        {
                            Bundle bundle = new Bundle();
                            bundle.putInt("MODE", EditProfileFormFragment.PROFILE_MODE.PROFILE_MODE_CREATE.ordinal());
                            pmapiresponse.launchFragment(bundle, com/poshmark/ui/fragments/EditProfileFormFragment, null);
                        }
                    }
                    return;
                }
                if (pmapiresponse.apiError.pmErrorType == PMErrorType.USERNAME_TAKEN_ERROR)
                {
                    showAlertMessage(null, PMApplication.getContext().getString(0x7f060102));
                    return;
                }
                if (pmapiresponse.apiError.pmErrorType == PMErrorType.EMAIL_TAKEN)
                {
                    showAlertMessage(null, PMApplication.getContext().getString(0x7f0600da));
                    return;
                }
                if (pmapiresponse.apiError.pmErrorType == PMErrorType.INVALID_REFERRAL_CODE)
                {
                    showAlertMessage(null, PMApplication.getContext().getString(0x7f0600e1));
                    return;
                } else
                {
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.USER_SIGNUP, PMApplication.getContext().getString(0x7f0600d7), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
                    return;
                }
            }

                    
                    {
                        this$1 = SignupFormFragment._cls4.this;
                        super();
                    }
        }

    }

}
