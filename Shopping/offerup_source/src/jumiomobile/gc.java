// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Parcel;
import com.jumio.netverify.sdk.NetverifyMrzData;

public final class gc
    implements android.os.Parcelable.Creator
{

    public gc()
    {
    }

    public final NetverifyMrzData a(Parcel parcel)
    {
        return new NetverifyMrzData(parcel);
    }

    public final NetverifyMrzData[] a(int i)
    {
        return new NetverifyMrzData[i];
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
