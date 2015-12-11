// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.groupon.models.search.domain:
//            SortMethod

public class SortMethodWrapper
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SortMethodWrapper createFromParcel(Parcel parcel)
        {
            return new SortMethodWrapper(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SortMethodWrapper[] newArray(int i)
        {
            return new SortMethodWrapper[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public boolean isSelected;
    public SortMethod sortMethod;

    protected SortMethodWrapper(Parcel parcel)
    {
        sortMethod = (SortMethod)parcel.readParcelable(com/groupon/models/search/domain/SortMethod.getClassLoader());
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSelected = flag;
    }

    public SortMethodWrapper(SortMethod sortmethod)
    {
        sortMethod = sortmethod;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(sortMethod, i);
        if (isSelected)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
