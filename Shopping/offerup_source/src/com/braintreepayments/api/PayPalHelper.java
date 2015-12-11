// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.models.PayPalAccountBuilder;
import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalOAuthScopes;
import com.paypal.android.sdk.payments.PayPalProfileSharingActivity;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PayPalTouchActivity;
import com.paypal.android.sdk.payments.PayPalTouchConfirmation;
import com.paypal.android.sdk.r;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class PayPalHelper
{

    private static final String OFFLINE = "offline";
    protected static boolean sEnableSignatureVerification = true;

    private PayPalHelper()
    {
        throw new IllegalStateException("Non-instantiable class.");
    }

    protected static PayPalConfiguration buildPayPalConfiguration(com.braintreepayments.api.models.PayPalConfiguration paypalconfiguration)
    {
        PayPalConfiguration paypalconfiguration1 = new PayPalConfiguration();
        if (paypalconfiguration.getEnvironment().equals("live"))
        {
            paypalconfiguration1.a("live");
        } else
        if (paypalconfiguration.getEnvironment().equals("offline"))
        {
            paypalconfiguration1.a("mock");
        } else
        {
            paypalconfiguration1.a(paypalconfiguration.getEnvironment());
        }
        return paypalconfiguration1.b(paypalconfiguration.getClientId()).c(paypalconfiguration.getDisplayName()).b(Uri.parse(paypalconfiguration.getUserAgreementUrl())).a(Uri.parse(paypalconfiguration.getPrivacyUrl()));
    }

    protected static Intent buildPayPalServiceIntent(Context context, com.braintreepayments.api.models.PayPalConfiguration paypalconfiguration)
    {
        context = new Intent(context, com/paypal/android/sdk/payments/PayPalService);
        context.putExtra("com.paypal.android.sdk.paypalConfiguration", buildPayPalConfiguration(paypalconfiguration));
        context.putExtra("com.paypal.android.sdk.enableAuthenticatorSecurity", sEnableSignatureVerification);
        if (paypalconfiguration.getEnvironment().equals("custom"))
        {
            context.putExtra("com.paypal.android.sdk.baseEnvironmentUrl", paypalconfiguration.getDirectBaseUrl());
            context.putExtra("com.paypal.android.sdk.enableStageSsl", false);
        }
        return context;
    }

    public static PayPalAccountBuilder getBuilderFromActivity(Activity activity, int i, Intent intent)
    {
        if (i == -1)
        {
            PayPalAccountBuilder paypalaccountbuilder = new PayPalAccountBuilder();
            if (activity != null)
            {
                paypalaccountbuilder.correlationId(PayPalConfiguration.a(activity));
            }
            activity = (PayPalTouchConfirmation)intent.getParcelableExtra("com.paypal.android.sdk.loginConfirmation");
            if (activity != null)
            {
                try
                {
                    activity = activity.a().getJSONObject("response");
                }
                // Misplaced declaration of an exception variable
                catch (Activity activity)
                {
                    return null;
                }
                paypalaccountbuilder.authorizationCode(activity.optString("authorization_code")).source("paypal-app");
                paypalaccountbuilder.email(activity.optString("email"));
            } else
            {
                activity = (PayPalAuthorization)intent.getParcelableExtra("com.paypal.android.sdk.authorization");
                paypalaccountbuilder.authorizationCode(activity.a()).source("paypal-sdk");
                try
                {
                    paypalaccountbuilder.email(activity.b().getJSONObject("user").getString("display_string"));
                }
                // Misplaced declaration of an exception variable
                catch (Activity activity) { }
            }
            return paypalaccountbuilder;
        }
        if (i == 2)
        {
            throw new ConfigurationException("Result extras were invalid");
        } else
        {
            return null;
        }
    }

    public static boolean isPayPalIntent(Intent intent)
    {
        return intent.hasExtra("com.paypal.android.sdk.loginConfirmation") || intent.hasExtra("com.paypal.android.sdk.authorization");
    }

    protected static void launchPayPal(Activity activity, int i, com.braintreepayments.api.models.PayPalConfiguration paypalconfiguration, List list)
    {
        Object obj = activity.getBaseContext();
        boolean flag = sEnableSignatureVerification;
        HashSet hashset;
        if ((new r()).a(((Context) (obj)), flag) && !paypalconfiguration.getEnvironment().equals("offline") && !paypalconfiguration.getTouchDisabled())
        {
            obj = com/paypal/android/sdk/payments/PayPalTouchActivity;
        } else
        {
            obj = com/paypal/android/sdk/payments/PayPalProfileSharingActivity;
        }
        hashset = new HashSet(Arrays.asList(new String[] {
            PayPalOAuthScopes.b, PayPalOAuthScopes.a
        }));
        if (list != null)
        {
            hashset.addAll(list);
        }
        activity.startActivityForResult((new Intent(activity, ((Class) (obj)))).putExtra("com.paypal.android.sdk.requested_scopes", new PayPalOAuthScopes(hashset)).putExtra("com.paypal.android.sdk.paypalConfiguration", buildPayPalConfiguration(paypalconfiguration)), i);
    }

    protected static void startPaypal(Context context, com.braintreepayments.api.models.PayPalConfiguration paypalconfiguration)
    {
        stopPaypalService(context);
        context.startService(buildPayPalServiceIntent(context, paypalconfiguration));
    }

    protected static void stopPaypalService(Context context)
    {
        context.stopService(new Intent(context, com/paypal/android/sdk/payments/PayPalService));
    }

}
