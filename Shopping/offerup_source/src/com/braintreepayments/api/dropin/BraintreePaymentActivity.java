// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.dropin;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import com.braintreepayments.api.Braintree;
import com.braintreepayments.api.exceptions.AuthenticationException;
import com.braintreepayments.api.exceptions.AuthorizationException;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.exceptions.DownForMaintenanceException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.exceptions.ServerException;
import com.braintreepayments.api.exceptions.UnexpectedException;
import com.braintreepayments.api.exceptions.UpgradeRequiredException;
import com.braintreepayments.api.models.AndroidPayCard;
import com.braintreepayments.api.models.Card;
import com.braintreepayments.api.models.PayPalAccount;
import com.braintreepayments.api.models.PaymentMethod;
import com.google.android.gms.wallet.Cart;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.braintreepayments.api.dropin:
//            Customization, AddPaymentMethodViewController, SelectPaymentMethodViewController, BraintreeViewController

public class BraintreePaymentActivity extends Activity
    implements com.braintreepayments.api.Braintree.BraintreeSetupFinishedListener, com.braintreepayments.api.Braintree.ErrorListener, com.braintreepayments.api.Braintree.PaymentMethodCreatedListener, com.braintreepayments.api.Braintree.PaymentMethodsUpdatedListener
{

    public static final int BRAINTREE_RESULT_DEVELOPER_ERROR = 2;
    public static final int BRAINTREE_RESULT_SERVER_ERROR = 3;
    public static final int BRAINTREE_RESULT_SERVER_UNAVAILABLE = 4;
    public static final String EXTRA_ANDROID_PAY_CART = "com.braintreepayments.api.dropin.EXTRA_CART";
    public static final String EXTRA_ANDROID_PAY_IS_BILLING_AGREEMENT = "com.braintreepayments.api.dropin.EXTRA_ANDROID_PAY_IS_BILLING_AGREEMENT";
    public static final String EXTRA_CLIENT_TOKEN = "com.braintreepayments.api.dropin.EXTRA_CLIENT_TOKEN";
    public static final String EXTRA_CUSTOMIZATION = "com.braintreepayments.api.dropin.EXTRA_CUSTOMIZATION";
    public static final String EXTRA_ERROR_MESSAGE = "com.braintreepayments.api.dropin.EXTRA_ERROR_MESSAGE";
    public static final String EXTRA_PAYMENT_METHOD = "com.braintreepayments.api.dropin.EXTRA_PAYMENT_METHOD";
    public static final String EXTRA_PAYMENT_METHOD_NONCE = "com.braintreepayments.api.dropin.EXTRA_PAYMENT_METHOD_NONCE";
    private static final String ON_PAYMENT_METHOD_ADD_FORM_KEY = "com.braintreepayments.api.dropin.PAYMENT_METHOD_ADD_FORM";
    private AddPaymentMethodViewController mAddPaymentMethodViewController;
    private Braintree mBraintree;
    private Customization mCustomization;
    private AtomicBoolean mHavePaymentMethodsBeenReceived;
    private Bundle mSavedInstanceState;
    private SelectPaymentMethodViewController mSelectPaymentMethodViewController;

    public BraintreePaymentActivity()
    {
        mHavePaymentMethodsBeenReceived = new AtomicBoolean(false);
    }

    private void customizeActionBar()
    {
        ActionBar actionbar;
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                actionbar = getActionBar();
                if (actionbar != null)
                {
                    if (TextUtils.isEmpty(mCustomization.getActionBarTitle()))
                    {
                        actionbar.setTitle(getString(R.string.bt_default_action_bar_text));
                    } else
                    {
                        actionbar.setTitle(mCustomization.getActionBarTitle());
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 14)
                    {
                        if (mCustomization.getActionBarLogo() != 0)
                        {
                            break label0;
                        }
                        actionbar.setLogo(new ColorDrawable(getResources().getColor(0x106000d)));
                    }
                }
            }
            return;
        }
        actionbar.setLogo(mCustomization.getActionBarLogo());
    }

    private View findView(int i)
    {
        return findViewById(i);
    }

    private void finishCreate()
    {
        mAddPaymentMethodViewController.endSubmit();
        initSelectPaymentMethodView();
        mSelectPaymentMethodViewController.onPaymentMethodSelected(0);
    }

    private String getClientToken()
    {
        String s1 = getIntent().getStringExtra("com.braintreepayments.api.dropin.EXTRA_CLIENT_TOKEN");
        String s = s1;
        if (s1 == null)
        {
            String s2 = mSavedInstanceState.getString("com.braintreepayments.api.dropin.EXTRA_CLIENT_TOKEN");
            s = s2;
            if (s2 == null)
            {
                throw new IllegalArgumentException((new StringBuilder("A client token must be specified with ")).append(com/braintreepayments/api/dropin/BraintreePaymentActivity.getSimpleName()).append(".EXTRA_CLIENT_TOKEN extra").toString());
            }
        }
        return s;
    }

    private Customization getCustomization()
    {
        Customization customization1 = (Customization)getIntent().getSerializableExtra("com.braintreepayments.api.dropin.EXTRA_CUSTOMIZATION");
        Customization customization = customization1;
        if (customization1 == null)
        {
            customization = (new Customization.CustomizationBuilder()).build();
        }
        return customization;
    }

    private void init()
    {
        mBraintree.setIntegrationDropin();
        mBraintree.sendAnalyticsEvent("sdk.initialized");
        mBraintree.addListener(this);
        mBraintree.unlockListeners();
        if (mBraintree.hasCachedCards())
        {
            if (mSavedInstanceState.getBoolean("com.braintreepayments.api.dropin.PAYMENT_METHOD_ADD_FORM"))
            {
                showAddPaymentMethodView();
                return;
            } else
            {
                onPaymentMethodsUpdated(mBraintree.getCachedPaymentMethods());
                return;
            }
        } else
        {
            mBraintree.getPaymentMethods();
            waitForData();
            return;
        }
    }

    private void initAddPaymentMethodView(View view)
    {
        if (mAddPaymentMethodViewController == null)
        {
            mAddPaymentMethodViewController = new AddPaymentMethodViewController(this, mSavedInstanceState, view, mBraintree, mCustomization);
        }
    }

    private void initSelectPaymentMethodView()
    {
        View view = StubbedView.SELECT_VIEW.show(this);
        if (mSelectPaymentMethodViewController == null)
        {
            mSelectPaymentMethodViewController = new SelectPaymentMethodViewController(this, mSavedInstanceState, view, mBraintree, mCustomization);
        } else
        {
            mSelectPaymentMethodViewController.setupPaymentMethod();
        }
        setActionBarUpEnabled(false);
    }

    private void saveState(BraintreeViewController braintreeviewcontroller, Bundle bundle)
    {
        if (braintreeviewcontroller != null)
        {
            braintreeviewcontroller.onSaveInstanceState(bundle);
        }
    }

    private void setActionBarUpEnabled(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            ActionBar actionbar = getActionBar();
            if (actionbar != null)
            {
                actionbar.setDisplayHomeAsUpEnabled(flag);
            }
        }
    }

    private void waitForData()
    {
        Executors.newScheduledThreadPool(1).schedule(new _cls2(), 10L, TimeUnit.SECONDS);
        showLoadingView();
    }

    protected void finalizeSelection(PaymentMethod paymentmethod)
    {
        mBraintree.sendAnalyticsEvent("sdk.exit.success");
        Intent intent = new Intent();
        intent.putExtra("com.braintreepayments.api.dropin.EXTRA_PAYMENT_METHOD", paymentmethod);
        intent.putExtra("com.braintreepayments.api.dropin.EXTRA_PAYMENT_METHOD_NONCE", paymentmethod.getNonce());
        setResult(-1, intent);
        finish();
    }

    protected Cart getAndroidPayCart()
    {
        return (Cart)getIntent().getParcelableExtra("com.braintreepayments.api.dropin.EXTRA_CART");
    }

    protected boolean getAndroidPayIsBillingAgreement()
    {
        return getIntent().getBooleanExtra("com.braintreepayments.api.dropin.EXTRA_ANDROID_PAY_IS_BILLING_AGREEMENT", false);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            if (i == 11876)
            {
                initAddPaymentMethodView(StubbedView.CARD_FORM.inflateOrFind(this));
                showLoadingView();
                mAddPaymentMethodViewController.onPaymentResult(i, j, intent);
            }
        } else
        {
            if (j == 0)
            {
                mBraintree.sendAnalyticsEvent("add-paypal.user-canceled");
            }
            if (i == 11876)
            {
                showAddPaymentMethodView();
                return;
            }
        }
    }

    public void onBackPressed()
    {
        if (StubbedView.CARD_FORM.mCurrentView && mBraintree.getCachedPaymentMethods().size() > 0)
        {
            initSelectPaymentMethodView();
        } else
        if (mAddPaymentMethodViewController == null || !mAddPaymentMethodViewController.isSubmitting())
        {
            if (mBraintree != null)
            {
                mBraintree.sendAnalyticsEvent("sdk.exit.user-canceled");
            }
            setResult(0);
            finish();
            return;
        }
    }

    public void onBraintreeSetupFinished(boolean flag, Braintree braintree, String s, Exception exception)
    {
        if (!flag)
        {
            setResult(3, (new Intent()).putExtra("com.braintreepayments.api.dropin.EXTRA_ERROR_MESSAGE", exception));
            finish();
            return;
        } else
        {
            mBraintree = braintree;
            init();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.bt_drop_in_ui);
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        mSavedInstanceState = bundle;
        mCustomization = getCustomization();
        customizeActionBar();
        mBraintree = Braintree.restoreSavedInstanceState(this, mSavedInstanceState);
        if (mBraintree != null)
        {
            init();
            return;
        } else
        {
            Braintree.setup(this, getClientToken(), this);
            showLoadingView();
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        super.onPause();
        if (mBraintree != null)
        {
            mBraintree.onPause(this);
        }
    }

    public void onPaymentMethodCreated(final PaymentMethod paymentMethod)
    {
        if (!(paymentMethod instanceof Card)) goto _L2; else goto _L1
_L1:
        if (paymentMethod.getSource() == null || !paymentMethod.getSource().equals("venmo-app")) goto _L4; else goto _L3
_L3:
        finishCreate();
_L6:
        return;
_L4:
        mBraintree.sendAnalyticsEvent("add-card.success");
        mAddPaymentMethodViewController.showSuccess();
        Executors.newScheduledThreadPool(1).schedule(new _cls1(), 1L, TimeUnit.SECONDS);
        return;
_L2:
        if (paymentMethod instanceof PayPalAccount)
        {
            mBraintree.sendAnalyticsEvent("add-paypal.success");
            finishCreate();
            return;
        }
        if (paymentMethod instanceof AndroidPayCard)
        {
            mBraintree.sendAnalyticsEvent("add-android-pay.success");
            finishCreate();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onPaymentMethodsUpdated(List list)
    {
        mHavePaymentMethodsBeenReceived.set(true);
        if (list.size() == 0)
        {
            showAddPaymentMethodView();
            return;
        } else
        {
            initSelectPaymentMethodView();
            return;
        }
    }

    public void onRecoverableError(ErrorWithResponse errorwithresponse)
    {
        mAddPaymentMethodViewController.setErrors(errorwithresponse);
    }

    protected void onResume()
    {
        super.onResume();
        if (mBraintree != null)
        {
            mBraintree.onResume(this);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("com.braintreepayments.api.dropin.EXTRA_CLIENT_TOKEN", getClientToken());
        if (StubbedView.CARD_FORM.mCurrentView)
        {
            bundle.putBoolean("com.braintreepayments.api.dropin.PAYMENT_METHOD_ADD_FORM", true);
        }
        saveState(mAddPaymentMethodViewController, bundle);
        saveState(mSelectPaymentMethodViewController, bundle);
        if (mBraintree != null)
        {
            mBraintree.onSaveInstanceState(bundle);
        }
    }

    public void onUnrecoverableError(Throwable throwable)
    {
        if (StubbedView.LOADING_VIEW.mCurrentView && !mHavePaymentMethodsBeenReceived.get())
        {
            mHavePaymentMethodsBeenReceived.set(true);
            showAddPaymentMethodView();
            return;
        }
        if (!(throwable instanceof AuthenticationException) && !(throwable instanceof AuthorizationException) && !(throwable instanceof UpgradeRequiredException) && !(throwable instanceof ConfigurationException)) goto _L2; else goto _L1
_L1:
        mBraintree.sendAnalyticsEvent("sdk.exit.developer-error");
        setResult(2, (new Intent()).putExtra("com.braintreepayments.api.dropin.EXTRA_ERROR_MESSAGE", throwable));
_L4:
        finish();
        return;
_L2:
        if ((throwable instanceof ServerException) || (throwable instanceof UnexpectedException))
        {
            mBraintree.sendAnalyticsEvent("sdk.exit.server-error");
            setResult(3, (new Intent()).putExtra("com.braintreepayments.api.dropin.EXTRA_ERROR_MESSAGE", throwable));
        } else
        if (throwable instanceof DownForMaintenanceException)
        {
            mBraintree.sendAnalyticsEvent("sdk.exit.server-unavailable");
            setResult(4, (new Intent()).putExtra("com.braintreepayments.api.dropin.EXTRA_ERROR_MESSAGE", throwable));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void showAddPaymentMethodView()
    {
        mBraintree.sendAnalyticsEvent("add-card.start");
        initAddPaymentMethodView(StubbedView.CARD_FORM.show(this));
        if (mBraintree.getCachedPaymentMethods().size() > 0)
        {
            setActionBarUpEnabled(true);
        }
    }

    protected void showLoadingView()
    {
        StubbedView.LOADING_VIEW.show(this);
    }



    private class StubbedView extends Enum
    {

        private static final StubbedView $VALUES[];
        public static final StubbedView CARD_FORM;
        public static final StubbedView LOADING_VIEW;
        public static final StubbedView SELECT_VIEW;
        private static int mAnimationDuration;
        private boolean mCurrentView;
        private final int mInflatedViewId;
        private final int mStubbedViewId;

        private long getDuration(Context context)
        {
            if (mAnimationDuration == 0)
            {
                mAnimationDuration = context.getResources().getInteger(0x10e0000);
            }
            return (long)mAnimationDuration;
        }

        public static StubbedView valueOf(String s)
        {
            return (StubbedView)Enum.valueOf(com/braintreepayments/api/dropin/BraintreePaymentActivity$StubbedView, s);
        }

        public static StubbedView[] values()
        {
            return (StubbedView[])$VALUES.clone();
        }

        final void hide(BraintreePaymentActivity braintreepaymentactivity)
        {
            if ((ViewStub)braintreepaymentactivity.findView(mStubbedViewId) == null)
            {
                braintreepaymentactivity.findView(mInflatedViewId).setVisibility(8);
            }
            mCurrentView = false;
        }

        final View inflateOrFind(BraintreePaymentActivity braintreepaymentactivity)
        {
            ViewStub viewstub = (ViewStub)braintreepaymentactivity.findView(mStubbedViewId);
            if (viewstub != null)
            {
                return viewstub.inflate();
            } else
            {
                return braintreepaymentactivity.findView(mInflatedViewId);
            }
        }

        final View show(BraintreePaymentActivity braintreepaymentactivity)
        {
            StubbedView astubbedview[] = values();
            int j = astubbedview.length;
            for (int i = 0; i < j; i++)
            {
                StubbedView stubbedview = astubbedview[i];
                if (this != stubbedview)
                {
                    stubbedview.hide(braintreepaymentactivity);
                }
            }

            View view = inflateOrFind(braintreepaymentactivity);
            if (android.os.Build.VERSION.SDK_INT >= 12)
            {
                view.setAlpha(0.0F);
                view.setVisibility(0);
                view.animate().alpha(1.0F).setDuration(getDuration(braintreepaymentactivity));
            } else
            {
                view.setVisibility(0);
            }
            mCurrentView = true;
            return view;
        }

        static 
        {
            LOADING_VIEW = new StubbedView("LOADING_VIEW", 0, R.id.bt_stub_loading_view, R.id.bt_inflated_loading_view);
            SELECT_VIEW = new StubbedView("SELECT_VIEW", 1, R.id.bt_stub_payment_methods_list, R.id.bt_inflated_payment_methods_list);
            CARD_FORM = new StubbedView("CARD_FORM", 2, R.id.bt_stub_payment_method_form, R.id.bt_inflated_payment_method_form);
            $VALUES = (new StubbedView[] {
                LOADING_VIEW, SELECT_VIEW, CARD_FORM
            });
        }


        private StubbedView(String s, int i, int j, int k)
        {
            super(s, i);
            mStubbedViewId = j;
            mInflatedViewId = k;
            mCurrentView = false;
        }
    }


    private class _cls2
        implements Runnable
    {

        final BraintreePaymentActivity this$0;

        public void run()
        {
            class _cls1
                implements Runnable
            {

                final _cls2 this$1;

                public void run()
                {
                    mHavePaymentMethodsBeenReceived.set(true);
                    showAddPaymentMethodView();
                }

                _cls1()
                {
                    this$1 = _cls2.this;
                    super();
                }
            }

            if (!mHavePaymentMethodsBeenReceived.get())
            {
                runOnUiThread(new _cls1());
            }
        }

        _cls2()
        {
            this$0 = BraintreePaymentActivity.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final BraintreePaymentActivity this$0;
        final PaymentMethod val$paymentMethod;

        public void run()
        {
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;

                public void run()
                {
                    finalizeSelection(paymentMethod);
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    super();
                }
            }

            runOnUiThread(new _cls1());
        }

        _cls1()
        {
            this$0 = BraintreePaymentActivity.this;
            paymentMethod = paymentmethod;
            super();
        }
    }

}
