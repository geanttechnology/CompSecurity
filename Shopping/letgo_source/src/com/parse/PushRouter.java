// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.ct;
import android.support.v7.cu;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseInstallation, PointerOrLocalIdEncoder, Parse, ParseFileUtils, 
//            PushRoutes, PushHistory, PLog, ManifestInfo, 
//            ParseNotificationManager, ParsePlugins, ParseTextUtils, ParseExecutors

class PushRouter
{
    static final class HandlePushResult extends Enum
    {

        private static final HandlePushResult $VALUES[];
        public static final HandlePushResult BROADCAST_INTENT;
        public static final HandlePushResult FAILED_HISTORY_TEST;
        public static final HandlePushResult INVALID_DATA;
        public static final HandlePushResult INVALID_ROUTE;
        public static final HandlePushResult INVOKED_PARSE_PUSH_BROADCAST_RECEIVER;
        public static final HandlePushResult NO_ROUTE_FOUND;
        public static final HandlePushResult SHOW_NOTIFICATION;
        public static final HandlePushResult SHOW_NOTIFICATION_AND_BROADCAST_INTENT;

        public static HandlePushResult valueOf(String s)
        {
            return (HandlePushResult)Enum.valueOf(com/parse/PushRouter$HandlePushResult, s);
        }

        public static HandlePushResult[] values()
        {
            return (HandlePushResult[])$VALUES.clone();
        }

        static 
        {
            INVALID_DATA = new HandlePushResult("INVALID_DATA", 0);
            FAILED_HISTORY_TEST = new HandlePushResult("FAILED_HISTORY_TEST", 1);
            NO_ROUTE_FOUND = new HandlePushResult("NO_ROUTE_FOUND", 2);
            INVALID_ROUTE = new HandlePushResult("INVALID_ROUTE", 3);
            BROADCAST_INTENT = new HandlePushResult("BROADCAST_INTENT", 4);
            SHOW_NOTIFICATION = new HandlePushResult("SHOW_NOTIFICATION", 5);
            SHOW_NOTIFICATION_AND_BROADCAST_INTENT = new HandlePushResult("SHOW_NOTIFICATION_AND_BROADCAST_INTENT", 6);
            INVOKED_PARSE_PUSH_BROADCAST_RECEIVER = new HandlePushResult("INVOKED_PARSE_PUSH_BROADCAST_RECEIVER", 7);
            $VALUES = (new HandlePushResult[] {
                INVALID_DATA, FAILED_HISTORY_TEST, NO_ROUTE_FOUND, INVALID_ROUTE, BROADCAST_INTENT, SHOW_NOTIFICATION, SHOW_NOTIFICATION_AND_BROADCAST_INTENT, INVOKED_PARSE_PUSH_BROADCAST_RECEIVER
            });
        }

        private HandlePushResult(String s, int i)
        {
            super(s, i);
        }
    }

    static interface PushListener
    {

        public abstract void onPushHandled(JSONObject jsonobject, HandlePushResult handlepushresult);
    }


    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
    public static final String GCM_RECEIVE_ACTION = "com.google.android.c2dm.intent.RECEIVE";
    private static final String LEGACY_ROUTE_LOCATION = "persistentCallbacks";
    static int MAX_HISTORY_LENGTH = 0;
    private static final String STATE_LOCATION = "pushState";
    private static final String TAG = "com.parse.ParsePushRouter";
    private static final Integer V1_LATEST_PUSH_STATE_VERSION = Integer.valueOf(3);
    public static final Integer V2_PUSH_STATE_VERSION = Integer.valueOf(4);
    private static PushRouter instance;
    private static cu lastTask;
    private static PushListener pushListener;
    private Boolean forceEnabled;
    private final PushHistory history;
    private final AtomicBoolean isRefreshingInstallation = new AtomicBoolean(false);
    private int pushStateVersion;
    private final PushRoutes routes;
    private final String stateLocation;

    public PushRouter(String s, PushRoutes pushroutes, PushHistory pushhistory)
    {
        stateLocation = s;
        routes = pushroutes;
        history = pushhistory;
        forceEnabled = null;
        pushStateVersion = V1_LATEST_PUSH_STATE_VERSION.intValue();
    }

    private static JSONArray getChannelsArrayFromInstallation(ParseInstallation parseinstallation)
    {
        Object obj = null;
        java.util.List list = parseinstallation.getList("channels");
        parseinstallation = obj;
        if (list != null)
        {
            parseinstallation = (JSONArray)PointerOrLocalIdEncoder.get().encode(list);
        }
        if (parseinstallation != null)
        {
            return parseinstallation;
        } else
        {
            return new JSONArray();
        }
    }

    public static cu getForceEnabledStateAsync()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        cu cu1;
        cu1 = getLastTask().c(new ct() {

            public Boolean then(cu cu2)
            {
                return PushRouter.getInstance().forceEnabled;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(cu1.j());
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return cu1;
        Exception exception;
        exception;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static PushRouter getInstance()
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        JSONObject jsonobject1 = migrateV1toV3("persistentCallbacks", "pushState");
        jsonobject = jsonobject1;
        if (jsonobject1 == null)
        {
            jsonobject = migrateV2toV3("pushState", "pushState");
        }
        if (jsonobject != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        JSONObject jsonobject2 = ParseFileUtils.readFileToJSONObject(new File(Parse.getParseDir(), "pushState"));
        jsonobject = jsonobject2;
_L4:
        instance = new PushRouter("pushState", new PushRoutes(jsonobject), new PushHistory(MAX_HISTORY_LENGTH, jsonobject));
        if (jsonobject != null)
        {
            instance.forceEnabled = (Boolean)jsonobject.opt("forceEnabled");
            instance.pushStateVersion = jsonobject.optInt("version", V1_LATEST_PUSH_STATE_VERSION.intValue());
        }
_L2:
        return instance;
        Object obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static cu getLastTask()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        cu cu1;
        if (lastTask == null)
        {
            lastTask = cu.a(null).j();
        }
        cu1 = lastTask;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return cu1;
        Exception exception;
        exception;
        throw exception;
    }

    public static cu getPushRequestJSONAsync()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        cu cu1;
        cu1 = getLastTask().c(new ct() {

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            public JSONObject then(cu cu2)
            {
                return PushRouter.getInstance().getPushRequestJSON();
            }

        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(cu1.j());
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return cu1;
        Exception exception;
        exception;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static cu getSubscriptionsAsync(boolean flag)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        cu cu1;
        cu1 = getLastTask().c(new ct(flag) {

            final boolean val$includeDefaultRoute;

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            public Set then(cu cu2)
            {
                return PushRouter.getInstance().getSubscriptions(includeDefaultRoute);
            }

            
            {
                includeDefaultRoute = flag;
                super();
            }
        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(cu1.j());
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return cu1;
        Exception exception;
        exception;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void handleGcmPushIntent(Intent intent)
    {
        Semaphore semaphore = new Semaphore(0);
        EXECUTOR.submit(new Runnable(intent, semaphore) {

            final Semaphore val$done;
            final Intent val$intent;

            public void run()
            {
                PushRouter.getInstance().handleGcmPush(intent);
                done.release();
            }

            
            {
                intent = intent1;
                done = semaphore;
                super();
            }
        });
        semaphore.acquireUninterruptibly();
    }

    public static cu handlePpnsPushAsync(JSONObject jsonobject)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        jsonobject = getLastTask().c(new ct(jsonobject) {

            final JSONObject val$pushPayload;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
            {
                if (pushPayload != null)
                {
                    PushRouter.getInstance().handlePpnsPush(pushPayload);
                }
                return null;
            }

            
            {
                pushPayload = jsonobject;
                super();
            }
        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(jsonobject);
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return jsonobject;
        jsonobject;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw jsonobject;
    }

    private void handlePushInternal(JSONObject jsonobject)
    {
        Object obj1 = jsonobject.optJSONObject("data");
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new JSONObject();
        }
        getInstance();
        String s = jsonobject.optString("channel", null);
        obj1 = new Bundle();
        if (!(obj instanceof JSONObject))
        {
            jsonobject = ((JSONObject) (obj)).toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)obj);
        }
        ((Bundle) (obj1)).putString("com.parse.Data", jsonobject);
        ((Bundle) (obj1)).putString("com.parse.Channel", s);
        jsonobject = Parse.getApplicationContext();
        obj = new Intent("com.parse.push.intent.RECEIVE");
        ((Intent) (obj)).putExtras(((Bundle) (obj1)));
        ((Intent) (obj)).setPackage(jsonobject.getPackageName());
        jsonobject.sendBroadcast(((Intent) (obj)));
    }

    private HandlePushResult handlePushLegacy(JSONObject jsonobject)
    {
        Context context = Parse.getApplicationContext();
        Object obj1 = jsonobject.optJSONObject("data");
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new JSONObject();
        }
        String s = jsonobject.optString("channel", null);
        String s1 = ((JSONObject) (obj)).optString("action", null);
        Bundle bundle = new Bundle();
        if (!(obj instanceof JSONObject))
        {
            obj1 = ((JSONObject) (obj)).toString();
        } else
        {
            obj1 = JSONObjectInstrumentation.toString((JSONObject)obj);
        }
        bundle.putString("com.parse.Data", ((String) (obj1)));
        bundle.putString("com.parse.Channel", s);
        if (s1 != null)
        {
            obj1 = new Intent();
            ((Intent) (obj1)).putExtras(bundle);
            ((Intent) (obj1)).setAction(s1);
            ((Intent) (obj1)).setPackage(context.getPackageName());
            context.sendBroadcast(((Intent) (obj1)));
            if (!((JSONObject) (obj)).has("alert") && !((JSONObject) (obj)).has("title"))
            {
                return HandlePushResult.BROADCAST_INTENT;
            }
        }
        PushRoutes.Route route = routes.get(s);
        obj1 = route;
        if (route == null)
        {
            obj1 = route;
            if (s != null)
            {
                obj1 = routes.get(null);
            }
        }
        if (obj1 == null)
        {
            PLog.w("com.parse.ParsePushRouter", (new StringBuilder()).append("Received push that has no handler. Did you call PushService.setDefaultPushCallback or PushService.subscribe? Push payload: ").append(jsonobject).toString());
            if (s1 != null)
            {
                return HandlePushResult.BROADCAST_INTENT;
            } else
            {
                return HandlePushResult.NO_ROUTE_FOUND;
            }
        }
        jsonobject = ((PushRoutes.Route) (obj1)).getActivityClass();
        int j = ((PushRoutes.Route) (obj1)).getIconId();
        obj1 = ((JSONObject) (obj)).optString("title", ManifestInfo.getDisplayName(context));
        obj = ((JSONObject) (obj)).optString("alert", "Notification received.");
        int i = j;
        if (j == 0)
        {
            i = ManifestInfo.getIconId();
            PLog.w("com.parse.ParsePushRouter", (new StringBuilder()).append("Icon ID associated with channel ").append(s).append("is invalid; defaulting to package icon").toString());
        }
        ParseNotificationManager.getInstance().showNotification(context, ((String) (obj1)), ((String) (obj)), jsonobject, i, bundle);
        if (s1 != null)
        {
            return HandlePushResult.SHOW_NOTIFICATION_AND_BROADCAST_INTENT;
        } else
        {
            return HandlePushResult.SHOW_NOTIFICATION;
        }
    }

    public static boolean isGcmPushIntent(Intent intent)
    {
        return intent != null && "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction());
    }

    private static cu makeUnhandledExceptionsFatal(cu cu1)
    {
        return cu1.a(new ct() {

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            public Void then(cu cu2)
            {
                if (cu2.d())
                {
                    ParseExecutors.main().execute(cu2. new Runnable() {

                        final _cls11 this$0;
                        final cu val$task;

                        public void run()
                        {
                            throw new RuntimeException(task.f());
                        }

            
            {
                this$0 = final__pcls11;
                task = cu.this;
                super();
            }
                    });
                }
                return null;
            }

        }, EXECUTOR);
    }

    private static transient JSONObject merge(JSONObject ajsonobject[])
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        int j = ajsonobject.length;
        for (int i = 0; i < j; i++)
        {
            JSONObject jsonobject1 = ajsonobject[i];
            String s;
            for (Iterator iterator = jsonobject1.keys(); iterator.hasNext(); jsonobject.put(s, jsonobject1.get(s)))
            {
                s = (String)iterator.next();
            }

        }

        return jsonobject;
    }

    static JSONObject migrateV1toV3(String s, String s1)
    {
        ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
        Object obj = ParseFileUtils.readFileToJSONObject(new File(Parse.getParseDir(), s));
_L2:
        Object obj2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        PLog.d("com.parse.ParsePushRouter", (new StringBuilder()).append("Migrating push state from V1 to V3: ").append(obj).toString());
        obj2 = new ArrayList();
        for (Iterator iterator = ((JSONObject) (obj)).keys(); iterator.hasNext(); ((ArrayList) (obj2)).add(iterator.next())) { }
        break; /* Loop/switch isn't completed */
        obj;
_L6:
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
        Collections.sort(((java.util.List) (obj2)));
        parseinstallation.addAllUnique("channels", ((java.util.Collection) (obj2)));
        parseinstallation.saveEventually();
        obj2 = new JSONObject();
        ((JSONObject) (obj2)).put("version", 3);
        ((JSONObject) (obj2)).put("routes", obj);
        ((JSONObject) (obj2)).put("channels", getChannelsArrayFromInstallation(parseinstallation));
        ParseFileUtils.writeJSONObjectToFile(new File(Parse.getParseDir(), s1), ((JSONObject) (obj2)));
        obj = obj2;
_L4:
        if (!s.equals(s1))
        {
            ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), s));
        }
        return ((JSONObject) (obj));
        Object obj1;
        obj1;
_L5:
        PLog.e("com.parse.ParsePushRouter", "Unexpected error when serializing upgraded v1 push state", ((Throwable) (obj1)));
        obj1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
          goto _L5
        obj1;
          goto _L6
        return null;
    }

    static JSONObject migrateV2toV3(String s, String s1)
    {
        ArrayList arraylist;
        ParseInstallation parseinstallation;
        boolean flag;
        arraylist = null;
        flag = false;
        parseinstallation = ParseInstallation.getCurrentInstallation();
        Object obj = ParseFileUtils.readFileToJSONObject(new File(Parse.getParseDir(), s));
_L5:
        Object obj1 = arraylist;
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((JSONObject) (obj)).optInt("version") != 2) goto _L4; else goto _L3
        obj;
_L9:
        obj = null;
          goto _L5
_L3:
        PLog.d("com.parse.ParsePushRouter", (new StringBuilder()).append("Migrating push state from V2 to V3: ").append(obj).toString());
        obj1 = ((JSONObject) (obj)).optJSONArray("addChannels");
        if (obj1 != null)
        {
            arraylist = new ArrayList();
            for (int i = 0; i < ((JSONArray) (obj1)).length(); i++)
            {
                arraylist.add(((JSONArray) (obj1)).optString(i));
            }

            parseinstallation.addAllUnique("channels", arraylist);
            parseinstallation.saveEventually();
        }
        obj1 = ((JSONObject) (obj)).optJSONArray("removeChannels");
        if (obj1 != null)
        {
            arraylist = new ArrayList();
            for (int j = ((flag) ? 1 : 0); j < ((JSONArray) (obj1)).length(); j++)
            {
                arraylist.add(((JSONArray) (obj1)).optString(j));
            }

            parseinstallation.removeAll("channels", arraylist);
            parseinstallation.saveEventually();
        }
        if (((JSONObject) (obj)).has("installation"))
        {
            parseinstallation.setState(parseinstallation.mergeFromDiskJSON(parseinstallation.getState(), ((JSONObject) (obj)).optJSONObject("installation")));
            parseinstallation.saveEventually();
        }
        ((JSONObject) (obj)).put("version", 3);
        ((JSONObject) (obj)).remove("addChannels");
        ((JSONObject) (obj)).remove("removeChannels");
        ((JSONObject) (obj)).remove("installation");
        ((JSONObject) (obj)).put("channels", getChannelsArrayFromInstallation(parseinstallation));
        ParseFileUtils.writeJSONObjectToFile(new File(Parse.getParseDir(), s1), ((JSONObject) (obj)));
_L6:
        if (!s.equals(s1))
        {
            ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), s));
        }
        obj1 = obj;
_L2:
        return ((JSONObject) (obj1));
        obj;
_L8:
        PLog.e("com.parse.ParsePushRouter", "Unexpected error when serializing upgraded v2 push state", ((Throwable) (obj)));
        obj = null;
          goto _L6
_L4:
        obj1 = arraylist;
        if (((JSONObject) (obj)).optInt("version") != 3) goto _L2; else goto _L7
_L7:
        return ((JSONObject) (obj));
        obj;
          goto _L8
        IOException ioexception;
        ioexception;
          goto _L9
    }

    static void noteHandlePushResult(JSONObject jsonobject, HandlePushResult handlepushresult)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        PushListener pushlistener = pushListener;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        if (pushlistener != null)
        {
            getLastTask().a(new ct(pushlistener, jsonobject, handlepushresult) {

                final PushListener val$finalListener;
                final JSONObject val$pushData;
                final HandlePushResult val$result;

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

                public Void then(cu cu1)
                {
                    finalListener.onPushHandled(pushData, result);
                    return null;
                }

            
            {
                finalListener = pushlistener;
                pushData = jsonobject;
                result = handlepushresult;
                super();
            }
            }, EXECUTOR);
        }
        return;
        jsonobject;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw jsonobject;
    }

    public static cu reloadFromDiskAsync(boolean flag)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        cu cu1;
        cu1 = getLastTask().c(new ct(flag) {

            final boolean val$removeExistingState;

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            public Void then(cu cu2)
            {
                PushRouter.reloadInstance(removeExistingState);
                return null;
            }

            
            {
                removeExistingState = flag;
                super();
            }
        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(cu1);
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return cu1;
        Exception exception;
        exception;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static PushRouter reloadInstance(boolean flag)
    {
        if (flag)
        {
            ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), "persistentCallbacks"));
            ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), "pushState"));
        }
        instance = null;
        return getInstance();
    }

    public static cu setForceEnabledAsync(Boolean boolean1)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        boolean1 = getLastTask().c(new ct(boolean1) {

            final Boolean val$forceEnabled;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
            {
                PushRouter.getInstance().setForceEnabledState(forceEnabled);
                return null;
            }

            
            {
                forceEnabled = boolean1;
                super();
            }
        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(boolean1);
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return boolean1;
        boolean1;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw boolean1;
    }

    static void setGlobalPushListener(PushListener pushlistener)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        pushListener = pushlistener;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return;
        pushlistener;
        throw pushlistener;
    }

    public static cu subscribeAsync(String s, Class class1, int i)
    {
        if (s != null && !PushRoutes.isValidChannelName(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid channel name: + ").append(s).append(" (must be empty ").append("string or a letter followed by alphanumerics or hyphen)").toString());
        }
        if (class1 == null)
        {
            throw new IllegalArgumentException("Can't subscribe to channel with null activity class.");
        }
        if (i == 0)
        {
            throw new IllegalArgumentException("Must subscribe to channel with a valid icon identifier.");
        }
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        s = getLastTask().c(new ct(s, class1, i) {

            final String val$channel;
            final Class val$cls;
            final int val$iconId;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
            {
                PushRouter.getInstance().subscribe(channel, cls, iconId);
                return null;
            }

            
            {
                channel = s;
                cls = class1;
                iconId = i;
                super();
            }
        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(s);
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return s;
        s;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static cu unsubscribeAsync(String s)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        s = getLastTask().c(new ct(s) {

            final String val$channel;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
            {
                PushRouter.getInstance().unsubscribe(channel);
                return null;
            }

            
            {
                channel = s;
                super();
            }
        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(s);
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return s;
        s;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static cu wipeRoutingAndUpgradePushStateAsync()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        cu cu1;
        cu1 = getLastTask().c(new ct() {

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            public Void then(cu cu2)
                throws Exception
            {
                PushRouter.getInstance().setPushStateVersion(PushRouter.V2_PUSH_STATE_VERSION.intValue());
                return null;
            }

        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(cu1);
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return cu1;
        Exception exception;
        exception;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    JSONObject convertGcmIntentToJSONObject(Intent intent)
    {
        if (intent != null)
        {
            String s = intent.getStringExtra("message_type");
            if (s != null)
            {
                PLog.i("com.parse.ParsePushRouter", (new StringBuilder()).append("Ignored special message type ").append(s).append(" from GCM via intent").append(intent).toString());
            } else
            {
                Object obj = intent.getStringExtra("data");
                String s1 = intent.getStringExtra("channel");
                boolean flag = false;
                if (obj != null)
                {
                    try
                    {
                        intent = JSONObjectInstrumentation.init(((String) (obj)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Intent intent)
                    {
                        PLog.e("com.parse.ParsePushRouter", (new StringBuilder()).append("Ignoring push because of JSON exception while processing: ").append(((String) (obj))).toString(), intent);
                        flag = true;
                        intent = null;
                    }
                } else
                {
                    intent = null;
                }
                if (!flag)
                {
                    try
                    {
                        obj = new JSONObject();
                        ((JSONObject) (obj)).putOpt("data", intent);
                        ((JSONObject) (obj)).putOpt("channel", s1);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Intent intent)
                    {
                        PLog.e("com.parse.ParsePushRouter", "Ignoring push because of JSON exception while building payload", intent);
                        return null;
                    }
                    return ((JSONObject) (obj));
                }
            }
        }
        return null;
    }

    public JSONObject getPushRequestJSON()
    {
        Parse.checkInit();
        Object obj = ParsePlugins.get().applicationId();
        JSONObject jsonobject = new JSONObject();
        ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
        try
        {
            jsonobject.put("installation_id", parseinstallation.getInstallationId());
            jsonobject.put("oauth_key", obj);
            jsonobject.put("v", "a1.9.4");
            obj = history.getLastReceivedTimestamp();
        }
        catch (JSONException jsonexception)
        {
            PLog.e("com.parse.ParsePushRouter", "Unexpected JSONException serializing push handshake", jsonexception);
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        jsonobject.put("last", obj);
        obj = history.getPushIds();
        if (((Set) (obj)).size() > 0)
        {
            jsonobject.put("last_seen", new JSONArray(((java.util.Collection) (obj))));
        }
        jsonobject.put("ack_keep_alive", true);
        jsonobject.putOpt("ignore_after", history.getCutoffTimestamp());
        return jsonobject;
        obj = JSONObject.NULL;
        break MISSING_BLOCK_LABEL_66;
    }

    public Set getSubscriptions(boolean flag)
    {
        HashSet hashset = new HashSet();
        java.util.List list = ParseInstallation.getCurrentInstallation().getList("channels");
        if (list != null)
        {
            hashset.addAll(list);
        }
        hashset.addAll(routes.getChannels());
        if (!flag)
        {
            hashset.remove(null);
        }
        return Collections.unmodifiableSet(hashset);
    }

    public HandlePushResult handleGcmPush(Intent intent)
    {
        return maybeHandlePush(intent.getStringExtra("push_id"), intent.getStringExtra("time"), convertGcmIntentToJSONObject(intent));
    }

    public HandlePushResult handlePpnsPush(JSONObject jsonobject)
    {
        return maybeHandlePush(jsonobject.optString("push_id", null), jsonobject.optString("time", null), jsonobject);
    }

    public HandlePushResult handlePush(JSONObject jsonobject)
    {
        HandlePushResult handlepushresult;
        if (ManifestInfo.getPushUsesBroadcastReceivers())
        {
            handlePushInternal(jsonobject);
            handlepushresult = HandlePushResult.INVOKED_PARSE_PUSH_BROADCAST_RECEIVER;
        } else
        {
            handlepushresult = handlePushLegacy(jsonobject);
        }
        noteHandlePushResult(jsonobject, handlepushresult);
        return handlepushresult;
    }

    public HandlePushResult maybeHandlePush(String s, String s1, JSONObject jsonobject)
    {
        if (ParseTextUtils.isEmpty(s) || ParseTextUtils.isEmpty(s1) || jsonobject == null)
        {
            return HandlePushResult.INVALID_DATA;
        }
        if (!history.tryInsertPush(s, s1))
        {
            return HandlePushResult.FAILED_HISTORY_TEST;
        } else
        {
            saveStateToDisk();
            return handlePush(jsonobject);
        }
    }

    public boolean saveStateToDisk()
    {
        JSONObject jsonobject = toJSON();
        ParseFileUtils.writeJSONObjectToFile(new File(Parse.getParseDir(), stateLocation), jsonobject);
        return true;
        Object obj;
        obj;
_L2:
        PLog.e("com.parse.ParsePushRouter", "Unexpected error when serializing push state", ((Throwable) (obj)));
        return false;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setForceEnabledState(Boolean boolean1)
    {
        Boolean boolean2 = forceEnabled;
        if (boolean2 != null && boolean2 == boolean1)
        {
            return;
        } else
        {
            forceEnabled = boolean1;
            saveStateToDisk();
            return;
        }
    }

    public void setPushStateVersion(int i)
    {
        if (i != pushStateVersion)
        {
            pushStateVersion = i;
            saveStateToDisk();
        }
    }

    public void subscribe(String s, Class class1, int i)
    {
        ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
        class1 = new PushRoutes.Route(class1.getName(), i);
        PushRoutes.Route route = routes.put(s, class1);
        if (!class1.equals(route))
        {
            saveStateToDisk();
        }
        if (route == null && s != null)
        {
            parseinstallation.addUnique("channels", s);
        }
        parseinstallation.saveEventually();
    }

    public JSONObject toJSON()
        throws JSONException
    {
        JSONObject jsonobject;
        if (V2_PUSH_STATE_VERSION.equals(Integer.valueOf(pushStateVersion)))
        {
            jsonobject = history.toJSON();
        } else
        {
            jsonobject = merge(new JSONObject[] {
                routes.toJSON(), history.toJSON()
            });
            jsonobject.put("channels", getChannelsArrayFromInstallation(ParseInstallation.getCurrentInstallation()));
        }
        jsonobject.put("version", pushStateVersion);
        jsonobject.putOpt("forceEnabled", forceEnabled);
        return jsonobject;
    }

    public void unsubscribe(String s)
    {
        if (routes.remove(s) != null)
        {
            saveStateToDisk();
            if (s != null)
            {
                ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
                parseinstallation.removeAll("channels", Arrays.asList(new String[] {
                    s
                }));
                parseinstallation.saveEventually();
            }
        }
    }

    static 
    {
        MAX_HISTORY_LENGTH = 10;
    }



}
