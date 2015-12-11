// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a.a;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;
import org.a.a.a.a.b.b;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package org.a.a.a.a.a:
//            e

public final class c
    implements Serializable
{

    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final c j;
    public static final c k;
    public static final c l = a("*/*", (Charset)null);
    public static final c m;
    public static final c n;
    private final String o;
    private final Charset p;
    private final NameValuePair q[] = null;

    c(String s, Charset charset)
    {
        o = s;
        p = charset;
    }

    public static c a(String s)
    {
        return new c(s, (Charset)null);
    }

    public static c a(String s, Charset charset)
    {
        s = ((String)org.a.a.a.a.b.b.a(s, "MIME type")).toLowerCase(Locale.ROOT);
        org.a.a.a.a.b.b.a(b(s), "MIME type may not contain reserved characters");
        return new c(s, charset);
    }

    private static boolean b(String s)
    {
        for (int i1 = 0; i1 < s.length(); i1++)
        {
            char c1 = s.charAt(i1);
            if (c1 == '"' || c1 == ',' || c1 == ';')
            {
                return false;
            }
        }

        return true;
    }

    public String a()
    {
        return o;
    }

    public Charset b()
    {
        return p;
    }

    public String toString()
    {
        CharArrayBuffer chararraybuffer;
        chararraybuffer = new CharArrayBuffer(64);
        chararraybuffer.append(o);
        if (q == null) goto _L2; else goto _L1
_L1:
        chararraybuffer.append("; ");
        BasicHeaderValueFormatter.DEFAULT.formatParameters(chararraybuffer, q, false);
_L4:
        return chararraybuffer.toString();
_L2:
        if (p != null)
        {
            chararraybuffer.append("; charset=");
            chararraybuffer.append(p.name());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        a = a("application/atom+xml", e.c);
        b = a("application/x-www-form-urlencoded", e.c);
        c = a("application/json", e.a);
        d = a("application/octet-stream", (Charset)null);
        e = a("application/svg+xml", e.c);
        f = a("application/xhtml+xml", e.c);
        g = a("application/xml", e.c);
        h = a("multipart/form-data", e.c);
        i = a("text/html", e.c);
        j = a("text/plain", e.c);
        k = a("text/xml", e.c);
        m = j;
        n = d;
    }
}
