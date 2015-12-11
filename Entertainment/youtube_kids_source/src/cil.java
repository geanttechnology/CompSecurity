// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.libraries.youtube.media.m2ts.NativeM2TSPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Queue;

public final class cil extends aou
{

    private final aor a;
    private final aoo b = new aoo();
    private final aoq c[] = new aoq[7];
    private int d;
    private int e;
    private boolean f;
    private long h;
    private long i;
    private NativeM2TSPlayer j;
    private cij k;
    private float l;

    public cil(aor aor1)
    {
        int i1 = 0;
        super();
        boolean flag;
        if (atp.a >= 9)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        a = aor1;
        do
        {
            aor1 = c;
            if (i1 < 7)
            {
                c[i1] = new aoq(1);
                i1++;
            } else
            {
                l = 1.0F;
                return;
            }
        } while (true);
    }

    private void i()
    {
        if (j != null)
        {
            j.b();
        }
        NativeM2TSPlayer nativem2tsplayer;
        try
        {
            j = new NativeM2TSPlayer();
        }
        catch (cim cim1)
        {
            bmo.b("Couldn't create the native player.");
            j = null;
            return;
        }
        k = new cij(j, b.a);
        nativem2tsplayer = j;
        NativeM2TSPlayer.a(l);
        if (super.g == 3)
        {
            j.a();
        }
    }

    private void j()
    {
        int i1 = 0;
        d = 0;
        for (; i1 < 7; i1++)
        {
            if (c[i1].b != null)
            {
                c[i1].b.clear();
            }
        }

    }

    public final void a(int i1, Object obj)
    {
        if (i1 == 1)
        {
            float f1 = ((Float)obj).floatValue();
            l = f1;
            if (j != null)
            {
                obj = j;
                NativeM2TSPlayer.a(f1);
            }
            return;
        } else
        {
            super.a(i1, obj);
            return;
        }
    }

    protected final void a(long l1)
    {
        a.b(l1);
        j();
        f = false;
        h = l1;
        i = l1;
        i();
    }

    protected final void a(long l1, long l2)
    {
        a.a(l1);
        if (j == null) goto _L2; else goto _L1
_L1:
        Object obj = j;
        if (((NativeM2TSPlayer) (obj)).a.size() != 0) goto _L4; else goto _L3
_L3:
        if (((NativeM2TSPlayer) (obj)).b)
        {
            NativeM2TSPlayer.enqueueEos();
            obj.d = true;
        }
          goto _L5
_L2:
        if (f) goto _L7; else goto _L6
_L6:
        ByteBuffer bytebuffer;
        Object aobj[];
        Object obj1;
        int i1;
        int j1;
        if (i - f() > 0x4c4b40L)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
          goto _L8
_L4:
        try
        {
            bytebuffer = NativeM2TSPlayer.getUnusedBuffer();
        }
        catch (IOException ioexception)
        {
            throw new ank(ioexception);
        }
        if (bytebuffer == null)
        {
            i1 = 0;
            continue; /* Loop/switch isn't completed */
        }
        bytebuffer.clear();
        for (; ((NativeM2TSPlayer) (obj)).a.size() > 0 && bytebuffer.position() + 188 <= bytebuffer.capacity(); bytebuffer.put((byte[])((NativeM2TSPlayer) (obj)).a.remove())) { }
        NativeM2TSPlayer.enqueueBuffer(bytebuffer, bytebuffer.position());
        i1 = 1;
        continue; /* Loop/switch isn't completed */
_L22:
        a.a(e, f(), b, c[d], false);
        JVM INSTR tableswitch -5 -1: default 688
    //                   -5 651
    //                   -4 252
    //                   -3 278
    //                   -2 694
    //                   -1 259;
           goto _L9 _L10 _L11 _L12 _L13 _L14
_L11:
        i();
          goto _L9
_L14:
        f = true;
        j.b = true;
        i1 = 0;
          goto _L15
_L12:
        i = c[d].e;
        d = d + 1;
        if (d != 7) goto _L17; else goto _L16
_L16:
        ioexception = k;
        aobj = c;
        j1 = d;
        obj1 = new byte[j1][];
        i1 = 0;
_L19:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1[i1] = cih.a(aobj[i1], ((cij) (ioexception)).b);
        i1++;
        if (true) goto _L19; else goto _L18
_L18:
        obj1 = a.a(((byte [][]) (obj1)));
        l1 = (aobj[0].e * 9L) / 100L;
        i1 = obj1.length + 8;
        aobj = a.a(new byte[][] {
            new byte[] {
                0, 0, 1, -64, (byte)(i1 >> 8), (byte)i1, -128, -128, 5, (byte)(int)(33L | l1 >> 30), 
                (byte)(int)(l1 >> 22 & 255L), (byte)(int)(1L | l1 >> 14 & 254L), (byte)(int)(l1 >> 7 & 255L), (byte)(int)(l1 << 1 & 254L | 1L)
            }, obj1
        });
        ((cij) (ioexception)).a.a(ioexception.a(a.a(((byte []) (aobj)), 0, 176), l1, true));
        i1 = 176;
_L21:
        if (i1 >= aobj.length)
        {
            break; /* Loop/switch isn't completed */
        }
        int k1 = Math.min(182, aobj.length - i1);
        ((cij) (ioexception)).a.a(ioexception.a(a.a(((byte []) (aobj)), i1, k1), -1L, false));
        i1 += 182;
        if (true) goto _L21; else goto _L20
_L20:
        j();
_L17:
        i1 = 1;
          goto _L15
_L10:
        i1 = 1;
          goto _L15
_L5:
        i1 = 0;
        if (i1 != 0) goto _L1; else goto _L2
_L8:
        if (i1 == 0) goto _L22; else goto _L7
_L7:
        i1 = 0;
_L15:
        if (i1 != 0) goto _L2; else goto _L23
_L23:
        return;
_L9:
        i1 = 1;
          goto _L15
_L13:
        i1 = 0;
          goto _L15
    }

    protected final void a(long l1, boolean flag)
    {
        a.a(e, l1);
        j();
        f = false;
        h = l1;
        i = l1;
    }

    protected final boolean a()
    {
        return true;
    }

    protected final void b()
    {
        if (j != null)
        {
            j.a();
        }
    }

    protected final void c()
    {
        if (j != null)
        {
            boolean flag;
            if (!j.c)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b.b(flag);
            NativeM2TSPlayer.setPlaybackState(false);
        }
    }

    protected final boolean d()
    {
        if (j == null)
        {
            return false;
        } else
        {
            return j.d;
        }
    }

    protected final boolean e()
    {
        return j != null;
    }

    protected final long f()
    {
        if (j != null)
        {
            NativeM2TSPlayer nativem2tsplayer = j;
            long l1 = NativeM2TSPlayer.c();
            if (l1 > 0L)
            {
                h = l1;
            }
        }
        return h;
    }

    protected final void g()
    {
        a.b(e);
    }

    protected final int h()
    {
        int i1;
        try
        {
            a.a();
        }
        catch (IOException ioexception)
        {
            throw new ank(ioexception);
        }
        for (i1 = 0; i1 < a.b(); i1++)
        {
            if (a.e(a.a(0).a))
            {
                e = 0;
                return 1;
            }
        }

        return -1;
    }

    protected final void l()
    {
        if (j != null)
        {
            j.b();
            j = null;
        }
        a.d();
    }

    protected final long m()
    {
        return a.a(e).b;
    }

    protected final long n()
    {
        long l1 = a.c();
        if (l1 == -1L || l1 == -3L)
        {
            return l1;
        } else
        {
            return Math.max(l1, f());
        }
    }
}
