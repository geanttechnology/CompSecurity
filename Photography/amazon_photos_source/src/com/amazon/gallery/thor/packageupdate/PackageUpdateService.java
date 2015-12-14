// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.packageupdate;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.customer.CustomerMetricsInfo;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.ThorNativeGalleryActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PackageUpdateService extends IntentService
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent MandatoryUpdateNotification;
        public static final MetricsEvent OptionalUpdateNotification;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/packageupdate/PackageUpdateService$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            MandatoryUpdateNotification = new MetricsEvent("MandatoryUpdateNotification", 0);
            OptionalUpdateNotification = new MetricsEvent("OptionalUpdateNotification", 1);
            $VALUES = (new MetricsEvent[] {
                MandatoryUpdateNotification, OptionalUpdateNotification
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/thor/packageupdate/PackageUpdateService.getName();
    private CloudFrontConfig cloudFrontConfig;
    private CustomerMetricsInfo customerMetricsInfo;
    private ComponentProfiler profiler;
    private RestClient restClient;

    public PackageUpdateService()
    {
        super(com/amazon/gallery/thor/packageupdate/PackageUpdateService.getSimpleName());
    }

    private void showMandatoryUpdateNotification()
    {
        Context context = getApplicationContext();
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (sharedpreferences.getLong("mandatoryNotificationDismissedDate", 0L) != 0L)
        {
            return;
        } else
        {
            ((NotificationManager)context.getSystemService("notification")).cancel(0x7f0e01d4);
            showNotification(context, 0x7f0201f2, context.getResources().getString(0x7f0e01cb), context.getResources().getString(0x7f0e01ca));
            profiler.trackEvent(MetricsEvent.MandatoryUpdateNotification);
            sharedpreferences.edit().putLong("mandatoryNotificationDismissedDate", SystemClock.uptimeMillis()).apply();
            return;
        }
    }

    private static void showNotification(Context context, int i, String s, String s1)
    {
        Object obj = new Intent(context, com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity);
        ((Intent) (obj)).setFlags(0x10000000);
        obj = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0);
        s = (new android.support.v4.app.NotificationCompat.Builder(context)).setSmallIcon(i).setContentTitle(s).setContentText(s1).setContentIntent(((PendingIntent) (obj))).setTicker(s).setWhen(System.currentTimeMillis()).build();
        ((NotificationManager)context.getSystemService("notification")).notify(0x7f0e01cb, s);
    }

    private void showOptionalUpdateNotification()
    {
        Context context = getApplicationContext();
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (sharedpreferences.getLong("optionalNotificationDismissedDate", 0L) != 0L)
        {
            return;
        } else
        {
            showNotification(context, 0x7f0201e9, context.getResources().getString(0x7f0e01d4), context.getResources().getString(0x7f0e01d3));
            profiler.trackEvent(MetricsEvent.OptionalUpdateNotification);
            sharedpreferences.edit().putLong("optionalNotificationDismissedDate", SystemClock.uptimeMillis()).apply();
            return;
        }
    }

    public static boolean versionNameMatch(JSONArray jsonarray, String s)
        throws JSONException
    {
        for (int i = 0; i < jsonarray.length(); i++)
        {
            if (jsonarray.getString(i).equals(s))
            {
                return true;
            }
        }

        return false;
    }

    public void onCreate()
    {
        super.onCreate();
        cloudFrontConfig = (CloudFrontConfig)ThorGalleryApplication.getBean(Keys.CLOUD_FRONT_CONFIG);
        restClient = (RestClient)ThorGalleryApplication.getBean(Keys.REST_CLIENT);
        profiler = new ComponentProfiler((Profiler)ThorGalleryApplication.getBean(Keys.PROFILER), getClass());
        customerMetricsInfo = (CustomerMetricsInfo)ThorGalleryApplication.getBean(Keys.CUSTOMER_METRICS_INFO);
    }

    protected void onHandleIntent(Intent intent)
    {
        intent = (JSONObject)NetworkExecutor.getInstance().execute(restClient.getUpdateConfigOperation(cloudFrontConfig));
        if (intent == null)
        {
            return;
        }
        String s;
        s = intent.toString();
        Object obj = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (!s.equals(((SharedPreferences) (obj)).getString("update_config_key", null)))
        {
            ((SharedPreferences) (obj)).edit().putLong("optionalNotificationDismissedDate", 0L);
        }
        ((SharedPreferences) (obj)).edit().putString("update_config_key", s).apply();
        s = customerMetricsInfo.getAppVersionName();
        obj = intent.getJSONArray("mandatory_update");
        intent = intent.getJSONArray("optional_update_available");
        if (versionNameMatch(((JSONArray) (obj)), s))
        {
            showMandatoryUpdateNotification();
            return;
        }
          goto _L1
        intent;
_L3:
        GLogger.i(TAG, "Unable to retrieve and parse the update config: %s", new Object[] {
            intent
        });
        return;
_L1:
        if (versionNameMatch(intent, s))
        {
            showOptionalUpdateNotification();
            return;
        }
        break; /* Loop/switch isn't completed */
        intent;
        if (true) goto _L3; else goto _L2
_L2:
    }

}
