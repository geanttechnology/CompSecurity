// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            FollowProfile, Rating, OfferUpBoolean

final class 
    implements android.os.or
{

    public final FollowProfile createFromParcel(Parcel parcel)
    {
        FollowProfile followprofile = new FollowProfile();
        FollowProfile.access$002(followprofile, parcel.readString());
        FollowProfile.access$102(followprofile, parcel.readString());
        FollowProfile.access$202(followprofile, parcel.readString());
        FollowProfile.access$302(followprofile, (Rating)parcel.readParcelable(com/offerup/android/dto/Rating.getClassLoader()));
        FollowProfile.access$402(followprofile, parcel.readInt());
        FollowProfile.access$502(followprofile, (new OfferUpBoolean(parcel.readInt())).value);
        return followprofile;
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final FollowProfile[] newArray(int i)
    {
        return new FollowProfile[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
