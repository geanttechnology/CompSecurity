// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Parcel;
import com.jumio.commons.camera.ImageData;

public final class t
    implements android.os.Parcelable.Creator
{

    public t()
    {
    }

    public final ImageData a(Parcel parcel)
    {
        return new ImageData(parcel, null);
    }

    public final ImageData[] a(int i)
    {
        return new ImageData[i];
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return a(i);
    }
}
