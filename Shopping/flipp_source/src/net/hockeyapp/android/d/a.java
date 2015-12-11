// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import net.hockeyapp.android.UpdateActivity;
import net.hockeyapp.android.e.h;
import net.hockeyapp.android.e.i;
import net.hockeyapp.android.q;
import net.hockeyapp.android.v;
import net.hockeyapp.android.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.hockeyapp.android.d:
//            b, c

public final class a extends AsyncTask
{

    protected String a;
    protected String b;
    public Activity c;
    private Boolean d;
    private z e;
    private long f;

    public a(WeakReference weakreference, String s, String s1)
    {
        a = null;
        b = null;
        c = null;
        d = Boolean.valueOf(false);
        f = 0L;
        b = s1;
        a = s;
        e = null;
        c = (Activity)weakreference.get();
        if (c == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        weakreference = c;
        if (net.hockeyapp.android.a.b != null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        net.hockeyapp.android.a.a(weakreference);
        if (net.hockeyapp.android.a.b != null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        flag = false;
_L3:
        long l;
        if (!flag)
        {
            l = 0L;
        } else
        {
            l = weakreference.getSharedPreferences("HockeyApp", 0).getLong((new StringBuilder("usageTime")).append(net.hockeyapp.android.a.b).toString(), 0L) / 1000L;
        }
        f = l;
        net.hockeyapp.android.a.a(c);
_L2:
        return;
        flag = true;
          goto _L3
    }

    private static String a(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream), 1024);
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
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
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        throw exception;
    }

    private String a(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(a);
        stringbuilder.append("api/2/apps/");
        String s1;
        if (b != null)
        {
            s1 = b;
        } else
        {
            s1 = c.getPackageName();
        }
        stringbuilder.append(s1);
        stringbuilder.append((new StringBuilder("?format=")).append(s).toString());
        if (android.provider.Settings.Secure.getString(c.getContentResolver(), "android_id") != null)
        {
            stringbuilder.append((new StringBuilder("&udid=")).append(b(android.provider.Settings.Secure.getString(c.getContentResolver(), "android_id"))).toString());
        }
        stringbuilder.append("&os=Android");
        stringbuilder.append((new StringBuilder("&os_version=")).append(b(net.hockeyapp.android.a.e)).toString());
        stringbuilder.append((new StringBuilder("&device=")).append(b(net.hockeyapp.android.a.f)).toString());
        stringbuilder.append((new StringBuilder("&oem=")).append(b(net.hockeyapp.android.a.g)).toString());
        stringbuilder.append((new StringBuilder("&app_version=")).append(b(net.hockeyapp.android.a.b)).toString());
        stringbuilder.append((new StringBuilder("&sdk=")).append(b("HockeySDK")).toString());
        stringbuilder.append((new StringBuilder("&sdk_version=")).append(b("3.0.2")).toString());
        stringbuilder.append((new StringBuilder("&lang=")).append(b(Locale.getDefault().getLanguage())).toString());
        stringbuilder.append((new StringBuilder("&usage_time=")).append(f).toString());
        return stringbuilder.toString();
    }

    private transient JSONArray a()
    {
        Object obj;
        int j;
        j = Integer.parseInt(net.hockeyapp.android.a.b);
        obj = new JSONArray(h.a(c));
        if (a(((JSONArray) (obj)), j))
        {
            return ((JSONArray) (obj));
        }
        obj = (new URL(a("json"))).openConnection();
        ((URLConnection) (obj)).addRequestProperty("User-Agent", "HockeySDK/Android");
        if (android.os.Build.VERSION.SDK_INT <= 9)
        {
            ((URLConnection) (obj)).setRequestProperty("connection", "close");
        }
        ((URLConnection) (obj)).connect();
        obj = new BufferedInputStream(((URLConnection) (obj)).getInputStream());
        String s = a(((InputStream) (obj)));
        ((InputStream) (obj)).close();
        obj = new JSONArray(s);
        if (!a(((JSONArray) (obj)), j))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = a(((JSONArray) (obj)));
        return ((JSONArray) (obj));
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    private static JSONArray a(JSONArray jsonarray)
    {
        JSONArray jsonarray1 = new JSONArray();
        int j = 0;
        while (j < Math.min(jsonarray.length(), 25)) 
        {
            try
            {
                jsonarray1.put(jsonarray.get(j));
            }
            catch (JSONException jsonexception) { }
            j++;
        }
        return jsonarray1;
    }

    static void a(a a1)
    {
        a1.b();
    }

    static void a(a a1, JSONArray jsonarray)
    {
        /*<invalid signature>*/java.lang.Object local;
        FragmentTransaction fragmenttransaction;
        if (a1.c == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        fragmenttransaction = a1.c.getFragmentManager().beginTransaction();
        fragmenttransaction.setTransition(4097);
        android.app.Fragment fragment = a1.c.getFragmentManager().findFragmentByTag("hockey_update_dialog");
        if (fragment != null)
        {
            fragmenttransaction.remove(fragment);
        }
        fragmenttransaction.addToBackStack(null);
        local = net/hockeyapp/android/v;
        if (a1.e != null)
        {
            local = net/hockeyapp/android/v;
        }
        ((DialogFragment)local.getMethod("newInstance", new Class[] {
            org/json/JSONArray, java/lang/String
        }).invoke(null, new Object[] {
            jsonarray, a1.a("apk")
        })).show(fragmenttransaction, "hockey_update_dialog");
        return;
        Exception exception;
        exception;
        Log.d("HockeyApp", "An exception happened while showing the update fragment:");
        exception.printStackTrace();
        Log.d("HockeyApp", "Showing update activity instead.");
        a1.a(jsonarray, Boolean.valueOf(false));
        return;
    }

    static void a(a a1, JSONArray jsonarray, Boolean boolean1)
    {
        a1.a(jsonarray, boolean1);
    }

    private void a(JSONArray jsonarray, Boolean boolean1)
    {
        /*<invalid signature>*/java.lang.Object local = null;
        if (e != null)
        {
            local = net/hockeyapp/android/UpdateActivity;
        }
        Class class1 = local;
        if (local == null)
        {
            class1 = net/hockeyapp/android/UpdateActivity;
        }
        if (c != null)
        {
            Intent intent = new Intent();
            intent.setClass(c, class1);
            intent.putExtra("json", jsonarray.toString());
            intent.putExtra("url", a("apk"));
            c.startActivity(intent);
            if (boolean1.booleanValue())
            {
                c.finish();
            }
        }
        b();
    }

    private boolean a(JSONArray jsonarray, int j)
    {
        boolean flag1 = false;
        int k = 0;
        do
        {
label0:
            {
label1:
                {
                    boolean flag = flag1;
                    try
                    {
                        if (k >= jsonarray.length())
                        {
                            break label1;
                        }
                        JSONObject jsonobject = jsonarray.getJSONObject(k);
                        if (jsonobject.getInt("version") <= j || i.a(jsonobject.getString("minimum_os_version"), android.os.Build.VERSION.RELEASE) > 0)
                        {
                            break label0;
                        }
                        if (jsonobject.has("mandatory"))
                        {
                            d = Boolean.valueOf(jsonobject.getBoolean("mandatory"));
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (JSONArray jsonarray)
                    {
                        return false;
                    }
                    flag = true;
                }
                return flag;
            }
            k++;
        } while (true);
    }

    static Activity b(a a1)
    {
        return a1.c;
    }

    private static String b(String s)
    {
        try
        {
            s = URLEncoder.encode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    private void b()
    {
        c = null;
        a = null;
        b = null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
label0:
        {
            obj = (JSONArray)obj;
            if (obj != null)
            {
                h.a(c, ((JSONArray) (obj)).toString());
                if (c != null && !c.isFinishing())
                {
                    break label0;
                }
            }
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(c);
        builder.setTitle(q.a(e, 9));
        if (!d.booleanValue())
        {
            builder.setMessage(q.a(e, 10));
            builder.setNegativeButton(q.a(e, 11), new b(this));
            builder.setPositiveButton(q.a(e, 12), new c(this, ((JSONArray) (obj))));
            builder.create().show();
            return;
        } else
        {
            Toast.makeText(c, q.a(e, 8), 1).show();
            a(((JSONArray) (obj)), Boolean.valueOf(true));
            return;
        }
    }
}
