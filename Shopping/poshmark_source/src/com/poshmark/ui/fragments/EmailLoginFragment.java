// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
//            PMFragment

public class EmailLoginFragment extends PMFragment
{

    public static final int LOGIN_REQUEST_OK = 2;
    Button forgotPasswordButton;
    Button loginButton;
    PMEditText passwordEditText;
    PMEditText userHandleEditText;

    public EmailLoginFragment()
    {
    }

    protected boolean isFormValid()
    {
        String s1 = new String();
        String s = s1;
        if (!userHandleEditText.isValid())
        {
            s = (new StringBuilder()).append(s1).append(userHandleEditText.getValidatorString()).append("\n").toString();
        }
        s1 = s;
        if (!passwordEditText.isValid())
        {
            s1 = (new StringBuilder()).append(s).append(passwordEditText.getValidatorString()).append("\n").toString();
        }
        if (!s1.isEmpty())
        {
            showAlertMessage(getResources().getString(0x7f060148), s1);
            return false;
        } else
        {
            return true;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        userHandleEditText = (PMEditText)getView().findViewById(0x7f0c0105);
        passwordEditText = (PMEditText)getView().findViewById(0x7f0c0014);
        passwordEditText.setTypeface(Typeface.DEFAULT);
        passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
        loginButton = (Button)getView().findViewById(0x7f0c0106);
        loginButton.setOnClickListener(new android.view.View.OnClickListener() {

            final EmailLoginFragment this$0;

            public void onClick(View view)
            {
                onLoginClicked();
            }

            
            {
                this$0 = EmailLoginFragment.this;
                super();
            }
        });
        forgotPasswordButton = (Button)getView().findViewById(0x7f0c0107);
        forgotPasswordButton.setOnClickListener(new android.view.View.OnClickListener() {

            final EmailLoginFragment this$0;

            public void onClick(View view)
            {
                view = "https://www.poshmark.com/user/password/reset";
                if (userHandleEditText.getText().toString().length() > 0)
                {
                    view = (new StringBuilder()).append("https://www.poshmark.com/user/password/reset").append("?username=").append(userHandleEditText.getText().toString()).toString();
                }
                view = new Intent("android.intent.action.VIEW", Uri.parse(view));
                startActivity(view);
            }

            
            {
                this$0 = EmailLoginFragment.this;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        setTitle(0x7f060194);
        return layoutinflater.inflate(0x7f03003b, viewgroup, false);
    }

    void onLoginClicked()
    {
        if (!isFormValid())
        {
            return;
        }
        hideKeyboard();
        showProgressDialogWithMessage(getResources().getString(0x7f060193));
        HashMap hashmap = new HashMap();
        Object obj = DeepLinkUtils.getDeepLinkHash();
        if (((Map) (obj)).size() > 0)
        {
            hashmap.put("stack", MetricsTrackingUtils.getTrackingStackAsJson((Activity)getView().getContext()));
            Gson gson = (new GsonBuilder()).create();
            java.lang.reflect.Type type = (new TypeToken() {

                final EmailLoginFragment this$0;

            
            {
                this$0 = EmailLoginFragment.this;
                super();
            }
            }).getType();
            if (!(gson instanceof Gson))
            {
                obj = gson.toJson(obj, type);
            } else
            {
                obj = GsonInstrumentation.toJson((Gson)gson, obj, type);
            }
            hashmap.put("deeplinks", obj);
        }
        PMApi.pmLogin(userHandleEditText.getText().toString(), passwordEditText.getText().toString(), hashmap, new PMApiResponseHandler() {

            final EmailLoginFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
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
                        PMNotificationManager.fireNotification("com.poshmark.intents.LOGIN_COMPLETE");
                        Analytics.getInstance().trackEvent("email_login_screen", "user", "login", null);
                        finishActivity();
                    }
                    return;
                }
                if (pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_UNAUTHORIZED)
                {
                    showAlertMessage(null, PMApplication.getContext().getString(0x7f0600e0));
                    return;
                } else
                {
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.USER_LOGIN, PMApplication.getContext().getString(0x7f0600ef), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
                    return;
                }
            }

            
            {
                this$0 = EmailLoginFragment.this;
                super();
            }
        });
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "email_login_screen";
    }
}
