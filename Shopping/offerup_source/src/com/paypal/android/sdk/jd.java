// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.net.ProtocolException;

// Referenced classes of package com.paypal.android.sdk:
//            ho, iw, ks, jb, 
//            hp, ij, hn, kt

final class jd
    implements ho
{

    private final ks a;
    private final boolean b;
    private final iw c;

    jd(ks ks1, boolean flag)
    {
        a = ks1;
        c = new iw(a);
        b = flag;
    }

    private static transient IOException a(String s, Object aobj[])
    {
        throw new IOException(String.format(s, aobj));
    }

    private void a(hp hp1, int i, int j)
    {
        boolean flag = true;
        int k = a.f();
        if (j != (k << 3) + 4)
        {
            throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] {
                Integer.valueOf(j), Integer.valueOf(k)
            });
        }
        jb jb1 = new jb();
        for (j = 0; j < k; j++)
        {
            int l = a.f();
            jb1.a(l & 0xffffff, (0xff000000 & l) >>> 24, a.f());
        }

        if ((i & 1) == 0)
        {
            flag = false;
        }
        hp1.a(flag, jb1);
    }

    public final void a()
    {
    }

    public final boolean a(hp hp1)
    {
        boolean flag = false;
        boolean flag1 = false;
        int i;
        int j;
        int k;
        int l;
        try
        {
            j = a.f();
            l = a.f();
        }
        // Misplaced declaration of an exception variable
        catch (hp hp1)
        {
            return false;
        }
        if ((0x80000000 & j) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        k = (0xff000000 & l) >>> 24;
        l = 0xffffff & l;
        if (i != 0)
        {
            i = (0x7fff0000 & j) >>> 16;
            if (i != 3)
            {
                throw new ProtocolException((new StringBuilder("version != 3: ")).append(i).toString());
            }
            switch (j & 0xffff)
            {
            case 5: // '\005'
            default:
                a.f(l);
                return true;

            case 1: // '\001'
                i = a.f();
                a.f();
                a.e();
                java.util.List list = c.a(l - 10);
                if ((k & 1) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if ((k & 2) != 0)
                {
                    flag1 = true;
                }
                hp1.a(flag1, flag, i & 0x7fffffff, list, ij.a);
                return true;

            case 2: // '\002'
                i = a.f();
                java.util.List list1 = c.a(l - 4);
                if ((k & 1) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                hp1.a(false, flag, i & 0x7fffffff, list1, ij.b);
                return true;

            case 3: // '\003'
                if (l != 8)
                {
                    throw a("TYPE_RST_STREAM length: %d != 8", new Object[] {
                        Integer.valueOf(l)
                    });
                }
                i = a.f();
                j = a.f();
                hn hn1 = hn.a(j);
                if (hn1 == null)
                {
                    throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                        Integer.valueOf(j)
                    });
                } else
                {
                    hp1.a(i & 0x7fffffff, hn1);
                    return true;
                }

            case 4: // '\004'
                a(hp1, k, l);
                return true;

            case 6: // '\006'
                if (l != 4)
                {
                    throw a("TYPE_PING length: %d != 4", new Object[] {
                        Integer.valueOf(l)
                    });
                }
                i = a.f();
                boolean flag2 = b;
                if ((i & 1) == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag2 == flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                hp1.a(flag, i, 0);
                return true;

            case 7: // '\007'
                if (l != 8)
                {
                    throw a("TYPE_GOAWAY length: %d != 8", new Object[] {
                        Integer.valueOf(l)
                    });
                }
                i = a.f();
                j = a.f();
                if (hn.c(j) == null)
                {
                    throw a("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                        Integer.valueOf(j)
                    });
                } else
                {
                    hp1.a(i & 0x7fffffff, kt.a);
                    return true;
                }

            case 8: // '\b'
                hp1.a(false, false, a.f() & 0x7fffffff, c.a(l - 4), ij.c);
                return true;

            case 9: // '\t'
                break;
            }
            if (l != 8)
            {
                throw a("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] {
                    Integer.valueOf(l)
                });
            }
            i = a.f();
            long l1 = a.f() & 0x7fffffff;
            if (l1 == 0L)
            {
                throw a("windowSizeIncrement was 0", new Object[] {
                    Long.valueOf(l1)
                });
            } else
            {
                hp1.a(i & 0x7fffffff, l1);
                return true;
            }
        }
        if ((k & 1) != 0)
        {
            flag = true;
        }
        hp1.a(flag, j & 0x7fffffff, a, l);
        return true;
    }

    public final void close()
    {
        c.a();
    }
}
