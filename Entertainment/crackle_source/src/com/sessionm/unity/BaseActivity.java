// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.unity;

import android.util.Log;
import android.view.Menu;
import com.sessionm.api.AchievementActivity;
import com.sessionm.api.AchievementActivityIllegalStateException;
import com.sessionm.api.User;
import com.sessionm.api.ext.SessionM;
import com.sessionm.core.Config;
import com.sessionm.core.f;
import com.sessionm.core.h;
import com.unity3d.player.UnityPlayerActivity;

// Referenced classes of package com.sessionm.unity:
//            SessionMListener

public class BaseActivity extends UnityPlayerActivity
{

    private static final String TAG = "SessionM.Unity";
    private final SessionM sessionM = SessionM.getInstance();

    public BaseActivity()
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

    public void notifyCustomAchievementCancelled()
    {
        Object obj;
        obj = sessionM.getCurrentActivity();
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".notifyCustomAchievementCancelled(), activity: ").append(obj).toString());
        }
        if (!(obj instanceof AchievementActivity))
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj = (AchievementActivity)obj;
        ((AchievementActivity) (obj)).notifyDismissed(com.sessionm.api.AchievementActivity.AchievementDismissType.CANCELLED);
        return;
        AchievementActivityIllegalStateException achievementactivityillegalstateexception;
        achievementactivityillegalstateexception;
        Log.e("SessionM.Unity", (new StringBuilder()).append(this).append(".notifyCustomAchievementCancelled()").toString(), achievementactivityillegalstateexception);
        return;
    }

    public void notifyCustomAchievementClaimed()
    {
        Object obj;
        obj = sessionM.getCurrentActivity();
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".notifyCustomAchievementClaimed(), activity: ").append(obj).toString());
        }
        if (!(obj instanceof AchievementActivity))
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj = (AchievementActivity)obj;
        ((AchievementActivity) (obj)).notifyDismissed(com.sessionm.api.AchievementActivity.AchievementDismissType.CLAIMED);
        return;
        AchievementActivityIllegalStateException achievementactivityillegalstateexception;
        achievementactivityillegalstateexception;
        Log.e("SessionM.Unity", (new StringBuilder()).append(this).append(".notifyCustomAchievementClaimed()").toString(), achievementactivityillegalstateexception);
        return;
    }

    public void notifyCustomAchievementPresented(String s)
    {
        com.sessionm.core.AchievementImpl achievementimpl = f.E().D().l(s);
        if (Log.isLoggable("SessionM.Unity", 3))
        {
            Log.d("SessionM.Unity", (new StringBuilder()).append(this).append(".notifyCustomAchievementPresented(), id: ").append(s).append(", achievement: ").append(achievementimpl).toString());
        }
        if (achievementimpl == null)
        {
            Log.e("SessionM.Unity", (new StringBuilder()).append(this).append(".notifyCustomAchievementPresented(): Null achievement").toString());
            return;
        }
        s = new AchievementActivity(achievementimpl);
        try
        {
            s.notifyPresented();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("SessionM.Unity", (new StringBuilder()).append(this).append(".notifyCustomAchievementPresented()").toString(), s);
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

    public void setServerUrls(String s)
    {
        Config config = Config.h();
        if (s.equalsIgnoreCase("Staging"))
        {
            config.setServerType(com.sessionm.core.Config.ServerType.aq, new String[0]);
        } else
        if (s.equalsIgnoreCase("Production"))
        {
            config.setServerType(com.sessionm.core.Config.ServerType.ap, new String[0]);
            return;
        }
    }

    public void stopSession()
    {
        f.E().stopSession();
    }
}
