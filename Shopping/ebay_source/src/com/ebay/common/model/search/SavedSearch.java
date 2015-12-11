// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.nautilus.domain.EbayCountry;

public class SavedSearch
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SavedSearch createFromParcel(Parcel parcel)
        {
            return new SavedSearch(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SavedSearch[] newArray(int i)
        {
            return new SavedSearch[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final long serialVersionUID = 1L;
    public String id;
    public String keywords;
    public String name;
    public boolean newItemsOnly;
    public String query;
    private boolean queryParsed;
    public SearchParameters searchParameters;
    public long since;

    public SavedSearch(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        queryParsed = false;
        newItemsOnly = false;
        id = parcel.readString();
        name = parcel.readString();
        keywords = parcel.readString();
        query = parcel.readString();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        queryParsed = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        newItemsOnly = flag;
        since = parcel.readLong();
        searchParameters = (SearchParameters)parcel.readParcelable(com/ebay/common/model/search/SavedSearch.getClassLoader());
    }

    public SavedSearch(EbayCountry ebaycountry, int i)
    {
        queryParsed = false;
        newItemsOnly = false;
        searchParameters = new SearchParameters(ebaycountry, i, 2);
    }

    public SavedSearch(String s, SearchParameters searchparameters)
    {
        queryParsed = false;
        newItemsOnly = false;
        searchParameters = searchparameters;
        name = s;
        keywords = searchparameters.keywords;
        queryParsed = true;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean isQueryParsed()
    {
        return queryParsed;
    }

    public void setQueryParsed(boolean flag)
    {
        queryParsed = flag;
    }

    public String toString()
    {
        return name;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(keywords);
        parcel.writeString(query);
        int j;
        if (queryParsed)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (newItemsOnly)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeLong(since);
        parcel.writeParcelable(searchParameters, i);
    }

}
