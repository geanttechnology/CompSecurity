// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.app.ModalProgressFragment;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.analytics.MimsUtil;
import com.ebay.common.model.UserDetail;
import com.ebay.common.net.api.coupon.IssueIncentiveResponse;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.crashlytics.CrashlyticsWrapper;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.notifications.EbayNotificationManager;
import com.ebay.mobile.service.PreferenceSyncService;
import com.ebay.mobile.signin.InstantiateGuidLoader;
import com.ebay.mobile.signin.SignInNetLoader;
import com.ebay.mobile.sitespeed.SiteSpeedActivityUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.ThreatMatrixDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.SiteSpeedData;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import com.ebay.server_requests.InstallTracking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseFragment, BaseActivity, eBay, ShowWebViewActivity, 
//            RegisterFragment

public class SignInModalFragment extends BaseFragment
    implements android.content.DialogInterface.OnCancelListener, TextWatcher, android.view.View.OnClickListener, android.view.View.OnFocusChangeListener, android.view.View.OnKeyListener, android.view.View.OnTouchListener, android.widget.AdapterView.OnItemClickListener, android.widget.TextView.OnEditorActionListener, DialogFragmentCallback, com.ebay.nautilus.domain.content.dm.ThreatMatrixDataManager.Observer
{
    private class AddressDataManagerObserver extends com.ebay.nautilus.domain.content.dm.AddressDataManager.SimpleObserver
    {

        final SignInModalFragment this$0;

        public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
        {
            for (addressdatamanager = getActivity(); addressdatamanager == null || addressdatamanager.isFinishing() || !signInComplete || userContextDataManger.getCurrentUser() == null;)
            {
                return;
            }

            ResultStatus resultstatus = content.getStatus();
            content = (List)content.getData();
            if ((resultstatus.hasError() || content == null) && userDetail != null)
            {
                com.ebay.common.model.UserDetail.Address address = userDetail.registrationAddress;
                Intent intent = new Intent(addressdatamanager, com/ebay/mobile/service/PreferenceSyncService);
                intent.putExtra("countryCode", address.country);
                intent.putExtra("postalCode", address.postalCode);
                intent.putExtra("stateOrProvince", address.stateOrProvince);
                intent.setAction("com.ebay.mobile.service.PreferenceSyncService.updatePrefsPrimaryAddress");
                addressdatamanager.startService(intent);
            }
            BaseCheckoutActivity.handleDefaultAddressChange(addressdatamanager, userContextDataManger, content, true, "Sign In");
            showIncentiveOrFinish(incentiveResponse);
        }

        private AddressDataManagerObserver()
        {
            this$0 = SignInModalFragment.this;
            super();
        }

    }

    private final class ErrorHandler extends EbayErrorHandler
    {

        final SignInModalFragment this$0;

        protected void onUserError(List list)
        {
            if (EbayErrorUtil.incorrectCredentials(list))
            {
                int i;
                if (DeviceConfiguration.getAsync().get(DcsBoolean.SignInWithEmailOrUsername))
                {
                    i = 0x7f070486;
                } else
                {
                    i = 0x7f070487;
                }
                errorTextView.setText(i);
                errorView.setVisibility(0);
                return;
            }
            if (EbayErrorUtil.missingPaypalSecurityKey(list))
            {
                errorTextView.setText(0x7f07063a);
                errorView.setVisibility(0);
                return;
            }
            if (EbayErrorUtil.forcedChangePassword(list))
            {
                showDialog(0x7f07041e);
                return;
            } else
            {
                super.onUserError(list);
                return;
            }
        }

        public ErrorHandler()
        {
            this$0 = SignInModalFragment.this;
            super(getActivity());
        }
    }

    public static class ForgotPasswordDialogFragment extends DialogFragment
        implements android.view.View.OnClickListener
    {

        TextView cancelButton;
        TextView forgotPasswordButton;

        public void onClick(View view)
        {
            int i;
            if (view.getId() == 0x7f1001c4)
            {
                i = 1;
            } else
            {
                i = 3;
            }
            if (getTargetFragment() != null && (getTargetFragment() instanceof DialogFragmentCallback))
            {
                ((DialogFragmentCallback)getTargetFragment()).onDialogFragmentResult(this, getTargetRequestCode(), i);
            } else
            if (getActivity() instanceof DialogFragmentCallback)
            {
                ((DialogFragmentCallback)getActivity()).onDialogFragmentResult(this, getTargetRequestCode(), i);
                return;
            }
        }

        public void onCreate(Bundle bundle)
        {
            super.onCreate(bundle);
        }

        public Dialog onCreateDialog(Bundle bundle)
        {
            bundle = new Dialog(getActivity());
            bundle.getWindow().requestFeature(1);
            bundle.setContentView(0x7f0300ae);
            bundle.show();
            cancelButton = (TextView)bundle.findViewById(0x7f1001c3);
            forgotPasswordButton = (TextView)bundle.findViewById(0x7f1001c4);
            cancelButton.setOnClickListener(this);
            forgotPasswordButton.setOnClickListener(this);
            return bundle;
        }

        public ForgotPasswordDialogFragment()
        {
        }
    }


    private static final int DIALOG_ID_ALERT = 1;
    private static final int DIALOG_ID_CHANGE_PASSWORD = 3;
    private static final int DIALOG_ID_FORGOT_PASSWORD = 4;
    private static final int DIALOG_ID_INCENTIVE = 2;
    private static final String DIALOG_TAG = "dialog";
    private static final String EMAIL_TAG = "email";
    public static final String EXTRA_IAF_TOKEN = "iaf_token";
    public static final String EXTRA_PREV_USERNAME = "prevUser";
    public static final String EXTRA_REDIRECT_INTENTS = "redirect_intents";
    public static final String EXTRA_USER = "user";
    private static final int LOADER_ID_INSTANTIATE_GUID = 3;
    private static final int LOADER_ID_SIGN_IN = 1;
    private static final int REQUEST_CODE_FYP = 2;
    private static final int REQUEST_CODE_REGISTER = 1;
    private static final String STATE_INCENTIVE_BODY = "incentive_body";
    private static final String STATE_INCENTIVE_BODY_SEPARATOR_INDEX = "incentive_body_separator_index";
    private static final String STATE_INCENTIVE_OK = "incentive_ok";
    private static final String STATE_INCENTIVE_TITLE = "incentive_title";
    private static final String USERID_TAG = "userid";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBaySignIn", 3, "Log authentication calls");
    private AddressDataManagerObserver addressDmObserver;
    protected TextView errorTextView;
    protected View errorView;
    private boolean fromHome;
    protected String id3pp;
    protected String id4pp;
    private String incentiveBody;
    private int incentiveBodySeparatorIndex;
    private String incentiveOk;
    protected IssueIncentiveResponse incentiveResponse;
    private String incentiveTitle;
    private final boolean isEmailSignInEnabled;
    private boolean isTabCurrent;
    private boolean isTabCurrentBeforeActivity;
    private TextView lastTextView;
    private EditText passwordInput;
    private String prevUserFromArguments;
    private ArrayList redirectIntents;
    private View registerButton;
    private Intent resultIntent;
    private TextView showHideTextView;
    private boolean showPassword;
    private View signInButton;
    protected boolean signInComplete;
    private String tmxSessionId;
    private UserCache userCache;
    protected UserContextDataManager userContextDataManger;
    protected UserDetail userDetail;
    private String userFromArguments;
    private AutoCompleteTextView usernameInput;

    public SignInModalFragment()
    {
        incentiveTitle = null;
        incentiveBody = null;
        incentiveOk = null;
        incentiveBodySeparatorIndex = -1;
        isTabCurrent = false;
        isTabCurrentBeforeActivity = false;
        isEmailSignInEnabled = DeviceConfiguration.getAsync().get(DcsBoolean.SignInWithEmailOrUsername);
        fromHome = false;
        signInComplete = false;
        showPassword = false;
    }

    private void completeSignIn(SignInNetLoader signinnetloader)
    {
        if (signinnetloader.isError())
        {
            onSignInLoaderError(signinnetloader);
            return;
        }
        BaseActivity baseactivity = (BaseActivity)getActivity();
        UserDetail userdetail = signinnetloader.getUserDetail();
        if (userdetail != null && "Unconfirmed".equalsIgnoreCase(userdetail.status))
        {
            ((DialogManager)baseactivity.getShim(com/ebay/common/view/util/DialogManager)).showDynamicAlertDialog(null, getString(0x7f070ba1), true);
            return;
        }
        Preferences preferences = MyApp.getPrefs();
        String s1 = getTextString(usernameInput);
        preferences.setGlobalPref(s1, "lastSigninEntered");
        Object obj = new TrackingData("SignInSuccess", TrackingType.EVENT);
        ((TrackingData) (obj)).addKeyValuePair("user_name", s1);
        String s;
        if (Pattern.compile("@").matcher(s1).find())
        {
            s = "email";
        } else
        {
            s = "userid";
        }
        ((TrackingData) (obj)).addKeyValuePair("sgnType", s);
        ((TrackingData) (obj)).send(baseactivity);
        s = signinnetloader.getUserId();
        obj = signinnetloader.getCoreToken();
        if (obj != null)
        {
            userContextDataManger.signInUserAndSetCurrent(s, ((String) (obj)));
            userCache.signIn(s, ((String) (obj)));
            String s2 = signinnetloader.getMachineGroupId();
            if (!TextUtils.isEmpty(s2))
            {
                preferences.setGlobalPref(s2, "mg_id_ref");
            }
            setupNotificationService(preferences);
            s2 = signinnetloader.getActorId();
            if (!TextUtils.isEmpty(s2))
            {
                preferences.setUserPref(s2, "mims_actor_id");
            }
            if (userdetail != null)
            {
                userCache.setUserDetails(userdetail);
                preferences.setPayPalAccountStatus(userdetail.payPalAccountStatus);
                preferences.setUserIsPpa(userdetail.isPpa);
                MimsUtil.removeIdentity(MimsUtil.PROVIDER_ID_MARKETPLACE, null);
                MimsUtil.addIdentity(MimsUtil.PROVIDER_ID_MARKETPLACE, userdetail.userId);
                MimsUtil.addIdentity(MimsUtil.PROVIDER_ID_MARKETPLACE, userdetail.email);
            }
            preferences.addPrefStringsUserNameHistory(s1);
            if (log.isLoggable)
            {
                log.log("Sign in was successful.");
            }
            userCache.refreshSavedSearchList();
            baseactivity.sendBroadcast(new Intent("com.ebay.mobile.APPLICATION_LAUNCH"));
            ((NotificationManager)baseactivity.getSystemService("notification")).cancel(EbayNotificationManager.ID_SIGN_OUT_NOTIFICATION);
            resultIntent.putExtra("user", s);
            resultIntent.putExtra("iaf_token", ((String) (obj)));
            baseactivity.setResult(-1, resultIntent);
        }
        CrashlyticsWrapper.updateMetadata(getActivity());
        incentiveResponse = signinnetloader.getIncentive();
        signinnetloader.getUserDetail();
        signInComplete = true;
    }

    private final DialogFragment createAlert(int i)
    {
        return (new com.ebay.app.AlertDialogFragment.Builder()).setMessage(i).setNegativeButton(0x104000a).createFromFragment(1, this);
    }

    private DialogFragment createChangePasswordDialog()
    {
        return (new com.ebay.app.AlertDialogFragment.Builder()).setTitle(0x7f07041f).setMessage(0x7f07041e).setNegativeButton(0x1040000).setPositiveButton(0x7f07091d).createFromFragment(3, this);
    }

    private DialogFragment createIncentiveDialog()
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        if (incentiveTitle != null)
        {
            builder.setTitle(incentiveTitle);
        }
        if (incentiveBody != null)
        {
            if (incentiveBodySeparatorIndex == -1)
            {
                builder.setMessage(incentiveBody);
            } else
            {
                SpannableString spannablestring = new SpannableString(incentiveBody);
                spannablestring.setSpan(new StyleSpan(1), 0, incentiveBodySeparatorIndex, 33);
                builder.setMessage(spannablestring);
            }
        }
        if (incentiveOk != null)
        {
            builder.setPositiveButton(incentiveOk);
        } else
        {
            builder.setPositiveButton(0x104000a);
        }
        return builder.createFromFragment(2, this);
    }

    private void doSignIn()
    {
        Util.hideSoftInput(getActivity(), passwordInput);
        FwLoaderManager fwloadermanager = getFwLoaderManager();
        if (fwloadermanager.getRunningLoader(1) == null)
        {
            Object obj = getFwActivity();
            SiteSpeedActivityUtil.initSiteSpeedData(((FwActivity) (obj)));
            SiteSpeedActivityUtil.getSiteSpeedData(((FwActivity) (obj))).viewAppeared();
            obj = getTextString(usernameInput);
            String s = getTextString(passwordInput);
            Preferences preferences = MyApp.getPrefs();
            preferences.setPostalCode(null);
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            fwloadermanager.start(1, new SignInNetLoader(getFwActivity().getEbayContext(), preferences.getCurrentSite(), ((String) (obj)), s, deviceconfiguration.get(DcsBoolean.SignInWithEmailOrUsername), tmxSessionId), true);
        }
    }

    private static String getTextString(TextView textview)
    {
        return textview.getText().toString().trim();
    }

    private void onSignInLoaderError(SignInNetLoader signinnetloader)
    {
        Activity activity = getActivity();
        passwordInput.setText(null);
        setProgressOff();
        List list = signinnetloader.getServiceErrorsAndWarnings();
        TrackingData trackingdata = new TrackingData("SignInFailure", TrackingType.EVENT);
        Object obj = getTextString(usernameInput);
        trackingdata.addKeyValuePair("user_name", ((String) (obj)));
        if (Pattern.compile("@").matcher(((CharSequence) (obj))).find())
        {
            obj = "email";
        } else
        {
            obj = "userid";
        }
        trackingdata.addKeyValuePair("sgnType", ((String) (obj)));
        if (list != null && list.size() > 0)
        {
            obj = (EbayResponseError)list.get(0);
            trackingdata.addKeyValuePair("errCode", ((EbayResponseError) (obj)).code);
            trackingdata.addKeyValuePair("errDesc", ((EbayResponseError) (obj)).shortMessage);
            trackingdata.send(activity);
            (new ErrorHandler()).handleEbayError(list, signinnetloader);
            return;
        } else
        {
            trackingdata.send(activity);
            EbayErrorHandler.handleResultStatus(this, 1, signinnetloader.getResultStatus());
            return;
        }
    }

    private void populateViewForOrientation(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        String s = getTextString(usernameInput);
        String s1 = getTextString(passwordInput);
        int i = errorView.getVisibility();
        String s2 = errorTextView.getText().toString();
        viewgroup.removeAllViewsInLayout();
        updateFragmentViews(layoutinflater.inflate(0x7f03024f, viewgroup));
        usernameInput.setText(s);
        passwordInput.setText(s1);
        setUserNameHistory();
        setPasswordVisible(showPassword);
        errorTextView.setText(s2);
        errorView.setVisibility(i);
    }

    private void redirectAndFinish()
    {
        Activity activity = getActivity();
        if ((!TextUtils.isEmpty(prevUserFromArguments) && !MyApp.getPrefs().getCurrentUser().equals(prevUserFromArguments) || activity.isTaskRoot()) && (redirectIntents == null || redirectIntents.isEmpty() || !((Intent)redirectIntents.get(0)).getComponent().getClassName().equals(com/ebay/mobile/activities/eBay.getClass().getName())))
        {
            Intent intent = new Intent(activity, com/ebay/mobile/activities/eBay);
            intent.addFlags(0x4000000);
            startActivity(intent);
        }
        if (redirectIntents != null && !redirectIntents.isEmpty())
        {
            for (Iterator iterator = redirectIntents.iterator(); iterator.hasNext(); startActivity((Intent)iterator.next())) { }
        }
        activity.finish();
    }

    private void requestFocus(TextView textview)
    {
        textview.requestFocus();
        textview.requestFocusFromTouch();
        lastTextView = textview;
    }

    private void setProgressOff()
    {
        ModalProgressFragment.hide(getFragmentManager());
    }

    private void setProgressOn()
    {
        ModalProgressFragment.show(getFragmentManager(), this);
    }

    private void setUserNameHistory()
    {
        String as[] = MyApp.getPrefs().getPrefStringsUserNameHistory();
        if (as != null && as.length > 0)
        {
            ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x109000a, as);
            usernameInput.setAdapter(arrayadapter);
            usernameInput.setOnItemClickListener(this);
        }
    }

    private void setupNotificationService(Preferences preferences)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("authCore", preferences.getAuthentication());
        ServiceStarter.instructNotificationManagerService(getActivity(), 1, bundle);
    }

    private void showForgotPasswordHint()
    {
        ForgotPasswordDialogFragment forgotpassworddialogfragment = new ForgotPasswordDialogFragment();
        forgotpassworddialogfragment.setTargetFragment(this, 4);
        forgotpassworddialogfragment.show(getFragmentManager().beginTransaction(), "dialog");
    }

    private void updateFragmentViews(View view)
    {
        if (!getResources().getBoolean(0x7f0b0006))
        {
            getActivity().getWindow().setLayout(-1, -1);
        }
        usernameInput = (AutoCompleteTextView)view.findViewById(0x7f1007ed);
        usernameInput.addTextChangedListener(this);
        passwordInput = (EditText)view.findViewById(0x7f1007ee);
        passwordInput.addTextChangedListener(this);
        registerButton = view.findViewById(0x7f100549);
        registerButton.setOnClickListener(this);
        if (DeviceConfiguration.getAsync().get(DcsNautilusBoolean.ThreatMatrixRiskModule))
        {
            registerButton.setEnabled(false);
            FwLoaderManager fwloadermanager = getFwLoaderManager();
            if (fwloadermanager.getRunningLoader(3) == null)
            {
                fwloadermanager.start(3, new InstantiateGuidLoader(getActivity()), true);
            }
        }
        showHideTextView = (TextView)view.findViewById(0x7f1007f4);
        showHideTextView.setOnClickListener(this);
        errorView = view.findViewById(0x7f1007ea);
        errorTextView = (TextView)view.findViewById(0x7f1007ec);
        signInButton = view.findViewById(0x7f1007f1);
        signInButton.setOnClickListener(this);
        view.findViewById(0x7f1007f3).setOnClickListener(this);
        view.findViewById(0x7f1007f0).setOnClickListener(this);
        if (isEmailSignInEnabled)
        {
            usernameInput.setInputType(33);
        }
        setUpUserEmailHint(view);
        setUpTextView(usernameInput);
        setUpTextView(passwordInput);
        passwordInput.setTypeface(Typeface.DEFAULT);
        updateSignInButtonState();
        processArguments(getArguments());
    }

    private void updateSignInButtonState()
    {
        String s = getTextString(usernameInput);
        String s1 = getTextString(passwordInput);
        View view = signInButton;
        boolean flag;
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setEnabled(flag);
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected boolean checkIncentive(IssueIncentiveResponse issueincentiveresponse)
    {
        if (issueincentiveresponse != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L4:
        return flag1;
_L2:
        Activity activity;
        boolean flag2;
        boolean flag3 = true;
        flag2 = true;
        flag1 = true;
        activity = getActivity();
        if (issueincentiveresponse.isSuccessful())
        {
            incentiveTitle = issueincentiveresponse.title;
            incentiveBodySeparatorIndex = -1;
            incentiveOk = issueincentiveresponse.buttonText;
            if (!TextUtils.isEmpty(issueincentiveresponse.primaryBody))
            {
                if (TextUtils.isEmpty(issueincentiveresponse.secondaryBody))
                {
                    incentiveBody = issueincentiveresponse.primaryBody;
                } else
                {
                    incentiveBody = (new StringBuilder()).append(issueincentiveresponse.primaryBody).append('\n').append(issueincentiveresponse.secondaryBody).toString();
                    incentiveBodySeparatorIndex = issueincentiveresponse.primaryBody.length();
                }
            } else
            if (!TextUtils.isEmpty(issueincentiveresponse.secondaryBody))
            {
                incentiveBody = issueincentiveresponse.secondaryBody;
            } else
            {
                incentiveBody = null;
            }
            if (TextUtils.isEmpty(incentiveBody) && TextUtils.isEmpty(incentiveTitle))
            {
                Log.e(com/ebay/mobile/activities/SignInModalFragment.getSimpleName(), "No coupon details!");
                flag1 = flag3;
            } else
            {
                showDialog(0x7f070493);
                flag1 = false;
            }
            InstallTracking.clearCoupon(activity);
            return flag1;
        }
        if (!issueincentiveresponse.getResultStatus().hasError()) goto _L4; else goto _L3
_L3:
        DeviceConfiguration deviceconfiguration;
        Iterator iterator;
        boolean flag;
        deviceconfiguration = null;
        flag = false;
        iterator = issueincentiveresponse.getResultStatus().getMessages().iterator();
_L7:
        int i;
label0:
        {
            com.ebay.nautilus.kernel.content.ResultStatus.Message message;
            do
            {
                issueincentiveresponse = deviceconfiguration;
                i = ((flag) ? 1 : 0);
                if (!iterator.hasNext())
                {
                    break label0;
                }
                message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)iterator.next();
            } while (!(message instanceof EbayResponseError));
            i = message.getId();
            if (5 != i && 16 != i && 18 != i && 38 != i || !message.displayToUser())
            {
                continue; /* Loop/switch isn't completed */
            }
            issueincentiveresponse = deviceconfiguration;
            i = ((flag) ? 1 : 0);
            if (InstallTracking.getCarrierIdRoverUrl(activity) == null)
            {
                issueincentiveresponse = message;
                i = ((flag) ? 1 : 0);
            }
        }
_L8:
        deviceconfiguration = DeviceConfiguration.getAsync();
        flag1 = flag2;
        if (issueincentiveresponse != null)
        {
            flag1 = flag2;
            if (!deviceconfiguration.get(DcsBoolean.IncentivesVouchersErrorSuppression))
            {
                incentiveTitle = null;
                incentiveBodySeparatorIndex = -1;
                incentiveOk = null;
                incentiveBody = issueincentiveresponse.getShortMessage(getFwActivity().getEbayContext());
                showDialog(0x7f070493);
                flag1 = false;
            }
        }
        if (i == 0)
        {
            InstallTracking.clearCoupon(activity);
        }
        if (!deviceconfiguration.get(DcsBoolean.IncentivesVouchersErrorSuppression)) goto _L4; else goto _L5
_L5:
        return true;
        if (2 != i && 4 != i && 30 != i && 32 != i && 2005 != i && 20005 != i) goto _L7; else goto _L6
_L6:
        i = 1;
        issueincentiveresponse = deviceconfiguration;
          goto _L8
    }

    Intent getForgotPasswordIntentAndTrack()
    {
        Object obj = getActivity();
        Object obj1 = MyApp.getDeviceConfiguration().forgotPasswordUrl();
        if (DeviceConfiguration.getAsync().get(DcsBoolean.ForgotPasswordInWebView))
        {
            obj = new Intent(((Context) (obj)), com/ebay/mobile/activities/ShowWebViewActivity);
            ((Intent) (obj)).putExtra("url", ((String) (obj1)));
            ((Intent) (obj)).putExtra("android.intent.extra.TITLE", getString(0x7f070760));
            ((Intent) (obj)).putExtra(ShowWebViewActivity.EXTRA_SHOW_MENU, false);
            ((Intent) (obj)).putExtra("back", true);
            ((Intent) (obj)).putExtra("impression", "ForgotPassword");
            return ((Intent) (obj));
        } else
        {
            obj1 = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj1))));
            (new TrackingData("ForgotPassword", TrackingType.PAGE_IMPRESSION)).send(((Activity) (obj)));
            return ((Intent) (obj1));
        }
    }

    public Intent getRegisterIntent(Context context, boolean flag)
    {
        context = RegisterFragment.getStartingIntent(context, flag);
        if (DeviceConfiguration.getAsync().get(DcsNautilusBoolean.ThreatMatrixRiskModule) && !TextUtils.isEmpty(tmxSessionId))
        {
            HashMap hashmap = new HashMap();
            hashmap.put("x-ebay-mobile-profile-session", EbayRequest.generateTmxProfileSessionValue(tmxSessionId));
            hashmap.put("x-ebay-4pp", id4pp);
            hashmap.put("x-ebay3pp-device-id", id3pp);
            context.putExtra("headers", hashmap);
        }
        return context;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        BaseActivity baseactivity = (BaseActivity)getActivity();
        SiteSpeedActivityUtil.invalidate(baseactivity);
        Intent intent = baseactivity.getIntent();
        resultIntent = new Intent(intent);
        if (userCache == null)
        {
            userCache = new UserCache(baseactivity);
        }
        setProgressOff();
        if (bundle != null)
        {
            incentiveTitle = bundle.getString("incentive_title");
            incentiveBody = bundle.getString("incentive_body");
            incentiveOk = bundle.getString("incentive_ok");
            incentiveBodySeparatorIndex = bundle.getInt("incentive_body_separator_index", -1);
            fromHome = bundle.getBoolean("fromHome", false);
            return;
        } else
        {
            fromHome = intent.getBooleanExtra("fromHome", false);
            return;
        }
    }

    protected void onActivityResultSafe(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 2 2: default 20
    //                   2 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (-1 == j)
        {
            Object obj = null;
            Intent intent1 = null;
            if (intent != null)
            {
                String s = intent.getStringExtra(ShowWebViewActivity.RESULT_VALUE_USERID);
                if (s != null)
                {
                    s.trim();
                }
                intent = intent.getStringExtra(ShowWebViewActivity.RESULT_VALUE_EMAIL);
                intent1 = intent;
                obj = s;
                if (intent != null)
                {
                    intent.trim();
                    obj = s;
                    intent1 = intent;
                }
            }
            if (!TextUtils.isEmpty(intent1))
            {
                obj = intent1;
            }
            setUsername(((String) (obj)));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        redirectAndFinish();
    }

    public void onClick(View view)
    {
        boolean flag = true;
        switch (view.getId())
        {
        default:
            return;

        case 2131757044: 
            if (showPassword)
            {
                flag = false;
            }
            showPassword = flag;
            setPasswordVisible(showPassword);
            MyApp.getPrefs().setGlobalPref(showPassword, "showSigninPassword");
            requestFocus(passwordInput);
            return;

        case 2131757040: 
            if (getResources().getBoolean(0x7f0b0006))
            {
                showForgotPasswordHint();
                return;
            } else
            {
                startActivityForResult(getForgotPasswordIntentAndTrack(), 2);
                return;
            }

        case 2131757041: 
            doSignIn();
            return;

        case 2131756361: 
            startActivityForResult(getRegisterIntent(view.getContext(), fromHome), 1);
            return;

        case 2131757043: 
            view = getActivity();
            (new TrackingData("SignInExit", TrackingType.EVENT)).send(view);
            view.finish();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        populateViewForOrientation(LayoutInflater.from(getActivity()), (ViewGroup)getView());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(false);
        setRetainInstance(true);
        addressDmObserver = new AddressDataManagerObserver();
        initDataManagers();
        showPassword = MyApp.getPrefs().getGlobalPref("showSigninPassword", false);
    }

    protected DialogFragment onCreateDialogFragment(int i)
    {
        switch (i)
        {
        default:
            return createAlert(i);

        case 2131166355: 
            return createIncentiveDialog();

        case 2131166238: 
            return createChangePasswordDialog();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03024f, viewgroup, false);
        updateFragmentViews(layoutinflater);
        return layoutinflater;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        i;
        JVM INSTR tableswitch 2 4: default 28
    //                   2 29
    //                   3 43
    //                   4 66;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (dialogfragment != null)
        {
            dialogfragment.dismiss();
        }
        onCancel(null);
        return;
_L3:
        if (dialogfragment != null)
        {
            dialogfragment.dismiss();
        }
        if (j == 1)
        {
            startActivityForResult(getForgotPasswordIntentAndTrack(), 2);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (dialogfragment != null)
        {
            dialogfragment.dismiss();
        }
        if (j == 1)
        {
            startActivityForResult(getForgotPasswordIntentAndTrack(), 2);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (6 == i)
        {
            doSignIn();
            flag = true;
        }
        return flag;
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (view instanceof TextView)
        {
            lastTextView = (TextView)view;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        userContextDataManger = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
        datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams("Shipping"), addressDmObserver);
        if (DeviceConfiguration.getAsync().get(DcsNautilusBoolean.ThreatMatrixRiskModule))
        {
            datamanagercontainer.initialize(ThreatMatrixDataManager.key(), this);
        }
    }

    public void onInitialized(ThreatMatrixDataManager threatmatrixdatamanager, String s)
    {
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        requestFocus(passwordInput);
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 1 && (i == 61 || i == 66 || i == 23))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0) goto _L2; else goto _L1
_L1:
        view.getId();
        JVM INSTR tableswitch 2131757037 2131757038: default 60
    //                   2131757037 67
    //                   2131757038 84;
           goto _L2 _L3 _L4
_L2:
        return false;
_L3:
        usernameInput.performCompletion();
        requestFocus(passwordInput);
        return true;
_L4:
        doSignIn();
        return true;
    }

    public void onNewIntent(Intent intent)
    {
        processArguments(intent.getExtras());
    }

    public void onPause()
    {
        super.onPause();
        Util.hideSoftInput(getActivity(), getView());
    }

    public void onRegistered(ThreatMatrixDataManager threatmatrixdatamanager, String s)
    {
        tmxSessionId = s;
    }

    public void onResume()
    {
        super.onResume();
        setUserNameHistory();
        setPasswordVisible(showPassword);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (incentiveTitle != null)
        {
            bundle.putString("incentive_title", incentiveTitle);
        }
        if (incentiveBody != null)
        {
            bundle.putString("incentive_body", incentiveBody);
        }
        if (incentiveOk != null)
        {
            bundle.putString("incentive_ok", incentiveOk);
        }
        if (incentiveBodySeparatorIndex != -1)
        {
            bundle.putInt("incentive_body_separator_index", incentiveBodySeparatorIndex);
        }
        bundle.putBoolean("fromHome", fromHome);
    }

    public void onStop()
    {
        Util.hideSoftInput(getActivity(), lastTextView);
        super.onStop();
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        super.onTaskComplete(i, fwloader);
        if (!getActivity().isFinishing())
        {
            switch (i)
            {
            case 2: // '\002'
            default:
                return;

            case 1: // '\001'
                completeSignIn((SignInNetLoader)fwloader);
                return;

            case 3: // '\003'
                fwloader = (InstantiateGuidLoader)fwloader;
                break;
            }
            if (fwloader != null)
            {
                id3pp = ((InstantiateGuidLoader) (fwloader)).id3pp;
                id4pp = ((InstantiateGuidLoader) (fwloader)).id4pp;
                registerButton.setEnabled(true);
                return;
            }
        }
    }

    protected void onTaskStarted(int i, FwLoader fwloader)
    {
        super.onTaskStarted(i, fwloader);
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            setProgressOn();
            break;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        updateSignInButtonState();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view.requestFocusFromTouch();
        return false;
    }

    protected void processArguments(Bundle bundle)
    {
        if (bundle == null)
        {
            redirectIntents = null;
            userFromArguments = null;
            prevUserFromArguments = null;
        } else
        {
            redirectIntents = bundle.getParcelableArrayList("redirect_intents");
            userFromArguments = bundle.getString("user");
            prevUserFromArguments = bundle.getString("prevUser");
        }
        if (TextUtils.isEmpty(userFromArguments))
        {
            setUsername(MyApp.getPrefs().getGlobalPref("lastSigninEntered", null));
            return;
        } else
        {
            setUsername(userFromArguments);
            return;
        }
    }

    protected void setPasswordVisible(boolean flag)
    {
        char c;
        if (flag)
        {
            c = '\220';
        } else
        {
            c = '\200';
        }
        passwordInput.setInputType(c | '\001');
        passwordInput.setSelection(passwordInput.length());
        if (flag)
        {
            showHideTextView.setText(0x7f070ac2);
            return;
        } else
        {
            showHideTextView.setText(0x7f070ac7);
            return;
        }
    }

    public void setUpTextView(TextView textview)
    {
        textview.setOnTouchListener(this);
        textview.setOnKeyListener(this);
        textview.setOnEditorActionListener(this);
        textview.setOnFocusChangeListener(this);
    }

    protected void setUpUserEmailHint(View view)
    {
        if (view != null)
        {
            int i;
            if (isEmailSignInEnabled)
            {
                i = 0x7f070acb;
            } else
            {
                i = 0x7f070aca;
            }
            ((EditText)(EditText)view.findViewById(0x7f1007ed)).setHint(i);
        }
    }

    public void setUsername(String s)
    {
        if (passwordInput == null || usernameInput == null)
        {
            return;
        }
        passwordInput.setText(null);
        if (!TextUtils.isEmpty(s))
        {
            MyApp.getPrefs().setGlobalPref(s, "lastSigninEntered");
            usernameInput.setText(s);
            requestFocus(passwordInput);
            return;
        } else
        {
            usernameInput.setText(null);
            requestFocus(usernameInput);
            return;
        }
    }

    protected void showDialog(int i)
    {
        DialogFragment dialogfragment = onCreateDialogFragment(i);
        if (dialogfragment != null)
        {
            dialogfragment.show(getFragmentManager(), "dialog");
        }
    }

    protected void showIncentiveOrFinish(IssueIncentiveResponse issueincentiveresponse)
    {
        SiteSpeedActivityUtil.primaryAndAllLoaded(getBaseActivity());
        if (checkIncentive(issueincentiveresponse))
        {
            redirectAndFinish();
        }
    }

}
