// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            ChannelsContainer

static final class 
    implements android.os.nifiedStream.ChannelsContainer._cls1
{

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

    ()
    {
    }
}
