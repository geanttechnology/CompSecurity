// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.query;

import android.os.Parcel;
import android.os.Parcelable;

public final class QuerySource extends Enum
    implements Parcelable
{

    private static final QuerySource $VALUES[];
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public QuerySource createFromParcel(Parcel parcel)
        {
            return QuerySource.sources[parcel.readInt()];
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public QuerySource[] newArray(int i)
        {
            return new QuerySource[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final QuerySource EXTERNAL_APP;
    public static final QuerySource GENERIC_INPUT_BOX;
    public static final QuerySource LINK;
    public static final QuerySource NAV_BAR_INPUT;
    public static final QuerySource UNIVERSAL_SEARCH;
    private static final QuerySource sources[] = values();

    private QuerySource(String s, int i)
    {
        super(s, i);
    }

    public static QuerySource valueOf(String s)
    {
        return (QuerySource)Enum.valueOf(com/amazon/retailsearch/android/api/query/QuerySource, s);
    }

    public static QuerySource[] values()
    {
        return (QuerySource[])$VALUES.clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(ordinal());
    }

    static 
    {
        GENERIC_INPUT_BOX = new QuerySource("GENERIC_INPUT_BOX", 0);
        NAV_BAR_INPUT = new QuerySource("NAV_BAR_INPUT", 1);
        LINK = new QuerySource("LINK", 2);
        UNIVERSAL_SEARCH = new QuerySource("UNIVERSAL_SEARCH", 3);
        EXTERNAL_APP = new QuerySource("EXTERNAL_APP", 4);
        $VALUES = (new QuerySource[] {
            GENERIC_INPUT_BOX, NAV_BAR_INPUT, LINK, UNIVERSAL_SEARCH, EXTERNAL_APP
        });
    }

}
