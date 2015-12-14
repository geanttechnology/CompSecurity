// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u, l, b, i, 
//            j, af, k

public class CLMakeupLiveEyeFilter extends u
{

    protected static final float au[] = {
        0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F
    };
    protected int A[];
    protected int B[];
    protected ByteBuffer C[];
    protected int D[];
    protected int E[];
    protected Rect F;
    protected Rect G;
    protected Rect H;
    protected Rect I;
    protected Rect J;
    protected Rect K;
    protected int L;
    protected int M;
    protected int N;
    protected int O;
    protected int P;
    protected int Q;
    protected int R;
    protected int S;
    protected int T;
    protected int U;
    protected int V;
    protected int W;
    protected int X;
    protected int Y;
    protected int Z;
    protected int a;
    private Object aE;
    private boolean aF;
    private Object aG;
    private boolean aH;
    private Object aI;
    private boolean aJ;
    private int aK;
    protected boolean aa;
    protected boolean ab;
    protected boolean ac;
    protected int ad;
    protected int ae;
    protected int af;
    protected float ag;
    protected float ah;
    protected int ai;
    protected int aj;
    protected int ak;
    protected Object al;
    LiveEyeMakeupMetadata am;
    protected boolean an;
    protected int ao;
    protected float ap[];
    protected int aq;
    protected int ar;
    protected int as;
    protected int at;
    protected FloatBuffer b;
    protected Bitmap c;
    protected int d;
    protected int e;
    protected int f;
    protected float g[] = {
        0.0F, 0.0F, 0.0F
    };
    protected float h[] = {
        0.0F, 0.0F, 0.0F
    };
    protected int i;
    protected int j;
    protected ByteBuffer k;
    protected int l;
    protected float m[] = {
        0.0F, 0.0F, 0.0F
    };
    protected float n[] = {
        0.0F, 0.0F, 0.0F
    };
    protected int o;
    protected int p;
    protected ByteBuffer q;
    protected boolean r;
    protected PointF s[];
    protected PointF t[];
    protected int u;
    protected int v;
    protected int w;
    protected int x;
    protected int y;
    protected ByteBuffer z[];

    public CLMakeupLiveEyeFilter(boolean flag)
    {
        boolean flag1 = false;
        super(com.cyberlink.clgpuimage.b.a(com.cyberlink.clgpuimage.l.a()), (new StringBuilder()).append(com.cyberlink.clgpuimage.b.a(com.cyberlink.clgpuimage.i.a())).append(com.cyberlink.clgpuimage.b.a(com.cyberlink.clgpuimage.j.a())).toString());
        d = -1;
        i = -1;
        o = -1;
        r = false;
        s = new PointF[4];
        t = new PointF[4];
        z = new ByteBuffer[2];
        A = new int[2];
        B = new int[2];
        C = new ByteBuffer[2];
        D = new int[2];
        E = new int[2];
        F = new Rect();
        G = new Rect();
        H = new Rect();
        I = new Rect();
        J = new Rect();
        K = new Rect();
        aa = false;
        ab = false;
        ac = false;
        al = new Object();
        am = new LiveEyeMakeupMetadata();
        an = true;
        ap = new float[4];
        aE = new Object();
        aF = false;
        aG = new Object();
        aH = false;
        aI = new Object();
        aJ = false;
        aK = 90;
        b = ByteBuffer.allocateDirect(au.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i1 = 0; i1 < 4; i1++)
        {
            s[i1] = new PointF();
            t[i1] = new PointF();
        }

        an = flag;
        for (int j1 = ((flag1) ? 1 : 0); j1 < 2; j1++)
        {
            A[j1] = -1;
            D[j1] = -1;
        }

    }

    protected CLMakeupLiveEyeFilter(boolean flag, String s1, String s2)
    {
        boolean flag1 = false;
        super(s1, s2);
        d = -1;
        i = -1;
        o = -1;
        r = false;
        s = new PointF[4];
        t = new PointF[4];
        z = new ByteBuffer[2];
        A = new int[2];
        B = new int[2];
        C = new ByteBuffer[2];
        D = new int[2];
        E = new int[2];
        F = new Rect();
        G = new Rect();
        H = new Rect();
        I = new Rect();
        J = new Rect();
        K = new Rect();
        aa = false;
        ab = false;
        ac = false;
        al = new Object();
        am = new LiveEyeMakeupMetadata();
        an = true;
        ap = new float[4];
        aE = new Object();
        aF = false;
        aG = new Object();
        aH = false;
        aI = new Object();
        aJ = false;
        aK = 90;
        b = ByteBuffer.allocateDirect(au.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i1 = 0; i1 < 4; i1++)
        {
            s[i1] = new PointF();
            t[i1] = new PointF();
        }

        an = flag;
        for (int j1 = ((flag1) ? 1 : 0); j1 < 2; j1++)
        {
            A[j1] = -1;
            D[j1] = -1;
        }

    }

    private void m()
    {
        Object obj = aE;
        obj;
        JVM INSTR monitorenter ;
        if (!aF) goto _L2; else goto _L1
_L1:
        Object obj1;
        if (d != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                d
            }, 0);
            d = -1;
        }
        if (c != null && !c.isRecycled())
        {
            d = com.cyberlink.clgpuimage.af.a(c, -1, false);
        }
        F.set(I);
        obj1 = IntBuffer.allocate(1);
        GLES20.glGetIntegerv(3317, ((IntBuffer) (obj1)));
        GLES20.glPixelStorei(3317, 1);
        int i1 = 0;
_L12:
        if (i1 >= 2) goto _L4; else goto _L3
_L3:
        if (A[i1] != -1) goto _L6; else goto _L5
_L5:
        int ai1[] = new int[1];
        GLES20.glGenTextures(1, ai1, 0);
        A[i1] = ai1[0];
        GLES20.glBindTexture(3553, A[i1]);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glTexImage2D(3553, 0, 6406, w >> i1, x >> i1, 0, 6406, 5121, z[i1]);
_L10:
        if (D[i1] != -1) goto _L8; else goto _L7
_L7:
        int ai2[] = new int[1];
        GLES20.glGenTextures(1, ai2, 0);
        D[i1] = ai2[0];
        GLES20.glBindTexture(3553, D[i1]);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glTexImage2D(3553, 0, 6406, w >> i1, x >> i1, 0, 6406, 5121, C[i1]);
          goto _L9
_L6:
        GLES20.glBindTexture(3553, A[i1]);
        GLES20.glTexSubImage2D(3553, 0, 0, 0, w >> i1, x >> i1, 6406, 5121, z[i1]);
          goto _L10
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
_L8:
        GLES20.glBindTexture(3553, D[i1]);
        GLES20.glTexSubImage2D(3553, 0, 0, 0, w >> i1, x >> i1, 6406, 5121, C[i1]);
          goto _L9
_L4:
        GLES20.glPixelStorei(3317, ((IntBuffer) (obj1)).get(0));
        aF = false;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
_L9:
        i1++;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void n()
    {
        Object obj = aI;
        obj;
        JVM INSTR monitorenter ;
        if (!aJ) goto _L2; else goto _L1
_L1:
        IntBuffer intbuffer;
        intbuffer = IntBuffer.allocate(1);
        GLES20.glGetIntegerv(3317, intbuffer);
        GLES20.glPixelStorei(3317, 1);
        if (o != -1)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        int ai1[] = new int[1];
        GLES20.glGenTextures(1, ai1, 0);
        o = ai1[0];
        GLES20.glBindTexture(3553, o);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glTexImage2D(3553, 0, 6406, u, v, 0, 6406, 5121, q);
_L4:
        GLES20.glPixelStorei(3317, intbuffer.get(0));
        H.set(K);
        aJ = false;
_L2:
        return;
        GLES20.glBindTexture(3553, o);
        GLES20.glTexSubImage2D(3553, 0, 0, 0, u, v, 6406, 5121, q);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void o()
    {
        Object obj = aG;
        obj;
        JVM INSTR monitorenter ;
        if (!aH) goto _L2; else goto _L1
_L1:
        IntBuffer intbuffer;
        intbuffer = IntBuffer.allocate(1);
        GLES20.glGetIntegerv(3317, intbuffer);
        GLES20.glPixelStorei(3317, 1);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        int ai1[] = new int[1];
        GLES20.glGenTextures(1, ai1, 0);
        i = ai1[0];
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glTexImage2D(3553, 0, 6406, u, v, 0, 6406, 5121, k);
_L4:
        GLES20.glPixelStorei(3317, intbuffer.get(0));
        G.set(J);
        aH = false;
_L2:
        return;
        GLES20.glBindTexture(3553, i);
        GLES20.glTexSubImage2D(3553, 0, 0, 0, u, v, 6406, 5121, k);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a()
    {
        super.a();
        a = GLES20.glGetAttribLocation(l(), "inputTemplateTextureCoordinate");
        e = GLES20.glGetUniformLocation(l(), "eyeshadow_texture");
        j = GLES20.glGetUniformLocation(l(), "eyeliner_texture");
        p = GLES20.glGetUniformLocation(l(), "eyelash_texture");
        ao = GLES20.glGetUniformLocation(l(), "left_right_flip");
        f = GLES20.glGetUniformLocation(l(), "eyeliner_template_color");
        l = GLES20.glGetUniformLocation(l(), "eyelash_template_color");
        L = GLES20.glGetUniformLocation(l(), "frame_to_template_y_remapping_factor");
        M = GLES20.glGetUniformLocation(l(), "target_eye_lower_lid_luma");
        N = GLES20.glGetUniformLocation(l(), "level_orient_cos_sin");
        O = GLES20.glGetUniformLocation(l(), "oriented_upper_lid_center");
        P = GLES20.glGetUniformLocation(l(), "oriented_lower_lid_center");
        Q = GLES20.glGetUniformLocation(l(), "similarity_origin");
        R = GLES20.glGetUniformLocation(l(), "similarity_shift");
        S = GLES20.glGetUniformLocation(l(), "similarity_scale");
        T = GLES20.glGetUniformLocation(l(), "top_spline_transform_src_dst_center");
        U = GLES20.glGetUniformLocation(l(), "top_left_spline_transform_src_dst_aligned_parabolic_coeff");
        V = GLES20.glGetUniformLocation(l(), "top_right_spline_transform_src_dst_aligned_parabolic_coeff");
        W = GLES20.glGetUniformLocation(l(), "bottom_spline_transform_src_dst_center");
        X = GLES20.glGetUniformLocation(l(), "bottom_left_spline_transform_src_dst_aligned_parabolic_coeff");
        Y = GLES20.glGetUniformLocation(l(), "bottom_right_spline_transform_src_dst_aligned_parabolic_coeff");
        ad = GLES20.glGetUniformLocation(l(), "enable_eyeshadow");
        ae = GLES20.glGetUniformLocation(l(), "enable_eyeliner");
        af = GLES20.glGetUniformLocation(l(), "enable_eyelash");
        a(aa);
        b(ab);
        c(ac);
        aq = GLES20.glGetUniformLocation(l(), "roi");
        ar = GLES20.glGetUniformLocation(l(), "eyeshadow_multiply_correction");
        as = GLES20.glGetUniformLocation(l(), "analyzing_frame_width_height_in_pixel");
        Z = GLES20.glGetUniformLocation(l(), "environment_luma");
        at = GLES20.glGetUniformLocation(l(), "upper_lid_eyelash_y_scale_adjuster");
        ai = GLES20.glGetUniformLocation(l(), "shimmer_model_scale");
        aj = GLES20.glGetUniformLocation(l(), "environment_brightest");
        ak = GLES20.glGetUniformLocation(l(), "environment_compress");
        B[0] = GLES20.glGetUniformLocation(l(), "bright0_texture");
        E[0] = GLES20.glGetUniformLocation(l(), "glitter0_texture");
        B[1] = GLES20.glGetUniformLocation(l(), "bright1_texture");
        E[1] = GLES20.glGetUniformLocation(l(), "glitter1_texture");
    }

    public void a(int i1)
    {
        aK = i1;
    }

    public void a(int i1, int j1)
    {
        super.a(i1, j1);
    }

    public void a(LiveEyeMakeupMetadata liveeyemakeupmetadata)
    {
        synchronized (al)
        {
            am.Copy(liveeyemakeupmetadata);
        }
        return;
        liveeyemakeupmetadata;
        obj;
        JVM INSTR monitorexit ;
        throw liveeyemakeupmetadata;
    }

    public void a(boolean flag)
    {
        aa = flag;
        int j1 = ad;
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        d(j1, i1);
    }

    public void a(PointF apointf[], int i1, int j1, int k1, int l1, int i2)
    {
        if (i2 != 2)
        {
            return;
        }
        u = i1;
        v = j1;
        w = k1;
        x = l1;
        k = ByteBuffer.allocate(i1 * j1);
        q = ByteBuffer.allocate(i1 * j1);
        y = 0;
        for (int j2 = 0; j2 < i2; j2++)
        {
            y = y + (k1 >> j2) * (l1 >> j2);
        }

        for (i2 = 0; i2 < 2; i2++)
        {
            z[i2] = ByteBuffer.allocate((k1 >> i2) * (l1 >> i2));
            C[i2] = ByteBuffer.allocate((k1 >> i2) * (l1 >> i2));
        }

        for (k1 = 0; k1 < 4; k1++)
        {
            t[k1] = apointf[k1];
        }

        apointf = new PointF(t[1].x, t[0].y);
        ap[0] = ((PointF) (apointf)).x / (((PointF) (apointf)).x - t[0].x);
        ap[1] = ((PointF) (apointf)).y / (((PointF) (apointf)).y - t[1].y);
        ap[2] = ((float)i1 - ((PointF) (apointf)).x) / (t[2].x - ((PointF) (apointf)).x);
        ap[3] = ((float)j1 - ((PointF) (apointf)).y) / (t[3].y - ((PointF) (apointf)).y);
        F.set(Math.round(((PointF) (apointf)).x), Math.round(((PointF) (apointf)).y), Math.round(((PointF) (apointf)).x), Math.round(((PointF) (apointf)).y));
        G.set(Math.round(((PointF) (apointf)).x), Math.round(((PointF) (apointf)).y), Math.round(((PointF) (apointf)).x), Math.round(((PointF) (apointf)).y));
        H.set(Math.round(((PointF) (apointf)).x), Math.round(((PointF) (apointf)).y), Math.round(((PointF) (apointf)).x), Math.round(((PointF) (apointf)).y));
        r = true;
    }

    boolean a(Rect rect, int ai1[], int i1)
    {
        if (rect == null)
        {
            return false;
        }
        rect.top = v;
        rect.bottom = -1;
        rect.left = u;
        rect.right = -1;
        for (int j1 = 0; j1 < v; j1++)
        {
            int l1 = u;
            for (int k1 = 0; k1 < u; k1++)
            {
                if (Color.alpha(ai1[j1 * l1 + k1]) > i1)
                {
                    rect.top = Math.min(rect.top, j1);
                    rect.bottom = Math.max(rect.bottom, j1);
                    rect.left = Math.min(rect.left, k1);
                    rect.right = Math.max(rect.right, k1);
                }
            }

        }

        if (rect.top == v || rect.bottom == -1 || rect.left == u || rect.right == -1)
        {
            rect.top = 0;
            rect.bottom = v;
            rect.left = 0;
            rect.right = u;
        }
        return true;
    }

    public boolean a(byte abyte0[], int i1)
    {
        boolean flag;
        for (flag = false; !r || abyte0.length != u * v;)
        {
            return false;
        }

        m[0] = (float)Color.red(i1) / 255F;
        m[1] = (float)Color.green(i1) / 255F;
        m[2] = (float)Color.blue(i1) / 255F;
        int ai1[] = new int[u * v];
        for (i1 = ((flag) ? 1 : 0); i1 < u * v; i1++)
        {
            ai1[i1] = abyte0[i1] << 24;
        }

        synchronized (aI)
        {
            a(K, ai1, 0);
            q.clear();
            q.put(abyte0);
            q.position(0);
            aJ = true;
        }
        return true;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public boolean a(int ai1[], byte abyte0[], byte abyte1[])
    {
        int i1;
        i1 = 0;
        if (!r)
        {
            return false;
        }
        if (ai1.length != u * v)
        {
            return false;
        }
        if (abyte0.length != y)
        {
            return false;
        }
        if (abyte1.length != y)
        {
            return false;
        }
        Object obj = aE;
        obj;
        JVM INSTR monitorenter ;
        a(I, ai1, 0);
        c = Bitmap.createBitmap(u, v, android.graphics.Bitmap.Config.ARGB_8888);
        c.setPixels(ai1, 0, u, 0, 0, u, v);
        int j1 = 0;
_L2:
        if (i1 >= 2)
        {
            break; /* Loop/switch isn't completed */
        }
        int k1;
        k1 = (w >> i1) * (x >> i1);
        z[i1].clear();
        z[i1].put(abyte0, j1, k1);
        z[i1].position(0);
        C[i1].clear();
        C[i1].put(abyte1, j1, k1);
        C[i1].position(0);
        j1 += k1;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        aF = true;
        obj;
        JVM INSTR monitorexit ;
        return true;
        ai1;
        obj;
        JVM INSTR monitorexit ;
        throw ai1;
    }

    protected float[] a(float af1[], int i1)
    {
        if (i1 == (aK + 270) % 360)
        {
            return (new float[] {
                af1[4], af1[5], af1[0], af1[1], af1[6], af1[7], af1[2], af1[3]
            });
        }
        if (i1 == (aK + 180) % 360)
        {
            return (new float[] {
                af1[6], af1[7], af1[4], af1[5], af1[2], af1[3], af1[0], af1[1]
            });
        }
        if (i1 == (aK + 90) % 360)
        {
            return (new float[] {
                af1[2], af1[3], af1[6], af1[7], af1[0], af1[1], af1[4], af1[5]
            });
        } else
        {
            return (new float[] {
                af1[0], af1[1], af1[2], af1[3], af1[4], af1[5], af1[6], af1[7]
            });
        }
    }

    public void b()
    {
        super.b();
    }

    public void b(boolean flag)
    {
        ab = flag;
        int j1 = ae;
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        d(j1, i1);
    }

    public boolean b(byte abyte0[], int i1)
    {
        boolean flag;
        for (flag = false; !r || abyte0.length != u * v;)
        {
            return false;
        }

        g[0] = (float)Color.red(i1) / 255F;
        g[1] = (float)Color.green(i1) / 255F;
        g[2] = (float)Color.blue(i1) / 255F;
        int ai1[] = new int[u * v];
        for (i1 = ((flag) ? 1 : 0); i1 < u * v; i1++)
        {
            ai1[i1] = abyte0[i1] << 24;
        }

        synchronized (aG)
        {
            a(J, ai1, 0);
            k.clear();
            k.put(abyte0);
            k.position(0);
            aH = true;
        }
        return true;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public void c()
    {
        super.c();
        if (d != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                d
            }, 0);
            d = -1;
        }
        if (i != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                i
            }, 0);
            i = -1;
        }
        if (o != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                o
            }, 0);
            o = -1;
        }
        for (int i1 = 0; i1 < 2; i1++)
        {
            if (A[i1] != -1)
            {
                GLES20.glDeleteTextures(1, new int[] {
                    A[i1]
                }, 0);
                A[i1] = -1;
            }
            if (D[i1] != -1)
            {
                GLES20.glDeleteTextures(1, new int[] {
                    D[i1]
                }, 0);
                D[i1] = -1;
            }
        }

    }

    public void c(boolean flag)
    {
        ac = flag;
        int j1 = af;
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        d(j1, i1);
    }

    protected void d_()
    {
        super.d_();
        m();
        o();
        n();
    }

    protected void e()
    {
        int i1;
        int j1 = 33985;
        int k1;
        int j2;
        int k2;
        if (d != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, d);
            GLES20.glUniform1i(e, 1);
            j1 = 33986;
            j2 = 2;
        } else
        {
            j2 = 1;
        }
        k1 = j2;
        i1 = j1;
        if (i != -1)
        {
            GLES20.glActiveTexture(j1);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(j, j2);
            k1 = j2 + 1;
            i1 = j1 + 1;
        }
        j1 = k1;
        j2 = i1;
        if (o != -1)
        {
            GLES20.glActiveTexture(i1);
            GLES20.glBindTexture(3553, o);
            GLES20.glUniform1i(p, k1);
            j1 = k1 + 1;
            j2 = i1 + 1;
        }
        k2 = 0;
        i1 = j1;
        j1 = j2;
        while (k2 < 2) 
        {
            float f1;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            Object obj1;
            Exception exception1;
            PointF pointf;
            int i2;
            if (A[k2] != -1)
            {
                GLES20.glActiveTexture(j1);
                GLES20.glBindTexture(3553, A[k2]);
                int l1 = B[k2];
                j2 = i1 + 1;
                GLES20.glUniform1i(l1, i1);
                i1 = j1 + 1;
            } else
            {
                j2 = i1;
                i1 = j1;
            }
            j1 = j2;
            i2 = i1;
            if (D[k2] != -1)
            {
                GLES20.glActiveTexture(i1);
                GLES20.glBindTexture(3553, D[k2]);
                GLES20.glUniform1i(E[k2], j2);
                j1 = j2 + 1;
                i2 = i1 + 1;
            }
            k2++;
            i1 = j1;
            j1 = i2;
        }
        synchronized (al)
        {
            f1 = am.m_environment_darkest_reference_normalized_luma;
            f2 = am.m_environment_brightest_reference_normalized_luma;
            ag = f2;
            ah = f2 - f1;
            h[0] = (f2 - f1) * g[0] + f1;
            h[1] = (f2 - f1) * g[1] + f1;
            h[2] = (f2 - f1) * g[2] + f1;
            n[0] = (f2 - f1) * m[0] + f1;
            n[1] = (f2 - f1) * m[1] + f1;
            n[2] = f1 + (f2 - f1) * m[2];
        }
        GLES20.glUniform3fv(f, 1, FloatBuffer.wrap(h));
        GLES20.glUniform3fv(l, 1, FloatBuffer.wrap(n));
        GLES20.glUniform1f(aj, ag);
        GLES20.glUniform1f(ak, ah);
        i1 = ao;
        if (an)
        {
            f1 = 0.0F;
        } else
        {
            f1 = 1.0F;
        }
        GLES20.glUniform1f(i1, f1);
        obj = al;
        obj;
        JVM INSTR monitorenter ;
        b.clear();
        b.put(a(au, am.m_rotation));
        b.position(0);
        GLES20.glVertexAttribPointer(a, 2, 5126, false, 0, b);
        GLES20.glEnableVertexAttribArray(a);
        i1 = 0;
_L2:
        if (i1 >= 4)
        {
            break; /* Loop/switch isn't completed */
        }
        s[i1].x = t[i1].x / (float)u;
        s[i1].y = t[i1].y / (float)v;
        i1++;
        if (true) goto _L2; else goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        GLES20.glUniform2f(as, am.m_analyzing_frame_width, am.m_analyzing_frame_height);
        if (u * am.m_analyzing_frame_height <= 0 || v * am.m_analyzing_frame_width <= 0) goto _L4; else goto _L3
_L3:
        f1 = (float)(v * am.m_analyzing_frame_width) / (float)(u * am.m_analyzing_frame_height);
          goto _L5
_L7:
        if (i1 >= 4)
        {
            break MISSING_BLOCK_LABEL_797;
        }
        obj1 = s[i1];
        obj1.y = ((PointF) (obj1)).y * f1;
        i1++;
        continue; /* Loop/switch isn't completed */
        GLES20.glUniform1f(L, 1.0F / f1);
        f2 = (s[2].x - s[0].x) / (am.m_oriented_eye_points[2].x - am.m_oriented_eye_points[0].x);
        f3 = Math.max(0.0F, Math.min(1.0F, (((1.0F / f2) * (float)u) / (float)w - 0.35F) / 0.3F));
        GLES20.glUniform1f(ai, f3);
        obj1 = new Rect();
        ((Rect) (obj1)).union(F);
        ((Rect) (obj1)).union(G);
        ((Rect) (obj1)).union(H);
        pointf = new PointF(t[1].x, t[0].y);
        ap[0] = (pointf.x - (float)((Rect) (obj1)).left) / (pointf.x - t[0].x);
        ap[1] = (pointf.y - (float)((Rect) (obj1)).top) / (pointf.y - t[1].y);
        ap[2] = ((float)((Rect) (obj1)).right - pointf.x) / (t[2].x - pointf.x);
        ap[3] = ((float)((Rect) (obj1)).bottom - pointf.y) / (t[3].y - pointf.y);
        f3 = Math.min(Math.max(am.m_oriented_eye_centers[0].x, am.m_oriented_eye_centers[1].x) + ap[0] * (am.m_oriented_eye_points[0].x - Math.max(am.m_oriented_eye_centers[0].x, am.m_oriented_eye_centers[1].x)), am.m_oriented_eye_centers[0].x - (s[1].x - (float)((Rect) (obj1)).left / (float)u) / f2);
        f4 = Math.max(Math.min(am.m_oriented_eye_centers[0].x, am.m_oriented_eye_centers[1].x) + ap[2] * (am.m_oriented_eye_points[2].x - Math.min(am.m_oriented_eye_centers[0].x, am.m_oriented_eye_centers[1].x)), am.m_oriented_eye_centers[0].x + ((float)(((Rect) (obj1)).right / u) - s[1].x) / f2);
        f1 = Math.min(am.m_oriented_eye_centers[0].y + ap[1] * (am.m_oriented_eye_points[1].y - am.m_oriented_eye_centers[0].y), am.m_oriented_eye_centers[0].y - (s[0].y - f1 * ((float)((Rect) (obj1)).top / (float)v)) / f2);
        f5 = am.m_oriented_eye_centers[1].y;
        f6 = ap[3];
        f7 = am.m_oriented_eye_points[3].y;
        f8 = am.m_oriented_eye_centers[1].y;
        GLES20.glUniform4f(aq, f3, f4, f1, f5 + f6 * (f7 - f8));
        GLES20.glUniform1f(M, am.m_target_eye_lower_lid_luma);
        f1 = Math.max(1.0F, Math.min(5F, ((float)Math.pow(Math.max(0.0F, (0.5F - am.m_target_eye_lower_lid_luma) / 0.5F), 0.25D) + 1.0F) * (0.5F / Math.max(am.m_target_eye_lower_lid_luma, 0.001F))));
        GLES20.glUniform1f(ar, f1);
        GLES20.glUniform2f(N, am.m_target_level_orientation_cos, am.m_target_level_orientation_sin);
        GLES20.glUniform2f(O, am.m_oriented_eye_centers[0].x, am.m_oriented_eye_centers[0].y);
        GLES20.glUniform2f(P, am.m_oriented_eye_centers[1].x, am.m_oriented_eye_centers[1].y);
        GLES20.glUniform2f(Q, am.m_oriented_eye_points[0].x, am.m_oriented_eye_points[0].y);
        GLES20.glUniform2f(R, s[0].x - am.m_oriented_eye_points[0].x, s[0].y - am.m_oriented_eye_points[0].y);
        GLES20.glUniform1f(S, f2);
        GLES20.glUniform4f(T, am.m_parabolic_polar_transform_top_left_src_center.x, am.m_parabolic_polar_transform_top_left_src_center.y, am.m_parabolic_polar_transform_top_left_dst_center.x, am.m_parabolic_polar_transform_top_left_dst_center.y);
        GLES20.glUniform4f(U, am.m_parabolic_polar_transform_top_left_src_aligned_coeff[0], am.m_parabolic_polar_transform_top_left_src_aligned_coeff[1], am.m_parabolic_polar_transform_top_left_dst_aligned_coeff[0], am.m_parabolic_polar_transform_top_left_dst_aligned_coeff[1]);
        GLES20.glUniform4f(V, am.m_parabolic_polar_transform_top_right_src_aligned_coeff[0], am.m_parabolic_polar_transform_top_right_src_aligned_coeff[1], am.m_parabolic_polar_transform_top_right_dst_aligned_coeff[0], am.m_parabolic_polar_transform_top_right_dst_aligned_coeff[1]);
        GLES20.glUniform4f(W, am.m_parabolic_polar_transform_bottom_left_src_center.x, am.m_parabolic_polar_transform_bottom_left_src_center.y, am.m_parabolic_polar_transform_bottom_left_dst_center.x, am.m_parabolic_polar_transform_bottom_left_dst_center.y);
        GLES20.glUniform4f(X, am.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[0], am.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[1], am.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[0], am.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[1]);
        GLES20.glUniform4f(Y, am.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[0], am.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[1], am.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[0], am.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[1]);
        GLES20.glUniform2f(Z, am.m_environment_darkest_reference_normalized_luma, am.m_environment_brightest_reference_normalized_luma);
        f1 = Math.max(0.2F, Math.min(1.0F, ((am.m_parabolic_polar_transform_top_left_src_aligned_coeff[1] * f2) / am.m_parabolic_polar_transform_top_left_dst_aligned_coeff[1]) * 1.2F));
        GLES20.glUniform1f(at, f1);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
_L4:
        f1 = 1.0F;
_L5:
        i1 = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void f()
    {
        a(com.cyberlink.clgpuimage.b.a(com.cyberlink.clgpuimage.l.a()), com.cyberlink.clgpuimage.b.a(com.cyberlink.clgpuimage.k.a()));
    }


    private class LiveEyeMakeupMetadata
    {

        int m_analyzing_frame_height;
        int m_analyzing_frame_width;
        public float m_environment_brightest_reference_normalized_luma;
        public float m_environment_darkest_reference_normalized_luma;
        PointF m_eye_points[];
        public boolean m_is_flipped;
        public EyeMode m_mode;
        PointF m_oriented_eye_centers[];
        PointF m_oriented_eye_points[];
        float m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[];
        PointF m_parabolic_polar_transform_bottom_left_dst_center;
        float m_parabolic_polar_transform_bottom_left_src_aligned_coeff[];
        PointF m_parabolic_polar_transform_bottom_left_src_center;
        float m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[];
        PointF m_parabolic_polar_transform_bottom_right_dst_center;
        float m_parabolic_polar_transform_bottom_right_src_aligned_coeff[];
        PointF m_parabolic_polar_transform_bottom_right_src_center;
        float m_parabolic_polar_transform_top_left_dst_aligned_coeff[];
        PointF m_parabolic_polar_transform_top_left_dst_center;
        float m_parabolic_polar_transform_top_left_src_aligned_coeff[];
        PointF m_parabolic_polar_transform_top_left_src_center;
        float m_parabolic_polar_transform_top_right_dst_aligned_coeff[];
        PointF m_parabolic_polar_transform_top_right_dst_center;
        float m_parabolic_polar_transform_top_right_src_aligned_coeff[];
        PointF m_parabolic_polar_transform_top_right_src_center;
        public float m_ratio_of_actual_lower_lid_height_to_limited_height;
        public float m_ratio_of_actual_upper_lid_height_to_limited_height;
        public int m_rotation;
        float m_target_eye_lower_lid_luma;
        float m_target_level_orientation_cos;
        float m_target_level_orientation_sin;

        public void Copy(LiveEyeMakeupMetadata liveeyemakeupmetadata)
        {
            boolean flag = false;
            m_target_eye_lower_lid_luma = liveeyemakeupmetadata.m_target_eye_lower_lid_luma;
            m_analyzing_frame_width = liveeyemakeupmetadata.m_analyzing_frame_width;
            m_analyzing_frame_height = liveeyemakeupmetadata.m_analyzing_frame_height;
            m_target_level_orientation_cos = liveeyemakeupmetadata.m_target_level_orientation_cos;
            m_target_level_orientation_sin = liveeyemakeupmetadata.m_target_level_orientation_sin;
            for (int i1 = 0; i1 < 4; i1++)
            {
                m_eye_points[i1].x = liveeyemakeupmetadata.m_eye_points[i1].x;
                m_eye_points[i1].y = liveeyemakeupmetadata.m_eye_points[i1].y;
                m_oriented_eye_points[i1].x = liveeyemakeupmetadata.m_oriented_eye_points[i1].x;
                m_oriented_eye_points[i1].y = liveeyemakeupmetadata.m_oriented_eye_points[i1].y;
            }

            for (int j1 = 0; j1 < 2; j1++)
            {
                m_oriented_eye_centers[j1].x = liveeyemakeupmetadata.m_oriented_eye_centers[j1].x;
                m_oriented_eye_centers[j1].y = liveeyemakeupmetadata.m_oriented_eye_centers[j1].y;
            }

            m_parabolic_polar_transform_top_left_src_center.x = liveeyemakeupmetadata.m_parabolic_polar_transform_top_left_src_center.x;
            m_parabolic_polar_transform_top_left_src_center.y = liveeyemakeupmetadata.m_parabolic_polar_transform_top_left_src_center.y;
            m_parabolic_polar_transform_top_left_dst_center.x = liveeyemakeupmetadata.m_parabolic_polar_transform_top_left_dst_center.x;
            m_parabolic_polar_transform_top_left_dst_center.y = liveeyemakeupmetadata.m_parabolic_polar_transform_top_left_dst_center.y;
            for (int k1 = 0; k1 < 2; k1++)
            {
                m_parabolic_polar_transform_top_left_src_aligned_coeff[k1] = liveeyemakeupmetadata.m_parabolic_polar_transform_top_left_src_aligned_coeff[k1];
                m_parabolic_polar_transform_top_left_dst_aligned_coeff[k1] = liveeyemakeupmetadata.m_parabolic_polar_transform_top_left_dst_aligned_coeff[k1];
            }

            m_parabolic_polar_transform_top_right_src_center.x = liveeyemakeupmetadata.m_parabolic_polar_transform_top_right_src_center.x;
            m_parabolic_polar_transform_top_right_src_center.y = liveeyemakeupmetadata.m_parabolic_polar_transform_top_right_src_center.y;
            m_parabolic_polar_transform_top_right_dst_center.x = liveeyemakeupmetadata.m_parabolic_polar_transform_top_right_dst_center.x;
            m_parabolic_polar_transform_top_right_dst_center.y = liveeyemakeupmetadata.m_parabolic_polar_transform_top_right_dst_center.y;
            for (int l1 = 0; l1 < 2; l1++)
            {
                m_parabolic_polar_transform_top_right_src_aligned_coeff[l1] = liveeyemakeupmetadata.m_parabolic_polar_transform_top_right_src_aligned_coeff[l1];
                m_parabolic_polar_transform_top_right_dst_aligned_coeff[l1] = liveeyemakeupmetadata.m_parabolic_polar_transform_top_right_dst_aligned_coeff[l1];
            }

            m_parabolic_polar_transform_bottom_left_src_center.x = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_left_src_center.x;
            m_parabolic_polar_transform_bottom_left_src_center.y = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_left_src_center.y;
            m_parabolic_polar_transform_bottom_left_dst_center.x = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_left_dst_center.x;
            m_parabolic_polar_transform_bottom_left_dst_center.y = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_left_dst_center.y;
            for (int i2 = 0; i2 < 2; i2++)
            {
                m_parabolic_polar_transform_bottom_left_src_aligned_coeff[i2] = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[i2];
                m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[i2] = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[i2];
            }

            m_parabolic_polar_transform_bottom_right_src_center.x = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_right_src_center.x;
            m_parabolic_polar_transform_bottom_right_src_center.y = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_right_src_center.y;
            m_parabolic_polar_transform_bottom_right_dst_center.x = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_right_dst_center.x;
            m_parabolic_polar_transform_bottom_right_dst_center.y = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_right_dst_center.y;
            for (int j2 = ((flag) ? 1 : 0); j2 < 2; j2++)
            {
                m_parabolic_polar_transform_bottom_right_src_aligned_coeff[j2] = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[j2];
                m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[j2] = liveeyemakeupmetadata.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[j2];
            }

            m_environment_darkest_reference_normalized_luma = liveeyemakeupmetadata.m_environment_darkest_reference_normalized_luma;
            m_environment_brightest_reference_normalized_luma = liveeyemakeupmetadata.m_environment_brightest_reference_normalized_luma;
            m_rotation = liveeyemakeupmetadata.m_rotation;
            m_is_flipped = liveeyemakeupmetadata.m_is_flipped;
            m_mode = liveeyemakeupmetadata.m_mode;
            m_ratio_of_actual_upper_lid_height_to_limited_height = liveeyemakeupmetadata.m_ratio_of_actual_upper_lid_height_to_limited_height;
            m_ratio_of_actual_lower_lid_height_to_limited_height = liveeyemakeupmetadata.m_ratio_of_actual_lower_lid_height_to_limited_height;
        }

        public LiveEyeMakeupMetadata()
        {
            boolean flag = false;
            super();
            m_eye_points = new PointF[4];
            for (int i1 = 0; i1 < 4; i1++)
            {
                m_eye_points[i1] = new PointF();
            }

            m_oriented_eye_points = new PointF[4];
            for (int j1 = 0; j1 < 4; j1++)
            {
                m_oriented_eye_points[j1] = new PointF();
            }

            m_oriented_eye_centers = new PointF[2];
            for (int k1 = ((flag) ? 1 : 0); k1 < 2; k1++)
            {
                m_oriented_eye_centers[k1] = new PointF();
            }

            m_parabolic_polar_transform_top_left_src_center = new PointF();
            m_parabolic_polar_transform_top_left_dst_center = new PointF();
            m_parabolic_polar_transform_top_left_src_aligned_coeff = new float[2];
            m_parabolic_polar_transform_top_left_dst_aligned_coeff = new float[2];
            m_parabolic_polar_transform_top_right_src_center = new PointF();
            m_parabolic_polar_transform_top_right_dst_center = new PointF();
            m_parabolic_polar_transform_top_right_src_aligned_coeff = new float[2];
            m_parabolic_polar_transform_top_right_dst_aligned_coeff = new float[2];
            m_parabolic_polar_transform_bottom_left_src_center = new PointF();
            m_parabolic_polar_transform_bottom_left_dst_center = new PointF();
            m_parabolic_polar_transform_bottom_left_src_aligned_coeff = new float[2];
            m_parabolic_polar_transform_bottom_left_dst_aligned_coeff = new float[2];
            m_parabolic_polar_transform_bottom_right_src_center = new PointF();
            m_parabolic_polar_transform_bottom_right_dst_center = new PointF();
            m_parabolic_polar_transform_bottom_right_src_aligned_coeff = new float[2];
            m_parabolic_polar_transform_bottom_right_dst_aligned_coeff = new float[2];
        }
    }

}
