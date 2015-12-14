// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class ccc extends byh
{

    private int A[] = {
        -1
    };
    boolean a;
    protected int b;
    protected int c;
    private Bitmap d;
    private int e;
    private Bitmap f;
    private int g;
    private int w;
    private cdn x;
    private float y;
    private int z[] = {
        -1
    };

    public ccc()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        d = null;
        e = -1;
        f = null;
        g = -1;
        w = 0;
        a = false;
        y = 0.7F;
        b = 0;
        c = 0;
    }

    public ccc(Bitmap bitmap, Bitmap bitmap1)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        d = null;
        e = -1;
        f = null;
        g = -1;
        w = 0;
        a = false;
        y = 0.7F;
        b = 0;
        c = 0;
        d = bitmap;
        f = bitmap1;
        if (f != null)
        {
            w = f.getHeight();
        }
    }

    static int a(ccc ccc1)
    {
        return ccc1.e;
    }

    static int a(ccc ccc1, int i)
    {
        ccc1.e = i;
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

    static int b(ccc ccc1, int i)
    {
        ccc1.g = i;
        return i;
    }

    static Bitmap b(ccc ccc1)
    {
        return ccc1.d;
    }

    static int c(ccc ccc1)
    {
        return ccc1.g;
    }

    static Bitmap d(ccc ccc1)
    {
        return ccc1.f;
    }

    private void j()
    {
        if (d == null)
        {
            return;
        } else
        {
            a(new ccd(this));
            return;
        }
    }

    private void k()
    {
        if (f == null)
        {
            return;
        } else
        {
            a(new cce(this));
            return;
        }
    }

    private void l()
    {
        if (e != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                e
            }, 0);
            e = -1;
        }
    }

    private void m()
    {
        if (g != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                g
            }, 0);
            g = -1;
        }
    }

    private void n()
    {
        x = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureLUT;\nuniform sampler2D inputImageTextureSkinToneLUT;\nuniform lowp int adjustLUT;\nuniform lowp float yContrastCoord;\nuniform lowp float filterLevel;\n \n \n lowp vec4 lookupColor(highp vec4 textureColor,sampler2D lookupTexture){ \n highp float blueColor = textureColor.b * 63.0; \n  \n highp vec2 quad1; \n quad1.y = floor(floor(blueColor) / 8.0); \n quad1.x = floor(blueColor) - (quad1.y * 8.0); \n  \n highp vec2 quad2; \n  quad2.y = floor(ceil(blueColor) / 8.0); \n quad2.x = ceil(blueColor) - (quad2.y * 8.0); \n  \n  highp vec2 texPos1; \n texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r); \n texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g); \n  \n highp vec2 texPos2; \n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r); \n texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g); \n  \n lowp vec4 newColor1 = texture2D(lookupTexture, texPos1); \n lowp vec4 newColor2 = texture2D(lookupTexture, texPos2); \n  \n lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor)); \n  \n  return newColor; \n  } \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 originalColor = vec4(textureColor.rgb, 1.0);\n\n     lowp vec4 rgbColor = vec4(textureColor.rgb, 1.0);\n\n \n     if (adjustLUT != 0) {\n         lowp float newr = texture2D(inputImageTextureSkinToneLUT, vec2(rgbColor.r, yContrastCoord)).r;\n         lowp float newg = texture2D(inputImageTextureSkinToneLUT, vec2(rgbColor.g, yContrastCoord)).g;\n         lowp float newb = texture2D(inputImageTextureSkinToneLUT, vec2(rgbColor.b, yContrastCoord)).b;\n         rgbColor = vec4(newr, newg, newb, 1.0);\n     }\n \n     rgbColor = lookupColor(rgbColor, inputImageTextureLUT);\n \n     gl_FragColor = mix(originalColor, rgbColor, filterLevel);\n     //gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n}");
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

    public void a()
    {
        super.a();
    }

    public void a(float f1)
    {
        u = f1;
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        while (i == 0 || i1 == 0 || b == i && c == i1) 
        {
            return;
        }
        b = i;
        c = i1;
        o();
        a(c, b, z, A);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        x.a();
        GLES20.glBindFramebuffer(36160, z[0]);
        GLES20.glViewport(0, 0, c, b);
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
        if (e != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, e);
            GLES20.glUniform1i(x.b("inputImageTextureLUT"), 1);
        }
        if (a)
        {
            k();
            a = false;
        }
        if (g != -1 && w > 0)
        {
            GLES20.glUniform1i(x.b("adjustLUT"), 0);
            GLES20.glUniform1f(x.b("yContrastCoord"), (float)((double)w - 0.5D) / (float)w);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, g);
            GLES20.glUniform1i(x.b("inputImageTextureSkinToneLUT"), 2);
        } else
        {
            GLES20.glUniform1i(x.b("adjustLUT"), 0);
        }
        GLES20.glUniform1f(x.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(x.a("position"));
        GLES20.glDisableVertexAttribArray(x.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    public void b(int i, int i1)
    {
        while (n == i && o == i1 || i == 0 || i1 == 0) 
        {
            return;
        }
        n = i;
        o = i1;
    }

    public void c()
    {
        super.c();
        n();
        j();
        k();
    }

    public void d()
    {
        super.d();
        l();
        m();
        x.a(true);
        o();
    }

    public int f()
    {
        return A[0];
    }
}
