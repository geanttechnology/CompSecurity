// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.arellomobile.android.push.exception.PushWooshException;
import com.arellomobile.android.push.preference.SoundType;
import com.arellomobile.android.push.preference.VibrateType;
import com.arellomobile.android.push.registrar.PushRegistrar;
import com.arellomobile.android.push.registrar.PushRegistrarADM;
import com.arellomobile.android.push.registrar.PushRegistrarGCM;
import com.arellomobile.android.push.utils.GeneralUtils;
import com.arellomobile.android.push.utils.PreferenceUtils;
import com.arellomobile.android.push.utils.WorkerTask;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;
import com.google.android.gcm.GCMRegistrar;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push:
//            AlarmReceiver, DeviceFeature2_5, PushEventsTransmitter, PushWebview, 
//            SendPushTagsAsyncTask, PushBeaconService, GeoLocationService, SendPushTagsCallBack, 
//            DeviceRegistrar

public class PushManager
{
    public static interface GetBeaconsListener
    {

        public abstract void onBeaconsError(Exception exception);

        public abstract void onBeaconsReceived(JSONObject jsonobject);
    }

    public static interface GetTagsListener
    {

        public abstract void onError(Exception exception);

        public abstract void onTagsReceived(Map map);
    }


    private static final String HTML_URL_FORMAT = "https://cp.pushwoosh.com/content/%s";
    public static final String PUSH_RECEIVE_EVENT = "PUSH_RECEIVE_EVENT";
    public static final String REGISTER_BROAD_CAST_ACTION = "com.arellomobile.android.push.REGISTER_BROAD_CAST_ACTION";
    public static final String REGISTER_ERROR_EVENT = "REGISTER_ERROR_EVENT";
    public static final String REGISTER_EVENT = "REGISTER_EVENT";
    public static final String UNREGISTER_ERROR_EVENT = "UNREGISTER_ERROR_EVENT";
    public static final String UNREGISTER_EVENT = "UNREGISTER_EVENT";
    private static PushManager instance = null;
    private static AsyncTask mRegistrationAsyncTask;
    private static final Object mSyncObj = new Object();
    private Context mContext;
    private PushRegistrar pushRegistrar;

    private PushManager(Context context)
    {
        GeneralUtils.checkNotNull(context, "context");
        mContext = context;
        if (GeneralUtils.isAmazonDevice())
        {
            pushRegistrar = new PushRegistrarADM(context);
            return;
        } else
        {
            pushRegistrar = new PushRegistrarGCM(context);
            return;
        }
    }

    private void cancelPrevRegisterTask()
    {
        synchronized (mSyncObj)
        {
            if (mRegistrationAsyncTask != null)
            {
                mRegistrationAsyncTask.cancel(true);
            }
            mRegistrationAsyncTask = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void clearLocalNotifications(Context context)
    {
        AlarmReceiver.clearAlarm(context);
    }

    public static void getBeacons(Context context, GetBeaconsListener getbeaconslistener)
    {
        (new Handler(context.getMainLooper())).post(new Runnable(context, getbeaconslistener) {

            final Context val$context;
            final GetBeaconsListener val$listener;

            public void run()
            {
                ExecutorHelper.executeAsyncTask(new WorkerTask(context) {

                    final _cls4 this$0;

                    protected void doWork(Context context)
                    {
                        try
                        {
                            context = DeviceFeature2_5.getBeacons(context);
                            listener.onBeaconsReceived(context);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Context context)
                        {
                            listener.onBeaconsError(context);
                        }
                    }

            
            {
                this$0 = _cls4.this;
                super(context);
            }
                });
            }

            
            {
                context = context1;
                listener = getbeaconslistener;
                super();
            }
        });
    }

    public static PushManager getInstance(Context context)
    {
        if (instance != null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        Object obj;
        Object obj1;
        obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        obj1 = ((ApplicationInfo) (obj)).metaData.getString("PW_APPID");
        Object obj2;
        try
        {
            obj = ((ApplicationInfo) (obj)).metaData.getString("PW_PROJECT_ID").substring(1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
_L2:
        obj2 = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj2 = PreferenceUtils.getApplicationId(context);
        }
        obj1 = obj;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj1 = PreferenceUtils.getProjectId(context);
        }
        if (GeneralUtils.isAmazonDevice())
        {
            obj1 = "AMAZON_DEVICE";
        }
        if (TextUtils.isEmpty(((CharSequence) (obj2))) || TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            System.out.println("Tried to get instance of PushManager with no Pushwoosh App ID or Project Id set");
            return null;
        }
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        exception = null;
        obj1 = null;
        if (true) goto _L2; else goto _L1
_L1:
        System.out.println((new StringBuilder()).append("App ID: ").append(((String) (obj2))).toString());
        System.out.println((new StringBuilder()).append("Project ID: ").append(((String) (obj1))).toString());
        if (!PreferenceUtils.getApplicationId(context).equals(obj2))
        {
            PreferenceUtils.setForceRegister(context, true);
        }
        PreferenceUtils.setApplicationId(context, ((String) (obj2)));
        PreferenceUtils.setProjectId(context, ((String) (obj1)));
        instance = new PushManager(context);
        return instance;
    }

    public static String getPushToken(Context context)
    {
        return GCMRegistrar.getRegistrationId(context);
    }

    public static String getPushwooshHWID(Context context)
    {
        return GeneralUtils.getDeviceUUID(context);
    }

    private AsyncTask getRegisterAsyncTask(final Context final_context, String s)
    {
        return new WorkerTask(s) {

            final PushManager this$0;
            final String val$regId;

            protected void doWork(Context context)
            {
                DeviceRegistrar.registerWithServer(mContext, regId);
            }

            
            {
                this$0 = PushManager.this;
                regId = s;
                super(final_context);
            }
        };
    }

    public static void getTagsAsync(Context context, GetTagsListener gettagslistener)
    {
        if (!GCMRegistrar.isRegisteredOnServer(context))
        {
            return;
        } else
        {
            (new Handler(context.getMainLooper())).post(new Runnable(context, gettagslistener) {

                final Context val$context;
                final GetTagsListener val$listener;

                public void run()
                {
                    ExecutorHelper.executeAsyncTask(new WorkerTask(context) {

                        final _cls2 this$0;

                        protected void doWork(Context context)
                        {
                            try
                            {
                                context = DeviceFeature2_5.getTags(context);
                                listener.onTagsReceived(context);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (Context context)
                            {
                                listener.onError(context);
                            }
                        }

            
            {
                this$0 = _cls2.this;
                super(context);
            }
                    });
                }

            
            {
                context = context1;
                listener = gettagslistener;
                super();
            }
            });
            return;
        }
    }

    public static Map getTagsSync(Context context)
    {
        if (!GCMRegistrar.isRegisteredOnServer(context))
        {
            return null;
        }
        try
        {
            context = DeviceFeature2_5.getTags(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return new HashMap();
        }
        return context;
    }

    public static Map incrementalTag(Integer integer)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("operation", "increment");
        hashmap.put("value", integer);
        return hashmap;
    }

    public static void initializePushManager(Context context, String s, String s1)
    {
        PreferenceUtils.setApplicationId(context, s);
        PreferenceUtils.setProjectId(context, s1);
    }

    private boolean neededToRequestPushWooshServer(Context context)
    {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(12, -10);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(PreferenceUtils.getLastRegistration(context)));
        return !calendar1.before(calendar2) || !calendar2.before(calendar);
    }

    static boolean onHandlePush(Activity activity)
    {
        Bundle bundle;
        JSONObject jsonobject;
        Iterator iterator;
        bundle = activity.getIntent().getBundleExtra("pushBundle");
        if (bundle == null)
        {
            return false;
        }
        jsonobject = new JSONObject();
        iterator = bundle.keySet().iterator();
_L9:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s = (String)iterator.next();
        if (!s.equals("u")) goto _L4; else goto _L3
_L3:
        Object obj2 = bundle.get("u");
        if (obj2 == null) goto _L4; else goto _L5
_L5:
        if (!(obj2 instanceof String)) goto _L4; else goto _L6
_L6:
        if (!((String)obj2).startsWith("{")) goto _L8; else goto _L7
_L7:
        Object obj = new JSONObject((String)obj2);
_L11:
        jsonobject.put("userdata", obj);
_L4:
        try
        {
            jsonobject.put(s, bundle.get(s));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L9
_L8:
        obj = obj2;
        if (!((String)obj2).startsWith("[")) goto _L11; else goto _L10
_L10:
        obj = new JSONArray((String)obj2);
          goto _L11
_L2:
        PushEventsTransmitter.onMessageReceive(activity, jsonobject.toString(), bundle);
        Object obj1 = (String)bundle.get("h");
        if (obj1 != null)
        {
            obj1 = String.format("https://cp.pushwoosh.com/content/%s", new Object[] {
                obj1
            });
            Intent intent = new Intent(activity, com/arellomobile/android/push/PushWebview);
            intent.putExtra("url", ((String) (obj1)));
            activity.startActivity(intent);
        }
        obj1 = (String)bundle.get("r");
        if (obj1 != null)
        {
            Intent intent1 = new Intent(activity, com/arellomobile/android/push/PushWebview);
            intent1.putExtra("url", ((String) (obj1)));
            activity.startActivity(intent1);
        }
        obj1 = (String)bundle.get("launch");
        if (obj1 != null)
        {
            try
            {
                obj1 = activity.getPackageManager().getLaunchIntentForPackage(((String) (obj1)));
            }
            catch (Exception exception)
            {
                exception = null;
            }
            if (obj1 != null)
            {
                activity.startActivity(((Intent) (obj1)));
            }
        }
        sendPushStat(activity, bundle.getString("p"));
        return true;
        JSONException jsonexception;
        jsonexception;
          goto _L4
    }

    public static void processBeacon(Context context, String s, String s1, String s2, String s3)
    {
        (new Handler(context.getMainLooper())).post(new Runnable(context, s, s1, s2, s3) {

            final String val$action;
            final Context val$context;
            final String val$major;
            final String val$minor;
            final String val$proximityUuid;

            public void run()
            {
                ExecutorHelper.executeAsyncTask(new WorkerTask(context) {

                    final _cls5 this$0;

                    protected void doWork(Context context)
                    {
                        try
                        {
                            DeviceFeature2_5.processBeacon(context, proximityUuid, major, minor, action);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Context context)
                        {
                            context.printStackTrace();
                        }
                    }

            
            {
                this$0 = _cls5.this;
                super(context);
            }
                });
            }

            
            {
                context = context1;
                proximityUuid = s;
                major = s1;
                minor = s2;
                action = s3;
                super();
            }
        });
    }

    private void registerOnPushWoosh(final Context context, final String regId)
    {
        cancelPrevRegisterTask();
        (new Handler(context.getMainLooper())).post(new Runnable() {

            final PushManager this$0;
            final Context val$context;
            final String val$regId;

            public void run()
            {
                PushManager.mRegistrationAsyncTask = getRegisterAsyncTask(context, regId);
                ExecutorHelper.executeAsyncTask(PushManager.mRegistrationAsyncTask);
            }

            
            {
                this$0 = PushManager.this;
                context = context1;
                regId = s;
                super();
            }
        });
    }

    public static void scheduleLocalNotification(Context context, String s, int i)
    {
        scheduleLocalNotification(context, s, null, i);
    }

    public static void scheduleLocalNotification(Context context, String s, Bundle bundle, int i)
    {
        AlarmReceiver.setAlarm(context, s, bundle, i);
    }

    private void sendAppOpen(final Context context)
    {
        (new Handler(context.getMainLooper())).post(new Runnable() {

            final PushManager this$0;
            final Context val$context;

            public void run()
            {
                ExecutorHelper.executeAsyncTask(new WorkerTask(context) {

                    final _cls8 this$1;

                    protected void doWork(Context context)
                    {
                        try
                        {
                            DeviceFeature2_5.sendAppOpen(context);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Context context)
                        {
                            return;
                        }
                    }

            
            {
                this$1 = _cls8.this;
                super(context);
            }
                });
            }

            
            {
                this$0 = PushManager.this;
                context = context1;
                super();
            }
        });
    }

    public static void sendGoalAchieved(Context context, String s, Integer integer)
    {
        (new Handler(context.getMainLooper())).post(new Runnable(context, s, integer) {

            final Context val$context;
            final Integer val$count;
            final String val$goal;

            public void run()
            {
                ExecutorHelper.executeAsyncTask(new WorkerTask(context) {

                    final _cls9 this$0;

                    protected void doWork(Context context)
                    {
                        try
                        {
                            DeviceFeature2_5.sendGoalAchieved(context, goal, count);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Context context)
                        {
                            return;
                        }
                    }

            
            {
                this$0 = _cls9.this;
                super(context);
            }
                });
            }

            
            {
                context = context1;
                goal = s;
                count = integer;
                super();
            }
        });
    }

    public static void sendLocation(Context context, Location location)
    {
        if (!GCMRegistrar.isRegisteredOnServer(context))
        {
            return;
        } else
        {
            (new Handler(context.getMainLooper())).post(new Runnable(context, location) {

                final Context val$context;
                final Location val$location;

                public void run()
                {
                    ExecutorHelper.executeAsyncTask(new WorkerTask(context) {

                        final _cls3 this$0;

                        protected void doWork(Context context)
                        {
                            try
                            {
                                DeviceFeature2_5.getNearestZone(context, location);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (Context context)
                            {
                                return;
                            }
                        }

            
            {
                this$0 = _cls3.this;
                super(context);
            }
                    });
                }

            
            {
                context = context1;
                location = location1;
                super();
            }
            });
            return;
        }
    }

    static void sendPushStat(Context context, String s)
    {
        (new Handler(context.getMainLooper())).post(new Runnable(context, s) {

            final Context val$context;
            final String val$hash;

            public void run()
            {
                ExecutorHelper.executeAsyncTask(new WorkerTask(context) {

                    final _cls7 this$0;

                    protected void doWork(Context context)
                    {
                        try
                        {
                            DeviceFeature2_5.sendPushStat(context, hash);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Context context)
                        {
                            return;
                        }
                    }

            
            {
                this$0 = _cls7.this;
                super(context);
            }
                });
            }

            
            {
                context = context1;
                hash = s;
                super();
            }
        });
    }

    public static void sendTags(Context context, Map map, SendPushTagsCallBack sendpushtagscallback)
    {
        (new Handler(context.getMainLooper())).post(new Runnable(context, sendpushtagscallback, map) {

            final SendPushTagsCallBack val$callBack;
            final Context val$context;
            final Map val$tags;

            public void run()
            {
                (new SendPushTagsAsyncTask(context, callBack)).execute(new Map[] {
                    tags
                });
            }

            
            {
                context = context1;
                callBack = sendpushtagscallback;
                tags = map;
                super();
            }
        });
    }

    public static Map sendTagsFromBG(Context context, Map map)
        throws PushWooshException
    {
        HashMap hashmap;
        hashmap = new HashMap();
        int i;
        try
        {
            context = DeviceFeature2_5.sendTags(context, map);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new PushWooshException(context);
        }
        i = 0;
        if (i >= context.length())
        {
            break; /* Loop/switch isn't completed */
        }
        map = context.getJSONObject(i);
        hashmap.put(map.getString("tag"), map.getString("reason"));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_16;
_L1:
        return hashmap;
    }

    public static void sendTagsFromUI(Context context, Map map, SendPushTagsCallBack sendpushtagscallback)
    {
        (new SendPushTagsAsyncTask(context, sendpushtagscallback)).execute(new Map[] {
            map
        });
    }

    public static void setBeaconBackgroundMode(Context context, boolean flag)
    {
        context.startService((new Intent(context, com/arellomobile/android/push/PushBeaconService)).putExtra("backgroundMode", flag));
    }

    public static void setEnableLED(Context context, boolean flag)
    {
        PreferenceUtils.setEnableLED(context, flag);
    }

    public static void setLightScreenOnNotification(Context context, boolean flag)
    {
        PreferenceUtils.setLightScreenOnNotification(context, flag);
    }

    public static void setMultiNotificationMode(Context context)
    {
        PreferenceUtils.setMultiMode(context, true);
    }

    public static void setSimpleNotificationMode(Context context)
    {
        PreferenceUtils.setMultiMode(context, false);
    }

    public static void setSoundNotificationType(Context context, SoundType soundtype)
    {
        PreferenceUtils.setSoundType(context, soundtype);
    }

    public static void setVibrateNotificationType(Context context, VibrateType vibratetype)
    {
        PreferenceUtils.setVibrateType(context, vibratetype);
    }

    public static void startTrackingGeoPushes(Context context)
    {
        context.startService(new Intent(context, com/arellomobile/android/push/GeoLocationService));
    }

    public static void stopTrackingGeoPushes(Context context)
    {
        context.stopService(new Intent(context, com/arellomobile/android/push/GeoLocationService));
    }

    public static void trackInAppRequest(Context context, String s, String s1, long l)
    {
        (new Handler(context.getMainLooper())).post(new Runnable(context, s, s1, l) {

            final Context val$context;
            final String val$orderId;
            final long val$purchaseTime;
            final String val$sku;

            public void run()
            {
                ExecutorHelper.executeAsyncTask(new WorkerTask(context) {

                    final _cls10 this$0;

                    protected void doWork(Context context)
                    {
                        try
                        {
                            DeviceFeature2_5.trackInAppRequest(context, orderId, sku, purchaseTime);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Context context)
                        {
                            return;
                        }
                    }

            
            {
                this$0 = _cls10.this;
                super(context);
            }
                });
            }

            
            {
                context = context1;
                orderId = s;
                sku = s1;
                purchaseTime = l;
                super();
            }
        });
    }

    Context getContext()
    {
        return mContext;
    }

    public String getCustomData(Bundle bundle)
    {
        if (bundle == null)
        {
            return null;
        } else
        {
            return bundle.getString("u");
        }
    }

    public void onStartup(Context context)
        throws Exception
    {
        pushRegistrar.checkDevice(context);
        sendAppOpen(context);
        String s;
        if (!(context instanceof Activity) || !((Activity)context).getIntent().hasExtra("PUSH_RECEIVE_EVENT"))
        {
            if ((s = GCMRegistrar.getRegistrationId(mContext)) != null && !s.equals(""))
            {
                boolean flag = PreferenceUtils.getForceRegister(context);
                PreferenceUtils.setForceRegister(context, false);
                if (flag)
                {
                    registerOnPushWoosh(context, s);
                    return;
                }
                if (neededToRequestPushWooshServer(context))
                {
                    registerOnPushWoosh(context, s);
                    return;
                }
            }
        }
    }

    public void registerForPushNotifications()
    {
        Object obj = GCMRegistrar.getRegistrationId(mContext);
        if (((String) (obj)).equals(""))
        {
            try
            {
                pushRegistrar.registerPW(mContext);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
            return;
        } else
        {
            PushEventsTransmitter.onRegistered(mContext, ((String) (obj)));
            return;
        }
    }

    public void startTrackingBeaconPushes()
    {
        mContext.startService(new Intent(mContext, com/arellomobile/android/push/PushBeaconService));
    }

    public void startTrackingGeoPushes()
    {
        mContext.startService(new Intent(mContext, com/arellomobile/android/push/GeoLocationService));
    }

    public void stopTrackingBeaconPushes()
    {
        mContext.stopService(new Intent(mContext, com/arellomobile/android/push/PushBeaconService));
    }

    public void stopTrackingGeoPushes()
    {
        mContext.stopService(new Intent(mContext, com/arellomobile/android/push/GeoLocationService));
    }

    public void unregisterForPushNotifications()
    {
        cancelPrevRegisterTask();
        pushRegistrar.unregisterPW(mContext);
    }




/*
    static AsyncTask access$002(AsyncTask asynctask)
    {
        mRegistrationAsyncTask = asynctask;
        return asynctask;
    }

*/


}
