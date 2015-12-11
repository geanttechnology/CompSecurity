// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.util.Base64;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.util.h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class am extends AsyncTask
{

    private final ContentResolver a;
    private final String b;
    private final String c;
    private final Context d;

    public am(ContentResolver contentresolver, String s, String s1, Context context)
    {
        a = contentresolver;
        b = s;
        c = s1;
        d = context;
    }

    private transient Boolean a()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj1 = null;
        if (b == null || c == null)
        {
            return Boolean.valueOf(false);
        }
        obj = Uri.parse("https://backflipp.wishabi.com/flipp/flyers").buildUpon();
        ((android.net.Uri.Builder) (obj)).appendEncodedPath(c);
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("postal_code", b);
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("locale", Locale.getDefault().toString());
        obj2 = ((android.net.Uri.Builder) (obj)).build();
        if (obj2 == null)
        {
            return Boolean.valueOf(false);
        }
        obj = d.getPackageManager();
        obj3 = d.getPackageName();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((PackageManager) (obj)).getPackageInfo(((String) (obj3)), 0).versionName;
_L6:
        obj3 = (HttpURLConnection)(new URL(((Uri) (obj2)).toString())).openConnection();
        ((HttpURLConnection) (obj3)).setDoInput(true);
        ((HttpURLConnection) (obj3)).setUseCaches(false);
        ((HttpURLConnection) (obj3)).setRequestProperty("Content-Type", "application/json");
        ((HttpURLConnection) (obj3)).setRequestProperty("Accept", "application/json");
        ((HttpURLConnection) (obj3)).setRequestProperty("Platform", "Android");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        ((HttpURLConnection) (obj3)).setRequestProperty("App-Version", ((String) (obj)));
        char ac[];
        if (!"".isEmpty())
        {
            ((HttpURLConnection) (obj3)).setRequestProperty("Authorization", (new StringBuilder("Basic ")).append(Base64.encodeToString("".getBytes(), 2)).toString());
        }
        if (((HttpURLConnection) (obj3)).getResponseCode() != 200)
        {
            break MISSING_BLOCK_LABEL_1025;
        }
        obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj3)).getInputStream()));
        obj3 = new StringBuilder();
        ac = new char[4096];
_L5:
        int j = ((BufferedReader) (obj)).read(ac);
        if (j == -1) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj3)).append(new String(ac, 0, j));
          goto _L5
        obj;
_L16:
        ((Exception) (obj)).toString();
        return Boolean.valueOf(false);
        obj;
_L2:
        obj = null;
          goto _L6
_L4:
        obj = new JSONObject(((StringBuilder) (obj3)).toString());
        (new StringBuilder("Beacon: ")).append(((Uri) (obj2)).toString());
_L17:
        if (obj == null)
        {
            return Boolean.valueOf(false);
        }
        obj2 = new ArrayList();
        int k;
        obj3 = ((JSONObject) (obj)).getJSONArray("items");
        k = ((JSONArray) (obj3)).length();
        j = 0;
_L8:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject1 = ((JSONArray) (obj3)).getJSONObject(j);
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put("_id", Long.valueOf(jsonobject1.getLong("id")));
        contentvalues1.put("available_to", jsonobject1.getString("available_to"));
        contentvalues1.put("bottom", Double.valueOf(-jsonobject1.getDouble("bottom")));
        contentvalues1.put("top", Double.valueOf(-jsonobject1.getDouble("top")));
        contentvalues1.put("left", Double.valueOf(jsonobject1.getDouble("left")));
        contentvalues1.put("right", Double.valueOf(jsonobject1.getDouble("right")));
        contentvalues1.put("brand", jsonobject1.getString("brand"));
        contentvalues1.put("discount", h.a(jsonobject1, "discount", Double.valueOf(0.0D)));
        contentvalues1.put("flyer_id", Integer.valueOf(jsonobject1.getInt("flyer_id")));
        contentvalues1.put("name", jsonobject1.getString("name"));
        contentvalues1.put("short_name", h.a(jsonobject1, "short_name"));
        contentvalues1.put("price", h.a(jsonobject1, "price"));
        contentvalues1.put("thumbnail", jsonobject1.getString("cutout_image_url"));
        contentvalues1.put("display_type", Integer.valueOf(jsonobject1.getInt("display_type")));
        contentvalues1.put("ttm_url", h.a(jsonobject1, "ttm_url"));
        contentvalues1.put("video_url", h.a(jsonobject1, "video_url"));
        contentvalues1.put("page_destination", h.a(jsonobject1, "page_destination", null));
        ((ArrayList) (obj2)).add(ContentProviderOperation.newInsert(i.c).withValues(contentvalues1).build());
        j++;
        if (true) goto _L8; else goto _L7
_L7:
        obj = h.b(((JSONObject) (obj)), "pages");
        if (obj == null) goto _L10; else goto _L9
_L9:
        j = 0;
_L11:
        if (j >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(j);
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", Integer.valueOf(jsonobject.getInt("id")));
        contentvalues.put("left", Double.valueOf(jsonobject.getDouble("left")));
        contentvalues.put("bottom", Double.valueOf(-jsonobject.getDouble("bottom")));
        contentvalues.put("right", Double.valueOf(jsonobject.getDouble("right")));
        contentvalues.put("top", Double.valueOf(-jsonobject.getDouble("top")));
        contentvalues.put("name", jsonobject.getString("name"));
        contentvalues.put("page", Integer.valueOf(jsonobject.getInt("page")));
        contentvalues.put("flyer_id", Integer.valueOf(c));
        ((ArrayList) (obj2)).add(ContentProviderOperation.newInsert(i.d).withValues(contentvalues).build());
        j++;
        if (true) goto _L11; else goto _L10
_L10:
        obj = obj2;
_L13:
        if (obj == null)
        {
            return Boolean.valueOf(false);
        }
        break; /* Loop/switch isn't completed */
        obj;
        (new StringBuilder("Error processing item JSON: ")).append(((JSONException) (obj)).toString());
        obj = obj1;
        if (true) goto _L13; else goto _L12
_L12:
        a.applyBatch("com.wishabi.flipp.content.Flyer", ((ArrayList) (obj)));
        return Boolean.valueOf(true);
        obj;
_L15:
        (new StringBuilder("Error inserting flyer-item data: ")).append(((Exception) (obj)).toString());
        return Boolean.valueOf(false);
        obj;
        if (true) goto _L15; else goto _L14
_L14:
        obj;
          goto _L16
        obj = null;
          goto _L17
    }

    protected Object doInBackground(Object aobj[])
    {
        return a();
    }
}
