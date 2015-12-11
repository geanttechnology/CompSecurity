// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Log;
import java.nio.ByteBuffer;

public final class ans extends anw
{

    final anv a;
    private final aov h = new aov();
    private int i;
    private long j;

    public ans(aor aor, ara ara, boolean flag, Handler handler, anv anv)
    {
        super(aor, ara, true, handler, anv);
        a = anv;
        i = 0;
    }

    public final void a(int k, Object obj)
    {
        if (k == 1)
        {
            h.a(((Float)obj).floatValue());
            return;
        } else
        {
            super.a(k, obj);
            return;
        }
    }

    protected final void a(long l)
    {
        super.a(l);
        h.d();
        j = 0x8000000000000000L;
    }

    protected final void a(long l, boolean flag)
    {
        super.a(l, flag);
        j = 0x8000000000000000L;
    }

    protected final void a(MediaFormat mediaformat)
    {
        aov aov1;
        int l;
        aov1 = h;
        l = mediaformat.getInteger("channel-count");
        l;
        JVM INSTR tableswitch 1 8: default 60
    //                   1 90
    //                   2 241
    //                   3 60
    //                   4 60
    //                   5 60
    //                   6 247
    //                   7 60
    //                   8 254;
           goto _L1 _L2 _L3 _L1 _L1 _L1 _L4 _L1 _L5
_L5:
        break MISSING_BLOCK_LABEL_254;
_L1:
        throw new IllegalArgumentException((new StringBuilder(38)).append("Unsupported channel count: ").append(l).toString());
_L2:
        int k = 4;
_L6:
        int i1 = mediaformat.getInteger("sample-rate");
        if (!aov1.a() || aov1.d != i1 || aov1.e != k || aov1.t)
        {
            aov1.d();
            aov1.f = 2;
            aov1.d = i1;
            aov1.e = k;
            aov1.t = false;
            aov1.u = 0;
            aov1.g = l * 2;
            aov1.h = AudioTrack.getMinBufferSize(i1, k, 2);
            k = aov1.h << 2;
            l = (int)aov1.c(0x3d090L) * aov1.g;
            i1 = (int)Math.max(aov1.h, aov1.c(0xb71b0L) * (long)aov1.g);
            if (k < l)
            {
                k = l;
            } else
            if (k > i1)
            {
                k = i1;
            }
            aov1.i = k;
        }
        return;
_L3:
        k = 12;
          goto _L6
_L4:
        k = 252;
          goto _L6
        k = 1020;
          goto _L6
    }

    protected final boolean a()
    {
        return true;
    }

    protected final boolean a(long l, long l1, MediaCodec mediacodec, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo, 
            int k, boolean flag)
    {
        if (flag)
        {
            mediacodec.releaseOutputBuffer(k, false);
            mediacodec = b;
            mediacodec.f = ((ane) (mediacodec)).f + 1;
            mediacodec = h;
            if (((aov) (mediacodec)).n == 1)
            {
                mediacodec.n = 2;
            }
            return true;
        }
        if (h.a()) goto _L2; else goto _L1
_L1:
        if (i == 0) goto _L4; else goto _L3
_L3:
        h.a(i);
_L7:
        if (super.g == 3)
        {
            h.b();
        }
_L2:
        aov aov1;
        int k1;
        int i2;
        aov1 = h;
        k1 = bufferinfo.offset;
        i2 = bufferinfo.size;
        l = bufferinfo.presentationTimeUs;
        if (i2 != 0) goto _L6; else goto _L5
_L5:
        int i1 = 2;
_L14:
        if ((i1 & 1) != 0)
        {
            j = 0x8000000000000000L;
        }
        int j1;
        if ((i1 & 2) != 0)
        {
            mediacodec.releaseOutputBuffer(k, false);
            mediacodec = b;
            mediacodec.e = ((ane) (mediacodec)).e + 1;
            return true;
        } else
        {
            return false;
        }
_L4:
        try
        {
            i = h.a(0);
            i1 = i;
        }
        // Misplaced declaration of an exception variable
        catch (MediaCodec mediacodec)
        {
            if (d != null && a != null)
            {
                d.post(new ant(this, mediacodec));
            }
            throw new ank(mediacodec);
        }
          goto _L7
_L6:
        j1 = 0;
        i1 = j1;
        if (aov1.s != 0) goto _L9; else goto _L8
_L8:
        if (aov1.t && aov1.u == 0)
        {
            aov1.u = ((i2 << 3) * aov1.d + 0xbb800) / 0x177000;
        }
        l -= aov1.b(aov1.a(i2));
        if (aov1.o != 0L) goto _L11; else goto _L10
_L10:
        aov1.o = Math.max(0L, l);
        aov1.n = 1;
        i1 = j1;
_L9:
        if (aov1.s == 0)
        {
            aov1.s = i2;
            bytebuffer.position(k1);
            if (atp.a < 21)
            {
                if (aov1.q == null || aov1.q.length < i2)
                {
                    aov1.q = new byte[i2];
                }
                bytebuffer.get(aov1.q, 0, i2);
                aov1.r = 0;
            }
        }
        j1 = 0;
        if (atp.a >= 21)
        {
            break MISSING_BLOCK_LABEL_726;
        }
        k1 = (int)(aov1.m - aov1.c.a() * (long)aov1.g);
        k1 = aov1.i - k1;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_533;
        }
        j1 = Math.min(aov1.s, k1);
        k1 = aov1.b.write(aov1.q, aov1.r, j1);
        j1 = k1;
        if (k1 < 0)
        {
            break MISSING_BLOCK_LABEL_533;
        }
        aov1.r = aov1.r + k1;
        j1 = k1;
_L13:
        if (j1 < 0)
        {
            try
            {
                throw new apa(j1);
            }
            // Misplaced declaration of an exception variable
            catch (MediaCodec mediacodec) { }
            if (d != null && a != null)
            {
                d.post(new anu(this, mediacodec));
            }
            throw new ank(mediacodec);
        }
        break MISSING_BLOCK_LABEL_747;
_L11:
        l1 = aov1.o + aov1.b(aov1.a(aov1.m));
        if (aov1.n == 1 && Math.abs(l1 - l) > 0x30d40L)
        {
            Log.e("AudioTrack", (new StringBuilder(80)).append("Discontinuity detected [expected ").append(l1).append(", got ").append(l).append("]").toString());
            aov1.n = 2;
        }
        i1 = j1;
        if (aov1.n != 2) goto _L9; else goto _L12
_L12:
        aov1.o = (l - l1) + aov1.o;
        aov1.n = 1;
        i1 = 1;
          goto _L9
        j1 = aov1.b.write(bytebuffer, aov1.s, 1);
          goto _L13
        aov1.s = aov1.s - j1;
        aov1.m = aov1.m + (long)j1;
        j1 = aov1.s;
        if (j1 == 0)
        {
            i1 |= 2;
        }
          goto _L14
    }

    protected final boolean a(String s)
    {
        return a.e(s) && super.a(s);
    }

    protected final void b()
    {
        super.b();
        h.b();
    }

    protected final void c()
    {
        aov aov1 = h;
        if (aov1.a())
        {
            aov1.f();
            aov1.b.pause();
        }
        super.c();
    }

    protected final boolean d()
    {
label0:
        {
            if (!super.d())
            {
                break label0;
            }
            if (h.c())
            {
                aov aov1 = h;
                boolean flag;
                if (aov1.m >= (long)aov1.h)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    protected final boolean e()
    {
        return h.c() || super.e() && super.f == 2;
    }

    protected final long f()
    {
        aov aov1 = h;
        boolean flag1 = d();
        boolean flag;
        long l;
        if (aov1.a() && aov1.o != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            l = 0x8000000000000000L;
        } else
        {
            if (aov1.b.getPlayState() == 3)
            {
                aov1.e();
            }
            l = System.nanoTime() / 1000L;
            if (aov1.l)
            {
                l = aov1.b(aov1.c(l - aov1.c.d() / 1000L) + aov1.c.e()) + aov1.o;
            } else
            {
                long l1;
                if (aov1.j == 0)
                {
                    l1 = aov1.c.b() + aov1.o;
                } else
                {
                    l1 = l + aov1.k + aov1.o;
                }
                l = l1;
                if (!flag1)
                {
                    l = l1 - aov1.p;
                }
            }
        }
        if (l == 0x8000000000000000L)
        {
            j = Math.max(j, super.f());
        } else
        {
            j = Math.max(j, l);
        }
        return j;
    }

    protected final void g()
    {
        i = 0;
        h.d();
        super.g();
        return;
        Exception exception;
        exception;
        super.g();
        throw exception;
    }
}
