// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Base64;
import com.wishabi.flipp.content.ai;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aq extends AsyncTask
{

    private final Context a;
    private final String b;
    private final String c;
    private final ContentResolver d;

    public aq(Context context, ContentResolver contentresolver, String s, String s1)
    {
        a = context;
        d = contentresolver;
        b = s;
        c = s1;
    }

    private transient HashMap a()
    {
        Object obj1;
        SharedPreferences sharedpreferences = a.getSharedPreferences("com.wishabi.flipp.preferences", 0);
        obj1 = Uri.parse("https://backflipp.wishabi.com/flipp/items/search").buildUpon();
        ((android.net.Uri.Builder) (obj1)).appendQueryParameter("postal_code", b);
        ((android.net.Uri.Builder) (obj1)).appendQueryParameter("locale", Locale.getDefault().toString());
        ((android.net.Uri.Builder) (obj1)).appendQueryParameter("q", c);
        ((android.net.Uri.Builder) (obj1)).appendQueryParameter("sid", sharedpreferences.getString("advertising_id", null));
        obj1 = ((android.net.Uri.Builder) (obj1)).build();
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        Object obj2;
        obj = a.getPackageManager();
        obj2 = a.getPackageName();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((PackageManager) (obj)).getPackageInfo(((String) (obj2)), 0).versionName;
_L10:
        obj1 = (HttpURLConnection)(new URL(((Uri) (obj1)).toString())).openConnection();
        ((HttpURLConnection) (obj1)).setDoInput(true);
        ((HttpURLConnection) (obj1)).setUseCaches(false);
        ((HttpURLConnection) (obj1)).setRequestProperty("Content-Type", "application/json");
        ((HttpURLConnection) (obj1)).setRequestProperty("Accept", "application/json");
        ((HttpURLConnection) (obj1)).setRequestProperty("Platform", "Android");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        ((HttpURLConnection) (obj1)).setRequestProperty("App-Version", ((String) (obj)));
        if (!"".isEmpty())
        {
            ((HttpURLConnection) (obj1)).setRequestProperty("Authorization", (new StringBuilder("Basic ")).append(Base64.encodeToString("".getBytes(), 2)).toString());
        }
        if (((HttpURLConnection) (obj1)).getResponseCode() != 200) goto _L6; else goto _L5
_L5:
        char ac[];
        obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj1)).getInputStream()));
        obj1 = new StringBuilder();
        ac = new char[4096];
_L9:
        int i = ((BufferedReader) (obj)).read(ac);
        if (i == -1) goto _L8; else goto _L7
_L7:
        ((StringBuilder) (obj1)).append(new String(ac, 0, i));
          goto _L9
        obj;
_L16:
        ((Exception) (obj)).toString();
        return null;
        obj;
_L4:
        obj = null;
          goto _L10
_L8:
        obj = new JSONObject(((StringBuilder) (obj1)).toString());
_L17:
        if (obj == null) goto _L1; else goto _L11
_L11:
        obj1 = new ArrayList();
        ac = new ArrayList();
        JSONArray jsonarray;
        int j;
        jsonarray = ((JSONObject) (obj)).getJSONArray("items");
        j = jsonarray.length();
        i = 0;
_L18:
        if (i >= j) goto _L13; else goto _L12
_L12:
        ai ai1 = ai.a(jsonarray.getJSONObject(i), i, d);
        if (ai1 == null)
        {
            break MISSING_BLOCK_LABEL_475;
        }
        try
        {
            ((ArrayList) (obj1)).add(ai1);
            break MISSING_BLOCK_LABEL_475;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).toString();
        }
          goto _L14
_L13:
        obj = ((JSONObject) (obj)).getJSONArray("coupons");
        i = 0;
_L15:
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        ac.add(Integer.valueOf(((JSONArray) (obj)).getInt(i)));
        i++;
        if (true) goto _L15; else goto _L14
_L14:
        obj = new HashMap();
        ((HashMap) (obj)).put("items", obj1);
        ((HashMap) (obj)).put("coupons", ac);
        return ((HashMap) (obj));
        obj;
          goto _L16
_L6:
        obj = null;
          goto _L17
        i++;
          goto _L18
    }

    protected Object doInBackground(Object aobj[])
    {
        return a();
    }
}
