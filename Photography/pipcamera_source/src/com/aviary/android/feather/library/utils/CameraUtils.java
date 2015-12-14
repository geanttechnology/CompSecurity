// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public final class CameraUtils
{

    public static final MegaPixels a;
    public static final MegaPixels b = MegaPixels.values()[n_getLargeMp()];
    public static final MegaPixels c = MegaPixels.values()[n_getNormalMp()];
    public static final MegaPixels d;

    public static String a(int i, int j)
    {
        double d1 = i * j;
        DecimalFormatSymbols decimalformatsymbols = new DecimalFormatSymbols();
        decimalformatsymbols.setDecimalSeparator('.');
        return (new DecimalFormat("##.#", decimalformatsymbols)).format(d1 / 1000000D);
    }

    private static native int n_getLargeMp();

    private static native int n_getMaximumMp();

    private static native int n_getNormalMp();

    static 
    {
        a = MegaPixels.values()[n_getMaximumMp()];
        d = a;
        System.loadLibrary("stlport_shared");
        System.loadLibrary("camera_utils");
    }

    private class MegaPixels extends Enum
    {

        private static final MegaPixels $VALUES[];
        public static final MegaPixels Mp0;
        public static final MegaPixels Mp1;
        public static final MegaPixels Mp10;
        public static final MegaPixels Mp11;
        public static final MegaPixels Mp12;
        public static final MegaPixels Mp13;
        public static final MegaPixels Mp2;
        public static final MegaPixels Mp3;
        public static final MegaPixels Mp4;
        public static final MegaPixels Mp5;
        public static final MegaPixels Mp6;
        public static final MegaPixels Mp7;
        public static final MegaPixels Mp8;
        public static final MegaPixels Mp9;

        public static MegaPixels valueOf(String s)
        {
            return (MegaPixels)Enum.valueOf(com/aviary/android/feather/library/utils/CameraUtils$MegaPixels, s);
        }

        public static MegaPixels[] values()
        {
            return (MegaPixels[])$VALUES.clone();
        }

        static 
        {
            Mp0 = new MegaPixels("Mp0", 0);
            Mp1 = new MegaPixels("Mp1", 1);
            Mp2 = new MegaPixels("Mp2", 2);
            Mp3 = new MegaPixels("Mp3", 3);
            Mp4 = new MegaPixels("Mp4", 4);
            Mp5 = new MegaPixels("Mp5", 5);
            Mp6 = new MegaPixels("Mp6", 6);
            Mp7 = new MegaPixels("Mp7", 7);
            Mp8 = new MegaPixels("Mp8", 8);
            Mp9 = new MegaPixels("Mp9", 9);
            Mp10 = new MegaPixels("Mp10", 10);
            Mp11 = new MegaPixels("Mp11", 11);
            Mp12 = new MegaPixels("Mp12", 12);
            Mp13 = new MegaPixels("Mp13", 13);
            $VALUES = (new MegaPixels[] {
                Mp0, Mp1, Mp2, Mp3, Mp4, Mp5, Mp6, Mp7, Mp8, Mp9, 
                Mp10, Mp11, Mp12, Mp13
            });
        }

        private MegaPixels(String s, int i)
        {
            super(s, i);
        }
    }

}
