// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmsp.client.sdk.oem.AudioSystemOEM;
import com.nuance.nmsp.client.sdk.oem.b;
import java.util.Enumeration;
import java.util.Vector;

public class de
    implements bj.a, bj.d, bj.e, bj.f, bj.g, bj.j, bj.l, bj.m, bn.b, ca
{

    private static final bm a = d.a(de);
    private bi b;
    private bj c;
    private bz d;
    private bn e;
    private cx f;
    private long g;
    private ce h;
    private int i;
    private bq j;
    private boolean k;
    private boolean l;
    private boolean m;
    private bj.h n;
    private Vector o;
    private int p;

    public de(bz bz1, df df1, Vector vector, bg bg1)
    {
        e = null;
        k = false;
        l = false;
        m = false;
        p = -1;
        a(vector);
        d = bz1;
        b = ((dl)df1).e();
        j = null;
        e = ((dl)df1).c_();
        o = vector;
        k = a(vector, "ep.enable");
        l = a(vector, "NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING");
        m = a(vector, "NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER");
        c = new AudioSystemOEM(e, b, vector);
        if (!bg1.equals(bg.c)) goto _L2; else goto _L1
_L1:
        n = bj.h.c;
_L4:
        bz1 = (ch)df1.a();
        if (bz1 != null)
        {
            bz1 = bz1.b();
            if (bz1 != null)
            {
                h = bz1.a("NMSPRecorder").a();
            }
        }
        p = 0;
        return;
_L2:
        if (bg1.equals(bg.a))
        {
            n = bj.h.a;
        } else
        if (bg1.equals(bg.b))
        {
            n = bj.h.b;
        } else
        if (bg1.equals(bg.d))
        {
            n = bj.h.d;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static bq a(de de1)
    {
        de1.j = null;
        return null;
    }

    private void a(cx cx1, int i1)
    {
label0:
        {
            if (a.b())
            {
                a.b((new StringBuilder("RecorderImpl.handleStartRecording(")).append(cx1).append(") _state:").append(p).toString());
            }
            if ((new b(o)).a())
            {
                b = bx.c(b);
            }
            i = i1;
            if (p == 0)
            {
                f = cx1;
                bj bj1 = c;
                bj.h h1 = n;
                boolean flag;
                if (k && cx1 != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (bj1.a(h1, flag, this, this, this, this, this, this, this))
                {
                    break label0;
                }
                if (a.e())
                {
                    a.e("RecorderImpl.handleStartRecording() startRecording() failed!!!");
                }
                p = 8;
                a("RECORD_ERROR", null);
            }
            return;
        }
        if (k)
        {
            if (cx1 == null)
            {
                p = 1;
            } else
            {
                p = 2;
            }
        } else
        if (cx1 == null)
        {
            p = 1;
        } else
        {
            h();
            p = 4;
        }
        a("STARTED", null);
    }

    private void a(String s)
    {
        if (h != null)
        {
            h.a(s).a();
        }
    }

    private void a(String s, Object obj)
    {
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        d.a(this, s, obj);
_L1:
        return;
        Throwable throwable;
        throwable;
        if (a.e())
        {
            a.e((new StringBuilder("Got an exp while calling NMSPAudioRecordListener.recorderUpdate(")).append(s).append(", ").append(obj).append(")[").append(throwable.getClass().getName()).append("] msg [").append(throwable.getMessage()).append("]").toString());
            return;
        }
          goto _L1
    }

    private static void a(Vector vector)
    {
label0:
        {
            if (vector == null)
            {
                break label0;
            }
            vector = vector.elements();
            cz cz1;
            do
            {
                if (!vector.hasMoreElements())
                {
                    break label0;
                }
                cz1 = (cz)vector.nextElement();
            } while (cz1.d() == cz.a.a);
            throw new IllegalArgumentException((new StringBuilder("Parameter type: ")).append(cz1.d()).append(" not allowed. ").toString());
        }
    }

    private static boolean a(Vector vector, String s)
    {
label0:
        {
            if (vector == null)
            {
                break label0;
            }
            vector = vector.elements();
            cz cz1;
            do
            {
                if (!vector.hasMoreElements())
                {
                    break label0;
                }
                cz1 = (cz)vector.nextElement();
            } while (cz1.d() != cz.a.a || !cz1.a().equals(s));
            return (new String(cz1.b())).equals("TRUE");
        }
        return false;
    }

    private void b(boolean flag)
    {
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl.handleStopRecording() _state:")).append(p).toString());
        }
        if (p == 2 || p == 4 || p == 5)
        {
            if (flag)
            {
                a("CAPTURE_TIMEOUT", null);
            }
            if (p == 4)
            {
                i();
            }
            c.a(this);
            p = 9;
        } else
        if (p == 1 || p == 3 || p == 6)
        {
            c.a(this);
            p = 7;
            return;
        }
    }

    static boolean b(de de1)
    {
        return de1.l;
    }

    static void c(de de1)
    {
        de1.b(true);
    }

    private void h()
    {
        if (i > 0)
        {
            j = new bq() {

                private de a;

                public final void run()
                {
                    de.a(a);
                    if (de.b(a))
                    {
                        a.a(true);
                        return;
                    } else
                    {
                        de.c(a);
                        return;
                    }
                }

            
            {
                a = de.this;
                super();
            }
            };
            e.a(j, i);
        }
    }

    private void i()
    {
        if (j != null)
        {
            e.a(j);
            j = null;
        }
    }

    private void j()
    {
        f.a(null, 0, 0, true);
_L2:
        if (a.b())
        {
            a.b("RecorderImpl::finishAudioSink send the last audio buffer from recorder");
        }
        return;
        dc dc1;
        dc1;
        if (a.d())
        {
            a.e((new StringBuilder("RecorderImpl.finishAudioSink() TransactionProcessingException:")).append(dc1).toString());
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a()
    {
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl::endOfSpeechCallback() _state:")).append(p).toString());
        }
        if (p == 4)
        {
            a("END_OF_SPEECH", null);
            if (!m)
            {
                a(false);
            }
        }
    }

    public final void a(bj.b b1)
    {
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl.stopCallback() _state:")).append(p).toString());
        }
        a("StreamStop");
        if (p == 1 || p == 3 || p == 7)
        {
            a("STOPPED", null);
            p = 8;
        } else
        if (p == 2 || p == 4 || p == 5 || p == 6 || p == 9)
        {
            if (p == 4)
            {
                i();
            }
            j();
            a("STOPPED", null);
            p = 8;
            return;
        }
    }

    public final void a(cx cx1)
    {
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl.startCapturing(")).append(cx1).append(")").toString());
        }
        if (cx1 == null)
        {
            throw new IllegalArgumentException("audioSink cannot be null.");
        } else
        {
            bn bn1 = e;
            cx1 = new bn.a((byte)4, ((Object) (new Object[] {
                cx1, new Integer(60000)
            })));
            Thread thread = Thread.currentThread();
            e.a();
            bn1.a(cx1, this, thread);
            return;
        }
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bn.a)obj;
        ((bn.a) (obj)).a;
        JVM INSTR tableswitch 1 5: default 44
    //                   1 45
    //                   2 52
    //                   3 80
    //                   4 86
    //                   5 235;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        a(((cx) (null)), 0);
        return;
_L3:
        obj = ((Object) ((Object[])((bn.a) (obj)).b));
        a((cx)obj[0], ((Integer)obj[1]).intValue());
        return;
_L4:
        b(false);
        return;
_L5:
        obj = ((Object) ((Object[])((bn.a) (obj)).b));
        obj1 = (cx)obj[0];
        int i1 = ((Integer)obj[1]).intValue();
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl.handleStartCapturing(")).append(obj1).append(") _state:").append(p).toString());
        }
        i = i1;
        f = ((cx) (obj1));
        if (p == 1)
        {
            if (k)
            {
                c.a(this);
                p = 2;
                return;
            } else
            {
                h();
                p = 4;
                return;
            }
        }
        if (p == 3)
        {
            p = 2;
            return;
        }
        if (p == 6)
        {
            p = 5;
            return;
        }
          goto _L1
_L6:
        a(false);
        return;
    }

    public final void a(boolean flag)
    {
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl.handleStopCapturing() _state:")).append(p).toString());
        }
        if (p == 2)
        {
            j();
            if (flag)
            {
                a("CAPTURE_TIMEOUT", null);
            }
            p = 3;
        } else
        {
            if (p == 4)
            {
                j();
                if (flag)
                {
                    a("CAPTURE_TIMEOUT", null);
                }
                if (p == 4)
                {
                    i();
                }
                if (k)
                {
                    c.a(this);
                    p = 6;
                    return;
                } else
                {
                    p = 1;
                    return;
                }
            }
            if (p == 5)
            {
                j();
                p = 6;
                return;
            }
        }
    }

    public final void a(byte abyte0[], Object obj, bj.i i1, bj.i j1, Float float1)
    {
        int k1 = 0;
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl.audioCallback() _state:")).append(p).toString());
        }
        if (p == 4)
        {
            if (g == 0L)
            {
                g = System.currentTimeMillis();
                a("StreamStart");
            }
            bi bi = b;
            bx.a();
            if (bx.b(b))
            {
                abyte0 = (byte[])obj;
                k1 = j1.a;
            } else
            if (bx.a(b))
            {
                k1 = i1.a;
            } else
            {
                abyte0 = null;
            }
            if (a.b())
            {
                a.b((new StringBuilder("========================= Recorder::audioCallback len[")).append(k1).append("] ======================").toString());
            }
            try
            {
                f.a(abyte0, 0, k1, false);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                if (a.d())
                {
                    a.d((new StringBuilder("RecorderImpl.audioCallback() TransactionProcessingException:")).append(abyte0).toString());
                }
                a("RECORD_ERROR", null);
                if (p == 4)
                {
                    i();
                }
                c.a(this);
                p = 7;
                return;
            }
            a("BUFFER_RECORDED", float1);
        }
    }

    public final void b()
    {
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl::endPointerStartedCallback() _state:")).append(p).toString());
        }
        if (p == 2)
        {
            h();
            p = 4;
        } else
        if (p == 3)
        {
            c.a(this);
            p = 6;
            return;
        }
    }

    public final void c()
    {
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl::endPointerStoppedCallback() _state:")).append(p).toString());
        }
        if (p == 5)
        {
            c.a(this);
            p = 2;
        } else
        if (p == 6)
        {
            p = 1;
            return;
        }
    }

    public final void d()
    {
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl.errorCallback() _state:")).append(p).toString());
        }
        if (p == 1 || p == 2 || p == 3 || p == 4 || p == 5 || p == 6)
        {
            if (p == 4)
            {
                i();
            }
            a("RECORD_ERROR", null);
            p = 7;
        }
    }

    public final void e()
    {
        if (a.b())
        {
            a.b((new StringBuilder("RecorderImpl::startOfSpeechCallback() _state:")).append(p).toString());
        }
        if (p == 4)
        {
            a("START_OF_SPEECH", null);
        }
    }

    public final void f()
    {
        if (a.b())
        {
            a.b("RecorderImpl.startRecording()");
        }
        g = 0L;
        a("RecorderStart");
        bn bn1 = e;
        bn.a a1 = new bn.a((byte)1, null);
        Thread thread = Thread.currentThread();
        e.a();
        bn1.a(a1, this, thread);
    }

    public final void g()
    {
        if (a.b())
        {
            a.b("RecorderImpl.stop()");
        }
        a("RecorderStop");
        bn bn1 = e;
        bn.a a1 = new bn.a((byte)3, null);
        Thread thread = Thread.currentThread();
        e.a();
        bn1.a(a1, this, thread);
    }

}
