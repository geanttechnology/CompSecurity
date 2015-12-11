// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ItemSpecific

public static class dependencies
    implements Parcelable
{

    public static final android.os..ValueDependency.name CREATOR = new android.os.Parcelable.Creator() {

        public ItemSpecific.ItemSpecificValue createFromParcel(Parcel parcel)
        {
            return new ItemSpecific.ItemSpecificValue(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ItemSpecific.ItemSpecificValue[] newArray(int i)
        {
            return new ItemSpecific.ItemSpecificValue[i];
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
            dependencies dependencies1;
            for (Iterator iterator = dependencies.iterator(); iterator.hasNext(); stringbuilder.append(dependencies1.me).append(":").append(dependencies1.lue).append(" "))
            {
                dependencies1 = (lue)iterator.next();
            }

            stringbuilder.append(")");
        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeInt(dependencies.size());
        lue lue;
        for (Iterator iterator = dependencies.iterator(); iterator.hasNext(); parcel.writeString(lue.lue))
        {
            lue = (lue)iterator.next();
            parcel.writeString(lue.me);
        }

    }


    public _cls1()
    {
        dependencies = new ArrayList();
        custom = false;
    }

    private custom(Parcel parcel)
    {
        dependencies = new ArrayList();
        custom = false;
        name = parcel.readString();
        int j = parcel.readInt();
        for (int i = 0; i < j; i++)
        {
            custom custom1 = new nit>();
            custom1.me = parcel.readString();
            custom1.lue = parcel.readString();
            dependencies.add(custom1);
        }

    }

    dependencies(Parcel parcel, dependencies dependencies1)
    {
        this(parcel);
    }

    public <init>(String s, String s1)
    {
        dependencies = new ArrayList();
        custom = false;
        name = s;
        <init> <init>1 = new nit>();
        <init>1.me = s;
        <init>1.lue = s1;
        dependencies.add(<init>1);
    }
}
