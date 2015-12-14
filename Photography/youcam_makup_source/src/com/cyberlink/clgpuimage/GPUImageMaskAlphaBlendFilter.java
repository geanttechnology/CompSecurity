// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

// Referenced classes of package com.cyberlink.clgpuimage:
//            y, af, w

public class GPUImageMaskAlphaBlendFilter extends y
{

    private int a[];
    private int b[];
    private int c;
    private final FloatBuffer d;
    private float e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    private float m;
    private float n;
    private MaskOperation o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private final w t;

    private void a(int j, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        if (f == 0)
        {
            f = af.a("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\nvarying vec2 referenceCoordinate;\nuniform highp vec2 uv_reference;\n\nvoid main()\n{\n\tgl_Position = position;\n\ttextureCoordinate = inputTextureCoordinate.xy;\n\treferenceCoordinate = uv_reference;\n}", "varying highp vec2 textureCoordinate;\nvarying highp vec2 referenceCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform highp float radius;\nuniform highp float threshold;const highp vec3 luminanceWeighting = vec3(0.2126, 0.7152, 0.0722);\n \nvoid main()\n{\n\t  highp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n\t  highp vec4 crReference = texture2D(inputImageTexture, referenceCoordinate);\n\t  highp float distance = length(referenceCoordinate-textureCoordinate);\n\t  if (distance >= radius)\n\t\t\tdiscard;\n\t  highp float varianceThreshold = mix(threshold, 0.0, distance);\n\t  highp float variance = abs(dot(color.rgb, luminanceWeighting) - dot(crReference.rgb, luminanceWeighting));\n\t  if (variance >= varianceThreshold)\n\t  \t\tdiscard;\n\t  gl_FragColor = vec4(0.0);\n}");
        }
        if (g == 0)
        {
            g = af.a("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\nvarying vec2 referenceCoordinate;\nuniform highp vec2 uv_reference;\n\nvoid main()\n{\n\tgl_Position = position;\n\ttextureCoordinate = inputTextureCoordinate.xy;\n\treferenceCoordinate = uv_reference;\n}", "varying highp vec2 textureCoordinate;\nvarying highp vec2 referenceCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform highp float radius;\nuniform highp float threshold;const highp vec3 luminanceWeighting = vec3(0.2126, 0.7152, 0.0722);\n \nvoid main()\n{\n\t  highp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n\t  highp vec4 crReference = texture2D(inputImageTexture, referenceCoordinate);\n\t  highp float distance = length(referenceCoordinate-textureCoordinate);\n\t  if (distance >= radius)\n\t\t\tdiscard;\n\t  highp float varianceThreshold = mix(threshold, 0.0, distance);\n\t  highp float variance = abs(dot(color.rgb, luminanceWeighting) - dot(crReference.rgb, luminanceWeighting));\n\t  if (variance >= varianceThreshold)\n\t  \t\tdiscard;\n\t  gl_FragColor = vec4(1.0);\n}");
        }
        float f1;
        int ai[];
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        if (p)
        {
            k = f;
        } else
        {
            k = g;
        }
        l = GLES20.glGetAttribLocation(k, "position");
        i1 = GLES20.glGetAttribLocation(k, "inputTextureCoordinate");
        j1 = GLES20.glGetUniformLocation(k, "inputImageTexture");
        k1 = GLES20.glGetUniformLocation(k, "uv_reference");
        l1 = GLES20.glGetUniformLocation(k, "radius");
        i2 = GLES20.glGetUniformLocation(k, "threshold");
        ai = new int[1];
        GLES20.glGetIntegerv(36006, ai, 0);
        GLES20.glBindFramebuffer(36160, a[0]);
        GLES20.glViewport(0, 0, n(), o());
        GLES20.glUseProgram(k);
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(l, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(l);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(i1, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(i1);
        if (j != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, j);
            GLES20.glUniform1i(j1, 0);
        }
        GLES20.glUniform2f(k1, m, n);
        GLES20.glUniform1f(l1, e);
        if (q)
        {
            f1 = 0.1F;
        } else
        {
            f1 = 1.0F;
        }
        GLES20.glUniform1f(i2, f1);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(l);
        GLES20.glDisableVertexAttribArray(i1);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, ai[0]);
        GLES20.glUseProgram(l());
    }

    private void a(FloatBuffer floatbuffer)
    {
        if (h == 0)
        {
            h = af.a("attribute vec4 position;\nvoid main()\n{\n    gl_Position = position;\n}", "void main()\n{\n     gl_FragColor = vec4(1.0);\n}");
        }
        int ai[] = new int[1];
        GLES20.glGetIntegerv(36006, ai, 0);
        GLES20.glBindFramebuffer(36160, a[0]);
        int j = GLES20.glGetAttribLocation(h, "position");
        GLES20.glViewport(0, 0, n(), o());
        GLES20.glUseProgram(h);
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(j, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(j);
        boolean flag = GLES20.glIsEnabled(3042);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(775, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBlendFunc(770, 771);
        if (!flag)
        {
            GLES20.glDisable(3042);
        }
        GLES20.glDisableVertexAttribArray(j);
        GLES20.glBindFramebuffer(36160, ai[0]);
        GLES20.glUseProgram(l());
    }

    private void c(int j, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glViewport(0, 0, j(), k());
        t.a(l, floatbuffer, floatbuffer1);
        t.c(j, floatbuffer, floatbuffer1);
        GLES20.glUseProgram(l());
    }

    static int f()
    {
        return p();
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

    private int n()
    {
        int j = az;
        byte byte0;
        if (r)
        {
            byte0 = 24;
        } else
        {
            byte0 = 2;
        }
        return j / byte0;
    }

    private int o()
    {
        int j = aA;
        byte byte0;
        if (r)
        {
            byte0 = 24;
        } else
        {
            byte0 = 2;
        }
        return j / byte0;
    }

    private static int p()
    {
        int ai[] = new int[1];
        ai[0] = -1;
        GLES20.glGenTextures(1, ai, 0);
        GLES20.glBindTexture(3553, ai[0]);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        return ai[0];
    }

    public void a()
    {
        super.a();
        s = GLES20.glGetUniformLocation(l(), "inputMaskTexture");
        if (o == MaskOperation.f)
        {
            t.g();
        }
    }

    public void a(int j, int k)
    {
        int l = az;
        int i1 = aA;
        super.a(j, k);
        if (o == MaskOperation.f)
        {
            m();
            t.a(j, k);
        } else
        if (l != j || i1 != k || a == null || b == null)
        {
            m();
            a = new int[c];
            b = new int[c];
            int ai[] = new int[1];
            GLES20.glGetIntegerv(36006, ai, 0);
            for (j = 0; j < c; j++)
            {
                GLES20.glGenFramebuffers(1, a, j);
                GLES20.glGenTextures(1, b, j);
                GLES20.glBindTexture(3553, b[j]);
                GLES20.glTexImage2D(3553, 0, 6408, n(), o(), 0, 6408, 5121, null);
                GLES20.glTexParameterf(3553, 10240, 9729F);
                GLES20.glTexParameterf(3553, 10241, 9729F);
                GLES20.glTexParameterf(3553, 10242, 33071F);
                GLES20.glTexParameterf(3553, 10243, 33071F);
                GLES20.glBindFramebuffer(36160, a[j]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, b[j], 0);
                GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
                GLES20.glClear(16384);
                GLES20.glBindTexture(3553, 0);
            }

            GLES20.glBindFramebuffer(36160, ai[0]);
            return;
        }
    }

    public void a(boolean flag, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        int ai[] = new int[1];
        GLES20.glGetIntegerv(36006, ai, 0);
        if (i == 0)
        {
            i = af.a("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        }
        GLES20.glUseProgram(i);
        int j = GLES20.glGetAttribLocation(i, "position");
        int k = GLES20.glGetAttribLocation(i, "inputTextureCoordinate");
        int l = GLES20.glGetUniformLocation(i, "inputImageTexture");
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(j, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(j);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(k, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(k);
        GLES20.glViewport(0, 0, n(), o());
        if (flag)
        {
            GLES20.glBindFramebuffer(36160, a[1]);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, b[0]);
            GLES20.glUniform1i(l, 0);
        } else
        {
            GLES20.glBindFramebuffer(36160, a[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, b[1]);
            GLES20.glUniform1i(l, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(j);
        GLES20.glDisableVertexAttribArray(k);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, ai[0]);
        GLES20.glUseProgram(l());
    }

    public void b(int j, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glUseProgram(l());
        d_();
        w.a(t);
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[MaskOperation.values().length];
                try
                {
                    a[MaskOperation.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[MaskOperation.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[MaskOperation.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[MaskOperation.e.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[MaskOperation.f.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[o.ordinal()];
        JVM INSTR tableswitch 1 5: default 64
    //                   1 135
    //                   2 150
    //                   3 170
    //                   4 74
    //                   5 190;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L4:
        break MISSING_BLOCK_LABEL_170;
_L6:
        break MISSING_BLOCK_LABEL_190;
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        a(j, floatbuffer, d);
_L7:
        GLES20.glViewport(0, 0, j(), k());
        GLES20.glActiveTexture(33985);
        int k;
        if (o == MaskOperation.e)
        {
            k = b[1];
        } else
        {
            k = b[0];
        }
        GLES20.glBindTexture(3553, k);
        GLES20.glUniform1i(s, 1);
        super.b(j, floatbuffer, floatbuffer1);
        return;
_L2:
        a(floatbuffer);
        o = MaskOperation.a;
          goto _L7
_L3:
        a(false, floatbuffer, d);
        o = MaskOperation.a;
          goto _L7
        a(true, floatbuffer, d);
        o = MaskOperation.a;
          goto _L7
        c(j, floatbuffer, floatbuffer1);
        return;
    }

    public void c()
    {
        if (o == MaskOperation.f)
        {
            t.h();
        }
        if (f != 0)
        {
            GLES20.glDeleteProgram(f);
            f = 0;
        }
        if (g != 0)
        {
            GLES20.glDeleteProgram(g);
            g = 0;
        }
        if (h != 0)
        {
            GLES20.glDeleteProgram(h);
            h = 0;
        }
        if (i != 0)
        {
            GLES20.glDeleteProgram(i);
            i = 0;
        }
        m();
        super.c();
    }

    private class MaskOperation extends Enum
    {

        public static final MaskOperation a;
        public static final MaskOperation b;
        public static final MaskOperation c;
        public static final MaskOperation d;
        public static final MaskOperation e;
        public static final MaskOperation f;
        private static final MaskOperation g[];

        public static MaskOperation valueOf(String s1)
        {
            return (MaskOperation)Enum.valueOf(com/cyberlink/clgpuimage/GPUImageMaskAlphaBlendFilter$MaskOperation, s1);
        }

        public static MaskOperation[] values()
        {
            return (MaskOperation[])g.clone();
        }

        static 
        {
            a = new MaskOperation("Normal", 0);
            b = new MaskOperation("Invert", 1);
            c = new MaskOperation("Undo", 2);
            d = new MaskOperation("Apply", 3);
            e = new MaskOperation("HideLast", 4);
            f = new MaskOperation("ExternalMask", 5);
            g = (new MaskOperation[] {
                a, b, c, d, e, f
            });
        }

        private MaskOperation(String s1, int j)
        {
            super(s1, j);
        }
    }

}
