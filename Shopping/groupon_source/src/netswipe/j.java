// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.os.Parcel;
import com.jumio.netswipe.sdk.core.NetswipeCardInformation;

public final class j
    implements android.os.Parcelable.Creator
{

    public j()
    {
    }

    public NetswipeCardInformation a(Parcel parcel)
    {
        return new NetswipeCardInformation(parcel);
    }

    public NetswipeCardInformation[] a(int i)
    {
        return new NetswipeCardInformation[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
