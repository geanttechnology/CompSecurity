// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class aga extends aeo
{

    private int A[] = {
        -1
    };
    boolean p;
    protected int q;
    protected int r;
    private Bitmap s;
    private int t;
    private Bitmap u;
    private int v;
    private int w;
    private agu x;
    private float y;
    private int z[] = {
        -1
    };

    public aga()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        s = null;
        t = -1;
        u = null;
        v = -1;
        w = 0;
        p = false;
        y = 0.7F;
        q = 0;
        r = 0;
    }

    public aga(Bitmap bitmap, Bitmap bitmap1)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        s = null;
        t = -1;
        u = null;
        v = -1;
        w = 0;
        p = false;
        y = 0.7F;
        q = 0;
        r = 0;
        s = bitmap;
        u = bitmap1;
        if (u != null)
        {
            w = u.getHeight();
        }
    }

    static int a(aga aga1)
    {
        return aga1.t;
    }

    static int a(aga aga1, int i)
    {
        aga1.t = i;
        return i;
    }

    static void a(int i, int i1, int ai[], int ai1[])
    {
        if (ai1[0] != -1)
        {
            GLES20.glDeleteTextures(1, ai1, 0);
            ai1[0] = -1;
        }
        if (ai[0] != -1)
        {
            GLES20.glDeleteFramebuffers(1, ai, 0);
            ai[0] = -1;
        }
        GLES20.glGenFramebuffers(1, ai, 0);
        GLES20.glBindFramebuffer(36160, ai[0]);
        GLES20.glGenTextures(1, ai1, 0);
        GLES20.glBindTexture(3553, ai1[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i1, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, ai1[0], 0);
        GLES20.glCheckFramebufferStatus(36160);
        GLES20.glBindFramebuffer(36160, 0);
    }

    static int b(aga aga1, int i)
    {
        aga1.v = i;
        return i;
    }

    static Bitmap b(aga aga1)
    {
        return aga1.s;
    }

    static int c(aga aga1)
    {
        return aga1.v;
    }

    static Bitmap d(aga aga1)
    {
        return aga1.u;
    }

    private void j()
    {
        if (s == null)
        {
            return;
        } else
        {
            a(new Runnable() {

                final aga a;

                public void run()
                {
                    if (aga.a(a) == -1)
                    {
                        GLES20.glActiveTexture(33985);
                        aga.a(a, OpenGlUtils.a(aga.b(a), -1, true));
                    }
                }

            
            {
                a = aga.this;
                super();
            }
            });
            return;
        }
    }

    private void k()
    {
        if (u == null)
        {
            return;
        } else
        {
            a(new Runnable() {

                final aga a;

                public void run()
                {
                    if (aga.c(a) != -1)
                    {
                        GLES20.glDeleteTextures(1, new int[] {
                            aga.c(a)
                        }, 0);
                        aga.b(a, -1);
                    }
                    GLES20.glActiveTexture(33986);
                    aga.b(a, OpenGlUtils.a(aga.d(a), -1, true));
                }

            
            {
                a = aga.this;
                super();
            }
            });
            return;
        }
    }

    private void l()
    {
        if (t != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                t
            }, 0);
            t = -1;
        }
    }

    private void m()
    {
        if (v != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                v
            }, 0);
            v = -1;
        }
    }

    private void n()
    {
        x = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureLUT;\nuniform sampler2D inputImageTextureSkinToneLUT;\nuniform lowp int adjustLUT;\nuniform lowp float yContrastCoord;\nuniform lowp float filterLevel;\n \n \n lowp vec4 lookupColor(highp vec4 textureColor,sampler2D lookupTexture){ \n highp float blueColor = textureColor.b * 63.0; \n  \n highp vec2 quad1; \n quad1.y = floor(floor(blueColor) / 8.0); \n quad1.x = floor(blueColor) - (quad1.y * 8.0); \n  \n highp vec2 quad2; \n  quad2.y = floor(ceil(blueColor) / 8.0); \n quad2.x = ceil(blueColor) - (quad2.y * 8.0); \n  \n  highp vec2 texPos1; \n texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r); \n texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g); \n  \n highp vec2 texPos2; \n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r); \n texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g); \n  \n lowp vec4 newColor1 = texture2D(lookupTexture, texPos1); \n lowp vec4 newColor2 = texture2D(lookupTexture, texPos2); \n  \n lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor)); \n  \n  return newColor; \n  } \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 originalColor = vec4(textureColor.rgb, 1.0);\n\n     lowp vec4 rgbColor = vec4(textureColor.rgb, 1.0);\n\n \n     if (adjustLUT != 0) {\n         lowp float newr = texture2D(inputImageTextureSkinToneLUT, vec2(rgbColor.r, yContrastCoord)).r;\n         lowp float newg = texture2D(inputImageTextureSkinToneLUT, vec2(rgbColor.g, yContrastCoord)).g;\n         lowp float newb = texture2D(inputImageTextureSkinToneLUT, vec2(rgbColor.b, yContrastCoord)).b;\n         rgbColor = vec4(newr, newg, newb, 1.0);\n     }\n \n     rgbColor = lookupColor(rgbColor, inputImageTextureLUT);\n \n     gl_FragColor = mix(originalColor, rgbColor, filterLevel);\n     //gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n}");
    }

    private void o()
    {
        if (z[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, z, 0);
            z[0] = -1;
        }
        if (A[0] != -1)
        {
            GLES20.glDeleteTextures(1, A, 0);
            A[0] = -1;
        }
    }

    public void a(float f1)
    {
        n = f1;
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        while (i == 0 || i1 == 0 || q == i && r == i1) 
        {
            return;
        }
        q = i;
        r = i1;
        o();
        a(r, q, z, A);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!this.i)
        {
            return;
        }
        x.a();
        GLES20.glBindFramebuffer(36160, z[0]);
        GLES20.glViewport(0, 0, r, q);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(x.a("position"));
        GLES20.glVertexAttribPointer(x.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(x.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(x.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(x.b("inputImageTexture"), 0);
        }
        if (t != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, t);
            GLES20.glUniform1i(x.b("inputImageTextureLUT"), 1);
        }
        if (p)
        {
            k();
            p = false;
        }
        if (v != -1 && w > 0)
        {
            GLES20.glUniform1i(x.b("adjustLUT"), 0);
            GLES20.glUniform1f(x.b("yContrastCoord"), (float)((double)w - 0.5D) / (float)w);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, v);
            GLES20.glUniform1i(x.b("inputImageTextureSkinToneLUT"), 2);
        } else
        {
            GLES20.glUniform1i(x.b("adjustLUT"), 0);
        }
        GLES20.glUniform1f(x.b("filterLevel"), n);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(x.a("position"));
        GLES20.glDisableVertexAttribArray(x.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    public void b()
    {
        super.b();
        n();
        j();
        k();
    }

    public void b(int i, int i1)
    {
        while (g == i && h == i1 || i == 0 || i1 == 0) 
        {
            return;
        }
        g = i;
        h = i1;
    }

    public void c()
    {
        super.c();
    }

    public int d()
    {
        return A[0];
    }

    public void f()
    {
        super.f();
        l();
        m();
        x.a(true);
        o();
    }
}
