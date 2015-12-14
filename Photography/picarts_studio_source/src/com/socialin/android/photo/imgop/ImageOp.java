// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop;

import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;

// Referenced classes of package com.socialin.android.photo.imgop:
//            ImageOpCommon

public class ImageOp
{

    public static boolean a = false;
    private static Object b = new Object();

    public ImageOp()
    {
    }

    public static int a()
    {
        int i;
        synchronized (b)
        {
            i = obtainEffectInstanceIdentifier();
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static ByteBuffer a(long l)
    {
        return ImageOpCommon.allocNativeBuffer(l);
    }

    public static void a(int i)
    {
        synchronized (b)
        {
            releaseEffectInstanceIdentifier(i);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void a(ByteBuffer bytebuffer)
    {
        ImageOpCommon.freeNativeBuffer(bytebuffer);
    }

    public static native void acquarello4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag, int i2);

    public static native void acquarello4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native boolean acquarello4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native void applyMask8ForBuffer8888(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int i, int j);

    public static void b()
    {
        try
        {
            if (a)
            {
                initInterruptFlags();
            }
            return;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            return;
        }
    }

    public static native void bleaching4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, Buffer buffer2, int i1, 
            int j1, int k1, int l1, int i2, int j2, boolean flag, int k2);

    public static native void bleaching4mix(String s, Buffer buffer, int i, int j, String s1, int k, int l, int i1, 
            int j1, boolean flag, int k1);

    public static native boolean bleaching4path(String s, String s1, int i, int j, String s2, int k, int l, int i1, 
            int j1, boolean flag, int k1);

    public static native void blemishfix4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, boolean flag, int j2);

    public static native void blemishfix4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            int k1, boolean flag, int l1);

    public static native boolean blemishfix4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            int k1, boolean flag, int l1);

    public static native void blend4buf(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j, int k, Buffer buffer3, int l, 
            int i1);

    public static native void blend4mix(String s, String s1, String s2, int i, Buffer buffer, int j, int k);

    public static native boolean blend4mix2(Buffer buffer, Buffer buffer1, Buffer buffer2, int i, int j, int k, String s, int l, 
            int i1);

    public static native boolean blend4path(String s, String s1, String s2, int i, String s3, int j, int k);

    public static native void bw4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native void bw4mix(String s, Buffer buffer, int i, int j, int k, int l, boolean flag, int i1);

    public static native boolean bw4path(String s, String s1, int i, int j, int k, int l, boolean flag, int i1);

    public static native void cartoonizer4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, boolean flag, int k2);

    public static native void cartoonizer4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag, int i2);

    public static native boolean cartoonizer4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag, int i2);

    public static native void cinerama4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void cinerama4mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean cinerama4path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void comicboom4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, Buffer buffer2, int i1, 
            int j1, int k1, int l1, int i2, boolean flag, int j2);

    public static native void comicboom4mix(String s, Buffer buffer, int i, int j, String s1, int k, int l, int i1, 
            boolean flag, int j1);

    public static native boolean comicboom4path(String s, String s1, int i, int j, String s2, int k, int l, int i1, 
            boolean flag, int j1);

    public static native void contours4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag, int i2);

    public static native void contours4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native boolean contours4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native void copyPartBuffer888(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int i, int j, int k, int l, int ai[], int ai1[], 
            int i1, int j1);

    public static native void crossprocess4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native void crossprocess4mix(String s, Buffer buffer, int i, int j, int k, int l, boolean flag, int i1);

    public static native boolean crossprocess4path(String s, String s1, int i, int j, int k, int l, boolean flag, int i1);

    public static native void crossprocessing4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, double d, 
            double d1, int i1, int j1, boolean flag, int k1);

    public static native void crossprocessing4mix(String s, Buffer buffer, int i, int j, double d, double d1, 
            int k, int l, boolean flag, int i1);

    public static native boolean crossprocessing4path(String s, String s1, int i, int j, double d, double d1, 
            int k, int l, boolean flag, int i1);

    public static native void customenhance4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, float f, float f1, 
            int i1, boolean flag, int j1);

    public static native void customenhance4mix(String s, Buffer buffer, int i, int j, float f, float f1, int k, boolean flag, 
            int l);

    public static native boolean customenhance4path(String s, String s1, int i, int j, float f, float f1, int k, boolean flag, 
            int l);

    public static native void drawLine8(ByteBuffer bytebuffer, int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1);

    public static native void dusk4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void dusk4mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean dusk4path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void effect124buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void effect124mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean effect124path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void effect134buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void effect134mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean effect134path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void effect144buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void effect144mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean effect144path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void effect244buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void effect244mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean effect244path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void effect404buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void effect404mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean effect404path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void effect44buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void effect44mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean effect44path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void effect74buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void effect74mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean effect74path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void facedetector4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, double d, 
            boolean flag, boolean flag1);

    public static native void facedetector4mix(String s, Buffer buffer, int i, int j, double d, boolean flag, boolean flag1);

    public static native boolean facedetector4path(String s, String s1, int i, int j, double d, boolean flag, boolean flag1);

    public static native void fattal4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, double d, 
            double d1, double d2, double d3, int i1, 
            int j1, int k1, int l1, boolean flag, int i2);

    public static native void fattal4mix(String s, Buffer buffer, int i, int j, double d, double d1, 
            double d2, double d3, int k, int l, int i1, 
            int j1, boolean flag, int k1);

    public static native boolean fattal4path(String s, String s1, int i, int j, double d, double d1, 
            double d2, double d3, int k, int l, int i1, 
            int j1, boolean flag, int k1);

    public static native void fill8(Buffer buffer, int i, int j, int k);

    public static native void focalsoften4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, boolean flag, int l2);

    public static native void focalsoften4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, boolean flag, int j2);

    public static native boolean focalsoften4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, boolean flag, int j2);

    public static native void focalzoom4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, boolean flag, int l2);

    public static native void focalzoom4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, boolean flag, int j2);

    public static native boolean focalzoom4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, boolean flag, int j2);

    public static native void getBoundingBox8(ByteBuffer bytebuffer, int i, int j, int ai[]);

    public static native void getSubBuffer(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int i, int j, int ai[]);

    public static native void getSubBuffer8(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int i, int j, int ai[]);

    public static native void grannyspaper4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, Buffer buffer2, int i1, 
            int j1, Buffer buffer3, int k1, int l1, int i2, int j2, int k2, 
            int l2, boolean flag, int i3);

    public static native void grannyspaper4mix(String s, Buffer buffer, int i, int j, String s1, String s2, int k, int l, 
            int i1, int j1, boolean flag, int k1);

    public static native boolean grannyspaper4path(String s, String s1, int i, int j, String s2, String s3, int k, int l, 
            int i1, int j1, boolean flag, int k1);

    public static native void halftonedots4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, boolean flag, int l1);

    public static native void halftonedots4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native boolean halftonedots4path(String s, String s1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void hdr4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, double d, double d1, int j1, int k1, boolean flag, int l1);

    public static native void hdr4mix(String s, Buffer buffer, int i, int j, int k, double d, double d1, int l, int i1, boolean flag, int j1);

    public static native boolean hdr4path(String s, String s1, int i, int j, int k, double d, double d1, int l, int i1, boolean flag, int j1);

    public static native void holgaart14buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, boolean flag, int l1);

    public static native void holgaart14mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native boolean holgaart14path(String s, String s1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void holgaart4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, Buffer buffer2, int l1, int i2, int j2, boolean flag, int k2);

    public static native void holgaart4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, String s1, 
            int j1, boolean flag, int k1);

    public static native boolean holgaart4path(String s, String s1, int i, int j, int k, int l, int i1, String s2, 
            int j1, boolean flag, int k1);

    private static native void initInterruptFlags();

    public static native boolean initfacedetector(String s);

    public static native void interruptEffectInstance(int i);

    public static native void invertColorInplace(Buffer buffer, int i);

    public static native void lensblur4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, boolean flag, int k2);

    public static native void lensblur4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag, int i2);

    public static native boolean lensblur4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag, int i2);

    public static native ByteBuffer load(String s, int i, int j, int k, int ai[], boolean flag);

    public static native ByteBuffer loadGray(String s, int i, int j, int k, int ai[]);

    public static native void lomo4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, double d, 
            double d1, double d2, int i1, int j1, boolean flag, 
            int k1);

    public static native void lomo4mix(String s, Buffer buffer, int i, int j, double d, double d1, 
            double d2, int k, int l, boolean flag, int i1);

    public static native boolean lomo4path(String s, String s1, int i, int j, double d, double d1, 
            double d2, int k, int l, boolean flag, int i1);

    public static native void motionblur4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1, int l1, int i2, int j2, int k2, boolean flag1, 
            int l2);

    public static native void motionblur4mix(String s, Buffer buffer, int i, int j, int k, int l, boolean flag, int i1, 
            int j1, int k1, int l1, int i2, boolean flag1, int j2);

    public static native boolean motionblur4path(String s, String s1, int i, int j, int k, int l, boolean flag, int i1, 
            int j1, int k1, int l1, int i2, boolean flag1, int j2);

    public static native void neoncola4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag, int i2);

    public static native void neoncola4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native boolean neoncola4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    private static native int obtainEffectInstanceIdentifier();

    public static native void orton4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag, int i2);

    public static native void orton4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native boolean orton4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native void pastelperfect4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, Buffer buffer2, int i1, 
            int j1, int k1, int l1, int i2, int j2, boolean flag, int k2);

    public static native void pastelperfect4mix(String s, Buffer buffer, int i, int j, String s1, int k, int l, int i1, 
            int j1, boolean flag, int k1);

    public static native boolean pastelperfect4path(String s, String s1, int i, int j, String s2, int k, int l, int i1, 
            int j1, boolean flag, int k1);

    public static native void pencil4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, double d, 
            double d1, double d2, int i1, boolean flag, int j1);

    public static native void pencil4mix(String s, Buffer buffer, int i, int j, double d, double d1, 
            double d2, int k, boolean flag, int l);

    public static native boolean pencil4path(String s, String s1, int i, int j, double d, double d1, 
            double d2, int k, boolean flag, int l);

    public static native void polygonize4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, float f, int i1, 
            boolean flag, int j1);

    public static native void polygonize4mix(String s, Buffer buffer, int i, int j, float f, int k, boolean flag, int l);

    public static native boolean polygonize4path(String s, String s1, int i, int j, float f, int k, boolean flag, int l);

    public static native void posterize4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, boolean flag, int l1);

    public static native void posterize4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native boolean posterize4path(String s, String s1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void pyramidnoisereduction4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, float f, float f1, 
            float f2, float f3, float f4, int i1, boolean flag, int j1);

    public static native void pyramidnoisereduction4mix(String s, Buffer buffer, int i, int j, float f, float f1, float f2, float f3, 
            float f4, int k, boolean flag, int l);

    public static native boolean pyramidnoisereduction4path(String s, String s1, int i, int j, float f, float f1, float f2, float f3, 
            float f4, int k, boolean flag, int l);

    public static native void redeyeremoval4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            double d, double d1);

    public static native void redeyeremoval4mix(String s, Buffer buffer, int i, int j, int k, int l, double d, 
            double d1);

    public static native boolean redeyeremoval4path(String s, String s1, int i, int j, int k, int l, double d, 
            double d1);

    private static native void releaseEffectInstanceIdentifier(int i);

    public static native void resize(ByteBuffer bytebuffer, int i, int j, ByteBuffer bytebuffer1, int k, int l, int i1);

    public static native void seafoamlightcross4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void seafoamlightcross4mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean seafoamlightcross4path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void sharpendodger4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void sharpendodger4mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean sharpendodger4path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void sketcher4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, boolean flag, 
            int i3);

    public static native void sketcher4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, boolean flag, int k2);

    public static native boolean sketcher4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, boolean flag, int k2);

    public static native void sketchup4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, Buffer buffer2, int i1, 
            int j1, int k1, int l1, int i2, int j2, boolean flag, int k2);

    public static native void sketchup4mix(String s, Buffer buffer, int i, int j, String s1, int k, int l, int i1, 
            int j1, boolean flag, int k1);

    public static native boolean sketchup4path(String s, String s1, int i, int j, String s2, int k, int l, int i1, 
            int j1, boolean flag, int k1);

    public static native void smartblur4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, boolean flag, int l1);

    public static native void smartblur4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native boolean smartblur4path(String s, String s1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void soften4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native void soften4mix(String s, Buffer buffer, int i, int j, int k, int l, boolean flag, int i1);

    public static native boolean soften4path(String s, String s1, int i, int j, int k, int l, boolean flag, int i1);

    public static native void stenciler4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, double d, 
            int i1, int j1, double d1, int k1, Buffer buffer2, int l1, 
            int i2, int j2, boolean flag, int k2);

    public static native void stenciler4mix(String s, Buffer buffer, int i, int j, double d, int k, int l, 
            double d1, int i1, String s1, int j1, boolean flag, int k1);

    public static native boolean stenciler4path(String s, String s1, int i, int j, double d, int k, int l, 
            double d1, int i1, String s2, int j1, boolean flag, int k1);

    public static native void sunlesstan4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native void sunlesstan4mix(String s, Buffer buffer, int i, int j, int k, int l, boolean flag, int i1);

    public static native boolean sunlesstan4path(String s, String s1, int i, int j, int k, int l, boolean flag, int i1);

    public static native void tranquil4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, boolean flag, int l1);

    public static native void tranquil4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native boolean tranquil4path(String s, String s1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void unitedcolors4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag, int i2);

    public static native void unitedcolors4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native boolean unitedcolors4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native void vignette4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag, int i2);

    public static native void vignette4mix(String s, Buffer buffer, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native boolean vignette4path(String s, String s1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native void vintage4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, double d, 
            int i1, int j1, boolean flag, int k1);

    public static native void vintage4mix(String s, Buffer buffer, int i, int j, double d, int k, int l, 
            boolean flag, int i1);

    public static native boolean vintage4path(String s, String s1, int i, int j, double d, int k, int l, 
            boolean flag, int i1);

    public static native void vintageivory4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void vintageivory4mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean vintageivory4path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void warmingamber4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, boolean flag, 
            int j1);

    public static native void warmingamber4mix(String s, Buffer buffer, int i, int j, int k, boolean flag, int l);

    public static native boolean warmingamber4path(String s, String s1, int i, int j, int k, boolean flag, int l);

    public static native void yestercolor4buf(Buffer buffer, Buffer buffer1, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, int k1);

    public static native void yestercolor4mix(String s, Buffer buffer, int i, int j, int k, int l, boolean flag, int i1);

    public static native boolean yestercolor4path(String s, String s1, int i, int j, int k, int l, boolean flag, int i1);

    static 
    {
        try
        {
            System.loadLibrary("imageop");
            initInterruptFlags();
            a = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            try
            {
                System.load((new StringBuilder("/data/data/")).append(System.getProperty("packageName")).append("/lib/imageop.so").toString());
                initInterruptFlags();
                a = true;
            }
            catch (UnsatisfiedLinkError unsatisfiedlinkerror1)
            {
                Log.e(com/socialin/android/photo/imgop/ImageOpCommon.getSimpleName(), "Can't load \"imageop\" library.");
                Log.e(com/socialin/android/photo/imgop/ImageOpCommon.getSimpleName(), unsatisfiedlinkerror1.getMessage());
            }
        }
    }
}
