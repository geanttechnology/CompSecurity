// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.packetzoom.speed:
//            Session, e, PacketZoomInputStream

class PZHttpURLConnection extends HttpURLConnection
{

    private Session a_com_packetzoom_speed_Session_fld;
    private InputStream a_java_io_InputStream_fld;
    private Object a_java_lang_Object_fld;
    private final String a_java_lang_String_fld = "pz-did-use-speed";
    private Map a_java_util_Map_fld;
    private boolean a_boolean_fld;
    private InputStream b_java_io_InputStream_fld;
    private final String b_java_lang_String_fld = "true";

    public PZHttpURLConnection(Session session, URL url)
    {
        super(url);
        a_boolean_fld = false;
        a_java_io_InputStream_fld = null;
        b_java_io_InputStream_fld = null;
        a_com_packetzoom_speed_Session_fld = session;
    }

    private Object a()
    {
        if (a_java_lang_Object_fld == null)
        {
            a_java_lang_Object_fld = a_com_packetzoom_speed_Session_fld.requestURL(getURL());
        }
        return a_java_lang_Object_fld;
    }

    private void a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        inputstream;
        e.a("libpz", "error closing input stream", inputstream);
        return;
    }

    private boolean b()
    {
        return pzResponseCode(a()) >= 777;
    }

    private boolean c()
    {
        int i = pzResponseCode(a());
        return i == 0 || i > 199 && i < 300;
    }

    private native int headerCount(Object obj);

    private native String headerKey(Object obj, int i);

    private native String headerValue(Object obj, int i);

    private native int pzIndex(Object obj);

    private native int pzResponseCode(Object obj);

    private native String pzStats(Object obj);

    public int a()
    {
        return pzIndex(a_java_lang_Object_fld);
    }

    public String a()
    {
        return pzStats(a_java_lang_Object_fld);
    }

    public boolean a()
    {
        return a_boolean_fld;
    }

    public void connect()
    {
        e.a("libpz", "connect() entered");
    }

    public void disconnect()
    {
        this;
        JVM INSTR monitorenter ;
        a(a_java_io_InputStream_fld);
        a(b_java_io_InputStream_fld);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public InputStream getErrorStream()
    {
        if (c())
        {
            return null;
        }
        this;
        JVM INSTR monitorenter ;
        InputStream inputstream;
        if (b_java_io_InputStream_fld == null)
        {
            b_java_io_InputStream_fld = new PacketZoomInputStream(a());
        }
        inputstream = b_java_io_InputStream_fld;
        this;
        JVM INSTR monitorexit ;
        return inputstream;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getHeaderField(int i)
    {
        e.a("libpz", (new StringBuilder("getHeaderField pos:")).append(i).toString());
        if (getHeaderFields() != null && headerCount(a_java_lang_Object_fld) > i)
        {
            return headerValue(a_java_lang_Object_fld, i);
        } else
        {
            return null;
        }
    }

    public String getHeaderField(String s)
    {
        e.a("libpz", (new StringBuilder("getHeaderField:")).append(s).toString());
        if (s.equalsIgnoreCase("pz-stats"))
        {
            return a();
        }
        if (getHeaderFields() != null)
        {
            s = (List)a_java_util_Map_fld.get(s.toLowerCase(Locale.ENGLISH));
            if (s != null)
            {
                return (String)s.get(0);
            } else
            {
                return null;
            }
        } else
        {
            return null;
        }
    }

    public Map getHeaderFields()
    {
        if (a_java_util_Map_fld != null)
        {
            return a_java_util_Map_fld;
        }
        if (pzResponseCode(a()) >= 777)
        {
            e.a("libpz", "getHeaderFields: pz_failed");
            a_boolean_fld = true;
            return a_java_util_Map_fld;
        }
        int j = headerCount(a_java_lang_Object_fld);
        e.a("libpz", (new StringBuilder("got headerCount [")).append(j).append("]").toString());
        a_java_util_Map_fld = new HashMap();
        for (int i = 0; i < j; i++)
        {
            String s = headerKey(a(), i);
            LinkedList linkedlist1 = new LinkedList();
            linkedlist1.add(headerValue(a_java_lang_Object_fld, i));
            a_java_util_Map_fld.put(s.toLowerCase(Locale.ENGLISH), linkedlist1);
        }

        LinkedList linkedlist = new LinkedList();
        linkedlist.add("true".toLowerCase(Locale.ENGLISH));
        a_java_util_Map_fld.put("pz-did-use-speed".toLowerCase(Locale.ENGLISH), linkedlist);
        return a_java_util_Map_fld;
    }

    public InputStream getInputStream()
    {
        if (!c())
        {
            if (b() && a_com_packetzoom_speed_Session_fld.isFallbackEnforced())
            {
                e.a("libpz", "getInputStream: pz failed");
                a_boolean_fld = true;
                return null;
            }
            if (pzResponseCode(a()) == 404)
            {
                throw new FileNotFoundException();
            } else
            {
                throw new IOException((new StringBuilder("Request got error response code [")).append(getResponseCode()).append("]").toString());
            }
        }
        this;
        JVM INSTR monitorenter ;
        InputStream inputstream;
        if (a_java_io_InputStream_fld == null)
        {
            a_java_io_InputStream_fld = new BufferedInputStream(new PacketZoomInputStream(a()), 16384);
        }
        inputstream = a_java_io_InputStream_fld;
        this;
        JVM INSTR monitorexit ;
        return inputstream;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getResponseCode()
    {
        int i = pzResponseCode(a());
        if (i >= 777)
        {
            e.a("libpz", "getResponseCode: pz failed");
            a_boolean_fld = true;
        }
        return i;
    }

    public boolean usingProxy()
    {
        return false;
    }
}
