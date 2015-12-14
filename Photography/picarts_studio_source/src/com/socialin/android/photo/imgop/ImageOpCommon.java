// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop;

import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class ImageOpCommon
{

    public static boolean a;

    public ImageOpCommon()
    {
    }

    public static native double RGBTOHCL(int i, int j, int k);

    public static void a()
    {
        try
        {
            if (a)
            {
                init();
            }
            return;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            return;
        }
    }

    public static native void addOverBufferWithMask(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j);

    public static native ByteBuffer allocNativeBuffer(long l);

    public static native void bathroom1(int ai[], int i, int j);

    public static native void bathroom12(Buffer buffer, Buffer buffer1, int i, int j, float f);

    public static native void bathroom2(int ai[], int ai1[], int i, int j);

    public static native void bathroom22(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void bathroom23(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, float f, 
            float f1);

    public static native void blend(Buffer buffer, Buffer buffer1, int i, int j, int k, int l);

    public static native void blurFilter2(Buffer buffer, Buffer buffer1, int i, int j, int k);

    public static native void blurFilter3(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1);

    public static native void bumpFilter(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void cameraBlend(Buffer buffer, Buffer buffer1, int i, int j, int k);

    public static native void caricature(int ai[], int ai1[], int i, int j, int k, int l, int i1);

    public static native void caricature2(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1);

    public static native void caricature3(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1);

    public static native void centerCropBlend(Buffer buffer, int i, int j, Buffer buffer1, int k, int l, int i1, int j1, 
            boolean flag);

    public static native void changeBufferAlphaChannel(Buffer buffer, int i);

    public static native void changeBufferAlphaChannel1(Buffer buffer, Buffer buffer1, int i);

    public static native void changeBufferAlphaChannelWithAlpha(Buffer buffer, int i, int j);

    public static native void changeBufferAlphaWithSrc(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void changeBufferWithMask(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j);

    public static native void changeChannelsWithCurve(Buffer buffer, Buffer buffer1, int i, int j, int ai[], int ai1[], int ai2[], int ai3[]);

    public static native void changeCircleHSL(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2);

    public static native void changeCirclesHSL(Buffer buffer, Buffer buffer1, int i, int j, int ai[], int ai1[], int ai2[], int ai3[], 
            int ai4[], int ai5[], int ai6[], int k, int l, int i1);

    public static native void changeContrast(Buffer buffer, Buffer buffer1, int i, int j, int k);

    public static native void changeHueSaturation(Buffer buffer, int i, int j, int k, int l, int i1);

    public static native void changeRedEyeRegions(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2);

    public static native void changebufferHSL(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1);

    public static native void changebufferHSLWithCurrentSaturationAndHue(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1);

    public static native void circularBlur(Buffer buffer, Buffer buffer1, int i, int j, float f, float f1, float f2, float f3, 
            float f4);

    public static native int clearWithMask(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j);

    public static native void colorBalance(Buffer buffer, Buffer buffer1, int i, int j, float f, float f1, float f2, float f3, 
            float f4, float f5);

    public static native void colorBalanceNew(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2);

    public static native void colorLevels(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1);

    public static native void contrastStretch(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void convolution2(Buffer buffer, Buffer buffer1, int i, int j, int ai[], int k, int l);

    public static native void convolution3(Buffer buffer, Buffer buffer1, int i, int j, int ai[], int k, int l, int i1, 
            int j1, int k1);

    public static native void copyCirclePixels(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2);

    public static native void customBlend(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j, int k);

    public static native void customCartoon(Buffer buffer, int i, int j, Buffer buffer1, int k, int l, Buffer buffer2, int i1);

    public static native void customOverlayBlend(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void cylinderMirror(int ai[], int ai1[], int i, int j);

    public static native void cylinderMirror2(Buffer buffer, Buffer buffer1, int i, int j, float f);

    public static native void deallocMemory(boolean flag);

    public static native void desaturate(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, float f);

    public static native void effectBlend(Buffer buffer, Buffer buffer1, Buffer buffer2, Buffer buffer3, int i, int j, int k);

    public static native void effectBlend1OrigAlpha(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j, int k);

    public static native void effectBlend1effectAlpha(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j, int k);

    public static native void effectBlendWithAlpha(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j, int k);

    public static native void effectBlendWithStrength(Buffer buffer, Buffer buffer1, int i, int j, int k);

    public static native void effectBlendWithStrength1(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j, int k);

    public static native void fishEye(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1);

    public static native void fishEye2(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1);

    public static native ByteBuffer freeAllNativeBuffers();

    public static native void freeNativeBuffer(ByteBuffer bytebuffer);

    public static native void gammaCorrection(Buffer buffer, int i, int j, float f);

    public static native ByteBuffer getAlphaChannel(ByteBuffer bytebuffer, int i, int j);

    public static native void getCropRect(Buffer buffer, int i, int j, int ai[]);

    public static native void getCropResult(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j, int ai[]);

    public static native void getGrayScaleBuffer(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void getHSLColorPickerImage(Buffer buffer, int i, int j);

    public static native int getPixel(Buffer buffer, int i);

    public static native void getPowerOfTwoSizeBuffer(Buffer buffer, Buffer buffer1, int i, int j, int k, int l);

    public static native void grafit(Buffer buffer, Buffer buffer1, int i, int j, int k);

    public static native void grayscale(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void grayscale2(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1);

    public static native void histoEqualization(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void histoEqualizationLuma(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void init();

    public static native void invertAlphaChannel(Buffer buffer, int i, int j);

    public static native void invertRedMask(Buffer buffer, int i, int j);

    public static native void lensBlur(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void lightCross(Buffer buffer, int i, int j, float f, float f1, float f2);

    public static native void matteFilter(int ai[], int ai1[], int i, int j, float f);

    public static native void meltFilter(Buffer buffer, int i, int j);

    public static native void mirrorWithFlip(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1);

    public static native int moveHue(int i, int j);

    public static native void multiplyWithAlphaChannel(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, ByteBuffer bytebuffer2, int i, int j);

    public static native void negativeFilter(int ai[], int i, int j);

    public static native void negativeFilter2(Buffer buffer, int i, int j);

    public static native void oilFilter(int ai[], int ai1[], int i, int j);

    public static native void oilFilter2(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void oilFilter3(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void oilFilter4(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void outline(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void pixelize2(Buffer buffer, Buffer buffer1, int i, int j, int k, float f);

    public static native void pixelize3(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1);

    public static native void reliefMapFilter(int ai[], int i, int j);

    public static native void reliefMapFilter2(Buffer buffer, int i, int j);

    public static native void resizeBuffer(Buffer buffer, Buffer buffer1, int i, int j, int k, int l);

    public static native void reverseBitmap(Buffer buffer, int i, int j);

    public static native void rotateBuffer(Buffer buffer, Buffer buffer1, int i, int j, int k);

    public static native void sepia(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void shapeBlur(Buffer buffer, Buffer buffer1, int i, int j, int k, float f, int l);

    public static native void sharpen(Buffer buffer, Buffer buffer1, int i, int j, int k);

    public static native void shearFilter(int ai[], int ai1[], int i, int j);

    public static native void shearFilter2(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void shrink(int ai[], int ai1[], int i, int j, float f);

    public static native void smearFilter(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, float f, float f1);

    public static native void solarizationFilter(Buffer buffer, Buffer buffer1, int i, int j);

    public static native void swirled(int ai[], int ai1[], int i, int j, int k, int l, int i1, float f);

    public static native void swirled2(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, float f);

    public static native void swirled3(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, float f);

    public static native void tweethWhiten(Buffer buffer, Buffer buffer1, int i, int j, int k);

    public static native void vignette(Buffer buffer, Buffer buffer1, int i, int j, int k, int l);

    public static native void vignette2(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, float f, float f1);

    public static native void waterFilter(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, float f, 
            float f1);

    public static native void yuv420sp2rgb(Buffer buffer, int i, int j, int k, Buffer buffer1);

    static 
    {
        boolean flag = true;
        a = false;
        try
        {
            System.loadLibrary("imageopcommon");
            init();
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            try
            {
                System.load((new StringBuilder("/data/data/")).append(System.getProperty("packageName")).append("/lib/imageopcommon.so").toString());
                init();
            }
            catch (UnsatisfiedLinkError unsatisfiedlinkerror1)
            {
                Log.e(com/socialin/android/photo/imgop/ImageOpCommon.getSimpleName(), "Can't load \"imageopcommon\" library.");
                Log.e(com/socialin/android/photo/imgop/ImageOpCommon.getSimpleName(), unsatisfiedlinkerror1.getMessage());
                flag = false;
            }
        }
        a = flag;
        Log.e("ex1", (new StringBuilder("ImageOpCommon first load Library = ")).append(a).toString());
    }
}
