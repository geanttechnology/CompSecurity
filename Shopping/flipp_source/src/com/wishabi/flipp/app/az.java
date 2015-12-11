// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.b.a;
import com.wishabi.flipp.content.i;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.wishabi.flipp.app:
//            FlippApplication

final class az extends AsyncTask
{

    final FlippApplication a;

    az(FlippApplication flippapplication)
    {
        a = flippapplication;
        super();
    }

    private transient Void a()
    {
        if (a.getPackageManager() != null) goto _L2; else goto _L1
_L1:
        Object obj2;
        return null;
_L2:
        if ((obj2 = a.getSharedPreferences("com.wishabi.flipp.preferences", 0)) == null) goto _L1; else goto _L3
_L3:
        Object obj;
        Object obj1;
        String s;
        android.net.Uri.Builder builder;
        ArrayList arraylist;
        int j;
        try
        {
            j = a.getPackageManager().getPackageInfo(a.getPackageName(), 0).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return null;
        }
        obj1 = com.google.android.gms.b.a.a(a);
        try
        {
            s = ((a) (obj1)).a(new String[] {
                "865057271330"
            });
        }
        catch (IOException ioexception)
        {
            return null;
        }
        obj = ((SharedPreferences) (obj2)).getString("postal_code", null);
        if (obj == null) goto _L1; else goto _L4
_L4:
        builder = Uri.parse("https://backflipp.wishabi.com/flipp/gcm/registration").buildUpon();
        builder.appendPath(s);
        builder.appendQueryParameter("locale", Locale.getDefault().toString());
        builder.appendQueryParameter("postal_code", ((String) (obj)));
        if (((SharedPreferences) (obj2)).contains("allow_push"))
        {
            if (((SharedPreferences) (obj2)).getBoolean("allow_push", true))
            {
                obj = "true";
            } else
            {
                obj = "false";
            }
            builder.appendQueryParameter("allow_push", ((String) (obj)));
        }
        arraylist = new ArrayList();
        obj = a.getContentResolver().query(i.f, new String[] {
            "_id"
        }, null, null, null);
_L6:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((Cursor) (obj)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("_id")));
        if (true) goto _L6; else goto _L5
        obj2;
        obj1 = obj;
        obj = obj2;
_L9:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L5:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (!arraylist.isEmpty())
        {
            builder.appendQueryParameter("merchant_ids", TextUtils.join(",", arraylist));
        }
        obj = builder.build();
        if (obj == null) goto _L1; else goto _L7
_L7:
        try
        {
            obj = new URL(((Uri) (obj)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        obj = (HttpURLConnection)((URL) (obj)).openConnection();
        ((HttpURLConnection) (obj)).setDoInput(true);
        ((HttpURLConnection) (obj)).setUseCaches(false);
        ((HttpURLConnection) (obj)).setRequestMethod("PUT");
        if (!"".isEmpty())
        {
            ((HttpURLConnection) (obj)).addRequestProperty("Authorization", (new StringBuilder("Basic ")).append(Base64.encodeToString("".getBytes(), 2)).toString());
        }
        if (((HttpURLConnection) (obj)).getResponseCode() == 200)
        {
            break MISSING_BLOCK_LABEL_544;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        obj = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        ((Intent) (obj)).setPackage("com.google.android.gms");
        ((a) (obj1)).c.clear();
        ((Intent) (obj)).putExtra("google.messenger", ((a) (obj1)).d);
        ((a) (obj1)).a(((Intent) (obj)));
        ((a) (obj1)).b.startService(((Intent) (obj)));
        obj = (Intent)((a) (obj1)).c.poll(5000L, TimeUnit.MILLISECONDS);
        if (obj != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        catch (IOException ioexception1)
        {
            return null;
        }
        throw new IOException(((InterruptedException) (obj)).getMessage());
        if (((Intent) (obj)).getStringExtra("unregistered") != null) goto _L1; else goto _L8
_L8:
        obj = ((Intent) (obj)).getStringExtra("error");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_533;
        }
        throw new IOException(((String) (obj)));
        throw new IOException("SERVICE_NOT_AVAILABLE");
        ((SharedPreferences) (obj2)).edit().putString("gcm_registration_id", s).putInt("gcm_application_version_id", j).commit();
        com.wishabi.flipp.b.a.a.c("gcm");
        return null;
        obj;
        obj1 = null;
          goto _L9
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }
}
