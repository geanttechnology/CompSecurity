// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkApplication, AkLog, AkGameFactory, AkPlayerBelongingsFactory

public class AkConfigFactory
{

    public static final int ADD_MB_FIRST = 1;
    public static final int ADD_MB_OK = 0;
    public static final int ADD_MB_SECOND = 2;
    private static final String AK_CONFIG_GCM_KEY = "gcm_key";
    private static final String AK_CONFIG_TYPE_KEY = "type";
    private static final String AK_GCM_TOKEN = "gcm_token";
    private static final String AK_HAS_USED_GENIZ = "geniz_used";
    private static final String AK_IS_TABLET = "tablet";
    private static final String AK_KEY_CAN_DISPLAY_COOKIE_ALERT = "keyCanDisplayCookieAlert";
    private static final String AK_KEY_CHANGE_LANG_MANUALLY = "keyHasAlreadyChangeLang";
    private static final String AK_LAST_VERSION = "last_version";
    private static final String AK_POPULARITY_DOWN_RATE = "pop_down_rate";
    private static final String AK_POPULARITY_UP_RATE = "pop_up_rate";
    private static final String AK_SETTING_100CREDITS_DISTRIBUES = "geniz_offerts";
    private static final String AK_SETTING_BACKGROUND_KEY = "question_background";
    private static final String AK_SETTING_CAN_RESHOW_ALERT = "alert_reshow";
    private static final String AK_SETTING_CHILD_PROTECT_CHOSEN = "child_protect_chosen";
    private static final String AK_SETTING_CHILD_PROTECT_KEY = "childprotect";
    private static final String AK_SETTING_CLOTH_KEY = "question_cloth";
    private static final String AK_SETTING_CUSTOMIZE_KEY = "personnalisation";
    private static final String AK_SETTING_DEVICE_ELOKENCE_ID = "deviceElokenceId";
    private static final String AK_SETTING_DISPLAY_ALERT_FIRST_TIME = "displayAlert";
    private static final String AK_SETTING_ENABLE_OGURY = "og_enable";
    private static final String AK_SETTING_FIRST_AJOUT_MB = "firstajoutMb";
    private static final String AK_SETTING_FIRST_LAUNCH_KEY = "firstLaunch";
    private static final String AK_SETTING_FIRST_LAUNCH_MYWORLD_KEY = "firstLaunchMB";
    private static final String AK_SETTING_HAT_KEY = "question_hat";
    private static final String AK_SETTING_HOME_BANNER_AVAILABLE = "homebanner_available";
    private static final String AK_SETTING_HOME_BANNER_STATE = "homebanner_state";
    private static final String AK_SETTING_INAPP_PANEL = "abinapanel";
    private static final String AK_SETTING_INSTANCE_ID = "instanceid";
    private static final String AK_SETTING_LAST_VERSION_PLAYED = "lastVersionPLayed";
    private static final String AK_SETTING_MUSIC_KEY = "music";
    private static final String AK_SETTING_NEXT_ALERT = "next_alert";
    private static final String AK_SETTING_PHONE_LANG_KEY = "lang";
    private static final String AK_SETTING_PLAY_WITH_CELEBRITIES = "play_celeb";
    private static final String AK_SETTING_PLAY_WITH_MYWORLD = "play_myworld";
    private static final String AK_SETTING_SHORT_MUSIC_ID = "musicShort";
    private static final String AK_SETTING_SHOW_ALERT_CUSTOMIZE = "alert_customize";
    private static final String AK_SETTING_SHOW_ALERT_GENIZ = "alert_geniz";
    private static final String AK_SETTING_SHOW_ALERT_RATING = "alert_rating";
    private static final String AK_SETTING_SOUND_KEY = "sound";
    private static final String AK_SETTING_SUBJECT_ID = "subjectid";
    private static final String AK_TYPE_FREE = "free";
    private static final String AK_TYPE_FREEMIUM = "freemium";
    private static final String AK_TYPE_PAID = "paid";
    private static final String AK_USER_MAX_RANKING = "user_max_ranking";
    private static final String Ak_OVERLAY_CHILD_PROTECTION = "overlay_child_protect";
    public static final int CANNOT_PLAY = -1;
    public static final int CAN_PLAY = 1;
    public static final int COULD_PLAY_WITH_PRIO = 0;
    public static final String KEY_PICTURES_CHOICE = "keyImages";
    public static final String NOM_SETTINGS_SHARED_PREFS = "settings";
    public static final int PICTURES_ALL_THE_TIME = 0;
    public static final int PICTURES_NEVER = 2;
    public static final int PICTURES_WIFI_ONLY = 1;
    private static AkConfigFactory _instance;
    private static int mCanPlay = 1;
    private boolean canSendAnalytics;
    public int delaiQuestionMoyenne;
    private android.content.SharedPreferences.Editor editor;
    private char lastGameState;
    private int lastPushMetrics;
    private boolean mCanCheckFull;
    private boolean mCanDisplayRestoreOk;
    private boolean mustUpdateWSC;
    private int nOriginalMaxRanking;
    private Properties properties;
    private SharedPreferences settings;
    private String versionName;

    private AkConfigFactory()
    {
        nOriginalMaxRanking = 5000;
        delaiQuestionMoyenne = 0;
        versionName = "";
        mCanDisplayRestoreOk = false;
        mustUpdateWSC = false;
        lastGameState = 'N';
        canSendAnalytics = true;
        mCanCheckFull = false;
        loadConfigFile();
        settings = AkApplication.getAppContext().getSharedPreferences("settings", 0);
        editor = settings.edit();
    }

    private void loadConfigFile()
    {
        AkLog.d("Akinator", "Load config file");
        Object obj = AkApplication.getAppContext().getResources().getAssets();
        try
        {
            obj = ((AssetManager) (obj)).open("config/config.properties");
            properties = new Properties();
            properties.load(((java.io.InputStream) (obj)));
            AkLog.d("Akinator", "The properties are now loaded");
            AkLog.d("Akinator", (new StringBuilder()).append("Properties: ").append(properties).toString());
            return;
        }
        catch (IOException ioexception)
        {
            AkLog.e("Akinator", (new StringBuilder()).append("Failed to open config property file ").append(ioexception.getClass()).toString());
            ioexception.printStackTrace();
            return;
        }
    }

    public static AkConfigFactory sharedInstance()
    {
        if (_instance == null)
        {
            _instance = new AkConfigFactory();
        }
        return _instance;
    }

    public static String transFormLang(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 56
    //                   3325: 124
    //                   3374: 109
    //                   3383: 94
    //                   3428: 154
    //                   3886: 139;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_154;
_L7:
        switch (byte0)
        {
        default:
            return s;

        case 0: // '\0'
            return "jp";

        case 1: // '\001'
        case 2: // '\002'
            return "il";

        case 3: // '\003'
            return "cn";

        case 4: // '\004'
            return "kr";
        }
_L4:
        if (s.equals("ja"))
        {
            byte0 = 0;
        }
          goto _L7
_L3:
        if (s.equals("iw"))
        {
            byte0 = 1;
        }
          goto _L7
_L2:
        if (s.equals("he"))
        {
            byte0 = 2;
        }
          goto _L7
_L6:
        if (s.equals("zh"))
        {
            byte0 = 3;
        }
          goto _L7
        if (s.equals("ko"))
        {
            byte0 = 4;
        }
          goto _L7
    }

    public boolean canCheckFull()
    {
        return mCanCheckFull;
    }

    public boolean canDisplayCookieAlert()
    {
        return settings.getBoolean("keyCanDisplayCookieAlert", true);
    }

    public boolean canDisplayRestoreOk()
    {
        return mCanDisplayRestoreOk;
    }

    public boolean canDownloadPicture()
    {
        int i = getPictureMode();
        if (i != 0)
        {
            if (i == 2)
            {
                return false;
            }
            if (i != 1 || !isWifiConnected())
            {
                return false;
            }
        }
        return true;
    }

    public int canPlay()
    {
        return mCanPlay;
    }

    public boolean canSendAnalytics()
    {
        return canSendAnalytics;
    }

    public boolean canShowAlertCustomize()
    {
        return settings.getBoolean("alert_customize", true);
    }

    public boolean canShowAlertRating()
    {
        return settings.getBoolean("alert_rating", true);
    }

    public void changeLanguageManually(boolean flag)
    {
        editor.putBoolean("keyHasAlreadyChangeLang", flag);
        editor.commit();
    }

    public int debutAddMB()
    {
        return settings.getInt("firstajoutMb", 1);
    }

    public boolean displayAlertFirstTime()
    {
        return settings.getBoolean("displayAlert", true);
    }

    public void displayRestoreOk(boolean flag)
    {
        mCanDisplayRestoreOk = flag;
    }

    public String getApplication()
    {
        String s1 = "";
        if (!sharedInstance().isFreemium()) goto _L2; else goto _L1
_L1:
        if (!"gplay".equals("gplay")) goto _L4; else goto _L3
_L3:
        String s = "JAGPFR";
_L6:
        return s;
_L4:
        s = s1;
        if ("gplay".equals("amazon"))
        {
            return "JAAMFR";
        }
        continue; /* Loop/switch isn't completed */
_L2:
        s = s1;
        if (sharedInstance().isPaid())
        {
            if ("gplay".equals("gplay"))
            {
                return "JAGPPR";
            }
            s = s1;
            if ("gplay".equals("amazon"))
            {
                return "JAAMPR";
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String getBackground()
    {
        return settings.getString("question_background", "orient");
    }

    public String getCloth()
    {
        return settings.getString("question_cloth", "orient");
    }

    public String getCodeSubject()
    {
        return settings.getString("subjectid", "1");
    }

    public String getElokenceDeviceId()
    {
        return settings.getString("deviceElokenceId", null);
    }

    public String getGCMKey()
    {
        return properties.getProperty("gcm_key");
    }

    public String getGCMToken()
    {
        return settings.getString("gcm_token", null);
    }

    public String getGoogleAnalyticsId()
    {
        String s1 = "";
        String s;
        if ("freemium".equals("freemium") && "gplay".equals("gplay"))
        {
            s = "UA-3342118-6";
        } else
        {
            if ("freemium".equals("paid") && "gplay".equals("gplay"))
            {
                return "UA-3342118-7";
            }
            s = s1;
            if ("freemium".equals("openbar"))
            {
                s = s1;
                if ("gplay".equals("pastrami"))
                {
                    return "UA-3342118-8";
                }
            }
        }
        return s;
    }

    public String getHat()
    {
        return settings.getString("question_hat", "turban");
    }

    public String getInappPanel()
    {
        return settings.getString("abinapanel", null);
    }

    public String getInstanceId()
    {
        return settings.getString("instanceid", "");
    }

    public String getLastVersion()
    {
        return settings.getString("last_version", null);
    }

    public String getLastVersionPLayed()
    {
        return settings.getString("lastVersionPLayed", "");
    }

    public int getMaxRanking()
    {
        return settings.getInt("user_max_ranking", 0);
    }

    public String getMediaFootprint()
    {
        if (AkGameFactory.sharedInstance().isUnlocked())
        {
            return "cd8e6509f3420878e18d75b9831b317f";
        } else
        {
            return "82de69085436aba8a6f6b37c0d5c8a1e";
        }
    }

    public String getMediaId()
    {
        if (AkGameFactory.sharedInstance().isUnlocked())
        {
            return "14";
        } else
        {
            return "13";
        }
    }

    public int getOriginalMaxRanking()
    {
        return nOriginalMaxRanking;
    }

    public int getPartnerId(boolean flag)
    {
        int j = 0;
        if (!"freemium".equals("freemium") || !"gplay".equals("gplay") || !AkGameFactory.sharedInstance().isPopularityLimited()) goto _L2; else goto _L1
_L1:
        int i = 410;
_L4:
        j = i;
        if (flag)
        {
            j = i + 3;
        }
        return j;
_L2:
        if ("freemium".equals("freemium") && "gplay".equals("gplay") && !AkGameFactory.sharedInstance().isPopularityLimited())
        {
            i = 430;
        } else
        if ("freemium".equals("paid") && "gplay".equals("gplay"))
        {
            i = 420;
        } else
        {
            i = j;
            if ("freemium".equals("openbar"))
            {
                i = j;
                if ("gplay".equals("pastrami"))
                {
                    i = 441;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getPhoneLang()
    {
        return settings.getString("lang", transFormLang(Locale.getDefault().getLanguage()));
    }

    public int getPictureMode()
    {
        return settings.getInt("keyImages", 0);
    }

    public int getPopDownRate()
    {
        return settings.getInt("pop_down_rate", 5);
    }

    public int getPopUpRate()
    {
        return settings.getInt("pop_up_rate", 15);
    }

    public ArrayList getSelectedInapps()
    {
        ArrayList arraylist = new ArrayList();
        String as[] = getInappPanel().split(";");
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String as1[] = as[i].split(",");
            arraylist.add(new Pair(as1[0], Integer.getInteger(as1[1])));
        }

        return arraylist;
    }

    public int getShortMusic()
    {
        return settings.getInt("musicShort", 0x7f060008);
    }

    public String getVersionName()
    {
        return versionName;
    }

    public boolean hasAlreadyChangeLangManually()
    {
        return settings.getBoolean("keyHasAlreadyChangeLang", false);
    }

    public boolean hasChosenChildProtection()
    {
        return settings.getBoolean("child_protect_chosen", false);
    }

    public boolean hasOverlayChildProtectionAlreadyDisplayed()
    {
        return settings.getBoolean("overlay_child_protect", false);
    }

    public boolean hasUsedGeniz()
    {
        return settings.getBoolean("geniz_used", false);
    }

    public boolean isChildProtectEnabled()
    {
        return settings.getBoolean("childprotect", false);
    }

    public boolean isCustomizeEnabled()
    {
        boolean flag;
        if (!isFreemium() || AkGameFactory.sharedInstance().isUnlocked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return settings.getBoolean("personnalisation", flag);
    }

    public boolean isFacesDistribues()
    {
        return settings.getBoolean("geniz_offerts", false);
    }

    public boolean isFirstLaunch()
    {
        return settings.getBoolean("firstLaunch", true);
    }

    public boolean isFirstLaunchMB()
    {
        return settings.getBoolean("firstLaunchMB", true);
    }

    public boolean isFreemium()
    {
        return "freemium".equals("freemium");
    }

    public boolean isGSMConnected()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)AkApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.getType() == 0;
    }

    public boolean isHomeBannerAvailable()
    {
        return settings.getBoolean("homebanner_available", true);
    }

    public boolean isHomeBannerOpened()
    {
        return settings.getBoolean("homebanner_state", true);
    }

    public boolean isMusicEnabled()
    {
        return settings.getBoolean("music", true);
    }

    public boolean isOguryEnabled()
    {
        return settings.getBoolean("og_enable", true);
    }

    public boolean isOnline()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)AkApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnected();
    }

    public boolean isPaid()
    {
        return "freemium".equals("paid");
    }

    public boolean isPlayWithCelebritiesActivated()
    {
        return settings.getBoolean("play_celeb", true);
    }

    public boolean isPlayWithMyworldActivated()
    {
        return settings.getBoolean("play_myworld", true);
    }

    public boolean isPrio()
    {
        return isPaid() || isFreemium() && AkGameFactory.sharedInstance().isUnlocked() || isFreemium() && !AkGameFactory.sharedInstance().isPopularityLimited();
    }

    public boolean isSoundEnabled()
    {
        return settings.getBoolean("sound", true);
    }

    public boolean isTablet()
    {
        return settings.getBoolean("tablet", false);
    }

    public boolean isWifiConnected()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)AkApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.getType() == 1;
    }

    public void neverDisplayAlert()
    {
        editor.putBoolean("displayAlert", false);
        editor.commit();
    }

    public void setBackground(String s)
    {
        editor.putString("question_background", s);
        editor.commit();
    }

    public void setCanCheckFull(boolean flag)
    {
        mCanCheckFull = flag;
    }

    public void setCanPlay(int i)
    {
        mCanPlay = i;
    }

    public void setCanReShowAlert(boolean flag)
    {
        editor.putBoolean("alert_reshow", flag);
        editor.commit();
    }

    public void setCanSendAnalytics(boolean flag)
    {
        canSendAnalytics = flag;
    }

    public void setChildProtectEnabled(boolean flag)
    {
        editor.putBoolean("childprotect", flag);
        editor.commit();
    }

    public void setChildProtectionChosen(boolean flag)
    {
        editor.putBoolean("child_protect_chosen", flag);
        editor.commit();
    }

    public void setCloth(String s)
    {
        editor.putString("question_cloth", s);
        editor.commit();
    }

    public void setCodeSubject(String s)
    {
        editor.putString("subjectid", s);
        editor.commit();
    }

    public void setCustomizeEnabled(boolean flag)
    {
        boolean flag1 = flag;
        if (isFreemium())
        {
            flag1 = flag;
            if (!AkGameFactory.sharedInstance().isUnlocked())
            {
                flag1 = false;
            }
        }
        editor.putBoolean("personnalisation", flag1);
        editor.commit();
    }

    public void setElokenceDeviceIdl(String s)
    {
        editor.putString("deviceElokenceId", s);
        editor.commit();
    }

    public void setFacesDistribues()
    {
        editor.putBoolean("geniz_offerts", true);
        editor.commit();
    }

    public void setFirstLaunch(boolean flag)
    {
        editor.putBoolean("firstLaunch", flag);
        editor.commit();
    }

    public void setFirstLaunchMB(boolean flag)
    {
        editor.putBoolean("firstLaunchMB", flag);
        if (flag)
        {
            AkPlayerBelongingsFactory.sharedInstance().resetFaces();
        }
        editor.commit();
    }

    public void setGCMToken(String s)
    {
        editor.putString("gcm_token", s);
        editor.commit();
    }

    public void setHasUsedGeniz(boolean flag)
    {
        editor.putBoolean("geniz_used", flag);
        editor.commit();
    }

    public void setHat(String s)
    {
        editor.putString("question_hat", s);
        editor.commit();
    }

    public void setHomeBannerAvailable(boolean flag)
    {
        editor.putBoolean("homebanner_available", flag);
        editor.commit();
    }

    public void setHomeBannerOpened(boolean flag)
    {
        editor.putBoolean("homebanner_state", flag);
        editor.commit();
    }

    public void setInappPanel(String s)
    {
        editor.putString("abinapanel", s);
        editor.commit();
    }

    public void setInstanceId(String s)
    {
        editor.putString("instanceid", s);
        editor.commit();
    }

    public void setIsTablet(boolean flag)
    {
        editor.putBoolean("tablet", flag);
        editor.commit();
    }

    public void setLastVersion(String s)
    {
        editor.putString("last_version", s);
        editor.commit();
    }

    public void setLastVersionPLayed(String s)
    {
        editor.putString("lastVersionPLayed", s);
        editor.commit();
    }

    public void setMaxRanking(int i)
    {
        editor.putInt("user_max_ranking", i);
        editor.commit();
    }

    public void setMusicEnabled(boolean flag)
    {
        editor.putBoolean("music", flag);
        editor.commit();
    }

    public void setOguryEnabled(boolean flag)
    {
        editor.putBoolean("og_enable", flag);
        editor.commit();
    }

    public void setOriginalMaxRanking(int i)
    {
        nOriginalMaxRanking = i;
    }

    public void setOverlayChildProtection()
    {
        editor.putBoolean("overlay_child_protect", true);
        editor.commit();
    }

    public void setPhoneLang(String s)
    {
        editor.putString("lang", s);
        editor.commit();
    }

    public void setPictureMode(int i)
    {
        editor.putInt("keyImages", i);
        editor.commit();
    }

    public void setPlayWithCelebrities(boolean flag)
    {
        editor.putBoolean("play_celeb", flag);
        editor.commit();
    }

    public void setPlayWithMyworld(boolean flag)
    {
        editor.putBoolean("play_myworld", flag);
        editor.commit();
    }

    public void setPopDownRate(int i)
    {
        editor.putInt("pop_down_rate", i);
    }

    public void setPopUpRate(int i)
    {
        editor.putInt("pop_up_rate", i);
    }

    public void setShortMusic(int i)
    {
        editor.putInt("musicShort", i);
        editor.commit();
    }

    public void setSoundEnabled(boolean flag)
    {
        editor.putBoolean("sound", flag);
        editor.commit();
    }

    public void setVersionName(String s)
    {
        versionName = s;
    }

    public void updateCookieAlertStatus(boolean flag)
    {
        editor.putBoolean("keyCanDisplayCookieAlert", flag);
        editor.commit();
    }

    public void updateDebutAddMB()
    {
        int i = debutAddMB();
        i;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 52
    //                   2 57;
           goto _L1 _L2 _L3
_L1:
        editor.putInt("firstajoutMb", i);
        editor.commit();
        return;
_L2:
        i = 2;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0;
        if (true) goto _L1; else goto _L4
_L4:
    }

}
