// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.library;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.livemixtapes.App;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser
{

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    public JSONParser()
    {
    }

    public static String generateString(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L3:
        String s = bufferedreader.readLine();
        if (s != null) goto _L2; else goto _L1
_L1:
        IOException ioexception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        return stringbuilder.toString();
_L2:
        stringbuilder.append((new StringBuilder(String.valueOf(s))).append("\n").toString());
          goto _L3
        ioexception;
        ioexception.printStackTrace();
          goto _L1
    }

    public JSONObject getJSONFromUrl(String s, final Activity context)
    {
        StringBuilder stringbuilder;
        String s1;
        try
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            s = new HttpGet(s);
            s.addHeader("X-Api-Key", "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh");
            s.addHeader("User-Agent", "LiveMixtapes Android/1.0.84 BETA");
            is = defaulthttpclient.execute(s).getEntity().getContent();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        s = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
        stringbuilder = new StringBuilder();
_L1:
        s1 = s.readLine();
        if (s1 == null)
        {
            try
            {
                is.close();
                json = stringbuilder.toString();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("Buffer Error", (new StringBuilder("Error converting result ")).append(s.toString()).toString());
                return null;
            }
            if (json.contains("BETA_DISABLED") && !"generic".equals(Build.BRAND.toLowerCase()))
            {
                context.runOnUiThread(new Runnable() {

                    final JSONParser this$0;
                    private final Activity val$context;

                    public void run()
                    {
                        (new android.app.AlertDialog.Builder(context)).setTitle("App Disabled").setMessage("This BETA version of LiveMixtapes has been disabled!  Please update your app in the play store to continue to use this app.  You may need to uninstall the app first and then visit http://bit.ly/LMT-Android-BETA and install it again in order to get the latest version quickly.").setPositiveButton("OK", context. new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$1;
                            private final Activity val$context;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                try
                                {
                                    dialoginterface = new Intent("android.intent.action.MAIN");
                                    dialoginterface.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                                    dialoginterface.addCategory("android.intent.category.LAUNCHER");
                                    dialoginterface.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.livemixtapes"));
                                    context.startActivity(dialoginterface);
                                }
                                // Misplaced declaration of an exception variable
                                catch (DialogInterface dialoginterface)
                                {
                                    dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.livemixtapes"));
                                    context.startActivity(dialoginterface);
                                }
                                Process.killProcess(Process.myPid());
                            }

            
            {
                this$1 = final__pcls1;
                context = Activity.this;
                super();
            }
                        }).setIcon(0x1080027).show();
                    }

            
            {
                this$0 = JSONParser.this;
                context = activity;
                super();
            }
                });
            }
            try
            {
                jObj = new JSONObject(json);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("JSON Parser", (new StringBuilder("Error parsing data ")).append(s.toString()).toString());
                return null;
            }
            return jObj;
        }
        stringbuilder.append((new StringBuilder(String.valueOf(s1))).append("\n").toString());
          goto _L1
    }

    public String getUrlResponse(String s)
    {
        Object obj2 = App.context.getResources().openRawResource(0x7f070001);
        Object obj = null;
        Object obj1;
        obj1 = KeyStore.getInstance("BKS");
        ((KeyStore) (obj1)).load(((InputStream) (obj2)), "api42829".toCharArray());
        obj2 = new BasicHttpParams();
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("https", new SSLSocketFactory(((KeyStore) (obj1))), 443));
        obj1 = new DefaultHttpClient(new ThreadSafeClientConnManager(((org.apache.http.params.HttpParams) (obj2)), schemeregistry), ((org.apache.http.params.HttpParams) (obj2)));
        obj = obj1;
_L3:
        try
        {
            s = new HttpGet(s);
            s.addHeader("X-Api-Key", "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh");
            s.addHeader("User-Agent", "LiveMixtapes Android/1.0.84 BETA");
            is = ((DefaultHttpClient) (obj)).execute(s).getEntity().getContent();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        s = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
        obj = new StringBuilder();
_L1:
        obj1 = s.readLine();
        if (obj1 == null)
        {
            try
            {
                is.close();
                json = ((StringBuilder) (obj)).toString();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("Buffer Error", (new StringBuilder("Error converting result ")).append(s.toString()).toString());
            }
            return json;
        }
        ((StringBuilder) (obj)).append((new StringBuilder(String.valueOf(obj1))).append("\n").toString());
          goto _L1
        Exception exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public boolean isSuccessfulRequest(JSONObject jsonobject)
    {
        if (jsonobject != null)
        {
            int i;
            try
            {
                i = Integer.parseInt(jsonobject.getString("status"));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return false;
            }
            if (i == 200)
            {
                return true;
            }
        }
        return false;
    }

    public JSONObject postData(String s, List list)
    {
        DefaultHttpClient defaulthttpclient;
        Object obj1;
        obj1 = App.context.getResources().openRawResource(0x7f070001);
        defaulthttpclient = null;
        Object obj;
        obj = KeyStore.getInstance("BKS");
        ((KeyStore) (obj)).load(((InputStream) (obj1)), "api42829".toCharArray());
        obj1 = new BasicHttpParams();
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("https", new SSLSocketFactory(((KeyStore) (obj))), 443));
        obj = new DefaultHttpClient(new ThreadSafeClientConnManager(((org.apache.http.params.HttpParams) (obj1)), schemeregistry), ((org.apache.http.params.HttpParams) (obj1)));
        defaulthttpclient = ((DefaultHttpClient) (obj));
_L2:
        s = new HttpPost(s);
        try
        {
            s.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            s.setHeader("X-Api-Key", "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh");
            s.addHeader("User-Agent", "LiveMixtapes Android/1.0.84 BETA");
            s = new JSONObject(generateString(defaulthttpclient.execute(s).getEntity().getContent()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
