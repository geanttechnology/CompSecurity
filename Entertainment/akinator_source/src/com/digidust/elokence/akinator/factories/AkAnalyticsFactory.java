// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.content.Context;
import android.content.SharedPreferences;
import com.elokence.analytics.AnalyticsCenter;
import com.elokence.analytics.AnalyticsInitCallback;
import com.elokence.limuleapi.MinibaseFactory;
import java.util.TreeMap;

// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkApplication, AkGameFactory, AkFacesFactory, AkLog, 
//            AkConfigFactory

public class AkAnalyticsFactory
    implements AnalyticsInitCallback
{

    public static final String ABTEST_FACES_BOUTIQUE = "MWcredits";
    public static final String ABTEST_FACES_DEMARRAGE = "MWtry";
    protected static final String MSG_ACCEPTATION_PROCHE_MYWORLD = "ACCEPT_RELATIVE";
    protected static final String MSG_ACTIVITY_AJOUT_MYWORLD = "SCREEN_ADD_MW";
    protected static final String MSG_ACTIVITY_IDENTIFIE_MYWORLD = "LIST_RELATIVES";
    protected static final String MSG_ACTIVITY_MYWORLD = "ActivityMW";
    protected static final String MSG_ACTIVITY_PENSE_JOUER_PROCHE = "MSG_PLAY_RELATIVE";
    protected static final String MSG_ACTIVITY_PROPOSE_AJOUT_MYWORLD = "RELATIVE_PLAYED";
    protected static final String MSG_ACTIVITY_SHOP = "SHOP";
    protected static final String MSG_ACTIVITY_UNLOCK_POTION = "ActivityPotion";
    protected static final String MSG_AJOUT_MYWORLD = "ADD_RELATIVE";
    protected static final String MSG_CONFIRMATION_ACHAT_INAPP = "BUY_INAPP";
    protected static final String MSG_IDENTIFIE_MYWORLD = "SELECT_LIST";
    protected static final String MSG_OUVERTURE_ACHAT_INAPP = "OPEN_STORE";
    protected static final String MSG_OUVERTURE_APP = "FIRST_OPENING";
    protected static final String MSG_PARTIE_JOUEE = "PLAYED_GAME";
    protected static final String MSG_PROPOSE_ACHAT_CREDITS = "PROPOSE_PURCHASE";
    protected static final String MSG_PROPOSITION_PROCHE = "PropositionProcheGenerique";
    protected static final String MSG_PROPOSITION_PROCHE_MYWORLD = "FIND_RELATIVE";
    protected static final String MSG_SUPPR_BASE_MYWORLD = "DEL_MINIBASE";
    protected static final String MSG_SUPPR_PROCHE_MYWORLD = "DEL_RELATIVE";
    protected static final String TAG = "AkinatorAnalytics";
    private static AkAnalyticsFactory instance;
    SharedPreferences settings;

    private AkAnalyticsFactory()
    {
        settings = AkApplication.getAppContext().getSharedPreferences("AkAnal", 0);
    }

    public static AkAnalyticsFactory sharedInstance()
    {
        if (instance == null)
        {
            instance = new AkAnalyticsFactory();
        }
        return instance;
    }

    public void logAccepteProcheMW()
    {
        int i = settings.getInt("ACCEPT_RELATIVE", 0);
        if (i >= 5)
        {
            return;
        }
        Object obj = settings.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putInt("ACCEPT_RELATIVE", i + 1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        obj = new TreeMap();
        ((TreeMap) (obj)).put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames() - 1).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("ACCEPT_RELATIVE", ((java.util.Map) (obj)));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logAffichageAjoutProcheMW()
    {
        int i = settings.getInt("SCREEN_ADD_MW", 0);
        if (i >= 5)
        {
            return;
        }
        Object obj = settings.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putInt("SCREEN_ADD_MW", i + 1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        obj = new TreeMap();
        ((TreeMap) (obj)).put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("SCREEN_ADD_MW", ((java.util.Map) (obj)));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logAffichageMessageJoueProche()
    {
        TreeMap treemap = new TreeMap();
        treemap.put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("MSG_PLAY_RELATIVE", treemap);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logAffichagePropositionAchatCredits()
    {
        TreeMap treemap = new TreeMap();
        treemap.put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("PROPOSE_PURCHASE", treemap);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logAffichagePropositionAjoutMW()
    {
        int i = settings.getInt("RELATIVE_PLAYED", 0);
        if (i >= 5)
        {
            return;
        }
        Object obj = settings.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putInt("RELATIVE_PLAYED", i + 1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        obj = new TreeMap();
        ((TreeMap) (obj)).put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("RELATIVE_PLAYED", ((java.util.Map) (obj)));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logAffichageStoreActivity()
    {
        TreeMap treemap = new TreeMap();
        treemap.put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        treemap.put("CREDIT", (new StringBuilder()).append("").append(AkFacesFactory.sharedInstance().getBalance()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("SHOP", treemap);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logAffichageUnlockPotion()
    {
        TreeMap treemap = new TreeMap();
        treemap.put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("ActivityPotion", treemap);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logAfficheListeIdentificationMW()
    {
        int i = settings.getInt("LIST_RELATIVES", 0);
        if (i >= 5)
        {
            return;
        }
        Object obj = settings.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putInt("LIST_RELATIVES", i + 1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        obj = new TreeMap();
        ((TreeMap) (obj)).put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("LIST_RELATIVES", ((java.util.Map) (obj)));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logAjoutProcheMW(boolean flag)
    {
        TreeMap treemap = new TreeMap();
        treemap.put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        String s;
        if (flag)
        {
            s = "TRUE";
        } else
        {
            s = "FALSE";
        }
        treemap.put("HAS_PHOTO", s);
        treemap.put("MB", (new StringBuilder()).append("").append(MinibaseFactory.sharedInstance().getMinibid()).toString());
        treemap.put("CREDIT", (new StringBuilder()).append("").append(AkFacesFactory.sharedInstance().getBalance()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("ADD_RELATIVE", treemap);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logConfirmeAchatInApp(String s)
    {
        TreeMap treemap = new TreeMap();
        treemap.put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        treemap.put("INAPP", (new StringBuilder()).append("").append(s).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("BUY_INAPP", treemap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void logDebutAchatInApp(String s)
    {
        TreeMap treemap = new TreeMap();
        treemap.put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        treemap.put("INAPP", (new StringBuilder()).append("").append(s).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("OPEN_STORE", treemap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void logIdentifieProcheMW()
    {
        int i = settings.getInt("SELECT_LIST", 0);
        if (i >= 5)
        {
            return;
        }
        Object obj = settings.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putInt("SELECT_LIST", i + 1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        obj = new TreeMap();
        ((TreeMap) (obj)).put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("SELECT_LIST", ((java.util.Map) (obj)));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logListePersosMW()
    {
    }

    public void logOuvertureApp(boolean flag)
    {
        TreeMap treemap = new TreeMap();
        String s;
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        treemap.put("MAJ", s);
        try
        {
            AnalyticsCenter.getInstance().logEvent("FIRST_OPENING", treemap);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logPartieJouee()
    {
        if (settings.getInt("PLAYED_GAME", 0) == AkGameFactory.sharedInstance().getNbGames() + 1)
        {
            return;
        }
        TreeMap treemap = new TreeMap();
        treemap.put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames() + 1).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("PLAYED_GAME", treemap);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logSupprimeBaseMW()
    {
        TreeMap treemap = new TreeMap();
        treemap.put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        treemap.put("MB", (new StringBuilder()).append("").append(MinibaseFactory.sharedInstance().getMinibid()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("DEL_MINIBASE", treemap);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logSupprimeProcheMW()
    {
        TreeMap treemap = new TreeMap();
        treemap.put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("DEL_RELATIVE", treemap);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void logTrouveProcheMW()
    {
        int i = settings.getInt("FIND_RELATIVE", 0);
        if (i >= 5)
        {
            return;
        }
        Object obj = settings.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putInt("FIND_RELATIVE", i + 1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        obj = new TreeMap();
        ((TreeMap) (obj)).put("CPT", (new StringBuilder()).append("").append(AkGameFactory.sharedInstance().getNbGames()).toString());
        try
        {
            AnalyticsCenter.getInstance().logEvent("FIND_RELATIVE", ((java.util.Map) (obj)));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void onAnalyticsInitError()
    {
        AkLog.e("AkinatorAnalytics", "Analytics init error");
        String s = AnalyticsCenter.getInstance().getCampaign("MWcredits");
        AkLog.e("AkinatorAnalytics", (new StringBuilder()).append("facesBoutique : ").append(s).toString());
        if (s != null)
        {
            AkConfigFactory.sharedInstance().setInappPanel(s);
        }
    }

    public void onAnalyticsInitResponse()
    {
        AkLog.d("AkinatorAnalytics", "Analytics init response");
        String s = AnalyticsCenter.getInstance().getCampaign("MWcredits");
        AkLog.e("AkinatorAnalytics", (new StringBuilder()).append("facesBoutique : ").append(s).toString());
        if (s != null)
        {
            AkConfigFactory.sharedInstance().setInappPanel(s);
        }
    }
}
