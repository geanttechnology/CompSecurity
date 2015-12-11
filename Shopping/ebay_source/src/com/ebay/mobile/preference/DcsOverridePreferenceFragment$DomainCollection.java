// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsOverridePreferenceFragment

public static final class domains
    implements Parcelable
{

    public static final android.os.omainCollection.domains CREATOR = new android.os.Parcelable.Creator() {

        public DcsOverridePreferenceFragment.DomainCollection createFromParcel(Parcel parcel)
        {
            int j = parcel.readInt();
            ArrayList arraylist = new ArrayList(j);
            int i = 0;
            do
            {
                if (i >= j)
                {
                    break;
                }
                Class class1 = (Class)parcel.readSerializable();
                try
                {
                    arraylist.add(class1.newInstance());
                }
                // Misplaced declaration of an exception variable
                catch (Parcel parcel)
                {
                    parcel.printStackTrace();
                    throw new RuntimeException(parcel);
                }
                i++;
            } while (true);
            return new DcsOverridePreferenceFragment.DomainCollection(arraylist);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public DcsOverridePreferenceFragment.DomainCollection[] newArray(int i)
        {
            return new DcsOverridePreferenceFragment.DomainCollection[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final Collection domains;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(domains.size());
        for (Iterator iterator = domains.iterator(); iterator.hasNext(); parcel.writeSerializable(((com.ebay.nautilus.domain.dcs.mains)iterator.next()).getClass())) { }
    }


    public _cls1(Collection collection)
    {
        domains = collection;
    }
}
