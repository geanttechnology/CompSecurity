// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.aw;

import android.opengl.GLES20;
import android.util.Log;
import com.photo.effect.Effect;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;

// Referenced classes of package myobfuscated.aw:
//            d

public final class b extends d
{

    private Effect c;
    private float d;
    private int e;
    private int f;
    private int g;
    private float h;
    private int i;
    private int j;
    private int k;
    private float l;
    private int m;
    private int n;

    public b()
    {
        this(0.0F, 0.0F, 0.0F);
    }

    private b(float f1, float f2, float f3)
    {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", " \nprecision highp float;varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\nconst highp mat3 rgb2ycc = mat3(\n                   0.299, 0.587, 0.114,\n                   0.5, -0.418688, -0.081312,\n                   -0.168736, -0.331264, 0.5\n                   );\nconst highp mat3 ycc2rgb = mat3(\n                   1.0, 1.402, 0.0,\n                   1.0, -0.71414, -0.34414,\n                   1.0, 0.0, 1.772\n                   );\n uniform  float shadowAmount; \n uniform  float shadowAmountSign; \n uniform  float highlightAmount; \n uniform  float highlightAmountSign; \nuniform highp vec2 mT;\nuniform highp vec2 kT;\nvec3 applyShadows(vec3 color)\n{\n   float luma = color.r*0.299 + color.g*0.587 + color.b*0.114;\n\tluma = clamp(luma,0.0,1.0);\n\tfloat x = 1.0 - luma;\n\tfloat y = (x - pow(x, shadowAmount)) * (x * x);\n\tfloat delta = shadowAmountSign*y;\n\tcolor.r = color.r + delta;\n\tcolor.g = color.g + delta;\n\tcolor.b = color.b + delta;\n\tcolor = clamp(color,vec3(0.0,0.0,0.0),vec3(1.0,1.0,1.0));\n   return color;\n}\nvec3 applyHighlights(vec3 color)\n{\n   float luma = color.r*0.299 + color.g*0.587 + color.b*0.114;\n\tfloat x = clamp(luma,0.0,1.0);\n\tfloat y = (x - pow(x, highlightAmount)) * (x * x);\n\tfloat delta = highlightAmountSign*y;\n\tcolor.r = color.r + delta;\n\tcolor.g = color.g + delta;\n\tcolor.b = color.b + delta;\n\tcolor = clamp(color,vec3(0.0,0.0,0.0),vec3(1.0,1.0,1.0));\n   return color;\n}\nvec3 applyTintTempEffect(vec3 src)\n{\n    vec3 ycc = src * rgb2ycc;\n    vec2 tt = vec2(ycc.b + ycc.g, ycc.b - ycc.g);\n    tt += (mT - tt) * kT;\n    ycc.b = (tt.r + tt.g) * 0.5;\n    ycc.g = tt.r - ycc.b;\n    ycc.gb = clamp(ycc.gb, -0.5, 0.5);\n    vec3 result =  ycc * ycc2rgb;\n\t result = clamp(result,vec3(0.0,0.0,0.0),vec3(1.0,1.0,1.0));\n\treturn result;\n}\n void main()\n {\n     vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n   textureColor.rgb = applyShadows(textureColor.rgb);\n   textureColor.rgb = applyHighlights(textureColor.rgb);\n   textureColor.rgb = applyTintTempEffect(textureColor.rgb);\n   gl_FragColor = textureColor;\n }");
        d = 0.0F;
        f = 1;
        h = 0.0F;
        j = 1;
        l = 0.0F;
        d = f1;
        h = f2;
        l = f3;
    }

    public b(Effect effect)
    {
        this(effect.a("Shadows"), effect.a("Highlights"), effect.a("Temp"));
        c = effect;
    }

    private void a(float f1)
    {
        d = f1;
        int i1;
        if (f1 > 0.0F)
        {
            i1 = 1;
        } else
        {
            i1 = -1;
        }
        f = i1;
        f1 = (2.0F * Math.abs(f1)) / 100F;
        a(e, 1.0F + f1);
        a(g, f);
        Log.e("ex1", (new StringBuilder("Shadowamount = ")).append(d).toString());
        Log.e("ex1", (new StringBuilder("ShadowamountSign = ")).append(f).toString());
    }

    private void b(float f1)
    {
        h = f1;
        int i1;
        if (f1 > 0.0F)
        {
            i1 = 1;
        } else
        {
            i1 = -1;
        }
        j = i1;
        f1 = (2.0F * Math.abs(f1)) / 100F;
        a(i, 1.0F + f1);
        a(k, j);
        Log.e("ex1", (new StringBuilder("mHighLightAmount = ")).append(h).toString());
        Log.e("ex1", (new StringBuilder("mHighLightAmountSign = ")).append(j).toString());
    }

    private void c(float f1)
    {
        l = f1;
        Log.e("ex1", (new StringBuilder("temp = ")).append(f1).toString());
        float f3 = l / 200F;
        float f2 = Math.abs(0.0F);
        if (f3 > 0.0F)
        {
            f1 = -1F;
        } else
        {
            f1 = 1.0F;
        }
        f3 = Math.abs(f3);
        a(m, new float[] {
            1.0F, f1
        });
        a(n, new float[] {
            f2, f3
        });
    }

    public final void a()
    {
        super.a();
        e = GLES20.glGetUniformLocation(super.a, "shadowAmount");
        g = GLES20.glGetUniformLocation(super.a, "shadowAmountSign");
        i = GLES20.glGetUniformLocation(super.a, "highlightAmount");
        k = GLES20.glGetUniformLocation(super.a, "highlightAmountSign");
        m = GLES20.glGetUniformLocation(super.a, "mT");
        n = GLES20.glGetUniformLocation(super.a, "kT");
    }

    public final void a(int i1)
    {
        if (i1 >= 0 && i1 < c.c.size())
        {
            EffectParameter effectparameter = c.a(i1);
            if (effectparameter.a.compareTo("Shadows") == 0)
            {
                a(((Float)effectparameter.c).floatValue());
            } else
            {
                if (effectparameter.a.compareTo("Highlights") == 0)
                {
                    b(((Float)effectparameter.c).floatValue());
                    return;
                }
                if (effectparameter.a.compareTo("Temp") == 0)
                {
                    c(((Float)effectparameter.c).floatValue());
                    return;
                }
            }
        }
    }

    public final void b()
    {
        super.b();
        a(d);
        b(h);
        c(l);
    }
}
