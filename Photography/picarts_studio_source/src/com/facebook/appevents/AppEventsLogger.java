// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.appevents;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import bolts.AppLinks;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLogger
{

    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 0x15180;
    private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private static final String TAG = com/facebook/appevents/AppEventsLogger.getCanonicalName();
    private static String anonymousAppDeviceGUID;
    private static Context applicationContext;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static FlushBehavior flushBehavior;
    private static boolean isOpenedByApplink;
    private static boolean requestInFlight;
    private static String sourceApplication;
    private static Map stateMap = new ConcurrentHashMap();
    private static Object staticLock = new Object();
    private final AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;

    private AppEventsLogger(Context context, String s, AccessToken accesstoken)
    {
        Validate.notNull(context, "context");
        contextName = Utility.getActivityName(context);
        AccessToken accesstoken1 = accesstoken;
        if (accesstoken == null)
        {
            accesstoken1 = AccessToken.getCurrentAccessToken();
        }
        if (accesstoken1 != null && (s == null || s.equals(accesstoken1.getApplicationId())))
        {
            accessTokenAppId = new AccessTokenAppIdPair(accesstoken1);
        } else
        {
            accesstoken = s;
            if (s == null)
            {
                accesstoken = Utility.getMetadataApplicationId(context);
            }
            accessTokenAppId = new AccessTokenAppIdPair(null, accesstoken);
        }
        synchronized (staticLock)
        {
            if (applicationContext == null)
            {
                applicationContext = context.getApplicationContext();
            }
        }
        initializeTimersIfNeeded();
        return;
        context;
        s;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static int accumulatePersistedEvents()
    {
        PersistedEvents persistedevents = PersistedEvents.readAndClearStore(applicationContext);
        Iterator iterator = persistedevents.keySet().iterator();
        Object obj;
        int i;
        for (i = 0; iterator.hasNext(); i = ((List) (obj)).size() + i)
        {
            obj = (AccessTokenAppIdPair)iterator.next();
            SessionEventsState sessioneventsstate = getSessionEventsState(applicationContext, ((AccessTokenAppIdPair) (obj)));
            obj = persistedevents.getEvents(((AccessTokenAppIdPair) (obj)));
            sessioneventsstate.accumulatePersistedEvents(((List) (obj)));
        }

        return i;
    }

    public static void activateApp(Context context)
    {
        FacebookSdk.sdkInitialize(context);
        activateApp(context, Utility.getMetadataApplicationId(context));
    }

    public static void activateApp(Context context, String s)
    {
        if (context == null || s == null)
        {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        long l;
        if (context instanceof Activity)
        {
            setSourceApplication((Activity)context);
        } else
        {
            resetSourceApplication();
            com/facebook/appevents/AppEventsLogger.getName();
        }
        FacebookSdk.publishInstallAsync(context, s);
        context = new AppEventsLogger(context, s, null);
        l = System.currentTimeMillis();
        s = getSourceApplication();
        backgroundExecutor.execute(new _cls1(context, l, s));
    }

    private static FlushStatistics buildAndExecuteRequests(FlushReason flushreason, Set set)
    {
        FlushStatistics flushstatistics = new FlushStatistics(null);
        boolean flag = FacebookSdk.getLimitEventAndDataUsage(applicationContext);
        ArrayList arraylist = new ArrayList();
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            Object obj = (AccessTokenAppIdPair)set.next();
            SessionEventsState sessioneventsstate = getSessionEventsState(((AccessTokenAppIdPair) (obj)));
            if (sessioneventsstate != null)
            {
                obj = buildRequestForSession(((AccessTokenAppIdPair) (obj)), sessioneventsstate, flag, flushstatistics);
                if (obj != null)
                {
                    arraylist.add(obj);
                }
            }
        } while (true);
        if (arraylist.size() > 0)
        {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", new Object[] {
                Integer.valueOf(flushstatistics.numEvents), flushreason.toString()
            });
            for (flushreason = arraylist.iterator(); flushreason.hasNext(); ((GraphRequest)flushreason.next()).executeAndWait()) { }
            return flushstatistics;
        } else
        {
            return null;
        }
    }

    private static GraphRequest buildRequestForSession(AccessTokenAppIdPair accesstokenappidpair, SessionEventsState sessioneventsstate, boolean flag, FlushStatistics flushstatistics)
    {
        Object obj = accesstokenappidpair.getApplicationId();
        com.facebook.internal.Utility.FetchedAppSettings fetchedappsettings = Utility.queryAppSettings(((String) (obj)), false);
        GraphRequest graphrequest = GraphRequest.newPostRequest(null, String.format("%s/activities", new Object[] {
            obj
        }), null, null);
        Bundle bundle = graphrequest.getParameters();
        obj = bundle;
        if (bundle == null)
        {
            obj = new Bundle();
        }
        ((Bundle) (obj)).putString("access_token", accesstokenappidpair.getAccessTokenString());
        graphrequest.setParameters(((Bundle) (obj)));
        if (fetchedappsettings == null)
        {
            return null;
        }
        int i = sessioneventsstate.populateRequest(graphrequest, fetchedappsettings.supportsImplicitLogging(), flag);
        if (i == 0)
        {
            return null;
        } else
        {
            flushstatistics.numEvents = i + flushstatistics.numEvents;
            graphrequest.setCallback(new _cls7(accesstokenappidpair, graphrequest, sessioneventsstate, flushstatistics));
            return graphrequest;
        }
    }

    public static void deactivateApp(Context context)
    {
        deactivateApp(context, Utility.getMetadataApplicationId(context));
    }

    public static void deactivateApp(Context context, String s)
    {
        if (context == null || s == null)
        {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        } else
        {
            resetSourceApplication();
            context = new AppEventsLogger(context, s, null);
            long l = System.currentTimeMillis();
            backgroundExecutor.execute(new _cls2(context, l));
            return;
        }
    }

    static void eagerFlush()
    {
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY)
        {
            flush(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    private static void flush(FlushReason flushreason)
    {
        FacebookSdk.getExecutor().execute(new _cls6(flushreason));
    }

    private static void flushAndWait(FlushReason flushreason)
    {
label0:
        {
            synchronized (staticLock)
            {
                if (!requestInFlight)
                {
                    break label0;
                }
            }
            return;
        }
        HashSet hashset;
        requestInFlight = true;
        hashset = new HashSet(stateMap.keySet());
        obj;
        JVM INSTR monitorexit ;
        accumulatePersistedEvents();
        obj = null;
        try
        {
            flushreason = buildAndExecuteRequests(flushreason, hashset);
        }
        // Misplaced declaration of an exception variable
        catch (FlushReason flushreason)
        {
            Utility.logd(TAG, "Caught unexpected exception while flushing: ", flushreason);
            flushreason = ((FlushReason) (obj));
        }
        synchronized (staticLock)
        {
            requestInFlight = false;
        }
        if (flushreason != null)
        {
            obj = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
            ((Intent) (obj)).putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", ((FlushStatistics) (flushreason)).numEvents);
            ((Intent) (obj)).putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", ((FlushStatistics) (flushreason)).result);
            LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(((Intent) (obj)));
            return;
        } else
        {
            return;
        }
        flushreason;
        obj;
        JVM INSTR monitorexit ;
        throw flushreason;
        flushreason;
        obj;
        JVM INSTR monitorexit ;
        throw flushreason;
    }

    private static void flushIfNecessary()
    {
        synchronized (staticLock)
        {
            if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY && getAccumulatedEventCount() > 100)
            {
                flush(FlushReason.EVENT_THRESHOLD);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static int getAccumulatedEventCount()
    {
        Object obj = staticLock;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = stateMap.values().iterator();
        int i = 0;
        while (iterator.hasNext()) 
        {
            i = ((SessionEventsState)iterator.next()).getAccumulatedEventCount() + i;
        }
        obj;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String getAnonymousAppDeviceGUID(Context context)
    {
        if (anonymousAppDeviceGUID != null) goto _L2; else goto _L1
_L1:
        Object obj = staticLock;
        obj;
        JVM INSTR monitorenter ;
        String s;
        if (anonymousAppDeviceGUID != null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        s = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
        anonymousAppDeviceGUID = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        anonymousAppDeviceGUID = (new StringBuilder("XZ")).append(UUID.randomUUID().toString()).toString();
        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID).apply();
        obj;
        JVM INSTR monitorexit ;
_L2:
        return anonymousAppDeviceGUID;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static FlushBehavior getFlushBehavior()
    {
        FlushBehavior flushbehavior;
        synchronized (staticLock)
        {
            flushbehavior = flushBehavior;
        }
        return flushbehavior;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static SessionEventsState getSessionEventsState(Context context, AccessTokenAppIdPair accesstokenappidpair)
    {
        AttributionIdentifiers attributionidentifiers;
        SessionEventsState sessioneventsstate = (SessionEventsState)stateMap.get(accesstokenappidpair);
        attributionidentifiers = null;
        if (sessioneventsstate == null)
        {
            attributionidentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        }
        Object obj = staticLock;
        obj;
        JVM INSTR monitorenter ;
        SessionEventsState sessioneventsstate2 = (SessionEventsState)stateMap.get(accesstokenappidpair);
        SessionEventsState sessioneventsstate1;
        sessioneventsstate1 = sessioneventsstate2;
        if (sessioneventsstate2 != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        sessioneventsstate1 = new SessionEventsState(attributionidentifiers, context.getPackageName(), getAnonymousAppDeviceGUID(context));
        stateMap.put(accesstokenappidpair, sessioneventsstate1);
        obj;
        JVM INSTR monitorexit ;
        return sessioneventsstate1;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static SessionEventsState getSessionEventsState(AccessTokenAppIdPair accesstokenappidpair)
    {
        synchronized (staticLock)
        {
            accesstokenappidpair = (SessionEventsState)stateMap.get(accesstokenappidpair);
        }
        return accesstokenappidpair;
        accesstokenappidpair;
        obj;
        JVM INSTR monitorexit ;
        throw accesstokenappidpair;
    }

    static String getSourceApplication()
    {
        String s = "Unclassified";
        if (isOpenedByApplink)
        {
            s = "Applink";
        }
        String s1 = s;
        if (sourceApplication != null)
        {
            s1 = (new StringBuilder()).append(s).append("(").append(sourceApplication).append(")").toString();
        }
        return s1;
    }

    private static void handleResponse(AccessTokenAppIdPair accesstokenappidpair, GraphRequest graphrequest, GraphResponse graphresponse, SessionEventsState sessioneventsstate, FlushStatistics flushstatistics)
    {
        FacebookRequestError facebookrequesterror = graphresponse.getError();
        Object obj = FlushResult.SUCCESS;
        String s;
        boolean flag;
        if (facebookrequesterror != null)
        {
            if (facebookrequesterror.getErrorCode() == -1)
            {
                graphresponse = FlushResult.NO_CONNECTIVITY;
                s = "Failed: No Connectivity";
            } else
            {
                s = String.format("Failed:\n  Response: %s\n  Error %s", new Object[] {
                    graphresponse.toString(), facebookrequesterror.toString()
                });
                graphresponse = FlushResult.SERVER_ERROR;
            }
        } else
        {
            s = "Success";
            graphresponse = ((GraphResponse) (obj));
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS))
        {
            obj = (String)graphrequest.getTag();
            try
            {
                obj = (new JSONArray(((String) (obj)))).toString(2);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", new Object[] {
                graphrequest.getGraphObject().toString(), s, obj
            });
        }
        if (facebookrequesterror != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        sessioneventsstate.clearInFlightAndStats(flag);
        if (graphresponse == FlushResult.NO_CONNECTIVITY)
        {
            PersistedEvents.persistEvents(applicationContext, accesstokenappidpair, sessioneventsstate);
        }
        if (graphresponse != FlushResult.SUCCESS && flushstatistics.result != FlushResult.NO_CONNECTIVITY)
        {
            flushstatistics.result = graphresponse;
        }
    }

    private static void initializeTimersIfNeeded()
    {
label0:
        {
            synchronized (staticLock)
            {
                if (backgroundExecutor == null)
                {
                    break label0;
                }
            }
            return;
        }
        backgroundExecutor = new ScheduledThreadPoolExecutor(1);
        obj;
        JVM INSTR monitorexit ;
        obj = new _cls3();
        backgroundExecutor.scheduleAtFixedRate(((Runnable) (obj)), 0L, 15L, TimeUnit.SECONDS);
        obj = new _cls4();
        backgroundExecutor.scheduleAtFixedRate(((Runnable) (obj)), 0L, 0x15180L, TimeUnit.SECONDS);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void logAppSessionResumeEvent(long l, String s)
    {
        PersistedAppSessionInfo.onResume(applicationContext, accessTokenAppId, this, l, s);
    }

    private void logAppSessionSuspendEvent(long l)
    {
        PersistedAppSessionInfo.onSuspend(applicationContext, accessTokenAppId, this, l);
    }

    private static void logEvent(Context context, AppEvent appevent, AccessTokenAppIdPair accesstokenappidpair)
    {
        FacebookSdk.getExecutor().execute(new _cls5(context, accesstokenappidpair, appevent));
    }

    private void logEvent(String s, Double double1, Bundle bundle, boolean flag)
    {
        s = new AppEvent(contextName, s, double1, bundle, flag);
        logEvent(applicationContext, ((AppEvent) (s)), accessTokenAppId);
    }

    public static AppEventsLogger newLogger(Context context)
    {
        return new AppEventsLogger(context, null, null);
    }

    public static AppEventsLogger newLogger(Context context, AccessToken accesstoken)
    {
        return new AppEventsLogger(context, null, accesstoken);
    }

    public static AppEventsLogger newLogger(Context context, String s)
    {
        return new AppEventsLogger(context, s, null);
    }

    public static AppEventsLogger newLogger(Context context, String s, AccessToken accesstoken)
    {
        return new AppEventsLogger(context, s, accesstoken);
    }

    private static void notifyDeveloperError(String s)
    {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", s);
    }

    public static void onContextStop()
    {
        PersistedEvents.persistEvents(applicationContext, stateMap);
    }

    static void resetSourceApplication()
    {
        sourceApplication = null;
        isOpenedByApplink = false;
    }

    public static void setFlushBehavior(FlushBehavior flushbehavior)
    {
        synchronized (staticLock)
        {
            flushBehavior = flushbehavior;
        }
        return;
        flushbehavior;
        obj;
        JVM INSTR monitorexit ;
        throw flushbehavior;
    }

    private static void setSourceApplication(Activity activity)
    {
        Object obj = activity.getCallingActivity();
        if (obj != null)
        {
            obj = ((ComponentName) (obj)).getPackageName();
            if (((String) (obj)).equals(activity.getPackageName()))
            {
                resetSourceApplication();
                return;
            }
            sourceApplication = ((String) (obj));
        }
        activity = activity.getIntent();
        if (activity == null || activity.getBooleanExtra("_fbSourceApplicationHasBeenSet", false))
        {
            resetSourceApplication();
            return;
        }
        obj = AppLinks.getAppLinkData(activity);
        if (obj == null)
        {
            resetSourceApplication();
            return;
        }
        isOpenedByApplink = true;
        obj = ((Bundle) (obj)).getBundle("referer_app_link");
        if (obj == null)
        {
            sourceApplication = null;
            return;
        } else
        {
            sourceApplication = ((Bundle) (obj)).getString("package");
            activity.putExtra("_fbSourceApplicationHasBeenSet", true);
            return;
        }
    }

    static void setSourceApplication(String s, boolean flag)
    {
        sourceApplication = s;
        isOpenedByApplink = flag;
    }

    public void flush()
    {
        flush(FlushReason.EXPLICIT);
    }

    public String getApplicationId()
    {
        return accessTokenAppId.getApplicationId();
    }

    public boolean isValidForAccessToken(AccessToken accesstoken)
    {
        accesstoken = new AccessTokenAppIdPair(accesstoken);
        return accessTokenAppId.equals(accesstoken);
    }

    public void logEvent(String s)
    {
        logEvent(s, ((Bundle) (null)));
    }

    public void logEvent(String s, double d)
    {
        logEvent(s, d, ((Bundle) (null)));
    }

    public void logEvent(String s, double d, Bundle bundle)
    {
        logEvent(s, Double.valueOf(d), bundle, false);
    }

    public void logEvent(String s, Bundle bundle)
    {
        logEvent(s, null, bundle, false);
    }

    public void logPurchase(BigDecimal bigdecimal, Currency currency)
    {
        logPurchase(bigdecimal, currency, null);
    }

    public void logPurchase(BigDecimal bigdecimal, Currency currency, Bundle bundle)
    {
        if (bigdecimal == null)
        {
            notifyDeveloperError("purchaseAmount cannot be null");
            return;
        }
        if (currency == null)
        {
            notifyDeveloperError("currency cannot be null");
            return;
        }
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putString("fb_currency", currency.getCurrencyCode());
        logEvent("fb_mobile_purchase", bigdecimal.doubleValue(), bundle1);
        eagerFlush();
    }

    public void logSdkEvent(String s, Double double1, Bundle bundle)
    {
        logEvent(s, double1, bundle, true);
    }

    static 
    {
        flushBehavior = FlushBehavior.AUTO;
    }












    /* member class not found */
    class AccessTokenAppIdPair {}


    /* member class not found */
    class PersistedEvents {}


    /* member class not found */
    class SessionEventsState {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class FlushStatistics {}


    /* member class not found */
    class FlushReason {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class FlushBehavior {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class FlushResult {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class PersistedAppSessionInfo {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class AppEvent {}

}
