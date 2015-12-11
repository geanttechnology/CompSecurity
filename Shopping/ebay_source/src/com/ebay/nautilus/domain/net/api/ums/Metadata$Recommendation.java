// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ums;

import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ums:
//            Metadata

public static class Tag
{
    public static class Tag
    {

        public String name;
        public Properties properties;
        public Values values;

        public Tag()
        {
        }
    }

    public static class Tag.Properties
    {

        public ArrayList property;

        public Tag.Properties()
        {
        }
    }

    public static class Tag.Properties.Property
    {

        public PropertyName name;
        public String value;

        public Tag.Properties.Property()
        {
        }
    }

    public static final class Tag.Properties.Property.PropertyName extends Enum
    {

        private static final Tag.Properties.Property.PropertyName $VALUES[];
        public static final Tag.Properties.Property.PropertyName Closed;
        public static final Tag.Properties.Property.PropertyName DataType;
        public static final Tag.Properties.Property.PropertyName DisableAsVariant;
        public static final Tag.Properties.Property.PropertyName HelpText;
        public static final Tag.Properties.Property.PropertyName Multivalued;
        public static final Tag.Properties.Property.PropertyName Precision;
        public static final Tag.Properties.Property.PropertyName Required;

        public static Tag.Properties.Property.PropertyName valueOf(String s)
        {
            return (Tag.Properties.Property.PropertyName)Enum.valueOf(com/ebay/nautilus/domain/net/api/ums/Metadata$Recommendation$Tag$Properties$Property$PropertyName, s);
        }

        public static Tag.Properties.Property.PropertyName[] values()
        {
            return (Tag.Properties.Property.PropertyName[])$VALUES.clone();
        }

        static 
        {
            Required = new Tag.Properties.Property.PropertyName("Required", 0);
            Multivalued = new Tag.Properties.Property.PropertyName("Multivalued", 1);
            Closed = new Tag.Properties.Property.PropertyName("Closed", 2);
            DisableAsVariant = new Tag.Properties.Property.PropertyName("DisableAsVariant", 3);
            DataType = new Tag.Properties.Property.PropertyName("DataType", 4);
            Precision = new Tag.Properties.Property.PropertyName("Precision", 5);
            HelpText = new Tag.Properties.Property.PropertyName("HelpText", 6);
            $VALUES = (new Tag.Properties.Property.PropertyName[] {
                Required, Multivalued, Closed, DisableAsVariant, DataType, Precision, HelpText
            });
        }

        private Tag.Properties.Property.PropertyName(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Tag.Values
    {

        public ArrayList tagValue;

        public Tag.Values()
        {
        }
    }

    public static class Tag.Values.Value
    {

        public Relationships relationships;
        public String value;

        public Tag.Values.Value()
        {
        }
    }

    public static class Tag.Values.Value.Relationships
    {

        public ArrayList relationship;

        public Tag.Values.Value.Relationships()
        {
        }
    }

    public static class Tag.Values.Value.Relationships.Relationship
    {

        public String parentName;
        public String parentValue;

        public Tag.Values.Value.Relationships.Relationship()
        {
        }
    }


    public ArrayList tag;

    public Tag()
    {
    }
}
