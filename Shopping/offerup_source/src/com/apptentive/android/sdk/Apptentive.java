// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.apptentive.android.sdk.comm.ApptentiveClient;
import com.apptentive.android.sdk.comm.ApptentiveHttpResponse;
import com.apptentive.android.sdk.lifecycle.ActivityLifecycleManager;
import com.apptentive.android.sdk.model.Configuration;
import com.apptentive.android.sdk.model.ConversationTokenRequest;
import com.apptentive.android.sdk.model.CustomData;
import com.apptentive.android.sdk.model.Device;
import com.apptentive.android.sdk.model.ExtendedData;
import com.apptentive.android.sdk.model.FileMessage;
import com.apptentive.android.sdk.model.Payload;
import com.apptentive.android.sdk.model.Person;
import com.apptentive.android.sdk.model.Sdk;
import com.apptentive.android.sdk.model.TextMessage;
import com.apptentive.android.sdk.module.engagement.EngagementModule;
import com.apptentive.android.sdk.module.engagement.interaction.InteractionManager;
import com.apptentive.android.sdk.module.messagecenter.ApptentiveMessageCenter;
import com.apptentive.android.sdk.module.messagecenter.MessageManager;
import com.apptentive.android.sdk.module.messagecenter.MessagePollingWorker;
import com.apptentive.android.sdk.module.messagecenter.UnreadMessagesListener;
import com.apptentive.android.sdk.module.metric.MetricModule;
import com.apptentive.android.sdk.module.rating.IRatingProvider;
import com.apptentive.android.sdk.module.survey.OnSurveyFinishedListener;
import com.apptentive.android.sdk.storage.AppReleaseManager;
import com.apptentive.android.sdk.storage.ApptentiveDatabase;
import com.apptentive.android.sdk.storage.DeviceManager;
import com.apptentive.android.sdk.storage.PayloadSendWorker;
import com.apptentive.android.sdk.storage.PersonManager;
import com.apptentive.android.sdk.storage.SdkManager;
import com.apptentive.android.sdk.storage.VersionHistoryStore;
import com.apptentive.android.sdk.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk:
//            Log, GlobalInfo, ApptentiveInternal

public class Apptentive
{

    public static final String INTEGRATION_AWS_SNS = "aws_sns";
    public static final String INTEGRATION_AWS_SNS_TOKEN = "token";
    public static final String INTEGRATION_PARSE = "parse";
    public static final String INTEGRATION_PARSE_DEVICE_TOKEN = "token";
    public static final String INTEGRATION_URBAN_AIRSHIP = "urban_airship";
    public static final String INTEGRATION_URBAN_AIRSHIP_CHANNEL_ID = "token";
    private static int runningActivities;

    private Apptentive()
    {
    }

    public static void addAmazonSnsPushIntegration(Context context, String s)
    {
        if (s != null)
        {
            Log.d("Setting Amazon AWS token: %s", new Object[] {
                s
            });
            HashMap hashmap = new HashMap();
            hashmap.put("token", s);
            addIntegration(context, "aws_sns", hashmap);
        }
    }

    public static void addCustomDeviceData(Context context, String s, String s1)
    {
        CustomData customdata;
        if (s != null && s.trim().length() != 0)
        {
            if ((customdata = DeviceManager.loadCustomDeviceData(context)) != null)
            {
                try
                {
                    customdata.put(s, s1);
                    DeviceManager.storeCustomDeviceData(context, customdata);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.w("Unable to add custom device data.", context, new Object[0]);
                }
                return;
            }
        }
    }

    public static void addCustomPersonData(Context context, String s, String s1)
    {
        CustomData customdata;
        if (s != null && s.trim().length() != 0)
        {
            if ((customdata = PersonManager.loadCustomPersonData(context)) != null)
            {
                try
                {
                    customdata.put(s, s1);
                    PersonManager.storeCustomPersonData(context, customdata);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.w("Unable to add custom person data.", context, new Object[0]);
                }
                return;
            }
        }
    }

    public static void addIntegration(Context context, String s, Map map)
    {
        CustomData customdata;
        if (s == null || map == null)
        {
            return;
        }
        customdata = DeviceManager.loadIntegrationConfig(context);
        if (customdata.isNull(s)) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject = customdata.getJSONObject(s);
_L4:
        String s1;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); jsonobject.put(s1, map.get(s1)))
        {
            s1 = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_126;
_L2:
        try
        {
            jsonobject = new JSONObject();
            customdata.put(s, jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Error adding integration: %s, %s", context, new Object[] {
                s, map.toString()
            });
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Log.d("Adding integration config: %s", new Object[] {
            map.toString()
        });
        DeviceManager.storeIntegrationConfig(context, customdata);
        syncDevice(context);
        return;
    }

    public static void addParsePushIntegration(Context context, String s)
    {
        if (s != null)
        {
            Log.d("Setting Parse Device Token: %s", new Object[] {
                s
            });
            HashMap hashmap = new HashMap();
            hashmap.put("token", s);
            addIntegration(context, "parse", hashmap);
        }
    }

    public static void addUrbanAirshipPushIntegration(Context context, String s)
    {
        if (s != null)
        {
            Log.d("Setting Urban Airship Channel ID: %s", new Object[] {
                s
            });
            HashMap hashmap = new HashMap();
            hashmap.put("token", s);
            addIntegration(context, "urban_airship", hashmap);
        }
    }

    private static void asyncFetchAppConfiguration(final Context context)
    {
        _cls3 _lcls3 = new _cls3();
        _lcls3.setUncaughtExceptionHandler(new _cls4());
        _lcls3.setName("Apptentive-FetchAppConfiguration");
        _lcls3.start();
    }

    private static void asyncFetchConversationToken(final Context context)
    {
        com/apptentive/android/sdk/Apptentive;
        JVM INSTR monitorenter ;
        _cls1 _lcls1 = new _cls1();
        _lcls1.setUncaughtExceptionHandler(new _cls2());
        _lcls1.setName("Apptentive-FetchConversationToken");
        _lcls1.start();
        com/apptentive/android/sdk/Apptentive;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static boolean engage(Activity activity, String s)
    {
        com/apptentive/android/sdk/Apptentive;
        JVM INSTR monitorenter ;
        boolean flag = EngagementModule.engage(activity, "local", "app", null, s, null, null, null);
        com/apptentive/android/sdk/Apptentive;
        JVM INSTR monitorexit ;
        return flag;
        activity;
        throw activity;
    }

    public static boolean engage(Activity activity, String s, Map map)
    {
        com/apptentive/android/sdk/Apptentive;
        JVM INSTR monitorenter ;
        boolean flag = EngagementModule.engage(activity, "local", "app", null, s, null, map, null);
        com/apptentive/android/sdk/Apptentive;
        JVM INSTR monitorexit ;
        return flag;
        activity;
        throw activity;
    }

    public static transient boolean engage(Activity activity, String s, Map map, ExtendedData aextendeddata[])
    {
        com/apptentive/android/sdk/Apptentive;
        JVM INSTR monitorenter ;
        boolean flag = EngagementModule.engage(activity, "local", "app", null, s, null, map, aextendeddata);
        com/apptentive/android/sdk/Apptentive;
        JVM INSTR monitorexit ;
        return flag;
        activity;
        throw activity;
    }

    private static void fetchAppConfiguration(Context context, boolean flag)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("APPTENTIVE", 0);
        if (flag) goto _L2; else goto _L1
_L1:
        long l = Configuration.load(sharedpreferences).getConfigurationCacheExpirationMillis();
        if (System.currentTimeMillis() >= Long.valueOf(l).longValue()) goto _L2; else goto _L3
_L3:
        Log.v("Using cached configuration.", new Object[0]);
_L5:
        return;
_L2:
        ApptentiveHttpResponse apptentivehttpresponse;
        Log.v("Fetching new configuration.", new Object[0]);
        apptentivehttpresponse = ApptentiveClient.getAppConfiguration();
        if (!apptentivehttpresponse.isSuccessful()) goto _L5; else goto _L4
_L4:
        Integer integer;
        Object obj;
        long l1;
        try
        {
            obj = Util.parseCacheControlHeader((String)apptentivehttpresponse.getHeaders().get("Cache-Control"));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Error parsing app configuration from server.", context, new Object[0]);
            return;
        }
        integer = ((Integer) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        integer = Integer.valueOf(0x15180);
        Log.d("Caching configuration for %d seconds.", new Object[] {
            integer
        });
        obj = new Configuration(apptentivehttpresponse.getContent());
        l1 = System.currentTimeMillis();
        ((Configuration) (obj)).setConfigurationCacheExpirationMillis((long)(integer.intValue() * 1000) + l1);
        ((Configuration) (obj)).save(context);
        return;
    }

    private static void fetchConversationToken(Context context)
    {
        Object obj;
        obj = new ConversationTokenRequest();
        ((ConversationTokenRequest) (obj)).setDevice(DeviceManager.storeDeviceAndReturnIt(context));
        ((ConversationTokenRequest) (obj)).setSdk(SdkManager.storeSdkAndReturnIt(context));
        ((ConversationTokenRequest) (obj)).setPerson(PersonManager.storePersonAndReturnIt(context));
        obj = ApptentiveClient.getConversationToken(((ConversationTokenRequest) (obj)));
        if (obj != null) goto _L2; else goto _L1
_L1:
        Log.w("Got null response fetching ConversationToken.", new Object[0]);
_L4:
        return;
_L2:
        if (!((ApptentiveHttpResponse) (obj)).isSuccessful()) goto _L4; else goto _L3
_L3:
        Object obj1;
        String s;
        String s1;
        try
        {
            obj1 = new JSONObject(((ApptentiveHttpResponse) (obj)).getContent());
            s = ((JSONObject) (obj1)).getString("token");
            Log.d((new StringBuilder("ConversationToken: ")).append(s).toString(), new Object[0]);
            s1 = ((JSONObject) (obj1)).getString("id");
            Log.d("New Conversation id: %s", new Object[] {
                s1
            });
            obj = context.getSharedPreferences("APPTENTIVE", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Error parsing ConversationToken response json.", context, new Object[0]);
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (!s.equals(""))
        {
            GlobalInfo.conversationToken = s;
            ((SharedPreferences) (obj)).edit().putString("conversationToken", s).commit();
            ((SharedPreferences) (obj)).edit().putString("conversationId", s1).commit();
        }
        obj1 = ((JSONObject) (obj1)).getString("person_id");
        Log.d((new StringBuilder("PersonId: ")).append(((String) (obj1))).toString(), new Object[0]);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        if (!((String) (obj1)).equals(""))
        {
            GlobalInfo.personId = ((String) (obj1));
            ((SharedPreferences) (obj)).edit().putString("personId", ((String) (obj1))).commit();
        }
        asyncFetchAppConfiguration(context);
        InteractionManager.asyncFetchAndStoreInteractions(context);
        return;
    }

    public static int getUnreadMessageCount(Context context)
    {
        int i;
        try
        {
            i = MessageManager.getUnreadMessageCount(context);
        }
        catch (Exception exception)
        {
            MetricModule.sendError(context.getApplicationContext(), exception, null, null);
            return 0;
        }
        return i;
    }

    public static boolean handleOpenedPushNotification(Activity activity)
    {
        String s;
        SharedPreferences sharedpreferences = activity.getSharedPreferences("APPTENTIVE", 0);
        s = sharedpreferences.getString("pendingPushNotification", null);
        sharedpreferences.edit().remove("pendingPushNotification").commit();
        if (s == null) goto _L2; else goto _L1
_L1:
        Log.i("Handling opened Apptentive push notification.", new Object[0]);
        ApptentiveInternal.PushAction pushaction;
        JSONObject jsonobject = new JSONObject(s);
        pushaction = ApptentiveInternal.PushAction.unknown;
        if (jsonobject.has("action"))
        {
            pushaction = ApptentiveInternal.PushAction.parse(jsonobject.getString("action"));
        }
        _cls5..SwitchMap.com.apptentive.android.sdk.ApptentiveInternal.PushAction[pushaction.ordinal()];
        JVM INSTR tableswitch 1 1: default 165
    //                   1 132;
           goto _L3 _L4
_L3:
        Log.v("Unknown Apptentive push notification action: \"%s\"", new Object[] {
            pushaction.name()
        });
        break; /* Loop/switch isn't completed */
_L4:
        showMessageCenter(activity);
        return true;
        JSONException jsonexception;
        jsonexception;
        Log.w("Error parsing JSON from push notification.", jsonexception, new Object[0]);
        MetricModule.sendError(activity.getApplicationContext(), jsonexception, "Parsing Push notification", s);
_L2:
        return false;
    }

    private static void init(Activity activity)
    {
        Context context = activity.getApplicationContext();
        if (GlobalInfo.initialized) goto _L2; else goto _L1
_L1:
        SharedPreferences sharedpreferences;
        sharedpreferences = context.getSharedPreferences("APPTENTIVE", 0);
        GlobalInfo.isAppDebuggable = false;
        Object obj2;
        Object obj3;
        obj2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        obj3 = ((ApplicationInfo) (obj2)).metaData;
        if (obj3 == null) goto _L4; else goto _L3
_L3:
        Object obj = ((Bundle) (obj3)).getString("apptentive_api_key");
        Object obj1;
        boolean flag;
        obj1 = ((Bundle) (obj3)).getString("apptentive_log_level");
        flag = ((Bundle) (obj3)).getBoolean("apptentive_debug");
        ApptentiveClient.useStagingServer = ((Bundle) (obj3)).getBoolean("apptentive_use_staging_server");
_L19:
        if (!flag) goto _L6; else goto _L5
_L5:
        Log.i("Apptentive debug logging set to VERBOSE.", new Object[0]);
        ApptentiveInternal.setMinimumLogLevel(Log.Level.VERBOSE);
        obj1 = obj;
_L11:
        Log.i("Debug mode enabled? %b", new Object[] {
            Boolean.valueOf(GlobalInfo.isAppDebuggable)
        });
        if (Util.isEmpty(((CharSequence) (obj1))))
        {
            if (GlobalInfo.isAppDebuggable)
            {
                activity = (new android.app.AlertDialog.Builder(activity)).setTitle("Error").setMessage("No Apptentive api key specified. Please make sure you have specified your api key in your AndroidManifest.xml").setPositiveButton("OK", null).create();
                activity.setCanceledOnTouchOutside(false);
                activity.show();
            }
            Log.e("No Apptentive api key specified. Please make sure you have specified your api key in your AndroidManifest.xml", new Object[0]);
        }
        GlobalInfo.apiKey = ((String) (obj1));
        Log.i("API Key: %s", new Object[] {
            GlobalInfo.apiKey
        });
        GlobalInfo.appPackage = context.getPackageName();
        GlobalInfo.androidId = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        activity = context.getPackageManager();
        obj = activity.getPackageInfo(context.getPackageName(), 0);
        obj1 = Integer.valueOf(((PackageInfo) (obj)).versionCode);
        obj2 = ((PackageInfo) (obj)).versionName;
        obj3 = VersionHistoryStore.getLastVersionSeen(context);
        if (obj3 != null) goto _L8; else goto _L7
_L7:
        onVersionChanged(context, null, ((Integer) (obj1)), null, ((String) (obj2)));
_L14:
        GlobalInfo.appDisplayName = activity.getApplicationLabel(activity.getApplicationInfo(((PackageInfo) (obj)).packageName, 0)).toString();
_L15:
        if (sharedpreferences.contains("conversationToken") && sharedpreferences.contains("personId"))
        {
            GlobalInfo.conversationToken = sharedpreferences.getString("conversationToken", null);
            GlobalInfo.personId = sharedpreferences.getString("personId", null);
        }
        GlobalInfo.initialized = true;
        Log.v("Done initializing...", new Object[0]);
_L16:
        if (GlobalInfo.conversationToken == null || GlobalInfo.personId == null)
        {
            asyncFetchConversationToken(context.getApplicationContext());
        } else
        {
            asyncFetchAppConfiguration(context.getApplicationContext());
            InteractionManager.asyncFetchAndStoreInteractions(context.getApplicationContext());
        }
        syncDevice(context);
        syncSdk(context);
        syncPerson(context);
        Log.d("Default Locale: %s", new Object[] {
            Locale.getDefault().toString()
        });
        Log.d("Conversation id: %s", new Object[] {
            context.getSharedPreferences("APPTENTIVE", 0).getString("conversationId", "null")
        });
        return;
_L6:
        if (obj1 == null) goto _L10; else goto _L9
_L9:
        Log.i("Overriding log level: %s", new Object[] {
            obj1
        });
        ApptentiveInternal.setMinimumLogLevel(Log.Level.parse(((String) (obj1))));
        obj1 = obj;
          goto _L11
        obj1;
_L17:
        Log.e("Unexpected error while reading application info.", ((Throwable) (obj1)), new Object[0]);
        obj1 = obj;
          goto _L11
_L10:
        if ((((ApplicationInfo) (obj2)).flags & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        GlobalInfo.isAppDebuggable = flag;
        obj1 = obj;
        if (!flag) goto _L11; else goto _L12
_L12:
        ApptentiveInternal.setMinimumLogLevel(Log.Level.VERBOSE);
        obj1 = obj;
          goto _L11
_L8:
        if (((Integer) (obj1)).equals(((com.apptentive.android.sdk.storage.VersionHistoryStore.VersionHistoryEntry) (obj3)).versionCode) && ((String) (obj2)).equals(((com.apptentive.android.sdk.storage.VersionHistoryStore.VersionHistoryEntry) (obj3)).versionName)) goto _L14; else goto _L13
_L13:
        onVersionChanged(context, ((com.apptentive.android.sdk.storage.VersionHistoryStore.VersionHistoryEntry) (obj3)).versionCode, ((Integer) (obj1)), ((com.apptentive.android.sdk.storage.VersionHistoryStore.VersionHistoryEntry) (obj3)).versionName, ((String) (obj2)));
          goto _L14
        activity;
        GlobalInfo.appDisplayName = "this app";
          goto _L15
_L2:
        Log.v("Already initialized...", new Object[0]);
          goto _L16
        obj1;
        obj = null;
          goto _L17
        obj1;
          goto _L17
_L4:
        obj1 = null;
        flag = false;
        obj = null;
        if (true) goto _L19; else goto _L18
_L18:
    }

    public static boolean isApptentivePushNotification(Intent intent)
    {
        return ApptentiveInternal.getApptentivePushNotificationData(intent) != null;
    }

    public static boolean isApptentivePushNotification(Bundle bundle)
    {
        return ApptentiveInternal.getApptentivePushNotificationData(bundle) != null;
    }

    public static void onStart(Activity activity)
    {
        try
        {
            init(activity);
            ActivityLifecycleManager.activityStarted(activity);
            if (runningActivities == 0)
            {
                PayloadSendWorker.appWentToForeground(activity.getApplicationContext());
                MessagePollingWorker.appWentToForeground(activity.getApplicationContext());
            }
            runningActivities++;
            return;
        }
        catch (Exception exception)
        {
            Log.w("Error starting Apptentive Activity.", exception, new Object[0]);
            MetricModule.sendError(activity.getApplicationContext(), exception, null, null);
            return;
        }
    }

    public static void onStop(Activity activity)
    {
        int i;
        try
        {
            ActivityLifecycleManager.activityStopped(activity);
            i = runningActivities - 1;
            runningActivities = i;
        }
        catch (Exception exception)
        {
            Log.w("Error stopping Apptentive Activity.", exception, new Object[0]);
            MetricModule.sendError(activity.getApplicationContext(), exception, null, null);
            return;
        }
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        Log.e("Incorrect number of running Activities encountered. Resetting to 0. Did you make sure to call Apptentive.onStart() and Apptentive.onStop() in all your Activities?", new Object[0]);
        runningActivities = 0;
        if (runningActivities == 0)
        {
            PayloadSendWorker.appWentToBackground();
            MessagePollingWorker.appWentToBackground();
        }
        return;
    }

    private static void onVersionChanged(Context context, Integer integer, Integer integer1, String s, String s1)
    {
        Log.i("Version changed: Name: %s => %s, Code: %d => %d", new Object[] {
            s, s1, integer, integer1
        });
        VersionHistoryStore.updateVersionHistory(context, integer1, s1);
        integer = AppReleaseManager.storeAppReleaseAndReturnDiff(context);
        if (integer != null)
        {
            Log.d("App release was updated.", new Object[0]);
            ApptentiveDatabase.getInstance(context).addPayload(new Payload[] {
                integer
            });
        }
    }

    public static void putRatingProviderArg(String s, String s1)
    {
        ApptentiveInternal.putRatingProviderArg(s, s1);
    }

    public static void removeCustomDeviceData(Context context, String s)
    {
        CustomData customdata = DeviceManager.loadCustomDeviceData(context);
        if (customdata != null)
        {
            customdata.remove(s);
            DeviceManager.storeCustomDeviceData(context, customdata);
        }
    }

    public static void removeCustomPersonData(Context context, String s)
    {
        CustomData customdata = PersonManager.loadCustomPersonData(context);
        if (customdata != null)
        {
            customdata.remove(s);
            PersonManager.storeCustomPersonData(context, customdata);
        }
    }

    public static void sendAttachmentFile(Context context, InputStream inputstream, String s)
    {
        FileMessage filemessage;
        filemessage = new FileMessage();
        filemessage.setHidden(true);
        boolean flag = filemessage.createStoredFile(context, inputstream, s);
_L1:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        try
        {
            filemessage.setRead(true);
            MessageManager.sendMessage(context, filemessage);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            Log.w("Error sending attachment file.", inputstream, new Object[0]);
        }
        break MISSING_BLOCK_LABEL_67;
        inputstream;
        Log.e("Error creating local copy of file attachment.", new Object[0]);
        flag = false;
          goto _L1
        MetricModule.sendError(context, inputstream, null, null);
    }

    public static void sendAttachmentFile(Context context, String s)
    {
        try
        {
            FileMessage filemessage = new FileMessage();
            filemessage.setHidden(true);
            if (filemessage.createStoredFile(context, s))
            {
                filemessage.setRead(true);
                MessageManager.sendMessage(context, filemessage);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("Error sending attachment file.", s, new Object[0]);
        }
        MetricModule.sendError(context, s, null, null);
    }

    public static void sendAttachmentFile(Context context, byte abyte0[], String s)
    {
        try
        {
            FileMessage filemessage = new FileMessage();
            filemessage.setHidden(true);
            if (filemessage.createStoredFile(context, abyte0, s))
            {
                filemessage.setRead(true);
                MessageManager.sendMessage(context, filemessage);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.w("Error sending attachment file.", abyte0, new Object[0]);
        }
        MetricModule.sendError(context, abyte0, null, null);
    }

    public static void sendAttachmentText(Context context, String s)
    {
        try
        {
            TextMessage textmessage = new TextMessage();
            textmessage.setBody(s);
            textmessage.setHidden(true);
            MessageManager.sendMessage(context, textmessage);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("Error sending attachment text.", s, new Object[0]);
        }
        MetricModule.sendError(context, s, null, null);
    }

    public static void setCustomDeviceData(Context context, Map map)
    {
        CustomData customdata;
        try
        {
            customdata = new CustomData();
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); customdata.put(s, map.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("Unable to set custom device data.", context, new Object[0]);
            return;
        }
        DeviceManager.storeCustomDeviceData(context, customdata);
        return;
    }

    public static void setCustomPersonData(Context context, Map map)
    {
        CustomData customdata;
        Log.w("Setting custom person data: %s", new Object[] {
            map.toString()
        });
        try
        {
            customdata = new CustomData();
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); customdata.put(s, map.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Unable to set custom person data.", context, new Object[0]);
            return;
        }
        PersonManager.storeCustomPersonData(context, customdata);
        return;
    }

    public static void setInitialUserEmail(Context context, String s)
    {
        PersonManager.storeInitialPersonEmail(context, s);
    }

    public static void setInitialUserName(Context context, String s)
    {
        PersonManager.storeInitialPersonUserName(context, s);
    }

    public static void setOnSurveyFinishedListener(OnSurveyFinishedListener onsurveyfinishedlistener)
    {
        ApptentiveInternal.setOnSurveyFinishedListener(onsurveyfinishedlistener);
    }

    public static boolean setPendingPushNotification(Context context, Intent intent)
    {
        intent = ApptentiveInternal.getApptentivePushNotificationData(intent);
        if (intent != null)
        {
            return ApptentiveInternal.setPendingPushNotification(context, intent);
        } else
        {
            return false;
        }
    }

    public static boolean setPendingPushNotification(Context context, Bundle bundle)
    {
        bundle = ApptentiveInternal.getApptentivePushNotificationData(bundle);
        if (bundle != null)
        {
            return ApptentiveInternal.setPendingPushNotification(context, bundle);
        } else
        {
            return false;
        }
    }

    public static void setRatingProvider(IRatingProvider iratingprovider)
    {
        ApptentiveInternal.setRatingProvider(iratingprovider);
    }

    public static void setUnreadMessagesListener(UnreadMessagesListener unreadmessageslistener)
    {
        MessageManager.setHostUnreadMessagesListener(unreadmessageslistener);
    }

    public static void showMessageCenter(Activity activity)
    {
        ApptentiveMessageCenter.show(activity, true, null);
    }

    public static void showMessageCenter(Activity activity, Map map)
    {
        try
        {
            ApptentiveMessageCenter.show(activity, true, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.w("Error starting Apptentive Activity.", map, new Object[0]);
        }
        MetricModule.sendError(activity.getApplicationContext(), map, null, null);
    }

    private static void syncDevice(Context context)
    {
        Device device = DeviceManager.storeDeviceAndReturnDiff(context);
        if (device != null)
        {
            Log.d("Device info was updated.", new Object[0]);
            Log.v(device.toString(), new Object[0]);
            ApptentiveDatabase.getInstance(context).addPayload(new Payload[] {
                device
            });
            return;
        } else
        {
            Log.d("Device info was not updated.", new Object[0]);
            return;
        }
    }

    private static void syncPerson(Context context)
    {
        Person person = PersonManager.storePersonAndReturnDiff(context);
        if (person != null)
        {
            Log.d("Person was updated.", new Object[0]);
            Log.v(person.toString(), new Object[0]);
            ApptentiveDatabase.getInstance(context).addPayload(new Payload[] {
                person
            });
            return;
        } else
        {
            Log.d("Person was not updated.", new Object[0]);
            return;
        }
    }

    private static void syncSdk(Context context)
    {
        Sdk sdk = SdkManager.storeSdkAndReturnDiff(context);
        if (sdk != null)
        {
            Log.d("Sdk was updated.", new Object[0]);
            Log.v(sdk.toString(), new Object[0]);
            ApptentiveDatabase.getInstance(context).addPayload(new Payload[] {
                sdk
            });
            return;
        } else
        {
            Log.d("Sdk was not updated.", new Object[0]);
            return;
        }
    }

    public static boolean willShowInteraction(Context context, String s)
    {
        com/apptentive/android/sdk/Apptentive;
        JVM INSTR monitorenter ;
        boolean flag = EngagementModule.willShowInteraction(context, "local", "app", s);
_L2:
        com/apptentive/android/sdk/Apptentive;
        JVM INSTR monitorexit ;
        return flag;
        s;
        MetricModule.sendError(context, s, null, null);
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        context;
        throw context;
    }



    private class _cls3 extends Thread
    {

        final Context val$context;

        public final void run()
        {
            Apptentive.fetchAppConfiguration(context, GlobalInfo.isAppDebuggable);
        }

        _cls3()
        {
            context = context1;
            super();
        }
    }


    private class _cls4
        implements Thread.UncaughtExceptionHandler
    {

        final Context val$context;

        public final void uncaughtException(Thread thread, Throwable throwable)
        {
            Log.e("Caught UncaughtException in thread \"%s\"", throwable, new Object[] {
                thread.getName()
            });
            MetricModule.sendError(context.getApplicationContext(), throwable, null, null);
        }

        _cls4()
        {
            context = context1;
            super();
        }
    }


    private class _cls1 extends Thread
    {

        final Context val$context;

        public final void run()
        {
            Apptentive.fetchConversationToken(context);
        }

        _cls1()
        {
            context = context1;
            super();
        }
    }


    private class _cls2
        implements Thread.UncaughtExceptionHandler
    {

        final Context val$context;

        public final void uncaughtException(Thread thread, Throwable throwable)
        {
            Log.w("Caught UncaughtException in thread \"%s\"", throwable, new Object[] {
                thread.getName()
            });
            MetricModule.sendError(context.getApplicationContext(), throwable, null, null);
        }

        _cls2()
        {
            context = context1;
            super();
        }
    }


    private class _cls5
    {

        static final int $SwitchMap$com$apptentive$android$sdk$ApptentiveInternal$PushAction[];

        static 
        {
            $SwitchMap$com$apptentive$android$sdk$ApptentiveInternal$PushAction = new int[ApptentiveInternal.PushAction.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$ApptentiveInternal$PushAction[ApptentiveInternal.PushAction.pmc.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
        }
    }

}
