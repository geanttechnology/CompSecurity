// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva;

import android.content.Context;
import com.conviva.monitor.PlayerStates;
import com.conviva.session.Session;
import com.conviva.session.SessionFactory;
import com.conviva.utils.PlatformUtils;
import com.conviva.utils.Settings;
import com.conviva.utils.Utils;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.conviva:
//            StreamerError, ConvivaContentInfo

public class LivePass
{

    private static int _globalSessionId = -1;
    private static SessionFactory _sessionFactory = null;
    private static Settings _settings = null;
    private static Boolean _toggleTracesSet = Boolean.valueOf(false);
    private static Boolean _toggleTracesSetValue = Boolean.valueOf(false);
    private static PlatformUtils _utils = null;
    private static Boolean readyState = Boolean.valueOf(false);

    public static void attachStreamer(int i, Object obj)
        throws Exception
    {
        Session session = _sessionFactory.getSession(i);
        if (session == null)
        {
            _utils.log("LivePass.attachStreamer(): session not found");
            return;
        } else
        {
            session.attachStreamer(obj);
            return;
        }
    }

    public static void cleanupSession(int i)
    {
        if (!readyState.booleanValue())
        {
            return;
        } else
        {
            _utils.runProtected(new Callable(i) {

                final int val$sessionId;

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public Void call()
                    throws Exception
                {
                    LivePass._sessionFactory.cleanupSession(sessionId);
                    return null;
                }

            
            {
                sessionId = i;
                super();
            }
            }, "Livepass.cleanupSession");
            return;
        }
    }

    public static int createSession(Object obj, ConvivaContentInfo convivacontentinfo)
        throws Exception
    {
        return createSessionWorker(obj, convivacontentinfo, null, false);
    }

    private static int createSessionWorker(Object obj, ConvivaContentInfo convivacontentinfo, Map map, boolean flag)
        throws Exception
    {
        if (!readyState.booleanValue())
        {
            if (_utils != null)
            {
                _utils.ping("createSession before LivePass.init");
            }
            throw new Exception("createSession before LivePass.init");
        }
        if (_settings.customerKey == null)
        {
            throw new Exception("Cannot create session: customerKey is null");
        } else
        {
            int i = _sessionFactory.newSessionId();
            _utils.runProtected(new Callable(obj, convivacontentinfo, map, i, flag) {

                final ConvivaContentInfo val$contentInfo;
                final boolean val$global;
                final Map val$sessionOptions;
                final int val$sid;
                final Object val$streamer;

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public Void call()
                    throws Exception
                {
                    LivePass._sessionFactory.makeSession(streamer, contentInfo, sessionOptions, sid, global);
                    LivePass._utils.log("LivePass Session Created");
                    return null;
                }

            
            {
                streamer = obj;
                contentInfo = convivacontentinfo;
                sessionOptions = map;
                sid = i;
                global = flag;
                super();
            }
            }, "LivePass.createSession");
            return i;
        }
    }

    public static void init(String s, Context context)
        throws Exception
    {
        initWithSettings(s, null, context);
    }

    public static void initWithSettings(String s, Map map, Context context)
        throws Exception
    {
        if (s == null || s.length() == 0)
        {
            throw new Exception((new StringBuilder()).append("invalid customerKey: ").append(s).toString());
        }
        if (readyState.booleanValue())
        {
            return;
        } else
        {
            _utils = Utils.CreateUtils(map, context);
            _utils.startFetchClientId();
            _settings = _utils.getSettings();
            _settings.clientInstanceId = _utils.randInt();
            _settings.customerKey = s;
            _settings.sendLogs = false;
            _utils.runProtected(new Callable() {

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public Void call()
                    throws Exception
                {
                    if (LivePass._toggleTracesSet.booleanValue())
                    {
                        LivePass._settings.enableLogging = LivePass._toggleTracesSetValue.booleanValue();
                    }
                    LivePass._utils.log((new StringBuilder()).append("LivePass.init url=").append(LivePass._settings.gatewayUrl).append(", customerKey=").append(LivePass._settings.customerKey).toString());
                    PlayerStates.init();
                    LivePass._sessionFactory = new SessionFactory();
                    LivePass.readyState = Boolean.valueOf(true);
                    return null;
                }

            }, "LivePass.init");
            return;
        }
    }

    public static void pauseMonitor(int i)
        throws Exception
    {
        Session session = _sessionFactory.getSession(i);
        if (session == null)
        {
            _utils.log("LivePass.pauseSession(): session not found");
            return;
        } else
        {
            session.pauseMonitor();
            return;
        }
    }

    public static void reportError(int i, String s, int j)
    {
        Session session = _sessionFactory.getSession(i);
        if (session == null)
        {
            _utils.log("LivePass.reportError(): session not found");
            return;
        } else
        {
            session.reportError(StreamerError.makeUnscopedError(s, j));
            return;
        }
    }

    public static void toggleTraces(Boolean boolean1)
    {
        _toggleTracesSet = Boolean.valueOf(true);
        if (_settings != null)
        {
            _settings.enableLogging = boolean1.booleanValue();
            return;
        } else
        {
            _toggleTracesSetValue = boolean1;
            return;
        }
    }








/*
    static SessionFactory access$402(SessionFactory sessionfactory)
    {
        _sessionFactory = sessionfactory;
        return sessionfactory;
    }

*/


/*
    static Boolean access$502(Boolean boolean1)
    {
        readyState = boolean1;
        return boolean1;
    }

*/
}
