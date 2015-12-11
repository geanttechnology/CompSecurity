// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.sessionm.core.f;
import com.sessionm.core.g;
import com.sessionm.core.i;
import java.util.Map;

// Referenced classes of package com.sessionm.api:
//            Activity, ActivityListener, SessionListener, AchievementData, 
//            User

public class SessionM
{
    public static final class ActivityType extends Enum
    {

        private static final ActivityType $VALUES[];
        public static final ActivityType ACHIEVEMENT;
        public static final ActivityType INTERSTITIAL;
        public static final ActivityType PORTAL;

        public static ActivityType valueOf(String s)
        {
            return (ActivityType)Enum.valueOf(com/sessionm/api/SessionM$ActivityType, s);
        }

        public static ActivityType[] values()
        {
            return (ActivityType[])$VALUES.clone();
        }

        static 
        {
            PORTAL = new ActivityType("PORTAL", 0);
            ACHIEVEMENT = new ActivityType("ACHIEVEMENT", 1);
            INTERSTITIAL = new ActivityType("INTERSTITIAL", 2);
            $VALUES = (new ActivityType[] {
                PORTAL, ACHIEVEMENT, INTERSTITIAL
            });
        }

        private ActivityType(String s, int j)
        {
            super(s, j);
        }
    }

    public static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State STARTED_OFFLINE;
        public static final State STARTED_ONLINE;
        public static final State STARTING;
        public static final State STOPPED;
        public static final State STOPPING;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/sessionm/api/SessionM$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        public boolean isStarted()
        {
            return this == STARTED_ONLINE || this == STARTED_OFFLINE;
        }

        static 
        {
            STOPPED = new State("STOPPED", 0);
            STARTING = new State("STARTING", 1);
            STARTED_ONLINE = new State("STARTED_ONLINE", 2);
            STARTED_OFFLINE = new State("STARTED_OFFLINE", 3);
            STOPPING = new State("STOPPING", 4);
            $VALUES = (new State[] {
                STOPPED, STARTING, STARTED_ONLINE, STARTED_OFFLINE, STOPPING
            });
        }

        private State(String s, int j)
        {
            super(s, j);
        }
    }


    public static final String TAG = "SessionM";
    protected static SessionM instance;
    private ActivityListener activityListener;
    private SessionListener sessionListener;

    protected SessionM()
    {
    }

    public static SessionM getInstance()
    {
        com/sessionm/api/SessionM;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            if (!i.isSupportedPlatform())
            {
                break MISSING_BLOCK_LABEL_34;
            }
            instance = new SessionM();
        }
_L1:
        SessionM sessionm = instance;
        com/sessionm/api/SessionM;
        JVM INSTR monitorexit ;
        return sessionm;
        instance = new g();
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public boolean collectsLocation()
    {
        return f.E().collectsLocation();
    }

    public void dismissActivity()
    {
        this;
        JVM INSTR monitorenter ;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", "dismiss activity called with activityType", new Throwable());
        }
        f.E().dismissActivity();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public ActivityListener getActivityListener()
    {
        return activityListener;
    }

    public com.sessionm.api.Activity getCurrentActivity()
    {
        this;
        JVM INSTR monitorenter ;
        com.sessionm.api.Activity activity;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("getCurrentActivityCalled", new Object[] {
                new Throwable()
            }));
        }
        activity = f.E().getCurrentActivity();
        this;
        JVM INSTR monitorexit ;
        return activity;
        Exception exception;
        exception;
        throw exception;
    }

    public Handler getListenerHandler()
    {
        return f.E().getListenerHandler();
    }

    public String getSDKVersion()
    {
        return f.E().getSDKVersion();
    }

    public SessionListener getSessionListener()
    {
        return sessionListener;
    }

    public State getSessionState()
    {
        this;
        JVM INSTR monitorenter ;
        State state = f.E().getSessionState();
        this;
        JVM INSTR monitorexit ;
        return state;
        Exception exception;
        exception;
        throw exception;
    }

    public AchievementData getUnclaimedAchievement()
    {
        return f.E().getUnclaimedAchievement();
    }

    public User getUser()
    {
        return f.E().D();
    }

    public boolean isActivityPresented()
    {
        return f.E().K() != null;
    }

    public boolean isAutopresentMode()
    {
        return f.E().isAutopresentMode();
    }

    public boolean isSupportedPlatform()
    {
        return i.isSupportedPlatform();
    }

    public void logAction(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("log action called with action: %s", new Object[] {
                s
            }), new Throwable());
        }
        logAction(s, 1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void logAction(String s, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("log action called with action: %s count: %d", new Object[] {
                s, Integer.valueOf(j)
            }), new Throwable());
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (s.trim().length() != 0)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        throw new NullPointerException("Action is null or empty string");
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", String.format("Provided count for action %s is zero. Ignoring action.", new Object[] {
                s
            }));
        }
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        f.E().logAction(s, j);
          goto _L1
    }

    public void logError(String s, String s1, Throwable throwable)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("log error called with meta data: %s %s %s", new Object[] {
                s, s1, throwable
            }), new Throwable());
        }
        f.E().logError(s, s1, throwable);
    }

    public void onActivityPause(Activity activity)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("onActivityPause called with activity %s", new Object[] {
                activity
            }), new Throwable());
        }
        if (activity == null)
        {
            throw new NullPointerException("Activity is null");
        } else
        {
            f.E().onActivityPause(activity);
            return;
        }
    }

    public void onActivityResume(Activity activity)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("onActivityResume called with activity %s", new Object[] {
                activity
            }), new Throwable());
        }
        if (activity == null)
        {
            throw new NullPointerException("Activity is null");
        } else
        {
            f.E().onActivityResume(activity);
            return;
        }
    }

    public void onActivityStart(Activity activity)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("onActivityStart called with activity %s", new Object[] {
                activity
            }), new Throwable());
        }
        if (activity == null)
        {
            throw new NullPointerException("Activity is null");
        } else
        {
            f.E().onActivityStart(activity);
            return;
        }
    }

    public void onActivityStop(Activity activity)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("onActivityStop called with activity %s", new Object[] {
                activity
            }), new Throwable());
        }
        if (activity == null)
        {
            throw new NullPointerException("Activity is null");
        } else
        {
            f.E().onActivityStop(activity);
            return;
        }
    }

    public boolean presentActivity(ActivityType activitytype)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        f f1;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("present activity called with activityType %s", new Object[] {
                activitytype
            }), new Throwable());
        }
        f1 = f.E();
        if (f1.J() != null || f1.isExpandedPresentationMode()) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
        if (!Log.isLoggable("SessionM", 6))
        {
            break MISSING_BLOCK_LABEL_82;
        }
        Log.e("SessionM", "SessionM activities must be presented on resumed (non-paused) activities. Activity cannot be presented because currently running Android activity is unknown. Ensure your activity properly calls SessionM.onActivityXXX() notification methods or extends com.sessionm.api.BaseActivity.");
        flag = flag1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = f1.b(new com.sessionm.api.Activity(activitytype), new Object[] {
            Boolean.valueOf(true)
        });
        if (true) goto _L4; else goto _L3
_L3:
        activitytype;
        throw activitytype;
    }

    public void setActivityListener(ActivityListener activitylistener)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("set activity listener called with listener: %s", new Object[] {
                activitylistener
            }), new Throwable());
        }
        activityListener = activitylistener;
    }

    public void setAutopresentMode(boolean flag)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("set auto present mode called with value: %b", new Object[] {
                Boolean.valueOf(flag)
            }), new Throwable());
        }
        f.E().setAutopresentMode(flag);
    }

    public void setCollectionLocation(boolean flag)
    {
        f.E().setCollectionLocation(flag);
    }

    public void setListenerHandler(Handler handler)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("set listener handler called with handler: %s", new Object[] {
                handler
            }), new Throwable());
        }
        f.E().setListenerHandler(handler);
    }

    public void setMetaData(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("set meta data called with meta data: %s %s", new Object[] {
                s, s1
            }), new Throwable());
        }
        f.E().setMetaData(s, s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setMetaData(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("set meta data called with meta data: %s", new Object[] {
                map
            }), new Throwable());
        }
        f.E().setMetaData(map);
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        throw map;
    }

    public void setSessionListener(SessionListener sessionlistener)
    {
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("set session listener called with listener: %s", new Object[] {
                sessionlistener
            }), new Throwable());
        }
        if (sessionListener != null)
        {
            f.E().b(sessionListener);
        }
        sessionListener = sessionlistener;
        f.E().a(sessionlistener);
    }

    public void startSession(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (Log.isLoggable("SessionM", 2))
        {
            Log.v("SessionM", String.format("Starting session with key: %s", new Object[] {
                s
            }), new Throwable());
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        throw new NullPointerException("Could not initialize SessionM SDK due to null application context");
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        throw new NullPointerException("Could not initialize SessionM SDK due to null or empty API key");
        f.E().a(context, s);
        this;
        JVM INSTR monitorexit ;
    }
}
