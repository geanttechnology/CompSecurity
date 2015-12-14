// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender.renderengine.filters;

import android.content.Context;
import bma;
import bmb;
import bmc;
import bmd;
import bme;
import bmf;
import bmg;
import bmh;
import bmi;
import bmj;
import bmk;
import bml;
import bmm;
import bmn;
import bmo;
import bmp;
import bmq;
import bmr;
import bms;
import bmt;
import bmu;
import bmv;
import bmw;
import bmx;
import bmz;
import bna;
import bnb;
import bnc;
import bne;
import bnf;
import bng;
import bnh;
import bni;
import bnj;
import bnk;
import bnl;
import bnm;
import bnn;
import java.util.HashMap;

public class ImageFilterFactory
{

    public static bmx a(Context context, TYPE type, HashMap hashmap)
    {
        Object obj = null;
        bmz.a[type.ordinal()];
        JVM INSTR tableswitch 1 36: default 168
    //                   1 184
    //                   2 195
    //                   3 206
    //                   4 217
    //                   5 228
    //                   6 239
    //                   7 250
    //                   8 261
    //                   9 272
    //                   10 283
    //                   11 294
    //                   12 305
    //                   13 316
    //                   14 327
    //                   15 338
    //                   16 349
    //                   17 360
    //                   18 371
    //                   19 382
    //                   20 393
    //                   21 404
    //                   22 415
    //                   23 426
    //                   24 437
    //                   25 448
    //                   26 459
    //                   27 470
    //                   28 481
    //                   29 492
    //                   30 503
    //                   31 514
    //                   32 525
    //                   33 536
    //                   34 547
    //                   35 558
    //                   36 569;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37
_L1:
        type = obj;
_L39:
        if (type != null)
        {
            type.a(context, hashmap);
        }
        return type;
_L2:
        type = new bnj();
        continue; /* Loop/switch isn't completed */
_L3:
        type = new bmu();
        continue; /* Loop/switch isn't completed */
_L4:
        type = new bmw();
        continue; /* Loop/switch isn't completed */
_L5:
        type = new bmv();
        continue; /* Loop/switch isn't completed */
_L6:
        type = new bma();
        continue; /* Loop/switch isn't completed */
_L7:
        type = new bmb();
        continue; /* Loop/switch isn't completed */
_L8:
        type = new bmd();
        continue; /* Loop/switch isn't completed */
_L9:
        type = new bme();
        continue; /* Loop/switch isn't completed */
_L10:
        type = new bmf();
        continue; /* Loop/switch isn't completed */
_L11:
        type = new bmg();
        continue; /* Loop/switch isn't completed */
_L12:
        type = new bmh();
        continue; /* Loop/switch isn't completed */
_L13:
        type = new bnl();
        continue; /* Loop/switch isn't completed */
_L14:
        type = new bmi();
        continue; /* Loop/switch isn't completed */
_L15:
        type = new bmj();
        continue; /* Loop/switch isn't completed */
_L16:
        type = new bml();
        continue; /* Loop/switch isn't completed */
_L17:
        type = new bmm();
        continue; /* Loop/switch isn't completed */
_L18:
        type = new bmn();
        continue; /* Loop/switch isn't completed */
_L19:
        type = new bmo();
        continue; /* Loop/switch isn't completed */
_L20:
        type = new bmp();
        continue; /* Loop/switch isn't completed */
_L21:
        type = new bmr();
        continue; /* Loop/switch isn't completed */
_L22:
        type = new bms();
        continue; /* Loop/switch isn't completed */
_L23:
        type = new bmt();
        continue; /* Loop/switch isn't completed */
_L24:
        type = new bnb();
        continue; /* Loop/switch isn't completed */
_L25:
        type = new bnc();
        continue; /* Loop/switch isn't completed */
_L26:
        type = new bne();
        continue; /* Loop/switch isn't completed */
_L27:
        type = new bnf();
        continue; /* Loop/switch isn't completed */
_L28:
        type = new bnh();
        continue; /* Loop/switch isn't completed */
_L29:
        type = new bni();
        continue; /* Loop/switch isn't completed */
_L30:
        type = new bnm();
        continue; /* Loop/switch isn't completed */
_L31:
        type = new bnn();
        continue; /* Loop/switch isn't completed */
_L32:
        type = new bmc();
        continue; /* Loop/switch isn't completed */
_L33:
        type = new bna();
        continue; /* Loop/switch isn't completed */
_L34:
        type = new bmk();
        continue; /* Loop/switch isn't completed */
_L35:
        type = new bmq();
        continue; /* Loop/switch isn't completed */
_L36:
        type = new bng();
        continue; /* Loop/switch isn't completed */
_L37:
        type = new bnk();
        if (true) goto _L39; else goto _L38
_L38:
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
        public static final TYPE SKINTONE;
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
            SKINTONE = new TYPE("SKINTONE", 35);
            $VALUES = (new TYPE[] {
                SIMPLE, GAUSSIANBLUR_HOR, GAUSSIANBLUR_VER, GAUSSIANBLUR, ABAO, ALPHAMASK, BLENDCOLOR, BLOOM, CHANNELMIXER, CHEAPBLOOM, 
                COLORCURVE, COLORLOOKUP, CRTSCANLINE, DREAMVISION, ERODE, EXBLEND, EXCOLORBLEND, FILMGRAIN, FROSTEDGLASS, GAMMACOLLECTION, 
                LEVELCONTROL, MOTIONBLUR, RIPPLE, SCENELOWSATURATION, SEPIA, SHARPNESS, THEMALVISION, UNSHARPMASK, AUTUMN, DESATURATION, 
                INVERT, NET_EXBLEND, FANTASY, SELECTIVEBLUR, SKETCH, SKINTONE
            });
        }

        private TYPE(String s, int i)
        {
            super(s, i);
        }
    }

}
