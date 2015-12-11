// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Parcel;
import com.jumio.netswipe.sdk.NetswipeCardInformation;

public final class cx
    implements android.os.Parcelable.Creator
{

    public cx()
    {
    }

    public final NetswipeCardInformation a(Parcel parcel)
    {
        return new NetswipeCardInformation(parcel);
    }

    public final NetswipeCardInformation[] a(int i)
    {
        return new NetswipeCardInformation[i];
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
