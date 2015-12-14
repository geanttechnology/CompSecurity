// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import android.content.SharedPreferences;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// Referenced classes of package com.packetzoom.speed:
//            n, e, l, PZHttpURLConnection, 
//            PZLogLevel

class Session
{

    private Object a_java_lang_Object_fld;
    private final String a_java_lang_String_fld = "libpz";
    private Pattern a_java_util_regex_Pattern_fld;
    private boolean a_boolean_fld;
    private String b_java_lang_String_fld;
    private Pattern b_java_util_regex_Pattern_fld;
    private boolean b_boolean_fld;
    private String c_java_lang_String_fld;
    private Pattern c_java_util_regex_Pattern_fld;
    private String d_java_lang_String_fld;
    private Pattern d_java_util_regex_Pattern_fld;
    private String e;
    private final String f = "(.*\\.(js|css|ico|gif|jpg|png|htc|html|ttf|eot|woff|svg|mp3|ogg|xml|json|zip|gz|tgz|bz2)$)|(.*_html*)";

    public Session(SharedPreferences sharedpreferences, String s, String s1, String s2, String s3)
    {
        a_boolean_fld = true;
        b_boolean_fld = true;
        d_java_lang_String_fld = s;
        e = s1;
        b_java_lang_String_fld = s3;
        c_java_lang_String_fld = s2;
        d_java_util_regex_Pattern_fld = Pattern.compile("(.*\\.(js|css|ico|gif|jpg|png|htc|html|ttf|eot|woff|svg|mp3|ogg|xml|json|zip|gz|tgz|bz2)$)|(.*_html*)", 2);
        (new Thread(new n(this, sharedpreferences))).start();
    }

    static Object a(Session session, Object obj)
    {
        session.a_java_lang_Object_fld = obj;
        return obj;
    }

    static String a(Session session)
    {
        return session.d_java_lang_String_fld;
    }

    private static InetAddress a(int i)
    {
        InetAddress inetaddress;
        try
        {
            inetaddress = InetAddress.getByAddress(a(i));
        }
        catch (UnknownHostException unknownhostexception)
        {
            return null;
        }
        return inetaddress;
    }

    private boolean a(String s)
    {
        if (b_java_util_regex_Pattern_fld == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (!b_java_util_regex_Pattern_fld.matcher(s).matches())
        {
            break MISSING_BLOCK_LABEL_49;
        }
        com.packetzoom.speed.e.a("libpz", (new StringBuilder("url: ")).append(s).append(" matches whitelist").toString());
        return true;
        try
        {
            com.packetzoom.speed.e.a("libpz", (new StringBuilder("header: ")).append(s).append(" not matches whitelist").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return false;
    }

    private static byte[] a(int i)
    {
        return (new byte[] {
            (byte)i, (byte)(i >>> 8), (byte)(i >>> 16), (byte)(i >>> 24)
        });
    }

    static String b(Session session)
    {
        return session.e;
    }

    private boolean b(String s)
    {
        if (c_java_util_regex_Pattern_fld == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (!c_java_util_regex_Pattern_fld.matcher(s).matches())
        {
            break MISSING_BLOCK_LABEL_49;
        }
        com.packetzoom.speed.e.a("libpz", (new StringBuilder("url: ")).append(s).append(" matches blacklist").toString());
        return true;
        try
        {
            com.packetzoom.speed.e.a("libpz", (new StringBuilder("header: ")).append(s).append(" not matches blacklist").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return false;
    }

    static String c(Session session)
    {
        return session.c_java_lang_String_fld;
    }

    static String d(Session session)
    {
        return session.b_java_lang_String_fld;
    }

    private native void didLostConnectivity(Object obj);

    private native int getDataServerIp(Object obj);

    private native int getInitServerIp(Object obj);

    private native int getInitStatus(Object obj);

    private native Object initiateRequest(Object obj, String s);

    private native boolean isHttpsAllowed(Object obj);

    private native boolean isPreferBlackList(Object obj);

    private native void nativeClearCache(Object obj);

    private native void refreshNetworkType(Object obj);

    private native void restartAppSession(Object obj);

    private native int sendAppSessionMetrics(Object obj);

    private native int sendNonPZMetrics(Object obj, int i, int j, String s, byte byte0, int k, int i1, 
            long l1, long l2);

    private native void setLogLevel(int i);

    int a()
    {
        if (a_java_lang_Object_fld != null)
        {
            return sendAppSessionMetrics(a_java_lang_Object_fld);
        } else
        {
            return -1;
        }
    }

    int a(int i, int j, String s, byte byte0, int k, int i1, long l1, long l2)
    {
        if (a_java_lang_Object_fld != null)
        {
            return sendNonPZMetrics(a_java_lang_Object_fld, i, j, s, byte0, k, i1, l1, l2);
        } else
        {
            return -1;
        }
    }

    void a()
    {
        if (isInitOk())
        {
            restartAppSession(a_java_lang_Object_fld);
        }
    }

    void b()
    {
        if (isInitOk())
        {
            refreshNetworkType(a_java_lang_Object_fld);
        }
    }

    public void clearCache()
    {
        nativeClearCache(a_java_lang_Object_fld);
    }

    public void didLostConnectivity()
    {
        if (isInitOk())
        {
            didLostConnectivity(a_java_lang_Object_fld);
        }
    }

    public void enforceFallback(boolean flag)
    {
        b_boolean_fld = flag;
    }

    public String getDataIpAddr()
    {
        InetAddress inetaddress = a(getDataServerIp(a_java_lang_Object_fld));
        if (inetaddress != null)
        {
            return inetaddress.getHostAddress();
        } else
        {
            return null;
        }
    }

    public String getInitIpAddr()
    {
        InetAddress inetaddress = a(getInitServerIp(a_java_lang_Object_fld));
        if (inetaddress != null)
        {
            return inetaddress.getHostAddress();
        } else
        {
            return null;
        }
    }

    public native Object init(SharedPreferences sharedpreferences, String s, String s1, String s2, String s3);

    public boolean isEnabled()
    {
        return a_boolean_fld;
    }

    public boolean isFallbackEnforced()
    {
        return b_boolean_fld;
    }

    public boolean isHttpsAllowed()
    {
        return isHttpsAllowed(a_java_lang_Object_fld);
    }

    public boolean isInitOk()
    {
        return a_java_lang_Object_fld != null && getInitStatus(a_java_lang_Object_fld) == 0;
    }

    public boolean isWhiteListed(String s)
    {
        if (!isPreferBlackList(a_java_lang_Object_fld)) goto _L2; else goto _L1
_L1:
        if (!b(s)) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        if (a(s))
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (a(s))
        {
            return true;
        }
        if (b(s)) goto _L3; else goto _L5
_L5:
        boolean flag;
        try
        {
            flag = d_java_util_regex_Pattern_fld.matcher(s).matches();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return false;
        }
        if (flag)
        {
            return true;
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    public HttpURLConnection newConnection(URL url, URLConnection urlconnection)
    {
        return new l(new PZHttpURLConnection(this, url), (HttpURLConnection)urlconnection, url, this);
    }

    public boolean pzHeadersCheck(String s)
    {
        if (a_java_util_regex_Pattern_fld == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (!a_java_util_regex_Pattern_fld.matcher(s).matches())
        {
            break MISSING_BLOCK_LABEL_49;
        }
        com.packetzoom.speed.e.a("libpz", (new StringBuilder("header: ")).append(s).append(" matches blacklist regexp").toString());
        return true;
        try
        {
            com.packetzoom.speed.e.a("libpz", (new StringBuilder("header: ")).append(s).append(" not matches blacklist regexp").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return false;
    }

    public Object requestURL(URL url)
    {
        return initiateRequest(a_java_lang_Object_fld, url.toString());
    }

    public void setBlackList(String s)
    {
        if (s == null || s.isEmpty())
        {
            break MISSING_BLOCK_LABEL_20;
        }
        c_java_util_regex_Pattern_fld = Pattern.compile(s, 2);
        return;
        s;
        s.printStackTrace();
        Log.e("libpz", "setBlackList::PatternSyntaxException");
        return;
    }

    public void setEnabled(boolean flag)
    {
        if (flag != a_boolean_fld)
        {
            a_boolean_fld = flag;
        }
    }

    public void setHeadersBlacklist(String s)
    {
        com.packetzoom.speed.e.a("libpz", (new StringBuilder("setting blacklist for headers: ")).append(s).toString());
        if (s == null || s.isEmpty())
        {
            break MISSING_BLOCK_LABEL_41;
        }
        a_java_util_regex_Pattern_fld = Pattern.compile(s, 2);
        return;
        PatternSyntaxException patternsyntaxexception;
        patternsyntaxexception;
        patternsyntaxexception.printStackTrace();
        Log.e("libpz", (new StringBuilder("PatternSyntaxException for: ")).append(s).toString());
        return;
    }

    public void setLogLevel(PZLogLevel pzloglevel)
    {
        setLogLevel(pzloglevel.ordinal());
    }

    public void setWhiteList(String s)
    {
        if (s == null || s.isEmpty())
        {
            break MISSING_BLOCK_LABEL_20;
        }
        b_java_util_regex_Pattern_fld = Pattern.compile(s, 2);
        return;
        s;
        s.printStackTrace();
        Log.e("libpz", "setWhiteList::PatternSyntaxException");
        return;
    }

    static 
    {
        System.loadLibrary("pzspeed");
    }
}
