// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.app.ModalProgressFragment;
import com.ebay.common.Preferences;
import com.ebay.common.TabsAdapter;
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
import com.ebay.mobile.service.GoogleNowAuthenticationService;
import com.ebay.mobile.service.PreferenceSyncService;
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
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import com.ebay.server_requests.InstallTracking;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseFragment, BaseActivity, eBay, ShowWebViewActivity, 
//            SignInActivity

public class SignInFragment extends BaseFragment
    implements android.content.DialogInterface.OnCancelListener, android.view.View.OnClickListener, android.view.View.OnFocusChangeListener, android.view.View.OnKeyListener, android.view.View.OnTouchListener, android.widget.TextView.OnEditorActionListener, DialogFragmentCallback, com.ebay.common.TabsAdapter.OnTabCurrentListener, com.ebay.nautilus.domain.content.dm.ThreatMatrixDataManager.Observer
{
    private class AddressDataManagerObserver extends com.ebay.nautilus.domain.content.dm.AddressDataManager.SimpleObserver
    {

        final SignInFragment this$0;

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
            this$0 = SignInFragment.this;
            super();
        }

    }

    private final class ErrorHandler extends EbayErrorHandler
    {

        final SignInFragment this$0;

        protected void onUserError(List list)
        {
            if (EbayErrorUtil.incorrectCredentials(list))
            {
                int i;
                if (DeviceConfiguration.getAsync().get(DcsBoolean.SignInWithEmailOrUsername))
                {
                    i = 0x7f070485;
                } else
                {
                    i = 0x7f070484;
                }
                showDialog(i);
                return;
            }
            if (EbayErrorUtil.missingPaypalSecurityKey(list))
            {
                showDialog(0x7f07063a);
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
            this$0 = SignInFragment.this;
            super(getActivity());
        }
    }


    private static final int DIALOG_ID_ALERT = 1;
    private static final int DIALOG_ID_CHANGE_PASSWORD = 3;
    private static final int DIALOG_ID_INCENTIVE = 2;
    private static final String DIALOG_TAG = "dialog";
    public static final String EXTRA_CLIENT_INT = "client_int";
    public static final String EXTRA_IAF_TOKEN = "iaf_token";
    public static final String EXTRA_PREV_USERNAME = "prevUser";
    public static final String EXTRA_REDIRECT_INTENTS = "redirect_intents";
    public static final String EXTRA_USER = "user";
    private static final int LOADER_ID_SIGN_IN = 1;
    private static final int REQUEST_CODE_FYP = 2;
    private static final String STATE_INCENTIVE_BODY = "incentive_body";
    private static final String STATE_INCENTIVE_BODY_SEPARATOR_INDEX = "incentive_body_separator_index";
    private static final String STATE_INCENTIVE_OK = "incentive_ok";
    private static final String STATE_INCENTIVE_TITLE = "incentive_title";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBaySignIn", 3, "Log authentication calls");
    private AddressDataManagerObserver addressDmObserver;
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
    private Intent resultIntent;
    private CheckBox showControl;
    protected boolean signInComplete;
    private String tmxSessionId;
    private UserCache userCache;
    protected UserContextDataManager userContextDataManger;
    protected UserDetail userDetail;
    private String userFromArguments;
    private AutoCompleteTextView usernameInput;

    public SignInFragment()
    {
        incentiveTitle = null;
        incentiveBody = null;
        incentiveOk = null;
        incentiveBodySeparatorIndex = -1;
        isTabCurrent = false;
        isTabCurrentBeforeActivity = false;
        isEmailSignInEnabled = DeviceConfiguration.getAsync().get(DcsBoolean.SignInWithEmailOrUsername);
        signInComplete = false;
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
        (new TrackingData("SignInSuccess", TrackingType.EVENT)).send(getActivity());
        Preferences preferences = MyApp.getPrefs();
        String s = getTextString(usernameInput);
        preferences.setGlobalPref(s, "lastSigninEntered");
        String s1 = signinnetloader.getUserId();
        String s2 = signinnetloader.getCoreToken();
        if (s2 != null)
        {
            userContextDataManger.signInUserAndSetCurrent(s1, s2);
            userCache.signIn(s1, s2);
            String s3 = signinnetloader.getMachineGroupId();
            if (!TextUtils.isEmpty(s3))
            {
                preferences.setGlobalPref(s3, "mg_id_ref");
            }
            setupNotificationService(preferences);
            s3 = signinnetloader.getActorId();
            if (!TextUtils.isEmpty(s3))
            {
                preferences.setUserPref(s3, "mims_actor_id");
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
            preferences.addPrefStringsUserNameHistory(s);
            if (log.isLoggable)
            {
                log.log("Sign in was successful.");
            }
            userCache.refreshSavedSearchList();
            baseactivity.sendBroadcast(new Intent("com.ebay.mobile.APPLICATION_LAUNCH"));
            ((NotificationManager)baseactivity.getSystemService("notification")).cancel(EbayNotificationManager.ID_SIGN_OUT_NOTIFICATION);
            resultIntent.putExtra("user", s1);
            resultIntent.putExtra("iaf_token", s2);
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
            SiteSpeedActivityUtil.initSiteSpeedData(getBaseActivity());
            SiteSpeedActivityUtil.getSiteSpeedData(getBaseActivity()).viewAppeared();
            String s = getTextString(usernameInput);
            String s1 = getTextString(passwordInput);
            Preferences preferences = MyApp.getPrefs();
            preferences.setPostalCode(null);
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            fwloadermanager.start(1, new SignInNetLoader(getFwActivity().getEbayContext(), preferences.getCurrentSite(), s, s1, deviceconfiguration.get(DcsBoolean.SignInWithEmailOrUsername), tmxSessionId), true);
        }
    }

    private static String getTextString(TextView textview)
    {
        return textview.getText().toString().trim();
    }

    private void onSignInLoaderError(SignInNetLoader signinnetloader)
    {
        (new TrackingData("SignInFailure", TrackingType.EVENT)).send(getActivity());
        passwordInput.setText(null);
        setProgressOff();
        List list = signinnetloader.getServiceErrorsAndWarnings();
        if (list != null)
        {
            (new ErrorHandler()).handleEbayError(list, signinnetloader);
            return;
        } else
        {
            EbayErrorHandler.handleResultStatus(this, 1, signinnetloader.getResultStatus());
            return;
        }
    }

    private void redirectAndFinish()
    {
        if ((!TextUtils.isEmpty(prevUserFromArguments) && !MyApp.getPrefs().getCurrentUser().equals(prevUserFromArguments) || getActivity().isTaskRoot()) && (redirectIntents == null || redirectIntents.isEmpty() || !((Intent)redirectIntents.get(0)).getComponent().getClassName().equals(com/ebay/mobile/activities/eBay.getClass().getName())))
        {
            Intent intent = new Intent(getActivity(), com/ebay/mobile/activities/eBay);
            intent.addFlags(0x4000000);
            startActivity(intent);
        }
        if (redirectIntents != null && !redirectIntents.isEmpty())
        {
            for (Iterator iterator = redirectIntents.iterator(); iterator.hasNext(); startActivity((Intent)iterator.next())) { }
        }
        getActivity().finish();
    }

    private void requestFocus(TextView textview)
    {
        if (isTabCurrent)
        {
            textview.requestFocus();
            textview.requestFocusFromTouch();
        }
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

    private void setupNotificationService(Preferences preferences)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("authCore", preferences.getAuthentication());
        ServiceStarter.instructNotificationManagerService(getActivity(), 1, bundle);
        GoogleNowAuthenticationService.start(getActivity());
    }

    protected boolean checkIncentive(IssueIncentiveResponse issueincentiveresponse)
    {
        if (issueincentiveresponse != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L4:
        return flag1;
_L2:
        boolean flag2;
        boolean flag3 = true;
        flag2 = true;
        flag1 = true;
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
                Log.e(com/ebay/mobile/activities/SignInFragment.getSimpleName(), "No coupon details!");
                flag1 = flag3;
            } else
            {
                showDialog(0x7f070493);
                flag1 = false;
            }
            InstallTracking.clearCoupon(getActivity());
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
            if (InstallTracking.getCarrierIdRoverUrl(getActivity()) == null)
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
            InstallTracking.clearCoupon(getActivity());
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
        Object obj = MyApp.getDeviceConfiguration().forgotPasswordUrl();
        if (DeviceConfiguration.getAsync().get(DcsBoolean.ForgotPasswordInWebView))
        {
            Intent intent = new Intent(getActivity(), com/ebay/mobile/activities/ShowWebViewActivity);
            intent.putExtra("url", ((String) (obj)));
            intent.putExtra("android.intent.extra.TITLE", getString(0x7f070760));
            intent.putExtra(ShowWebViewActivity.EXTRA_SHOW_MENU, false);
            intent.putExtra("back", true);
            intent.putExtra("impression", "ForgotPassword");
            return intent;
        } else
        {
            obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
            (new TrackingData("ForgotPassword", TrackingType.PAGE_IMPRESSION)).send(getActivity());
            return ((Intent) (obj));
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        BaseActivity baseactivity = (BaseActivity)getActivity();
        SiteSpeedActivityUtil.invalidate(baseactivity);
        resultIntent = new Intent(baseactivity.getIntent());
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
        }
        if (baseactivity instanceof com.ebay.common.TabsAdapter.TabsAdapterGetter)
        {
            ((com.ebay.common.TabsAdapter.TabsAdapterGetter)baseactivity).getTabsAdaptor().setItem(getArguments().getInt(TabsAdapter.EXTRA_POSITION), this);
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
        switch (view.getId())
        {
        default:
            return;

        case 2131757039: 
            setPasswordVisible(showControl.isChecked());
            requestFocus(passwordInput);
            return;

        case 2131757040: 
            startActivityForResult(getForgotPasswordIntentAndTrack(), 2);
            return;

        case 2131757041: 
            doSignIn();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(false);
        setRetainInstance(true);
        addressDmObserver = new AddressDataManagerObserver();
        initDataManagers();
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
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f03024e, null);
        usernameInput = (AutoCompleteTextView)layoutinflater.findViewById(0x7f1007ed);
        passwordInput = (EditText)layoutinflater.findViewById(0x7f1007ee);
        showControl = (CheckBox)layoutinflater.findViewById(0x7f1007ef);
        layoutinflater.findViewById(0x7f1007ef).setOnClickListener(this);
        layoutinflater.findViewById(0x7f1007f1).setOnClickListener(this);
        layoutinflater.findViewById(0x7f1007f0).setOnClickListener(this);
        if (isEmailSignInEnabled)
        {
            usernameInput.setInputType(33);
        }
        setUpUserEmailHint(layoutinflater);
        setUpTextView(usernameInput);
        setUpTextView(passwordInput);
        processArguments(getArguments());
        return layoutinflater;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        i;
        JVM INSTR tableswitch 2 3: default 24
    //                   2 25
    //                   3 39;
           goto _L1 _L2 _L3
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
        if (true) goto _L1; else goto _L4
_L4:
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

    public void onRegistered(ThreatMatrixDataManager threatmatrixdatamanager, String s)
    {
        tmxSessionId = s;
    }

    public void onResume()
    {
        super.onResume();
        String as[] = MyApp.getPrefs().getPrefStringsUserNameHistory();
        if (as != null && as.length > 0)
        {
            ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x109000a, as);
            usernameInput.setAdapter(arrayadapter);
        }
        setPasswordVisible(showControl.isChecked());
        if (isTabCurrentBeforeActivity)
        {
            isTabCurrentBeforeActivity = false;
            Util.showSoftInput(getActivity(), lastTextView);
        }
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
    }

    public void onStop()
    {
        Util.hideSoftInput(getActivity(), lastTextView);
        super.onStop();
    }

    public void onTabCurrent(boolean flag)
    {
        isTabCurrent = flag;
        Activity activity = getActivity();
        if (activity == null)
        {
            isTabCurrentBeforeActivity = flag;
        } else
        if (flag)
        {
            Util.showSoftInput(activity, getView());
            if (lastTextView != null)
            {
                requestFocus(lastTextView);
                return;
            }
        } else
        {
            Util.hideSoftInput(activity, getView());
            return;
        }
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        super.onTaskComplete(i, fwloader);
        if (getActivity().isFinishing())
        {
            return;
        }
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            completeSignIn((SignInNetLoader)fwloader);
            break;
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
        DialogFragment dialogfragment;
label0:
        {
            dialogfragment = onCreateDialogFragment(i);
            if (dialogfragment != null)
            {
                if (!(getActivity() instanceof SignInActivity))
                {
                    break label0;
                }
                if (((SignInActivity)getActivity()).canShowDialog)
                {
                    dialogfragment.show(getFragmentManager(), "dialog");
                }
            }
            return;
        }
        dialogfragment.show(getFragmentManager(), "dialog");
    }

    protected void showIncentiveOrFinish(IssueIncentiveResponse issueincentiveresponse)
    {
        SiteSpeedActivityUtil.primaryAndAllLoaded(getBaseActivity());
        if (checkIncentive(issueincentiveresponse))
        {
            redirectAndFinish();
        }
    }

    protected void showTabs(boolean flag)
    {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof SignInActivity))
        {
            ((SignInActivity)activity).showTabs(flag);
        }
    }

}
