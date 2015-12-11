// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class bfn
    implements android.os.Parcelable.Creator
{

    bfn()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        bfz bfz1 = (bfz)parcel.readParcelable(bfz.getClassLoader());
        parcel = (buz)parcel.readParcelable(buz.getClassLoader());
        if (bfz1 == null && parcel == null)
        {
            return null;
        } else
        {
            return new bfm(bfz1, parcel);
        }
    }

    public final Object[] newArray(int i)
    {
        return new bfm[i];
    }
}
