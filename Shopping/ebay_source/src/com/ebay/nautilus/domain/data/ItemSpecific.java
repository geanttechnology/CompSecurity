// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemSpecific
    implements Parcelable
{
    public static class ItemSpecificValue
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ItemSpecificValue createFromParcel(Parcel parcel)
            {
                return new ItemSpecificValue(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public ItemSpecificValue[] newArray(int i)
            {
                return new ItemSpecificValue[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public boolean custom;
        public ArrayList dependencies;
        public String name;

        public int describeContents()
        {
            return 0;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder(name);
            if (dependencies.size() > 0)
            {
                stringbuilder.append("(");
                ValueDependency valuedependency;
                for (Iterator iterator = dependencies.iterator(); iterator.hasNext(); stringbuilder.append(valuedependency.name).append(":").append(valuedependency.value).append(" "))
                {
                    valuedependency = (ValueDependency)iterator.next();
                }

                stringbuilder.append(")");
            }
            return stringbuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(name);
            parcel.writeInt(dependencies.size());
            ValueDependency valuedependency;
            for (Iterator iterator = dependencies.iterator(); iterator.hasNext(); parcel.writeString(valuedependency.value))
            {
                valuedependency = (ValueDependency)iterator.next();
                parcel.writeString(valuedependency.name);
            }

        }


        public ItemSpecificValue()
        {
            dependencies = new ArrayList();
            custom = false;
        }

        private ItemSpecificValue(Parcel parcel)
        {
            dependencies = new ArrayList();
            custom = false;
            name = parcel.readString();
            int j = parcel.readInt();
            for (int i = 0; i < j; i++)
            {
                ValueDependency valuedependency = new ValueDependency();
                valuedependency.name = parcel.readString();
                valuedependency.value = parcel.readString();
                dependencies.add(valuedependency);
            }

        }


        public ItemSpecificValue(String s, String s1)
        {
            dependencies = new ArrayList();
            custom = false;
            name = s;
            ValueDependency valuedependency = new ValueDependency();
            valuedependency.name = s;
            valuedependency.value = s1;
            dependencies.add(valuedependency);
        }
    }

    public static class ValueDependency
    {

        public String name;
        public String value;

        public ValueDependency()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ItemSpecific createFromParcel(Parcel parcel)
        {
            return new ItemSpecific(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ItemSpecific[] newArray(int i)
        {
            return new ItemSpecific[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String MODE_FREE_TEXT = "FreeText";
    public static final String MODE_PREFILLED = "Prefilled";
    public static final String MODE_SELECTION_ONLY = "SelectionOnly";
    public ArrayList dependencies;
    public int maxValues;
    public int minValues;
    public String name;
    public String selectionMode;
    public ArrayList values;

    public ItemSpecific()
    {
        dependencies = new ArrayList();
        values = new ArrayList();
    }

    private ItemSpecific(Parcel parcel)
    {
        dependencies = new ArrayList();
        values = new ArrayList();
        name = parcel.readString();
        minValues = parcel.readInt();
        maxValues = parcel.readInt();
        selectionMode = parcel.readString();
        dependencies = new ArrayList();
        parcel.readStringList(dependencies);
        parcel.readList(values, com/ebay/nautilus/domain/data/ItemSpecific$ItemSpecificValue.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public boolean isEqual(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof ItemSpecific)
        {
            obj = (ItemSpecific)obj;
            flag = flag1;
            if (name.equals(((ItemSpecific) (obj)).name))
            {
                flag = flag1;
                if (dependencies.equals(((ItemSpecific) (obj)).dependencies))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean isRequired()
    {
        return minValues > 0;
    }

    public void setValueList(String s, ArrayList arraylist)
    {
        String s1;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); values.add(new ItemSpecificValue(s, s1)))
        {
            s1 = (String)arraylist.next();
        }

    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(selectionMode).append(", ");
        stringbuilder.append(name);
        if (dependencies.size() > 0)
        {
            stringbuilder.append("(");
            for (Iterator iterator = dependencies.iterator(); iterator.hasNext(); stringbuilder.append((String)iterator.next()).append(" ")) { }
            stringbuilder.append(")");
        }
        stringbuilder.append(":");
        for (Iterator iterator1 = values.iterator(); iterator1.hasNext(); stringbuilder.append((ItemSpecificValue)iterator1.next()).append(" ")) { }
        return stringbuilder.toString();
    }

    public ArrayList valueList()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = values.iterator(); iterator.hasNext(); arraylist.add(((ItemSpecificValue)iterator.next()).name)) { }
        return arraylist;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeInt(minValues);
        parcel.writeInt(maxValues);
        parcel.writeString(selectionMode);
        parcel.writeStringList(dependencies);
        parcel.writeList(values);
    }

}
