// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class ccw extends byh
{

    private int A[] = {
        -1
    };
    FloatBuffer a;
    FloatBuffer b;
    protected int c;
    protected int d;
    private Bitmap e;
    private Bitmap f;
    private int g;
    private int w;
    private cdn x;
    private ccu y;
    private int z[] = {
        -1
    };

    public ccw(Bitmap bitmap, Bitmap bitmap1)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        e = null;
        f = null;
        g = -1;
        w = -1;
        a = null;
        b = null;
        y = new ccu();
        c = 0;
        d = 0;
        e = bitmap;
        f = bitmap1;
    }

    static int a(ccw ccw1)
    {
        return ccw1.g;
    }

    static int a(ccw ccw1, int i)
    {
        ccw1.g = i;
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

    static int b(ccw ccw1, int i)
    {
        ccw1.w = i;
        return i;
    }

    static Bitmap b(ccw ccw1)
    {
        return ccw1.e;
    }

    static int c(ccw ccw1)
    {
        return ccw1.w;
    }

    static Bitmap d(ccw ccw1)
    {
        return ccw1.f;
    }

    private void j()
    {
        if (e == null || f == null)
        {
            return;
        } else
        {
            k();
            a(new ccx(this));
            return;
        }
    }

    private void k()
    {
        if (g != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                g
            }, 0);
            g = -1;
        }
        if (w != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                w
            }, 0);
            w = -1;
        }
    }

    private void l()
    {
        x = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputImageTextureOverlay;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp vec4 colorFill;\nuniform lowp vec4 colorFill_base;\nuniform lowp float filterLevel;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n     lowp vec4 maskColor = texture2D(inputImageTextureMask, textureCoordinate);\n     lowp vec4 overlayColor = texture2D(inputImageTextureOverlay, textureCoordinate);\n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     if (colorFill.r > 0.01 || colorFill.g > 0.01 || colorFill.b > 0.01 || colorFill.a > 0.01) { \n         rgbColor = mix(rgbColor, colorFill.rgb, colorFill.a); \n     }\n\n \n     rgbColor = mix(rgbColor, colorFill_base.rgb, maskColor.r*colorFill_base.a);\n \n     rgbColor = mix(rgbColor, overlayColor.rgb, 0.35);\n \n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void m()
    {
        a = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.35F
        });
        b = FloatBuffer.wrap(new float[] {
            0.8117647F, 0.8117647F, 0.4470588F, 1.0F
        });
    }

    private void n()
    {
        PointF pointf = new PointF(0.0F, 0.0F);
        PointF pointf1 = new PointF(0.2627451F, 0.1058824F);
        PointF pointf2 = new PointF(0.4980392F, 0.3254902F);
        PointF pointf3 = new PointF(0.7019608F, 0.7411765F);
        PointF pointf4 = new PointF(1.0F, 1.0F);
        PointF pointf5 = new PointF(0.0F, 0.0F);
        PointF pointf6 = new PointF(0.2431373F, 0.3176471F);
        PointF pointf7 = new PointF(0.7215686F, 0.6901961F);
        PointF pointf8 = new PointF(1.0F, 1.0F);
        PointF pointf9 = new PointF(0.0F, 0.0F);
        PointF pointf10 = new PointF(0.5F, 0.5F);
        PointF pointf11 = new PointF(0.6588235F, 0.6666667F);
        PointF pointf12 = new PointF(1.0F, 1.0F);
        PointF pointf13 = new PointF(0.0F, 0.0F);
        PointF pointf14 = new PointF(0.1764706F, 0.2784314F);
        PointF pointf15 = new PointF(0.682353F, 0.7058824F);
        PointF pointf16 = new PointF(1.0F, 1.0F);
        y.a(new PointF[] {
            pointf, pointf1, pointf2, pointf3, pointf4
        });
        y.b(new PointF[] {
            pointf5, pointf6, pointf7, pointf8
        });
        y.c(new PointF[] {
            pointf9, pointf10, pointf11, pointf12
        });
        y.d(new PointF[] {
            pointf13, pointf14, pointf15, pointf16
        });
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
        while (i == 0 || i1 == 0 || c == i && d == i1) 
        {
            return;
        }
        c = i;
        d = i1;
        o();
        a(d, c, z, A);
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
        GLES20.glViewport(0, 0, d, c);
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
        if (g != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, g);
            GLES20.glUniform1i(x.b("inputImageTextureMask"), 1);
        }
        if (w != -1)
        {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, w);
            GLES20.glUniform1i(x.b("inputImageTextureOverlay"), 4);
        }
        GLES20.glUniform4fv(x.b("colorFill"), 1, a);
        GLES20.glUniform4fv(x.b("colorFill_base"), 1, b);
        y.a(33989);
        GLES20.glUniform1i(x.b("inputToneCurveTexture"), 5);
        GLES20.glUniform1f(x.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(x.a("position"));
        GLES20.glDisableVertexAttribArray(x.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
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
        l();
        m();
        n();
        j();
    }

    public void d()
    {
        super.d();
        k();
        x.a(true);
        o();
    }

    public int f()
    {
        return A[0];
    }
}
