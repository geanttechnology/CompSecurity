// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

public class HiddenFollows extends BaseApiResponse
    implements Parcelable
{
    public static final class HiddenCollection
    {

        public String collectionId;

        public HiddenCollection()
        {
        }
    }

    public static final class HiddenInterest
    {

        public String interestId;

        public HiddenInterest()
        {
        }
    }

    public static final class HiddenUser
    {

        public String username;

        public HiddenUser()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public HiddenFollows createFromParcel(Parcel parcel)
        {
            return (HiddenFollows)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/HiddenFollows);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public HiddenFollows[] newArray(int i)
        {
            return new HiddenFollows[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public List hiddenCollections;
    public List hiddenInterests;
    public List hiddenUsers;

    public HiddenFollows()
    {
    }

}
