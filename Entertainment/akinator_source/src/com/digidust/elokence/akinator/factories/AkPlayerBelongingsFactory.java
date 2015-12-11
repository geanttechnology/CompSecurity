// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import com.digidust.elokence.akinator.backup.AkBackupManager;
import com.elokence.limuleapi.TraductionFactory;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJViewListener;
import com.tapjoy.Tapjoy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkApplication, AkSessionFactory, AkLog

public class AkPlayerBelongingsFactory
    implements TJGetCurrencyBalanceListener, TJEarnedCurrencyListener, TJSpendCurrencyListener, TJConnectListener, TJViewListener
{
    public static interface Listener
    {

        public abstract void onAwardAwarded(int i);

        public abstract void onFacesAwarded(int i);

        public abstract void onGenizAwarded(int i);

        public abstract void onXpAwarded(int i);
    }


    public static final int AK_BACKGROUND_GZ[] = {
        0, 0, 15000, 0x124f8, 0x249f0
    };
    private static final String AK_BACKGROUND_INDEX = "backgroundIndex";
    public static final String AK_BACKGROUND_NAMES[] = {
        "orient", "japon", "farwest", "marin", "halloween"
    };
    private static final String AK_BANK_BALANCE = "akbankbalance";
    private static final String AK_CAN_DISPLAY_SHOP_AFTER_GAME_OVER = "canDisplayShopAfterGameOver";
    public static final int AK_CLOTH_GZ[] = {
        0, 0, 3000, 15000, 25000, 30000, 40000, 50000, 60000, 0x11170, 
        0x13880, 0x17318, 0x1adb0
    };
    private static final String AK_CLOTH_INDEX = "clothIndex";
    public static final String AK_CLOTH_NAMES[] = {
        "orient", "yukata", "rap", "chevalier", "scuba", "mexicain", "cowboy", "disco", "catcheur", "indien", 
        "dracula", "superheros", "pirate"
    };
    private static final String AK_FACES_BALANCE = "les_fafaces";
    public static final int AK_HAT_GZ[] = {
        0, 1000, 7000, 15000, 20000, 25000, 30000, 40000, 45000, 50000, 
        55000
    };
    private static final String AK_HAT_INDEX = "hatIndex";
    public static final String AK_HAT_NAMES[] = {
        "turban", "rap", "scuba", "chevalier", "elvis", "cowboy", "mexicain", "disco", "indien", "punk", 
        "pirate"
    };
    private static final String AK_THRESHOLD_POPULARITY = "lebigboss";
    private static final String AK_XP_BALANCE = "naheulbeuk";
    public static final String NOM_SHAREDPREFS = "bank";
    public static final String TYPE_BACKGROUND = "bg";
    public static final String TYPE_CLOTH = "cloth";
    public static final String TYPE_HAT = "hat";
    private static AkPlayerBelongingsFactory _instance = null;
    private static final int removePopularity2HoursCost1 = 100;
    private static final int removePopularity2HoursCost2 = 2000;
    private static final int removePopularity2HoursCost3 = 5000;
    private static final int removePopularity2HoursCost4 = 10000;
    private static final int removePopularity2HoursCost5 = 15000;
    private android.content.SharedPreferences.Editor editor;
    private int idNotif;
    private HashSet listeners;
    private int removeAdsCost;
    private int removeGameCountLimitCost;
    private int removePopularityAllTimeCost;
    private int removePopularityLimitCost;
    private SharedPreferences settings;
    private Queue waitingAlerts;

    private AkPlayerBelongingsFactory()
    {
        idNotif = 1;
        removeAdsCost = 100;
        removePopularityLimitCost = 50;
        removePopularityAllTimeCost = 0x186a0;
        listeners = new HashSet();
        waitingAlerts = new LinkedList();
        settings = AkApplication.getAppContext().getSharedPreferences("bank", 0);
        editor = settings.edit();
    }

    public static int getBackgroundGz(int i)
    {
        if (i < 0 || i > getNbHats())
        {
            return -1;
        } else
        {
            return AK_BACKGROUND_GZ[i];
        }
    }

    public static String getBackgroundName(int i)
    {
        if (i < 0 || i > getNbHats())
        {
            return null;
        } else
        {
            return AK_BACKGROUND_NAMES[i];
        }
    }

    public static int getClothGz(int i)
    {
        if (i < 0 || i > getNbCloths())
        {
            return -1;
        } else
        {
            return AK_CLOTH_GZ[i];
        }
    }

    public static String getClothName(int i)
    {
        if (i < 0 || i > getNbCloths())
        {
            return null;
        } else
        {
            return AK_CLOTH_NAMES[i];
        }
    }

    public static int getHatGz(int i)
    {
        if (i < 0 || i > getNbHats())
        {
            return -1;
        } else
        {
            return AK_HAT_GZ[i];
        }
    }

    public static String getHatName(int i)
    {
        if (i < 0 || i > getNbHats())
        {
            return null;
        } else
        {
            return AK_HAT_NAMES[i];
        }
    }

    public static int getNbBackgrounds()
    {
        return AK_BACKGROUND_NAMES.length;
    }

    public static int getNbCloths()
    {
        return AK_CLOTH_NAMES.length;
    }

    public static int getNbHats()
    {
        return AK_HAT_NAMES.length;
    }

    public static AkPlayerBelongingsFactory sharedInstance()
    {
        if (_instance == null)
        {
            _instance = new AkPlayerBelongingsFactory();
        }
        return _instance;
    }

    private void signalAwardAwarded(int i)
    {
        AkBackupManager.getInstance().setCanSave(true);
        HashSet hashset = listeners;
        hashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((Listener)iterator.next()).onAwardAwarded(i)) { }
        break MISSING_BLOCK_LABEL_54;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
    }

    private void signalFacesModified(int i)
    {
        AkBackupManager.getInstance().setCanSave(true);
        HashSet hashset = listeners;
        hashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((Listener)iterator.next()).onFacesAwarded(i)) { }
        break MISSING_BLOCK_LABEL_54;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
    }

    private void signalGenizModified(int i)
    {
        AkBackupManager.getInstance().setCanSave(true);
        HashSet hashset = listeners;
        hashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((Listener)iterator.next()).onGenizAwarded(i)) { }
        break MISSING_BLOCK_LABEL_54;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
    }

    private void signalXpModified(int i)
    {
        AkBackupManager.getInstance().setCanSave(true);
        AkSessionFactory.sharedInstance().setMustPublishScore(true);
        HashSet hashset = listeners;
        hashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((Listener)iterator.next()).onXpAwarded(i)) { }
        break MISSING_BLOCK_LABEL_61;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
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

    public void addXp(int i)
    {
        if (i <= 0)
        {
            return;
        } else
        {
            editor.putInt("naheulbeuk", getXp() + i);
            editor.commit();
            signalXpModified(i);
            return;
        }
    }

    public boolean canDisplayScreenShopAfterGameOver()
    {
        return settings.getBoolean("canDisplayShopAfterGameOver", true);
    }

    public void changeThresholdPopularity()
    {
        int i = settings.getInt("lebigboss", 100);
        if (i == 100)
        {
            editor.putInt("lebigboss", 2000);
            editor.commit();
        } else
        {
            if (i == 2000)
            {
                editor.putInt("lebigboss", 5000);
                editor.commit();
                return;
            }
            if (i == 5000)
            {
                editor.putInt("lebigboss", 10000);
                editor.commit();
                return;
            }
            if (i == 10000)
            {
                editor.putInt("lebigboss", 15000);
                editor.commit();
                return;
            }
        }
    }

    public boolean depositFaces(int i)
    {
        if (i <= 0)
        {
            return false;
        } else
        {
            int j = getFacesBalance();
            editor.putInt("les_fafaces", j + i);
            editor.commit();
            AkLog.d("Akinator", (new StringBuilder()).append("faces deposit ok : ").append(i).toString());
            Object obj = AkApplication.getAppContext();
            Object obj1 = TraductionFactory.sharedInstance().getTraductionFromToken("BRAVO_TU_AS_GAGNE_CREDITS_MYWORLD").replace("[NB_CREDITS]", (new StringBuilder()).append("").append(i).toString());
            obj1 = (new android.support.v4.app.NotificationCompat.Builder(((Context) (obj)))).setSmallIcon(0x7f020336).setContentTitle(" ").setContentText(((CharSequence) (obj1)));
            obj = (NotificationManager)((Context) (obj)).getSystemService("notification");
            j = idNotif;
            idNotif = j + 1;
            ((NotificationManager) (obj)).notify(j, ((android.support.v4.app.NotificationCompat.Builder) (obj1)).build());
            signalFacesModified(i);
            return true;
        }
    }

    public boolean depositGeniz(int i)
    {
        return depositGeniz(i, true);
    }

    public boolean depositGeniz(int i, boolean flag)
    {
        if (i <= 0)
        {
            return false;
        }
        int j = getGenizBalance();
        editor.putInt("akbankbalance", j + i);
        editor.commit();
        AkLog.d("Akinator", (new StringBuilder()).append("Geniz deposit ok : ").append(i).toString());
        if (flag)
        {
            waitingAlerts.add(Integer.valueOf(i));
            Object obj = AkApplication.getAppContext();
            Object obj1 = TraductionFactory.sharedInstance().getTraductionFromToken("BRAVO_TU_AS_GAGNE_GENIZ").replace("[NB_GENIZ]", (new StringBuilder()).append("").append(i).toString());
            obj1 = (new android.support.v4.app.NotificationCompat.Builder(((Context) (obj)))).setSmallIcon(0x7f020336).setContentTitle(" ").setContentText(((CharSequence) (obj1)));
            obj = (NotificationManager)((Context) (obj)).getSystemService("notification");
            int k = idNotif;
            idNotif = k + 1;
            ((NotificationManager) (obj)).notify(k, ((android.support.v4.app.NotificationCompat.Builder) (obj1)).build());
        }
        signalGenizModified(i);
        return true;
    }

    public boolean depositGenizWithoutNotif(int i)
    {
        return depositGeniz(i, false);
    }

    public void doNotDisplayScreenShopAnymore()
    {
        editor.putBoolean("canDisplayShopAfterGameOver", false);
        editor.commit();
    }

    public int getAlertGz()
    {
        if (waitingAlerts.isEmpty())
        {
            return -1;
        } else
        {
            return ((Integer)waitingAlerts.remove()).intValue();
        }
    }

    public int getCurrentBackgroundIndex()
    {
        return settings.getInt("backgroundIndex", 0);
    }

    public int getCurrentClothIndex()
    {
        return settings.getInt("clothIndex", 0);
    }

    public int getCurrentHatIndex()
    {
        return settings.getInt("hatIndex", 0);
    }

    public int getFacesBalance()
    {
        return settings.getInt("les_fafaces", 0);
    }

    public int getGenizBalance()
    {
        return settings.getInt("akbankbalance", 0);
    }

    public int getRemoveAdsCost()
    {
        return removeAdsCost;
    }

    public int getRemovePopularity2HoursCost()
    {
        return settings.getInt("lebigboss", 100);
    }

    public int getRemovePopularityAllTimeCost()
    {
        return removePopularityAllTimeCost;
    }

    public int getRemovePopularityLimitCost()
    {
        return removePopularityLimitCost;
    }

    public int getXp()
    {
        return settings.getInt("naheulbeuk", 0);
    }

    public boolean isItemBought(String s, String s1)
    {
        return settings.getBoolean((new StringBuilder()).append(s).append("_").append(s1).toString(), false);
    }

    public void onConnectFailure()
    {
        AkLog.d("AkinatorTapjoy", "Connect Failed");
    }

    public void onConnectSuccess()
    {
        AkLog.d("AkinatorTapjoy", "Connect OK");
        Tapjoy.setEarnedCurrencyListener(this);
        Tapjoy.setTapjoyViewListener(this);
    }

    public void onEarnedCurrency(String s, int i)
    {
        AkLog.d("AkinatorTapjoy", (new StringBuilder()).append("Earned Tap points : ").append(i).toString());
    }

    public void onGetCurrencyBalanceResponse(String s, int i)
    {
        AkLog.d("AkinatorTapjoy", (new StringBuilder()).append("Get Update Points : ").append(s).append(" ").append(i).toString());
        Tapjoy.spendCurrency(i, new _cls1(i));
    }

    public void onGetCurrencyBalanceResponseFailure(String s)
    {
        AkLog.d("AkinatorTapjoy", (new StringBuilder()).append("get update points failed : ").append(s).toString());
    }

    public void onSpendCurrencyResponse(String s, int i)
    {
        AkLog.d("AkinatorTapjoy", (new StringBuilder()).append("Get Spend Points rep : ").append(s).append(" ").append(i).toString());
    }

    public void onSpendCurrencyResponseFailure(String s)
    {
        AkLog.d("AkinatorTapjoy", (new StringBuilder()).append("Get Spend Points rep failed : ").append(s).toString());
    }

    public void onViewDidClose(int i)
    {
    }

    public void onViewDidOpen(int i)
    {
    }

    public void onViewWillClose(int i)
    {
    }

    public void onViewWillOpen(int i)
    {
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

    public void resetFaces()
    {
        int i = getFacesBalance();
        editor.putInt("les_fafaces", 0);
        editor.commit();
        signalFacesModified(-i);
    }

    public void restoreFaces(int i)
    {
        editor.putInt("les_fafaces", i);
        editor.commit();
    }

    public void restoreGz(int i)
    {
        editor.putInt("akbankbalance", i);
        editor.commit();
    }

    public void restoreXP(int i)
    {
        editor.putInt("naheulbeuk", i);
        editor.commit();
    }

    public void setCurrentBackgroundIndex(int i)
    {
        editor.putInt("backgroundIndex", i);
        editor.commit();
    }

    public void setCurrentClothIndex(int i)
    {
        editor.putInt("clothIndex", i);
        editor.commit();
    }

    public void setCurrentHatIndex(int i)
    {
        editor.putInt("hatIndex", i);
        editor.commit();
    }

    public void setItemBought(String s, String s1)
    {
        editor.putBoolean((new StringBuilder()).append(s).append("_").append(s1).toString(), true);
        editor.commit();
    }

    public boolean withdrawFaces()
    {
        if (getFacesBalance() <= 0)
        {
            return false;
        } else
        {
            int i = getFacesBalance();
            editor.putInt("les_fafaces", i - 1);
            editor.commit();
            signalFacesModified(-1);
            return true;
        }
    }

    public boolean withdrawGeniz(int i)
    {
        int j;
        if (i > 0)
        {
            if ((j = getGenizBalance() - i) >= 0)
            {
                editor.putInt("akbankbalance", j);
                editor.commit();
                signalGenizModified(-i);
                return true;
            }
        }
        return false;
    }


    /* member class not found */
    class _cls1 {}

}
