// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.content.SharedPreferences;
import com.gotv.crackle.Application;
import java.util.Date;

public class SharedPrefsManager
{
    public static final class ParentalControl extends Enum
    {

        private static final ParentalControl $VALUES[];
        public static final ParentalControl RESTRICT_ALL_CONTENT;
        public static final ParentalControl RESTRICT_MATURE_CONTENT;

        public static ParentalControl valueOf(String s)
        {
            return (ParentalControl)Enum.valueOf(com/gotv/crackle/helpers/SharedPrefsManager$ParentalControl, s);
        }

        public static ParentalControl[] values()
        {
            return (ParentalControl[])$VALUES.clone();
        }

        static 
        {
            RESTRICT_MATURE_CONTENT = new ParentalControl("RESTRICT_MATURE_CONTENT", 0);
            RESTRICT_ALL_CONTENT = new ParentalControl("RESTRICT_ALL_CONTENT", 1);
            $VALUES = (new ParentalControl[] {
                RESTRICT_MATURE_CONTENT, RESTRICT_ALL_CONTENT
            });
        }

        private ParentalControl(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String CURRENT_MEDIA_ITEM = "MEDIA_ITEM";
    public static final String FIRST_LAUNCH_TIME = "FIRST_LAUNCH_TIME";
    public static final String GENERAL_PREFS = "GENERAL_PREFS";
    public static final String ITEM_PROGRESS_TIMESTAMP = "TIMESTAMP";
    public static final String LAST_EXPIRATION_NOTICE = "LAST_EXPIRATION_NOTICE";
    public static final String LAST_LATAM_VALUE = "LAST_LATAM_VALUE";
    public static final String LAST_PLAYED = "LAST_PLAYED";
    public static final String LAST_PLAYED_THUMBNAIL = "LAST_PLAYED_THUMBNAIL";
    private static final String LAST_SUBTITLES = "LAST_SUBTITLES";
    public static final String NUMBER_OF_LAUNCHES = "NUMBER_OF_LAUNCHES";
    public static final String PARENTAL_CODE = "PARENTAL_CODE";
    public static final String PARENTAL_LOCK_ENABLED = "PARENTAL_LOCK_ENABLED";
    public static final String PARENTAL_RESTRICT_MATURE_CONTENT = "PARENTAL_RESTRICT_MATURE_CONTENT";
    public static final String PLAY_PROGRESS = "PLAY_PROGRESS";
    public static final String PUSH_NOTIFICATIONS_ENABLED = "PUSH_ENABLED";
    public static final String PUSH_QUESTION_ASKED = "PUSH_QUESTION";
    public static final String RESUME_STATE = "RESUME_STATE";
    public static final String SHARING_PREFS = "SHARING_PREFS";
    public static final String SHOW_RESUME_PROMPT = "SHOW_RESUME_PROMPT";
    public static final String SOCIAL_ON_ENABLED = "SOCIAL_ON_ENABLED";
    public static final String SUPPORTS_HLS = "SUPPORTS_HLS";
    public static final String VERSION_NUMBER = "VERSION_NUMBER";
    public static final String VIEW_STATE_PREFS = "VIEW_STATES";
    public static final String WATCHED_FIRST_VIDEO_TO_COMPLETION = "WATCHED_FIRST_VIDEO_COMPLETE";
    public static final String WATCHLIST_NOTIFICATIONS_ENABLED = "WATCHLIST_NOTIFICATIONS_ENABLED";
    public static final String WIFI_ONLY_ENABLED = "WIFI_ONLY";

    public SharedPrefsManager()
    {
    }

    public static void clearPlayProgressForItem(String s)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("VIEW_STATES", 0).edit();
        editor.remove((new StringBuilder()).append(s).append("&").append("PLAY_PROGRESS").toString());
        editor.remove((new StringBuilder()).append(s).append("&").append("RESUME_STATE").toString());
        editor.remove((new StringBuilder()).append(s).append("&").append("MEDIA_ITEM").toString());
        editor.remove("LAST_PLAYED");
        editor.commit();
    }

    public static String getCurrentVersion()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getString("VERSION_NUMBER", "");
    }

    public static long getFirstLaunchTime()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getLong("FIRST_LAUNCH_TIME", 0L);
    }

    public static boolean getIsParentalLockEnabled(ParentalControl parentalcontrol)
    {
        boolean flag = false;
        SharedPreferences sharedpreferences = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0);
        if (parentalcontrol == ParentalControl.RESTRICT_MATURE_CONTENT)
        {
            flag = sharedpreferences.getBoolean("PARENTAL_RESTRICT_MATURE_CONTENT", false);
        } else
        if (parentalcontrol == ParentalControl.RESTRICT_ALL_CONTENT)
        {
            return sharedpreferences.getBoolean("PARENTAL_LOCK_ENABLED", false);
        }
        return flag;
    }

    public static boolean getIsPushEnabled()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getBoolean("PUSH_ENABLED", false);
    }

    public static boolean getIsWatchlistNotificationEnabled()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getBoolean("WATCHLIST_NOTIFICATIONS_ENABLED", true);
    }

    public static Date getLastExpiredNotificationDate()
    {
        return new Date(Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getLong("LAST_EXPIRATION_NOTICE", 0L));
    }

    public static boolean getLastIsLatamValue()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getBoolean("LAST_LATAM_VALUE", false);
    }

    public static String getLastSubtitles()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getString("LAST_SUBTITLES", null);
    }

    public static String getLastViewedMediaItem()
    {
        return Application.getInstance().getSharedPreferences("VIEW_STATES", 0).getString("LAST_PLAYED", null);
    }

    public static String getLastViewedMediaItemThumbnail()
    {
        return Application.getInstance().getSharedPreferences("VIEW_STATES", 0).getString("LAST_PLAYED_THUMBNAIL", null);
    }

    public static int getNumberOfLaunches()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getInt("NUMBER_OF_LAUNCHES", 0);
    }

    public static String getParentalLockCode()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getString("PARENTAL_CODE", "");
    }

    public static int getPlayProgressForItem(String s)
    {
        return Application.getInstance().getSharedPreferences("VIEW_STATES", 0).getInt((new StringBuilder()).append(s).append("&").append("PLAY_PROGRESS").toString(), 0);
    }

    public static Long getProgressTimestampForItem(String s)
    {
        return Long.valueOf(Application.getInstance().getSharedPreferences("VIEW_STATES", 0).getLong((new StringBuilder()).append(s).append("&").append("TIMESTAMP").toString(), 0L));
    }

    public static boolean getPushQuestionAsked()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getBoolean("PUSH_QUESTION", false);
    }

    public static String getReferralID()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getString("REFERRER", null);
    }

    public static Boolean getResumeStateForItem(String s)
    {
        return Boolean.valueOf(Application.getInstance().getSharedPreferences("VIEW_STATES", 0).getBoolean((new StringBuilder()).append(s).append("&").append("RESUME_STATE").toString(), false));
    }

    public static boolean getShouldReportReferrer()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getBoolean("REFERRER_REPORT", false);
    }

    public static boolean getShowResumePrompt()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getBoolean("SHOW_RESUME_PROMPT", true);
    }

    public static boolean getSocialOnEnabled()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getBoolean("SOCIAL_ON_ENABLED", false);
    }

    public static boolean getSupportsHLS()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getBoolean((new StringBuilder()).append(Application.getInstalledVersion()).append("&").append("SUPPORTS_HLS").toString(), true);
    }

    public static boolean getWatchedFirstVideoToCompletion()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getBoolean("WATCHED_FIRST_VIDEO_COMPLETE", false);
    }

    public static boolean getWifiOnlyEnabled()
    {
        return Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).getBoolean("WIFI_ONLY", false);
    }

    public static void setCurrentVersion(String s)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putString("VERSION_NUMBER", s);
        editor.commit();
    }

    public static void setFirstLaunchTime(long l)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putLong("FIRST_LAUNCH_TIME", l);
        editor.commit();
    }

    public static void setIsParentalLockEnabled(ParentalControl parentalcontrol, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        if (parentalcontrol != ParentalControl.RESTRICT_MATURE_CONTENT) goto _L2; else goto _L1
_L1:
        editor.putBoolean("PARENTAL_RESTRICT_MATURE_CONTENT", flag);
_L4:
        editor.commit();
        return;
_L2:
        if (parentalcontrol == ParentalControl.RESTRICT_ALL_CONTENT)
        {
            editor.putBoolean("PARENTAL_LOCK_ENABLED", flag);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void setIsPushEnabled(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putBoolean("PUSH_ENABLED", flag);
        editor.commit();
    }

    public static void setIsWatchlistNotificationEnabled(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putBoolean("WATCHLIST_NOTIFICATIONS_ENABLED", flag);
        editor.commit();
    }

    public static void setLastExpiredNotificationDate(Date date)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putLong("LAST_EXPIRATION_NOTICE", date.getTime());
        editor.commit();
    }

    public static void setLastIsLatamValue(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putBoolean("LAST_LATAM_VALUE", flag);
        editor.commit();
    }

    public static void setLastSubtitles(String s)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putString("LAST_SUBTITLES", s);
        editor.commit();
    }

    public static void setNumberOfLaunches(int i)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putInt("NUMBER_OF_LAUNCHES", i);
        editor.commit();
    }

    public static void setParentalLockCode(String s)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putString("PARENTAL_CODE", s);
        editor.commit();
    }

    public static void setPlayProgressForItem(String s, String s1, Integer integer)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("VIEW_STATES", 0).edit();
        editor.putInt((new StringBuilder()).append(s).append("&").append("PLAY_PROGRESS").toString(), integer.intValue());
        editor.putBoolean((new StringBuilder()).append(s).append("&").append("RESUME_STATE").toString(), true);
        editor.putLong((new StringBuilder()).append(s).append("&").append("TIMESTAMP").toString(), System.currentTimeMillis());
        editor.putString("LAST_PLAYED", s);
        editor.putString("LAST_PLAYED_THUMBNAIL", s1);
        editor.commit();
    }

    public static void setPushQuestionAsked(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putBoolean("PUSH_QUESTION", flag);
        editor.commit();
    }

    public static void setReferralID(String s)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putString("REFERRER", s);
        editor.commit();
    }

    public static void setShouldReportReferrer(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putBoolean("REFERRER_REPORT", flag);
        editor.commit();
    }

    public static void setShowResumePrompt(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putBoolean("SHOW_RESUME_PROMPT", flag);
        editor.commit();
    }

    public static void setSocialOnEnabled(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putBoolean("SOCIAL_ON_ENABLED", flag);
        editor.commit();
    }

    public static void setSupportsHLS(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putBoolean((new StringBuilder()).append(Application.getInstalledVersion()).append("&").append("SUPPORTS_HLS").toString(), flag);
        editor.commit();
    }

    public static void setWatchedFirstVideoToCompletion(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putBoolean("WATCHED_FIRST_VIDEO_COMPLETE", flag);
        editor.commit();
    }

    public static void setWifiOnlyEnabled(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("GENERAL_PREFS", 0).edit();
        editor.putBoolean("WIFI_ONLY", flag);
        editor.commit();
    }

    public static void updatePlayProgressForItem(String s, Integer integer, Long long1)
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("VIEW_STATES", 0).edit();
        editor.putInt((new StringBuilder()).append(s).append("&").append("PLAY_PROGRESS").toString(), integer.intValue());
        editor.putBoolean((new StringBuilder()).append(s).append("&").append("RESUME_STATE").toString(), true);
        editor.putLong((new StringBuilder()).append(s).append("&").append("TIMESTAMP").toString(), long1.longValue());
        editor.commit();
    }
}
