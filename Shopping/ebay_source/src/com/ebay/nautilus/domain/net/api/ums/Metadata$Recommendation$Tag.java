// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ums;

import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ums:
//            Metadata

public static class Values
{
    public static class Properties
    {

        public ArrayList property;

        public Properties()
        {
        }
    }

    public static class Properties.Property
    {

        public PropertyName name;
        public String value;

        public Properties.Property()
        {
        }
    }

    public static final class Properties.Property.PropertyName extends Enum
    {

        private static final Properties.Property.PropertyName $VALUES[];
        public static final Properties.Property.PropertyName Closed;
        public static final Properties.Property.PropertyName DataType;
        public static final Properties.Property.PropertyName DisableAsVariant;
        public static final Properties.Property.PropertyName HelpText;
        public static final Properties.Property.PropertyName Multivalued;
        public static final Properties.Property.PropertyName Precision;
        public static final Properties.Property.PropertyName Required;

        public static Properties.Property.PropertyName valueOf(String s)
        {
            return (Properties.Property.PropertyName)Enum.valueOf(com/ebay/nautilus/domain/net/api/ums/Metadata$Recommendation$Tag$Properties$Property$PropertyName, s);
        }

        public static Properties.Property.PropertyName[] values()
        {
            return (Properties.Property.PropertyName[])$VALUES.clone();
        }

        static 
        {
            Required = new Properties.Property.PropertyName("Required", 0);
            Multivalued = new Properties.Property.PropertyName("Multivalued", 1);
            Closed = new Properties.Property.PropertyName("Closed", 2);
            DisableAsVariant = new Properties.Property.PropertyName("DisableAsVariant", 3);
            DataType = new Properties.Property.PropertyName("DataType", 4);
            Precision = new Properties.Property.PropertyName("Precision", 5);
            HelpText = new Properties.Property.PropertyName("HelpText", 6);
            $VALUES = (new Properties.Property.PropertyName[] {
                Required, Multivalued, Closed, DisableAsVariant, DataType, Precision, HelpText
            });
        }

        private Properties.Property.PropertyName(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Values
    {

        public ArrayList tagValue;

        public Values()
        {
        }
    }

    public static class Values.Value
    {

        public Relationships relationships;
        public String value;

        public Values.Value()
        {
        }
    }

    public static class Values.Value.Relationships
    {

        public ArrayList relationship;

        public Values.Value.Relationships()
        {
        }
    }

    public static class Values.Value.Relationships.Relationship
    {

        public String parentName;
        public String parentValue;

        public Values.Value.Relationships.Relationship()
        {
        }
    }


    public String name;
    public Properties properties;
    public Values values;

    public Values()
    {
    }
}
