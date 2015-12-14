// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class ReportIssueUtility
{

    private static Map MARKETPLACE_TO_CS_EMAILS;
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd HH:mm");

    public ReportIssueUtility()
    {
    }

    private String buildEmailBody(Context context, String s)
    {
        s = String.format("%n%n%nModel: %s (%s)%nOS version: %s (%s)%nCarrier: %s%nApp version: %s %nScreen: %s%nCustomer Id: %s%n%n", new Object[] {
            Build.MODEL, Locale.getDefault().toString(), android.os.Build.VERSION.RELEASE, Integer.valueOf(android.os.Build.VERSION.SDK_INT), getCarrierName(context), s, describeScreen(context), (new AospPreferences(context)).getCustomerId()
        });
        return (new StringBuilder(context.getResources().getString(0x7f0e01d6))).append(s).append(context.getResources().getString(0x7f0e01d7)).toString();
    }

    private String buildEmailSubject(Context context)
    {
        return (new StringBuilder()).append(context.getResources().getString(0x7f0e01d9)).append(" | ").append(Build.MODEL).append(" | ").append(dateFormatter.format(new Date())).toString();
    }

    private Intent createEmailIntent(Context context, String s)
    {
        return new Intent("android.intent.action.SENDTO", Uri.parse(String.format("mailto:%s?subject=%s&body=%s", new Object[] {
            StringUtils.join(getCustomerSupportEmailAddresses(), ','), Uri.encode(buildEmailSubject(context)), Uri.encode(buildEmailBody(context, s))
        })));
    }

    private String describeScreen(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        return (new StringBuilder()).append("(").append(((DisplayMetrics) (context)).widthPixels).append("x").append(((DisplayMetrics) (context)).heightPixels).append(", Density=").append(((DisplayMetrics) (context)).heightPixels).append(")").toString();
    }

    private String getCarrierName(Context context)
    {
label0:
        {
            String s = "UNKNOWN_CARRIER";
            TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
            context = s;
            if (telephonymanager == null)
            {
                break label0;
            }
            s = telephonymanager.getSimOperatorName();
            if (s != null)
            {
                context = s;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            context = telephonymanager.getNetworkOperatorName();
        }
        return context;
    }

    private String[] getCustomerSupportEmailAddresses()
    {
        Endpoint endpoint = ((RestClient)ThorGalleryApplication.getBean(Keys.REST_CLIENT)).getEndpointManager().getCachedEndpoint();
        return (new String[] {
            (String)MARKETPLACE_TO_CS_EMAILS.get(endpoint.getExactMarketplace()), getFeedbackEmailAddressForMarketPlace(endpoint)
        });
    }

    private String getFeedbackEmailAddressForMarketPlace(Endpoint endpoint)
    {
        String s = "amazon.com";
        String s2 = endpoint.getHttpHostString();
        endpoint = s;
        if (!StringUtils.isEmpty(s2))
        {
            String s1;
            if (s2.startsWith("www."))
            {
                s1 = s2.substring(4);
            } else
            {
                s1 = s2;
            }
            endpoint = s1;
            if (s1.contains("amazon.in"))
            {
                endpoint = "amazon.com";
            }
        }
        return (new StringBuilder()).append("clouddrive-android-feedback@").append(endpoint).toString();
    }

    public void sendEmail(Activity activity, String s)
    {
        if (((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY)).promptIfOffline(activity))
        {
            return;
        }
        try
        {
            activity.startActivity(createEmailIntent(activity, s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Toast.makeText(activity, activity.getResources().getString(0x7f0e01d8, new Object[] {
                getCustomerSupportEmailAddresses()[0]
            }), 1).show();
        }
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.US, "cloud-drive-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.UK, "cloud-drive-uk-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.GERMANY, "cloud-drive-de-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.FRANCE, "cloud-drive-fr-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.ITALY, "cloud-drive-it-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.SPAIN, "cloud-drive-es-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.JAPAN, "cloud-drive-jp-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.CHINA, "cloud-drive-cn-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.CANADA, "cloud-drive-ca-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.AUSTRALIA, "cloud-drive-au-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.INDIA, "cloud-drive-na-queue@amazon.com");
        hashmap.put(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.UNKNOWN, "cloud-drive-queue@amazon.com");
        MARKETPLACE_TO_CS_EMAILS = Collections.unmodifiableMap(hashmap);
    }
}
