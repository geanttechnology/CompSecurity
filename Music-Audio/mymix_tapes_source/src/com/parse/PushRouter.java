// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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
//            ParseInstallation, PointerOrLocalIdEncodingStrategy, Parse, PushRoutes, 
//            PushHistory, ManifestInfo, ParseNotificationManager, ParseDecoder, 
//            ParseObject

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
    private static Task lastTask;
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
            parseinstallation = (JSONArray)Parse.encode(list, PointerOrLocalIdEncodingStrategy.get());
        }
        if (parseinstallation != null)
        {
            return parseinstallation;
        } else
        {
            return new JSONArray();
        }
    }

    public static Task getForceEnabledStateAsync()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        Task task;
        task = getLastTask().onSuccess(new Continuation() {

            public Boolean then(Task task1)
            {
                return PushRouter.getInstance().forceEnabled;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(task.makeVoid());
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static PushRouter getInstance()
    {
        if (instance == null)
        {
            JSONObject jsonobject1 = migrateV1toV3("persistentCallbacks", "pushState");
            JSONObject jsonobject = jsonobject1;
            if (jsonobject1 == null)
            {
                jsonobject = migrateV2toV3("pushState", "pushState");
            }
            jsonobject1 = jsonobject;
            if (jsonobject == null)
            {
                jsonobject1 = Parse.getDiskObject(Parse.applicationContext, "pushState");
            }
            instance = new PushRouter("pushState", new PushRoutes(jsonobject1), new PushHistory(MAX_HISTORY_LENGTH, jsonobject1));
            if (jsonobject1 != null)
            {
                instance.forceEnabled = (Boolean)jsonobject1.opt("forceEnabled");
                instance.pushStateVersion = jsonobject1.optInt("version", V1_LATEST_PUSH_STATE_VERSION.intValue());
            }
        }
        return instance;
    }

    private static Task getLastTask()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        Task task;
        if (lastTask == null)
        {
            lastTask = Task.forResult(null).makeVoid();
        }
        task = lastTask;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public static Task getPushRequestJSONAsync()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        Task task;
        task = getLastTask().onSuccess(new Continuation() {

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public JSONObject then(Task task1)
            {
                return PushRouter.getInstance().getPushRequestJSON();
            }

        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(task.makeVoid());
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static Task getPushStateVersionAsync()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        Task task;
        task = getLastTask().onSuccess(new Continuation() {

            public Integer then(Task task1)
            {
                return Integer.valueOf(PushRouter.getInstance().pushStateVersion);
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(task.makeVoid());
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static PushRoutes.Route getRoute(String s)
    {
        try
        {
            s = (PushRoutes.Route)Parse.waitForTask(getRouteAsync(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private static Task getRouteAsync(String s)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        s = getLastTask().onSuccess(new Continuation(s) {

            final String val$channel;

            public PushRoutes.Route then(Task task)
                throws Exception
            {
                PushRoutes.Route route = PushRouter.getInstance().routes.get(channel);
                task = route;
                if (route == null)
                {
                    task = route;
                    if (channel != null)
                    {
                        task = PushRouter.getInstance().routes.get(null);
                    }
                }
                return task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                channel = s;
                super();
            }
        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(s.makeVoid());
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return s;
        s;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static Task getSubscriptionsAsync(boolean flag)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        Task task;
        task = getLastTask().onSuccess(new Continuation(flag) {

            final boolean val$includeDefaultRoute;

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public Set then(Task task1)
            {
                return PushRouter.getInstance().getSubscriptions(includeDefaultRoute);
            }

            
            {
                includeDefaultRoute = flag;
                super();
            }
        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(task.makeVoid());
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return task;
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

    public static Task handlePpnsPushAsync(JSONObject jsonobject)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        jsonobject = getLastTask().onSuccess(new Continuation(jsonobject) {

            final JSONObject val$pushPayload;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
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
        obj1 = jsonobject.optString("channel", null);
        jsonobject = new Bundle();
        jsonobject.putString("com.parse.Data", ((JSONObject) (obj)).toString());
        jsonobject.putString("com.parse.Channel", ((String) (obj1)));
        obj = Parse.applicationContext;
        obj1 = new Intent("com.parse.push.intent.RECEIVE");
        ((Intent) (obj1)).putExtras(jsonobject);
        ((Intent) (obj1)).setPackage(((Context) (obj)).getPackageName());
        ((Context) (obj)).sendBroadcast(((Intent) (obj1)));
    }

    private HandlePushResult handlePushLegacy(JSONObject jsonobject)
    {
        Object obj1 = jsonobject.optJSONObject("data");
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new JSONObject();
        }
        String s1 = jsonobject.optString("channel", null);
        String s = ((JSONObject) (obj)).optString("action", null);
        Bundle bundle = new Bundle();
        bundle.putString("com.parse.Data", ((JSONObject) (obj)).toString());
        bundle.putString("com.parse.Channel", s1);
        if (s != null)
        {
            obj1 = new Intent();
            ((Intent) (obj1)).putExtras(bundle);
            ((Intent) (obj1)).setAction(s);
            ((Intent) (obj1)).setPackage(Parse.applicationContext.getPackageName());
            Parse.applicationContext.sendBroadcast(((Intent) (obj1)));
            if (!((JSONObject) (obj)).has("alert") && !((JSONObject) (obj)).has("title"))
            {
                return HandlePushResult.BROADCAST_INTENT;
            }
        }
        Object obj2 = routes.get(s1);
        obj1 = obj2;
        if (obj2 == null)
        {
            obj1 = obj2;
            if (s1 != null)
            {
                obj1 = routes.get(null);
            }
        }
        if (obj1 == null)
        {
            Parse.logW("com.parse.ParsePushRouter", (new StringBuilder()).append("Received push that has no handler. Did you call PushService.setDefaultPushCallback or PushService.subscribe? Push payload: ").append(jsonobject).toString());
            if (s != null)
            {
                return HandlePushResult.BROADCAST_INTENT;
            } else
            {
                return HandlePushResult.NO_ROUTE_FOUND;
            }
        }
        jsonobject = ((PushRoutes.Route) (obj1)).getActivityClass();
        int j = ((PushRoutes.Route) (obj1)).getIconId();
        obj1 = ((JSONObject) (obj)).optString("title", ManifestInfo.getDisplayName());
        obj = ((JSONObject) (obj)).optString("alert", "Notification received.");
        int i = j;
        if (j == 0)
        {
            i = ManifestInfo.getIconId();
            Parse.logW("com.parse.ParsePushRouter", (new StringBuilder()).append("Icon ID associated with channel ").append(s1).append("is invalid; defaulting to package icon").toString());
        }
        obj2 = Parse.applicationContext;
        ParseNotificationManager.getInstance().showNotification(((Context) (obj2)), ((String) (obj1)), ((String) (obj)), jsonobject, i, bundle);
        if (s != null)
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

    private static Task makeUnhandledExceptionsFatal(Task task)
    {
        return task.continueWith(new Continuation() {

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public Void then(Task task1)
            {
                if (task1.isFaulted())
                {
                    Task.UI_THREAD_EXECUTOR.execute(task1. new Runnable() {

                        final _cls13 this$0;
                        final Task val$task;

                        public void run()
                        {
                            throw new RuntimeException(task.getError());
                        }

            
            {
                this$0 = final__pcls13;
                task = Task.this;
                super();
            }
                    });
                }
                return null;
            }

        }, EXECUTOR);
    }

    private void maybeRefreshInstallation(Date date)
    {
        Date date1 = ParseInstallation.getCurrentInstallation().getUpdatedAt();
        if (date1 != null && date != null && date1.compareTo(date) < 0 && isRefreshingInstallation.compareAndSet(false, true))
        {
            ParseInstallation.getCurrentInstallation().fetchInBackground().continueWith(new Continuation() {

                final PushRouter this$0;

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

                public Void then(Task task)
                {
                    isRefreshingInstallation.set(false);
                    return null;
                }

            
            {
                this$0 = PushRouter.this;
                super();
            }
            });
        }
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
        Object obj;
        Object obj1;
        ParseInstallation parseinstallation;
        JSONObject jsonobject;
        parseinstallation = ParseInstallation.getCurrentInstallation();
        jsonobject = Parse.getDiskObject(Parse.applicationContext, s);
        obj1 = null;
        obj = null;
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        Parse.logD("com.parse.ParsePushRouter", (new StringBuilder()).append("Migrating push state from V1 to V3: ").append(jsonobject).toString());
        obj1 = new ArrayList();
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); ((ArrayList) (obj1)).add(iterator.next())) { }
        parseinstallation.addAllUnique("channels", ((java.util.Collection) (obj1)));
        parseinstallation.saveEventually();
        obj1 = new JSONObject();
        ((JSONObject) (obj1)).put("version", 3);
        ((JSONObject) (obj1)).put("routes", jsonobject);
        ((JSONObject) (obj1)).put("channels", getChannelsArrayFromInstallation(parseinstallation));
        Parse.saveDiskObject(Parse.applicationContext, s1, ((JSONObject) (obj1)));
        obj = obj1;
_L4:
        obj1 = obj;
        if (!s.equals(s1))
        {
            Parse.deleteDiskObject(Parse.applicationContext, s);
            obj1 = obj;
        }
_L2:
        return ((JSONObject) (obj1));
        JSONException jsonexception;
        jsonexception;
        Parse.logE("com.parse.ParsePushRouter", "Unexpected JSONException when serializing upgraded v1 push state: ", jsonexception);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static JSONObject migrateV2toV3(String s, String s1)
    {
        JSONObject jsonobject;
        Object obj;
        JSONObject jsonobject1;
        ArrayList arraylist;
        ParseInstallation parseinstallation;
        parseinstallation = ParseInstallation.getCurrentInstallation();
        jsonobject1 = Parse.getDiskObject(Parse.applicationContext, s);
        arraylist = null;
        jsonobject = null;
        obj = arraylist;
        if (jsonobject1 == null) goto _L2; else goto _L1
_L1:
        if (jsonobject1.optInt("version") != 2) goto _L4; else goto _L3
_L3:
        Parse.logD("com.parse.ParsePushRouter", (new StringBuilder()).append("Migrating push state from V2 to V3: ").append(jsonobject1).toString());
        obj = jsonobject1.optJSONArray("addChannels");
        if (obj != null)
        {
            arraylist = new ArrayList();
            for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
            {
                arraylist.add(((JSONArray) (obj)).optString(i));
            }

            parseinstallation.addAllUnique("channels", arraylist);
            parseinstallation.saveEventually();
        }
        obj = jsonobject1.optJSONArray("removeChannels");
        if (obj != null)
        {
            arraylist = new ArrayList();
            for (int j = 0; j < ((JSONArray) (obj)).length(); j++)
            {
                arraylist.add(((JSONArray) (obj)).optString(j));
            }

            parseinstallation.removeAll("channels", arraylist);
            parseinstallation.saveEventually();
        }
        if (jsonobject1.has("installation"))
        {
            obj = new ParseDecoder();
            parseinstallation.mergeAfterFetch(jsonobject1.optJSONObject("installation"), ((ParseDecoder) (obj)), true);
            parseinstallation.saveEventually();
        }
        try
        {
            jsonobject1.put("version", 3);
            jsonobject1.remove("addChannels");
            jsonobject1.remove("removeChannels");
            jsonobject1.remove("installation");
            jsonobject1.put("channels", getChannelsArrayFromInstallation(parseinstallation));
            Parse.saveDiskObject(Parse.applicationContext, s1, jsonobject1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Parse.logE("com.parse.ParsePushRouter", "Unexpected JSONException when serializing upgraded v2 push state: ", ((Throwable) (obj)));
            continue; /* Loop/switch isn't completed */
        }
        jsonobject = jsonobject1;
_L7:
        obj = jsonobject;
        if (!s.equals(s1))
        {
            Parse.deleteDiskObject(Parse.applicationContext, s);
            obj = jsonobject;
        }
_L2:
        return ((JSONObject) (obj));
_L4:
        obj = arraylist;
        if (jsonobject1.optInt("version") != 3) goto _L2; else goto _L5
_L5:
        return jsonobject1;
        if (true) goto _L7; else goto _L6
_L6:
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
            getLastTask().continueWith(new Continuation(pushlistener, jsonobject, handlepushresult) {

                final PushListener val$finalListener;
                final JSONObject val$pushData;
                final HandlePushResult val$result;

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

                public Void then(Task task)
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

    public static Task reloadFromDiskAsync(boolean flag)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        Task task;
        task = getLastTask().onSuccess(new Continuation(flag) {

            final boolean val$removeExistingState;

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public Void then(Task task1)
            {
                PushRouter.reloadInstance(removeExistingState);
                return null;
            }

            
            {
                removeExistingState = flag;
                super();
            }
        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(task);
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return task;
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
            Parse.deleteDiskObject(Parse.applicationContext, "persistentCallbacks");
            Parse.deleteDiskObject(Parse.applicationContext, "pushState");
        }
        instance = null;
        return getInstance();
    }

    private Date serverInstallationUpdatedAt(JSONObject jsonobject)
    {
        Object obj = null;
        String s = jsonobject.optString("installation_updated_at", null);
        jsonobject = obj;
        if (s != null)
        {
            jsonobject = Parse.stringToDate(s);
        }
        return jsonobject;
    }

    public static Task setForceEnabledAsync(Boolean boolean1)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        boolean1 = getLastTask().onSuccess(new Continuation(boolean1) {

            final Boolean val$forceEnabled;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
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

    public static Task subscribeAsync(String s, Class class1, int i)
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
        s = getLastTask().onSuccess(new Continuation(s, class1, i) {

            final String val$channel;
            final Class val$cls;
            final int val$iconId;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
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

    public static Task unsubscribeAsync(String s)
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        s = getLastTask().onSuccess(new Continuation(s) {

            final String val$channel;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
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

    public static Task wipeRoutingAndUpgradePushStateAsync()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        Task task;
        task = getLastTask().onSuccess(new Continuation() {

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public Void then(Task task1)
                throws Exception
            {
                PushRouter.getInstance().setPushStateVersion(PushRouter.V2_PUSH_STATE_VERSION.intValue());
                return null;
            }

        }, EXECUTOR);
        lastTask = makeUnhandledExceptionsFatal(task);
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    JSONObject convertGcmIntentToJSONObject(Intent intent)
    {
        if (intent == null) goto _L2; else goto _L1
_L1:
        Object obj = intent.getStringExtra("message_type");
        if (obj == null) goto _L4; else goto _L3
_L3:
        Parse.logI("com.parse.ParsePushRouter", (new StringBuilder()).append("Ignored special message type ").append(((String) (obj))).append(" from GCM via intent").append(intent).toString());
_L2:
        return null;
_L4:
        String s;
        String s1;
        String s2;
        boolean flag;
        boolean flag1;
        s2 = intent.getStringExtra("data");
        s = intent.getStringExtra("channel");
        s1 = intent.getStringExtra("installation_updated_at");
        obj = null;
        flag1 = false;
        flag = flag1;
        intent = ((Intent) (obj));
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        intent = new JSONObject(s2);
        flag = flag1;
_L6:
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new JSONObject();
        ((JSONObject) (obj)).putOpt("data", intent);
        ((JSONObject) (obj)).putOpt("channel", s);
        ((JSONObject) (obj)).putOpt("installation_updated_at", s1);
        return ((JSONObject) (obj));
        intent;
        Parse.logE("com.parse.ParsePushRouter", (new StringBuilder()).append("Ignoring push because of JSON exception while processing: ").append(s2).toString(), intent);
        flag = true;
        intent = ((Intent) (obj));
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L2; else goto _L7
_L7:
        intent;
_L9:
        Parse.logE("com.parse.ParsePushRouter", "Ignoring push because of JSON exception while building payload", intent);
        return null;
        intent;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public JSONObject getPushRequestJSON()
    {
        JSONObject jsonobject = new JSONObject();
        Object obj = ParseInstallation.getCurrentInstallation();
        try
        {
            jsonobject.put("installation_id", ((ParseInstallation) (obj)).getInstallationId());
            jsonobject.put("oauth_key", ParseObject.getApplicationId());
            jsonobject.put("v", "a1.8.0");
            obj = history.getLastReceivedTimestamp();
        }
        catch (JSONException jsonexception)
        {
            Parse.logE("com.parse.ParsePushRouter", "Unexpected JSONException serializing push handshake", jsonexception);
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_126;
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
        break MISSING_BLOCK_LABEL_58;
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
        intent = convertGcmIntentToJSONObject(intent);
        if (intent != null)
        {
            return handlePush(intent);
        } else
        {
            return HandlePushResult.INVALID_DATA;
        }
    }

    public HandlePushResult handlePpnsPush(JSONObject jsonobject)
    {
        HandlePushResult handlepushresult1 = HandlePushResult.FAILED_HISTORY_TEST;
        String s = jsonobject.optString("push_id", null);
        String s1 = jsonobject.optString("time", null);
        HandlePushResult handlepushresult = handlepushresult1;
        if (s1 != null)
        {
            handlepushresult = handlepushresult1;
            if (history.tryInsertPush(s, s1))
            {
                handlepushresult = handlePush(jsonobject);
                saveStateToDisk();
            }
        }
        return handlepushresult;
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
        maybeRefreshInstallation(serverInstallationUpdatedAt(jsonobject));
        noteHandlePushResult(jsonobject, handlepushresult);
        return handlepushresult;
    }

    public boolean saveStateToDisk()
    {
        try
        {
            JSONObject jsonobject = toJSON();
            Parse.saveDiskObject(Parse.applicationContext, stateLocation, jsonobject);
        }
        catch (JSONException jsonexception)
        {
            Parse.logE("com.parse.ParsePushRouter", "Error serializing push state to json", jsonexception);
            return false;
        }
        return true;
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
