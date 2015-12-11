// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.groupon.Channel;
import com.groupon.abtest.GoogleSignInAbTestHelper;
import com.groupon.activity.FacebookAppUtils;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.Login;
import com.groupon.dogfood.DogfoodHelper;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.models.error.GrouponException;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.models.nst.GoogleSmartLockExtraInfo;
import com.groupon.models.nst.LoginSignUpGenericExtraInfo;
import com.groupon.models.nst.NewsletterClickExtraInfo;
import com.groupon.models.signup.SignupResponse;
import com.groupon.models.signup.User;
import com.groupon.service.AttributionService;
import com.groupon.service.EmailSubscriptionsService;
import com.groupon.service.LoginService;
import com.groupon.service.SignUpService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.googlesmartlock.GoogleSmartLockService;
import com.groupon.sso.SSOHelper;
import com.groupon.sso.UserCredential;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.ContextUtils;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.LoginUtil;
import com.groupon.view.SpinnerButton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseSignUpFragment, TermsConditionsFragment

public class SignUpFragment extends BaseSignUpFragment
    implements TermsConditionsFragment.TermsConditionsListener
{
    private static class DisableSelectionForEditText
        implements android.view.ActionMode.Callback
    {

        public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
        {
            return false;
        }

        public boolean onCreateActionMode(ActionMode actionmode, Menu menu)
        {
            return false;
        }

        public void onDestroyActionMode(ActionMode actionmode)
        {
        }

        public boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
        {
            return false;
        }

        private DisableSelectionForEditText()
        {
        }

    }

    private class GoogleSmartLockOnCredentialsSavedCallback
        implements com.groupon.service.googlesmartlock.GoogleSmartLockService.OnCredentialsSavedCallback
    {

        final SignUpFragment this$0;

        public void onCredentialSaveCompleted(boolean flag)
        {
            String s;
            ClickMetadata clickmetadata;
            if (flag)
            {
                s = "google_smartlock_save_credentials_save_click";
            } else
            {
                s = "google_smartlock_save_credentials_no_click";
            }
            clickmetadata = new ClickMetadata();
            clickmetadata.pageId = getClass().getSimpleName();
            logger.logClick("", s, channelId, clickmetadata, new GoogleSmartLockExtraInfo(trigger));
            startNextActivityAndFinish();
        }

        private GoogleSmartLockOnCredentialsSavedCallback()
        {
            this$0 = SignUpFragment.this;
            super();
        }

    }


    private static final String AREA_ID = "areaId";
    private static final String CITY_NAME = "cityName";
    private static final String SIGNUP_TYPE = "signupType";
    private static final String SIGN_UP_TYPE_GOOGLE = "google";
    public static final String TAG = com/groupon/fragment/SignUpFragment.getName();
    private static final String TAndC = "T&C";
    private static final String USERS_URL_INTL = "/users?%s=%s";
    private static final String USERS_URL_US = "/users";
    private final String CLICK_TYPE_GOOGLE_SMARTLOCK_SAVE_CREDENTIALS_NO_CLICK = "google_smartlock_save_credentials_no_click";
    private final String CLICK_TYPE_GOOGLE_SMARTLOCK_SAVE_CREDENTIALS_SAVE_CLICK = "google_smartlock_save_credentials_save_click";
    private final String IMPRESSION_TYPE_GOOGLE_SMARTLOCK_SAVE_CREDENTIALS_MODAL = "google_smartlock_save_credentials_modal";
    private String areaId;
    private AttributionService attributionService;
    private String channelId;
    Button city;
    TextView contactUs;
    private CurrentDivisionManager currentDivisionManager;
    private String deviceId;
    private DeviceInfoUtil deviceInfoUtil;
    private DogfoodHelper dogfoodHelper;
    AutoCompleteTextView email;
    private EmailSubscriptionsService emailSubscriptionsService;
    SpinnerButton facebook;
    SpinnerButton google;
    private IntentFactory intentFactory;
    private boolean isCityDealCountry;
    private boolean isNewCheckoutFlow1408;
    private boolean isNewsletterOptInEnabled;
    private ArraySharedPreferences loginPrefs;
    private LoginSignUpGenericExtraInfo loginSignUpGenericExtraInfo;
    EditText name;
    CheckBox newsletterOptin;
    View orText;
    EditText password;
    EditText phoneNumber;
    private SharedPreferences prefs;
    private String referrer;
    private boolean showIHQ;
    private String signUpType;
    SpinnerButton submit;
    View subscriptionDisclaimer;
    private UserManager userManager;

    public SignUpFragment()
    {
    }

    public static String firstName(String s)
    {
        return Strings.toString(s).split("\\s+", 2)[0].trim();
    }

    private String getCountryErrorPrefix(boolean flag)
    {
        int i = ContextUtils.getIdentifier(getActivity(), (new StringBuilder()).append(((CurrentCountryManager)RoboGuice.getInjector(getActivity()).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager)).getCurrentCountry().isoName.toLowerCase()).append("_display_name").toString(), "string");
        String s;
        if (i == 0)
        {
            s = "";
        } else
        {
            s = getString(i);
        }
        if (flag)
        {
            return String.format(getString(0x7f08015a), new Object[] {
                s
            });
        } else
        {
            return String.format(getString(0x7f080159), new Object[] {
                s
            });
        }
    }

    private String getEmailText()
    {
        return Strings.toString(email.getText());
    }

    private String getLastNameText()
    {
        return lastName(Strings.toString(name.getText()));
    }

    private List getParams()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "first_name", getFirstNameText(), "last_name", getLastNameText(), "email_address", getEmailText(), "password", getPasswordText(), "referrer", referrer
        }));
        if (currentCountryManager.getCurrentCountry().needsPhoneNumberAtSignUp())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "phone_number", getPhoneNumberText()
            }));
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "device_id", deviceId
            }));
        } else
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "divisions[]", currentDivisionManager.getCurrentDivision().id
            }));
            boolean flag;
            if (newsletterOptin.getVisibility() == 0 && newsletterOptin.isChecked())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "subscribe_to_newsletter", Boolean.valueOf(flag)
            }));
            if (showIHQ)
            {
                arraylist.addAll(Arrays.asList(new Serializable[] {
                    "legalTermsAccepted", Boolean.valueOf(true)
                }));
            }
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                arraylist.addAll(Arrays.asList(new String[] {
                    "area_id", areaId
                }));
                return arraylist;
            }
        }
        return arraylist;
    }

    private String getPasswordText()
    {
        return Strings.toString(password.getText());
    }

    private String getPhoneNumberText()
    {
        return Strings.toString(phoneNumber.getText());
    }

    private String getUrl()
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            return "/users";
        } else
        {
            return String.format("/users?%s=%s", new Object[] {
                "lang", deviceInfoUtil.getLanguageFromLocale()
            });
        }
    }

    private void initializeCitySelector(Bundle bundle)
    {
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            city.setVisibility(8);
            return;
        }
        if (bundle != null)
        {
            areaId = bundle.getString("areaId");
            city.setText(bundle.getString("cityName"));
        } else
        {
            bundle = currentDivisionManager.getCurrentDivision().name;
            areaId = currentDivisionManager.getCurrentDivision().id;
            city.setText(bundle);
        }
        city.setVisibility(0);
        city.setOnClickListener(new android.view.View.OnClickListener() {

            final SignUpFragment this$0;

            public void onClick(View view)
            {
                getLoginRedesign().getCity();
            }

            
            {
                this$0 = SignUpFragment.this;
                super();
            }
        });
    }

    private boolean isCheckoutFlow1408()
    {
        return isComingFromCheckout != null && isComingFromCheckout.booleanValue() && isNewCheckoutFlow1408;
    }

    public static boolean isInvalidName(Editable editable)
    {
        return Strings.toString(editable).split("\\s+", 2).length < 2;
    }

    public static String lastName(String s)
    {
        s = Strings.toString(s).split("\\s+", 2);
        if (s.length >= 2)
        {
            return s[1].trim();
        } else
        {
            return "";
        }
    }

    private boolean onExceptionEvent(GrouponException grouponexception)
    {
        grouponexception = grouponexception.mapErrorFieldToErrorList;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            if (grouponexception != null && !grouponexception.isEmpty())
            {
                Object obj = (java.util.Map.Entry)grouponexception.entrySet().iterator().next();
                int i = ContextUtils.getIdentifier(getActivity(), (new StringBuilder()).append(((CurrentCountryManager)RoboGuice.getInjector(getActivity()).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager)).getCurrentCountry().isoName.toLowerCase()).append("_display_name").toString(), "string");
                StringBuilder stringbuilder;
                String s1;
                if (i == 0)
                {
                    grouponexception = "";
                } else
                {
                    grouponexception = getString(i);
                }
                grouponexception = String.format(getString(0x7f080159), new Object[] {
                    grouponexception
                });
                grouponexception = (new StringBuilder()).append(grouponexception).append("%s: %s").toString();
                stringbuilder = new StringBuilder();
                s1 = (String)((java.util.Map.Entry) (obj)).getKey();
                for (obj = ((Collection)((java.util.Map.Entry) (obj)).getValue()).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append(String.format(grouponexception, new Object[] {
    s1, (String)((Iterator) (obj)).next()
}))) { }
                Toast.makeText(getActivity().getApplicationContext(), stringbuilder.toString(), 1).show();
                return true;
            } else
            {
                return false;
            }
        }
        if (grouponexception != null && !grouponexception.isEmpty())
        {
            Object obj1 = (java.util.Map.Entry)grouponexception.entrySet().iterator().next();
            grouponexception = (new StringBuilder()).append(getCountryErrorPrefix(false)).append("%s: %s").toString();
            String s = (String)((java.util.Map.Entry) (obj1)).getKey();
            StringBuilder stringbuilder1 = new StringBuilder();
            for (obj1 = ((Collection)((java.util.Map.Entry) (obj1)).getValue()).iterator(); ((Iterator) (obj1)).hasNext(); stringbuilder1.append(String.format(grouponexception, new Object[] {
    s, (String)((Iterator) (obj1)).next()
}))) { }
            Toast.makeText(getActivity().getApplicationContext(), stringbuilder1.toString(), 1).show();
        } else
        {
            grouponexception = getCountryErrorPrefix(true);
            Toast.makeText(getActivity().getApplicationContext(), grouponexception, 1).show();
        }
        return true;
    }

    private void onSuccessEvent(SignupResponse signupresponse)
    {
        UserCredential usercredential = new UserCredential(getEmailText(), getPasswordText(), currentCountryManager.getCurrentCountry().isoName, getFirstNameText());
        SSOHelper.addOrUpdateAccountForApp(getActivity().getApplicationContext(), usercredential);
        userManager.updateUserDetails(signupresponse.user);
        if (!isCityDealCountry || !isNewsletterOptInEnabled || newsletterOptin.getVisibility() == 0 && newsletterOptin.isChecked())
        {
            emailSubscriptionsService.addEmailSubscription(getEmailText(), currentDivisionManager.getCurrentDivision(), null, null, null, null);
        }
        loginPrefs.edit().putString("firstName", getFirstNameText()).putString("lastName", getLastNameText()).putString("accessToken", signupresponse.accessToken).putLong("accessTokenConfigured", System.currentTimeMillis()).putString("userId", signupresponse.user.id).putString("referralCode", signupresponse.user.referralCode).apply();
        prefs.edit().putString("emailPrefill", getEmailText()).putBoolean("hasLoggedInAtleastOnce", true).apply();
        logger.forceLogRotate();
        Toast.makeText(getActivity().getApplicationContext(), 0x7f0803cd, 1).show();
        if (isGoogleSmartLock1511)
        {
            googleSmartLockService.setOnCredentialSavedCallback(new GoogleSmartLockOnCredentialsSavedCallback());
            googleSmartLockService.saveCredentialsToSmartLock(getEmailText(), getPasswordText(), loginService.getFullName());
            Object obj;
            String s;
            com.groupon.tracking.mobile.EncodedNSTField encodednstfield;
            if (channel != null)
            {
                signupresponse = channel.name();
            } else
            {
                signupresponse = Channel.UNKNOWN.name();
            }
            channelId = signupresponse;
            logger.logImpression("", "google_smartlock_save_credentials_modal", channelId, "", new GoogleSmartLockExtraInfo(getClass().getSimpleName(), trigger));
        } else
        {
            startNextActivityAndFinish();
        }
        logger.logSignUp("", attributionService.getAttributionCid(), attributionService.getAttributionId(), attributionService.getAttributionType(), attributionService.getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), attributionService.getAttributionDownloadId(), attributionService.getAttributionDownloadCid(), Logger.NULL_NST_FIELD);
        if (isCityDealCountry && isNewsletterOptInEnabled)
        {
            obj = logger;
            s = com/groupon/fragment/SignUpFragment.getSimpleName();
            encodednstfield = Logger.NULL_NST_FIELD;
            if (newsletterOptin.isChecked())
            {
                signupresponse = "opt-in";
            } else
            {
                signupresponse = "opt-out";
            }
            ((Logger) (obj)).logClick("", "newsletter_opt_check", s, encodednstfield, new NewsletterClickExtraInfo("newsletter", signupresponse));
        }
        obj = getLoginRedesign().getNext();
        if (obj != null)
        {
            signupresponse = ((Intent) (obj)).getStringExtra("flow");
        } else
        {
            signupresponse = "";
        }
        if (Strings.equals(signupresponse, "checkout"))
        {
            if (((Intent) (obj)).hasExtra("dealId"))
            {
                signupresponse = ((Intent) (obj)).getStringExtra("dealId");
            } else
            {
                signupresponse = "";
            }
            logger.logClick("", "signUp_click", "checkout", signupresponse);
        }
    }

    private void setupCASLContent()
    {
        boolean flag = currentCountryManager.getCurrentCountry().isCanada();
        View view = subscriptionDisclaimer;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        if (flag)
        {
            contactUs.setOnClickListener(new android.view.View.OnClickListener() {

                final SignUpFragment this$0;

                public void onClick(View view1)
                {
                    getActivity().startActivity(intentFactory.newGrouponSupportWithoutIdIntent());
                }

            
            {
                this$0 = SignUpFragment.this;
                super();
            }
            });
            contactUs.setVisibility(0);
            return;
        } else
        {
            contactUs.setVisibility(8);
            return;
        }
    }

    private void setupSubmitListeners()
    {
        submit.setOnClickListener(new android.view.View.OnClickListener() {

            final SignUpFragment this$0;

            public void onClick(View view)
            {
                ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(password.getWindowToken(), 0);
                if (!valid())
                {
                    return;
                } else
                {
                    logger.logClick("", "signUp_click", com/groupon/activity/Login.getSimpleName(), "");
                    signUpType = "grpn";
                    (new TermsConditionsFragment()).show(getActivity().getFragmentManager(), "T&C");
                    return;
                }
            }

            
            {
                this$0 = SignUpFragment.this;
                super();
            }
        });
        if (isNewCheckoutFlow1408)
        {
            password.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                final SignUpFragment this$0;

                public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                {
                    if (i == 6)
                    {
                        submit.performClick();
                    }
                    return false;
                }

            
            {
                this$0 = SignUpFragment.this;
                super();
            }
            });
        }
    }

    private void signUp()
    {
        submit.startSpinning();
        SignUpService signupservice = new SignUpService(getActivity(), getUrl(), getParams().toArray()) {

            final SignUpFragment this$0;

            protected void onException(Exception exception)
            {
                submit.stopSpinning();
                if ((exception instanceof GrouponException) && onExceptionEvent((GrouponException)exception))
                {
                    return;
                } else
                {
                    super.onException(exception);
                    return;
                }
            }

            protected void onSuccess(SignupResponse signupresponse)
            {
                submit.stopSpinning();
                onSuccessEvent(signupresponse);
            }

            transient 
            {
                this$0 = SignUpFragment.this;
                super(context, s, aobj);
            }
        };
        signupservice.method("POST");
        signupservice.execute();
    }

    private void startNextActivityAndFinish()
    {
        getActivity().setResult(-1);
        loginUtil.startNextActivity(getLoginRedesign().getNext());
        getActivity().finish();
    }

    private boolean valid()
    {
        if (isInvalidName(name.getText()))
        {
            name.setError(getString(0x7f080175));
            return false;
        }
        if (Strings.isEmpty(email.getText()))
        {
            email.setError(getString(0x7f08015f));
            return false;
        }
        if (Strings.isEmpty(password.getText()))
        {
            password.setError(getString(0x7f080195));
            return false;
        }
        if (currentCountryManager.getCurrentCountry().needsPhoneNumberAtSignUp() && Strings.isEmpty(phoneNumber.getText()))
        {
            phoneNumber.setError(getString(0x7f080198));
            return false;
        } else
        {
            return true;
        }
    }

    protected void disableSelectionForPasswordAndEmail()
    {
        DisableSelectionForEditText disableselectionforedittext = new DisableSelectionForEditText();
        email.setCustomSelectionActionModeCallback(disableselectionforedittext);
        password.setCustomSelectionActionModeCallback(disableselectionforedittext);
    }

    protected void facebookCleanUp()
    {
        facebook.stopSpinning();
        super.facebookCleanUp();
    }

    public void fbRequestNewReadPermission()
    {
        facebook.startSpinning();
        super.fbRequestNewReadPermission();
    }

    public void fbSignUp()
    {
        facebook.startSpinning();
        super.fbSignUp();
    }

    protected String getFirstNameText()
    {
        return firstName(Strings.toString(name.getText()));
    }

    public int getGoogleSignInRequestCode()
    {
        return 40001;
    }

    protected void googleCleanUp()
    {
        if (getActivity() != null)
        {
            getActivity().runOnUiThread(new Runnable() {

                final SignUpFragment this$0;

                public void run()
                {
                    google.stopSpinning();
                }

            
            {
                this$0 = SignUpFragment.this;
                super();
            }
            });
        }
        super.googleCleanUp();
    }

    public void googleSignUp()
    {
        google.startSpinning();
        super.googleSignUp();
    }

    public void onActivityCreated(Bundle bundle)
    {
        boolean flag = false;
        super.onActivityCreated(bundle);
        if (bundle != null)
        {
            signUpType = bundle.getString("signupType");
        }
        isCityDealCountry = currentCountryManager.getCurrentCountry().isCityDealCountry();
        Object obj;
        int i;
        boolean flag1;
        boolean flag2;
        if (currentCountryManager.getCurrentCountry().isNewsletterOptInEnabledCountry() && abTestService.isVariantEnabled("nLOptIn1403INTL", "on"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        isNewsletterOptInEnabled = flag1;
        if (getArguments() != null)
        {
            obj = getArguments().getString("discount");
        } else
        {
            obj = null;
        }
        if (getArguments() == null || getArguments().getBoolean("should_display_discount", true))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        setSignUpButtonText(((String) (obj)), flag1);
        flag1 = facebookAppUtils.isFacebookLoginAvailable();
        flag2 = googleSignInAbTestHelper.isGoogleLoginUSCA1508Enabled();
        dogfoodHelper.logHideViewId(0x7f1002ae);
        loginSignUpGenericExtraInfo.pageId = getClass().getSimpleName();
        setFacebookGoogleVisible(flag1, flag2);
        if (flag1)
        {
            facebook.setOnClickListener(new android.view.View.OnClickListener() {

                final SignUpFragment this$0;

                public void onClick(View view)
                {
                    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(password.getWindowToken(), 0);
                    logger.logClick("", "facebook_signup_click", com/groupon/activity/Login.getSimpleName(), "");
                    signUpType = "fb";
                    (new TermsConditionsFragment()).show(getActivity().getFragmentManager(), "T&C");
                }

            
            {
                this$0 = SignUpFragment.this;
                super();
            }
            });
        }
        if (flag2)
        {
            google.setOnClickListener(new android.view.View.OnClickListener() {

                final SignUpFragment this$0;

                public void onClick(View view)
                {
                    logger.logClick("", "google_signup_click", com/groupon/activity/Login.getSimpleName(), Logger.NULL_NST_FIELD, loginSignUpGenericExtraInfo);
                    signUpType = "google";
                    (new TermsConditionsFragment()).show(getActivity().getFragmentManager(), "T&C");
                }

            
            {
                this$0 = SignUpFragment.this;
                super();
            }
            });
        }
        obj = loginPrefs.getString("email", "");
        if (Strings.notEmpty(obj))
        {
            email.setText(((CharSequence) (obj)));
        }
        email.setAdapter(new ArrayAdapter(getActivity(), 0x109000a, userManager.getDeviceAndGrouponEmailAccounts()));
        obj = phoneNumber;
        if (currentCountryManager.getCurrentCountry().needsPhoneNumberAtSignUp())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((EditText) (obj)).setVisibility(i);
        initializeCitySelector(bundle);
        setupSubmitListeners();
        disableSelectionForPasswordAndEmail();
        showIHQ = Strings.notEmpty(loginUtil.getSignUpLegalFromJson());
        bundle = newsletterOptin;
        if (isCityDealCountry && isNewsletterOptInEnabled)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        bundle.setVisibility(i);
        if (currentCountryManager.getCurrentCountry().isIsrael())
        {
            newsletterOptin.setText(0x7f0803c3);
        }
        setupCASLContent();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 10154 && googleSmartLockService != null)
        {
            googleSmartLockService.handleSaveCredentialActivityResult(j);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        loginSignUpGenericExtraInfo = new LoginSignUpGenericExtraInfo();
        loginSignUpGenericExtraInfo.pageId = getClass().getSimpleName();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        int j;
        j = 0x7f0300ef;
        isNewCheckoutFlow1408 = currentCountryManager.getCurrentCountry().isUSACompatible();
        if (!googleSignInAbTestHelper.isGoogleLoginUSCA1508Top()) goto _L2; else goto _L1
_L1:
        int i = 0x7f0300f1;
_L4:
        layoutinflater = layoutinflater.inflate(i, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
_L2:
        i = j;
        if (!googleSignInAbTestHelper.isGoogleLoginUSCA1508Bottom())
        {
            i = j;
            if (isCheckoutFlow1408())
            {
                i = 0x7f0300f0;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onDestroyView()
    {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("signupType", signUpType);
        bundle.putString("areaId", areaId);
        bundle.putString("cityName", city.getText().toString());
    }

    public void onTermsConditionsAccepted()
    {
        if (signUpType.equals("grpn"))
        {
            signUp();
        } else
        {
            if (signUpType.equals("fb"))
            {
                fbSignUp();
                return;
            }
            if (signUpType.equals("google"))
            {
                googleSignUp();
                return;
            }
        }
    }

    public void setDivision(Division division)
    {
        if (division != null)
        {
            city.setText(division.name);
            areaId = division.id;
        }
    }

    public void setFacebookGoogleVisible(boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        int i;
        if (orText != null)
        {
            Object obj = orText;
            if (flag || flag1)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((View) (obj)).setVisibility(i);
        }
        obj = facebook;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((SpinnerButton) (obj)).setVisibility(i);
        obj = google;
        if (flag1)
        {
            i = ((flag2) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((SpinnerButton) (obj)).setVisibility(i);
    }

    public void setSignUpButtonText(final String buttonText, boolean flag)
    {
        if (isCheckoutFlow1408() && flag && Strings.notEmpty(buttonText))
        {
            buttonText = getString(0x7f0801d3, new Object[] {
                buttonText
            });
        } else
        {
            buttonText = getString(0x7f0801ce);
        }
        submit.setText(buttonText);
        submit.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final SignUpFragment this$0;
            final String val$buttonText;

            public void onGlobalLayout()
            {
                int i = submit.getPaddingLeft();
                int j = submit.getPaddingRight();
                i = submit.getWidth() - (i + j) - submit.getCompoundDrawables()[0].getIntrinsicWidth();
                j = Math.round(submit.getPaint().measureText(buttonText));
                if (i > 0 && i < j)
                {
                    submit.setText(0x7f0801ce);
                }
                submit.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }

            
            {
                this$0 = SignUpFragment.this;
                buttonText = s;
                super();
            }
        });
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (!flag)
        {
            return;
        }
        if (googleSignInAbTestHelper.isGoogleLoginUSCA1508Enabled())
        {
            logger.logImpression("", "google_signup_button", com/groupon/activity/Login.getSimpleName(), "", loginSignUpGenericExtraInfo);
        }
        logger.logPageView("", "signup_page", Logger.NULL_NST_FIELD);
    }



/*
    static String access$002(SignUpFragment signupfragment, String s)
    {
        signupfragment.signUpType = s;
        return s;
    }

*/







}
