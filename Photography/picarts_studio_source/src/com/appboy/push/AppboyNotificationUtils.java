// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appboy.push;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import com.appboy.Appboy;
import com.appboy.AppboyAdmReceiver;
import com.appboy.AppboyGcmReceiver;
import com.appboy.Constants;
import com.appboy.IAppboyNotificationFactory;
import java.util.Iterator;
import myobfuscated.d.b;
import myobfuscated.i.a;
import myobfuscated.i.c;
import myobfuscated.i.d;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.appboy.push:
//            AppboyNotificationFactory, AppboyNotificationStyleFactory

public class AppboyNotificationUtils
{

    public static final String APPBOY_NOTIFICATION_OPENED_SUFFIX = ".intent.APPBOY_NOTIFICATION_OPENED";
    public static final String APPBOY_NOTIFICATION_RECEIVED_SUFFIX = ".intent.APPBOY_PUSH_RECEIVED";
    private static final String SOURCE_KEY = "source";
    private static final String TAG;

    public AppboyNotificationUtils()
    {
    }

    public static String bundleOptString(Bundle bundle, String s, String s1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            s1 = bundle.getString(s, s1);
        } else
        {
            bundle = bundle.getString(s);
            if (bundle != null)
            {
                return bundle;
            }
        }
        return s1;
    }

    public static void cancelNotification(Context context, int i)
    {
        try
        {
            Intent intent = (new Intent("com.appboy.action.CANCEL_NOTIFICATION")).setClass(context, getNotificationReceiverClass());
            intent.putExtra("nid", i);
            context.sendBroadcast(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            a.c(TAG, "Exception occurred attempting to cancel notification.", context);
        }
    }

    public static IAppboyNotificationFactory getActiveNotificationFactory()
    {
        IAppboyNotificationFactory iappboynotificationfactory = Appboy.getCustomAppboyNotificationFactory();
        Object obj = iappboynotificationfactory;
        if (iappboynotificationfactory == null)
        {
            obj = AppboyNotificationFactory.getInstance();
        }
        return ((IAppboyNotificationFactory) (obj));
    }

    public static Bundle getAppboyExtras(Bundle bundle)
    {
        Bundle bundle1;
        if (bundle == null)
        {
            bundle1 = null;
        } else
        {
            bundle1 = bundle;
            if (!Constants.IS_AMAZON.booleanValue())
            {
                return bundle.getBundle("extra");
            }
        }
        return bundle1;
    }

    public static Bundle getAppboyExtrasWithoutPreprocessing(Bundle bundle)
    {
        if (bundle == null)
        {
            return null;
        }
        if (!Constants.IS_AMAZON.booleanValue())
        {
            return parseJSONStringDictionaryIntoBundle(bundleOptString(bundle, "extra", "{}"));
        } else
        {
            return new Bundle(bundle);
        }
    }

    public static int getNotificationId(Bundle bundle)
    {
        if (bundle != null)
        {
            if (bundle.containsKey("n"))
            {
                int i;
                try
                {
                    i = Integer.parseInt(bundle.getString("n"));
                    String.format((new StringBuilder("Using notification id provided in the message's extras bundle: ")).append(i).toString(), new Object[0]);
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    a.c(TAG, String.format("Unable to parse notification id provided in the message's extras bundle. Using default notification id instead: -1", new Object[0]), bundle);
                    return -1;
                }
                return i;
            } else
            {
                int j = (new StringBuilder()).append(bundleOptString(bundle, "t", "")).append(bundleOptString(bundle, "a", "")).toString().hashCode();
                String.format((new StringBuilder("Message without notification id provided in the extras bundle received.  Using a hash of the message: ")).append(j).toString(), new Object[0]);
                return j;
            }
        } else
        {
            String.format("Message without extras bundle received.  Using default notification id: -1", new Object[0]);
            return -1;
        }
    }

    public static int getNotificationPriority(Bundle bundle)
    {
        if (bundle == null || !bundle.containsKey("p"))
        {
            break MISSING_BLOCK_LABEL_55;
        }
        int i = Integer.parseInt(bundle.getString("p"));
        if (isValidNotificationPriority(i))
        {
            return i;
        }
        try
        {
            a.c(TAG, String.format("Received invalid notification priority %d", new Object[] {
                Integer.valueOf(i)
            }));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            a.c(TAG, String.format("Unable to parse custom priority. Returning default priority of 0", new Object[0]), bundle);
        }
        return 0;
    }

    public static Class getNotificationReceiverClass()
    {
        if (Constants.IS_AMAZON.booleanValue())
        {
            return com/appboy/AppboyAdmReceiver;
        } else
        {
            return com/appboy/AppboyGcmReceiver;
        }
    }

    static String getOptionalStringResource(Resources resources, int i, String s)
    {
        try
        {
            resources = resources.getString(i);
        }
        // Misplaced declaration of an exception variable
        catch (Resources resources)
        {
            return s;
        }
        return resources;
    }

    public static void handleCancelNotificationAction(Context context, Intent intent)
    {
        try
        {
            if (intent.hasExtra("nid"))
            {
                int i = intent.getIntExtra("nid", -1);
                ((NotificationManager)context.getSystemService("notification")).cancel("appboy_notification", i);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            a.c(TAG, "Exception occurred handling cancel notification intent.", context);
        }
    }

    public static void handleNotificationOpened(Context context, Intent intent)
    {
        try
        {
            logNotificationOpened(context, intent);
            sendNotificationOpenedBroadcast(context, intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            a.c(TAG, "Exception occurred attempting to handle notification.", context);
        }
    }

    public static boolean isAppboyPushMessage(Intent intent)
    {
        intent = intent.getExtras();
        return intent != null && "true".equals(intent.getString("_ab"));
    }

    public static boolean isNotificationMessage(Intent intent)
    {
        intent = intent.getExtras();
        return intent != null && intent.containsKey("t") && intent.containsKey("a");
    }

    public static boolean isUninstallTrackingPush(Bundle bundle)
    {
        if (bundle != null)
        {
            if (bundle.containsKey("appboy_uninstall_tracking"))
            {
                return true;
            }
            bundle = bundle.getBundle("extra");
            if (bundle != null)
            {
                return bundle.containsKey("appboy_uninstall_tracking");
            }
        }
        return false;
    }

    public static boolean isValidNotificationPriority(int i)
    {
        return i >= -2 && i <= 2;
    }

    public static boolean isValidNotificationVisibility(int i)
    {
        return i == -1 || i == 0 || i == 1;
    }

    public static void logBaiduNotificationClick(Context context, String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        a.b(TAG, "customContentString was null. Doing nothing.");
_L4:
        return;
_L2:
        String s1;
        Object obj;
        obj = new JSONObject(s);
        s1 = ((JSONObject) (obj)).optString("source", null);
        obj = ((JSONObject) (obj)).optString("cid", null);
        if (s1 == null) goto _L4; else goto _L3
_L3:
        if (!"Appboy".equals(s1) || obj == null) goto _L4; else goto _L5
_L5:
        try
        {
            Appboy.getInstance(context).logPushNotificationOpened(((String) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            a.c(TAG, String.format("Caught an exception processing customContentString: %s", new Object[] {
                s
            }), context);
        }
        return;
    }

    private static void logNotificationOpened(Context context, Intent intent)
    {
        intent = intent.getStringExtra("cid");
        if (intent != null)
        {
            a.a(TAG, String.format((new StringBuilder("Logging push click to Appboy. Campaign Id: ")).append(intent).toString(), new Object[0]));
            Appboy.getInstance(context).logPushNotificationOpened(intent);
            return;
        } else
        {
            a.a(TAG, String.format("No campaign Id associated with this notification. Not logging push click to Appboy.", new Object[0]));
            return;
        }
    }

    public static Bundle parseJSONStringDictionaryIntoBundle(String s)
    {
        Bundle bundle;
        try
        {
            bundle = new Bundle();
            s = new JSONObject(s);
            String s1;
            for (Iterator iterator = s.keys(); iterator.hasNext(); bundle.putString(s1, s.getString(s1)))
            {
                s1 = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            a.c(TAG, String.format("Unable parse JSON into a bundle.", new Object[0]), s);
            return null;
        }
        return bundle;
    }

    static void sendNotificationOpenedBroadcast(Context context, Intent intent)
    {
        Intent intent1 = new Intent((new StringBuilder()).append(c.a(context)).append(".intent.APPBOY_NOTIFICATION_OPENED").toString());
        if (intent.getExtras() != null)
        {
            intent1.putExtras(intent.getExtras());
        }
        context.sendBroadcast(intent1);
    }

    public static void sendPushMessageReceivedBroadcast(Context context, Bundle bundle)
    {
        Intent intent = new Intent((new StringBuilder()).append(context.getPackageName()).append(".intent.APPBOY_PUSH_RECEIVED").toString());
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        context.sendBroadcast(intent);
    }

    public static void setAccentColorIfPresentAndSupported(b b1, android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                if (bundle == null || !bundle.containsKey("ac"))
                {
                    break label0;
                }
                builder.setColor((int)Long.parseLong(bundle.getString("ac")));
            }
            return;
        }
        builder.setColor(b1.getIntValue("com_appboy_default_notification_accent_color", 0));
    }

    public static void setCategoryIfPresentAndSupported(android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21 && bundle != null && bundle.containsKey("ab_ct"))
        {
            builder.setCategory(bundle.getString("ab_ct"));
        }
    }

    public static void setContentIfPresent(android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
        if (bundle != null)
        {
            builder.setContentText(bundle.getString("a"));
        }
    }

    public static void setContentIntentIfPresent(Context context, android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
        Intent intent;
        try
        {
            intent = (new Intent("com.appboy.action.APPBOY_PUSH_CLICKED")).setClass(context, getNotificationReceiverClass());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            a.c(TAG, "Error setting content.", context);
            return;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        intent.putExtras(bundle);
        builder.setContentIntent(PendingIntent.getBroadcast(context, myobfuscated.i.b.a(), intent, 0x40000000));
        return;
    }

    public static void setLargeIconIfPresentAndSupported(Context context, b b1, android.support.v4.app.NotificationCompat.Builder builder)
    {
        int i;
        if (android.os.Build.VERSION.SDK_INT <= 11)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        i = b1.j();
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), i));
        return;
        context;
        a.c(TAG, "Error setting large notification icon", context);
        return;
    }

    public static void setNotificationDurationAlarm(Context context, Class class1, int i, int j)
    {
        class1 = new Intent(context, class1);
        class1.setAction("com.appboy.action.CANCEL_NOTIFICATION");
        class1.putExtra("nid", i);
        class1 = PendingIntent.getBroadcast(context, 0, class1, 0x8000000);
        context = (AlarmManager)context.getSystemService("alarm");
        if (j >= 1000)
        {
            context.set(3, SystemClock.elapsedRealtime() + (long)j, class1);
        }
    }

    public static void setPriorityIfPresentAndSupported(android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16 && bundle != null)
        {
            builder.setPriority(getNotificationPriority(bundle));
        }
    }

    public static void setPublicVersionIfPresentAndSupported(Context context, b b1, android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21 && bundle != null && bundle.containsKey("ab_pn"))
        {
            bundle = parseJSONStringDictionaryIntoBundle(bundle.getString("ab_pn"));
            context = new android.support.v4.app.NotificationCompat.Builder(context);
            setContentIfPresent(context, bundle);
            setTitleIfPresent(context, bundle);
            setSummaryTextIfPresentAndSupported(context, bundle);
            setSmallIcon(b1, context);
            setAccentColorIfPresentAndSupported(b1, context, bundle);
            builder.setPublicVersion(context.build());
        }
    }

    public static int setSmallIcon(b b1, android.support.v4.app.NotificationCompat.Builder builder)
    {
        int j = b1.i();
        int i = j;
        if (j == 0)
        {
            i = b1.m();
        }
        builder.setSmallIcon(i);
        return i;
    }

    public static void setSoundIfPresentAndSupported(android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
label0:
        {
            if (android.os.Build.VERSION.SDK_INT > 11 && bundle != null && bundle.containsKey("sd"))
            {
                bundle = bundle.getString("sd");
                if (bundle != null)
                {
                    if (!bundle.equals("d"))
                    {
                        break label0;
                    }
                    builder.setDefaults(1);
                }
            }
            return;
        }
        builder.setSound(Uri.parse(bundle));
    }

    public static void setStyleIfSupported(Context context, android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle, Bundle bundle1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16 && bundle != null)
        {
            builder.setStyle(AppboyNotificationStyleFactory.getBigNotificationStyle(context, bundle, bundle1));
        }
    }

    public static void setSummaryTextIfPresentAndSupported(android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16 && bundle != null && bundle.containsKey("s"))
        {
            bundle = bundle.getString("s");
            if (bundle != null)
            {
                builder.setSubText(bundle);
            }
        }
    }

    public static void setTickerIfPresent(android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
        if (bundle != null)
        {
            builder.setTicker(bundle.getString("t"));
        }
    }

    public static void setTitleIfPresent(android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
        if (bundle != null)
        {
            builder.setContentTitle(bundle.getString("t"));
        }
    }

    public static void setVisibilityIfPresentAndSupported(android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle)
    {
        if (android.os.Build.VERSION.SDK_INT < 21 || bundle == null || !bundle.containsKey("ab_vs"))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        int i;
        i = Integer.parseInt(bundle.getString("ab_vs"));
        if (isValidNotificationVisibility(i))
        {
            builder.setVisibility(i);
            return;
        }
        try
        {
            a.c(TAG, String.format("Received invalid notification visibility %d", new Object[] {
                Integer.valueOf(i)
            }));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (android.support.v4.app.NotificationCompat.Builder builder)
        {
            a.c(TAG, "Failed to parse visibility from notificationExtras", builder);
        }
    }

    public static boolean wakeScreenIfHasPermission(Context context, Bundle bundle)
    {
        while (!d.a(context, "android.permission.WAKE_LOCK") || android.os.Build.VERSION.SDK_INT >= 16 && getNotificationPriority(bundle) == -2) 
        {
            return false;
        }
        context = ((PowerManager)context.getSystemService("power")).newWakeLock(0x1000001a, TAG);
        context.acquire();
        context.release();
        return true;
    }

    static 
    {
        TAG = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, com/appboy/push/AppboyNotificationUtils.getName()
        });
    }
}
