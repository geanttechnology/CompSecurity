// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

public class FacetValue
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FacetValue createFromParcel(Parcel parcel)
        {
            return new FacetValue(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public FacetValue[] newArray(int i)
        {
            return new FacetValue[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public List children;
    public int count;
    public int derivedDepth;
    public String derivedParentFacetId;
    public String friendlyName;
    public String friendlyNameShort;
    public String id;
    public boolean isDerivedLeaf;
    public boolean isSelected;

    public FacetValue()
    {
        children = new ArrayList();
    }

    public FacetValue(Parcel parcel)
    {
        boolean flag = true;
        super();
        children = new ArrayList();
        id = parcel.readString();
        derivedParentFacetId = parcel.readString();
        count = parcel.readInt();
        friendlyName = parcel.readString();
        friendlyNameShort = parcel.readString();
        parcel.readList(children, com/groupon/models/search/data/FacetValue.getClassLoader());
        derivedDepth = parcel.readInt();
        if (parcel.readByte() != 1)
        {
            flag = false;
        }
        isSelected = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof FacetValue))
        {
            if (hashCode() == ((FacetValue) (obj = (FacetValue)obj)).hashCode())
            {
                return true;
            }
        }
        return false;
    }

    public boolean hasSelectedChildren()
    {
        for (Iterator iterator = children.iterator(); iterator.hasNext();)
        {
            if (((FacetValue)iterator.next()).isSelected)
            {
                return true;
            }
        }

        return false;
    }

    public int hashCode()
    {
        if (Strings.isEmpty(id))
        {
            return 0;
        }
        if (Strings.isEmpty(derivedParentFacetId))
        {
            return id.hashCode();
        } else
        {
            return (new StringBuilder()).append(id).append(derivedParentFacetId).toString().hashCode();
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(derivedParentFacetId);
        parcel.writeInt(count);
        parcel.writeString(friendlyName);
        parcel.writeString(friendlyNameShort);
        parcel.writeList(children);
        parcel.writeInt(derivedDepth);
        if (isSelected)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}
