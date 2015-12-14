// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u, b, af, a

public class CLMakeupLiveBlushFilter extends u
{

    private static final float D[] = {
        0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F
    };
    private static final char E[] = {
        '\372', '\215', '\215', '\213', '\362', '\373', '\216', '\215', '\376', '\350', 
        '\217', '\376', '\374', '\253', '\350', '\211', '\210', '\214', '\362', '\215', 
        '\362', '\210', '\367', '\242', '\372', '\215', '\215', '\213', '\362', '\373', 
        '\216', '\215', '\376', '\350', '\217', '\376', '\374', '\253', '\350', '\362', 
        '\367', '\211', '\216', '\215', '\355', '\376', '\201', '\215', '\216', '\213', 
        '\376', '\272', '\210', '\210', '\213', '\375', '\362', '\367', '\372', '\215', 
        '\376', '\242', '\372', '\215', '\215', '\213', '\362', '\373', '\216', '\215', 
        '\376', '\350', '\217', '\376', '\374', '\253', '\350', '\362', '\367', '\211', 
        '\216', '\215', '\355', '\376', '\366', '\211', '\365', '\372', '\215', '\376', 
        '\355', '\376', '\201', '\215', '\216', '\213', '\376', '\272', '\210', '\210', 
        '\213', '\375', '\362', '\367', '\372', '\215', '\376', '\242', '\217', '\372', 
        '\213', '\202', '\362', '\367', '\360', '\350', '\217', '\376', '\374', '\251', 
        '\350', '\215', '\376', '\201', '\215', '\216', '\213', '\376', '\272', '\210', 
        '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', '\242', '\217', 
        '\372', '\213', '\202', '\362', '\367', '\360', '\350', '\217', '\376', '\374', 
        '\251', '\350', '\265', '\210', '\353', '\210', '\215', '\372', '\215', '\376', 
        '\272', '\210', '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', 
        '\242', '\217', '\372', '\213', '\202', '\362', '\367', '\360', '\350', '\217', 
        '\376', '\374', '\251', '\350', '\263', '\376', '\377', '\215', '\271', '\365', 
        '\216', '\214', '\361', '\265', '\210', '\353', '\210', '\215', '\372', '\215', 
        '\376', '\272', '\210', '\210', '\213', '\375', '\362', '\367', '\372', '\215', 
        '\376', '\242', '\217', '\372', '\213', '\202', '\362', '\367', '\360', '\350', 
        '\217', '\376', '\374', '\251', '\350', '\353', '\362', '\360', '\361', '\215', 
        '\271', '\365', '\216', '\214', '\361', '\265', '\210', '\353', '\210', '\215', 
        '\372', '\215', '\376', '\272', '\210', '\210', '\213', '\375', '\362', '\367', 
        '\372', '\215', '\376', '\242', '\216', '\367', '\362', '\377', '\210', '\213', 
        '\366', '\350', '\217', '\376', '\374', '\251', '\350', '\365', '\376', '\377', 
        '\215', '\370', '\373', '\365', '\216', '\214', '\361', '\370', '\213', '\210', 
        '\362', '\242', '\216', '\367', '\362', '\377', '\210', '\213', '\366', '\350', 
        '\217', '\376', '\374', '\251', '\350', '\213', '\362', '\360', '\361', '\215', 
        '\370', '\373', '\365', '\216', '\214', '\361', '\370', '\213', '\210', '\362', 
        '\242', '\216', '\367', '\362', '\377', '\210', '\213', '\366', '\350', '\217', 
        '\376', '\374', '\251', '\350', '\365', '\376', '\377', '\215', '\370', '\373', 
        '\365', '\216', '\214', '\361', '\370', '\214', '\215', '\213', '\376', '\215', 
        '\374', '\361', '\242', '\216', '\367', '\362', '\377', '\210', '\213', '\366', 
        '\350', '\217', '\376', '\374', '\251', '\350', '\213', '\362', '\360', '\361', 
        '\215', '\370', '\373', '\365', '\216', '\214', '\361', '\370', '\214', '\215', 
        '\213', '\376', '\215', '\374', '\361', '\242', '\216', '\367', '\362', '\377', 
        '\210', '\213', '\366', '\350', '\217', '\376', '\374', '\251', '\350', '\272', 
        '\210', '\214', '\370', '\354', '\362', '\367', '\242', '\216', '\367', '\362', 
        '\377', '\210', '\213', '\366', '\350', '\217', '\376', '\374', '\251', '\350', 
        '\367', '\376', '\360', '\354', '\362', '\367', '\370', '\272', '\210', '\214', 
        '\242', '\216', '\367', '\362', '\377', '\210', '\213', '\366', '\350', '\217', 
        '\376', '\374', '\251', '\350', '\353', '\210', '\215', '\372', '\215', '\376', 
        '\272', '\376', '\367', '\215', '\376', '\213', '\242', '\217', '\210', '\362', 
        '\375', '\350', '\366', '\372', '\362', '\367', '\237', '\220', '\204', '\360', 
        '\365', '\370', '\351', '\210', '\214', '\362', '\215', '\362', '\210', '\367', 
        '\350', '\244', '\350', '\211', '\210', '\214', '\362', '\215', '\362', '\210', 
        '\367', '\242', '\215', '\376', '\201', '\215', '\216', '\213', '\376', '\272', 
        '\210', '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', '\350', 
        '\244', '\350', '\362', '\367', '\211', '\216', '\215', '\355', '\376', '\201', 
        '\215', '\216', '\213', '\376', '\272', '\210', '\210', '\213', '\375', '\362', 
        '\367', '\372', '\215', '\376', '\225', '\201', '\202', '\242', '\217', '\376', 
        '\374', '\251', '\350', '\215', '\366', '\211', '\350', '\244', '\350', '\362', 
        '\367', '\211', '\216', '\215', '\355', '\376', '\366', '\211', '\365', '\372', 
        '\215', '\376', '\355', '\376', '\201', '\215', '\216', '\213', '\376', '\272', 
        '\210', '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', '\225', 
        '\201', '\202', '\350', '\224', '\350', '\353', '\210', '\215', '\372', '\215', 
        '\376', '\272', '\376', '\367', '\215', '\376', '\213', '\242', '\265', '\210', 
        '\353', '\210', '\215', '\372', '\215', '\376', '\272', '\210', '\210', '\213', 
        '\375', '\362', '\367', '\372', '\215', '\376', '\350', '\244', '\350', '\353', 
        '\210', '\215', '\372', '\215', '\376', '\272', '\376', '\367', '\215', '\376', 
        '\213', '\350', '\222', '\350', '\217', '\376', '\374', '\251', '\237', '\215', 
        '\366', '\211', '\225', '\201', '\223', '\350', '\215', '\366', '\211', '\225', 
        '\201', '\220', '\221', '\272', '\210', '\214', '\370', '\354', '\362', '\367', 
        '\350', '\222', '\350', '\217', '\376', '\374', '\251', '\237', '\215', '\366', 
        '\211', '\225', '\202', '\223', '\350', '\215', '\366', '\211', '\225', '\202', 
        '\220', '\221', '\367', '\376', '\360', '\354', '\362', '\367', '\370', '\272', 
        '\210', '\214', '\242', '\263', '\376', '\377', '\215', '\271', '\365', '\216', 
        '\214', '\361', '\265', '\210', '\353', '\210', '\215', '\372', '\215', '\376', 
        '\272', '\210', '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', 
        '\350', '\244', '\350', '\237', '\265', '\210', '\353', '\210', '\215', '\372', 
        '\215', '\376', '\272', '\210', '\210', '\213', '\375', '\362', '\367', '\372', 
        '\215', '\376', '\350', '\224', '\350', '\365', '\376', '\377', '\215', '\370', 
        '\373', '\365', '\216', '\214', '\361', '\370', '\213', '\210', '\362', '\220', 
        '\221', '\365', '\376', '\377', '\215', '\370', '\373', '\365', '\216', '\214', 
        '\361', '\370', '\214', '\215', '\213', '\376', '\215', '\374', '\361', '\242', 
        '\353', '\362', '\360', '\361', '\215', '\271', '\365', '\216', '\214', '\361', 
        '\265', '\210', '\353', '\210', '\215', '\372', '\215', '\376', '\272', '\210', 
        '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', '\350', '\244', 
        '\350', '\237', '\265', '\210', '\353', '\210', '\215', '\372', '\215', '\376', 
        '\272', '\210', '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', 
        '\350', '\224', '\350', '\213', '\362', '\360', '\361', '\215', '\370', '\373', 
        '\365', '\216', '\214', '\361', '\370', '\213', '\210', '\362', '\220', '\221', 
        '\213', '\362', '\360', '\361', '\215', '\370', '\373', '\365', '\216', '\214', 
        '\361', '\370', '\214', '\215', '\213', '\376', '\215', '\374', '\361', '\242', 
        '\263', '\376', '\377', '\215', '\271', '\365', '\216', '\214', '\361', '\265', 
        '\210', '\353', '\210', '\215', '\372', '\215', '\376', '\272', '\210', '\210', 
        '\213', '\375', '\362', '\367', '\372', '\215', '\376', '\225', '\202', '\350', 
        '\244', '\350', '\250', '\225', '\227', '\350', '\224', '\350', '\263', '\376', 
        '\377', '\215', '\271', '\365', '\216', '\214', '\361', '\265', '\210', '\353', 
        '\210', '\215', '\372', '\215', '\376', '\272', '\210', '\210', '\213', '\375', 
        '\362', '\367', '\372', '\215', '\376', '\225', '\202', '\242', '\353', '\362', 
        '\360', '\361', '\215', '\271', '\365', '\216', '\214', '\361', '\265', '\210', 
        '\353', '\210', '\215', '\372', '\215', '\376', '\272', '\210', '\210', '\213', 
        '\375', '\362', '\367', '\372', '\215', '\376', '\225', '\202', '\350', '\244', 
        '\350', '\250', '\225', '\227', '\350', '\224', '\350', '\353', '\362', '\360', 
        '\361', '\215', '\271', '\365', '\216', '\214', '\361', '\265', '\210', '\353', 
        '\210', '\215', '\372', '\215', '\376', '\272', '\210', '\210', '\213', '\375', 
        '\362', '\367', '\372', '\215', '\376', '\225', '\202', '\242', '\206'
    };
    private static final char F[] = {
        '\211', '\213', '\376', '\374', '\362', '\214', '\362', '\210', '\367', '\350', 
        '\366', '\376', '\375', '\362', '\216', '\366', '\211', '\350', '\377', '\365', 
        '\210', '\372', '\215', '\242', '\216', '\367', '\362', '\377', '\210', '\213', 
        '\366', '\350', '\214', '\372', '\366', '\211', '\365', '\376', '\213', '\251', 
        '\273', '\350', '\362', '\367', '\211', '\216', '\215', '\260', '\366', '\372', 
        '\360', '\376', '\355', '\376', '\201', '\215', '\216', '\213', '\376', '\242', 
        '\216', '\367', '\362', '\377', '\210', '\213', '\366', '\350', '\214', '\372', 
        '\366', '\211', '\365', '\376', '\213', '\251', '\273', '\350', '\365', '\376', 
        '\377', '\215', '\370', '\373', '\365', '\216', '\214', '\361', '\370', '\215', 
        '\376', '\201', '\215', '\216', '\213', '\376', '\242', '\216', '\367', '\362', 
        '\377', '\210', '\213', '\366', '\350', '\214', '\372', '\366', '\211', '\365', 
        '\376', '\213', '\251', '\273', '\350', '\213', '\362', '\360', '\361', '\215', 
        '\370', '\373', '\365', '\216', '\214', '\361', '\370', '\215', '\376', '\201', 
        '\215', '\216', '\213', '\376', '\242', '\217', '\372', '\213', '\202', '\362', 
        '\367', '\360', '\350', '\217', '\376', '\374', '\251', '\350', '\215', '\376', 
        '\201', '\215', '\216', '\213', '\376', '\272', '\210', '\210', '\213', '\375', 
        '\362', '\367', '\372', '\215', '\376', '\242', '\217', '\372', '\213', '\202', 
        '\362', '\367', '\360', '\350', '\217', '\376', '\374', '\251', '\350', '\265', 
        '\210', '\353', '\210', '\215', '\372', '\215', '\376', '\272', '\210', '\210', 
        '\213', '\375', '\362', '\367', '\372', '\215', '\376', '\242', '\217', '\372', 
        '\213', '\202', '\362', '\367', '\360', '\350', '\217', '\376', '\374', '\251', 
        '\350', '\263', '\376', '\377', '\215', '\271', '\365', '\216', '\214', '\361', 
        '\265', '\210', '\353', '\210', '\215', '\372', '\215', '\376', '\272', '\210', 
        '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', '\242', '\217', 
        '\372', '\213', '\202', '\362', '\367', '\360', '\350', '\217', '\376', '\374', 
        '\251', '\350', '\353', '\362', '\360', '\361', '\215', '\271', '\365', '\216', 
        '\214', '\361', '\265', '\210', '\353', '\210', '\215', '\372', '\215', '\376', 
        '\272', '\210', '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', 
        '\242', '\216', '\367', '\362', '\377', '\210', '\213', '\366', '\350', '\377', 
        '\365', '\210', '\372', '\215', '\350', '\373', '\365', '\216', '\214', '\361', 
        '\370', '\214', '\215', '\213', '\376', '\367', '\360', '\215', '\361', '\242', 
        '\216', '\367', '\362', '\377', '\210', '\213', '\366', '\350', '\217', '\376', 
        '\374', '\252', '\350', '\373', '\365', '\216', '\214', '\361', '\370', '\374', 
        '\210', '\365', '\210', '\213', '\242', '\216', '\367', '\362', '\377', '\210', 
        '\213', '\366', '\350', '\377', '\365', '\210', '\372', '\215', '\350', '\264', 
        '\362', '\375', '\370', '\341', '\370', '\210', '\377', '\370', '\365', '\376', 
        '\377', '\215', '\370', '\213', '\362', '\360', '\361', '\215', '\242', '\217', 
        '\210', '\362', '\375', '\350', '\366', '\372', '\362', '\367', '\237', '\220', 
        '\204', '\377', '\365', '\210', '\372', '\215', '\350', '\372', '\365', '\211', 
        '\361', '\372', '\370', '\365', '\376', '\377', '\215', '\350', '\244', '\350', 
        '\215', '\376', '\201', '\215', '\216', '\213', '\376', '\251', '\273', '\237', 
        '\365', '\376', '\377', '\215', '\370', '\373', '\365', '\216', '\214', '\361', 
        '\370', '\215', '\376', '\201', '\215', '\216', '\213', '\376', '\223', '\350', 
        '\263', '\376', '\377', '\215', '\271', '\365', '\216', '\214', '\361', '\265', 
        '\210', '\353', '\210', '\215', '\372', '\215', '\376', '\272', '\210', '\210', 
        '\213', '\375', '\362', '\367', '\372', '\215', '\376', '\220', '\225', '\372', 
        '\242', '\377', '\365', '\210', '\372', '\215', '\350', '\372', '\365', '\211', 
        '\361', '\372', '\370', '\213', '\362', '\360', '\361', '\215', '\350', '\244', 
        '\350', '\215', '\376', '\201', '\215', '\216', '\213', '\376', '\251', '\273', 
        '\237', '\213', '\362', '\360', '\361', '\215', '\370', '\373', '\365', '\216', 
        '\214', '\361', '\370', '\215', '\376', '\201', '\215', '\216', '\213', '\376', 
        '\223', '\350', '\353', '\362', '\360', '\361', '\215', '\271', '\365', '\216', 
        '\214', '\361', '\265', '\210', '\353', '\210', '\215', '\372', '\215', '\376', 
        '\272', '\210', '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', 
        '\220', '\225', '\372', '\242', '\377', '\365', '\210', '\372', '\215', '\350', 
        '\372', '\365', '\211', '\361', '\372', '\350', '\244', '\350', '\373', '\365', 
        '\216', '\214', '\361', '\370', '\214', '\215', '\213', '\376', '\367', '\360', 
        '\215', '\361', '\350', '\221', '\350', '\366', '\362', '\201', '\237', '\372', 
        '\365', '\211', '\361', '\372', '\370', '\365', '\376', '\377', '\215', '\223', 
        '\350', '\372', '\365', '\211', '\361', '\372', '\370', '\213', '\362', '\360', 
        '\361', '\215', '\223', '\350', '\214', '\215', '\376', '\211', '\237', '\264', 
        '\362', '\375', '\370', '\341', '\370', '\210', '\377', '\370', '\365', '\376', 
        '\377', '\215', '\370', '\213', '\362', '\360', '\361', '\215', '\223', '\350', 
        '\265', '\210', '\353', '\210', '\215', '\372', '\215', '\376', '\272', '\210', 
        '\210', '\213', '\375', '\362', '\367', '\372', '\215', '\376', '\225', '\201', 
        '\220', '\220', '\242', '\217', '\376', '\374', '\252', '\350', '\374', '\210', 
        '\365', '\210', '\213', '\350', '\244', '\350', '\366', '\362', '\201', '\237', 
        '\215', '\376', '\201', '\215', '\216', '\213', '\376', '\251', '\273', '\237', 
        '\362', '\367', '\211', '\216', '\215', '\260', '\366', '\372', '\360', '\376', 
        '\355', '\376', '\201', '\215', '\216', '\213', '\376', '\223', '\350', '\215', 
        '\376', '\201', '\215', '\216', '\213', '\376', '\272', '\210', '\210', '\213', 
        '\375', '\362', '\367', '\372', '\215', '\376', '\220', '\225', '\213', '\360', 
        '\373', '\223', '\350', '\373', '\365', '\216', '\214', '\361', '\370', '\374', 
        '\210', '\365', '\210', '\213', '\223', '\350', '\372', '\365', '\211', '\361', 
        '\372', '\220', '\242', '\360', '\365', '\370', '\275', '\213', '\372', '\360', 
        '\272', '\210', '\365', '\210', '\213', '\350', '\244', '\350', '\217', '\376', 
        '\374', '\253', '\237', '\374', '\210', '\365', '\210', '\213', '\223', '\350', 
        '\250', '\225', '\227', '\220', '\242', '\206'
    };
    private int A;
    private boolean B;
    private int C;
    protected int a;
    private Object b;
    private boolean c;
    private Object d;
    private FloatBuffer e;
    private float f;
    private float g[] = {
        0.0F, 0.0F, 0.0F
    };
    private float h[] = {
        0.0F, 0.0F, 0.0F
    };
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private Bitmap o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Bitmap t;
    private int u;
    private int v;
    private int w;
    private int x;
    private float y;
    private float z;

    public CLMakeupLiveBlushFilter()
    {
        super(com.cyberlink.clgpuimage.b.a(E), com.cyberlink.clgpuimage.b.a(F));
        b = new Object();
        c = false;
        d = new Object();
        f = 1.0F;
        o = null;
        p = -1;
        t = null;
        u = -1;
        C = 90;
        e = ByteBuffer.allocateDirect(D.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static PointF a(float f1, float f2, PointF pointf, PointF pointf1)
    {
        PointF pointf2 = new PointF();
        pointf2.x = pointf.x + (pointf1.x - pointf.x) * f1 + (pointf1.y - pointf.y) * -f2;
        pointf2.y = pointf.y + (pointf1.x - pointf.x) * f2 + (pointf1.y - pointf.y) * f1;
        return pointf2;
    }

    public static PointF a(PointF pointf)
    {
        return new PointF(pointf.x, 1.0F - pointf.y);
    }

    private void f()
    {
        synchronized (b)
        {
            if (c)
            {
                if (p != -1)
                {
                    GLES20.glDeleteTextures(1, new int[] {
                        p
                    }, 0);
                    p = -1;
                }
                if (o != null && !o.isRecycled())
                {
                    p = af.a(o, -1, false);
                }
                if (u != -1)
                {
                    GLES20.glDeleteTextures(1, new int[] {
                        u
                    }, 0);
                    u = -1;
                }
                if (t != null && !t.isRecycled())
                {
                    u = af.a(t, -1, false);
                }
                c = false;
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
        a = GLES20.glGetAttribLocation(l(), "inputTemplateTextureCoordinate");
        i = GLES20.glGetUniformLocation(l(), "blush_strength");
        j = GLES20.glGetUniformLocation(l(), "blush_color");
        k = GLES20.glGetUniformLocation(l(), "Mid_X_of_left_right");
        l = GLES20.glGetUniformLocation(l(), "RotateCenter");
        m = GLES20.glGetUniformLocation(l(), "Cos_Sin");
        n = GLES20.glGetUniformLocation(l(), "negSin_Cos");
        q = GLES20.glGetUniformLocation(l(), "left_blush_texture");
        r = GLES20.glGetUniformLocation(l(), "left_blush_roi");
        s = GLES20.glGetUniformLocation(l(), "left_blush_stretch");
        v = GLES20.glGetUniformLocation(l(), "right_blush_texture");
        w = GLES20.glGetUniformLocation(l(), "right_blush_roi");
        x = GLES20.glGetUniformLocation(l(), "right_blush_stretch");
    }

    public void a(float f1)
    {
        if (f1 >= 0.0F && f1 <= 100F)
        {
            f = 0.01F * f1;
        }
    }

    public void a(int i1)
    {
        g[0] = (float)Color.red(i1) / 255F;
        g[1] = (float)Color.green(i1) / 255F;
        g[2] = (float)Color.blue(i1) / 255F;
    }

    public void a(LiveBlushMakeupdata liveblushmakeupdata)
    {
        synchronized (d)
        {
            a(n, new PointF(-liveblushmakeupdata.m_sin_val, liveblushmakeupdata.m_cos_val));
            a(m, new PointF(liveblushmakeupdata.m_cos_val, liveblushmakeupdata.m_sin_val));
            a(l, liveblushmakeupdata.m_center);
            a(k, liveblushmakeupdata.m_center.x);
            a(s, new PointF(b(liveblushmakeupdata.m_left_blush_roi.a()), b(liveblushmakeupdata.m_left_blush_roi.b())));
            a(r, new PointF(liveblushmakeupdata.m_left_blush_roi.a, liveblushmakeupdata.m_left_blush_roi.b));
            a(x, new PointF(b(liveblushmakeupdata.m_right_blush_roi.a()), b(liveblushmakeupdata.m_right_blush_roi.b())));
            a(w, new PointF(liveblushmakeupdata.m_right_blush_roi.a, liveblushmakeupdata.m_right_blush_roi.b));
            z = liveblushmakeupdata.m_environment_darkest_reference_normalized_luma;
            y = liveblushmakeupdata.m_environment_brightest_reference_normalized_luma;
            A = liveblushmakeupdata.m_rotation;
            B = liveblushmakeupdata.m_is_flipped;
        }
        return;
        liveblushmakeupdata;
        obj;
        JVM INSTR monitorexit ;
        throw liveblushmakeupdata;
    }

    public boolean a(Bitmap abitmap[])
    {
        synchronized (b)
        {
            o = Bitmap.createBitmap(abitmap[0]);
            t = Bitmap.createBitmap(abitmap[1]);
            c = true;
        }
        return true;
        abitmap;
        obj;
        JVM INSTR monitorexit ;
        throw abitmap;
    }

    protected float[] a(float af1[], int i1)
    {
        if (i1 == (C + 270) % 360)
        {
            return (new float[] {
                af1[4], af1[5], af1[0], af1[1], af1[6], af1[7], af1[2], af1[3]
            });
        }
        if (i1 == (C + 180) % 360)
        {
            return (new float[] {
                af1[6], af1[7], af1[4], af1[5], af1[2], af1[3], af1[0], af1[1]
            });
        }
        if (i1 == (C + 90) % 360)
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

    public float b(float f1)
    {
        return 1.0F / f1;
    }

    public void b(int i1)
    {
        C = i1;
    }

    public void c()
    {
        super.c();
        if (p != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                p
            }, 0);
            p = -1;
        }
        if (u != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                u
            }, 0);
            u = -1;
        }
    }

    protected void d_()
    {
        super.d_();
        f();
    }

    protected void e()
    {
        e.clear();
        e.put(a(D, A));
        e.position(0);
        GLES20.glVertexAttribPointer(a, 2, 5126, false, 0, e);
        GLES20.glEnableVertexAttribArray(a);
        a(i, f);
        synchronized (d)
        {
            float f1 = z;
            float f2 = y;
            h[0] = (f2 - f1) * g[0] + f1;
            h[1] = (f2 - f1) * g[1] + f1;
            h[2] = f1 + (f2 - f1) * g[2];
        }
        GLES20.glUniform3fv(j, 1, FloatBuffer.wrap(h));
        if (p != -1)
        {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, p);
            GLES20.glUniform1i(q, 3);
        }
        if (u != -1)
        {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, u);
            GLES20.glUniform1i(v, 4);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }


    private class LiveBlushMakeupdata
    {

        public PointF m_center;
        public float m_cos_val;
        public float m_environment_brightest_reference_normalized_luma;
        public float m_environment_darkest_reference_normalized_luma;
        public boolean m_is_flipped;
        public a m_left_blush_roi;
        public a m_right_blush_roi;
        public int m_rotation;
        public float m_sin_val;

        public void ComputeData(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3, PointF pointf4, PointF pointf5, PointF pointf6, 
                PointF pointf7, PointF pointf8, PointF pointf9)
        {
            double d1 = Math.atan2(pointf9.y - pointf4.y, pointf9.x - pointf4.x);
            m_cos_val = (float)Math.cos(-d1);
            m_sin_val = (float)Math.sin(-d1);
            m_center.x = (pointf1.x + pointf6.x) * 0.5F;
            m_center.y = (pointf1.y + pointf6.y) * 0.5F;
            m_left_blush_roi.c();
            m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf));
            m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf1));
            m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf2));
            m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf3));
            m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf4));
            m_right_blush_roi.c();
            m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf5));
            m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf6));
            m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf7));
            m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf8));
            m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(m_cos_val, m_sin_val, m_center, pointf9));
        }

        public void Copy(LiveBlushMakeupdata liveblushmakeupdata)
        {
            m_cos_val = liveblushmakeupdata.m_cos_val;
            m_sin_val = liveblushmakeupdata.m_sin_val;
            m_center.x = liveblushmakeupdata.m_center.x;
            m_center.y = liveblushmakeupdata.m_center.y;
            m_left_blush_roi.a = liveblushmakeupdata.m_left_blush_roi.a;
            m_left_blush_roi.c = liveblushmakeupdata.m_left_blush_roi.c;
            m_left_blush_roi.b = liveblushmakeupdata.m_left_blush_roi.b;
            m_left_blush_roi.d = liveblushmakeupdata.m_left_blush_roi.d;
            m_right_blush_roi.a = liveblushmakeupdata.m_right_blush_roi.a;
            m_right_blush_roi.c = liveblushmakeupdata.m_right_blush_roi.c;
            m_right_blush_roi.b = liveblushmakeupdata.m_right_blush_roi.b;
            m_right_blush_roi.d = liveblushmakeupdata.m_right_blush_roi.d;
            m_environment_darkest_reference_normalized_luma = liveblushmakeupdata.m_environment_darkest_reference_normalized_luma;
            m_environment_brightest_reference_normalized_luma = liveblushmakeupdata.m_environment_brightest_reference_normalized_luma;
            m_rotation = liveblushmakeupdata.m_rotation;
            m_is_flipped = liveblushmakeupdata.m_is_flipped;
        }

        public void SetBlushFeaturePts(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3, PointF pointf4, PointF pointf5, PointF pointf6, 
                PointF pointf7, PointF pointf8, PointF pointf9)
        {
            ComputeData(CLMakeupLiveBlushFilter.a(pointf), CLMakeupLiveBlushFilter.a(pointf1), CLMakeupLiveBlushFilter.a(pointf2), CLMakeupLiveBlushFilter.a(pointf3), CLMakeupLiveBlushFilter.a(pointf4), CLMakeupLiveBlushFilter.a(pointf5), CLMakeupLiveBlushFilter.a(pointf6), CLMakeupLiveBlushFilter.a(pointf7), CLMakeupLiveBlushFilter.a(pointf8), CLMakeupLiveBlushFilter.a(pointf9));
        }

        public LiveBlushMakeupdata()
        {
            m_center = new PointF();
            m_left_blush_roi = new a();
            m_right_blush_roi = new a();
        }
    }

}
