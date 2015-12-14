// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.controllers.UpdateUserController;
import com.socialin.android.apiv3.model.StatusObj;
import com.socialin.android.apiv3.model.stripe.StripeChargeParams;
import com.socialin.android.apiv3.model.stripe.StripeChargeResponse;
import com.socialin.android.apiv3.model.stripe.StripeTokenParams;
import com.socialin.android.apiv3.model.stripe.StripeTokenResponse;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.exception.AuthenticationException;
import java.util.Calendar;

// Referenced classes of package com.stripe.android.picsart:
//            PaymentForm

public class StripeAuthActivity extends BaseActivity
    implements android.view.View.OnClickListener, PaymentForm
{

    private final String STRIPE_AUTH_DATA = "stripe.auth";
    private final String STRIPE_FORM_PANEL = "form.panel";
    private final String STRIPE_PASS_KEY = "stripe.pass";
    private final String STRIPE_PASS_PANEL = "pass.panel";
    private final int YEAR_EXP_COUNT = 10;
    private View authPanelLayout;
    private LinearLayout formLayout;
    private StripeAuthActivity instance;
    private View passPanelLayout;
    private ProgressBar progressBar;
    private boolean rememberChecked;
    private double shopItemPrice;

    public StripeAuthActivity()
    {
        rememberChecked = false;
        shopItemPrice = 0.0D;
    }

    private void changeProgressVisibility(int i)
    {
        progressBar.setVisibility(i);
    }

    private void chargeWithToken(String s)
    {
        StripeChargeParams stripechargeparams = new StripeChargeParams();
        stripechargeparams.chargeValue = (int)(shopItemPrice * 100D);
        if (!TextUtils.isEmpty(s))
        {
            stripechargeparams.tokenValue = s;
        }
        s = RequestControllerFactory.createChargeAliPayController();
        s.setRequestCompleteListener(new d() {

            final StripeAuthActivity this$0;

            public void onCancelRequest(StripeChargeResponse stripechargeresponse, Request request)
            {
            }

            public volatile void onCancelRequest(Object obj, Request request)
            {
                onCancelRequest((StripeChargeResponse)obj, request);
            }

            public void onFailure(Exception exception, Request request)
            {
                Utils.a(instance, exception.getMessage(), 1);
                if (passPanelLayout != null)
                {
                    passPanelLayout.setVisibility(8);
                }
                formLayout.setVisibility(0);
            }

            public transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public void onSuccess(StripeChargeResponse stripechargeresponse, Request request)
            {
                exitWithOk();
            }

            public volatile void onSuccess(Object obj, Request request)
            {
                onSuccess((StripeChargeResponse)obj, request);
            }

            
            {
                this$0 = StripeAuthActivity.this;
                super();
            }
        });
        s.doRequest(null, stripechargeparams);
    }

    private void createToken(Card card)
    {
        changeProgressVisibility(0);
        try
        {
            (new Stripe(getString(com.stripe.android.R.string.alipay_publish_key))).createToken(card, new TokenCallback() {

                final StripeAuthActivity this$0;

                public void onError(Exception exception)
                {
                    if (instance != null && !instance.isFinishing())
                    {
                        changeProgressVisibility(8);
                        Utils.a(instance, exception.getMessage(), 1);
                    }
                }

                public void onSuccess(Token token)
                {
                    if (instance != null && !instance.isFinishing())
                    {
                        changeProgressVisibility(8);
                    }
                    chargeWithToken(token.getId());
                }

            
            {
                this$0 = StripeAuthActivity.this;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Card card)
        {
            card.printStackTrace();
        }
    }

    private void exitWithError()
    {
        setResult(0);
        finish();
    }

    private void exitWithOk()
    {
        setResult(-1);
        finish();
    }

    private String getEntryValue(int i)
    {
        return ((EditText)findViewById(i)).getText().toString();
    }

    private Integer getInteger(int i)
    {
        Spinner spinner = (Spinner)findViewById(i);
        try
        {
            i = Integer.parseInt(spinner.getSelectedItem().toString());
        }
        catch (NumberFormatException numberformatexception)
        {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(i);
    }

    private SharedPreferences getPrefs()
    {
        return getSharedPreferences("stripe.auth", 0);
    }

    private void initAuthView()
    {
        formLayout.setVisibility(8);
        authPanelLayout = ((ViewStub)findViewById(com.stripe.android.R.id.stub_auth_id)).inflate();
        authPanelLayout.findViewById(com.stripe.android.R.id.stripe_new_account_button).setOnClickListener(this);
        authPanelLayout.findViewById(com.stripe.android.R.id.stripe_exisiting_button).setOnClickListener(this);
    }

    private void initPassView()
    {
        passPanelLayout = ((ViewStub)findViewById(com.stripe.android.R.id.stub_pass_panel)).inflate();
        View view = passPanelLayout.findViewById(com.stripe.android.R.id.stripe_auth_password);
        boolean flag;
        if (!rememberChecked)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setEnabled(flag);
        ((RadioButton)passPanelLayout.findViewById(com.stripe.android.R.id.stripe_remember)).setChecked(rememberChecked);
        passPanelLayout.findViewById(com.stripe.android.R.id.stripe_ok_do_charge).setOnClickListener(this);
        findViewById(com.stripe.android.R.id.stripe_choose_account).setVisibility(8);
    }

    private void initYearSpinner()
    {
        int i = 1;
        Spinner spinner = (Spinner)findViewById(com.stripe.android.R.id.stripe_expire_year);
        String as[] = new String[10];
        as[0] = getString(com.stripe.android.R.string.stripe_card_exp_year);
        int j = Calendar.getInstance().get(1);
        for (; i < 10; i++)
        {
            as[i] = String.valueOf((j + i) - 1);
        }

        ArrayAdapter arrayadapter = new ArrayAdapter(this, 0x1090008, as);
        arrayadapter.setDropDownViewResource(0x1090009);
        spinner.setAdapter(arrayadapter);
    }

    private void requestCustomsId()
    {
        changeProgressVisibility(0);
        formLayout.setVisibility(4);
        BaseSocialinApiRequestController basesocialinapirequestcontroller = RequestControllerFactory.createGetAliPayTokenController();
        basesocialinapirequestcontroller.setRequestCompleteListener(new d() {

            final StripeAuthActivity this$0;

            public void onCancelRequest(StripeTokenResponse stripetokenresponse, Request request)
            {
            }

            public volatile void onCancelRequest(Object obj, Request request)
            {
                onCancelRequest((StripeTokenResponse)obj, request);
            }

            public void onFailure(Exception exception, Request request)
            {
                changeProgressVisibility(8);
                formLayout.setVisibility(0);
            }

            public transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public void onSuccess(StripeTokenResponse stripetokenresponse, Request request)
            {
                changeProgressVisibility(8);
                if (!TextUtils.isEmpty(stripetokenresponse.message))
                {
                    Utils.a(instance, stripetokenresponse.message, 1);
                }
                if (!TextUtils.isEmpty(stripetokenresponse.cusomerId))
                {
                    initAuthView();
                    return;
                } else
                {
                    formLayout.setVisibility(0);
                    return;
                }
            }

            public volatile void onSuccess(Object obj, Request request)
            {
                onSuccess((StripeTokenResponse)obj, request);
            }

            
            {
                this$0 = StripeAuthActivity.this;
                super();
            }
        });
        basesocialinapirequestcontroller.doRequest();
    }

    private void saveUserDecision()
    {
        getPrefs().edit().putBoolean("stripe.pass", ((RadioButton)passPanelLayout.findViewById(com.stripe.android.R.id.stripe_remember)).isChecked()).apply();
    }

    private void storeStripeToken(String s)
    {
        StripeTokenParams stripetokenparams = new StripeTokenParams();
        stripetokenparams.tokenValue = s;
        RequestControllerFactory.createStoreAliPayTokenConroller().doRequest(null, stripetokenparams);
    }

    private void validateUser(String s)
    {
        changeProgressVisibility(0);
        UpdateUserController updateusercontroller = new UpdateUserController();
        UpdateUserParams updateuserparams = new UpdateUserParams();
        updateuserparams.passwordConfirm = s;
        updateusercontroller.setRequestParams(updateuserparams);
        updateusercontroller.setRequestCompleteListener(new d() {

            final StripeAuthActivity this$0;

            public void onCancelRequest(StatusObj statusobj, Request request)
            {
            }

            public volatile void onCancelRequest(Object obj, Request request)
            {
                onCancelRequest((StatusObj)obj, request);
            }

            public void onFailure(Exception exception, Request request)
            {
                changeProgressVisibility(8);
                Utils.a(instance, exception.getMessage(), 1);
            }

            public transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public void onSuccess(StatusObj statusobj, Request request)
            {
                changeProgressVisibility(8);
                saveUserDecision();
                chargeWithToken(null);
            }

            public volatile void onSuccess(Object obj, Request request)
            {
                onSuccess((StatusObj)obj, request);
            }

            
            {
                this$0 = StripeAuthActivity.this;
                super();
            }
        });
        updateusercontroller.doRequest();
    }

    public String getCardNumber()
    {
        return getEntryValue(com.stripe.android.R.id.stripe_card_number);
    }

    public String getCvc()
    {
        return getEntryValue(com.stripe.android.R.id.stripe_cvc);
    }

    public Integer getExpMonth()
    {
        return getInteger(com.stripe.android.R.id.stripe_expire_month);
    }

    public Integer getExpYear()
    {
        return getInteger(com.stripe.android.R.id.stripe_expire_year);
    }

    public void onClick(View view)
    {
        if (view.getId() == com.stripe.android.R.id.stripe_cancel_button)
        {
            exitWithError();
        } else
        {
            if (view.getId() == com.stripe.android.R.id.stripe_charge_button)
            {
                view = new Card(getCardNumber(), Integer.valueOf(getExpMonth().intValue()), Integer.valueOf(getExpYear().intValue()), getCvc());
                if (view.validateCard())
                {
                    createToken(view);
                    return;
                }
                if (!view.validateNumber())
                {
                    Utils.a(this, getString(com.stripe.android.R.string.stripe_invalid_card_number_msg), 1);
                    return;
                }
                if (!view.validateExpiryDate())
                {
                    Utils.a(this, getString(com.stripe.android.R.string.stripe_invalid_date_msg), 1);
                    return;
                }
                if (!view.validateCVC())
                {
                    Utils.a(this, getString(com.stripe.android.R.string.stripe_invalid_cvc_msg), 1);
                    return;
                } else
                {
                    Utils.a(this, getString(com.stripe.android.R.string.stripe_generic_error_msg), 1);
                    return;
                }
            }
            if (view.getId() == com.stripe.android.R.id.stripe_new_account_button)
            {
                authPanelLayout.setVisibility(8);
                formLayout.setVisibility(0);
                return;
            }
            if (view.getId() == com.stripe.android.R.id.stripe_exisiting_button)
            {
                initPassView();
                return;
            }
            if (view.getId() == com.stripe.android.R.id.stripe_ok_do_charge)
            {
                if (rememberChecked)
                {
                    saveUserDecision();
                    chargeWithToken(null);
                    return;
                }
                view = ((TextView)passPanelLayout.findViewById(com.stripe.android.R.id.stripe_auth_password)).getText().toString();
                if ("".equals(view) || view.contains(" "))
                {
                    Utils.a(instance, getString(com.stripe.android.R.string.error_empty_password), 1);
                    return;
                } else
                {
                    validateUser(view.trim());
                    return;
                }
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        if (getResources().getConfiguration().orientation == 2)
        {
            layoutparams.width = (getResources().getDisplayMetrics().widthPixels * 2) / 3;
        }
        layoutparams.gravity = 17;
        getWindow().setAttributes(layoutparams);
        if (getIntent() != null)
        {
            shopItemPrice = getIntent().getDoubleExtra("item.price", 0.0D);
        }
        rememberChecked = getPrefs().getBoolean("stripe.pass", false);
        instance = this;
        setContentView(com.stripe.android.R.layout.stripe_form_layout);
        formLayout = (LinearLayout)findViewById(com.stripe.android.R.id.stripe_form_parent);
        initYearSpinner();
        progressBar = (ProgressBar)findViewById(com.stripe.android.R.id.stripe_loading);
        findViewById(com.stripe.android.R.id.stripe_charge_button).setOnClickListener(this);
        findViewById(com.stripe.android.R.id.stripe_cancel_button).setOnClickListener(this);
        if (bundle != null)
        {
            if (bundle.getBoolean("pass.panel", false))
            {
                initAuthView();
                initPassView();
                return;
            }
            if (bundle.getBoolean("form.panel", false))
            {
                formLayout.setVisibility(0);
                return;
            } else
            {
                requestCustomsId();
                return;
            }
        } else
        {
            requestCustomsId();
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (passPanelLayout == null) goto _L2; else goto _L1
_L1:
        bundle.putBoolean("pass.panel", true);
_L4:
        super.onSaveInstanceState(bundle);
        return;
_L2:
        if (formLayout.getVisibility() == 0)
        {
            bundle.putBoolean("form.panel", true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }








}
