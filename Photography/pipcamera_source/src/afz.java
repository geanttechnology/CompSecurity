// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;
import jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyBlendMode;

public class afz extends aeo
{

    private agu A;
    private boolean B;
    private int C[] = {
        -1
    };
    private int D[] = {
        -1
    };
    protected int p;
    protected int q;
    private Bitmap r;
    private int s;
    private Bitmap t;
    private GPUImageBeautyBlendMode u;
    private float v;
    private int w;
    private boolean x;
    private boolean y;
    private float z;

    public afz()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        r = null;
        s = -1;
        t = null;
        v = 1.0F;
        w = -1;
        x = false;
        y = false;
        z = 0.0F;
        B = false;
        p = 0;
        q = 0;
    }

    public afz(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        r = null;
        s = -1;
        t = null;
        v = 1.0F;
        w = -1;
        x = false;
        y = false;
        z = 0.0F;
        B = false;
        p = 0;
        q = 0;
        r = bitmap;
    }

    static int a(afz afz1)
    {
        return afz1.s;
    }

    static int a(afz afz1, int i)
    {
        afz1.s = i;
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

    static int b(afz afz1, int i)
    {
        afz1.w = i;
        return i;
    }

    private int b(GPUImageBeautyBlendMode gpuimagebeautyblendmode)
    {
        class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[GPUImageBeautyBlendMode.values().length];
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeNormal.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeDissolve.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeDarken.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeMultiply.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeColorBurn.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeLinearBurn.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeDarkerColor.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeLighten.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeScreen.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeColorDodge.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeLinearDodge.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeLighterColor.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeOverlay.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeSoftLight.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeHardLight.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeVividLight.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeLinearLight.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModePinLight.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeHardMix.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeDifference.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeExclusion.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeSubtract.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeDivide.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeHue.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeSaturation.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeColor.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[GPUImageBeautyBlendMode.BlendModeLuminosity.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3.a[gpuimagebeautyblendmode.ordinal()])
        {
        default:
            return -1;

        case 1: // '\001'
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 3;

        case 5: // '\005'
            return 4;

        case 6: // '\006'
            return 5;

        case 7: // '\007'
            return 6;

        case 8: // '\b'
            return 7;

        case 9: // '\t'
            return 8;

        case 10: // '\n'
            return 9;

        case 11: // '\013'
            return 10;

        case 12: // '\f'
            return 11;

        case 13: // '\r'
            return 12;

        case 14: // '\016'
            return 13;

        case 15: // '\017'
            return 14;

        case 16: // '\020'
            return 15;

        case 17: // '\021'
            return 16;

        case 18: // '\022'
            return 17;

        case 19: // '\023'
            return 18;

        case 20: // '\024'
            return 19;

        case 21: // '\025'
            return 20;

        case 22: // '\026'
            return 21;

        case 23: // '\027'
            return 22;

        case 24: // '\030'
            return 23;

        case 25: // '\031'
            return 24;

        case 26: // '\032'
            return 25;

        case 27: // '\033'
            return 26;
        }
    }

    static Bitmap b(afz afz1)
    {
        return afz1.r;
    }

    static int c(afz afz1)
    {
        return afz1.w;
    }

    static boolean d(afz afz1)
    {
        return afz1.B;
    }

    static Bitmap e(afz afz1)
    {
        return afz1.t;
    }

    private void j()
    {
        if (r == null)
        {
            return;
        } else
        {
            a(new Runnable() {

                final afz a;

                public void run()
                {
                    if (afz.a(a) == -1)
                    {
                        GLES20.glActiveTexture(33986);
                        afz.a(a, OpenGlUtils.a(afz.b(a), -1, true));
                    }
                }

            
            {
                a = afz.this;
                super();
            }
            });
            return;
        }
    }

    private void k()
    {
        if (s != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                s
            }, 0);
            s = -1;
        }
    }

    private void l()
    {
        if (t == null)
        {
            return;
        } else
        {
            m();
            a(new Runnable() {

                final afz a;

                public void run()
                {
label0:
                    {
                        if (afz.c(a) == -1)
                        {
                            GLES20.glActiveTexture(33987);
                            if (!afz.d(a))
                            {
                                break label0;
                            }
                            afz.b(a, OpenGlUtils.a(afz.e(a), -1, jp.co.cyberagent.android.gpuimage.OpenGlUtils.Direction.VERTICAL, true));
                        }
                        return;
                    }
                    afz.b(a, OpenGlUtils.a(afz.e(a), -1, true));
                }

            
            {
                a = afz.this;
                super();
            }
            });
            return;
        }
    }

    private void m()
    {
        if (w != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                w
            }, 0);
            w = -1;
        }
    }

    private void n()
    {
        A = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\nattribute highp vec4 inputBlendTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blendTextureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    blendTextureCoordinate = inputBlendTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\nvarying highp vec2 blendTextureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureLUT;\nuniform sampler2D inputBlendImageTexture;\nuniform lowp int blendMode;\nuniform lowp float blendAlpha;\nuniform lowp float filterLevel;\n \n \n lowp vec4 blend(highp vec4 srcColor, highp vec4 blendColor, lowp int blendMode, lowp float blendAlpha){ \n   if (blendMode == 0) { //BlendModeNormal \n\t\treturn blendColor; \n\t} \n   else if (blendMode == 2) { //BlendModeDarken \n\t\tlowp vec4 newColor = vec4(min(srcColor.r, blendColor.r), min(srcColor.g, blendColor.g), min(srcColor.b, blendColor.b), 1.0); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 3) { //BlendModeMultiply \n\t\tlowp vec4 newColor = srcColor * blendColor; \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 4) { //BlendModeColorBurn \n\t\tlowp vec4 newColor = vec4(1.0) - (vec4(1.0) - srcColor) / blendColor; \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 5) { //BlendModeLinearBurn \n\t\tlowp vec4 newColor = srcColor + blendColor - vec4(1.0); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 7) { //BlendModeLighten \n\t\tlowp vec4 newColor = vec4(max(srcColor.r, blendColor.r), max(srcColor.g, blendColor.g), max(srcColor.b, blendColor.b), 1.0); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 8) { //BlendModeScreen \n\t\tlowp vec4 newColor = vec4(1.0) - (vec4(1.0) - srcColor) * (vec4(1.0) - blendColor); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 9) { //BlendModeColorDodge \n\t\tlowp vec4 newColor = srcColor / (vec4(1.0) - blendColor); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 10) { //BlendModeLinearDodge \n\t\tlowp vec4 newColor = srcColor + blendColor; \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 12) { //BlendModeOverlay \n\t\tlowp float newr; \n\t\tlowp float newg; \n\t\tlowp float newb; \n\t\tif (srcColor.r > 0.5) { \n\t\t    newr = 1.0 - (1.0 - 2.0*(srcColor.r - 0.5))*(1.0 - blendColor.r); \n\t\t} else { \n\t\t    newr = 2.0 * srcColor.r * blendColor.r; \n\t\t} \n\t\tif (srcColor.g > 0.5) { \n\t\t    newg = 1.0 - (1.0 - 2.0*(srcColor.g - 0.5))*(1.0 - blendColor.g); \n\t\t} else { \n\t\t    newg = 2.0 * srcColor.g * blendColor.g; \n\t\t} \n\t\tif (srcColor.b > 0.5) { \n\t\t    newb = 1.0 - (1.0 - 2.0*(srcColor.b - 0.5))*(1.0 - blendColor.b); \n\t\t} else { \n\t\t    newb = 2.0 * srcColor.b * blendColor.b; \n\t\t} \n\t\tlowp vec4 newColor = vec4(newr, newg, newb, 1.0); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 13) { //BlendModeSoftLight \n\t\tlowp vec4 newColor = (vec4(1.0) - srcColor)*blendColor*srcColor + srcColor*(vec4(1.0) - (vec4(1.0) - blendColor)*(vec4(1.0) - srcColor)); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 14) { //BlendModeHardLight \n\t\tlowp vec4 newColor; \n\t\tif (srcColor.r < 0.5 && srcColor.g < 0.5 && srcColor.b < 0.5) { \n\t\t\tnewColor = vec4(2.0) * srcColor * blendColor; \n\t\t} \n\t\telse { \n\t\t\tnewColor = vec4(1.0) - vec4(2.0) * (vec4(1.0) - srcColor) * (vec4(1.0) - blendColor); \n\t\t} \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 15) { //BlendModeVividLight \n\t\tlowp vec4 newColor; \n\t\tif (blendColor.r < 0.5 && blendColor.g < 0.5 && blendColor.b < 0.5) { \n\t\t\tnewColor = vec4(1.0) - (vec4(1.0) - srcColor) / vec4(2.0) * blendColor; \n\t\t} \n\t\telse { \n\t\t\tnewColor = srcColor / (vec4(1.0) - vec4(2.0) * (blendColor - vec4(0.5))); \n\t\t} \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 19) { //BlendModeDifference \n\t\tlowp vec4 newColor = vec4(abs(srcColor.r - blendColor.r), abs(srcColor.g - blendColor.g), abs(srcColor.b - blendColor.b), 1.0); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 20) { //BlendModeExclusion \n\t\tlowp vec4 newColor = blendColor + srcColor - vec4(2.0)*srcColor*blendColor; \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else { \n\t\treturn srcColor; \n\t} \n  } \n \n lowp vec4 lookupColor(highp vec4 textureColor,sampler2D lookupTexture){ \n highp float blueColor = textureColor.b * 63.0; \n  \n highp vec2 quad1; \n quad1.y = floor(floor(blueColor) / 8.0); \n quad1.x = floor(blueColor) - (quad1.y * 8.0); \n  \n highp vec2 quad2; \n  quad2.y = floor(ceil(blueColor) / 8.0); \n quad2.x = ceil(blueColor) - (quad2.y * 8.0); \n  \n  highp vec2 texPos1; \n texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r); \n texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g); \n  \n highp vec2 texPos2; \n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r); \n texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g); \n  \n lowp vec4 newColor1 = texture2D(lookupTexture, texPos1); \n lowp vec4 newColor2 = texture2D(lookupTexture, texPos2); \n  \n lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor)); \n  \n  return newColor; \n  } \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 originalColor = vec4(textureColor.rgb, 1.0);\n\n     lowp vec4 rgbColor = vec4(textureColor.rgb, 1.0);\n\n     rgbColor = lookupColor(rgbColor, inputImageTextureLUT);\n     lowp vec4 blendColor = texture2D(inputBlendImageTexture, blendTextureCoordinate);\n \n     rgbColor = blend(rgbColor, blendColor, blendMode, blendAlpha);\n \n     gl_FragColor = mix(originalColor, rgbColor, filterLevel);\n     //gl_FragColor = blendColor;\n}");
    }

    private void o()
    {
        if (C[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, C, 0);
            C[0] = -1;
        }
        if (D[0] != -1)
        {
            GLES20.glDeleteTextures(1, D, 0);
            D[0] = -1;
        }
    }

    public void a(float f1)
    {
        n = f1;
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        while (i == 0 || i1 == 0 || p == i && q == i1) 
        {
            return;
        }
        p = i;
        q = i1;
        o();
        a(q, p, C, D);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!this.i)
        {
            return;
        }
        A.a();
        GLES20.glBindFramebuffer(36160, C[0]);
        GLES20.glViewport(0, 0, q, p);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(A.a("position"));
        GLES20.glVertexAttribPointer(A.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(A.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(A.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (!x)
        {
            floatbuffer = new float[8];
            floatbuffer1.get(floatbuffer);
            if (y)
            {
                floatbuffer[0] = z;
                floatbuffer[2] = 1.0F - z;
                floatbuffer[4] = z;
                floatbuffer[6] = 1.0F - z;
            } else
            {
                floatbuffer[1] = Math.abs(floatbuffer[1] - z);
                floatbuffer[3] = Math.abs(floatbuffer[3] - z);
                floatbuffer[5] = Math.abs(floatbuffer[5] - z);
                floatbuffer[7] = Math.abs(floatbuffer[7] - z);
            }
            floatbuffer1 = ByteBuffer.allocateDirect(floatbuffer.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            floatbuffer1.put(floatbuffer).position(0);
            GLES20.glEnableVertexAttribArray(A.a("inputBlendTextureCoordinate"));
            GLES20.glVertexAttribPointer(A.a("inputBlendTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        } else
        {
            floatbuffer1.position(0);
            GLES20.glEnableVertexAttribArray(A.a("inputBlendTextureCoordinate"));
            GLES20.glVertexAttribPointer(A.a("inputBlendTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        }
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(A.b("inputImageTexture"), 0);
        }
        if (s != -1)
        {
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, s);
            GLES20.glUniform1i(A.b("inputImageTextureLUT"), 2);
        }
        if (w != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, w);
            GLES20.glUniform1i(A.b("inputBlendImageTexture"), 1);
        }
        GLES20.glUniform1i(A.b("blendMode"), b(u));
        GLES20.glUniform1f(A.b("blendAlpha"), v);
        GLES20.glUniform1f(A.b("filterLevel"), n);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(A.a("position"));
        GLES20.glDisableVertexAttribArray(A.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    public void a(Bitmap bitmap)
    {
        t = bitmap;
        l();
    }

    public void a(GPUImageBeautyBlendMode gpuimagebeautyblendmode)
    {
        u = gpuimagebeautyblendmode;
    }

    public void a(boolean flag)
    {
        B = flag;
    }

    public void a(boolean flag, Bitmap bitmap, Bitmap bitmap1)
    {
        int i;
        int i1;
label0:
        {
            x = flag;
            if (!x)
            {
                i1 = 3;
                i = 4;
                if (bitmap != null)
                {
                    i1 = bitmap.getWidth();
                    i = bitmap.getHeight();
                }
                int j1 = bitmap1.getWidth();
                int k1 = bitmap1.getHeight();
                float f1 = (float)i1 / (float)i;
                if ((float)j1 / (float)k1 <= f1)
                {
                    break label0;
                }
                y = true;
                z = (1.0F - (float)i1 / (float)i) * 0.5F;
            }
            return;
        }
        y = false;
        z = (1.0F - (float)i / (float)i1) * 0.5F;
    }

    public void b()
    {
        super.b();
        j();
        n();
    }

    public void b(float f1)
    {
        v = f1;
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
        return D[0];
    }

    public void f()
    {
        super.f();
        k();
        m();
        A.a(true);
        o();
    }
}
