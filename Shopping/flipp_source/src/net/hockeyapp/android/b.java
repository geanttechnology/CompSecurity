// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.hockeyapp.android.e.a;
import net.hockeyapp.android.e.e;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package net.hockeyapp.android:
//            a, g, q, c, 
//            d, f, e, h

public final class b
{

    private static String a = null;
    private static String b = null;

    public static void a(Context context, String s, g g1)
    {
        if (context != null)
        {
            b = "https://sdk.hockeyapp.net/";
            a = s;
            net.hockeyapp.android.a.a(context);
            if (a == null)
            {
                a = a.d;
            }
        }
        s = Boolean.valueOf(false);
        context = new WeakReference(context);
        int i = b(context);
        if (i == 1)
        {
            if (!Boolean.valueOf(Boolean.valueOf(Boolean.valueOf(false).booleanValue() | g1.a()).booleanValue() | false).booleanValue())
            {
                boolean flag = s.booleanValue();
                s = (Context)context.get();
                if (s != null)
                {
                    s = new android.app.AlertDialog.Builder(s);
                    s.setTitle(net.hockeyapp.android.q.a(g1, 0));
                    s.setMessage(net.hockeyapp.android.q.a(g1, 1));
                    s.setNegativeButton(net.hockeyapp.android.q.a(g1, 2), new c(g1, context, flag));
                    s.setPositiveButton(net.hockeyapp.android.q.a(g1, 3), new d(context, g1, flag));
                    s.create().show();
                }
                return;
            } else
            {
                b(context, g1, s.booleanValue());
                return;
            }
        }
        if (i == 2)
        {
            b(context, g1, s.booleanValue());
            return;
        } else
        {
            b(g1, s.booleanValue());
            return;
        }
    }

    public static void a(WeakReference weakreference)
    {
        String as[];
        int i;
        as = a();
        if (as == null || as.length <= 0)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        Log.d("HockeyApp", (new StringBuilder("Found ")).append(as.length).append(" stacktrace(s).").toString());
        i = 0;
_L3:
        if (i >= as.length) goto _L2; else goto _L1
_L1:
        if (weakreference == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Context context;
        Log.d("HockeyApp", (new StringBuilder("Delete stacktrace ")).append(as[i]).append(".").toString());
        a(weakreference, as[i]);
        context = (Context)weakreference.get();
        if (context != null)
        {
            try
            {
                context.deleteFile(as[i]);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        i++;
          goto _L3
_L2:
    }

    private static void a(WeakReference weakreference, String s)
    {
        if (weakreference != null)
        {
            weakreference = (Context)weakreference.get();
            if (weakreference != null)
            {
                weakreference.deleteFile(s);
                weakreference.deleteFile(s.replace(".stacktrace", ".user"));
                weakreference.deleteFile(s.replace(".stacktrace", ".contact"));
                weakreference.deleteFile(s.replace(".stacktrace", ".description"));
            }
        }
    }

    public static void a(WeakReference weakreference, g g1)
    {
        String as[] = a();
        if (as == null || as.length <= 0) goto _L2; else goto _L1
_L1:
        Object obj;
        int i;
        Log.d("HockeyApp", (new StringBuilder("Found ")).append(as.length).append(" stacktrace(s).").toString());
        obj = Boolean.valueOf(false);
        i = 0;
_L3:
        Object obj2;
        if (i >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = as[i];
        String s = b(weakreference, ((String) (obj2)));
        Object obj1 = obj;
        if (s.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        Log.d("HockeyApp", (new StringBuilder("Transmitting crash data: \n")).append(s).toString());
        obj1 = (DefaultHttpClient)net.hockeyapp.android.e.b.a.a;
        HttpPost httppost = new HttpPost((new StringBuilder()).append(b).append("api/2/apps/").append(a).append("/crashes/").toString());
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("raw", s));
        arraylist.add(new BasicNameValuePair("userID", b(weakreference, ((String) (obj2)).replace(".stacktrace", ".user"))));
        arraylist.add(new BasicNameValuePair("contact", b(weakreference, ((String) (obj2)).replace(".stacktrace", ".contact"))));
        arraylist.add(new BasicNameValuePair("description", b(weakreference, ((String) (obj2)).replace(".stacktrace", ".description"))));
        arraylist.add(new BasicNameValuePair("sdk", "HockeySDK"));
        arraylist.add(new BasicNameValuePair("sdk_version", "3.0.2"));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
        ((DefaultHttpClient) (obj1)).execute(httppost);
        obj1 = Boolean.valueOf(true);
        if (((Boolean) (obj1)).booleanValue())
        {
            a(weakreference, as[i]);
            obj2 = obj1;
            if (g1 == null);
        } else
        {
            obj2 = obj1;
            if (g1 != null)
            {
                obj2 = obj1;
            }
        }
_L4:
        i++;
        obj = obj2;
        if (true) goto _L3; else goto _L2
        Exception exception;
        exception;
        exception.printStackTrace();
        if (((Boolean) (obj)).booleanValue())
        {
            a(weakreference, as[i]);
            obj2 = obj;
            if (g1 != null)
            {
                obj2 = obj;
            }
        } else
        {
            obj2 = obj;
            if (g1 != null)
            {
                obj2 = obj;
            }
        }
          goto _L4
        g1;
        if (((Boolean) (obj)).booleanValue())
        {
            a(weakreference, as[i]);
        }
        throw g1;
_L2:
    }

    static void a(WeakReference weakreference, g g1, boolean flag)
    {
        b(weakreference, g1, flag);
    }

    static void a(g g1, boolean flag)
    {
        b(g1, flag);
    }

    private static String[] a()
    {
        if (net.hockeyapp.android.a.a != null)
        {
            Log.d("HockeyApp", (new StringBuilder("Looking for exceptions in: ")).append(net.hockeyapp.android.a.a).toString());
            File file = new File((new StringBuilder()).append(net.hockeyapp.android.a.a).append("/").toString());
            if (!file.mkdir() && !file.exists())
            {
                return new String[0];
            } else
            {
                return file.list(new f());
            }
        } else
        {
            Log.d("HockeyApp", "Can't search for exception as file path is null.");
            return null;
        }
    }

    private static int b(WeakReference weakreference)
    {
        Object obj;
        String as[];
        int i;
        i = 0;
        as = a();
        obj = null;
        if (as == null || as.length <= 0)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        weakreference = (Context)weakreference.get();
label0:
        {
            byte byte0;
            if (weakreference != null)
            {
                try
                {
                    weakreference = Arrays.asList(weakreference.getSharedPreferences("HockeySDK", 0).getString("ConfirmedFilenames", "").split("\\|"));
                }
                // Misplaced declaration of an exception variable
                catch (WeakReference weakreference)
                {
                    weakreference = obj;
                }
            } else
            {
                weakreference = null;
            }
            if (weakreference != null)
            {
                byte byte1 = 2;
                int j = as.length;
                do
                {
                    byte0 = byte1;
                    if (i >= j)
                    {
                        break label0;
                    }
                    if (!weakreference.contains(as[i]))
                    {
                        break;
                    }
                    i++;
                } while (true);
            }
            byte0 = 1;
        }
        return byte0;
        return 0;
    }

    private static String b(WeakReference weakreference, String s)
    {
        Object obj = null;
        if (weakreference == null) goto _L2; else goto _L1
_L1:
        weakreference = (Context)weakreference.get();
        if (weakreference == null) goto _L2; else goto _L3
_L3:
        StringBuilder stringbuilder = new StringBuilder();
        weakreference = new BufferedReader(new InputStreamReader(weakreference.openFileInput(s)));
_L5:
        s = weakreference;
        obj = weakreference.readLine();
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = weakreference;
        stringbuilder.append(((String) (obj)));
        s = weakreference;
        stringbuilder.append(System.getProperty("line.separator"));
        if (true) goto _L5; else goto _L4
        s;
_L11:
        if (weakreference != null)
        {
            try
            {
                weakreference.close();
            }
            // Misplaced declaration of an exception variable
            catch (WeakReference weakreference) { }
        }
_L6:
        return stringbuilder.toString();
_L4:
        try
        {
            weakreference.close();
        }
        // Misplaced declaration of an exception variable
        catch (WeakReference weakreference) { }
          goto _L6
        obj;
        weakreference = null;
_L9:
        s = weakreference;
        ((IOException) (obj)).printStackTrace();
        if (weakreference != null)
        {
            try
            {
                weakreference.close();
            }
            // Misplaced declaration of an exception variable
            catch (WeakReference weakreference) { }
        }
          goto _L6
        weakreference;
        s = null;
_L8:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw weakreference;
_L2:
        return null;
        weakreference;
        if (true) goto _L8; else goto _L7
_L7:
        obj;
          goto _L9
        weakreference;
        weakreference = ((WeakReference) (obj));
        if (true) goto _L11; else goto _L10
_L10:
    }

    private static void b(WeakReference weakreference, g g1, boolean flag)
    {
        if (weakreference == null) goto _L2; else goto _L1
_L1:
        Object obj = (Context)weakreference.get();
        if (obj == null) goto _L2; else goto _L3
_L3:
        String as[];
        StringBuffer stringbuffer;
        as = a();
        obj = ((Context) (obj)).getSharedPreferences("HockeySDK", 0).edit();
        stringbuffer = new StringBuffer();
        int i = 0;
_L8:
        if (i >= as.length) goto _L5; else goto _L4
_L4:
        stringbuffer.append(as[i]);
        if (i < as.length - 1)
        {
            stringbuffer.append("|");
        }
          goto _L6
_L5:
        try
        {
            ((android.content.SharedPreferences.Editor) (obj)).putString("ConfirmedFilenames", stringbuffer.toString());
            e.a(((android.content.SharedPreferences.Editor) (obj)));
        }
        catch (Exception exception) { }
_L2:
        (new net.hockeyapp.android.e(weakreference, g1, flag)).start();
        return;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static void b(g g1, boolean flag)
    {
        if (a.b != null && a.d != null)
        {
            Thread.UncaughtExceptionHandler uncaughtexceptionhandler = Thread.getDefaultUncaughtExceptionHandler();
            if (uncaughtexceptionhandler != null)
            {
                Log.d("HockeyApp", (new StringBuilder("Current handler class = ")).append(uncaughtexceptionhandler.getClass().getName()).toString());
            }
            if (uncaughtexceptionhandler instanceof h)
            {
                ((h)uncaughtexceptionhandler).a = g1;
                return;
            } else
            {
                Thread.setDefaultUncaughtExceptionHandler(new h(uncaughtexceptionhandler, g1, flag));
                return;
            }
        } else
        {
            Log.d("HockeyApp", "Exception handler not set because version or package is null.");
            return;
        }
    }

}
