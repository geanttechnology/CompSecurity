// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;

final class bvw
    implements android.os.Parcelable.Creator
{

    bvw()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new bvv(parcel.readInt(), (Uri)parcel.readParcelable(android/net/Uri.getClassLoader()));
    }

    public final Object[] newArray(int i)
    {
        return new bvv[i];
    }
}
