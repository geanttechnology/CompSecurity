// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.experimentation;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.api.experimentation.ExperimentBase;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;

// Referenced classes of package com.ebay.mobile.experimentation:
//            Experiments

public static class defaultTreatment extends ExperimentBase
{
    public static final class AdsPageSource extends Enum
    {

        private static final AdsPageSource $VALUES[];
        public static final AdsPageSource AdsOnHp;
        public static final AdsPageSource AdsOnSrp;
        public static final AdsPageSource AdsOnVip;

        public static AdsPageSource valueOf(String s)
        {
            return (AdsPageSource)Enum.valueOf(com/ebay/mobile/experimentation/Experiments$AdsExperimentDefinition$AdsPageSource, s);
        }

        public static AdsPageSource[] values()
        {
            return (AdsPageSource[])$VALUES.clone();
        }

        static 
        {
            AdsOnHp = new AdsPageSource("AdsOnHp", 0);
            AdsOnSrp = new AdsPageSource("AdsOnSrp", 1);
            AdsOnVip = new AdsPageSource("AdsOnVip", 2);
            $VALUES = (new AdsPageSource[] {
                AdsOnHp, AdsOnSrp, AdsOnVip
            });
        }

        private AdsPageSource(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String SHOW_ALL_ADS_1_TREATMENT = "AEAPP_00001_ShowAllAds_1";
    public static final String SHOW_ALL_ADS_2_TREATMENT = "AEAPP_00001_ShowAllAds_2";
    public static final String SHOW_NO_ADS = "AEAPP_00001_ShowNoAds";
    public static final String SHOW_NO_ADS_ON_HP = "AEAPP_00001_ShowNoAdsOnHP";
    public static final String SHOW_NO_ADS_ON_SRP = "AEAPP_00001_ShowNoAdsOnSRP";
    public static final String SHOW_NO_ADS_ON_VIP = "AEAPP_00001_ShowNoAdsOnVIP";

    public static boolean isActive(Treatment treatment, AdsPageSource adspagesource)
    {
_L2:
        return true;
        if (treatment == null || treatment.isDefault || TextUtils.equals("AEAPP_00001_ShowAllAds_1", treatment.treatmentName) || TextUtils.equals("AEAPP_00001_ShowAllAds_2", treatment.treatmentName)) goto _L2; else goto _L1
_L1:
        if (TextUtils.equals("AEAPP_00001_ShowNoAds", treatment.treatmentName))
        {
            return false;
        }
        bile.experimentation.Experiments.AdsExperimentDefinition.AdsPageSource[adspagesource.ordinal()];
        JVM INSTR tableswitch 1 3: default 84
    //                   1 86
    //                   2 100
    //                   3 114;
           goto _L3 _L4 _L5 _L6
_L6:
        continue; /* Loop/switch isn't completed */
_L3:
        return true;
_L4:
        if (!TextUtils.equals("AEAPP_00001_ShowNoAdsOnHP", treatment.treatmentName)) goto _L2; else goto _L7
_L7:
        return false;
_L5:
        if (!TextUtils.equals("AEAPP_00001_ShowNoAdsOnSRP", treatment.treatmentName)) goto _L2; else goto _L8
_L8:
        return false;
        if (!TextUtils.equals("AEAPP_00001_ShowNoAdsOnVIP", treatment.treatmentName)) goto _L2; else goto _L9
_L9:
        return false;
    }

    public AdsPageSource(String s, String s1, String s2)
    {
        super(s, s1, s2);
        defaultTreatment = new Treatment(Experiments.access$000(), null);
    }
}
