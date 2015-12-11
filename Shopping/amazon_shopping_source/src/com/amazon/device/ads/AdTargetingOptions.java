// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            Utils, Log

public class AdTargetingOptions
{
    public static final class Gender extends Enum
    {

        private static final Gender $VALUES[];
        public static final Gender FEMALE;
        public static final Gender MALE;
        public static final Gender UNKNOWN;
        final String gender;

        public static Gender valueOf(String s)
        {
            return (Gender)Enum.valueOf(com/amazon/device/ads/AdTargetingOptions$Gender, s);
        }

        public static Gender[] values()
        {
            return (Gender[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new Gender("UNKNOWN", 0, "unknown");
            MALE = new Gender("MALE", 1, "male");
            FEMALE = new Gender("FEMALE", 2, "female");
            $VALUES = (new Gender[] {
                UNKNOWN, MALE, FEMALE
            });
        }

        private Gender(String s, int i, String s1)
        {
            super(s, i);
            gender = s1;
        }
    }


    private static final String LOGTAG = com/amazon/device/ads/AdTargetingOptions.getSimpleName();
    private Map advanced;
    private int age;
    private boolean enableGeoTargeting;
    private long floorPrice;

    public AdTargetingOptions()
    {
        age = 0x80000000;
        floorPrice = 0x8000000000000000L;
        enableGeoTargeting = false;
        advanced = new HashMap();
    }

    public boolean containsAdvancedOption(String s)
    {
        return advanced.containsKey(s);
    }

    public AdTargetingOptions enableGeoLocation(boolean flag)
    {
        enableGeoTargeting = flag;
        return this;
    }

    public String getAdvancedOption(String s)
    {
        return (String)advanced.get(s);
    }

    public int getAge()
    {
        return age;
    }

    HashMap getCopyOfAdvancedOptions()
    {
        return new HashMap(advanced);
    }

    public long getFloorPrice()
    {
        return floorPrice;
    }

    public Gender getGender()
    {
        return Gender.UNKNOWN;
    }

    boolean hasAge()
    {
        return age > -1;
    }

    boolean hasFloorPrice()
    {
        return floorPrice > -1L;
    }

    public boolean isGeoLocationEnabled()
    {
        return enableGeoTargeting;
    }

    public AdTargetingOptions setAdvancedOption(String s, String s1)
    {
        if (Utils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("Option Key must not be null or empty string");
        }
        if (s1 != null)
        {
            advanced.put(s, s1);
            return this;
        } else
        {
            advanced.remove(s);
            return this;
        }
    }

    public AdTargetingOptions setAge(int i)
    {
        age = i;
        return this;
    }

    public AdTargetingOptions setFloorPrice(long l)
    {
        floorPrice = l;
        return this;
    }

    public AdTargetingOptions setGender(Gender gender)
    {
        Log.d(LOGTAG, "Gender information has been deprecated and is no longer used for targeting.");
        return this;
    }

}
