// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.AmazonActivity;
import com.amazon.now.AppExtensionsInitializer;
import com.amazon.now.account.SSO;
import com.amazon.now.account.User;
import com.amazon.now.cart.CartController;
import com.amazon.now.location.LocaleManager;
import com.amazon.now.location.Location;
import com.amazon.now.location.Store;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.util:
//            DataStore, AppUtils, ImageUtil, WeblabUtil, 
//            NetUtil

public class LocationUtil
{
    private static class StoreFetcherTask extends AsyncTask
    {

        private com.amazon.now.location.Store.StoreFetchCallback mCallback;
        private Context mContext;

        private boolean processCopperfieldStoresData(JSONObject jsonobject)
        {
            jsonobject = jsonobject.optJSONArray("stores");
            if (jsonobject != null)
            {
                jsonobject = jsonobject.toString();
                if (Location.saveStores(jsonobject))
                {
                    LocationUtil.parseStores(jsonobject);
                    LocationUtil.sSearchAliasWhitelist = null;
                    return true;
                }
            }
            return false;
        }

        private boolean processRestaurantsData(JSONObject jsonobject)
        {
            jsonobject = jsonobject.optJSONObject("restaurantsInfo");
            if (jsonobject != null)
            {
                boolean flag = jsonobject.optBoolean("restaurantsEnabled");
                if (flag != LocationUtil.isRestaurantsEnabled())
                {
                    LocationUtil.setRestaurantsEnabled(flag);
                    return true;
                }
            }
            return false;
        }

        private void processWeblabTreatment(JSONObject jsonobject)
        {
            jsonobject = jsonobject.optJSONArray("weblabs");
            if (jsonobject != null)
            {
                WeblabUtil.saveTreatment(jsonobject.toString());
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            Object obj;
            Object obj1;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            avoid = Uri.parse(AppUtils.getServiceUrl(mContext)).buildUpon();
            avoid.appendPath("api").appendPath("store").appendPath("by-session-id");
            obj9 = avoid.build().toString();
            obj7 = null;
            obj8 = null;
            avoid = null;
            obj6 = null;
            obj4 = null;
            obj5 = null;
            obj2 = avoid;
            obj = obj7;
            obj1 = obj4;
            obj3 = obj8;
            obj9 = NetUtil.getURLConnection(((String) (obj9)));
            obj2 = avoid;
            obj = obj7;
            obj1 = obj4;
            obj3 = obj8;
            ((URLConnection) (obj9)).setConnectTimeout(5000);
            obj2 = avoid;
            obj = obj7;
            obj1 = obj4;
            obj3 = obj8;
            avoid = ((URLConnection) (obj9)).getInputStream();
            obj2 = avoid;
            obj = avoid;
            obj1 = obj4;
            obj3 = avoid;
            obj4 = new BufferedReader(new InputStreamReader(avoid, Charset.forName("UTF-8")));
            obj = new StringBuilder();
_L3:
            obj1 = ((BufferedReader) (obj4)).readLine();
            if (obj1 == null) goto _L2; else goto _L1
_L1:
            ((StringBuilder) (obj)).append(((String) (obj1)).trim());
              goto _L3
            obj;
            obj2 = obj4;
            obj4 = obj;
_L9:
            obj = avoid;
            obj1 = obj2;
            Log.e(LocationUtil.TAG, ((MalformedURLException) (obj4)).toString(), ((Throwable) (obj4)));
            if (avoid != null)
            {
                try
                {
                    avoid.close();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    Log.e(LocationUtil.TAG, avoid.toString(), avoid);
                }
            }
            if (obj2 != null)
            {
                try
                {
                    ((BufferedReader) (obj2)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    Log.e(LocationUtil.TAG, avoid.toString(), avoid);
                }
            }
_L4:
            return null;
_L2:
            obj = ((StringBuilder) (obj)).toString();
            if (avoid != null)
            {
                try
                {
                    avoid.close();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    Log.e(LocationUtil.TAG, avoid.toString(), avoid);
                }
            }
            if (obj4 != null)
            {
                try
                {
                    ((BufferedReader) (obj4)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    Log.e(LocationUtil.TAG, avoid.toString(), avoid);
                }
            }
            return ((String) (obj));
            obj3;
            avoid = obj6;
_L7:
            obj = obj2;
            obj1 = avoid;
            Log.e(LocationUtil.TAG, ((IOException) (obj3)).toString(), ((Throwable) (obj3)));
            if (obj2 != null)
            {
                try
                {
                    ((InputStream) (obj2)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    Log.e(LocationUtil.TAG, ((IOException) (obj)).toString(), ((Throwable) (obj)));
                }
            }
            if (avoid != null)
            {
                try
                {
                    avoid.close();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    Log.e(LocationUtil.TAG, avoid.toString(), avoid);
                }
            }
              goto _L4
            avoid;
_L6:
            if (obj != null)
            {
                try
                {
                    ((InputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    Log.e(LocationUtil.TAG, ((IOException) (obj)).toString(), ((Throwable) (obj)));
                }
            }
            if (obj1 != null)
            {
                try
                {
                    ((BufferedReader) (obj1)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    Log.e(LocationUtil.TAG, ((IOException) (obj)).toString(), ((Throwable) (obj)));
                }
            }
            throw avoid;
            obj2;
            obj1 = obj4;
            obj = avoid;
            avoid = ((Void []) (obj2));
            if (true) goto _L6; else goto _L5
_L5:
            obj3;
            obj2 = avoid;
            avoid = ((Void []) (obj4));
              goto _L7
            obj4;
            avoid = ((Void []) (obj3));
            obj2 = obj5;
            if (true) goto _L9; else goto _L8
_L8:
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
            if (mCallback != null)
            {
                mCallback.onFailure();
            }
_L4:
            return;
_L2:
            if (mCallback != null)
            {
                mCallback.onComplete();
            }
            boolean flag;
            boolean flag1;
            s = new JSONObject(s);
            flag = processCopperfieldStoresData(s);
            flag1 = processRestaurantsData(s);
            processWeblabTreatment(s);
            if (flag || flag1)
            {
                try
                {
                    LocationUtil.notifyStoresUpdated();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Log.e(LocationUtil.TAG, s.toString(), s);
                }
                mCallback.onFailure();
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public StoreFetcherTask(Context context, com.amazon.now.location.Store.StoreFetchCallback storefetchcallback)
        {
            mContext = context;
            mCallback = storefetchcallback;
        }
    }


    private static final String TAG = com/amazon/now/util/LocationUtil.getSimpleName();
    private static List sSearchAliasWhitelist;
    private static List sStoreList;
    private static final ArrayList sStoreListeners = new ArrayList();
    private static final Map sStoreMap = new HashMap();

    public LocationUtil()
    {
    }

    public static void addStoreListener(com.amazon.now.location.Store.StoreListener storelistener)
    {
        sStoreListeners.add(storelistener);
    }

    public static void changeLocation(AmazonActivity amazonactivity, String s, String s1, String s2, String s3, String s4, double d, 
            double d1, CallbackContext callbackcontext)
    {
        if (s1.indexOf("amazon.") != 0)
        {
            callbackcontext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
        }
        LocaleManager.getInstance().setLocaleFromDomain(s1);
        String s5 = Location.getDomain();
        Location.saveLocation(s, s1, s2, s3, s4, d, d1);
        resetStores();
        AppExtensionsInitializer.setMarketplace(s2);
        AndroidMetricsFactoryImpl.setPreferredMarketplace(amazonactivity, s2);
        if (User.isSignedIn() && s5 != null && !s5.equalsIgnoreCase(s1))
        {
            SSO.syncCookies(true, new Callback(amazonactivity, callbackcontext) {

                final AmazonActivity val$activity;
                final CallbackContext val$callbackContext;

                public void onError(Bundle bundle)
                {
                    callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
                }

                public void onSuccess(Bundle bundle)
                {
                    LocationUtil.completeLocationChange(activity, callbackContext);
                }

            
            {
                activity = amazonactivity;
                callbackContext = callbackcontext;
                super();
            }
            });
            return;
        } else
        {
            completeLocationChange(amazonactivity, callbackcontext);
            return;
        }
    }

    private static void completeLocationChange(AmazonActivity amazonactivity, CallbackContext callbackcontext)
    {
        CartController.getInstance().fetchCartCount(null, null);
        amazonactivity.updateLeftNav();
        callbackcontext.success();
    }

    public static void fetchStores(Context context, com.amazon.now.location.Store.StoreFetchCallback storefetchcallback)
    {
        (new StoreFetcherTask(context, storefetchcallback)).execute(new Void[0]);
    }

    public static List getSearchAliasWhitelist()
    {
        if (sSearchAliasWhitelist == null && Location.isStoreSet())
        {
            if (getStoreList() == null)
            {
                sSearchAliasWhitelist = new ArrayList(1);
            } else
            {
                sSearchAliasWhitelist = new ArrayList(getStoreCount() + 1);
                Iterator iterator = getStoreList().iterator();
                while (iterator.hasNext()) 
                {
                    Store store = (Store)iterator.next();
                    sSearchAliasWhitelist.add(store.getSearchAlias());
                }
            }
            sSearchAliasWhitelist.add("aps");
        }
        return sSearchAliasWhitelist;
    }

    public static Store getStoreByMerchantId(String s)
    {
        return (Store)sStoreMap.get(s);
    }

    public static int getStoreCount()
    {
        if (sStoreList == null && Location.isStoreSet())
        {
            parseStores(Location.getStores());
        }
        if (sStoreList == null)
        {
            return 0;
        } else
        {
            return sStoreList.size();
        }
    }

    public static List getStoreList()
    {
        if (sStoreList == null && Location.isStoreSet())
        {
            parseStores(Location.getStores());
        }
        return sStoreList;
    }

    public static boolean isRestaurantsEnabled()
    {
        return DataStore.getBoolean("RESTAURANTS_ENABLED");
    }

    private static void notifyStoresUpdated()
    {
        for (Iterator iterator = sStoreListeners.iterator(); iterator.hasNext(); ((com.amazon.now.location.Store.StoreListener)iterator.next()).onStoresUpdated()) { }
    }

    private static void parseStores(String s)
    {
        Object obj = null;
        JSONArray jsonarray = new JSONArray(s);
        s = obj;
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        int j;
        j = jsonarray.length();
        s = new ArrayList(j);
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj2 = jsonarray.optJSONObject(i);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        Object obj1 = ((JSONObject) (obj2)).optString("displayName");
        String s1 = ((JSONObject) (obj2)).optString("merchantId");
        String s2 = ((JSONObject) (obj2)).optString("storefrontRelativeUrl");
        String s3 = ((JSONObject) (obj2)).optString("primaryBackgroundColor");
        String s4 = ((JSONObject) (obj2)).optString("leftNavImageUrl");
        String s5 = ((JSONObject) (obj2)).optString("badgeImageUrl");
        obj2 = ((JSONObject) (obj2)).optString("searchAlias");
        if (AppUtils.isDefined(((String) (obj1))) && AppUtils.isDefined(s1) && AppUtils.isDefined(s2) && ImageUtil.isImageServerUrl(s4))
        {
            obj1 = new Store(((String) (obj1)), s1, s2, s4, s5, s3, ((String) (obj2)));
            s.add(obj1);
            sStoreMap.put(s1, obj1);
        }
        i++;
        if (true) goto _L3; else goto _L2
        s;
_L5:
        Log.e(TAG, "Error during store JSON parsing", s);
        s = null;
_L2:
        sStoreList = s;
        return;
        s;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void removeStoreListener(com.amazon.now.location.Store.StoreListener storelistener)
    {
        sStoreListeners.remove(storelistener);
    }

    private static void resetStores()
    {
        sStoreList = null;
        sStoreMap.clear();
        setRestaurantsEnabled(false);
        notifyStoresUpdated();
    }

    private static void setRestaurantsEnabled(boolean flag)
    {
        DataStore.putBoolean("RESTAURANTS_ENABLED", flag);
    }







/*
    static List access$402(List list)
    {
        sSearchAliasWhitelist = list;
        return list;
    }

*/

}
