// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.mobile.android.spotlets.album.model;

import android.os.Parcel;

// Referenced classes of package com.spotify.mobile.android.spotlets.album.model:
//            AlbumDisc

final class A
    implements android.os.reator
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new AlbumDisc(parcel, null);
    }

    public final volatile Object[] newArray(int i)
    {
        return new AlbumDisc[i];
    }

    A()
    {
    }
}
