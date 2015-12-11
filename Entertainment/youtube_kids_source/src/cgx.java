// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;

final class cgx
    implements android.os.Parcelable.Creator
{

    cgx()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        cgy cgy1 = new cgy();
        cgy1.c = parcel.readString();
        cgy1.e = parcel.readString();
        cgy1.f = parcel.readString();
        cgy1.g = (cgt)parcel.readSerializable();
        cgy1.b = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        boolean flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cgy1.d = flag;
        cgy1.a = (cfy)parcel.readParcelable(cfy.getClassLoader());
        cgy1.h = parcel.readString();
        cgy1.i = Integer.valueOf(parcel.readInt());
        return cgy1.a();
    }

    public final Object[] newArray(int i)
    {
        return new cgw[i];
    }
}
