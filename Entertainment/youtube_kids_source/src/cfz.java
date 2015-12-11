// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;

final class cfz
    implements android.os.Parcelable.Creator
{

    cfz()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        boolean flag1 = true;
        cga cga1 = new cga();
        cga1.d = parcel.readInt();
        cga1.a = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        cga1.b = parcel.readString();
        cga1.c = (cgr)parcel.readSerializable();
        boolean flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cga1.e = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cga1.f = flag;
        if (parcel.readByte() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        cga1.g = flag;
        return cga1.a();
    }

    public final Object[] newArray(int i)
    {
        return new cfy[i];
    }
}
