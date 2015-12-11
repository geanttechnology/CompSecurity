// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.unity;

import android.util.Log;
import android.widget.FrameLayout;
import com.sessionm.api.AchievementData;
import com.sessionm.api.Activity;
import com.sessionm.api.SessionListener;
import com.sessionm.api.User;
import com.sessionm.api.ext.ActivityListener;
import com.sessionm.api.ext.SessionM;
import com.sessionm.b.a;
import com.sessionm.core.AchievementImpl;
import com.sessionm.core.h;
import com.unity3d.player.UnityPlayer;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class SessionMListener
    implements SessionListener, ActivityListener
{

    private static final String TAG = "SessionM.Unity";
    private static SessionMListener instance;
    private static final SessionM sessionM = SessionM.getInstance();
    private String callbackGameObjectName;
    private String presentedActivityType;

    public SessionMListener()
    {
    }

    static String getAchievementJSON(AchievementData achievementdata)
    {
        a a1 = a.aG();
        a1.put("name", achievementdata.getName());
        a1.put("message", achievementdata.getMessage());
        a1.put("mpointValue", achievementdata.getMpointValue());
        a1.put("identifier", ((AchievementImpl)achievementdata).a());
        a1.put("isCustom", achievementdata.isCustom());
        return a1.toString();
    }

    private String getCurrentUnityActivityType()
    {
        com.sessionm.api.SessionM.ActivityType activitytype = sessionM.getCurrentActivity().getActivityType();
        if (activitytype == null) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$sessionm$api$SessionM$ActivityType[];
            static final int $SwitchMap$com$sessionm$api$SessionM$State[];

            static 
            {
                $SwitchMap$com$sessionm$api$SessionM$State = new int[com.sessionm.api.SessionM.State.values().length];
                try
                {
                    $SwitchMap$com$sessionm$api$SessionM$State[com.sessionm.api.SessionM.State.STOPPED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$sessionm$api$SessionM$State[com.sessionm.api.SessionM.State.STARTED_ONLINE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$sessionm$api$SessionM$State[com.sessionm.api.SessionM.State.STARTED_OFFLINE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$sessionm$api$SessionM$ActivityType = new int[com.sessionm.api.SessionM.ActivityType.values().length];
                try
                {
                    $SwitchMap$com$sessionm$api$SessionM$ActivityType[com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$sessionm$api$SessionM$ActivityType[com.sessionm.api.SessionM.ActivityType.PORTAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$sessionm$api$SessionM$ActivityType[com.sessionm.api.SessionM.ActivityType.INTERSTITIAL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.sessionm.api.SessionM.ActivityType[activitytype.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 51
    //                   2 54
    //                   3 57;
           goto _L2 _L3 _L4 _L5
_L2:
        return "0";
_L3:
        return "1";
_L4:
        return "2";
_L5:
        return "3";
    }

    private String getCurrentUnitySessionState()
    {
        switch (_cls1..SwitchMap.com.sessionm.api.SessionM.State[sessionM.getSessionState().ordinal()])
        {
        default:
            return "0";

        case 1: // '\001'
            return "0";

        case 2: // '\002'
            return "1";

        case 3: // '\003'
            return "2";
        }
    }

    public static SessionMListener getInstance()
    {
        com/sessionm/unity/SessionMListener;
        JVM INSTR monitorenter ;
        SessionMListener sessionmlistener;
        if (instance == null)
        {
            instance = new SessionMListener();
            sessionM.setActivityListener(instance);
            sessionM.setSessionListener(instance);
            if (android.os.Build.VERSION.SDK_INT < 17)
            {
                sessionM.setHardwareAccelerationDisabled(true);
            }
        }
        sessionmlistener = instance;
        com/sessionm/unity/SessionMListener;
        JVM INSTR monitorexit ;
        return sessionmlistener;
        Exception exception;
        exception;
        throw exception;
    }

    public void onDismissed(com.sessionm.api.SessionM sessionm)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onDismissed()").toString());
        }
        if (callbackGameObjectName != null)
        {
            UnityPlayer.UnitySendMessage(callbackGameObjectName, "_sessionM_HandleDismissedActivityMessage", presentedActivityType);
        }
        presentedActivityType = null;
    }

    public void onPrepared(com.sessionm.api.SessionM sessionm)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onPrepared()").toString());
        }
        if (callbackGameObjectName != null)
        {
            UnityPlayer.UnitySendMessage(callbackGameObjectName, "_sessionM_HandleOnPreparedMessage", "1");
        }
    }

    public void onPresented(com.sessionm.api.SessionM sessionm)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onPresented()").toString());
        }
        presentedActivityType = getCurrentUnityActivityType();
        if (callbackGameObjectName != null)
        {
            UnityPlayer.UnitySendMessage(callbackGameObjectName, "_sessionM_HandlePresentedActivityMessage", presentedActivityType);
        }
    }

    public void onSessionFailed(com.sessionm.api.SessionM sessionm, int i)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onSessionFailed(): ").append(i).toString());
        }
        if (callbackGameObjectName != null)
        {
            sessionm = String.valueOf(i);
            sessionm = String.format(Locale.US, "%d:%s%d:%s", new Object[] {
                Integer.valueOf(sessionm.length()), sessionm, Integer.valueOf("Session error".length()), "Session error"
            });
            UnityPlayer.UnitySendMessage(callbackGameObjectName, "_sessionM_HandleSessionFailedMessage", sessionm);
        }
    }

    public void onSessionStateChanged(com.sessionm.api.SessionM sessionm, com.sessionm.api.SessionM.State state)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onSessionStateChanged(): ").append(state).toString());
        }
        if (callbackGameObjectName != null)
        {
            UnityPlayer.UnitySendMessage(callbackGameObjectName, "_sessionM_HandleStateTransitionMessage", getCurrentUnitySessionState());
        }
    }

    public void onUserAction(com.sessionm.api.SessionM sessionm, com.sessionm.api.ActivityListener.UserAction useraction, Map map)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onUserAction(): ").append(useraction.getCode()).append(", data: ").append(map).toString());
        }
        sessionm = a.aG();
        sessionm.put("userAction", useraction.getCode());
        if (map != null)
        {
            useraction = a.aG();
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); useraction.put((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

            sessionm.put("data", useraction);
        }
        if (callbackGameObjectName != null)
        {
            UnityPlayer.UnitySendMessage(callbackGameObjectName, "_sessionM_HandleUserActionMessage", sessionm.toString());
        }
    }

    public void onUserUpdated(com.sessionm.api.SessionM sessionm, User user)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onUserUpdated(): ").append(user).toString());
        }
        if (callbackGameObjectName != null)
        {
            sessionm = ((h)user).aB();
            UnityPlayer.UnitySendMessage(callbackGameObjectName, "_sessionM_HandleUserInfoChangedMessage", sessionm);
        }
    }

    public final void setCallbackGameObjectName(String s)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append("Callback game object name: ").append(s).toString());
        }
        callbackGameObjectName = s;
    }

    public boolean shouldPresentAchievement(com.sessionm.api.SessionM sessionm, AchievementData achievementdata)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".shouldAutopresentActivity()").toString());
        }
        if (callbackGameObjectName != null)
        {
            UnityPlayer.UnitySendMessage(callbackGameObjectName, "_sessionM_HandleUpdatedUnclaimedAchievementMessage", getAchievementJSON(achievementdata));
        }
        return false;
    }

    public FrameLayout viewGroupForActivity(com.sessionm.api.SessionM sessionm)
    {
        return null;
    }

}
