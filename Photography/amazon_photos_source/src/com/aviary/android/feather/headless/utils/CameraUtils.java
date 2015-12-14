// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

// Referenced classes of package com.aviary.android.feather.headless.utils:
//            MegaPixels

public final class CameraUtils
{

    static final int MEGAPIXELS = 0xf4240;

    private CameraUtils()
    {
    }

    public static int[] computePixels(MegaPixels megapixels, int i, int j)
    {
        double d = Math.ceil(Math.sqrt(((double)i / (double)j) * 1000000D * (double)megapixels.ordinal()));
        double d1 = Math.ceil(Math.sqrt(((double)i / (double)j) * 1000000D * (double)megapixels.ordinal()));
        return (new int[] {
            (int)d, (int)d1
        });
    }

    static MegaPixels fromInt(int i)
    {
        MegaPixels amegapixels[] = (MegaPixels[])com/aviary/android/feather/headless/utils/MegaPixels.getEnumConstants();
        if (i >= 0 && i < amegapixels.length)
        {
            return amegapixels[i];
        } else
        {
            return MegaPixels.Mp1;
        }
    }

    public static MegaPixels getLargeMegaPixels()
    {
        return fromInt(n_getMediumMp());
    }

    public static MegaPixels getMaximumMegaPixels()
    {
        return fromInt(n_getMaximumMp());
    }

    public static String getMegaPixels(int i, int j)
    {
        double d = i * j;
        DecimalFormatSymbols decimalformatsymbols = new DecimalFormatSymbols();
        decimalformatsymbols.setDecimalSeparator('.');
        return (new DecimalFormat("##.#", decimalformatsymbols)).format(d / 1000000D);
    }

    public static MegaPixels getNormalMegaPixels()
    {
        return fromInt(n_getSmallMp());
    }

    public static MegaPixels getOriginalMegaPixels()
    {
        return fromInt(n_getLargeMp());
    }

    private static native int n_getLargeMp();

    private static native int n_getMaximumMp();

    private static native int n_getMediumMp();

    private static native int n_getSmallMp();

    static 
    {
        System.loadLibrary("cutils");
        System.loadLibrary("aviary_moalite");
        System.loadLibrary("aviary_native");
    }
}
