// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.piprender.renderengine.filters.BlendMode;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class bku
{

    static final boolean a;

    public bku()
    {
    }

    public static bmx a(Context context, String s)
    {
        bmy bmy1 = null;
        InstaBeautyApplication.a();
        if (InstaBeautyApplication.d())
        {
            s = b(context, s);
        } else
        {
            HashMap hashmap = new HashMap();
            Log.v("ImageGLFilterMapping", s);
            Object obj;
            if (s.equals(context.getResources().getString(0x7f0601a0)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06025e)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SKETCH;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06004a)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SKINTONE;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/defaultSkinToneLUT.png");
                hashmap.put("index", Integer.valueOf(1));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06004b)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SKINTONE;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/defaultSkinToneLUT.png");
                hashmap.put("index", Integer.valueOf(2));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06004c)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SKINTONE;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/defaultSkinToneLUT.png");
                hashmap.put("index", Integer.valueOf(3));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06004d)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SKINTONE;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/defaultSkinToneLUT.png");
                hashmap.put("index", Integer.valueOf(4));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06008c)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
                hashmap.put("threshold", Float.valueOf(0.12F));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_beauty1.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060090)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
                hashmap.put("threshold", Float.valueOf(0.1F));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.0F));
                hashmap.put("gamma", Float.valueOf(1.5F));
                hashmap.put("maxInput", Float.valueOf(1.0F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.ERODE;
                hashmap.put("kSize", Integer.valueOf(1));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601c1)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/04_rg.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06020c)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/filter_6.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060138)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/23_nimin.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0602f3)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
                hashmap.put("mapImageAssetPath", "curveMapping/violet.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060059)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/02_abao.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060091)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/01_tm.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060031)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/filter_4.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06017e)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/09_fl.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06009d)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/03_bw.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06027c)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/04_rg.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060066)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/07_nn.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600cc)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/06_ld.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06027d)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/07_nn.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060281)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/01_tm.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060044)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/filter_3.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06003c)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/05_zr.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060045)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/00_lb.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06005f)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/filter_3.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060282)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
                hashmap.put("threshold", Float.valueOf(0.1F));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_rixi.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060135)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
                hashmap.put("mapImageAssetPath", "curveMapping/greenlight.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060184)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_nashville.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06015f)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_lomofi.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("blendImagePath", "curveMapping/x-pro-ii-mask.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060160)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_classiclomo.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("opacity", Float.valueOf(0.8F));
                hashmap.put("blendImagePath", "lomoclassic.jpg");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060086)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.AUTUMN;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_autumn.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600ff)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060067)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/02_abao.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0602fb)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_xpro.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600b5)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_coffe.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060108)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_foliage.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06013c)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_hefe.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("blendImagePath", "edgeBurn.jpg");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600f1)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_satur.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060134)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_brannan.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060198)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_earlybird.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("blendImagePath", "curveMapping/earlybird_mask.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06009e)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/03_bw.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060042)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "fotobeauty/filter/Libra.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600b0)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_xproii.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("blendImagePath", "curveMapping/x-pro-ii-mask.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060271)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_waldon.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("opacity", Float.valueOf(0.5F));
                hashmap.put("blendImagePath", "curveMapping/waldon_mask.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600c6)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
                hashmap.put("threshold", Float.valueOf(0.1F));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.0F));
                hashmap.put("gamma", Float.valueOf(1.5F));
                hashmap.put("maxInput", Float.valueOf(1.0F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_waldon.png");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06016f)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_lord_kelvin.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06017a)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601a1)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                bmy1.a(ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SKETCH, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.NORMAL.ordinal()));
                hashmap.put("opacity", Float.valueOf(0.6F));
                hashmap.put("blendSrcLocation", Integer.valueOf(0));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060197)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                bmy1.a(ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.DESATURATION, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("opacity", Float.valueOf(0.6F));
                hashmap.put("blendImagePath", "filterRes/oldphoto.jpg");
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060103)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06026d)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601c0)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600cf)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601d3)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060139)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600fd)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.FANTASY;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060111)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06013a)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060147)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.06666667F));
                hashmap.put("gamma", Float.valueOf(1.0F));
                hashmap.put("maxInput", Float.valueOf(0.7529412F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060163)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SCENELOWSATURATION;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600d3)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.05490196F));
                hashmap.put("gamma", Float.valueOf(0.64F));
                hashmap.put("maxInput", Float.valueOf(1.0F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060097)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.0F));
                hashmap.put("gamma", Float.valueOf(1.5F));
                hashmap.put("maxInput", Float.valueOf(0.7921569F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600f2)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.UNSHARPMASK;
                hashmap.put("strength", Float.valueOf(0.8F));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.1372549F));
                hashmap.put("gamma", Float.valueOf(1.2F));
                hashmap.put("maxInput", Float.valueOf(0.9803922F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06008b)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.1176471F));
                hashmap.put("gamma", Float.valueOf(1.2F));
                hashmap.put("maxInput", Float.valueOf(0.9098039F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06018b)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.05882353F));
                hashmap.put("gamma", Float.valueOf(1.8F));
                hashmap.put("maxInput", Float.valueOf(0.7568628F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06010a)))
            {
                bmy1 = new bmy();
                bmy1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.1215686F));
                hashmap.put("gamma", Float.valueOf(1.14F));
                hashmap.put("maxInput", Float.valueOf(0.8862745F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
                hashmap.put("blendColor", Integer.valueOf(Color.argb(51, 233, 137, 0)));
                bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060102)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.0F));
                hashmap.put("gamma", Float.valueOf(0.81F));
                hashmap.put("maxInput", Float.valueOf(0.7058824F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
            } else
            {
                if (!a)
                {
                    throw new AssertionError();
                }
                s = null;
            }
            obj = s;
            if (s == null)
            {
                obj = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
            }
            s = bmy1;
            if (bmy1 == null)
            {
                return ImageFilterFactory.a(context, ((com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE) (obj)), hashmap);
            }
        }
        return s;
    }

    public static bmx b(Context context, String s)
    {
        bmy bmy1 = null;
        HashMap hashmap = new HashMap();
        Object obj;
        if (s.equals(context.getResources().getString(0x7f0601a0)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f06008c)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/skin.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601c1)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "fotobeauty/filter/04_rg.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f06020c)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "fotobeauty/filter/11_ql.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0602f3)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/violet.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0602f3)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/violet.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060135)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/greenlight.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060184)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_sutro.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f06015f)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_lomo.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0602fb)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_xpro.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600b5)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_coffee.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060108)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_foliage.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600f1)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_toaster.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060134)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_brannan.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060198)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_earlybird.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f06009d)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
            hashmap.put("mapImageAssetPath", "fotobeauty/filter/03_bw.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060042)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
            hashmap.put("mapImageAssetPath", "fotobeauty/filter/Libra.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060271)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_walden.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f06016f)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_lord.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060163)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SCENELOWSATURATION;
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600d3)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
            hashmap.put("minInput", Float.valueOf(0.05490196F));
            hashmap.put("gamma", Float.valueOf(0.64F));
            hashmap.put("maxInput", Float.valueOf(1.0F));
            hashmap.put("minOutput", Float.valueOf(0.0F));
            hashmap.put("maxOutput", Float.valueOf(1.0F));
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060097)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
            hashmap.put("minInput", Float.valueOf(0.0F));
            hashmap.put("gamma", Float.valueOf(1.5F));
            hashmap.put("maxInput", Float.valueOf(0.7921569F));
            hashmap.put("minOutput", Float.valueOf(0.0F));
            hashmap.put("maxOutput", Float.valueOf(1.0F));
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600f2)))
        {
            bmy1 = new bmy();
            bmy1.a(context, null);
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.UNSHARPMASK;
            hashmap.put("strength", Float.valueOf(0.8F));
            bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            hashmap.clear();
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
            hashmap.put("minInput", Float.valueOf(0.1372549F));
            hashmap.put("gamma", Float.valueOf(1.2F));
            hashmap.put("maxInput", Float.valueOf(0.9803922F));
            hashmap.put("minOutput", Float.valueOf(0.0F));
            hashmap.put("maxOutput", Float.valueOf(1.0F));
            bmy1.a(ImageFilterFactory.a(context, s, hashmap));
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f06008b)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
            hashmap.put("minInput", Float.valueOf(0.1176471F));
            hashmap.put("gamma", Float.valueOf(1.2F));
            hashmap.put("maxInput", Float.valueOf(0.9098039F));
            hashmap.put("minOutput", Float.valueOf(0.0F));
            hashmap.put("maxOutput", Float.valueOf(1.0F));
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f06018b)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
            hashmap.put("minInput", Float.valueOf(0.05882353F));
            hashmap.put("gamma", Float.valueOf(1.8F));
            hashmap.put("maxInput", Float.valueOf(0.7568628F));
            hashmap.put("minOutput", Float.valueOf(0.0F));
            hashmap.put("maxOutput", Float.valueOf(1.0F));
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f06010a)))
        {
            bmy1 = new bmy();
            bmy1.a(context, null);
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
            hashmap.put("minInput", Float.valueOf(0.1215686F));
            hashmap.put("gamma", Float.valueOf(1.14F));
            hashmap.put("maxInput", Float.valueOf(0.8862745F));
            hashmap.put("minOutput", Float.valueOf(0.0F));
            hashmap.put("maxOutput", Float.valueOf(1.0F));
            bmy1.a(ImageFilterFactory.a(context, s, hashmap));
            hashmap.clear();
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
            hashmap.put("blendColor", Integer.valueOf(Color.argb(51, 233, 137, 0)));
            bmy1.a(ImageFilterFactory.a(context, s, hashmap));
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060102)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
            hashmap.put("minInput", Float.valueOf(0.0F));
            hashmap.put("gamma", Float.valueOf(0.81F));
            hashmap.put("maxInput", Float.valueOf(0.7058824F));
            hashmap.put("minOutput", Float.valueOf(0.0F));
            hashmap.put("maxOutput", Float.valueOf(1.0F));
        } else
        {
            if (!a)
            {
                throw new AssertionError();
            }
            s = null;
        }
        obj = s;
        if (s == null)
        {
            obj = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
        }
        s = bmy1;
        if (bmy1 == null)
        {
            s = ImageFilterFactory.a(context, ((com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE) (obj)), hashmap);
        }
        return s;
    }

    public static String c(Context context, String s)
    {
        String s1;
        if (s.equalsIgnoreCase("Beauty"))
        {
            s1 = context.getResources().getString(0x7f06008c);
        } else
        {
            if (s.equalsIgnoreCase("BigEyes"))
            {
                return context.getResources().getString(0x7f060090);
            }
            if (s.equalsIgnoreCase("Pole"))
            {
                return context.getResources().getString(0x7f0601c1);
            }
            if (s.equalsIgnoreCase("Violet"))
            {
                return context.getResources().getString(0x7f0602f3);
            }
            if (s.equalsIgnoreCase("Sweet"))
            {
                return context.getResources().getString(0x7f060281);
            }
            if (s.equalsIgnoreCase("Greenlight"))
            {
                return context.getResources().getString(0x7f060135);
            }
            if (s.equalsIgnoreCase("Nashville"))
            {
                return context.getResources().getString(0x7f060184);
            }
            if (s.equalsIgnoreCase("Lomo"))
            {
                return context.getResources().getString(0x7f06015f);
            }
            if (s.equalsIgnoreCase("Lomo-C"))
            {
                return context.getResources().getString(0x7f060160);
            }
            if (s.equalsIgnoreCase("Autumn"))
            {
                return context.getResources().getString(0x7f060086);
            }
            if (s.equalsIgnoreCase("Film"))
            {
                return context.getResources().getString(0x7f0600ff);
            }
            if (s.equalsIgnoreCase("AB-Color"))
            {
                return context.getResources().getString(0x7f060067);
            }
            if (s.equalsIgnoreCase("X-Pro"))
            {
                return context.getResources().getString(0x7f0602fb);
            }
            if (s.equalsIgnoreCase("Coffee"))
            {
                return context.getResources().getString(0x7f0600b5);
            }
            if (s.equalsIgnoreCase("Foliage"))
            {
                return context.getResources().getString(0x7f060108);
            }
            if (s.equalsIgnoreCase("Hefe"))
            {
                return context.getResources().getString(0x7f06013c);
            }
            if (s.equalsIgnoreCase("Elegant"))
            {
                return context.getResources().getString(0x7f0600f1);
            }
            if (s.equalsIgnoreCase("Old Time"))
            {
                return context.getResources().getString(0x7f060198);
            }
            if (s.equalsIgnoreCase("B&W") || s.equalsIgnoreCase("BW"))
            {
                return context.getResources().getString(0x7f06009d);
            }
            if (s.equalsIgnoreCase("Classic"))
            {
                return context.getResources().getString(0x7f0600b0);
            }
            if (s.equalsIgnoreCase("Star"))
            {
                return context.getResources().getString(0x7f060271);
            }
            if (s.equalsIgnoreCase("Memory"))
            {
                return context.getResources().getString(0x7f06016f);
            }
            if (s.equalsIgnoreCase("Sketch"))
            {
                return context.getResources().getString(0x7f06025e);
            }
            if (s.equalsIgnoreCase("Paint"))
            {
                return context.getResources().getString(0x7f0601a1);
            }
            if (s.equalsIgnoreCase("HDR"))
            {
                return context.getResources().getString(0x7f060139);
            }
            s1 = s;
            if (s.equalsIgnoreCase("Monroe"))
            {
                return context.getResources().getString(0x7f06017a);
            }
        }
        return s1;
    }

    public static jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE d(Context context, String s)
    {
        if (!s.equalsIgnoreCase(context.getResources().getString(0x7f0601a0)))
        {
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06004a)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF1;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06004b)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF2;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06004c)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF3;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06004d)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF4;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06004e)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF5;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06004f)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF6;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060050)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF7;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060051)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF8;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060052)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF9;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060045)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_LIANGBAI;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060138)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_MENGLONG;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060281)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_TIANMI;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060067)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_ABAO;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06005f)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_XIARI;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06003c)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_QINGXIN;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600cc)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_QINGSHUANG;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601c1)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_LIANGLI;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06017e)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_XIAOQINGXIN;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06020c)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_JINGMI;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060033)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_HEIBAI;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060066)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_LUANFENG;
            }
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060042)))
            {
                return jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_ABAO_LIBRA;
            }
        }
        return null;
    }

    static 
    {
        boolean flag;
        if (!bku.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
