// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Base64;
import com.wishabi.flipp.content.af;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class al extends AsyncTask
{

    private final long a;
    private final String b;
    private final Context c;

    public al(long l, String s, Context context)
    {
        a = l;
        b = s;
        c = context;
    }

    private transient af a()
    {
        Object obj1;
        android.net.Uri.Builder builder = Uri.parse("https://backflipp.wishabi.com/flipp/items").buildUpon();
        builder.appendEncodedPath(Long.toString(a));
        builder.appendQueryParameter("postal_code", b);
        builder.appendQueryParameter("locale", Locale.getDefault().toString());
        obj1 = builder.build();
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        String s;
        obj = c.getPackageManager();
        s = c.getPackageName();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((PackageManager) (obj)).getPackageInfo(s, 0).versionName;
_L8:
        obj1 = (HttpURLConnection)(new URL(((Uri) (obj1)).toString())).openConnection();
        ((HttpURLConnection) (obj1)).setDoInput(true);
        ((HttpURLConnection) (obj1)).setUseCaches(false);
        ((HttpURLConnection) (obj1)).setRequestProperty("Content-Type", "application/json");
        ((HttpURLConnection) (obj1)).setRequestProperty("Accept", "application/json");
        ((HttpURLConnection) (obj1)).setRequestProperty("Platform", "Android");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        ((HttpURLConnection) (obj1)).setRequestProperty("App-Version", ((String) (obj)));
        char ac[];
        if (!"".isEmpty())
        {
            ((HttpURLConnection) (obj1)).setRequestProperty("Authorization", (new StringBuilder("Basic ")).append(Base64.encodeToString("".getBytes(), 2)).toString());
        }
        if (((HttpURLConnection) (obj1)).getResponseCode() != 200)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj1)).getInputStream()));
        obj1 = new StringBuilder();
        ac = new char[4096];
_L7:
        int i = ((BufferedReader) (obj)).read(ac);
        if (i == -1) goto _L6; else goto _L5
_L5:
        ((StringBuilder) (obj1)).append(new String(ac, 0, i));
          goto _L7
        obj;
_L9:
        ((Exception) (obj)).toString();
        return null;
        obj;
_L4:
        obj = null;
          goto _L8
_L6:
        obj = new JSONObject(((StringBuilder) (obj1)).toString());
_L10:
        if (obj != null)
        {
            obj = ((JSONObject) (obj)).optJSONObject("item");
            if (obj != null)
            {
                return af.a(((JSONObject) (obj)));
            }
        }
          goto _L1
        obj;
          goto _L9
        obj = null;
          goto _L10
    }

    protected Object doInBackground(Object aobj[])
    {
        return a();
    }
}
