// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;

// Referenced classes of package com.smule.android.network.models:
//            PartnerArtistV2

final class 
    implements android.os.
{

    public PartnerArtistV2 a(Parcel parcel)
    {
        return new PartnerArtistV2(parcel);
    }

    public PartnerArtistV2[] a(int i)
    {
        return new PartnerArtistV2[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
