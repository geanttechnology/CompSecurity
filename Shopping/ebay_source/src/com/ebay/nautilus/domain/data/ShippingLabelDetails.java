// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelContact, ShippingLabelPackage

public class ShippingLabelDetails
{
    public static final class ServiceFeature extends Enum
    {

        private static final ServiceFeature $VALUES[];
        public static final ServiceFeature SIG_CON;

        public static ServiceFeature valueOf(String s)
        {
            return (ServiceFeature)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelDetails$ServiceFeature, s);
        }

        public static ServiceFeature[] values()
        {
            return (ServiceFeature[])$VALUES.clone();
        }

        static 
        {
            SIG_CON = new ServiceFeature("SIG_CON", 0);
            $VALUES = (new ServiceFeature[] {
                SIG_CON
            });
        }

        private ServiceFeature(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ServiceFeatureValue
    {

        public String feature;
        public String value;

        public ServiceFeatureValue()
        {
        }

        public ServiceFeatureValue(String s, String s1)
        {
            feature = s;
            value = s1;
        }
    }

    public static final class ShippingCarrier extends Enum
    {

        private static final ShippingCarrier $VALUES[];
        public static final ShippingCarrier FEDEX;
        public static final ShippingCarrier USPS;

        public static ShippingCarrier valueOf(String s)
        {
            return (ShippingCarrier)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelDetails$ShippingCarrier, s);
        }

        public static ShippingCarrier[] values()
        {
            return (ShippingCarrier[])$VALUES.clone();
        }

        static 
        {
            USPS = new ShippingCarrier("USPS", 0);
            FEDEX = new ShippingCarrier("FEDEX", 1);
            $VALUES = (new ShippingCarrier[] {
                USPS, FEDEX
            });
        }

        private ShippingCarrier(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class SigConValue extends Enum
    {

        private static final SigConValue $VALUES[];
        public static final SigConValue ADULT;
        public static final SigConValue DIRECT;
        public static final SigConValue INDIRECT;
        public static final SigConValue NO_SIGNATURE_REQUIRED;

        public static SigConValue valueOf(String s)
        {
            return (SigConValue)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelDetails$SigConValue, s);
        }

        public static SigConValue[] values()
        {
            return (SigConValue[])$VALUES.clone();
        }

        static 
        {
            DIRECT = new SigConValue("DIRECT", 0);
            ADULT = new SigConValue("ADULT", 1);
            INDIRECT = new SigConValue("INDIRECT", 2);
            NO_SIGNATURE_REQUIRED = new SigConValue("NO_SIGNATURE_REQUIRED", 3);
            $VALUES = (new SigConValue[] {
                DIRECT, ADULT, INDIRECT, NO_SIGNATURE_REQUIRED
            });
        }

        private SigConValue(String s, int i)
        {
            super(s, i);
        }
    }


    public String customMessage;
    public ShippingLabelContact from;
    public ShippingLabelPackage pkg;
    public transient boolean printPostageOnLabel;
    public transient String selectedInsuranceCoverage;
    public ArrayList serviceFeatureValues;
    public ArrayList shippingOptions;
    public transient boolean showCustomMessage;
    public transient String sigConSelected;
    public ShippingLabelContact to;

    public ShippingLabelDetails()
    {
        shippingOptions = new ArrayList();
        serviceFeatureValues = new ArrayList();
    }
}
