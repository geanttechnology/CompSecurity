// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class cao extends byh
{

    private int A[] = {
        -1
    };
    private int B[] = {
        -1
    };
    FloatBuffer a;
    FloatBuffer b;
    FloatBuffer c;
    FloatBuffer d;
    FloatBuffer e;
    FloatBuffer f;
    protected int g;
    protected int w;
    private Bitmap x;
    private int y;
    private cdn z;

    public cao(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        x = null;
        y = -1;
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = 0;
        w = 0;
        x = bitmap;
        j();
    }

    static int a(cao cao1)
    {
        return cao1.y;
    }

    static int a(cao cao1, int i)
    {
        cao1.y = i;
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
        GLES20.glBindFramebuffer(36160, 0);
    }

    static Bitmap b(cao cao1)
    {
        return cao1.x;
    }

    private void j()
    {
        n();
        o();
        p();
        l();
    }

    private void k()
    {
        z = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureMask;\nuniform lowp vec4 colorFill_multiply;\nuniform lowp vec3 bceShift;\nuniform lowp vec3 hsbShift1;\nuniform lowp vec3 hsbShift2;\nuniform lowp float filterLevel;\n \n \n // Values for Satuation \n  // Values from \"Graphics Shaders: Theory and Practice\" by Bailey and Cunningham \n  // Adjusting satuation \n  const lowp vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721); \n  // Values for HUE \n  const lowp vec3 kRGBToYPrime = vec3 (0.299, 0.587, 0.114); \n  const lowp vec3 kRGBToI = vec3 (0.595716, -0.274453, -0.321263); \n  const lowp vec3 kRGBToQ = vec3 (0.211456, -0.522591, 0.31135); \n  const lowp vec3 kYIQToR = vec3 (1.0, 0.9563, 0.6210); \n  const lowp vec3 kYIQToG = vec3 (1.0, -0.2721, -0.6474); \n  const lowp vec3 kYIQToB = vec3 (1.0, -1.1070, 1.7046); \n  lowp vec3 HueSatuationAdjusting(lowp vec3 rgbColor, lowp float hueAdjust, lowp float satuationAdjust) \n  { \n      lowp vec3 retColor = rgbColor; \n      if ((hueAdjust > -3.01 && hueAdjust < -0.01) || (hueAdjust > 0.01 && hueAdjust < 3.01)) \n      { \n          // Adjusting hue \n          lowp float YPrime = dot(rgbColor, kRGBToYPrime); \n          lowp float I = dot(rgbColor, kRGBToI); \n          lowp float Q = dot(rgbColor, kRGBToQ); \n          lowp float hue = atan(Q, I); \n          lowp float chroma = sqrt(I * I + Q * Q); \n          hue += (-hueAdjust); \n          Q = chroma * sin(hue); \n          I = chroma * cos(hue); \n          lowp vec3 yIQ = vec3(YPrime, I, Q); \n          retColor = vec3(dot(yIQ, kYIQToR), dot(yIQ, kYIQToG), dot(yIQ, kYIQToB)); \n      } \n      if (satuationAdjust > 1.01 || satuationAdjust < 0.99) \n      { \n          // Adjusting satuation \n          lowp float luminance = dot(retColor.rgb, luminanceWeighting); \n          lowp vec3 greyScaleColor = vec3(luminance); \n          retColor = mix(greyScaleColor, retColor, satuationAdjust); \n      } \n      return retColor; \n  } \n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 maskColor = texture2D(inputImageTextureMask, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n     //hue saturation1\n     rgbColor = HueSatuationAdjusting(rgbColor, hsbShift1.r, 1.0 + hsbShift1.g);\n \n \n     //brightness\n     rgbColor = clamp(pow(rgbColor, vec3(bceShift.r)), vec3(0.0), vec3(1.0));\n     //contrast\n     rgbColor = clamp((rgbColor - vec3(0.5)) * (1.0 + bceShift.g) + vec3(0.5), vec3(0.0), vec3(1.0));\n     //exposure\n     //rgbColor = clamp(rgbColor * pow(2.0, bceShift.b), vec3(0.0), vec3(1.0));\n \n \n     //hue saturation2\n     rgbColor = HueSatuationAdjusting(rgbColor, hsbShift2.r, 1.0 + hsbShift2.g);\n \n     // multiply \n     lowp vec3 newcolor = colorFill_multiply.rgb * rgbColor.rgb; \n     rgbColor = mix(rgbColor, newcolor, colorFill_multiply.a); \n     rgbColor = clamp(rgbColor, vec3(0.0), vec3(1.0)); \n \n     rgbColor = rgbColor * maskColor.rgb;\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void l()
    {
        if (x == null)
        {
            return;
        } else
        {
            m();
            a(new cap(this));
            return;
        }
    }

    private void m()
    {
        if (y != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                y
            }, 0);
            y = -1;
        }
    }

    private void n()
    {
        b = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
    }

    private void o()
    {
        d = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F
        });
    }

    private void p()
    {
        e = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F
        });
        f = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F
        });
    }

    private void q()
    {
        if (A[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, A, 0);
            A[0] = -1;
        }
        if (B[0] != -1)
        {
            GLES20.glDeleteTextures(1, B, 0);
            B[0] = -1;
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
        while (i == 0 || i1 == 0 || g == i && w == i1) 
        {
            return;
        }
        g = i;
        w = i1;
        q();
        a(w, g, A, B);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        z.a();
        GLES20.glBindFramebuffer(36160, A[0]);
        GLES20.glViewport(0, 0, w, g);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(z.a("position"));
        GLES20.glVertexAttribPointer(z.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(z.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(z.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(z.b("inputImageTexture"), 0);
        }
        if (y != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, y);
            GLES20.glUniform1i(z.b("inputImageTextureMask"), 1);
        }
        GLES20.glUniform4fv(z.b("colorFill_multiply"), 1, b);
        GLES20.glUniform3fv(z.b("bceShift"), 1, d);
        GLES20.glUniform3fv(z.b("hsbShift1"), 1, e);
        GLES20.glUniform3fv(z.b("hsbShift2"), 1, f);
        GLES20.glUniform1f(z.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(z.a("position"));
        GLES20.glDisableVertexAttribArray(z.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void a(float af[])
    {
        b = FloatBuffer.wrap(af);
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

    public void b(float af[])
    {
        d = FloatBuffer.wrap(af);
    }

    public void c()
    {
        super.c();
        k();
    }

    public void c(float af[])
    {
        e = FloatBuffer.wrap(af);
    }

    public void d()
    {
        super.d();
        m();
        z.a(true);
        q();
    }

    public void d(float af[])
    {
        f = FloatBuffer.wrap(af);
    }

    public int f()
    {
        return B[0];
    }
}
