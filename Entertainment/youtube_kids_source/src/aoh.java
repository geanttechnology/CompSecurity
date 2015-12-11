// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import java.nio.ByteBuffer;

public class aoh extends anw
{

    final aol a;
    private final aom h;
    private final long i;
    private final int j;
    private final int k;
    private Surface l;
    private boolean m;
    private boolean n;
    private long o;
    private long p;
    private int q;
    private int r;
    private int s;
    private float t;
    private int u;
    private int v;
    private float w;

    public aoh(aor aor, ara ara, boolean flag, int i1, long l1, aom aom1, 
            Handler handler, aol aol, int j1)
    {
        super(aor, ara, flag, handler, aol);
        j = i1;
        i = 1000L * l1;
        h = aom1;
        a = aol;
        k = j1;
        o = -1L;
        r = -1;
        s = -1;
        t = -1F;
        u = -1;
        v = -1;
        w = -1F;
    }

    private void a(MediaCodec mediacodec, int i1)
    {
        t();
        a.g("renderVideoBufferImmediate");
        mediacodec.releaseOutputBuffer(i1, true);
        a.c();
        mediacodec = b;
        mediacodec.e = ((ane) (mediacodec)).e + 1;
        u();
    }

    private void t()
    {
        if (d == null || a == null || u == r && v == s && w == t)
        {
            return;
        } else
        {
            int i1 = r;
            int j1 = s;
            float f = t;
            d.post(new aoi(this, i1, j1, f));
            u = i1;
            v = j1;
            w = f;
            return;
        }
    }

    private void u()
    {
        if (d == null || a == null || m)
        {
            return;
        } else
        {
            Surface surface = l;
            d.post(new aoj(this, surface));
            m = true;
            return;
        }
    }

    private void v()
    {
        if (d == null || a == null || q == 0)
        {
            return;
        } else
        {
            long l1 = SystemClock.elapsedRealtime();
            int i1 = q;
            long l2 = p;
            d.post(new aok(this, i1, l1 - l2));
            q = 0;
            p = l1;
            return;
        }
    }

    public final void a(int i1, Object obj)
    {
        if (i1 == 1)
        {
            obj = (Surface)obj;
            if (l != obj)
            {
                l = ((Surface) (obj));
                m = false;
                i1 = super.g;
                if (i1 == 2 || i1 == 3)
                {
                    k();
                    i();
                }
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
        super.a(l1);
        n = false;
        o = -1L;
    }

    protected final void a(long l1, boolean flag)
    {
        super.a(l1, flag);
        n = false;
        if (flag && i > 0L)
        {
            o = SystemClock.elapsedRealtime() * 1000L + i;
        }
        if (h != null)
        {
            h.a();
        }
    }

    protected final void a(MediaCodec mediacodec, MediaFormat mediaformat, MediaCrypto mediacrypto)
    {
        mediacodec.configure(mediaformat, l, mediacrypto, 0);
        mediacodec.setVideoScalingMode(j);
    }

    protected final void a(MediaFormat mediaformat)
    {
        int i1;
        int j1;
        if (mediaformat.containsKey("crop-right") && mediaformat.containsKey("crop-left") && mediaformat.containsKey("crop-bottom") && mediaformat.containsKey("crop-top"))
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            j1 = (mediaformat.getInteger("crop-right") - mediaformat.getInteger("crop-left")) + 1;
        } else
        {
            j1 = mediaformat.getInteger("width");
        }
        r = j1;
        if (i1 != 0)
        {
            i1 = (mediaformat.getInteger("crop-bottom") - mediaformat.getInteger("crop-top")) + 1;
        } else
        {
            i1 = mediaformat.getInteger("height");
        }
        s = i1;
    }

    protected final void a(aoo aoo1)
    {
        super.a(aoo1);
        float f;
        if (aoo1.a.e == -1F)
        {
            f = 1.0F;
        } else
        {
            f = aoo1.a.e;
        }
        t = f;
    }

    protected final boolean a(long l1, long l2, MediaCodec mediacodec, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo, 
            int i1, boolean flag)
    {
        if (flag)
        {
            a.g("skipVideoBuffer");
            mediacodec.releaseOutputBuffer(i1, false);
            a.c();
            mediacodec = b;
            mediacodec.f = ((ane) (mediacodec)).f + 1;
            return true;
        }
        long l3 = SystemClock.elapsedRealtime();
        l2 = bufferinfo.presentationTimeUs - l1 - (l3 * 1000L - l2);
        long l4 = System.nanoTime();
        l3 = 1000L * l2 + l4;
        l1 = l3;
        if (h != null)
        {
            l1 = h.a(bufferinfo.presentationTimeUs, l3);
            l2 = (l1 - l4) / 1000L;
        }
        if (l2 < -30000L)
        {
            a.g("dropVideoBuffer");
            mediacodec.releaseOutputBuffer(i1, false);
            a.c();
            mediacodec = b;
            mediacodec.g = ((ane) (mediacodec)).g + 1;
            q = q + 1;
            if (q == k)
            {
                v();
            }
            return true;
        }
        if (!n)
        {
            a(mediacodec, i1);
            n = true;
            return true;
        }
        if (super.g != 3)
        {
            return false;
        }
        if (atp.a >= 21)
        {
            if (l2 < 50000L)
            {
                t();
                a.g("releaseOutputBufferTimed");
                mediacodec.releaseOutputBuffer(i1, l1);
                a.c();
                mediacodec = b;
                mediacodec.e = ((ane) (mediacodec)).e + 1;
                u();
                return true;
            }
        } else
        if (l2 < 30000L)
        {
            if (l2 > 11000L)
            {
                try
                {
                    Thread.sleep((l2 - 10000L) / 1000L);
                }
                // Misplaced declaration of an exception variable
                catch (ByteBuffer bytebuffer)
                {
                    Thread.currentThread().interrupt();
                }
            }
            a(mediacodec, i1);
            return true;
        }
        return false;
    }

    public boolean a(MediaCodec mediacodec, boolean flag, aon aon1, aon aon2)
    {
        return aon2.a.equals(aon1.a) && (flag || aon1.c == aon2.c && aon1.d == aon2.d);
    }

    protected final boolean a(String s1)
    {
        return a.f(s1) && super.a(s1);
    }

    protected final void b()
    {
        super.b();
        q = 0;
        p = SystemClock.elapsedRealtime();
    }

    protected final void c()
    {
        o = -1L;
        v();
        super.c();
    }

    protected final boolean e()
    {
        if (!super.e()) goto _L2; else goto _L1
_L1:
        if (n) goto _L4; else goto _L3
_L3:
        boolean flag;
        if (super.e != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && super.f != 2) goto _L2; else goto _L4
_L4:
        o = -1L;
_L6:
        return true;
_L2:
        if (o == -1L)
        {
            return false;
        }
        if (SystemClock.elapsedRealtime() * 1000L >= o)
        {
            o = -1L;
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void g()
    {
        r = -1;
        s = -1;
        t = -1F;
        u = -1;
        v = -1;
        w = -1F;
        if (h != null)
        {
            h.b();
        }
        super.g();
    }

    protected final boolean j()
    {
        return super.j() && l != null;
    }
}
