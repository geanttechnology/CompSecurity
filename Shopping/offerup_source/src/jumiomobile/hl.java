// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Parcel;
import com.jumio.netverify.sdk.core.vo.Country;

public final class hl
    implements android.os.Parcelable.Creator
{

    public hl()
    {
    }

    public final Country a(Parcel parcel)
    {
        return new Country(parcel);
    }

    public final Country[] a(int i)
    {
        return new Country[i];
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
