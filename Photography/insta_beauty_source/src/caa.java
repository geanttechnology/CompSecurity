// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class caa extends byh
{

    private int A;
    private cdn B;
    private ccu C;
    private ccu D;
    private int E[] = {
        -1
    };
    private int F[] = {
        -1
    };
    FloatBuffer a;
    FloatBuffer b;
    FloatBuffer c;
    FloatBuffer d;
    FloatBuffer e;
    FloatBuffer f;
    FloatBuffer g;
    FloatBuffer w;
    protected int x;
    protected int y;
    private Bitmap z;

    public caa(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        z = null;
        A = -1;
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        w = null;
        C = new ccu();
        D = new ccu();
        x = 0;
        y = 0;
        z = bitmap;
        m();
    }

    static int a(caa caa1)
    {
        return caa1.A;
    }

    static int a(caa caa1, int i)
    {
        caa1.A = i;
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

    static Bitmap b(caa caa1)
    {
        return caa1.z;
    }

    private void j()
    {
        B = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputToneCurveTexture;\nuniform sampler2D inputToneCurveTexture2;\n//uniform sampler2D inputImageTextureLUT;\nuniform lowp vec4 colorFill_multiply;\nuniform lowp vec4 colorFill_exclusion;\nuniform lowp vec4 colorFill_screen;\nuniform lowp vec4 colorFill_darken;\nuniform lowp vec4 colorFill_lighten;\nuniform lowp vec4 colorFill_vividlight;\nuniform lowp vec4 colorFill_softlight;\nuniform lowp vec3 bceShift;\nuniform lowp float filterLevel;\n \n \n \n lowp vec4 lookupColor(highp vec4 textureColor,sampler2D lookupTexture){ \n highp float blueColor = textureColor.b * 63.0; \n  \n highp vec2 quad1; \n quad1.y = floor(floor(blueColor) / 8.0); \n quad1.x = floor(blueColor) - (quad1.y * 8.0); \n  \n highp vec2 quad2; \n  quad2.y = floor(ceil(blueColor) / 8.0); \n quad2.x = ceil(blueColor) - (quad2.y * 8.0); \n  \n  highp vec2 texPos1; \n texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r); \n texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g); \n  \n highp vec2 texPos2; \n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r); \n texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g); \n  \n lowp vec4 newColor1 = texture2D(lookupTexture, texPos1); \n lowp vec4 newColor2 = texture2D(lookupTexture, texPos2); \n  \n lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor)); \n  \n  return newColor; \n  } \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     //brightness\n     rgbColor = clamp(rgbColor * vec3(1.0 + bceShift.r), vec3(0.0), vec3(1.0));\n     //contrast\n     rgbColor = clamp((rgbColor - vec3(0.5)) * (1.0 + bceShift.g) + vec3(0.5), vec3(0.0), vec3(1.0));\n     //exposure\n     rgbColor = clamp(rgbColor * pow(2.0, bceShift.b), vec3(0.0), vec3(1.0));\n \n     redCurveValue = texture2D(inputToneCurveTexture2, vec2(rgbColor.r, 0.0)).r;\n     greenCurveValue = texture2D(inputToneCurveTexture2, vec2(rgbColor.g, 0.0)).g;\n     blueCurveValue = texture2D(inputToneCurveTexture2, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     if (colorFill_lighten.r > 0.01 || colorFill_lighten.g > 0.01 || colorFill_lighten.b > 0.01 || colorFill_lighten.a > 0.01) { \n         rgbColor = vec3(max(colorFill_lighten.r, rgbColor.r), max(colorFill_lighten.g, rgbColor.g), max(colorFill_lighten.b, rgbColor.b)); \n     }\n\n \n \n     if (colorFill_multiply.r > 0.01 || colorFill_multiply.g > 0.01 || colorFill_multiply.b > 0.01 || colorFill_multiply.a > 0.01) { \n         rgbColor = rgbColor * colorFill_multiply.rgb; \n     }\n\n \n \n     if (colorFill_screen.r > 0.01 || colorFill_screen.g > 0.01 || colorFill_screen.b > 0.01 || colorFill_screen.a > 0.01) { \n         rgbColor = vec3(1.0) - (vec3(1.0) - rgbColor.rgb)*(vec3(1.0) - colorFill_screen.rgb); \n     }\n\n \n     if (colorFill_exclusion.r > 0.01 || colorFill_exclusion.g > 0.01 || colorFill_exclusion.b > 0.01 || colorFill_exclusion.a > 0.01) { \n         lowp vec3 newcolor = (colorFill_exclusion.rgb + rgbColor.rgb - 2.0*colorFill_exclusion.rgb*rgbColor.rgb); \n         rgbColor = clamp(mix(rgbColor, newcolor, colorFill_exclusion.a), vec3(0.0), vec3(1.0)); \n     }\n\n \n     if (colorFill_darken.r > 0.01 || colorFill_darken.g > 0.01 || colorFill_darken.b > 0.01 || colorFill_darken.a > 0.01) { \n          lowp vec3 newcolor = vec3(min(colorFill_darken.r, rgbColor.r), min(colorFill_darken.g, rgbColor.g), min(colorFill_darken.b, rgbColor.b)); \n          rgbColor = mix(newcolor, rgbColor, colorFill_darken.a); \n          rgbColor = clamp(rgbColor, vec3(0.0), vec3(1.0)); \n          } \n  \n \n     if (colorFill_vividlight.r > 0.01 || colorFill_vividlight.g > 0.01 || colorFill_vividlight.b > 0.01 || colorFill_vividlight.a > 0.01) { \n          lowp vec3 newcolor; \n          if (colorFill_vividlight.r < 0.5 && colorFill_vividlight.g < 0.5 && colorFill_vividlight.b < 0.5){ \n              newcolor = vec3(1.0) - ((vec3(1.0)-rgbColor.rgb)/2.0)*colorFill_vividlight.rgb; \n          }else{ \n              newcolor = rgbColor.rgb/(vec3(1.0) - 2.0*(colorFill_vividlight.rgb - vec3(0.5))); \n          } \n          rgbColor = mix(rgbColor, newcolor,  colorFill_vividlight.a); \n          } \n  \n \n     if (colorFill_softlight.r > 0.01 || colorFill_softlight.g > 0.01 || colorFill_softlight.b > 0.01 || colorFill_softlight.a > 0.01) { \n          lowp vec3 newcolor = (vec3(1.0) - colorFill_softlight.rgb)*colorFill_softlight.rgb*rgbColor + colorFill_softlight.rgb*(vec3(1.0) - (vec3(1.0) - colorFill_softlight.rgb)*(vec3(1.0) - rgbColor)); \n          rgbColor = mix(rgbColor, newcolor, colorFill_softlight.a); \n          } \n  \n     //rgbColor = lookupColor(vec4(rgbColor, textureColor.a), inputImageTextureLUT).rgb;\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void k()
    {
        if (z == null)
        {
            return;
        } else
        {
            l();
            a(new cab(this));
            return;
        }
    }

    private void l()
    {
        if (A != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                A
            }, 0);
            A = -1;
        }
    }

    private void m()
    {
        n();
        o();
        p();
        k();
    }

    private void n()
    {
        a = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
        b = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
        c = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
        d = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
        e = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
        f = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
        g = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
    }

    private void o()
    {
        w = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F
        });
    }

    private void p()
    {
        PointF apointf[] = new PointF[2];
        apointf[0] = new PointF(0.0F, 0.0F);
        apointf[1] = new PointF(1.0F, 1.0F);
        PointF apointf1[] = new PointF[2];
        apointf1[0] = new PointF(0.0F, 0.0F);
        apointf1[1] = new PointF(1.0F, 1.0F);
        PointF apointf2[] = new PointF[2];
        apointf2[0] = new PointF(0.0F, 0.0F);
        apointf2[1] = new PointF(1.0F, 1.0F);
        PointF apointf3[] = new PointF[2];
        apointf3[0] = new PointF(0.0F, 0.0F);
        apointf3[1] = new PointF(1.0F, 1.0F);
        C.a(apointf);
        C.b(apointf1);
        C.c(apointf2);
        C.d(apointf3);
        new PointF(0.0F, 0.0F);
        new PointF(1.0F, 1.0F);
        new PointF(0.0F, 0.0F);
        new PointF(1.0F, 1.0F);
        new PointF(0.0F, 0.0F);
        new PointF(1.0F, 1.0F);
        new PointF(0.0F, 0.0F);
        new PointF(1.0F, 1.0F);
        D.a(apointf);
        D.b(apointf1);
        D.c(apointf2);
        D.d(apointf3);
    }

    private void q()
    {
        if (E[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, E, 0);
            E[0] = -1;
        }
        if (F[0] != -1)
        {
            GLES20.glDeleteTextures(1, F, 0);
            F[0] = -1;
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
        while (i == 0 || i1 == 0 || x == i && y == i1) 
        {
            return;
        }
        x = i;
        y = i1;
        q();
        a(y, x, E, F);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        B.a();
        GLES20.glBindFramebuffer(36160, E[0]);
        GLES20.glViewport(0, 0, y, x);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(B.a("position"));
        GLES20.glVertexAttribPointer(B.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(B.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(B.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(B.b("inputImageTexture"), 0);
        }
        if (A != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, A);
            GLES20.glUniform1i(B.b("inputImageTextureLUT"), 1);
        }
        GLES20.glUniform4fv(B.b("colorFill_multiply"), 1, a);
        GLES20.glUniform4fv(B.b("colorFill_exclusion"), 1, b);
        GLES20.glUniform4fv(B.b("colorFill_screen"), 1, c);
        GLES20.glUniform4fv(B.b("colorFill_darken"), 1, d);
        GLES20.glUniform4fv(B.b("colorFill_lighten"), 1, e);
        GLES20.glUniform4fv(B.b("colorFill_vividlight"), 1, f);
        GLES20.glUniform4fv(B.b("colorFill_softlight"), 1, g);
        GLES20.glUniform3fv(B.b("bceShift"), 1, w);
        C.a(33988);
        GLES20.glUniform1i(B.b("inputToneCurveTexture"), 4);
        D.a(33989);
        GLES20.glUniform1i(B.b("inputToneCurveTexture2"), 5);
        GLES20.glUniform1f(B.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(B.a("position"));
        GLES20.glDisableVertexAttribArray(B.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void a(float af[])
    {
        b = FloatBuffer.wrap(af);
    }

    public void a(PointF apointf[], PointF apointf1[], PointF apointf2[], PointF apointf3[])
    {
        C.a(apointf);
        C.b(apointf1);
        C.c(apointf2);
        C.d(apointf3);
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
        c = FloatBuffer.wrap(af);
    }

    public void b(PointF apointf[], PointF apointf1[], PointF apointf2[], PointF apointf3[])
    {
        D.a(apointf);
        D.b(apointf1);
        D.c(apointf2);
        D.d(apointf3);
    }

    public void c()
    {
        super.c();
        j();
    }

    public void c(float af[])
    {
        d = FloatBuffer.wrap(af);
    }

    public void d()
    {
        super.d();
        l();
        B.a(true);
        q();
    }

    public void d(float af[])
    {
        e = FloatBuffer.wrap(af);
    }

    public void e(float af[])
    {
        f = FloatBuffer.wrap(af);
    }

    public int f()
    {
        return F[0];
    }

    public void f(float af[])
    {
        g = FloatBuffer.wrap(af);
    }

    public void g(float af[])
    {
        w = FloatBuffer.wrap(af);
    }
}
