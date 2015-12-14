// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.content.Context;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import com.socialin.android.util.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{

    private static final HashMap i = new EffectsAditionalInfo._cls2();
    private static final HashMap j = new EffectsAditionalInfo._cls3();
    private static final HashMap l = new EffectsAditionalInfo._cls5();
    private static ArrayList q = new EffectsAditionalInfo._cls7();
    public HashMap a;
    public HashMap b;
    public HashMap c;
    public HashMap d;
    public HashMap e;
    public HashMap f;
    public HashMap g;
    public HashMap h;
    private final HashMap k = new EffectsAditionalInfo._cls4();
    private JSONObject m;
    private HashMap n;
    private HashMap o;
    private HashMap p;

    public b(Context context)
    {
        a = new EffectsAditionalInfo._cls1();
        b = new EffectsAditionalInfo._cls6();
        m = null;
        n = new HashMap();
        o = new HashMap();
        p = new HashMap();
        c = new HashMap();
        d = new HashMap();
        e = new HashMap();
        f = new HashMap();
        g = new HashMap();
        h = new HashMap();
        context = FileUtils.a(context, "effects/effects_additional_info.json");
        try
        {
            m = new JSONObject(context);
            a(m);
            b(m);
            c(m);
            d(m);
            e(m);
            f(m);
            g(m);
            a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static PorterDuffXfermode a(int i1)
    {
        String s = (String)q.get(i1);
        Log.e("ex1", (new StringBuilder("getPorterDuffXfermode modeName = ")).append(s).toString());
        if (s.compareTo("Normal") != 0)
        {
            if (s.compareTo("Screen") == 0)
            {
                return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SCREEN);
            }
            if (s.compareTo("Lighten") == 0)
            {
                return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.LIGHTEN);
            }
            if (s.compareTo("Overlay") == 0)
            {
                return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.OVERLAY);
            }
            if (s.compareTo("Darken") == 0)
            {
                return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DARKEN);
            }
            if (s.compareTo("Add") == 0)
            {
                return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.ADD);
            }
            if (s.compareTo("Multiply") == 0)
            {
                return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.MULTIPLY);
            }
        }
        return null;
    }

    public static String a(int i1, Context context)
    {
        if (i1 >= 0 && i1 < q.size())
        {
            return c(context, (String)q.get(i1));
        } else
        {
            return null;
        }
    }

    public static String a(Context context, String s)
    {
        s = (Integer)i.get(s);
        if (s != null)
        {
            return context.getString(s.intValue());
        } else
        {
            return null;
        }
    }

    public static ArrayList a(Context context)
    {
        ArrayList arraylist = new ArrayList();
        for (int i1 = 0; i1 < q.size(); i1++)
        {
            arraylist.add(c(context, (String)q.get(i1)));
        }

        return arraylist;
    }

    private void a()
    {
        JSONArray jsonarray = m.getJSONArray("new_effect_categories");
        int i1 = 0;
_L4:
        Object obj;
        if (i1 >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = jsonarray.getJSONObject(i1);
        String s = ((JSONObject) (obj)).getString("name");
        g.put(s, Boolean.valueOf(true));
        obj = ((JSONObject) (obj)).getJSONArray("effects");
        int j1 = 0;
_L2:
        if (j1 >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        String s1 = ((JSONArray) (obj)).getString(j1);
        h.put(s1, Boolean.valueOf(true));
        j1++;
        if (true) goto _L2; else goto _L1
_L1:
        i1++;
        if (true) goto _L4; else goto _L3
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
_L3:
    }

    private void a(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("cursor_support_effects");
        int i1 = 0;
_L2:
        if (i1 >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        String s = jsonobject.getString(i1);
        n.put(s, Boolean.valueOf(true));
        i1++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L1:
    }

    public static String b(Context context, String s)
    {
        Integer integer = (Integer)j.get(s);
        if (integer != null)
        {
            return context.getString(integer.intValue());
        } else
        {
            Log.e("ex1", (new StringBuilder("parameterName : ")).append(s).append(" local = null").toString());
            return null;
        }
    }

    private void b(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("invert_effects");
        int i1 = 0;
_L2:
        if (i1 >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        String s = jsonobject.getString(i1);
        o.put(s, Boolean.valueOf(true));
        i1++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L1:
    }

    public static String c(Context context, String s)
    {
        s = (Integer)l.get(s);
        if (s != null)
        {
            return context.getString(s.intValue());
        } else
        {
            Log.e("ex1", (new StringBuilder("blendModeName : ")).append(s).append(" local = null").toString());
            return null;
        }
    }

    private void c(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("shape_unsupport_effects");
        int i1 = 0;
_L2:
        if (i1 >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        String s = jsonobject.getString(i1);
        p.put(s, Boolean.valueOf(true));
        i1++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L1:
    }

    private void d(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("effects_with_drawer");
        int i1 = 0;
_L2:
        if (i1 >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        String s = jsonobject.getString(i1);
        c.put(s, Boolean.valueOf(true));
        i1++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L1:
    }

    private void e(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("effects_opened_in_new_activity");
        int i1 = 0;
_L2:
        if (i1 >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        String s = jsonobject.getString(i1);
        d.put(s, Boolean.valueOf(true));
        i1++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L1:
    }

    private void f(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("fast_effects");
        int i1 = 0;
_L2:
        if (i1 >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        String s = jsonobject.getString(i1);
        e.put(s, Boolean.valueOf(true));
        i1++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L1:
    }

    private void g(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("spen_unsupport_effects");
        int i1 = 0;
_L2:
        if (i1 >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        String s = jsonobject.getString(i1);
        f.put(s, Boolean.valueOf(true));
        i1++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L1:
    }

    public final String a(String s)
    {
        s = (String)k.get(s);
        if (s == null)
        {
            Log.e("ex1", "effectNameForAnalytic = null");
        }
        return s;
    }

    public final boolean b(String s)
    {
        if (o != null && o.containsKey(s))
        {
            return ((Boolean)o.get(s)).booleanValue();
        } else
        {
            return false;
        }
    }

    public final boolean c(String s)
    {
        if (p != null && p.containsKey(s))
        {
            return !((Boolean)p.get(s)).booleanValue();
        } else
        {
            return true;
        }
    }

    public final boolean d(String s)
    {
        if (n != null && n.containsKey(s))
        {
            return ((Boolean)n.get(s)).booleanValue();
        } else
        {
            return false;
        }
    }


    // Unreferenced inner class com/socialin/android/photo/effects/factory/EffectsAditionalInfo$1

/* anonymous class */
    class EffectsAditionalInfo._cls1 extends HashMap
    {

        final b this$0;

            
            {
                this$0 = b.this;
                super();
                put("FX", Integer.valueOf(0x7f080162));
                put("Artistic", Integer.valueOf(0x7f08015b));
                put("Pop Art", Integer.valueOf(0x7f08015a));
                put("Paper", Integer.valueOf(0x7f080163));
                put("Color Adjust", Integer.valueOf(0x7f08015d));
                put("Distort", Integer.valueOf(0x7f080161));
                put("Colors", Integer.valueOf(0x7f08015f));
                put("Corrections", Integer.valueOf(0x7f080160));
                put("Blur", Integer.valueOf(0x7f08015c));
            }
    }


    // Unreferenced inner class com/socialin/android/photo/effects/factory/EffectsAditionalInfo$2

/* anonymous class */
    final class EffectsAditionalInfo._cls2 extends HashMap
    {

            
            {
                put("None", Integer.valueOf(0x7f08019d));
                put("Cross Proc", Integer.valueOf(0x7f080174));
                put("Twilight", Integer.valueOf(0x7f080179));
                put("Warm Color", Integer.valueOf(0x7f080225));
                put("Sunny", Integer.valueOf(0x7f080216));
                put("Light Cross", Integer.valueOf(0x7f08021a));
                put("Warm Amber", Integer.valueOf(0x7f080223));
                put("Seafoam", Integer.valueOf(0x7f080200));
                put("Vignette", Integer.valueOf(0x7f080220));
                put("Orton", Integer.valueOf(0x7f0801a0));
                put("Cross Proc 2", Integer.valueOf(0x7f080175));
                put("Lomo", Integer.valueOf(0x7f08018c));
                put("Vintage", Integer.valueOf(0x7f080221));
                put("B&W", Integer.valueOf(0x7f080157));
                put("B&W Cross", Integer.valueOf(0x7f080152));
                put("B&W Vintage", Integer.valueOf(0x7f080153));
                put("B&W Blur", Integer.valueOf(0x7f080150));
                put("B&W HDR", Integer.valueOf(0x7f080154));
                put("Sepia", Integer.valueOf(0x7f080201));
                put("Blur", Integer.valueOf(0x7f08020a));
                put("SmartBlur", Integer.valueOf(0x7f080209));
                put("HDR 1", Integer.valueOf(0x7f080184));
                put("HDR 2", Integer.valueOf(0x7f080185));
                put("Sharpen", Integer.valueOf(0x7f080172));
                put("Cinerama", Integer.valueOf(0x7f080164));
                put("Film", Integer.valueOf(0x7f08017d));
                put("Film B&W", Integer.valueOf(0x7f08017e));
                put("Crisp", Integer.valueOf(0x7f080173));
                put("Vibrant", Integer.valueOf(0x7f08021f));
                put("Fog B&W", Integer.valueOf(0x7f080180));
                put("LutVintage", Integer.valueOf(0x7f080193));
                put("LutInstant", Integer.valueOf(0x7f080190));
                put("LutBleach", Integer.valueOf(0x7f08018d));
                put("LutBlueCrush", Integer.valueOf(0x7f08018e));
                put("LutbwContrast", Integer.valueOf(0x7f08018f));
                put("LutPunch", Integer.valueOf(0x7f080192));
                put("LutXprocess", Integer.valueOf(0x7f080191));
                put("LutWashout", Integer.valueOf(0x7f080194));
                put("LutWashoutColor", Integer.valueOf(0x7f080195));
                put("Motion blur", Integer.valueOf(0x7f080198));
                put("Polygon", Integer.valueOf(0x7f0801f8));
                put("Poster", Integer.valueOf(0x7f0801fc));
                put("Halftone Dots", Integer.valueOf(0x7f080183));
                put("Motion", Integer.valueOf(0x7f080197));
                put("Gouache", Integer.valueOf(0x7f08014e));
                put("Old Paper", Integer.valueOf(0x7f08019f));
                put("Pastel", Integer.valueOf(0x7f0801f5));
                put("Comic", Integer.valueOf(0x7f08016d));
                put("Neon", Integer.valueOf(0x7f08019b));
                put("Watercolor", Integer.valueOf(0x7f080149));
                put("Sketcher", Integer.valueOf(0x7f080208));
                put("Contours", Integer.valueOf(0x7f08016e));
                put("Pencil", Integer.valueOf(0x7f0801f6));
                put("Oil", Integer.valueOf(0x7f08019e));
                put("Cartoonizer", Integer.valueOf(0x7f080159));
                put("Sketcher1", Integer.valueOf(0x7f080206));
                put("Sketcher2", Integer.valueOf(0x7f080207));
                put("Fattal1", Integer.valueOf(0x7f08017b));
                put("Fattal2", Integer.valueOf(0x7f08017c));
                put("Emboss", Integer.valueOf(0x7f080171));
                put("Shear", Integer.valueOf(0x7f080204));
                put("Holga 1", Integer.valueOf(0x7f080187));
                put("Holga 2", Integer.valueOf(0x7f080188));
                put("Colors 1", Integer.valueOf(0x7f08021b));
                put("Colors 2", Integer.valueOf(0x7f08021c));
                put("Colors 3", Integer.valueOf(0x7f08021d));
                put("Colors 4", Integer.valueOf(0x7f08021e));
                put("Popart Colors", Integer.valueOf(0x7f0801f9));
                put("Popart 1", Integer.valueOf(0x7f0801fa));
                put("Popart 2", Integer.valueOf(0x7f0801fb));
                put("Stenciler 1", Integer.valueOf(0x7f08020c));
                put("Stenciler 2", Integer.valueOf(0x7f08020d));
                put("Stenciler 3", Integer.valueOf(0x7f08020e));
                put("Stenciler 4", Integer.valueOf(0x7f08020f));
                put("Stenciler 5", Integer.valueOf(0x7f080210));
                put("Stenciler 6", Integer.valueOf(0x7f080211));
                put("Stenciler 7", Integer.valueOf(0x7f080212));
                put("Stenciler 8", Integer.valueOf(0x7f080213));
                put("Saturation", Integer.valueOf(0x7f0801ff));
                put("Black & White", Integer.valueOf(0x7f08014d));
                put("Hue", Integer.valueOf(0x7f080189));
                put("Colorize", Integer.valueOf(0x7f08016c));
                put("Brightness", Integer.valueOf(0x7f080151));
                put("Contrast", Integer.valueOf(0x7f08016f));
                put("Negative", Integer.valueOf(0x7f08019a));
                put("Solarization", Integer.valueOf(0x7f08020b));
                put("Invert", Integer.valueOf(0x7f08018a));
                put("Color gradient", Integer.valueOf(0x7f080168));
                put("Color Levels", Integer.valueOf(0x7f080169));
                put("Zoom Blur", Integer.valueOf(0x7f080226));
                put("Mirrors", Integer.valueOf(0x7f080196));
                put("Pixelize", Integer.valueOf(0x7f0801f7));
                put("Caricature", Integer.valueOf(0x7f080158));
                put("Fish Eye", Integer.valueOf(0x7f08017f));
                put("Swirled", Integer.valueOf(0x7f080217));
                put("Cylinder Mirror", Integer.valueOf(0x7f080176));
                put("Bathroom 1", Integer.valueOf(0x7f08014b));
                put("Bathroom 2", Integer.valueOf(0x7f08014c));
                put("Radial Blur", Integer.valueOf(0x7f080165));
                put("Lens Blur", Integer.valueOf(0x7f08018b));
                put("Water", Integer.valueOf(0x7f080224));
                put("ShapeBlur", Integer.valueOf(0x7f080203));
                put("Color Splash", Integer.valueOf(0x7f08016b));
                put("Color Replace", Integer.valueOf(0x7f08016a));
                put("Noise Reduction", Integer.valueOf(0x7f08019c));
                put("Clone", Integer.valueOf(0x7f080166));
                put("Red Eye", Integer.valueOf(0x7f0801fd));
                put("Color Eye", Integer.valueOf(0x7f080167));
                put("Blemish Fix", Integer.valueOf(0x7f08014f));
                put("Face Fix", Integer.valueOf(0x7f08017a));
                put("SunlessTan", Integer.valueOf(0x7f080215));
                put("Teeth whiten", Integer.valueOf(0x7f080218));
                put("Correct colors", Integer.valueOf(0x7f08014a));
                put("Stretch", Integer.valueOf(0x7f080214));
                put("Enhance", Integer.valueOf(0x7f080170));
                put("Dodger", Integer.valueOf(0x7f080177));
                put("Drama", Integer.valueOf(0x7f080178));
                put("Retro", Integer.valueOf(0x7f0801fe));
                put("B&W HiCon", Integer.valueOf(0x7f080155));
                put("B&W LowCon", Integer.valueOf(0x7f080156));
                put("VintageIvory", Integer.valueOf(0x7f080222));
            }
    }


    // Unreferenced inner class com/socialin/android/photo/effects/factory/EffectsAditionalInfo$3

/* anonymous class */
    final class EffectsAditionalInfo._cls3 extends HashMap
    {

            
            {
                put("Fade", Integer.valueOf(0x7f0801bc));
                put("Amount", Integer.valueOf(0x7f0801a2));
                put("Saturation", Integer.valueOf(0x7f0801e8));
                put("Normal", Integer.valueOf(0x7f0801dd));
                put("Contrast", Integer.valueOf(0x7f0801b8));
                put("Brightness", Integer.valueOf(0x7f0801b1));
                put("InputShift", Integer.valueOf(0x7f0801c2));
                put("OutputShift", Integer.valueOf(0x7f0801df));
                put("Blur", Integer.valueOf(0x7f0801b0));
                put("Vignette", Integer.valueOf(0x7f0801ef));
                put("Radius", Integer.valueOf(0x7f0801e2));
                put("Unsharp", Integer.valueOf(0x7f0801ea));
                put("Max blur", Integer.valueOf(0x7f0801d5));
                put("Distance", Integer.valueOf(0x7f0801bb));
                put("Angle", Integer.valueOf(0x7f0801a3));
                put("Focal zoom", Integer.valueOf(0x7f0801bd));
                put("Hardness", Integer.valueOf(0x7f0801c0));
                put("Noise", Integer.valueOf(0x7f0801dc));
                put("Colors", Integer.valueOf(0x7f0801b6));
                put("Details", Integer.valueOf(0x7f0801ba));
                put("Point size", Integer.valueOf(0x7f0801e1));
                put("Hue", Integer.valueOf(0x7f080389));
                put("Size", Integer.valueOf(0x7f0801e9));
                put("Lines", Integer.valueOf(0x7f0801ca));
                put("Length", Integer.valueOf(0x7f0801c5));
                put("Mask 1", Integer.valueOf(0x7f0801d3));
                put("Mask 2", Integer.valueOf(0x7f0801d4));
                put("Magic 1", Integer.valueOf(0x7f0801d0));
                put("Magic 2", Integer.valueOf(0x7f0801d1));
                put("Magic 3", Integer.valueOf(0x7f0801d2));
                put("Alpha", Integer.valueOf(0x7f0801a1));
                put("Beta", Integer.valueOf(0x7f0801a4));
                put("Left", Integer.valueOf(0x7f0801c4));
                put("Right", Integer.valueOf(0x7f0801e5));
                put("Intensity", Integer.valueOf(0x7f0801c3));
                put("Gamma", Integer.valueOf(0x7f0801be));
                put("Median", Integer.valueOf(0x7f0801d7));
                put("Offset", Integer.valueOf(0x7f0801de));
                put("Phase", Integer.valueOf(0x7f0801e0));
                put("Wave", Integer.valueOf(0x7f0801f4));
                put("Replace Hue", Integer.valueOf(0x7f0801e4));
                put("Max Hue", Integer.valueOf(0x7f0801d6));
                put("Min Hue", Integer.valueOf(0x7f0801d8));
                put("Lightness", Integer.valueOf(0x7f0801c9));
                put("Colors Count", Integer.valueOf(0x7f0801b7));
                put("Denoising", Integer.valueOf(0x7f0801b9));
                put("Rotation", Integer.valueOf(0x7f0801e6));
                put("Red", Integer.valueOf(0x7f0801e3));
                put("Green", Integer.valueOf(0x7f0801bf));
                put("Blue", Integer.valueOf(0x7f0801af));
                put("Mode1", Integer.valueOf(0x7f0801da));
                put("Mode2", Integer.valueOf(0x7f0801db));
                put("Round Corners", Integer.valueOf(0x7f0801e7));
                put("Sin", Integer.valueOf(0x7f0801ec));
                put("Sqrt", Integer.valueOf(0x7f0801ed));
                put("Square", Integer.valueOf(0x7f0801ee));
                put("L1", Integer.valueOf(0x7f0801cb));
                put("L2", Integer.valueOf(0x7f0801cc));
                put("L3", Integer.valueOf(0x7f0801cd));
                put("L4", Integer.valueOf(0x7f0801ce));
                put("L5", Integer.valueOf(0x7f0801cf));
                put("V1", Integer.valueOf(0x7f0801f0));
                put("V2", Integer.valueOf(0x7f0801f1));
                put("V3", Integer.valueOf(0x7f0801f2));
                put("V4", Integer.valueOf(0x7f0801f3));
                put("Mode", Integer.valueOf(0x7f0801d9));
                put("Std", Integer.valueOf(0x7f0801b5));
                put("R", Integer.valueOf(0x7f0801b4));
                put("G", Integer.valueOf(0x7f0801b3));
                put("B", Integer.valueOf(0x7f0801b2));
                put("Horizontal", Integer.valueOf(0x7f0801c1));
                put("Vertical", Integer.valueOf(0x7f0801eb));
                put("Density", Integer.valueOf(0x7f08010e));
            }
    }


    // Unreferenced inner class com/socialin/android/photo/effects/factory/EffectsAditionalInfo$4

/* anonymous class */
    class EffectsAditionalInfo._cls4 extends HashMap
    {

        final b this$0;

            
            {
                this$0 = b.this;
                super();
                put("None", "effect_none");
                put("Cross Proc", "effect_cross_process");
                put("Twilight", "effect_twilight");
                put("Warm Color", "effect_warm_color");
                put("Warm Color", "effect_sunny");
                put("Light Cross", "effect_light_cross");
                put("Vignette", "effect_vignette");
                put("Orton", "effect_orton");
                put("Cross Proc 2", "effect_cross_processing");
                put("Lomo", "effect_lomo");
                put("Vintage", "effect_vintage");
                put("B&W", "effect_bw");
                put("B&W Cross", "effect_bw_cross");
                put("B&W Vintage", "effec_bw_vintage");
                put("B&W Blur", "effec_bw_blur");
                put("B&W HDR", "effect_bw_hdr");
                put("Sepia", "effect_sepia");
                put("Blur", "effect_blur");
                put("SmartBlur", "effect_smart_blur");
                put("HDR 1", "effect_hdr1");
                put("HDR 2", "effect_hdr2");
                put("Sharpen", "effect_sharpen");
                put("Cinerama", "effect_cinerama");
                put("Film", "effect_film");
                put("Film B&W", "effect_film_bw");
                put("Crisp", "effect_crisp");
                put("Vibrant", "effect_vibrant");
                put("Motion blur", "effect_motion_blur");
                put("Polygon", "effect_polygon");
                put("Poster", "effect_posterize");
                put("Halftone Dots", "effect_halftone_dots");
                put("Motion", "effect_motion");
                put("Gouache", "effect_gouache");
                put("Old Paper", "effect_oldpaper");
                put("Pastel", "effect_pastel");
                put("Comic", "effect_comic_boom");
                put("Neon", "effect_neon_cola");
                put("Watercolor", "effect_water_color");
                put("Sketcher", "effect_sketcher");
                put("Contours", "effect_contours");
                put("Pencil", "effect_pencil");
                put("Oil", "effect_oil");
                put("Cartoonizer", "effect_cartoonizer");
                put("Sketcher1", "effect_sketcher1");
                put("Sketcher2", "effect_sketcher2");
                put("Fattal1", "effect_fattal1");
                put("Fattal2", "effect_fattal2");
                put("Emboss", "effect_emboss");
                put("Shear", "effect_shear");
                put("Holga 1", "effect_holgaart1");
                put("Holga 2", "effect_holgaart2");
                put("Colors 1", "effect_united_colors1");
                put("Colors 2", "effect_united_colors2");
                put("Colors 3", "effect_united_colors3");
                put("Colors 4", "effect_united_colors4");
                put("Popart Colors", "effect_pop_art_united_colors");
                put("Popart 1", "effect_popart1");
                put("Popart 2", "effect_popart2");
                put("Stenciler 1", "effect_stenciler1");
                put("Stenciler 2", "effect_stenciler2");
                put("Stenciler 3", "effect_stenciler3");
                put("Stenciler 4", "effect_stenciler4");
                put("Stenciler 5", "effect_stenciler5");
                put("Stenciler 6", "effect_stenciler6");
                put("Stenciler 7", "effect_stenciler7");
                put("Stenciler 8", "effect_stenciler8");
                put("Saturation", "effect_saturation");
                put("Black & White", "effect_black_and_white");
                put("Hue", "effect_hue");
                put("Colorize", "effect_colorize");
                put("Brightness", "effect_brightness");
                put("Contrast", "effect_contrast");
                put("Negative", "effect_negative");
                put("Solarization", "effect_solarization");
                put("Invert", "effect_invert");
                put("Color gradient", "effect_color_gradient");
                put("Zoom Blur", "effect_focal_zoom");
                put("Mirrors", "effect_mirrors");
                put("Pixelize", "effect_pixelize");
                put("Caricature", "effect_caricature");
                put("Fish Eye", "effect_fish_eye");
                put("Swirled", "effect_swirled");
                put("Cylinder Mirror", "effect_cylinder_mirror");
                put("Bathroom 1", "effect_bathroom1");
                put("Bathroom 2", "effect_bathroom2");
                put("Radial Blur", "effect_radial_blur");
                put("Lens Blur", "effect_lens_blur");
                put("Water", "effect_water");
                put("Color Splash", "effect_color_splash");
                put("Color Replace", "effect_color_replace");
                put("Clone", "effect_clone");
                put("Red Eye", "effect_red_eye");
                put("Color Eye", "effect_color_eye");
                put("Blemish Fix", "effect_blemish_fix");
                put("Face Fix", "effect_face_fix");
                put("SunlessTan", "effect_sun_tan");
                put("Teeth whiten", "effect_teeth_whiten");
                put("Noise Reduction", "effect_noise_reduction");
                put("Dodger", "effect_dodger");
                put("Drama", "effect_drama");
                put("Retro", "effect_retro");
                put("B&W HiCon", "effect_bw_hicon");
                put("B&W LowCon", "effect_bw_lowcon");
                put("VintageIvory", "effect_vintage_ivory");
                put("Seafoam", "effect_seafoam");
                put("Warm Amber", "effect_warming_amber");
            }
    }


    // Unreferenced inner class com/socialin/android/photo/effects/factory/EffectsAditionalInfo$5

/* anonymous class */
    final class EffectsAditionalInfo._cls5 extends HashMap
    {

            
            {
                put("Normal", Integer.valueOf(0x7f0801ac));
                put("Multiply", Integer.valueOf(0x7f0801ab));
                put("Screen", Integer.valueOf(0x7f0801ae));
                put("Overlay", Integer.valueOf(0x7f0801ad));
                put("Darken", Integer.valueOf(0x7f0801a7));
                put("Lighten", Integer.valueOf(0x7f0801aa));
                put("Color Dodge", Integer.valueOf(0x7f0801a6));
                put("Difference", Integer.valueOf(0x7f0801a8));
                put("Exclusion", Integer.valueOf(0x7f0801a9));
                put("Add", Integer.valueOf(0x7f0801a5));
            }
    }


    // Unreferenced inner class com/socialin/android/photo/effects/factory/EffectsAditionalInfo$6

/* anonymous class */
    class EffectsAditionalInfo._cls6 extends HashMap
    {

        final b this$0;

            
            {
                this$0 = b.this;
                super();
                put("Color Splash", Integer.valueOf(0x7f0201d7));
                put("Color Replace", Integer.valueOf(0x7f0201d6));
                put("SunlessTan", Integer.valueOf(0x7f0201df));
                put("Teeth whiten", Integer.valueOf(0x7f0201f3));
                put("Face Fix", Integer.valueOf(0x7f0201dd));
                put("Red Eye", Integer.valueOf(0x7f0201de));
                put("Color Eye", Integer.valueOf(0x7f0201dc));
                put("Clone", Integer.valueOf(0x7f0201d5));
                put("Blemish Fix", Integer.valueOf(0x7f0201db));
                put("Noise Reduction", Integer.valueOf(0x7f0201ee));
            }
    }


    // Unreferenced inner class com/socialin/android/photo/effects/factory/EffectsAditionalInfo$7

/* anonymous class */
    final class EffectsAditionalInfo._cls7 extends ArrayList
    {

            
            {
                add("Normal");
                add("Screen");
                add("Lighten");
                add("Overlay");
                add("Darken");
                add("Add");
                add("Multiply");
            }
    }

}
