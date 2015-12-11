// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ums;

import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ums:
//            Metadata

public static class Property
{
    public static class Property
    {

        public PropertyName name;
        public String value;

        public Property()
        {
        }
    }

    public static final class Property.PropertyName extends Enum
    {

        private static final Property.PropertyName $VALUES[];
        public static final Property.PropertyName Closed;
        public static final Property.PropertyName DataType;
        public static final Property.PropertyName DisableAsVariant;
        public static final Property.PropertyName HelpText;
        public static final Property.PropertyName Multivalued;
        public static final Property.PropertyName Precision;
        public static final Property.PropertyName Required;

        public static Property.PropertyName valueOf(String s)
        {
            return (Property.PropertyName)Enum.valueOf(com/ebay/nautilus/domain/net/api/ums/Metadata$Recommendation$Tag$Properties$Property$PropertyName, s);
        }

        public static Property.PropertyName[] values()
        {
            return (Property.PropertyName[])$VALUES.clone();
        }

        static 
        {
            Required = new Property.PropertyName("Required", 0);
            Multivalued = new Property.PropertyName("Multivalued", 1);
            Closed = new Property.PropertyName("Closed", 2);
            DisableAsVariant = new Property.PropertyName("DisableAsVariant", 3);
            DataType = new Property.PropertyName("DataType", 4);
            Precision = new Property.PropertyName("Precision", 5);
            HelpText = new Property.PropertyName("HelpText", 6);
            $VALUES = (new Property.PropertyName[] {
                Required, Multivalued, Closed, DisableAsVariant, DataType, Precision, HelpText
            });
        }

        private Property.PropertyName(String s, int i)
        {
            super(s, i);
        }
    }


    public ArrayList property;

    public Property()
    {
    }
}
