// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.cast.CastDevice;

final class alp
    implements android.os.Parcelable.Creator
{

    alp()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        if (parcel.readByte() == amf.c.d)
        {
            return new alo((CastDevice)parcel.readParcelable(com/google/android/gms/cast/CastDevice.getClassLoader()));
        } else
        {
            return null;
        }
    }

    public final Object[] newArray(int i)
    {
        return new alo[i];
    }
}
