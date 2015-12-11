// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.billing;

import android.app.Activity;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.elokence.analytics.MetricsSetAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.billing:
//            InappManagerImpl, AkInappListener

public class AkInappManager
{

    private static final String TAG = "AkInappManager";
    private static AkInappManager _instance = null;
    protected String descInappFaces[];
    protected String descInappFull;
    protected String descInappGeniz[];
    protected String descInappNoads;
    protected String descInappPopu;
    private InappManagerImpl impl;
    private HashSet listeners;
    protected String nomInappFull;
    protected String nomInappNoads;
    protected String nomInappPopu;
    protected String nomsInappFaces[];
    protected String nomsInappGeniz[];
    protected String priceInappFull;
    protected String priceInappNoads;
    protected String priceInappPopu;
    protected String pricesInappFaces[];
    protected String pricesInappGeniz[];
    protected int valuesInappFaces[];
    protected int valuesInappGeniz[];

    private AkInappManager()
    {
        listeners = new HashSet();
        nomInappNoads = null;
        descInappNoads = null;
        priceInappNoads = null;
        nomInappPopu = null;
        descInappPopu = null;
        priceInappPopu = null;
        nomInappFull = null;
        descInappFull = null;
        priceInappFull = null;
        impl = new InappManagerImpl();
    }

    public static AkInappManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new AkInappManager();
        }
        return _instance;
    }

    private int isFacesSku(String s)
    {
        return impl.isFacesSku(s);
    }

    private int isGzSku(String s)
    {
        return impl.isGzSku(s);
    }

    public void addListener(AkInappListener akinapplistener)
    {
        HashSet hashset = listeners;
        hashset;
        JVM INSTR monitorenter ;
        AkLog.w("AkInappManager", "Ajout d'un listener");
        if (akinapplistener == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        listeners.add(akinapplistener);
        hashset;
        JVM INSTR monitorexit ;
        return;
        akinapplistener;
        hashset;
        JVM INSTR monitorexit ;
        throw akinapplistener;
    }

    public String getDescInappFaces(int i)
    {
        return descInappFaces[i];
    }

    public String getDescInappGeniz(int i)
    {
        return descInappGeniz[i];
    }

    public String getDescInappNoads()
    {
        return descInappNoads;
    }

    public String getDescInappPopu()
    {
        return descInappPopu;
    }

    public String getDescInappUltime()
    {
        return descInappFull;
    }

    public int[] getListIdInappFaces()
    {
        return impl.getListIdInappFaces();
    }

    public int[] getListIdInappGeniz()
    {
        return impl.getListIdInappGeniz();
    }

    public String getNomInappFaces(int i)
    {
        return nomsInappFaces[i];
    }

    public String getNomInappGeniz(int i)
    {
        return nomsInappGeniz[i];
    }

    public String getNomInappNoads()
    {
        return nomInappNoads;
    }

    public String getNomInappPopu()
    {
        return nomInappPopu;
    }

    public String getNomInappUltime()
    {
        return nomInappFull;
    }

    public String getPriceInappFaces(int i)
    {
        return pricesInappFaces[i];
    }

    public String getPriceInappGeniz(int i)
    {
        return pricesInappGeniz[i];
    }

    public String getPriceInappNoads()
    {
        return priceInappNoads;
    }

    public String getPriceInappPopu()
    {
        return priceInappPopu;
    }

    public String getPriceInappUltime()
    {
        return priceInappFull;
    }

    public String getSkuInappFaces(int i)
    {
        return impl.skuInappFaces(i);
    }

    public String getSkuInappGeniz(int i)
    {
        return impl.skuInappGeniz(i);
    }

    public String getSkuInappNoads()
    {
        return "com.elokence.akinator.freemium.packads";
    }

    public String getSkuInappPopu()
    {
        return "com.elokence.akinator.freemium.packcharacters";
    }

    public String getSkuInappUltime()
    {
        return "com.digidust.elokence.akinator.freemium.full";
    }

    public int getValuesInappFaces(int i)
    {
        return valuesInappFaces[i];
    }

    public int getValuesInappGeniz(int i)
    {
        return valuesInappGeniz[i];
    }

    public void init()
    {
        impl.initImpl();
    }

    public boolean isInit()
    {
        return impl.isInitImpl();
    }

    public boolean purchaseInapp(String s, Activity activity)
    {
        return impl.purchaseInappImpl(s, activity);
    }

    public void removeListener(AkInappListener akinapplistener)
    {
        synchronized (listeners)
        {
            AkLog.w("AkInappManager", "Retrait d'un listener");
            listeners.remove(akinapplistener);
        }
        return;
        akinapplistener;
        hashset;
        JVM INSTR monitorexit ;
        throw akinapplistener;
    }

    public boolean requestAllPurchases()
    {
        return impl.requestAllPurchasesImpl();
    }

    public void requestInappDetailsUpdate()
    {
        impl.requestInappDetailsUpdateImpl();
    }

    public void requestLastPurchases()
    {
        impl.requestLastPurchasesImpl();
    }

    protected void signalAllPurchasesRestored()
    {
        HashSet hashset = listeners;
        hashset;
        JVM INSTR monitorenter ;
        AkLog.w("AkInappManager", "Signal All Purchases restored");
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AkInappListener)iterator.next()).onAllPurchasesRestored()) { }
        break MISSING_BLOCK_LABEL_53;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
    }

    protected void signalInitialised(boolean flag)
    {
        HashSet hashset = listeners;
        hashset;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder = (new StringBuilder()).append("Signal Initialised ");
        Object obj;
        if (flag)
        {
            obj = "TRUE";
        } else
        {
            obj = "FALSE";
        }
        AkLog.w("AkInappManager", stringbuilder.append(((String) (obj))).toString());
        for (obj = listeners.iterator(); ((Iterator) (obj)).hasNext(); ((AkInappListener)((Iterator) (obj)).next()).onInitialization(flag)) { }
        break MISSING_BLOCK_LABEL_88;
        obj;
        hashset;
        JVM INSTR monitorexit ;
        throw obj;
        hashset;
        JVM INSTR monitorexit ;
    }

    protected void signalItemPurchased(String s)
    {
        if (!s.contains(getSkuInappNoads()) && !s.contains(getSkuInappPopu()) && !s.contains(getSkuInappUltime())) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = Calendar.getInstance();
        obj1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (!s.contains(getSkuInappUltime())) goto _L4; else goto _L3
_L3:
        ((Calendar) (obj)).setTimeInMillis(Long.parseLong(AkGameFactory.sharedInstance().getDatePurchaseFull()));
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("date_achat_potion_ultime", ((SimpleDateFormat) (obj1)).format(((Calendar) (obj)).getTime()));
_L7:
        obj = listeners;
        obj;
        JVM INSTR monitorenter ;
        AkLog.w("AkInappManager", "Signal item purchased");
        for (obj1 = listeners.iterator(); ((Iterator) (obj1)).hasNext(); ((AkInappListener)((Iterator) (obj1)).next()).itemPurchased(s)) { }
        break MISSING_BLOCK_LABEL_343;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
_L4:
        if (!s.contains(getSkuInappPopu())) goto _L6; else goto _L5
_L5:
        ((Calendar) (obj)).setTimeInMillis(Long.parseLong(AkGameFactory.sharedInstance().getDatePurchasePopu()));
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("date_achat_potion_supercharged", ((SimpleDateFormat) (obj1)).format(((Calendar) (obj)).getTime()));
          goto _L7
_L6:
        if (!s.contains(getSkuInappNoads())) goto _L7; else goto _L8
_L8:
        ((Calendar) (obj)).setTimeInMillis(Long.parseLong(AkGameFactory.sharedInstance().getDatePurchaseNoAds()));
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("date_achat_radiant_potion", ((SimpleDateFormat) (obj1)).format(((Calendar) (obj)).getTime()));
          goto _L7
_L2:
        int i;
        AkLog.d("AkInappManager", (new StringBuilder()).append("check isGzSku ").append(s).toString());
        i = isGzSku(s);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                MetricsSetAdapter.sharedInstance().createOrUpdateMetricCompteur("gz_gain_inapp", getValuesInappGeniz(i));
            }
            catch (Exception exception) { }
        }
          goto _L7
        AkLog.d("AkInappManager", (new StringBuilder()).append("check isFacesSku ").append(s).toString());
        i = isFacesSku(s);
        if (i == -1) goto _L7; else goto _L9
_L9:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricCompteur("mw_inapp_purchased", getValuesInappFaces(i));
          goto _L7
        obj;
        JVM INSTR monitorexit ;
    }

    protected void signalUpdateSku()
    {
        HashSet hashset = listeners;
        hashset;
        JVM INSTR monitorenter ;
        AkLog.w("AkInappManager", "Signal update sku");
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AkInappListener)iterator.next()).skuDetailsUpdated()) { }
        break MISSING_BLOCK_LABEL_54;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
    }

}
