// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.util.Log;
import android.util.Pair;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            PostableWorker, SingularLog, TimeHelper, InvalidArgumentException, 
//            LogsKeeper, EventReporter, Collector, EventStore, 
//            CountersLogger, HTTPConstants, SessionManager

class Controller
{

    public static final String TAG = "net.singular.sdk.Controller";
    private Collector collector;
    private CountersLogger countersLogger;
    private EventReporter eventReporter;
    private EventStore eventStore;
    private boolean exponential_backoff;
    private int exponential_backoff_exponent;
    private long exponential_backoff_wait_until;
    private boolean isPaused;
    private SingularLog log;
    private LogsKeeper logsKeeper;
    private Random random;
    protected PostableWorker saverPostable;
    protected PostableWorker senderPostable;
    protected Runnable senderRunnable;
    private boolean sender_enabled;
    private SessionManager sessionManager;
    private int single_post_event_limit;
    private TimeHelper timeHelper;

    public Controller(EventStore eventstore, EventReporter eventreporter, TimeHelper timehelper, PostableWorker postableworker, PostableWorker postableworker1, CountersLogger counterslogger, Random random1, 
            LogsKeeper logskeeper, SingularLog singularlog)
    {
        eventStore = eventstore;
        eventReporter = eventreporter;
        timeHelper = timehelper;
        senderPostable = postableworker;
        saverPostable = postableworker1;
        countersLogger = counterslogger;
        random = random1;
        logsKeeper = logskeeper;
        log = singularlog;
    }

    private void activateSenderInner(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (sender_enabled)
        {
            senderPostable.postDelayed(senderRunnable, l);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void exponentialBackoff()
    {
        int i;
        if (!exponential_backoff)
        {
            exponential_backoff = true;
            exponential_backoff_exponent = 1;
        } else
        {
            exponential_backoff_exponent = exponential_backoff_exponent + 1;
        }
        i = exponential_backoff_exponent;
        i = (int)Math.min(random.nextInt((int)((long)(1 << i) * 30000L)), 0xa4cb80L);
        log.d("singular_sdk", String.format("exponentialBackoff: exponent = %d, current_delay = %d", new Object[] {
            Integer.valueOf(exponential_backoff_exponent), Integer.valueOf(i)
        }));
        exponential_backoff_wait_until = timeHelper.currentTimeMillis() + (long)i;
        if (!isPaused)
        {
            senderPostable.postDelayed(senderRunnable, i);
        }
    }

    private void handleVerboseRequestIfNeeded(JSONObject jsonobject, JSONObject jsonobject1)
    {
        boolean flag;
        try
        {
            flag = jsonobject1.getBoolean("submit_verbose");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        jsonobject = eventReporter.sendVerboseLogsRequest(jsonobject, logsKeeper.getLogs());
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        jsonobject = (Integer)((Pair) (jsonobject)).first;
        if (jsonobject.intValue() >= 200 && jsonobject.intValue() < 300)
        {
            logsKeeper.cleanLogs();
        }
        return;
        jsonobject;
        logsKeeper.cleanLogs();
        log.trackError("singular_sdk", "logsKeeper lines corruption", jsonobject);
        return;
    }

    private void logAndReportException(Exception exception, String s)
    {
        log.trackError("singular_sdk", String.format("Controller:%s failed", new Object[] {
            s
        }), exception);
    }

    private void logException(Exception exception, String s)
    {
        log.e("singular_sdk", String.format("Controller:%s failed", new Object[] {
            s
        }), exception);
    }

    private void senderMethod()
    {
        JSONObject jsonobject;
        log.d("net.singular.sdk.Controller", "senderRunnable: started!");
        jsonobject = collector.getPersistentIdCountersAndDebugVars();
_L4:
        Object obj;
        Object obj1;
        long l;
        long l1;
        obj = eventStore.getEvents(single_post_event_limit);
        if (obj == null)
        {
            return;
        }
        l = ((Long)((Pair) (obj)).first).longValue();
        obj1 = (JSONArray)((Pair) (obj)).second;
        l1 = ((JSONArray) (obj1)).length();
        log.d("net.singular.sdk.Controller", String.format("senderRunnable: event_count = %d", new Object[] {
            Long.valueOf(l1)
        }));
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        obj = null;
        obj1 = eventReporter.sendPostEventsRequest(jsonobject, ((JSONArray) (obj1)));
        obj = obj1;
_L2:
        if (obj == null)
        {
            log.d("net.singular.sdk.Controller", "senderRunnable: no response, retry later");
            exponentialBackoff();
            return;
        }
        break; /* Loop/switch isn't completed */
        InvalidArgumentException invalidargumentexception;
        invalidargumentexception;
        log.trackError("singular_sdk", "senderMethod: InvalidArgumentException", invalidargumentexception);
        eventStore.deleteEvents(l);
        if (true) goto _L2; else goto _L1
_L1:
        Integer integer = (Integer)((Pair) (obj)).first;
        log.d("singular_sdk", String.format("senderRunnable: responseCode = %d", new Object[] {
            integer
        }));
        obj = (JSONObject)((Pair) (obj)).second;
        if (integer.intValue() >= 200 && integer.intValue() < 300)
        {
            exponential_backoff = false;
            countersLogger.increaseCounter("total_successful_sends");
            log.d("net.singular.sdk.Controller", "senderRunnable: send_ok :)");
            eventStore.deleteEvents(l);
            handleVerboseRequestIfNeeded(jsonobject, ((JSONObject) (obj)));
            log.forDeveloper("Events reported to server!");
        } else
        if (integer.intValue() == 413)
        {
            countersLogger.increaseCounter("failed_sends");
            single_post_event_limit = Math.max(1, single_post_event_limit / 2);
        } else
        if (integer.intValue() == 400)
        {
            countersLogger.increaseCounter("failed_sends");
            eventStore.deleteEvents(l);
        } else
        if (integer.intValue() == 401 || integer.intValue() == 405 || integer.intValue() == 415)
        {
            sender_enabled = false;
            countersLogger.increaseCounter("failed_sends");
            log.forDeveloper("Fatal failure reporting events to server! turning reporter off");
            return;
        } else
        {
            countersLogger.increaseCounter("failed_sends");
            exponentialBackoff();
            log.forDeveloper("Failed reporting events to server, backing off for a while");
            return;
        }
        if (l1 <= 0L)
        {
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void activateSender(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (!exponential_backoff)
        {
            activateSenderInner(l);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearTemporalIds()
    {
        collector.clearTemporalIds(saverPostable);
    }

    public String getDefaultCurrency()
    {
        return collector.getCurrency();
    }

    public SingularLog getLogger()
    {
        if (log == null)
        {
            throw new NullPointerException("Controller: getLogger");
        } else
        {
            return log;
        }
    }

    public String getSingularId()
    {
        if (collector != null)
        {
            return collector.getSingularId();
        } else
        {
            log.d("singular_sdk", "getSingularId: called before initController");
            return null;
        }
    }

    public void initController(SessionManager sessionmanager, final Collector collector)
    {
        sessionManager = sessionmanager;
        this.collector = collector;
        sender_enabled = true;
        exponential_backoff = false;
        single_post_event_limit = 100;
        if (!collector.initializeMandatoryManifestIds())
        {
            sender_enabled = false;
        }
        isPaused = false;
        saverPostable.postNow(new Runnable() {

            final Controller this$0;
            final Collector val$collector;

            public void run()
            {
                try
                {
                    countersLogger.loadSavedCounters();
                    collector.initializeIds();
                    senderPostable.start();
                    return;
                }
                catch (RuntimeException runtimeexception)
                {
                    logAndReportException(runtimeexception, "initController() runnable");
                }
            }

            
            {
                this$0 = Controller.this;
                collector = collector1;
                super();
            }
        });
        saverPostable.start();
        senderRunnable = new Runnable() {

            final Controller this$0;

            public void run()
            {
                try
                {
                    senderPostable.removeCallback(senderRunnable);
                    senderMethod();
                    return;
                }
                catch (RuntimeException runtimeexception)
                {
                    logException(runtimeexception, "senderMethod()");
                }
            }

            
            {
                this$0 = Controller.this;
                super();
            }
        };
    }

    public JSONObject initEvent(String s, String s1, String s2, String s3, String s4, String s5, boolean flag)
        throws JSONException
    {
        int i;
        String as[] = new String[5];
        as[0] = s1;
        as[1] = s2;
        as[2] = s3;
        as[3] = s4;
        as[4] = s5;
        try
        {
            s1 = new JSONObject();
            s1.put("event_name", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.e("singular_sdk", (new StringBuilder()).append("initEvent: invalid argument with attributes: ").append(Arrays.toString(as)).toString());
            throw s;
        }
        i = 0;
_L2:
        if (i >= as.length)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        if (as[i] == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        s1.put(HTTPConstants.EVENT_ATTRIBUTE_FIELDS[i], as[i]);
        break MISSING_BLOCK_LABEL_140;
        s1.put("is_special_event", flag);
        return s1;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public JSONObject initEvent(String s, boolean flag)
        throws JSONException
    {
        return initEvent(s, null, null, null, null, null, flag);
    }

    public void onPause()
    {
        isPaused = true;
        log.forDeveloper("onPause() called");
        saverPostable.postNow(new Runnable() {

            final Controller this$0;

            public void run()
            {
                try
                {
                    sessionManager.onPause();
                    return;
                }
                catch (RuntimeException runtimeexception)
                {
                    logAndReportException(runtimeexception, "onPause runnable");
                }
            }

            
            {
                this$0 = Controller.this;
                super();
            }
        });
    }

    public void onResume()
    {
        isPaused = false;
        log.forDeveloper("onResume() called");
        saverPostable.postNow(new Runnable() {

            final Controller this$0;

            public void run()
            {
                try
                {
                    sessionManager.onResume();
                    return;
                }
                catch (RuntimeException runtimeexception)
                {
                    logAndReportException(runtimeexception, "onResume runnable");
                }
            }

            
            {
                this$0 = Controller.this;
                super();
            }
        });
        long l1 = timeHelper.currentTimeMillis();
        long l = collector.getFirstUploadDelay();
        if (exponential_backoff)
        {
            l = Math.max(collector.getFirstUploadDelay(), exponential_backoff_wait_until - l1);
            log.d("singular_sdk", String.format("onResume: exponential_backoff = true, current_delay = %d", new Object[] {
                Long.valueOf(l)
            }));
        }
        activateSenderInner(l);
    }

    public void postEventDelayed(JSONObject jsonobject)
    {
        postEventDelayed(jsonobject, collector.getNormalUploadDelay());
    }

    public void postEventDelayed(JSONObject jsonobject, final long delayMillis)
    {
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        jsonobject = jsonobject.toString();
_L1:
        final JSONObject event_copy;
        event_copy = JSONObjectInstrumentation.init(jsonobject);
        event_copy.put("event_timestamp_s", timeHelper.currentTimeSeconds());
        event_copy.put("sdk_event_id", UUID.randomUUID().toString());
        SingularLog singularlog = log;
        if (!(event_copy instanceof JSONObject))
        {
            jsonobject = event_copy.toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)event_copy);
        }
        singularlog.forDeveloper(String.format("Event Saved: %s", new Object[] {
            jsonobject
        }));
        jsonobject = new Runnable() {

            final Controller this$0;
            final long val$delayMillis;
            final JSONObject val$event_copy;

            public void run()
            {
                try
                {
                    JSONObject jsonobject1 = collector.getTemporalIds();
                    Iterator iterator = jsonobject1.keys();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        String s = (String)iterator.next();
                        if (!s.equals("event_timestamp_s") && !s.equals("sdk_event_id"))
                        {
                            event_copy.put(s, jsonobject1.get(s));
                        }
                    } while (true);
                }
                catch (JSONException jsonexception)
                {
                    logException(jsonexception, "postEventDelayed runnable");
                    return;
                }
                catch (RuntimeException runtimeexception)
                {
                    logException(runtimeexception, "postEventDelayed runnable");
                    return;
                }
                if (eventStore.addEvent(event_copy))
                {
                    log.d("net.singular.sdk.Controller", String.format("postEventDelayed: event saved to db, posting with delay = %d to sender", new Object[] {
                        Long.valueOf(delayMillis)
                    }));
                    activateSender(delayMillis);
                    return;
                }
                log.e("net.singular.sdk.Controller", "postEventDelayed: eventStore.addEvent failed :(");
                return;
            }

            
            {
                this$0 = Controller.this;
                event_copy = jsonobject;
                delayMillis = l;
                super();
            }
        };
        log.d("net.singular.sdk.Controller", "postEventDelayed: posted save event runnable");
        saverPostable.postNow(jsonobject);
        return;
        try
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            logException(jsonobject, "postEventDelayed()");
            return;
        }
          goto _L1
    }

    public void postEventNow(JSONObject jsonobject)
    {
        postEventDelayed(jsonobject, 0L);
    }

    public void setDefaultCurrency(String s)
    {
        collector.setCurrency(s);
    }

    public void setReferralId(String s)
    {
        collector.setReferralId(s, saverPostable);
    }

    public void setTemporalId(String s, String s1)
    {
        collector.setTemporalId(s, s1, saverPostable);
    }

    public void trackInternalDebugEvent(String s, String s1, Throwable throwable)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = initEvent("SINGULAR_INTERNAL_DEBUG_EVENT", true);
            jsonobject.put("tag", s);
            jsonobject.put("message", s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        s = "";
        if (throwable == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        s = Log.getStackTraceString(throwable);
        jsonobject.put("exception_stacktrace", s);
        postEventDelayed(jsonobject);
        return;
    }

    public void trackInternalException(String s, Throwable throwable)
    {
        String s1;
        s1 = "";
        if (throwable == null)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        s1 = Log.getStackTraceString(throwable);
        throwable = initEvent("SINGULAR_INTERNAL_EXCEPTION", true);
        throwable.put("exception_message", s);
        throwable.put("exception_stacktrace", s1);
        postEventDelayed(throwable);
        return;
        s;
        return;
        s;
    }

    public void unsetTemporalId(String s)
    {
        collector.unsetTemporalId(s, saverPostable);
    }








}
