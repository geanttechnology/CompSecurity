// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class alt
    implements android.os.Parcelable.Creator
{

    alt()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        if (parcel.readByte() == amf.b.d)
        {
            return new als((cgw)parcel.readParcelable(cgw.getClassLoader()));
        } else
        {
            return null;
        }
    }

    public final Object[] newArray(int i)
    {
        return new als[i];
    }
}
