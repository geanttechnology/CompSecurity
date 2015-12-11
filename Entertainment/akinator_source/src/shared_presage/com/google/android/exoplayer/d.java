// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.PriorityHandlerThread;
import shared_presage.com.google.android.exoplayer.util.TraceUtil;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            n, TrackRenderer, MediaClock, ExoPlaybackException

final class d
    implements android.os.Handler.Callback
{

    private final Handler a;
    private final HandlerThread b = new PriorityHandlerThread((new StringBuilder()).append(getClass().getSimpleName()).append(":Handler").toString(), -16);
    private final Handler c;
    private final n d = new n();
    private final boolean e[];
    private final long f;
    private final long g;
    private final List h;
    private TrackRenderer i[];
    private TrackRenderer j;
    private MediaClock k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private long r;
    private volatile long s;
    private volatile long t;
    private volatile long u;

    public d(Handler handler, boolean flag, boolean aflag[], int i1, int j1)
    {
        boolean flag1 = false;
        super();
        p = 0;
        q = 0;
        c = handler;
        m = flag;
        e = new boolean[aflag.length];
        f = (long)i1 * 1000L;
        g = (long)j1 * 1000L;
        for (i1 = ((flag1) ? 1 : 0); i1 < aflag.length; i1++)
        {
            e[i1] = aflag[i1];
        }

        o = 1;
        s = -1L;
        u = -1L;
        h = new ArrayList(aflag.length);
        b.start();
        a = new Handler(b.getLooper(), this);
    }

    private void a(int i1)
    {
        if (o != i1)
        {
            o = i1;
            c.obtainMessage(2, i1, 0).sendToTarget();
        }
    }

    private void a(int i1, long l1, long l2)
    {
        l1 = (l1 + l2) - SystemClock.elapsedRealtime();
        if (l1 <= 0L)
        {
            a.sendEmptyMessage(i1);
            return;
        } else
        {
            a.sendEmptyMessageDelayed(i1, l1);
            return;
        }
    }

    private boolean a(TrackRenderer trackrenderer)
    {
        if (!trackrenderer.isEnded())
        {
            if (!trackrenderer.isReady())
            {
                return false;
            }
            if (o != 4)
            {
                long l2 = trackrenderer.getDurationUs();
                long l3 = trackrenderer.getBufferedPositionUs();
                long l1;
                if (n)
                {
                    l1 = g;
                } else
                {
                    l1 = f;
                }
                if (l1 > 0L && l3 != -1L && l3 != -3L && l3 < l1 + t && (l2 == -1L || l2 == -2L || l3 < l2))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static void b(TrackRenderer trackrenderer)
    {
        if (trackrenderer.getState() == 3)
        {
            trackrenderer.stop();
        }
    }

    private void g()
    {
        long l2 = SystemClock.elapsedRealtime();
        boolean flag = true;
        for (int i1 = 0; i1 < i.length;)
        {
            TrackRenderer trackrenderer = i[i1];
            boolean flag1 = flag;
            if (trackrenderer.getState() == 0)
            {
                flag1 = flag;
                if (trackrenderer.prepare(t) == 0)
                {
                    trackrenderer.maybeThrowError();
                    flag1 = false;
                }
            }
            i1++;
            flag = flag1;
        }

        if (!flag)
        {
            a(2, l2, 10L);
            return;
        }
        l2 = 0L;
        int k1 = 1;
        int j1 = 1;
        boolean aflag[] = new boolean[i.length];
        int l1 = 0;
        while (l1 < i.length) 
        {
            TrackRenderer trackrenderer1 = i[l1];
            boolean flag2;
            if (trackrenderer1.getState() == 1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            aflag[l1] = flag2;
            if (aflag[l1])
            {
                if (l2 != -1L)
                {
                    long l3 = trackrenderer1.getDurationUs();
                    int i2;
                    if (l3 == -1L)
                    {
                        l2 = -1L;
                    } else
                    if (l3 != -2L)
                    {
                        l2 = Math.max(l2, l3);
                    }
                }
                if (e[l1])
                {
                    trackrenderer1.enable(t, false);
                    h.add(trackrenderer1);
                    if (k1 != 0 && trackrenderer1.isEnded())
                    {
                        k1 = 1;
                    } else
                    {
                        k1 = 0;
                    }
                    if (j1 != 0 && a(trackrenderer1))
                    {
                        j1 = 1;
                    } else
                    {
                        j1 = 0;
                    }
                    i2 = k1;
                    k1 = j1;
                    j1 = i2;
                } else
                {
                    int j2 = j1;
                    j1 = k1;
                    k1 = j2;
                }
            } else
            {
                int k2 = j1;
                j1 = k1;
                k1 = k2;
            }
            i2 = l1 + 1;
            l1 = k1;
            k1 = j1;
            j1 = l1;
            l1 = i2;
        }
        s = l2;
        if (k1 != 0 && (l2 == -1L || l2 <= t))
        {
            j1 = 5;
        } else
        if (j1 != 0)
        {
            j1 = 4;
        } else
        {
            j1 = 3;
        }
        o = j1;
        c.obtainMessage(1, o, 0, aflag).sendToTarget();
        if (m && o == 4)
        {
            h();
        }
        a.sendEmptyMessage(7);
    }

    private void h()
    {
        n = false;
        d.a();
        for (int i1 = 0; i1 < h.size(); i1++)
        {
            ((TrackRenderer)h.get(i1)).start();
        }

    }

    private void i()
    {
        d.b();
        for (int i1 = 0; i1 < h.size(); i1++)
        {
            b((TrackRenderer)h.get(i1));
        }

    }

    private void j()
    {
        if (k != null && h.contains(j) && !j.isEnded())
        {
            t = k.getPositionUs();
            d.a(t);
        } else
        {
            t = d.getPositionUs();
        }
        r = SystemClock.elapsedRealtime() * 1000L;
    }

    private void k()
    {
        l();
        a(1);
    }

    private void l()
    {
        int i1 = 0;
        a.removeMessages(7);
        a.removeMessages(2);
        n = false;
        d.b();
        if (i == null)
        {
            return;
        }
        while (i1 < i.length) 
        {
            TrackRenderer trackrenderer = i[i1];
            try
            {
                b(trackrenderer);
                if (trackrenderer.getState() == 2)
                {
                    trackrenderer.disable();
                }
            }
            catch (ExoPlaybackException exoplaybackexception1)
            {
                Log.e("ExoPlayerImplInternal", "Stop failed.", exoplaybackexception1);
            }
            catch (RuntimeException runtimeexception1)
            {
                Log.e("ExoPlayerImplInternal", "Stop failed.", runtimeexception1);
            }
            try
            {
                trackrenderer.release();
            }
            catch (ExoPlaybackException exoplaybackexception)
            {
                Log.e("ExoPlayerImplInternal", "Release failed.", exoplaybackexception);
            }
            catch (RuntimeException runtimeexception)
            {
                Log.e("ExoPlayerImplInternal", "Release failed.", runtimeexception);
            }
            i1++;
        }
        i = null;
        k = null;
        j = null;
        h.clear();
    }

    public final Looper a()
    {
        return b.getLooper();
    }

    public final void a(int i1, boolean flag)
    {
        Handler handler = a;
        int j1;
        if (flag)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        handler.obtainMessage(8, i1, j1).sendToTarget();
    }

    public final void a(long l1)
    {
        a.obtainMessage(6, Long.valueOf(l1)).sendToTarget();
    }

    public final void a(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i1, Object obj)
    {
        p = p + 1;
        a.obtainMessage(9, i1, 0, Pair.create(exoplayercomponent, obj)).sendToTarget();
    }

    public final void a(boolean flag)
    {
        Handler handler = a;
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        handler.obtainMessage(3, i1, 0).sendToTarget();
    }

    public final transient void a(TrackRenderer atrackrenderer[])
    {
        a.obtainMessage(1, atrackrenderer).sendToTarget();
    }

    public final long b()
    {
        return t / 1000L;
    }

    public final void b(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i1, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (!l) goto _L2; else goto _L1
_L1:
        Log.w("ExoPlayerImplInternal", (new StringBuilder("Sent message(")).append(i1).append(") after release. Message ignored.").toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int j1;
        j1 = p;
        p = j1 + 1;
        a.obtainMessage(9, i1, 0, Pair.create(exoplayercomponent, obj)).sendToTarget();
_L5:
        i1 = q;
        if (i1 > j1) goto _L4; else goto _L3
_L3:
        wait();
          goto _L5
        exoplayercomponent;
        Thread.currentThread().interrupt();
          goto _L5
        exoplayercomponent;
        throw exoplayercomponent;
    }

    public final long c()
    {
        if (u == -1L)
        {
            return -1L;
        } else
        {
            return u / 1000L;
        }
    }

    public final long d()
    {
        if (s == -1L)
        {
            return -1L;
        } else
        {
            return s / 1000L;
        }
    }

    public final void e()
    {
        a.sendEmptyMessage(4);
    }

    public final void f()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = l;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a.sendEmptyMessage(5);
_L3:
        flag = l;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        wait();
          goto _L3
        Object obj;
        obj;
        Thread.currentThread().interrupt();
          goto _L3
        obj;
        throw obj;
        b.quit();
          goto _L1
    }

    public final boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 9: default 1134
    //                   1 56
    //                   2 133
    //                   3 139
    //                   4 794
    //                   5 800
    //                   6 666
    //                   7 284
    //                   8 939
    //                   9 829;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        message = (TrackRenderer[])message.obj;
        l();
        i = message;
        int i1 = 0;
_L66:
        if (i1 >= message.length) goto _L12; else goto _L11
_L11:
        MediaClock mediaclock = message[i1].getMediaClock();
        if (mediaclock == null) goto _L14; else goto _L13
_L13:
        boolean flag;
        int j1;
        long l1;
        long l2;
        long l3;
        long l4;
        boolean flag1;
        if (k == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        k = mediaclock;
        j = message[i1];
          goto _L14
_L12:
        a(2);
        g();
        return true;
_L3:
        g();
        return true;
_L4:
        i1 = message.arg1;
        if (i1 != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        n = false;
        m = flag1;
        if (flag1) goto _L16; else goto _L15
_L15:
        i();
        j();
_L19:
        c.obtainMessage(3).sendToTarget();
        return true;
_L16:
        if (o != 4) goto _L18; else goto _L17
_L17:
        h();
        a.sendEmptyMessage(7);
          goto _L19
        message;
          goto _L20
_L18:
        if (o != 3) goto _L19; else goto _L21
_L21:
        a.sendEmptyMessage(7);
          goto _L19
_L8:
        TraceUtil.beginSection("doSomeWork");
        l2 = SystemClock.elapsedRealtime();
        if (s == -1L) goto _L23; else goto _L22
_L22:
        l1 = s;
_L62:
        i1 = 1;
        flag = true;
        j();
        j1 = 0;
_L61:
        if (j1 >= h.size()) goto _L25; else goto _L24
_L24:
        message = (TrackRenderer)h.get(j1);
        message.doSomeWork(t, r);
        if (i1 == 0) goto _L27; else goto _L26
_L26:
        if (!message.isEnded()) goto _L27; else goto _L28
_L28:
        i1 = 1;
_L63:
        flag1 = a(message);
        if (flag1) goto _L30; else goto _L29
_L29:
        message.maybeThrowError();
          goto _L30
_L60:
        if (l1 == -1L) goto _L32; else goto _L31
_L31:
        l3 = message.getDurationUs();
        l4 = message.getBufferedPositionUs();
        if (l4 != -1L) goto _L34; else goto _L33
_L33:
        l1 = -1L;
          goto _L32
_L64:
        l1 = Math.min(l1, l4);
          goto _L32
_L25:
        u = l1;
        if (i1 == 0) goto _L36; else goto _L35
_L35:
        if (s != -1L && s > t) goto _L36; else goto _L37
_L37:
        a(5);
        i();
_L42:
        a.removeMessages(7);
        if ((!m || o != 4) && o != 3) goto _L39; else goto _L38
_L38:
        a(7, l2, 10L);
_L45:
        TraceUtil.endSection();
        return true;
_L36:
        if (o != 3 || !flag) goto _L41; else goto _L40
_L40:
        a(4);
        if (m)
        {
            h();
        }
          goto _L42
_L20:
        try
        {
            c.obtainMessage(3).sendToTarget();
            throw message;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.e("ExoPlayerImplInternal", "Internal track renderer error.", message);
            c.obtainMessage(4, message).sendToTarget();
            k();
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", message);
        }
        c.obtainMessage(4, new ExoPlaybackException(message, true)).sendToTarget();
        k();
        return true;
_L41:
        if (o != 4 || flag) goto _L42; else goto _L43
_L43:
        n = m;
        a(3);
        i();
          goto _L42
_L39:
        if (h.isEmpty()) goto _L45; else goto _L44
_L44:
        a(7, l2, 1000L);
          goto _L45
_L7:
        l1 = ((Long)message.obj).longValue();
        n = false;
        t = l1 * 1000L;
        d.b();
        d.a(t);
        if (o != 1 && o != 2) goto _L47; else goto _L46
_L50:
        if (i1 >= h.size()) goto _L49; else goto _L48
_L48:
        message = (TrackRenderer)h.get(i1);
        b(message);
        message.seekTo(t);
        i1++;
          goto _L50
_L49:
        a(3);
        a.sendEmptyMessage(7);
          goto _L46
_L5:
        k();
        return true;
_L6:
        l();
        a(1);
        this;
        JVM INSTR monitorenter ;
        l = true;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return true;
        message;
        this;
        JVM INSTR monitorexit ;
        throw message;
_L10:
        i1 = message.arg1;
        message = ((Message) (message.obj));
        message = (Pair)message;
        ((ExoPlayer.ExoPlayerComponent)((Pair) (message)).first).handleMessage(i1, ((Pair) (message)).second);
        this;
        JVM INSTR monitorenter ;
        q = q + 1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        if (o != 1 && o != 2)
        {
            a.sendEmptyMessage(7);
        }
          goto _L51
        message;
        this;
        JVM INSTR monitorexit ;
        throw message;
        message;
        this;
        JVM INSTR monitorenter ;
        q = q + 1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        throw message;
        message;
        this;
        JVM INSTR monitorexit ;
        throw message;
_L9:
        i1 = message.arg1;
        if (message.arg2 != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (e[i1] == flag1) goto _L53; else goto _L52
_L52:
        e[i1] = flag1;
        if (o != 1 && o != 2) goto _L54; else goto _L53
_L54:
        message = i[i1];
        i1 = message.getState();
        if (i1 != 1 && i1 != 2 && i1 != 3) goto _L53; else goto _L55
_L55:
        if (!flag1) goto _L57; else goto _L56
_L56:
        if (m && o == 4)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        message.enable(t, flag1);
        h.add(message);
        if (!flag1) goto _L59; else goto _L58
_L58:
        message.start();
_L59:
        a.sendEmptyMessage(7);
          goto _L53
_L57:
        if (message == j)
        {
            d.a(k.getPositionUs());
        }
        b(message);
        h.remove(message);
        message.disable();
          goto _L53
_L1:
        return false;
_L14:
        i1++;
        continue; /* Loop/switch isn't completed */
_L30:
        if (flag && flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L60
_L32:
        j1++;
          goto _L61
_L23:
        l1 = 0x7fffffffffffffffL;
          goto _L62
_L27:
        i1 = 0;
          goto _L63
_L34:
        if (l4 == -3L || l3 != -1L && l3 != -2L && l4 >= l3) goto _L32; else goto _L64
_L46:
        return true;
_L47:
        i1 = 0;
          goto _L50
_L51:
        return true;
_L53:
        return true;
        if (true) goto _L66; else goto _L65
_L65:
    }
}
