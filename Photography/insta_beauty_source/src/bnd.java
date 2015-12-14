// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.HashMap;

public class bnd
{

    private static bnd b = null;
    private HashMap a;

    private bnd()
    {
        a = new HashMap();
    }

    private int a(String s, String s1)
    {
        return bli.a(bli.a(35633, s), bli.a(35632, s1), new String[] {
            "Position", "inputTextureCoordinate"
        });
    }

    public static bnd a()
    {
        if (b == null)
        {
            b = new bnd();
        }
        return b;
    }

    public int a(Context context, String s)
    {
        int i = 0;
        int j = 0x7f050014;
        if (a.containsKey(s))
        {
            return ((Integer)a.get(s)).intValue();
        }
        if (s.equalsIgnoreCase("simple"))
        {
            i = 0x7f050054;
        } else
        if (s.equalsIgnoreCase("gaussianblur"))
        {
            i = 0x7f050040;
        } else
        if (s.equalsIgnoreCase("gaussianblurh"))
        {
            i = 0x7f050042;
        } else
        if (s.equalsIgnoreCase("gaussianblurv"))
        {
            i = 0x7f050043;
        } else
        if (s.equalsIgnoreCase("ABao"))
        {
            i = 0x7f050000;
        } else
        if (s.equalsIgnoreCase("AlphaMask"))
        {
            i = 0x7f050003;
        } else
        if (s.equalsIgnoreCase("BlendColor"))
        {
            i = 0x7f050005;
        } else
        if (s.equalsIgnoreCase("Bloom"))
        {
            i = 0x7f050007;
        } else
        if (s.equalsIgnoreCase("ChannelMixer"))
        {
            i = 0x7f050009;
        } else
        if (s.equalsIgnoreCase("CheapBloom"))
        {
            i = 0x7f050012;
        } else
        if (s.equalsIgnoreCase("ColorCurve"))
        {
            i = 0x7f05000c;
        } else
        if (s.equalsIgnoreCase("SkinTone"))
        {
            i = 0x7f050056;
        } else
        if (s.equalsIgnoreCase("ColorLookup"))
        {
            i = 0x7f050010;
        } else
        if (s.equalsIgnoreCase("CrtScanline"))
        {
            i = 0x7f050015;
        } else
        if (s.equalsIgnoreCase("DreamVision"))
        {
            i = 0x7f050018;
        } else
        if (s.equalsIgnoreCase("Erode"))
        {
            i = 0x7f05001a;
        } else
        if (s.equalsIgnoreCase("ExBlend"))
        {
            i = 0x7f050023;
        } else
        if (s.equalsIgnoreCase("FilmGrain"))
        {
            i = 0x7f05003a;
        } else
        if (s.equalsIgnoreCase("FrostedGlass"))
        {
            i = 0x7f05003c;
        } else
        if (s.equalsIgnoreCase("GammaCollection"))
        {
            i = 0x7f05003e;
        } else
        if (s.equalsIgnoreCase("LevelControl"))
        {
            i = 0x7f050046;
        } else
        if (s.equalsIgnoreCase("MotionBlur"))
        {
            i = 0x7f050049;
        } else
        if (s.equalsIgnoreCase("Ripple"))
        {
            i = 0x7f05004b;
        } else
        if (s.equalsIgnoreCase("SceneLowSaturation"))
        {
            i = 0x7f05004d;
        } else
        if (s.equalsIgnoreCase("Sepia"))
        {
            i = 0x7f050050;
        } else
        if (s.equalsIgnoreCase("Sharpness"))
        {
            i = 0x7f050052;
        } else
        if (s.equalsIgnoreCase("ThemalVision"))
        {
            i = 0x7f050057;
        } else
        if (s.equalsIgnoreCase("UnsharpMask"))
        {
            i = 0x7f05005c;
        } else
        if (s.equalsIgnoreCase("Desaturation"))
        {
            i = 0x7f050017;
        } else
        if (s.equalsIgnoreCase("Invert"))
        {
            i = 0x7f050045;
        } else
        if (s.equalsIgnoreCase("SelectiveBlur"))
        {
            i = 0x7f05004f;
        } else
        if (s.equals("ExBlend0"))
        {
            i = 0x7f05002f;
        } else
        if (s.equals("ExBlend1"))
        {
            i = 0x7f050028;
        } else
        if (s.equals("ExBlend2"))
        {
            i = 0x7f050021;
        } else
        if (s.equals("ExBlend3"))
        {
            i = 0x7f05002d;
        } else
        if (s.equals("ExBlend4"))
        {
            i = 0x7f05001d;
        } else
        if (s.equals("ExBlend5"))
        {
            i = 0x7f05001c;
        } else
        if (s.equals("ExBlend6"))
        {
            i = 0x7f050037;
        } else
        if (s.equals("ExBlend7"))
        {
            i = 0x7f05002e;
        } else
        if (s.equals("ExBlend8"))
        {
            i = 0x7f050022;
        } else
        if (s.equals("ExBlend9"))
        {
            i = 0x7f050035;
        } else
        if (s.equals("ExBlend10"))
        {
            i = 0x7f050030;
        } else
        if (s.equals("ExBlend11"))
        {
            i = 0x7f050036;
        } else
        if (s.equals("ExBlend12"))
        {
            i = 0x7f050025;
        } else
        if (s.equals("ExBlend13"))
        {
            i = 0x7f050020;
        } else
        if (s.equals("ExBlend14"))
        {
            i = 0x7f05001f;
        } else
        if (s.equals("ExBlend15"))
        {
            i = 0x7f05002a;
        } else
        if (s.equals("ExBlend16"))
        {
            i = 0x7f050029;
        } else
        if (s.equals("ExBlend17"))
        {
            i = 0x7f05002b;
        } else
        if (s.equals("ExBlend18"))
        {
            i = 0x7f050039;
        } else
        if (s.equals("ExBlend19"))
        {
            i = 0x7f050032;
        } else
        if (s.equals("ExBlend20"))
        {
            i = 0x7f050026;
        } else
        if (s.equals("ExBlend21"))
        {
            i = 0x7f050033;
        } else
        if (s.equals("ExBlend22"))
        {
            i = 0x7f050024;
        } else
        if (s.equals("ExBlend23"))
        {
            i = 0x7f050031;
        } else
        if (s.equals("ExBlend24"))
        {
            i = 0x7f050027;
        } else
        if (s.equals("ExBlend25"))
        {
            i = 0x7f050034;
        } else
        if (s.equals("ExBlend26"))
        {
            i = 0x7f05001e;
        } else
        if (s.equals("ExBlend27"))
        {
            i = 0x7f05002c;
        } else
        {
            j = 0;
        }
        i = a(blh.a(context, j), blh.a(context, i));
        a.put(s, Integer.valueOf(i));
        return i;
    }

    public void b()
    {
        a.clear();
    }

}
