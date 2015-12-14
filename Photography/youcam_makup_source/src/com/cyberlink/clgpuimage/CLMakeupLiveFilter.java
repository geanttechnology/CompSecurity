// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u, m, CLMakeupLiveSmoothFilter, CLMakeupLiveEyeFilter, 
//            c, CLMakeupLiveLipStickFilter, CLMakeupLiveBlushFilter, n, 
//            CLMakeupLiveLeftRightFlipFilter, o

public class CLMakeupLiveFilter extends u
{

    private static final int d;
    private static final int e;
    private static final int f;
    private static final int g;
    private static final int h;
    private static final int i;
    private CLMakeupLiveLipStickFilter.LipstickData A;
    private CLMakeupLiveBlushFilter.LiveBlushMakeupdata B;
    private CLMakeupLiveSmoothFilter.LiveSmoothMetadata C;
    private LiveFrameInformation D;
    private float E;
    private float F;
    private o G;
    private Object H;
    private boolean I;
    private o J;
    private Object K;
    private boolean L;
    private int a[];
    private int b[];
    private FLIP_MODE c;
    private m j;
    private m k;
    private CLMakeupLiveEyeFilter l;
    private CLMakeupLiveEyeFilter m;
    private c n;
    private c o;
    private CLMakeupLiveSmoothFilter p;
    private CLMakeupLiveBlushFilter q;
    private CLMakeupLiveLipStickFilter r;
    private n s;
    private n t;
    private CLMakeupLiveLeftRightFlipFilter u;
    private u v;
    private List w;
    private Object x;
    private Object y;
    private CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata z[];

    public CLMakeupLiveFilter()
    {
        this(true, true, true, true, true);
    }

    public CLMakeupLiveFilter(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        this(flag, flag1, flag2, flag3, flag4, false);
    }

    public CLMakeupLiveFilter(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5)
    {
        c = FLIP_MODE.a;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        x = new Object();
        y = new Object();
        H = new Object();
        I = false;
        K = new Object();
        L = false;
        j = new m(this);
        k = new m(this);
        w = new ArrayList();
        com.cyberlink.clgpuimage.m.a(j)[d] = flag;
        com.cyberlink.clgpuimage.m.a(j)[e] = flag1;
        com.cyberlink.clgpuimage.m.a(j)[f] = flag2;
        com.cyberlink.clgpuimage.m.a(j)[g] = flag3;
        com.cyberlink.clgpuimage.m.a(j)[h] = flag4;
        com.cyberlink.clgpuimage.m.a(j)[i] = flag5;
        v = new u();
        p = new CLMakeupLiveSmoothFilter();
        l = new CLMakeupLiveEyeFilter(true);
        m = new CLMakeupLiveEyeFilter(false);
        n = new c(true);
        o = new c(false);
        r = new CLMakeupLiveLipStickFilter();
        q = new CLMakeupLiveBlushFilter();
        s = new n();
        t = new n();
        u = new CLMakeupLiveLeftRightFlipFilter();
        z = new CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata[2];
        z[0] = new CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata();
        z[1] = new CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata();
        A = new CLMakeupLiveLipStickFilter.LipstickData();
        B = new CLMakeupLiveBlushFilter.LiveBlushMakeupdata();
        C = new CLMakeupLiveSmoothFilter.LiveSmoothMetadata();
        D = new LiveFrameInformation();
    }

    private void f()
    {
        a = new int[7];
        b = new int[7];
        int j1 = j();
        int k1 = k();
        for (int i1 = 0; i1 < 7; i1++)
        {
            GLES20.glGenFramebuffers(1, a, i1);
            GLES20.glGenTextures(1, b, i1);
            GLES20.glBindTexture(3553, b[i1]);
            GLES20.glTexImage2D(3553, 0, 6408, j1, k1, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLES20.glBindFramebuffer(36160, a[i1]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, b[i1], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }

    }

    private void m()
    {
        if (b != null)
        {
            GLES20.glDeleteTextures(b.length, b, 0);
            b = null;
        }
        if (a != null)
        {
            GLES20.glDeleteFramebuffers(a.length, a, 0);
            a = null;
        }
    }

    private void n()
    {
        synchronized (x)
        {
            if (com.cyberlink.clgpuimage.m.a(k)[d] || com.cyberlink.clgpuimage.m.a(k)[e] || com.cyberlink.clgpuimage.m.a(k)[i])
            {
                l.a(z[0]);
                m.a(z[1]);
                n.a(z[0]);
                o.a(z[1]);
            }
            if (com.cyberlink.clgpuimage.m.a(k)[f])
            {
                r.a(A);
            }
            if (com.cyberlink.clgpuimage.m.a(k)[h])
            {
                q.a(B);
            }
            if (com.cyberlink.clgpuimage.m.a(k)[g])
            {
                p.a(C);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a()
    {
        super.a();
        v.g();
        p.g();
        l.g();
        m.g();
        n.g();
        o.g();
        if (l.av == 0 || m.av == 0 || n.av == 0 || o.av == 0)
        {
            l.h();
            m.h();
            n.h();
            o.h();
            l.f();
            m.f();
            n.f();
            o.f();
            l.g();
            m.g();
            n.g();
            o.g();
        }
        r.g();
        q.g();
        s.g();
        t.g();
        u.g();
        f();
    }

    public void a(float f1)
    {
        q.a(f1);
    }

    public void a(int i1)
    {
        r.a(i1);
    }

    public void a(int i1, int j1)
    {
        super.a(i1, j1);
        m();
        f();
        v.a(i1, j1);
        p.a(i1, j1);
        l.a(i1, j1);
        m.a(i1, j1);
        n.a(i1, j1);
        o.a(i1, j1);
        r.a(i1, j1);
        q.a(i1, j1);
        s.a(i1, j1);
        t.a(i1, j1);
        u.a(i1, j1);
    }

    public void a(int i1, int j1, PointF apointf[], int k1, int l1, int i2)
    {
        l.a(apointf, i1, j1, k1, l1, i2);
        m.a(apointf, i1, j1, k1, l1, i2);
        n.a(apointf, i1, j1, k1, l1, i2);
        o.a(apointf, i1, j1, k1, l1, i2);
    }

    public void a(CaptureFrameType captureframetype)
    {
        synchronized (y)
        {
            com.cyberlink.clgpuimage.m.a(j, captureframetype);
        }
        return;
        captureframetype;
        obj;
        JVM INSTR monitorexit ;
        throw captureframetype;
    }

    public void a(FLIP_MODE flip_mode)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[FLIP_MODE.values().length];
                try
                {
                    a[FLIP_MODE.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[FLIP_MODE.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[FLIP_MODE.a.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[flip_mode.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 50
    //                   2 57;
           goto _L1 _L2 _L3
_L1:
        CLMakeupLiveLeftRightFlipFilter.FLIP_MODE flip_mode1 = CLMakeupLiveLeftRightFlipFilter.FLIP_MODE.a;
_L5:
        u.a(flip_mode1);
        c = flip_mode;
        return;
_L2:
        flip_mode1 = CLMakeupLiveLeftRightFlipFilter.FLIP_MODE.c;
        continue; /* Loop/switch isn't completed */
_L3:
        flip_mode1 = CLMakeupLiveLeftRightFlipFilter.FLIP_MODE.b;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(MakeupLiveFeatures makeuplivefeatures, boolean flag)
    {
        synchronized (y)
        {
            com.cyberlink.clgpuimage.m.a(j)[makeuplivefeatures.ordinal()] = flag;
        }
        return;
        makeuplivefeatures;
        obj;
        JVM INSTR monitorexit ;
        throw makeuplivefeatures;
    }

    public void a(boolean flag)
    {
        synchronized (y)
        {
            com.cyberlink.clgpuimage.m.a(j, flag);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata aliveeyemakeupmetadata[], CLMakeupLiveLipStickFilter.LipstickData lipstickdata, CLMakeupLiveBlushFilter.LiveBlushMakeupdata liveblushmakeupdata, CLMakeupLiveSmoothFilter.LiveSmoothMetadata livesmoothmetadata, LiveFrameInformation liveframeinformation)
    {
        synchronized (x)
        {
            z[0].Copy(aliveeyemakeupmetadata[0]);
            z[1].Copy(aliveeyemakeupmetadata[1]);
            A.Copy(lipstickdata);
            B.Copy(liveblushmakeupdata);
            C.Copy(livesmoothmetadata);
            D.Copy(liveframeinformation);
            E = livesmoothmetadata.m_environment_darkest_reference_normalized_luma;
            F = livesmoothmetadata.m_environment_brightest_reference_normalized_luma;
        }
        return;
        aliveeyemakeupmetadata;
        obj;
        JVM INSTR monitorexit ;
        throw aliveeyemakeupmetadata;
    }

    public boolean a(boolean flag, byte abyte0[], int i1)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!l.a(abyte0, i1) || !n.a(abyte0, i1)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (!m.a(abyte0, i1) || !o.a(abyte0, i1))
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public boolean a(boolean flag, int ai[], byte abyte0[], byte abyte1[])
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!l.a(ai, abyte0, abyte1) || !n.a(ai, abyte0, abyte1)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (!m.a(ai, abyte0, abyte1) || !o.a(ai, abyte0, abyte1))
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public boolean a(Bitmap abitmap[])
    {
        return q.a(abitmap);
    }

    public void b(int i1)
    {
        q.a(i1);
    }

    public void b(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        int j1;
        int l1;
        boolean flag;
        boolean flag1;
        synchronized (y)
        {
            com.cyberlink.clgpuimage.m.a(k, com.cyberlink.clgpuimage.m.b(j));
            com.cyberlink.clgpuimage.m.a(k, (boolean[])com.cyberlink.clgpuimage.m.a(j).clone());
            com.cyberlink.clgpuimage.m.a(k, com.cyberlink.clgpuimage.m.c(j));
            com.cyberlink.clgpuimage.m.a(j, CaptureFrameType.a);
        }
        if (com.cyberlink.clgpuimage.m.c(k) == CaptureFrameType.b || com.cyberlink.clgpuimage.m.c(k) == CaptureFrameType.d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (com.cyberlink.clgpuimage.m.c(k) == CaptureFrameType.c || com.cyberlink.clgpuimage.m.c(k) == CaptureFrameType.d)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        j1 = 0;
        l1 = 0;
        obj = x;
        obj;
        JVM INSTR monitorenter ;
        if (!com.cyberlink.clgpuimage.m.b(k))
        {
            break MISSING_BLOCK_LABEL_198;
        }
        n();
        if (z[0].m_mode == CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata.EyeMode.BLINK)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (z[1].m_mode == CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata.EyeMode.BLINK)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        s.a(D.feature_points);
        s.a(D.rotation);
        s.a(E, F);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        t.a(D.feature_points);
        t.a(D.rotation);
        t.a(E, F);
        obj;
        JVM INSTR monitorexit ;
        obj = IntBuffer.allocate(1);
        GLES20.glGetIntegerv(36006, ((IntBuffer) (obj)));
        IntBuffer intbuffer = IntBuffer.allocate(4);
        GLES20.glGetIntegerv(2978, intbuffer);
        if (com.cyberlink.clgpuimage.m.b(k))
        {
            l.b(com.cyberlink.clgpuimage.m.a(k)[d]);
            m.b(com.cyberlink.clgpuimage.m.a(k)[d]);
            l.a(com.cyberlink.clgpuimage.m.a(k)[e]);
            m.a(com.cyberlink.clgpuimage.m.a(k)[e]);
            l.c(com.cyberlink.clgpuimage.m.a(k)[i]);
            m.c(com.cyberlink.clgpuimage.m.a(k)[i]);
            n.b(com.cyberlink.clgpuimage.m.a(k)[d]);
            o.b(com.cyberlink.clgpuimage.m.a(k)[d]);
            n.a(com.cyberlink.clgpuimage.m.a(k)[e]);
            o.a(com.cyberlink.clgpuimage.m.a(k)[e]);
            n.c(com.cyberlink.clgpuimage.m.a(k)[i]);
            o.c(com.cyberlink.clgpuimage.m.a(k)[i]);
            if (!com.cyberlink.clgpuimage.m.a(k)[d] && !com.cyberlink.clgpuimage.m.a(k)[e] && !com.cyberlink.clgpuimage.m.a(k)[f] && !com.cyberlink.clgpuimage.m.a(k)[g] && !com.cyberlink.clgpuimage.m.a(k)[h] && !com.cyberlink.clgpuimage.m.a(k)[i])
            {
                GLES20.glBindFramebuffer(36160, ((IntBuffer) (obj)).get(0));
                GLES20.glViewport(intbuffer.get(0), intbuffer.get(1), intbuffer.get(2), intbuffer.get(3));
                if (flag || flag1 || c != FLIP_MODE.a)
                {
                    if (flag)
                    {
                        s.b(i1, floatbuffer, floatbuffer1);
                    }
                    if (flag1)
                    {
                        t.b(i1, floatbuffer, floatbuffer1);
                    }
                    if (c != FLIP_MODE.a)
                    {
                        u.b(i1, floatbuffer, floatbuffer1);
                    }
                } else
                {
                    v.b(i1, floatbuffer, floatbuffer1);
                }
            } else
            {
                w.clear();
                if (flag)
                {
                    w.add(s);
                }
                if (com.cyberlink.clgpuimage.m.a(k)[g])
                {
                    w.add(p);
                }
                if (com.cyberlink.clgpuimage.m.a(k)[h])
                {
                    w.add(q);
                }
                if (com.cyberlink.clgpuimage.m.a(k)[d] || com.cyberlink.clgpuimage.m.a(k)[e] || com.cyberlink.clgpuimage.m.a(k)[i])
                {
                    if (j1 == true)
                    {
                        w.add(n);
                    } else
                    {
                        w.add(l);
                    }
                    if (l1 == true)
                    {
                        w.add(o);
                    } else
                    {
                        w.add(m);
                    }
                }
                if (com.cyberlink.clgpuimage.m.a(k)[f])
                {
                    w.add(r);
                }
                if (flag1)
                {
                    w.add(t);
                }
                if (c != FLIP_MODE.a)
                {
                    w.add(u);
                }
                l1 = w.size();
                j1 = 0;
                while (j1 < l1) 
                {
                    if (j1 == l1 - 1)
                    {
                        GLES20.glBindFramebuffer(36160, ((IntBuffer) (obj)).get(0));
                        GLES20.glViewport(intbuffer.get(0), intbuffer.get(1), intbuffer.get(2), intbuffer.get(3));
                    } else
                    {
                        GLES20.glBindFramebuffer(36160, a[j1]);
                        GLES20.glViewport(0, 0, j(), k());
                    }
                    if (j1 == 0)
                    {
                        ((u)w.get(j1)).b(i1, floatbuffer, floatbuffer1);
                    } else
                    {
                        ((u)w.get(j1)).b(b[j1 - 1], floatbuffer, floatbuffer1);
                    }
                    j1++;
                }
            }
        } else
        {
            w.clear();
            if (flag)
            {
                w.add(s);
            }
            if (com.cyberlink.clgpuimage.m.a(k)[g])
            {
                w.add(p);
            }
            if (flag1)
            {
                w.add(t);
            }
            if (c != FLIP_MODE.a)
            {
                w.add(u);
            }
            if (w.size() == 0)
            {
                w.add(v);
            }
            int i2 = w.size();
            int k1 = 0;
            while (k1 < i2) 
            {
                if (k1 == i2 - 1)
                {
                    GLES20.glBindFramebuffer(36160, ((IntBuffer) (obj)).get(0));
                    GLES20.glViewport(intbuffer.get(0), intbuffer.get(1), intbuffer.get(2), intbuffer.get(3));
                } else
                {
                    GLES20.glBindFramebuffer(36160, a[k1]);
                    GLES20.glViewport(0, 0, j(), k());
                }
                if (k1 == 0)
                {
                    ((u)w.get(k1)).b(i1, floatbuffer, floatbuffer1);
                } else
                {
                    ((u)w.get(k1)).b(b[k1 - 1], floatbuffer, floatbuffer1);
                }
                k1++;
            }
        }
        if (flag)
        {
            synchronized (H)
            {
                G = s.f();
                if (!com.cyberlink.clgpuimage.m.b(k))
                {
                    G.d = null;
                }
                I = true;
                H.notify();
            }
        }
        if (flag1)
        {
            synchronized (K)
            {
                J = t.f();
                if (!com.cyberlink.clgpuimage.m.b(k))
                {
                    J.d = null;
                }
                L = true;
                K.notify();
            }
        }
        return;
        floatbuffer;
        obj;
        JVM INSTR monitorexit ;
        throw floatbuffer;
        floatbuffer;
        obj;
        JVM INSTR monitorexit ;
        throw floatbuffer;
        floatbuffer1;
        floatbuffer;
        JVM INSTR monitorexit ;
        throw floatbuffer1;
        floatbuffer1;
        floatbuffer;
        JVM INSTR monitorexit ;
        throw floatbuffer1;
    }

    public boolean b(boolean flag, byte abyte0[], int i1)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!l.b(abyte0, i1) || !n.b(abyte0, i1)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (!m.b(abyte0, i1) || !o.b(abyte0, i1))
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public o[] b(CaptureFrameType captureframetype)
    {
        if (captureframetype != CaptureFrameType.d)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        synchronized (H)
        {
            if (!I)
            {
                H.wait();
            }
            I = false;
            captureframetype = G;
        }
        o o1;
        synchronized (K)
        {
            if (!L)
            {
                K.wait();
            }
            L = false;
            o1 = J;
        }
        return (new o[] {
            captureframetype, o1
        });
        captureframetype;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw captureframetype;
        }
        // Misplaced declaration of an exception variable
        catch (CaptureFrameType captureframetype)
        {
            captureframetype.printStackTrace();
        }
        return null;
        captureframetype;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw captureframetype;
        }
        // Misplaced declaration of an exception variable
        catch (CaptureFrameType captureframetype)
        {
            captureframetype.printStackTrace();
        }
        return null;
        return null;
    }

    public void c()
    {
        v.h();
        p.h();
        l.h();
        m.h();
        n.h();
        o.h();
        r.h();
        q.h();
        s.h();
        t.h();
        u.h();
        m();
        super.c();
    }

    public void c(int i1)
    {
        l.a(i1);
        m.a(i1);
        n.a(i1);
        o.a(i1);
        r.b(i1);
        q.b(i1);
        s.b(i1);
        t.b(i1);
    }

    static 
    {
        d = MakeupLiveFeatures.a.ordinal();
        e = MakeupLiveFeatures.b.ordinal();
        f = MakeupLiveFeatures.c.ordinal();
        g = MakeupLiveFeatures.d.ordinal();
        h = MakeupLiveFeatures.e.ordinal();
        i = MakeupLiveFeatures.f.ordinal();
    }

    private class FLIP_MODE extends Enum
    {

        public static final FLIP_MODE a;
        public static final FLIP_MODE b;
        public static final FLIP_MODE c;
        private static final FLIP_MODE d[];

        public static FLIP_MODE valueOf(String s1)
        {
            return (FLIP_MODE)Enum.valueOf(com/cyberlink/clgpuimage/CLMakeupLiveFilter$FLIP_MODE, s1);
        }

        public static FLIP_MODE[] values()
        {
            return (FLIP_MODE[])d.clone();
        }

        static 
        {
            a = new FLIP_MODE("NONE", 0);
            b = new FLIP_MODE("FOR_PORTRAIT_ORIENTATION", 1);
            c = new FLIP_MODE("FOR_LANDSCAPE_ORIENTATION", 2);
            d = (new FLIP_MODE[] {
                a, b, c
            });
        }

        private FLIP_MODE(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class LiveFrameInformation
    {

        public ArrayList feature_points;
        public boolean is_flipped;
        public int rotation;

        public void Copy(LiveFrameInformation liveframeinformation)
        {
            feature_points = new ArrayList(liveframeinformation.feature_points);
            rotation = liveframeinformation.rotation;
            is_flipped = liveframeinformation.is_flipped;
        }

        public LiveFrameInformation()
        {
            feature_points = new ArrayList();
        }
    }


    private class MakeupLiveFeatures extends Enum
    {

        public static final MakeupLiveFeatures a;
        public static final MakeupLiveFeatures b;
        public static final MakeupLiveFeatures c;
        public static final MakeupLiveFeatures d;
        public static final MakeupLiveFeatures e;
        public static final MakeupLiveFeatures f;
        private static final MakeupLiveFeatures g[];

        public static MakeupLiveFeatures valueOf(String s1)
        {
            return (MakeupLiveFeatures)Enum.valueOf(com/cyberlink/clgpuimage/CLMakeupLiveFilter$MakeupLiveFeatures, s1);
        }

        public static MakeupLiveFeatures[] values()
        {
            return (MakeupLiveFeatures[])g.clone();
        }

        static 
        {
            a = new MakeupLiveFeatures("EYELINER", 0);
            b = new MakeupLiveFeatures("EYESHADOW", 1);
            c = new MakeupLiveFeatures("LIPSTICK", 2);
            d = new MakeupLiveFeatures("SMOOTH", 3);
            e = new MakeupLiveFeatures("BLUSH", 4);
            f = new MakeupLiveFeatures("EYELASH", 5);
            g = (new MakeupLiveFeatures[] {
                a, b, c, d, e, f
            });
        }

        private MakeupLiveFeatures(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class CaptureFrameType extends Enum
    {

        public static final CaptureFrameType a;
        public static final CaptureFrameType b;
        public static final CaptureFrameType c;
        public static final CaptureFrameType d;
        private static final CaptureFrameType e[];

        public static CaptureFrameType valueOf(String s1)
        {
            return (CaptureFrameType)Enum.valueOf(com/cyberlink/clgpuimage/CLMakeupLiveFilter$CaptureFrameType, s1);
        }

        public static CaptureFrameType[] values()
        {
            return (CaptureFrameType[])e.clone();
        }

        static 
        {
            a = new CaptureFrameType("NONE", 0);
            b = new CaptureFrameType("CAPTURE_SOURCE", 1);
            c = new CaptureFrameType("CAPTURE_AFTER_MAKEUP_FILTERS", 2);
            d = new CaptureFrameType("CAPTURE_BOTH", 3);
            e = (new CaptureFrameType[] {
                a, b, c, d
            });
        }

        private CaptureFrameType(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
