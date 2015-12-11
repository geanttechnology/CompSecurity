// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ums;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.ItemSpecific;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.ArrayList;
import java.util.Iterator;

public class Metadata extends BaseApiResponse
    implements Parcelable
{
    public static class Recommendation
    {

        public ArrayList tag;

        public Recommendation()
        {
        }
    }

    public static class Recommendation.Tag
    {

        public String name;
        public Properties properties;
        public Values values;

        public Recommendation.Tag()
        {
        }
    }

    public static class Recommendation.Tag.Properties
    {

        public ArrayList property;

        public Recommendation.Tag.Properties()
        {
        }
    }

    public static class Recommendation.Tag.Properties.Property
    {

        public PropertyName name;
        public String value;

        public Recommendation.Tag.Properties.Property()
        {
        }
    }

    public static final class Recommendation.Tag.Properties.Property.PropertyName extends Enum
    {

        private static final Recommendation.Tag.Properties.Property.PropertyName $VALUES[];
        public static final Recommendation.Tag.Properties.Property.PropertyName Closed;
        public static final Recommendation.Tag.Properties.Property.PropertyName DataType;
        public static final Recommendation.Tag.Properties.Property.PropertyName DisableAsVariant;
        public static final Recommendation.Tag.Properties.Property.PropertyName HelpText;
        public static final Recommendation.Tag.Properties.Property.PropertyName Multivalued;
        public static final Recommendation.Tag.Properties.Property.PropertyName Precision;
        public static final Recommendation.Tag.Properties.Property.PropertyName Required;

        public static Recommendation.Tag.Properties.Property.PropertyName valueOf(String s)
        {
            return (Recommendation.Tag.Properties.Property.PropertyName)Enum.valueOf(com/ebay/nautilus/domain/net/api/ums/Metadata$Recommendation$Tag$Properties$Property$PropertyName, s);
        }

        public static Recommendation.Tag.Properties.Property.PropertyName[] values()
        {
            return (Recommendation.Tag.Properties.Property.PropertyName[])$VALUES.clone();
        }

        static 
        {
            Required = new Recommendation.Tag.Properties.Property.PropertyName("Required", 0);
            Multivalued = new Recommendation.Tag.Properties.Property.PropertyName("Multivalued", 1);
            Closed = new Recommendation.Tag.Properties.Property.PropertyName("Closed", 2);
            DisableAsVariant = new Recommendation.Tag.Properties.Property.PropertyName("DisableAsVariant", 3);
            DataType = new Recommendation.Tag.Properties.Property.PropertyName("DataType", 4);
            Precision = new Recommendation.Tag.Properties.Property.PropertyName("Precision", 5);
            HelpText = new Recommendation.Tag.Properties.Property.PropertyName("HelpText", 6);
            $VALUES = (new Recommendation.Tag.Properties.Property.PropertyName[] {
                Required, Multivalued, Closed, DisableAsVariant, DataType, Precision, HelpText
            });
        }

        private Recommendation.Tag.Properties.Property.PropertyName(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Recommendation.Tag.Values
    {

        public ArrayList tagValue;

        public Recommendation.Tag.Values()
        {
        }
    }

    public static class Recommendation.Tag.Values.Value
    {

        public Relationships relationships;
        public String value;

        public Recommendation.Tag.Values.Value()
        {
        }
    }

    public static class Recommendation.Tag.Values.Value.Relationships
    {

        public ArrayList relationship;

        public Recommendation.Tag.Values.Value.Relationships()
        {
        }
    }

    public static class Recommendation.Tag.Values.Value.Relationships.Relationship
    {

        public String parentName;
        public String parentValue;

        public Recommendation.Tag.Values.Value.Relationships.Relationship()
        {
        }
    }

    public static class Recommendations
    {

        public ArrayList recommendation;

        public Recommendations()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Metadata createFromParcel(Parcel parcel)
        {
            return (Metadata)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/net/api/ums/Metadata);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Metadata[] newArray(int i)
        {
            return new Metadata[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Recommendations recommendations;

    public Metadata()
    {
    }

    public static ArrayList convertMetadataToSpecifics(Metadata metadata)
    {
        ArrayList arraylist = new ArrayList();
        if (metadata != null && metadata.recommendations != null && metadata.recommendations.recommendation != null)
        {
            metadata = metadata.recommendations.recommendation.iterator();
            while (metadata.hasNext()) 
            {
                Object obj = (Recommendation)metadata.next();
                if (((Recommendation) (obj)).tag != null)
                {
                    obj = ((Recommendation) (obj)).tag.iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        Object obj1 = (Recommendation.Tag)((Iterator) (obj)).next();
                        ItemSpecific itemspecific = new ItemSpecific();
                        arraylist.add(itemspecific);
                        itemspecific.name = ((Recommendation.Tag) (obj1)).name;
                        itemspecific.minValues = 0;
                        itemspecific.maxValues = 1;
                        itemspecific.selectionMode = "FreeText";
                        if (((Recommendation.Tag) (obj1)).properties != null)
                        {
                            Iterator iterator = ((Recommendation.Tag) (obj1)).properties.property.iterator();
                            do
                            {
                                if (!iterator.hasNext())
                                {
                                    break;
                                }
                                Recommendation.Tag.Properties.Property property = (Recommendation.Tag.Properties.Property)iterator.next();
                                if (Recommendation.Tag.Properties.Property.PropertyName.Required.equals(property.name))
                                {
                                    itemspecific.minValues = 1;
                                } else
                                if (Recommendation.Tag.Properties.Property.PropertyName.Multivalued.equals(property.name))
                                {
                                    itemspecific.maxValues = 2;
                                } else
                                if (Recommendation.Tag.Properties.Property.PropertyName.Closed.equals(property.name))
                                {
                                    itemspecific.selectionMode = "SelectionOnly";
                                }
                            } while (true);
                        }
                        if (((Recommendation.Tag) (obj1)).values != null)
                        {
                            obj1 = ((Recommendation.Tag) (obj1)).values.tagValue.iterator();
                            while (((Iterator) (obj1)).hasNext()) 
                            {
                                Object obj2 = (Recommendation.Tag.Values.Value)((Iterator) (obj1)).next();
                                com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue itemspecificvalue = new com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue();
                                itemspecific.values.add(itemspecificvalue);
                                itemspecificvalue.name = ((Recommendation.Tag.Values.Value) (obj2)).value;
                                if (((Recommendation.Tag.Values.Value) (obj2)).relationships != null)
                                {
                                    obj2 = ((Recommendation.Tag.Values.Value) (obj2)).relationships.relationship.iterator();
                                    while (((Iterator) (obj2)).hasNext()) 
                                    {
                                        Recommendation.Tag.Values.Value.Relationships.Relationship relationship = (Recommendation.Tag.Values.Value.Relationships.Relationship)((Iterator) (obj2)).next();
                                        com.ebay.nautilus.domain.data.ItemSpecific.ValueDependency valuedependency = new com.ebay.nautilus.domain.data.ItemSpecific.ValueDependency();
                                        valuedependency.name = relationship.parentName;
                                        valuedependency.value = relationship.parentValue;
                                        itemspecificvalue.dependencies.add(valuedependency);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return arraylist;
    }

}
