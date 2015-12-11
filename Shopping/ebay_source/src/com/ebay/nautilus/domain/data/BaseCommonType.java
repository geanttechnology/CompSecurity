// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.content.res.Resources;
import android.text.Html;
import android.text.TextUtils;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ItemCurrency

public abstract class BaseCommonType
{
    public static class Address
    {

        public String addressLine1;
        public String addressLine2;
        public AddressTypeEnum addressType;
        public String city;
        public String country;
        public Boolean isTransliterated;
        public LanguageScriptEnum isTransliteratedFromScript;
        public String nationalRegion;
        public String postalCode;
        public LanguageScriptEnum script;
        public String stateOrProvince;
        public String worldRegion;

        public Address()
        {
        }
    }

    public static final class AddressTypeEnum extends Enum
    {

        private static final AddressTypeEnum $VALUES[];
        public static final AddressTypeEnum BUSINESS;
        public static final AddressTypeEnum PO_BOX;
        public static final AddressTypeEnum RESIDENCE;

        public static AddressTypeEnum valueOf(String s)
        {
            return (AddressTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$AddressTypeEnum, s);
        }

        public static AddressTypeEnum[] values()
        {
            return (AddressTypeEnum[])$VALUES.clone();
        }

        static 
        {
            PO_BOX = new AddressTypeEnum("PO_BOX", 0);
            RESIDENCE = new AddressTypeEnum("RESIDENCE", 1);
            BUSINESS = new AddressTypeEnum("BUSINESS", 2);
            $VALUES = (new AddressTypeEnum[] {
                PO_BOX, RESIDENCE, BUSINESS
            });
        }

        private AddressTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Amount
    {

        public String convertedFromCurrency;
        public Double convertedFromValue;
        public String currency;
        public double value;

        public final ItemCurrency getAmount()
        {
            if (hasConvertedAmount())
            {
                return new ItemCurrency(convertedFromCurrency, convertedFromValue.toString());
            } else
            {
                return new ItemCurrency(currency, Double.toString(value));
            }
        }

        public final ItemCurrency getConvertedAmount()
        {
            ItemCurrency itemcurrency = null;
            if (hasConvertedAmount())
            {
                itemcurrency = new ItemCurrency(currency, Double.toString(value));
            }
            return itemcurrency;
        }

        boolean hasConvertedAmount()
        {
            return convertedFromValue != null && convertedFromCurrency != null;
        }

        public Amount()
        {
        }
    }

    public static final class DateTime
    {

        public String formattedValue;
        public Date value;

        public DateTime(Date date)
        {
            value = date;
        }
    }

    public static final class Dimension
    {

        public double height;
        public double length;
        public DimensionUnitOfMeasureEnum unit;
        public double width;

        public Dimension()
        {
        }
    }

    public static final class DimensionUnitOfMeasureEnum extends Enum
    {

        private static final DimensionUnitOfMeasureEnum $VALUES[];
        public static final DimensionUnitOfMeasureEnum CENTIMETER;
        public static final DimensionUnitOfMeasureEnum FEET;
        public static final DimensionUnitOfMeasureEnum INCH;
        public static final DimensionUnitOfMeasureEnum METER;

        public static DimensionUnitOfMeasureEnum valueOf(String s)
        {
            return (DimensionUnitOfMeasureEnum)Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$DimensionUnitOfMeasureEnum, s);
        }

        public static DimensionUnitOfMeasureEnum[] values()
        {
            return (DimensionUnitOfMeasureEnum[])$VALUES.clone();
        }

        static 
        {
            INCH = new DimensionUnitOfMeasureEnum("INCH", 0);
            FEET = new DimensionUnitOfMeasureEnum("FEET", 1);
            CENTIMETER = new DimensionUnitOfMeasureEnum("CENTIMETER", 2);
            METER = new DimensionUnitOfMeasureEnum("METER", 3);
            $VALUES = (new DimensionUnitOfMeasureEnum[] {
                INCH, FEET, CENTIMETER, METER
            });
        }

        private DimensionUnitOfMeasureEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GeoCoordinates
    {

        public double latitude;
        public double longitude;

        public GeoCoordinates()
        {
        }
    }

    public static final class LanguageScriptEnum extends Enum
    {

        private static final LanguageScriptEnum $VALUES[];
        public static final LanguageScriptEnum ARABIC;
        public static final LanguageScriptEnum ARMENIAN;
        public static final LanguageScriptEnum CHINESE;
        public static final LanguageScriptEnum CYRILLIC;
        public static final LanguageScriptEnum GEORGIAN;
        public static final LanguageScriptEnum GREEK;
        public static final LanguageScriptEnum HEBREW;
        public static final LanguageScriptEnum INDIC;
        public static final LanguageScriptEnum JAPANESE;
        public static final LanguageScriptEnum KOREAN;
        public static final LanguageScriptEnum LATIN;
        public static final LanguageScriptEnum THAI;

        public static LanguageScriptEnum valueOf(String s)
        {
            return (LanguageScriptEnum)Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$LanguageScriptEnum, s);
        }

        public static LanguageScriptEnum[] values()
        {
            return (LanguageScriptEnum[])$VALUES.clone();
        }

        static 
        {
            LATIN = new LanguageScriptEnum("LATIN", 0);
            CYRILLIC = new LanguageScriptEnum("CYRILLIC", 1);
            ARABIC = new LanguageScriptEnum("ARABIC", 2);
            HEBREW = new LanguageScriptEnum("HEBREW", 3);
            GREEK = new LanguageScriptEnum("GREEK", 4);
            JAPANESE = new LanguageScriptEnum("JAPANESE", 5);
            CHINESE = new LanguageScriptEnum("CHINESE", 6);
            GEORGIAN = new LanguageScriptEnum("GEORGIAN", 7);
            ARMENIAN = new LanguageScriptEnum("ARMENIAN", 8);
            THAI = new LanguageScriptEnum("THAI", 9);
            KOREAN = new LanguageScriptEnum("KOREAN", 10);
            INDIC = new LanguageScriptEnum("INDIC", 11);
            $VALUES = (new LanguageScriptEnum[] {
                LATIN, CYRILLIC, ARABIC, HEBREW, GREEK, JAPANESE, CHINESE, GEORGIAN, ARMENIAN, THAI, 
                KOREAN, INDIC
            });
        }

        private LanguageScriptEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Location
    {

        public Address address;
        public GeoCoordinates geoCoordinates;
        public String locationId;
        public String name;
        public RegionSet regionSet;

        public Location()
        {
        }
    }

    public static final class NameValues
    {

        public Text name;
        public Text values;

        public NameValues()
        {
        }
    }

    public static class NameValuesPair
    {

        public String globalIdentifier;
        public Text name;
        public List values;

        public NameValuesPair()
        {
        }
    }

    public static final class Property
    {

        public String propertyName;
        public List propertyValues;

        public Property()
        {
        }
    }

    public static final class PropertyValue
    {

        public Amount amountValue;
        public Boolean booleanValue;
        public DateTime dateTimeValue;
        public Date dateValue;
        public Double doubleValue;
        public Integer intValue;
        public Long longValue;
        public String stringValue;
        public Text textValue;

        public PropertyValue()
        {
        }
    }

    public static final class Region
    {

        public String regionId;
        public String regionName;
        public RegionTypeEnum regionType;

        public Region()
        {
        }
    }

    public static final class RegionSet
    {

        public List regionExcluded;
        public List regionIncluded;

        public RegionSet()
        {
        }
    }

    public static final class RegionTypeEnum extends Enum
    {

        private static final RegionTypeEnum $VALUES[];
        public static final RegionTypeEnum COUNTRY;
        public static final RegionTypeEnum COUNTRY_REGION;
        public static final RegionTypeEnum STATE_OR_PROVINCE;
        public static final RegionTypeEnum WORLDWIDE;
        public static final RegionTypeEnum WORLD_REGION;

        public static RegionTypeEnum valueOf(String s)
        {
            return (RegionTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$RegionTypeEnum, s);
        }

        public static RegionTypeEnum[] values()
        {
            return (RegionTypeEnum[])$VALUES.clone();
        }

        static 
        {
            COUNTRY_REGION = new RegionTypeEnum("COUNTRY_REGION", 0);
            STATE_OR_PROVINCE = new RegionTypeEnum("STATE_OR_PROVINCE", 1);
            COUNTRY = new RegionTypeEnum("COUNTRY", 2);
            WORLD_REGION = new RegionTypeEnum("WORLD_REGION", 3);
            WORLDWIDE = new RegionTypeEnum("WORLDWIDE", 4);
            $VALUES = (new RegionTypeEnum[] {
                COUNTRY_REGION, STATE_OR_PROVINCE, COUNTRY, WORLD_REGION, WORLDWIDE
            });
        }

        private RegionTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Text
    {

        public String content;
        public String language;
        public String translatedFromContent;
        public String translatedFromLanguage;

        public String decode()
        {
            String s = null;
            String s1 = getSourceContent();
            if (!TextUtils.isEmpty(s1))
            {
                s = Html.fromHtml(s1).toString();
            }
            return s;
        }

        public String getContent(boolean flag)
        {
            if (flag && !TextUtils.isEmpty(content))
            {
                return content;
            }
            if (!flag && !TextUtils.isEmpty(translatedFromContent))
            {
                return translatedFromContent;
            } else
            {
                return content;
            }
        }

        public String getSourceContent()
        {
            String s1 = translatedFromContent;
            String s = s1;
            if (TextUtils.isEmpty(s1))
            {
                s = content;
            }
            return s;
        }

        public Text(String s)
        {
            content = s;
        }
    }

    public static final class TimeDuration
    {

        public TimeDurationUnitEnum unit;
        public long value;

        public String toIso8601()
        {
            String s;
            String s1;
            StringBuilder stringbuilder;
            stringbuilder = new StringBuilder();
            s1 = null;
            s = null;
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$TimeDurationUnitEnum[];

                static 
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$TimeDurationUnitEnum = new int[TimeDurationUnitEnum.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$TimeDurationUnitEnum[TimeDurationUnitEnum.YEAR.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$TimeDurationUnitEnum[TimeDurationUnitEnum.MONTH.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$TimeDurationUnitEnum[TimeDurationUnitEnum.CALENDAR_DAY.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$TimeDurationUnitEnum[TimeDurationUnitEnum.BUSINESS_DAY.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$TimeDurationUnitEnum[TimeDurationUnitEnum.HOUR.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$TimeDurationUnitEnum[TimeDurationUnitEnum.MINUTE.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$TimeDurationUnitEnum[TimeDurationUnitEnum.SECOND.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$TimeDurationUnitEnum[TimeDurationUnitEnum.MILLISECOND.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.ebay.nautilus.domain.data.BaseCommonType.TimeDurationUnitEnum[unit.ordinal()];
            JVM INSTR tableswitch 1 8: default 68
        //                       1 109
        //                       2 115
        //                       3 121
        //                       4 121
        //                       5 127
        //                       6 136
        //                       7 145
        //                       8 154;
               goto _L1 _L2 _L3 _L4 _L4 _L5 _L6 _L7 _L8
_L1:
            stringbuilder.append('P');
            if (s1 != null)
            {
                stringbuilder.append(s1);
            }
            stringbuilder.append(value);
            if (s != null)
            {
                stringbuilder.append(s);
            }
            return stringbuilder.toString();
_L2:
            s = "Y";
            continue; /* Loop/switch isn't completed */
_L3:
            s = "M";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "D";
            continue; /* Loop/switch isn't completed */
_L5:
            s1 = "T";
            s = "H";
            continue; /* Loop/switch isn't completed */
_L6:
            s1 = "T";
            s = "M";
            continue; /* Loop/switch isn't completed */
_L7:
            s1 = "T";
            s = "S";
            continue; /* Loop/switch isn't completed */
_L8:
            s1 = "T";
            s = "S";
            value = value / 1000L;
            if (true) goto _L1; else goto _L9
_L9:
        }

        public String toString(Resources resources)
        {
            Object obj;
            long l;
            l = value;
            obj = null;
            _cls1..SwitchMap.com.ebay.nautilus.domain.data.BaseCommonType.TimeDurationUnitEnum[unit.ordinal()];
            JVM INSTR tableswitch 1 7: default 60
        //                       1 115
        //                       2 123
        //                       3 131
        //                       4 139
        //                       5 147
        //                       6 155
        //                       7 163;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            int i;
            i = com.ebay.nautilus.domain.R.plurals.time_duration_seconds;
            l /= 1000L;
_L10:
            String s = obj;
            if (resources != null)
            {
                s = obj;
                if (l <= 0x7fffffffL)
                {
                    s = resources.getQuantityString(i, (int)l, new Object[] {
                        Integer.valueOf((int)l)
                    });
                }
            }
            return s;
_L2:
            i = com.ebay.nautilus.domain.R.plurals.time_duration_years;
            continue; /* Loop/switch isn't completed */
_L3:
            i = com.ebay.nautilus.domain.R.plurals.time_duration_months;
            continue; /* Loop/switch isn't completed */
_L4:
            i = com.ebay.nautilus.domain.R.plurals.time_duration_calendar_days;
            continue; /* Loop/switch isn't completed */
_L5:
            i = com.ebay.nautilus.domain.R.plurals.time_duration_business_days;
            continue; /* Loop/switch isn't completed */
_L6:
            i = com.ebay.nautilus.domain.R.plurals.time_duration_hours;
            continue; /* Loop/switch isn't completed */
_L7:
            i = com.ebay.nautilus.domain.R.plurals.time_duration_minutes;
            continue; /* Loop/switch isn't completed */
_L8:
            i = com.ebay.nautilus.domain.R.plurals.time_duration_seconds;
            if (true) goto _L10; else goto _L9
_L9:
        }

        public TimeDuration()
        {
        }

        public TimeDuration(TimeDurationUnitEnum timedurationunitenum, long l)
        {
            value = l;
            unit = timedurationunitenum;
        }
    }

    public static final class TimeDurationUnitEnum extends Enum
    {

        private static final TimeDurationUnitEnum $VALUES[];
        public static final TimeDurationUnitEnum BUSINESS_DAY;
        public static final TimeDurationUnitEnum CALENDAR_DAY;
        public static final TimeDurationUnitEnum HOUR;
        public static final TimeDurationUnitEnum MILLISECOND;
        public static final TimeDurationUnitEnum MINUTE;
        public static final TimeDurationUnitEnum MONTH;
        public static final TimeDurationUnitEnum SECOND;
        public static final TimeDurationUnitEnum YEAR;

        public static TimeDurationUnitEnum valueOf(String s)
        {
            return (TimeDurationUnitEnum)Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$TimeDurationUnitEnum, s);
        }

        public static TimeDurationUnitEnum[] values()
        {
            return (TimeDurationUnitEnum[])$VALUES.clone();
        }

        static 
        {
            YEAR = new TimeDurationUnitEnum("YEAR", 0);
            MONTH = new TimeDurationUnitEnum("MONTH", 1);
            CALENDAR_DAY = new TimeDurationUnitEnum("CALENDAR_DAY", 2);
            BUSINESS_DAY = new TimeDurationUnitEnum("BUSINESS_DAY", 3);
            HOUR = new TimeDurationUnitEnum("HOUR", 4);
            MINUTE = new TimeDurationUnitEnum("MINUTE", 5);
            SECOND = new TimeDurationUnitEnum("SECOND", 6);
            MILLISECOND = new TimeDurationUnitEnum("MILLISECOND", 7);
            $VALUES = (new TimeDurationUnitEnum[] {
                YEAR, MONTH, CALENDAR_DAY, BUSINESS_DAY, HOUR, MINUTE, SECOND, MILLISECOND
            });
        }

        private TimeDurationUnitEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Weight
    {

        public WeightUnitOfMeasureEnum unit;
        public double value;

        public Weight()
        {
        }
    }

    public static final class WeightUnitOfMeasureEnum extends Enum
    {

        private static final WeightUnitOfMeasureEnum $VALUES[];
        public static final WeightUnitOfMeasureEnum KILOGRAM;
        public static final WeightUnitOfMeasureEnum POUND;

        public static WeightUnitOfMeasureEnum valueOf(String s)
        {
            return (WeightUnitOfMeasureEnum)Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$WeightUnitOfMeasureEnum, s);
        }

        public static WeightUnitOfMeasureEnum[] values()
        {
            return (WeightUnitOfMeasureEnum[])$VALUES.clone();
        }

        static 
        {
            POUND = new WeightUnitOfMeasureEnum("POUND", 0);
            KILOGRAM = new WeightUnitOfMeasureEnum("KILOGRAM", 1);
            $VALUES = (new WeightUnitOfMeasureEnum[] {
                POUND, KILOGRAM
            });
        }

        private WeightUnitOfMeasureEnum(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("type mapping", 6, "COS type mapping errors");

    public BaseCommonType()
    {
    }

}
