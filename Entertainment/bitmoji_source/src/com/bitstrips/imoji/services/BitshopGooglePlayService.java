// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

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
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.BitshopPack;
import com.bitstrips.imoji.models.JSONStringPayload;
import com.bitstrips.imoji.util.PreferenceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class BitshopGooglePlayService
{
    public static interface PacksListener
    {

        public abstract void onErrorConnectingToGooglePlay();

        public abstract void onErrorPurchasingPack(int i);

        public abstract void onPacksSynced();
    }


    protected static final int BILLING_RESPONSE_OK = 0;
    private static final String BITSHOP_PURCHASED_DATA_ID = "application_pack_store_id";
    private static final String BITSHOP_PURCHASED_DATA_RECEIPT = "receipt";
    private static final String BITSHOP_PURCHASED_DATA_ROOT = "purchase_pack";
    protected static final int IAB_API_VERSION = 3;
    protected static final String IAB_INTENT_ACTION = "com.android.vending.billing.InAppBillingService.BIND";
    protected static final String IAB_INTENT_PACKAGE = "com.android.vending";
    protected static final String IAB_PURCHASED_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    protected static final String IAB_PURCHASE_ONE_TIME = "inapp";
    protected static final String IAB_SKU_DETAILS = "DETAILS_LIST";
    protected static final String IAB_SKU_ID = "productId";
    protected static final String IAB_SKU_ITEM_LIST = "ITEM_ID_LIST";
    protected static final String IAB_SKU_PRICE = "price";
    public static final String IAB_SKU_RESPONSE = "RESPONSE_CODE";
    public static final int PURCHASE_REQUEST_CODE = 1001;
    private static final String TAG = "BitshopGooglePlayServ";
    public static final String UNIVERSAL_PACK_ID = "universal_pack_id";
    AnalyticsService analytics;
    BitstripsService bitstripsService;
    private final String facebookAppBusinessId;
    FacebookService facebookService;
    private ArrayList listeners;
    private IInAppBillingService mService;
    private ServiceConnection mServiceConn;
    private final String packageName;
    HashMap packsMap;
    PreferenceUtils preferenceUtils;
    private String startedPurchaseID;
    TemplatesManager templatesManager;

    public BitshopGooglePlayService(Context context)
    {
        ((InjectorApplication)context).inject(this);
        packageName = context.getPackageName();
        facebookAppBusinessId = context.getString(0x7f060017);
        listeners = new ArrayList();
    }

    private void augmentPacksDataWithGoogleStoreDetails(Bundle bundle)
    {
        bundle = bundle.getStringArrayList("DETAILS_LIST").iterator();
_L2:
        Object obj;
        if (!bundle.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)bundle.next();
        Object obj1;
        obj1 = new JSONObject(((String) (obj)));
        obj = ((JSONObject) (obj1)).getString("productId");
        obj1 = ((JSONObject) (obj1)).getString("price");
        obj = (BitshopPack)packsMap.get(obj);
        if (obj != null)
        {
            try
            {
                ((BitshopPack) (obj)).setPrice(((String) (obj1)));
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void augmentPacksDataWithGoogleStorePurchases(Bundle bundle)
    {
        bundle = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST").iterator();
        do
        {
            if (!bundle.hasNext())
            {
                break;
            }
            String s = (String)bundle.next();
            BitshopPack bitshoppack = (BitshopPack)packsMap.get(s);
            if (bitshoppack != null && !((BitshopPack)packsMap.get(s)).isPurchased())
            {
                bitshoppack.setPurchased();
                createFakePurchase(s);
            }
        } while (true);
    }

    private void createFakePurchase(String s)
    {
        try
        {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("Message", "Receipt generated to sync Google Play with Bitshop");
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("application_pack_store_id", s);
            jsonobject.put("receipt", jsonobject1);
            s = new JSONObject();
            s.put("purchase_pack", jsonobject);
            savePackPurchase(s.toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("BitshopGooglePlayServ", "Failed to create fake data.");
        }
        s.printStackTrace();
    }

    private void onErrorConnectingToGooglePlay()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PacksListener)(Activity)iterator.next()).onErrorConnectingToGooglePlay()) { }
    }

    private void onErrorPurchasingPack(int i)
    {
        analytics.sendEvent(Category.BITSHOP, Action.PURCHASE_FAILED, startedPurchaseID);
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PacksListener)(Activity)iterator.next()).onErrorPurchasingPack(i)) { }
    }

    private void onPacksSynced()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PacksListener)(Activity)iterator.next()).onPacksSynced()) { }
    }

    private void savePackPurchase(final String payload)
    {
        String s = preferenceUtils.getString(0x7f06003a, "");
        bitstripsService.purchasePack("android", facebookService.getToken(), s, facebookAppBusinessId, new JSONStringPayload(payload), new Callback() {

            final BitshopGooglePlayService this$0;
            final String val$payload;

            public void failure(RetrofitError retrofiterror)
            {
                Log.e("BitshopGooglePlayServ", retrofiterror.toString());
                onErrorPurchasingPack(0x7f060033);
                try
                {
                    retrofiterror = (new JSONObject(payload)).getJSONObject("purchase_pack").getString("application_pack_store_id");
                    ((BitshopPack)packsMap.get(retrofiterror)).setUnpurchased();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (RetrofitError retrofiterror)
                {
                    Log.e("BitshopGooglePlayServ", "Failed to create or get product ID from payload JSON object");
                }
                retrofiterror.printStackTrace();
            }

            public volatile void success(Object obj, Response response)
            {
                success((Void)obj, response);
            }

            public void success(Void void1, Response response)
            {
                synchronizeWithGooglePlay();
            }

            
            {
                this$0 = BitshopGooglePlayService.this;
                payload = s;
                super();
            }
        });
    }

    private void synchronizeWithGooglePlay()
    {
        if (mService == null)
        {
            return;
        }
        Object obj = new ArrayList();
        ((ArrayList) (obj)).addAll(packsMap.keySet());
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", ((ArrayList) (obj)));
        int i;
        try
        {
            obj = mService.getSkuDetails(3, packageName, "inapp", bundle);
            bundle = mService.getPurchases(3, packageName, "inapp", null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((RemoteException) (obj)).printStackTrace();
            onErrorConnectingToGooglePlay();
            return;
        }
        i = ((Bundle) (obj)).getInt("RESPONSE_CODE");
        if (i != 0)
        {
            onErrorConnectingToGooglePlay();
            Log.e("BitshopGooglePlayServ", (new StringBuilder()).append("Couldn't fetch product from Google Play. Error code: ").append(i).toString());
            return;
        } else
        {
            augmentPacksDataWithGoogleStoreDetails(((Bundle) (obj)));
            augmentPacksDataWithGoogleStorePurchases(bundle);
            onPacksSynced();
            return;
        }
    }

    public void addListener(final Activity a)
    {
        listeners.add(a);
        (new AsyncTask() {

            final BitshopGooglePlayService this$0;
            final Activity val$a;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                if (mServiceConn == null)
                {
                    mServiceConn = getBillingServiceConnection();
                }
                avoid = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                avoid.setPackage("com.android.vending");
                a.bindService(avoid, mServiceConn, 1);
                return null;
            }

            
            {
                this$0 = BitshopGooglePlayService.this;
                a = activity;
                super();
            }
        }).execute(new Void[0]);
    }

    public ServiceConnection getBillingServiceConnection()
    {
        return new ServiceConnection() {

            final BitshopGooglePlayService this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                Log.d("BitshopGooglePlayServ", "Billing Service Connected");
                mService = com.android.vending.billing.IInAppBillingService.Stub.asInterface(ibinder);
                packsMap = new HashMap();
                for (componentname = templatesManager.getPacks().iterator(); componentname.hasNext(); packsMap.put(ibinder.getApplicationPackStoreId(), ibinder))
                {
                    ibinder = (BitshopPack)componentname.next();
                }

                synchronizeWithGooglePlay();
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mService = null;
            }

            
            {
                this$0 = BitshopGooglePlayService.this;
                super();
            }
        };
    }

    public IInAppBillingService getService()
    {
        return mService;
    }

    public void processIABResponse(int i, Intent intent)
    {
        if (i == 0)
        {
            analytics.sendEvent(Category.BITSHOP, Action.PURCHASE_CANCELLED, startedPurchaseID);
        } else
        if (i == -1)
        {
            Object obj1 = intent.getStringExtra("INAPP_PURCHASE_DATA");
            Object obj = intent.getStringExtra("INAPP_DATA_SIGNATURE");
            try
            {
                obj1 = new JSONObject(((String) (obj1)));
                intent = ((JSONObject) (obj1)).getString("productId");
                ((JSONObject) (obj1)).put("signature", obj);
                obj = new JSONObject();
                ((JSONObject) (obj)).put("application_pack_store_id", intent);
                ((JSONObject) (obj)).put("receipt", obj1);
                obj1 = new JSONObject();
                ((JSONObject) (obj1)).put("purchase_pack", obj);
                ((BitshopPack)packsMap.get(intent)).setPurchased();
                analytics.sendEvent(Category.BITSHOP, Action.PURCHASE_COMPLETED, String.valueOf(((BitshopPack)packsMap.get(intent)).getUniversalPackId()));
                savePackPurchase(((JSONObject) (obj1)).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.e("BitshopGooglePlayServ", "Failed to parse purchase data.");
            }
            intent.printStackTrace();
            return;
        }
    }

    public void removeListener(Activity activity)
    {
        listeners.remove(activity);
        if (mServiceConn != null)
        {
            Log.d("BitshopGooglePlayServ", "Unbinding ServiceConnection");
            activity.unbindService(mServiceConn);
        }
    }

    public void startPackPurchase(Activity activity, BitshopPack bitshoppack)
    {
        if (mService != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (bitshoppack.isFree() && !bitshoppack.isPurchased())
        {
            bitshoppack.setPurchased();
            createFakePurchase(bitshoppack.getApplicationPackStoreId());
            return;
        }
        PendingIntent pendingintent = (PendingIntent)mService.getBuyIntent(3, packageName, bitshoppack.getApplicationPackStoreId(), "inapp", "dev_string").getParcelable("BUY_INTENT");
        if (pendingintent == null) goto _L1; else goto _L3
_L3:
        startedPurchaseID = String.valueOf(bitshoppack.getUniversalPackId());
        analytics.sendEvent(Category.BITSHOP, Action.PURCHASE_STARTED, startedPurchaseID);
        try
        {
            activity.startIntentSenderForResult(pendingintent.getIntentSender(), 1001, new Intent(), 0, 0, 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity) { }
        try
        {
            activity.printStackTrace();
            onErrorPurchasingPack(0x7f060031);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            activity.printStackTrace();
        }
        onErrorPurchasingPack(0x7f060031);
        return;
    }


/*
    static IInAppBillingService access$002(BitshopGooglePlayService bitshopgoogleplayservice, IInAppBillingService iinappbillingservice)
    {
        bitshopgoogleplayservice.mService = iinappbillingservice;
        return iinappbillingservice;
    }

*/




/*
    static ServiceConnection access$202(BitshopGooglePlayService bitshopgoogleplayservice, ServiceConnection serviceconnection)
    {
        bitshopgoogleplayservice.mServiceConn = serviceconnection;
        return serviceconnection;
    }

*/

}
