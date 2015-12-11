// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class arg
{

    private static arg a;
    private volatile arh b;
    private volatile String c;
    private volatile String d;
    private volatile String e;

    arg()
    {
        e();
    }

    static arg a()
    {
        arg;
        JVM INSTR monitorenter ;
        arg arg1;
        if (a == null)
        {
            a = new arg();
        }
        arg1 = a;
        arg;
        JVM INSTR monitorexit ;
        return arg1;
        Exception exception;
        exception;
        arg;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private String a(String s)
    {
        return s.split("&")[0].split("=")[1];
    }

    private String b(Uri uri)
    {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    boolean a(Uri uri)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        String s = URLDecoder.decode(uri.toString(), "UTF-8");
        if (!s.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) goto _L2; else goto _L1
_L1:
        aqv.d((new StringBuilder()).append("Container preview url: ").append(s).toString());
        if (!s.matches(".*?&gtm_debug=x$")) goto _L4; else goto _L3
_L3:
        b = arh.c;
_L6:
        e = b(uri);
        if (b == arh.b || b == arh.c)
        {
            d = (new StringBuilder()).append("/r?").append(e).toString();
        }
        c = a(e);
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
        uri;
        flag = false;
          goto _L5
_L4:
        b = arh.b;
          goto _L6
        uri;
        throw uri;
_L2:
label0:
        {
            if (!s.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
            {
                break label0;
            }
            if (!a(uri.getQuery()).equals(c))
            {
                break MISSING_BLOCK_LABEL_247;
            }
            aqv.d((new StringBuilder()).append("Exit preview mode for container: ").append(c).toString());
            b = arh.a;
            d = null;
        }
          goto _L5
        aqv.b((new StringBuilder()).append("Invalid preview uri: ").append(s).toString());
        flag = false;
          goto _L5
        flag = false;
          goto _L5
    }

    arh b()
    {
        return b;
    }

    String c()
    {
        return d;
    }

    String d()
    {
        return c;
    }

    void e()
    {
        b = arh.a;
        d = null;
        c = null;
        e = null;
    }
}
