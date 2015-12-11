// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkApplication

public class AkSessionFactory
{

    private static final int ECART_QUESTION_ENTRE_PROPS = 5;
    private static final String KEY_ANALYTICS_SENT = "keyAnalyticsSent";
    private static final String KEY_DELAI_SESSION_MOYENNE = "delaiSessionMoyenne";
    private static final String KEY_FACEBOOK_CAN_DISPLAY = "keyFacebookCanDisplay";
    private static final String KEY_FACEBOOK_REQUEST_SENT = "keyFacebookRequestSent";
    private static final String KEY_MUST_PUBLISHED_SCORE = "keyMustPublishedScore";
    private static final String KEY_TIME_LAST_SCREEN_PAUSE = "timeOfLastScreenOnPause";
    private static final String KEY_TIME_SESSION_START = "timeOfCurrentSessionStart";
    public static final int NB_QUESTIONS_MAX = 80;
    private static final int PERCENT_NEEDED_FOR_LIST = 97;
    private static final int PERCENT_NEEDED_FOR_LIST2 = 80;
    private static final int QUESTIONS_MAX_AVANT_PROP = 25;
    private static final int QUESTIONS_MAX_AVANT_PROP2 = 30;
    private static AkSessionFactory _instance = null;
    private boolean analyticsSend;
    private boolean canDisplayQuestionAlert;
    private boolean characterAlreadyProposed;
    private String characterNameProposed;
    private Bitmap imageDefi;
    private String lastQuestion;
    private boolean noMoreQuestion;
    private float oldProgression;
    private boolean photoAlreadyProposed;
    private boolean questionAlreadyProposed;
    SharedPreferences settings;
    private int stepOfLastProp;
    private String versionRequired;

    public AkSessionFactory()
    {
        versionRequired = null;
        canDisplayQuestionAlert = false;
        noMoreQuestion = false;
        analyticsSend = false;
        settings = AkApplication.getAppContext().getSharedPreferences("session", 0);
    }

    public static AkSessionFactory sharedInstance()
    {
        if (_instance == null)
        {
            _instance = new AkSessionFactory();
        }
        return _instance;
    }

    public void addFacebookIdForRequest(String s)
    {
        Object obj = settings.getStringSet("keyFacebookRequestSent", null);
        if (obj == null)
        {
            obj = new HashSet();
            ((HashSet) (obj)).add(s);
            s = settings.edit();
            s.putStringSet("keyFacebookRequestSent", ((Set) (obj)));
            s.commit();
            return;
        } else
        {
            ((Set) (obj)).add(String.valueOf(s));
            s = settings.edit();
            s.putStringSet("keyFacebookRequestSent", ((Set) (obj)));
            s.commit();
            return;
        }
    }

    public boolean areAnalyticsSendLastTime()
    {
        return settings.getBoolean("keyAnalyticsSent", false);
    }

    public boolean canDisplayAlertFacebookScore()
    {
        return settings.getBoolean("keyFacebookCanDisplay", true);
    }

    public void doNotDisplayFacebookAlertAnymore()
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("keyFacebookCanDisplay", false);
        editor.commit();
    }

    public String getCharacterNameProposed()
    {
        return characterNameProposed;
    }

    public Bitmap getImageDefi()
    {
        return imageDefi;
    }

    public float getLastProgression()
    {
        return oldProgression;
    }

    public String getLastQuestion()
    {
        return lastQuestion;
    }

    public boolean getNoMoreQuestionsStatus()
    {
        return noMoreQuestion;
    }

    public int getStepOfLastProp()
    {
        return stepOfLastProp;
    }

    public long getTimeOfCurrentSessionStart()
    {
        return settings.getLong("timeOfCurrentSessionStart", 0L);
    }

    public long getTimeOfLastScreenOnPause()
    {
        return settings.getLong("timeOfLastScreenOnPause", 0x7fffffffffffffffL);
    }

    public String getVersionRequired()
    {
        return versionRequired;
    }

    public boolean hasAlreadyProposedPhoto()
    {
        return photoAlreadyProposed;
    }

    public boolean hasAlreadyProposedQuestion()
    {
        return questionAlreadyProposed;
    }

    public boolean hasToPublishedScore()
    {
        return settings.getBoolean("keyMustPublishedScore", true);
    }

    public boolean isAbleToFind()
    {
        float f;
        int i;
        int j;
        com.elokence.limuleapi.Session.QuestionProgression questionprogression = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression();
        i = questionprogression.getStep();
        j = stepOfLastProp;
        f = questionprogression.getProgression();
        j = i - j;
        if (!noMoreQuestion && i != 80) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (j < 5)
        {
            return false;
        }
        if (i > 25) goto _L4; else goto _L3
_L3:
        if (f > 97F)
        {
            continue; /* Loop/switch isn't completed */
        }
_L6:
        return false;
_L4:
        if (f <= 80F && j < 30) goto _L6; else goto _L5
_L5:
        if (80 - i <= 5)
        {
            return false;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public boolean isCharacterAlreadyProposed()
    {
        return characterAlreadyProposed;
    }

    public boolean isFacebookRequestAlreadySend(String s)
    {
        Set set = settings.getStringSet("keyFacebookRequestSent", null);
        if (set == null)
        {
            return false;
        } else
        {
            return set.contains(s);
        }
    }

    public void noMoreQuestions(boolean flag)
    {
        noMoreQuestion = flag;
    }

    public void removeFacebookIdForRequest(String s)
    {
        Set set = settings.getStringSet("keyFacebookRequestSent", null);
        if (set != null)
        {
            set.remove(s);
        }
    }

    public void setAnalyticsSend(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("keyAnalyticsSent", flag);
        editor.commit();
    }

    public void setCharacterAlreadyProposed(boolean flag)
    {
        characterAlreadyProposed = flag;
    }

    public void setCharacterNameProposed(String s)
    {
        characterNameProposed = s;
    }

    public void setImageDefi(Bitmap bitmap)
    {
        imageDefi = bitmap;
    }

    public void setLastProgression(float f)
    {
        oldProgression = f;
    }

    public void setLastQuestion(String s)
    {
        lastQuestion = s;
    }

    public void setMustPublishScore(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("keyMustPublishedScore", flag);
        editor.commit();
    }

    public void setPhotoAlreadyProposed(boolean flag)
    {
        photoAlreadyProposed = flag;
    }

    public void setQuestionAlreadyProposed(boolean flag)
    {
        questionAlreadyProposed = flag;
    }

    public void setStepOfLastProp(int i)
    {
        stepOfLastProp = i;
    }

    public void setTimeOfCurrentSessionStart(long l)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putLong("timeOfCurrentSessionStart", l);
        editor.commit();
    }

    public void setTimeOfLastScreenOnPause(long l)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putLong("timeOfLastScreenOnPause", l);
        editor.commit();
    }

    public void setVersionRequired(String s)
    {
        versionRequired = s;
    }

}
