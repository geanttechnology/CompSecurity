// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.unity;

import android.util.Log;
import android.view.Menu;
import com.sessionm.api.User;
import com.sessionm.api.ext.SessionM;
import com.unity3d.player.UnityPlayerNativeActivity;

// Referenced classes of package com.sessionm.unity:
//            SessionMListener

public class BaseNativeActivity extends UnityPlayerNativeActivity
{

    private static final String TAG = "SessionM.Unity";
    private final SessionM sessionM = SessionM.getInstance();

    public BaseNativeActivity()
    {
    }

    public static final void setCallbackGameObjectName(String s)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append("Callback game object name: ").append(s).toString());
        }
        SessionMListener.getInstance().setCallbackGameObjectName(s);
    }

    public int getUnclaimedAchievementCount()
    {
        return sessionM.getUser().getUnclaimedAchievementCount();
    }

    public String getUnclaimedAchievementJSON()
    {
        String s = null;
        com.sessionm.api.AchievementData achievementdata = sessionM.getUnclaimedAchievement();
        if (achievementdata != null)
        {
            s = SessionMListener.getAchievementJSON(achievementdata);
        }
        return s;
    }

    public boolean isActivityAvailable(com.sessionm.api.SessionM.ActivityType activitytype)
    {
        if (sessionM.getSessionState() == com.sessionm.api.SessionM.State.STARTED_ONLINE)
        {
            return activitytype != com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT || sessionM.getUnclaimedAchievement() != null;
        } else
        {
            return false;
        }
    }

    protected void onPause()
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onPause()").toString());
        }
        sessionM.onActivityPause(this);
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        sessionM.dismissActivity();
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onRestart()
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onRestart()").toString());
        }
        super.onRestart();
    }

    protected void onResume()
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onResume()").toString());
        }
        super.onResume();
        sessionM.onActivityResume(this);
    }

    protected void onStart()
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onStart()").toString());
        }
        super.onStart();
        sessionM.onActivityStart(this);
    }

    protected void onStop()
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".onStop()").toString());
        }
        super.onStop();
        sessionM.onActivityStop(this);
    }

    public boolean presentActivity(com.sessionm.api.SessionM.ActivityType activitytype)
    {
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append("Present activity: ").append(activitytype).toString());
        }
        return sessionM.presentActivity(activitytype);
    }
}
