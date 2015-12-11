// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.adobe.adms.measurement.ADMS_Measurement;
import com.gotv.crackle.Application;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.helpers.SharedPrefsManager;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.util:
//            Log

public class OmnitureWrapper
{

    private final ADMS_Measurement mAppMeas = ADMS_Measurement.sharedInstance(Application.getInstance());
    private final String mUdid = android.provider.Settings.Secure.getString(Application.getInstance().getContentResolver(), "android_id");
    Hashtable overrides;

    public OmnitureWrapper(String s)
    {
        overrides = new Hashtable();
        mAppMeas.configureMeasurement(s, "omn.crackle.com");
        initVars();
    }

    private String PhoneOrTabletString()
    {
        if (Application.getInstance().isTablet())
        {
            return "Android Tablet App:";
        } else
        {
            return "Android Phone App:";
        }
    }

    private String getOrientationString()
    {
        if (Application.getInstance().getResources().getConfiguration().orientation == 1)
        {
            return "Portrait";
        } else
        {
            return "Landscape";
        }
    }

    private String getPodName(int i)
    {
        if (i == 0)
        {
            return "pre-roll";
        } else
        {
            return (new StringBuilder()).append("mid-roll ").append(i).toString();
        }
    }

    private void initVars()
    {
        mAppMeas.clearVars();
        String s;
        ADMS_Measurement adms_measurement;
        if (Application.getInstance().isTablet())
        {
            mAppMeas.setEvar(11, "Android Tablet App");
            mAppMeas.setEvar(39, "Android Tablet App");
            mAppMeas.setProp(50, "Android Tablet App");
            mAppMeas.setEvar(10, "Android Tablet App");
            mAppMeas.setEvar(44, (new StringBuilder()).append("Android Tablet App Version ").append(Application.APP_VERSION_NAME).toString());
            mAppMeas.setEvar(45, (new StringBuilder()).append("Android Tablet App Device OS ").append(android.os.Build.VERSION.RELEASE).toString());
        } else
        {
            mAppMeas.setEvar(11, "Android Phone App");
            mAppMeas.setEvar(39, "Android Phone App");
            mAppMeas.setProp(50, "Android Phone App");
            mAppMeas.setEvar(10, "Android Phone App");
            mAppMeas.setEvar(44, (new StringBuilder()).append("Android Phone App Version ").append(Application.APP_VERSION_NAME).toString());
            mAppMeas.setEvar(45, (new StringBuilder()).append("Android Phone App Device OS ").append(android.os.Build.VERSION.RELEASE).toString());
        }
        mAppMeas.setEvar(9, mUdid);
        mAppMeas.setEvar(5, "Mobile Apps");
        if (CrackleAccountManager.isLoggedIn())
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(CrackleAccountManager.getTimeOfFirstLogIn(CrackleAccountManager.getUserID())));
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(new Date(CrackleAccountManager.getTimeOfLastLogIn(CrackleAccountManager.getUserID())));
            Calendar calendar2 = Calendar.getInstance();
            mAppMeas.setEvar(14, (new StringBuilder()).append("").append((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 0x5265c00L).toString());
            mAppMeas.setEvar(15, (new StringBuilder()).append("").append((calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / 0x5265c00L).toString());
        }
        adms_measurement = mAppMeas;
        if (CrackleAccountManager.isLoggedIn())
        {
            s = "true";
        } else
        {
            s = "false";
        }
        adms_measurement.setProp(7, s);
        if (CrackleAccountManager.isLoggedIn())
        {
            mAppMeas.setProp(15, CrackleAccountManager.getUserID());
            mAppMeas.setEvar(8, CrackleAccountManager.getUserID());
        }
        mAppMeas.setEvar(50, getOrientationString());
    }

    private void pageViewVarsLevThree(String s, String s1, String s2, String s3)
    {
        pageViewVarsLevTwo(s, s1, s3);
        mAppMeas.setAppState((new StringBuilder()).append(PhoneOrTabletString()).append(s).append(":").append(s1).append(":").append(s2).append(":").append(s3).toString());
        mAppMeas.setEvar(16, (new StringBuilder()).append(PhoneOrTabletString()).append(s).append(":").append(s1).append(":").append(s2).append(":").append(s3).toString());
        mAppMeas.setEvar(3, (new StringBuilder()).append(s).append(":").append(s1).append(":").append(s2).toString());
        mAppMeas.setProp(3, (new StringBuilder()).append(s).append(":").append(s1).append(":").append(s2).toString());
    }

    private void pageViewVarsLevTwo(String s, String s1, String s2)
    {
        initVars();
        mAppMeas.setEvents("event13");
        mAppMeas.setAppState((new StringBuilder()).append(PhoneOrTabletString()).append(s).append(":").append(s1).append(":").append(s2).toString());
        mAppMeas.setEvar(16, (new StringBuilder()).append(PhoneOrTabletString()).append(s).append(":").append(s1).append(":").append(s2).toString());
        mAppMeas.setEvar(1, s);
        mAppMeas.setProp(1, s);
        mAppMeas.setEvar(2, (new StringBuilder()).append(s).append(":").append(s1).toString());
        mAppMeas.setProp(2, (new StringBuilder()).append(s).append(":").append(s1).toString());
        mAppMeas.setEvar(3, (new StringBuilder()).append(s).append(":").append(s1).toString());
        mAppMeas.setProp(3, (new StringBuilder()).append(s).append(":").append(s1).toString());
    }

    private void videoVars(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9)
    {
        mAppMeas.setEvar(22, s3);
        mAppMeas.setProp(22, s3);
        mAppMeas.setEvar(23, s);
        mAppMeas.setProp(23, s);
        mAppMeas.setEvar(24, s4);
        mAppMeas.setProp(24, s4);
        mAppMeas.setEvar(25, s2);
        mAppMeas.setProp(25, s2);
        mAppMeas.setEvar(33, (new StringBuilder()).append(s1).append(":").append(s9).toString());
        mAppMeas.setProp(33, (new StringBuilder()).append(s1).append(":").append(s9).toString());
        mAppMeas.setEvar(36, s5);
        mAppMeas.setProp(36, s5);
        mAppMeas.setEvar(37, s6);
        mAppMeas.setProp(37, s6);
        mAppMeas.setEvar(38, s7);
        mAppMeas.setProp(38, s7);
        mAppMeas.setEvar(59, s8);
    }

    public void addToWatchlist()
    {
        initVars();
        mAppMeas.setEvents("event37");
        mAppMeas.trackLink("", "o", "Queue", null, null);
    }

    public void browseMovieGenres()
    {
        pageViewVarsLevTwo("sectional", "movies", "browse page");
        mAppMeas.track();
    }

    public void browseMovieGenres(String s)
    {
        pageViewVarsLevThree("sectional", "movies", "browse", s);
        mAppMeas.track();
    }

    public void browseShowGenres()
    {
        pageViewVarsLevTwo("sectional", "shows", "browse page");
        mAppMeas.track();
    }

    public void browseShowGenres(String s)
    {
        pageViewVarsLevThree("sectional", "shows", "browse", s);
        mAppMeas.track();
    }

    public void chromecastStart(String s)
    {
        initVars();
        mAppMeas.setEvents("event60");
        mAppMeas.setProp(25, s);
        mAppMeas.setEvar(25, s);
        ADMS_Measurement adms_measurement = mAppMeas;
        if (Application.getInstance().isTablet())
        {
            s = "Android Tablet App";
        } else
        {
            s = "Android Phone App";
        }
        adms_measurement.setEvar(69, s);
        mAppMeas.trackLink("", "o", "Chromecast Start", null, null);
    }

    public void chromecastStop(String s)
    {
        initVars();
        mAppMeas.setEvents("event61");
        mAppMeas.setProp(25, s);
        mAppMeas.setEvar(25, s);
        ADMS_Measurement adms_measurement = mAppMeas;
        if (Application.getInstance().isTablet())
        {
            s = "Android Tablet App";
        } else
        {
            s = "Android Phone App";
        }
        adms_measurement.setEvar(69, s);
        mAppMeas.trackLink("", "o", "Chromecast Stop", null, null);
    }

    public void detailScreenMovie(String s)
    {
        pageViewVarsLevThree("show page", "movies", s, "video page");
        mAppMeas.track();
    }

    public void detailScreenShow(String s, String s1)
    {
        pageViewVarsLevThree("show page", s1, s, "video page");
        mAppMeas.track();
    }

    public void homeScreen()
    {
        initVars();
        String s = (new StringBuilder()).append(PhoneOrTabletString()).append("home page").toString();
        mAppMeas.setEvents("event13");
        mAppMeas.setAppState(s);
        mAppMeas.setEvar(16, s);
        mAppMeas.setEvar(1, "home");
        mAppMeas.setProp(1, "home");
        mAppMeas.setEvar(2, "home");
        mAppMeas.setProp(2, "home");
        mAppMeas.setEvar(3, "home");
        mAppMeas.setProp(3, "home");
        if (SharedPrefsManager.getShouldReportReferrer() && SharedPrefsManager.getReferralID() != null)
        {
            Log.d("REFERRAL3", "REFERRAL3");
            mAppMeas.setEvar(67, SharedPrefsManager.getReferralID());
            SharedPrefsManager.setShouldReportReferrer(false);
        }
        mAppMeas.track();
    }

    public void logIn(String s, String s1)
    {
        initVars();
        mAppMeas.setEvents("event8");
        mAppMeas.setEvar(8, s);
        mAppMeas.setEvar(11, s1);
        mAppMeas.trackLink("", "o", "Login", null, null);
    }

    public void logOut(String s, String s1)
    {
        initVars();
        mAppMeas.setEvents("event57");
        mAppMeas.setEvar(8, s);
        mAppMeas.setEvar(11, s1);
        mAppMeas.trackLink("", "o", "Member Logout", null, null);
    }

    public void loginPage()
    {
        pageViewVarsLevTwo("members", "profile", "login page");
        mAppMeas.track();
    }

    public void loginTracking(String s)
    {
        pageViewVarsLevTwo("members", "profile", "member profile page");
        mAppMeas.setEvar(8, s);
        mAppMeas.setEvents("event31,event13");
        mAppMeas.track();
    }

    public void moviesSectional()
    {
        pageViewVarsLevTwo("sectional", "movies", "sectional page");
        mAppMeas.track();
    }

    public void myCracklePage(String s)
    {
        pageViewVarsLevTwo("members", "profile", s);
        mAppMeas.track();
    }

    public void myWatchlists()
    {
        pageViewVarsLevTwo("show guide", "watchlists", "recommended");
        mAppMeas.track();
    }

    public int onAdStart(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, int i, int j, int k, int l, 
            String s10)
    {
        initVars();
        mAppMeas.setEvents((new StringBuilder()).append("event25,event52=").append(i - j).toString());
        mAppMeas.setEvar(41, "Freewheel");
        mAppMeas.setEvar(62, getPodName(k));
        mAppMeas.setEvar(63, (new StringBuilder()).append(k).append(":").append(l).toString());
        videoVars(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
        mAppMeas.trackLink("", "o", "Video Ad Oppurtunity", null, null);
        return i;
    }

    public int onVideo25Percent(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, int i, int j)
    {
        initVars();
        mAppMeas.setEvents((new StringBuilder()).append("event22,event52=").append(i - j).toString());
        videoVars(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
        mAppMeas.trackLink("", "o", "Video 25%", null, null);
        return i;
    }

    public int onVideo50Percent(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, int i, int j)
    {
        initVars();
        mAppMeas.setEvents((new StringBuilder()).append("event23,event52=").append(i - j).toString());
        videoVars(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
        mAppMeas.trackLink("", "o", "Video 50%", null, null);
        return i;
    }

    public int onVideo75Percent(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, int i, int j)
    {
        initVars();
        mAppMeas.setEvents((new StringBuilder()).append("event24,event52=").append(i - j).toString());
        videoVars(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
        mAppMeas.trackLink("", "o", "Video 75%", null, null);
        return i;
    }

    public void onVideoBuy(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9)
    {
        initVars();
        mAppMeas.setEvents("event30");
        mAppMeas.setEvar(47, "amazon");
        videoVars(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
        mAppMeas.trackLink("", "o", "Video Buy It Now", null, null);
    }

    public int onVideoComplete(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, int i, int j)
    {
        initVars();
        mAppMeas.setEvents((new StringBuilder()).append("event19,event52=").append(i - j).toString());
        videoVars(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
        mAppMeas.trackLink("", "o", "Video 95%", null, null);
        return i;
    }

    public void onVideoQueue(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9)
    {
        initVars();
        mAppMeas.setEvents("event37");
        videoVars(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
        mAppMeas.trackLink("", "o", "Add to Queue", null, null);
    }

    public void onVideoShare(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10)
    {
        initVars();
        mAppMeas.setEvents("event54");
        videoVars(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
        mAppMeas.trackLink("", "o", (new StringBuilder()).append("Social:").append(s).toString(), null, null);
    }

    public int onVideoStart(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, int i, int j)
    {
        initVars();
        mAppMeas.setEvents((new StringBuilder()).append("event18,event52=").append(i - j).toString());
        videoVars(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
        mAppMeas.trackLink("", "o", "Video Start", null, null);
        return i;
    }

    public void recommendedWatchlists()
    {
        pageViewVarsLevTwo("show guide", "watchlists", "recommended");
        mAppMeas.track();
    }

    public void registration(String s)
    {
        pageViewVarsLevTwo("members", "profile", "registration success page");
        mAppMeas.setEvar(8, s);
        mAppMeas.setEvents("event20,event13");
        mAppMeas.track();
    }

    public void registrationPage()
    {
        pageViewVarsLevTwo("members", "profile", "join page");
        mAppMeas.track();
    }

    public void removeFromWatchlist()
    {
        initVars();
        mAppMeas.setEvents("event46");
        mAppMeas.trackLink("", "o", "members:profile:member profile page", null, null);
    }

    public void showsSectional()
    {
        pageViewVarsLevTwo("sectional", "shows", "sectional page");
        mAppMeas.track();
    }

    public void slideShowItem(String s, int i)
    {
        initVars();
        mAppMeas.setProp(30, s);
        mAppMeas.setProp(32, (new StringBuilder()).append("Slideshow:").append(i).toString());
        mAppMeas.trackLink("", "o", "Slideshow", null, null);
    }

    public void subtitlesOff()
    {
        initVars();
        mAppMeas.setEvents("event51");
        mAppMeas.trackLink("", "o", "Subtitle Off", null, null);
    }

    public void subtitlesOn()
    {
        initVars();
        mAppMeas.setEvents("event50");
        mAppMeas.trackLink("", "o", "Subtitle On", null, null);
    }

    public void trackFromJSONData(JSONArray jsonarray)
    {
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        if (jsonarray.length() <= 0) goto _L2; else goto _L3
_L3:
        int i = 0;
_L4:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = jsonarray.getJSONObject(i);
        String s = ((JSONObject) (obj)).getString("Key");
        obj = ((JSONObject) (obj)).getString("Value");
        overrides.put(s, obj);
        i++;
        if (true) goto _L4; else goto _L2
        jsonarray;
        jsonarray.printStackTrace();
_L2:
    }

    public void watchlistRecommendedTitle(String s)
    {
        pageViewVarsLevThree("show guide", "watchlists", "recommended", s);
        mAppMeas.track();
    }
}
