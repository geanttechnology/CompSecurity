// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.data;

import android.os.Parcel;
import android.util.Log;
import com.groupon.models.search.domain.FacetFilter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.models.search.data:
//            Facet

public class UnsupportedFacet extends Facet
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UnsupportedFacet createFromParcel(Parcel parcel)
        {
            return new UnsupportedFacet(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UnsupportedFacet[] newArray(int i)
        {
            return new UnsupportedFacet[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final String TAG = "UNSUPPORTED_FACET";
    public static final int unsupportedType = -1;

    public UnsupportedFacet()
    {
        Log.e("UNSUPPORTED_FACET", "Unsupported facet type in search response!");
    }

    public UnsupportedFacet(Parcel parcel)
    {
        super(parcel);
    }

    public UnsupportedFacet(String s)
    {
        super(s);
    }

    public FacetFilter createEmptyFacetFilter(String s)
    {
        throw new UnsupportedOperationException("Do not use createEmptyFacetFilter() for UnsupportedFacet");
    }

    public int getFilterSheetListItemType()
    {
        return -1;
    }

    public List getValues()
    {
        return new ArrayList();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
    }

}
