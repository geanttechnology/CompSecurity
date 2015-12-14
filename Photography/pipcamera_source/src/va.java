// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.piprender.renderengine.filters.BlendMode;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class va
{

    static final boolean a;

    public va()
    {
    }

    public static xj a(Context context, String s)
    {
        xk xk1 = null;
        if (PIPCameraApplication.a(context))
        {
            s = b(context, s);
        } else
        {
            HashMap hashmap = new HashMap();
            Log.v("ImageGLFilterMapping", (new StringBuilder()).append("ImageGLFilterMapping ").append(s).toString());
            Object obj;
            if (s.equals(context.getResources().getString(0x7f060181)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06022b)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SKETCH;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060089)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SELECTIVEBLUR;
                hashmap.put("threshold", Float.valueOf(0.12F));
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_beauty1.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06008d)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SELECTIVEBLUR;
                hashmap.put("threshold", Float.valueOf(0.1F));
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.0F));
                hashmap.put("gamma", Float.valueOf(1.5F));
                hashmap.put("maxInput", Float.valueOf(1.0F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.ERODE;
                hashmap.put("kSize", Integer.valueOf(1));
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601a1)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
                hashmap.put("mapImageAssetPath", "curveMapping/brightpole.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601e6)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_amatuka.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0602af)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
                hashmap.put("mapImageAssetPath", "curveMapping/violet.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06024d)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_rixi.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060122)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
                hashmap.put("mapImageAssetPath", "curveMapping/greenlight.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060167)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_nashville.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06014a)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_lomofi.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("blendImagePath", "curveMapping/x-pro-ii-mask.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06014b)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_classiclomo.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("opacity", Float.valueOf(0.8F));
                hashmap.put("blendImagePath", "lomoclassic.jpg");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060083)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.AUTUMN;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_autumn.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600ed)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06006d)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SELECTIVEBLUR;
                hashmap.put("threshold", Float.valueOf(0.1F));
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL;
                hashmap.put("minInput", Float.valueOf(0.0F));
                hashmap.put("gamma", Float.valueOf(1.5F));
                hashmap.put("maxInput", Float.valueOf(1.0F));
                hashmap.put("minOutput", Float.valueOf(0.0F));
                hashmap.put("maxOutput", Float.valueOf(1.0F));
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_abao.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0602b5)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_xpro.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600ab)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_coffe.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600f6)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_foliage.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060129)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_hefe.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("blendImagePath", "edgeBurn.jpg");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600e1)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_satur.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060121)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_brannan.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060178)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_earlybird.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("blendImagePath", "curveMapping/earlybird_mask.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060098)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_gotham.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600a5)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_xproii.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("blendImagePath", "curveMapping/x-pro-ii-mask.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06023c)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_waldon.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("opacity", Float.valueOf(0.5F));
                hashmap.put("blendImagePath", "curveMapping/waldon_mask.png");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060159)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP;
                hashmap.put("mapImageAssetPath", "curveMapping/lookup_lord_kelvin.png");
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06008e)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.BLOOM;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f06015f)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060182)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                xk1.a(ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SKETCH, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.NORMAL.ordinal()));
                hashmap.put("opacity", Float.valueOf(0.6F));
                hashmap.put("blendSrcLocation", Integer.valueOf(0));
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060177)))
            {
                xk1 = new xk();
                xk1.a(context, null);
                xk1.a(ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.DESATURATION, hashmap));
                hashmap.clear();
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
                hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
                hashmap.put("opacity", Float.valueOf(0.6F));
                hashmap.put("blendImagePath", "filterRes/oldphoto.jpg");
                xk1.a(ImageFilterFactory.a(context, s, hashmap));
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600f1)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060238)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601a0)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600c1)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601b0)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060126)))
            {
                s = null;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600eb)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.FANTASY;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600fe)))
            {
                s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR;
            } else
            if (s.equalsIgnoreCase(context.getResources().getString(0x7f060127)))
            {
                s = null;
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
            s = xk1;
            if (xk1 == null)
            {
                return ImageFilterFactory.a(context, ((com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE) (obj)), hashmap);
            }
        }
        return s;
    }

    public static xj b(Context context, String s)
    {
        Object obj1 = null;
        HashMap hashmap = new HashMap();
        Object obj;
        if (s.equals(context.getResources().getString(0x7f060181)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060089)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/skin.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601a1)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/brightpole.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0601e6)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_amatorka.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0602af)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/violet.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060122)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/greenlight.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060167)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_sutro.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f06014a)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_lomo.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0602b5)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_xpro.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600ab)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_coffee.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600f6)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_foliage.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f0600e1)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_toaster.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060121)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_brannan.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060178)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_earlybird.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060098)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.DESATURATION;
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f06023c)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_walden.png");
        } else
        if (s.equalsIgnoreCase(context.getResources().getString(0x7f060159)))
        {
            s = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE;
            hashmap.put("mapImageAssetPath", "curveMapping/curvemap_lord.png");
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
        s = obj1;
        if (true)
        {
            s = ImageFilterFactory.a(context, ((com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE) (obj)), hashmap);
        }
        return s;
    }

    public static String c(Context context, String s)
    {
        String s1;
        if (s.equalsIgnoreCase("origin") || s.equalsIgnoreCase("original"))
        {
            s1 = context.getResources().getString(0x7f060181);
        } else
        {
            if (s.equalsIgnoreCase("Beauty"))
            {
                return context.getResources().getString(0x7f060089);
            }
            if (s.equalsIgnoreCase("BigEyes"))
            {
                return context.getResources().getString(0x7f06008d);
            }
            if (s.equalsIgnoreCase("Pole"))
            {
                return context.getResources().getString(0x7f0601a1);
            }
            if (s.equalsIgnoreCase("Violet"))
            {
                return context.getResources().getString(0x7f0602af);
            }
            if (s.equalsIgnoreCase("Sweet"))
            {
                return context.getResources().getString(0x7f06024d);
            }
            if (s.equalsIgnoreCase("Greenlight"))
            {
                return context.getResources().getString(0x7f060122);
            }
            if (s.equalsIgnoreCase("Nashville"))
            {
                return context.getResources().getString(0x7f060167);
            }
            if (s.equalsIgnoreCase("Lomo"))
            {
                return context.getResources().getString(0x7f06014a);
            }
            if (s.equalsIgnoreCase("Lomo-C"))
            {
                return context.getResources().getString(0x7f06014b);
            }
            if (s.equalsIgnoreCase("Autumn"))
            {
                return context.getResources().getString(0x7f060083);
            }
            if (s.equalsIgnoreCase("Film"))
            {
                return context.getResources().getString(0x7f0600ed);
            }
            if (s.equalsIgnoreCase("AB-Color"))
            {
                return context.getResources().getString(0x7f06006d);
            }
            if (s.equalsIgnoreCase("X-Pro"))
            {
                return context.getResources().getString(0x7f0602b5);
            }
            if (s.equalsIgnoreCase("Coffee"))
            {
                return context.getResources().getString(0x7f0600ab);
            }
            if (s.equalsIgnoreCase("Foliage"))
            {
                return context.getResources().getString(0x7f0600f6);
            }
            if (s.equalsIgnoreCase("Hefe"))
            {
                return context.getResources().getString(0x7f060129);
            }
            if (s.equalsIgnoreCase("Elegant"))
            {
                return context.getResources().getString(0x7f0600e1);
            }
            if (s.equalsIgnoreCase("Old Time"))
            {
                return context.getResources().getString(0x7f060178);
            }
            if (s.equalsIgnoreCase("B&W") || s.equalsIgnoreCase("BW"))
            {
                return context.getResources().getString(0x7f060098);
            }
            if (s.equalsIgnoreCase("Classic"))
            {
                return context.getResources().getString(0x7f0600a5);
            }
            if (s.equalsIgnoreCase("Star"))
            {
                return context.getResources().getString(0x7f06023c);
            }
            if (s.equalsIgnoreCase("Memory"))
            {
                return context.getResources().getString(0x7f060159);
            }
            if (s.equalsIgnoreCase("Sketch"))
            {
                return context.getResources().getString(0x7f06022b);
            }
            if (s.equalsIgnoreCase("Paint"))
            {
                return context.getResources().getString(0x7f060182);
            }
            if (s.equalsIgnoreCase("HDR"))
            {
                return context.getResources().getString(0x7f060126);
            }
            if (s.equalsIgnoreCase("Monroe"))
            {
                return context.getResources().getString(0x7f06015f);
            }
            if (s.equalsIgnoreCase("Gorgeous"))
            {
                return context.getResources().getString(0x7f060121);
            }
            if (s.equalsIgnoreCase("Fantasy"))
            {
                return context.getResources().getString(0x7f0600eb);
            }
            s1 = s;
            if (s.equalsIgnoreCase("Foliage"))
            {
                return context.getResources().getString(0x7f0600f6);
            }
        }
        return s1;
    }

    static 
    {
        boolean flag;
        if (!va.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
