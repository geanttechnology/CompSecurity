// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.search.data.FacetValue;
import java.util.ArrayList;
import java.util.List;

public class FacetFilter
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FacetFilter createFromParcel(Parcel parcel)
        {
            return new FacetFilter(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public FacetFilter[] newArray(int i)
        {
            return new FacetFilter[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String facetId;
    protected List selectedFacetValueList;

    public FacetFilter(Parcel parcel)
    {
        selectedFacetValueList = new ArrayList();
        facetId = parcel.readString();
        parcel.readList(selectedFacetValueList, com/groupon/models/search/data/FacetValue.getClassLoader());
    }

    public FacetFilter(String s)
    {
        selectedFacetValueList = new ArrayList();
        facetId = s;
    }

    public void addSelectedFacetValue(FacetValue facetvalue)
    {
        selectedFacetValueList.add(facetvalue);
    }

    public String asUrlParam()
    {
        return facetId;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getSelectedFacetValues()
    {
        return selectedFacetValueList;
    }

    public void removeSelectedFacetValue(FacetValue facetvalue)
    {
        selectedFacetValueList.remove(facetvalue);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(facetId);
        parcel.writeList(selectedFacetValueList);
    }

}
