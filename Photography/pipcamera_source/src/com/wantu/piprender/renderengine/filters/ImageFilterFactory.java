// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender.renderengine.filters;

import android.content.Context;
import java.util.HashMap;
import wm;
import wn;
import wo;
import wp;
import wq;
import wr;
import ws;
import wt;
import wu;
import wv;
import ww;
import wx;
import wy;
import wz;
import xa;
import xb;
import xc;
import xd;
import xe;
import xf;
import xg;
import xh;
import xi;
import xj;
import xl;
import xm;
import xn;
import xp;
import xq;
import xr;
import xs;
import xt;
import xu;
import xv;
import xw;
import xx;

public class ImageFilterFactory
{

    public static xj a(Context context, TYPE type, HashMap hashmap)
    {
        Object obj = null;
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[TYPE.values().length];
                try
                {
                    a[TYPE.SIMPLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    a[TYPE.GAUSSIANBLUR_HOR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    a[TYPE.GAUSSIANBLUR_VER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    a[TYPE.GAUSSIANBLUR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    a[TYPE.ABAO.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    a[TYPE.ALPHAMASK.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    a[TYPE.BLENDCOLOR.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    a[TYPE.BLOOM.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    a[TYPE.CHANNELMIXER.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    a[TYPE.CHEAPBLOOM.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    a[TYPE.COLORCURVE.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    a[TYPE.COLORLOOKUP.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    a[TYPE.CRTSCANLINE.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    a[TYPE.DREAMVISION.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    a[TYPE.ERODE.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    a[TYPE.EXBLEND.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    a[TYPE.NET_EXBLEND.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    a[TYPE.EXCOLORBLEND.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    a[TYPE.FILMGRAIN.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    a[TYPE.FROSTEDGLASS.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    a[TYPE.GAMMACOLLECTION.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    a[TYPE.LEVELCONTROL.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    a[TYPE.MOTIONBLUR.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[TYPE.RIPPLE.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[TYPE.SCENELOWSATURATION.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[TYPE.SEPIA.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[TYPE.SHARPNESS.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[TYPE.THEMALVISION.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[TYPE.UNSHARPMASK.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[TYPE.AUTUMN.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[TYPE.INVERT.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[TYPE.DESATURATION.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[TYPE.FANTASY.ordinal()] = 33;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[TYPE.SELECTIVEBLUR.ordinal()] = 34;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[TYPE.SKETCH.ordinal()] = 35;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[type.ordinal()];
        JVM INSTR tableswitch 1 35: default 164
    //                   1 180
    //                   2 191
    //                   3 202
    //                   4 213
    //                   5 224
    //                   6 235
    //                   7 246
    //                   8 257
    //                   9 268
    //                   10 279
    //                   11 290
    //                   12 301
    //                   13 312
    //                   14 323
    //                   15 334
    //                   16 345
    //                   17 356
    //                   18 367
    //                   19 378
    //                   20 389
    //                   21 400
    //                   22 411
    //                   23 422
    //                   24 433
    //                   25 444
    //                   26 455
    //                   27 466
    //                   28 477
    //                   29 488
    //                   30 499
    //                   31 510
    //                   32 521
    //                   33 532
    //                   34 543
    //                   35 554;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36
_L1:
        type = obj;
_L38:
        if (type != null)
        {
            type.a(context, hashmap);
        }
        return type;
_L2:
        type = new xu();
        continue; /* Loop/switch isn't completed */
_L3:
        type = new xg();
        continue; /* Loop/switch isn't completed */
_L4:
        type = new xi();
        continue; /* Loop/switch isn't completed */
_L5:
        type = new xh();
        continue; /* Loop/switch isn't completed */
_L6:
        type = new wm();
        continue; /* Loop/switch isn't completed */
_L7:
        type = new wn();
        continue; /* Loop/switch isn't completed */
_L8:
        type = new wp();
        continue; /* Loop/switch isn't completed */
_L9:
        type = new wq();
        continue; /* Loop/switch isn't completed */
_L10:
        type = new wr();
        continue; /* Loop/switch isn't completed */
_L11:
        type = new ws();
        continue; /* Loop/switch isn't completed */
_L12:
        type = new wt();
        continue; /* Loop/switch isn't completed */
_L13:
        type = new wu();
        continue; /* Loop/switch isn't completed */
_L14:
        type = new wv();
        continue; /* Loop/switch isn't completed */
_L15:
        type = new wx();
        continue; /* Loop/switch isn't completed */
_L16:
        type = new wy();
        continue; /* Loop/switch isn't completed */
_L17:
        type = new wz();
        continue; /* Loop/switch isn't completed */
_L18:
        type = new xa();
        continue; /* Loop/switch isn't completed */
_L19:
        type = new xb();
        continue; /* Loop/switch isn't completed */
_L20:
        type = new xd();
        continue; /* Loop/switch isn't completed */
_L21:
        type = new xe();
        continue; /* Loop/switch isn't completed */
_L22:
        type = new xf();
        continue; /* Loop/switch isn't completed */
_L23:
        type = new xm();
        continue; /* Loop/switch isn't completed */
_L24:
        type = new xn();
        continue; /* Loop/switch isn't completed */
_L25:
        type = new xp();
        continue; /* Loop/switch isn't completed */
_L26:
        type = new xq();
        continue; /* Loop/switch isn't completed */
_L27:
        type = new xs();
        continue; /* Loop/switch isn't completed */
_L28:
        type = new xt();
        continue; /* Loop/switch isn't completed */
_L29:
        type = new xw();
        continue; /* Loop/switch isn't completed */
_L30:
        type = new xx();
        continue; /* Loop/switch isn't completed */
_L31:
        type = new wo();
        continue; /* Loop/switch isn't completed */
_L32:
        type = new xl();
        continue; /* Loop/switch isn't completed */
_L33:
        type = new ww();
        continue; /* Loop/switch isn't completed */
_L34:
        type = new xc();
        continue; /* Loop/switch isn't completed */
_L35:
        type = new xr();
        continue; /* Loop/switch isn't completed */
_L36:
        type = new xv();
        if (true) goto _L38; else goto _L37
_L37:
    }

    private class TYPE extends Enum
    {

        private static final TYPE $VALUES[];
        public static final TYPE ABAO;
        public static final TYPE ALPHAMASK;
        public static final TYPE AUTUMN;
        public static final TYPE BLENDCOLOR;
        public static final TYPE BLOOM;
        public static final TYPE CHANNELMIXER;
        public static final TYPE CHEAPBLOOM;
        public static final TYPE COLORCURVE;
        public static final TYPE COLORLOOKUP;
        public static final TYPE CRTSCANLINE;
        public static final TYPE DESATURATION;
        public static final TYPE DREAMVISION;
        public static final TYPE ERODE;
        public static final TYPE EXBLEND;
        public static final TYPE EXCOLORBLEND;
        public static final TYPE FANTASY;
        public static final TYPE FILMGRAIN;
        public static final TYPE FROSTEDGLASS;
        public static final TYPE GAMMACOLLECTION;
        public static final TYPE GAUSSIANBLUR;
        public static final TYPE GAUSSIANBLUR_HOR;
        public static final TYPE GAUSSIANBLUR_VER;
        public static final TYPE INVERT;
        public static final TYPE LEVELCONTROL;
        public static final TYPE MOTIONBLUR;
        public static final TYPE NET_EXBLEND;
        public static final TYPE RIPPLE;
        public static final TYPE SCENELOWSATURATION;
        public static final TYPE SELECTIVEBLUR;
        public static final TYPE SEPIA;
        public static final TYPE SHARPNESS;
        public static final TYPE SIMPLE;
        public static final TYPE SKETCH;
        public static final TYPE THEMALVISION;
        public static final TYPE UNSHARPMASK;

        public static TYPE valueOf(String s)
        {
            return (TYPE)Enum.valueOf(com/wantu/piprender/renderengine/filters/ImageFilterFactory$TYPE, s);
        }

        public static TYPE[] values()
        {
            return (TYPE[])$VALUES.clone();
        }

        static 
        {
            SIMPLE = new TYPE("SIMPLE", 0);
            GAUSSIANBLUR_HOR = new TYPE("GAUSSIANBLUR_HOR", 1);
            GAUSSIANBLUR_VER = new TYPE("GAUSSIANBLUR_VER", 2);
            GAUSSIANBLUR = new TYPE("GAUSSIANBLUR", 3);
            ABAO = new TYPE("ABAO", 4);
            ALPHAMASK = new TYPE("ALPHAMASK", 5);
            BLENDCOLOR = new TYPE("BLENDCOLOR", 6);
            BLOOM = new TYPE("BLOOM", 7);
            CHANNELMIXER = new TYPE("CHANNELMIXER", 8);
            CHEAPBLOOM = new TYPE("CHEAPBLOOM", 9);
            COLORCURVE = new TYPE("COLORCURVE", 10);
            COLORLOOKUP = new TYPE("COLORLOOKUP", 11);
            CRTSCANLINE = new TYPE("CRTSCANLINE", 12);
            DREAMVISION = new TYPE("DREAMVISION", 13);
            ERODE = new TYPE("ERODE", 14);
            EXBLEND = new TYPE("EXBLEND", 15);
            EXCOLORBLEND = new TYPE("EXCOLORBLEND", 16);
            FILMGRAIN = new TYPE("FILMGRAIN", 17);
            FROSTEDGLASS = new TYPE("FROSTEDGLASS", 18);
            GAMMACOLLECTION = new TYPE("GAMMACOLLECTION", 19);
            LEVELCONTROL = new TYPE("LEVELCONTROL", 20);
            MOTIONBLUR = new TYPE("MOTIONBLUR", 21);
            RIPPLE = new TYPE("RIPPLE", 22);
            SCENELOWSATURATION = new TYPE("SCENELOWSATURATION", 23);
            SEPIA = new TYPE("SEPIA", 24);
            SHARPNESS = new TYPE("SHARPNESS", 25);
            THEMALVISION = new TYPE("THEMALVISION", 26);
            UNSHARPMASK = new TYPE("UNSHARPMASK", 27);
            AUTUMN = new TYPE("AUTUMN", 28);
            DESATURATION = new TYPE("DESATURATION", 29);
            INVERT = new TYPE("INVERT", 30);
            NET_EXBLEND = new TYPE("NET_EXBLEND", 31);
            FANTASY = new TYPE("FANTASY", 32);
            SELECTIVEBLUR = new TYPE("SELECTIVEBLUR", 33);
            SKETCH = new TYPE("SKETCH", 34);
            $VALUES = (new TYPE[] {
                SIMPLE, GAUSSIANBLUR_HOR, GAUSSIANBLUR_VER, GAUSSIANBLUR, ABAO, ALPHAMASK, BLENDCOLOR, BLOOM, CHANNELMIXER, CHEAPBLOOM, 
                COLORCURVE, COLORLOOKUP, CRTSCANLINE, DREAMVISION, ERODE, EXBLEND, EXCOLORBLEND, FILMGRAIN, FROSTEDGLASS, GAMMACOLLECTION, 
                LEVELCONTROL, MOTIONBLUR, RIPPLE, SCENELOWSATURATION, SEPIA, SHARPNESS, THEMALVISION, UNSHARPMASK, AUTUMN, DESATURATION, 
                INVERT, NET_EXBLEND, FANTASY, SELECTIVEBLUR, SKETCH
            });
        }

        private TYPE(String s, int i)
        {
            super(s, i);
        }
    }

}
