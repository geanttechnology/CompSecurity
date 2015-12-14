// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

// Referenced classes of package com.packetzoom.speed:
//            e, Session, l

class f extends URLStreamHandler
{

    private Session a_com_packetzoom_speed_Session_fld;
    private Method a_java_lang_reflect_Method_fld;
    private URLStreamHandler a_java_net_URLStreamHandler_fld;
    private Method b_java_lang_reflect_Method_fld;
    private URLStreamHandler b_java_net_URLStreamHandler_fld;

    public f(Session session, URLStreamHandler urlstreamhandler, URLStreamHandler urlstreamhandler1)
    {
        a_com_packetzoom_speed_Session_fld = session;
        a_java_net_URLStreamHandler_fld = urlstreamhandler;
        b_java_net_URLStreamHandler_fld = urlstreamhandler1;
        session = new Class[1];
        session[0] = java/net/URL;
        a_java_lang_reflect_Method_fld = urlstreamhandler.getClass().getDeclaredMethod("openConnection", session);
        a_java_lang_reflect_Method_fld.setAccessible(true);
        b_java_lang_reflect_Method_fld = urlstreamhandler1.getClass().getDeclaredMethod("openConnection", session);
        b_java_lang_reflect_Method_fld.setAccessible(true);
_L1:
        return;
        session;
        if (a_java_lang_reflect_Method_fld != null)
        {
            b_java_lang_reflect_Method_fld = a_java_lang_reflect_Method_fld;
            return;
        }
          goto _L1
    }

    protected URLConnection openConnection(URL url)
    {
        Object obj;
        Object obj1;
        long l1 = System.currentTimeMillis();
        boolean flag = "https".equals(url.getProtocol());
        obj1 = new StringBuilder("opening a new ");
        Object obj2;
        long l2;
        if (flag)
        {
            obj = "https";
        } else
        {
            obj = "http";
        }
        e.a("libpz", ((StringBuilder) (obj1)).append(((String) (obj))).append(" connection to:").append(url.toString()).toString());
        if (!flag) goto _L2; else goto _L1
_L1:
        try
        {
            obj1 = (URLConnection)b_java_lang_reflect_Method_fld.invoke(b_java_net_URLStreamHandler_fld, new Object[] {
                url
            });
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.e("libpz", "error trying to invoke default url connection", url);
            throw new IOException("wrapping base failed");
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.e("libpz", "error trying to invoke default url connection", url);
            throw new IOException("wrapping base failed");
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.e("libpz", "error trying to invoke default url connection", url);
            throw new IOException("wrapping base failed");
        }
        obj2 = null;
        obj = obj2;
        if (!a_com_packetzoom_speed_Session_fld.isEnabled())
        {
            break MISSING_BLOCK_LABEL_144;
        }
        obj = obj2;
        if (!a_com_packetzoom_speed_Session_fld.isInitOk())
        {
            break MISSING_BLOCK_LABEL_144;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj = obj2;
        if (!a_com_packetzoom_speed_Session_fld.isHttpsAllowed())
        {
            break MISSING_BLOCK_LABEL_144;
        }
        obj = a_com_packetzoom_speed_Session_fld.newConnection(url, ((URLConnection) (obj1)));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        url = new l((HttpURLConnection)obj1, url, a_com_packetzoom_speed_Session_fld);
_L3:
        l2 = System.currentTimeMillis();
        e.a("libpz", (new StringBuilder("openConnection ")).append(l2 - l1).append(" ms").toString());
        return url;
_L2:
        obj1 = (URLConnection)a_java_lang_reflect_Method_fld.invoke(a_java_net_URLStreamHandler_fld, new Object[] {
            url
        });
        break MISSING_BLOCK_LABEL_87;
        url = ((URL) (obj));
          goto _L3
    }
}
