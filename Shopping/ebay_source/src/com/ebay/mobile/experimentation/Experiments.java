// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.experimentation;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.experimentation.Experiment;
import com.ebay.nautilus.domain.net.api.experimentation.ExperimentBase;
import com.ebay.nautilus.domain.net.api.experimentation.Factor;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.Arrays;
import java.util.List;

public class Experiments
{
    public static class AdsExperimentDefinition extends ExperimentBase
    {

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
            static class _cls2
            {

                static final int $SwitchMap$com$ebay$mobile$experimentation$Experiments$AdsExperimentDefinition$AdsPageSource[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$experimentation$Experiments$AdsExperimentDefinition$AdsPageSource = new int[AdsExperimentDefinition.AdsPageSource.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$experimentation$Experiments$AdsExperimentDefinition$AdsPageSource[AdsExperimentDefinition.AdsPageSource.AdsOnHp.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$experimentation$Experiments$AdsExperimentDefinition$AdsPageSource[AdsExperimentDefinition.AdsPageSource.AdsOnSrp.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$experimentation$Experiments$AdsExperimentDefinition$AdsPageSource[AdsExperimentDefinition.AdsPageSource.AdsOnVip.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls2..SwitchMap.com.ebay.mobile.experimentation.Experiments.AdsExperimentDefinition.AdsPageSource[adspagesource.ordinal()];
            JVM INSTR tableswitch 1 3: default 84
        //                       1 86
        //                       2 100
        //                       3 114;
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

        public AdsExperimentDefinition(String s, String s1, String s2)
        {
            super(s, s1, s2);
            defaultTreatment = new Treatment(Experiments.UNKNOWN_DISPLAY_ID, null);
        }
    }

    public static final class AdsExperimentDefinition.AdsPageSource extends Enum
    {

        private static final AdsExperimentDefinition.AdsPageSource $VALUES[];
        public static final AdsExperimentDefinition.AdsPageSource AdsOnHp;
        public static final AdsExperimentDefinition.AdsPageSource AdsOnSrp;
        public static final AdsExperimentDefinition.AdsPageSource AdsOnVip;

        public static AdsExperimentDefinition.AdsPageSource valueOf(String s)
        {
            return (AdsExperimentDefinition.AdsPageSource)Enum.valueOf(com/ebay/mobile/experimentation/Experiments$AdsExperimentDefinition$AdsPageSource, s);
        }

        public static AdsExperimentDefinition.AdsPageSource[] values()
        {
            return (AdsExperimentDefinition.AdsPageSource[])$VALUES.clone();
        }

        static 
        {
            AdsOnHp = new AdsExperimentDefinition.AdsPageSource("AdsOnHp", 0);
            AdsOnSrp = new AdsExperimentDefinition.AdsPageSource("AdsOnSrp", 1);
            AdsOnVip = new AdsExperimentDefinition.AdsPageSource("AdsOnVip", 2);
            $VALUES = (new AdsExperimentDefinition.AdsPageSource[] {
                AdsOnHp, AdsOnSrp, AdsOnVip
            });
        }

        private AdsExperimentDefinition.AdsPageSource(String s, int i)
        {
            super(s, i);
        }
    }

    public static class BooleanExperimentDefinition extends ExperimentBase
    {

        public static final String FACTOR_ENABLED = "enabled";

        public static boolean isEnabled(Treatment treatment, boolean flag)
        {
            Object obj;
            if (treatment == null)
            {
                obj = null;
            } else
            {
                obj = treatment.getCurrentFactor("enabled");
            }
            if (treatment == null || treatment.isDefault || TextUtils.isEmpty(((CharSequence) (obj))))
            {
                return flag;
            } else
            {
                return Boolean.parseBoolean(((String) (obj)));
            }
        }

        public BooleanExperimentDefinition(String s, String s1, String s2)
        {
            this(s, s1, s2, false);
        }

        public BooleanExperimentDefinition(String s, String s1, String s2, boolean flag)
        {
            super(s, s1, s2);
            defaultTreatment = new Treatment(Experiments.UNKNOWN_DISPLAY_ID, new Factor[] {
                new Factor("enabled", Boolean.toString(flag))
            });
        }
    }

    public static class FollowBarExperimentDefinition extends ExperimentBase
    {

        public static boolean isFollowBarVisible(Treatment treatment)
        {
            boolean flag;
            if (treatment != null && !treatment.isDefault && treatment.treatmentName.equals("mAPP_001_Follow_Refine_Bar"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return !flag;
        }

        public FollowBarExperimentDefinition(String s, String s1, String s2)
        {
            super(s, s1, s2);
            defaultTreatment = new Treatment(Experiments.UNKNOWN_DISPLAY_ID, null);
        }
    }


    public static final Experiment AdsExperiment41DE;
    public static final Experiment AdsExperiment41UK;
    public static final Experiment AdsExperiment41US;
    public static final Experiment HideSrpVqFollowBar40DE;
    public static final Experiment HideSrpVqFollowBar40UK;
    public static final Experiment HideSrpVqFollowBar40US;
    public static final Experiment ShowProxExperiment;
    public static final Experiment TestExperiment;
    private static String UNKNOWN_DISPLAY_ID;
    private static final List experiments;

    public Experiments()
    {
    }

    public static Treatment getAdsTreatment(EbaySite ebaysite, EbayContext ebaycontext)
    {
        if (ebaysite == EbaySite.US)
        {
            return AdsExperiment41US.getCurrentTreatment(ebaycontext);
        }
        if (ebaysite == EbaySite.UK)
        {
            return AdsExperiment41UK.getCurrentTreatment(ebaycontext);
        }
        if (ebaysite == EbaySite.DE)
        {
            return AdsExperiment41DE.getCurrentTreatment(ebaycontext);
        } else
        {
            return null;
        }
    }

    public static List getExperiments()
    {
        return experiments;
    }

    public static Treatment getHideFollowBarTreatment(EbaySite ebaysite, EbayContext ebaycontext)
    {
        if (ebaysite == EbaySite.US)
        {
            return HideSrpVqFollowBar40US.getCurrentTreatment(ebaycontext);
        }
        if (ebaysite == EbaySite.UK)
        {
            return HideSrpVqFollowBar40UK.getCurrentTreatment(ebaycontext);
        }
        if (ebaysite == EbaySite.DE)
        {
            return HideSrpVqFollowBar40DE.getCurrentTreatment(ebaycontext);
        } else
        {
            return null;
        }
    }

    static 
    {
        UNKNOWN_DISPLAY_ID = "99999999";
        TestExperiment = new ExperimentBase("AEAPP 20131226 Dev Validation A/A US", "id", "702192") {

            
            {
                defaultTreatment = new Treatment("treatmentDisplayId", new Factor[] {
                    new Factor("f1", "0"), new Factor("f2", "true"), new Factor("f3", "Default")
                });
            }
        };
        HideSrpVqFollowBar40US = new FollowBarExperimentDefinition("US_mApp_SEARCH_893_Refine_UX - (TPES: 727)", "id", UNKNOWN_DISPLAY_ID);
        HideSrpVqFollowBar40UK = new FollowBarExperimentDefinition("UK_mApp_SEARCH_893_Refine_UX - (TPES: 732)", "id", UNKNOWN_DISPLAY_ID);
        HideSrpVqFollowBar40DE = new FollowBarExperimentDefinition("DE_mApp_SEARCH_893_Refine_UX - (TPES: 733)", "id", UNKNOWN_DISPLAY_ID);
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        ShowProxExperiment = new BooleanExperimentDefinition("AEAPP 2.8.0 PROX A/B DE v1", "id", UNKNOWN_DISPLAY_ID, deviceconfiguration.get(DcsNautilusBoolean.PROX));
        AdsExperiment41US = new AdsExperimentDefinition("US_AEAPP_ADS_240_Cannibalization (TPES - 674)", null, null);
        AdsExperiment41UK = new AdsExperimentDefinition("UK_AEAPP_ADS_240_Cannibalization (TPES - 730)", null, null);
        AdsExperiment41DE = new AdsExperimentDefinition("DE_AEAPP_ADS_240_Cannibalization (TPES - 731)", null, null);
        experiments = Arrays.asList(new Experiment[] {
            TestExperiment, ShowProxExperiment, HideSrpVqFollowBar40US, HideSrpVqFollowBar40UK, HideSrpVqFollowBar40DE, AdsExperiment41US, AdsExperiment41UK, AdsExperiment41DE
        });
    }

}
