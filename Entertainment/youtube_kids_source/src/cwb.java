// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public final class cwb
    implements cwh
{

    public static final android.os.Parcelable.Creator CREATOR = new cwc();
    public final byte a[];

    public cwb(Parcel parcel)
    {
        a = new byte[parcel.readInt()];
        parcel.readByteArray(a);
    }

    public cwb(byte abyte0[])
    {
        if (abyte0 == null)
        {
            abyte0 = new byte[0];
        }
        a = abyte0;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a.length);
        parcel.writeByteArray(a);
    }

}
