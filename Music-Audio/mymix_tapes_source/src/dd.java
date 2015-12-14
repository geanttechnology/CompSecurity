// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmsp.client.sdk.oem.AudioSystemOEM;
import com.nuance.nmsp.client.sdk.oem.b;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Vector;

public class dd
    implements bj.a, bj.c, bj.m, bn.b, cx, z
{

    private static final bm a = d.a(dd);
    private bi b;
    private bj c;
    private by d;
    private ByteArrayOutputStream e;
    private Vector f;
    private boolean g;
    private LinkedList h;
    private boolean i;
    private short j;
    private Vector k;
    private bn l;
    private Object m;
    private bj.k n;
    private ce o;

    public dd(by by1, df df1, Vector vector, bh bh1)
    {
        j = -1;
        l = null;
        m = new Object();
        b = ((dl)df1).f();
        d = by1;
        l = ((dl)df1).c_();
        k = vector;
        c = new AudioSystemOEM(l, b, vector);
        e = new ByteArrayOutputStream();
        f = new Vector();
        i = false;
        g = false;
        if (!bh1.equals(bh.d)) goto _L2; else goto _L1
_L1:
        n = bj.k.d;
_L4:
        if (bx.b(b))
        {
            h = new LinkedList();
        }
        by1 = (ch)df1.a();
        if (by1 != null)
        {
            by1 = by1.b();
            if (by1 != null)
            {
                o = by1.a("NMSPPlayer").a();
            }
        }
        return;
_L2:
        if (bh1.equals(bh.c))
        {
            n = bj.k.c;
        } else
        if (bh1.equals(bh.b))
        {
            n = bj.k.b;
        } else
        if (bh1.equals(bh.a))
        {
            n = bj.k.a;
        } else
        if (bh1.equals(bh.e))
        {
            n = bj.k.e;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(String s)
    {
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        d.a(s);
_L1:
        return;
        Throwable throwable;
        throwable;
        if (a.e())
        {
            a.e((new StringBuilder("Got an exp while calling NMSPAudioPlaybackListener.playerUpdate(")).append(s).append(")[").append(throwable.getClass().getName()).append("] msg [").append(throwable.getMessage()).append("]").toString());
            return;
        }
          goto _L1
    }

    private void b(String s)
    {
        if (o != null)
        {
            o.a(s).a();
        }
    }

    public final void a()
    {
        if (a.b())
        {
            a.b("PlayerImpl.start()");
        }
        b("PlayerStart");
        bn bn1 = l;
        bn.a a1 = new bn.a((byte)1, this);
        Thread thread = Thread.currentThread();
        l.a();
        bn1.a(a1, this, thread);
    }

    public final void a(bj.b b1)
    {
        if (a.b())
        {
            a.b("audio stop call back is called");
        }
        j = 5;
        if (b1.equals(bj.b.b))
        {
            b1 = "PLAYBACK_ERROR";
        } else
        {
            b1 = "STOPPED";
        }
        a(((String) (b1)));
    }

    public final void a(bj.b b1, Object obj)
    {
        if (a.b())
        {
            a.b("PlayerImpl.doneCallback()");
        }
        bn bn1 = l;
        b1 = new bn.a((byte)7, ((Object) (new Object[] {
            b1, obj
        })));
        obj = Thread.currentThread();
        l.a();
        bn1.a(b1, this, obj);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bn.a)obj;
        if (a.b())
        {
            a.b((new StringBuilder("\nXMode handleMessage - [")).append(((bn.a) (obj)).a).append("]").toString());
        }
        ((bn.a) (obj)).a;
        JVM INSTR tableswitch 1 7: default 92
    //                   1 93
    //                   2 346
    //                   3 396
    //                   4 528
    //                   5 655
    //                   6 782
    //                   7 905;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        return;
_L2:
        if (a.b())
        {
            a.b("PlayerImpl.handleStartPlayback()");
        }
        if ((new b(k)).a())
        {
            b = bx.c(b);
        }
        if (j != -1) goto _L10; else goto _L9
_L9:
        j = 0;
          goto _L11
_L10:
        if (j != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        j = 3;
        if (true) goto _L11; else goto _L12
_L12:
        j = 5;
        if (a.e())
        {
            a.e("PlayImpl.handleStartPlayback() wrong state [state != STATE_INIT]!!!");
        }
        a("PLAYBACK_ERROR");
        return;
_L11:
        if (j != 0 && j != 3)
        {
            j = 5;
            if (a.e())
            {
                a.e("PlayImpl.handleStartPlayback() wrong state [state != STATE_STARTING]!!!");
            }
            a("PLAYBACK_ERROR");
            return;
        }
        if (j == 0)
        {
            if (!c.a(n, this, this))
            {
                j = 5;
                if (a.e())
                {
                    a.e("PlayImpl.handleStartPlayback() audioSys.startPlayback() return false!!!");
                }
                a("PLAYBACK_ERROR");
                return;
            } else
            {
                b("StreamStart");
                return;
            }
        }
        c.a();
        j = 5;
        if (a.e())
        {
            a.e("PlayImpl.handleStartPlayback() audioSys.pausePlayback() return false!!!");
        }
        a("PLAYBACK_ERROR");
        return;
_L3:
        if (a.b())
        {
            a.b("PlayerImpl.handleStopPlayback()");
        }
        if (j != 5 && j != 4)
        {
            j = 4;
            c.b(this);
            return;
        }
          goto _L1
_L4:
        if (a.b())
        {
            a.b("PlayerImpl.handlePausePlayback()");
        }
        if (j != 5 && j != 4)
        {
            j = 2;
            c.a();
            j = 5;
            if (a.e())
            {
                a.e("PlayImpl.handleStartPlayback() audioSys.pausePlayback() return false!!!");
            }
            a("PLAYBACK_ERROR");
            return;
        }
        j = 5;
        if (a.e())
        {
            a.e((new StringBuilder("PlayImpl.handlePausePlayback() wrong state [state == ")).append(j).append("]!!!").toString());
        }
        a("PLAYBACK_ERROR");
        return;
_L5:
        if (a.b())
        {
            a.b("PlayerImpl.handlePrevious()");
        }
        if (j != 5 && j != 4)
        {
            c.b();
            j = 5;
            if (a.e())
            {
                a.e("PlayImpl.handleStartPlayback() audioSys.previousPlayback() return false!!!");
            }
            a("PLAYBACK_ERROR");
            return;
        }
        j = 5;
        if (a.e())
        {
            a.e((new StringBuilder("PlayImpl.handlePausePlayback() wrong state [state == ")).append(j).append("]!!!").toString());
        }
        a("PLAYBACK_ERROR");
        return;
_L6:
        if (a.b())
        {
            a.b("PlayerImpl.handleNext()");
        }
        if (j != 5 && j != 4)
        {
            c.c();
            j = 5;
            if (a.e())
            {
                a.e("PlayImpl.handleStartPlayback() audioSys.nextPlayback() return false!!!");
            }
            a("PLAYBACK_ERROR");
            return;
        }
        j = 5;
        if (a.e())
        {
            a.e((new StringBuilder("PlayImpl.handlePausePlayback() wrong state [state == ")).append(j).append("]!!!").toString());
        }
        a("PLAYBACK_ERROR");
        return;
_L7:
        boolean flag;
        obj1 = ((Object) ((Object[])((bn.a) (obj)).b));
        obj = (byte[])obj1[0];
        flag = ((Boolean)obj1[1]).booleanValue();
        if (a.b())
        {
            a.b("PlayerImpl.handleAddBuffer()");
        }
        obj1 = m;
        obj1;
        JVM INSTR monitorenter ;
        if (obj == null) goto _L14; else goto _L13
_L13:
        bi bi1 = b;
        bx.a();
        if (!bx.b(b)) goto _L16; else goto _L15
_L15:
        h.add(obj);
_L14:
        if (!flag) goto _L18; else goto _L17
_L17:
        i = true;
_L18:
        obj1;
        JVM INSTR monitorexit ;
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
_L16:
        e.write(((byte []) (obj)), 0, obj.length);
        f.addElement(obj);
          goto _L14
_L8:
        obj = (bj.b)((Object[])((bn.a) (obj)).b)[0];
        if (a.b())
        {
            a.b("audio done call back is called");
        }
        if (((bj.b) (obj)).equals(bj.b.b))
        {
            j = 5;
            a("PLAYBACK_ERROR");
            return;
        } else
        {
            j = 5;
            b("StreamStop");
            a("STOPPED");
            return;
        }
    }

    public final void a(byte abyte0[], int i1, int j1, boolean flag)
        throws dc
    {
        if (a.c())
        {
            a.c((new StringBuilder("addAudioBuf(")).append(abyte0).append(", ").append(flag).append(")").toString());
        }
        if (abyte0 == null && !flag)
        {
            throw new NullPointerException("buffer is null!");
        }
        if (abyte0 != null && i1 < 0)
        {
            throw new IllegalArgumentException("offset cannot be negative!!!");
        }
        if (abyte0 != null && j1 <= 0)
        {
            throw new IllegalArgumentException("length can only be positive!!!");
        }
        if ((b == bi.c || b == bi.b || b == bi.a) && j1 > 0x25800)
        {
            a("PLAYBACK_ERROR");
            a_();
            return;
        }
        if (g)
        {
            throw new dc("audio player is full, the last buffer has already apended!");
        }
        if (!g && flag)
        {
            g = true;
        }
        byte abyte1[] = null;
        if (abyte0 != null)
        {
            abyte1 = new byte[j1];
            System.arraycopy(abyte0, i1, abyte1, 0, j1);
        }
        Object obj = new Boolean(flag);
        abyte0 = l;
        bn.a a1 = new bn.a((byte)6, ((Object) (new Object[] {
            abyte1, obj
        })));
        obj = Thread.currentThread();
        l.a();
        abyte0.a(a1, this, obj);
    }

    public final void a(byte abyte0[], Object obj, bj.i i1, bj.i j1, Float float1)
    {
        int k1;
        if (a.b())
        {
            a.b((new StringBuilder("audio call back is called time: [")).append(System.currentTimeMillis()).append("]").toString());
        }
        if (j == 0)
        {
            j = 1;
            a("STARTED");
        }
        float1 = b;
        bx.a();
        if (!bx.b(b))
        {
            obj = b;
            bx.b();
            bi bi1;
            Exception exception;
            if (!bx.a(b))
            {
                abyte0 = null;
            }
        } else
        {
            abyte0 = (byte[])obj;
        }
        k1 = abyte0.length;
        if (!bx.b(b)) goto _L2; else goto _L1
_L1:
        if (!h.isEmpty()) goto _L4; else goto _L3
_L3:
        if (i)
        {
            k1 = -1;
        } else
        {
            k1 = 0;
        }
_L16:
        if (k1 > 0)
        {
            a("BUFFER_PLAYED");
        }
        abyte0 = b;
        bx.a();
        if (!bx.b(b))
        {
            abyte0 = b;
            bx.b();
            if (bx.a(b))
            {
                i1.a = k1;
            }
            return;
        } else
        {
            j1.a = k1;
            return;
        }
_L4:
        obj = (byte[])h.removeFirst();
        if (k1 >= obj.length) goto _L6; else goto _L5
_L5:
        if (a.e())
        {
            a.e("Buffer is too small to contain the Speex buffer.");
        }
          goto _L7
_L6:
        try
        {
            k1 = obj.length;
            System.arraycopy(obj, 0, abyte0, 0, k1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            k1 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        obj = m;
        obj;
        JVM INSTR monitorenter ;
        if (e.size() > 0) goto _L9; else goto _L8
_L8:
        if (i)
        {
            k1 = -1;
        } else
        {
            k1 = 0;
        }
_L12:
        obj;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
        abyte0;
        throw abyte0;
_L9:
        float1 = e.toByteArray();
        e.close();
_L13:
        e = null;
        e = new ByteArrayOutputStream();
        if (k1 >= float1.length) goto _L11; else goto _L10
_L10:
        bi1 = b;
        bx.a();
        if (!bx.a(b))
        {
            break MISSING_BLOCK_LABEL_545;
        }
_L14:
        if (k1 < float1.length)
        {
            e.write(float1, k1, float1.length - k1);
        }
        if (a.b())
        {
            a.b((new StringBuilder("feed oem audio data len [")).append(k1).append("] complete buffer size [").append(float1.length).append("]").toString());
        }
        System.arraycopy(float1, 0, abyte0, 0, k1);
          goto _L12
        exception;
        System.out.println((new StringBuilder("got an exception [")).append(exception.getClass().getName()).append("] message [").append(exception.getMessage()).append("]").toString());
          goto _L13
_L11:
        exception = b;
        bx.a();
        if (!bx.a(b))
        {
            break MISSING_BLOCK_LABEL_545;
        }
        k1 = float1.length;
          goto _L14
        k1 = 0;
          goto _L14
_L7:
        k1 = 0;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public final void a_()
    {
        if (a.b())
        {
            a.b("PlayerImpl.start()");
        }
        b("PlayerStop");
        bn bn1 = l;
        bn.a a1 = new bn.a((byte)2, this);
        Thread thread = Thread.currentThread();
        l.a();
        bn1.a(a1, this, thread);
    }

}
