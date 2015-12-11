// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class alr
    implements android.os.Parcelable.Creator
{

    alr()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        if (parcel.readByte() == amf.a.d)
        {
            return new alq((cgc)parcel.readParcelable(cgc.getClassLoader()));
        } else
        {
            return null;
        }
    }

    public final Object[] newArray(int i)
    {
        return new alq[i];
    }
}
