// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            NewInjector, Controller, SingularLog, KeyValueStore, 
//            CountersLogger, TimeHelper, PostableWorker, KeyNotFoundException

class SessionManager
{

    public static final int MILLIS_IN_SECOND = 1000;
    public static final String SESSION_MANAGER_NAMESPACE = "SessionManager";
    private final Controller controller;
    private CountersLogger countersLogger;
    private Runnable end_session_runnable;
    private boolean is_paused;
    private final KeyValueStore key_value_store;
    private final SingularLog log;
    private PostableWorker postable_worker;
    private String session_id;
    private long session_pause;
    private long session_start;
    private final TimeHelper time_helper;

    public SessionManager(SingularLog singularlog, Controller controller1, TimeHelper timehelper, PostableWorker postableworker, CountersLogger counterslogger, NewInjector newinjector)
    {
        log = singularlog;
        key_value_store = newinjector.generateKeyValueStore("SessionManager");
        controller = controller1;
        time_helper = timehelper;
        postable_worker = postableworker;
        countersLogger = counterslogger;
        is_paused = false;
        session_id = null;
        end_session_runnable = null;
    }

    private void buildAndSendSessionEndEvent()
    {
        JSONObject jsonobject = buildSessionEndEvent();
        if (jsonobject != null)
        {
            controller.postEventDelayed(jsonobject);
        }
    }

    private JSONObject buildSessionEndEvent()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = controller.initEvent("SESSION_END", true);
            jsonobject.put("last_session_start_s", session_start);
            jsonobject.put("last_session_pause_s", session_pause);
            jsonobject.put("last_session_id", session_id);
        }
        catch (JSONException jsonexception)
        {
            log.e("singular_sdk", "SessionManager: buildAndSendSessionEndEvent failed");
            return null;
        }
        return jsonobject;
    }

    private void deleteSessionFromKeyValueStore()
    {
        key_value_store.delete("last_session_id");
        key_value_store.delete("last_session_start_s");
        key_value_store.delete("last_session_pause_s");
    }

    private void startNewSession()
    {
        log.d("singular_sdk", "startNewSession");
        countersLogger.increaseCounter("session_count");
        session_id = UUID.randomUUID().toString();
        session_start = time_helper.currentTimeSeconds();
        session_pause = 0L;
        try
        {
            JSONObject jsonobject = controller.initEvent("SESSION_START", true);
            controller.postEventDelayed(jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            log.e("singular_sdk", "SessionManager: startNewSession failed");
        }
    }

    public String getSessionId()
    {
        return session_id;
    }

    public void onPause()
    {
        log.d("singular_sdk", "SessionManager: onPause");
        session_pause = time_helper.currentTimeSeconds();
        key_value_store.put("last_session_start_s", session_start);
        key_value_store.put("last_session_pause_s", session_pause);
        key_value_store.put("last_session_id", session_id);
        is_paused = true;
        final JSONObject session_end_event = buildSessionEndEvent();
        if (postable_worker != null && session_end_event != null)
        {
            end_session_runnable = new Runnable() {

                final SessionManager this$0;
                final JSONObject val$session_end_event;

                public void run()
                {
                    try
                    {
                        log.d("singular_sdk", "SessionManager: delayed Runnable started");
                        controller.postEventNow(session_end_event);
                        deleteSessionFromKeyValueStore();
                        session_id = null;
                        return;
                    }
                    catch (RuntimeException runtimeexception)
                    {
                        log.e("singular_sdk", "SessionManager:onPause() failed", runtimeexception);
                    }
                }

            
            {
                this$0 = SessionManager.this;
                session_end_event = jsonobject;
                super();
            }
            };
            postable_worker.postDelayed(end_session_runnable, 0x2bf20L);
        }
    }

    public void onResume()
    {
        log.d("singular_sdk", String.format("SessionManager: onResume (is_paused = %b, session_id = %s)", new Object[] {
            Boolean.valueOf(is_paused), session_id
        }));
        long l;
        if (!is_paused)
        {
            try
            {
                session_id = key_value_store.getString("last_session_id");
                session_start = key_value_store.getLong("last_session_start_s");
                session_pause = key_value_store.getLong("last_session_pause_s");
                deleteSessionFromKeyValueStore();
            }
            catch (KeyNotFoundException keynotfoundexception) { }
        }
        is_paused = false;
        if (session_id == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        l = time_helper.currentTimeSeconds() - session_pause;
        log.d("singular_sdk", String.format("SessionManager: time_since_pause = %d", new Object[] {
            Long.valueOf(l)
        }));
        if (l <= 180L) goto _L2; else goto _L1
_L1:
        log.d("singular_sdk", "SESSION_TIMEOUT exceeded!");
        buildAndSendSessionEndEvent();
        startNewSession();
_L4:
        return;
_L2:
        if (end_session_runnable == null) goto _L4; else goto _L3
_L3:
        postable_worker.removeCallback(end_session_runnable);
        end_session_runnable = null;
        return;
        log.d("singular_sdk", "session_id = null, startNewSession!");
        startNewSession();
        return;
    }





/*
    static String access$302(SessionManager sessionmanager, String s)
    {
        sessionmanager.session_id = s;
        return s;
    }

*/
}
