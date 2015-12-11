// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.paypal.android.sdk:
//            ho, io, il, ks, 
//            in, kt, ip, hp, 
//            ij, hn, jb

final class iq
    implements ho
{

    private final ks a;
    private final io b;
    private final boolean c;
    private il d;

    iq(ks ks1, boolean flag)
    {
        a = ks1;
        c = flag;
        b = new io(a);
        d = new il(4096, b);
    }

    private List a(int i, short word0, byte byte0, int j)
    {
        io io1 = b;
        b.d = i;
        io1.a = i;
        b.e = word0;
        b.b = byte0;
        b.c = j;
        d.a();
        return d.b();
    }

    private void b()
    {
        a.f();
        a.d();
    }

    public final void a()
    {
        if (!c)
        {
            kt kt1 = a.c(in.a().b.length);
            if (in.b().isLoggable(Level.FINE))
            {
                in.b().fine(String.format("<< CONNECTION %s", new Object[] {
                    kt1.b()
                }));
            }
            if (!in.a().equals(kt1))
            {
                throw in.a("Expected a connection header but was %s", new Object[] {
                    kt1.a()
                });
            }
        }
    }

    public final boolean a(hp hp1)
    {
        int i;
        boolean flag;
        int i2;
        boolean flag2;
        boolean flag6;
        flag2 = true;
        flag = false;
        flag6 = false;
        i = 0;
        try
        {
            a.a(9L);
            break MISSING_BLOCK_LABEL_24;
        }
        // Misplaced declaration of an exception variable
        catch (hp hp1)
        {
            flag2 = false;
        }
_L12:
        return flag2;
        byte byte0;
        byte byte1;
        int l1;
        i2 = in.a(a);
        if (i2 < 0 || i2 > 16384)
        {
            throw in.a("FRAME_SIZE_ERROR: %s", new Object[] {
                Integer.valueOf(i2)
            });
        }
        byte0 = a.d();
        byte1 = a.d();
        l1 = a.f() & 0x7fffffff;
        if (in.b().isLoggable(Level.FINE))
        {
            in.b().fine(ip.a(true, l1, i2, byte0, byte1));
        }
        byte0;
        JVM INSTR tableswitch 0 8: default 184
    //                   0 198
    //                   1 307
    //                   2 420
    //                   3 465
    //                   4 557
    //                   5 862
    //                   6 943
    //                   7 1032
    //                   8 1163;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        a.f(i2);
        return true;
_L2:
        boolean flag1;
        boolean flag3;
        if ((byte1 & 1) != 0)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if ((byte1 & 0x20) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            throw in.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        if ((byte1 & 8) != 0)
        {
            i = (short)(a.d() & 0xff);
        }
        int j = in.a(i2, byte1, i);
        hp1.a(flag3, l1, a, j);
        a.f(i);
        return true;
_L3:
        if (l1 == 0)
        {
            throw in.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        int k;
        boolean flag4;
        if ((byte1 & 1) != 0)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        if ((byte1 & 8) != 0)
        {
            i = (short)(a.d() & 0xff);
        } else
        {
            i = 0;
        }
        k = i2;
        if ((byte1 & 0x20) != 0)
        {
            b();
            k = i2 - 5;
        }
        hp1.a(false, flag4, l1, a(in.a(k, byte1, i), i, byte1, l1), ij.d);
        return true;
_L4:
        if (i2 != 5)
        {
            throw in.a("TYPE_PRIORITY length: %d != 5", new Object[] {
                Integer.valueOf(i2)
            });
        }
        if (l1 == 0)
        {
            throw in.a("TYPE_PRIORITY streamId == 0", new Object[0]);
        } else
        {
            b();
            return true;
        }
_L5:
        if (i2 != 4)
        {
            throw in.a("TYPE_RST_STREAM length: %d != 4", new Object[] {
                Integer.valueOf(i2)
            });
        }
        if (l1 == 0)
        {
            throw in.a("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int l = a.f();
        hn hn1 = hn.b(l);
        if (hn1 == null)
        {
            throw in.a("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                Integer.valueOf(l)
            });
        } else
        {
            hp1.a(l1, hn1);
            return true;
        }
_L6:
        if (l1 != 0)
        {
            throw in.a("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((byte1 & 1) == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i2 != 0)
        {
            throw in.a("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        }
        if (true) goto _L12; else goto _L11
_L11:
        jb jb1;
        int i1;
        if (i2 % 6 != 0)
        {
            throw in.a("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] {
                Integer.valueOf(i2)
            });
        }
        jb1 = new jb();
        i1 = 0;
_L21:
        if (i1 >= i2) goto _L14; else goto _L13
_L13:
        int j2;
        i = a.e();
        j2 = a.f();
        l1 = i;
        i;
        JVM INSTR tableswitch 1 6: default 704
    //                   1 754
    //                   2 722
    //                   3 751
    //                   4 775
    //                   5 794
    //                   6 754;
           goto _L15 _L16 _L17 _L18 _L19 _L20 _L16
_L16:
        break; /* Loop/switch isn't completed */
_L15:
        throw in.a("PROTOCOL_ERROR invalid settings id: %s", new Object[] {
            Short.valueOf(i)
        });
_L17:
        l1 = i;
        if (j2 != 0)
        {
            l1 = i;
            if (j2 != 1)
            {
                throw in.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            }
        }
        break; /* Loop/switch isn't completed */
_L18:
        l1 = 4;
_L23:
        jb1.a(l1, 0, j2);
        i1 += 6;
          goto _L21
_L19:
        l1 = 7;
        if (j2 >= 0) goto _L23; else goto _L22
_L22:
        throw in.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
_L20:
        if (j2 < 16384)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = i;
        if (j2 <= 0xffffff) goto _L23; else goto _L24
_L24:
        throw in.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] {
            Integer.valueOf(j2)
        });
_L14:
        hp1.a(false, jb1);
        if (jb1.c() >= 0)
        {
            d.a(jb1.c());
            return true;
        }
          goto _L12
_L7:
        if (l1 == 0)
        {
            throw in.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short word0 = flag;
        if ((byte1 & 8) != 0)
        {
            word0 = (short)(a.d() & 0xff);
        }
        hp1.a(a.f() & 0x7fffffff, a(in.a(i2 - 4, byte1, word0), word0, byte1, l1));
        return true;
_L8:
        if (i2 != 8)
        {
            throw in.a("TYPE_PING length != 8: %s", new Object[] {
                Integer.valueOf(i2)
            });
        }
        if (l1 != 0)
        {
            throw in.a("TYPE_PING streamId != 0", new Object[0]);
        }
        int j1 = a.f();
        l1 = a.f();
        boolean flag5 = flag6;
        if ((byte1 & 1) != 0)
        {
            flag5 = true;
        }
        hp1.a(flag5, j1, l1);
        return true;
_L9:
        if (i2 < 8)
        {
            throw in.a("TYPE_GOAWAY length < 8: %s", new Object[] {
                Integer.valueOf(i2)
            });
        }
        if (l1 != 0)
        {
            throw in.a("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int k1 = a.f();
        l1 = a.f();
        i2 -= 8;
        if (hn.b(l1) == null)
        {
            throw in.a("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                Integer.valueOf(l1)
            });
        }
        kt kt1 = kt.a;
        if (i2 > 0)
        {
            kt1 = a.c(i2);
        }
        hp1.a(k1, kt1);
        return true;
_L10:
        if (i2 != 4)
        {
            throw in.a("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] {
                Integer.valueOf(i2)
            });
        }
        long l2 = (long)a.f() & 0x7fffffffL;
        if (l2 == 0L)
        {
            throw in.a("windowSizeIncrement was 0", new Object[] {
                Long.valueOf(l2)
            });
        } else
        {
            hp1.a(l1, l2);
            return true;
        }
    }

    public final void close()
    {
        a.close();
    }
}
