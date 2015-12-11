// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class bxc
    implements android.os.Parcelable.Creator
{

    bxc()
    {
    }

    private static bxb a(Parcel parcel)
    {
        try
        {
            duc duc1 = (duc)a.b(parcel, new duc());
            long l = parcel.readLong();
            byte abyte0[] = new byte[parcel.readInt()];
            parcel.readByteArray(abyte0);
            parcel = new bxb(duc1, l, abyte0, (bww)parcel.readParcelable(bww.getClassLoader()));
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            return null;
        }
        return parcel;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new bxb[i];
    }
}
