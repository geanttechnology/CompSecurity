// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.TimeZone;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.packetzoom.speed:
//            g, e, Session, a, 
//            f, PZLogLevel

public class PacketZoomClient
    implements URLStreamHandlerFactory
{

    private static PacketZoomClient a_com_packetzoom_speed_PacketZoomClient_static_fld;
    static Session a_com_packetzoom_speed_Session_static_fld;
    private static final String a_java_lang_String_static_fld = com/packetzoom/speed/PacketZoomClient.getName();
    private f a_com_packetzoom_speed_f_fld;
    private g a_com_packetzoom_speed_g_fld;
    private URLStreamHandler a_java_net_URLStreamHandler_fld;
    private URLStreamHandler b;

    private PacketZoomClient(Context context, String s, String s1)
    {
        a_com_packetzoom_speed_g_fld = new g();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (s.isEmpty() || s1 == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (s1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        e.a(a_java_lang_String_static_fld, "checked appId and appKey");
        a(context);
        this;
        JVM INSTR monitorenter ;
        if (a_com_packetzoom_speed_Session_static_fld == null)
        {
            a_com_packetzoom_speed_Session_static_fld = new Session(a(context), s, s1, b(context), a(context));
        }
        this;
        JVM INSTR monitorexit ;
        try
        {
            a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            e.a(a_java_lang_String_static_fld, Log.getStackTraceString(context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            e.a(a_java_lang_String_static_fld, Log.getStackTraceString(context));
        }
        break MISSING_BLOCK_LABEL_129;
        Log.e(a_java_lang_String_static_fld, "incorrect or missing appId/appKey");
        return;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }

    static SharedPreferences a(Context context)
    {
        return context.getSharedPreferences("PacketZoomClient", 0);
    }

    static PacketZoomClient a()
    {
        return a_com_packetzoom_speed_PacketZoomClient_static_fld;
    }

    static String a()
    {
        return a_java_lang_String_static_fld;
    }

    private String a(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private static URLStreamHandler a(String s)
    {
        Object obj;
        try
        {
            obj = new URL(s);
            Field field = obj.getClass().getDeclaredField("streamHandler");
            field.setAccessible(true);
            obj = (URLStreamHandler)field.get(obj);
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(a_java_lang_String_static_fld, (new StringBuilder("couldn't get URLStreamHandler for: ")).append(s).toString());
            return null;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.e(a_java_lang_String_static_fld, (new StringBuilder("couldn't get URLStreamHandler for: ")).append(s).toString());
            return null;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            Log.e(a_java_lang_String_static_fld, (new StringBuilder("couldn't get URLStreamHandler for: ")).append(s).toString());
            return null;
        }
        catch (RuntimeException runtimeexception)
        {
            Log.e(a_java_lang_String_static_fld, (new StringBuilder("couldn't get URLStreamHandler for: ")).append(s).toString());
            return null;
        }
        catch (Exception exception)
        {
            Log.e(a_java_lang_String_static_fld, (new StringBuilder("couldn't get URLStreamHandler for: ")).append(s).toString());
            return null;
        }
        return ((URLStreamHandler) (obj));
    }

    private void a()
    {
        a_java_net_URLStreamHandler_fld = a("http://www.google.com");
        e.a(a_java_lang_String_static_fld, (new StringBuilder("set original http handler to [")).append(a_java_net_URLStreamHandler_fld.getClass().getCanonicalName()).append("]").toString());
        b = a("https://www.google.com");
        e.a(a_java_lang_String_static_fld, (new StringBuilder("set original https handler to [")).append(b.getClass().getCanonicalName()).append("]").toString());
    }

    private void a(Context context)
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        android.content.SharedPreferences.Editor editor = a(context).edit();
        String s = context.getPackageName();
        editor.putString("package_id", s);
        editor.putString("timezone", TimeZone.getDefault().getID());
        editor.putString("app_version", context.getPackageManager().getPackageInfo(s, 0).versionName);
        if (networkinfo != null && networkinfo.isConnected())
        {
            editor.putLong("network_type", networkinfo.getType());
            editor.putLong("network_subtype", networkinfo.getSubtype());
            editor.commit();
        }
    }

    private static boolean a()
    {
        File file = new File("/system/lib/libhoudini.so");
        return file.exists() && !file.isDirectory();
    }

    private String b(Context context)
    {
        return (new StringBuilder()).append(context.getCacheDir()).append("/PZCACHE").toString();
    }

    public static HttpClient createHttpClient()
    {
        return (new a()).a(new DefaultHttpClient(), a_com_packetzoom_speed_Session_static_fld);
    }

    public static HttpClient createHttpClient(HttpParams httpparams)
    {
        return (new a()).a(new DefaultHttpClient(httpparams), a_com_packetzoom_speed_Session_static_fld);
    }

    public static void enforceFallback(boolean flag)
    {
        if (a_com_packetzoom_speed_PacketZoomClient_static_fld != null && a_com_packetzoom_speed_Session_static_fld != null)
        {
            a_com_packetzoom_speed_Session_static_fld.enforceFallback(flag);
        }
    }

    public static String getDataServerIp()
    {
        if (a_com_packetzoom_speed_Session_static_fld != null && a_com_packetzoom_speed_Session_static_fld.isInitOk())
        {
            return a_com_packetzoom_speed_Session_static_fld.getDataIpAddr();
        } else
        {
            return null;
        }
    }

    public static String getInitServerIp()
    {
        if (a_com_packetzoom_speed_Session_static_fld != null && a_com_packetzoom_speed_Session_static_fld.isInitOk())
        {
            return a_com_packetzoom_speed_Session_static_fld.getInitIpAddr();
        } else
        {
            return null;
        }
    }

    public static void init(Context context, String s, String s1)
    {
        com/packetzoom/speed/PacketZoomClient;
        JVM INSTR monitorenter ;
        boolean flag;
        int i;
        if (!Build.CPU_ABI.contains("x86") && !Build.CPU_ABI2.contains("x86") && !Build.CPU_ABI.contains("arm64") && !a())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14 && !flag) goto _L2; else goto _L1
_L1:
        com/packetzoom/speed/PacketZoomClient;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (a_com_packetzoom_speed_PacketZoomClient_static_fld != null) goto _L1; else goto _L3
_L3:
        a_com_packetzoom_speed_PacketZoomClient_static_fld = new PacketZoomClient(context, s, s1);
        if (a_com_packetzoom_speed_Session_static_fld != null)
        {
            URL.setURLStreamHandlerFactory(a_com_packetzoom_speed_PacketZoomClient_static_fld);
        }
        if (context instanceof Activity)
        {
            ((Activity)context).getApplication().registerActivityLifecycleCallbacks(a_com_packetzoom_speed_PacketZoomClient_static_fld.a_com_packetzoom_speed_g_fld);
        }
          goto _L1
        context;
        context.printStackTrace();
        Log.e(a_java_lang_String_static_fld, (new StringBuilder("failed to init PZ: ")).append(context.getMessage()).toString());
          goto _L1
        context;
        throw context;
        context;
        Log.e(a_java_lang_String_static_fld, (new StringBuilder("failed to init PZ: ")).append(context.getMessage()).toString());
          goto _L1
    }

    public static boolean isEnabled()
    {
        if (a_com_packetzoom_speed_PacketZoomClient_static_fld != null && a_com_packetzoom_speed_Session_static_fld != null)
        {
            return a_com_packetzoom_speed_Session_static_fld.isEnabled();
        } else
        {
            return false;
        }
    }

    public static boolean isSessionValid()
    {
        return a_com_packetzoom_speed_Session_static_fld != null && a_com_packetzoom_speed_Session_static_fld.isInitOk();
    }

    public static void setEnabled(boolean flag)
    {
        if (a_com_packetzoom_speed_PacketZoomClient_static_fld != null && a_com_packetzoom_speed_Session_static_fld != null)
        {
            a_com_packetzoom_speed_Session_static_fld.setEnabled(flag);
        }
    }

    public static void setLogLevel(PZLogLevel pzloglevel)
    {
        e.a(pzloglevel);
        if (a_com_packetzoom_speed_PacketZoomClient_static_fld != null && a_com_packetzoom_speed_Session_static_fld != null)
        {
            a_com_packetzoom_speed_Session_static_fld.setLogLevel(pzloglevel);
        }
    }

    public void clearCache()
    {
        if (a_com_packetzoom_speed_Session_static_fld != null)
        {
            a_com_packetzoom_speed_Session_static_fld.clearCache();
        }
    }

    public URLStreamHandler createURLStreamHandler(String s)
    {
        e.a(a_java_lang_String_static_fld, (new StringBuilder("got scheme: ")).append(s).toString());
        if (s.equalsIgnoreCase("http") || s.equalsIgnoreCase("https"))
        {
            e.a(a_java_lang_String_static_fld, "doing some http-specific stuff");
            a_com_packetzoom_speed_f_fld = new f(a_com_packetzoom_speed_Session_static_fld, a_java_net_URLStreamHandler_fld, b);
            return a_com_packetzoom_speed_f_fld;
        } else
        {
            return null;
        }
    }

}
