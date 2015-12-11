// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.billing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digidust.elokence.akinator.billing:
//            AkInappManager, InappPurchaseActivity

public class InappManagerImpl
{

    private static String INAPP_FACES_ID_PREFIX = null;
    private static String INAPP_GENIZ_ID_PREFIX = null;
    public static final String TAG = "AkInappManagerImpl";
    protected static final String skuInappFull = "com.digidust.elokence.akinator.freemium.full";
    protected static final String skuInappNoads = "com.elokence.akinator.freemium.packads";
    protected static final String skuInappPopu = "com.elokence.akinator.freemium.packcharacters";
    private int idInappFaces[] = {
        51, 22, 23, 82, 63, 21, 24, 83, 41, 12, 
        13, 72, 53, 11, 14, 73, 61, 81, 71, 32, 
        62, 52, 31
    };
    private int idInappGeniz[] = {
        1, 2, 3, 4, 5
    };
    private boolean isMyworldEnabled;
    IInAppBillingService mService;
    ServiceConnection mServiceConn;
    protected Set purchasedSkus;
    protected String skusInappFaces[];
    protected String skusInappGeniz[];

    protected InappManagerImpl()
    {
        mService = null;
        skusInappFaces = null;
        skusInappGeniz = null;
        mServiceConn = new ServiceConnection() {

            final InappManagerImpl this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                AkLog.w("AkInappManagerImpl", "Inapp service connected");
                mService = com.android.vending.billing.IInAppBillingService.Stub.asInterface(ibinder);
                AkInappManager.getInstance().signalInitialised(true);
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                AkLog.w("AkInappManagerImpl", "Inapp service disconnected");
                AkInappManager.getInstance().signalInitialised(false);
                mService = null;
            }

            
            {
                this$0 = InappManagerImpl.this;
                super();
            }
        };
        purchasedSkus = new TreeSet();
        isMyworldEnabled = true;
    }

    private int getFaceInappIndiceFromId(int i)
    {
        for (int j = 0; j < idInappFaces.length; j++)
        {
            if (i == idInappFaces[j])
            {
                return j;
            }
        }

        return -1;
    }

    protected final int[] getListIdInappFaces()
    {
        return idInappFaces;
    }

    protected final int[] getListIdInappGeniz()
    {
        return idInappGeniz;
    }

    public void inappActivityCallback(final InappPurchaseActivity caller, final String sku, final String token)
    {
        if (sku.startsWith(INAPP_FACES_ID_PREFIX))
        {
            (new AsyncTask() {

                final InappManagerImpl this$0;
                final InappPurchaseActivity val$caller;
                final String val$sku;
                final String val$token;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    String s;
                    int k;
                    avoid = "";
                    for (int i = 0; i < skusInappFaces.length; i++)
                    {
                        if (sku.equals(skusInappFaces[i]))
                        {
                            avoid = AkInappManager.getInstance().nomsInappFaces[i];
                        }
                    }

                    s = "";
                    for (int j = 0; j < avoid.length();)
                    {
                        String s1 = s;
                        if (Character.isDigit(avoid.charAt(j)))
                        {
                            s1 = (new StringBuilder()).append(s).append(avoid.charAt(j)).toString();
                        }
                        j++;
                        s = s1;
                    }

                    k = 0;
                    int l = Integer.parseInt(s);
                    k = l;
_L1:
                    try
                    {
                        if (mService.consumePurchase(3, caller.getPackageName(), token) == 0)
                        {
                            AkPlayerBelongingsFactory.sharedInstance().depositFaces(k);
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[]) { }
                    return null;
                    avoid;
                      goto _L1
                }

            
            {
                this$0 = InappManagerImpl.this;
                sku = s;
                caller = inapppurchaseactivity;
                token = s1;
                super();
            }
            }).execute(new Void[0]);
        } else
        if (sku.startsWith(INAPP_GENIZ_ID_PREFIX))
        {
            (new AsyncTask() {

                final InappManagerImpl this$0;
                final InappPurchaseActivity val$caller;
                final String val$sku;
                final String val$token;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    int i;
                    char c;
                    c = sku.charAt(sku.length() - 1);
                    i = 0;
                    c;
                    JVM INSTR tableswitch 49 53: default 56
                //                               49 93
                //                               50 99
                //                               51 105
                //                               52 111
                //                               53 117;
                       goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                    break; /* Loop/switch isn't completed */
_L6:
                    break MISSING_BLOCK_LABEL_117;
_L7:
                    try
                    {
                        if (mService.consumePurchase(3, caller.getPackageName(), token) == 0)
                        {
                            AkPlayerBelongingsFactory.sharedInstance().depositGeniz(i);
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[]) { }
                    return null;
_L2:
                    i = 45000;
                      goto _L7
_L3:
                    i = 0x1c138;
                      goto _L7
_L4:
                    i = 0x2f9b8;
                      goto _L7
_L5:
                    i = 0x4a768;
                      goto _L7
                    i = 0x704e0;
                      goto _L7
                }

            
            {
                this$0 = InappManagerImpl.this;
                sku = s;
                caller = inapppurchaseactivity;
                token = s1;
                super();
            }
            }).execute(new Void[0]);
        } else
        {
            purchasedSkus.add(sku);
        }
        AkInappManager.getInstance().signalItemPurchased(sku);
    }

    protected void initImpl()
    {
        AkLog.d("AkInappManagerImpl", "Init");
        if (isInitImpl())
        {
            AkInappManager.getInstance().signalInitialised(true);
            return;
        }
        if (AkConfigFactory.sharedInstance().isFreemium())
        {
            INAPP_FACES_ID_PREFIX = "com.elokence.akinator.freemium.myworld";
            INAPP_GENIZ_ID_PREFIX = "com.elokence.akinatorfree.packgeniz0";
        } else
        {
            INAPP_FACES_ID_PREFIX = "com.elokence.akinator.myworld";
            INAPP_GENIZ_ID_PREFIX = "com.elokence.akinator.packgeniz0";
        }
        skusInappFaces = new String[idInappFaces.length];
        skusInappGeniz = new String[idInappGeniz.length];
        AkInappManager.getInstance().valuesInappFaces = new int[idInappFaces.length];
        AkInappManager.getInstance().pricesInappFaces = new String[idInappFaces.length];
        AkInappManager.getInstance().nomsInappFaces = new String[idInappFaces.length];
        AkInappManager.getInstance().descInappFaces = new String[idInappFaces.length];
        AkInappManager.getInstance().valuesInappGeniz = new int[idInappGeniz.length];
        AkInappManager.getInstance().pricesInappGeniz = new String[idInappGeniz.length];
        AkInappManager.getInstance().nomsInappGeniz = new String[idInappGeniz.length];
        AkInappManager.getInstance().descInappGeniz = new String[idInappGeniz.length];
        for (int i = 0; i < idInappFaces.length; i++)
        {
            skusInappFaces[i] = (new StringBuilder()).append(INAPP_FACES_ID_PREFIX).append(idInappFaces[i]).toString();
        }

        for (int j = 0; j < idInappGeniz.length; j++)
        {
            skusInappGeniz[j] = (new StringBuilder()).append(INAPP_GENIZ_ID_PREFIX).append(idInappGeniz[j]).toString();
        }

        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        try
        {
            AkApplication.getAppContext().bindService(intent, mServiceConn, 1);
        }
        catch (Exception exception)
        {
            mService = null;
            AkLog.w("AkInappManagerImpl", "Erreur on connection Inapp service");
            AkInappManager.getInstance().signalInitialised(false);
        }
        (new AsyncTask() {

            final InappManagerImpl this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                try
                {
                    Thread.sleep(3000L);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
                AkLog.d("AkInappManagerImpl", "Timeout thread !");
                AkInappManager.getInstance().signalInitialised(isInitImpl());
                return null;
            }

            
            {
                this$0 = InappManagerImpl.this;
                super();
            }
        }).execute(new Void[0]);
    }

    protected int isFacesSku(String s)
    {
        for (int i = 0; i < skusInappFaces.length; i++)
        {
            if (s.equals(skusInappFaces[i]))
            {
                return i;
            }
        }

        return -1;
    }

    protected int isGzSku(String s)
    {
        for (int i = 0; i < skusInappGeniz.length; i++)
        {
            if (s.equals(skusInappGeniz[i]))
            {
                return i;
            }
        }

        return -1;
    }

    protected boolean isInitImpl()
    {
        return mService != null;
    }

    protected boolean purchaseInappImpl(String s, final Activity caller)
    {
        if (!isInitImpl())
        {
            return false;
        }
        if (purchasedSkus.contains(s))
        {
            return false;
        }
        try
        {
            s = (PendingIntent)mService.getBuyIntent(3, caller.getPackageName(), s, "inapp", "payload_not_used").getParcelable("BUY_INTENT");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (s == null)
        {
            return false;
        }
        InappPurchaseActivity.toLaunch = s;
        InappPurchaseActivity.caller = this;
        caller.runOnUiThread(new Runnable() {

            final InappManagerImpl this$0;
            final Activity val$caller;
            final Intent val$inappActivityIntent;

            public void run()
            {
                caller.startActivity(inappActivityIntent);
            }

            
            {
                this$0 = InappManagerImpl.this;
                caller = activity;
                inappActivityIntent = intent;
                super();
            }
        });
        return true;
    }

    protected boolean requestAllPurchasesImpl()
    {
        int i;
        if (!isInitImpl())
        {
            return false;
        }
        AkLog.w("AkInappManagerImpl", "PurchasingService : request all updates");
        Object obj;
        String s;
        String s1;
        String s2;
        Object obj1;
        try
        {
            obj = mService.getPurchases(3, AkApplication.getAppContext().getPackageName(), "inapp", null);
            i = ((Bundle) (obj)).getInt("RESPONSE_CODE");
        }
        catch (Exception exception)
        {
            AkLog.e("AkInappManagerImpl", "PurchasingService : request all updates FAILED");
            return false;
        }
        if (i != 0) goto _L2; else goto _L1
_L1:
        obj = ((Bundle) (obj)).getStringArrayList("INAPP_PURCHASE_DATA_LIST").iterator();
_L15:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_338;
        }
        s = (String)((Iterator) (obj)).next();
        obj1 = new JSONObject(s);
        s1 = ((JSONObject) (obj1)).getString("productId");
        s2 = ((JSONObject) (obj1)).getString("purchaseTime");
        obj1 = ((JSONObject) (obj1)).getString("purchaseState");
        AkLog.w("AkInappManagerImpl", (new StringBuilder()).append("PurchasingService : item purchased ").append(s).toString());
        if (!s1.equals("com.digidust.elokence.akinator.freemium.full")) goto _L4; else goto _L3
_L3:
        if (!((String) (obj1)).equals("0")) goto _L6; else goto _L5
_L5:
        AkGameFactory.sharedInstance().unlockGame();
        AkGameFactory.sharedInstance().setDatePurchaseFull(s2);
_L4:
        if (!s1.equals("com.elokence.akinator.freemium.packads")) goto _L8; else goto _L7
_L7:
        if (!((String) (obj1)).equals("0")) goto _L10; else goto _L9
_L9:
        AkGameFactory.sharedInstance().setAdsState(false);
        AkGameFactory.sharedInstance().setDatePurchaseNoAds(s2);
_L8:
        if (!s1.equals("com.elokence.akinator.freemium.packcharacters")) goto _L12; else goto _L11
_L11:
        if (!((String) (obj1)).equals("0")) goto _L14; else goto _L13
_L13:
        AkGameFactory.sharedInstance().setPopularityState(false);
        AkGameFactory.sharedInstance().setDatePurchasePopu(s2);
_L12:
        purchasedSkus.add(s1);
        AkInappManager.getInstance().signalItemPurchased(s1);
          goto _L15
_L6:
        AkGameFactory.sharedInstance().lockGame();
          goto _L4
_L10:
        AkGameFactory.sharedInstance().setAdsState(true);
          goto _L8
_L14:
        AkGameFactory.sharedInstance().setPopularityState(true);
          goto _L12
_L2:
        AkLog.w("AkInappManagerImpl", (new StringBuilder()).append("PurchasingService : response not OK : ").append(i).toString());
        return false;
        AkInappManager.getInstance().signalAllPurchasesRestored();
        return true;
          goto _L15
    }

    protected boolean requestInappDetailsUpdateImpl()
    {
        ArrayList arraylist;
        int l1;
        AkLog.d("AkInappManagerImpl", "Request Inapp Details");
        if (!isInitImpl())
        {
            return false;
        }
        AkLog.d("AkInappManagerImpl", "Request Inapp Details : init OK");
        arraylist = new ArrayList();
        if (isMyworldEnabled)
        {
            String as[] = skusInappFaces;
            int k1 = as.length;
            for (int i = 0; i < k1; i++)
            {
                arraylist.add(as[i]);
            }

            as = skusInappGeniz;
            k1 = as.length;
            for (int j = 0; j < k1; j++)
            {
                arraylist.add(as[j]);
            }

        }
        if (AkConfigFactory.sharedInstance().isFreemium())
        {
            arraylist.add("com.digidust.elokence.akinator.freemium.full");
            arraylist.add("com.elokence.akinator.freemium.packads");
            arraylist.add("com.elokence.akinator.freemium.packcharacters");
        }
        AkLog.d("AkInappManagerImpl", (new StringBuilder()).append("Skus demandes ").append(arraylist).toString());
        l1 = 0;
_L66:
        TreeMap treemap;
        TreeMap treemap1;
        TreeMap treemap2;
        if (l1 >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = new ArrayList();
        for (int k = l1; k < Math.min(l1 + 19, arraylist.size()); k++)
        {
            ((ArrayList) (obj)).add(arraylist.get(k));
        }

        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", ((ArrayList) (obj)));
        int l;
        try
        {
            AkLog.d("AkInappManagerImpl", (new StringBuilder()).append("Packagename pass\351 : ").append(AkApplication.getAppContext().getPackageName()).toString());
            obj = mService.getSkuDetails(3, AkApplication.getAppContext().getPackageName(), "inapp", bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            AkLog.e("AkInappManagerImpl", "Request Inapp Details : problem with getSkuDetails");
            return false;
        }
        l = ((Bundle) (obj)).getInt("RESPONSE_CODE");
        AkLog.d("AkInappManagerImpl", (new StringBuilder()).append("Request Inapp Details : getSkuDetails response ").append(l).toString());
        if (l != 0)
        {
            return false;
        }
        obj = ((Bundle) (obj)).getStringArrayList("DETAILS_LIST");
        treemap = new TreeMap();
        treemap1 = new TreeMap();
        treemap2 = new TreeMap();
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            String s2 = (String)((Iterator) (obj)).next();
            AkLog.d("AkInappManagerImpl", (new StringBuilder()).append("ThisResponse : ").append(s2).toString());
            try
            {
                Object obj1 = new JSONObject(s2);
                s2 = ((JSONObject) (obj1)).getString("productId");
                String s5 = ((JSONObject) (obj1)).getString("price");
                String s7 = ((JSONObject) (obj1)).getString("title");
                obj1 = ((JSONObject) (obj1)).getString("description");
                AkLog.d("AkInappManagerImpl", (new StringBuilder()).append("Request Inapp Details : object ").append(s2).append(" ").append(s7).append(" ").append(((String) (obj1))).append(" ").append(s5).toString());
                treemap.put(s2, s5);
                treemap1.put(s2, s7);
                treemap2.put(s2, obj1);
            }
            catch (JSONException jsonexception) { }
        }

        if (treemap1.get("com.elokence.akinator.freemium.packads") != null)
        {
            AkInappManager.getInstance().nomInappNoads = ((String)treemap1.get("com.elokence.akinator.freemium.packads")).replace("(Akinator the Genie FREE)", "");
            AkInappManager.getInstance().descInappNoads = (String)treemap2.get("com.elokence.akinator.freemium.packads");
            AkInappManager.getInstance().priceInappNoads = (String)treemap.get("com.elokence.akinator.freemium.packads");
        }
        if (treemap1.get("com.elokence.akinator.freemium.packcharacters") != null)
        {
            AkInappManager.getInstance().nomInappPopu = ((String)treemap1.get("com.elokence.akinator.freemium.packcharacters")).replace("(Akinator the Genie FREE)", "");
            AkInappManager.getInstance().descInappPopu = (String)treemap2.get("com.elokence.akinator.freemium.packcharacters");
            AkInappManager.getInstance().priceInappPopu = (String)treemap.get("com.elokence.akinator.freemium.packcharacters");
        }
        if (treemap1.get("com.digidust.elokence.akinator.freemium.full") != null)
        {
            AkInappManager.getInstance().nomInappFull = ((String)treemap1.get("com.digidust.elokence.akinator.freemium.full")).replace("(Akinator the Genie FREE)", "");
            AkInappManager.getInstance().descInappFull = (String)treemap2.get("com.digidust.elokence.akinator.freemium.full");
            AkInappManager.getInstance().priceInappFull = (String)treemap.get("com.digidust.elokence.akinator.freemium.full");
        }
        if (!isMyworldEnabled) goto _L2; else goto _L1
_L1:
        int i2 = 0;
_L54:
        if (i2 >= skusInappFaces.length) goto _L2; else goto _L3
_L3:
        if (treemap1.get(skusInappFaces[i2]) == null) goto _L5; else goto _L4
_L4:
        String s;
        String s4;
        int j1;
        AkInappManager.getInstance().nomsInappFaces[i2] = ((String)treemap1.get(skusInappFaces[i2])).replace("(Akinator the Genie FREE)", "").replace("(Akinator the Genie)", "");
        AkLog.d("AkInappManagerImpl", (new StringBuilder()).append("nomsInappFaces ").append(i2).append(" : ").append(AkInappManager.getInstance().nomsInappFaces[i2]).toString());
        AkInappManager.getInstance().descInappFaces[i2] = (String)treemap2.get(skusInappFaces[i2]);
        AkInappManager.getInstance().pricesInappFaces[i2] = (String)treemap.get(skusInappFaces[i2]);
        String s6 = AkInappManager.getInstance().nomsInappFaces[i2];
        s = "";
        for (int i1 = 0; i1 < s6.length();)
        {
            String s3 = s;
            if (Character.isDigit(s6.charAt(i1)))
            {
                s3 = (new StringBuilder()).append(s).append(s6.charAt(i1)).toString();
            }
            i1++;
            s = s3;
        }

        s4 = skusInappFaces[i2];
        j1 = -1;
        s4.hashCode();
        JVM INSTR lookupswitch 23: default 1232
    //                   -1414195984: 1577
    //                   -1414195983: 1509
    //                   -1414195982: 1526
    //                   -1414195981: 1594
    //                   -1414195953: 1442
    //                   -1414195952: 1378
    //                   -1414195951: 1394
    //                   -1414195950: 1458
    //                   -1414195922: 1730
    //                   -1414195921: 1679
    //                   -1414195891: 1492
    //                   -1414195860: 1362
    //                   -1414195859: 1713
    //                   -1414195858: 1560
    //                   -1414195829: 1628
    //                   -1414195828: 1696
    //                   -1414195827: 1426
    //                   -1414195798: 1662
    //                   -1414195797: 1543
    //                   -1414195796: 1611
    //                   -1414195767: 1645
    //                   -1414195766: 1410
    //                   -1414195765: 1475;
           goto _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29
_L6:
        j1;
        JVM INSTR tableswitch 0 22: default 1340
    //                   0 1747
    //                   1 1761
    //                   2 1775
    //                   3 1789
    //                   4 1803
    //                   5 1817
    //                   6 1830
    //                   7 1844
    //                   8 1858
    //                   9 1872
    //                   10 1886
    //                   11 1900
    //                   12 1914
    //                   13 1928
    //                   14 1941
    //                   15 1955
    //                   16 1969
    //                   17 1983
    //                   18 1997
    //                   19 2011
    //                   20 2025
    //                   21 2039
    //                   22 2053;
           goto _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53
_L30:
        AkInappManager.getInstance().valuesInappFaces[i2] = Integer.parseInt(s);
_L5:
        i2++;
          goto _L54
_L18:
        if (s4.equals("com.elokence.akinator.myworld51"))
        {
            j1 = 0;
        }
          goto _L6
_L12:
        if (s4.equals("com.elokence.akinator.myworld22"))
        {
            j1 = 1;
        }
          goto _L6
_L13:
        if (s4.equals("com.elokence.akinator.myworld23"))
        {
            j1 = 2;
        }
          goto _L6
_L28:
        if (s4.equals("com.elokence.akinator.myworld82"))
        {
            j1 = 3;
        }
          goto _L6
_L23:
        if (s4.equals("com.elokence.akinator.myworld63"))
        {
            j1 = 4;
        }
          goto _L6
_L11:
        if (s4.equals("com.elokence.akinator.myworld21"))
        {
            j1 = 5;
        }
          goto _L6
_L14:
        if (s4.equals("com.elokence.akinator.myworld24"))
        {
            j1 = 6;
        }
          goto _L6
_L29:
        if (s4.equals("com.elokence.akinator.myworld83"))
        {
            j1 = 7;
        }
          goto _L6
_L17:
        if (s4.equals("com.elokence.akinator.myworld41"))
        {
            j1 = 8;
        }
          goto _L6
_L8:
        if (s4.equals("com.elokence.akinator.myworld12"))
        {
            j1 = 9;
        }
          goto _L6
_L9:
        if (s4.equals("com.elokence.akinator.myworld13"))
        {
            j1 = 10;
        }
          goto _L6
_L25:
        if (s4.equals("com.elokence.akinator.myworld72"))
        {
            j1 = 11;
        }
          goto _L6
_L20:
        if (s4.equals("com.elokence.akinator.myworld53"))
        {
            j1 = 12;
        }
          goto _L6
_L7:
        if (s4.equals("com.elokence.akinator.myworld11"))
        {
            j1 = 13;
        }
          goto _L6
_L10:
        if (s4.equals("com.elokence.akinator.myworld14"))
        {
            j1 = 14;
        }
          goto _L6
_L26:
        if (s4.equals("com.elokence.akinator.myworld73"))
        {
            j1 = 15;
        }
          goto _L6
_L21:
        if (s4.equals("com.elokence.akinator.myworld61"))
        {
            j1 = 16;
        }
          goto _L6
_L27:
        if (s4.equals("com.elokence.akinator.myworld81"))
        {
            j1 = 17;
        }
          goto _L6
_L24:
        if (s4.equals("com.elokence.akinator.myworld71"))
        {
            j1 = 18;
        }
          goto _L6
_L16:
        if (s4.equals("com.elokence.akinator.myworld32"))
        {
            j1 = 19;
        }
          goto _L6
_L22:
        if (s4.equals("com.elokence.akinator.myworld62"))
        {
            j1 = 20;
        }
          goto _L6
_L19:
        if (s4.equals("com.elokence.akinator.myworld52"))
        {
            j1 = 21;
        }
          goto _L6
_L15:
        if (s4.equals("com.elokence.akinator.myworld31"))
        {
            j1 = 22;
        }
          goto _L6
_L31:
        AkInappManager.getInstance().valuesInappFaces[i2] = 10;
          goto _L5
_L32:
        AkInappManager.getInstance().valuesInappFaces[i2] = 15;
          goto _L5
_L33:
        AkInappManager.getInstance().valuesInappFaces[i2] = 25;
          goto _L5
_L34:
        AkInappManager.getInstance().valuesInappFaces[i2] = 40;
          goto _L5
_L35:
        AkInappManager.getInstance().valuesInappFaces[i2] = 45;
          goto _L5
_L36:
        AkInappManager.getInstance().valuesInappFaces[i2] = 5;
          goto _L5
_L37:
        AkInappManager.getInstance().valuesInappFaces[i2] = 50;
          goto _L5
_L38:
        AkInappManager.getInstance().valuesInappFaces[i2] = 65;
          goto _L5
_L39:
        AkInappManager.getInstance().valuesInappFaces[i2] = 10;
          goto _L5
_L40:
        AkInappManager.getInstance().valuesInappFaces[i2] = 15;
          goto _L5
_L41:
        AkInappManager.getInstance().valuesInappFaces[i2] = 25;
          goto _L5
_L42:
        AkInappManager.getInstance().valuesInappFaces[i2] = 40;
          goto _L5
_L43:
        AkInappManager.getInstance().valuesInappFaces[i2] = 45;
          goto _L5
_L44:
        AkInappManager.getInstance().valuesInappFaces[i2] = 5;
          goto _L5
_L45:
        AkInappManager.getInstance().valuesInappFaces[i2] = 50;
          goto _L5
_L46:
        AkInappManager.getInstance().valuesInappFaces[i2] = 65;
          goto _L5
_L47:
        AkInappManager.getInstance().valuesInappFaces[i2] = 10;
          goto _L5
_L48:
        AkInappManager.getInstance().valuesInappFaces[i2] = 15;
          goto _L5
_L49:
        AkInappManager.getInstance().valuesInappFaces[i2] = 15;
          goto _L5
_L50:
        AkInappManager.getInstance().valuesInappFaces[i2] = 15;
          goto _L5
_L51:
        AkInappManager.getInstance().valuesInappFaces[i2] = 25;
          goto _L5
_L52:
        AkInappManager.getInstance().valuesInappFaces[i2] = 25;
          goto _L5
_L53:
        AkInappManager.getInstance().valuesInappFaces[i2] = 5;
          goto _L5
_L2:
        j1 = 0;
_L64:
        if (j1 >= skusInappGeniz.length) goto _L56; else goto _L55
_L55:
        if (treemap1.get(skusInappGeniz[j1]) == null) goto _L58; else goto _L57
_L57:
        AkInappManager.getInstance().nomsInappGeniz[j1] = ((String)treemap1.get(skusInappGeniz[j1])).replace("(Akinator the Genie FREE)", "").replace("(Akinator the Genie)", "");
        AkLog.d("AkInappManagerImpl", (new StringBuilder()).append("nomsInappGeniz ").append(j1).append(" : ").append(AkInappManager.getInstance().nomsInappGeniz[j1]).toString());
        AkInappManager.getInstance().descInappGeniz[j1] = (String)treemap2.get(skusInappGeniz[j1]);
        AkInappManager.getInstance().pricesInappGeniz[j1] = (String)treemap.get(skusInappGeniz[j1]);
        String s1 = AkInappManager.getInstance().nomsInappGeniz[j1];
        AkInappManager.getInstance().valuesInappGeniz[j1] = 0;
        skusInappGeniz[j1].charAt(skusInappGeniz[j1].length() - 1);
        JVM INSTR tableswitch 49 53: default 2304
    //                   49 2313
    //                   50 2328
    //                   51 2343
    //                   52 2358
    //                   53 2373;
           goto _L58 _L59 _L60 _L61 _L62 _L63
_L58:
        j1++;
          goto _L64
_L59:
        AkInappManager.getInstance().valuesInappGeniz[j1] = 45000;
          goto _L58
_L60:
        AkInappManager.getInstance().valuesInappGeniz[j1] = 0x1c138;
          goto _L58
_L61:
        AkInappManager.getInstance().valuesInappGeniz[j1] = 0x2f9b8;
          goto _L58
_L62:
        AkInappManager.getInstance().valuesInappGeniz[j1] = 0x4a768;
          goto _L58
_L63:
        AkInappManager.getInstance().valuesInappGeniz[j1] = 0x704e0;
          goto _L58
_L56:
        l1 += 19;
        if (true) goto _L66; else goto _L65
_L65:
        AkLog.w("AkInappManagerImpl", "PurchasingService : getProductData");
        AkInappManager.getInstance().signalUpdateSku();
        return true;
    }

    protected boolean requestLastPurchasesImpl()
    {
        AkLog.w("AkInappManagerImpl", "PurchasingService : request last updates");
        return requestAllPurchasesImpl();
    }

    protected String skuInappFaces(int i)
    {
        Object obj = null;
        int j = 0;
        do
        {
label0:
            {
                String s = obj;
                if (j < idInappFaces.length)
                {
                    if (idInappFaces[j] != i)
                    {
                        break label0;
                    }
                    s = obj;
                    if (skusInappFaces.length > j)
                    {
                        s = skusInappFaces[j];
                    }
                }
                return s;
            }
            j++;
        } while (true);
    }

    protected String skuInappGeniz(int i)
    {
        Object obj = null;
        int j = 0;
        do
        {
label0:
            {
                String s = obj;
                if (j < idInappGeniz.length)
                {
                    if (idInappGeniz[j] != i)
                    {
                        break label0;
                    }
                    s = obj;
                    if (skusInappGeniz.length > j)
                    {
                        s = skusInappGeniz[j];
                    }
                }
                return s;
            }
            j++;
        } while (true);
    }

}
