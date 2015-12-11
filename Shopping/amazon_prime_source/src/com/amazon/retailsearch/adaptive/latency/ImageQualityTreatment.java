// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.adaptive.latency;

import com.amazon.retailsearch.adaptive.framework.AdaptiveTreatmentEnum;

public final class ImageQualityTreatment extends Enum
    implements AdaptiveTreatmentEnum
{

    private static final ImageQualityTreatment $VALUES[];
    public static final ImageQualityTreatment HIGH;
    public static final ImageQualityTreatment LOW;
    public static final ImageQualityTreatment MEDIUM;
    public static final ImageQualityTreatment VERY_LOW;
    public static String clickToATFArray[] = null;
    private final String clickToATFLevel;

    private ImageQualityTreatment(String s, int i, String s1)
    {
        super(s, i);
        clickToATFLevel = s1;
    }

    public static String[] getClickToATFArray()
    {
        if (clickToATFArray == null)
        {
            clickToATFArray = new String[values().length];
            int j = 0;
            ImageQualityTreatment aimagequalitytreatment[] = values();
            int k = aimagequalitytreatment.length;
            for (int i = 0; i < k; i++)
            {
                ImageQualityTreatment imagequalitytreatment = aimagequalitytreatment[i];
                clickToATFArray[j] = imagequalitytreatment.getATFLevel();
                j++;
            }

        }
        return clickToATFArray;
    }

    public static ImageQualityTreatment valueOf(String s)
    {
        return (ImageQualityTreatment)Enum.valueOf(com/amazon/retailsearch/adaptive/latency/ImageQualityTreatment, s);
    }

    public static ImageQualityTreatment[] values()
    {
        return (ImageQualityTreatment[])$VALUES.clone();
    }

    public String getATFLevel()
    {
        return clickToATFLevel;
    }

    static 
    {
        HIGH = new ImageQualityTreatment("HIGH", 0, "None");
        MEDIUM = new ImageQualityTreatment("MEDIUM", 1, "ATF_50");
        LOW = new ImageQualityTreatment("LOW", 2, "ATF_90");
        VERY_LOW = new ImageQualityTreatment("VERY_LOW", 3, "ATF_99");
        $VALUES = (new ImageQualityTreatment[] {
            HIGH, MEDIUM, LOW, VERY_LOW
        });
    }
}
