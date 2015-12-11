// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.braintreepayments.api.data.BraintreeData;
import com.braintreepayments.api.data.BraintreeEnvironment;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.exceptions.ServerException;
import com.braintreepayments.api.internal.HttpRequest;
import com.braintreepayments.api.internal.HttpResponse;
import com.braintreepayments.api.models.AnalyticsConfiguration;
import com.braintreepayments.api.models.AnalyticsRequest;
import com.braintreepayments.api.models.AndroidPayCard;
import com.braintreepayments.api.models.AndroidPayConfiguration;
import com.braintreepayments.api.models.ClientToken;
import com.braintreepayments.api.models.CoinbaseAccount;
import com.braintreepayments.api.models.CoinbaseAccountBuilder;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PayPalAccount;
import com.braintreepayments.api.models.PayPalAccountBuilder;
import com.braintreepayments.api.models.PaymentMethod;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.PaymentMethodToken;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters;
import com.google.gson.Gson;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.braintreepayments.api:
//            VenmoAppSwitch, Coinbase, AndroidPay, PayPalHelper

public class BraintreeApi
{

    private static final String PAYMENT_METHOD_ENDPOINT = "payment_methods";
    private AndroidPay mAndroidPay;
    private Object mBraintreeData;
    private ClientToken mClientToken;
    private Coinbase mCoinbase;
    private Configuration mConfiguration;
    private Context mContext;
    private HttpRequest mHttpRequest;
    private VenmoAppSwitch mVenmoAppSwitch;

    protected BraintreeApi(Context context, ClientToken clienttoken)
    {
        mContext = context.getApplicationContext();
        mClientToken = clienttoken;
        mHttpRequest = new HttpRequest(mClientToken.getAuthorizationFingerprint());
    }

    protected BraintreeApi(Context context, ClientToken clienttoken, Configuration configuration, HttpRequest httprequest)
    {
        mContext = context.getApplicationContext();
        mClientToken = clienttoken;
        mConfiguration = configuration;
        mHttpRequest = httprequest;
        if (configuration != null)
        {
            mHttpRequest.setBaseUrl(configuration.getClientApiUrl());
        }
        mBraintreeData = null;
        mVenmoAppSwitch = new VenmoAppSwitch(mContext, mConfiguration);
        mCoinbase = new Coinbase(mContext, mConfiguration);
    }

    public BraintreeApi(Context context, String s)
    {
        String s1 = s;
        if (Pattern.compile("([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)").matcher(s).matches())
        {
            s1 = new String(Base64.decode(s, 0));
        }
        mClientToken = ClientToken.fromString(s1);
        mContext = context.getApplicationContext();
        mConfiguration = Configuration.fromJson(s1);
        mHttpRequest = new HttpRequest(mClientToken.getAuthorizationFingerprint());
        mHttpRequest.setBaseUrl(mConfiguration.getClientApiUrl());
        mBraintreeData = null;
        mVenmoAppSwitch = new VenmoAppSwitch(context, mConfiguration);
        mCoinbase = new Coinbase(context, mConfiguration);
    }

    protected BraintreeApi(Context context, String s, String s1)
    {
        this(context, ClientToken.fromString(s), Configuration.fromJson(s1), new HttpRequest(ClientToken.fromString(s).getAuthorizationFingerprint()));
    }

    private Configuration getConfiguration()
    {
        String s = Uri.parse(mClientToken.getConfigUrl()).buildUpon().appendQueryParameter("configVersion", "3").build().toString();
        return Configuration.fromJson(mHttpRequest.get(s).getResponseBody());
    }

    private String jsonForType(String s, String s1)
    {
        try
        {
            s = (new JSONObject(s)).getJSONArray(s1).get(0).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ServerException("Parsing server response failed");
        }
        return s;
    }

    private String versionedPath(String s)
    {
        return (new StringBuilder("/v1/")).append(s).toString();
    }

    public String collectDeviceData(Activity activity, BraintreeEnvironment braintreeenvironment)
    {
        return collectDeviceData(activity, braintreeenvironment.getMerchantId(), braintreeenvironment.getCollectorUrl());
    }

    public String collectDeviceData(Activity activity, String s, String s1)
    {
        try
        {
            mBraintreeData = new BraintreeData(activity, s, s1);
            s = ((BraintreeData)mBraintreeData).collectDeviceData();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return (new StringBuilder("{\"correlation_id\":\"")).append(PayPalConfiguration.a(activity)).append("\"}").toString();
        }
        return s;
    }

    public PaymentMethod create(com.braintreepayments.api.models.PaymentMethod.Builder builder)
    {
        return builder.fromJson(jsonForType(mHttpRequest.post(versionedPath((new StringBuilder("payment_methods/")).append(builder.getApiPath()).toString()), builder.toJsonString()).getResponseBody(), builder.getApiResource()));
    }

    protected void disconnectGoogleApiClient()
    {
        if (mAndroidPay != null)
        {
            mAndroidPay.disconnect();
        }
    }

    protected CoinbaseAccount finishPayWithCoinbase(Intent intent)
    {
        Object obj = (Uri)intent.getParcelableExtra("com.braintreepayments.api.BraintreeBrowserSwitchActivity.EXTRA_REDIRECT_URL");
        obj = (new CoinbaseAccountBuilder()).code(mCoinbase.parseResponse(((Uri) (obj)))).redirectUri(mCoinbase.getRedirectUri()).source("coinbase-browser");
        if (intent.getBooleanExtra("store-in-vault", false))
        {
            ((CoinbaseAccountBuilder) (obj)).storeInVault(true);
        }
        return (CoinbaseAccount)create(((com.braintreepayments.api.models.PaymentMethod.Builder) (obj)));
    }

    public PayPalAccount finishPayWithPayPal(int i, Intent intent)
    {
        Object obj = null;
        PayPalAccountBuilder paypalaccountbuilder = handlePayPalResponse(null, i, intent);
        intent = obj;
        if (paypalaccountbuilder != null)
        {
            intent = (PayPalAccount)create(paypalaccountbuilder);
        }
        return intent;
    }

    public PayPalAccount finishPayWithPayPal(Activity activity, int i, Intent intent)
    {
        activity = handlePayPalResponse(activity, i, intent);
        if (activity != null)
        {
            return (PayPalAccount)create(activity);
        } else
        {
            return null;
        }
    }

    public String finishPayWithVenmo(int i, Intent intent)
    {
        return mVenmoAppSwitch.handleAppSwitchResponse(i, intent);
    }

    protected PaymentMethodTokenizationParameters getAndroidPayTokenizationParameters()
    {
        if (mAndroidPay == null)
        {
            mAndroidPay = new AndroidPay(mConfiguration);
        }
        return mAndroidPay.getTokenizationParameters();
    }

    protected String getConfigurationString()
    {
        if (mConfiguration != null)
        {
            return (new Gson()).toJson(mConfiguration);
        } else
        {
            return null;
        }
    }

    protected AndroidPayCard getNonceFromAndroidPayFullWalletResponse(Intent intent)
    {
        if (AndroidPay.isFullWalletResponse(intent))
        {
            intent = (new JSONObject(((FullWallet)intent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET")).getPaymentMethodToken().getToken())).getJSONArray("androidPayCards");
            if (intent.length() > 0)
            {
                return (AndroidPayCard)(new Gson()).fromJson(intent.getString(0), com/braintreepayments/api/models/AndroidPayCard);
            }
        }
        return null;
    }

    protected PaymentMethod getPaymentMethod(String s)
    {
        s = PaymentMethod.parsePaymentMethods(mHttpRequest.get(versionedPath((new StringBuilder("payment_methods/")).append(s).toString())).getResponseBody());
        if (s.size() == 1)
        {
            return (PaymentMethod)s.get(0);
        }
        if (s.size() > 1)
        {
            throw new ServerException("Expected one payment method, got multiple payment methods");
        } else
        {
            throw new ServerException("No payment methods were found for nonce");
        }
    }

    public List getPaymentMethods()
    {
        return PaymentMethod.parsePaymentMethods(mHttpRequest.get(versionedPath("payment_methods")).getResponseBody());
    }

    public PayPalAccountBuilder handlePayPalResponse(Activity activity, int i, Intent intent)
    {
        PayPalHelper.stopPaypalService(mContext);
        return PayPalHelper.getBuilderFromActivity(activity, i, intent);
    }

    protected boolean isAndroidPayEnabled()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            int i;
            try
            {
                if (!mConfiguration.getAndroidPay().isEnabled())
                {
                    break label0;
                }
                i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(mContext);
            }
            catch (NoClassDefFoundError noclassdeffounderror)
            {
                return false;
            }
            flag = flag1;
            if (i == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    protected boolean isCoinbaseEnabled()
    {
        return mCoinbase.isAvailable();
    }

    public boolean isCvvChallengePresent()
    {
        return mConfiguration.isCvvChallengePresent();
    }

    public boolean isPayPalEnabled()
    {
        return mConfiguration.isPayPalEnabled();
    }

    public boolean isPostalCodeChallengePresent()
    {
        return mConfiguration.isPostalCodeChallengePresent();
    }

    protected boolean isSetup()
    {
        return mConfiguration != null;
    }

    public boolean isThreeDSecureEnabled()
    {
        return mConfiguration.isThreeDSecureEnabled();
    }

    public boolean isVenmoEnabled()
    {
        return mVenmoAppSwitch.isAvailable();
    }

    protected void performAndroidPayChangeMaskedWalletRequest(Activity activity, int i, String s)
    {
        if (mAndroidPay == null)
        {
            mAndroidPay = new AndroidPay(mConfiguration);
        }
        mAndroidPay.performChangeMaskedWalletRequest(activity, i, s);
    }

    protected void performAndroidPayFullWalletRequest(Activity activity, int i, Cart cart, String s)
    {
        if (mAndroidPay == null)
        {
            mAndroidPay = new AndroidPay(mConfiguration);
        }
        if (cart != null)
        {
            mAndroidPay.setCart(cart);
        }
        mAndroidPay.performFullWalletRequest(activity, i, s);
    }

    protected void performAndroidPayMaskedWalletRequest(Activity activity, int i, Cart cart, boolean flag, boolean flag1, boolean flag2)
    {
        if (flag && cart != null)
        {
            throw new InvalidArgumentException("The cart must be null when isBillingAgreement is true");
        }
        if (!flag && cart == null)
        {
            throw new InvalidArgumentException("Cart cannot be null unless isBillingAgreement is true");
        }
        if (mAndroidPay == null)
        {
            mAndroidPay = new AndroidPay(mConfiguration);
        }
        mAndroidPay.setCart(cart);
        mAndroidPay.performMaskedWalletRequest(activity, i, flag, flag1, flag2);
    }

    public void sendAnalyticsEvent(String s, String s1)
    {
        if (!mConfiguration.isAnalyticsEnabled())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        s = new AnalyticsRequest(mContext, s, s1);
        mHttpRequest.post(mConfiguration.getAnalytics().getUrl(), s.toJson());
        return;
        s;
        return;
        s;
    }

    protected void setup()
    {
        mConfiguration = getConfiguration();
        mHttpRequest.setBaseUrl(mConfiguration.getClientApiUrl());
        mBraintreeData = null;
        mVenmoAppSwitch = new VenmoAppSwitch(mContext, mConfiguration);
        mCoinbase = new Coinbase(mContext, mConfiguration);
    }

    protected boolean startPayWithCoinbase(Activity activity)
    {
        Intent intent = mCoinbase.getLaunchIntent();
        if (intent != null)
        {
            activity.startActivity(intent);
            return true;
        } else
        {
            return false;
        }
    }

    public void startPayWithPayPal(Activity activity, int i, List list)
    {
        PayPalHelper.startPaypal(activity.getApplicationContext(), mConfiguration.getPayPal());
        PayPalHelper.launchPayPal(activity, i, mConfiguration.getPayPal(), list);
    }

    public void startPayWithVenmo(Activity activity, int i)
    {
        mVenmoAppSwitch.launch(activity, i);
    }

    public ThreeDSecureLookup threeDSecureLookup(String s, String s1)
    {
        s1 = (new JSONObject()).put("merchantAccountId", mConfiguration.getMerchantAccountId()).put("amount", s1);
        return ThreeDSecureLookup.fromJson(mHttpRequest.post(versionedPath((new StringBuilder("payment_methods/")).append(s).append("/three_d_secure/lookup").toString()), s1.toString()).getResponseBody());
    }

    public String tokenize(com.braintreepayments.api.models.PaymentMethod.Builder builder)
    {
        return create(builder.validate(false)).getNonce();
    }
}
