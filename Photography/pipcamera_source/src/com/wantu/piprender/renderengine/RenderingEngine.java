// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender.renderengine;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import vs;
import vu;
import vw;
import vx;
import vz;
import wb;
import wc;
import wi;
import wj;
import wk;
import wl;

public class RenderingEngine extends vw
{

    private final float A[];
    private final float B[];
    private float C[];
    private int D;
    vx c;
    final float d[];
    wi e;
    wi f;
    wi g;
    wi h;
    wi i;
    int j;
    int k;
    wc l;
    wj m;
    wk n;
    wb o;
    FloatBuffer p;
    FloatBuffer q;
    FloatBuffer r;
    FloatBuffer s;
    private volatile float t;
    private volatile float u;
    private volatile boolean v;
    private IntBuffer w;
    private IntBuffer x;
    private Handler y;
    private float z[];

    protected int a(String s1, String s2, wi wi1)
    {
        int i1 = super.a(s1, s2, wi1);
        s1 = wi1.a;
        s1.f = GLES20.glGetUniformLocation(i1, "matrixlength");
        s1.g = GLES20.glGetUniformLocation(i1, "cmatrix");
        s1.h = GLES20.glGetUniformLocation(i1, "alphaMask");
        s1.i = GLES20.glGetUniformLocation(i1, "curveTex");
        s1.j = GLES20.glGetUniformLocation(i1, "texture");
        s1.k = GLES20.glGetUniformLocation(i1, "blendAlpha");
        s1.l = GLES20.glGetUniformLocation(i1, "blendMode");
        s1.m = GLES20.glGetUniformLocation(i1, "blurSize");
        return i1;
    }

    public Bitmap a(int i1, int j1, int k1, int l1)
    {
        int ai[] = new int[(j1 + l1) * k1];
        int ai1[] = new int[k1 * l1];
        IntBuffer intbuffer = IntBuffer.wrap(ai);
        intbuffer.position(0);
        GLES20.glReadPixels(i1, 0, k1, j1 + l1, 6408, 5121, intbuffer);
        i1 = 0;
        for (j1 = 0; j1 < l1;)
        {
            for (int i2 = 0; i2 < k1; i2++)
            {
                int j2 = ai[j1 * k1 + i2];
                ai1[(l1 - i1 - 1) * k1 + i2] = j2 & 0xff00ff00 | j2 << 16 & 0xff0000 | j2 >> 16 & 0xff;
            }

            j1++;
            i1++;
        }

        return Bitmap.createBitmap(ai1, k1, l1, android.graphics.Bitmap.Config.ARGB_8888);
    }

    public void a()
    {
        if (e.b != 0)
        {
            GLES20.glDeleteProgram(e.b);
        }
        if (f.b != 0)
        {
            GLES20.glDeleteProgram(f.b);
        }
        if (g.b != 0)
        {
            GLES20.glDeleteProgram(g.b);
        }
        if (h.b != 0)
        {
            GLES20.glDeleteProgram(h.b);
        }
        if (i.b != 0)
        {
            GLES20.glDeleteProgram(i.b);
        }
        l.a();
        n.a();
    }

    public void a(float f1, float f2)
    {
        t = f1;
        u = f2;
    }

    public void a(int i1, int j1)
    {
        c.a = i1;
        c.b = j1;
        if (Math.max(i1, j1) < 612)
        {
            a(w, null, x, 612, 612);
        }
        GLES20.glViewport(0, 0, i1, j1);
        j = GLES20.glGetAttribLocation(e.b, "Position");
        k = GLES20.glGetAttribLocation(e.b, "inputTextureCoordinate");
    }

    public void a(int i1, int j1, int k1)
    {
        float af[] = new float[8];
        af[0] = 0.0F;
        af[1] = 0.0F;
        af[2] = 0.0F;
        af[3] = (float)k1 / (float)i1;
        af[4] = (float)j1 / (float)i1;
        af[5] = 0.0F;
        af[6] = (float)j1 / (float)i1;
        af[7] = (float)k1 / (float)i1;
        r = ByteBuffer.allocateDirect(af.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r.put(af).position(0);
    }

    public void a(vz vz1)
    {
        if (n.e != null)
        {
            n.e.position(0);
            GLES20.glDeleteTextures(1, n.e);
            a("glDeleteTextures");
            n.e = null;
        }
        if (vz1.i != EResType.NETWORK) goto _L2; else goto _L1
_L1:
        if (vz1.g != null)
        {
            int i1 = vz1.g.lastIndexOf("/");
            String s1 = vz1.g.substring(i1 + 1);
            Log.v("alphaTexture fileName", s1);
            i1 = vu.a(FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.PIP_SCENE, s1), true);
            n.e = IntBuffer.wrap(new int[] {
                i1
            });
        }
_L4:
        p = ByteBuffer.allocateDirect(vz1.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.put(vz1.e).position(0);
        a(vz1.f);
        Matrix.setIdentityM(z, 0);
        return;
_L2:
        if (vz1.g != null)
        {
            int j1 = vu.a(b, vz1.g, true);
            n.e = IntBuffer.wrap(new int[] {
                j1
            });
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(wb wb1)
    {
        int i1 = n.c.get(0);
        if (i1 != 0)
        {
            GLES20.glDeleteTextures(1, IntBuffer.wrap(new int[] {
                i1
            }));
        }
        if (l.c.get(0) != 0)
        {
            GLES20.glDeleteFramebuffers(1, IntBuffer.wrap(new int[] {
                l.c.get(0)
            }));
        }
        a(l.c, m.c, n.c, (int)wb1.e, (int)wb1.f);
        o = wb1;
    }

    public void b()
    {
        for (int i1 = 0; i1 < 2; i1++)
        {
            a(l.b[i1], m.b[i1], n.b[i1], 180, 180);
        }

        a(vs.a(b, 0x7f050056), vs.a(b, 0x7f050055), e);
        a(vs.a(b, 0x7f050014), vs.a(b, 0x7f050043), g);
        a(vs.a(b, 0x7f050014), vs.a(b, 0x7f050042), f);
        a(vs.a(b, 0x7f050014), vs.a(b, 0x7f050002), h);
        a(vs.a(b, 0x7f050014), vs.a(b, 0x7f05000b), i);
        ByteBuffer.allocateDirect(d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(d).position(0);
        GLES20.glUseProgram(f.b);
        GLES20.glUniform1f(f.a.d, 180F);
        GLES20.glUniform1f(f.a.e, 180F);
        GLES20.glUniform1f(f.a.m, 1.0F);
        GLES20.glUseProgram(g.b);
        GLES20.glUniform1f(g.a.d, 180F);
        GLES20.glUniform1f(g.a.e, 180F);
        GLES20.glUniform1f(g.a.m, 1.0F);
        GLES20.glUseProgram(e.b);
        a("glUseProgram");
        a(1.0F, 1.0F, e.b);
        D = GLES20.glGetUniformLocation(e.b, "Modelview");
        Matrix.setIdentityM(z, 0);
        Matrix.setIdentityM(A, 0);
    }

    public void b(int i1)
    {
        GLES20.glBindFramebuffer(36160, l.b[0].get(0));
        GLES20.glClearColor(0.5F, 0.5F, 0.5F, 1.0F);
        GLES20.glClear(16384);
        GLES20.glViewport(0, 0, 180, 180);
        GLES20.glUseProgram(e.b);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i1);
        a("glBindTexture");
        a(e.b);
        int j1 = GLES20.glGetUniformLocation(e.b, "videoFrame");
        int k1 = GLES20.glGetUniformLocation(f.b, "videoFrame");
        int l1 = GLES20.glGetUniformLocation(g.b, "videoFrame");
        a("glGetUniformLocation");
        GLES20.glUniform1i(j1, 0);
        a("glUniform1i");
        GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_VERTEX.ordinal(), 2, 5126, false, 0, p);
        a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_VERTEX.ordinal());
        a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, r);
        a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        a("glEnableVertexAttribArray");
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glBindFramebuffer(36160, l.b[1].get(0));
        GLES20.glViewport(0, 0, 180, 180);
        GLES20.glUseProgram(f.b);
        GLES20.glBindTexture(3553, n.b[0].get(0));
        GLES20.glUniform1i(k1, 0);
        GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, q);
        GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_VERTEX.ordinal());
        GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, s);
        GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, l.b[0].get(0));
        GLES20.glViewport(0, 0, 180, 180);
        GLES20.glUseProgram(g.b);
        GLES20.glBindTexture(3553, n.b[1].get(0));
        GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, q);
        GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_VERTEX.ordinal());
        GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, s);
        GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        GLES20.glUniform1i(l1, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, l.c.get(0));
        GLES20.glClearColor(0.5F, 0.5F, 0.5F, 1.0F);
        GLES20.glClear(16384);
        GLES20.glViewport(0, 0, (int)o.e, (int)o.f);
        GLES20.glUseProgram(e.b);
        GLES20.glBindTexture(3553, i1);
        float af[] = o.a;
        Matrix.setIdentityM(B, 0);
        Matrix.setIdentityM(C, 0);
        Matrix.translateM(z, 0, t, u, 0.0F);
        t = 0.0F;
        u = 0.0F;
        GLES20.glUniformMatrix4fv(D, 1, false, z, 0);
        FloatBuffer floatbuffer1 = ByteBuffer.allocateDirect(af.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatbuffer1.put(af).position(0);
        GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_VERTEX.ordinal());
        GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_VERTEX.ordinal(), 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, r);
        GLES20.glDrawArrays(5, 0, 4);
        if (v)
        {
            GLES20.glBindFramebuffer(36160, w.get(0));
            GLES20.glViewport(0, 0, 612, 612);
            GLES20.glUseProgram(e.b);
            GLES20.glBindTexture(3553, n.b[0].get(0));
            a(e.b);
            GLES20.glUniform1i(j1, 0);
            GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_VERTEX.ordinal());
            GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, q);
            GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
            GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, s);
            GLES20.glDrawArrays(5, 0, 4);
            a("glDrawArrays");
            Object obj = ByteBuffer.allocateDirect(o.c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            ((FloatBuffer) (obj)).put(o.c).position(0);
            if (n.e != null && n.e.get(0) > 0)
            {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, n.c.get(0));
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, n.e.get(0));
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(770, 771);
                GLES20.glUseProgram(h.b);
                GLES20.glUniform1i(h.a.c, 0);
                GLES20.glUniform1i(h.a.h, 1);
                GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_VERTEX.ordinal());
                GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_VERTEX.ordinal(), 2, 5126, false, 0, ((java.nio.Buffer) (obj)));
                GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
                GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, s);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisable(3042);
            } else
            {
                GLES20.glBindTexture(3553, n.c.get(0));
                a(e.b);
                GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_VERTEX.ordinal());
                GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_VERTEX.ordinal(), 2, 5126, false, 0, ((java.nio.Buffer) (obj)));
                GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
                GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, s);
                GLES20.glDrawArrays(5, 0, 4);
            }
            GLES20.glFlush();
            obj = a(0, 0, 612, 612);
            if (obj == null);
            obj = Message.obtain(y, 0, obj);
            y.sendMessage(((Message) (obj)));
            v = false;
            GLES20.glViewport(0, 0, c.a, c.b);
        } else
        {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(0, 0, c.a, c.b);
            GLES20.glUseProgram(e.b);
            GLES20.glBindTexture(3553, n.b[0].get(0));
            a(e.b);
            GLES20.glUniform1i(j1, 0);
            GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_VERTEX.ordinal());
            GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, q);
            GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
            GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, s);
            GLES20.glDrawArrays(5, 0, 4);
            a("glDrawArrays");
            FloatBuffer floatbuffer = ByteBuffer.allocateDirect(o.c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            floatbuffer.put(o.c).position(0);
            if (n.e != null && n.e.get(0) > 0)
            {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, n.c.get(0));
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, n.e.get(0));
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(770, 771);
                GLES20.glUseProgram(h.b);
                GLES20.glUniform1i(h.a.c, 0);
                GLES20.glUniform1i(h.a.h, 1);
                GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_VERTEX.ordinal());
                GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_VERTEX.ordinal(), 2, 5126, false, 0, floatbuffer);
                GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
                GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, s);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisable(3042);
            } else
            {
                GLES20.glBindTexture(3553, n.c.get(0));
                a(e.b);
                GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_VERTEX.ordinal());
                GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_VERTEX.ordinal(), 2, 5126, false, 0, floatbuffer);
                GLES20.glEnableVertexAttribArray(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
                GLES20.glVertexAttribPointer(Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, s);
                GLES20.glDrawArrays(5, 0, 4);
            }
        }
        GLES20.glBindTexture(3553, 0);
    }

    private class Attribute extends Enum
    {

        private static final Attribute $VALUES[];
        public static final Attribute RE_ATTRIB_TEXTUREPOSITON;
        public static final Attribute RE_ATTRIB_VERTEX;
        public static final Attribute RE_NUM_ATTRIBUTES;

        public static Attribute valueOf(String s1)
        {
            return (Attribute)Enum.valueOf(com/wantu/piprender/renderengine/RenderingEngine$Attribute, s1);
        }

        public static Attribute[] values()
        {
            return (Attribute[])$VALUES.clone();
        }

        static 
        {
            RE_ATTRIB_VERTEX = new Attribute("RE_ATTRIB_VERTEX", 0);
            RE_ATTRIB_TEXTUREPOSITON = new Attribute("RE_ATTRIB_TEXTUREPOSITON", 1);
            RE_NUM_ATTRIBUTES = new Attribute("RE_NUM_ATTRIBUTES", 2);
            $VALUES = (new Attribute[] {
                RE_ATTRIB_VERTEX, RE_ATTRIB_TEXTUREPOSITON, RE_NUM_ATTRIBUTES
            });
        }

        private Attribute(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
