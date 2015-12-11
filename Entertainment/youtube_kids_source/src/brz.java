// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class brz
    implements android.os.Parcelable.Creator
{

    brz()
    {
    }

    private static bry a(Parcel parcel)
    {
        byte abyte0[] = new byte[parcel.readInt()];
        parcel.readByteArray(abyte0);
        try
        {
            parcel = new bry((dmu)eun.a(new dmu(), abyte0));
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
        return new bry[i];
    }
}
