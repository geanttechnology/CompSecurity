// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Channel

public final class ChannelsContainer extends BaseApiResponse
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ChannelsContainer createFromParcel(Parcel parcel)
        {
            return (ChannelsContainer)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/UnifiedStream/ChannelsContainer);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ChannelsContainer[] newArray(int i)
        {
            return new ChannelsContainer[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public List channels;
    public Channel landingChannel;

    public ChannelsContainer()
    {
    }

}
