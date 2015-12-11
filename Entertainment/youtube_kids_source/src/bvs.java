// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;

final class bvs
    implements android.os.Parcelable.Creator
{

    bvs()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        boolean flag = true;
        String s = parcel.readString();
        String s1 = parcel.readString();
        Uri uri = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        String s2 = parcel.readString();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        return new bvr(s, s1, uri, s2, flag, parcel.readFloat(), (Uri)parcel.readParcelable(android/net/Uri.getClassLoader()), parcel.readInt());
    }

    public final Object[] newArray(int i)
    {
        return new bvr[i];
    }
}
