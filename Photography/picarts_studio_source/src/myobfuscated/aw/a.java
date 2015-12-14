// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.aw;

import android.opengl.GLES20;
import android.util.Log;
import com.photo.effect.Effect;
import com.photo.effect.EffectParameter;
import com.photo.gpu.h;
import java.util.ArrayList;

// Referenced classes of package myobfuscated.aw:
//            d

public final class a extends d
{

    private static String c;
    private Effect d;
    private int e;
    private float f;
    private int g;
    private float h;
    private int i;
    private float j;
    private int k;
    private float l;

    public a()
    {
        this(0.0F, 0.0F, 0.0F, 0.0F);
    }

    private a(float f1, float f2, float f3, float f4)
    {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", c);
        f = f1;
        h = f2;
        j = f3;
        l = f4;
    }

    public a(Effect effect)
    {
        this(effect.a("Brightness"), effect.a("Contrast"), effect.a("Saturation"), effect.a("Hue"));
        d = effect;
    }

    private void a(float f1)
    {
        f = f1;
        Log.e("ex1", (new StringBuilder("mBrightness = ")).append(f).toString());
        a(e, f);
    }

    private void b(float f1)
    {
        h = f1;
        Log.e("ex1", (new StringBuilder("contrast = ")).append(f1).toString());
        a(g, h);
    }

    private void c(float f1)
    {
        j = f1;
        Log.e("ex1", (new StringBuilder("mSaturation = ")).append(j).toString());
        float f2 = f1;
        if (f1 > 1.0F)
        {
            f2 = 1.0F - (f1 - 1.0F);
            f1 = f2;
            if (f2 <= 0.0F)
            {
                f1 = 1E-04F;
            }
            f2 = 1.0F / f1;
        }
        a(i, f2);
    }

    private void d(float f1)
    {
        l = f1;
        Log.e("ex1", (new StringBuilder("mHue = ")).append(l).toString());
        a(k, l);
    }

    public final void a()
    {
        super.a();
        e = GLES20.glGetUniformLocation(super.a, "brightness");
        g = GLES20.glGetUniformLocation(super.a, "contrast");
        i = GLES20.glGetUniformLocation(super.a, "saturation");
        k = GLES20.glGetUniformLocation(super.a, "hue");
    }

    public final void a(int i1)
    {
        if (i1 >= 0 && i1 < d.c.size())
        {
            EffectParameter effectparameter = d.a(i1);
            if (effectparameter.a.compareTo("Brightness") == 0)
            {
                a(((Float)effectparameter.c).floatValue());
            } else
            {
                if (effectparameter.a.compareTo("Contrast") == 0)
                {
                    b(((Float)effectparameter.c).floatValue());
                    return;
                }
                if (effectparameter.a.compareTo("Saturation") == 0)
                {
                    c(((Float)effectparameter.c).floatValue());
                    return;
                }
                if (effectparameter.a.compareTo("Hue") == 0)
                {
                    d(((Float)effectparameter.c).floatValue());
                    return;
                }
            }
        }
    }

    public final void b()
    {
        super.b();
        a(f);
        b(h);
        c(j);
        d(l);
    }

    static 
    {
        c = (new StringBuilder(" \nprecision highp float;varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform float brightness;\n uniform float contrast;\n uniform float saturation;\n uniform float hue;\n \n")).append(h.a).append(" \n").append(h.b).append(" \nvec3 rabidRGBToHSL(vec3 rgb)\n{ \nfloat r = rgb.r;\n \nfloat g = rgb.g;\n \nfloat b = rgb.b;\nfloat H = 0.0;\nfloat S = 0.0;\nfloat L = 0.0;\n\tfloat cMax = max(max(r,g),b);\n\tfloat cMin = min(min(r,g),b);\n\tfloat delta = cMax - cMin;\n   if(delta == 0.0){\n       H = 0.0;\n   }else \n\tif(cMax == r){\n\t\tH = mod((g - b)/delta,6.0)*60.0;\n\t}\n else if(cMax == g) {\n\t\tH = ((b - r)/delta + 2.0)*60.0;\n\t}\n else {\n\t\tH = ((r - g)/delta + 4.0)*60.0;\n\t}\nL = (cMax + cMin)/2.0;\n\tif(delta == 0.0){\n\t\tS = 0.0;\n\t} else {\n\t\tS = delta/(1.0 - abs((2.0*L - 1.0)));\n\t}\n   if(H < 0.0){\n       H += 360.0;\n   }else if(H > 360.0){\n       H -= 360.0;\n   }\nvec3 hsl = vec3(H,S,L);return hsl;\n}\nvec3 rabidHSLToRGB(vec3 hsl)\n{ \nfloat H = hsl.x;\n \nfloat S = hsl.y;\n \nfloat L = hsl.z;\nfloat C = (1.0 - abs((2.0*L - 1.0))) * S;\nfloat X = C * (1.0 - abs( (mod((H / 60.0),2.0) - 1.0)));\nfloat m = L - C/2.0;\nvec3 rgb = vec3(0.0,0.0,0.0);\nif(H >= 0.0 && H <= 60.0){\n\trgb = vec3(C,X,0.0);\n} else if(H >= 60.0 && H <= 120.0){\n\trgb = vec3(X,C,0.0);\n} else if(H >= 120.0 && H <= 180.0){\n\trgb = vec3(0.0,C,X);\n} else if(H >= 180.0 && H <= 240.0){\n\trgb = vec3(0.0,X,C);\n} else if(H >= 240.0 && H <= 300.0){\n\trgb = vec3(X,0.0,C);\n} else if(H >= 300.0 && H <= 360.0){\n\trgb = vec3(C,0.0,X);\n} \nrgb.r += m;\nrgb.g += m;\nrgb.b += m;\nreturn rgb;\n}\nvec3 contrastGimpRGB(vec3 rgb,float contrast)\n").append(" {\n\trgb.r = contrastGimp(rgb.r,contrast);\n\trgb.g = contrastGimp(rgb.g,contrast);\n\trgb.b = contrastGimp(rgb.b,contrast);\n").append("\trgb = clamp(rgb,vec3(0.0,0.0,0.0),vec3(1.0,1.0,1.0));\n   return rgb;\n }\n void main()\n").append(" {\n     vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n\ttextureColor.r = correctBrightness(textureColor.r,brightness);\n").append("\ttextureColor.g = correctBrightness(textureColor.g,brightness);\n\ttextureColor.b = correctBrightness(textureColor.b,brightness);\n\ttextureColor.rgb = clamp(textureColor.rgb,vec3(0.0,0.0,0.0),vec3(1.0,1.0,1.0));\n   textureColor.rgb = contrastGimpRGB(textureColor.rgb,contrast);\n").append("\tvec3 hsl = rabidRGBToHSL(textureColor.rgb);\n\thsl.y = hsl.y*saturation;\n\thsl.y = clamp(hsl.y,0.0,1.0);\n\thsl.x += hue;\n").append("\tif(hsl.x < 0.0){\n\t\thsl.x += 360.0;\n\t} else if(hsl.x > 360.0){\n\t\thsl.x -= 360.0;\n").append("\t}\n\ttextureColor.rgb = rabidHSLToRGB(hsl);\n\ttextureColor.rgb = clamp(textureColor.rgb,vec3(0.0,0.0,0.0),vec3(1.0,1.0,1.0));\n   gl_FragColor = textureColor;\n").append(" }").toString();
    }
}
