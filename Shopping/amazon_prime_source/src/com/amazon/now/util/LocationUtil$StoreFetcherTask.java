// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.now.location.Location;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.util:
//            LocationUtil, WeblabUtil, AppUtils, NetUtil

private static class mCallback extends AsyncTask
{

    private com.amazon.now.location.lure mCallback;
    private Context mContext;

    private boolean processCopperfieldStoresData(JSONObject jsonobject)
    {
        jsonobject = jsonobject.optJSONArray("stores");
        if (jsonobject != null)
        {
            jsonobject = jsonobject.toString();
            if (Location.saveStores(jsonobject))
            {
                LocationUtil.access$300(jsonobject);
                java.util.List _tmp = LocationUtil.access$402(null);
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
                LocationUtil.access$500(flag);
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
        avoid.mContext("api").mContext("store").mContext("by-session-id");
        obj9 = avoid.mContext().toString();
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
        Log.e(LocationUtil.access$100(), ((MalformedURLException) (obj4)).toString(), ((Throwable) (obj4)));
        if (avoid != null)
        {
            try
            {
                avoid.close();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Log.e(LocationUtil.access$100(), avoid.toString(), avoid);
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
                Log.e(LocationUtil.access$100(), avoid.toString(), avoid);
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
                Log.e(LocationUtil.access$100(), avoid.toString(), avoid);
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
                Log.e(LocationUtil.access$100(), avoid.toString(), avoid);
            }
        }
        return ((String) (obj));
        obj3;
        avoid = obj6;
_L7:
        obj = obj2;
        obj1 = avoid;
        Log.e(LocationUtil.access$100(), ((IOException) (obj3)).toString(), ((Throwable) (obj3)));
        if (obj2 != null)
        {
            try
            {
                ((InputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(LocationUtil.access$100(), ((IOException) (obj)).toString(), ((Throwable) (obj)));
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
                Log.e(LocationUtil.access$100(), avoid.toString(), avoid);
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
                Log.e(LocationUtil.access$100(), ((IOException) (obj)).toString(), ((Throwable) (obj)));
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
                Log.e(LocationUtil.access$100(), ((IOException) (obj)).toString(), ((Throwable) (obj)));
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
            mCallback.lure();
        }
_L4:
        return;
_L2:
        if (mCallback != null)
        {
            mCallback.plete();
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
                LocationUtil.access$200();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e(LocationUtil.access$100(), s.toString(), s);
            }
            mCallback.lure();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public (Context context, com.amazon.now.location. )
    {
        mContext = context;
        mCallback = ;
    }
}
