// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.elokence.limuleapi.factories.AkUrlCachedFactory;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebServiceHandler, AkLog, TestUrl, Session, 
//            AkCancellingWS, AkNewSessionWS, AkWebservice

public class SessionFactory
    implements AkWebServiceHandler
{
    public static interface Listener
    {

        public abstract void onWebServiceReload(int i);
    }


    private static final String FOOTPRINT = "<footprint>";
    private static final String LANG = "<lang>";
    private static final String MEDIA_ID = "<media>";
    public static final String NOM_SETTINGS_SHARED_PREFS = "SessionFactorySettings";
    public static final String TAG = "SessionFactory";
    private static final String THEME = "<theme>";
    private static final int TIMEOUT_WSC = 20000;
    private static final String globalWscUrl = "http://global<variable>.akinator.com/ws/instances_v2.php?media_id=<media>&footprint=<footprint>&lang=<lang>&subject_id=<theme>";
    private static final TreeMap languagesStaticBaseUrls = new _cls1();
    private static SessionFactory msInstance = null;
    private android.content.SharedPreferences.Editor editor;
    private final Object languageLock = new Object();
    private final HashSet listeners = new HashSet();
    protected Context mAppContext;
    private int mBaseLogiqueId;
    private String mBaseUrlToGiveToWS;
    private boolean mCanCheckUrl;
    private boolean mChildrenFilter;
    private boolean mFast;
    private int mFreeGamesAllowed;
    private int mHauteurPhoto;
    private String mLabel;
    private String mLanguage;
    private int mLargeurPhoto;
    private String mMediaFootprint;
    private int mMediaId;
    private int mPartnerId;
    private boolean mPremium;
    private boolean mPrio;
    private String mPrioAvailable;
    private int mRankingLimit;
    ScheduledExecutorService mScheduler;
    private String mServiceId;
    private Session mSession;
    private String mSessionFactoryBaseUrl;
    private String mState;
    private String mSubjectId;
    private String mSubjectPrice;
    private int mTheme;
    private Thread mThreadVerifUrl;
    private SharedPreferences settings;

    private SessionFactory()
    {
        settings = null;
        editor = null;
        mThreadVerifUrl = null;
        mCanCheckUrl = false;
        mLanguage = null;
        mHauteurPhoto = -1;
        mLargeurPhoto = -1;
        mSessionFactoryBaseUrl = null;
        mBaseUrlToGiveToWS = null;
        mScheduler = null;
        mSession = null;
    }

    private int checkCachedUrl()
    {
label0:
        {
            AkLog.d("SessionFactory", "Try to find a URL in cache.");
            Object obj = AkUrlCachedFactory.sharedInstance().getCachedUrls(mLanguage, mTheme);
            if (obj == null)
            {
                break label0;
            }
            obj = ((Set) (obj)).iterator();
            String s1;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                s1 = (String)((Iterator) (obj)).next();
            } while (s1.equals(mSessionFactoryBaseUrl) || !TestUrl.pingUrl(s1));
            mSessionFactoryBaseUrl = s1;
            AkLog.d("SessionFactory", (new StringBuilder()).append("checkCachedUrl found baseUrl ").append(mSessionFactoryBaseUrl).toString());
            return 0;
        }
    /* block-local class not found */
    class languageMini {}

        String s = (String)languagesStaticBaseUrls.get(new languageMini(mLanguage, mTheme, null));
        if (TestUrl.pingUrl(s))
        {
            mSessionFactoryBaseUrl = s;
            AkLog.d("SessionFactory", (new StringBuilder()).append("checkCachedUrl found static baseUrl ").append(mSessionFactoryBaseUrl).toString());
            return 0;
        } else
        {
            mSessionFactoryBaseUrl = null;
            AkLog.e("SessionFactory", "checkCachedUrl baseUrl KO");
            return 400;
        }
    }

    private void checkWSC()
    {
        if (mAppContext == null || !isOnline())
        {
            break MISSING_BLOCK_LABEL_175;
        }
        if (!mCanCheckUrl) goto _L2; else goto _L1
_L1:
        Object obj = languageLock;
        obj;
        JVM INSTR monitorenter ;
        if (mLanguage == null || mLanguage.equals("")) goto _L4; else goto _L3
_L3:
        String s;
        int i;
        AkLog.d("SessionFactory", "Thread -> check baseUrl");
        s = mSessionFactoryBaseUrl;
        i = setLanguageWSPrivate(mLanguage);
        if (mSessionFactoryBaseUrl == null || mSessionFactoryBaseUrl.equals(s)) goto _L6; else goto _L5
_L5:
        AkLog.d("SessionFactory", (new StringBuilder()).append("Thread -> Need to change baseUrl... at next startSession() -> ").append(mSessionFactoryBaseUrl).append(". Former URL : ").append(s).toString());
_L7:
        if (mSessionFactoryBaseUrl == null)
        {
            mSessionFactoryBaseUrl = s;
        }
        signalUpdateWSC(i);
_L8:
        return;
_L6:
        AkLog.d("SessionFactory", "Thread -> Same baseURL... no need to change");
          goto _L7
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        AkLog.d("SessionFactory", "Thread -> No language yet... no need to change");
          goto _L8
_L2:
        AkLog.d("SessionFactory", "Thread -> App is in background... no need to change");
        return;
        AkLog.d("SessionFactory", "Thread -> No Internet... no need to change");
        return;
          goto _L7
    }

    private int extractInstanceFromXMLString(Document document)
    {
        int i;
        boolean flag = false;
        Element element;
        Element element1;
        try
        {
            document.getDocumentElement().normalize();
            document = document.getElementsByTagName("INSTANCE");
        }
        // Misplaced declaration of an exception variable
        catch (Document document)
        {
            document.printStackTrace();
            return 400;
        }
        if (document == null)
        {
            break MISSING_BLOCK_LABEL_715;
        }
        document = document.item(0);
        mServiceId = ((Element)((Element)document).getElementsByTagName("SERVICE_ID").item(0)).getTextContent();
        mLabel = ((Element)((Element)document).getElementsByTagName("TRANSLATED_SUBJECT_NAME").item(0)).getTextContent();
        mFreeGamesAllowed = Integer.parseInt(((Element)((Element)document).getElementsByTagName("NB_FREE_GAMES_ALLOWED").item(0)).getTextContent());
        element = (Element)((Element)document).getElementsByTagName("SUBJECT").item(0);
        mSubjectId = ((Element)element.getElementsByTagName("SUBJ_ID").item(0)).getTextContent();
        mSubjectPrice = ((Element)element.getElementsByTagName("SUBJ_PRICE").item(0)).getTextContent();
        mRankingLimit = Integer.parseInt(((Element)((Element)document).getElementsByTagName("RANKING_LIMIT").item(0)).getTextContent());
        mState = ((Element)((Element)document).getElementsByTagName("STATE").item(0)).getTextContent();
        mPrioAvailable = ((Element)((Element)document).getElementsByTagName("PRIO_AVAILABLE").item(0)).getTextContent();
        mBaseLogiqueId = Integer.parseInt(((Element)((Element)document).getElementsByTagName("BASE_LOGIQUE_ID").item(0)).getTextContent());
        element = (Element)((Element)document).getElementsByTagName("CANDIDATS").item(0);
        if (element == null) goto _L2; else goto _L1
_L1:
        AkUrlCachedFactory.sharedInstance().clearUrls(mLanguage, mTheme);
        i = 0;
_L3:
        if (i >= element.getElementsByTagName("URL").getLength())
        {
            break; /* Loop/switch isn't completed */
        }
        element1 = (Element)element.getElementsByTagName("URL").item(i);
        AkUrlCachedFactory.sharedInstance().addUrlInCache(mLanguage, mTheme, element1.getTextContent());
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        if (mState == null)
        {
            i = checkCachedUrl();
            break MISSING_BLOCK_LABEL_736;
        }
        if (!mState.equals("OK"))
        {
            break MISSING_BLOCK_LABEL_653;
        }
        AkLog.d("SessionFactory", "State OK. Parse URL_BASE_WS");
        mSessionFactoryBaseUrl = ((Element)((Element)document).getElementsByTagName("URL_BASE_WS").item(0)).getTextContent();
        if (mSessionFactoryBaseUrl == null || mSessionFactoryBaseUrl.equals(""))
        {
            AkLog.d("SessionFactory", "Base URL empty or null");
            i = checkCachedUrl();
            break MISSING_BLOCK_LABEL_736;
        }
        AkLog.d("SessionFactory", (new StringBuilder()).append("Try to ping ").append(mSessionFactoryBaseUrl).toString());
        if (!TestUrl.pingUrl(mSessionFactoryBaseUrl))
        {
            break MISSING_BLOCK_LABEL_616;
        }
        AkLog.d("SessionFactory", (new StringBuilder()).append("Ping OK on URL_BASE_WS ").append(mSessionFactoryBaseUrl).toString());
        i = 0;
        break MISSING_BLOCK_LABEL_736;
        AkLog.d("SessionFactory", (new StringBuilder()).append("Ping KO on URL_BASE_WS ").append(mSessionFactoryBaseUrl).toString());
        i = checkCachedUrl();
        break MISSING_BLOCK_LABEL_736;
        i = ((flag) ? 1 : 0);
        if (!mState.equals("KO"))
        {
            break MISSING_BLOCK_LABEL_736;
        }
        if (!mPrioAvailable.equals("1"))
        {
            break MISSING_BLOCK_LABEL_699;
        }
        AkLog.e("SessionFactory", "WSC -> stop because STATE = KO but PRIO = 1");
        i = 510;
        break MISSING_BLOCK_LABEL_736;
        AkLog.e("SessionFactory", "WSC -> stop because STATE = KO and PRIO = 0");
        i = 500;
        break MISSING_BLOCK_LABEL_736;
        AkLog.e("SessionFactory", "WSC <INSTANCE> not present");
        return 400;
        return i;
    }

    private boolean isOnline()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)mAppContext.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnected();
    }

    private void launchThreadVerif()
    {
        mThreadVerifUrl = new Thread(new _cls2());
        mThreadVerifUrl.start();
    }

    private void restoreAttributes()
    {
        settings = mAppContext.getSharedPreferences("SessionFactorySettings", 0);
        editor = settings.edit();
        if (settings != null)
        {
            mChildrenFilter = settings.getBoolean("mChildrenFilter", true);
            mPartnerId = settings.getInt("mPartnerId", 0);
            mMediaId = settings.getInt("mMediaId", 0);
            mLanguage = settings.getString("mLanguage", "en");
            mTheme = settings.getInt("mTheme", 1);
            mPrio = settings.getBoolean("mPrio", false);
            mPremium = settings.getBoolean("mPremium", false);
            mFast = settings.getBoolean("mFast", true);
            mHauteurPhoto = settings.getInt("mHauteurPhoto", 640);
            mLargeurPhoto = settings.getInt("mLargeurPhoto", 480);
            mMediaFootprint = settings.getString("mMediaFootprint", "");
            mSessionFactoryBaseUrl = settings.getString("mSessionFactoryBaseUrl", "");
            mBaseUrlToGiveToWS = settings.getString("mBaseUrlToGiveToWS", "");
            mBaseLogiqueId = settings.getInt("mBaseLogiqueId", 0);
        }
    }

    private void saveAttributes()
    {
        settings = mAppContext.getSharedPreferences("SessionFactorySettings", 0);
        editor = settings.edit();
        if (editor != null)
        {
            editor.putBoolean("mChildrenFilter", mChildrenFilter);
            editor.putInt("mPartnerId", mPartnerId);
            editor.putInt("mMediaId", mMediaId);
            editor.putString("mLanguage", mLanguage);
            editor.putInt("mTheme", mTheme);
            editor.putBoolean("mPrio", mPrio);
            editor.putBoolean("mPremium", mPremium);
            editor.putBoolean("mFast", mFast);
            editor.putInt("mHauteurPhoto", mHauteurPhoto);
            editor.putInt("mLargeurPhoto", mLargeurPhoto);
            editor.putString("mMediaFootprint", mMediaFootprint);
            editor.putInt("mBaseLogiqueId", mBaseLogiqueId);
            editor.commit();
        }
    }

    private int setLanguageWSPrivate(String s)
    {
        mLanguage = s;
        s = TestUrl.TryToConnectWithLoadBalancing("http://global<variable>.akinator.com/ws/instances_v2.php?media_id=<media>&footprint=<footprint>&lang=<lang>&subject_id=<theme>".replace("<media>", String.valueOf(mMediaId)).replace("<footprint>", mMediaFootprint).replace("<lang>", mLanguage).replace("<theme>", String.valueOf(mTheme)), 20000);
        if (s != null)
        {
            int i;
            try
            {
                s = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(s)));
                if (TestUrl.testNodeCompletion(s) == 0)
                {
                    return extractInstanceFromXMLString(s);
                }
                i = checkCachedUrl();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return 400;
            }
            return i;
        } else
        {
            AkLog.e("SessionFactory", "setLanguageWS -> TryToConnectWithLoadBalancing returns a null XML");
            return checkCachedUrl();
        }
    }

    public static SessionFactory sharedInstance()
    {
        if (msInstance == null)
        {
            msInstance = new SessionFactory();
        }
        return msInstance;
    }

    private void signalUpdateWSC(int i)
    {
        HashSet hashset = listeners;
        hashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((Listener)iterator.next()).onWebServiceReload(i)) { }
        break MISSING_BLOCK_LABEL_47;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
    }

    public void SetChildrenProtect(boolean flag)
    {
        mChildrenFilter = flag;
    }

    public void addListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.add(listener);
        }
        return;
        listener;
        hashset;
        JVM INSTR monitorexit ;
        throw listener;
    }

    public int cancelSession()
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (mSession != null)
        {
            i = ((flag) ? 1 : 0);
            if (mSession.isActive())
            {
                i = (new AkCancellingWS(false)).call();
            }
        }
        return i;
    }

    public int createSessionFactory(boolean flag, int i, int j, String s, String s1, int k, boolean flag1, 
            boolean flag2, boolean flag3, int l, int i1)
    {
        return updateSessionFactory(flag, i, j, s, s1, k, flag1, flag2, flag3, l, i1);
    }

    public Context getApplicationContext()
    {
        return mAppContext;
    }

    public int getBaseLogiqueId()
    {
        return mBaseLogiqueId;
    }

    protected String getBaseUrlFromSessionFactory()
    {
        return mBaseUrlToGiveToWS;
    }

    public String getDeviceId()
    {
        String s;
        String s1;
        String s2;
        s1 = "";
        s2 = "";
        s = s1;
        Object obj = (TelephonyManager)mAppContext.getSystemService("phone");
        s = s1;
        s1 = (new StringBuilder()).append("").append(((TelephonyManager) (obj)).getDeviceId()).toString();
        s = s1;
        obj = (new StringBuilder()).append("").append(((TelephonyManager) (obj)).getSimSerialNumber()).toString();
        s2 = ((String) (obj));
        s = s1;
_L2:
        return (new UUID((new StringBuilder()).append("").append(android.provider.Settings.Secure.getString(mAppContext.getContentResolver(), "android_id")).toString().hashCode(), (long)s.hashCode() << 32 | (long)s2.hashCode())).toString();
        SecurityException securityexception;
        securityexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int getFreeGamesAllowed()
    {
        return mFreeGamesAllowed;
    }

    public int getHauteurPhoto()
    {
        return mHauteurPhoto;
    }

    public String getLabel()
    {
        return mLabel;
    }

    public String getLanguage()
    {
        return mLanguage;
    }

    public int getLargeurPhoto()
    {
        return mLargeurPhoto;
    }

    public String getMediaFootprint()
    {
        return mMediaFootprint;
    }

    public int getMediaId()
    {
        return mMediaId;
    }

    public int getPartnerId()
    {
        return mPartnerId;
    }

    public String getPlayerName()
    {
        if (mAppContext.getResources().getBoolean(R.bool.isTablet))
        {
            return "Android-Tab";
        } else
        {
            return "Android-Phone";
        }
    }

    public int getRankingLimit()
    {
        return mRankingLimit;
    }

    public Session getSession()
    {
        if (mSession != null)
        {
            return mSession;
        } else
        {
            return null;
        }
    }

    public int getTheme()
    {
        return mTheme;
    }

    public void handleWSCallCompleted(AkWebservice akwebservice)
    {
        if (akwebservice instanceof AkNewSessionWS)
        {
            akwebservice = (AkNewSessionWS)akwebservice;
            mSession = new Session(akwebservice.getChannel(), akwebservice.getSession(), akwebservice.getSignature(), akwebservice.isIsMinibaseActivated(), akwebservice.isIsOnlyMinibaseActivated());
            mSession.setActive(true);
            mSession.updateSessionState(akwebservice.getFirstQuestion(), akwebservice.getAnswears(), 0, 0.0F);
        } else
        if (akwebservice instanceof AkCancellingWS)
        {
            mSession.setActive(false);
            mSession.reset();
            return;
        }
    }

    public void init(Context context)
    {
        mAppContext = context;
        if (settings == null)
        {
            restoreAttributes();
        }
        if (mThreadVerifUrl == null)
        {
            launchThreadVerif();
        }
    }

    public boolean isChildProtect()
    {
        return mChildrenFilter;
    }

    public boolean isFast()
    {
        return mFast;
    }

    public boolean isPremium()
    {
        return mPremium;
    }

    public boolean isPrio()
    {
        return mPrio;
    }

    public void onActivityPause()
    {
        mCanCheckUrl = false;
    }

    public void onActivityResume()
    {
        mCanCheckUrl = true;
    }

    public void removeListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.remove(listener);
        }
        return;
        listener;
        hashset;
        JVM INSTR monitorexit ;
        throw listener;
    }

    public void setFast(boolean flag)
    {
        mFast = flag;
    }

    public int setLanguageWS(String s)
    {
        Object obj = languageLock;
        obj;
        JVM INSTR monitorenter ;
        int i = setLanguageWSPrivate(s);
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        updateBaseUrlToGiveToWC();
        obj;
        JVM INSTR monitorexit ;
        return i;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void setMediaFootprint(String s)
    {
        mMediaFootprint = s;
    }

    public void setMediaId(int i)
    {
        mMediaId = i;
    }

    public void setPartnerId(int i)
    {
        mPartnerId = i;
    }

    public void setPremium(boolean flag)
    {
        mPremium = flag;
    }

    public void setPrio(boolean flag)
    {
        mPrio = flag;
    }

    public int startSession()
    {
        if (mSession != null && mSession.isActive())
        {
            cancelSession();
        }
        boolean flag1 = false;
        boolean flag = flag1;
        if (mSessionFactoryBaseUrl != null)
        {
            flag = flag1;
            if (!mSessionFactoryBaseUrl.equals(mBaseUrlToGiveToWS))
            {
                flag = true;
                updateBaseUrlToGiveToWC();
            }
        }
        int i;
        for (i = (new AkNewSessionWS(flag, false, false)).call(); i == 700 || i == 400 || i == 500; i = (new AkNewSessionWS(flag, false, false)).call())
        {
            AkLog.d("SessionFactory", "startSession -> returns KO. Try to call WSC again...");
            i = setLanguageWS(mLanguage);
            if (i != 0)
            {
                AkLog.e("SessionFactory", "startSession -> AkNewSessionWS and setLanguageWS returns KO. Impossible to startSession");
                return i;
            }
            boolean flag2 = false;
            flag = flag2;
            if (mSessionFactoryBaseUrl == null)
            {
                continue;
            }
            flag = flag2;
            if (!mSessionFactoryBaseUrl.equals(mBaseUrlToGiveToWS))
            {
                flag = true;
                updateBaseUrlToGiveToWC();
            }
        }

        return i;
    }

    public int startSessionWithMinibase(boolean flag, boolean flag1)
    {
        if (mSession != null && mSession.isActive())
        {
            cancelSession();
        }
        boolean flag3 = false;
        boolean flag2 = flag3;
        if (mSessionFactoryBaseUrl != null)
        {
            flag2 = flag3;
            if (!mSessionFactoryBaseUrl.equals(mBaseUrlToGiveToWS))
            {
                flag2 = true;
                updateBaseUrlToGiveToWC();
            }
        }
        int i;
        for (i = (new AkNewSessionWS(flag2, flag, flag1)).call(); i == 700 || i == 400 || i == 500; i = (new AkNewSessionWS(flag2, flag, flag1)).call())
        {
            AkLog.d("SessionFactory", "startSession -> returns KO. Try to call WSC again...");
            i = setLanguageWS(mLanguage);
            if (i != 0)
            {
                AkLog.e("SessionFactory", "startSession -> AkNewSessionWS and setLanguageWS returns KO. Impossible to startSession");
                return i;
            }
            boolean flag4 = false;
            flag2 = flag4;
            if (mSessionFactoryBaseUrl == null)
            {
                continue;
            }
            flag2 = flag4;
            if (!mSessionFactoryBaseUrl.equals(mBaseUrlToGiveToWS))
            {
                flag2 = true;
                updateBaseUrlToGiveToWC();
            }
        }

        return i;
    }

    protected void updateBaseUrlToGiveToWC()
    {
        mBaseUrlToGiveToWS = mSessionFactoryBaseUrl;
        editor.putString("mSessionFactoryBaseUrl", mSessionFactoryBaseUrl);
        editor.putString("mBaseUrlToGiveToWS", mBaseUrlToGiveToWS);
        editor.commit();
    }

    public int updateSessionFactory(boolean flag, int i, int j, String s, String s1, int k, boolean flag1, 
            boolean flag2, boolean flag3, int l, int i1)
    {
        if (mAppContext == null)
        {
            return 100;
        } else
        {
            mChildrenFilter = flag;
            mPartnerId = i;
            mMediaId = j;
            mLanguage = s1;
            mTheme = k;
            mPrio = flag1;
            mPremium = flag2;
            mFast = flag3;
            mHauteurPhoto = l;
            mLargeurPhoto = i1;
            mMediaFootprint = s;
            saveAttributes();
            return setLanguageWS(s1);
        }
    }



    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
