// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.paypal.android.sdk:
//            fx, gc, gy, hl

public final class gb
{

    public static final gb a;
    public static final gb b;
    public static final gb c = (new gc(false)).b();
    private static final fx f[];
    final boolean d;
    final boolean e;
    private final String g[];
    private final String h[];

    private gb(gc gc1)
    {
        d = gc.a(gc1);
        g = gc.b(gc1);
        h = gc.c(gc1);
        e = gc.d(gc1);
    }

    gb(gc gc1, byte byte0)
    {
        this(gc1);
    }

    private List a()
    {
        gy agy[] = new gy[h.length];
        for (int i = 0; i < h.length; i++)
        {
            agy[i] = gy.a(h[i]);
        }

        return hl.a(agy);
    }

    private static boolean a(String as[], String as1[])
    {
        boolean flag1 = true;
        if (as != null && as1 != null && as.length != 0 && as1.length != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L6:
        return flag;
_L2:
        int k;
        k = as.length;
_L7:
        String s;
        int i;
        int j;
        int l;
        for (i = 0; i >= k;)
        {
            break MISSING_BLOCK_LABEL_102;
        }

        s = as[i];
        l = as1.length;
        j = 0;
_L8:
        if (j >= l)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (!hl.a(s, as1[j])) goto _L4; else goto _L3
_L3:
        j = 1;
_L9:
        flag = flag1;
        if (j != 0) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        j++;
          goto _L8
        j = 0;
          goto _L9
        return false;
          goto _L7
    }

    static String[] a(gb gb1)
    {
        return gb1.g;
    }

    static String[] b(gb gb1)
    {
        return gb1.h;
    }

    final void a(SSLSocket sslsocket, boolean flag)
    {
        Object obj = null;
        if (g != null)
        {
            obj = sslsocket.getEnabledCipherSuites();
            obj = (String[])hl.a(java/lang/String, g, ((Object []) (obj)));
        }
        if (flag && Arrays.asList(sslsocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV"))
        {
            String as[];
            if (obj == null)
            {
                obj = sslsocket.getEnabledCipherSuites();
            }
            as = new String[obj.length + 1];
            System.arraycopy(obj, 0, as, 0, obj.length);
            as[as.length - 1] = "TLS_FALLBACK_SCSV";
            obj = as;
        }
        as = sslsocket.getEnabledProtocols();
        as = (String[])hl.a(java/lang/String, h, as);
        obj = (new gc(this)).a(((String []) (obj))).b(as).b();
        sslsocket.setEnabledProtocols(((gb) (obj)).h);
        obj = ((gb) (obj)).g;
        if (obj != null)
        {
            sslsocket.setEnabledCipherSuites(((String []) (obj)));
        }
    }

    public final boolean a(SSLSocket sslsocket)
    {
        String as[];
        if (d)
        {
            if (a(h, as = sslsocket.getEnabledProtocols()))
            {
                if (g == null)
                {
                    if (sslsocket.getEnabledCipherSuites().length > 0)
                    {
                        return true;
                    }
                } else
                {
                    sslsocket = sslsocket.getEnabledCipherSuites();
                    return a(g, ((String []) (sslsocket)));
                }
            }
        }
        return false;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof gb)
        {
            if (obj == this)
            {
                return true;
            }
            obj = (gb)obj;
            if (d == ((gb) (obj)).d && (!d || Arrays.equals(g, ((gb) (obj)).g) && Arrays.equals(h, ((gb) (obj)).h) && e == ((gb) (obj)).e))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        int i = 17;
        if (d)
        {
            int j = Arrays.hashCode(g);
            int k = Arrays.hashCode(h);
            if (e)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            i += ((j + 527) * 31 + k) * 31;
        }
        return i;
    }

    public final String toString()
    {
        if (d)
        {
            Object obj;
            if (g == null)
            {
                obj = null;
            } else
            {
                obj = new fx[g.length];
                for (int i = 0; i < g.length; i++)
                {
                    obj[i] = fx.a(g[i]);
                }

                obj = hl.a(((Object []) (obj)));
            }
            if (obj == null)
            {
                obj = "[use default]";
            } else
            {
                obj = obj.toString();
            }
            return (new StringBuilder("ConnectionSpec(cipherSuites=")).append(((String) (obj))).append(", tlsVersions=").append(a()).append(", supportsTlsExtensions=").append(e).append(")").toString();
        } else
        {
            return "ConnectionSpec()";
        }
    }

    static 
    {
        f = (new fx[] {
            fx.m, fx.n, fx.h, fx.j, fx.i, fx.k, fx.l, fx.d, fx.c, fx.f, 
            fx.g, fx.b, fx.e, fx.a
        });
        a = (new gc(true)).a(f).a(new gy[] {
            gy.a, gy.b, gy.c
        }).a().b();
        b = (new gc(a)).a(new gy[] {
            gy.c
        }).a().b();
    }
}
