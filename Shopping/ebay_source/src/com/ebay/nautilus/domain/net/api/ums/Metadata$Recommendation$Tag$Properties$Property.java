// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ums;


// Referenced classes of package com.ebay.nautilus.domain.net.api.ums:
//            Metadata

public static class PropertyName
{
    public static final class PropertyName extends Enum
    {

        private static final PropertyName $VALUES[];
        public static final PropertyName Closed;
        public static final PropertyName DataType;
        public static final PropertyName DisableAsVariant;
        public static final PropertyName HelpText;
        public static final PropertyName Multivalued;
        public static final PropertyName Precision;
        public static final PropertyName Required;

        public static PropertyName valueOf(String s)
        {
            return (PropertyName)Enum.valueOf(com/ebay/nautilus/domain/net/api/ums/Metadata$Recommendation$Tag$Properties$Property$PropertyName, s);
        }

        public static PropertyName[] values()
        {
            return (PropertyName[])$VALUES.clone();
        }

        static 
        {
            Required = new PropertyName("Required", 0);
            Multivalued = new PropertyName("Multivalued", 1);
            Closed = new PropertyName("Closed", 2);
            DisableAsVariant = new PropertyName("DisableAsVariant", 3);
            DataType = new PropertyName("DataType", 4);
            Precision = new PropertyName("Precision", 5);
            HelpText = new PropertyName("HelpText", 6);
            $VALUES = (new PropertyName[] {
                Required, Multivalued, Closed, DisableAsVariant, DataType, Precision, HelpText
            });
        }

        private PropertyName(String s, int i)
        {
            super(s, i);
        }
    }


    public PropertyName name;
    public String value;

    public PropertyName()
    {
    }
}
