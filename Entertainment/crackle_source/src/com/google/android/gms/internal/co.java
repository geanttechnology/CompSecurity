// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            cr, cp, cq, cs, 
//            ct

public final class co
{
    private static final class a extends BroadcastReceiver
    {

        public void onReceive(Context context, Intent intent)
        {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction()))
            {
                co.k(true);
            } else
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
            {
                co.k(false);
                return;
            }
        }

        private a()
        {
        }

    }


    private static final Object hC = new Object();
    private static boolean iD = true;
    private static String iE;
    private static boolean iF = false;

    public static String a(Readable readable)
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder();
        CharBuffer charbuffer = CharBuffer.allocate(2048);
        do
        {
            int l = readable.read(charbuffer);
            if (l != -1)
            {
                charbuffer.flip();
                stringbuilder.append(charbuffer, 0, l);
            } else
            {
                return stringbuilder.toString();
            }
        } while (true);
    }

    private static JSONArray a(Collection collection)
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        for (collection = collection.iterator(); collection.hasNext(); a(jsonarray, collection.next())) { }
        return jsonarray;
    }

    private static JSONArray a(Object aobj[])
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        int i1 = aobj.length;
        for (int l = 0; l < i1; l++)
        {
            a(jsonarray, aobj[l]);
        }

        return jsonarray;
    }

    private static JSONObject a(Bundle bundle)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); a(jsonobject, s, bundle.get(s)))
        {
            s = (String)iterator.next();
        }

        return jsonobject;
    }

    public static void a(Context context, String s, WebSettings websettings)
    {
        websettings.setUserAgentString(b(context, s));
    }

    public static void a(Context context, String s, List list)
    {
        for (list = list.iterator(); list.hasNext(); (new cr(context, s, (String)list.next())).start()) { }
    }

    public static void a(Context context, String s, boolean flag, HttpURLConnection httpurlconnection)
    {
        httpurlconnection.setConnectTimeout(60000);
        httpurlconnection.setInstanceFollowRedirects(flag);
        httpurlconnection.setReadTimeout(60000);
        httpurlconnection.setRequestProperty("User-Agent", b(context, s));
        httpurlconnection.setUseCaches(false);
    }

    public static void a(WebView webview)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            cp.a(webview);
        }
    }

    private static void a(JSONArray jsonarray, Object obj)
        throws JSONException
    {
        if (obj instanceof Bundle)
        {
            jsonarray.put(a((Bundle)obj));
            return;
        }
        if (obj instanceof Map)
        {
            jsonarray.put(m((Map)obj));
            return;
        }
        if (obj instanceof Collection)
        {
            jsonarray.put(a((Collection)obj));
            return;
        }
        if (obj instanceof Object[])
        {
            jsonarray.put(a((Object[])(Object[])obj));
            return;
        } else
        {
            jsonarray.put(obj);
            return;
        }
    }

    private static void a(JSONObject jsonobject, String s, Object obj)
        throws JSONException
    {
        if (obj instanceof Bundle)
        {
            jsonobject.put(s, a((Bundle)obj));
            return;
        }
        if (obj instanceof Map)
        {
            jsonobject.put(s, m((Map)obj));
            return;
        }
        if (obj instanceof Collection)
        {
            if (s == null)
            {
                s = "null";
            }
            jsonobject.put(s, a((Collection)obj));
            return;
        }
        if (obj instanceof Object[])
        {
            jsonobject.put(s, a(((Collection) (Arrays.asList((Object[])(Object[])obj)))));
            return;
        } else
        {
            jsonobject.put(s, obj);
            return;
        }
    }

    public static boolean a(PackageManager packagemanager, String s, String s1)
    {
        return packagemanager.checkPermission(s1, s) == 0;
    }

    public static boolean a(ClassLoader classloader, Class class1, String s)
    {
        boolean flag;
        try
        {
            flag = class1.isAssignableFrom(Class.forName(s, false, classloader));
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            return false;
        }
        return flag;
    }

    public static boolean at()
    {
        return iD;
    }

    public static int au()
    {
        return android.os.Build.VERSION.SDK_INT < 9 ? 0 : 6;
    }

    public static int av()
    {
        return android.os.Build.VERSION.SDK_INT < 9 ? 1 : 7;
    }

    static Object aw()
    {
        return hC;
    }

    private static String b(Context context, String s)
    {
label0:
        {
            synchronized (hC)
            {
                if (iE == null)
                {
                    break label0;
                }
                context = iE;
            }
            return context;
        }
        if (android.os.Build.VERSION.SDK_INT < 17) goto _L2; else goto _L1
_L1:
        iE = cq.getDefaultUserAgent(context);
_L4:
        iE = (new StringBuilder()).append(iE).append(" (Mobile; ").append(s).append(")").toString();
        context = iE;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
_L2:
        if (cs.ay())
        {
            break MISSING_BLOCK_LABEL_128;
        }
        cs.iI.post(new Runnable(context) {

            final Context hF;

            public void run()
            {
                synchronized (co.aw())
                {
                    co.p(co.k(hF));
                    co.aw().notifyAll();
                }
                return;
                exception;
                obj1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                hF = context;
                super();
            }
        });
_L5:
        context = iE;
        if (context != null) goto _L4; else goto _L3
_L3:
        hC.wait();
          goto _L5
        context;
        context = iE;
        obj;
        JVM INSTR monitorexit ;
        return context;
        iE = j(context);
          goto _L4
    }

    public static void b(WebView webview)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            cp.b(webview);
        }
    }

    public static boolean h(Context context)
    {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        context = context.getPackageManager().resolveActivity(intent, 0x10000);
        if (context == null || ((ResolveInfo) (context)).activityInfo == null)
        {
            ct.v("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean flag;
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x10) == 0)
        {
            ct.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "keyboard"
            }));
            flag = false;
        } else
        {
            flag = true;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x20) == 0)
        {
            ct.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "keyboardHidden"
            }));
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x80) == 0)
        {
            ct.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "orientation"
            }));
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x100) == 0)
        {
            ct.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "screenLayout"
            }));
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x200) == 0)
        {
            ct.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "uiMode"
            }));
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x400) == 0)
        {
            ct.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "screenSize"
            }));
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x800) == 0)
        {
            ct.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "smallestScreenSize"
            }));
            return false;
        } else
        {
            return flag;
        }
    }

    public static void i(Context context)
    {
        if (iF)
        {
            return;
        } else
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.USER_PRESENT");
            intentfilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new a(), intentfilter);
            iF = true;
            return;
        }
    }

    private static String j(Context context)
    {
        return (new WebView(context)).getSettings().getUserAgentString();
    }

    static String k(Context context)
    {
        return j(context);
    }

    static boolean k(boolean flag)
    {
        iD = flag;
        return flag;
    }

    public static JSONObject m(Map map)
        throws JSONException
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); a(jsonobject, s, map.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new JSONException((new StringBuilder()).append("Could not convert map to JSON: ").append(map.getMessage()).toString());
        }
        return jsonobject;
    }

    public static String o(String s)
    {
        return Uri.parse(s).buildUpon().query(null).build().toString();
    }

    static String p(String s)
    {
        iE = s;
        return s;
    }

}
