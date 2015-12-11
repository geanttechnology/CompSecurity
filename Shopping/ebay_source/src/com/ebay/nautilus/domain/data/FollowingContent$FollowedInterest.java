// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            FollowingContent

public static final class imageUrl extends imageUrl
    implements Parcelable
{

    public static final android.os.erFactory.writeParcelJson CREATOR = new android.os.Parcelable.Creator() {

        public FollowingContent.FollowedInterest createFromParcel(Parcel parcel)
        {
            return (FollowingContent.FollowedInterest)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/FollowingContent$FollowedInterest);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public FollowingContent.FollowedInterest[] newArray(int i)
        {
            return new FollowingContent.FollowedInterest[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String customTitle;
    public final String imageUrl;
    public final String interestId;
    public final st searchRequest;
    public final String title;

    public int describeContents()
    {
        return 0;
    }

    public String getDisplayTitle()
    {
        if (customTitle != null)
        {
            return customTitle;
        } else
        {
            return title;
        }
    }

    public String toString()
    {
        return title;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        DataMapperFactory.writeParcelJson(parcel, this);
    }


    public _cls1(_cls1 _pcls1, boolean flag)
    {
        super(flag);
        interestId = _pcls1.interestId;
        title = _pcls1.title;
        customTitle = _pcls1.;
        searchRequest = _pcls1.st;
        imageUrl = _pcls1.imageUrl.l;
    }

    public l(l l)
    {
        super(l.hiddenFeedEvents);
        interestId = l.interestId;
        title = l.title;
        customTitle = l.customTitle;
        searchRequest = l.searchRequest;
        imageUrl = l.imageUrl;
    }
}
