// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Collections;
import java.util.Map;

public final class Merchandise extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Merchandise createFromParcel(Parcel parcel)
        {
            return (Merchandise)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/Merchandise);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Merchandise[] newArray(int i)
        {
            return new Merchandise[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final Map itemsByPlacement;

    public Merchandise()
    {
        this(null);
    }

    public Merchandise(Map map)
    {
        if (map == null)
        {
            map = Collections.emptyMap();
        } else
        {
            map = Collections.unmodifiableMap(map);
        }
        itemsByPlacement = map;
    }

}
