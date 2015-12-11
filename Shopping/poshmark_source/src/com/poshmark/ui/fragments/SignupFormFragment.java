// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kochava.android.tracker.Feature;
import com.mobileapptracker.MobileAppTracker;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMEditText;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfo;
import com.poshmark.utils.DeepLinkUtils;
import com.poshmark.utils.DeferredDeepLinkManager;
import com.poshmark.utils.FbDeferredDeepLinkManager;
import com.poshmark.utils.MetricsTrackingUtils;
import com.poshmark.utils.ViewUtils;
import java.util.HashMap;
import java.util.Map;
import net.singular.sdk.Singular;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, MappPageFragment, EditProfileFormFragment, CameraPreviewFragment, 
//            EmailLoginFragment

public class SignupFormFragment extends PMFragment
{

    private int SELECT_PICTURE;
    private ImageView avataar;
    private Uri avataarImageFile;
    private boolean creationInProgress;
    private String email;
    private PMEditText emailEditText;
    private String exprDate;
    private String externalToken;
    private String fbUserId;
    private String firstName;
    private PMEditText firstNameEditText;
    private String googleAvataarUrl;
    private String googleUserId;
    private int imageHeight;
    private int imageWidth;
    private PMEditText inviteCodeEditText;
    private boolean isAvtaarImageSet;
    private boolean isFbSignup;
    private boolean isGoogleSignup;
    private String lastName;
    private PMEditText lastNameEditText;
    private PMEditText passwordEditText;
    private PMTextView signInButton;
    private TextView tosTextView;
    private boolean userCreated;
    private PMEditText userNameEditText;

    public SignupFormFragment()
    {
        SELECT_PICTURE = 1;
        isAvtaarImageSet = false;
        userCreated = false;
        creationInProgress = false;
        isFbSignup = false;
        isGoogleSignup = false;
        imageHeight = 0;
        imageWidth = 0;
    }

    private void displayForm()
    {
        firstNameEditText = (PMEditText)getView().findViewById(0x7f0c0100);
        lastNameEditText = (PMEditText)getView().findViewById(0x7f0c0101);
        emailEditText = (PMEditText)getView().findViewById(0x7f0c00ff);
        passwordEditText = (PMEditText)getView().findViewById(0x7f0c0102);
        passwordEditText.setTypeface(Typeface.DEFAULT);
        passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
        userNameEditText = (PMEditText)getView().findViewById(0x7f0c02df);
        inviteCodeEditText = (PMEditText)getView().findViewById(0x7f0c02e0);
        signInButton = (PMTextView)getView().findViewById(0x7f0c02d8);
        String s = getResources().getString(0x7f06029a);
        String s2 = getResources().getString(0x7f060299);
        String s3 = getResources().getString(0x7f06021d);
        SpannableStringBuilder spannablestringbuilder1 = new SpannableStringBuilder(s);
        int i = s.indexOf(s2);
        int k = s2.length();
        spannablestringbuilder1.setSpan(new ClickableSpan() {

            final SignupFormFragment this$0;

            public void onClick(View view)
            {
                launchUrl("/mapp/terms_and_conditions", "terms_and_conditions_screen");
            }

            
            {
                this$0 = SignupFormFragment.this;
                super();
            }
        }, i, i + k, 0);
        i = s.indexOf(s3);
        k = s3.length();
        spannablestringbuilder1.setSpan(new ClickableSpan() {

            final SignupFormFragment this$0;

            public void onClick(View view)
            {
                launchUrl("/mapp/privacy_policy", "privacy_policy_screen");
            }

            
            {
                this$0 = SignupFormFragment.this;
                super();
            }
        }, i, i + k, 0);
        tosTextView = (TextView)getView().findViewById(0x7f0c02e2);
        tosTextView.setMovementMethod(LinkMovementMethod.getInstance());
        tosTextView.setText(spannablestringbuilder1, android.widget.TextView.BufferType.SPANNABLE);
        if (firstName != null)
        {
            firstNameEditText.setText(firstName);
        }
        if (lastName != null)
        {
            lastNameEditText.setText(lastName);
        }
        if (email != null)
        {
            emailEditText.setText(email);
        }
        avataar = (ImageView)getView().findViewById(0x7f0c00fe);
        if (isAvtaarImageSet) goto _L2; else goto _L1
_L1:
        if (!isFbSignup) goto _L4; else goto _L3
_L3:
        ViewUtils.loadFbAvataar(fbUserId, avataar);
_L6:
        avataar.setOnClickListener(new android.view.View.OnClickListener() {

            final SignupFormFragment this$0;

            public void onClick(View view)
            {
                imageHeight = avataar.getHeight();
                imageWidth = avataar.getWidth();
                view = new Intent((PMActivity)getActivity(), com/poshmark/ui/PMContainerActivity);
                view.putExtra("FRAGMENT", com/poshmark/ui/fragments/CameraPreviewFragment);
                Bundle bundle = new Bundle();
                bundle.putInt("CREATION_MODE", CameraPreviewFragment.CREATE_COVERSHOT);
                view.putExtra("FRAGMENT_DATA", bundle);
                startActivityForResult(view, SELECT_PICTURE);
            }

            
            {
                this$0 = SignupFormFragment.this;
                super();
            }
        });
        ((Button)getView().findViewById(0x7f0c02e1)).setOnClickListener(new android.view.View.OnClickListener() {

            final SignupFormFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "join_in_signup_clicked", null);
                if (!isFormValid()) goto _L2; else goto _L1
_L1:
                HashMap hashmap;
                showProgressDialogWithMessage(getResources().getString(0x7f060190));
                hashmap = new HashMap();
                hashmap.put("username", userNameEditText.getText().toString());
                hashmap.put("password", passwordEditText.getText().toString());
                hashmap.put("first_name", firstNameEditText.getText().toString());
                hashmap.put("last_name", lastNameEditText.getText().toString());
                hashmap.put("email", emailEditText.getText().toString());
                hashmap.put("referral_code", inviteCodeEditText.getText().toString());
                view = DeepLinkUtils.getDeepLinkHash();
                if (view.size() > 0)
                {
                    hashmap.put("stack", MetricsTrackingUtils.getTrackingStackAsJson((Activity)getView().getContext()));
                    Gson gson = (new GsonBuilder()).create();
                    java.lang.reflect.Type type = (new TypeToken() {

                        final _cls4 this$1;

            
            {
                this$1 = _cls4.this;
                super();
            }
                    }).getType();
                    if (!(gson instanceof Gson))
                    {
                        view = gson.toJson(view, type);
                    } else
                    {
                        view = GsonInstrumentation.toJson((Gson)gson, view, type);
                    }
                    hashmap.put("deeplinks", view);
                }
                if (!isFbSignup) goto _L4; else goto _L3
_L3:
                hashmap.put("ext_access_token", externalToken);
                hashmap.put("ext_service_id", "fb");
                hashmap.put("ext_token_expr", exprDate);
_L6:
                view = null;
                if (isAvtaarImageSet)
                {
                    view = ((BitmapDrawable)avataar.getDrawable()).getBitmap();
                }
                creationInProgress = true;
                PMApi.createNewUser(hashmap, view, new PMApiResponseHandler() {

                    final _cls4 this$1;

                    public void handleResponse(PMApiResponse pmapiresponse)
                    {
label0:
                        {
                            creationInProgress = false;
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
                                fireTrackingCalls();
                                PMNotificationManager.fireNotification("com.poshmark.intents.LOGIN_COMPLETE");
                                userCreated = true;
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
                this$1 = _cls4.this;
                super();
            }
                });
_L2:
                return;
_L4:
                if (isGoogleSignup)
                {
                    hashmap.put("ext_access_token", externalToken);
                    hashmap.put("ext_service_id", "gp");
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = SignupFormFragment.this;
                super();
            }
        });
        signInButton = (PMTextView)getView().findViewById(0x7f0c02d8);
        signInButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SignupFormFragment this$0;

            public void onClick(View view)
            {
                ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/EmailLoginFragment, null);
            }

            
            {
                this$0 = SignupFormFragment.this;
                super();
            }
        });
        String s1 = getString(0x7f060103);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s1);
        String s4 = getString(0x7f060296);
        int j = s1.indexOf(s4);
        int l = s4.length();
        spannablestringbuilder.setSpan(new ClickableSpan() {

            final SignupFormFragment this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = SignupFormFragment.this;
                super();
            }
        }, j, j + l, 0);
        signInButton.setMovementMethod(LinkMovementMethod.getInstance());
        signInButton.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
        return;
_L4:
        if (isGoogleSignup)
        {
            ViewUtils.loadGooglePlusAvataar(googleAvataarUrl, avataar);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        Object obj = new android.graphics.BitmapFactory.Options();
        obj.inMutable = true;
        obj = BitmapFactoryInstrumentation.decodeFile(avataarImageFile.getPath(), ((android.graphics.BitmapFactory.Options) (obj)));
        avataar.setImageBitmap(((android.graphics.Bitmap) (obj)));
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void fireTrackingCalls()
    {
        String s;
        String s1;
        String s2;
        if (isFbSignup)
        {
            s2 = "facebook_sign_up_screen";
            s = "facebook_signup";
            s1 = "signup_type/facebook";
        } else
        if (isGoogleSignup)
        {
            s2 = "google_sign_up_screen";
            s = "gp_signup";
            s1 = "signup_type/googlePlus";
        } else
        {
            s2 = "email_sign_up_screen";
            s = "email_signup";
            s1 = "signup_type/email";
        }
        Analytics.getInstance().trackEvent(s2, "user", s, s1);
        if (PMApplication.getHasOffersObject() != null)
        {
            PMApplication.getHasOffersObject().setUserId(PMApplicationSession.GetPMSession().getUserId());
            PMApplication.getHasOffersObject().measureAction("signup");
        }
        PMApplication.getKochavaTracker().event("signup", "");
        Singular.setCustomUserId(PMApplicationSession.GetPMSession().getUserId());
        Singular.trackEvent("signup", PMApplicationSession.GetPMSession().getUserId());
        AppEventsLogger.newLogger(getActivity()).logEvent("signup");
    }

    private boolean isFormValid()
    {
        String s2;
label0:
        {
            s2 = new String();
            String s = s2;
            if (!userNameEditText.isValid())
            {
                s = (new StringBuilder()).append(s2).append(userNameEditText.getValidatorString()).append("\n").toString();
            }
            s2 = s;
            if (!emailEditText.isValid())
            {
                s2 = (new StringBuilder()).append(s).append(emailEditText.getValidatorString()).append("\n").toString();
            }
            s = s2;
            if (!passwordEditText.isValid())
            {
                s = (new StringBuilder()).append(s2).append(passwordEditText.getValidatorString()).append("\n").toString();
            }
            if (firstNameEditText.isValid())
            {
                s2 = s;
                if (lastNameEditText.isValid())
                {
                    break label0;
                }
            }
            s2 = (new StringBuilder()).append(s).append(firstNameEditText.getValidatorString()).append("\n").toString();
        }
        String s1 = s2;
        if (!isAvtaarImageSet)
        {
            s1 = s2;
            if (!isFbSignup)
            {
                s1 = s2;
                if (!isGoogleSignup)
                {
                    s1 = (new StringBuilder()).append(s2).append(getResources().getString(0x7f060278)).toString();
                }
            }
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

    private void launchUrl(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("URL", (new StringBuilder()).append("https://www.poshmark.com").append(s).toString());
        bundle.putString("ANALYTICS_PAGE_NAME", s1);
        ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/MappPageFragment, null);
    }

    public boolean handleBack()
    {
        FbHelper.getInstance().logout();
        return false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle != null)
        {
            isAvtaarImageSet = bundle.getBoolean("IS_IMAGE_SET");
            if (isAvtaarImageSet)
            {
                avataarImageFile = Uri.parse(bundle.getString("IMAGE_FILE"));
            }
        }
        displayForm();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == -1 && i == SELECT_PICTURE)
        {
            avataarImageFile = (Uri)intent.getExtras().getParcelable("IMAGE_FILE_URI");
            intent = new android.graphics.BitmapFactory.Options();
            intent.inMutable = true;
            intent = BitmapFactoryInstrumentation.decodeFile(avataarImageFile.getPath(), intent);
            avataar.setImageBitmap(intent);
            isAvtaarImageSet = true;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            firstName = getArguments().getString("FIRST_NAME");
            lastName = getArguments().getString("LAST_NAME");
            email = getArguments().getString("EMAIL");
            isFbSignup = getArguments().getBoolean("FB_SIGNUP", false);
            if (isFbSignup)
            {
                exprDate = getArguments().getString("EXPIRY_DATE");
                fbUserId = getArguments().getString("USERID");
                externalToken = getArguments().getString("TOKEN");
            }
            isGoogleSignup = getArguments().getBoolean("GOOGLE_SIGNUP", false);
            if (isGoogleSignup)
            {
                googleUserId = getArguments().getString("USERID");
                externalToken = getArguments().getString("TOKEN");
                googleAvataarUrl = getArguments().getString("GOOGLE_AVATAAR_URL", null);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        setTitle(0x7f060276);
        return layoutinflater.inflate(0x7f0300be, viewgroup, false);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        userCreated = false;
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (userCreated)
        {
            PMActivity pmactivity = (PMActivity)getActivity();
            Bundle bundle = new Bundle();
            bundle.putInt("MODE", EditProfileFormFragment.PROFILE_MODE.PROFILE_MODE_CREATE.ordinal());
            pmactivity.launchFragment(bundle, com/poshmark/ui/fragments/EditProfileFormFragment, null);
        } else
        if (creationInProgress)
        {
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (isAvtaarImageSet)
        {
            bundle.putString("IMAGE_FILE", avataarImageFile.toString());
            bundle.putBoolean("IS_IMAGE_SET", true);
        }
    }

    public void setViewNameForAnalytics()
    {
        if (externalToken != null && externalToken.length() > 0)
        {
            viewNameForAnalytics = "facebook_sign_up_screen";
            return;
        } else
        {
            viewNameForAnalytics = "email_sign_up_screen";
            return;
        }
    }




/*
    static int access$102(SignupFormFragment signupformfragment, int i)
    {
        signupformfragment.imageHeight = i;
        return i;
    }

*/








/*
    static boolean access$1702(SignupFormFragment signupformfragment, boolean flag)
    {
        signupformfragment.creationInProgress = flag;
        return flag;
    }

*/



/*
    static boolean access$1902(SignupFormFragment signupformfragment, boolean flag)
    {
        signupformfragment.userCreated = flag;
        return flag;
    }

*/



/*
    static int access$302(SignupFormFragment signupformfragment, int i)
    {
        signupformfragment.imageWidth = i;
        return i;
    }

*/






}
