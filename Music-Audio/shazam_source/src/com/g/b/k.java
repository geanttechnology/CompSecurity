// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.g.b:
//            h, aa

public final class k
{
    public static final class a
    {

        boolean a;
        String b[];
        String c[];
        boolean d;

        public final a a()
        {
            if (!a)
            {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            } else
            {
                d = true;
                return this;
            }
        }

        public final transient a a(aa aaa[])
        {
            if (!a)
            {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (aaa.length == 0)
            {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
            String as[] = new String[aaa.length];
            for (int i = 0; i < aaa.length; i++)
            {
                as[i] = aaa[i].e;
            }

            c = as;
            return this;
        }

        public final transient a a(String as[])
        {
            if (!a)
            {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (as == null)
            {
                b = null;
                return this;
            } else
            {
                b = (String[])as.clone();
                return this;
            }
        }

        public final transient a b(String as[])
        {
            if (!a)
            {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (as == null)
            {
                c = null;
                return this;
            } else
            {
                c = (String[])as.clone();
                return this;
            }
        }

        public final k b()
        {
            return new k(this, (byte)0);
        }

        public a(k k1)
        {
            a = k1.d;
            b = k.a(k1);
            c = k.b(k1);
            d = k1.g;
        }

        a(boolean flag)
        {
            a = flag;
        }
    }


    public static final k a;
    public static final k b;
    public static final k c = (new a(false)).b();
    private static final h h[];
    final boolean d;
    final String e[];
    final String f[];
    public final boolean g;

    private k(a a1)
    {
        d = a1.a;
        e = a1.b;
        f = a1.c;
        g = a1.d;
    }

    k(a a1, byte byte0)
    {
        this(a1);
    }

    private List a()
    {
        aa aaa[] = new aa[f.length];
        for (int i = 0; i < f.length; i++)
        {
            aaa[i] = aa.a(f[i]);
        }

        return com.g.b.a.k.a(aaa);
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
        int l;
        l = as.length;
_L7:
        String s;
        int i;
        int j;
        int i1;
        for (i = 0; i >= l;)
        {
            break MISSING_BLOCK_LABEL_102;
        }

        s = as[i];
        i1 = as1.length;
        j = 0;
_L8:
        if (j >= i1)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (!com.g.b.a.k.a(s, as1[j])) goto _L4; else goto _L3
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

    static String[] a(k k1)
    {
        return k1.e;
    }

    static String[] b(k k1)
    {
        return k1.f;
    }

    public final boolean a(SSLSocket sslsocket)
    {
        String as[];
        if (d)
        {
            if (a(f, as = sslsocket.getEnabledProtocols()))
            {
                if (e == null)
                {
                    if (sslsocket.getEnabledCipherSuites().length > 0)
                    {
                        return true;
                    }
                } else
                {
                    sslsocket = sslsocket.getEnabledCipherSuites();
                    return a(e, ((String []) (sslsocket)));
                }
            }
        }
        return false;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof k)
        {
            if (obj == this)
            {
                return true;
            }
            obj = (k)obj;
            if (d == ((k) (obj)).d && (!d || Arrays.equals(e, ((k) (obj)).e) && Arrays.equals(f, ((k) (obj)).f) && g == ((k) (obj)).g))
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
            int j = Arrays.hashCode(e);
            int l = Arrays.hashCode(f);
            if (g)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            i += ((j + 527) * 31 + l) * 31;
        }
        return i;
    }

    public final String toString()
    {
        if (d)
        {
            Object obj;
            if (e == null)
            {
                obj = null;
            } else
            {
                obj = new h[e.length];
                for (int i = 0; i < e.length; i++)
                {
                    obj[i] = com.g.b.h.a(e[i]);
                }

                obj = com.g.b.a.k.a(((Object []) (obj)));
            }
            if (obj == null)
            {
                obj = "[use default]";
            } else
            {
                obj = obj.toString();
            }
            return (new StringBuilder("ConnectionSpec(cipherSuites=")).append(((String) (obj))).append(", tlsVersions=").append(a()).append(", supportsTlsExtensions=").append(g).append(")").toString();
        } else
        {
            return "ConnectionSpec()";
        }
    }

    static 
    {
        h = (new h[] {
            h.aK, h.aO, h.W, h.am, h.al, h.av, h.aw, h.F, h.E, h.J, 
            h.U, h.D, h.H, h.h
        });
        a a1 = new a(true);
        h ah[] = h;
        if (!a1.a)
        {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String as[] = new String[ah.length];
        for (int i = 0; i < ah.length; i++)
        {
            as[i] = ah[i].aS;
        }

        a1.b = as;
        a = a1.a(new aa[] {
            aa.a, aa.b, aa.c
        }).a().b();
        b = (new a(a)).a(new aa[] {
            aa.c
        }).a().b();
    }
}
