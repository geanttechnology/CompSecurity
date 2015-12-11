// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkApplication, AkLog, AkConfigFactory

public class AkGameFactory
{
    public class BestQuestion
        implements Comparable
    {

        public float mDiffTrouvitude;
        public int mIndice;
        public String mQuestion;
        final AkGameFactory this$0;

        public int compareTo(BestQuestion bestquestion)
        {
            return Integer.valueOf(mIndice).compareTo(Integer.valueOf(bestquestion.mIndice));
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((BestQuestion)obj);
        }

        public void copy(BestQuestion bestquestion)
        {
            mIndice = bestquestion.mIndice;
            mDiffTrouvitude = bestquestion.mDiffTrouvitude;
            mQuestion = bestquestion.mQuestion;
        }

        public BestQuestion()
        {
            this$0 = AkGameFactory.this;
            super();
            mIndice = 0;
            mDiffTrouvitude = 0.0F;
        }

        public BestQuestion(int i, float f, String s)
        {
            this$0 = AkGameFactory.this;
            super();
            mIndice = 0;
            mDiffTrouvitude = 0.0F;
            mIndice = i;
            mDiffTrouvitude = f;
            mQuestion = s;
        }
    }


    public static final int AKINATOR_STATUS_LOST = 1;
    public static final int AKINATOR_STATUS_NEW_CHARACTER = 3;
    public static final int AKINATOR_STATUS_UNDEFINED = 0;
    public static final int AKINATOR_STATUS_WON = 2;
    private static final String KEY_GAMEOVER_STATUS = "keyGOStatus";
    private static final String KEY_INFO_MY_WORLD = "keyMyWorldInfo";
    private static final String KEY_MINIBASE_COMEFROM = "keymninibasecomefrom";
    public static final String SKU_FACES_PREFIX = "com.elokence.akinator.myworld";
    public static final String SKU_GAMECOUNT = "com.elokence.akinator.freemium.packgames";
    public static final String SKU_NOADS = "com.elokence.akinator.freemium.packads";
    public static final String SKU_POPULARITY = "com.elokence.akinator.freemium.packcharacters";
    public static final String SKU_UNLOCK = "com.digidust.elokence.akinator.freemium.full";
    private static AkGameFactory _instance;
    private Bitmap bd;
    BestQuestion bestQuestion1;
    BestQuestion bestQuestion2;
    BestQuestion bestQuestion3;
    private Bitmap characterProposalScreenShot;
    private Bitmap characterScreenshotDefi;
    private Bitmap characterScreenshotWithAward;
    private String dateFull;
    private String datePurchaseNoAds;
    private String datePurchasePopu;
    private int delaiQuestionMoyenne;
    private boolean hasClickedBanner;
    private boolean isFirstGameOverCreation;
    private int lastIdBasePlayed;
    private boolean mCanShareImageAward;
    SharedPreferences settings;
    private boolean winFirstTry;

    public AkGameFactory()
    {
        bestQuestion1 = null;
        bestQuestion2 = null;
        bestQuestion3 = null;
        bd = null;
        characterProposalScreenShot = null;
        characterScreenshotWithAward = null;
        mCanShareImageAward = false;
        lastIdBasePlayed = -1;
        isFirstGameOverCreation = true;
        settings = AkApplication.getAppContext().getSharedPreferences("game", 0);
    }

    public static AkGameFactory sharedInstance()
    {
        if (_instance == null)
        {
            _instance = new AkGameFactory();
        }
        return _instance;
    }

    public void addOneCelebCharacterPlayed()
    {
        int i = getNbCelebCharactersPlayed();
        if (i == -1)
        {
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = settings.edit();
            AkLog.d("AkGameFact", (new StringBuilder()).append("cpt : ").append(i).toString());
            editor.putInt("nb_celebrities_played", i + 1);
            editor.commit();
            return;
        }
    }

    public void addOneGame()
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt("gamecount", getGameCount() + 1);
        editor.commit();
    }

    public void addOneLostGame()
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt("games", getNbGames() + 1);
        editor.commit();
    }

    public void addOneWonGame()
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        int i = getNbWonGames();
        int j = getNbGames();
        editor.putInt("wons", i + 1);
        editor.putInt("games", j + 1);
        editor.commit();
    }

    public boolean areAdsEnabled()
    {
        return getAdsState() && getNoAdsTimestamp() < getCurrentTime();
    }

    public void canShareAwardImage(boolean flag)
    {
        mCanShareImageAward = flag;
    }

    public boolean canShareAwardImage()
    {
        return mCanShareImageAward;
    }

    public boolean canShowAd()
    {
        return settings.getBoolean("showAd", true);
    }

    public int comeFrom()
    {
        return settings.getInt("keymninibasecomefrom", 0);
    }

    public void disableAlertRateApp()
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("app_rated", true);
        editor.commit();
    }

    public void disableDiscoverMyWorld()
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("discover_my_world", true);
        editor.commit();
    }

    public boolean getAdsState()
    {
        return settings.getBoolean("ads_state", true);
    }

    public int getAkinatorStatus()
    {
        return settings.getInt("akinator_status", 0);
    }

    public Bitmap getBd()
    {
        return bd;
    }

    public BestQuestion getBestQuestion1()
    {
        return bestQuestion1;
    }

    public BestQuestion getBestQuestion2()
    {
        return bestQuestion2;
    }

    public BestQuestion getBestQuestion3()
    {
        return bestQuestion3;
    }

    public Bitmap getCharacterScreenshot()
    {
        return characterProposalScreenShot;
    }

    public Bitmap getCharacterScreenshotDefi()
    {
        return characterScreenshotDefi;
    }

    public Bitmap getCharacterScreenshotWithAward()
    {
        return characterScreenshotWithAward;
    }

    public boolean getClickedBanner()
    {
        AkLog.d("AkiBanner", (new StringBuilder()).append("Get ").append(hasClickedBanner).toString());
        return hasClickedBanner;
    }

    public int getCptNbAjoutsMinibase()
    {
        int i = settings.getInt("nb_ajouts_mini", 0);
        AkLog.d("AkGameFact", (new StringBuilder()).append("cptAjoutMini ret = ").append(i).toString());
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt("nb_ajouts_mini", i + 1);
        editor.commit();
        return i;
    }

    public long getCurrentTime()
    {
        return System.currentTimeMillis();
    }

    public String getDatePurchaseFull()
    {
        return dateFull;
    }

    public String getDatePurchaseNoAds()
    {
        return datePurchaseNoAds;
    }

    public String getDatePurchasePopu()
    {
        return datePurchasePopu;
    }

    public long getDelaiMoyen()
    {
        return (long)delaiQuestionMoyenne;
    }

    public int getGameCount()
    {
        return settings.getInt("gamecount", 0);
    }

    public String getGameOverActivityInfo()
    {
        return settings.getString("keyMyWorldInfo", "");
    }

    public int getGameOverActivityState()
    {
        return settings.getInt("keyGOStatus", 1);
    }

    public String getHomeBannerDate()
    {
        return settings.getString("home_banner_date", "");
    }

    public String getHomeBannerText()
    {
        return settings.getString("home_banner_text", "");
    }

    public String getHomeBannerUrl()
    {
        return settings.getString("home_banner_url", "");
    }

    public int getLastIdBasePlayed()
    {
        return lastIdBasePlayed;
    }

    public boolean getLimitedGameCountState()
    {
        return settings.getBoolean("game_count_state", true);
    }

    public int getNbCelebCharactersPlayed()
    {
        return settings.getInt("nb_celebrities_played", 0);
    }

    public int getNbGames()
    {
        return settings.getInt("games", 0);
    }

    public int getNbWonGames()
    {
        return settings.getInt("wons", 0);
    }

    public int getNextVarianteTextAjoutPerso()
    {
        int i = settings.getInt("text_ajout_myworld_variant", 0);
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt("text_ajout_myworld_variant", (i + 1) % 5);
        editor.commit();
        return i;
    }

    public int getNextVarianteTextAugmenteTaBase()
    {
        int i = settings.getInt("text_augmente_myworld_variant", 0);
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt("text_augmente_myworld_variant", (i + 1) % 6);
        editor.commit();
        return i;
    }

    public long getNoAdsTimestamp()
    {
        return settings.getLong("no_ads_timestamp", 0L);
    }

    public boolean getPopularityState()
    {
        return settings.getBoolean("popularity_state", true);
    }

    public long getTimestamp()
    {
        return settings.getLong("timestamp", 0L);
    }

    public long getUnlimitedGameCountTimestamp()
    {
        return settings.getLong("unlockedtime", 0L);
    }

    public long getUnlockedPopularityTimestamp()
    {
        return settings.getLong("unlocked_popularity_timestamp", 0L);
    }

    public boolean hasDiscoverMyWorld()
    {
        return settings.getBoolean("discover_my_world", false);
    }

    public boolean hasDownloadedDailyApp()
    {
        return settings.getBoolean("dailyapp_status", false);
    }

    public boolean hasSharedGame()
    {
        return settings.getBoolean("sharingstatus", false);
    }

    public boolean isAppRated()
    {
        return settings.getBoolean("app_rated", false);
    }

    public boolean isFirstGameOverCreation()
    {
        return isFirstGameOverCreation;
    }

    public boolean isGameCountLimited()
    {
        return getLimitedGameCountState() && getUnlimitedGameCountTimestamp() < getCurrentTime();
    }

    public boolean isPopularityLimited()
    {
        return getPopularityState() && getUnlockedPopularityTimestamp() < getCurrentTime();
    }

    public boolean isUnlocked()
    {
        SharedPreferences sharedpreferences = settings;
        boolean flag;
        if (!AkConfigFactory.sharedInstance().isFreemium())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return sharedpreferences.getBoolean("unlockedgame", flag);
    }

    public void lockGame()
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("unlockedgame", false);
        editor.commit();
    }

    public void replaceTimestampWithCurrentTime()
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putLong("timestamp", System.currentTimeMillis());
        editor.commit();
    }

    public void resetBestQuestions()
    {
        settings.edit();
        bestQuestion1 = new BestQuestion();
        bestQuestion2 = new BestQuestion();
        bestQuestion3 = new BestQuestion();
    }

    public void resetGameCount()
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt("gamecount", 0);
        editor.commit();
    }

    public void setAdsState(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("ads_state", flag);
        editor.commit();
    }

    public void setAkinatorStatus(int i)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt("akinator_status", i);
        editor.commit();
    }

    public void setBd(Bitmap bitmap)
    {
        bd = bitmap;
    }

    public void setCanShowAd(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("showAd", flag);
        editor.commit();
    }

    public void setCharacterScreenShot(Bitmap bitmap)
    {
        characterProposalScreenShot = bitmap;
    }

    public void setCharacterScreenshotDefi(Bitmap bitmap)
    {
        characterScreenshotDefi = bitmap;
    }

    public void setCharacterScreenshotWithAward(Bitmap bitmap)
    {
        characterScreenshotWithAward = bitmap;
    }

    public void setClickedBanner(boolean flag)
    {
        AkLog.d("AkiBanner", (new StringBuilder()).append("Set to ").append(flag).toString());
        hasClickedBanner = flag;
    }

    public void setComeFrom(int i)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt("keymninibasecomefrom", i);
        editor.commit();
    }

    public void setDatePurchaseFull(String s)
    {
        dateFull = s;
    }

    public void setDatePurchaseNoAds(String s)
    {
        datePurchaseNoAds = s;
    }

    public void setDatePurchasePopu(String s)
    {
        datePurchasePopu = s;
    }

    public void setDelaiMoyen(int i)
    {
        delaiQuestionMoyenne = i;
    }

    public void setDownloadedDailyApp(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("dailyapp_status", flag);
        editor.commit();
    }

    public void setFirstGameOverCreation(boolean flag)
    {
        isFirstGameOverCreation = flag;
    }

    public void setGameOverActivityInfo(String s)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putString("keyMyWorldInfo", s);
        editor.commit();
    }

    public void setGameOverActivityState(int i)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt("keyGOStatus", i);
        editor.commit();
    }

    public void setHomeBannerDate(String s)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putString("home_banner_date", s);
        editor.commit();
    }

    public void setHomeBannerText(String s)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putString("home_banner_text", s);
        editor.commit();
    }

    public void setHomeBannerUrl(String s)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putString("home_banner_url", s);
        editor.commit();
    }

    public void setLastIdBasePlayed(int i)
    {
        lastIdBasePlayed = i;
    }

    public void setLimitedGameCountState(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("game_count_state", flag);
        editor.commit();
    }

    public void setNoAdsTimestamp(long l)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putLong("no_ads_timestamp", getCurrentTime() + l);
        editor.commit();
    }

    public void setPopularityState(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("popularity_state", flag);
        editor.commit();
    }

    public void setSharedGame(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("sharingstatus", flag);
        editor.commit();
    }

    public void setUnlockedPopularity(long l)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putLong("unlocked_popularity_timestamp", getCurrentTime() + l);
        editor.commit();
    }

    public void setUnlockedTime(long l)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putLong("unlockedtime", getCurrentTime() + l);
        editor.commit();
    }

    public void setWinFirstTry(boolean flag)
    {
        winFirstTry = flag;
    }

    public void unlockGame()
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("unlockedgame", true);
        editor.commit();
        AkConfigFactory.sharedInstance().setCustomizeEnabled(true);
    }

    public void updateBestQuestion1(BestQuestion bestquestion)
    {
        if (bestquestion == null)
        {
            return;
        } else
        {
            bestQuestion1.copy(bestquestion);
            return;
        }
    }

    public void updateBestQuestion2(BestQuestion bestquestion)
    {
        if (bestquestion == null)
        {
            return;
        } else
        {
            bestQuestion2.copy(bestquestion);
            return;
        }
    }

    public void updateBestQuestion3(BestQuestion bestquestion)
    {
        if (bestquestion == null)
        {
            return;
        } else
        {
            bestQuestion3.copy(bestquestion);
            return;
        }
    }

    public boolean winFirstTry()
    {
        return winFirstTry;
    }
}
