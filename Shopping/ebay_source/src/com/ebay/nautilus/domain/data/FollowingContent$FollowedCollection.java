// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            FollowingContent

public static final class imageUrls extends imageUrls
    implements Parcelable
{

    public static final android.os.Factory.writeParcelJson CREATOR = new android.os.Parcelable.Creator() {

        public FollowingContent.FollowedCollection createFromParcel(Parcel parcel)
        {
            return (FollowingContent.FollowedCollection)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/FollowingContent$FollowedCollection);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public FollowingContent.FollowedCollection[] newArray(int i)
        {
            return new FollowingContent.FollowedCollection[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String collectionId;
    public final List imageUrls;
    public final String name;
    public final _cls1.newArray owner;
    public final int size;
    public final String url;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        DataMapperFactory.writeParcelJson(parcel, this);
    }


    public _cls1(_cls1 _pcls1, _cls1 _pcls1_1, boolean flag)
    {
        super(flag);
        collectionId = _pcls1.d;
        owner = _pcls1_1;
        name = _pcls1.name;
        url = _pcls1.url;
        size = _pcls1.size;
        imageUrls = _pcls1.imageUrls;
    }

    public imageUrls(imageUrls imageurls)
    {
        super(imageurls.hiddenFeedEvents);
        collectionId = imageurls.collectionId;
        owner = new owner(imageurls.owner);
        name = imageurls.name;
        url = imageurls.url;
        size = imageurls.size;
        imageUrls = imageurls.imageUrls;
    }
}
