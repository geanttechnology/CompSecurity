// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.util.Log;
import java.lang.reflect.Method;

public final class aov
{

    private long A;
    private float B;
    final ConditionVariable a = new ConditionVariable(true);
    public AudioTrack b;
    public aox c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public boolean l;
    public long m;
    public int n;
    public long o;
    public long p;
    public byte q[];
    public int r;
    public int s;
    public boolean t;
    public int u;
    private final long v[] = new long[10];
    private int w;
    private long x;
    private long y;
    private Method z;

    public aov()
    {
        if (atp.a >= 18)
        {
            try
            {
                z = android/media/AudioTrack.getMethod("getLatency", null);
            }
            catch (NoSuchMethodException nosuchmethodexception) { }
        }
        B = 1.0F;
        n = 0;
    }

    public final int a(int i1)
    {
        a.block();
        if (i1 == 0)
        {
            b = new AudioTrack(3, d, e, f, i, 1);
        } else
        {
            b = new AudioTrack(3, d, e, f, i, 1, i1);
        }
        i1 = b.getState();
        if (i1 == 1)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        b.release();
        b = null;
_L2:
        throw new aoz(i1, d, e, i);
        Object obj;
        obj;
        b = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        b = null;
        throw obj;
        if (atp.a >= 19)
        {
            c = new aoy(b);
        } else
        {
            c = new aox(b);
        }
        a(B);
        return b.getAudioSessionId();
    }

    public long a(long l1)
    {
        if (t)
        {
            if (u == 0)
            {
                return 0L;
            } else
            {
                return ((l1 << 3) * (long)d) / (long)(u * 1000);
            }
        } else
        {
            return l1 / (long)g;
        }
    }

    public final void a(float f1)
    {
label0:
        {
            B = f1;
            if (a())
            {
                if (atp.a < 21)
                {
                    break label0;
                }
                b.setVolume(f1);
            }
            return;
        }
        b.setStereoVolume(f1, f1);
    }

    public final boolean a()
    {
        return b != null;
    }

    public long b(long l1)
    {
        return (0xf4240L * l1) / (long)d;
    }

    public final void b()
    {
        if (a())
        {
            A = System.nanoTime() / 1000L;
            b.play();
        }
    }

    public long c(long l1)
    {
        return ((long)d * l1) / 0xf4240L;
    }

    public final boolean c()
    {
        return a() && a(m) > c.a();
    }

    public final void d()
    {
        if (a())
        {
            m = 0L;
            s = 0;
            o = 0L;
            f();
            if (b.getPlayState() == 3)
            {
                b.pause();
            }
            AudioTrack audiotrack = b;
            b = null;
            c = null;
            a.close();
            (new aow(this, audiotrack)).start();
        }
    }

    public void e()
    {
        long l2 = c.b();
        if (l2 != 0L)
        {
            long l1 = System.nanoTime() / 1000L;
            if (l1 - x >= 30000L)
            {
                v[w] = l2 - l1;
                w = (w + 1) % 10;
                if (j < 10)
                {
                    j = j + 1;
                }
                x = l1;
                k = 0L;
                for (int i1 = 0; i1 < j; i1++)
                {
                    k = k + v[i1] / (long)j;
                }

            }
            if (l1 - y >= 0x7a120L)
            {
                l = c.c();
                if (l)
                {
                    long l3 = c.d() / 1000L;
                    long l4 = c.e();
                    if (l3 < A)
                    {
                        l = false;
                    } else
                    if (Math.abs(l3 - l1) > 0x4c4b40L)
                    {
                        l = false;
                        Log.w("AudioTrack", (new StringBuilder(136)).append("Spurious audio timestamp (system clock mismatch): ").append(l4).append(", ").append(l3).append(", ").append(l1).append(", ").append(l2).toString());
                    } else
                    if (Math.abs(b(l4) - l2) > 0x4c4b40L)
                    {
                        l = false;
                        Log.w("AudioTrack", (new StringBuilder(138)).append("Spurious audio timestamp (frame position mismatch): ").append(l4).append(", ").append(l3).append(", ").append(l1).append(", ").append(l2).toString());
                    }
                }
                if (z != null)
                {
                    try
                    {
                        p = (long)((Integer)z.invoke(b, null)).intValue() * 1000L - b(a(i));
                        p = Math.max(p, 0L);
                        if (p > 0x4c4b40L)
                        {
                            l2 = p;
                            Log.w("AudioTrack", (new StringBuilder(61)).append("Ignoring impossibly large audio latency: ").append(l2).toString());
                            p = 0L;
                        }
                    }
                    catch (Exception exception)
                    {
                        z = null;
                    }
                }
                y = l1;
                return;
            }
        }
    }

    public void f()
    {
        k = 0L;
        j = 0;
        w = 0;
        x = 0L;
        l = false;
        y = 0L;
    }
}
